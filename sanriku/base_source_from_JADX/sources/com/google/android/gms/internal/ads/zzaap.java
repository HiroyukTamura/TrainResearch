package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaap extends zzaaq {
    private final zze zzcvc;
    @Nullable
    private final String zzcvd;
    private final String zzcve;

    public zzaap(zze zze, @Nullable String str, String str2) {
        this.zzcvc = zze;
        this.zzcvd = str;
        this.zzcve = str2;
    }

    public final String getContent() {
        return this.zzcve;
    }

    public final void recordClick() {
        this.zzcvc.zzjy();
    }

    public final void recordImpression() {
        this.zzcvc.zzjz();
    }

    public final void zzn(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzcvc.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final String zzro() {
        return this.zzcvd;
    }
}
