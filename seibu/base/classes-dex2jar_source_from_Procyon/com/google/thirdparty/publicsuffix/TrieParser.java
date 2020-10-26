// 
// Decompiled by Procyon v0.5.36
// 

package com.google.thirdparty.publicsuffix;

import com.google.common.collect.Lists;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import com.google.common.base.Joiner;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
class TrieParser
{
    private static final Joiner PREFIX_JOINER;
    
    static {
        PREFIX_JOINER = Joiner.on("");
    }
    
    private static int doParseTrieToBuilder(final List<CharSequence> list, final CharSequence charSequence, final ImmutableMap.Builder<String, PublicSuffixType> builder) {
        final int length = charSequence.length();
        int n = 0;
        char char1 = '\0';
        char c;
        while (true) {
            c = char1;
            if (n >= length) {
                break;
            }
            char1 = charSequence.charAt(n);
            if ((c = char1) == '&' || (c = char1) == '?' || (c = char1) == '!' || (c = char1) == ':') {
                break;
            }
            if (char1 == ',') {
                c = char1;
                break;
            }
            ++n;
        }
        list.add(0, reverse(charSequence.subSequence(0, n)));
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            final String join = TrieParser.PREFIX_JOINER.join(list);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c));
            }
        }
        int n3;
        int n2 = n3 = n + 1;
        if (c != '?') {
            n3 = n2;
            if (c != ',') {
                while ((n3 = n2) < length) {
                    final int n4 = n2 + doParseTrieToBuilder(list, charSequence.subSequence(n2, length), builder);
                    if (charSequence.charAt(n4) != '?') {
                        n2 = n4;
                        if (charSequence.charAt(n4) != ',') {
                            continue;
                        }
                    }
                    n3 = n4 + 1;
                    break;
                }
            }
        }
        list.remove(0);
        return n3;
    }
    
    static ImmutableMap<String, PublicSuffixType> parseTrie(final CharSequence charSequence) {
        final ImmutableMap.Builder<String, PublicSuffixType> builder = ImmutableMap.builder();
        for (int length = charSequence.length(), i = 0; i < length; i += doParseTrieToBuilder((List<CharSequence>)Lists.newLinkedList(), charSequence.subSequence(i, length), builder)) {}
        return builder.build();
    }
    
    private static CharSequence reverse(final CharSequence charSequence) {
        final int length = charSequence.length();
        if (length <= 1) {
            return charSequence;
        }
        final char[] value = new char[length];
        value[0] = charSequence.charAt(length - 1);
        for (int i = 1; i < length; ++i) {
            value[i] = charSequence.charAt(length - 1 - i);
            if (Character.isSurrogatePair(value[i], value[i - 1])) {
                swap(value, i - 1, i);
            }
        }
        return new String(value);
    }
    
    private static void swap(final char[] array, final int n, final int n2) {
        final char c = array[n];
        array[n] = array[n2];
        array[n2] = c;
    }
}
