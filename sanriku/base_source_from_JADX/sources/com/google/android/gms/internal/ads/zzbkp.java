package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzbkp implements zzo, zzbrp, zzbrs, zzpz {
    private final Clock zzbnt;
    private final zzbkg zzfhe;
    private final zzbkn zzfhf;
    private final Set<zzbek> zzfhg = new HashSet();
    private final zzalb<JSONObject, JSONObject> zzfhh;
    private final Executor zzfhi;
    private final AtomicBoolean zzfhj = new AtomicBoolean(false);
    private final zzbkr zzfhk = new zzbkr();
    private boolean zzfhl = false;
    private WeakReference<?> zzfhm = new WeakReference<>(this);

    public zzbkp(zzaku zzaku, zzbkn zzbkn, Executor executor, zzbkg zzbkg, Clock clock) {
        this.zzfhe = zzbkg;
        zzakl<JSONObject> zzakl = zzakk.zzddu;
        this.zzfhh = zzaku.zzb("google.afma.activeView.handleUpdate", zzakl, zzakl);
        this.zzfhf = zzbkn;
        this.zzfhi = executor;
        this.zzbnt = clock;
    }

    private final void zzagn() {
        for (zzbek zze : this.zzfhg) {
            this.zzfhe.zze(zze);
        }
        this.zzfhe.zzagl();
    }

    public final synchronized void onAdImpression() {
        if (this.zzfhj.compareAndSet(false, true)) {
            this.zzfhe.zza(this);
            zzagm();
        }
    }

    public final synchronized void onPause() {
        this.zzfhk.zzfhr = true;
        zzagm();
    }

    public final synchronized void onResume() {
        this.zzfhk.zzfhr = false;
        zzagm();
    }

    public final synchronized void zza(zzqa zzqa) {
        this.zzfhk.zzbot = zzqa.zzbot;
        this.zzfhk.zzfhu = zzqa;
        zzagm();
    }

    public final synchronized void zzagm() {
        if (!(this.zzfhm.get() != null)) {
            zzago();
        } else if (!this.zzfhl && this.zzfhj.get()) {
            try {
                this.zzfhk.timestamp = this.zzbnt.elapsedRealtime();
                JSONObject zza = this.zzfhf.zzj(this.zzfhk);
                for (zzbek zzbko : this.zzfhg) {
                    this.zzfhi.execute(new zzbko(zzbko, zza));
                }
                zzbaf.zzb(this.zzfhh.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzawr.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    public final synchronized void zzago() {
        zzagn();
        this.zzfhl = true;
    }

    public final synchronized void zzbx(@Nullable Context context) {
        this.zzfhk.zzfhr = true;
        zzagm();
    }

    public final synchronized void zzby(@Nullable Context context) {
        this.zzfhk.zzfhr = false;
        zzagm();
    }

    public final synchronized void zzbz(@Nullable Context context) {
        this.zzfhk.zzfht = "u";
        zzagm();
        zzagn();
        this.zzfhl = true;
    }

    public final synchronized void zzf(zzbek zzbek) {
        this.zzfhg.add(zzbek);
        this.zzfhe.zzd(zzbek);
    }

    public final void zzo(Object obj) {
        this.zzfhm = new WeakReference<>(obj);
    }

    public final void zztz() {
    }

    public final void zzua() {
    }
}
