// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import android.support.annotation.BinderThread;
import android.os.Bundle;

abstract class zze extends zzi<Boolean>
{
    private int statusCode;
    private Bundle zzaHd;
    private /* synthetic */ zzd zzaHe;
    
    @BinderThread
    protected zze(final zzd zzaHe, final int statusCode, final Bundle zzaHd) {
        this.zzaHe = zzaHe;
        super(true);
        this.statusCode = statusCode;
        this.zzaHd = zzaHd;
    }
    
    protected abstract void zzj(final ConnectionResult p0);
    
    protected abstract boolean zzrj();
}
