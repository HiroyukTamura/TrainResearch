// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.util.Log;
import android.os.Process;
import android.os.Binder;

public final class zzf extends Binder
{
    private final zzb zzckm;
    
    zzf(final zzb zzckm) {
        this.zzckm = zzckm;
    }
    
    public final void zza(final zzd zzd) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "service received new intent via bind strategy");
        }
        if (this.zzckm.zzo(zzd.intent)) {
            zzd.finish();
            return;
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
        }
        this.zzckm.zzbrV.execute(new zzg(this, zzd));
    }
}
