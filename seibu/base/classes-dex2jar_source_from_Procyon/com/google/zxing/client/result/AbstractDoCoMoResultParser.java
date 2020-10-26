// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

abstract class AbstractDoCoMoResultParser extends ResultParser
{
    static String[] matchDoCoMoPrefixedField(final String s, final String s2, final boolean b) {
        return ResultParser.matchPrefixedField(s, s2, ';', b);
    }
    
    static String matchSingleDoCoMoPrefixedField(final String s, final String s2, final boolean b) {
        return ResultParser.matchSinglePrefixedField(s, s2, ';', b);
    }
}
