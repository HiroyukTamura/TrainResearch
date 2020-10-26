/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.common.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import jp.co.jreast.jreastapp.commuter.ak;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/view/OutlineTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mText", "", "getMText", "()Ljava/lang/String;", "setMText", "(Ljava/lang/String;)V", "mTextColor", "", "mTextSize", "paintBorder", "Landroid/graphics/Paint;", "paintText", "scale", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class OutlineTextView
extends View {
    public static final a a = new a(null);
    private String b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private Paint g;

    public OutlineTextView(Context context) {
        this(context, null, 2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public OutlineTextView(Context context, AttributeSet object) {
        Resources resources;
        void var2_5;
        block3 : {
            block2 : {
                j.b((Object)context, "context");
                super(context, object);
                this.b = "";
                this.c = 16;
                this.d = -16777216;
                resources = context.getResources();
                j.a((Object)resources, "context.resources");
                this.e = resources.getDisplayMetrics().density;
                this.f = new Paint();
                this.g = new Paint();
                resources = context.obtainStyledAttributes(object, ak.b.OutlineTextView, 0, 0);
                try {
                    this.c = resources.getDimensionPixelSize(2, 16);
                    this.d = resources.getColor(1, -16777216);
                    String string2 = resources.getString(0);
                    if (string2 == null) break block2;
                    break block3;
                }
                catch (Throwable throwable) {
                    resources.recycle();
                    throw throwable;
                }
            }
            String string3 = "";
        }
        this.b = var2_5;
        resources.recycle();
        int n2 = (int)((float)8 * this.e);
        this.setPadding(n2, 0, n2, 0);
        n2 = this.c;
        context = Typeface.createFromAsset((AssetManager)context.getAssets(), (String)"fonts/TT-UDShinGoPro-Bold.ttf");
        this.f.setTypeface((Typeface)context);
        this.f.setAntiAlias(true);
        Paint paint = this.f;
        float f2 = n2;
        paint.setTextSize(f2);
        this.f.setTextAlign(Paint.Align.LEFT);
        this.f.setStrokeWidth((float)10 * this.e);
        this.f.setStrokeJoin(Paint.Join.ROUND);
        this.f.setStrokeCap(Paint.Cap.ROUND);
        this.f.setColor(-1);
        this.f.setStyle(Paint.Style.STROKE);
        this.g.setTypeface((Typeface)context);
        this.g.setAntiAlias(true);
        this.g.setTextSize(f2);
        this.g.setTextAlign(Paint.Align.LEFT);
        this.g.setStrokeWidth(0.0f);
        this.g.setColor(this.d);
        this.g.setStyle(Paint.Style.FILL);
    }

    public /* synthetic */ OutlineTextView(Context context, AttributeSet attributeSet, int n2, g g2) {
        if ((n2 & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public static final void a(OutlineTextView outlineTextView, String string2) {
        a.a(outlineTextView, string2);
    }

    public void draw(Canvas canvas) {
        j.b((Object)canvas, "canvas");
        super.draw(canvas);
        boolean bl2 = ((CharSequence)this.b).length() == 0;
        if (bl2) {
            return;
        }
        Rect rect = new Rect();
        this.f.getTextBounds(this.b, 0, this.b.length(), rect);
        this.g.getTextBounds(this.b, 0, this.b.length(), rect);
        float f2 = (float)(this.getWidth() - rect.width()) / 2.0f;
        float f3 = (float)this.getHeight() / 2.0f + (float)rect.height() / 2.0f - (float)rect.bottom;
        canvas.drawText(this.b, f2, f3, this.f);
        canvas.drawText(this.b, f2, f3, this.g);
    }

    public final String getMText() {
        return this.b;
    }

    public final void setMText(String string2) {
        j.b(string2, "<set-?>");
        this.b = string2;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/view/OutlineTextView$Companion;", "", "()V", "setCustomText", "", "view", "Ljp/co/jreast/jreastapp/commuter/common/view/OutlineTextView;", "value", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final void a(OutlineTextView outlineTextView, String string2) {
            j.b((Object)outlineTextView, "view");
            j.b(string2, "value");
            outlineTextView.setMText(string2);
            outlineTextView.invalidate();
        }
    }

}

