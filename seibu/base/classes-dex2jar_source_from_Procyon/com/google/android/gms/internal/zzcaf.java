// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzcaf
{
    private static zzcaf zzaXH;
    private final zzcaa zzaXI;
    private final zzcab zzaXJ;
    
    static {
        final zzcaf zzaXH = new zzcaf();
        synchronized (zzcaf.class) {
            zzcaf.zzaXH = zzaXH;
        }
    }
    
    private zzcaf() {
        this.zzaXI = new zzcaa();
        this.zzaXJ = new zzcab();
    }
    
    private static zzcaf zzua() {
        synchronized (zzcaf.class) {
            return zzcaf.zzaXH;
        }
    }
    
    public static zzcaa zzub() {
        return zzua().zzaXI;
    }
    
    public static zzcab zzuc() {
        return zzua().zzaXJ;
    }
}
