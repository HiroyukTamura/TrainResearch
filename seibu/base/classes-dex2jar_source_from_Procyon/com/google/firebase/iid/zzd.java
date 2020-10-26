// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import android.content.BroadcastReceiver$PendingResult;
import android.content.Intent;

final class zzd
{
    final Intent intent;
    private final BroadcastReceiver$PendingResult zzcki;
    private boolean zzckj;
    private final ScheduledFuture<?> zzckk;
    
    zzd(final Intent intent, final BroadcastReceiver$PendingResult zzcki, final ScheduledExecutorService scheduledExecutorService) {
        this.zzckj = false;
        this.intent = intent;
        this.zzcki = zzcki;
        this.zzckk = scheduledExecutorService.schedule(new zze(this, intent), 9500L, TimeUnit.MILLISECONDS);
    }
    
    final void finish() {
        synchronized (this) {
            if (!this.zzckj) {
                this.zzcki.finish();
                this.zzckk.cancel(false);
                this.zzckj = true;
            }
        }
    }
}
