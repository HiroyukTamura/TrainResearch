/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 */
package androidx.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.b.a.d;
import androidx.b.a.h;

class b
extends d {
    b() {
    }

    @Override
    public void a() {
        h.a = new h.a(){

            @Override
            public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                canvas.drawRoundRect(rectF, f2, f2, paint);
            }
        };
    }

}

