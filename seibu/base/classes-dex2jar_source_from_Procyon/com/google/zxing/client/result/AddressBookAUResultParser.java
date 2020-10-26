// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.List;
import java.util.ArrayList;

public final class AddressBookAUResultParser extends ResultParser
{
    private static String[] matchMultipleValuePrefix(final String str, final int initialCapacity, final String s, final boolean b) {
        List<String> list = null;
        List<String> list2;
        for (int i = 1; i <= initialCapacity; ++i, list = list2) {
            final String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i + ':', s, '\r', b);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if ((list2 = list) == null) {
                list2 = new ArrayList<String>(initialCapacity);
            }
            list2.add(matchSinglePrefixedField);
        }
        if (list == null) {
            return null;
        }
        return list.toArray(new String[list.size()]);
    }
    
    @Override
    public AddressBookParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        final String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("NAME1:", massagedText, '\r', true);
        final String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("NAME2:", massagedText, '\r', true);
        final String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
        final String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
        final String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, '\r', false);
        final String matchSinglePrefixedField4 = ResultParser.matchSinglePrefixedField("ADD:", massagedText, '\r', true);
        String[] array;
        if (matchSinglePrefixedField4 == null) {
            array = null;
        }
        else {
            array = new String[] { matchSinglePrefixedField4 };
        }
        return new AddressBookParsedResult(ResultParser.maybeWrap(matchSinglePrefixedField), null, matchSinglePrefixedField2, matchMultipleValuePrefix, null, matchMultipleValuePrefix2, null, null, matchSinglePrefixedField3, array, null, null, null, null, null, null);
    }
}
