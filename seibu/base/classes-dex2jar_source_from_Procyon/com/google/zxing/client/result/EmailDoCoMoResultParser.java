// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser
{
    private static final Pattern ATEXT_ALPHANUMERIC;
    
    static {
        ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");
    }
    
    static boolean isBasicallyValidEmailAddress(final String input) {
        return input != null && EmailDoCoMoResultParser.ATEXT_ALPHANUMERIC.matcher(input).matches() && input.indexOf(64) >= 0;
    }
    
    @Override
    public EmailAddressParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("MATMSG:")) {
            final String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("TO:", massagedText, true);
            if (matchDoCoMoPrefixedField != null) {
                for (int length = matchDoCoMoPrefixedField.length, i = 0; i < length; ++i) {
                    if (!isBasicallyValidEmailAddress(matchDoCoMoPrefixedField[i])) {
                        return null;
                    }
                }
                return new EmailAddressParsedResult(matchDoCoMoPrefixedField, null, null, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("SUB:", massagedText, false), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("BODY:", massagedText, false));
            }
        }
        return null;
    }
}
