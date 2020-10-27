package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;

@VisibleForTesting
public interface zzbek extends zzi, zzaif, zzajc, zzbbx, zzbfj, zzbfm, zzbfq, zzbfr, zzbft, zzbfu, zzpz {
    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(zzc zzc);

    void zza(zzacf zzacf);

    void zza(zzacg zzacg);

    void zza(zzbfe zzbfe);

    void zza(zzbfz zzbfz);

    void zza(zzrh zzrh);

    void zza(String str, Predicate<zzaga<? super zzbek>> predicate);

    void zza(String str, zzaga<? super zzbek> zzaga);

    void zza(String str, zzbdl zzbdl);

    void zzabc();

    void zzabd();

    Context zzabe();

    zzc zzabf();

    zzc zzabg();

    zzbfz zzabh();

    String zzabi();

    @Nullable
    zzbfw zzabj();

    WebViewClient zzabk();

    boolean zzabl();

    zzdt zzabm();

    @Nullable
    IObjectWrapper zzabn();

    boolean zzabo();

    void zzabp();

    boolean zzabq();

    boolean zzabr();

    void zzabs();

    void zzabt();

    zzacg zzabu();

    void zzabv();

    void zzabw();

    zzrh zzabx();

    boolean zzaby();

    zzrv zzabz();

    boolean zzaca();

    void zzal(boolean z);

    void zzap(IObjectWrapper iObjectWrapper);

    void zzax(boolean z);

    void zzb(zzc zzc);

    void zzb(String str, zzaga<? super zzbek> zzaga);

    void zzb(String str, String str2, @Nullable String str3);

    void zzba(boolean z);

    void zzbb(boolean z);

    void zzbc(boolean z);

    void zzbt(Context context);

    boolean zzc(boolean z, int i);

    void zzdn(int i);

    void zzum();

    @Nullable
    zzbfe zzzf();

    Activity zzzh();

    zza zzzi();

    zzaan zzzj();

    zzazz zzzk();
}
