package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzsv;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
public class zzbej extends WebViewClient implements zzbfw {
    private final Object lock;
    private boolean zzbne;
    private zzub zzceb;
    private zzafj zzczu;
    private zzafl zzczw;
    private zzc zzdas;
    private zzaor zzdat;
    private zzo zzdkt;
    private zzt zzdkx;
    private boolean zzdov;
    protected zzbek zzehs;
    @Nullable
    private final zzst zzeht;
    private final HashMap<String, List<zzaga<? super zzbek>>> zzehu;
    private zzbfv zzehv;
    private zzbfy zzehw;
    private zzbfx zzehx;
    private boolean zzehy;
    private boolean zzehz;
    private boolean zzeia;
    private boolean zzeib;
    private final zzaoy zzeic;
    @Nullable
    protected zzaun zzeid;
    private boolean zzeie;
    private boolean zzeif;
    private int zzeig;
    private View.OnAttachStateChangeListener zzeih;

    public zzbej(zzbek zzbek, zzst zzst, boolean z) {
        this(zzbek, zzst, z, new zzaoy(zzbek, zzbek.zzabe(), new zzzg(zzbek.getContext())), (zzaor) null);
    }

    @VisibleForTesting
    private zzbej(zzbek zzbek, zzst zzst, boolean z, zzaoy zzaoy, zzaor zzaor) {
        this.zzehu = new HashMap<>();
        this.lock = new Object();
        this.zzehy = false;
        this.zzeht = zzst;
        this.zzehs = zzbek;
        this.zzbne = z;
        this.zzeic = zzaoy;
        this.zzdat = null;
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzaun zzaun, int i) {
        if (zzaun.zzvg() && i > 0) {
            zzaun.zzl(view);
            if (zzaun.zzvg()) {
                zzaxa.zzdwf.postDelayed(new zzbeo(this, view, zzaun, i), 100);
            }
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzd zzd;
        zzaor zzaor = this.zzdat;
        boolean zzub = zzaor != null ? zzaor.zzub() : false;
        zzq.zzkv();
        zzn.zza(this.zzehs.getContext(), adOverlayInfoParcel, !zzub);
        if (this.zzeid != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzd = adOverlayInfoParcel.zzdks) != null) {
                str = zzd.url;
            }
            this.zzeid.zzdy(str);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzaga<? super zzbek>> list, String str) {
        if (zzazw.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzawr.zzeg(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                StringBuilder sb = new StringBuilder(C0681a.m336b(str2, C0681a.m336b(next, 4)));
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str2);
                zzawr.zzeg(sb.toString());
            }
        }
        for (zzaga<? super zzbek> zza : list) {
            zza.zza(this.zzehs, map);
        }
    }

    private final void zzaau() {
        if (this.zzeih != null) {
            this.zzehs.getView().removeOnAttachStateChangeListener(this.zzeih);
        }
    }

    private final void zzaaz() {
        if (this.zzehv != null && ((this.zzeie && this.zzeig <= 0) || this.zzeif)) {
            this.zzehv.zzak(!this.zzeif);
            this.zzehv = null;
        }
        this.zzehs.zzabt();
    }

    private static WebResourceResponse zzaba() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzclc)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zze(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : map.entrySet()) {
                    openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzq.zzkw().zza(this.zzehs.getContext(), this.zzehs.zzzk().zzbnd, false, httpURLConnection);
                    zzazq zzazq = new zzazq();
                    zzazq.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzazq.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        zzq.zzkw();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        } else if (headerField.startsWith("tel:")) {
                            return null;
                        } else {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzazw.zzfc("Protocol is null");
                                return zzaba();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                zzazw.zzed(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                zzazw.zzfc(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                                return zzaba();
                            }
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                throw new IOException("Too many redirects (20)");
            }
        }
        zzq.zzkw();
        return zzaxa.zzd(httpURLConnection);
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzawr.zzeg(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zzsw();
        r0.zzehw = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzaaz();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzeie = true;
        r1 = r0.zzehw;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbek r2 = r0.zzehs     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.internal.ads.zzawr.zzeg(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbek r2 = r0.zzehs     // Catch:{ all -> 0x0029 }
            r2.zzabp()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzeie = r1
            com.google.android.gms.internal.ads.zzbfy r1 = r0.zzehw
            if (r1 == 0) goto L_0x0025
            r1.zzsw()
            r1 = 0
            r0.zzehw = r1
        L_0x0025:
            r0.zzaaz()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbej.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzrv zzabz = this.zzehs.zzabz();
        if (zzabz != null && webView == zzabz.getWebView()) {
            zzabz.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzehs.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzaun zzaun = this.zzeid;
        if (zzaun != null) {
            zzaun.zzvi();
            this.zzeid = null;
        }
        zzaau();
        synchronized (this.lock) {
            this.zzehu.clear();
            this.zzceb = null;
            this.zzdkt = null;
            this.zzehv = null;
            this.zzehw = null;
            this.zzczu = null;
            this.zzczw = null;
            this.zzehy = false;
            this.zzbne = false;
            this.zzehz = false;
            this.zzeib = false;
            this.zzdkx = null;
            this.zzehx = null;
            if (this.zzdat != null) {
                this.zzdat.zzac(true);
                this.zzdat = null;
            }
        }
    }

    @TargetApi(11)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzawr.zzeg(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzehy && webView == this.zzehs.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzub zzub = this.zzceb;
                    if (zzub != null) {
                        zzub.onAdClicked();
                        zzaun zzaun = this.zzeid;
                        if (zzaun != null) {
                            zzaun.zzdy(str);
                        }
                        this.zzceb = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzehs.getWebView().willNotDraw()) {
                try {
                    zzdt zzabm = this.zzehs.zzabm();
                    if (zzabm != null && zzabm.zzb(parse)) {
                        parse = zzabm.zza(parse, this.zzehs.getContext(), this.zzehs.getView(), this.zzehs.zzzh());
                    }
                } catch (zzdw unused) {
                    String valueOf2 = String.valueOf(str);
                    zzazw.zzfc(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zzc zzc = this.zzdas;
                if (zzc == null || zzc.zzjx()) {
                    zza(new zzd("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                } else {
                    this.zzdas.zzbm(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzazw.zzfc(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzeic.zzj(i, i2);
        zzaor zzaor = this.zzdat;
        if (zzaor != null) {
            zzaor.zza(i, i2, false);
        }
    }

    public final void zza(zzd zzd) {
        boolean zzabo = this.zzehs.zzabo();
        zza(new AdOverlayInfoParcel(zzd, (!zzabo || this.zzehs.zzabh().zzaco()) ? this.zzceb : null, zzabo ? null : this.zzdkt, this.zzdkx, this.zzehs.zzzk()));
    }

    public final void zza(zzbfv zzbfv) {
        this.zzehv = zzbfv;
    }

    public final void zza(zzbfy zzbfy) {
        this.zzehw = zzbfy;
    }

    public final void zza(zzub zzub, zzafj zzafj, zzo zzo, zzafl zzafl, zzt zzt, boolean z, @Nullable zzagd zzagd, zzc zzc, zzapa zzapa, @Nullable zzaun zzaun) {
        if (zzc == null) {
            zzc = new zzc(this.zzehs.getContext(), zzaun, (zzaqy) null);
        }
        this.zzdat = new zzaor(this.zzehs, zzapa);
        this.zzeid = zzaun;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzclm)).booleanValue()) {
            zza("/adMetadata", (zzaga<? super zzbek>) new zzafg(zzafj));
        }
        zza("/appEvent", (zzaga<? super zzbek>) new zzafi(zzafl));
        zza("/backButton", (zzaga<? super zzbek>) zzafn.zzdah);
        zza("/refresh", (zzaga<? super zzbek>) zzafn.zzdai);
        zza("/canOpenURLs", (zzaga<? super zzbek>) zzafn.zzczy);
        zza("/canOpenIntents", (zzaga<? super zzbek>) zzafn.zzczz);
        zza("/click", (zzaga<? super zzbek>) zzafn.zzdaa);
        zza("/close", (zzaga<? super zzbek>) zzafn.zzdab);
        zza("/customClose", (zzaga<? super zzbek>) zzafn.zzdac);
        zza("/instrument", (zzaga<? super zzbek>) zzafn.zzdal);
        zza("/delayPageLoaded", (zzaga<? super zzbek>) zzafn.zzdan);
        zza("/delayPageClosed", (zzaga<? super zzbek>) zzafn.zzdao);
        zza("/getLocationInfo", (zzaga<? super zzbek>) zzafn.zzdap);
        zza("/httpTrack", (zzaga<? super zzbek>) zzafn.zzdad);
        zza("/log", (zzaga<? super zzbek>) zzafn.zzdae);
        zza("/mraid", (zzaga<? super zzbek>) new zzagf(zzc, this.zzdat, zzapa));
        zza("/mraidLoaded", (zzaga<? super zzbek>) this.zzeic);
        zza("/open", (zzaga<? super zzbek>) new zzage(zzc, this.zzdat));
        zza("/precache", (zzaga<? super zzbek>) new zzbdu());
        zza("/touch", (zzaga<? super zzbek>) zzafn.zzdag);
        zza("/video", (zzaga<? super zzbek>) zzafn.zzdaj);
        zza("/videoMeta", (zzaga<? super zzbek>) zzafn.zzdak);
        if (zzq.zzlu().zzab(this.zzehs.getContext())) {
            zza("/logScionEvent", (zzaga<? super zzbek>) new zzagc(this.zzehs.getContext()));
        }
        this.zzceb = zzub;
        this.zzdkt = zzo;
        this.zzczu = zzafj;
        this.zzczw = zzafl;
        this.zzdkx = zzt;
        this.zzdas = zzc;
        this.zzehy = z;
    }

    public final void zza(String str, Predicate<zzaga<? super zzbek>> predicate) {
        synchronized (this.lock) {
            List<zzaga> list = this.zzehu.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzaga zzaga : list) {
                    if (predicate.apply(zzaga)) {
                        arrayList.add(zzaga);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void zza(String str, zzaga<? super zzbek> zzaga) {
        synchronized (this.lock) {
            List list = this.zzehu.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzehu.put(str, list);
            }
            list.add(zzaga);
        }
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzabo = this.zzehs.zzabo();
        zzub zzub = (!zzabo || this.zzehs.zzabh().zzaco()) ? this.zzceb : null;
        zzbep zzbep = zzabo ? null : new zzbep(this.zzehs, this.zzdkt);
        zzafj zzafj = this.zzczu;
        zzafl zzafl = this.zzczw;
        zzt zzt = this.zzdkx;
        zzbek zzbek = this.zzehs;
        zza(new AdOverlayInfoParcel(zzub, (zzo) zzbep, zzafj, zzafl, zzt, zzbek, z, i, str, zzbek.zzzk()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzabo = this.zzehs.zzabo();
        zzub zzub = (!zzabo || this.zzehs.zzabh().zzaco()) ? this.zzceb : null;
        zzbep zzbep = zzabo ? null : new zzbep(this.zzehs, this.zzdkt);
        zzafj zzafj = this.zzczu;
        zzafl zzafl = this.zzczw;
        zzt zzt = this.zzdkx;
        zzbek zzbek = this.zzehs;
        zza(new AdOverlayInfoParcel(zzub, zzbep, zzafj, zzafl, zzt, zzbek, z, i, str, str2, zzbek.zzzk()));
    }

    public final zzc zzaao() {
        return this.zzdas;
    }

    public final boolean zzaap() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbne;
        }
        return z;
    }

    public final boolean zzaaq() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzehz;
        }
        return z;
    }

    public final boolean zzaar() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeia;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaas() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzaat() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final void zzaav() {
        zzaun zzaun = this.zzeid;
        if (zzaun != null) {
            WebView webView = this.zzehs.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza((View) webView, zzaun, 10);
                return;
            }
            zzaau();
            this.zzeih = new zzben(this, zzaun);
            this.zzehs.getView().addOnAttachStateChangeListener(this.zzeih);
        }
    }

    public final void zzaaw() {
        synchronized (this.lock) {
            this.zzeib = true;
        }
        this.zzeig++;
        zzaaz();
    }

    public final void zzaax() {
        this.zzeig--;
        zzaaz();
    }

    public final void zzaay() {
        zzst zzst = this.zzeht;
        if (zzst != null) {
            zzst.zza(zzsv.zza.C2668zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzeif = true;
        zzaaz();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrz)).booleanValue()) {
            this.zzehs.destroy();
        }
    }

    public final zzaun zzabb() {
        return this.zzeid;
    }

    public final void zzav(boolean z) {
        this.zzehy = z;
    }

    public final void zzax(boolean z) {
        this.zzdov = z;
    }

    public final void zzay(boolean z) {
        synchronized (this.lock) {
            this.zzehz = true;
        }
    }

    public final void zzaz(boolean z) {
        synchronized (this.lock) {
            this.zzeia = z;
        }
    }

    public final void zzb(String str, zzaga<? super zzbek> zzaga) {
        synchronized (this.lock) {
            List list = this.zzehu.get(str);
            if (list != null) {
                list.remove(zzaga);
            }
        }
    }

    public final void zzb(boolean z, int i) {
        zzub zzub = (!this.zzehs.zzabo() || this.zzehs.zzabh().zzaco()) ? this.zzceb : null;
        zzo zzo = this.zzdkt;
        zzt zzt = this.zzdkx;
        zzbek zzbek = this.zzehs;
        zza(new AdOverlayInfoParcel(zzub, zzo, zzt, zzbek, z, i, zzbek.zzzk()));
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzse zza;
        try {
            String zzc = zzavj.zzc(str, this.zzehs.getContext(), this.zzdov);
            if (!zzc.equals(str)) {
                return zze(zzc, map);
            }
            zzsf zzbu = zzsf.zzbu(str);
            if (zzbu != null && (zza = zzq.zzlc().zza(zzbu)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzazq.isEnabled() || !zzabi.zzcwi.get().booleanValue()) {
                return null;
            }
            return zze(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            zzq.zzla().zza(e, "AdWebViewClient.interceptRequest");
            return zzaba();
        }
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List list = this.zzehu.get(path);
        if (list != null) {
            if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcrv)).booleanValue()) {
                zzq.zzkw();
                zza(zzaxa.zzj(uri), (List<zzaga<? super zzbek>>) list, path);
                return;
            }
            zzdqw.zza(zzq.zzkw().zzi(uri), new zzbeq(this, list, path), zzbab.zzdzw);
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(valueOf.length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf);
        zzawr.zzeg(sb.toString());
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzctz)).booleanValue() && zzq.zzla().zzvv() != null) {
            zzbab.zzdzr.execute(new zzbel(path));
        }
    }

    public final void zzi(int i, int i2) {
        zzaor zzaor = this.zzdat;
        if (zzaor != null) {
            zzaor.zzi(i, i2);
        }
    }

    public final void zzui() {
        synchronized (this.lock) {
            this.zzehy = false;
            this.zzbne = true;
            zzbab.zzdzv.execute(new zzbem(this));
        }
    }
}
