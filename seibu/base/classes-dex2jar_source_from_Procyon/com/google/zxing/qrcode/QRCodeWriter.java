// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode;

import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.WriterException;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.QRCode;
import com.google.zxing.Writer;

public final class QRCodeWriter implements Writer
{
    private static final int QUIET_ZONE_SIZE = 4;
    
    private static BitMatrix renderResult(final QRCode qrCode, int a, int i, int max) {
        final ByteMatrix matrix = qrCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        final int width = matrix.getWidth();
        final int height = matrix.getHeight();
        final int b = width + (max << 1);
        final int b2 = height + (max << 1);
        max = Math.max(a, b);
        i = Math.max(i, b2);
        final int min = Math.min(max / b, i / b2);
        final int n = (max - width * min) / 2;
        a = (i - height * min) / 2;
        final BitMatrix bitMatrix = new BitMatrix(max, i);
        int j;
        for (i = 0; i < height; ++i, a += min) {
            for (j = 0, max = n; j < width; ++j, max += min) {
                if (matrix.get(j, i) == 1) {
                    bitMatrix.setRegion(max, a, min, min);
                }
            }
        }
        return bitMatrix;
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) throws WriterException {
        return this.encode(s, barcodeFormat, n, n2, null);
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int i, final int j, final Map<EncodeHintType, ?> map) throws WriterException {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (obj != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + obj);
        }
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + j);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        final int n = 4;
        ErrorCorrectionLevel errorCorrectionLevel2 = errorCorrectionLevel;
        int int1 = n;
        if (map != null) {
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            errorCorrectionLevel2 = errorCorrectionLevel;
            int1 = n;
            if (map.containsKey(EncodeHintType.MARGIN)) {
                int1 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                errorCorrectionLevel2 = errorCorrectionLevel;
            }
        }
        return renderResult(Encoder.encode(s, errorCorrectionLevel2, map), i, j, int1);
    }
}
