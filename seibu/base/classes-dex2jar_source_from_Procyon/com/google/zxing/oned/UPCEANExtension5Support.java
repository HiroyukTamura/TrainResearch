// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.Result;
import java.util.EnumMap;
import com.google.zxing.ResultMetadataType;
import java.util.Map;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class UPCEANExtension5Support
{
    private static final int[] CHECK_DIGIT_ENCODINGS;
    private final int[] decodeMiddleCounters;
    private final StringBuilder decodeRowStringBuffer;
    
    static {
        CHECK_DIGIT_ENCODINGS = new int[] { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
    }
    
    UPCEANExtension5Support() {
        this.decodeMiddleCounters = new int[4];
        this.decodeRowStringBuffer = new StringBuilder();
    }
    
    private int decodeMiddle(final BitArray bitArray, final int[] array, final StringBuilder sb) throws NotFoundException {
        final int[] decodeMiddleCounters = this.decodeMiddleCounters;
        decodeMiddleCounters[1] = (decodeMiddleCounters[0] = 0);
        decodeMiddleCounters[3] = (decodeMiddleCounters[2] = 0);
        final int size = bitArray.getSize();
        int n = array[1];
        int n2 = 0;
        int n4;
        int nextUnset;
        for (int n3 = 0; n3 < 5 && n < size; ++n3, n2 = n4, n = nextUnset) {
            final int decodeDigit = UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char)(decodeDigit % 10 + 48));
            for (int length = decodeMiddleCounters.length, i = 0; i < length; ++i) {
                n += decodeMiddleCounters[i];
            }
            n4 = n2;
            if (decodeDigit >= 10) {
                n4 = (n2 | 1 << 4 - n3);
            }
            nextUnset = n;
            if (n3 != 4) {
                nextUnset = bitArray.getNextUnset(bitArray.getNextSet(n));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(sb.toString()) != determineCheckDigit(n2)) {
            throw NotFoundException.getNotFoundInstance();
        }
        return n;
    }
    
    private static int determineCheckDigit(final int n) throws NotFoundException {
        for (int i = 0; i < 10; ++i) {
            if (n == UPCEANExtension5Support.CHECK_DIGIT_ENCODINGS[i]) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static int extensionChecksum(final CharSequence charSequence) {
        final int length = charSequence.length();
        int n = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            n += charSequence.charAt(i) - '0';
        }
        int n2 = n * 3;
        for (int j = length - 1; j >= 0; j -= 2) {
            n2 += charSequence.charAt(j) - '0';
        }
        return n2 * 3 % 10;
    }
    
    private static String parseExtension5String(String str) {
        int n = 0;
        String str2 = null;
        Label_0043: {
            switch (str.charAt(0)) {
                default: {
                    str2 = "";
                    break;
                }
                case '0': {
                    str2 = "£";
                    break;
                }
                case '5': {
                    str2 = "$";
                    break;
                }
                case '9': {
                    Label_0170: {
                        switch (str.hashCode()) {
                            case 54118329: {
                                if (str.equals("90000")) {
                                    break Label_0170;
                                }
                                break;
                            }
                            case 54395377: {
                                if (str.equals("99991")) {
                                    n = 1;
                                    break Label_0170;
                                }
                                break;
                            }
                            case 54395376: {
                                if (str.equals("99990")) {
                                    n = 2;
                                    break Label_0170;
                                }
                                break;
                            }
                        }
                        n = -1;
                    }
                    switch (n) {
                        default: {
                            str2 = "";
                            break Label_0043;
                        }
                        case 0: {
                            return null;
                        }
                        case 1: {
                            return "0.00";
                        }
                        case 2: {
                            return "Used";
                        }
                    }
                    break;
                }
            }
        }
        final int int1 = Integer.parseInt(str.substring(1));
        final int i = int1 / 100;
        final int n2 = int1 % 100;
        if (n2 < 10) {
            str = "0" + n2;
        }
        else {
            str = String.valueOf(n2);
        }
        return str2 + String.valueOf(i) + '.' + str;
    }
    
    private static Map<ResultMetadataType, Object> parseExtensionString(String extension5String) {
        if (extension5String.length() == 5) {
            extension5String = parseExtension5String(extension5String);
            if (extension5String != null) {
                final EnumMap<ResultMetadataType, String> enumMap = (EnumMap<ResultMetadataType, String>)new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
                enumMap.put(ResultMetadataType.SUGGESTED_PRICE, extension5String);
                return (Map<ResultMetadataType, Object>)enumMap;
            }
        }
        return null;
    }
    
    Result decodeRow(final int n, final BitArray bitArray, final int[] array) throws NotFoundException {
        final StringBuilder decodeRowStringBuffer = this.decodeRowStringBuffer;
        decodeRowStringBuffer.setLength(0);
        final int decodeMiddle = this.decodeMiddle(bitArray, array, decodeRowStringBuffer);
        final String string = decodeRowStringBuffer.toString();
        final Map<ResultMetadataType, Object> extensionString = parseExtensionString(string);
        final Result result = new Result(string, null, new ResultPoint[] { new ResultPoint((array[0] + array[1]) / 2.0f, (float)n), new ResultPoint((float)decodeMiddle, (float)n) }, BarcodeFormat.UPC_EAN_EXTENSION);
        if (extensionString != null) {
            result.putAllMetadata(extensionString);
        }
        return result;
    }
}
