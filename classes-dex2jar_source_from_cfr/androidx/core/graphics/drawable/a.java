/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.c;
import androidx.core.graphics.drawable.d;
import androidx.core.graphics.drawable.e;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    @Deprecated
    public static void a(Drawable drawable2) {
        drawable2.jumpToCurrentState();
    }

    public static void a(Drawable drawable2, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.setHotspot(f2, f3);
        }
    }

    public static void a(Drawable drawable2, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.setTint(n2);
            return;
        }
        if (drawable2 instanceof b) {
            ((b)drawable2).setTint(n2);
        }
    }

    public static void a(Drawable drawable2, int n2, int n3, int n4, int n5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.setHotspotBounds(n2, n3, n4, n5);
        }
    }

    public static void a(Drawable drawable2, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.setTintList(colorStateList);
            return;
        }
        if (drawable2 instanceof b) {
            ((b)drawable2).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.applyTheme(theme);
        }
    }

    public static void a(Drawable drawable2, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        drawable2.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void a(Drawable drawable2, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable2.setTintMode(mode);
            return;
        }
        if (drawable2 instanceof b) {
            ((b)drawable2).setTintMode(mode);
        }
    }

    public static void a(Drawable drawable2, boolean bl2) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable2.setAutoMirrored(bl2);
        }
    }

    public static boolean b(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable2.isAutoMirrored();
        }
        return false;
    }

    public static boolean b(Drawable drawable2, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable2.setLayoutDirection(n2);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!b) {
                try {
                    a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    a.setAccessible(true);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Log.i((String)"DrawableCompat", (String)"Failed to retrieve setLayoutDirection(int) method", (Throwable)noSuchMethodException);
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke((Object)drawable2, n2);
                    return true;
                }
                catch (Exception exception) {
                    Log.i((String)"DrawableCompat", (String)"Failed to invoke setLayoutDirection(int) via reflection", (Throwable)exception);
                    a = null;
                }
            }
        }
        return false;
    }

    public static int c(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable2.getAlpha();
        }
        return 0;
    }

    public static boolean d(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable2.canApplyTheme();
        }
        return false;
    }

    public static ColorFilter e(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable2.getColorFilter();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void f(Drawable drawable2) {
        block8 : {
            block7 : {
                block6 : {
                    if (Build.VERSION.SDK_INT >= 23 || Build.VERSION.SDK_INT < 21) {
                        drawable2.clearColorFilter();
                        return;
                    }
                    drawable2.clearColorFilter();
                    if (!(drawable2 instanceof InsetDrawable)) break block6;
                    drawable2 = ((InsetDrawable)drawable2).getDrawable();
                    break block7;
                }
                if (!(drawable2 instanceof c)) break block8;
                drawable2 = ((c)drawable2).a();
            }
            a.f(drawable2);
            return;
        }
        if (drawable2 instanceof DrawableContainer && (drawable2 = (DrawableContainer.DrawableContainerState)((DrawableContainer)drawable2).getConstantState()) != null) {
            int n2 = drawable2.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable drawable3 = drawable2.getChild(i2);
                if (drawable3 == null) continue;
                a.f(drawable3);
            }
        }
    }

    public static Drawable g(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable2;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (!(drawable2 instanceof b)) {
                return new e(drawable2);
            }
            return drawable2;
        }
        if (!(drawable2 instanceof b)) {
            return new d(drawable2);
        }
        return drawable2;
    }

    public static int h(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable2.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!d) {
                try {
                    c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    c.setAccessible(true);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Log.i((String)"DrawableCompat", (String)"Failed to retrieve getLayoutDirection() method", (Throwable)noSuchMethodException);
                }
                d = true;
            }
            if (c != null) {
                try {
                    int n2 = (Integer)c.invoke((Object)drawable2, new Object[0]);
                    return n2;
                }
                catch (Exception exception) {
                    Log.i((String)"DrawableCompat", (String)"Failed to invoke getLayoutDirection() via reflection", (Throwable)exception);
                    c = null;
                }
            }
        }
        return 0;
    }
}

