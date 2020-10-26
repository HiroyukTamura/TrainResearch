/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.core.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.a.a.b;
import org.xmlpull.v1.XmlPullParser;

public class g {
    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, float f2) {
        if (!g.a(xmlPullParser, string2)) {
            return f2;
        }
        return typedArray.getFloat(n2, f2);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, int n3) {
        if (!g.a(xmlPullParser, string2)) {
            return n3;
        }
        return typedArray.getInt(n2, n3);
    }

    public static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }

    public static b a(TypedArray object, XmlPullParser xmlPullParser, Resources.Theme theme, String string2, int n2, int n3) {
        if (g.a(xmlPullParser, string2)) {
            xmlPullParser = new TypedValue();
            object.getValue(n2, (TypedValue)xmlPullParser);
            if (xmlPullParser.type >= 28 && xmlPullParser.type <= 31) {
                return b.a(xmlPullParser.data);
            }
            if ((object = b.a(object.getResources(), object.getResourceId(n2, 0), theme)) != null) {
                return object;
            }
        }
        return b.a(n3);
    }

    public static String a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2) {
        if (!g.a(xmlPullParser, string2)) {
            return null;
        }
        return typedArray.getString(n2);
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, boolean bl2) {
        if (!g.a(xmlPullParser, string2)) {
            return bl2;
        }
        return typedArray.getBoolean(n2, bl2);
    }

    public static boolean a(XmlPullParser xmlPullParser, String string2) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", string2) != null;
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, int n3) {
        if (!g.a(xmlPullParser, string2)) {
            return n3;
        }
        return typedArray.getColor(n2, n3);
    }

    public static TypedValue b(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2) {
        if (!g.a(xmlPullParser, string2)) {
            return null;
        }
        return typedArray.peekValue(n2);
    }

    public static int c(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, int n3) {
        if (!g.a(xmlPullParser, string2)) {
            return n3;
        }
        return typedArray.getResourceId(n2, n3);
    }
}

