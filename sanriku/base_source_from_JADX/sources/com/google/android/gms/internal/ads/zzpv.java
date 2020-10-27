package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public final class zzpv implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbon = ((Long) zzvj.zzpv().zzd(zzzz.zzcmu)).longValue();
    private final WindowManager zzboo;
    @Nullable
    @VisibleForTesting
    private BroadcastReceiver zzbop;
    private WeakReference<View> zzboq;
    private zzqc zzbor;
    private zzazc zzbos = new zzazc(zzbon);
    private boolean zzbot = false;
    private final HashSet<zzpz> zzbou = new HashSet<>();
    private final Rect zzbov;
    private final DisplayMetrics zzwz;
    private Application zzxv;
    private final Context zzzo;
    private final PowerManager zzzp;
    private final KeyguardManager zzzq;
    private WeakReference<ViewTreeObserver> zzzs;
    private int zzzw = -1;

    public zzpv(Context context, View view) {
        this.zzzo = context.getApplicationContext();
        this.zzboo = (WindowManager) context.getSystemService("window");
        this.zzzp = (PowerManager) this.zzzo.getSystemService("power");
        this.zzzq = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzzo;
        if (context2 instanceof Application) {
            this.zzxv = (Application) context2;
            this.zzbor = new zzqc((Application) context2, this);
        }
        this.zzwz = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzbov = rect;
        rect.right = this.zzboo.getDefaultDisplay().getWidth();
        this.zzbov.bottom = this.zzboo.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzboq;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzboq = new WeakReference<>(view);
        if (view != null) {
            if (zzq.zzky().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbp(rect.left), zzbp(rect.top), zzbp(rect.right), zzbp(rect.bottom));
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzboq != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzboq.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzzw = i;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzbo(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        int i2 = i;
        if (this.zzbou.size() != 0 && (weakReference = this.zzboq) != null) {
            View view = (View) weakReference.get();
            boolean z3 = i2 == 1;
            boolean z4 = view == null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Exception e) {
                    zzazw.zzc("Failure getting view location.", e);
                }
                int i3 = iArr[0];
                rect.left = i3;
                rect.top = iArr[1];
                rect.right = view.getWidth() + i3;
                rect.bottom = view.getHeight() + rect.top;
                z2 = globalVisibleRect;
                z = localVisibleRect;
            } else {
                z2 = false;
                z = false;
            }
            List<Rect> emptyList = (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcmx)).booleanValue() || view == null) ? Collections.emptyList() : zzi(view);
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            int i4 = this.zzzw;
            if (i4 != -1) {
                windowVisibility = i4;
            }
            boolean z5 = !z4 && zzq.zzkw().zza(view, this.zzzp, this.zzzq) && z2 && z && windowVisibility == 0;
            if (z3 && !this.zzbos.tryAcquire() && z5 == this.zzbot) {
                return;
            }
            if (z5 || this.zzbot || i2 != 1) {
                zzqa zzqa = new zzqa(zzq.zzld().elapsedRealtime(), this.zzzp.isScreenOn(), view != null && zzq.zzky().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, zza(this.zzbov), zza(rect), zza(rect2), z2, zza(rect3), z, zza(rect4), this.zzwz.density, z5, emptyList);
                Iterator<zzpz> it = this.zzbou.iterator();
                while (it.hasNext()) {
                    it.next().zza(zzqa);
                }
                this.zzbot = z5;
            }
        }
    }

    private final int zzbp(int i) {
        return (int) (((float) i) / this.zzwz.density);
    }

    private final void zzcu() {
        zzaxa.zzdwf.post(new zzpy(this));
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzzs = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbop == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbop = new zzpx(this);
            zzq.zzlr().zza(this.zzzo, this.zzbop, intentFilter);
        }
        Application application = this.zzxv;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbor);
            } catch (Exception e) {
                zzazw.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzg(View view) {
        try {
            if (this.zzzs != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzzs.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzzs = null;
            }
        } catch (Exception e) {
            zzazw.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzazw.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbop != null) {
            try {
                zzq.zzlr().zza(this.zzzo, this.zzbop);
            } catch (IllegalStateException e3) {
                zzazw.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzq.zzla().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbop = null;
        }
        Application application = this.zzxv;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbor);
            } catch (Exception e5) {
                zzazw.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzq.zzla().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbo(3);
        zzcu();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbo(3);
        zzcu();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbo(3);
        zzcu();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbo(3);
        zzcu();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbo(3);
        zzcu();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbo(3);
        zzcu();
    }

    public final void onActivityStopped(Activity activity) {
        zzbo(3);
        zzcu();
    }

    public final void onGlobalLayout() {
        zzbo(2);
        zzcu();
    }

    public final void onScrollChanged() {
        zzbo(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzzw = -1;
        zzf(view);
        zzbo(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzzw = -1;
        zzbo(3);
        zzcu();
        zzg(view);
    }

    public final void zza(zzpz zzpz) {
        this.zzbou.add(zzpz);
        zzbo(3);
    }

    public final void zzb(zzpz zzpz) {
        this.zzbou.remove(zzpz);
    }

    public final void zzen(long j) {
        this.zzbos.zzfb(j);
    }

    public final void zzlv() {
        this.zzbos.zzfb(zzbon);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzlw() {
        zzbo(3);
    }
}
