package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public final class zzcvf implements zzdak<zzcvg> {
    private final zzdhe zzfll;
    private final zzdrh zzglk;
    private final View zzgll;
    private final Context zzvf;

    public zzcvf(zzdrh zzdrh, Context context, zzdhe zzdhe, @Nullable ViewGroup viewGroup) {
        this.zzglk = zzdrh;
        this.zzvf = context;
        this.zzfll = zzdhe;
        this.zzgll = viewGroup;
    }

    public final zzdri<zzcvg> zzaqa() {
        return this.zzglk.zzd(new zzcvi(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcvg zzaqb() throws Exception {
        Context context = this.zzvf;
        zzum zzum = this.zzfll.zzbmp;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgll;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcvg(context, zzum, arrayList);
    }
}
