package com.google.android.material.bottomsheet;

import android.view.View;

/* renamed from: com.google.android.material.bottomsheet.a */
class C1165a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f1103a;

    /* renamed from: b */
    final /* synthetic */ int f1104b;

    /* renamed from: c */
    final /* synthetic */ BottomSheetBehavior f1105c;

    C1165a(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.f1105c = bottomSheetBehavior;
        this.f1103a = view;
        this.f1104b = i;
    }

    public void run() {
        this.f1105c.mo25366a(this.f1103a, this.f1104b);
    }
}
