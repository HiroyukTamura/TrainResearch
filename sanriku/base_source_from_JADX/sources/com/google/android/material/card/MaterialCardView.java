package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.C1196d;
import p009e.p028d.p030b.p054b.C1533b;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

public class MaterialCardView extends CardView {

    /* renamed from: a */
    private final C1174a f1146a;

    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray a = C1196d.m1820a(context, attributeSet, C1533b.f1764g, i, C2092R.style.Widget_MaterialComponents_CardView, new int[0]);
        C1174a aVar = new C1174a(this);
        this.f1146a = aVar;
        aVar.mo25403a(a);
        a.recycle();
    }

    public void setRadius(float f) {
        super.setRadius(f);
        this.f1146a.mo25402a();
    }
}
