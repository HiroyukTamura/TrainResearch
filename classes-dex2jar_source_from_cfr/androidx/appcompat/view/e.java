/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class e
extends b
implements h.a {
    private Context a;
    private ActionBarContextView b;
    private b.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private h g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a a2, boolean bl2) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = a2;
        this.g = new h(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f = bl2;
    }

    @Override
    public MenuInflater a() {
        return new g(this.b.getContext());
    }

    @Override
    public void a(int n2) {
        this.b(this.a.getString(n2));
    }

    @Override
    public void a(View object) {
        this.b.setCustomView((View)object);
        object = object != null ? new WeakReference<View>((View)object) : null;
        this.d = object;
    }

    @Override
    public void a(h h2) {
        this.d();
        this.b.a();
    }

    @Override
    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        super.a(bl2);
        this.b.setTitleOptional(bl2);
    }

    @Override
    public boolean a(h h2, MenuItem menuItem) {
        return this.c.a((b)this, menuItem);
    }

    @Override
    public Menu b() {
        return this.g;
    }

    @Override
    public void b(int n2) {
        this.a(this.a.getString(n2));
    }

    @Override
    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    @Override
    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.sendAccessibilityEvent(32);
        this.c.a(this);
    }

    @Override
    public void d() {
        this.c.b(this, this.g);
    }

    @Override
    public CharSequence f() {
        return this.b.getTitle();
    }

    @Override
    public CharSequence g() {
        return this.b.getSubtitle();
    }

    @Override
    public boolean h() {
        return this.b.d();
    }

    @Override
    public View i() {
        if (this.d != null) {
            return (View)this.d.get();
        }
        return null;
    }
}

