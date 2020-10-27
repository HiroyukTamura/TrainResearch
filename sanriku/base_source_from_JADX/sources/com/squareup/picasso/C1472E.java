package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.C1513u;

/* renamed from: com.squareup.picasso.E */
final class C1472E extends C1478a<C1471D> {
    C1472E(C1513u uVar, C1471D d, C1526x xVar, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(uVar, d, xVar, i, i2, i3, drawable, str, obj, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27183a(Bitmap bitmap, C1513u.C1519e eVar) {
        if (bitmap != null) {
            C1471D d = (C1471D) mo27197b();
            if (d != null) {
                d.onBitmapLoaded(bitmap, eVar);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27184a(Exception exc) {
        C1471D d = (C1471D) mo27197b();
        if (d != null) {
            d.onBitmapFailed(exc, this.f1577g != 0 ? this.f1571a.f1677e.getResources().getDrawable(this.f1577g) : this.f1578h);
        }
    }
}
