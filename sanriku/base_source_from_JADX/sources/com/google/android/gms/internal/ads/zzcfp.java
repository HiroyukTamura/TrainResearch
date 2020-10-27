package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public final class zzcfp extends FrameLayout {
    private final zzaxr zzdkn;

    public zzcfp(Context context, @NonNull View view, @NonNull zzaxr zzaxr) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zzdkn = zzaxr;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zzdkn.zzd(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzbek)) {
                arrayList.add((zzbek) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzbek) obj).destroy();
        }
    }
}
