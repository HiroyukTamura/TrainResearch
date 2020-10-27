package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.C0655R;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzbev extends FrameLayout implements zzbek {
    /* access modifiers changed from: private */
    public final zzbek zzeje;
    private final zzbbq zzejf;
    private final AtomicBoolean zzejg = new AtomicBoolean();

    public zzbev(zzbek zzbek) {
        super(zzbek.getContext());
        this.zzeje = zzbek;
        this.zzejf = new zzbbq(zzbek.zzabe(), this, this);
        if (!zzaca()) {
            addView(this.zzeje.getView());
        }
    }

    public final void destroy() {
        IObjectWrapper zzabn = zzabn();
        if (zzabn != null) {
            zzaxa.zzdwf.post(new zzbey(zzabn));
            zzaxa.zzdwf.postDelayed(new zzbex(this), (long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcqx)).intValue());
            return;
        }
        this.zzeje.destroy();
    }

    public final String getRequestId() {
        return this.zzeje.getRequestId();
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this.zzeje.getWebView();
    }

    public final boolean isDestroyed() {
        return this.zzeje.isDestroyed();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zzeje.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzeje.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.zzeje.loadUrl(str);
    }

    public final void onPause() {
        this.zzejf.onPause();
        this.zzeje.onPause();
    }

    public final void onResume() {
        this.zzeje.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeje.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzeje.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.zzeje.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzeje.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzeje.setWebViewClient(webViewClient);
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.zzeje.zza(this, activity, str, str2);
    }

    public final void zza(zzc zzc) {
        this.zzeje.zza(zzc);
    }

    public final void zza(zzd zzd) {
        this.zzeje.zza(zzd);
    }

    public final void zza(zzacf zzacf) {
        this.zzeje.zza(zzacf);
    }

    public final void zza(@Nullable zzacg zzacg) {
        this.zzeje.zza(zzacg);
    }

    public final void zza(zzbfe zzbfe) {
        this.zzeje.zza(zzbfe);
    }

    public final void zza(zzbfz zzbfz) {
        this.zzeje.zza(zzbfz);
    }

    public final void zza(zzqa zzqa) {
        this.zzeje.zza(zzqa);
    }

    public final void zza(zzrh zzrh) {
        this.zzeje.zza(zzrh);
    }

    public final void zza(String str, Predicate<zzaga<? super zzbek>> predicate) {
        this.zzeje.zza(str, predicate);
    }

    public final void zza(String str, zzaga<? super zzbek> zzaga) {
        this.zzeje.zza(str, zzaga);
    }

    public final void zza(String str, zzbdl zzbdl) {
        this.zzeje.zza(str, zzbdl);
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzeje.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzeje.zza(str, jSONObject);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzeje.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeje.zza(z, i, str, str2);
    }

    public final void zza(boolean z, long j) {
        this.zzeje.zza(z, j);
    }

    public final void zzabc() {
        this.zzeje.zzabc();
    }

    public final void zzabd() {
        this.zzeje.zzabd();
    }

    public final Context zzabe() {
        return this.zzeje.zzabe();
    }

    public final zzc zzabf() {
        return this.zzeje.zzabf();
    }

    public final zzc zzabg() {
        return this.zzeje.zzabg();
    }

    public final zzbfz zzabh() {
        return this.zzeje.zzabh();
    }

    public final String zzabi() {
        return this.zzeje.zzabi();
    }

    public final zzbfw zzabj() {
        return this.zzeje.zzabj();
    }

    public final WebViewClient zzabk() {
        return this.zzeje.zzabk();
    }

    public final boolean zzabl() {
        return this.zzeje.zzabl();
    }

    public final zzdt zzabm() {
        return this.zzeje.zzabm();
    }

    public final IObjectWrapper zzabn() {
        return this.zzeje.zzabn();
    }

    public final boolean zzabo() {
        return this.zzeje.zzabo();
    }

    public final void zzabp() {
        this.zzejf.onDestroy();
        this.zzeje.zzabp();
    }

    public final boolean zzabq() {
        return this.zzeje.zzabq();
    }

    public final boolean zzabr() {
        return this.zzeje.zzabr();
    }

    public final void zzabs() {
        this.zzeje.zzabs();
    }

    public final void zzabt() {
        this.zzeje.zzabt();
    }

    @Nullable
    public final zzacg zzabu() {
        return this.zzeje.zzabu();
    }

    public final void zzabv() {
        setBackgroundColor(0);
        this.zzeje.setBackgroundColor(0);
    }

    public final void zzabw() {
        TextView textView = new TextView(getContext());
        Resources resources = zzq.zzla().getResources();
        textView.setText(resources != null ? resources.getString(C0655R.string.f352s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final zzrh zzabx() {
        return this.zzeje.zzabx();
    }

    public final boolean zzaby() {
        return this.zzejg.get();
    }

    public final zzrv zzabz() {
        return this.zzeje.zzabz();
    }

    public final boolean zzaca() {
        return this.zzeje.zzaca();
    }

    public final void zzal(boolean z) {
        this.zzeje.zzal(z);
    }

    public final void zzap(IObjectWrapper iObjectWrapper) {
        this.zzeje.zzap(iObjectWrapper);
    }

    public final void zzav(boolean z) {
        this.zzeje.zzav(z);
    }

    public final void zzax(boolean z) {
        this.zzeje.zzax(z);
    }

    public final void zzb(zzc zzc) {
        this.zzeje.zzb(zzc);
    }

    public final void zzb(String str, zzaga<? super zzbek> zzaga) {
        this.zzeje.zzb(str, zzaga);
    }

    public final void zzb(String str, String str2, @Nullable String str3) {
        this.zzeje.zzb(str, str2, str3);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzeje.zzb(str, jSONObject);
    }

    public final void zzb(boolean z, int i) {
        this.zzeje.zzb(z, i);
    }

    public final void zzba(boolean z) {
        this.zzeje.zzba(z);
    }

    public final void zzbb(boolean z) {
        this.zzeje.zzbb(z);
    }

    public final void zzbc(boolean z) {
        this.zzeje.zzbc(z);
    }

    public final void zzbt(Context context) {
        this.zzeje.zzbt(context);
    }

    public final boolean zzc(boolean z, int i) {
        if (!this.zzejg.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzclf)).booleanValue()) {
            return false;
        }
        if (this.zzeje.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzeje.getParent()).removeView(this.zzeje.getView());
        }
        return this.zzeje.zzc(z, i);
    }

    public final void zzda(String str) {
        this.zzeje.zzda(str);
    }

    public final void zzdn(int i) {
        this.zzeje.zzdn(i);
    }

    public final zzbdl zzfh(String str) {
        return this.zzeje.zzfh(str);
    }

    public final void zzkc() {
        this.zzeje.zzkc();
    }

    public final void zzkd() {
        this.zzeje.zzkd();
    }

    public final void zzum() {
        this.zzeje.zzum();
    }

    public final void zzun() {
        this.zzeje.zzun();
    }

    public final zzbbq zzze() {
        return this.zzejf;
    }

    public final zzbfe zzzf() {
        return this.zzeje.zzzf();
    }

    public final zzaak zzzg() {
        return this.zzeje.zzzg();
    }

    public final Activity zzzh() {
        return this.zzeje.zzzh();
    }

    public final zza zzzi() {
        return this.zzeje.zzzi();
    }

    public final zzaan zzzj() {
        return this.zzeje.zzzj();
    }

    public final zzazz zzzk() {
        return this.zzeje.zzzk();
    }

    public final int zzzl() {
        return getMeasuredHeight();
    }

    public final int zzzm() {
        return getMeasuredWidth();
    }

    public final void zzzn() {
        this.zzeje.zzzn();
    }
}
