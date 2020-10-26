// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.oned.EAN8Writer;
import java.util.Map;
import com.google.zxing.common.BitMatrix;

public final class MultiFormatWriter implements Writer
{
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) throws WriterException {
        return this.encode(s, barcodeFormat, n, n2, null);
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        Writer writer = null;
        switch (obj) {
            default: {
                throw new IllegalArgumentException("No encoder available for format " + obj);
            }
            case EAN_8: {
                writer = new EAN8Writer();
                break;
            }
            case UPC_E: {
                writer = new UPCEWriter();
                break;
            }
            case EAN_13: {
                writer = new EAN13Writer();
                break;
            }
            case UPC_A: {
                writer = new UPCAWriter();
                break;
            }
            case QR_CODE: {
                writer = new QRCodeWriter();
                break;
            }
            case CODE_39: {
                writer = new Code39Writer();
                break;
            }
            case CODE_93: {
                writer = new Code93Writer();
                break;
            }
            case CODE_128: {
                writer = new Code128Writer();
                break;
            }
            case ITF: {
                writer = new ITFWriter();
                break;
            }
            case PDF_417: {
                writer = new PDF417Writer();
                break;
            }
            case CODABAR: {
                writer = new CodaBarWriter();
                break;
            }
            case DATA_MATRIX: {
                writer = new DataMatrixWriter();
                break;
            }
            case AZTEC: {
                writer = new AztecWriter();
                break;
            }
        }
        return writer.encode(s, obj, n, n2, map);
    }
}
