/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.q;
import androidx.c.g;
import java.util.ArrayList;

public class f
extends ActionMode {
    final Context a;
    final b b;

    public f(Context context, b b2) {
        this.a = context;
        this.b = b2;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.i();
    }

    public Menu getMenu() {
        return q.a(this.a, (androidx.core.b.a.a)this.b.b());
    }

    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.j();
    }

    public CharSequence getTitle() {
        return this.b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    public void invalidate() {
        this.b.d();
    }

    public boolean isTitleOptional() {
        return this.b.h();
    }

    public void setCustomView(View view) {
        this.b.a(view);
    }

    public void setSubtitle(int n2) {
        this.b.b(n2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    public void setTag(Object object) {
        this.b.a(object);
    }

    public void setTitle(int n2) {
        this.b.a(n2);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean bl2) {
        this.b.a(bl2);
    }

    public static class a
    implements b.a {
        final ActionMode.Callback a;
        final Context b;
        final ArrayList<f> c;
        final g<Menu, Menu> d;

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
            this.c = new ArrayList();
            this.d = new g();
        }

        private Menu a(Menu menu) {
            Menu menu2;
            Menu menu3 = menu2 = this.d.get((Object)menu);
            if (menu2 == null) {
                menu3 = q.a(this.b, (androidx.core.b.a.a)menu);
                this.d.put(menu, menu3);
            }
            return menu3;
        }

        @Override
        public void a(b b2) {
            this.a.onDestroyActionMode(this.b(b2));
        }

        @Override
        public boolean a(b b2, Menu menu) {
            return this.a.onCreateActionMode(this.b(b2), this.a(menu));
        }

        @Override
        public boolean a(b b2, MenuItem menuItem) {
            return this.a.onActionItemClicked(this.b(b2), q.a(this.b, (androidx.core.b.a.b)menuItem));
        }

        public ActionMode b(b object) {
            int n2 = this.c.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                f f2 = this.c.get(i2);
                if (f2 == null || f2.b != object) continue;
                return f2;
            }
            object = new f(this.b, (b)object);
            this.c.add((f)((Object)object));
            return object;
        }

        @Override
        public boolean b(b b2, Menu menu) {
            return this.a.onPrepareActionMode(this.b(b2), this.a(menu));
        }
    }

}

