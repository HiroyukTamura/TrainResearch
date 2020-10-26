// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.ReaderException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.ChecksumException;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import java.util.Arrays;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.google.zxing.FormatException;

public abstract class UPCEANReader extends OneDReader
{
    static final int[] END_PATTERN;
    static final int[][] L_AND_G_PATTERNS;
    static final int[][] L_PATTERNS;
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] MIDDLE_PATTERN;
    static final int[] START_END_PATTERN;
    private final StringBuilder decodeRowStringBuffer;
    private final EANManufacturerOrgSupport eanManSupport;
    private final UPCEANExtensionSupport extensionReader;
    
    static {
        START_END_PATTERN = new int[] { 1, 1, 1 };
        MIDDLE_PATTERN = new int[] { 1, 1, 1, 1, 1 };
        END_PATTERN = new int[] { 1, 1, 1, 1, 1, 1 };
        L_PATTERNS = new int[][] { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
        L_AND_G_PATTERNS = new int[20][];
        System.arraycopy(UPCEANReader.L_PATTERNS, 0, UPCEANReader.L_AND_G_PATTERNS, 0, 10);
        for (int i = 10; i < 20; ++i) {
            final int[] array = UPCEANReader.L_PATTERNS[i - 10];
            final int[] array2 = new int[array.length];
            for (int j = 0; j < array.length; ++j) {
                array2[j] = array[array.length - j - 1];
            }
            UPCEANReader.L_AND_G_PATTERNS[i] = array2;
        }
    }
    
    protected UPCEANReader() {
        this.decodeRowStringBuffer = new StringBuilder(20);
        this.extensionReader = new UPCEANExtensionSupport();
        this.eanManSupport = new EANManufacturerOrgSupport();
    }
    
    static boolean checkStandardUPCEANChecksum(final CharSequence charSequence) throws FormatException {
        final int length = charSequence.length();
        return length != 0 && getStandardUPCEANChecksum(charSequence.subSequence(0, length - 1)) == Character.digit(charSequence.charAt(length - 1), 10);
    }
    
    static int decodeDigit(final BitArray bitArray, final int[] array, int i, final int[][] array2) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i, array);
        float n = 0.48f;
        int n2 = -1;
        int length;
        float patternMatchVariance;
        float n3;
        for (length = array2.length, i = 0; i < length; ++i, n = n3) {
            patternMatchVariance = OneDReader.patternMatchVariance(array, array2[i], 0.7f);
            n3 = n;
            if (patternMatchVariance < n) {
                n3 = patternMatchVariance;
                n2 = i;
            }
        }
        if (n2 >= 0) {
            return n2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    static int[] findGuardPattern(final BitArray bitArray, final int n, final boolean b, final int[] array) throws NotFoundException {
        return findGuardPattern(bitArray, n, b, array, new int[array.length]);
    }
    
    private static int[] findGuardPattern(final BitArray bitArray, int n, boolean b, final int[] array, final int[] array2) throws NotFoundException {
        final int size = bitArray.getSize();
        if (b) {
            n = bitArray.getNextUnset(n);
        }
        else {
            n = bitArray.getNextSet(n);
        }
        final int n2 = 0;
        final int n3 = n;
        final int length = array.length;
        int i = n;
        n = n3;
        int n4 = n2;
        while (i < size) {
            if (bitArray.get(i) != b) {
                ++array2[n4];
            }
            else {
                if (n4 == length - 1) {
                    if (OneDReader.patternMatchVariance(array2, array, 0.7f) < 0.48f) {
                        return new int[] { n, i };
                    }
                    n += array2[0] + array2[1];
                    System.arraycopy(array2, 2, array2, 0, n4 - 1);
                    array2[n4] = (array2[n4 - 1] = 0);
                    --n4;
                }
                else {
                    ++n4;
                }
                array2[n4] = 1;
                if (!b) {
                    b = true;
                }
                else {
                    b = false;
                }
            }
            ++i;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    static int[] findStartGuardPattern(final BitArray bitArray) throws NotFoundException {
        boolean range = false;
        int[] array = null;
        int n = 0;
        final int[] a = new int[UPCEANReader.START_END_PATTERN.length];
        while (!range) {
            Arrays.fill(a, 0, UPCEANReader.START_END_PATTERN.length, 0);
            final int[] guardPattern = findGuardPattern(bitArray, n, false, UPCEANReader.START_END_PATTERN, a);
            final int n2 = guardPattern[0];
            final int n3 = guardPattern[1];
            final int n4 = n2 - (n3 - n2);
            n = n3;
            array = guardPattern;
            if (n4 >= 0) {
                range = bitArray.isRange(n4, n2, false);
                n = n3;
                array = guardPattern;
            }
        }
        return array;
    }
    
    static int getStandardUPCEANChecksum(final CharSequence charSequence) throws FormatException {
        final int length = charSequence.length();
        int n = 0;
        for (int i = length - 1; i >= 0; i -= 2) {
            final int n2 = charSequence.charAt(i) - '0';
            if (n2 < 0 || n2 > 9) {
                throw FormatException.getFormatInstance();
            }
            n += n2;
        }
        int n3 = n * 3;
        for (int j = length - 2; j >= 0; j -= 2) {
            final int n4 = charSequence.charAt(j) - '0';
            if (n4 < 0 || n4 > 9) {
                throw FormatException.getFormatInstance();
            }
            n3 += n4;
        }
        return (1000 - n3) % 10;
    }
    
    boolean checkChecksum(final String s) throws FormatException {
        return checkStandardUPCEANChecksum(s);
    }
    
    int[] decodeEnd(final BitArray bitArray, final int n) throws NotFoundException {
        return findGuardPattern(bitArray, n, false, UPCEANReader.START_END_PATTERN);
    }
    
    protected abstract int decodeMiddle(final BitArray p0, final int[] p1, final StringBuilder p2) throws NotFoundException;
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return this.decodeRow(n, bitArray, findStartGuardPattern(bitArray), map);
    }
    
    public Result decodeRow(int length, final BitArray bitArray, int[] array, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPointCallback resultPointCallback;
        if (map == null) {
            resultPointCallback = null;
        }
        else {
            resultPointCallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((array[0] + array[1]) / 2.0f, (float)length));
        }
        final StringBuilder decodeRowStringBuffer = this.decodeRowStringBuffer;
        decodeRowStringBuffer.setLength(0);
        final int decodeMiddle = this.decodeMiddle(bitArray, array, decodeRowStringBuffer);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((float)decodeMiddle, (float)length));
        }
        final int[] decodeEnd = this.decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((decodeEnd[0] + decodeEnd[1]) / 2.0f, (float)length));
        }
        final int n = decodeEnd[1];
        final int n2 = n + (n - decodeEnd[0]);
        if (n2 >= bitArray.getSize() || !bitArray.isRange(n, n2, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        final String string = decodeRowStringBuffer.toString();
        if (string.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!this.checkChecksum(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        final float n3 = (array[1] + array[0]) / 2.0f;
        final float n4 = (decodeEnd[1] + decodeEnd[0]) / 2.0f;
        final BarcodeFormat barcodeFormat = this.getBarcodeFormat();
        array = (int[])(Object)new Result(string, null, new ResultPoint[] { new ResultPoint(n3, (float)length), new ResultPoint(n4, (float)length) }, barcodeFormat);
        int n5 = 0;
        while (true) {
            try {
                final Result decodeRow = this.extensionReader.decodeRow(length, bitArray, decodeEnd[1]);
                ((Result)(Object)array).putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                ((Result)(Object)array).putAllMetadata(decodeRow.getResultMetadata());
                ((Result)(Object)array).addResultPoints(decodeRow.getResultPoints());
                length = decodeRow.getText().length();
                int[] array2;
                if (map == null) {
                    array2 = null;
                }
                else {
                    array2 = (int[])(Object)map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
                }
                if (array2 != null) {
                    final int n6 = 0;
                    final int length2 = array2.length;
                    n5 = 0;
                    int n7;
                    while (true) {
                        n7 = n6;
                        if (n5 >= length2) {
                            break;
                        }
                        if (length == array2[n5]) {
                            n7 = 1;
                            break;
                        }
                        ++n5;
                    }
                    if (n7 == 0) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                if (barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) {
                    final String lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(string);
                    if (lookupCountryIdentifier != null) {
                        ((Result)(Object)array).putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
                    }
                }
                return (Result)(Object)array;
            }
            catch (ReaderException ex) {
                length = n5;
                continue;
            }
            break;
        }
    }
    
    abstract BarcodeFormat getBarcodeFormat();
}
