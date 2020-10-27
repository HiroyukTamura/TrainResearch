package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@VisibleForTesting
public final class zzbgc extends zzbgl implements zzbfw {
    private final Object lock = new Object();
    private volatile boolean zzbne;
    private zzub zzceb;
    private zzafj zzczu;
    private zzafl zzczw;
    private zzc zzdas;
    private zzaor zzdat;
    private zzo zzdkt;
    private zzt zzdkx;
    private boolean zzdov;
    protected zzbek zzehs;
    private zzbfv zzehv;
    private zzbfy zzehw;
    private zzbfx zzehx;
    private boolean zzehy = false;
    private boolean zzehz;
    private boolean zzeia;
    private boolean zzeib;
    private zzaoy zzeic;
    @Nullable
    private zzaun zzeid;
    private boolean zzeie;
    private boolean zzeif;
    private int zzeig;
    private View.OnAttachStateChangeListener zzeih;
    private final zzair<zzbek> zzell = new zzair<>();

    /* access modifiers changed from: private */
    public final void zza(View view, zzaun zzaun, int i) {
        if (zzaun.zzvg() && i > 0) {
            zzaun.zzl(view);
            if (zzaun.zzvg()) {
                zzaxa.zzdwf.postDelayed(new zzbge(this, view, zzaun, i), 100);
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

    private final WebResourceResponse zze(zzbgo zzbgo) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbgo.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : zzbgo.zzab.entrySet()) {
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

    public final void destroy() {
        zzaun zzaun = this.zzeid;
        if (zzaun != null) {
            zzaun.zzvi();
            this.zzeid = null;
        }
        zzaau();
        this.zzell.reset();
        this.zzell.zzg(null);
        synchronized (this.lock) {
            this.zzceb = null;
            this.zzdkt = null;
            this.zzehv = null;
            this.zzehw = null;
            this.zzczu = null;
            this.zzczw = null;
            this.zzdkx = null;
            this.zzehx = null;
            if (this.zzdat != null) {
                this.zzdat.zzac(true);
                this.zzdat = null;
            }
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzrv zzabz = this.zzehs.zzabz();
        if (zzabz != null && webView == zzabz.getWebView()) {
            zzabz.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzehs.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
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

    /* access modifiers changed from: package-private */
    public final void zza(zzbek zzbek, boolean z) {
        zzaoy zzaoy = new zzaoy(zzbek, zzbek.zzabe(), new zzzg(zzbek.getContext()));
        this.zzehs = zzbek;
        this.zzbne = z;
        this.zzeic = zzaoy;
        this.zzdat = null;
        this.zzell.zzg(zzbek);
    }

    public final void zza(zzbfv zzbfv) {
        this.zzehv = zzbfv;
    }

    public final void zza(zzbfy zzbfy) {
        this.zzehw = zzbfy;
    }

    public final void zza(zzbgo zzbgo) {
        this.zzeie = true;
        zzbfy zzbfy = this.zzehw;
        if (zzbfy != null) {
            zzbfy.zzsw();
            this.zzehw = null;
        }
        zzaaz();
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
        this.zzell.zza(str, predicate);
    }

    public final void zza(String str, zzaga<? super zzbek> zzaga) {
        this.zzell.zza(str, zzaga);
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzabo = this.zzehs.zzabo();
        zzub zzub = (!zzabo || this.zzehs.zzabh().zzaco()) ? this.zzceb : null;
        zzbgg zzbgg = zzabo ? null : new zzbgg(this.zzehs, this.zzdkt);
        zzafj zzafj = this.zzczu;
        zzafl zzafl = this.zzczw;
        zzt zzt = this.zzdkx;
        zzbek zzbek = this.zzehs;
        zza(new AdOverlayInfoParcel(zzub, (zzo) zzbgg, zzafj, zzafl, zzt, zzbek, z, i, str, zzbek.zzzk()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzabo = this.zzehs.zzabo();
        zzub zzub = (!zzabo || this.zzehs.zzabh().zzaco()) ? this.zzceb : null;
        zzbgg zzbgg = zzabo ? null : new zzbgg(this.zzehs, this.zzdkt);
        zzafj zzafj = this.zzczu;
        zzafl zzafl = this.zzczw;
        zzt zzt = this.zzdkx;
        zzbek zzbek = this.zzehs;
        zza(new AdOverlayInfoParcel(zzub, zzbgg, zzafj, zzafl, zzt, zzbek, z, i, str, str2, zzbek.zzzk()));
    }

    public final zzc zzaao() {
        return this.zzdas;
    }

    public final boolean zzaap() {
        return this.zzbne;
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
            this.zzeih = new zzbgd(this, zzaun);
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
        this.zzeif = true;
        zzaaz();
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

    public final void zzb(zzbgo zzbgo) {
        this.zzell.zzg(zzbgo.uri);
    }

    public final void zzb(String str, zzaga<? super zzbek> zzaga) {
        this.zzell.zzb(str, zzaga);
    }

    public final void zzb(boolean z, int i) {
        zzub zzub = (!this.zzehs.zzabo() || this.zzehs.zzabh().zzaco()) ? this.zzceb : null;
        zzo zzo = this.zzdkt;
        zzt zzt = this.zzdkx;
        zzbek zzbek = this.zzehs;
        zza(new AdOverlayInfoParcel(zzub, zzo, zzt, zzbek, z, i, zzbek.zzzk()));
    }

    public final boolean zzc(zzbgo zzbgo) {
        String valueOf = String.valueOf(zzbgo.url);
        zzawr.zzeg(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbgo.uri;
        if (this.zzell.zzg(uri)) {
            return true;
        }
        if (this.zzehy) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzub zzub = this.zzceb;
                if (zzub != null) {
                    zzub.onAdClicked();
                    zzaun zzaun = this.zzeid;
                    if (zzaun != null) {
                        zzaun.zzdy(zzbgo.url);
                    }
                    this.zzceb = null;
                }
                return false;
            }
        }
        if (!this.zzehs.getWebView().willNotDraw()) {
            try {
                zzdt zzabm = this.zzehs.zzabm();
                if (zzabm != null && zzabm.zzb(uri)) {
                    uri = zzabm.zza(uri, this.zzehs.getContext(), this.zzehs.getView(), this.zzehs.zzzh());
                }
            } catch (zzdw unused) {
                String valueOf2 = String.valueOf(zzbgo.url);
                zzazw.zzfc(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            zzc zzc = this.zzdas;
            if (zzc == null || zzc.zzjx()) {
                zza(new zzd("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.zzdas.zzbm(zzbgo.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbgo.url);
            zzazw.zzfc(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Nullable
    public final WebResourceResponse zzd(zzbgo zzbgo) {
        WebResourceResponse webResourceResponse;
        zzse zza;
        zzaun zzaun = this.zzeid;
        if (zzaun != null) {
            zzaun.zza(zzbgo.url, zzbgo.zzab, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbgo.url).getName())) {
            webResourceResponse = null;
        } else {
            zzui();
            String str = (String) zzvj.zzpv().zzd(this.zzehs.zzabh().zzaco() ? zzzz.zzcka : this.zzehs.zzabo() ? zzzz.zzcjz : zzzz.zzcjy);
            zzq.zzkw();
            webResourceResponse = zzaxa.zzd(this.zzehs.getContext(), this.zzehs.zzzk().zzbnd, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzavj.zzc(zzbgo.url, this.zzehs.getContext(), this.zzdov).equals(zzbgo.url)) {
                return zze(zzbgo);
            }
            zzsf zzbu = zzsf.zzbu(zzbgo.url);
            if (zzbu != null && (zza = zzq.zzlc().zza(zzbu)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzazq.isEnabled() || !zzabi.zzcwi.get().booleanValue()) {
                return null;
            }
            return zze(zzbgo);
        } catch (Exception | NoClassDefFoundError e) {
            zzq.zzla().zza(e, "AdWebViewClient.interceptRequest");
            return zzaba();
        }
    }

    public final void zzh(Uri uri) {
        this.zzell.zzh(uri);
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
            zzbab.zzdzv.execute(new zzbgb(this));
        }
    }
}
