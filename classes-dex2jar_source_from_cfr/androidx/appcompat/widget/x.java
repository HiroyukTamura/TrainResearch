/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ScaleDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.b.a.c;
import androidx.appcompat.widget.aj;

public class x {
    public static final Rect a;
    private static Class<?> b;

    static {
        block2 : {
            a = new Rect();
            if (Build.VERSION.SDK_INT < 18) break block2;
            try {
                b = Class.forName("android.graphics.Insets");
            }
            catch (ClassNotFoundException classNotFoundException) {}
        }
    }

    public static PorterDuff.Mode a(int n2, PorterDuff.Mode mode) {
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    switch (n2) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    static void a(Drawable drawable2) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable2.getClass().getName())) {
            x.c(drawable2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean b(Drawable drawable2) {
        if (Build.VERSION.SDK_INT < 15 && drawable2 instanceof InsetDrawable) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && drawable2 instanceof GradientDrawable) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && drawable2 instanceof LayerDrawable) {
            return false;
        }
        if (drawable2 instanceof DrawableContainer) {
            if (!((drawable2 = drawable2.getConstantState()) instanceof DrawableContainer.DrawableContainerState)) return true;
            drawable2 = ((DrawableContainer.DrawableContainerState)drawable2).getChildren();
            int n2 = ((Drawable)drawable2).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (x.b(drawable2[i2])) continue;
                return false;
            }
            return true;
        }
        if (drawable2 instanceof androidx.core.graphics.drawable.c) {
            drawable2 = ((androidx.core.graphics.drawable.c)drawable2).a();
            do {
                return x.b(drawable2);
                break;
            } while (true);
        }
        if (drawable2 instanceof c) {
            drawable2 = ((c)drawable2).a();
            return x.b(drawable2);
        }
        if (!(drawable2 instanceof ScaleDrawable)) return true;
        drawable2 = ((ScaleDrawable)drawable2).getDrawable();
        return x.b(drawable2);
    }

    private static void c(Drawable drawable2) {
        int[] arrn = drawable2.getState();
        int[] arrn2 = arrn != null && arrn.length != 0 ? aj.h : aj.e;
        drawable2.setState(arrn2);
        drawable2.setState(arrn);
    }
}

