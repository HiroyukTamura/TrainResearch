package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcao extends zzadc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcbj {
    private final WeakReference<View> zzfsz;
    private final Map<String, WeakReference<View>> zzfta = new HashMap();
    private final Map<String, WeakReference<View>> zzftb = new HashMap();
    private final Map<String, WeakReference<View>> zzftc = new HashMap();
    private zzbzm zzftd;
    private zzpv zzfte;

    public zzcao(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzq.zzlt();
        zzbar.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzq.zzlt();
        zzbar.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfsz = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.zzfta.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzftc.putAll(this.zzfta);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.zzftb.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzftc.putAll(this.zzftb);
        this.zzfte = new zzpv(view.getContext(), view);
    }

    public final synchronized void onClick(View view) {
        if (this.zzftd != null) {
            this.zzftd.zza(view, zzahe(), zzaly(), zzalz(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzftd != null) {
            this.zzftd.zzb(zzahe(), zzaly(), zzalz(), zzbzm.zzy(zzahe()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzftd != null) {
            this.zzftd.zzb(zzahe(), zzaly(), zzalz(), zzbzm.zzy(zzahe()));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzftd != null) {
            this.zzftd.zza(view, motionEvent, zzahe());
        }
        return false;
    }

    public final synchronized void unregisterNativeAd() {
        if (this.zzftd != null) {
            this.zzftd.zzb(this);
            this.zzftd = null;
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbzm)) {
            zzazw.zzfc("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzftd != null) {
            this.zzftd.zzb(this);
        }
        if (((zzbzm) unwrap).zzakr()) {
            zzbzm zzbzm = (zzbzm) unwrap;
            this.zzftd = zzbzm;
            zzbzm.zza((zzcbj) this);
            this.zzftd.zzz(zzahe());
            return;
        }
        zzazw.zzfa("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzftc     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfta     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzftb     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzftc     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfta     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0047 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0047 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcao.zza(java.lang.String, android.view.View, boolean):void");
    }

    @Nullable
    public final View zzahe() {
        return (View) this.zzfsz.get();
    }

    @Nullable
    public final FrameLayout zzalw() {
        return null;
    }

    public final zzpv zzalx() {
        return this.zzfte;
    }

    public final synchronized Map<String, WeakReference<View>> zzaly() {
        return this.zzftc;
    }

    public final synchronized Map<String, WeakReference<View>> zzalz() {
        return this.zzfta;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzama() {
        return this.zzftb;
    }

    public final synchronized String zzamb() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Nullable
    public final synchronized IObjectWrapper zzamc() {
        return null;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzftd != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzazw.zzfc("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzftd.setClickConfirmingView((View) unwrap);
        }
    }

    public final synchronized View zzgd(String str) {
        WeakReference weakReference = this.zzftc.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }
}
