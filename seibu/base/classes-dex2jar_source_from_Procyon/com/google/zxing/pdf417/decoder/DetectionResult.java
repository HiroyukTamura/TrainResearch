// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

final class DetectionResult
{
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;
    
    DetectionResult(final BarcodeMetadata barcodeMetadata, final BoundingBox boundingBox) {
        this.barcodeMetadata = barcodeMetadata;
        this.barcodeColumnCount = barcodeMetadata.getColumnCount();
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new DetectionResultColumn[this.barcodeColumnCount + 2];
    }
    
    private void adjustIndicatorColumnRowNumbers(final DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn)detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }
    
    private static boolean adjustRowNumber(final Codeword codeword, final Codeword codeword2) {
        if (codeword2 != null && codeword2.hasValidRowNumber() && codeword2.getBucket() == codeword.getBucket()) {
            codeword.setRowNumber(codeword2.getRowNumber());
            return true;
        }
        return false;
    }
    
    private static int adjustRowNumberIfValid(final int rowNumber, final int n, final Codeword codeword) {
        if (codeword == null) {
            return n;
        }
        int n2 = n;
        if (!codeword.hasValidRowNumber()) {
            if (codeword.isValidRowNumber(rowNumber)) {
                codeword.setRowNumber(rowNumber);
                n2 = 0;
            }
            else {
                n2 = n + 1;
            }
        }
        return n2;
    }
    
    private int adjustRowNumbers() {
        final int adjustRowNumbersByRow = this.adjustRowNumbersByRow();
        int n;
        if (adjustRowNumbersByRow == 0) {
            n = 0;
        }
        else {
            int n2 = 1;
            while (true) {
                n = adjustRowNumbersByRow;
                if (n2 >= this.barcodeColumnCount + 1) {
                    break;
                }
                final Codeword[] codewords = this.detectionResultColumns[n2].getCodewords();
                for (int i = 0; i < codewords.length; ++i) {
                    if (codewords[i] != null && !codewords[i].hasValidRowNumber()) {
                        this.adjustRowNumbers(n2, i, codewords);
                    }
                }
                ++n2;
            }
        }
        return n;
    }
    
    private void adjustRowNumbers(int n, final int n2, final Codeword[] array) {
        final int n3 = 0;
        final Codeword codeword = array[n2];
        Codeword[] array3;
        final Codeword[] array2 = array3 = this.detectionResultColumns[n - 1].getCodewords();
        if (this.detectionResultColumns[n + 1] != null) {
            array3 = this.detectionResultColumns[n + 1].getCodewords();
        }
        final Codeword[] array4 = new Codeword[14];
        array4[2] = array2[n2];
        array4[3] = array3[n2];
        if (n2 > 0) {
            array4[0] = array[n2 - 1];
            array4[4] = array2[n2 - 1];
            array4[5] = array3[n2 - 1];
        }
        if (n2 > 1) {
            array4[8] = array[n2 - 2];
            array4[10] = array2[n2 - 2];
            array4[11] = array3[n2 - 2];
        }
        if (n2 < array.length - 1) {
            array4[1] = array[n2 + 1];
            array4[6] = array2[n2 + 1];
            array4[7] = array3[n2 + 1];
        }
        n = n3;
        if (n2 < array.length - 2) {
            array4[9] = array[n2 + 2];
            array4[12] = array2[n2 + 2];
            array4[13] = array3[n2 + 2];
            n = n3;
        }
        while (n < 14 && !adjustRowNumber(codeword, array4[n])) {
            ++n;
        }
    }
    
    private int adjustRowNumbersByRow() {
        this.adjustRowNumbersFromBothRI();
        return this.adjustRowNumbersFromLRI() + this.adjustRowNumbersFromRRI();
    }
    
    private void adjustRowNumbersFromBothRI() {
        if (this.detectionResultColumns[0] != null && this.detectionResultColumns[this.barcodeColumnCount + 1] != null) {
            final Codeword[] codewords = this.detectionResultColumns[0].getCodewords();
            final Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
            for (int i = 0; i < codewords.length; ++i) {
                if (codewords[i] != null && codewords2[i] != null && codewords[i].getRowNumber() == codewords2[i].getRowNumber()) {
                    for (int j = 1; j <= this.barcodeColumnCount; ++j) {
                        final Codeword codeword = this.detectionResultColumns[j].getCodewords()[i];
                        if (codeword != null) {
                            codeword.setRowNumber(codewords[i].getRowNumber());
                            if (!codeword.hasValidRowNumber()) {
                                this.detectionResultColumns[j].getCodewords()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private int adjustRowNumbersFromLRI() {
        int n;
        if (this.detectionResultColumns[0] == null) {
            n = 0;
        }
        else {
            int n2 = 0;
            final Codeword[] codewords = this.detectionResultColumns[0].getCodewords();
            int n3 = 0;
            while (true) {
                n = n2;
                if (n3 >= codewords.length) {
                    break;
                }
                int n4 = n2;
                if (codewords[n3] != null) {
                    final int rowNumber = codewords[n3].getRowNumber();
                    int n5 = 0;
                    int n6 = 1;
                    while (true) {
                        n4 = n2;
                        if (n6 >= this.barcodeColumnCount + 1) {
                            break;
                        }
                        n4 = n2;
                        if (n5 >= 2) {
                            break;
                        }
                        final Codeword codeword = this.detectionResultColumns[n6].getCodewords()[n3];
                        int adjustRowNumberIfValid = n5;
                        int n7 = n2;
                        if (codeword != null) {
                            adjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, n5, codeword);
                            n7 = n2;
                            if (!codeword.hasValidRowNumber()) {
                                n7 = n2 + 1;
                                adjustRowNumberIfValid = adjustRowNumberIfValid;
                            }
                        }
                        ++n6;
                        n5 = adjustRowNumberIfValid;
                        n2 = n7;
                    }
                }
                ++n3;
                n2 = n4;
            }
        }
        return n;
    }
    
    private int adjustRowNumbersFromRRI() {
        int n;
        if (this.detectionResultColumns[this.barcodeColumnCount + 1] == null) {
            n = 0;
        }
        else {
            int n2 = 0;
            final Codeword[] codewords = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
            int n3 = 0;
            while (true) {
                n = n2;
                if (n3 >= codewords.length) {
                    break;
                }
                int n4 = n2;
                if (codewords[n3] != null) {
                    final int rowNumber = codewords[n3].getRowNumber();
                    int n5 = 0;
                    int n6 = this.barcodeColumnCount + 1;
                    while (true) {
                        n4 = n2;
                        if (n6 <= 0) {
                            break;
                        }
                        n4 = n2;
                        if (n5 >= 2) {
                            break;
                        }
                        final Codeword codeword = this.detectionResultColumns[n6].getCodewords()[n3];
                        int adjustRowNumberIfValid = n5;
                        int n7 = n2;
                        if (codeword != null) {
                            adjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, n5, codeword);
                            n7 = n2;
                            if (!codeword.hasValidRowNumber()) {
                                n7 = n2 + 1;
                                adjustRowNumberIfValid = adjustRowNumberIfValid;
                            }
                        }
                        --n6;
                        n5 = adjustRowNumberIfValid;
                        n2 = n7;
                    }
                }
                ++n3;
                n2 = n4;
            }
        }
        return n;
    }
    
    int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }
    
    int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }
    
    int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }
    
    BoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    DetectionResultColumn getDetectionResultColumn(final int n) {
        return this.detectionResultColumns[n];
    }
    
    DetectionResultColumn[] getDetectionResultColumns() {
        this.adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        this.adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int n = 928;
        int adjustRowNumbers;
        int n2;
        do {
            n2 = n;
            adjustRowNumbers = this.adjustRowNumbers();
        } while (adjustRowNumbers > 0 && (n = adjustRowNumbers) < n2);
        return this.detectionResultColumns;
    }
    
    void setBoundingBox(final BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
    
    void setDetectionResultColumn(final int n, final DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[n] = detectionResultColumn;
    }
    
    @Override
    public String toString() {
        Object string;
        if ((string = this.detectionResultColumns[0]) == null) {
            string = this.detectionResultColumns[this.barcodeColumnCount + 1];
        }
        final Formatter exception = new Formatter();
        final Throwable t = null;
        int i = 0;
    Label_0072_Outer:
        while (true) {
        Label_0145_Outer:
            while (true) {
                Label_0157: {
                    while (true) {
                        try {
                            if (i >= ((DetectionResultColumn)string).getCodewords().length) {
                                break Label_0145_Outer;
                            }
                            exception.format("CW %3d:", i);
                            final int n = 0;
                            if (n >= this.barcodeColumnCount + 2) {
                                break Label_0157;
                            }
                            if (this.detectionResultColumns[n] == null) {
                                exception.format("    |   ", new Object[0]);
                                break Label_0157;
                            }
                            final Codeword codeword = this.detectionResultColumns[n].getCodewords()[i];
                            if (codeword == null) {
                                exception.format("    |   ", new Object[0]);
                                break Label_0157;
                            }
                            break Label_0157;
                        }
                        catch (Throwable t) {
                            try {
                                throw t;
                            }
                            finally {}
                            while (true) {
                                Label_0238: {
                                    if (t == null) {
                                        break Label_0238;
                                    }
                                    try {
                                        exception.close();
                                        throw string;
                                        final Codeword codeword;
                                        exception.format(" %3d|%3d", codeword.getRowNumber(), codeword.getValue());
                                        break Label_0157;
                                        exception.format("%n", new Object[0]);
                                        ++i;
                                        continue Label_0072_Outer;
                                        string = exception.toString();
                                        exception.close();
                                        return (String)string;
                                    }
                                    catch (Throwable exception) {
                                        t.addSuppressed((Throwable)exception);
                                        throw string;
                                    }
                                    break Label_0238;
                                    final int n = n + 1;
                                    continue Label_0145_Outer;
                                }
                                exception.close();
                                continue;
                            }
                        }
                        finally {
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
            break;
        }
    }
}
