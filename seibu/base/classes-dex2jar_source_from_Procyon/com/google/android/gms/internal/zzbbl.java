// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzbbl implements Runnable
{
    private /* synthetic */ zzbbk zzaCx;
    
    zzbbl(final zzbbk zzaCx) {
        this.zzaCx = zzaCx;
    }
    
    @Override
    public final void run() {
        this.zzaCx.zzaCv.lock();
        try {
            this.zzaCx.zzpF();
        }
        finally {
            this.zzaCx.zzaCv.unlock();
        }
    }
}
