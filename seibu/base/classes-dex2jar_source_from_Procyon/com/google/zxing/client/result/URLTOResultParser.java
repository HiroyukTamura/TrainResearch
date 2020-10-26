// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class URLTOResultParser extends ResultParser
{
    @Override
    public URIParsedResult parse(final Result result) {
        final String s = null;
        final String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("urlto:") || massagedText.startsWith("URLTO:")) {
            final int index = massagedText.indexOf(58, 6);
            if (index >= 0) {
                String substring;
                if (index <= 6) {
                    substring = s;
                }
                else {
                    substring = massagedText.substring(6, index);
                }
                return new URIParsedResult(massagedText.substring(index + 1), substring);
            }
        }
        return null;
    }
}
