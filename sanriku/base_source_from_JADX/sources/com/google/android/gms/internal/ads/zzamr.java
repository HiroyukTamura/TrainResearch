package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class zzamr extends zzamc {
    private final NativeContentAdMapper zzdhf;

    public zzamr(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdhf = nativeContentAdMapper;
    }

    public final String getAdvertiser() {
        return this.zzdhf.getAdvertiser();
    }

    public final String getBody() {
        return this.zzdhf.getBody();
    }

    public final String getCallToAction() {
        return this.zzdhf.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzdhf.getExtras();
    }

    public final String getHeadline() {
        return this.zzdhf.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdhf.getImages();
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
        return this.zzdhf.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdhf.getOverrideImpressionRecording();
    }

    public final zzxl getVideoController() {
        if (this.zzdhf.getVideoController() != null) {
            return this.zzdhf.getVideoController().zzdu();
        }
        return null;
    }

    public final void recordImpression() {
        this.zzdhf.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdhf.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzack zzsb() {
        return null;
    }

    public final IObjectWrapper zzsc() {
        return null;
    }

    public final zzacs zzsd() {
        NativeAd.Image logo = this.zzdhf.getLogo();
        if (logo != null) {
            return new zzace(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    public final IObjectWrapper zztr() {
        View adChoicesContent = this.zzdhf.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzts() {
        View zzacu = this.zzdhf.zzacu();
        if (zzacu == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacu);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdhf.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdhf.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdhf.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
