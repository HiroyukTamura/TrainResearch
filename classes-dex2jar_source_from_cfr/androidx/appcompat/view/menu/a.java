/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.ActionProvider
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.h.b;

public class a
implements androidx.core.b.a.b {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private int i = 4096;
    private char j;
    private int k = 4096;
    private Drawable l;
    private int m = 0;
    private Context n;
    private MenuItem.OnMenuItemClickListener o;
    private CharSequence p;
    private CharSequence q;
    private ColorStateList r = null;
    private PorterDuff.Mode s = null;
    private boolean t = false;
    private boolean u = false;
    private int v = 16;

    public a(Context context, int n2, int n3, int n4, int n5, CharSequence charSequence) {
        this.n = context;
        this.a = n3;
        this.b = n2;
        this.c = n4;
        this.d = n5;
        this.e = charSequence;
    }

    private void b() {
        if (this.l != null && (this.t || this.u)) {
            this.l = androidx.core.graphics.drawable.a.g(this.l);
            this.l = this.l.mutate();
            if (this.t) {
                androidx.core.graphics.drawable.a.a(this.l, this.r);
            }
            if (this.u) {
                androidx.core.graphics.drawable.a.a(this.l, this.s);
            }
        }
    }

    public androidx.core.b.a.b a(int n2) {
        throw new UnsupportedOperationException();
    }

    public androidx.core.b.a.b a(View view) {
        throw new UnsupportedOperationException();
    }

    @Override
    public androidx.core.b.a.b a(b b2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public androidx.core.b.a.b a(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    @Override
    public b a() {
        return null;
    }

    public androidx.core.b.a.b b(int n2) {
        this.setShowAsAction(n2);
        return this;
    }

    @Override
    public androidx.core.b.a.b b(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    @Override
    public boolean collapseActionView() {
        return false;
    }

    @Override
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override
    public View getActionView() {
        return null;
    }

    @Override
    public int getAlphabeticModifiers() {
        return this.k;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override
    public CharSequence getContentDescription() {
        return this.p;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.l;
    }

    @Override
    public ColorStateList getIconTintList() {
        return this.r;
    }

    @Override
    public PorterDuff.Mode getIconTintMode() {
        return this.s;
    }

    public Intent getIntent() {
        return this.g;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override
    public int getNumericModifiers() {
        return this.i;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        if (this.f != null) {
            return this.f;
        }
        return this.e;
    }

    @Override
    public CharSequence getTooltipText() {
        return this.q;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.v & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override
    public /* synthetic */ MenuItem setActionView(int n2) {
        return this.a(n2);
    }

    @Override
    public /* synthetic */ MenuItem setActionView(View view) {
        return this.a(view);
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.j = Character.toLowerCase(c2);
        return this;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState((int)n2);
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        this.v = bl2 | this.v & -2;
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        int n2 = this.v;
        int n3 = bl2 ? 2 : 0;
        this.v = n3 | n2 & -3;
        return this;
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return this.a(charSequence);
    }

    public MenuItem setEnabled(boolean bl2) {
        int n2 = this.v;
        int n3 = bl2 ? 16 : 0;
        this.v = n3 | n2 & -17;
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.m = n2;
        this.l = androidx.core.a.a.a(this.n, n2);
        this.b();
        return this;
    }

    public MenuItem setIcon(Drawable drawable2) {
        this.l = drawable2;
        this.m = 0;
        this.b();
        return this;
    }

    @Override
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        this.t = true;
        this.b();
        return this;
    }

    @Override
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.s = mode;
        this.u = true;
        this.b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.h = c2;
        return this;
    }

    @Override
    public MenuItem setNumericShortcut(char c2, int n2) {
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState((int)n2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.j = Character.toLowerCase(c3);
        return this;
    }

    @Override
    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState((int)n2);
        this.j = Character.toLowerCase(c3);
        this.k = KeyEvent.normalizeMetaState((int)n3);
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
    }

    @Override
    public /* synthetic */ MenuItem setShowAsActionFlags(int n2) {
        return this.b(n2);
    }

    public MenuItem setTitle(int n2) {
        this.e = this.n.getResources().getString(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return this.b(charSequence);
    }

    public MenuItem setVisible(boolean bl2) {
        int n2 = this.v;
        int n3 = 8;
        if (bl2) {
            n3 = 0;
        }
        this.v = n2 & 8 | n3;
        return this;
    }
}

