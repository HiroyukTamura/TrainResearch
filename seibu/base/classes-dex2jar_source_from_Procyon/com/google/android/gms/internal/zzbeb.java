// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.CancellationException;
import com.google.android.gms.tasks.Task;
import android.app.Activity;
import com.google.android.gms.tasks.TaskCompletionSource;

public class zzbeb extends zzbba
{
    private TaskCompletionSource<Void> zzalE;
    
    private zzbeb(final zzbdt zzbdt) {
        super(zzbdt);
        this.zzalE = new TaskCompletionSource<Void>();
        this.zzaEG.zza("GmsAvailabilityHelper", this);
    }
    
    public static zzbeb zzp(final Activity activity) {
        final zzbdt zzn = zzbds.zzn(activity);
        final zzbeb zzbeb = zzn.zza("GmsAvailabilityHelper", zzbeb.class);
        if (zzbeb != null) {
            if (zzbeb.zzalE.getTask().isComplete()) {
                zzbeb.zzalE = new TaskCompletionSource<Void>();
            }
            return zzbeb;
        }
        return new zzbeb(zzn);
    }
    
    public final Task<Void> getTask() {
        return this.zzalE.getTask();
    }
    
    @Override
    public final void onDestroy() {
        super.onDestroy();
        this.zzalE.setException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }
    
    @Override
    protected final void zza(final ConnectionResult connectionResult, final int n) {
        this.zzalE.setException(zzb.zzx(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution())));
    }
    
    @Override
    protected final void zzps() {
        final int googlePlayServicesAvailable = this.zzaBd.isGooglePlayServicesAvailable((Context)this.zzaEG.zzqF());
        if (googlePlayServicesAvailable == 0) {
            this.zzalE.setResult(null);
        }
        else if (!this.zzalE.getTask().isComplete()) {
            this.zzb(new ConnectionResult(googlePlayServicesAvailable, null), 0);
        }
    }
}
