// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.view.WindowManager;
import android.util.DisplayMetrics;
import java.util.Map;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzen extends zzbr
{
    private static final String ID;
    private final Context mContext;
    
    static {
        ID = zzbf.zzdN.toString();
    }
    
    public zzen(final Context mContext) {
        super(zzen.ID, new String[0]);
        this.mContext = mContext;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return zzgk.zzI(new StringBuilder(23).append(displayMetrics.widthPixels).append("x").append(displayMetrics.heightPixels).toString());
    }
}
