package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzdgi extends zzasj {
    private final zzdgz zzfmx;
    private boolean zzgjy = false;
    private final zzdfw zzgsz;
    private final zzdez zzgta;
    /* access modifiers changed from: private */
    @Nullable
    public zzcel zzgtb;

    public zzdgi(zzdfw zzdfw, zzdez zzdez, zzdgz zzdgz) {
        this.zzgsz = zzdfw;
        this.zzgta = zzdez;
        this.zzfmx = zzdgz;
    }

    private final synchronized boolean zzapm() {
        return this.zzgtb != null && !this.zzgtb.isClosed();
    }

    public final void destroy() throws RemoteException {
        zzl((IObjectWrapper) null);
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzcel zzcel = this.zzgtb;
        return zzcel != null ? zzcel.getAdMetadata() : new Bundle();
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgtb == null || this.zzgtb.zzaia() == null) {
            return null;
        }
        return this.zzgtb.zzaia().getMediationAdapterClassName();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzapm();
    }

    public final void pause() {
        zzj((IObjectWrapper) null);
    }

    public final void resume() {
        zzk((IObjectWrapper) null);
    }

    public final void setAppPackageName(String str) throws RemoteException {
    }

    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcln)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfmx.zzdrg = str;
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgjy = z;
    }

    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfmx.zzdrf = str;
    }

    public final synchronized void show() throws RemoteException {
        zzi((IObjectWrapper) null);
    }

    public final void zza(zzasi zzasi) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzgta.zzb(zzasi);
    }

    public final void zza(zzasn zzasn) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzgta.zzb(zzasn);
    }

    public final synchronized void zza(zzast zzast) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzaab.zzcr(zzast.zzbsc)) {
            if (zzapm()) {
                if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcrl)).booleanValue()) {
                    return;
                }
            }
            zzdft zzdft = new zzdft((String) null);
            this.zzgtb = null;
            this.zzgsz.zzdt(zzdgw.zzguj);
            this.zzgsz.zza(zzast.zzdlx, zzast.zzbsc, zzdft, new zzdgh(this));
        }
    }

    public final void zza(zzwc zzwc) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzwc == null) {
            this.zzgta.zza((AdMetadataListener) null);
        } else {
            this.zzgta.zza((AdMetadataListener) new zzdgk(this, zzwc));
        }
    }

    public final synchronized void zzi(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzgtb != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzgtb.zzb(this.zzgjy, activity);
                }
            }
            activity = null;
            this.zzgtb.zzb(this.zzgjy, activity);
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgtb != null) {
            this.zzgtb.zzahz().zzbx(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgtb != null) {
            this.zzgtb.zzahz().zzby(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final synchronized zzxg zzki() throws RemoteException {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcua)).booleanValue()) {
            return null;
        }
        if (this.zzgtb == null) {
            return null;
        }
        return this.zzgtb.zzaia();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdez r0 = r2.zzgta     // Catch:{ all -> 0x0025 }
            r1 = 0
            r0.zza((com.google.android.gms.ads.reward.AdMetadataListener) r1)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcel r0 = r2.zzgtb     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0025 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0025 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzcel r3 = r2.zzgtb     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbrr r3 = r3.zzahz()     // Catch:{ all -> 0x0025 }
            r3.zzbz(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdgi.zzl(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final boolean zzqu() {
        zzcel zzcel = this.zzgtb;
        return zzcel != null && zzcel.zzqu();
    }
}
