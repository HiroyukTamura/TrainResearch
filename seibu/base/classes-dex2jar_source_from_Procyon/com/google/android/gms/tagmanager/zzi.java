// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzi extends zzbr
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = zzbf.zzdo.toString();
    }
    
    public zzi(final Context mContext) {
        super(zzi.ID, new String[0]);
        this.mContext = mContext;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgk.zzI(this.mContext.getPackageName());
    }
}
