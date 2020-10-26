// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Map;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzj extends zzbr
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = zzbf.zzdp.toString();
    }
    
    public zzj(final Context mContext) {
        super(zzj.ID, new String[0]);
        this.mContext = mContext;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        try {
            final PackageManager packageManager = this.mContext.getPackageManager();
            return zzgk.zzI(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        }
        catch (PackageManager$NameNotFoundException ex) {
            zzdj.zzb("App name is not found.", (Throwable)ex);
            return zzgk.zzCh();
        }
    }
}
