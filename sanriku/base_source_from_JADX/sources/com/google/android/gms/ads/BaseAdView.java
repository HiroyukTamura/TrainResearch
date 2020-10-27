package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzxv;

class BaseAdView extends ViewGroup {
    protected final zzxv zzacm;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzacm = new zzxv(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzacm = new zzxv(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzacm = new zzxv(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzacm.destroy();
    }

    public AdListener getAdListener() {
        return this.zzacm.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzacm.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzacm.getAdUnitId();
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        return this.zzacm.getMediationAdapterClassName();
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        return this.zzacm.getResponseInfo();
    }

    public boolean isLoading() {
        return this.zzacm.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzacm.zza(adRequest.zzdq());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzazw.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zzacm.pause();
    }

    public void resume() {
        this.zzacm.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzacm.setAdListener(adListener);
        if (adListener == null) {
            this.zzacm.zza((zzub) null);
            this.zzacm.setAppEventListener((AppEventListener) null);
            return;
        }
        if (adListener instanceof zzub) {
            this.zzacm.zza((zzub) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzacm.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzacm.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzacm.setAdUnitId(str);
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzacm.setOnPaidEventListener(onPaidEventListener);
    }
}
