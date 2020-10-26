// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class aem extends adp
{
    private static volatile aem[] zzcum;
    public String zzcun;
    
    public aem() {
        this.zzcun = "";
        this.zzcsx = -1;
    }
    
    public static aem[] zzMh() {
        Label_0027: {
            if (aem.zzcum != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (aem.zzcum == null) {
                    aem.zzcum = new aem[0];
                }
                return aem.zzcum;
            }
        }
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzcun != null && !this.zzcun.equals("")) {
            adh.zzl(1, this.zzcun);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzcun != null) {
            zzn = n;
            if (!this.zzcun.equals("")) {
                zzn = n + adh.zzm(1, this.zzcun);
            }
        }
        return zzn;
    }
}
