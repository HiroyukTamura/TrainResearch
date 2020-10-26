/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.RatingBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import androidx.appcompat.a;
import androidx.appcompat.widget.n;

public class p
extends RatingBar {
    private final n a = new n((ProgressBar)this);

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.ratingBarStyle);
    }

    public p(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a.a(attributeSet, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onMeasure(int n2, int n3) {
        synchronized (this) {
            super.onMeasure(n2, n3);
            Bitmap bitmap = this.a.a();
            if (bitmap != null) {
                this.setMeasuredDimension(View.resolveSizeAndState((int)(bitmap.getWidth() * this.getNumStars()), (int)n2, (int)0), this.getMeasuredHeight());
            }
            return;
        }
    }
}

