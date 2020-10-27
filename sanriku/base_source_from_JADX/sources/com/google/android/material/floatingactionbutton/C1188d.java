package com.google.android.material.floatingactionbutton;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.C1197e;
import p009e.p028d.p030b.p054b.p060h.C1556a;
import p009e.p028d.p030b.p054b.p060h.C1557b;

@RequiresApi(21)
/* renamed from: com.google.android.material.floatingactionbutton.d */
class C1188d extends C1178b {

    /* renamed from: A */
    private InsetDrawable f1200A;

    C1188d(C1197e eVar, C1557b bVar) {
        super(eVar, bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25435a(Rect rect) {
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        if (floatingActionButton.f1155g) {
            float c = ((float) floatingActionButton.mo25410c()) / 2.0f;
            float elevation = this.f1180m.getElevation() + this.f1176i;
            int ceil = (int) Math.ceil((double) C1556a.m2175a(elevation, c, false));
            int ceil2 = (int) Math.ceil((double) C1556a.m2176b(elevation, c, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25437a(int[] iArr) {
        C1197e eVar;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.f1180m.isEnabled()) {
                this.f1180m.setElevation(this.f1174g);
                if (this.f1180m.isPressed()) {
                    eVar = this.f1180m;
                    f = this.f1176i;
                } else if (this.f1180m.isFocused() || this.f1180m.isHovered()) {
                    eVar = this.f1180m;
                    f = this.f1175h;
                }
                eVar.setTranslationZ(f);
            }
            this.f1180m.setElevation(0.0f);
            eVar = this.f1180m;
            eVar.setTranslationZ(f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25439b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25441b(Rect rect) {
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        if (floatingActionButton.f1155g) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            this.f1200A = insetDrawable;
            C1188d.super.setBackgroundDrawable(insetDrawable);
            return;
        }
        C1188d.super.setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo25448f() {
        return false;
    }
}
