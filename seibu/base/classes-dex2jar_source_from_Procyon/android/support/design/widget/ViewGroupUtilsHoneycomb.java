// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewParent;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(11)
@RequiresApi(11)
class ViewGroupUtilsHoneycomb
{
    private static final ThreadLocal<Matrix> sMatrix;
    private static final ThreadLocal<RectF> sRectF;
    
    static {
        sMatrix = new ThreadLocal<Matrix>();
        sRectF = new ThreadLocal<RectF>();
    }
    
    static void offsetDescendantMatrix(final ViewParent viewParent, final View view, final Matrix matrix) {
        final ViewParent parent = view.getParent();
        if (parent instanceof View && parent != viewParent) {
            final View view2 = (View)parent;
            offsetDescendantMatrix(viewParent, view2, matrix);
            matrix.preTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
    
    public static void offsetDescendantRect(final ViewGroup viewGroup, final View view, final Rect rect) {
        Matrix value = ViewGroupUtilsHoneycomb.sMatrix.get();
        if (value == null) {
            value = new Matrix();
            ViewGroupUtilsHoneycomb.sMatrix.set(value);
        }
        else {
            value.reset();
        }
        offsetDescendantMatrix((ViewParent)viewGroup, view, value);
        RectF value2;
        if ((value2 = ViewGroupUtilsHoneycomb.sRectF.get()) == null) {
            value2 = new RectF();
            ViewGroupUtilsHoneycomb.sRectF.set(value2);
        }
        value2.set(rect);
        value.mapRect(value2);
        rect.set((int)(value2.left + 0.5f), (int)(value2.top + 0.5f), (int)(value2.right + 0.5f), (int)(value2.bottom + 0.5f));
    }
}
