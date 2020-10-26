/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.appcompat.widget.i;
import androidx.core.a.a.f;

public class ao {
    private final Context a;
    private final TypedArray b;
    private TypedValue c;

    private ao(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static ao a(Context context, int n2, int[] arrn) {
        return new ao(context, context.obtainStyledAttributes(n2, arrn));
    }

    public static ao a(Context context, AttributeSet attributeSet, int[] arrn) {
        return new ao(context, context.obtainStyledAttributes(attributeSet, arrn));
    }

    public static ao a(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3) {
        return new ao(context, context.obtainStyledAttributes(attributeSet, arrn, n2, n3));
    }

    public float a(int n2, float f2) {
        return this.b.getFloat(n2, f2);
    }

    public int a(int n2, int n3) {
        return this.b.getInt(n2, n3);
    }

    public Typeface a(int n2, int n3, f.a a2) {
        if ((n2 = this.b.getResourceId(n2, 0)) == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return f.a(this.a, n2, this.c, n3, a2);
    }

    public Drawable a(int n2) {
        int n3;
        if (this.b.hasValue(n2) && (n3 = this.b.getResourceId(n2, 0)) != 0) {
            return a.b(this.a, n3);
        }
        return this.b.getDrawable(n2);
    }

    public void a() {
        this.b.recycle();
    }

    public boolean a(int n2, boolean bl2) {
        return this.b.getBoolean(n2, bl2);
    }

    public int b(int n2, int n3) {
        return this.b.getColor(n2, n3);
    }

    public Drawable b(int n2) {
        if (this.b.hasValue(n2) && (n2 = this.b.getResourceId(n2, 0)) != 0) {
            return i.a().a(this.a, n2, true);
        }
        return null;
    }

    public int c(int n2, int n3) {
        return this.b.getInteger(n2, n3);
    }

    public CharSequence c(int n2) {
        return this.b.getText(n2);
    }

    public int d(int n2, int n3) {
        return this.b.getDimensionPixelOffset(n2, n3);
    }

    public String d(int n2) {
        return this.b.getString(n2);
    }

    public int e(int n2, int n3) {
        return this.b.getDimensionPixelSize(n2, n3);
    }

    public ColorStateList e(int n2) {
        ColorStateList colorStateList;
        int n3;
        if (this.b.hasValue(n2) && (n3 = this.b.getResourceId(n2, 0)) != 0 && (colorStateList = a.a(this.a, n3)) != null) {
            return colorStateList;
        }
        return this.b.getColorStateList(n2);
    }

    public int f(int n2, int n3) {
        return this.b.getLayoutDimension(n2, n3);
    }

    public CharSequence[] f(int n2) {
        return this.b.getTextArray(n2);
    }

    public int g(int n2, int n3) {
        return this.b.getResourceId(n2, n3);
    }

    public boolean g(int n2) {
        return this.b.hasValue(n2);
    }
}

