package p043jp.reifrontier.gym.p044ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.domain.api.RFGUserChartData;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J`\u00101\u001a\u00020-2\u0006\u0010\"\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u00103\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u00104\u001a\b\u0012\u0004\u0012\u00020 0'2\b\b\u0002\u0010$\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J0\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u00102\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0014H\u0002R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020 0'X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/RFGChartView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "barCount", "barPaint", "Landroid/graphics/Paint;", "barPaint2", "barPaint3", "bmi", "", "bmiMax", "bmiMin", "bodyRectPaint", "borderPaint", "clearView", "", "endPoint", "startPoint", "textBounds", "Landroid/graphics/Rect;", "title", "", "titlePaint", "type", "Ljp/reifrontier/gym/RFGDef$ActivityChartType;", "weight", "xAxisPaint", "xAxisTitles", "", "Ljp/reifrontier/gym/domain/api/RFGUserChartData;", "xAxisValues", "yAxisPaint", "yAxisTitles", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setChartData", "xTitles", "xValues", "yTitles", "setText", "text", "paint", "baseX", "baseY", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.RFGChartView */
public final class RFGChartView extends View {
    private HashMap _$_findViewCache;
    private int barCount;
    private Paint barPaint;
    private Paint barPaint2;
    private Paint barPaint3;
    private float bmi;
    private float bmiMax;
    private float bmiMin;
    private Paint bodyRectPaint;
    private Paint borderPaint;
    private boolean clearView;
    private float endPoint;
    private float startPoint;
    private final Rect textBounds;
    private String title;
    private Paint titlePaint;
    private RFGDef.ActivityChartType type;
    private float weight;
    private Paint xAxisPaint;
    private List<RFGUserChartData> xAxisTitles;
    private List<RFGUserChartData> xAxisValues;
    private Paint yAxisPaint;
    private List<String> yAxisTitles;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.RFGChartView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGDef.ActivityChartType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.ActivityChartType activityChartType = RFGDef.ActivityChartType.POINT;
            iArr[1] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGDef.ActivityChartType activityChartType2 = RFGDef.ActivityChartType.WEIGHT;
            iArr2[2] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGDef.ActivityChartType activityChartType3 = RFGDef.ActivityChartType.STEP;
            iArr3[3] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFGDef.ActivityChartType activityChartType4 = RFGDef.ActivityChartType.BICYCLE;
            iArr4[4] = 4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGChartView(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.textBounds = new Rect();
        this.barCount = 6;
        this.xAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.xAxisValues = CollectionsKt__CollectionsKt.emptyList();
        this.yAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.title = "";
        this.type = RFGDef.ActivityChartType.POINT;
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        this.textBounds = new Rect();
        this.barCount = 6;
        this.xAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.xAxisValues = CollectionsKt__CollectionsKt.emptyList();
        this.yAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.title = "";
        this.type = RFGDef.ActivityChartType.POINT;
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.textBounds = new Rect();
        this.barCount = 6;
        this.xAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.xAxisValues = CollectionsKt__CollectionsKt.emptyList();
        this.yAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.title = "";
        this.type = RFGDef.ActivityChartType.POINT;
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public RFGChartView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        this.textBounds = new Rect();
        this.barCount = 6;
        this.xAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.xAxisValues = CollectionsKt__CollectionsKt.emptyList();
        this.yAxisTitles = CollectionsKt__CollectionsKt.emptyList();
        this.title = "";
        this.type = RFGDef.ActivityChartType.POINT;
        init(context);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGChartView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void init(Context context) {
        Paint paint = new Paint(1);
        this.barPaint = paint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint");
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.barPaint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint");
        }
        paint2.setColor(ContextCompat.getColor(context, R.color.yellow));
        Paint paint3 = this.barPaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint");
        }
        paint3.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint4 = new Paint(1);
        this.barPaint2 = paint4;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint2");
        }
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = this.barPaint2;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint2");
        }
        paint5.setColor(ContextCompat.getColor(context, R.color.green));
        Paint paint6 = this.barPaint2;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint2");
        }
        paint6.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint7 = new Paint(1);
        this.barPaint3 = paint7;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint3");
        }
        paint7.setStyle(Paint.Style.FILL);
        Paint paint8 = this.barPaint3;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint3");
        }
        paint8.setColor(ContextCompat.getColor(context, R.color.blue));
        Paint paint9 = this.barPaint3;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint3");
        }
        paint9.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint10 = new Paint(1);
        this.borderPaint = paint10;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        }
        paint10.setStyle(Paint.Style.STROKE);
        Paint paint11 = this.borderPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        }
        paint11.setColor(ContextCompat.getColor(context, R.color.gray));
        Paint paint12 = this.borderPaint;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        }
        paint12.setStrokeWidth(2.0f);
        Paint paint13 = this.borderPaint;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        }
        paint13.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint14 = new Paint(1);
        this.bodyRectPaint = paint14;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bodyRectPaint");
        }
        paint14.setStyle(Paint.Style.FILL);
        Paint paint15 = this.bodyRectPaint;
        if (paint15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bodyRectPaint");
        }
        paint15.setColor(ContextCompat.getColor(context, R.color.redFade));
        Paint paint16 = this.bodyRectPaint;
        if (paint16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bodyRectPaint");
        }
        paint16.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint17 = new Paint(1);
        this.xAxisPaint = paint17;
        if (paint17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAxisPaint");
        }
        paint17.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint18 = this.xAxisPaint;
        if (paint18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAxisPaint");
        }
        paint18.setColor(ContextCompat.getColor(context, R.color.white));
        Paint paint19 = this.xAxisPaint;
        if (paint19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAxisPaint");
        }
        paint19.setTextSize(50.0f);
        Paint paint20 = new Paint(1);
        this.titlePaint = paint20;
        if (paint20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
        }
        paint20.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint21 = this.titlePaint;
        if (paint21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
        }
        paint21.setColor(ContextCompat.getColor(context, R.color.white));
        Paint paint22 = this.titlePaint;
        if (paint22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
        }
        paint22.setTextSize(40.0f);
        Paint paint23 = new Paint(1);
        this.yAxisPaint = paint23;
        if (paint23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yAxisPaint");
        }
        paint23.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint24 = this.yAxisPaint;
        if (paint24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yAxisPaint");
        }
        paint24.setColor(ContextCompat.getColor(context, R.color.white));
        Paint paint25 = this.yAxisPaint;
        if (paint25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yAxisPaint");
        }
        paint25.setTextSize(36.0f);
    }

    public static /* synthetic */ void setChartData$default(RFGChartView rFGChartView, RFGDef.ActivityChartType activityChartType, List list, List list2, List list3, float f, float f2, float f3, float f4, int i, Object obj) {
        int i2 = i;
        rFGChartView.setChartData(activityChartType, list, list2, list3, (i2 & 16) != 0 ? 0.0f : f, (i2 & 32) != 0 ? 0.0f : f2, (i2 & 64) != 0 ? 0.0f : f3, (i2 & 128) != 0 ? 0.0f : f4);
    }

    private final void setText(String str, Paint paint, Canvas canvas, float f, float f2) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f, f2, paint);
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
        float f;
        float f2;
        int i;
        float f3;
        String str;
        int i2;
        Paint paint;
        float f4;
        float f5;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.clearView) {
            if (canvas2 == null) {
                Intrinsics.throwNpe();
            }
            canvas2.drawColor(Color.argb(0, 0, 0, 0));
            return;
        }
        if (canvas2 == null) {
            Intrinsics.throwNpe();
        }
        canvas2.drawColor(Color.argb(0, 0, 0, 0));
        if (!this.yAxisTitles.isEmpty()) {
            int width = getWidth();
            float height = ((float) getHeight()) - 100.0f;
            this.startPoint = height;
            this.endPoint = 100.0f;
            float f6 = (float) width;
            float f7 = (f6 - 240.0f) / ((float) this.barCount);
            float f8 = f6 - 110.0f;
            int i3 = 4;
            float f9 = (height - 100.0f) / ((float) 4);
            float f10 = height - 100.0f;
            float parseFloat = Float.parseFloat((String) CollectionsKt___CollectionsKt.first(this.yAxisTitles));
            String str2 = this.title;
            Paint paint2 = this.titlePaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
            }
            paint2.getTextBounds(str2, 0, str2.length(), this.textBounds);
            float width2 = (float) ((width - this.textBounds.width()) / 2);
            Paint paint3 = this.titlePaint;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
            }
            canvas2.drawText(str2, width2, 60.0f, paint3);
            int size = this.yAxisTitles.size();
            int i4 = 0;
            while (true) {
                f = 20.0f;
                if (i4 >= size) {
                    break;
                }
                String str3 = this.yAxisTitles.get(i4);
                if (i4 == i3) {
                    float f11 = this.startPoint;
                    float f12 = f8 + 30.0f;
                    Paint paint4 = this.borderPaint;
                    if (paint4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
                    }
                    str = str3;
                    i2 = i4;
                    i = size;
                    float f13 = f12;
                    f3 = f10;
                    canvas.drawLine(42.0f, f11, f13, f11, paint4);
                    f5 = 4.0f + f8;
                    f4 = this.startPoint - 8.0f;
                    paint = this.yAxisPaint;
                    if (paint != null) {
                        canvas2.drawText(str, f5, f4, paint);
                        i4 = i2 + 1;
                        f10 = f3;
                        size = i;
                        i3 = 4;
                    }
                } else {
                    str = str3;
                    i2 = i4;
                    i = size;
                    f3 = f10;
                    float f14 = this.endPoint + (((float) i2) * f9);
                    Paint paint5 = this.borderPaint;
                    if (paint5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
                    }
                    canvas.drawLine(42.0f, f14, f8, f14, paint5);
                    f5 = 10.0f + f8;
                    f4 = f14 + 20.0f;
                    paint = this.yAxisPaint;
                    if (paint != null) {
                        canvas2.drawText(str, f5, f4, paint);
                        i4 = i2 + 1;
                        f10 = f3;
                        size = i;
                        i3 = 4;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException("yAxisPaint");
                canvas2.drawText(str, f5, f4, paint);
                i4 = i2 + 1;
                f10 = f3;
                size = i;
                i3 = 4;
            }
            float f15 = f10;
            float f16 = this.barCount == 6 ? 38.0f : 26.0f;
            if (width < 1000) {
                if (this.barCount != 6) {
                    f = 14.0f;
                }
                f16 = f;
            }
            Paint paint6 = this.xAxisPaint;
            if (paint6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xAxisPaint");
            }
            paint6.setTextSize(f16);
            int size2 = this.xAxisTitles.size();
            for (int i5 = 0; i5 < size2; i5++) {
                float f17 = (((80.0f / ((float) this.barCount)) + f7) * ((float) i5)) + 50.0f;
                String title2 = this.xAxisTitles.get(i5).getTitle();
                Paint paint7 = this.xAxisPaint;
                if (paint7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("xAxisPaint");
                }
                paint7.getTextBounds(title2, 0, title2.length(), this.textBounds);
                float width3 = ((f7 - ((float) this.textBounds.width())) / ((float) 2)) + f17;
                float f18 = this.startPoint + 60.0f;
                Paint paint8 = this.xAxisPaint;
                if (paint8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("xAxisPaint");
                }
                canvas2.drawText(title2, width3, f18, paint8);
            }
            int size3 = this.xAxisValues.size();
            for (int i6 = 0; i6 < size3; i6++) {
                RFGUserChartData rFGUserChartData = this.xAxisValues.get(i6);
                float f19 = (((80.0f / ((float) this.barCount)) + f7) * ((float) i6)) + 50.0f;
                float f20 = f19 + f7;
                int ordinal = this.type.ordinal();
                if (ordinal != 1) {
                    f2 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? 0.0f : rFGUserChartData.distanceF() : rFGUserChartData.stepF() / 10000.0f : rFGUserChartData.weightF();
                } else {
                    float walkPoint = rFGUserChartData.walkPoint();
                    float f21 = this.startPoint;
                    float point = f21 - ((rFGUserChartData.point() / parseFloat) * f15);
                    Paint paint9 = this.barPaint3;
                    if (paint9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("barPaint3");
                    }
                    canvas.drawRect(f19, point, f20, f21, paint9);
                    float f22 = this.startPoint;
                    float bicyclePoint = f22 - ((rFGUserChartData.bicyclePoint() / parseFloat) * f15);
                    Paint paint10 = this.barPaint2;
                    if (paint10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("barPaint2");
                    }
                    canvas.drawRect(f19, bicyclePoint, f20, f22, paint10);
                    f2 = walkPoint;
                }
                float f23 = this.startPoint;
                float f24 = f23 - ((f2 / parseFloat) * f15);
                Paint paint11 = this.barPaint;
                if (paint11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barPaint");
                }
                canvas.drawRect(f19, f24, f20, f23, paint11);
            }
            if (this.type == RFGDef.ActivityChartType.WEIGHT) {
                float f25 = this.startPoint;
                float f26 = f25 - ((this.bmiMax / parseFloat) * f15);
                float f27 = f25 - ((this.bmiMin / parseFloat) * f15);
                Paint paint12 = this.bodyRectPaint;
                if (paint12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bodyRectPaint");
                }
                canvas.drawRect(42.0f, f26, f8, f27, paint12);
                String string = getResources().getString(R.string.bmi_range);
                Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.bmi_range)");
                float f28 = ((f27 - f26) / ((float) 2)) + f26;
                Paint paint13 = this.titlePaint;
                if (paint13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
                }
                paint13.getTextBounds(string, 0, string.length(), this.textBounds);
                float height2 = f28 + ((float) (this.textBounds.height() / 2));
                Paint paint14 = this.titlePaint;
                if (paint14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
                }
                canvas2.drawText(string, 50.0f, height2, paint14);
                float f29 = this.weight - this.bmi;
                String string2 = getResources().getString(R.string.activity_chart_body_message, new Object[]{f29 < ((float) 0) ? "" : "+", Float.valueOf(f29)});
                Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st…chart_body_message, p, s)");
                Paint paint15 = this.titlePaint;
                if (paint15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
                }
                paint15.getTextBounds(string2, 0, string2.length(), this.textBounds);
                int width4 = this.textBounds.width();
                Paint paint16 = this.titlePaint;
                if (paint16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titlePaint");
                }
                setText(string2, paint16, canvas, f8 - ((float) width4), 155.0f);
            }
        }
    }

    public final void setChartData(RFGDef.ActivityChartType activityChartType, List<RFGUserChartData> list, List<RFGUserChartData> list2, List<String> list3, float f, float f2, float f3, float f4) {
        Intrinsics.checkParameterIsNotNull(activityChartType, "type");
        Intrinsics.checkParameterIsNotNull(list, "xTitles");
        Intrinsics.checkParameterIsNotNull(list2, "xValues");
        Intrinsics.checkParameterIsNotNull(list3, "yTitles");
        this.barCount = list2.size();
        this.xAxisTitles = list;
        this.xAxisValues = list2;
        this.yAxisTitles = list3;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.title = activityChartType.getTitle(context);
        this.type = activityChartType;
        this.weight = f;
        this.bmi = f2;
        this.bmiMin = f3;
        this.bmiMax = f4;
        Paint paint = this.barPaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barPaint");
        }
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        paint.setColor(activityChartType.getColor(context2));
        invalidate();
    }
}
