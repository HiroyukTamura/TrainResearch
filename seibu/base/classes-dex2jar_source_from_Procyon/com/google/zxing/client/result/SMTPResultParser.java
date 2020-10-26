// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMTPResultParser extends ResultParser
{
    @Override
    public EmailAddressParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("smtp:") && !massagedText.startsWith("SMTP:")) {
            return null;
        }
        final String substring = massagedText.substring(5);
        String substring2 = null;
        final String s = null;
        final int index = substring.indexOf(58);
        String substring3 = s;
        String s2 = substring;
        if (index >= 0) {
            final String substring4 = substring.substring(index + 1);
            final String substring5 = substring.substring(0, index);
            final int index2 = substring4.indexOf(58);
            substring2 = substring4;
            substring3 = s;
            s2 = substring5;
            if (index2 >= 0) {
                substring3 = substring4.substring(index2 + 1);
                substring2 = substring4.substring(0, index2);
                s2 = substring5;
            }
        }
        return new EmailAddressParsedResult(new String[] { s2 }, null, null, substring2, substring3);
    }
}
