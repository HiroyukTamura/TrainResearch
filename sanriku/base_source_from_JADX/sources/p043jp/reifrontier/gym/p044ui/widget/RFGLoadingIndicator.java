package p043jp.reifrontier.gym.p044ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 O2\u00020\u0001:\u0001OB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0017J\b\u0010(\u001a\u00020!H\u0014J\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020!J,\u0010+\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020!H\u0014J\b\u00100\u001a\u00020!H\u0014J\u0010\u00101\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014J(\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0014J\u0018\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\tH\u0014J\b\u0010=\u001a\u00020!H\u0002J\b\u0010>\u001a\u00020!H\u0002J\u0012\u0010>\u001a\u00020!2\b\u0010?\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\tH\u0016J\u0006\u0010D\u001a\u00020!J\u0006\u0010E\u001a\u00020!J\u0006\u0010F\u001a\u00020!J\b\u0010G\u001a\u00020!H\u0002J\b\u0010H\u001a\u00020!H\u0002J\u0018\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\tH\u0002J\b\u0010L\u001a\u00020!H\u0002J\u0010\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020.H\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGLoadingIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "defaultIndicator", "Ljp/reifrontier/gym/ui/widget/RFGIndicator;", "mDelayedHide", "Ljava/lang/Runnable;", "mDelayedShow", "mDismissed", "", "mIndicator", "mIndicatorColor", "mMaxHeight", "mMaxWidth", "mMinHeight", "mMinWidth", "mPostedHide", "mPostedShow", "mShouldStartAnimationDrawable", "mStartTime", "", "drawTrack", "", "canvas", "Landroid/graphics/Canvas;", "drawableHotspotChanged", "x", "", "y", "drawableStateChanged", "getIndicator", "hide", "init", "invalidateDrawable", "dr", "Landroid/graphics/drawable/Drawable;", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onVisibilityChanged", "changedView", "visibility", "removeCallbacks", "setIndicator", "d", "setIndicatorColor", "color", "setVisibility", "v", "show", "smoothToHide", "smoothToShow", "startAnimation", "stopAnimation", "updateDrawableBounds", "ws", "hs", "updateDrawableState", "verifyDrawable", "who", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGLoadingIndicator */
public final class RFGLoadingIndicator extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private HashMap _$_findViewCache;
    private final RFGIndicator defaultIndicator;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    /* access modifiers changed from: private */
    public boolean mDismissed;
    private RFGIndicator mIndicator;
    private int mIndicatorColor;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMinHeight;
    private int mMinWidth;
    /* access modifiers changed from: private */
    public boolean mPostedHide;
    /* access modifiers changed from: private */
    public boolean mPostedShow;
    private boolean mShouldStartAnimationDrawable;
    /* access modifiers changed from: private */
    public long mStartTime;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGLoadingIndicator$Companion;", "", "()V", "MIN_DELAY", "", "MIN_SHOW_TIME", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.RFGLoadingIndicator$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RFGLoadingIndicator(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RFGLoadingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.AVLoadingIndicatorView);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGLoadingIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.defaultIndicator = new RFGIndicator();
        this.mStartTime = -1;
        this.mDelayedHide = new RFGLoadingIndicator$mDelayedHide$1(this);
        this.mDelayedShow = new RFGLoadingIndicator$mDelayedShow$1(this);
        init$default(this, context, attributeSet, i, 0, 8, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public RFGLoadingIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.defaultIndicator = new RFGIndicator();
        this.mStartTime = -1;
        this.mDelayedHide = new RFGLoadingIndicator$mDelayedHide$1(this);
        this.mDelayedShow = new RFGLoadingIndicator$mDelayedShow$1(this);
        init(context, attributeSet, i, i2);
    }

    private final void drawTrack(Canvas canvas) {
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator != null) {
            int save = canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            rFGIndicator.draw(canvas);
            canvas.restoreToCount(save);
            if (this.mShouldStartAnimationDrawable) {
                rFGIndicator.start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    private final void init(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2092R.styleable.RFGLoadingIndicator, i, i2);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(5, this.mMinWidth);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(3, this.mMaxWidth);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(4, this.mMinHeight);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(2, this.mMaxHeight);
        this.mIndicatorColor = obtainStyledAttributes.getColor(0, -1);
        setIndicator();
        if (this.mIndicator == null) {
            setIndicator(this.defaultIndicator);
        }
        obtainStyledAttributes.recycle();
    }

    static /* synthetic */ void init$default(RFGLoadingIndicator rFGLoadingIndicator, Context context, AttributeSet attributeSet, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = R.style.AVLoadingIndicatorView;
        }
        rFGLoadingIndicator.init(context, attributeSet, i, i2);
    }

    private final void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    private final void setIndicator() {
        setIndicator(RFGIndicator.Companion.newInstance());
    }

    private final void setIndicator(RFGIndicator rFGIndicator) {
        if (!Intrinsics.areEqual((Object) this.mIndicator, (Object) rFGIndicator)) {
            RFGIndicator rFGIndicator2 = this.mIndicator;
            if (rFGIndicator2 != null) {
                if (rFGIndicator2 == null) {
                    Intrinsics.throwNpe();
                }
                rFGIndicator2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.mIndicator);
            }
            this.mIndicator = rFGIndicator;
            setIndicatorColor(this.mIndicatorColor);
            if (rFGIndicator != null) {
                rFGIndicator.setCallback(this);
            }
            postInvalidate();
        }
    }

    private final void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator == null) {
            Intrinsics.throwNpe();
        }
        rFGIndicator.setColor(i);
    }

    private final void startAnimation() {
        if (getVisibility() == 0) {
            if (this.mIndicator instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
            }
            postInvalidate();
        }
    }

    private final void stopAnimation() {
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator instanceof Animatable) {
            if (rFGIndicator == null) {
                Intrinsics.throwNpe();
            }
            rFGIndicator.stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateDrawableBounds(int r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.getPaddingRight()
            int r1 = r7.getPaddingLeft()
            int r1 = r1 + r0
            int r8 = r8 - r1
            int r0 = r7.getPaddingTop()
            int r1 = r7.getPaddingBottom()
            int r1 = r1 + r0
            int r9 = r9 - r1
            jp.reifrontier.gym.ui.widget.RFGIndicator r0 = r7.mIndicator
            if (r0 == 0) goto L_0x005e
            if (r0 != 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x001d:
            int r0 = r0.getIntrinsicWidth()
            jp.reifrontier.gym.ui.widget.RFGIndicator r1 = r7.mIndicator
            if (r1 != 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0028:
            int r1 = r1.getIntrinsicHeight()
            float r0 = (float) r0
            float r1 = (float) r1
            float r0 = r0 / r1
            float r1 = (float) r8
            float r2 = (float) r9
            float r3 = r1 / r2
            r4 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0053
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0047
            float r2 = r2 * r0
            int r0 = (int) r2
            int r8 = r8 - r0
            int r8 = r8 / 2
            int r0 = r0 + r8
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x0054
        L_0x0047:
            r2 = 1
            float r2 = (float) r2
            float r2 = r2 / r0
            float r2 = r2 * r1
            int r0 = (int) r2
            int r9 = r9 - r0
            int r9 = r9 / 2
            int r0 = r0 + r9
            r4 = r9
            r9 = r0
        L_0x0053:
            r0 = 0
        L_0x0054:
            jp.reifrontier.gym.ui.widget.RFGIndicator r1 = r7.mIndicator
            if (r1 != 0) goto L_0x005b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x005b:
            r1.setBounds(r0, r4, r8, r9)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.p044ui.widget.RFGLoadingIndicator.updateDrawableBounds(int, int):void");
    }

    private final void updateDrawableState() {
        int[] drawableState = getDrawableState();
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator != null) {
            if (rFGIndicator == null) {
                Intrinsics.throwNpe();
            }
            if (rFGIndicator.isStateful()) {
                RFGIndicator rFGIndicator2 = this.mIndicator;
                if (rFGIndicator2 == null) {
                    Intrinsics.throwNpe();
                }
                rFGIndicator2.setState(drawableState);
            }
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

    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator != null) {
            if (rFGIndicator == null) {
                Intrinsics.throwNpe();
            }
            rFGIndicator.setHotspot(f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    public final RFGIndicator getIndicator() {
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator == null) {
            Intrinsics.throwNpe();
        }
        return rFGIndicator;
    }

    public final void hide() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mStartTime;
        long j2 = currentTimeMillis - j;
        long j3 = (long) 500;
        if (j2 >= j3 || j == -1) {
            setVisibility(8);
        } else if (!this.mPostedHide) {
            postDelayed(this.mDelayedHide, j3 - j2);
            this.mPostedHide = true;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "dr");
        if (verifyDrawable(drawable)) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
        removeCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        drawTrack(canvas);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        RFGIndicator rFGIndicator = this.mIndicator;
        if (rFGIndicator != null) {
            i3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, rFGIndicator.getIntrinsicWidth()));
            i4 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, rFGIndicator.getIntrinsicHeight()));
        } else {
            i4 = 0;
            i3 = 0;
        }
        updateDrawableState();
        setMeasuredDimension(View.resolveSizeAndState(getPaddingLeft() + getPaddingRight() + i3, i, 0), View.resolveSizeAndState(getPaddingTop() + getPaddingBottom() + i4, i2, 0));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateDrawableBounds(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "changedView");
        super.onVisibilityChanged(view, i);
        if (i == 8 || i == 4) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    public final void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, (long) 500);
            this.mPostedShow = true;
        }
    }

    public final void smoothToHide() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        setVisibility(8);
    }

    public final void smoothToShow() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "who");
        return drawable == this.mIndicator || super.verifyDrawable(drawable);
    }
}
