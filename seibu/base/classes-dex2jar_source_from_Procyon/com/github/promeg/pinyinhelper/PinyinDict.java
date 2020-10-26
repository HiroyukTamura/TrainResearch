// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.Set;

public interface PinyinDict
{
    String[] toPinyin(final String p0);
    
    Set<String> words();
}
