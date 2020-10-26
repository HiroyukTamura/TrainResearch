// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.content.Context;

public final class zzchk
{
    final Context mContext;
    
    public zzchk(Context applicationContext) {
        zzbo.zzu(applicationContext);
        applicationContext = applicationContext.getApplicationContext();
        zzbo.zzu(applicationContext);
        this.mContext = applicationContext;
    }
}
