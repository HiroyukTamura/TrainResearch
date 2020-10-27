package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzq;

public final class zzazj {
    private final View view;
    private boolean zzbpc;
    private boolean zzbtg;
    private Activity zzdys;
    private boolean zzdyt;
    private ViewTreeObserver.OnGlobalLayoutListener zzdyu;
    private ViewTreeObserver.OnScrollChangedListener zzdyv = null;

    public zzazj(Activity activity, View view2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzdys = activity;
        this.view = view2;
        this.zzdyu = onGlobalLayoutListener;
    }

    private static ViewTreeObserver zzi(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void zzyb() {
        ViewTreeObserver zzi;
        if (!this.zzdyt) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdyu;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.zzdys;
                if (!(activity == null || (zzi = zzi(activity)) == null)) {
                    zzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
                zzq.zzlt();
                zzbar.zza(this.view, this.zzdyu);
            }
            this.zzdyt = true;
        }
    }

    private final void zzyc() {
        ViewTreeObserver zzi;
        Activity activity = this.zzdys;
        if (activity != null && this.zzdyt) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdyu;
            if (!(onGlobalLayoutListener == null || (zzi = zzi(activity)) == null)) {
                zzq.zzky();
                zzi.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzdyt = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzbpc = true;
        if (this.zzbtg) {
            zzyb();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbpc = false;
        zzyc();
    }

    public final void zzh(Activity activity) {
        this.zzdys = activity;
    }

    public final void zzxz() {
        this.zzbtg = true;
        if (this.zzbpc) {
            zzyb();
        }
    }

    public final void zzya() {
        this.zzbtg = false;
        zzyc();
    }
}
