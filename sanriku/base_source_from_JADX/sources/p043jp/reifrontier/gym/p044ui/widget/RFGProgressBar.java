package p043jp.reifrontier.gym.p044ui.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u001e\u0010'\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010,\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundPaint", "Landroid/graphics/Paint;", "color", "foregroundPaint", "foregroundPaint2", "foregroundPaint3", "max", "min", "progress", "", "progress2", "progress3", "rectF", "Landroid/graphics/RectF;", "rectF2", "rectFInner", "startAngle", "strokeWidth", "objectAnimation", "", "property", "", "duration", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCircle", "setColor", "setProgress", "setProgress2", "setProgress3", "setProgressWithAnimation", "setStrokeWidth", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGProgressBar */
public final class RFGProgressBar extends View {
    private HashMap _$_findViewCache;
    private final Paint backgroundPaint;
    private int color;
    private final Paint foregroundPaint;
    private final Paint foregroundPaint2;
    private final Paint foregroundPaint3;
    private int max;
    private int min;
    private float progress;
    private float progress2;
    private float progress3;
    private final RectF rectF;
    private final RectF rectF2;
    private final RectF rectFInner;
    private final int startAngle;
    private float strokeWidth;

    @JvmOverloads
    public RFGProgressBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public RFGProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RFGProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.strokeWidth = 40.0f;
        this.max = 100;
        this.startAngle = -90;
        this.color = -1;
        this.rectF = new RectF();
        this.rectF2 = new RectF();
        this.rectFInner = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2092R.styleable.CircleProgressBar, 0, 0);
        try {
            this.strokeWidth = obtainStyledAttributes.getDimension(3, this.strokeWidth);
            this.progress = obtainStyledAttributes.getFloat(2, this.progress);
            this.color = obtainStyledAttributes.getInt(4, this.color);
            this.min = obtainStyledAttributes.getInt(1, this.min);
            this.max = obtainStyledAttributes.getInt(0, this.max);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.foregroundPaint = paint;
            paint.setColor(ContextCompat.getColor(context, R.color.yellow));
            this.foregroundPaint.setStyle(Paint.Style.STROKE);
            this.foregroundPaint.setStrokeWidth(this.strokeWidth);
            this.foregroundPaint.setStrokeCap(Paint.Cap.SQUARE);
            Paint paint2 = new Paint(1);
            this.foregroundPaint2 = paint2;
            paint2.setColor(ContextCompat.getColor(context, R.color.green));
            this.foregroundPaint2.setStyle(Paint.Style.STROKE);
            this.foregroundPaint2.setStrokeWidth(this.strokeWidth);
            this.foregroundPaint2.setStrokeCap(Paint.Cap.SQUARE);
            Paint paint3 = new Paint(1);
            this.foregroundPaint3 = paint3;
            paint3.setColor(ContextCompat.getColor(context, R.color.blue));
            this.foregroundPaint3.setStyle(Paint.Style.STROKE);
            this.foregroundPaint3.setStrokeWidth(this.strokeWidth);
            this.foregroundPaint3.setStrokeCap(Paint.Cap.SQUARE);
            Paint paint4 = new Paint(1);
            this.backgroundPaint = paint4;
            paint4.setColor(ContextCompat.getColor(context, R.color.black));
            this.backgroundPaint.setStyle(Paint.Style.STROKE);
            this.backgroundPaint.setStrokeWidth(this.strokeWidth);
            this.backgroundPaint.setStrokeCap(Paint.Cap.SQUARE);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void objectAnimation(String str, float f, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, str, new float[]{f});
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "objectAnimator");
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        float f = (float) 360;
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.rectF, (float) this.startAngle, f, false, this.backgroundPaint);
        Canvas canvas3 = canvas;
        canvas3.drawArc(this.rectF, (float) this.startAngle, (this.progress3 * f) / ((float) this.max), false, this.foregroundPaint3);
        canvas3.drawArc(this.rectF, (float) this.startAngle, (this.progress2 * f) / ((float) this.max), false, this.foregroundPaint2);
        Canvas canvas4 = canvas;
        canvas4.drawArc(this.rectF, (float) this.startAngle, (f * this.progress) / ((float) this.max), false, this.foregroundPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min2 = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
        float f = (float) min2;
        float f2 = this.strokeWidth;
        float f3 = f2 / ((float) 2);
        setMeasuredDimension(min2, min2);
        float f4 = f2 + f3;
        float f5 = f - f3;
        float f6 = f5 - f2;
        this.rectF.set(f4, f4, f6, f6);
        this.rectF2.set(f3, f3, f5, f5);
        float f7 = f2 + f2;
        float f8 = (f - f2) - f2;
        this.rectFInner.set(f7, f7, f8, f8);
    }

    public final void setCircle(float f, float f2, float f3) {
        this.progress = f;
        this.progress2 = f2;
        this.progress3 = f3;
        invalidate();
    }

    public final void setColor(int i) {
        this.color = i;
        this.foregroundPaint.setColor(i);
        invalidate();
        requestLayout();
    }

    public final void setProgress(float f) {
        this.progress = f;
        invalidate();
    }

    public final void setProgress2(float f) {
        this.progress2 = f;
        invalidate();
    }

    public final void setProgress3(float f) {
        this.progress3 = f;
        invalidate();
    }

    public final void setProgressWithAnimation(float f, float f2, float f3) {
        objectAnimation(NotificationCompat.CATEGORY_PROGRESS, f, 500);
        objectAnimation("progress2", f2, 600);
        objectAnimation("progress3", f3, 800);
    }

    public final void setStrokeWidth(float f) {
        this.strokeWidth = f;
        this.foregroundPaint.setStrokeWidth(f);
        this.foregroundPaint2.setStrokeWidth(f);
        this.foregroundPaint3.setStrokeWidth(f);
        this.backgroundPaint.setStrokeWidth(f);
        invalidate();
        requestLayout();
    }
}
