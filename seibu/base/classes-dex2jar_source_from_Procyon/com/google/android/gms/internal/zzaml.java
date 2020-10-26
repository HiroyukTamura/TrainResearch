// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.content.Context;

public final class zzaml
{
    private final Context mApplicationContext;
    private final Context zzagb;
    
    public zzaml(Context applicationContext) {
        zzbo.zzu(applicationContext);
        applicationContext = applicationContext.getApplicationContext();
        zzbo.zzb(applicationContext, "Application context can't be null");
        this.mApplicationContext = applicationContext;
        this.zzagb = applicationContext;
    }
    
    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }
    
    public final Context zzkE() {
        return this.zzagb;
    }
}
