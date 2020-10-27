package p043jp.reifrontier.gym.p044ui.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\b\u0010%\u001a\u00020\u0005H\u0016J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0007J\b\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0002J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\fH\u0002J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0007H\u0014J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0005J\u0012\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J(\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010=\u001a\u00020\u0017H\u0016J\b\u0010>\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGIndicator;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "()V", "alpha", "", "drawBounds", "Landroid/graphics/Rect;", "mAnimators", "", "Landroid/animation/ValueAnimator;", "mHasAnimators", "", "mPaint", "Landroid/graphics/Paint;", "mUpdateListeners", "Ljava/util/HashMap;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Lkotlin/collections/HashMap;", "scaleYFloats", "", "zeroBoundRect", "addUpdateListener", "", "animator", "updateListener", "centerX", "centerY", "colorInit", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "ensureAnimators", "exactCenterX", "", "exactCenterY", "getAlpha", "getColor", "getDrawBounds", "getHeight", "getOpacity", "getWidth", "isRunning", "isStarted", "onBoundsChange", "bounds", "onCreateAnimators", "postInvalidate", "setAlpha", "setColor", "color", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setDrawBounds", "setDrawBounds2", "left", "top", "right", "bottom", "start", "startAnimators", "stop", "stopAnimators", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGIndicator */
public final class RFGIndicator extends Drawable implements Animatable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float SCALE = 1.0f;
    /* access modifiers changed from: private */
    public static final String TAG;
    private int alpha = 255;
    private Rect drawBounds;
    private List<? extends ValueAnimator> mAnimators;
    private boolean mHasAnimators;
    private final Paint mPaint;
    private final HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> mUpdateListeners = new HashMap<>();
    /* access modifiers changed from: private */
    public float[] scaleYFloats = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    private final Rect zeroBoundRect;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGIndicator$Companion;", "", "()V", "SCALE", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Ljp/reifrontier/gym/ui/widget/RFGIndicator;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.RFGIndicator$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RFGIndicator.TAG;
        }

        public final RFGIndicator newInstance() {
            RFGIndicator rFGIndicator = new RFGIndicator();
            rFGIndicator.colorInit();
            return rFGIndicator;
        }
    }

    static {
        String simpleName = RFGIndicator.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGIndicator::class.java.simpleName");
        TAG = simpleName;
    }

    public RFGIndicator() {
        Rect rect = new Rect();
        this.zeroBoundRect = rect;
        this.drawBounds = rect;
        this.mPaint = new Paint();
    }

    private final void addUpdateListener(ValueAnimator valueAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mUpdateListeners.put(valueAnimator, animatorUpdateListener);
    }

    private final void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 11);
        float height = (float) (getHeight() / 2);
        for (int i = 0; i <= 4; i++) {
            canvas.save();
            float f = (float) 2;
            float f2 = width / f;
            canvas.translate((((float) ((i * 2) + 2)) * width) - f2, height);
            canvas.scale(1.0f, this.scaleYFloats[i]);
            canvas.drawRoundRect(new RectF((-width) / f, ((float) (-getHeight())) / 2.5f, f2, ((float) getHeight()) / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    private final void ensureAnimators() {
        if (!this.mHasAnimators) {
            this.mAnimators = onCreateAnimators();
            this.mHasAnimators = true;
        }
    }

    private final int getHeight() {
        return this.drawBounds.height();
    }

    private final int getWidth() {
        return this.drawBounds.width();
    }

    private final boolean isStarted() {
        List<? extends ValueAnimator> list = this.mAnimators;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        Iterator<? extends ValueAnimator> it = list.iterator();
        if (it.hasNext()) {
            return ((ValueAnimator) it.next()).isStarted();
        }
        return false;
    }

    private final List<ValueAnimator> onCreateAnimators() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {500, 250, 0, 250, 500};
        for (int i = 0; i <= 4; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f, 1.0f});
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "scaleAnim");
            ofFloat.setDuration(1000);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i]);
            addUpdateListener(ofFloat, new RFGIndicator$onCreateAnimators$1(this, i));
            arrayList.add(ofFloat);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void postInvalidate() {
        invalidateSelf();
    }

    private final void setDrawBounds(Rect rect) {
        setDrawBounds2(rect.left, rect.top, rect.right, rect.bottom);
    }

    private final void setDrawBounds2(int i, int i2, int i3, int i4) {
        this.drawBounds = new Rect(i, i2, i3, i4);
    }

    private final void startAnimators() {
        List<? extends ValueAnimator> list = this.mAnimators;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        for (ValueAnimator valueAnimator : list) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mUpdateListeners.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
    }

    private final void stopAnimators() {
        List<? extends ValueAnimator> list = this.mAnimators;
        if (list != null) {
            if (list == null) {
                Intrinsics.throwNpe();
            }
            for (ValueAnimator valueAnimator : list) {
                if (valueAnimator.isStarted()) {
                    valueAnimator.removeAllUpdateListeners();
                    valueAnimator.end();
                }
            }
        }
    }

    public final int centerX() {
        return this.drawBounds.centerX();
    }

    public final int centerY() {
        return this.drawBounds.centerY();
    }

    public final void colorInit() {
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        draw(canvas, this.mPaint);
    }

    public final float exactCenterX() {
        return this.drawBounds.exactCenterX();
    }

    public final float exactCenterY() {
        return this.drawBounds.exactCenterY();
    }

    public int getAlpha() {
        return this.alpha;
    }

    public final int getColor() {
        return this.mPaint.getColor();
    }

    public final Rect getDrawBounds() {
        return this.drawBounds;
    }

    public int getOpacity() {
        return -1;
    }

    public boolean isRunning() {
        List<? extends ValueAnimator> list = this.mAnimators;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        Iterator<? extends ValueAnimator> it = list.iterator();
        if (it.hasNext()) {
            return ((ValueAnimator) it.next()).isRunning();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "bounds");
        super.onBoundsChange(rect);
        setDrawBounds(rect);
    }

    public void setAlpha(int i) {
        this.alpha = i;
    }

    public final void setColor(int i) {
        this.mPaint.setColor(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void start() {
        ensureAnimators();
        if (this.mAnimators != null && !isStarted()) {
            startAnimators();
            invalidateSelf();
        }
    }

    public void stop() {
        stopAnimators();
    }
}
