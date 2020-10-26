// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.List;
import org.ahocorasick.trie.Emit;
import java.util.Collection;

interface SegmentationSelector
{
    List<Emit> select(final Collection<Emit> p0);
}
