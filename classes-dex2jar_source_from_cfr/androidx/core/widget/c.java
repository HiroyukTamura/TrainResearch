/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.widget.CompoundButton
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.core.widget.j;
import java.lang.reflect.Field;

public final class c {
    private static Field a;
    private static boolean b;

    public static ColorStateList a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof j) {
            return ((j)compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
            return;
        }
        if (compoundButton instanceof j) {
            ((j)compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
            return;
        }
        if (compoundButton instanceof j) {
            ((j)compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static Drawable b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!b) {
            try {
                a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.i((String)"CompoundButtonCompat", (String)"Failed to retrieve mButtonDrawable field", (Throwable)noSuchFieldException);
            }
            b = true;
        }
        if (a != null) {
            try {
                compoundButton = (Drawable)a.get((Object)compoundButton);
                return compoundButton;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.i((String)"CompoundButtonCompat", (String)"Failed to get button drawable via reflection", (Throwable)illegalAccessException);
                a = null;
            }
        }
        return null;
    }
}

