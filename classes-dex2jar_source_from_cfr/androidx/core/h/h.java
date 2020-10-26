/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MenuItem
 */
package androidx.core.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.h.b;

public final class h {
    public static MenuItem a(MenuItem menuItem, b b2) {
        if (menuItem instanceof androidx.core.b.a.b) {
            return ((androidx.core.b.a.b)menuItem).a(b2);
        }
        Log.w((String)"MenuItemCompat", (String)"setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a(MenuItem menuItem, char c2, int n2) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b)menuItem).setNumericShortcut(c2, n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, n2);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b)menuItem).setIconTintList(colorStateList);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b)menuItem).setIconTintMode(mode);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b)menuItem).a(charSequence);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c2, int n2) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b)menuItem).setAlphabeticShortcut(c2, n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, n2);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b)menuItem).b(charSequence);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}

