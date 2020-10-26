// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser extends ResultParser
{
    private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN;
    private static final Pattern URL_WITH_PROTOCOL_PATTERN;
    
    static {
        URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
        URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
    }
    
    static boolean isBasicallyValidURI(final String s) {
        if (!s.contains(" ")) {
            final Matcher matcher = URIResultParser.URL_WITH_PROTOCOL_PATTERN.matcher(s);
            if (matcher.find() && matcher.start() == 0) {
                return true;
            }
            final Matcher matcher2 = URIResultParser.URL_WITHOUT_PROTOCOL_PATTERN.matcher(s);
            if (matcher2.find() && matcher2.start() == 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public URIParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("URL:") || massagedText.startsWith("URI:")) {
            return new URIParsedResult(massagedText.substring(4).trim(), null);
        }
        final String trim = massagedText.trim();
        if (isBasicallyValidURI(trim)) {
            return new URIParsedResult(trim, null);
        }
        return null;
    }
}
