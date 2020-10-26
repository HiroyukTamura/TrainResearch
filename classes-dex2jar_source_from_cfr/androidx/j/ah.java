/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.j;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import androidx.j.j;

class ah {
    ah() {
    }

    public float a(View view) {
        Float f2 = (Float)view.getTag(j.a.save_non_transition_alpha);
        if (f2 != null) {
            return view.getAlpha() / f2.floatValue();
        }
        return view.getAlpha();
    }

    public void a(View view, float f2) {
        Float f3 = (Float)view.getTag(j.a.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
            return;
        }
        view.setAlpha(f2);
    }

    public void a(View view, int n2, int n3, int n4, int n5) {
        view.setLeft(n2);
        view.setTop(n3);
        view.setRight(n4);
        view.setBottom(n5);
    }

    public void a(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            viewParent = (View)viewParent;
            this.a((View)viewParent, matrix);
            matrix.preTranslate((float)(-viewParent.getScrollX()), (float)(-viewParent.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity()) {
            matrix.preConcat((Matrix)view);
        }
    }

    public void b(View view) {
        if (view.getTag(j.a.save_non_transition_alpha) == null) {
            view.setTag(j.a.save_non_transition_alpha, (Object)Float.valueOf(view.getAlpha()));
        }
    }

    public void b(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            viewParent = (View)viewParent;
            this.b((View)viewParent, matrix);
            matrix.postTranslate((float)viewParent.getScrollX(), (float)viewParent.getScrollY());
        }
        matrix.postTranslate((float)view.getLeft(), (float)view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity() && view.invert((Matrix)(viewParent = new Matrix()))) {
            matrix.postConcat((Matrix)viewParent);
        }
    }

    public void c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(j.a.save_non_transition_alpha, null);
        }
    }
}

