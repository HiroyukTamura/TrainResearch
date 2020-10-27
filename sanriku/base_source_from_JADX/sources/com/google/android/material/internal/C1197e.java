package com.google.android.material.internal;

import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.internal.e */
public class C1197e extends ImageButton {

    /* renamed from: a */
    private int f1230a;

    /* renamed from: a */
    public final void mo25480a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f1230a = i;
        }
    }

    /* renamed from: b */
    public final int mo25481b() {
        return this.f1230a;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f1230a = i;
    }
}
