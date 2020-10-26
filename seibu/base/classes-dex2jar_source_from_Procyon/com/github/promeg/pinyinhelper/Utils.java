// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.Iterator;
import org.ahocorasick.trie.Trie$TrieBuilder;
import java.util.Collection;
import java.util.TreeSet;
import org.ahocorasick.trie.Trie;
import java.util.List;

final class Utils
{
    private Utils() {
    }
    
    static Trie dictsToTrie(final List<PinyinDict> list) {
        final TreeSet<String> set = new TreeSet<String>();
        final Trie$TrieBuilder builder = Trie.builder();
        if (list != null) {
            for (final PinyinDict pinyinDict : list) {
                if (pinyinDict != null && pinyinDict.words() != null) {
                    set.addAll((Collection<?>)pinyinDict.words());
                }
            }
            if (set.size() > 0) {
                final Iterator<Object> iterator2 = set.iterator();
                while (iterator2.hasNext()) {
                    builder.addKeyword((String)iterator2.next());
                }
                return builder.build();
            }
        }
        return null;
    }
}
