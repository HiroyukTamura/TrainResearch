/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.a;
import androidx.core.a.a.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    private static int a(int n2, float f2) {
        return n2 & 16777215 | Math.round((float)Color.alpha((int)n2) * f2) << 24;
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int n2;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n2 = xmlPullParser.next()) != 2 && n2 != 1) {
        }
        if (n2 == 2) {
            return a.a(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList a(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String string2 = xmlPullParser.getName();
        if (string2.equals("selector")) {
            return a.b((Resources)object, xmlPullParser, attributeSet, theme);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": invalid color state list tag ");
        ((StringBuilder)object).append(string2);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static ColorStateList b(Resources arrn, XmlPullParser arrarrn, AttributeSet attributeSet, Resources.Theme theme) {
        int n2 = arrarrn.getDepth() + 1;
        int[][] arrarrn2 = new int[20][];
        int[] arrn2 = new int[arrarrn2.length];
        int n3 = 0;
        do {
            float f2;
            int n4;
            int n5;
            int[] arrn3;
            int n6;
            int n7;
            block13 : {
                block9 : {
                    block12 : {
                        block11 : {
                            block10 : {
                                if ((n7 = arrarrn.next()) == 1 || (n4 = arrarrn.getDepth()) < n2 && n7 == 3) break block9;
                                if (n7 != 2 || n4 > n2 || !arrarrn.getName().equals("item")) continue;
                                arrn3 = a.a((Resources)arrn, theme, attributeSet, a.c.ColorStateListItem);
                                n6 = arrn3.getColor(a.c.ColorStateListItem_android_color, -65281);
                                f2 = 1.0f;
                                if (!arrn3.hasValue(a.c.ColorStateListItem_android_alpha)) break block10;
                                n7 = a.c.ColorStateListItem_android_alpha;
                                break block11;
                            }
                            if (!arrn3.hasValue(a.c.ColorStateListItem_alpha)) break block12;
                            n7 = a.c.ColorStateListItem_alpha;
                        }
                        f2 = arrn3.getFloat(n7, 1.0f);
                    }
                    arrn3.recycle();
                    n5 = attributeSet.getAttributeCount();
                    arrn3 = new int[n5];
                    n4 = 0;
                    break block13;
                }
                arrn = new int[n3];
                arrarrn = new int[n3][];
                System.arraycopy(arrn2, 0, arrn, 0, n3);
                System.arraycopy(arrarrn2, 0, arrarrn, 0, n3);
                return new ColorStateList((int[][])arrarrn, arrn);
            }
            for (n7 = 0; n7 < n5; ++n7) {
                int n8 = attributeSet.getAttributeNameResource(n7);
                int n9 = n4;
                if (n8 != 16843173) {
                    n9 = n4;
                    if (n8 != 16843551) {
                        n9 = n4;
                        if (n8 != a.a.alpha) {
                            n9 = attributeSet.getAttributeBooleanValue(n7, false) ? n8 : -n8;
                            arrn3[n4] = n9;
                            n9 = n4 + 1;
                        }
                    }
                }
                n4 = n9;
            }
            arrn3 = StateSet.trimStateSet((int[])arrn3, (int)n4);
            n7 = a.a(n6, f2);
            if (n3 != 0) {
                n4 = arrn3.length;
            }
            arrn2 = e.a(arrn2, n3, n7);
            arrarrn2 = e.a(arrarrn2, n3, arrn3);
            ++n3;
        } while (true);
    }
}

