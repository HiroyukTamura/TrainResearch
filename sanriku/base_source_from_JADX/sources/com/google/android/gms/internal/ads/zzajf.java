package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;

public final class zzajf {
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public int status;
    private final zzazz zzbmo;
    private final String zzdcp;
    /* access modifiers changed from: private */
    public zzayf<zzais> zzdcq;
    private zzayf<zzais> zzdcr;
    /* access modifiers changed from: private */
    @Nullable
    public zzajw zzdcs;
    private final Context zzvf;

    public zzajf(Context context, zzazz zzazz, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdcp = str;
        this.zzvf = context.getApplicationContext();
        this.zzbmo = zzazz;
        this.zzdcq = new zzajt();
        this.zzdcr = new zzajt();
    }

    public zzajf(Context context, zzazz zzazz, String str, zzayf<zzais> zzayf, zzayf<zzais> zzayf2) {
        this(context, zzazz, str);
        this.zzdcq = zzayf;
        this.zzdcr = zzayf2;
    }

    /* access modifiers changed from: protected */
    public final zzajw zza(@Nullable zzdt zzdt) {
        zzajw zzajw = new zzajw(this.zzdcr);
        zzbab.zzdzv.execute(new zzaje(this, zzdt, zzajw));
        zzajw.zza(new zzajo(this, zzajw), new zzajr(this, zzajw));
        return zzajw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzais zzais) {
        if (zzais.isDestroyed()) {
            this.status = 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzajw r4, com.google.android.gms.internal.ads.zzais r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzdrh r4 = com.google.android.gms.internal.ads.zzbab.zzdzv     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzajl.zzb(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.ads.zzawr.zzeg(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajf.zza(com.google.android.gms.internal.ads.zzajw, com.google.android.gms.internal.ads.zzais):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdt zzdt, zzajw zzajw) {
        try {
            Context context = this.zzvf;
            zzazz zzazz = this.zzbmo;
            zzais zzaie = zzabz.zzcyc.get().booleanValue() ? new zzaie(context, zzazz) : new zzaiu(context, zzazz, zzdt, (zza) null);
            zzaie.zza(new zzajj(this, zzajw, zzaie));
            zzaie.zza("/jsLoaded", new zzajk(this, zzajw, zzaie));
            zzazb zzazb = new zzazb();
            zzajn zzajn = new zzajn(this, zzdt, zzaie, zzazb);
            zzazb.set(zzajn);
            zzaie.zza("/requestReload", zzajn);
            if (this.zzdcp.endsWith(".js")) {
                zzaie.zzcx(this.zzdcp);
            } else if (this.zzdcp.startsWith("<html>")) {
                zzaie.zzcy(this.zzdcp);
            } else {
                zzaie.zzcz(this.zzdcp);
            }
            zzaxa.zzdwf.postDelayed(new zzajm(this, zzajw, zzaie), (long) zzajq.zzddd);
        } catch (Throwable th) {
            zzazw.zzc("Error creating webview.", th);
            zzq.zzla().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzajw.reject();
        }
    }

    public final zzajs zzb(@Nullable zzdt zzdt) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdcs != null && this.status == 0) {
                    this.zzdcs.zza(new zzajh(this), zzajg.zzdct);
                }
            }
            if (this.zzdcs != null) {
                if (this.zzdcs.getStatus() != -1) {
                    if (this.status == 0) {
                        zzajs zzsx = this.zzdcs.zzsx();
                        return zzsx;
                    } else if (this.status == 1) {
                        this.status = 2;
                        zza((zzdt) null);
                        zzajs zzsx2 = this.zzdcs.zzsx();
                        return zzsx2;
                    } else if (this.status == 2) {
                        zzajs zzsx3 = this.zzdcs.zzsx();
                        return zzsx3;
                    } else {
                        zzajs zzsx4 = this.zzdcs.zzsx();
                        return zzsx4;
                    }
                }
            }
            this.status = 2;
            zzajw zza = zza((zzdt) null);
            this.zzdcs = zza;
            zzajs zzsx5 = zza.zzsx();
            return zzsx5;
        }
    }
}
