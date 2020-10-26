// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Map;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzl extends zzbr
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = zzbf.zzfx.toString();
    }
    
    public zzl(final Context mContext) {
        super(zzl.ID, new String[0]);
        this.mContext = mContext;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        try {
            return zzgk.zzI(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
        }
        catch (PackageManager$NameNotFoundException ex) {
            final String value = String.valueOf(this.mContext.getPackageName());
            final String value2 = String.valueOf(ex.getMessage());
            zzdj.e(new StringBuilder(String.valueOf(value).length() + 25 + String.valueOf(value2).length()).append("Package name ").append(value).append(" not found. ").append(value2).toString());
            return zzgk.zzCh();
        }
    }
}
