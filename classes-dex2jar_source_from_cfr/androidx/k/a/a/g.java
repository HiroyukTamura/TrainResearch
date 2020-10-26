/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.util.AttributeSet
 *  android.view.InflateException
 *  android.view.animation.Interpolator
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.k.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.graphics.b;
import androidx.k.a.a.a;
import org.xmlpull.v1.XmlPullParser;

public class g
implements Interpolator {
    private float[] a;
    private float[] b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        resources = androidx.core.a.a.g.a(resources, theme, attributeSet, a.l);
        this.a((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    private void a(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        this.a(path);
    }

    private void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        this.a(path);
    }

    private void a(TypedArray object, XmlPullParser object2) {
        if (androidx.core.a.a.g.a((XmlPullParser)object2, "pathData")) {
            object = androidx.core.a.a.g.a(object, (XmlPullParser)object2, "pathData", 4);
            object2 = b.a((String)object);
            if (object2 != null) {
                this.a((Path)object2);
                return;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("The path is null, which is created from ");
            ((StringBuilder)object2).append((String)object);
            throw new InflateException(((StringBuilder)object2).toString());
        }
        if (androidx.core.a.a.g.a((XmlPullParser)object2, "controlX1")) {
            if (androidx.core.a.a.g.a((XmlPullParser)object2, "controlY1")) {
                float f2 = androidx.core.a.a.g.a(object, (XmlPullParser)object2, "controlX1", 0, 0.0f);
                float f3 = androidx.core.a.a.g.a(object, (XmlPullParser)object2, "controlY1", 1, 0.0f);
                boolean bl2 = androidx.core.a.a.g.a((XmlPullParser)object2, "controlX2");
                if (bl2 == androidx.core.a.a.g.a((XmlPullParser)object2, "controlY2")) {
                    if (!bl2) {
                        this.a(f2, f3);
                        return;
                    }
                    this.a(f2, f3, androidx.core.a.a.g.a(object, (XmlPullParser)object2, "controlX2", 2, 0.0f), androidx.core.a.a.g.a(object, (XmlPullParser)object2, "controlY2", 3, 0.0f));
                    return;
                }
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }

    private void a(Path object) {
        int n2 = 0;
        float f2 = (object = new PathMeasure((Path)object, false)).getLength();
        int n3 = Math.min(3000, (int)(f2 / 0.002f) + 1);
        if (n3 > 0) {
            int n4;
            this.a = new float[n3];
            this.b = new float[n3];
            float[] arrf = new float[2];
            for (n4 = 0; n4 < n3; ++n4) {
                object.getPosTan((float)n4 * f2 / (float)(n3 - 1), arrf, null);
                this.a[n4] = arrf[0];
                this.b[n4] = arrf[1];
            }
            if (!((double)Math.abs(this.a[0]) > 1.0E-5 || (double)Math.abs(this.b[0]) > 1.0E-5 || (double)Math.abs((arrf = this.a)[n4 = n3 - 1] - 1.0f) > 1.0E-5 || (double)Math.abs(this.b[n4] - 1.0f) > 1.0E-5)) {
                n4 = 0;
                f2 = 0.0f;
                while (n2 < n3) {
                    float f3 = this.a[n4];
                    if (!(f3 < f2)) {
                        this.a[n2] = f3;
                        ++n2;
                        f2 = f3;
                        ++n4;
                        continue;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("The Path cannot loop back on itself, x :");
                    ((StringBuilder)object).append(f3);
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                if (!object.nextContour()) {
                    return;
                }
                throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("The Path must start at (0,0) and end at (1,1) start: ");
            ((StringBuilder)object).append(this.a[0]);
            ((StringBuilder)object).append(",");
            ((StringBuilder)object).append(this.b[0]);
            ((StringBuilder)object).append(" end:");
            arrf = this.a;
            n4 = n3 - 1;
            ((StringBuilder)object).append(arrf[n4]);
            ((StringBuilder)object).append(",");
            ((StringBuilder)object).append(this.b[n4]);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("The Path has a invalid length ");
        ((StringBuilder)object).append(f2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int n2 = 0;
        int n3 = this.a.length - 1;
        while (n3 - n2 > 1) {
            int n4 = (n2 + n3) / 2;
            if (f2 < this.a[n4]) {
                n3 = n4;
                continue;
            }
            n2 = n4;
        }
        float f3 = this.a[n3] - this.a[n2];
        if (f3 == 0.0f) {
            return this.b[n2];
        }
        f2 = (f2 - this.a[n2]) / f3;
        f3 = this.b[n2];
        return f3 + f2 * (this.b[n3] - f3);
    }
}

