/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.core.h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {
    private final Context a;
    private a b;
    private b c;

    public b(Context context) {
        this.a = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return this.a();
    }

    public void a(SubMenu subMenu) {
    }

    public void a(a a2) {
        this.b = a2;
    }

    public void a(b b2) {
        if (this.c != null && b2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" instance while it is still in use somewhere else?");
            Log.w((String)"ActionProvider(support)", (String)stringBuilder.toString());
        }
        this.c = b2;
    }

    public void a(boolean bl2) {
        if (this.b != null) {
            this.b.d(bl2);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public void f() {
        this.c = null;
        this.b = null;
    }

    public static interface a {
        public void d(boolean var1);
    }

    public static interface b {
        public void a(boolean var1);
    }

}

