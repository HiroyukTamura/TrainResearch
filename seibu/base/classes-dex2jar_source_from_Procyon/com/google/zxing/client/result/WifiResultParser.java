// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class WifiResultParser extends ResultParser
{
    @Override
    public WifiParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("WIFI:")) {
            final String substring = massagedText.substring(5);
            final String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("S:", substring, ';', false);
            if (matchSinglePrefixedField != null && !matchSinglePrefixedField.isEmpty()) {
                final String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("P:", substring, ';', false);
                String matchSinglePrefixedField3;
                if ((matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("T:", substring, ';', false)) == null) {
                    matchSinglePrefixedField3 = "nopass";
                }
                return new WifiParsedResult(matchSinglePrefixedField3, matchSinglePrefixedField, matchSinglePrefixedField2, Boolean.parseBoolean(ResultParser.matchSinglePrefixedField("H:", substring, ';', false)), ResultParser.matchSinglePrefixedField("I:", substring, ';', false), ResultParser.matchSinglePrefixedField("A:", substring, ';', false), ResultParser.matchSinglePrefixedField("E:", substring, ';', false), ResultParser.matchSinglePrefixedField("H:", substring, ';', false));
            }
        }
        return null;
    }
}
