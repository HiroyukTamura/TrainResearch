// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.util.Map;
import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser
{
    private static final Pattern COMMA;
    
    static {
        COMMA = Pattern.compile(",");
    }
    
    @Override
    public EmailAddressParsedResult parse(final Result result) {
        final EmailAddressParsedResult emailAddressParsedResult = null;
        final String massagedText = ResultParser.getMassagedText(result);
        Label_0264: {
            if (!massagedText.startsWith("mailto:") && !massagedText.startsWith("MAILTO:")) {
                break Label_0264;
            }
            final String substring = massagedText.substring(7);
            final int index = substring.indexOf(63);
            String substring2 = substring;
            if (index >= 0) {
                substring2 = substring.substring(0, index);
            }
            try {
                final String urlDecode = ResultParser.urlDecode(substring2);
                String[] split = null;
                if (!urlDecode.isEmpty()) {
                    split = EmailAddressResultParser.COMMA.split(urlDecode);
                }
                final Map<String, String> nameValuePairs = ResultParser.parseNameValuePairs(massagedText);
                String[] array = null;
                final String[] array2 = null;
                String[] array3 = null;
                final String[] array4 = null;
                String s = null;
                String s2 = null;
                String[] split2 = split;
                if (nameValuePairs != null) {
                    if ((split2 = split) == null) {
                        final String input = nameValuePairs.get("to");
                        split2 = split;
                        if (input != null) {
                            split2 = EmailAddressResultParser.COMMA.split(input);
                        }
                    }
                    final String input2 = nameValuePairs.get("cc");
                    String[] split3 = array2;
                    if (input2 != null) {
                        split3 = EmailAddressResultParser.COMMA.split(input2);
                    }
                    final String input3 = nameValuePairs.get("bcc");
                    String[] split4 = array4;
                    if (input3 != null) {
                        split4 = EmailAddressResultParser.COMMA.split(input3);
                    }
                    s = nameValuePairs.get("subject");
                    s2 = nameValuePairs.get("body");
                    array3 = split4;
                    array = split3;
                }
                EmailAddressParsedResult emailAddressParsedResult2 = new EmailAddressParsedResult(split2, array, array3, s, s2);
                Label_0262: {
                    return emailAddressParsedResult2;
                }
                emailAddressParsedResult2 = emailAddressParsedResult;
                // iftrue(Label_0262:, !EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText))
                return new EmailAddressParsedResult(massagedText);
            }
            catch (IllegalArgumentException ex) {
                return null;
            }
        }
    }
}
