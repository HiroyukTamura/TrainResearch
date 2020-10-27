package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

public abstract class zzckt implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final Object mLock = new Object();
    protected final zzbaj<InputStream> zzdej = new zzbaj<>();
    protected boolean zzgbr = false;
    protected boolean zzgbs = false;
    protected zzarj zzgbt;
    @VisibleForTesting(otherwise = 3)
    @GuardedBy("mLock")
    protected zzaqr zzgbu;

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzazw.zzed("Disconnected from remote ad request service.");
        this.zzdej.setException(new zzclc(0));
    }

    public void onConnectionSuspended(int i) {
        zzazw.zzed("Cannot connect to remote service, fallback to local instance.");
    }

    /* access modifiers changed from: protected */
    public final void zzaot() {
        synchronized (this.mLock) {
            this.zzgbs = true;
            if (this.zzgbu.isConnected() || this.zzgbu.isConnecting()) {
                this.zzgbu.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
