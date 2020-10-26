// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.Context;

public abstract class zzae
{
    private static final Object zzaHL;
    private static zzae zzaHM;
    
    static {
        zzaHL = new Object();
    }
    
    public static zzae zzaC(final Context context) {
        synchronized (zzae.zzaHL) {
            if (zzae.zzaHM == null) {
                zzae.zzaHM = new zzag(context.getApplicationContext());
            }
            return zzae.zzaHM;
        }
    }
    
    public final void zza(final String s, final String s2, final ServiceConnection serviceConnection, final String s3) {
        this.zzb(new zzaf(s, s2), serviceConnection, s3);
    }
    
    public final boolean zza(final ComponentName componentName, final ServiceConnection serviceConnection, final String s) {
        return this.zza(new zzaf(componentName), serviceConnection, s);
    }
    
    protected abstract boolean zza(final zzaf p0, final ServiceConnection p1, final String p2);
    
    public final void zzb(final ComponentName componentName, final ServiceConnection serviceConnection, final String s) {
        this.zzb(new zzaf(componentName), serviceConnection, s);
    }
    
    protected abstract void zzb(final zzaf p0, final ServiceConnection p1, final String p2);
}
