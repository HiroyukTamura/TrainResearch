/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.a;
import androidx.appcompat.b.a.b;
import androidx.appcompat.b.a.d;
import androidx.c.h;
import androidx.core.a.a.g;
import androidx.k.a.a.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
extends androidx.appcompat.b.a.d {
    private static final String a = "a";
    private b b;
    private f c;
    private int d = -1;
    private int e = -1;
    private boolean f;

    public a() {
        this(null, null);
    }

    a(b b2, Resources resources) {
        super(null);
        this.a(new b(b2, this, resources));
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    public static a a(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object2 = xmlPullParser.getName();
        if (((String)object2).equals("animated-selector")) {
            object2 = new a();
            ((a)((Object)object2)).b((Context)object, resources, xmlPullParser, attributeSet, theme);
            return object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": invalid animated-selector tag ");
        ((StringBuilder)object).append((String)object2);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private void a(TypedArray typedArray) {
        b b2 = this.b;
        if (Build.VERSION.SDK_INT >= 21) {
            b2.f |= typedArray.getChangingConfigurations();
        }
        b2.a(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_variablePadding, b2.k));
        b2.b(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_constantSize, b2.n));
        b2.c(typedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, b2.C));
        b2.d(typedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, b2.D));
        this.setDither(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_dither, b2.z));
    }

    private boolean b(int n2) {
        block9 : {
            int n3;
            Object object;
            block11 : {
                Drawable drawable2;
                block12 : {
                    block10 : {
                        object = this.c;
                        if (object != null) {
                            if (n2 == this.d) {
                                return true;
                            }
                            if (n2 == this.e && ((f)object).c()) {
                                ((f)object).d();
                                this.d = this.e;
                                this.e = n2;
                                return true;
                            }
                            n3 = this.d;
                            ((f)object).b();
                        } else {
                            n3 = this.d();
                        }
                        this.c = null;
                        this.e = -1;
                        this.d = -1;
                        object = this.b;
                        int n4 = ((b)((Object)object)).a(n3);
                        int n5 = ((b)((Object)object)).a(n2);
                        if (n5 == 0) break block9;
                        if (n4 == 0) {
                            return false;
                        }
                        int n6 = ((b)((Object)object)).a(n4, n5);
                        if (n6 < 0) {
                            return false;
                        }
                        boolean bl2 = ((b)((Object)object)).c(n4, n5);
                        this.a(n6);
                        drawable2 = this.getCurrent();
                        if (!(drawable2 instanceof AnimationDrawable)) break block10;
                        boolean bl3 = ((b)((Object)object)).b(n4, n5);
                        object = new d((AnimationDrawable)drawable2, bl3, bl2);
                        break block11;
                    }
                    if (!(drawable2 instanceof androidx.k.a.a.c)) break block12;
                    object = new c((androidx.k.a.a.c)drawable2);
                    break block11;
                }
                if (!(drawable2 instanceof Animatable)) break block9;
                object = new a((Animatable)drawable2);
            }
            ((f)object).a();
            this.c = object;
            this.e = n3;
            this.d = n2;
            return true;
        }
        return false;
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth() + 1;
        while ((n2 = xmlPullParser.next()) != 1 && ((n3 = xmlPullParser.getDepth()) >= n4 || n2 != 3)) {
            if (n2 != 2 || n3 > n4) continue;
            if (xmlPullParser.getName().equals("item")) {
                this.e(context, resources, xmlPullParser, attributeSet, theme);
                continue;
            }
            if (!xmlPullParser.getName().equals("transition")) continue;
            this.d(context, resources, xmlPullParser, attributeSet, theme);
        }
    }

    private int d(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object2 = g.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableTransition);
        int n2 = object2.getResourceId(a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int n3 = object2.getResourceId(a.j.AnimatedStateListDrawableTransition_android_toId, -1);
        int n4 = object2.getResourceId(a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawable2 = n4 > 0 ? androidx.appcompat.a.a.a.b((Context)object, n4) : null;
        boolean bl2 = object2.getBoolean(a.j.AnimatedStateListDrawableTransition_android_reversible, false);
        object2.recycle();
        object2 = drawable2;
        if (drawable2 == null) {
            while ((n4 = xmlPullParser.next()) == 4) {
            }
            if (n4 == 2) {
                object2 = xmlPullParser.getName().equals("animated-vector") ? androidx.k.a.a.c.a((Context)object, resources, xmlPullParser, attributeSet, theme) : (Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet));
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
                ((StringBuilder)object).append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(((StringBuilder)object).toString());
            }
        }
        if (object2 != null) {
            if (n2 != -1 && n3 != -1) {
                return this.b.a(n2, n3, (Drawable)object2, bl2);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
            ((StringBuilder)object).append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private int e(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int[] arrn = g.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableItem);
        int n2 = arrn.getResourceId(a.j.AnimatedStateListDrawableItem_android_id, 0);
        int n3 = arrn.getResourceId(a.j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawable2 = n3 > 0 ? androidx.appcompat.a.a.a.b((Context)object, n3) : null;
        arrn.recycle();
        arrn = this.a(attributeSet);
        object = drawable2;
        if (drawable2 == null) {
            while ((n3 = xmlPullParser.next()) == 4) {
            }
            if (n3 == 2) {
                object = xmlPullParser.getName().equals("vector") ? i.a(resources, xmlPullParser, attributeSet, theme) : (Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet));
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
                ((StringBuilder)object).append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(((StringBuilder)object).toString());
            }
        }
        if (object != null) {
            return this.b.a(arrn, (Drawable)object, n2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private void e() {
        this.onStateChange(this.getState());
    }

    b a() {
        return new b(this.b, this, null);
    }

    @Override
    protected void a(b.b b2) {
        super.a(b2);
        if (b2 instanceof b) {
            this.b = (b)b2;
        }
    }

    @Override
    /* synthetic */ d.a b() {
        return this.a();
    }

    @Override
    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray = g.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableCompat);
        this.setVisible(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
        this.a(typedArray);
        this.a(resources);
        typedArray.recycle();
        this.c(context, resources, xmlPullParser, attributeSet, theme);
        this.e();
    }

    @Override
    /* synthetic */ b.b c() {
        return this.a();
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.c != null) {
            this.c.b();
            this.c = null;
            this.a(this.d);
            this.d = -1;
            this.e = -1;
        }
    }

    @Override
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.b.a();
            this.f = true;
        }
        return this;
    }

    @Override
    protected boolean onStateChange(int[] arrn) {
        int n2 = this.b.a(arrn);
        boolean bl2 = n2 != this.d() && (this.b(n2) || this.a(n2));
        Drawable drawable2 = this.getCurrent();
        boolean bl3 = bl2;
        if (drawable2 != null) {
            bl3 = bl2 | drawable2.setState(arrn);
        }
        return bl3;
    }

    @Override
    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = super.setVisible(bl2, bl3);
        if (this.c != null && (bl4 || bl3)) {
            if (bl2) {
                this.c.a();
                return bl4;
            }
            this.jumpToCurrentState();
        }
        return bl4;
    }

    private static class a
    extends f {
        private final Animatable a;

        a(Animatable animatable) {
            super();
            this.a = animatable;
        }

        @Override
        public void a() {
            this.a.start();
        }

        @Override
        public void b() {
            this.a.stop();
        }
    }

    static class b
    extends d.a {
        androidx.c.d<Long> a;
        h<Integer> b;

        /*
         * Enabled aggressive block sorting
         */
        b(b object, a a2, Resources resources) {
            void var1_3;
            void var2_5;
            void var3_6;
            super((d.a)((Object)object), (androidx.appcompat.b.a.d)var2_5, (Resources)var3_6);
            if (object != null) {
                this.a = object.a;
                h<Integer> h2 = object.b;
            } else {
                this.a = new androidx.c.d();
                h h3 = new h();
            }
            this.b = var1_3;
        }

        private static long f(int n2, int n3) {
            long l2 = n2;
            return (long)n3 | l2 << 32;
        }

        int a(int n2) {
            if (n2 < 0) {
                return 0;
            }
            return this.b.a(n2, 0);
        }

        int a(int n2, int n3) {
            long l2 = b.f(n2, n3);
            return (int)this.a.a(l2, -1L).longValue();
        }

        int a(int n2, int n3, Drawable object, boolean bl2) {
            int n4 = super.a((Drawable)object);
            long l2 = b.f(n2, n3);
            long l3 = bl2 ? 0x200000000L : 0L;
            object = this.a;
            long l4 = n4;
            ((androidx.c.d)object).c(l2, l4 | l3);
            if (bl2) {
                l2 = b.f(n3, n2);
                this.a.c(l2, 0x100000000L | l4 | l3);
            }
            return n4;
        }

        int a(int[] arrn) {
            int n2 = super.b(arrn);
            if (n2 >= 0) {
                return n2;
            }
            return super.b(StateSet.WILD_CARD);
        }

        int a(int[] arrn, Drawable drawable2, int n2) {
            int n3 = super.a(arrn, drawable2);
            this.b.b(n3, n2);
            return n3;
        }

        @Override
        void a() {
            this.a = this.a.a();
            this.b = this.b.a();
        }

        boolean b(int n2, int n3) {
            long l2 = b.f(n2, n3);
            return (this.a.a(l2, -1L) & 0x100000000L) != 0L;
        }

        boolean c(int n2, int n3) {
            long l2 = b.f(n2, n3);
            return (this.a.a(l2, -1L) & 0x200000000L) != 0L;
        }

        @Override
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    private static class c
    extends f {
        private final androidx.k.a.a.c a;

        c(androidx.k.a.a.c c2) {
            super();
            this.a = c2;
        }

        @Override
        public void a() {
            this.a.start();
        }

        @Override
        public void b() {
            this.a.stop();
        }
    }

    private static class d
    extends f {
        private final ObjectAnimator a;
        private final boolean b;

        d(AnimationDrawable animationDrawable, boolean bl2, boolean bl3) {
            super();
            int n2 = animationDrawable.getNumberOfFrames();
            int n3 = bl2 ? n2 - 1 : 0;
            if (bl2) {
                n2 = 0;
            }
            e e2 = new e(animationDrawable, bl2);
            animationDrawable = ObjectAnimator.ofInt((Object)animationDrawable, (String)"currentIndex", (int[])new int[]{n3, --n2});
            if (Build.VERSION.SDK_INT >= 18) {
                animationDrawable.setAutoCancel(true);
            }
            animationDrawable.setDuration((long)e2.a());
            animationDrawable.setInterpolator((TimeInterpolator)e2);
            this.b = bl3;
            this.a = animationDrawable;
        }

        @Override
        public void a() {
            this.a.start();
        }

        @Override
        public void b() {
            this.a.cancel();
        }

        @Override
        public boolean c() {
            return this.b;
        }

        @Override
        public void d() {
            this.a.reverse();
        }
    }

    private static class e
    implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean bl2) {
            this.a(animationDrawable, bl2);
        }

        int a() {
            return this.c;
        }

        int a(AnimationDrawable animationDrawable, boolean bl2) {
            int n2;
            this.b = n2 = animationDrawable.getNumberOfFrames();
            if (this.a == null || this.a.length < n2) {
                this.a = new int[n2];
            }
            int[] arrn = this.a;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n4 = bl2 ? n2 - i2 - 1 : i2;
                arrn[i2] = n4 = animationDrawable.getDuration(n4);
                n3 += n4;
            }
            this.c = n3;
            return n3;
        }

        public float getInterpolation(float f2) {
            int n2;
            int n3 = (int)(f2 * (float)this.c + 0.5f);
            int n4 = this.b;
            int[] arrn = this.a;
            for (n2 = 0; n2 < n4 && n3 >= arrn[n2]; n3 -= arrn[n2], ++n2) {
            }
            f2 = n2 < n4 ? (float)n3 / (float)this.c : 0.0f;
            return (float)n2 / (float)n4 + f2;
        }
    }

    private static abstract class f {
        private f() {
        }

        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }
    }

}

