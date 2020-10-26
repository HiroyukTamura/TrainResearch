/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.a;
import androidx.appcompat.b.a.b;
import androidx.core.a.a.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class d
extends b {
    private a a;
    private boolean b;

    d() {
        this(null, null);
    }

    d(a a2) {
        if (a2 != null) {
            this.a(a2);
        }
    }

    d(a a2, Resources resources) {
        this.a(new a(a2, this, resources));
        this.onStateChange(this.getState());
    }

    private void a(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        a a2 = this.a;
        int n4 = xmlPullParser.getDepth() + 1;
        while ((n3 = xmlPullParser.next()) != 1 && ((n2 = xmlPullParser.getDepth()) >= n4 || n3 != 3)) {
            if (n3 != 2 || n2 > n4 || !xmlPullParser.getName().equals("item")) continue;
            TypedArray typedArray = g.a(resources, theme, attributeSet, a.j.StateListDrawableItem);
            Drawable drawable2 = null;
            n3 = typedArray.getResourceId(a.j.StateListDrawableItem_android_drawable, -1);
            if (n3 > 0) {
                drawable2 = androidx.appcompat.a.a.a.b((Context)object, n3);
            }
            typedArray.recycle();
            int[] arrn = this.a(attributeSet);
            typedArray = drawable2;
            if (drawable2 == null) {
                while ((n3 = xmlPullParser.next()) == 4) {
                }
                if (n3 == 2) {
                    typedArray = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet);
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
                    ((StringBuilder)object).append(": <item> tag requires a 'drawable' attribute or ");
                    ((StringBuilder)object).append("child tag defining a drawable");
                    throw new XmlPullParserException(((StringBuilder)object).toString());
                }
            }
            a2.a(arrn, (Drawable)typedArray);
        }
    }

    private void a(TypedArray typedArray) {
        a a2 = this.a;
        if (Build.VERSION.SDK_INT >= 21) {
            a2.f |= typedArray.getChangingConfigurations();
        }
        a2.k = typedArray.getBoolean(a.j.StateListDrawable_android_variablePadding, a2.k);
        a2.n = typedArray.getBoolean(a.j.StateListDrawable_android_constantSize, a2.n);
        a2.C = typedArray.getInt(a.j.StateListDrawable_android_enterFadeDuration, a2.C);
        a2.D = typedArray.getInt(a.j.StateListDrawable_android_exitFadeDuration, a2.D);
        a2.z = typedArray.getBoolean(a.j.StateListDrawable_android_dither, a2.z);
    }

    @Override
    protected void a(b.b b2) {
        super.a(b2);
        if (b2 instanceof a) {
            this.a = (a)b2;
        }
    }

    int[] a(AttributeSet attributeSet) {
        int n2 = attributeSet.getAttributeCount();
        int[] arrn = new int[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = attributeSet.getAttributeNameResource(i2);
            int n5 = n3;
            if (n4 != 0) {
                n5 = n3;
                if (n4 != 16842960) {
                    n5 = n3;
                    if (n4 != 16843161) {
                        n5 = attributeSet.getAttributeBooleanValue(i2, false) ? n4 : -n4;
                        arrn[n3] = n5;
                        n5 = n3 + 1;
                    }
                }
            }
            n3 = n5;
        }
        return StateSet.trimStateSet((int[])arrn, (int)n3);
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.onStateChange(this.getState());
    }

    a b() {
        return new a(this.a, this, null);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray = g.a(resources, theme, attributeSet, a.j.StateListDrawable);
        this.setVisible(typedArray.getBoolean(a.j.StateListDrawable_android_visible, true), true);
        this.a(typedArray);
        this.a(resources);
        typedArray.recycle();
        this.a(context, resources, xmlPullParser, attributeSet, theme);
        this.onStateChange(this.getState());
    }

    @Override
    /* synthetic */ b.b c() {
        return this.b();
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public Drawable mutate() {
        if (!this.b && super.mutate() == this) {
            this.a.a();
            this.b = true;
        }
        return this;
    }

    @Override
    protected boolean onStateChange(int[] arrn) {
        int n2;
        boolean bl2 = super.onStateChange(arrn);
        int n3 = n2 = this.a.b(arrn);
        if (n2 < 0) {
            n3 = this.a.b(StateSet.WILD_CARD);
        }
        return this.a(n3) || bl2;
        {
        }
    }

    static class a
    extends b.b {
        int[][] L;

        /*
         * Enabled aggressive block sorting
         */
        a(a object, d d2, Resources resources) {
            super((b.b)((Object)object), d2, resources);
            object = object != null ? object.L : new int[this.c()][];
            this.L = object;
        }

        int a(int[] arrn, Drawable drawable2) {
            int n2 = this.a(drawable2);
            this.L[n2] = arrn;
            return n2;
        }

        @Override
        void a() {
            int[][] arrarrn = new int[this.L.length][];
            for (int i2 = this.L.length - 1; i2 >= 0; --i2) {
                int[] arrn = this.L[i2] != null ? (int[])this.L[i2].clone() : null;
                arrarrn[i2] = arrn;
            }
            this.L = arrarrn;
        }

        int b(int[] arrn) {
            int[][] arrn2 = this.L;
            int n2 = this.d();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!StateSet.stateSetMatches((int[])arrn2[i2], (int[])arrn)) continue;
                return i2;
            }
            return -1;
        }

        @Override
        public void e(int n2, int n3) {
            super.e(n2, n3);
            int[][] arrarrn = new int[n3][];
            System.arraycopy(this.L, 0, arrarrn, 0, n2);
            this.L = arrarrn;
        }

        public Drawable newDrawable() {
            return new d(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

}

