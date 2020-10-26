// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.util.Log;
import android.content.Intent;

final class zze implements Runnable
{
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ zzd zzckl;
    
    zze(final zzd zzckl, final Intent val$intent) {
        this.zzckl = zzckl;
        this.val$intent = val$intent;
    }
    
    @Override
    public final void run() {
        final String value = String.valueOf(this.val$intent.getAction());
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(value).length() + 61).append("Service took too long to process intent: ").append(value).append(" App may get closed.").toString());
        this.zzckl.finish();
    }
}
