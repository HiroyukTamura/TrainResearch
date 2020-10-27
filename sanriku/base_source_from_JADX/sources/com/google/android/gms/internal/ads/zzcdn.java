package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

public final class zzcdn extends zzadr {
    private final zzbzx zzfqb;
    /* access modifiers changed from: private */
    public zzbzm zzftd;
    private zzcat zzfwc;
    private final Context zzzo;

    public zzcdn(Context context, zzbzx zzbzx, zzcat zzcat, zzbzm zzbzm) {
        this.zzzo = context;
        this.zzfqb = zzbzx;
        this.zzfwc = zzcat;
        this.zzftd = zzbzm;
    }

    public final void destroy() {
        zzbzm zzbzm = this.zzftd;
        if (zzbzm != null) {
            zzbzm.destroy();
        }
        this.zzftd = null;
        this.zzfwc = null;
    }

    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzace> zzale = this.zzfqb.zzale();
        SimpleArrayMap<String, String> zzalg = this.zzfqb.zzalg();
        String[] strArr = new String[(zzalg.size() + zzale.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzale.size()) {
            strArr[i3] = zzale.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzalg.size()) {
            strArr[i3] = zzalg.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzfqb.getCustomTemplateId();
    }

    public final zzxl getVideoController() {
        return this.zzfqb.getVideoController();
    }

    public final void performClick(String str) {
        zzbzm zzbzm = this.zzftd;
        if (zzbzm != null) {
            zzbzm.zzfx(str);
        }
    }

    public final void recordImpression() {
        zzbzm zzbzm = this.zzftd;
        if (zzbzm != null) {
            zzbzm.zzakl();
        }
    }

    public final String zzcv(String str) {
        return this.zzfqb.zzalg().get(str);
    }

    public final zzacs zzcw(String str) {
        return this.zzfqb.zzale().get(str);
    }

    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup)) {
            return false;
        }
        zzcat zzcat = this.zzfwc;
        if (!(zzcat != null && zzcat.zza((ViewGroup) unwrap))) {
            return false;
        }
        this.zzfqb.zzalb().zza((zzacg) new zzcdm(this));
        return true;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzbzm zzbzm;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzfqb.zzald() != null && (zzbzm = this.zzftd) != null) {
            zzbzm.zzz((View) unwrap);
        }
    }

    public final IObjectWrapper zzrz() {
        return null;
    }

    public final IObjectWrapper zzse() {
        return ObjectWrapper.wrap(this.zzzo);
    }

    public final boolean zzsf() {
        zzbzm zzbzm = this.zzftd;
        return (zzbzm == null || zzbzm.zzaks()) && this.zzfqb.zzalc() != null && this.zzfqb.zzalb() == null;
    }

    public final boolean zzsg() {
        IObjectWrapper zzald = this.zzfqb.zzald();
        if (zzald != null) {
            zzq.zzll().zzab(zzald);
            return true;
        }
        zzazw.zzfc("Trying to start OMID session before creation.");
        return false;
    }

    public final void zzsh() {
        String zzalf = this.zzfqb.zzalf();
        if ("Google".equals(zzalf)) {
            zzazw.zzfc("Illegal argument specified for omid partner name.");
            return;
        }
        zzbzm zzbzm = this.zzftd;
        if (zzbzm != null) {
            zzbzm.zzg(zzalf, false);
        }
    }
}
