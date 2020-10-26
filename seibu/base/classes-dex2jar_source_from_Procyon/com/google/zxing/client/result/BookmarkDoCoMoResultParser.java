// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser
{
    @Override
    public URIParsedResult parse(final Result result) {
        final String text = result.getText();
        if (text.startsWith("MEBKM:")) {
            final String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("TITLE:", text, true);
            final String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", text, true);
            if (matchDoCoMoPrefixedField != null) {
                final String s = matchDoCoMoPrefixedField[0];
                if (URIResultParser.isBasicallyValidURI(s)) {
                    return new URIParsedResult(s, matchSingleDoCoMoPrefixedField);
                }
            }
        }
        return null;
    }
}
