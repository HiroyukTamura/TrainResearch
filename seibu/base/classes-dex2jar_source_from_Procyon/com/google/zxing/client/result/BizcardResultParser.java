// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

public final class BizcardResultParser extends AbstractDoCoMoResultParser
{
    private static String buildName(final String str, final String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }
    
    private static String[] buildPhoneNumbers(final String s, final String s2, final String s3) {
        final ArrayList<String> list = new ArrayList<String>(3);
        if (s != null) {
            list.add(s);
        }
        if (s2 != null) {
            list.add(s2);
        }
        if (s3 != null) {
            list.add(s3);
        }
        final int size = list.size();
        if (size == 0) {
            return null;
        }
        return list.toArray(new String[size]);
    }
    
    @Override
    public AddressBookParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        return new AddressBookParsedResult(ResultParser.maybeWrap(buildName(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("N:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("X:", massagedText, true))), null, null, buildPhoneNumbers(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("B:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("M:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("F:", massagedText, true)), null, ResultParser.maybeWrap(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("E:", massagedText, true)), null, null, null, AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("A:", massagedText, true), null, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("C:", massagedText, true), null, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("T:", massagedText, true), null, null);
    }
}
