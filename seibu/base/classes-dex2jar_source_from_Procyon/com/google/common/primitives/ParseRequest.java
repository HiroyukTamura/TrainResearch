// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class ParseRequest
{
    final int radix;
    final String rawValue;
    
    private ParseRequest(final String rawValue, final int radix) {
        this.rawValue = rawValue;
        this.radix = radix;
    }
    
    static ParseRequest fromString(String s) {
        if (s.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        final char char1 = s.charAt(0);
        int n;
        if (s.startsWith("0x") || s.startsWith("0X")) {
            s = s.substring(2);
            n = 16;
        }
        else if (char1 == '#') {
            s = s.substring(1);
            n = 16;
        }
        else if (char1 == '0' && s.length() > 1) {
            s = s.substring(1);
            n = 8;
        }
        else {
            n = 10;
        }
        return new ParseRequest(s, n);
    }
}
