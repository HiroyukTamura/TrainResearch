// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn extends DetectionResultColumn
{
    private final boolean isLeft;
    
    DetectionResultRowIndicatorColumn(final BoundingBox boundingBox, final boolean isLeft) {
        super(boundingBox);
        this.isLeft = isLeft;
    }
    
    private void adjustIncompleteIndicatorColumnRowNumbers(final BarcodeMetadata barcodeMetadata) {
        final BoundingBox boundingBox = this.getBoundingBox();
        ResultPoint resultPoint;
        if (this.isLeft) {
            resultPoint = boundingBox.getTopLeft();
        }
        else {
            resultPoint = boundingBox.getTopRight();
        }
        ResultPoint resultPoint2;
        if (this.isLeft) {
            resultPoint2 = boundingBox.getBottomLeft();
        }
        else {
            resultPoint2 = boundingBox.getBottomRight();
        }
        int i = this.imageRowToCodewordIndex((int)resultPoint.getY());
        final int imageRowToCodewordIndex = this.imageRowToCodewordIndex((int)resultPoint2.getY());
        final Codeword[] codewords = this.getCodewords();
        int n = -1;
        int a = 1;
        int b = 0;
        while (i < imageRowToCodewordIndex) {
            int n2 = n;
            int n3 = b;
            int max = a;
            if (codewords[i] != null) {
                final Codeword codeword = codewords[i];
                codeword.setRowNumberAsRowIndicatorColumn();
                final int n4 = codeword.getRowNumber() - n;
                if (n4 == 0) {
                    n3 = b + 1;
                    max = a;
                    n2 = n;
                }
                else if (n4 == 1) {
                    max = Math.max(a, b);
                    n3 = 1;
                    n2 = codeword.getRowNumber();
                }
                else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                    codewords[i] = null;
                    n2 = n;
                    n3 = b;
                    max = a;
                }
                else {
                    n2 = codeword.getRowNumber();
                    n3 = 1;
                    max = a;
                }
            }
            ++i;
            n = n2;
            b = n3;
            a = max;
        }
    }
    
    private void removeIncorrectCodewords(final Codeword[] array, final BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < array.length; ++i) {
            final Codeword codeword = array[i];
            if (array[i] != null) {
                final int n = codeword.getValue() % 30;
                final int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    array[i] = null;
                }
                else {
                    int n2 = rowNumber;
                    if (!this.isLeft) {
                        n2 = rowNumber + 2;
                    }
                    switch (n2 % 3) {
                        case 0: {
                            if (n * 3 + 1 != barcodeMetadata.getRowCountUpperPart()) {
                                array[i] = null;
                                break;
                            }
                            break;
                        }
                        case 1: {
                            if (n / 3 != barcodeMetadata.getErrorCorrectionLevel() || n % 3 != barcodeMetadata.getRowCountLowerPart()) {
                                array[i] = null;
                                break;
                            }
                            break;
                        }
                        case 2: {
                            if (n + 1 != barcodeMetadata.getColumnCount()) {
                                array[i] = null;
                                break;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private void setRowNumbers() {
        final Codeword[] codewords = this.getCodewords();
        for (int length = codewords.length, i = 0; i < length; ++i) {
            final Codeword codeword = codewords[i];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }
    
    void adjustCompleteIndicatorColumnRowNumbers(final BarcodeMetadata barcodeMetadata) {
        final Codeword[] codewords = this.getCodewords();
        this.setRowNumbers();
        this.removeIncorrectCodewords(codewords, barcodeMetadata);
        final BoundingBox boundingBox = this.getBoundingBox();
        ResultPoint resultPoint;
        if (this.isLeft) {
            resultPoint = boundingBox.getTopLeft();
        }
        else {
            resultPoint = boundingBox.getTopRight();
        }
        ResultPoint resultPoint2;
        if (this.isLeft) {
            resultPoint2 = boundingBox.getBottomLeft();
        }
        else {
            resultPoint2 = boundingBox.getBottomRight();
        }
        int i = this.imageRowToCodewordIndex((int)resultPoint.getY());
        final int imageRowToCodewordIndex = this.imageRowToCodewordIndex((int)resultPoint2.getY());
        int n = -1;
        int a = 1;
        int b = 0;
        while (i < imageRowToCodewordIndex) {
            int n2 = n;
            int n3 = b;
            int max = a;
            if (codewords[i] != null) {
                final Codeword codeword = codewords[i];
                int n4 = codeword.getRowNumber() - n;
                if (n4 == 0) {
                    n3 = b + 1;
                    max = a;
                    n2 = n;
                }
                else if (n4 == 1) {
                    max = Math.max(a, b);
                    n3 = 1;
                    n2 = codeword.getRowNumber();
                }
                else if (n4 < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || n4 > i) {
                    codewords[i] = null;
                    n2 = n;
                    n3 = b;
                    max = a;
                }
                else {
                    if (a > 2) {
                        n4 *= a - 2;
                    }
                    int n5;
                    if (n4 >= i) {
                        n5 = 1;
                    }
                    else {
                        n5 = 0;
                    }
                    for (int n6 = 1; n6 <= n4 && n5 == 0; ++n6) {
                        if (codewords[i - n6] != null) {
                            n5 = 1;
                        }
                        else {
                            n5 = 0;
                        }
                    }
                    if (n5 != 0) {
                        codewords[i] = null;
                        n2 = n;
                        n3 = b;
                        max = a;
                    }
                    else {
                        n2 = codeword.getRowNumber();
                        n3 = 1;
                        max = a;
                    }
                }
            }
            ++i;
            n = n2;
            b = n3;
            a = max;
        }
    }
    
    BarcodeMetadata getBarcodeMetadata() {
        final Codeword[] codewords = this.getCodewords();
        final BarcodeValue barcodeValue = new BarcodeValue();
        final BarcodeValue barcodeValue2 = new BarcodeValue();
        final BarcodeValue barcodeValue3 = new BarcodeValue();
        final BarcodeValue barcodeValue4 = new BarcodeValue();
        for (int length = codewords.length, i = 0; i < length; ++i) {
            final Codeword codeword = codewords[i];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                final int n = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                switch (rowNumber % 3) {
                    case 0: {
                        barcodeValue2.setValue(n * 3 + 1);
                        break;
                    }
                    case 1: {
                        barcodeValue4.setValue(n / 3);
                        barcodeValue3.setValue(n % 3);
                        break;
                    }
                    case 2: {
                        barcodeValue.setValue(n + 1);
                        break;
                    }
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        final BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        this.removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }
    
    int[] getRowHeights() {
        final BarcodeMetadata barcodeMetadata = this.getBarcodeMetadata();
        int[] array;
        if (barcodeMetadata == null) {
            array = null;
        }
        else {
            this.adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
            final int[] array2 = new int[barcodeMetadata.getRowCount()];
            final Codeword[] codewords = this.getCodewords();
            final int length = codewords.length;
            int n = 0;
            while (true) {
                array = array2;
                if (n >= length) {
                    break;
                }
                final Codeword codeword = codewords[n];
                if (codeword != null) {
                    final int rowNumber = codeword.getRowNumber();
                    if (rowNumber < array2.length) {
                        ++array2[rowNumber];
                    }
                }
                ++n;
            }
        }
        return array;
    }
    
    boolean isLeft() {
        return this.isLeft;
    }
    
    @Override
    public String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
