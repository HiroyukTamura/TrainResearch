/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.widget.ConstraintLayout;

public class i
extends View {
    private int a;
    private View b;
    private int c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.a == -1 && !this.isInEditMode()) {
            this.setVisibility(this.c);
        }
        this.b = constraintLayout.findViewById(this.a);
        if (this.b != null) {
            ((ConstraintLayout.a)this.b.getLayoutParams()).aa = true;
            this.b.setVisibility(0);
            this.setVisibility(0);
        }
    }

    public void b(ConstraintLayout object) {
        if (this.b == null) {
            return;
        }
        object = (ConstraintLayout.a)this.getLayoutParams();
        ConstraintLayout.a a2 = (ConstraintLayout.a)this.b.getLayoutParams();
        a2.am.e(0);
        ((ConstraintLayout.a)object).am.h(a2.am.p());
        ((ConstraintLayout.a)object).am.i(a2.am.r());
        a2.am.e(8);
    }

    public View getContent() {
        return this.b;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    public void onDraw(Canvas canvas) {
        if (this.isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create((Typeface)Typeface.DEFAULT, (int)0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float)rect.height());
            int n2 = rect.height();
            int n3 = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, "?".length(), rect);
            canvas.drawText("?", (float)n3 / 2.0f - (float)rect.width() / 2.0f - (float)rect.left, (float)n2 / 2.0f + (float)rect.height() / 2.0f - (float)rect.bottom, paint);
        }
    }

    public void setContentId(int n2) {
        View view;
        if (this.a == n2) {
            return;
        }
        if (this.b != null) {
            this.b.setVisibility(0);
            ((ConstraintLayout.a)this.b.getLayoutParams()).aa = false;
            this.b = null;
        }
        this.a = n2;
        if (n2 != -1 && (view = ((View)this.getParent()).findViewById(n2)) != null) {
            view.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int n2) {
        this.c = n2;
    }
}

