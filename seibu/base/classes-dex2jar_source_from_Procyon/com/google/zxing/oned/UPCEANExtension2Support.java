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

final class UPCEANExtension2Support
{
    private final int[] decodeMiddleCounters;
    private final StringBuilder decodeRowStringBuffer;
    
    UPCEANExtension2Support() {
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
        for (int n3 = 0; n3 < 2 && n < size; ++n3, n2 = n4, n = nextUnset) {
            final int decodeDigit = UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char)(decodeDigit % 10 + 48));
            for (int length = decodeMiddleCounters.length, i = 0; i < length; ++i) {
                n += decodeMiddleCounters[i];
            }
            n4 = n2;
            if (decodeDigit >= 10) {
                n4 = (n2 | 1 << 1 - n3);
            }
            nextUnset = n;
            if (n3 != 1) {
                nextUnset = bitArray.getNextUnset(bitArray.getNextSet(n));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb.toString()) % 4 != n2) {
            throw NotFoundException.getNotFoundInstance();
        }
        return n;
    }
    
    private static Map<ResultMetadataType, Object> parseExtensionString(final String s) {
        if (s.length() != 2) {
            return null;
        }
        final EnumMap<ResultMetadataType, Integer> enumMap = (EnumMap<ResultMetadataType, Integer>)new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(s));
        return (Map<ResultMetadataType, Object>)enumMap;
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
