/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.am;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.u;
import androidx.core.a.a.f;
import androidx.core.widget.b;
import java.lang.ref.WeakReference;

class t {
    private final TextView a;
    private am b;
    private am c;
    private am d;
    private am e;
    private am f;
    private am g;
    private final u h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    t(TextView textView) {
        this.a = textView;
        this.h = new u(this.a);
    }

    private static am a(Context context, i object, int n2) {
        if ((context = ((i)object).b(context, n2)) != null) {
            object = new am();
            ((am)object).d = true;
            ((am)object).a = context;
            return object;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(Context var1_1, ao var2_3) {
        block11 : {
            this.i = var2_3.a(a.j.TextAppearance_android_textStyle, this.i);
            var5_4 = var2_3.g(a.j.TextAppearance_android_fontFamily);
            var4_5 = true;
            if (!var5_4 && !var2_3.g(a.j.TextAppearance_fontFamily)) {
                if (var2_3.g(a.j.TextAppearance_android_typeface) == false) return;
                this.k = false;
                switch (var2_3.a(a.j.TextAppearance_android_typeface, 1)) {
                    default: {
                        return;
                    }
                    case 3: {
                        var1_1 /* !! */  = Typeface.MONOSPACE;
                        ** break;
                    }
                    case 2: {
                        var1_1 /* !! */  = Typeface.SERIF;
                        ** break;
                    }
                    case 1: 
                }
                var1_1 /* !! */  = Typeface.SANS_SERIF;
lbl18: // 3 sources:
                this.j = var1_1 /* !! */ ;
                return;
            }
            this.j = null;
            var3_6 = var2_3.g(a.j.TextAppearance_fontFamily) != false ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            if (!var1_1 /* !! */ .isRestricted()) {
                block10 : {
                    block9 : {
                        var1_1 /* !! */  = new f.a(new WeakReference<TextView>(this.a)){
                            final /* synthetic */ WeakReference a;
                            {
                                this.a = weakReference;
                            }

                            @Override
                            public void a(int n2) {
                            }

                            @Override
                            public void a(Typeface typeface) {
                                t.this.a(this.a, typeface);
                            }
                        };
                        try {
                            this.j = var2_3.a(var3_6, this.i, (f.a)var1_1 /* !! */ );
                            if (this.j != null) break block9;
                            break block10;
                        }
                        catch (Resources.NotFoundException | UnsupportedOperationException var1_2) {
                            break block11;
                        }
                    }
                    var4_5 = false;
                }
                this.k = var4_5;
            }
        }
        if (this.j != null) return;
        var1_1 /* !! */  = var2_3.d(var3_6);
        if (var1_1 /* !! */  == null) return;
        this.j = Typeface.create((String)var1_1 /* !! */ , (int)this.i);
    }

    private void a(Drawable drawable2, am am2) {
        if (drawable2 != null && am2 != null) {
            i.a(drawable2, am2, this.a.getDrawableState());
        }
    }

    private void b(int n2, float f2) {
        this.h.a(n2, f2);
    }

    void a() {
        Drawable[] arrdrawable;
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            arrdrawable = this.a.getCompoundDrawables();
            this.a(arrdrawable[0], this.b);
            this.a(arrdrawable[1], this.c);
            this.a(arrdrawable[2], this.d);
            this.a(arrdrawable[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17 && (this.f != null || this.g != null)) {
            arrdrawable = this.a.getCompoundDrawablesRelative();
            this.a(arrdrawable[0], this.f);
            this.a(arrdrawable[2], this.g);
        }
    }

    void a(int n2) {
        this.h.a(n2);
    }

    void a(int n2, float f2) {
        if (!b.d && !this.c()) {
            this.b(n2, f2);
        }
    }

    void a(int n2, int n3, int n4, int n5) {
        this.h.a(n2, n3, n4, n5);
    }

    void a(Context context, int n2) {
        ColorStateList colorStateList;
        ao ao2 = ao.a(context, n2, a.j.TextAppearance);
        if (ao2.g(a.j.TextAppearance_textAllCaps)) {
            this.a(ao2.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && ao2.g(a.j.TextAppearance_android_textColor) && (colorStateList = ao2.e(a.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(colorStateList);
        }
        if (ao2.g(a.j.TextAppearance_android_textSize) && ao2.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.a(context, ao2);
        ao2.a();
        if (this.j != null) {
            this.a.setTypeface(this.j, this.i);
        }
    }

    @SuppressLint(value={"NewApi"})
    void a(AttributeSet object, int n2) {
        boolean bl2;
        Context context = this.a.getContext();
        Object object2 = i.a();
        ao ao2 = ao.a(context, (AttributeSet)object, a.j.AppCompatTextHelper, n2, 0);
        int n3 = ao2.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (ao2.g(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = t.a(context, (i)object2, ao2.g(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (ao2.g(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = t.a(context, (i)object2, ao2.g(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (ao2.g(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = t.a(context, (i)object2, ao2.g(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (ao2.g(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = t.a(context, (i)object2, ao2.g(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (ao2.g(a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f = t.a(context, (i)object2, ao2.g(a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (ao2.g(a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = t.a(context, (i)object2, ao2.g(a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        ao2.a();
        boolean bl3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        int n4 = 1;
        ao2 = null;
        Object object3 = null;
        ColorStateList colorStateList = null;
        if (n3 != -1) {
            object3 = ao.a(context, n3, a.j.TextAppearance);
            if (!bl3 && ((ao)object3).g(a.j.TextAppearance_textAllCaps)) {
                bl2 = ((ao)object3).a(a.j.TextAppearance_textAllCaps, false);
                n3 = 1;
            } else {
                n3 = 0;
                bl2 = false;
            }
            this.a(context, (ao)object3);
            if (Build.VERSION.SDK_INT < 23) {
                ao2 = ((ao)object3).g(a.j.TextAppearance_android_textColor) ? ((ao)object3).e(a.j.TextAppearance_android_textColor) : null;
                object2 = ((ao)object3).g(a.j.TextAppearance_android_textColorHint) ? ((ao)object3).e(a.j.TextAppearance_android_textColorHint) : null;
                if (((ao)object3).g(a.j.TextAppearance_android_textColorLink)) {
                    colorStateList = ((ao)object3).e(a.j.TextAppearance_android_textColorLink);
                }
            } else {
                colorStateList = null;
                object2 = colorStateList;
            }
            ((ao)object3).a();
        } else {
            colorStateList = null;
            object2 = colorStateList;
            n3 = 0;
            bl2 = false;
            ao2 = object3;
        }
        ao ao3 = ao.a(context, (AttributeSet)object, a.j.TextAppearance, n2, 0);
        if (!bl3 && ao3.g(a.j.TextAppearance_textAllCaps)) {
            bl2 = ao3.a(a.j.TextAppearance_textAllCaps, false);
            n3 = n4;
        }
        ao ao4 = ao2;
        ColorStateList colorStateList2 = colorStateList;
        object3 = object2;
        if (Build.VERSION.SDK_INT < 23) {
            if (ao3.g(a.j.TextAppearance_android_textColor)) {
                ao2 = ao3.e(a.j.TextAppearance_android_textColor);
            }
            if (ao3.g(a.j.TextAppearance_android_textColorHint)) {
                object2 = ao3.e(a.j.TextAppearance_android_textColorHint);
            }
            ao4 = ao2;
            colorStateList2 = colorStateList;
            object3 = object2;
            if (ao3.g(a.j.TextAppearance_android_textColorLink)) {
                colorStateList2 = ao3.e(a.j.TextAppearance_android_textColorLink);
                object3 = object2;
                ao4 = ao2;
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && ao3.g(a.j.TextAppearance_android_textSize) && ao3.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.a(context, ao3);
        ao3.a();
        if (ao4 != null) {
            this.a.setTextColor((ColorStateList)ao4);
        }
        if (object3 != null) {
            this.a.setHintTextColor((ColorStateList)object3);
        }
        if (colorStateList2 != null) {
            this.a.setLinkTextColor(colorStateList2);
        }
        if (!bl3 && n3 != 0) {
            this.a(bl2);
        }
        if (this.j != null) {
            this.a.setTypeface(this.j, this.i);
        }
        this.h.a((AttributeSet)object, n2);
        if (b.d && this.h.a() != 0 && ((int[])(object2 = this.h.e())).length > 0) {
            if ((float)this.a.getAutoSizeStepGranularity() != -1.0f) {
                this.a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.d(), this.h.b(), 0);
            } else {
                this.a.setAutoSizeTextTypeUniformWithPresetSizes(object2, 0);
            }
        }
        object = ao.a(context, (AttributeSet)object, a.j.AppCompatTextView);
        n2 = ((ao)object).e(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        n3 = ((ao)object).e(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        n4 = ((ao)object).e(a.j.AppCompatTextView_lineHeight, -1);
        ((ao)object).a();
        if (n2 != -1) {
            androidx.core.widget.i.b(this.a, n2);
        }
        if (n3 != -1) {
            androidx.core.widget.i.c(this.a, n3);
        }
        if (n4 != -1) {
            androidx.core.widget.i.d(this.a, n4);
        }
    }

    void a(WeakReference<TextView> textView, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            if ((textView = (TextView)textView.get()) != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    void a(boolean bl2) {
        this.a.setAllCaps(bl2);
    }

    void a(boolean bl2, int n2, int n3, int n4, int n5) {
        if (!b.d) {
            this.b();
        }
    }

    void a(int[] arrn, int n2) {
        this.h.a(arrn, n2);
    }

    void b() {
        this.h.f();
    }

    boolean c() {
        return this.h.g();
    }

    int d() {
        return this.h.a();
    }

    int e() {
        return this.h.b();
    }

    int f() {
        return this.h.c();
    }

    int g() {
        return this.h.d();
    }

    int[] h() {
        return this.h.e();
    }

}

