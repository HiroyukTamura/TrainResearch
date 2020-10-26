/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
import androidx.appcompat.app.e;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.at;
import androidx.core.app.g;

public class c
extends androidx.f.a.e
implements d,
g.a {
    private e k;
    private int l = 0;
    private Resources m;

    private boolean a(int n2, KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers((int)keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey((int)keyEvent.getKeyCode()) && (window = this.getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    public a a() {
        return this.f().a();
    }

    @Override
    public b a(b.a a2) {
        return null;
    }

    @Override
    public void a(b b2) {
    }

    public void a(Toolbar toolbar) {
        this.f().a(toolbar);
    }

    public void a(g g2) {
        g2.a(this);
    }

    public boolean a(Intent intent) {
        return androidx.core.app.e.a(this, intent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f().b(view, layoutParams);
    }

    @Override
    public void b() {
        this.f().f();
    }

    public void b(Intent intent) {
        androidx.core.app.e.b(this, intent);
    }

    @Override
    public void b(b b2) {
    }

    public void b(g g2) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c() {
        Object object = this.d();
        if (object == null) return false;
        if (!this.a((Intent)object)) {
            this.b((Intent)object);
            return true;
        }
        object = g.a((Context)this);
        this.a((g)object);
        this.b((g)object);
        ((g)object).a();
        try {
            androidx.core.app.a.a(this);
            return true;
        }
        catch (IllegalStateException illegalStateException) {}
        this.finish();
        return true;
    }

    public void closeOptionsMenu() {
        a a2 = this.a();
        if (this.getWindow().hasFeature(0) && (a2 == null || !a2.d())) {
            super.closeOptionsMenu();
        }
    }

    @Override
    public Intent d() {
        return androidx.core.app.e.a(this);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n2 = keyEvent.getKeyCode();
        a a2 = this.a();
        if (n2 == 82 && a2 != null && a2.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Deprecated
    public void e() {
    }

    public e f() {
        if (this.k == null) {
            this.k = e.a(this, (d)this);
        }
        return this.k;
    }

    public <T extends View> T findViewById(int n2) {
        return this.f().a(n2);
    }

    public MenuInflater getMenuInflater() {
        return this.f().b();
    }

    public Resources getResources() {
        if (this.m == null && at.a()) {
            this.m = new at((Context)this, super.getResources());
        }
        if (this.m == null) {
            return super.getResources();
        }
        return this.m;
    }

    public void invalidateOptionsMenu() {
        this.f().f();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f().a(configuration);
        if (this.m != null) {
            DisplayMetrics displayMetrics = super.getResources().getDisplayMetrics();
            this.m.updateConfiguration(configuration, displayMetrics);
        }
    }

    public void onContentChanged() {
        this.e();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        e e2 = this.f();
        e2.h();
        e2.a(bundle);
        if (e2.i() && this.l != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.onApplyThemeResource(this.getTheme(), this.l, false);
            } else {
                this.setTheme(this.l);
            }
        }
        super.onCreate(bundle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.f().g();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (this.a(n2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(n2, keyEvent);
    }

    @Override
    public final boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        if (super.onMenuItemSelected(n2, menuItem)) {
            return true;
        }
        a a2 = this.a();
        if (menuItem.getItemId() == 16908332 && a2 != null && (a2.a() & 4) != 0) {
            return this.c();
        }
        return false;
    }

    public boolean onMenuOpened(int n2, Menu menu) {
        return super.onMenuOpened(n2, menu);
    }

    @Override
    public void onPanelClosed(int n2, Menu menu) {
        super.onPanelClosed(n2, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f().b(bundle);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        this.f().e();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f().c(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.f().c();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.f().d();
    }

    protected void onTitleChanged(CharSequence charSequence, int n2) {
        super.onTitleChanged(charSequence, n2);
        this.f().a(charSequence);
    }

    public void openOptionsMenu() {
        a a2 = this.a();
        if (this.getWindow().hasFeature(0) && (a2 == null || !a2.c())) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int n2) {
        this.f().b(n2);
    }

    public void setContentView(View view) {
        this.f().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f().a(view, layoutParams);
    }

    public void setTheme(int n2) {
        super.setTheme(n2);
        this.l = n2;
    }
}

