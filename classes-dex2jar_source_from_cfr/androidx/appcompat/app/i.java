/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ap;
import androidx.appcompat.widget.w;
import androidx.core.h.t;
import java.util.ArrayList;

class i
extends androidx.appcompat.app.a {
    w a;
    boolean b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<a.b> f = new ArrayList();
    private final Runnable g = new Runnable(){

        @Override
        public void run() {
            i.this.i();
        }
    };
    private final Toolbar.c h = new Toolbar.c(){

        @Override
        public boolean a(MenuItem menuItem) {
            return i.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.a = new ap(toolbar, false);
        this.c = new c(callback);
        this.a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.a(charSequence);
    }

    private Menu j() {
        if (!this.d) {
            this.a.a(new a(), new b());
            this.d = true;
        }
        return this.a.q();
    }

    @Override
    public int a() {
        return this.a.o();
    }

    @Override
    public void a(float f2) {
        t.c((View)this.a.a(), f2);
    }

    public void a(int n2, int n3) {
        int n4 = this.a.o();
        this.a.c(n2 & n3 | n3 & n4);
    }

    @Override
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override
    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        int n2 = bl2 ? 8 : 0;
        this.a(n2, 8);
    }

    @Override
    public boolean a(int n2, KeyEvent keyEvent) {
        Menu menu = this.j();
        if (menu != null) {
            int n3 = keyEvent != null ? keyEvent.getDeviceId() : -1;
            n3 = KeyCharacterMap.load((int)n3).getKeyboardType();
            boolean bl2 = true;
            if (n3 == 1) {
                bl2 = false;
            }
            menu.setQwertyMode(bl2);
            return menu.performShortcut(n2, keyEvent, 0);
        }
        return false;
    }

    @Override
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.c();
        }
        return true;
    }

    @Override
    public Context b() {
        return this.a.b();
    }

    @Override
    public void b(boolean bl2) {
    }

    @Override
    public boolean c() {
        return this.a.k();
    }

    @Override
    public void d(boolean bl2) {
    }

    @Override
    public boolean d() {
        return this.a.l();
    }

    @Override
    public void e(boolean bl2) {
    }

    @Override
    public boolean e() {
        this.a.a().removeCallbacks(this.g);
        t.a((View)this.a.a(), this.g);
        return true;
    }

    @Override
    public void f(boolean bl2) {
        if (bl2 == this.e) {
            return;
        }
        this.e = bl2;
        int n2 = this.f.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.f.get(i2).a(bl2);
        }
    }

    @Override
    public boolean f() {
        if (this.a.c()) {
            this.a.d();
            return true;
        }
        return false;
    }

    @Override
    void g() {
        this.a.a().removeCallbacks(this.g);
    }

    public Window.Callback h() {
        return this.c;
    }

    void i() {
        Menu menu = this.j();
        h h2 = menu instanceof h ? (h)menu : null;
        if (h2 != null) {
            h2.h();
        }
        try {
            menu.clear();
            if (!this.c.onCreatePanelMenu(0, menu) || !this.c.onPreparePanel(0, null, menu)) {
                menu.clear();
            }
            return;
        }
        finally {
            if (h2 != null) {
                h2.i();
            }
        }
    }

    private final class a
    implements o.a {
        private boolean b;

        a() {
        }

        @Override
        public void a(h h2, boolean bl2) {
            if (this.b) {
                return;
            }
            this.b = true;
            i.this.a.n();
            if (i.this.c != null) {
                i.this.c.onPanelClosed(108, (Menu)h2);
            }
            this.b = false;
        }

        @Override
        public boolean a(h h2) {
            if (i.this.c != null) {
                i.this.c.onMenuOpened(108, (Menu)h2);
                return true;
            }
            return false;
        }
    }

    private final class b
    implements h.a {
        b() {
        }

        @Override
        public void a(h h2) {
            if (i.this.c != null) {
                if (i.this.a.i()) {
                    i.this.c.onPanelClosed(108, (Menu)h2);
                    return;
                }
                if (i.this.c.onPreparePanel(0, null, (Menu)h2)) {
                    i.this.c.onMenuOpened(108, (Menu)h2);
                }
            }
        }

        @Override
        public boolean a(h h2, MenuItem menuItem) {
            return false;
        }
    }

    private class c
    extends androidx.appcompat.view.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override
        public View onCreatePanelView(int n2) {
            if (n2 == 0) {
                return new View(i.this.a.b());
            }
            return super.onCreatePanelView(n2);
        }

        @Override
        public boolean onPreparePanel(int n2, View view, Menu menu) {
            boolean bl2 = super.onPreparePanel(n2, view, menu);
            if (bl2 && !i.this.b) {
                i.this.a.m();
                i.this.b = true;
            }
            return bl2;
        }
    }

}

