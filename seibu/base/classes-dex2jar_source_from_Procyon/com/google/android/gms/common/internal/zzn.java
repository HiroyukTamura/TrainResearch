// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.util.Log;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import android.support.annotation.BinderThread;
import android.os.Bundle;
import android.os.IBinder;

public final class zzn extends zze
{
    private /* synthetic */ zzd zzaHe;
    private IBinder zzaHi;
    
    @BinderThread
    public zzn(final zzd zzaHe, final int n, final IBinder zzaHi, final Bundle bundle) {
        this.zzaHe = zzaHe;
        super(zzaHe, n, bundle);
        this.zzaHi = zzaHi;
    }
    
    @Override
    protected final void zzj(final ConnectionResult connectionResult) {
        if (this.zzaHe.zzaGW != null) {
            this.zzaHe.zzaGW.onConnectionFailed(connectionResult);
        }
        this.zzaHe.onConnectionFailed(connectionResult);
    }
    
    @Override
    protected final boolean zzrj() {
        while (true) {
            try {
                final String interfaceDescriptor = this.zzaHi.getInterfaceDescriptor();
                if (!this.zzaHe.zzdc().equals(interfaceDescriptor)) {
                    final String value = String.valueOf(this.zzaHe.zzdc());
                    Log.e("GmsClient", new StringBuilder(String.valueOf(value).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(value).append(" vs. ").append(interfaceDescriptor).toString());
                    return false;
                }
            }
            catch (RemoteException ex) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
            final IInterface zzd = this.zzaHe.zzd(this.zzaHi);
            if (zzd != null && (this.zzaHe.zza(2, 4, zzd) || this.zzaHe.zza(3, 4, zzd))) {
                break;
            }
            return false;
        }
        this.zzaHe.zzaGZ = null;
        final Bundle zzoC = this.zzaHe.zzoC();
        if (this.zzaHe.zzaGV != null) {
            this.zzaHe.zzaGV.onConnected(zzoC);
        }
        return true;
    }
}
