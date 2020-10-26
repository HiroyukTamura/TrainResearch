// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Context;

public final class zzbha
{
    private static zzbha zzaKk;
    private zzbgz zzaKj;
    
    static {
        zzbha.zzaKk = new zzbha();
    }
    
    public zzbha() {
        this.zzaKj = null;
    }
    
    private final zzbgz zzaO(Context applicationContext) {
        synchronized (this) {
            if (this.zzaKj == null) {
                if (applicationContext.getApplicationContext() != null) {
                    applicationContext = applicationContext.getApplicationContext();
                }
                this.zzaKj = new zzbgz(applicationContext);
            }
            return this.zzaKj;
        }
    }
    
    public static zzbgz zzaP(final Context context) {
        return zzbha.zzaKk.zzaO(context);
    }
}
