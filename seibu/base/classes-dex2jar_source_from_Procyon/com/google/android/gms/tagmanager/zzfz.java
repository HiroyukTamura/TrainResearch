// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;
import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzfz extends zzga
{
    private static final String ID;
    
    static {
        ID = zzbf.zzew.toString();
    }
    
    public zzfz() {
        super(zzfz.ID);
    }
    
    @Override
    protected final boolean zza(final String s, final String prefix, final Map<String, com.google.android.gms.internal.zzbr> map) {
        return s.startsWith(prefix);
    }
}
