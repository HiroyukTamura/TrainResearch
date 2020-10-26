// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ISBNResultParser extends ResultParser
{
    @Override
    public ISBNParsedResult parse(final Result result) {
        if (result.getBarcodeFormat() == BarcodeFormat.EAN_13) {
            final String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.length() == 13 && (massagedText.startsWith("978") || massagedText.startsWith("979"))) {
                return new ISBNParsedResult(massagedText);
            }
        }
        return null;
    }
}
