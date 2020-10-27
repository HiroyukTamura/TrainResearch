package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzcdo extends zzaev {
    @Nullable
    private final String zzflf;
    private final zzbzx zzfqb;
    private final zzbzm zzftd;

    public zzcdo(@Nullable String str, zzbzm zzbzm, zzbzx zzbzx) {
        this.zzflf = str;
        this.zzftd = zzbzm;
        this.zzfqb = zzbzx;
    }

    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzftd.cancelUnconfirmedClick();
    }

    public final void destroy() throws RemoteException {
        this.zzftd.destroy();
    }

    public final String getAdvertiser() throws RemoteException {
        return this.zzfqb.getAdvertiser();
    }

    public final String getBody() throws RemoteException {
        return this.zzfqb.getBody();
    }

    public final String getCallToAction() throws RemoteException {
        return this.zzfqb.getCallToAction();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.zzfqb.getExtras();
    }

    public final String getHeadline() throws RemoteException {
        return this.zzfqb.getHeadline();
    }

    public final List<?> getImages() throws RemoteException {
        return this.zzfqb.getImages();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzflf;
    }

    public final List<?> getMuteThisAdReasons() throws RemoteException {
        return isCustomMuteThisAdEnabled() ? this.zzfqb.getMuteThisAdReasons() : Collections.emptyList();
    }

    public final String getPrice() throws RemoteException {
        return this.zzfqb.getPrice();
    }

    public final double getStarRating() throws RemoteException {
        return this.zzfqb.getStarRating();
    }

    public final String getStore() throws RemoteException {
        return this.zzfqb.getStore();
    }

    public final zzxl getVideoController() throws RemoteException {
        return this.zzfqb.getVideoController();
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzftd.isCustomClickGestureEnabled();
    }

    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return !this.zzfqb.getMuteThisAdReasons().isEmpty() && this.zzfqb.zzakz() != null;
    }

    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzftd.zzg(bundle);
    }

    public final void recordCustomClickGesture() {
        this.zzftd.recordCustomClickGesture();
    }

    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzftd.zzi(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzftd.zzh(bundle);
    }

    public final void zza(zzaer zzaer) throws RemoteException {
        this.zzftd.zza(zzaer);
    }

    public final void zza(zzws zzws) throws RemoteException {
        this.zzftd.zza(zzws);
    }

    public final void zza(@Nullable zzww zzww) throws RemoteException {
        this.zzftd.zza(zzww);
    }

    public final void zza(zzxf zzxf) throws RemoteException {
        this.zzftd.zza(zzxf);
    }

    public final zzxg zzki() throws RemoteException {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcua)).booleanValue()) {
            return null;
        }
        return this.zzftd.zzaia();
    }

    public final IObjectWrapper zzrz() throws RemoteException {
        return ObjectWrapper.wrap(this.zzftd);
    }

    public final zzacs zzsa() throws RemoteException {
        return this.zzfqb.zzsa();
    }

    public final zzack zzsb() throws RemoteException {
        return this.zzfqb.zzsb();
    }

    public final IObjectWrapper zzsc() throws RemoteException {
        return this.zzfqb.zzsc();
    }

    public final void zzsk() {
        this.zzftd.zzsk();
    }

    public final zzacr zzsl() throws RemoteException {
        return this.zzftd.zzakt().zzsl();
    }
}
