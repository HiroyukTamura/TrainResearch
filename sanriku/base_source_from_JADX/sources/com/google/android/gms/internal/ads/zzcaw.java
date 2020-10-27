package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcaw implements View.OnClickListener {
    private final Clock zzbnt;
    private final zzcdt zzftu;
    @Nullable
    private zzaer zzftv;
    @Nullable
    private zzaga<Object> zzftw;
    @VisibleForTesting
    @Nullable
    String zzftx;
    @VisibleForTesting
    @Nullable
    Long zzfty;
    @VisibleForTesting
    @Nullable
    WeakReference<View> zzftz;

    public zzcaw(zzcdt zzcdt, Clock clock) {
        this.zzftu = zzcdt;
        this.zzbnt = clock;
    }

    private final void zzamg() {
        View view;
        this.zzftx = null;
        this.zzfty = null;
        WeakReference<View> weakReference = this.zzftz;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzftz = null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzftv != null && this.zzfty != null) {
            zzamg();
            try {
                this.zzftv.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzftz;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zzftx == null || this.zzfty == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzftx);
                hashMap.put("time_interval", String.valueOf(this.zzbnt.currentTimeMillis() - this.zzfty.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzftu.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            zzamg();
        }
    }

    public final void zza(zzaer zzaer) {
        this.zzftv = zzaer;
        zzaga<Object> zzaga = this.zzftw;
        if (zzaga != null) {
            this.zzftu.zzb("/unconfirmedClick", zzaga);
        }
        zzcaz zzcaz = new zzcaz(this, zzaer);
        this.zzftw = zzcaz;
        this.zzftu.zza("/unconfirmedClick", (zzaga<Object>) zzcaz);
    }

    @Nullable
    public final zzaer zzamf() {
        return this.zzftv;
    }
}
