// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;

final class zzbdv implements Runnable
{
    private /* synthetic */ String zzO;
    private /* synthetic */ zzbds zzaEK;
    private /* synthetic */ zzbdu zzaEL;
    
    zzbdv(final zzbdu zzaEL, final zzbds zzaEK, final String zzO) {
        this.zzaEL = zzaEL;
        this.zzaEK = zzaEK;
        this.zzO = zzO;
    }
    
    @Override
    public final void run() {
        if (this.zzaEL.zzLe > 0) {
            final zzbds zzaEK = this.zzaEK;
            Bundle bundle;
            if (this.zzaEL.zzaEJ != null) {
                bundle = this.zzaEL.zzaEJ.getBundle(this.zzO);
            }
            else {
                bundle = null;
            }
            zzaEK.onCreate(bundle);
        }
        if (this.zzaEL.zzLe >= 2) {
            this.zzaEK.onStart();
        }
        if (this.zzaEL.zzLe >= 3) {
            this.zzaEK.onResume();
        }
        if (this.zzaEL.zzLe >= 4) {
            this.zzaEK.onStop();
        }
        if (this.zzaEL.zzLe >= 5) {
            this.zzaEK.onDestroy();
        }
    }
}
