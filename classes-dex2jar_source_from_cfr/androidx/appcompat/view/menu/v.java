/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.r;
import androidx.core.b.a.a;
import androidx.core.b.a.c;

class v
extends r
implements SubMenu {
    v(Context context, c c2) {
        super(context, c2);
    }

    public c b() {
        return (c)this.b;
    }

    public void clearHeader() {
        this.b().clearHeader();
    }

    public MenuItem getItem() {
        return this.a(this.b().getItem());
    }

    public SubMenu setHeaderIcon(int n2) {
        this.b().setHeaderIcon(n2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable2) {
        this.b().setHeaderIcon(drawable2);
        return this;
    }

    public SubMenu setHeaderTitle(int n2) {
        this.b().setHeaderTitle(n2);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int n2) {
        this.b().setIcon(n2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable2) {
        this.b().setIcon(drawable2);
        return this;
    }
}

