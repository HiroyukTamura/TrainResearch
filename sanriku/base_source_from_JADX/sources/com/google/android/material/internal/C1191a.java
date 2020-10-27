package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.internal.a */
public class C1191a {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f1213a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f1214b = new ThreadLocal<>();

    /* renamed from: a */
    public static void m1815a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = f1213a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f1213a.set(matrix);
        } else {
            matrix.reset();
        }
        m1816a((ViewParent) viewGroup, view, matrix);
        RectF rectF = f1214b.get();
        if (rectF == null) {
            rectF = new RectF();
            f1214b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    private static void m1816a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m1816a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
