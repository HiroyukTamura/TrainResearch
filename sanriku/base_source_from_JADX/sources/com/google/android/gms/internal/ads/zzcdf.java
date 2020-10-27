package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcdf extends zzahr implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzacf {
    private boolean zzejx = false;
    private zzxl zzfrz;
    private View zzfse;
    private zzbzm zzftd;
    private boolean zzfvz = false;

    public zzcdf(zzbzm zzbzm, zzbzx zzbzx) {
        this.zzfse = zzbzx.zzala();
        this.zzfrz = zzbzx.getVideoController();
        this.zzftd = zzbzm;
        if (zzbzx.zzalb() != null) {
            zzbzx.zzalb().zza((zzacf) this);
        }
    }

    private static void zza(zzaht zzaht, int i) {
        try {
            zzaht.zzcw(i);
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    private final void zzaml() {
        View view = this.zzfse;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzfse);
            }
        }
    }

    private final void zzamm() {
        View view;
        zzbzm zzbzm = this.zzftd;
        if (zzbzm != null && (view = this.zzfse) != null) {
            zzbzm.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzbzm.zzy(this.zzfse));
        }
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaml();
        zzbzm zzbzm = this.zzftd;
        if (zzbzm != null) {
            zzbzm.destroy();
        }
        this.zzftd = null;
        this.zzfse = null;
        this.zzfrz = null;
        this.zzejx = true;
    }

    public final zzxl getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzejx) {
            return this.zzfrz;
        }
        zzazw.zzfa("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void onGlobalLayout() {
        zzamm();
    }

    public final void onScrollChanged() {
        zzamm();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaht zzaht) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzejx) {
            zzazw.zzfa("Instream ad can not be shown after destroy().");
            zza(zzaht, 2);
        } else if (this.zzfse == null || this.zzfrz == null) {
            String str = this.zzfse == null ? "can not get video view." : "can not get video controller.";
            zzazw.zzfa(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzaht, 0);
        } else if (this.zzfvz) {
            zzazw.zzfa("Instream ad should not be used again.");
            zza(zzaht, 1);
        } else {
            this.zzfvz = true;
            zzaml();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzfse, new ViewGroup.LayoutParams(-1, -1));
            zzq.zzlt();
            zzbar.zza(this.zzfse, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzq.zzlt();
            zzbar.zza(this.zzfse, (ViewTreeObserver.OnScrollChangedListener) this);
            zzamm();
            try {
                zzaht.zzsp();
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzamn() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, (zzaht) new zzcdh(this));
    }

    public final void zzrw() {
        zzaxa.zzdwf.post(new zzcde(this));
    }

    public final zzacr zzsl() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzejx) {
            zzazw.zzfa("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzbzm zzbzm = this.zzftd;
        if (zzbzm == null || zzbzm.zzakt() == null) {
            return null;
        }
        return this.zzftd.zzakt().zzsl();
    }
}
