/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;

public class u
extends h
implements SubMenu {
    private h d;
    private j e;

    public u(Context context, h h2, j j2) {
        super(context);
        this.d = h2;
        this.e = j2;
    }

    @Override
    public String a() {
        int n2 = this.e != null ? this.e.getItemId() : 0;
        if (n2 == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.a());
        stringBuilder.append(":");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    @Override
    public void a(h.a a2) {
        this.d.a(a2);
    }

    @Override
    boolean a(h h2, MenuItem menuItem) {
        return super.a(h2, menuItem) || this.d.a(h2, menuItem);
        {
        }
    }

    @Override
    public boolean b() {
        return this.d.b();
    }

    @Override
    public boolean c() {
        return this.d.c();
    }

    @Override
    public boolean c(j j2) {
        return this.d.c(j2);
    }

    @Override
    public boolean d() {
        return this.d.d();
    }

    @Override
    public boolean d(j j2) {
        return this.d.d(j2);
    }

    public MenuItem getItem() {
        return this.e;
    }

    @Override
    public h q() {
        return this.d.q();
    }

    @Override
    public void setGroupDividerEnabled(boolean bl2) {
        this.d.setGroupDividerEnabled(bl2);
    }

    public SubMenu setHeaderIcon(int n2) {
        return (SubMenu)super.e(n2);
    }

    public SubMenu setHeaderIcon(Drawable drawable2) {
        return (SubMenu)super.a(drawable2);
    }

    public SubMenu setHeaderTitle(int n2) {
        return (SubMenu)super.d(n2);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu)super.a(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu)super.a(view);
    }

    public SubMenu setIcon(int n2) {
        this.e.setIcon(n2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable2) {
        this.e.setIcon(drawable2);
        return this;
    }

    @Override
    public void setQwertyMode(boolean bl2) {
        this.d.setQwertyMode(bl2);
    }

    public Menu t() {
        return this.d;
    }
}

