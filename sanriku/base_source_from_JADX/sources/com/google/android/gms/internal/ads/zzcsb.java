package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public class zzcsb extends zzalu {
    private final zzbsh zzfkr;
    private final zzbrx zzflh;
    private final zzbre zzfow;
    private final zzbsu zzfpb;
    private final zzbro zzfqc;
    private final zzbqw zzfqd;
    private final zzbtw zzfwo;
    private final zzbtp zzgho;
    private final zzbwi zzghy;

    public zzcsb(zzbqw zzbqw, zzbro zzbro, zzbrx zzbrx, zzbsh zzbsh, zzbtw zzbtw, zzbsu zzbsu, zzbwi zzbwi, zzbtp zzbtp, zzbre zzbre) {
        this.zzfqd = zzbqw;
        this.zzfqc = zzbro;
        this.zzflh = zzbrx;
        this.zzfkr = zzbsh;
        this.zzfwo = zzbtw;
        this.zzfpb = zzbsu;
        this.zzghy = zzbwi;
        this.zzgho = zzbtp;
        this.zzfow = zzbre;
    }

    public final void onAdClicked() {
        this.zzfqd.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzfpb.zztz();
    }

    public final void onAdFailedToLoad(int i) {
    }

    public void onAdImpression() {
        this.zzfqc.onAdImpression();
        this.zzgho.zzaiy();
    }

    public final void onAdLeftApplication() {
        this.zzflh.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzfkr.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzfpb.zzua();
        this.zzgho.zzaiz();
    }

    public final void onAppEvent(String str, String str2) {
        this.zzfwo.onAppEvent(str, str2);
    }

    public void onVideoEnd() {
        this.zzghy.onVideoEnd();
    }

    public final void onVideoPause() {
        this.zzghy.onVideoPause();
    }

    public final void onVideoPlay() throws RemoteException {
        this.zzghy.onVideoPlay();
    }

    public final void zza(zzado zzado, String str) {
    }

    public final void zza(zzalw zzalw) {
    }

    public void zza(zzate zzate) throws RemoteException {
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public void zzb(zzatc zzatc) {
    }

    public final void zzc(int i, String str) {
    }

    @Deprecated
    public final void zzcx(int i) throws RemoteException {
        this.zzfow.zzf(i, (String) null);
    }

    public final void zzdl(String str) {
    }

    public final void zzdm(String str) {
        this.zzfow.zzf(0, str);
    }

    public void zztp() {
        this.zzghy.onVideoStart();
    }

    public void zztq() throws RemoteException {
    }
}
