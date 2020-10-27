package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcar extends zzacz implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcbj {
    public static final String[] zzfth = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private FrameLayout zzbld;
    private zzacr zzchr;
    private Map<String, WeakReference<View>> zzdli = new HashMap();
    private final int zzdzo;
    private boolean zzejx = false;
    private zzbzm zzftd;
    private zzpv zzfte;
    private final String zzftg;
    private FrameLayout zzfti;
    private zzdrh zzftj;
    private View zzftk;
    private IObjectWrapper zzftl = null;
    private boolean zzftm;

    public zzcar(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzfti = frameLayout;
        this.zzbld = frameLayout2;
        this.zzdzo = i;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzftg = str;
        zzq.zzlt();
        zzbar.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzq.zzlt();
        zzbar.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzftj = zzbab.zzdzv;
        this.zzfte = new zzpv(this.zzfti.getContext(), this.zzfti);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzamd() {
        this.zzftj.execute(new zzcaq(this));
    }

    public final synchronized void destroy() {
        if (!this.zzejx) {
            if (this.zzftd != null) {
                this.zzftd.zzb(this);
                this.zzftd = null;
            }
            this.zzdli.clear();
            this.zzfti.removeAllViews();
            this.zzbld.removeAllViews();
            this.zzdli = null;
            this.zzfti = null;
            this.zzbld = null;
            this.zzftk = null;
            this.zzfte = null;
            this.zzejx = true;
        }
    }

    public final synchronized void onClick(View view) {
        if (this.zzftd != null) {
            this.zzftd.cancelUnconfirmedClick();
            this.zzftd.zza(view, this.zzfti, zzaly(), zzalz(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzftd != null) {
            this.zzftd.zzb(this.zzfti, zzaly(), zzalz(), zzbzm.zzy(this.zzfti));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzftd != null) {
            this.zzftd.zzb(this.zzfti, zzaly(), zzalz(), zzbzm.zzy(this.zzfti));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzftd != null) {
            this.zzftd.zza(view, motionEvent, this.zzfti);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzejx     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x0048 }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzbzm     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.internal.ads.zzazw.zzfc(r2)     // Catch:{ all -> 0x0048 }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzbzm r0 = r1.zzftd     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzbzm r0 = r1.zzftd     // Catch:{ all -> 0x0048 }
            r0.zzb(r1)     // Catch:{ all -> 0x0048 }
        L_0x001f:
            r1.zzamd()     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbzm r2 = (com.google.android.gms.internal.ads.zzbzm) r2     // Catch:{ all -> 0x0048 }
            r1.zzftd = r2     // Catch:{ all -> 0x0048 }
            r2.zza((com.google.android.gms.internal.ads.zzcbj) r1)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbzm r2 = r1.zzftd     // Catch:{ all -> 0x0048 }
            android.widget.FrameLayout r0 = r1.zzfti     // Catch:{ all -> 0x0048 }
            r2.zzz(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbzm r2 = r1.zzftd     // Catch:{ all -> 0x0048 }
            android.widget.FrameLayout r0 = r1.zzbld     // Catch:{ all -> 0x0048 }
            r2.zzaa(r0)     // Catch:{ all -> 0x0048 }
            boolean r2 = r1.zzftm     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzbzm r2 = r1.zzftd     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbzs r2 = r2.zzakt()     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzacr r0 = r1.zzchr     // Catch:{ all -> 0x0048 }
            r2.zza(r0)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r1)
            return
        L_0x0048:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcar.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzacr r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzejx     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.zzftm = r0     // Catch:{ all -> 0x001b }
            r1.zzchr = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzbzm r0 = r1.zzftd     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzbzm r0 = r1.zzftd     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzbzs r0 = r0.zzakt()     // Catch:{ all -> 0x001b }
            r0.zza(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcar.zza(com.google.android.gms.internal.ads.zzacr):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzejx     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzdli     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzdli     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzdzo     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.internal.ads.zzaza.zzdb(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcar.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final /* synthetic */ View zzahe() {
        return this.zzfti;
    }

    public final FrameLayout zzalw() {
        return this.zzbld;
    }

    public final zzpv zzalx() {
        return this.zzfte;
    }

    public final synchronized Map<String, WeakReference<View>> zzaly() {
        return this.zzdli;
    }

    public final synchronized Map<String, WeakReference<View>> zzalz() {
        return this.zzdli;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzama() {
        return null;
    }

    public final synchronized String zzamb() {
        return this.zzftg;
    }

    @Nullable
    public final IObjectWrapper zzamc() {
        return this.zzftl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzame() {
        if (this.zzftk == null) {
            View view = new View(this.zzfti.getContext());
            this.zzftk = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzfti != this.zzftk.getParent()) {
            this.zzfti.addView(this.zzftk);
        }
    }

    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized IObjectWrapper zzcq(String str) {
        return ObjectWrapper.wrap(zzgd(str));
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        this.zzftd.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzfti, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        if (!this.zzejx) {
            this.zzftl = iObjectWrapper;
        }
    }

    public final synchronized View zzgd(String str) {
        if (this.zzejx) {
            return null;
        }
        WeakReference weakReference = this.zzdli.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }
}
