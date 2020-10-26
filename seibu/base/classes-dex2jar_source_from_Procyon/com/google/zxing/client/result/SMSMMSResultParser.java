// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.util.Map;
import java.util.ArrayList;
import com.google.zxing.Result;
import java.util.Collection;

public final class SMSMMSResultParser extends ResultParser
{
    private static void addNumberVia(final Collection<String> collection, final Collection<String> collection2, final String s) {
        final int index = s.indexOf(59);
        if (index < 0) {
            collection.add(s);
            collection2.add(null);
            return;
        }
        collection.add(s.substring(0, index));
        final String substring = s.substring(index + 1);
        String substring2;
        if (substring.startsWith("via=")) {
            substring2 = substring.substring(4);
        }
        else {
            substring2 = null;
        }
        collection2.add(substring2);
    }
    
    @Override
    public SMSParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        final Map<String, String> nameValuePairs = ResultParser.parseNameValuePairs(massagedText);
        final String s = null;
        final String s2 = null;
        final int n = 0;
        String s3 = s2;
        int n2 = n;
        String s4 = s;
        if (nameValuePairs != null) {
            s3 = s2;
            n2 = n;
            s4 = s;
            if (!nameValuePairs.isEmpty()) {
                s4 = nameValuePairs.get("subject");
                s3 = nameValuePairs.get("body");
                n2 = 1;
            }
        }
        final int index = massagedText.indexOf(63, 4);
        String s5;
        if (index < 0 || n2 == 0) {
            s5 = massagedText.substring(4);
        }
        else {
            s5 = massagedText.substring(4, index);
        }
        int n3 = -1;
        final ArrayList<String> list = new ArrayList<String>(1);
        final ArrayList<String> list2 = new ArrayList<String>(1);
        while (true) {
            final int index2 = s5.indexOf(44, n3 + 1);
            if (index2 <= n3) {
                break;
            }
            addNumberVia(list, list2, s5.substring(n3 + 1, index2));
            n3 = index2;
        }
        addNumberVia(list, list2, s5.substring(n3 + 1));
        return new SMSParsedResult(list.toArray(new String[list.size()]), list2.toArray(new String[list2.size()]), s4, s3);
    }
}
