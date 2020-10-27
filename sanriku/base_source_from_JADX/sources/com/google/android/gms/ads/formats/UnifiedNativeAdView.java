package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzacj;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzacw;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzyg;
import com.google.android.gms.internal.ads.zzzz;

public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbld;
    private final zzacw zzble = zzjs();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbld = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbld = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbld = zzd(context);
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbld = zzd(context);
    }

    private final void zza(String str, View view) {
        try {
            this.zzble.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzazw.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    private final View zzbl(String str) {
        try {
            IObjectWrapper zzcq = this.zzble.zzcq(str);
            if (zzcq != null) {
                return (View) ObjectWrapper.unwrap(zzcq);
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzacw zzjs() {
        Preconditions.checkNotNull(this.zzbld, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzvj.zzps().zza(this.zzbld.getContext(), (FrameLayout) this, this.zzbld);
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbld);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbld;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void destroy() {
        try {
            this.zzble.destroy();
        } catch (RemoteException e) {
            zzazw.zzc("Unable to destroy native ad view", e);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzacw zzacw;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcoj)).booleanValue() && (zzacw = this.zzble) != null) {
            try {
                zzacw.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbl = zzbl(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbl instanceof AdChoicesView) {
            return (AdChoicesView) zzbl;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getBodyView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getCallToActionView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getHeadlineView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getIconView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getImageView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final MediaView getMediaView() {
        View zzbl = zzbl(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (zzbl instanceof MediaView) {
            return (MediaView) zzbl;
        }
        if (zzbl == null) {
            return null;
        }
        zzazw.zzed("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getStarRatingView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final View getStoreView() {
        return zzbl(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzacw zzacw = this.zzble;
        if (zzacw != null) {
            try {
                zzacw.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbld);
    }

    public final void removeView(View view) {
        if (this.zzbld != view) {
            super.removeView(view);
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzble.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzazw.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
        if (mediaView != null) {
            mediaView.zza((zzach) new zze(this));
            mediaView.zza((zzacj) new zzd(this));
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzble.zza((IObjectWrapper) unifiedNativeAd.zzjq());
        } catch (RemoteException e) {
            zzazw.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.zzble.zzg(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzyg) {
                this.zzble.zza(((zzyg) mediaContent).zzqr());
            } else if (mediaContent == null) {
                this.zzble.zza((zzacr) null);
            } else {
                zzazw.zzed("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzazw.zzc("Unable to call setMediaContent on delegate", e);
        }
    }
}
