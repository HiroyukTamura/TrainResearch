// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec;

import java.nio.charset.StandardCharsets;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;

public final class AztecWriter implements Writer
{
    private static BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Charset charset, final int n3, final int n4) {
        if (obj != BarcodeFormat.AZTEC) {
            throw new IllegalArgumentException("Can only encode AZTEC, but got " + obj);
        }
        return renderResult(Encoder.encode(s.getBytes(charset), n3, n4), n, n2);
    }
    
    private static BitMatrix renderResult(final AztecCode aztecCode, int a, int i) {
        final BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        final int width = matrix.getWidth();
        final int height = matrix.getHeight();
        final int max = Math.max(a, width);
        i = Math.max(i, height);
        final int min = Math.min(max / width, i / height);
        final int n = (max - width * min) / 2;
        a = (i - height * min) / 2;
        final BitMatrix bitMatrix = new BitMatrix(max, i);
        int j;
        int n2;
        for (i = 0; i < height; ++i, a += min) {
            for (j = 0, n2 = n; j < width; ++j, n2 += min) {
                if (matrix.get(j, i)) {
                    bitMatrix.setRegion(n2, a, min, min);
                }
            }
        }
        return bitMatrix;
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) {
        return this.encode(s, barcodeFormat, n, n2, null);
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2, final Map<EncodeHintType, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int int1 = 33;
        final int n3 = 0;
        Charset charset2 = charset;
        int n4 = int1;
        int int2 = n3;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charset = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                int1 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            charset2 = charset;
            n4 = int1;
            int2 = n3;
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                int2 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                n4 = int1;
                charset2 = charset;
            }
        }
        return encode(s, barcodeFormat, n, n2, charset2, n4, int2);
    }
}
