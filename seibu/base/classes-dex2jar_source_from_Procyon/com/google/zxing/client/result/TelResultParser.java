// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser extends ResultParser
{
    @Override
    public TelParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("tel:") && !massagedText.startsWith("TEL:")) {
            return null;
        }
        String string;
        if (massagedText.startsWith("TEL:")) {
            string = "tel:" + massagedText.substring(4);
        }
        else {
            string = massagedText;
        }
        final int index = massagedText.indexOf(63, 4);
        String s;
        if (index < 0) {
            s = massagedText.substring(4);
        }
        else {
            s = massagedText.substring(4, index);
        }
        return new TelParsedResult(s, string, null);
    }
}
