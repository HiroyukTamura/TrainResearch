// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.provider.Settings$Secure;
import java.util.Map;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzbc extends zzbr
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = zzbf.zzdU.toString();
    }
    
    public zzbc(final Context mContext) {
        super(zzbc.ID, new String[0]);
        this.mContext = mContext;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String string = Settings$Secure.getString(this.mContext.getContentResolver(), "android_id");
        if (string == null) {
            return zzgk.zzCh();
        }
        return zzgk.zzI(string);
    }
}
