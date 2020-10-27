package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class zzbws extends zzbns {
    private final WeakReference<zzbek> zzfor;
    private final zzbvg zzfos;
    private final zzbxz zzfot;
    private final zzbom zzfou;
    private final zzdly zzfov;
    private final zzbre zzfow;
    private boolean zzfox = false;
    private final Context zzvf;

    zzbws(zzbnv zzbnv, Context context, zzbek zzbek, zzbvg zzbvg, zzbxz zzbxz, zzbom zzbom, zzdly zzdly, zzbre zzbre) {
        super(zzbnv);
        this.zzvf = context;
        this.zzfor = new WeakReference<>(zzbek);
        this.zzfos = zzbvg;
        this.zzfot = zzbxz;
        this.zzfou = zzbom;
        this.zzfov = zzdly;
        this.zzfow = zzbre;
    }

    public final void finalize() throws Throwable {
        try {
            zzbek zzbek = (zzbek) this.zzfor.get();
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcty)).booleanValue()) {
                if (!this.zzfox && zzbek != null) {
                    zzdrh zzdrh = zzbab.zzdzv;
                    zzbek.getClass();
                    zzdrh.execute(zzbwv.zzh(zzbek));
                }
            } else if (zzbek != null) {
                zzbek.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        return this.zzfou.isClosed();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbi(boolean r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcla
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.ads.internal.zzq.zzkw()
            android.content.Context r0 = r4.zzvf
            boolean r0 = com.google.android.gms.internal.ads.zzaxa.zzau(r0)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)
            com.google.android.gms.internal.ads.zzbre r0 = r4.zzfow
            r0.zzais()
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzclb
            com.google.android.gms.internal.ads.zzzv r3 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzdly r0 = r4.zzfov
            com.google.android.gms.internal.ads.zzdha r3 = r4.zzfgj
            com.google.android.gms.internal.ads.zzdgy r3 = r3.zzgus
            com.google.android.gms.internal.ads.zzdgq r3 = r3.zzgup
            java.lang.String r3 = r3.zzdoh
            r0.zzgz(r3)
            goto L_0x004f
        L_0x0049:
            boolean r0 = r4.zzfox
            if (r0 != 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0053
            return r2
        L_0x0053:
            com.google.android.gms.internal.ads.zzbvg r0 = r4.zzfos
            r0.zzajn()
            com.google.android.gms.internal.ads.zzbxz r0 = r4.zzfot     // Catch:{ zzbxy -> 0x0062 }
            android.content.Context r3 = r4.zzvf     // Catch:{ zzbxy -> 0x0062 }
            r0.zza(r5, r3)     // Catch:{ zzbxy -> 0x0062 }
            r4.zzfox = r1
            return r1
        L_0x0062:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbre r0 = r4.zzfow
            r0.zza(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbws.zzbi(boolean):boolean");
    }
}
