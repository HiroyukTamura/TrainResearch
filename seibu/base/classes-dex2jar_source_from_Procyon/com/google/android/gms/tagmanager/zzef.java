// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzef extends zzbr
{
    private static final String ID;
    private static final com.google.android.gms.internal.zzbr zzbFD;
    
    static {
        ID = zzbf.zzdK.toString();
        zzbFD = zzgk.zzI("Android");
    }
    
    public zzef() {
        super(zzef.ID, new String[0]);
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzef.zzbFD;
    }
}
