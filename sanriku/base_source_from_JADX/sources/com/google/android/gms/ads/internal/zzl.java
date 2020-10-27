package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzasn;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbab;
import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzrn;
import com.google.android.gms.internal.ads.zzuj;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzut;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwh;
import com.google.android.gms.internal.ads.zzwn;
import com.google.android.gms.internal.ads.zzxf;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzxr;
import com.google.android.gms.internal.ads.zzze;
import java.util.Map;
import java.util.concurrent.Future;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzl extends zzvy {
    /* access modifiers changed from: private */
    public final zzazz zzbmo;
    private final zzum zzbmp;
    /* access modifiers changed from: private */
    public final Future<zzdt> zzbmq = zzbab.zzdzr.zzd(new zzm(this));
    private final zzo zzbmr;
    /* access modifiers changed from: private */
    @Nullable
    public WebView zzbms = new WebView(this.zzvf);
    /* access modifiers changed from: private */
    @Nullable
    public zzvm zzbmt;
    /* access modifiers changed from: private */
    @Nullable
    public zzdt zzbmu;
    private AsyncTask<Void, Void, String> zzbmv;
    /* access modifiers changed from: private */
    public final Context zzvf;

    public zzl(Context context, zzum zzum, String str, zzazz zzazz) {
        this.zzvf = context;
        this.zzbmo = zzazz;
        this.zzbmp = zzum;
        this.zzbmr = new zzo(context, str);
        zzbn(0);
        this.zzbms.setVerticalScrollBarEnabled(false);
        this.zzbms.getSettings().setJavaScriptEnabled(true);
        this.zzbms.setWebViewClient(new zzk(this));
        this.zzbms.setOnTouchListener(new zzn(this));
    }

    /* access modifiers changed from: private */
    public final String zzbp(String str) {
        if (this.zzbmu == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbmu.zza(parse, this.zzvf, (View) null, (Activity) null);
        } catch (zzdw e) {
            zzazw.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzbq(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.zzvf.startActivity(intent);
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbmv.cancel(true);
        this.zzbmq.cancel(true);
        this.zzbms.destroy();
        this.zzbms = null;
    }

    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Nullable
    public final zzxl getVideoController() {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void stopLoading() throws RemoteException {
    }

    public final void zza(zzaas zzaas) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzapq zzapq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzapw zzapw, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzasn zzasn) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzrn zzrn) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzum zzum) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zza(zzut zzut) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzvl zzvl) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzvm zzvm) throws RemoteException {
        this.zzbmt = zzvm;
    }

    public final void zza(zzwc zzwc) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwh zzwh) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwn zzwn) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzxf zzxf) {
    }

    public final void zza(zzxr zzxr) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzze zzze) {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zza(zzuj zzuj) throws RemoteException {
        Preconditions.checkNotNull(this.zzbms, "This Search Ad has already been torn down");
        this.zzbmr.zza(zzuj, this.zzbmo);
        this.zzbmv = new zzp(this, (zzk) null).execute(new Void[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzbn(int i) {
        if (this.zzbms != null) {
            this.zzbms.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    public final void zzbn(String str) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zzbo(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzvj.zzpr();
            return zzazm.zzc(this.zzvf, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final IObjectWrapper zzke() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbms);
    }

    public final void zzkf() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzum zzkg() throws RemoteException {
        return this.zzbmp;
    }

    @Nullable
    public final String zzkh() throws RemoteException {
        return null;
    }

    @Nullable
    public final zzxg zzki() {
        return null;
    }

    public final zzwh zzkj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzvm zzkk() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzkl() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzabd.zzcvr.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzbmr.getQuery());
        builder.appendQueryParameter("pubId", this.zzbmr.zzko());
        Map<String, String> zzkp = this.zzbmr.zzkp();
        for (String next : zzkp.keySet()) {
            builder.appendQueryParameter(next, zzkp.get(next));
        }
        Uri build = builder.build();
        zzdt zzdt = this.zzbmu;
        if (zzdt != null) {
            try {
                build = zzdt.zza(build, this.zzvf);
            } catch (zzdw e) {
                zzazw.zzd("Unable to process ad data", e);
            }
        }
        String zzkm = zzkm();
        String encodedQuery = build.getEncodedQuery();
        return C0681a.m313a(C0681a.m336b(encodedQuery, C0681a.m336b(zzkm, 1)), zzkm, "#", encodedQuery);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzkm() {
        String zzkn = this.zzbmr.zzkn();
        if (TextUtils.isEmpty(zzkn)) {
            zzkn = "www.google.com";
        }
        String str = zzabd.zzcvr.get();
        return C0681a.m313a(C0681a.m336b(str, C0681a.m336b(zzkn, 8)), "https://", zzkn, str);
    }
}
