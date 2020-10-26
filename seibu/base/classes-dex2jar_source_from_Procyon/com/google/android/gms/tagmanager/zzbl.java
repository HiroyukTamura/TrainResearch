// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;
import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzbl extends zzga
{
    private static final String ID;
    
    static {
        ID = zzbf.zzex.toString();
    }
    
    public zzbl() {
        super(zzbl.ID);
    }
    
    @Override
    protected final boolean zza(final String s, final String suffix, final Map<String, com.google.android.gms.internal.zzbr> map) {
        return s.endsWith(suffix);
    }
}
