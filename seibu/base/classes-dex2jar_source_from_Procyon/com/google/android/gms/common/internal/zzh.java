// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.util.Log;
import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzh extends Handler
{
    private /* synthetic */ zzd zzaHe;
    
    public zzh(final zzd zzaHe, final Looper looper) {
        this.zzaHe = zzaHe;
        super(looper);
    }
    
    private static void zza(final Message message) {
        ((zzi)message.obj).unregister();
    }
    
    private static boolean zzb(final Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }
    
    public final void handleMessage(final Message message) {
        PendingIntent pendingIntent = null;
        if (this.zzaHe.zzaHb.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
            return;
        }
        if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.zzaHe.isConnecting()) {
            zza(message);
            return;
        }
        if (message.what == 4) {
            this.zzaHe.zzaGZ = new ConnectionResult(message.arg2);
            if (this.zzaHe.zzri() && !this.zzaHe.zzaHa) {
                zzd.zza(this.zzaHe, 3, null);
                return;
            }
            ConnectionResult zzd;
            if (this.zzaHe.zzaGZ != null) {
                zzd = this.zzaHe.zzaGZ;
            }
            else {
                zzd = new ConnectionResult(8);
            }
            this.zzaHe.zzaGQ.zzf(zzd);
            this.zzaHe.onConnectionFailed(zzd);
        }
        else {
            if (message.what == 5) {
                ConnectionResult zzd2;
                if (this.zzaHe.zzaGZ != null) {
                    zzd2 = this.zzaHe.zzaGZ;
                }
                else {
                    zzd2 = new ConnectionResult(8);
                }
                this.zzaHe.zzaGQ.zzf(zzd2);
                this.zzaHe.onConnectionFailed(zzd2);
                return;
            }
            if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent)message.obj;
                }
                final ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.zzaHe.zzaGQ.zzf(connectionResult);
                this.zzaHe.onConnectionFailed(connectionResult);
                return;
            }
            if (message.what == 6) {
                zzd.zza(this.zzaHe, 5, null);
                if (this.zzaHe.zzaGV != null) {
                    this.zzaHe.zzaGV.onConnectionSuspended(message.arg2);
                }
                this.zzaHe.onConnectionSuspended(message.arg2);
                this.zzaHe.zza(5, 1, null);
                return;
            }
            if (message.what == 2 && !this.zzaHe.isConnected()) {
                zza(message);
                return;
            }
            if (zzb(message)) {
                ((zzi)message.obj).zzrk();
                return;
            }
            Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), (Throwable)new Exception());
        }
    }
}
