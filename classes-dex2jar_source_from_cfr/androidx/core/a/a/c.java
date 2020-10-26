/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Base64
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    private static int a(TypedArray typedArray, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(n2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(n2, typedValue);
        return typedValue.type;
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
        int n2;
        while ((n2 = xmlPullParser.next()) != 2 && n2 != 1) {
        }
        if (n2 == 2) {
            return c.b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static List<List<byte[]>> a(Resources var0, int var1_2) {
        block10 : {
            block9 : {
                if (var1_3 == 0) {
                    return Collections.emptyList();
                }
                var3_4 = var0 /* !! */ .obtainTypedArray(var1_3);
                try {
                    if (var3_4.length() != 0) break block9;
                    var0_1 = Collections.emptyList();
                }
                catch (Throwable var0_2) {
                    var3_4.recycle();
                    throw var0_2;
                }
                var3_4.recycle();
                return var0_1;
            }
            var4_5 = new ArrayList<List<byte[]>>();
            if (c.a(var3_4, 0) == 1) {
                var1_3 = 0;
                break block10;
            }
            var4_5.add(c.a(var0 /* !! */ .getStringArray(var1_3)));
            ** GOTO lbl-1000
        }
        do {
            if (var1_3 < var3_4.length()) {
                var2_6 = var3_4.getResourceId(var1_3, 0);
                if (var2_6 != 0) {
                    var4_5.add(c.a(var0 /* !! */ .getStringArray(var2_6)));
                }
            } else lbl-1000: // 2 sources:
            {
                var3_4.recycle();
                return var4_5;
            }
            ++var1_3;
        } while (true);
    }

    private static List<byte[]> a(String[] arrstring) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(Base64.decode((String)arrstring[i2], (int)0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) {
        int n2 = 1;
        block4 : while (n2 > 0) {
            switch (xmlPullParser.next()) {
                default: {
                    continue block4;
                }
                case 3: {
                    --n2;
                    continue block4;
                }
                case 2: 
            }
            ++n2;
        }
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c.c(xmlPullParser, resources);
        }
        c.a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) {
        Object object = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), a.c.FontFamily);
        String string2 = object.getString(a.c.FontFamily_fontProviderAuthority);
        String string3 = object.getString(a.c.FontFamily_fontProviderPackage);
        String string4 = object.getString(a.c.FontFamily_fontProviderQuery);
        int n2 = object.getResourceId(a.c.FontFamily_fontProviderCerts, 0);
        int n3 = object.getInteger(a.c.FontFamily_fontProviderFetchStrategy, 1);
        int n4 = object.getInteger(a.c.FontFamily_fontProviderFetchTimeout, 500);
        object.recycle();
        if (string2 != null && string3 != null && string4 != null) {
            while (xmlPullParser.next() != 3) {
                c.a(xmlPullParser);
            }
            return new d(new androidx.core.e.a(string2, string3, string4, c.a(resources, n2)), n3, n4);
        }
        object = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() != 2) continue;
            if (xmlPullParser.getName().equals("font")) {
                object.add(c.d(xmlPullParser, resources));
                continue;
            }
            c.a(xmlPullParser);
        }
        if (object.isEmpty()) {
            return null;
        }
        return new b(object.toArray(new c[object.size()]));
    }

    private static c d(XmlPullParser xmlPullParser, Resources resources) {
        int n2 = (resources = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), a.c.FontFamilyFont)).hasValue(a.c.FontFamilyFont_fontWeight) ? a.c.FontFamilyFont_fontWeight : a.c.FontFamilyFont_android_fontWeight;
        int n3 = resources.getInt(n2, 400);
        n2 = resources.hasValue(a.c.FontFamilyFont_fontStyle) ? a.c.FontFamilyFont_fontStyle : a.c.FontFamilyFont_android_fontStyle;
        boolean bl2 = 1 == resources.getInt(n2, 0);
        n2 = resources.hasValue(a.c.FontFamilyFont_ttcIndex) ? a.c.FontFamilyFont_ttcIndex : a.c.FontFamilyFont_android_ttcIndex;
        int n4 = resources.hasValue(a.c.FontFamilyFont_fontVariationSettings) ? a.c.FontFamilyFont_fontVariationSettings : a.c.FontFamilyFont_android_fontVariationSettings;
        String string2 = resources.getString(n4);
        n4 = resources.getInt(n2, 0);
        n2 = resources.hasValue(a.c.FontFamilyFont_font) ? a.c.FontFamilyFont_font : a.c.FontFamilyFont_android_font;
        int n5 = resources.getResourceId(n2, 0);
        String string3 = resources.getString(n2);
        resources.recycle();
        while (xmlPullParser.next() != 3) {
            c.a(xmlPullParser);
        }
        return new c(string3, n3, bl2, string2, n4, n5);
    }

    public static interface a {
    }

    public static final class b
    implements a {
        private final c[] a;

        public b(c[] arrc) {
            this.a = arrc;
        }

        public c[] a() {
            return this.a;
        }
    }

    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private int f;

        public c(String string2, int n2, boolean bl2, String string3, int n3, int n4) {
            this.a = string2;
            this.b = n2;
            this.c = bl2;
            this.d = string3;
            this.e = n3;
            this.f = n4;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }
    }

    public static final class d
    implements a {
        private final androidx.core.e.a a;
        private final int b;
        private final int c;

        public d(androidx.core.e.a a2, int n2, int n3) {
            this.a = a2;
            this.c = n2;
            this.b = n3;
        }

        public androidx.core.e.a a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

}

