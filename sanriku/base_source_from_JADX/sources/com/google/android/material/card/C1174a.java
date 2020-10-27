package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.card.a */
class C1174a {

    /* renamed from: a */
    private final MaterialCardView f1147a;

    /* renamed from: b */
    private int f1148b;

    /* renamed from: c */
    private int f1149c;

    public C1174a(MaterialCardView materialCardView) {
        this.f1147a = materialCardView;
    }

    /* renamed from: a */
    public void mo25403a(TypedArray typedArray) {
        this.f1148b = typedArray.getColor(0, -1);
        this.f1149c = typedArray.getDimensionPixelSize(1, 0);
        mo25402a();
        this.f1147a.setContentPadding(this.f1147a.getContentPaddingLeft() + this.f1149c, this.f1147a.getContentPaddingTop() + this.f1149c, this.f1147a.getContentPaddingRight() + this.f1149c, this.f1147a.getContentPaddingBottom() + this.f1149c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25402a() {
        MaterialCardView materialCardView = this.f1147a;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f1147a.getRadius());
        int i = this.f1148b;
        if (i != -1) {
            gradientDrawable.setStroke(this.f1149c, i);
        }
        materialCardView.setForeground(gradientDrawable);
    }
}
