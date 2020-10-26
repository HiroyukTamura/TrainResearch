/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.Shader
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.a.a.a;
import androidx.core.a.a.d;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b {
    private final Shader a;
    private final ColorStateList b;
    private int c;

    private b(Shader shader, ColorStateList colorStateList, int n2) {
        this.a = shader;
        this.b = colorStateList;
        this.c = n2;
    }

    static b a(int n2) {
        return new b(null, null, n2);
    }

    static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static b a(Resources object, int n2, Resources.Theme theme) {
        try {
            object = b.b(object, n2, theme);
            return object;
        }
        catch (Exception exception) {
            Log.e((String)"ComplexColorCompat", (String)"Failed to inflate ComplexColor.", (Throwable)exception);
            return null;
        }
    }

    static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    private static b b(Resources object, int n2, Resources.Theme theme) {
        block7 : {
            XmlResourceParser xmlResourceParser;
            String string2;
            AttributeSet attributeSet;
            block10 : {
                block9 : {
                    block8 : {
                        int n3;
                        xmlResourceParser = object.getXml(n2);
                        attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                        do {
                            n3 = xmlResourceParser.next();
                            n2 = 1;
                        } while (n3 != 2 && n3 != 1);
                        if (n3 != 2) break block7;
                        string2 = xmlResourceParser.getName();
                        n3 = string2.hashCode();
                        if (n3 == 89650992) break block8;
                        if (n3 != 1191572447 || !string2.equals("selector")) break block9;
                        n2 = 0;
                        break block10;
                    }
                    if (string2.equals("gradient")) break block10;
                }
                n2 = -1;
            }
            switch (n2) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(xmlResourceParser.getPositionDescription());
                    ((StringBuilder)object).append(": unsupported complex color tag ");
                    ((StringBuilder)object).append(string2);
                    throw new XmlPullParserException(((StringBuilder)object).toString());
                }
                case 1: {
                    return b.a(d.a((Resources)object, (XmlPullParser)xmlResourceParser, attributeSet, theme));
                }
                case 0: 
            }
            return b.a(a.a((Resources)object, (XmlPullParser)xmlResourceParser, attributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    public Shader a() {
        return this.a;
    }

    public boolean a(int[] arrn) {
        int n2;
        if (this.d() && (n2 = this.b.getColorForState(arrn, this.b.getDefaultColor())) != this.c) {
            this.c = n2;
            return true;
        }
        return false;
    }

    public int b() {
        return this.c;
    }

    public void b(int n2) {
        this.c = n2;
    }

    public boolean c() {
        return this.a != null;
    }

    public boolean d() {
        return this.a == null && this.b != null && this.b.isStateful();
    }

    public boolean e() {
        return this.c() || this.c != 0;
        {
        }
    }
}

