package com.google.android.gms.ads.appopen;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzrj;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzvz;

public final class AppOpenAdView extends ViewGroup {
    private AppOpenAd zzadb;
    private AppOpenAdPresentationCallback zzadc;

    public AppOpenAdView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private final AdSize getAdSize() {
        zzvz zzdv = this.zzadb.zzdv();
        if (zzdv == null) {
            return null;
        }
        try {
            zzum zzkg = zzdv.zzkg();
            if (zzkg != null) {
                return zzkg.zzpl();
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    private final void zzdw() {
        AppOpenAd appOpenAd = this.zzadb;
        if (appOpenAd != null && this.zzadc != null) {
            appOpenAd.zza(new zzrj(this.zzadc));
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    public final void onMeasure(int i, int i2) {
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

    public final void setAppOpenAd(AppOpenAd appOpenAd) {
        IObjectWrapper zzke;
        try {
            zzvz zzdv = appOpenAd.zzdv();
            if (zzdv != null && (zzke = zzdv.zzke()) != null) {
                View view = (View) ObjectWrapper.unwrap(zzke);
                if (view.getParent() == null) {
                    removeAllViews();
                    addView(view);
                    this.zzadb = appOpenAd;
                    zzdw();
                    return;
                }
                zzazw.zzfa("Trying to set AppOpenAd which is already in use.");
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAppOpenAdPresentationCallback(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzadc = appOpenAdPresentationCallback;
        zzdw();
    }
}
