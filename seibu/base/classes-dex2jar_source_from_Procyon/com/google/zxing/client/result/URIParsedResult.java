// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class URIParsedResult extends ParsedResult
{
    private static final Pattern USER_IN_HOST;
    private final String title;
    private final String uri;
    
    static {
        USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    }
    
    public URIParsedResult(final String s, final String title) {
        super(ParsedResultType.URI);
        this.uri = massageURI(s);
        this.title = title;
    }
    
    private static boolean isColonFollowedByPortNumber(final String s, int n) {
        final int fromIndex = n + 1;
        if ((n = s.indexOf(47, fromIndex)) < 0) {
            n = s.length();
        }
        return ResultParser.isSubstringOfDigits(s, fromIndex, n - fromIndex);
    }
    
    private static String massageURI(String string) {
        final String trim = string.trim();
        final int index = trim.indexOf(58);
        if (index >= 0) {
            string = trim;
            if (!isColonFollowedByPortNumber(trim, index)) {
                return string;
            }
        }
        string = "http://" + trim;
        return string;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(30);
        ParsedResult.maybeAppend(this.title, sb);
        ParsedResult.maybeAppend(this.uri, sb);
        return sb.toString();
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getURI() {
        return this.uri;
    }
    
    public boolean isPossiblyMaliciousURI() {
        return URIParsedResult.USER_IN_HOST.matcher(this.uri).find();
    }
}
