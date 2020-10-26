// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.android;

import java.util.Iterator;
import java.util.Arrays;
import android.content.Intent;
import java.util.HashMap;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.regex.Pattern;
import com.google.zxing.BarcodeFormat;
import java.util.Set;

public final class DecodeFormatManager
{
    static final Set<BarcodeFormat> AZTEC_FORMATS;
    private static final Pattern COMMA_PATTERN;
    static final Set<BarcodeFormat> DATA_MATRIX_FORMATS;
    private static final Map<String, Set<BarcodeFormat>> FORMATS_FOR_MODE;
    static final Set<BarcodeFormat> INDUSTRIAL_FORMATS;
    private static final Set<BarcodeFormat> ONE_D_FORMATS;
    static final Set<BarcodeFormat> PDF417_FORMATS;
    static final Set<BarcodeFormat> PRODUCT_FORMATS;
    static final Set<BarcodeFormat> QR_CODE_FORMATS;
    
    static {
        COMMA_PATTERN = Pattern.compile(",");
        QR_CODE_FORMATS = EnumSet.of(BarcodeFormat.QR_CODE);
        DATA_MATRIX_FORMATS = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        AZTEC_FORMATS = EnumSet.of(BarcodeFormat.AZTEC);
        PDF417_FORMATS = EnumSet.of(BarcodeFormat.PDF_417);
        PRODUCT_FORMATS = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[] { BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED });
        INDUSTRIAL_FORMATS = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        (ONE_D_FORMATS = EnumSet.copyOf(DecodeFormatManager.PRODUCT_FORMATS)).addAll(DecodeFormatManager.INDUSTRIAL_FORMATS);
        (FORMATS_FOR_MODE = new HashMap<String, Set<BarcodeFormat>>()).put("ONE_D_MODE", DecodeFormatManager.ONE_D_FORMATS);
        DecodeFormatManager.FORMATS_FOR_MODE.put("PRODUCT_MODE", DecodeFormatManager.PRODUCT_FORMATS);
        DecodeFormatManager.FORMATS_FOR_MODE.put("QR_CODE_MODE", DecodeFormatManager.QR_CODE_FORMATS);
        DecodeFormatManager.FORMATS_FOR_MODE.put("DATA_MATRIX_MODE", DecodeFormatManager.DATA_MATRIX_FORMATS);
        DecodeFormatManager.FORMATS_FOR_MODE.put("AZTEC_MODE", DecodeFormatManager.AZTEC_FORMATS);
        DecodeFormatManager.FORMATS_FOR_MODE.put("PDF417_MODE", DecodeFormatManager.PDF417_FORMATS);
    }
    
    private DecodeFormatManager() {
    }
    
    public static Set<BarcodeFormat> parseDecodeFormats(final Intent intent) {
        Iterable<String> list = null;
        final String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        if (stringExtra != null) {
            list = Arrays.asList(DecodeFormatManager.COMMA_PATTERN.split(stringExtra));
        }
        return parseDecodeFormats(list, intent.getStringExtra("SCAN_MODE"));
    }
    
    private static Set<BarcodeFormat> parseDecodeFormats(final Iterable<String> iterable, final String s) {
        if (iterable != null) {
            final EnumSet<BarcodeFormat> none = EnumSet.noneOf(BarcodeFormat.class);
            try {
                final Iterator<String> iterator = iterable.iterator();
                while (true) {
                    final Set<BarcodeFormat> set = none;
                    if (!iterator.hasNext()) {
                        return set;
                    }
                    none.add(BarcodeFormat.valueOf(iterator.next()));
                }
            }
            catch (IllegalArgumentException ex) {}
        }
        if (s == null) {
            return null;
        }
        return DecodeFormatManager.FORMATS_FOR_MODE.get(s);
    }
}
