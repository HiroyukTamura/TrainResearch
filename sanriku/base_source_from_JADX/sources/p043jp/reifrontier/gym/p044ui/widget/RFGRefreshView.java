package p043jp.reifrontier.gym.p044ui.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.dinuscxj.refresh.C0543a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0016`\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGRefreshView;", "Landroid/view/View;", "Lcom/dinuscxj/refresh/IRefreshStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mAnimators", "", "Landroid/animation/ValueAnimator;", "mPaint", "Landroid/graphics/Paint;", "mUpdateListeners", "Ljava/util/HashMap;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Lkotlin/collections/HashMap;", "scaleYFloats", "", "addUpdateListener", "", "animator", "updateListener", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "init", "onCreateAnimators", "onDraw", "pullProgress", "pullDistance", "", "pullToRefresh", "refreshComplete", "refreshing", "releaseToRefresh", "reset", "startAnimator", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGRefreshView */
public final class RFGRefreshView extends View implements C0543a {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float SCALE = 1.0f;
    private HashMap _$_findViewCache;
    private List<? extends ValueAnimator> mAnimators;
    private final Paint mPaint;
    private final HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> mUpdateListeners;
    /* access modifiers changed from: private */
    public float[] scaleYFloats;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGRefreshView$Companion;", "", "()V", "SCALE", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.RFGRefreshView$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGRefreshView(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.scaleYFloats = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.mUpdateListeners = new HashMap<>();
        this.mPaint = new Paint();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        this.scaleYFloats = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.mUpdateListeners = new HashMap<>();
        this.mPaint = new Paint();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.scaleYFloats = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.mUpdateListeners = new HashMap<>();
        this.mPaint = new Paint();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public RFGRefreshView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        this.scaleYFloats = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.mUpdateListeners = new HashMap<>();
        this.mPaint = new Paint();
        init();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGRefreshView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
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

    private final void init() {
        this.mPaint.setColor(-7829368);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
    }

    private final List<ValueAnimator> onCreateAnimators() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {500, 250, 0, 250, 500};
        for (int i = 0; i <= 4; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "scaleAnim");
            ofFloat.setDuration(1000);
            ofFloat.setRepeatCount(0);
            ofFloat.setStartDelay(jArr[i]);
            addUpdateListener(ofFloat, new RFGRefreshView$onCreateAnimators$1(this, i));
            arrayList.add(ofFloat);
        }
        return arrayList;
    }

    private final void startAnimator() {
        List<ValueAnimator> onCreateAnimators = onCreateAnimators();
        this.mAnimators = onCreateAnimators;
        if (onCreateAnimators == null) {
            Intrinsics.throwNpe();
        }
        for (ValueAnimator next : onCreateAnimators) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mUpdateListeners.get(next);
            if (animatorUpdateListener != null) {
                next.addUpdateListener(animatorUpdateListener);
            }
            next.start();
        }
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
        draw(canvas, this.mPaint);
    }

    public void pullProgress(float f, float f2) {
    }

    public void pullToRefresh() {
    }

    public void refreshComplete() {
    }

    public void refreshing() {
        startAnimator();
    }

    public void releaseToRefresh() {
    }

    public void reset() {
    }
}
