// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.Comparator;
import java.util.Collections;
import org.ahocorasick.trie.Emit;
import java.util.Collection;
import org.ahocorasick.trie.Trie;
import java.util.Iterator;
import java.util.List;

final class Engine
{
    static final EmitComparator EMIT_COMPARATOR;
    
    static {
        EMIT_COMPARATOR = new EmitComparator();
    }
    
    private Engine() {
    }
    
    static String[] pinyinFromDict(final String str, final List<PinyinDict> list) {
        if (list != null) {
            for (final PinyinDict pinyinDict : list) {
                if (pinyinDict != null && pinyinDict.words() != null && pinyinDict.words().contains(str)) {
                    return pinyinDict.toPinyin(str);
                }
            }
        }
        throw new IllegalArgumentException("No pinyin dict contains word: " + str);
    }
    
    static String toPinyin(final String s, final Trie trie, final List<PinyinDict> list, final String str, final SegmentationSelector segmentationSelector) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (trie == null || segmentationSelector == null) {
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); ++i) {
                sb.append(Pinyin.toPinyin(s.charAt(i)));
                if (i != s.length() - 1) {
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        final List<Emit> select = segmentationSelector.select(trie.parseText((CharSequence)s));
        Collections.sort((List<Object>)select, (Comparator<? super Object>)Engine.EMIT_COMPARATOR);
        final StringBuffer sb2 = new StringBuffer();
        int n = 0;
        int n2;
        int n3;
        for (int j = 0; j < s.length(); j = n2, n = n3) {
            if (n < select.size() && j == select.get(n).getStart()) {
                final String[] pinyinFromDict = pinyinFromDict(select.get(n).getKeyword(), list);
                for (int k = 0; k < pinyinFromDict.length; ++k) {
                    sb2.append(pinyinFromDict[k].toUpperCase());
                    if (k != pinyinFromDict.length - 1) {
                        sb2.append(str);
                    }
                }
                n2 = j + select.get(n).size();
                n3 = n + 1;
            }
            else {
                sb2.append(Pinyin.toPinyin(s.charAt(j)));
                n2 = j + 1;
                n3 = n;
            }
            j = n2;
            n = n3;
            if (n2 != s.length()) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }
    
    static final class EmitComparator implements Comparator<Emit>
    {
        @Override
        public int compare(final Emit emit, final Emit emit2) {
            int n = -1;
            if (emit.getStart() != emit2.getStart()) {
                if (emit.getStart() >= emit2.getStart()) {
                    if (emit.getStart() == emit2.getStart()) {
                        n = 0;
                    }
                    else {
                        n = 1;
                    }
                }
                return n;
            }
            if (emit.size() < emit2.size()) {
                return 1;
            }
            if (emit.size() == emit2.size()) {
                return 0;
            }
            return -1;
        }
    }
}
