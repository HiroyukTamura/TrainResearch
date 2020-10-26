/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.PathMeasure
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Shader
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.VectorDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.k.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.graphics.b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i
extends androidx.k.a.a.h {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private g b;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g = true;
    private Drawable.ConstantState h;
    private final float[] i = new float[9];
    private final Matrix j = new Matrix();
    private final Rect k = new Rect();

    i() {
        this.b = new g();
    }

    i(g g2) {
        this.b = g2;
        this.d = this.a(this.d, g2.c, g2.d);
    }

    static int a(int n2, float f2) {
        return n2 & 16777215 | (int)((float)Color.alpha((int)n2) * f2) << 24;
    }

    private static PorterDuff.Mode a(int n2, PorterDuff.Mode mode) {
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    switch (n2) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static i a(Resources resources, int n2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 24) {
            i i2 = new i();
            i2.c = androidx.core.a.a.f.a(resources, n2, theme);
            i2.h = new h(i2.c.getConstantState());
            return i2;
        }
        XmlResourceParser xmlResourceParser = resources.getXml(n2);
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
        while ((n2 = xmlResourceParser.next()) != 2 && n2 != 1) {
        }
        if (n2 != 2) throw new XmlPullParserException("No start tag found");
        try {
            return i.a(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme);
        }
        catch (IOException | XmlPullParserException iOException) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)iOException);
            return null;
        }
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i i2 = new i();
        i2.inflate(resources, xmlPullParser, attributeSet, theme);
        return i2;
    }

    private void a(TypedArray object, XmlPullParser object2) {
        g g2 = this.b;
        f f2 = g2.b;
        g2.d = i.a(androidx.core.a.a.g.a(object, (XmlPullParser)object2, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = object.getColorStateList(1);
        if (colorStateList != null) {
            g2.c = colorStateList;
        }
        g2.e = androidx.core.a.a.g.a(object, (XmlPullParser)object2, "autoMirrored", 5, g2.e);
        f2.f = androidx.core.a.a.g.a(object, (XmlPullParser)object2, "viewportWidth", 7, f2.f);
        f2.g = androidx.core.a.a.g.a(object, (XmlPullParser)object2, "viewportHeight", 8, f2.g);
        if (!(f2.f <= 0.0f)) {
            if (!(f2.g <= 0.0f)) {
                f2.d = object.getDimension(3, f2.d);
                f2.e = object.getDimension(2, f2.e);
                if (!(f2.d <= 0.0f)) {
                    if (!(f2.e <= 0.0f)) {
                        f2.setAlpha(androidx.core.a.a.g.a(object, (XmlPullParser)object2, "alpha", 4, f2.getAlpha()));
                        object = object.getString(0);
                        if (object != null) {
                            f2.i = object;
                            f2.k.put((String)object, f2);
                        }
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(object.getPositionDescription());
                    ((StringBuilder)object2).append("<vector> tag requires height > 0");
                    throw new XmlPullParserException(((StringBuilder)object2).toString());
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(object.getPositionDescription());
                ((StringBuilder)object2).append("<vector> tag requires width > 0");
                throw new XmlPullParserException(((StringBuilder)object2).toString());
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(object.getPositionDescription());
            ((StringBuilder)object2).append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(((StringBuilder)object2).toString());
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(object.getPositionDescription());
        ((StringBuilder)object2).append("<vector> tag requires viewportWidth > 0");
        throw new XmlPullParserException(((StringBuilder)object2).toString());
    }

    private boolean a() {
        boolean bl2;
        int n2 = Build.VERSION.SDK_INT;
        boolean bl3 = bl2 = false;
        if (n2 >= 17) {
            bl3 = bl2;
            if (this.isAutoMirrored()) {
                bl3 = bl2;
                if (androidx.core.graphics.drawable.a.h(this) == 1) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g g2 = this.b;
        f f2 = g2.b;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
        arrayDeque.push(f2.c);
        int n2 = xmlPullParser.getEventType();
        int n3 = xmlPullParser.getDepth();
        int n4 = 1;
        while (n2 != 1 && (xmlPullParser.getDepth() >= n3 + 1 || n2 != 3)) {
            int n5;
            block13 : {
                block9 : {
                    block11 : {
                        Object object;
                        c c2;
                        block12 : {
                            block10 : {
                                if (n2 != 2) break block9;
                                object = xmlPullParser.getName();
                                c2 = (c)arrayDeque.peek();
                                if (!"path".equals(object)) break block10;
                                object = new b();
                                ((b)object).a(resources, attributeSet, theme, xmlPullParser);
                                c2.b.add((d)object);
                                if (((e)object).getPathName() != null) {
                                    f2.k.put(((e)object).getPathName(), object);
                                }
                                n4 = 0;
                                n2 = g2.a;
                                n5 = ((b)object).o;
                                break block11;
                            }
                            if (!"clip-path".equals(object)) break block12;
                            object = new a();
                            ((a)object).a(resources, attributeSet, theme, xmlPullParser);
                            c2.b.add((d)object);
                            if (((e)object).getPathName() != null) {
                                f2.k.put(((e)object).getPathName(), object);
                            }
                            n2 = g2.a;
                            n5 = ((a)object).o;
                            break block11;
                        }
                        n5 = n4;
                        if (!"group".equals(object)) break block13;
                        object = new c();
                        ((c)object).a(resources, attributeSet, theme, xmlPullParser);
                        c2.b.add((d)object);
                        arrayDeque.push(object);
                        if (((c)object).getGroupName() != null) {
                            f2.k.put(((c)object).getGroupName(), object);
                        }
                        n2 = g2.a;
                        n5 = ((c)object).e;
                    }
                    g2.a = n5 | n2;
                    n5 = n4;
                    break block13;
                }
                n5 = n4;
                if (n2 == 3) {
                    n5 = n4;
                    if ("group".equals(xmlPullParser.getName())) {
                        arrayDeque.pop();
                        n5 = n4;
                    }
                }
            }
            n2 = xmlPullParser.next();
            n4 = n5;
        }
        if (n4 == 0) {
            return;
        }
        throw new XmlPullParserException("no path defined");
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    Object a(String string2) {
        return this.b.b.k.get(string2);
    }

    void a(boolean bl2) {
        this.g = bl2;
    }

    public boolean canApplyTheme() {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.d(this.c);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
            return;
        }
        this.copyBounds(this.k);
        if (this.k.width() > 0) {
            if (this.k.height() <= 0) {
                return;
            }
            Object object = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float f2 = Math.abs(this.i[0]);
            float f3 = Math.abs(this.i[4]);
            float f4 = Math.abs(this.i[1]);
            float f5 = Math.abs(this.i[3]);
            if (f4 != 0.0f || f5 != 0.0f) {
                f2 = 1.0f;
                f3 = 1.0f;
            }
            int n2 = (int)((float)this.k.width() * f2);
            int n3 = (int)((float)this.k.height() * f3);
            n2 = Math.min(2048, n2);
            n3 = Math.min(2048, n3);
            if (n2 > 0) {
                if (n3 <= 0) {
                    return;
                }
                int n4 = canvas.save();
                canvas.translate((float)this.k.left, (float)this.k.top);
                if (this.a()) {
                    canvas.translate((float)this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.b.b(n2, n3);
                if (!this.g) {
                    this.b.a(n2, n3);
                } else if (!this.b.b()) {
                    this.b.a(n2, n3);
                    this.b.c();
                }
                this.b.a(canvas, (ColorFilter)object, this.k);
                canvas.restoreToCount(n4);
            }
        }
    }

    public int getAlpha() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.c(this.c);
        }
        return this.b.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        if (this.c != null) {
            return this.c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.c != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.c.getConstantState());
        }
        this.b.a = this.getChangingConfigurations();
        return this.b;
    }

    public int getIntrinsicHeight() {
        if (this.c != null) {
            return this.c.getIntrinsicHeight();
        }
        return (int)this.b.b.e;
    }

    public int getIntrinsicWidth() {
        if (this.c != null) {
            return this.c.getIntrinsicWidth();
        }
        return (int)this.b.b.d;
    }

    public int getOpacity() {
        if (this.c != null) {
            return this.c.getOpacity();
        }
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.c != null) {
            this.c.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g g2 = this.b;
        g2.b = new f();
        TypedArray typedArray = androidx.core.a.a.g.a(resources, theme, attributeSet, androidx.k.a.a.a.a);
        this.a(typedArray, xmlPullParser);
        typedArray.recycle();
        g2.a = this.getChangingConfigurations();
        g2.k = true;
        this.b(resources, xmlPullParser, attributeSet, theme);
        this.d = this.a(this.d, g2.c, g2.d);
    }

    public void invalidateSelf() {
        if (this.c != null) {
            this.c.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.b(this.c);
        }
        return this.b.e;
    }

    public boolean isStateful() {
        if (this.c != null) {
            return this.c.isStateful();
        }
        return super.isStateful() || this.b != null && (this.b.d() || this.b.c != null && this.b.c.isStateful());
        {
        }
    }

    public Drawable mutate() {
        if (this.c != null) {
            this.c.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.b = new g(this.b);
            this.f = true;
        }
        return this;
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] arrn) {
        if (this.c != null) {
            return this.c.setState(arrn);
        }
        boolean bl2 = false;
        g g2 = this.b;
        boolean bl3 = bl2;
        if (g2.c != null) {
            bl3 = bl2;
            if (g2.d != null) {
                this.d = this.a(this.d, g2.c, g2.d);
                this.invalidateSelf();
                bl3 = true;
            }
        }
        bl2 = bl3;
        if (g2.d()) {
            bl2 = bl3;
            if (g2.a(arrn)) {
                this.invalidateSelf();
                bl2 = true;
            }
        }
        return bl2;
    }

    public void scheduleSelf(Runnable runnable, long l2) {
        if (this.c != null) {
            this.c.scheduleSelf(runnable, l2);
            return;
        }
        super.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        if (this.c != null) {
            this.c.setAlpha(n2);
            return;
        }
        if (this.b.b.getRootAlpha() != n2) {
            this.b.b.setRootAlpha(n2);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean bl2) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, bl2);
            return;
        }
        this.b.e = bl2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c != null) {
            this.c.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        this.invalidateSelf();
    }

    @Override
    public void setTint(int n2) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, n2);
            return;
        }
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
            return;
        }
        g g2 = this.b;
        if (g2.c != colorStateList) {
            g2.c = colorStateList;
            this.d = this.a(this.d, colorStateList, g2.d);
            this.invalidateSelf();
        }
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, mode);
            return;
        }
        g g2 = this.b;
        if (g2.d != mode) {
            g2.d = mode;
            this.d = this.a(this.d, g2.c, mode);
            this.invalidateSelf();
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (this.c != null) {
            return this.c.setVisible(bl2, bl3);
        }
        return super.setVisible(bl2, bl3);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.c != null) {
            this.c.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }

    private static class a
    extends e {
        public a() {
        }

        public a(a a2) {
            super(a2);
        }

        private void a(TypedArray object) {
            String string2 = object.getString(0);
            if (string2 != null) {
                this.n = string2;
            }
            if ((object = object.getString(1)) != null) {
                this.m = androidx.core.graphics.b.b((String)object);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!androidx.core.a.a.g.a(xmlPullParser, "pathData")) {
                return;
            }
            resources = androidx.core.a.a.g.a(resources, theme, attributeSet, androidx.k.a.a.a.d);
            this.a((TypedArray)resources);
            resources.recycle();
        }

        @Override
        public boolean a() {
            return true;
        }
    }

    private static class b
    extends e {
        androidx.core.a.a.b a;
        float b = 0.0f;
        androidx.core.a.a.b c;
        float d = 1.0f;
        int e = 0;
        float f = 1.0f;
        float g = 0.0f;
        float h = 1.0f;
        float i = 0.0f;
        Paint.Cap j = Paint.Cap.BUTT;
        Paint.Join k = Paint.Join.MITER;
        float l = 4.0f;
        private int[] p;

        public b() {
        }

        public b(b b2) {
            super(b2);
            this.p = b2.p;
            this.a = b2.a;
            this.b = b2.b;
            this.d = b2.d;
            this.c = b2.c;
            this.e = b2.e;
            this.f = b2.f;
            this.g = b2.g;
            this.h = b2.h;
            this.i = b2.i;
            this.j = b2.j;
            this.k = b2.k;
            this.l = b2.l;
        }

        private Paint.Cap a(int n2, Paint.Cap cap) {
            switch (n2) {
                default: {
                    return cap;
                }
                case 2: {
                    return Paint.Cap.SQUARE;
                }
                case 1: {
                    return Paint.Cap.ROUND;
                }
                case 0: 
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join a(int n2, Paint.Join join) {
            switch (n2) {
                default: {
                    return join;
                }
                case 2: {
                    return Paint.Join.BEVEL;
                }
                case 1: {
                    return Paint.Join.ROUND;
                }
                case 0: 
            }
            return Paint.Join.MITER;
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.p = null;
            if (!androidx.core.a.a.g.a(xmlPullParser, "pathData")) {
                return;
            }
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                this.n = string2;
            }
            if ((string2 = typedArray.getString(2)) != null) {
                this.m = androidx.core.graphics.b.b(string2);
            }
            this.c = androidx.core.a.a.g.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.f = androidx.core.a.a.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
            this.j = this.a(androidx.core.a.a.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
            this.k = this.a(androidx.core.a.a.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
            this.l = androidx.core.a.a.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
            this.a = androidx.core.a.a.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.d = androidx.core.a.a.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
            this.b = androidx.core.a.a.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
            this.h = androidx.core.a.a.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
            this.i = androidx.core.a.a.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
            this.g = androidx.core.a.a.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
            this.e = androidx.core.a.a.g.a(typedArray, xmlPullParser, "fillType", 13, this.e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            resources = androidx.core.a.a.g.a(resources, theme, attributeSet, androidx.k.a.a.a.c);
            this.a((TypedArray)resources, xmlPullParser, theme);
            resources.recycle();
        }

        @Override
        public boolean a(int[] arrn) {
            boolean bl2 = this.c.a(arrn);
            return this.a.a(arrn) | bl2;
        }

        @Override
        public boolean b() {
            return this.c.d() || this.a.d();
            {
            }
        }

        float getFillAlpha() {
            return this.f;
        }

        int getFillColor() {
            return this.c.b();
        }

        float getStrokeAlpha() {
            return this.d;
        }

        int getStrokeColor() {
            return this.a.b();
        }

        float getStrokeWidth() {
            return this.b;
        }

        float getTrimPathEnd() {
            return this.h;
        }

        float getTrimPathOffset() {
            return this.i;
        }

        float getTrimPathStart() {
            return this.g;
        }

        void setFillAlpha(float f2) {
            this.f = f2;
        }

        void setFillColor(int n2) {
            this.c.b(n2);
        }

        void setStrokeAlpha(float f2) {
            this.d = f2;
        }

        void setStrokeColor(int n2) {
            this.a.b(n2);
        }

        void setStrokeWidth(float f2) {
            this.b = f2;
        }

        void setTrimPathEnd(float f2) {
            this.h = f2;
        }

        void setTrimPathOffset(float f2) {
            this.i = f2;
        }

        void setTrimPathStart(float f2) {
            this.g = f2;
        }
    }

    private static class c
    extends d {
        final Matrix a = new Matrix();
        final ArrayList<d> b = new ArrayList();
        float c = 0.0f;
        final Matrix d = new Matrix();
        int e;
        private float f = 0.0f;
        private float g = 0.0f;
        private float h = 1.0f;
        private float i = 1.0f;
        private float j = 0.0f;
        private float k = 0.0f;
        private int[] l;
        private String m = null;

        public c() {
            super();
        }

        public c(c d2, androidx.c.a<String, Object> a2) {
            super();
            this.c = d2.c;
            this.f = d2.f;
            this.g = d2.g;
            this.h = d2.h;
            this.i = d2.i;
            this.j = d2.j;
            this.k = d2.k;
            this.l = d2.l;
            this.m = d2.m;
            this.e = d2.e;
            if (this.m != null) {
                a2.put(this.m, this);
            }
            this.d.set(d2.d);
            ArrayList<d> arrayList = d2.b;
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                block8 : {
                    block7 : {
                        block6 : {
                            d2 = arrayList.get(i2);
                            if (d2 instanceof c) {
                                this.b.add(new c((c)d2, a2));
                                continue;
                            }
                            if (!(d2 instanceof b)) break block6;
                            d2 = new b((b)d2);
                            break block7;
                        }
                        if (!(d2 instanceof a)) break block8;
                        d2 = new a((a)d2);
                    }
                    this.b.add(d2);
                    if (((e)d2).n == null) continue;
                    a2.put(((e)d2).n, d2);
                    continue;
                }
                throw new IllegalStateException("Unknown object in the tree!");
            }
        }

        private void a() {
            this.d.reset();
            this.d.postTranslate(-this.f, -this.g);
            this.d.postScale(this.h, this.i);
            this.d.postRotate(this.c, 0.0f, 0.0f);
            this.d.postTranslate(this.j + this.f, this.k + this.g);
        }

        private void a(TypedArray object, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = androidx.core.a.a.g.a(object, xmlPullParser, "rotation", 5, this.c);
            this.f = object.getFloat(1, this.f);
            this.g = object.getFloat(2, this.g);
            this.h = androidx.core.a.a.g.a(object, xmlPullParser, "scaleX", 3, this.h);
            this.i = androidx.core.a.a.g.a(object, xmlPullParser, "scaleY", 4, this.i);
            this.j = androidx.core.a.a.g.a(object, xmlPullParser, "translateX", 6, this.j);
            this.k = androidx.core.a.a.g.a(object, xmlPullParser, "translateY", 7, this.k);
            if ((object = object.getString(0)) != null) {
                this.m = object;
            }
            this.a();
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            resources = androidx.core.a.a.g.a(resources, theme, attributeSet, androidx.k.a.a.a.b);
            this.a((TypedArray)resources, xmlPullParser);
            resources.recycle();
        }

        @Override
        public boolean a(int[] arrn) {
            boolean bl2 = false;
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                bl2 |= this.b.get(i2).a(arrn);
            }
            return bl2;
        }

        @Override
        public boolean b() {
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                if (!this.b.get(i2).b()) continue;
                return true;
            }
            return false;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.d;
        }

        public float getPivotX() {
            return this.f;
        }

        public float getPivotY() {
            return this.g;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.h;
        }

        public float getScaleY() {
            return this.i;
        }

        public float getTranslateX() {
            return this.j;
        }

        public float getTranslateY() {
            return this.k;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                this.a();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                this.a();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                this.a();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                this.a();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                this.a();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.j) {
                this.j = f2;
                this.a();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.k) {
                this.k = f2;
                this.a();
            }
        }
    }

    private static abstract class d {
        private d() {
        }

        public boolean a(int[] arrn) {
            return false;
        }

        public boolean b() {
            return false;
        }
    }

    private static abstract class e
    extends d {
        protected b.b[] m = null;
        String n;
        int o;

        public e() {
        }

        public e(e e2) {
            this.n = e2.n;
            this.o = e2.o;
            this.m = androidx.core.graphics.b.a(e2.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                b.b.a(this.m, path);
            }
        }

        public boolean a() {
            return false;
        }

        public b.b[] getPathData() {
            return this.m;
        }

        public String getPathName() {
            return this.n;
        }

        public void setPathData(b.b[] arrb) {
            if (!androidx.core.graphics.b.a(this.m, arrb)) {
                this.m = androidx.core.graphics.b.a(arrb);
                return;
            }
            androidx.core.graphics.b.b(this.m, arrb);
        }
    }

    private static class f {
        private static final Matrix n = new Matrix();
        Paint a;
        Paint b;
        final c c;
        float d = 0.0f;
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        int h = 255;
        String i = null;
        Boolean j = null;
        final androidx.c.a<String, Object> k = new androidx.c.a();
        private final Path l;
        private final Path m;
        private final Matrix o = new Matrix();
        private PathMeasure p;
        private int q;

        public f() {
            this.c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public f(f f2) {
            this.c = new c(f2.c, this.k);
            this.l = new Path(f2.l);
            this.m = new Path(f2.m);
            this.d = f2.d;
            this.e = f2.e;
            this.f = f2.f;
            this.g = f2.g;
            this.q = f2.q;
            this.h = f2.h;
            this.i = f2.i;
            if (f2.i != null) {
                this.k.put(f2.i, this);
            }
            this.j = f2.j;
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return f2 * f5 - f3 * f4;
        }

        private float a(Matrix matrix) {
            float[] arrf;
            float[] arrf2 = arrf = new float[4];
            arrf2[0] = 0.0f;
            arrf2[1] = 1.0f;
            arrf2[2] = 1.0f;
            arrf2[3] = 0.0f;
            matrix.mapVectors(arrf);
            float f2 = (float)Math.hypot(arrf[0], arrf[1]);
            float f3 = (float)Math.hypot(arrf[2], arrf[3]);
            float f4 = f.a(arrf[0], arrf[1], arrf[2], arrf[3]);
            f3 = Math.max(f2, f3);
            f2 = 0.0f;
            if (f3 > 0.0f) {
                f2 = Math.abs(f4) / f3;
            }
            return f2;
        }

        private void a(c c2, Matrix object, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
            c2.a.set(object);
            c2.a.preConcat(c2.d);
            canvas.save();
            for (int i2 = 0; i2 < c2.b.size(); ++i2) {
                object = c2.b.get(i2);
                if (object instanceof c) {
                    this.a((c)object, c2.a, canvas, n2, n3, colorFilter);
                    continue;
                }
                if (!(object instanceof e)) continue;
                this.a(c2, (e)object, canvas, n2, n3, colorFilter);
            }
            canvas.restore();
        }

        private void a(c object, e e2, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
            androidx.core.a.a.b b2;
            float f2 = (float)n2 / this.f;
            float f3 = (float)n3 / this.g;
            float f4 = Math.min(f2, f3);
            object = ((c)object).a;
            this.o.set((Matrix)object);
            this.o.postScale(f2, f3);
            f2 = this.a((Matrix)object);
            if (f2 == 0.0f) {
                return;
            }
            e2.a(this.l);
            object = this.l;
            this.m.reset();
            if (e2.a()) {
                this.m.addPath((Path)object, this.o);
                canvas.clipPath(this.m);
                return;
            }
            e2 = (b)e2;
            if (((b)e2).g != 0.0f || ((b)e2).h != 1.0f) {
                float f5 = ((b)e2).g;
                float f6 = ((b)e2).i;
                float f7 = ((b)e2).h;
                float f8 = ((b)e2).i;
                if (this.p == null) {
                    this.p = new PathMeasure();
                }
                this.p.setPath(this.l, false);
                f3 = this.p.getLength();
                f5 = (f5 + f6) % 1.0f * f3;
                f7 = (f7 + f8) % 1.0f * f3;
                object.reset();
                if (f5 > f7) {
                    this.p.getSegment(f5, f3, (Path)object, true);
                    this.p.getSegment(0.0f, f7, (Path)object, true);
                } else {
                    this.p.getSegment(f5, f7, (Path)object, true);
                }
                object.rLineTo(0.0f, 0.0f);
            }
            this.m.addPath((Path)object, this.o);
            if (((b)e2).c.e()) {
                object = ((b)e2).c;
                if (this.b == null) {
                    this.b = new Paint(1);
                    this.b.setStyle(Paint.Style.FILL);
                }
                b2 = this.b;
                if (((androidx.core.a.a.b)object).c()) {
                    object = ((androidx.core.a.a.b)object).a();
                    object.setLocalMatrix(this.o);
                    b2.setShader((Shader)object);
                    b2.setAlpha(Math.round(((b)e2).f * 255.0f));
                } else {
                    b2.setShader(null);
                    b2.setAlpha(255);
                    b2.setColor(i.a(((androidx.core.a.a.b)object).b(), ((b)e2).f));
                }
                b2.setColorFilter(colorFilter);
                Path path = this.m;
                object = ((b)e2).e == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                path.setFillType((Path.FillType)object);
                canvas.drawPath(this.m, (Paint)b2);
            }
            if (((b)e2).a.e()) {
                b2 = ((b)e2).a;
                if (this.a == null) {
                    this.a = new Paint(1);
                    this.a.setStyle(Paint.Style.STROKE);
                }
                object = this.a;
                if (((b)e2).k != null) {
                    object.setStrokeJoin(((b)e2).k);
                }
                if (((b)e2).j != null) {
                    object.setStrokeCap(((b)e2).j);
                }
                object.setStrokeMiter(((b)e2).l);
                if (b2.c()) {
                    b2 = b2.a();
                    b2.setLocalMatrix(this.o);
                    object.setShader((Shader)b2);
                    object.setAlpha(Math.round(((b)e2).d * 255.0f));
                } else {
                    object.setShader(null);
                    object.setAlpha(255);
                    object.setColor(i.a(b2.b(), ((b)e2).d));
                }
                object.setColorFilter(colorFilter);
                object.setStrokeWidth(((b)e2).b * (f4 * f2));
                canvas.drawPath(this.m, (Paint)object);
            }
        }

        public void a(Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
            this.a(this.c, n, canvas, n2, n3, colorFilter);
        }

        public boolean a() {
            if (this.j == null) {
                this.j = this.c.b();
            }
            return this.j;
        }

        public boolean a(int[] arrn) {
            return this.c.a(arrn);
        }

        public float getAlpha() {
            return (float)this.getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public void setAlpha(float f2) {
            this.setRootAlpha((int)(f2 * 255.0f));
        }

        public void setRootAlpha(int n2) {
            this.h = n2;
        }
    }

    private static class g
    extends Drawable.ConstantState {
        int a;
        f b;
        ColorStateList c = null;
        PorterDuff.Mode d = i.a;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g() {
            this.b = new f();
        }

        public g(g g2) {
            if (g2 != null) {
                this.a = g2.a;
                this.b = new f(g2.b);
                if (g2.b.b != null) {
                    this.b.b = new Paint(g2.b.b);
                }
                if (g2.b.a != null) {
                    this.b.a = new Paint(g2.b.a);
                }
                this.c = g2.c;
                this.d = g2.d;
                this.e = g2.e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!this.a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int n2, int n3) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            this.b.a(canvas, n2, n3, null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            colorFilter = this.a(colorFilter);
            canvas.drawBitmap(this.f, null, rect, (Paint)colorFilter);
        }

        public boolean a() {
            return this.b.getRootAlpha() < 255;
        }

        public boolean a(int[] arrn) {
            boolean bl2 = this.b.a(arrn);
            this.k |= bl2;
            return bl2;
        }

        public void b(int n2, int n3) {
            if (this.f == null || !this.c(n2, n3)) {
                this.f = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public boolean c(int n2, int n3) {
            return n2 == this.f.getWidth() && n3 == this.f.getHeight();
        }

        public boolean d() {
            return this.b.a();
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    private static class h
    extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public h(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            i i2 = new i();
            i2.c = (VectorDrawable)this.a.newDrawable();
            return i2;
        }

        public Drawable newDrawable(Resources resources) {
            i i2 = new i();
            i2.c = (VectorDrawable)this.a.newDrawable(resources);
            return i2;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i i2 = new i();
            i2.c = (VectorDrawable)this.a.newDrawable(resources, theme);
            return i2;
        }
    }

}

