// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.internal.zzbo;

public final class zzcgb
{
    private String mValue;
    private final String zzBN;
    private boolean zzbrE;
    private /* synthetic */ zzcfw zzbrF;
    private final String zzbrK;
    
    public zzcgb(final zzcfw zzbrF, final String zzBN, final String s) {
        this.zzbrF = zzbrF;
        zzbo.zzcF(zzBN);
        this.zzBN = zzBN;
        this.zzbrK = null;
    }
    
    @WorkerThread
    public final void zzef(final String mValue) {
        if (zzcjl.zzR(mValue, this.mValue)) {
            return;
        }
        final SharedPreferences$Editor edit = this.zzbrF.zzaix.edit();
        edit.putString(this.zzBN, mValue);
        edit.apply();
        this.mValue = mValue;
    }
    
    @WorkerThread
    public final String zzyL() {
        if (!this.zzbrE) {
            this.zzbrE = true;
            this.mValue = this.zzbrF.zzaix.getString(this.zzBN, (String)null);
        }
        return this.mValue;
    }
}
