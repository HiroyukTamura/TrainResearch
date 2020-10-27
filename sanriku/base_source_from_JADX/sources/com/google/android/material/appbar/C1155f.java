package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.C1196d;

@RequiresApi(21)
/* renamed from: com.google.android.material.appbar.f */
class C1155f {

    /* renamed from: a */
    private static final int[] f1047a = {16843848};

    /* renamed from: a */
    static void m1717a(View view, AttributeSet attributeSet, int i, int i2) {
        Context context = view.getContext();
        TypedArray a = C1196d.m1820a(context, attributeSet, f1047a, i, i2, new int[0]);
        try {
            if (a.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a.getResourceId(0, 0)));
            }
        } finally {
            a.recycle();
        }
    }
}
