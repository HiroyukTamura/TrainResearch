package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbab;
import com.google.android.gms.internal.ads.zzcm;
import com.google.android.gms.internal.ads.zzdf;
import com.google.android.gms.internal.ads.zzdj;
import com.google.android.gms.internal.ads.zzdu;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzzz;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class zzh implements zzdj, Runnable {
    private final List<Object[]> zzbmi = new Vector();
    private final AtomicReference<zzdj> zzbmj = new AtomicReference<>();
    private final AtomicReference<zzdj> zzbmk = new AtomicReference<>();
    private zzazz zzbml;
    private CountDownLatch zzbmm = new CountDownLatch(1);
    private Context zzvf;
    private final int zzwg;

    public zzh(Context context, zzazz zzazz) {
        this.zzvf = context;
        this.zzbml = zzazz;
        int intValue = ((Integer) zzvj.zzpv().zzd(zzzz.zzcnm)).intValue();
        this.zzwg = intValue != 1 ? intValue != 2 ? zzcm.zzmx : zzcm.zzmz : zzcm.zzmy;
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcod)).booleanValue()) {
            zzvj.zzpr();
            if (!zzazm.zzye()) {
                run();
                return;
            }
        }
        zzbab.zzdzr.execute(this);
    }

    @Nullable
    private final zzdj zzcb() {
        return (this.zzwg == zzcm.zzmy ? this.zzbmk : this.zzbmj).get();
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean zzka() {
        try {
            this.zzbmm.await();
            return true;
        } catch (InterruptedException e) {
            zzazw.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzkb() {
        zzdj zzcb = zzcb();
        if (!this.zzbmi.isEmpty() && zzcb != null) {
            for (Object[] next : this.zzbmi) {
                if (next.length == 1) {
                    zzcb.zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    zzcb.zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzbmi.clear();
        }
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbml.zzdzp;
            if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcls)).booleanValue() && z2) {
                z = true;
            }
            if (this.zzwg != zzcm.zzmy) {
                this.zzbmj.set(zzdu.zzb(this.zzbml.zzbnd, zze(this.zzvf), z, this.zzwg));
            }
            if (this.zzwg != zzcm.zzmx) {
                this.zzbmk.set(zzdf.zza(this.zzbml.zzbnd, zze(this.zzvf), z));
            }
        } finally {
            this.zzbmm.countDown();
            this.zzvf = null;
            this.zzbml = null;
        }
    }

    public final String zza(Context context, View view, Activity activity) {
        zzdj zzcb = zzcb();
        return zzcb != null ? zzcb.zza(context, view, activity) : "";
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        zzdj zzcb;
        if (!zzka() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzkb();
        return zzcb.zza(zze(context), str, view, activity);
    }

    public final void zza(int i, int i2, int i3) {
        zzdj zzcb = zzcb();
        if (zzcb != null) {
            zzkb();
            zzcb.zza(i, i2, i3);
            return;
        }
        this.zzbmi.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zza(MotionEvent motionEvent) {
        zzdj zzcb = zzcb();
        if (zzcb != null) {
            zzkb();
            zzcb.zza(motionEvent);
            return;
        }
        this.zzbmi.add(new Object[]{motionEvent});
    }

    public final String zzb(Context context) {
        if (!zzka()) {
            return "";
        }
        int i = this.zzwg;
        zzdj zzdj = ((i == zzcm.zzmy || i == zzcm.zzmz) ? this.zzbmk : this.zzbmj).get();
        if (zzdj == null) {
            return "";
        }
        zzkb();
        return zzdj.zzb(zze(context));
    }

    public final void zzb(View view) {
        zzdj zzcb = zzcb();
        if (zzcb != null) {
            zzcb.zzb(view);
        }
    }
}
