// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzbg
{
    private final List<String> zzaIh;
    private final Object zzaaw;
    
    private zzbg(final Object o) {
        this.zzaaw = zzbo.zzu(o);
        this.zzaIh = new ArrayList<String>();
    }
    
    @Override
    public final String toString() {
        final StringBuilder append = new StringBuilder(100).append(this.zzaaw.getClass().getSimpleName()).append('{');
        for (int size = this.zzaIh.size(), i = 0; i < size; ++i) {
            append.append(this.zzaIh.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
    
    public final zzbg zzg(String s, final Object obj) {
        final List<String> zzaIh = this.zzaIh;
        s = zzbo.zzu(s);
        final String value = String.valueOf(String.valueOf(obj));
        zzaIh.add(new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(value).length()).append(s).append("=").append(value).toString());
        return this;
    }
}
