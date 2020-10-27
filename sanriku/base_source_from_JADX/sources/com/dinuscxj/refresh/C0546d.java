package com.dinuscxj.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* renamed from: com.dinuscxj.refresh.d */
public class C0546d extends View implements C0543a {

    /* renamed from: a */
    private final RectF f98a = new RectF();

    /* renamed from: b */
    private final Paint f99b = new Paint();

    /* renamed from: c */
    private float f100c = 285.0f;

    /* renamed from: d */
    private float f101d = 0.0f;

    /* renamed from: e */
    private float f102e = (getResources().getDisplayMetrics().density * 2.0f);

    /* renamed from: f */
    private boolean f103f;

    /* renamed from: g */
    private ValueAnimator f104g;

    public C0546d(Context context) {
        super(context, (AttributeSet) null, 0);
        this.f99b.setAntiAlias(true);
        this.f99b.setStyle(Paint.Style.STROKE);
        this.f99b.setStrokeWidth(this.f102e);
        this.f99b.setColor(Color.parseColor("#FFD72263"));
    }

    /* renamed from: a */
    static /* synthetic */ void m54a(C0546d dVar, float f) {
        dVar.f100c = f;
        dVar.postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f104g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f104g.removeAllUpdateListeners();
            this.f104g = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f98a, this.f100c, this.f101d, false, this.f99b);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float min = ((float) Math.min(i, i2)) / 2.0f;
        float f = ((float) i) / 2.0f;
        float f2 = ((float) i2) / 2.0f;
        this.f98a.set(f - min, f2 - min, f + min, f2 + min);
        RectF rectF = this.f98a;
        float f3 = this.f102e;
        rectF.inset(f3 / 2.0f, f3 / 2.0f);
    }

    public void pullProgress(float f, float f2) {
        if (!this.f103f) {
            this.f101d = Math.min(1.0f, f2) * 330.0f;
            postInvalidate();
        }
    }

    public void pullToRefresh() {
    }

    public void refreshComplete() {
    }

    public void refreshing() {
        this.f103f = true;
        this.f101d = 330.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f104g = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f104g.addUpdateListener(new C0545c(this));
        this.f104g.setRepeatMode(1);
        this.f104g.setRepeatCount(-1);
        this.f104g.setDuration(888);
        this.f104g.start();
    }

    public void releaseToRefresh() {
    }

    public void reset() {
        ValueAnimator valueAnimator = this.f104g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f104g.removeAllUpdateListeners();
            this.f104g = null;
        }
        this.f103f = false;
        this.f100c = 285.0f;
        this.f101d = 0.0f;
    }
}
