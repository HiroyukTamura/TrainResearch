// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.animation.TypeEvaluator;

@TargetApi(14)
@RequiresApi(14)
class RectEvaluator implements TypeEvaluator<Rect>
{
    private Rect mRect;
    
    public RectEvaluator() {
    }
    
    public RectEvaluator(final Rect mRect) {
        this.mRect = mRect;
    }
    
    public Rect evaluate(final float n, final Rect rect, final Rect rect2) {
        final int n2 = rect.left + (int)((rect2.left - rect.left) * n);
        final int n3 = rect.top + (int)((rect2.top - rect.top) * n);
        final int n4 = rect.right + (int)((rect2.right - rect.right) * n);
        final int n5 = rect.bottom + (int)((rect2.bottom - rect.bottom) * n);
        if (this.mRect == null) {
            return new Rect(n2, n3, n4, n5);
        }
        this.mRect.set(n2, n3, n4, n5);
        return this.mRect;
    }
}
