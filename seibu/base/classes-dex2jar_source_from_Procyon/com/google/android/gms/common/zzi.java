// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzi extends zzg
{
    private static final WeakReference<byte[]> zzaAj;
    private WeakReference<byte[]> zzaAi;
    
    static {
        zzaAj = new WeakReference<byte[]>(null);
    }
    
    zzi(final byte[] array) {
        super(array);
        this.zzaAi = zzi.zzaAj;
    }
    
    @Override
    final byte[] getBytes() {
        synchronized (this) {
            byte[] zzpa;
            if ((zzpa = this.zzaAi.get()) == null) {
                zzpa = this.zzpa();
                this.zzaAi = new WeakReference<byte[]>(zzpa);
            }
            return zzpa;
        }
    }
    
    protected abstract byte[] zzpa();
}
