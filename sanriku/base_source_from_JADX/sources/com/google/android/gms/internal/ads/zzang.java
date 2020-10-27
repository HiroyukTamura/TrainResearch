package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class zzang extends zzamh {
    private final UnifiedNativeAdMapper zzdhk;

    public zzang(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdhk = unifiedNativeAdMapper;
    }

    public final String getAdvertiser() {
        return this.zzdhk.getAdvertiser();
    }

    public final String getBody() {
        return this.zzdhk.getBody();
    }

    public final String getCallToAction() {
        return this.zzdhk.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzdhk.getExtras();
    }

    public final String getHeadline() {
        return this.zzdhk.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdhk.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image next : images) {
                arrayList.add(new zzace(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
            }
        }
        return arrayList;
    }

    public final float getMediaContentAspectRatio() {
        return this.zzdhk.getMediaContentAspectRatio();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdhk.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdhk.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.zzdhk.getPrice();
    }

    public final double getStarRating() {
        if (this.zzdhk.getStarRating() != null) {
            return this.zzdhk.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.zzdhk.getStore();
    }

    public final zzxl getVideoController() {
        if (this.zzdhk.getVideoController() != null) {
            return this.zzdhk.getVideoController().zzdu();
        }
        return null;
    }

    public final float getVideoCurrentTime() {
        return this.zzdhk.getCurrentTime();
    }

    public final float getVideoDuration() {
        return this.zzdhk.getDuration();
    }

    public final void recordImpression() {
        this.zzdhk.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdhk.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzacs zzsa() {
        NativeAd.Image icon = this.zzdhk.getIcon();
        if (icon != null) {
            return new zzace(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final zzack zzsb() {
        return null;
    }

    public final IObjectWrapper zzsc() {
        Object zzjv = this.zzdhk.zzjv();
        if (zzjv == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzjv);
    }

    public final IObjectWrapper zztr() {
        View adChoicesContent = this.zzdhk.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzts() {
        View zzacu = this.zzdhk.zzacu();
        if (zzacu == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacu);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdhk.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdhk.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
