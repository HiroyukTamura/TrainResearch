// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Build$VERSION;
import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzeb extends zzbr
{
    private static final String ID;
    
    static {
        ID = zzbf.zzdJ.toString();
    }
    
    public zzeb() {
        super(zzeb.ID, new String[0]);
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgk.zzI(Build$VERSION.RELEASE);
    }
}
