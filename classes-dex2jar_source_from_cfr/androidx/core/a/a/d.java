/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.LinearGradient
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.a;
import androidx.core.a.a.g;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d {
    private static Shader.TileMode a(int n2) {
        switch (n2) {
            default: {
                return Shader.TileMode.CLAMP;
            }
            case 2: {
                return Shader.TileMode.MIRROR;
            }
            case 1: 
        }
        return Shader.TileMode.REPEAT;
    }

    static Shader a(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String string2 = xmlPullParser.getName();
        if (string2.equals("gradient")) {
            string2 = g.a((Resources)object, theme, attributeSet, a.c.GradientColor);
            float f2 = g.a((TypedArray)string2, xmlPullParser, "startX", a.c.GradientColor_android_startX, 0.0f);
            float f3 = g.a((TypedArray)string2, xmlPullParser, "startY", a.c.GradientColor_android_startY, 0.0f);
            float f4 = g.a((TypedArray)string2, xmlPullParser, "endX", a.c.GradientColor_android_endX, 0.0f);
            float f5 = g.a((TypedArray)string2, xmlPullParser, "endY", a.c.GradientColor_android_endY, 0.0f);
            float f6 = g.a((TypedArray)string2, xmlPullParser, "centerX", a.c.GradientColor_android_centerX, 0.0f);
            float f7 = g.a((TypedArray)string2, xmlPullParser, "centerY", a.c.GradientColor_android_centerY, 0.0f);
            int n2 = g.a((TypedArray)string2, xmlPullParser, "type", a.c.GradientColor_android_type, 0);
            int n3 = g.b((TypedArray)string2, xmlPullParser, "startColor", a.c.GradientColor_android_startColor, 0);
            boolean bl2 = g.a(xmlPullParser, "centerColor");
            int n4 = g.b((TypedArray)string2, xmlPullParser, "centerColor", a.c.GradientColor_android_centerColor, 0);
            int n5 = g.b((TypedArray)string2, xmlPullParser, "endColor", a.c.GradientColor_android_endColor, 0);
            int n6 = g.a((TypedArray)string2, xmlPullParser, "tileMode", a.c.GradientColor_android_tileMode, 0);
            float f8 = g.a((TypedArray)string2, xmlPullParser, "gradientRadius", a.c.GradientColor_android_gradientRadius, 0.0f);
            string2.recycle();
            object = d.a(d.b((Resources)object, xmlPullParser, attributeSet, theme), n3, n5, bl2, n4);
            switch (n2) {
                default: {
                    return new LinearGradient(f2, f3, f4, f5, ((a)object).a, ((a)object).b, d.a(n6));
                }
                case 2: {
                    return new SweepGradient(f6, f7, ((a)object).a, ((a)object).b);
                }
                case 1: 
            }
            if (!(f8 <= 0.0f)) {
                return new RadialGradient(f6, f7, f8, ((a)object).a, ((a)object).b, d.a(n6));
            }
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": invalid gradient color tag ");
        ((StringBuilder)object).append(string2);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private static a a(a a2, int n2, int n3, boolean bl2, int n4) {
        if (a2 != null) {
            return a2;
        }
        if (bl2) {
            return new a(n2, n4, n3);
        }
        return new a(n2, n3);
    }

    private static a b(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth() + 1;
        ArrayList<Float> arrayList = new ArrayList<Float>(20);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(20);
        while ((n2 = xmlPullParser.next()) != 1 && ((n3 = xmlPullParser.getDepth()) >= n4 || n2 != 3)) {
            if (n2 != 2 || n3 > n4 || !xmlPullParser.getName().equals("item")) continue;
            TypedArray typedArray = g.a((Resources)object, theme, attributeSet, a.c.GradientColorItem);
            boolean bl2 = typedArray.hasValue(a.c.GradientColorItem_android_color);
            boolean bl3 = typedArray.hasValue(a.c.GradientColorItem_android_offset);
            if (bl2 && bl3) {
                n2 = typedArray.getColor(a.c.GradientColorItem_android_color, 0);
                float f2 = typedArray.getFloat(a.c.GradientColorItem_android_offset, 0.0f);
                typedArray.recycle();
                arrayList2.add(n2);
                arrayList.add(Float.valueOf(f2));
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
            ((StringBuilder)object).append(": <item> tag requires a 'color' attribute and a 'offset' ");
            ((StringBuilder)object).append("attribute!");
            throw new XmlPullParserException(((StringBuilder)object).toString());
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    static final class a {
        final int[] a;
        final float[] b;

        a(int n2, int n3) {
            this.a = new int[]{n2, n3};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int n2, int n3, int n4) {
            this.a = new int[]{n2, n3, n4};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int n2 = list.size();
            this.a = new int[n2];
            this.b = new float[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.a[i2] = list.get(i2);
                this.b[i2] = list2.get(i2).floatValue();
            }
        }
    }

}

