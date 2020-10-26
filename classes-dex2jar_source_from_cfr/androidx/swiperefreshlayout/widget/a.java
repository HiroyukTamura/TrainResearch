/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.OvalShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.widget.ImageView
 */
package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.h.t;

class a
extends ImageView {
    int a;
    private Animation.AnimationListener b;

    a(Context context, int n2) {
        super(context);
        float f2 = this.getContext().getResources().getDisplayMetrics().density;
        int n3 = (int)(1.75f * f2);
        int n4 = (int)(0.0f * f2);
        this.a = (int)(3.5f * f2);
        if (this.a()) {
            context = new ShapeDrawable((Shape)new OvalShape());
            t.c((View)this, f2 * 4.0f);
        } else {
            context = new ShapeDrawable((Shape)new a(this.a));
            this.setLayerType(1, context.getPaint());
            context.getPaint().setShadowLayer((float)this.a, (float)n4, (float)n3, 503316480);
            n3 = this.a;
            this.setPadding(n3, n3, n3, n3);
        }
        context.getPaint().setColor(n2);
        t.a((View)this, (Drawable)context);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void a(Animation.AnimationListener animationListener) {
        this.b = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.b != null) {
            this.b.onAnimationEnd(this.getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.b != null) {
            this.b.onAnimationStart(this.getAnimation());
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (!this.a()) {
            this.setMeasuredDimension(this.getMeasuredWidth() + this.a * 2, this.getMeasuredHeight() + this.a * 2);
        }
    }

    public void setBackgroundColor(int n2) {
        if (this.getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable)this.getBackground()).getPaint().setColor(n2);
        }
    }

    private class a
    extends OvalShape {
        private RadialGradient b;
        private Paint c = new Paint();

        a(int n2) {
            a.this.a = n2;
            this.a((int)this.rect().width());
        }

        private void a(int n2) {
            float f2 = n2 / 2;
            float f3 = a.this.a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.b = new RadialGradient(f2, f2, f3, new int[]{1023410176, 0}, null, tileMode);
            this.c.setShader((Shader)this.b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int n2 = a.this.getWidth();
            int n3 = a.this.getHeight();
            float f2 = n2 /= 2;
            float f3 = n3 / 2;
            canvas.drawCircle(f2, f3, f2, this.c);
            canvas.drawCircle(f2, f3, (float)(n2 - a.this.a), paint);
        }

        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            this.a((int)f2);
        }
    }

}

