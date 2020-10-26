// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.SharedPreferences$Editor;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbo;

public final class zzcfz
{
    private final String zzBN;
    private long zzaeZ;
    private boolean zzbrE;
    private /* synthetic */ zzcfw zzbrF;
    private final long zzbrG;
    
    public zzcfz(final zzcfw zzbrF, final String zzBN, final long zzbrG) {
        this.zzbrF = zzbrF;
        zzbo.zzcF(zzBN);
        this.zzBN = zzBN;
        this.zzbrG = zzbrG;
    }
    
    @WorkerThread
    public final long get() {
        if (!this.zzbrE) {
            this.zzbrE = true;
            this.zzaeZ = this.zzbrF.zzaix.getLong(this.zzBN, this.zzbrG);
        }
        return this.zzaeZ;
    }
    
    @WorkerThread
    public final void set(final long zzaeZ) {
        final SharedPreferences$Editor edit = this.zzbrF.zzaix.edit();
        edit.putLong(this.zzBN, zzaeZ);
        edit.apply();
        this.zzaeZ = zzaeZ;
    }
}
