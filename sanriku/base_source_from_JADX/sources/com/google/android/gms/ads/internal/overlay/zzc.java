package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzbek;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzzz;
import java.util.Collections;

public class zzc extends zzapf implements zzy {
    @VisibleForTesting
    private static final int zzdjp = Color.argb(0, 0, 0, 0);
    protected final Activity zzaad;
    @VisibleForTesting
    private boolean zzblz = false;
    @VisibleForTesting
    zzbek zzdce;
    @VisibleForTesting
    AdOverlayInfoParcel zzdjq;
    @VisibleForTesting
    private zzi zzdjr;
    @VisibleForTesting
    private zzq zzdjs;
    @VisibleForTesting
    private boolean zzdjt = false;
    @VisibleForTesting
    private FrameLayout zzdju;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdjv;
    @VisibleForTesting
    private boolean zzdjw = false;
    @VisibleForTesting
    private zzj zzdjx;
    @VisibleForTesting
    private boolean zzdjy = false;
    @VisibleForTesting
    int zzdjz = 0;
    private final Object zzdka = new Object();
    private Runnable zzdkb;
    private boolean zzdkc;
    private boolean zzdkd;
    private boolean zzdke = false;
    private boolean zzdkf = false;
    private boolean zzdkg = true;

    public zzc(Activity activity) {
        this.zzaad = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzdla;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzdjq
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzg r0 = r0.zzdla
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzbma
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.gms.internal.ads.zzaxf r3 = com.google.android.gms.ads.internal.zzq.zzky()
            android.app.Activity r4 = r5.zzaad
            boolean r6 = r3.zza((android.app.Activity) r4, (android.content.res.Configuration) r6)
            boolean r3 = r5.zzblz
            if (r3 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0031
        L_0x0021:
            if (r6 != 0) goto L_0x0031
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzdjq
            if (r6 == 0) goto L_0x0032
            com.google.android.gms.ads.internal.zzg r6 = r6.zzdla
            if (r6 == 0) goto L_0x0032
            boolean r6 = r6.zzbmf
            if (r6 == 0) goto L_0x0032
            r2 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            android.app.Activity r6 = r5.zzaad
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzclw
            com.google.android.gms.internal.ads.zzzv r3 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005c
            android.view.View r6 = r6.getDecorView()
            r0 = 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0058
            r0 = 5380(0x1504, float:7.539E-42)
            if (r2 == 0) goto L_0x0058
            r0 = 5894(0x1706, float:8.259E-42)
        L_0x0058:
            r6.setSystemUiVisibility(r0)
            return
        L_0x005c:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0074
            r6.addFlags(r0)
            r6.clearFlags(r3)
            if (r2 == 0) goto L_0x007a
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
            return
        L_0x0074:
            r6.addFlags(r3)
            r6.clearFlags(r0)
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zza(android.content.res.Configuration):void");
    }

    private final void zzai(boolean z) {
        int intValue = ((Integer) zzvj.zzpv().zzd(zzzz.zzcqp)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzdjs = new zzq(this.zzaad, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdjq.zzdkv);
        this.zzdjx.addView(this.zzdjs, layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r1.zzaad.getResources().getConfiguration().orientation == 1) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r1.zzaad.getResources().getConfiguration().orientation == 2) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaj(boolean r20) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            r19 = this;
            r1 = r19
            boolean r0 = r1.zzdkd
            r2 = 1
            if (r0 != 0) goto L_0x000c
            android.app.Activity r0 = r1.zzaad
            r0.requestWindowFeature(r2)
        L_0x000c:
            android.app.Activity r0 = r1.zzaad
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x01db
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzdjq
            com.google.android.gms.internal.ads.zzbek r3 = r3.zzdce
            r4 = 0
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzbfw r3 = r3.zzabj()
            goto L_0x0021
        L_0x0020:
            r3 = r4
        L_0x0021:
            r5 = 0
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.zzaap()
            if (r3 == 0) goto L_0x002c
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            r1.zzdjy = r5
            if (r3 == 0) goto L_0x0067
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzdjq
            int r6 = r6.orientation
            com.google.android.gms.ads.internal.zzq.zzky()
            r7 = 6
            if (r6 != r7) goto L_0x004d
            android.app.Activity r6 = r1.zzaad
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 != r2) goto L_0x004a
        L_0x0049:
            r5 = 1
        L_0x004a:
            r1.zzdjy = r5
            goto L_0x0067
        L_0x004d:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzdjq
            int r6 = r6.orientation
            com.google.android.gms.ads.internal.zzq.zzky()
            r7 = 7
            if (r6 != r7) goto L_0x0067
            android.app.Activity r6 = r1.zzaad
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 != r7) goto L_0x004a
            goto L_0x0049
        L_0x0067:
            boolean r5 = r1.zzdjy
            r6 = 46
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Delay onShow to next orientation change: "
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.google.android.gms.internal.ads.zzazw.zzed(r5)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzdjq
            int r5 = r5.orientation
            r1.setRequestedOrientation(r5)
            com.google.android.gms.ads.internal.zzq.zzky()
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r5, r5)
            java.lang.String r0 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.internal.ads.zzazw.zzed(r0)
            boolean r0 = r1.zzblz
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.ads.internal.overlay.zzj r0 = r1.zzdjx
            r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x00a0
        L_0x009c:
            com.google.android.gms.ads.internal.overlay.zzj r0 = r1.zzdjx
            int r5 = zzdjp
        L_0x00a0:
            r0.setBackgroundColor(r5)
            android.app.Activity r0 = r1.zzaad
            com.google.android.gms.ads.internal.overlay.zzj r5 = r1.zzdjx
            r0.setContentView(r5)
            r1.zzdkd = r2
            if (r20 == 0) goto L_0x016b
            com.google.android.gms.ads.internal.zzq.zzkx()     // Catch:{ Exception -> 0x015d }
            android.app.Activity r6 = r1.zzaad     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce     // Catch:{ Exception -> 0x015d }
            if (r0 == 0) goto L_0x00c3
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbfz r0 = r0.zzabh()     // Catch:{ Exception -> 0x015d }
            r7 = r0
            goto L_0x00c4
        L_0x00c3:
            r7 = r4
        L_0x00c4:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce     // Catch:{ Exception -> 0x015d }
            if (r0 == 0) goto L_0x00d4
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce     // Catch:{ Exception -> 0x015d }
            java.lang.String r0 = r0.zzabi()     // Catch:{ Exception -> 0x015d }
            r8 = r0
            goto L_0x00d5
        L_0x00d4:
            r8 = r4
        L_0x00d5:
            r9 = 1
            r11 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzazz r12 = r0.zzbmo     // Catch:{ Exception -> 0x015d }
            r13 = 0
            r14 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce     // Catch:{ Exception -> 0x015d }
            if (r0 == 0) goto L_0x00ed
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.ads.internal.zza r0 = r0.zzzi()     // Catch:{ Exception -> 0x015d }
            r15 = r0
            goto L_0x00ee
        L_0x00ed:
            r15 = r4
        L_0x00ee:
            com.google.android.gms.internal.ads.zzst r16 = com.google.android.gms.internal.ads.zzst.zzmz()     // Catch:{ Exception -> 0x015d }
            r17 = 0
            r18 = 0
            r10 = r3
            com.google.android.gms.internal.ads.zzbek r0 = com.google.android.gms.internal.ads.zzbes.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x015d }
            r1.zzdce = r0     // Catch:{ Exception -> 0x015d }
            com.google.android.gms.internal.ads.zzbfw r5 = r0.zzabj()
            r6 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq
            com.google.android.gms.internal.ads.zzafj r7 = r0.zzczu
            r8 = 0
            com.google.android.gms.internal.ads.zzafl r9 = r0.zzczw
            com.google.android.gms.ads.internal.overlay.zzt r10 = r0.zzdkx
            r11 = 1
            r12 = 0
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce
            if (r0 == 0) goto L_0x011b
            com.google.android.gms.internal.ads.zzbfw r0 = r0.zzabj()
            com.google.android.gms.ads.internal.zzc r0 = r0.zzaao()
            r13 = r0
            goto L_0x011c
        L_0x011b:
            r13 = r4
        L_0x011c:
            r14 = 0
            r15 = 0
            r5.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            com.google.android.gms.internal.ads.zzbfw r0 = r0.zzabj()
            com.google.android.gms.ads.internal.overlay.zzf r5 = new com.google.android.gms.ads.internal.overlay.zzf
            r5.<init>(r1)
            r0.zza((com.google.android.gms.internal.ads.zzbfv) r5)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq
            java.lang.String r5 = r0.url
            if (r5 == 0) goto L_0x013b
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            r0.loadUrl(r5)
            goto L_0x014b
        L_0x013b:
            java.lang.String r8 = r0.zzdkw
            if (r8 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzbek r6 = r1.zzdce
            java.lang.String r7 = r0.zzdku
            r11 = 0
            java.lang.String r9 = "text/html"
            java.lang.String r10 = "UTF-8"
            r6.loadDataWithBaseURL(r7, r8, r9, r10, r11)
        L_0x014b:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce
            if (r0 == 0) goto L_0x0176
            r0.zzb(r1)
            goto L_0x0176
        L_0x0155:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "No URL or HTML to display in ad overlay."
            r0.<init>(r2)
            throw r0
        L_0x015d:
            r0 = move-exception
            java.lang.String r2 = "Error obtaining webview."
            com.google.android.gms.internal.ads.zzazw.zzc(r2, r0)
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Could not obtain webview for the overlay."
            r0.<init>(r2)
            throw r0
        L_0x016b:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce
            r1.zzdce = r0
            android.app.Activity r5 = r1.zzaad
            r0.zzbt(r5)
        L_0x0176:
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            r0.zza((com.google.android.gms.ads.internal.overlay.zzc) r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdjq
            com.google.android.gms.internal.ads.zzbek r0 = r0.zzdce
            if (r0 == 0) goto L_0x018a
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzabn()
            com.google.android.gms.ads.internal.overlay.zzj r5 = r1.zzdjx
            zzc(r0, r5)
        L_0x018a:
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x01a1
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x01a1
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            com.google.android.gms.internal.ads.zzbek r5 = r1.zzdce
            android.view.View r5 = r5.getView()
            r0.removeView(r5)
        L_0x01a1:
            boolean r0 = r1.zzblz
            if (r0 == 0) goto L_0x01aa
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            r0.zzabv()
        L_0x01aa:
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            android.app.Activity r5 = r1.zzaad
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzdjq
            java.lang.String r7 = r6.zzdku
            java.lang.String r6 = r6.zzdkw
            r0.zza(r4, r5, r7, r6)
            com.google.android.gms.ads.internal.overlay.zzj r0 = r1.zzdjx
            com.google.android.gms.internal.ads.zzbek r4 = r1.zzdce
            android.view.View r4 = r4.getView()
            r5 = -1
            r0.addView(r4, r5, r5)
            if (r20 != 0) goto L_0x01cc
            boolean r0 = r1.zzdjy
            if (r0 != 0) goto L_0x01cc
            r19.zzum()
        L_0x01cc:
            r1.zzai(r3)
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce
            boolean r0 = r0.zzabl()
            if (r0 == 0) goto L_0x01da
            r1.zza((boolean) r3, (boolean) r2)
        L_0x01da:
            return
        L_0x01db:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Invalid activity, no window available."
            r0.<init>(r2)
            goto L_0x01e4
        L_0x01e3:
            throw r0
        L_0x01e4:
            goto L_0x01e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zzaj(boolean):void");
    }

    private static void zzc(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzq.zzll().zza(iObjectWrapper, view);
        }
    }

    private final void zzuj() {
        if (this.zzaad.isFinishing() && !this.zzdke) {
            this.zzdke = true;
            zzbek zzbek = this.zzdce;
            if (zzbek != null) {
                zzbek.zzdn(this.zzdjz);
                synchronized (this.zzdka) {
                    if (!this.zzdkc && this.zzdce.zzabr()) {
                        zze zze = new zze(this);
                        this.zzdkb = zze;
                        zzaxa.zzdwf.postDelayed(zze, ((Long) zzvj.zzpv().zzd(zzzz.zzclt)).longValue());
                        return;
                    }
                }
            }
            zzuk();
        }
    }

    private final void zzum() {
        this.zzdce.zzum();
    }

    public final void close() {
        this.zzdjz = 2;
        this.zzaad.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.zzdjz = 0;
    }

    public void onCreate(Bundle bundle) {
        this.zzaad.requestWindowFeature(1);
        this.zzdjw = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(this.zzaad.getIntent());
            this.zzdjq = zzc;
            if (zzc != null) {
                if (zzc.zzbmo.zzdzo > 7500000) {
                    this.zzdjz = 3;
                }
                if (this.zzaad.getIntent() != null) {
                    this.zzdkg = this.zzaad.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdjq.zzdla != null) {
                    this.zzblz = this.zzdjq.zzdla.zzblz;
                } else {
                    this.zzblz = false;
                }
                if (this.zzblz && this.zzdjq.zzdla.zzbme != -1) {
                    new zzl(this).zzwn();
                }
                if (bundle == null) {
                    if (this.zzdjq.zzdkt != null && this.zzdkg) {
                        this.zzdjq.zzdkt.zzua();
                    }
                    if (!(this.zzdjq.zzdky == 1 || this.zzdjq.zzceb == null)) {
                        this.zzdjq.zzceb.onAdClicked();
                    }
                }
                zzj zzj = new zzj(this.zzaad, this.zzdjq.zzdkz, this.zzdjq.zzbmo.zzbnd);
                this.zzdjx = zzj;
                zzj.setId(1000);
                zzq.zzky().zzg(this.zzaad);
                int i = this.zzdjq.zzdky;
                if (i == 1) {
                    zzaj(false);
                } else if (i == 2) {
                    this.zzdjr = new zzi(this.zzdjq.zzdce);
                    zzaj(false);
                } else if (i == 3) {
                    zzaj(true);
                } else {
                    throw new zzg("Could not determine ad overlay type.");
                }
            } else {
                throw new zzg("Could not get info for ad overlay.");
            }
        } catch (zzg e) {
            zzazw.zzfc(e.getMessage());
            this.zzdjz = 3;
            this.zzaad.finish();
        }
    }

    public final void onDestroy() {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            try {
                this.zzdjx.removeView(zzbek.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzuj();
    }

    public final void onPause() {
        zzuf();
        zzo zzo = this.zzdjq.zzdkt;
        if (zzo != null) {
            zzo.onPause();
        }
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue() && this.zzdce != null && (!this.zzaad.isFinishing() || this.zzdjr == null)) {
            zzq.zzky();
            zzaxf.zza(this.zzdce);
        }
        zzuj();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        zzo zzo = this.zzdjq.zzdkt;
        if (zzo != null) {
            zzo.onResume();
        }
        zza(this.zzaad.getResources().getConfiguration());
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue()) {
            zzbek zzbek = this.zzdce;
            if (zzbek == null || zzbek.isDestroyed()) {
                zzazw.zzfc("The webview does not exist. Ignoring action.");
                return;
            }
            zzq.zzky();
            zzaxf.zzb(this.zzdce);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdjw);
    }

    public final void onStart() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue()) {
            zzbek zzbek = this.zzdce;
            if (zzbek == null || zzbek.isDestroyed()) {
                zzazw.zzfc("The webview does not exist. Ignoring action.");
                return;
            }
            zzq.zzky();
            zzaxf.zzb(this.zzdce);
        }
    }

    public final void onStop() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue() && this.zzdce != null && (!this.zzaad.isFinishing() || this.zzdjr == null)) {
            zzq.zzky();
            zzaxf.zza(this.zzdce);
        }
        zzuj();
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaad.getApplicationInfo().targetSdkVersion >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcsn)).intValue()) {
            if (this.zzaad.getApplicationInfo().targetSdkVersion <= ((Integer) zzvj.zzpv().zzd(zzzz.zzcso)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcsp)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzvj.zzpv().zzd(zzzz.zzcsq)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaad.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzq.zzla().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaad);
        this.zzdju = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdju.addView(view, -1, -1);
        this.zzaad.setContentView(this.zzdju);
        this.zzdkd = true;
        this.zzdjv = customViewCallback;
        this.zzdjt = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzdjq).zzdla;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzclu
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdjq
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzg r0 = r0.zzdla
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzbmg
            if (r0 == 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzzz.zzclv
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdjq
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzg r3 = r3.zzdla
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzbmh
            if (r3 == 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzapb r7 = new com.google.android.gms.internal.ads.zzapb
            com.google.android.gms.internal.ads.zzbek r4 = r6.zzdce
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzdv(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzq r7 = r6.zzdjs
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r7.zzal(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zza(boolean, boolean):void");
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzdp() {
        this.zzdkd = true;
    }

    public final void zzuf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdjq;
        if (adOverlayInfoParcel != null && this.zzdjt) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdju != null) {
            this.zzaad.setContentView(this.zzdjx);
            this.zzdkd = true;
            this.zzdju.removeAllViews();
            this.zzdju = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdjv;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdjv = null;
        }
        this.zzdjt = false;
    }

    public final void zzug() {
        this.zzdjz = 1;
        this.zzaad.finish();
    }

    public final boolean zzuh() {
        this.zzdjz = 0;
        zzbek zzbek = this.zzdce;
        if (zzbek == null) {
            return true;
        }
        boolean zzabq = zzbek.zzabq();
        if (!zzabq) {
            this.zzdce.zza("onbackblocked", Collections.emptyMap());
        }
        return zzabq;
    }

    public final void zzui() {
        this.zzdjx.removeView(this.zzdjs);
        zzai(true);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzuk() {
        zzbek zzbek;
        zzo zzo;
        if (!this.zzdkf) {
            this.zzdkf = true;
            zzbek zzbek2 = this.zzdce;
            if (zzbek2 != null) {
                this.zzdjx.removeView(zzbek2.getView());
                zzi zzi = this.zzdjr;
                if (zzi != null) {
                    this.zzdce.zzbt(zzi.zzvf);
                    this.zzdce.zzba(false);
                    ViewGroup viewGroup = this.zzdjr.parent;
                    View view = this.zzdce.getView();
                    zzi zzi2 = this.zzdjr;
                    viewGroup.addView(view, zzi2.index, zzi2.zzdkm);
                    this.zzdjr = null;
                } else if (this.zzaad.getApplicationContext() != null) {
                    this.zzdce.zzbt(this.zzaad.getApplicationContext());
                }
                this.zzdce = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdjq;
            if (!(adOverlayInfoParcel == null || (zzo = adOverlayInfoParcel.zzdkt) == null)) {
                zzo.zztz();
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdjq;
            if (adOverlayInfoParcel2 != null && (zzbek = adOverlayInfoParcel2.zzdce) != null) {
                zzc(zzbek.zzabn(), this.zzdjq.zzdce.getView());
            }
        }
    }

    public final void zzul() {
        if (this.zzdjy) {
            this.zzdjy = false;
            zzum();
        }
    }

    public final void zzun() {
        this.zzdjx.zzdko = true;
    }

    public final void zzuo() {
        synchronized (this.zzdka) {
            this.zzdkc = true;
            if (this.zzdkb != null) {
                zzaxa.zzdwf.removeCallbacks(this.zzdkb);
                zzaxa.zzdwf.post(this.zzdkb);
            }
        }
    }
}
