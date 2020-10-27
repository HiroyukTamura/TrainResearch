package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class zzamo extends zzamb {
    private final NativeAppInstallAdMapper zzdha;

    public zzamo(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdha = nativeAppInstallAdMapper;
    }

    public final String getBody() {
        return this.zzdha.getBody();
    }

    public final String getCallToAction() {
        return this.zzdha.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzdha.getExtras();
    }

    public final String getHeadline() {
        return this.zzdha.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdha.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzace(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
        }
        return arrayList;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdha.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdha.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.zzdha.getPrice();
    }

    public final double getStarRating() {
        return this.zzdha.getStarRating();
    }

    public final String getStore() {
        return this.zzdha.getStore();
    }

    public final zzxl getVideoController() {
        if (this.zzdha.getVideoController() != null) {
            return this.zzdha.getVideoController().zzdu();
        }
        return null;
    }

    public final void recordImpression() {
        this.zzdha.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdha.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzacs zzsa() {
        NativeAd.Image icon = this.zzdha.getIcon();
        if (icon != null) {
            return new zzace(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final zzack zzsb() {
        return null;
    }

    public final IObjectWrapper zzsc() {
        return null;
    }

    public final IObjectWrapper zztr() {
        View adChoicesContent = this.zzdha.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzts() {
        View zzacu = this.zzdha.zzacu();
        if (zzacu == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacu);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdha.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdha.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdha.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
