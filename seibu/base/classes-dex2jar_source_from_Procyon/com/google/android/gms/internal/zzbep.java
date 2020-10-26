// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;

final class zzbep implements Runnable
{
    private /* synthetic */ String zzO;
    private /* synthetic */ zzbds zzaEK;
    private /* synthetic */ zzbeo zzaEZ;
    
    zzbep(final zzbeo zzaEZ, final zzbds zzaEK, final String zzO) {
        this.zzaEZ = zzaEZ;
        this.zzaEK = zzaEK;
        this.zzO = zzO;
    }
    
    @Override
    public final void run() {
        if (this.zzaEZ.zzLe > 0) {
            final zzbds zzaEK = this.zzaEK;
            Bundle bundle;
            if (this.zzaEZ.zzaEJ != null) {
                bundle = this.zzaEZ.zzaEJ.getBundle(this.zzO);
            }
            else {
                bundle = null;
            }
            zzaEK.onCreate(bundle);
        }
        if (this.zzaEZ.zzLe >= 2) {
            this.zzaEK.onStart();
        }
        if (this.zzaEZ.zzLe >= 3) {
            this.zzaEK.onResume();
        }
        if (this.zzaEZ.zzLe >= 4) {
            this.zzaEK.onStop();
        }
        if (this.zzaEZ.zzLe >= 5) {
            this.zzaEK.onDestroy();
        }
    }
}
