/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.f.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.f.a.d;
import androidx.f.a.f;
import androidx.f.a.h;
import androidx.f.a.i;
import androidx.f.a.j;
import androidx.f.a.k;

public class g {
    private final h<?> a;

    private g(h<?> h2) {
        this.a = h2;
    }

    public static g a(h<?> h2) {
        return new g(h2);
    }

    public View a(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.a.b.onCreateView(view, string2, context, attributeSet);
    }

    public d a(String string2) {
        return this.a.b.b(string2);
    }

    public i a() {
        return this.a.i();
    }

    public void a(Configuration configuration) {
        this.a.b.a(configuration);
    }

    public void a(Parcelable parcelable, k k2) {
        this.a.b.a(parcelable, k2);
    }

    public void a(d d2) {
        this.a.b.a(this.a, this.a, d2);
    }

    public void a(boolean bl2) {
        this.a.b.a(bl2);
    }

    public boolean a(Menu menu) {
        return this.a.b.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.b.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.b.a(menuItem);
    }

    public void b() {
        this.a.b.o();
    }

    public void b(Menu menu) {
        this.a.b.b(menu);
    }

    public void b(boolean bl2) {
        this.a.b.b(bl2);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.b.b(menuItem);
    }

    public Parcelable c() {
        return this.a.b.n();
    }

    public k d() {
        return this.a.b.l();
    }

    public void e() {
        this.a.b.p();
    }

    public void f() {
        this.a.b.q();
    }

    public void g() {
        this.a.b.r();
    }

    public void h() {
        this.a.b.s();
    }

    public void i() {
        this.a.b.t();
    }

    public void j() {
        this.a.b.u();
    }

    public void k() {
        this.a.b.w();
    }

    public void l() {
        this.a.b.x();
    }

    public boolean m() {
        return this.a.b.i();
    }
}

