package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzdgc extends zzati {
    private final String zzbsc;
    private final zzdgz zzfmx;
    private final Context zzgiz;
    private final zzdfw zzgsz;
    private final zzdez zzgta;
    /* access modifiers changed from: private */
    @Nullable
    public zzcel zzgtb;

    public zzdgc(@Nullable String str, zzdfw zzdfw, Context context, zzdez zzdez, zzdgz zzdgz) {
        this.zzbsc = str;
        this.zzgsz = zzdfw;
        this.zzgta = zzdez;
        this.zzfmx = zzdgz;
        this.zzgiz = context;
    }

    private final synchronized void zza(zzuj zzuj, zzatn zzatn, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgta.zzb(zzatn);
        zzq.zzkw();
        if (zzaxa.zzbd(this.zzgiz) && zzuj.zzceu == null) {
            zzazw.zzfa("Failed to load the ad because app ID is missing.");
            this.zzgta.onAdFailedToLoad(8);
        } else if (this.zzgtb == null) {
            zzdft zzdft = new zzdft((String) null);
            this.zzgsz.zzdt(i);
            this.zzgsz.zza(zzuj, this.zzbsc, zzdft, new zzdge(this));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcel zzcel = this.zzgtb;
        return zzcel != null ? zzcel.getAdMetadata() : new Bundle();
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgtb == null || this.zzgtb.zzaia() == null) {
            return null;
        }
        return this.zzgtb.zzaia().getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcel zzcel = this.zzgtb;
        return zzcel != null && !zzcel.zzamq();
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzgtb == null) {
            zzazw.zzfc("Rewarded can not be shown before loaded");
            this.zzgta.zzcx(2);
            return;
        }
        this.zzgtb.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(zzatk zzatk) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgta.zzb(zzatk);
    }

    public final void zza(zzats zzats) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgta.zzb(zzats);
    }

    public final synchronized void zza(zzaua zzaua) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdgz zzdgz = this.zzfmx;
        zzdgz.zzdrf = zzaua.zzdrf;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcln)).booleanValue()) {
            zzdgz.zzdrg = zzaua.zzdrg;
        }
    }

    public final synchronized void zza(zzuj zzuj, zzatn zzatn) throws RemoteException {
        zza(zzuj, zzatn, zzdgw.zzguk);
    }

    public final void zza(zzxa zzxa) {
        if (zzxa == null) {
            this.zzgta.zza((AdMetadataListener) null);
        } else {
            this.zzgta.zza((AdMetadataListener) new zzdgb(this, zzxa));
        }
    }

    public final void zza(zzxf zzxf) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzgta.zzc(zzxf);
    }

    public final synchronized void zzb(zzuj zzuj, zzatn zzatn) throws RemoteException {
        zza(zzuj, zzatn, zzdgw.zzgul);
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    public final zzxg zzki() {
        zzcel zzcel;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcua)).booleanValue() && (zzcel = this.zzgtb) != null) {
            return zzcel.zzaia();
        }
        return null;
    }

    @Nullable
    public final zzate zzqt() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcel zzcel = this.zzgtb;
        if (zzcel != null) {
            return zzcel.zzqt();
        }
        return null;
    }
}
