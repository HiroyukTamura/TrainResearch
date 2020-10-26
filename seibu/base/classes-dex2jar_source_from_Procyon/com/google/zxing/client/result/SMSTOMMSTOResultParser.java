// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMSTOMMSTOResultParser extends ResultParser
{
    @Override
    public SMSParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("smsto:") && !massagedText.startsWith("SMSTO:") && !massagedText.startsWith("mmsto:") && !massagedText.startsWith("MMSTO:")) {
            return null;
        }
        final String substring = massagedText.substring(6);
        String substring2 = null;
        final int index = substring.indexOf(58);
        String substring3 = substring;
        if (index >= 0) {
            substring2 = substring.substring(index + 1);
            substring3 = substring.substring(0, index);
        }
        return new SMSParsedResult(substring3, null, null, substring2);
    }
}
