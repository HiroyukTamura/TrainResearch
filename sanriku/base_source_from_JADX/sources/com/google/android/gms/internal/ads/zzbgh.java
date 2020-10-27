package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zztf;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;

@VisibleForTesting
final class zzbgh extends zzbgn implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzain, zzbek {
    private int maxHeight = -1;
    private int maxWidth = -1;
    private String zzacf;
    private final zzazz zzbmo;
    private final WindowManager zzboo;
    private int zzdji = -1;
    private int zzdjj = -1;
    private boolean zzdkv;
    private String zzdmh = "";
    private zzaak zzeec;
    private final zzst zzeht;
    private final zzbga zzejk;
    @Nullable
    private final zzdt zzejl;
    private final zzi zzejm;
    private final zza zzejn;
    @Nullable
    private final zzrv zzejp;
    private final boolean zzejq;
    private zzc zzeju;
    private zzbfz zzejw;
    private boolean zzejy;
    private boolean zzejz;
    private int zzeka;
    private boolean zzekb = true;
    private boolean zzekc = false;
    private zzbfe zzekd;
    private boolean zzeke;
    private boolean zzekf;
    private zzacg zzekg;
    private zzacf zzekh;
    private zzrh zzeki;
    private int zzekj;
    /* access modifiers changed from: private */
    public int zzekk;
    private zzaak zzekl;
    private zzaak zzekm;
    private zzaan zzekn;
    private WeakReference<View.OnClickListener> zzeko;
    private zzc zzekp;
    private zzazj zzekr;
    private Map<String, zzbdl> zzeks;
    private final zzbgc zzeln;
    private final AtomicReference<IObjectWrapper> zzelo = new AtomicReference<>();
    private final DisplayMetrics zzwz;

    @VisibleForTesting
    protected zzbgh(zzbga zzbga, zzbgc zzbgc, zzbfz zzbfz, String str, boolean z, boolean z2, @Nullable zzdt zzdt, zzazz zzazz, zzaam zzaam, zzi zzi, zza zza, zzst zzst, zzrv zzrv, boolean z3) {
        super(zzbga, zzbgc);
        this.zzejk = zzbga;
        this.zzeln = zzbgc;
        this.zzejw = zzbfz;
        this.zzacf = str;
        this.zzejy = z;
        this.zzeka = -1;
        this.zzejl = zzdt;
        this.zzbmo = zzazz;
        this.zzejm = zzi;
        this.zzejn = zza;
        this.zzboo = (WindowManager) getContext().getSystemService("window");
        zzq.zzkw();
        this.zzwz = zzaxa.zza(this.zzboo);
        this.zzeht = zzst;
        this.zzejp = zzrv;
        this.zzejq = z3;
        this.zzekr = new zzazj(this.zzejk.zzzh(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzq.zzkw().zza((Context) zzbga, zzazz.zzbnd, getSettings());
        setDownloadListener(this);
        zzace();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbff.zzc(this), "googleAdsJsInterface");
        }
        zzaci();
        zzaan zzaan = new zzaan(new zzaam(true, "make_wv", this.zzacf));
        this.zzekn = zzaan;
        zzaan.zzrn().zzc(zzaam);
        zzaak zzb = zzaah.zzb(this.zzekn.zzrn());
        this.zzeec = zzb;
        this.zzekn.zza("native:view_create", zzb);
        this.zzekm = null;
        this.zzekl = null;
        zzq.zzky().zzbe(zzbga);
    }

    static final /* synthetic */ void zza(boolean z, int i, zztf.zzi.zza zza) {
        zztf.zzae.zza zzpe = zztf.zzae.zzpe();
        if (zzpe.zzpd() != z) {
            zzpe.zzw(z);
        }
        zza.zzb((zztf.zzae) ((zzecd) zzpe.zzcr(i).zzbet()));
    }

    private final boolean zzacb() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzeln.zzaap() && !this.zzeln.zzaaq()) {
            return false;
        }
        zzvj.zzpr();
        DisplayMetrics displayMetrics = this.zzwz;
        int zzb = zzazm.zzb(displayMetrics, displayMetrics.widthPixels);
        zzvj.zzpr();
        DisplayMetrics displayMetrics2 = this.zzwz;
        int zzb2 = zzazm.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzzh = this.zzejk.zzzh();
        if (zzzh == null || zzzh.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzq.zzkw();
            int[] zzd = zzaxa.zzd(zzzh);
            zzvj.zzpr();
            int zzb3 = zzazm.zzb(this.zzwz, zzd[0]);
            zzvj.zzpr();
            i = zzazm.zzb(this.zzwz, zzd[1]);
            i2 = zzb3;
        }
        if (this.zzdji == zzb && this.zzdjj == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(this.zzdji == zzb && this.zzdjj == zzb2)) {
            z = true;
        }
        this.zzdji = zzb;
        this.zzdjj = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzapb(this).zza(zzb, zzb2, i2, i, this.zzwz.density, this.zzboo.getDefaultDisplay().getRotation());
        return z;
    }

    private final void zzacd() {
        zzaah.zza(this.zzekn.zzrn(), this.zzeec, "aeh2");
    }

    private final synchronized void zzace() {
        if (!this.zzejy) {
            if (!this.zzejw.zzaco()) {
                zzazw.zzed("Enabling hardware acceleration on an AdView.");
                zzacg();
                return;
            }
        }
        zzazw.zzed("Enabling hardware acceleration on an overlay.");
        zzacg();
    }

    private final synchronized void zzacf() {
        if (!this.zzejz) {
            zzq.zzky();
            setLayerType(1, (Paint) null);
        }
        this.zzejz = true;
    }

    private final synchronized void zzacg() {
        if (this.zzejz) {
            zzq.zzky();
            setLayerType(0, (Paint) null);
        }
        this.zzejz = false;
    }

    private final synchronized void zzach() {
        if (this.zzeks != null) {
            for (zzbdl release : this.zzeks.values()) {
                release.release();
            }
        }
        this.zzeks = null;
    }

    private final void zzaci() {
        zzaam zzrn;
        zzaan zzaan = this.zzekn;
        if (zzaan != null && (zzrn = zzaan.zzrn()) != null && zzq.zzla().zzvv() != null) {
            zzq.zzla().zzvv().zza(zzrn);
        }
    }

    private final void zzbd(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : RFGDef.DEFAULT_GYM_ID);
        zzaim.zza((zzain) this, "onAdVisibilityChanged", (Map) hashMap);
    }

    public final synchronized String getRequestId() {
        return this.zzdmh;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzekr.onAttachedToWindow();
        }
        boolean z = this.zzeke;
        if (this.zzeln != null && this.zzeln.zzaaq()) {
            if (!this.zzekf) {
                this.zzeln.zzaas();
                this.zzeln.zzaat();
                this.zzekf = true;
            }
            zzacb();
            z = true;
        }
        zzbd(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzekr.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzekf && this.zzeln != null && this.zzeln.zzaaq() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzeln.zzaas();
                this.zzeln.zzaat();
                this.zzekf = false;
            }
        }
        zzbd(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzq.zzkw();
            zzaxa.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str4, C0681a.m336b(str, 51)));
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzazw.zzed(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zzacb = zzacb();
        zzc zzabf = zzabf();
        if (zzabf != null && zzacb) {
            zzabf.zzul();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d8 A[SYNTHETIC, Splitter:B:109:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00de=Splitter:B:64:0x00de, B:116:0x01ee=Splitter:B:116:0x01ee} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01f3 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x01ee
            boolean r0 = r7.zzejy     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x01ee
            com.google.android.gms.internal.ads.zzbfz r0 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzacp()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x0021
            goto L_0x01ee
        L_0x0021:
            com.google.android.gms.internal.ads.zzbfz r0 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzacr()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbfz r0 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzacq()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcpa     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x01f3 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01f3 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbfe r0 = r7.zzzf()     // Catch:{ all -> 0x01f3 }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01f3 }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x0063:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01f3 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f3 }
            float r1 = (float) r9     // Catch:{ all -> 0x01f3 }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01f3 }
            float r2 = (float) r8     // Catch:{ all -> 0x01f3 }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01f3 }
            if (r9 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r9 = (float) r2     // Catch:{ all -> 0x01f3 }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x01f3 }
            r9 = r2
            goto L_0x0084
        L_0x007c:
            if (r8 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r8 = (float) r1     // Catch:{ all -> 0x01f3 }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x01f3 }
            r8 = r1
        L_0x0084:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x01f3 }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x01f3 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbfz r0 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcpd     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x01f3 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01f3 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x00de
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00de
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.zzbgj r1 = new com.google.android.gms.internal.ads.zzbgj     // Catch:{ all -> 0x01f3 }
            r1.<init>(r7)     // Catch:{ all -> 0x01f3 }
            r7.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzaga<? super com.google.android.gms.internal.ads.zzbek>) r1)     // Catch:{ all -> 0x01f3 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.zzda(r0)     // Catch:{ all -> 0x01f3 }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01f3 }
            int r0 = r7.zzekk     // Catch:{ all -> 0x01f3 }
            r1 = -1
            if (r0 == r1) goto L_0x00d5
            int r9 = r7.zzekk     // Catch:{ all -> 0x01f3 }
            float r9 = (float) r9     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r0 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r0 = r0.density     // Catch:{ all -> 0x01f3 }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x01f3 }
            goto L_0x00d9
        L_0x00d5:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f3 }
        L_0x00d9:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x00de:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbfz r0 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzaco()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x00f8
            android.util.DisplayMetrics r8 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r9 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01f3 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x00f8:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x01f3 }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01f3 }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01f3 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f3 }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0118
            if (r0 != r3) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0119
        L_0x0118:
            r0 = r8
        L_0x0119:
            if (r2 == r4) goto L_0x011d
            if (r2 != r3) goto L_0x011e
        L_0x011d:
            r5 = r9
        L_0x011e:
            com.google.android.gms.internal.ads.zzbfz r2 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01f3 }
            r3 = 1
            if (r2 > r0) goto L_0x012e
            com.google.android.gms.internal.ads.zzbfz r2 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01f3 }
            if (r2 <= r5) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzzz.zzcrk     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzzv r6 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x01f3 }
            java.lang.Object r4 = r6.zzd(r4)     // Catch:{ all -> 0x01f3 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01f3 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01f3 }
            if (r4 == 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzbfz r4 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r4 = r4.widthPixels     // Catch:{ all -> 0x01f3 }
            float r4 = (float) r4     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r6 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r6 = r6.density     // Catch:{ all -> 0x01f3 }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r6 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r6 = r6.density     // Catch:{ all -> 0x01f3 }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzbfz r0 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x01f3 }
            float r0 = (float) r0     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r5 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r5 = r5.density     // Catch:{ all -> 0x01f3 }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x016a
            goto L_0x016b
        L_0x016a:
            r3 = 0
        L_0x016b:
            if (r2 == 0) goto L_0x016e
            r2 = r3
        L_0x016e:
            r0 = 8
            if (r2 == 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzbfz r2 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01f3 }
            float r2 = (float) r2     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r3 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r3 = r3.density     // Catch:{ all -> 0x01f3 }
            float r2 = r2 / r3
            int r2 = (int) r2     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzbfz r3 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r3 = r3.heightPixels     // Catch:{ all -> 0x01f3 }
            float r3 = (float) r3     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r3 = r3 / r4
            int r3 = (int) r3     // Catch:{ all -> 0x01f3 }
            float r8 = (float) r8     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r8 = r8 / r4
            int r8 = (int) r8     // Catch:{ all -> 0x01f3 }
            float r9 = (float) r9     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwz     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01f3 }
            r4 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f3 }
            r5.<init>(r4)     // Catch:{ all -> 0x01f3 }
            java.lang.String r4 = "Not enough space to show ad. Needs "
            r5.append(r4)     // Catch:{ all -> 0x01f3 }
            r5.append(r2)     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = "x"
            r5.append(r2)     // Catch:{ all -> 0x01f3 }
            r5.append(r3)     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = " dp, but only has "
            r5.append(r2)     // Catch:{ all -> 0x01f3 }
            r5.append(r8)     // Catch:{ all -> 0x01f3 }
            java.lang.String r8 = "x"
            r5.append(r8)     // Catch:{ all -> 0x01f3 }
            r5.append(r9)     // Catch:{ all -> 0x01f3 }
            java.lang.String r8 = " dp."
            r5.append(r8)     // Catch:{ all -> 0x01f3 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzazw.zzfc(r8)     // Catch:{ all -> 0x01f3 }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01f3 }
            if (r8 == r0) goto L_0x01d3
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x01f3 }
        L_0x01d3:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x01d8:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01f3 }
            if (r8 == r0) goto L_0x01e1
            r7.setVisibility(r1)     // Catch:{ all -> 0x01f3 }
        L_0x01e1:
            com.google.android.gms.internal.ads.zzbfz r8 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzbfz r9 = r7.zzejw     // Catch:{ all -> 0x01f3 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01f3 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x01ee:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x01f3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgh.onMeasure(int, int):void");
    }

    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzazw.zzc("Could not pause webview.", e);
        }
    }

    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzazw.zzc("Could not resume webview.", e);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzeln.zzaaq() || this.zzeln.zzaar()) {
            zzdt zzdt = this.zzejl;
            if (zzdt != null) {
                zzdt.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                if (this.zzekg != null) {
                    this.zzekg.zzc(motionEvent);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeko = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.zzeka = i;
        if (this.zzeju != null) {
            this.zzeju.setRequestedOrientation(i);
        }
    }

    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzazw.zzc("Could not stop loading webview.", e);
        }
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzaca()) {
            zzawr.zzeg("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzawr.zzeg("Initializing ArWebView object.");
        this.zzejp.zza(activity, this);
        this.zzejp.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzejp.getView());
        } else {
            zzazw.zzfa("The FrameLayout object cannot be null.");
        }
    }

    public final synchronized void zza(zzc zzc) {
        this.zzeju = zzc;
    }

    public final void zza(zzd zzd) {
        this.zzeln.zza(zzd);
    }

    public final synchronized void zza(zzacf zzacf2) {
        this.zzekh = zzacf2;
    }

    public final synchronized void zza(zzacg zzacg) {
        this.zzekg = zzacg;
    }

    public final synchronized void zza(zzbfe zzbfe) {
        if (this.zzekd != null) {
            zzazw.zzfa("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzekd = zzbfe;
        }
    }

    public final synchronized void zza(zzbfz zzbfz) {
        this.zzejw = zzbfz;
        requestLayout();
    }

    public final void zza(zzqa zzqa) {
        synchronized (this) {
            this.zzeke = zzqa.zzbot;
        }
        zzbd(zzqa.zzbot);
    }

    public final synchronized void zza(zzrh zzrh) {
        this.zzeki = zzrh;
    }

    public final void zza(String str, Predicate<zzaga<? super zzbek>> predicate) {
        zzbgc zzbgc = this.zzeln;
        if (zzbgc != null) {
            zzbgc.zza(str, predicate);
        }
    }

    public final void zza(String str, zzaga<? super zzbek> zzaga) {
        zzbgc zzbgc = this.zzeln;
        if (zzbgc != null) {
            zzbgc.zza(str, zzaga);
        }
    }

    public final synchronized void zza(String str, zzbdl zzbdl) {
        if (this.zzeks == null) {
            this.zzeks = new HashMap();
        }
        this.zzeks.put(str, zzbdl);
    }

    public final void zza(String str, Map map) {
        zzaim.zza((zzain) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaim.zza((zzain) this, str, jSONObject);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzeln.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeln.zza(z, i, str, str2);
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : RFGDef.DEFAULT_GYM_ID);
        hashMap.put("duration", Long.toString(j));
        zzaim.zza((zzain) this, "onCacheAccessComplete", (Map) hashMap);
    }

    public final void zzabc() {
        zzacd();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbmo.zzbnd);
        zzaim.zza((zzain) this, "onhide", (Map) hashMap);
    }

    public final void zzabd() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzq.zzlb().zzqc()));
        hashMap.put("app_volume", String.valueOf(zzq.zzlb().zzqb()));
        hashMap.put("device_volume", String.valueOf(zzaxs.zzbg(getContext())));
        zzaim.zza((zzain) this, "volume", (Map) hashMap);
    }

    public final Context zzabe() {
        return this.zzejk.zzabe();
    }

    public final synchronized zzc zzabf() {
        return this.zzeju;
    }

    public final synchronized zzc zzabg() {
        return this.zzekp;
    }

    public final synchronized zzbfz zzabh() {
        return this.zzejw;
    }

    public final synchronized String zzabi() {
        return this.zzacf;
    }

    public final /* synthetic */ zzbfw zzabj() {
        return this.zzeln;
    }

    public final WebViewClient zzabk() {
        return this.zzeln;
    }

    public final synchronized boolean zzabl() {
        return this.zzdkv;
    }

    public final zzdt zzabm() {
        return this.zzejl;
    }

    public final IObjectWrapper zzabn() {
        return this.zzelo.get();
    }

    public final synchronized boolean zzabo() {
        return this.zzejy;
    }

    public final void zzabp() {
    }

    public final synchronized boolean zzabq() {
        return this.zzekb;
    }

    public final synchronized boolean zzabr() {
        return this.zzekj > 0;
    }

    public final void zzabs() {
        this.zzekr.zzxz();
    }

    public final void zzabt() {
        if (this.zzekm == null) {
            zzaak zzb = zzaah.zzb(this.zzekn.zzrn());
            this.zzekm = zzb;
            this.zzekn.zza("native:view_load", zzb);
        }
    }

    public final synchronized zzacg zzabu() {
        return this.zzekg;
    }

    public final void zzabv() {
        setBackgroundColor(0);
    }

    public final void zzabw() {
        zzawr.zzeg("Cannot add text view to inner AdWebView");
    }

    public final synchronized zzrh zzabx() {
        return this.zzeki;
    }

    public final boolean zzaby() {
        return false;
    }

    public final zzrv zzabz() {
        return this.zzejp;
    }

    public final boolean zzaca() {
        return ((Boolean) zzvj.zzpv().zzd(zzzz.zzcte)).booleanValue() && this.zzejp != null && this.zzejq;
    }

    public final synchronized void zzal(boolean z) {
        if (this.zzeju != null) {
            this.zzeju.zza(this.zzeln.zzaap(), z);
        } else {
            this.zzdkv = z;
        }
    }

    public final void zzap(IObjectWrapper iObjectWrapper) {
        this.zzelo.set(iObjectWrapper);
    }

    public final void zzav(boolean z) {
        this.zzeln.zzav(z);
    }

    public final void zzax(boolean z) {
        this.zzeln.zzax(z);
    }

    public final synchronized void zzb(zzc zzc) {
        this.zzekp = zzc;
    }

    public final void zzb(String str, zzaga<? super zzbek> zzaga) {
        zzbgc zzbgc = this.zzeln;
        if (zzbgc != null) {
            zzbgc.zzb(str, zzaga);
        }
    }

    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        String str4 = str;
        super.loadDataWithBaseURL(str4, zzbfp.zzf(str2, zzbfp.zzack()), "text/html", "UTF-8", str3);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaim.zzb(this, str, jSONObject);
    }

    public final void zzb(boolean z, int i) {
        this.zzeln.zzb(z, i);
    }

    public final synchronized void zzba(boolean z) {
        boolean z2 = z != this.zzejy;
        this.zzejy = z;
        zzace();
        if (z2) {
            if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzckc)).booleanValue() || !this.zzejw.zzaco()) {
                new zzapb(this).zzdx(z ? "expanded" : "default");
            }
        }
    }

    public final synchronized void zzbb(boolean z) {
        this.zzekb = z;
    }

    public final synchronized void zzbc(boolean z) {
        int i = this.zzekj + (z ? 1 : -1);
        this.zzekj = i;
        if (i <= 0 && this.zzeju != null) {
            this.zzeju.zzuo();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzbe(boolean z) {
        if (!z) {
            zzaci();
            this.zzekr.zzya();
            if (this.zzeju != null) {
                this.zzeju.close();
                this.zzeju.onDestroy();
                this.zzeju = null;
            }
        }
        this.zzelo.set((Object) null);
        this.zzeln.destroy();
        zzq.zzls();
        zzbdm.zzc(this);
        zzach();
    }

    public final void zzbt(Context context) {
        this.zzejk.setBaseContext(context);
        this.zzekr.zzh(this.zzejk.zzzh());
    }

    public final boolean zzc(boolean z, int i) {
        destroy();
        this.zzeht.zza((zzsw) new zzbgk(z, i));
        this.zzeht.zza(zzsv.zza.C2668zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final synchronized void zzda(String str) {
        if (!isDestroyed()) {
            super.zzda(str);
        } else {
            zzazw.zzfc("The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzdn(int i) {
        if (i == 0) {
            zzaah.zza(this.zzekn.zzrn(), this.zzeec, "aebb2");
        }
        zzacd();
        if (this.zzekn.zzrn() != null) {
            this.zzekn.zzrn().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbmo.zzbnd);
        zzaim.zza((zzain) this, "onhide", (Map) hashMap);
    }

    public final synchronized zzbdl zzfh(String str) {
        if (this.zzeks == null) {
            return null;
        }
        return this.zzeks.get(str);
    }

    public final void zzj(String str, String str2) {
        zzaim.zza((zzain) this, str, str2);
    }

    public final synchronized void zzkc() {
        this.zzekc = true;
        if (this.zzejm != null) {
            this.zzejm.zzkc();
        }
    }

    public final synchronized void zzkd() {
        this.zzekc = false;
        if (this.zzejm != null) {
            this.zzejm.zzkd();
        }
    }

    public final void zzum() {
        if (this.zzekl == null) {
            zzaah.zza(this.zzekn.zzrn(), this.zzeec, "aes2");
            zzaak zzb = zzaah.zzb(this.zzekn.zzrn());
            this.zzekl = zzb;
            this.zzekn.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbmo.zzbnd);
        zzaim.zza((zzain) this, "onshow", (Map) hashMap);
    }

    public final void zzun() {
        zzc zzabf = zzabf();
        if (zzabf != null) {
            zzabf.zzun();
        }
    }

    public final zzbbq zzze() {
        return null;
    }

    public final synchronized zzbfe zzzf() {
        return this.zzekd;
    }

    public final zzaak zzzg() {
        return this.zzeec;
    }

    public final Activity zzzh() {
        return this.zzejk.zzzh();
    }

    public final zza zzzi() {
        return this.zzejn;
    }

    public final zzaan zzzj() {
        return this.zzekn;
    }

    public final zzazz zzzk() {
        return this.zzbmo;
    }

    public final int zzzl() {
        return getMeasuredHeight();
    }

    public final int zzzm() {
        return getMeasuredWidth();
    }

    public final synchronized void zzzn() {
        if (this.zzekh != null) {
            this.zzekh.zzrw();
        }
    }
}
