/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Rect
 */
package androidx.j;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class k
implements TypeEvaluator<Rect> {
    private Rect a;

    k() {
    }

    public Rect a(float f2, Rect rect, Rect rect2) {
        int n2 = rect.left + (int)((float)(rect2.left - rect.left) * f2);
        int n3 = rect.top + (int)((float)(rect2.top - rect.top) * f2);
        int n4 = rect.right + (int)((float)(rect2.right - rect.right) * f2);
        int n5 = rect.bottom + (int)((float)(rect2.bottom - rect.bottom) * f2);
        if (this.a == null) {
            return new Rect(n2, n3, n4, n5);
        }
        this.a.set(n2, n3, n4, n5);
        return this.a;
    }

    public /* synthetic */ Object evaluate(float f2, Object object, Object object2) {
        return this.a(f2, (Rect)object, (Rect)object2);
    }
}

