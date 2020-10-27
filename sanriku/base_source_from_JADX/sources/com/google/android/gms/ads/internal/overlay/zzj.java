package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaxr;

@VisibleForTesting
final class zzj extends RelativeLayout {
    @VisibleForTesting
    private zzaxr zzdkn;
    @VisibleForTesting
    boolean zzdko;

    public zzj(Context context, String str, String str2) {
        super(context);
        zzaxr zzaxr = new zzaxr(context, str);
        this.zzdkn = zzaxr;
        zzaxr.zzac(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdko) {
            return false;
        }
        this.zzdkn.zzd(motionEvent);
        return false;
    }
}
