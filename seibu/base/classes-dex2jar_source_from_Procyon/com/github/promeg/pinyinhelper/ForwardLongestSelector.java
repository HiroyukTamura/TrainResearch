// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import org.ahocorasick.trie.Emit;
import java.util.Collection;

final class ForwardLongestSelector implements SegmentationSelector
{
    static final Engine.EmitComparator HIT_COMPARATOR;
    
    static {
        HIT_COMPARATOR = new Engine.EmitComparator();
    }
    
    @Override
    public List<Emit> select(final Collection<Emit> c) {
        if (c == null) {
            return null;
        }
        final ArrayList<Object> list = new ArrayList<Object>(c);
        Collections.sort(list, (Comparator<? super Object>)ForwardLongestSelector.HIT_COMPARATOR);
        int end = -1;
        final TreeSet<Object> set = new TreeSet<Object>();
        for (final Emit emit : list) {
            if (emit.getStart() > end && emit.getEnd() > end) {
                end = emit.getEnd();
            }
            else {
                set.add(emit);
            }
        }
        list.removeAll(set);
        return (List<Emit>)list;
    }
}
