// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzal;
import java.util.Collections;
import com.google.android.gms.common.ConnectionResult;

final class zzbdi implements Runnable
{
    private /* synthetic */ ConnectionResult zzaEw;
    private /* synthetic */ zzbdh zzaEy;
    
    zzbdi(final zzbdh zzaEy, final ConnectionResult zzaEw) {
        this.zzaEy = zzaEy;
        this.zzaEw = zzaEw;
    }
    
    @Override
    public final void run() {
        if (!this.zzaEw.isSuccess()) {
            this.zzaEy.zzaEm.zzaCB.get(this.zzaEy.zzaAK).onConnectionFailed(this.zzaEw);
            return;
        }
        zzbdh.zza(this.zzaEy, true);
        if (this.zzaEy.zzaCy.zzmv()) {
            this.zzaEy.zzqz();
            return;
        }
        this.zzaEy.zzaCy.zza(null, Collections.emptySet());
    }
}
