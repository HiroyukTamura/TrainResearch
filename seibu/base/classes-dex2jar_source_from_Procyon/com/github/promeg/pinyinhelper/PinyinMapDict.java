// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.Set;
import java.util.Map;

public abstract class PinyinMapDict implements PinyinDict
{
    public abstract Map<String, String[]> mapping();
    
    @Override
    public String[] toPinyin(final String s) {
        if (this.mapping() != null) {
            return this.mapping().get(s);
        }
        return null;
    }
    
    @Override
    public Set<String> words() {
        if (this.mapping() != null) {
            return this.mapping().keySet();
        }
        return null;
    }
}
