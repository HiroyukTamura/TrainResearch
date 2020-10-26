// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.ResultPoint;
import com.google.zxing.FormatException;
import java.util.Collection;
import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import com.google.zxing.common.DecoderResult;
import java.lang.reflect.Array;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.NotFoundException;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;

public final class PDF417ScanningDecoder
{
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection;
    
    static {
        errorCorrection = new ErrorCorrection();
    }
    
    private PDF417ScanningDecoder() {
    }
    
    private static BoundingBox adjustBoundingBox(final DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        if (detectionResultRowIndicatorColumn != null) {
            final int[] rowHeights = detectionResultRowIndicatorColumn.getRowHeights();
            if (rowHeights != null) {
                final int max = getMax(rowHeights);
                int n = 0;
                final int length = rowHeights.length;
                int n2 = 0;
                int n3;
                while (true) {
                    n3 = n;
                    if (n2 >= length) {
                        break;
                    }
                    final int n4 = rowHeights[n2];
                    n = (n3 = n + (max - n4));
                    if (n4 > 0) {
                        break;
                    }
                    ++n2;
                }
                Codeword[] codewords;
                int n5;
                int n6;
                for (codewords = detectionResultRowIndicatorColumn.getCodewords(), n5 = 0, n6 = n3; n6 > 0 && codewords[n5] == null; --n6, ++n5) {}
                int n7 = 0;
                int n8 = rowHeights.length - 1;
                int n9;
                while (true) {
                    n9 = n7;
                    if (n8 < 0) {
                        break;
                    }
                    n7 = (n9 = n7 + (max - rowHeights[n8]));
                    if (rowHeights[n8] > 0) {
                        break;
                    }
                    --n8;
                }
                for (int n10 = codewords.length - 1; n9 > 0 && codewords[n10] == null; --n9, --n10) {}
                return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(n6, n9, detectionResultRowIndicatorColumn.isLeft());
            }
        }
        return null;
    }
    
    private static void adjustCodewordCount(final DetectionResult detectionResult, final BarcodeValue[][] array) throws NotFoundException {
        final BarcodeValue barcodeValue = array[0][1];
        final int[] value = barcodeValue.getValue();
        final int n = detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount() - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (n <= 0 || n > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValue.setValue(n);
        }
        else if (value[0] != n) {
            barcodeValue.setValue(n);
        }
    }
    
    private static int adjustCodewordStartColumn(final BitMatrix bitMatrix, final int n, final int n2, boolean b, final int n3, final int n4) {
        int n5 = n3;
        int n6;
        if (b) {
            n6 = -1;
        }
        else {
            n6 = 1;
        }
        final int n7 = 0;
        int n8 = n6;
        for (int i = n7; i < 2; ++i) {
            while (true) {
                if (b) {
                    if (n5 < n) {
                        break;
                    }
                }
                else if (n5 >= n2) {
                    break;
                }
                if (b != bitMatrix.get(n5, n4)) {
                    break;
                }
                if (Math.abs(n3 - n5) > 2) {
                    return n3;
                }
                n5 += n8;
            }
            n8 = -n8;
            if (!b) {
                b = true;
            }
            else {
                b = false;
            }
        }
        return n5;
    }
    
    private static boolean checkCodewordSkew(final int n, final int n2, final int n3) {
        return n2 - 2 <= n && n <= n3 + 2;
    }
    
    private static int correctErrors(final int[] array, final int[] array2, final int n) throws ChecksumException {
        if ((array2 != null && array2.length > n / 2 + 3) || n < 0 || n > 512) {
            throw ChecksumException.getChecksumInstance();
        }
        return PDF417ScanningDecoder.errorCorrection.decode(array, n, array2);
    }
    
    private static BarcodeValue[][] createBarcodeMatrix(final DetectionResult detectionResult) {
        final BarcodeValue[][] array = (BarcodeValue[][])Array.newInstance(BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                array[i][j] = new BarcodeValue();
            }
        }
        int n = 0;
        final DetectionResultColumn[] detectionResultColumns = detectionResult.getDetectionResultColumns();
        for (int length = detectionResultColumns.length, k = 0; k < length; ++k) {
            final DetectionResultColumn detectionResultColumn = detectionResultColumns[k];
            if (detectionResultColumn != null) {
                final Codeword[] codewords = detectionResultColumn.getCodewords();
                for (int length2 = codewords.length, l = 0; l < length2; ++l) {
                    final Codeword codeword = codewords[l];
                    if (codeword != null) {
                        final int rowNumber = codeword.getRowNumber();
                        if (rowNumber >= 0 && rowNumber < array.length) {
                            array[rowNumber][n].setValue(codeword.getValue());
                        }
                    }
                }
            }
            ++n;
        }
        return array;
    }
    
    private static DecoderResult createDecoderResult(final DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        final BarcodeValue[][] barcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, barcodeMatrix);
        final ArrayList<Integer> list = new ArrayList<Integer>();
        final int[] array = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        final ArrayList<int[]> list2 = new ArrayList<int[]>();
        final ArrayList<Integer> list3 = new ArrayList<Integer>();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); ++i) {
            for (int j = 0; j < detectionResult.getBarcodeColumnCount(); ++j) {
                final int[] value = barcodeMatrix[i][j + 1].getValue();
                final int n = detectionResult.getBarcodeColumnCount() * i + j;
                if (value.length == 0) {
                    list.add(n);
                }
                else if (value.length == 1) {
                    array[n] = value[0];
                }
                else {
                    list3.add(n);
                    list2.add(value);
                }
            }
        }
        final int[][] array2 = new int[list2.size()][];
        for (int k = 0; k < array2.length; ++k) {
            array2[k] = (int[])list2.get(k);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), array, PDF417Common.toIntArray(list), PDF417Common.toIntArray(list3), array2);
    }
    
    private static DecoderResult createDecoderResultFromAmbiguousValues(final int n, final int[] array, final int[] array2, final int[] array3, final int[][] array4) throws FormatException, ChecksumException {
        final int[] array5 = new int[array3.length];
        int n2 = 100;
    Label_0010:
        while (true) {
            final int n3 = n2 - 1;
            if (n2 > 0) {
                for (int i = 0; i < array5.length; ++i) {
                    array[array3[i]] = array4[i][array5[i]];
                }
                try {
                    return decodeCodewords(array, n, array2);
                }
                catch (ChecksumException ex) {
                    if (array5.length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    for (int j = 0; j < array5.length; ++j) {
                        if (array5[j] < array4[j].length - 1) {
                            ++array5[j];
                            n2 = n3;
                            continue Label_0010;
                        }
                        array5[j] = 0;
                        if (j == array5.length - 1) {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    n2 = n3;
                    continue;
                }
                break;
            }
            break;
        }
        throw ChecksumException.getChecksumInstance();
    }
    
    public static DecoderResult decode(final BitMatrix bitMatrix, final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4, int i, int a) throws NotFoundException, FormatException, ChecksumException {
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResultRowIndicatorColumn rowIndicatorColumn = null;
        DetectionResultRowIndicatorColumn rowIndicatorColumn2 = null;
        DetectionResult merge = null;
        int n = 0;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2;
        while (true) {
            detectionResultRowIndicatorColumn = rowIndicatorColumn;
            detectionResultRowIndicatorColumn2 = rowIndicatorColumn2;
            if (n >= 2) {
                break;
            }
            if (resultPoint != null) {
                rowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, a);
            }
            if (resultPoint3 != null) {
                rowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, a);
            }
            merge = merge(rowIndicatorColumn, rowIndicatorColumn2);
            if (merge == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (n != 0 || merge.getBoundingBox() == null || (merge.getBoundingBox().getMinY() >= boundingBox.getMinY() && merge.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                merge.setBoundingBox(boundingBox);
                detectionResultRowIndicatorColumn2 = rowIndicatorColumn2;
                detectionResultRowIndicatorColumn = rowIndicatorColumn;
                break;
            }
            boundingBox = merge.getBoundingBox();
            ++n;
        }
        final int n2 = merge.getBarcodeColumnCount() + 1;
        merge.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        merge.setDetectionResultColumn(n2, detectionResultRowIndicatorColumn2);
        final boolean b = detectionResultRowIndicatorColumn != null;
        final int n3 = 1;
        int a2 = i;
        int n4;
        int n5;
        int n6;
        DetectionResultColumn detectionResultColumn;
        int n7;
        int minY;
        int startColumn;
        int n8;
        int n9 = 0;
        int min = 0;
        int max = 0;
        Codeword detectCodeword;
        for (i = n3; i <= n2; ++i, a2 = n5, a = n6) {
            if (b) {
                n4 = i;
            }
            else {
                n4 = n2 - i;
            }
            n5 = a2;
            n6 = a;
            if (merge.getDetectionResultColumn(n4) == null) {
                if (n4 == 0 || n4 == n2) {
                    detectionResultColumn = new DetectionResultRowIndicatorColumn(boundingBox, n4 == 0);
                }
                else {
                    detectionResultColumn = new DetectionResultColumn(boundingBox);
                }
                merge.setDetectionResultColumn(n4, detectionResultColumn);
                n7 = -1;
                minY = boundingBox.getMinY();
                while (true) {
                    n5 = a2;
                    n6 = a;
                    if (minY > boundingBox.getMaxY()) {
                        break;
                    }
                    startColumn = getStartColumn(merge, n4, minY, b);
                    Label_0441: {
                        if (startColumn < 0 || (n8 = startColumn) > boundingBox.getMaxX()) {
                            n9 = n7;
                            min = a2;
                            max = a;
                            if (n7 == -1) {
                                break Label_0441;
                            }
                            n8 = n7;
                        }
                        detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), b, n8, minY, a2, a);
                        n9 = n7;
                        min = a2;
                        max = a;
                        if (detectCodeword != null) {
                            detectionResultColumn.setCodeword(minY, detectCodeword);
                            min = Math.min(a2, detectCodeword.getWidth());
                            max = Math.max(a, detectCodeword.getWidth());
                            n9 = n8;
                        }
                    }
                    ++minY;
                    n7 = n9;
                    a2 = min;
                    a = max;
                }
            }
        }
        return createDecoderResult(merge);
    }
    
    private static DecoderResult decodeCodewords(final int[] array, final int i, final int[] array2) throws FormatException, ChecksumException {
        if (array.length == 0) {
            throw FormatException.getFormatInstance();
        }
        final int n = 1 << i + 1;
        final int correctErrors = correctErrors(array, array2, n);
        verifyCodewordCount(array, n);
        final DecoderResult decode = DecodedBitStreamParser.decode(array, String.valueOf(i));
        decode.setErrorsCorrected(correctErrors);
        decode.setErasures(array2.length);
        return decode;
    }
    
    private static Codeword detectCodeword(final BitMatrix bitMatrix, int i, int n, final boolean b, int adjustCodewordStartColumn, int codeword, final int n2, final int n3) {
        adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, n, b, adjustCodewordStartColumn, codeword);
        final int[] moduleBitCount = getModuleBitCount(bitMatrix, i, n, b, adjustCodewordStartColumn, codeword);
        if (moduleBitCount == null) {
            return null;
        }
        n = MathUtils.sum(moduleBitCount);
        if (b) {
            i = adjustCodewordStartColumn + n;
        }
        else {
            for (i = 0; i < moduleBitCount.length / 2; ++i) {
                codeword = moduleBitCount[i];
                moduleBitCount[i] = moduleBitCount[moduleBitCount.length - 1 - i];
                moduleBitCount[moduleBitCount.length - 1 - i] = codeword;
            }
            i = adjustCodewordStartColumn;
            adjustCodewordStartColumn -= n;
        }
        if (!checkCodewordSkew(n, n2, n3)) {
            return null;
        }
        n = PDF417CodewordDecoder.getDecodedValue(moduleBitCount);
        codeword = PDF417Common.getCodeword(n);
        if (codeword == -1) {
            return null;
        }
        return new Codeword(adjustCodewordStartColumn, i, getCodewordBucketNumber(n), codeword);
    }
    
    private static BarcodeMetadata getBarcodeMetadata(final DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, final DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        if (detectionResultRowIndicatorColumn != null) {
            final BarcodeMetadata barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata();
            if (barcodeMetadata != null) {
                BarcodeMetadata barcodeMetadata2 = barcodeMetadata;
                if (detectionResultRowIndicatorColumn2 == null) {
                    return barcodeMetadata2;
                }
                final BarcodeMetadata barcodeMetadata3 = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
                barcodeMetadata2 = barcodeMetadata;
                if (barcodeMetadata3 == null) {
                    return barcodeMetadata2;
                }
                barcodeMetadata2 = barcodeMetadata;
                if (barcodeMetadata.getColumnCount() == barcodeMetadata3.getColumnCount()) {
                    return barcodeMetadata2;
                }
                barcodeMetadata2 = barcodeMetadata;
                if (barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata3.getErrorCorrectionLevel()) {
                    return barcodeMetadata2;
                }
                barcodeMetadata2 = barcodeMetadata;
                if (barcodeMetadata.getRowCount() != barcodeMetadata3.getRowCount()) {
                    return null;
                }
                return barcodeMetadata2;
            }
        }
        if (detectionResultRowIndicatorColumn2 != null) {
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        return null;
    }
    
    private static int[] getBitCountForCodeword(int n) {
        final int[] array = new int[8];
        int n2 = 0;
        int n3 = 7;
        while (true) {
            int n4 = n3;
            int n5 = n2;
            if ((n & 0x1) != n2) {
                n5 = (n & 0x1);
                n4 = n3 - 1;
                if (n4 < 0) {
                    break;
                }
            }
            ++array[n4];
            n >>= 1;
            n3 = n4;
            n2 = n5;
        }
        return array;
    }
    
    private static int getCodewordBucketNumber(final int n) {
        return getCodewordBucketNumber(getBitCountForCodeword(n));
    }
    
    private static int getCodewordBucketNumber(final int[] array) {
        return (array[0] - array[2] + array[4] - array[6] + 9) % 9;
    }
    
    private static int getMax(final int[] array) {
        int max = -1;
        for (int length = array.length, i = 0; i < length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    private static int[] getModuleBitCount(final BitMatrix bitMatrix, final int n, int n2, final boolean b, int n3, final int n4) {
        int n5 = n3;
        final int[] array = new int[8];
        int n6 = 0;
        if (b) {
            n3 = 1;
        }
        else {
            n3 = -1;
        }
        boolean b2 = b;
        while (true) {
            if (b) {
                if (n5 >= n2) {
                    break;
                }
            }
            else if (n5 < n) {
                break;
            }
            if (n6 >= 8) {
                break;
            }
            if (bitMatrix.get(n5, n4) == b2) {
                ++array[n6];
                n5 += n3;
            }
            else {
                ++n6;
                b2 = !b2;
            }
        }
        if (n6 != 8) {
            if (!b) {
                n2 = n;
            }
            if (n5 != n2 || n6 != 7) {
                return null;
            }
        }
        return array;
    }
    
    private static int getNumberOfECCodeWords(final int n) {
        return 2 << n;
    }
    
    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(final BitMatrix bitMatrix, final BoundingBox boundingBox, final ResultPoint resultPoint, final boolean b, final int n, final int n2) {
        final DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, b);
        for (int i = 0; i < 2; ++i) {
            int n3;
            if (i == 0) {
                n3 = 1;
            }
            else {
                n3 = -1;
            }
            int n4 = (int)resultPoint.getX();
            for (int n5 = (int)resultPoint.getY(); n5 <= boundingBox.getMaxY() && n5 >= boundingBox.getMinY(); n5 += n3) {
                final Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), b, n4, n5, n, n2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(n5, detectCodeword);
                    if (b) {
                        n4 = detectCodeword.getStartX();
                    }
                    else {
                        n4 = detectCodeword.getEndX();
                    }
                }
            }
        }
        return detectionResultRowIndicatorColumn;
    }
    
    private static int getStartColumn(final DetectionResult detectionResult, int n, int i, final boolean b) {
        int n2;
        if (b) {
            n2 = 1;
        }
        else {
            n2 = -1;
        }
        Codeword codeword = null;
        if (isValidBarcodeColumn(detectionResult, n - n2)) {
            codeword = detectionResult.getDetectionResultColumn(n - n2).getCodeword(i);
        }
        if (codeword != null) {
            if (b) {
                return codeword.getEndX();
            }
            return codeword.getStartX();
        }
        else {
            Codeword codeword2 = detectionResult.getDetectionResultColumn(n).getCodewordNearby(i);
            if (codeword2 != null) {
                if (b) {
                    return codeword2.getStartX();
                }
                return codeword2.getEndX();
            }
            else {
                if (isValidBarcodeColumn(detectionResult, n - n2)) {
                    codeword2 = detectionResult.getDetectionResultColumn(n - n2).getCodewordNearby(i);
                }
                if (codeword2 != null) {
                    if (b) {
                        return codeword2.getEndX();
                    }
                    return codeword2.getStartX();
                }
                else {
                    final int n3 = 0;
                    i = n;
                    n = n3;
                    while (isValidBarcodeColumn(detectionResult, i - n2)) {
                        final int n4 = i - n2;
                        final Codeword[] codewords = detectionResult.getDetectionResultColumn(n4).getCodewords();
                        int length;
                        Codeword codeword3;
                        for (length = codewords.length, i = 0; i < length; ++i) {
                            codeword3 = codewords[i];
                            if (codeword3 != null) {
                                if (b) {
                                    i = codeword3.getEndX();
                                }
                                else {
                                    i = codeword3.getStartX();
                                }
                                return i + n2 * n * (codeword3.getEndX() - codeword3.getStartX());
                            }
                        }
                        ++n;
                        i = n4;
                    }
                    if (b) {
                        return detectionResult.getBoundingBox().getMinX();
                    }
                    return detectionResult.getBoundingBox().getMaxX();
                }
            }
        }
    }
    
    private static boolean isValidBarcodeColumn(final DetectionResult detectionResult, final int n) {
        return n >= 0 && n <= detectionResult.getBarcodeColumnCount() + 1;
    }
    
    private static DetectionResult merge(final DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, final DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        if (detectionResultRowIndicatorColumn != null || detectionResultRowIndicatorColumn2 != null) {
            final BarcodeMetadata barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
            if (barcodeMetadata != null) {
                return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
            }
        }
        return null;
    }
    
    public static String toString(final BarcodeValue[][] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: new             Ljava/util/Formatter;
        //     5: dup            
        //     6: invokespecial   java/util/Formatter.<init>:()V
        //     9: astore          4
        //    11: iconst_0       
        //    12: istore_1       
        //    13: iload_1        
        //    14: aload_0        
        //    15: arraylength    
        //    16: if_icmpge       157
        //    19: aload           4
        //    21: ldc_w           "Row %2d: "
        //    24: iconst_1       
        //    25: anewarray       Ljava/lang/Object;
        //    28: dup            
        //    29: iconst_0       
        //    30: iload_1        
        //    31: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    34: aastore        
        //    35: invokevirtual   java/util/Formatter.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
        //    38: pop            
        //    39: iconst_0       
        //    40: istore_2       
        //    41: iload_2        
        //    42: aload_0        
        //    43: iload_1        
        //    44: aaload         
        //    45: arraylength    
        //    46: if_icmpge       137
        //    49: aload_0        
        //    50: iload_1        
        //    51: aaload         
        //    52: iload_2        
        //    53: aaload         
        //    54: astore          5
        //    56: aload           5
        //    58: invokevirtual   com/google/zxing/pdf417/decoder/BarcodeValue.getValue:()[I
        //    61: arraylength    
        //    62: ifne            78
        //    65: aload           4
        //    67: ldc_w           "        "
        //    70: aconst_null    
        //    71: invokevirtual   java/util/Formatter.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
        //    74: pop            
        //    75: goto            193
        //    78: aload           4
        //    80: ldc_w           "%4d(%2d)"
        //    83: iconst_2       
        //    84: anewarray       Ljava/lang/Object;
        //    87: dup            
        //    88: iconst_0       
        //    89: aload           5
        //    91: invokevirtual   com/google/zxing/pdf417/decoder/BarcodeValue.getValue:()[I
        //    94: iconst_0       
        //    95: iaload         
        //    96: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    99: aastore        
        //   100: dup            
        //   101: iconst_1       
        //   102: aload           5
        //   104: aload           5
        //   106: invokevirtual   com/google/zxing/pdf417/decoder/BarcodeValue.getValue:()[I
        //   109: iconst_0       
        //   110: iaload         
        //   111: invokevirtual   com/google/zxing/pdf417/decoder/BarcodeValue.getConfidence:(I)Ljava/lang/Integer;
        //   114: aastore        
        //   115: invokevirtual   java/util/Formatter.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
        //   118: pop            
        //   119: goto            193
        //   122: astore_3       
        //   123: aload_3        
        //   124: athrow         
        //   125: astore_0       
        //   126: aload_3        
        //   127: ifnull          181
        //   130: aload           4
        //   132: invokevirtual   java/util/Formatter.close:()V
        //   135: aload_0        
        //   136: athrow         
        //   137: aload           4
        //   139: ldc_w           "%n"
        //   142: iconst_0       
        //   143: anewarray       Ljava/lang/Object;
        //   146: invokevirtual   java/util/Formatter.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
        //   149: pop            
        //   150: iload_1        
        //   151: iconst_1       
        //   152: iadd           
        //   153: istore_1       
        //   154: goto            13
        //   157: aload           4
        //   159: invokevirtual   java/util/Formatter.toString:()Ljava/lang/String;
        //   162: astore_0       
        //   163: aload           4
        //   165: invokevirtual   java/util/Formatter.close:()V
        //   168: aload_0        
        //   169: areturn        
        //   170: astore          4
        //   172: aload_3        
        //   173: aload           4
        //   175: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   178: goto            135
        //   181: aload           4
        //   183: invokevirtual   java/util/Formatter.close:()V
        //   186: goto            135
        //   189: astore_0       
        //   190: goto            126
        //   193: iload_2        
        //   194: iconst_1       
        //   195: iadd           
        //   196: istore_2       
        //   197: goto            41
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     39     122    126    Ljava/lang/Throwable;
        //  13     39     189    193    Any
        //  41     49     122    126    Ljava/lang/Throwable;
        //  41     49     189    193    Any
        //  56     75     122    126    Ljava/lang/Throwable;
        //  56     75     189    193    Any
        //  78     119    122    126    Ljava/lang/Throwable;
        //  78     119    189    193    Any
        //  123    125    125    126    Any
        //  130    135    170    181    Ljava/lang/Throwable;
        //  137    150    122    126    Ljava/lang/Throwable;
        //  137    150    189    193    Any
        //  157    163    122    126    Ljava/lang/Throwable;
        //  157    163    189    193    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void verifyCodewordCount(final int[] array, final int n) throws FormatException {
        if (array.length < 4) {
            throw FormatException.getFormatInstance();
        }
        final int n2 = array[0];
        if (n2 > array.length) {
            throw FormatException.getFormatInstance();
        }
        if (n2 == 0) {
            if (n >= array.length) {
                throw FormatException.getFormatInstance();
            }
            array[0] = array.length - n;
        }
    }
}
