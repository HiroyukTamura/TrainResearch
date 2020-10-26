/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package jp.co.jreast.jreastapp.commuter.common.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/view/ScalableImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "mBaseScale", "", "mFirstLayout", "", "mMatrix", "Landroid/graphics/Matrix;", "mSimpleOnGestureListener", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "getMSimpleOnGestureListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "borderAndCenterCheck", "", "getMatrixRectF", "Landroid/graphics/RectF;", "getScale", "onAttachedToWindow", "onDetachedFromWindow", "onGlobalLayout", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class ScalableImageView
extends AppCompatImageView
implements ScaleGestureDetector.OnScaleGestureListener,
ViewTreeObserver.OnGlobalLayoutListener {
    public static final a a = new a(null);
    private GestureDetector b;
    private ScaleGestureDetector c;
    private Matrix d;
    private boolean e;
    private float f;
    private final GestureDetector.SimpleOnGestureListener g;

    public ScalableImageView(Context context) {
        j.b((Object)context, "context");
        super(context);
        this.d = new Matrix();
        this.e = true;
        this.g = new GestureDetector.SimpleOnGestureListener(this){
            final /* synthetic */ ScalableImageView a;
            {
                this.a = scalableImageView;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                j.b((Object)motionEvent, "e1");
                j.b((Object)motionEvent2, "e2");
                if (motionEvent.getPointerCount() == motionEvent2.getPointerCount() && motionEvent.getPointerCount() == 1) {
                    this.a.d.postTranslate(-f2, -f3);
                    this.a.a();
                    this.a.setImageMatrix(this.a.d);
                    return true;
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
        };
    }

    public ScalableImageView(Context context, AttributeSet attributeSet) {
        j.b((Object)context, "context");
        j.b((Object)attributeSet, "attrs");
        super(context, attributeSet);
        this.d = new Matrix();
        this.e = true;
        this.g = new /* invalid duplicate definition of identical inner class */;
        this.setScaleType(ImageView.ScaleType.MATRIX);
        this.b = new GestureDetector(context, (GestureDetector.OnGestureListener)this.g);
        this.c = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)this);
    }

    public ScalableImageView(Context context, AttributeSet attributeSet, int n2) {
        j.b((Object)context, "context");
        j.b((Object)attributeSet, "attrs");
        super(context, attributeSet, n2);
        this.d = new Matrix();
        this.e = true;
        this.g = new /* invalid duplicate definition of identical inner class */;
    }

    private final void a() {
        float f2;
        float f3;
        RectF rectF = this.getMatrixRectF();
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        float f4 = rectF.width();
        float f5 = n2;
        float f6 = 0.0f;
        float f7 = 0.0f;
        if (f4 >= f5) {
            f4 = rectF.left > (float)false ? -rectF.left : 0.0f;
            if (rectF.right < f5) {
                f4 = f5 - rectF.right;
            }
        } else {
            f4 = 0.0f;
        }
        if ((f3 = rectF.height()) >= (f2 = (float)n3)) {
            f6 = f7;
            if (rectF.top > (float)false) {
                f6 = -rectF.top;
            }
            if (rectF.bottom < f2) {
                f6 = f2 - rectF.bottom;
            }
        }
        if (rectF.width() < f5) {
            f4 = f5 / 2.0f;
            f7 = rectF.right;
            f4 = rectF.width() / 2.0f + (f4 - f7);
        }
        if (rectF.height() < f2) {
            f6 = f2 / 2.0f - rectF.bottom + rectF.height() / 2.0f;
        }
        this.d.postTranslate(f4, f6);
    }

    private final RectF getMatrixRectF() {
        RectF rectF = new RectF();
        if (this.getDrawable() != null) {
            Drawable drawable2 = this.getDrawable();
            j.a((Object)drawable2, "drawable");
            float f2 = drawable2.getIntrinsicWidth();
            drawable2 = this.getDrawable();
            j.a((Object)drawable2, "drawable");
            rectF.set(0.0f, 0.0f, f2, (float)drawable2.getIntrinsicHeight());
            this.d.mapRect(rectF);
        }
        return rectF;
    }

    private final float getScale() {
        float[] arrf = new float[9];
        this.d.getValues(arrf);
        return arrf[0];
    }

    public final GestureDetector.SimpleOnGestureListener getMSimpleOnGestureListener() {
        return this.g;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onGlobalLayout() {
        block4 : {
            if (this.e == false) return;
            this.e = false;
            var4_1 = this.getWidth();
            var3_2 = this.getHeight();
            var8_3 = this.getDrawable();
            if (var8_3 == null) return;
            var7_4 = var8_3.getIntrinsicWidth();
            var6_5 = var8_3.getIntrinsicHeight();
            var5_6 = var7_4;
            var7_4 = (int)(var5_6 FCMPL var4_1);
            if (var7_4 < 0 || !((var2_7 = (float)var6_5) >= var3_2)) break block4;
            var1_8 = var4_1 / var5_6;
            ** GOTO lbl23
        }
        if (var7_4 > 0 && (float)var6_5 < var3_2) {
            var1_8 = var4_1 / var5_6;
        } else if (var5_6 < var4_1 && (var1_8 = (float)var6_5) > var3_2) {
            var1_8 = var3_2 / var1_8;
        } else {
            var1_8 = var4_1 / var5_6;
            var2_7 = var6_5;
lbl23: // 2 sources:
            var1_8 = Math.min(var1_8, var3_2 / var2_7);
        }
        this.f = var1_8;
        var1_8 = this.f * 3.5f;
        this.d.postScale(var1_8, var1_8);
        var2_7 = 2;
        var4_1 = (var4_1 - var5_6 * var1_8) / var2_7;
        var5_6 = 200;
        var1_8 = (var3_2 - (float)var6_5 * var1_8) / var2_7;
        var2_7 = 100;
        this.d.postTranslate(var4_1 - var5_6, var1_8 - var2_7);
        this.setImageMatrix(this.d);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f2;
        float f3;
        j.b((Object)scaleGestureDetector, "detector");
        if (this.getDrawable() == null) {
            return false;
        }
        float f4 = scaleGestureDetector.getScaleFactor();
        float f5 = this.getScale();
        if (f5 < (f3 = this.f) * (f2 = (float)8) && f4 > 1.0f || f5 > this.f && f4 < 1.0f) {
            if ((f5 *= f4) > this.f && f5 < this.f * f2) {
                this.d.postScale(f4, f4, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                this.a();
                this.setImageMatrix(this.d);
            }
            return true;
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        j.b((Object)scaleGestureDetector, "detector");
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        j.b((Object)scaleGestureDetector, "detector");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        j.b((Object)motionEvent, "event");
        GestureDetector gestureDetector = this.b;
        if (gestureDetector == null) {
            j.b("gestureDetector");
        }
        if (gestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        gestureDetector = this.c;
        if (gestureDetector == null) {
            j.b("scaleGestureDetector");
        }
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/view/ScalableImageView$Companion;", "", "()V", "BASE_SCALE_TIMES", "", "MAX_SCALE_TIMES", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

