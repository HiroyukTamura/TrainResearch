package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbbq {
    private final Context zzciq;
    private final zzbbx zzebj;
    private final ViewGroup zzece;
    private zzbbk zzecf;

    @VisibleForTesting
    private zzbbq(Context context, ViewGroup viewGroup, zzbbx zzbbx, zzbbk zzbbk) {
        this.zzciq = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzece = viewGroup;
        this.zzebj = zzbbx;
        this.zzecf = null;
    }

    public zzbbq(Context context, ViewGroup viewGroup, zzbek zzbek) {
        this(context, viewGroup, zzbek, (zzbbk) null);
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbbk zzbbk = this.zzecf;
        if (zzbbk != null) {
            zzbbk.destroy();
            this.zzece.removeView(this.zzecf);
            this.zzecf = null;
        }
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbbk zzbbk = this.zzecf;
        if (zzbbk != null) {
            zzbbk.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbby zzbby) {
        if (this.zzecf == null) {
            zzaah.zza(this.zzebj.zzzj().zzrn(), this.zzebj.zzzg(), "vpr2");
            Context context = this.zzciq;
            zzbbx zzbbx = this.zzebj;
            zzbbk zzbbk = new zzbbk(context, zzbbx, i5, z, zzbbx.zzzj().zzrn(), zzbby);
            this.zzecf = zzbbk;
            this.zzece.addView(zzbbk, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzecf.zzd(i, i2, i3, i4);
            this.zzebj.zzav(false);
        }
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbbk zzbbk = this.zzecf;
        if (zzbbk != null) {
            zzbbk.zzd(i, i2, i3, i4);
        }
    }

    public final zzbbk zzza() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzecf;
    }
}
