/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.SubMenu
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.q;
import androidx.c.a;
import androidx.core.b.a.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class c<T>
extends d<T> {
    final Context a;
    private Map<b, MenuItem> c;
    private Map<androidx.core.b.a.c, SubMenu> d;

    c(Context context, T t2) {
        super(t2);
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        if (menuItem instanceof b) {
            b b2 = (b)menuItem;
            if (this.c == null) {
                this.c = new a<b, MenuItem>();
            }
            menuItem2 = menuItem = this.c.get((Object)menuItem);
            if (menuItem == null) {
                menuItem2 = q.a(this.a, b2);
                this.c.put(b2, menuItem2);
            }
        }
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof androidx.core.b.a.c) {
            SubMenu subMenu2;
            androidx.core.b.a.c c2 = (androidx.core.b.a.c)subMenu;
            if (this.d == null) {
                this.d = new a<androidx.core.b.a.c, SubMenu>();
            }
            subMenu = subMenu2 = this.d.get(c2);
            if (subMenu2 == null) {
                subMenu = q.a(this.a, c2);
                this.d.put(c2, subMenu);
            }
            return subMenu;
        }
        return subMenu;
    }

    final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    final void a(int n2) {
        if (this.c == null) {
            return;
        }
        Iterator<b> iterator = this.c.keySet().iterator();
        while (iterator.hasNext()) {
            if (n2 != ((MenuItem)iterator.next()).getGroupId()) continue;
            iterator.remove();
        }
    }

    final void b(int n2) {
        if (this.c == null) {
            return;
        }
        Iterator<b> iterator = this.c.keySet().iterator();
        while (iterator.hasNext()) {
            if (n2 != ((MenuItem)iterator.next()).getItemId()) continue;
            iterator.remove();
            break;
        }
    }
}

