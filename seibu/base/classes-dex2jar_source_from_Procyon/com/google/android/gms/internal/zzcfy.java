// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.SharedPreferences$Editor;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbo;

public final class zzcfy
{
    private final String zzBN;
    private boolean zzaAI;
    private final boolean zzbrD;
    private boolean zzbrE;
    private /* synthetic */ zzcfw zzbrF;
    
    public zzcfy(final zzcfw zzbrF, final String zzBN, final boolean b) {
        this.zzbrF = zzbrF;
        zzbo.zzcF(zzBN);
        this.zzBN = zzBN;
        this.zzbrD = true;
    }
    
    @WorkerThread
    public final boolean get() {
        if (!this.zzbrE) {
            this.zzbrE = true;
            this.zzaAI = this.zzbrF.zzaix.getBoolean(this.zzBN, this.zzbrD);
        }
        return this.zzaAI;
    }
    
    @WorkerThread
    public final void set(final boolean zzaAI) {
        final SharedPreferences$Editor edit = this.zzbrF.zzaix.edit();
        edit.putBoolean(this.zzBN, zzaAI);
        edit.apply();
        this.zzaAI = zzaAI;
    }
}
