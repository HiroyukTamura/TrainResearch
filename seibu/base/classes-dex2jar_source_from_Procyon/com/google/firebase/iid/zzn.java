// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class zzn extends BroadcastReceiver
{
    private /* synthetic */ zzl zzckJ;
    
    zzn(final zzl zzckJ) {
        this.zzckJ = zzckJ;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            final String value = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(value).length() + 44).append("Received GSF callback via dynamic receiver: ").append(value).toString());
        }
        this.zzckJ.zzi(intent);
    }
}
