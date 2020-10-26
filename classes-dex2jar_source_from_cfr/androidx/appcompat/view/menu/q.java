/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.view.menu.v;
import androidx.core.b.a.a;
import androidx.core.b.a.b;
import androidx.core.b.a.c;

public final class q {
    public static Menu a(Context context, a a2) {
        return new r(context, a2);
    }

    public static MenuItem a(Context context, b b2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new l(context, b2);
        }
        return new k(context, b2);
    }

    public static SubMenu a(Context context, c c2) {
        return new v(context, c2);
    }
}

