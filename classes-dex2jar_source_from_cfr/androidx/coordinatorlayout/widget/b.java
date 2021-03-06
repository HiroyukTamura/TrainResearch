/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class b {
    private static final ThreadLocal<Matrix> a = new ThreadLocal();
    private static final ThreadLocal<RectF> b = new ThreadLocal();

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = a.get();
        if (matrix == null) {
            matrix = new Matrix();
            a.set(matrix);
        } else {
            matrix.reset();
        }
        b.a((ViewParent)viewGroup, view, matrix);
        view = b.get();
        viewGroup = view;
        if (view == null) {
            viewGroup = new RectF();
            b.set((RectF)viewGroup);
        }
        viewGroup.set(rect);
        matrix.mapRect((RectF)viewGroup);
        rect.set((int)(viewGroup.left + 0.5f), (int)(viewGroup.top + 0.5f), (int)(viewGroup.right + 0.5f), (int)(viewGroup.bottom + 0.5f));
    }

    private static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent viewParent2 = view.getParent();
        if (viewParent2 instanceof View && viewParent2 != viewParent) {
            viewParent2 = (View)viewParent2;
            b.a(viewParent, (View)viewParent2, matrix);
            matrix.preTranslate((float)(-viewParent2.getScrollX()), (float)(-viewParent2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }

    public static void b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        b.a(viewGroup, view, rect);
    }
}

