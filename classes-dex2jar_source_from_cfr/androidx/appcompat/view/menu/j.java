/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewDebug
 *  android.view.ViewDebug$CapturedViewProperty
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 */
package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.u;
import androidx.core.h.b;

public final class j
implements androidx.core.b.a.b {
    private View A;
    private b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;
    h a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private CharSequence f;
    private CharSequence g;
    private Intent h;
    private char i;
    private int j = 4096;
    private char k;
    private int l = 4096;
    private Drawable m;
    private int n = 0;
    private u o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private int z = 0;

    j(h h2, int n2, int n3, int n4, int n5, CharSequence charSequence, int n6) {
        this.a = h2;
        this.b = n3;
        this.c = n2;
        this.d = n4;
        this.e = n5;
        this.f = charSequence;
        this.z = n6;
    }

    private Drawable a(Drawable drawable2) {
        Drawable drawable3;
        block5 : {
            block6 : {
                drawable3 = drawable2;
                if (drawable2 == null) break block5;
                drawable3 = drawable2;
                if (!this.x) break block5;
                if (this.v) break block6;
                drawable3 = drawable2;
                if (!this.w) break block5;
            }
            drawable3 = androidx.core.graphics.drawable.a.g(drawable2).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable3, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable3, this.u);
            }
            this.x = false;
        }
        return drawable3;
    }

    private static void a(StringBuilder stringBuilder, int n2, int n3, String string2) {
        if ((n2 & n3) == n3) {
            stringBuilder.append(string2);
        }
    }

    public androidx.core.b.a.b a(int n2) {
        Context context = this.a.f();
        this.a(LayoutInflater.from((Context)context).inflate(n2, (ViewGroup)new LinearLayout(context), false));
        return this;
    }

    public androidx.core.b.a.b a(View view) {
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && this.b > 0) {
            view.setId(this.b);
        }
        this.a.b(this);
        return this;
    }

    @Override
    public androidx.core.b.a.b a(b b2) {
        if (this.B != null) {
            this.B.f();
        }
        this.A = null;
        this.B = b2;
        this.a.b(true);
        if (this.B != null) {
            this.B.a(new b.b(){

                @Override
                public void a(boolean bl2) {
                    j.this.a.a(j.this);
                }
            });
        }
        return this;
    }

    @Override
    public androidx.core.b.a.b a(CharSequence charSequence) {
        this.r = charSequence;
        this.a.b(false);
        return this;
    }

    @Override
    public b a() {
        return this.B;
    }

    CharSequence a(p.a a2) {
        if (a2 != null && a2.a()) {
            return this.getTitleCondensed();
        }
        return this.getTitle();
    }

    void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public void a(u u2) {
        this.o = u2;
        u2.setHeaderTitle(this.getTitle());
    }

    public void a(boolean bl2) {
        int n2 = this.y;
        int n3 = bl2 ? 4 : 0;
        this.y = n3 | n2 & -5;
    }

    public androidx.core.b.a.b b(int n2) {
        this.setShowAsAction(n2);
        return this;
    }

    @Override
    public androidx.core.b.a.b b(CharSequence charSequence) {
        this.s = charSequence;
        this.a.b(false);
        return this;
    }

    void b(boolean bl2) {
        int n2 = this.y;
        int n3 = this.y;
        int n4 = bl2 ? 2 : 0;
        this.y = n4 | n3 & -3;
        if (n2 != this.y) {
            this.a.b(false);
        }
    }

    public boolean b() {
        if (this.q != null && this.q.onMenuItemClick((MenuItem)this)) {
            return true;
        }
        if (this.a.a(this.a, this)) {
            return true;
        }
        if (this.p != null) {
            this.p.run();
            return true;
        }
        if (this.h != null) {
            try {
                this.a.f().startActivity(this.h);
                return true;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                Log.e((String)"MenuItemImpl", (String)"Can't find activity to handle intent; ignoring", (Throwable)activityNotFoundException);
            }
        }
        return this.B != null && this.B.b();
    }

    public int c() {
        return this.e;
    }

    boolean c(boolean bl2) {
        int n2 = this.y;
        int n3 = this.y;
        boolean bl3 = false;
        int n4 = bl2 ? 0 : 8;
        this.y = n4 | n3 & -9;
        bl2 = bl3;
        if (n2 != this.y) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        if (this.C != null && !this.C.onMenuItemActionCollapse((MenuItem)this)) {
            return false;
        }
        return this.a.d(this);
    }

    char d() {
        if (this.a.c()) {
            return this.k;
        }
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d(boolean bl2) {
        int n2 = bl2 ? this.y | 32 : this.y & -33;
        this.y = n2;
    }

    String e() {
        StringBuilder stringBuilder;
        block5 : {
            Resources resources;
            int n2;
            block6 : {
                block2 : {
                    block3 : {
                        block4 : {
                            char c2 = this.d();
                            if (c2 == '\u0000') {
                                return "";
                            }
                            resources = this.a.f().getResources();
                            stringBuilder = new StringBuilder();
                            if (ViewConfiguration.get((Context)this.a.f()).hasPermanentMenuKey()) {
                                stringBuilder.append(resources.getString(a.h.abc_prepend_shortcut_label));
                            }
                            n2 = this.a.c() ? this.l : this.j;
                            j.a(stringBuilder, n2, 65536, resources.getString(a.h.abc_menu_meta_shortcut_label));
                            j.a(stringBuilder, n2, 4096, resources.getString(a.h.abc_menu_ctrl_shortcut_label));
                            j.a(stringBuilder, n2, 2, resources.getString(a.h.abc_menu_alt_shortcut_label));
                            j.a(stringBuilder, n2, 1, resources.getString(a.h.abc_menu_shift_shortcut_label));
                            j.a(stringBuilder, n2, 4, resources.getString(a.h.abc_menu_sym_shortcut_label));
                            j.a(stringBuilder, n2, 8, resources.getString(a.h.abc_menu_function_shortcut_label));
                            if (c2 == '\b') break block2;
                            if (c2 == '\n') break block3;
                            if (c2 == ' ') break block4;
                            stringBuilder.append(c2);
                            break block5;
                        }
                        n2 = a.h.abc_menu_space_shortcut_label;
                        break block6;
                    }
                    n2 = a.h.abc_menu_enter_shortcut_label;
                    break block6;
                }
                n2 = a.h.abc_menu_delete_shortcut_label;
            }
            stringBuilder.append(resources.getString(n2));
        }
        return stringBuilder.toString();
    }

    public void e(boolean bl2) {
        this.D = bl2;
        this.a.b(false);
    }

    @Override
    public boolean expandActionView() {
        if (!this.n()) {
            return false;
        }
        if (this.C != null && !this.C.onMenuItemActionExpand((MenuItem)this)) {
            return false;
        }
        return this.a.c(this);
    }

    boolean f() {
        return this.a.d() && this.d() != '\u0000';
    }

    public boolean g() {
        return (this.y & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override
    public View getActionView() {
        if (this.A != null) {
            return this.A;
        }
        if (this.B != null) {
            this.A = this.B.a(this);
            return this.A;
        }
        return null;
    }

    @Override
    public int getAlphabeticModifiers() {
        return this.l;
    }

    public char getAlphabeticShortcut() {
        return this.k;
    }

    @Override
    public CharSequence getContentDescription() {
        return this.r;
    }

    public int getGroupId() {
        return this.c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Drawable getIcon() {
        Drawable drawable2;
        if (this.m != null) {
            drawable2 = this.m;
            do {
                return this.a(drawable2);
                break;
            } while (true);
        }
        if (this.n == 0) return null;
        drawable2 = androidx.appcompat.a.a.a.b(this.a.f(), this.n);
        this.n = 0;
        this.m = drawable2;
        return this.a(drawable2);
    }

    @Override
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    public Intent getIntent() {
        return this.h;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.b;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override
    public int getNumericModifiers() {
        return this.j;
    }

    public char getNumericShortcut() {
        return this.i;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.g != null ? this.g : this.f;
        CharSequence charSequence2 = charSequence;
        if (Build.VERSION.SDK_INT < 18) {
            charSequence2 = charSequence;
            if (charSequence != null) {
                charSequence2 = charSequence;
                if (!(charSequence instanceof String)) {
                    charSequence2 = charSequence.toString();
                }
            }
        }
        return charSequence2;
    }

    @Override
    public CharSequence getTooltipText() {
        return this.s;
    }

    public void h() {
        this.a.b(this);
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return this.a.r();
    }

    @Override
    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    public boolean isVisible() {
        b b2 = this.B;
        boolean bl2 = false;
        boolean bl3 = false;
        if (b2 != null && this.B.d()) {
            bl2 = bl3;
            if ((this.y & 8) == 0) {
                bl2 = bl3;
                if (this.B.e()) {
                    bl2 = true;
                }
            }
            return bl2;
        }
        if ((this.y & 8) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean j() {
        return (this.y & 32) == 32;
    }

    public boolean k() {
        return (this.z & 1) == 1;
    }

    public boolean l() {
        return (this.z & 2) == 2;
    }

    public boolean m() {
        return (this.z & 4) == 4;
    }

    public boolean n() {
        boolean bl2;
        int n2 = this.z;
        boolean bl3 = bl2 = false;
        if ((n2 & 8) != 0) {
            if (this.A == null && this.B != null) {
                this.A = this.B.a(this);
            }
            bl3 = bl2;
            if (this.A != null) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
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
        if (this.k == c2) {
            return this;
        }
        this.k = Character.toLowerCase(c2);
        this.a.b(false);
        return this;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        if (this.k == c2 && this.l == n2) {
            return this;
        }
        this.k = Character.toLowerCase(c2);
        this.l = KeyEvent.normalizeMetaState((int)n2);
        this.a.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        int n2 = this.y;
        this.y = bl2 | this.y & -2;
        if (n2 != this.y) {
            this.a.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        if ((this.y & 4) != 0) {
            this.a.a((MenuItem)this);
            return this;
        }
        this.b(bl2);
        return this;
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return this.a(charSequence);
    }

    /*
     * Enabled aggressive block sorting
     */
    public MenuItem setEnabled(boolean bl2) {
        int n2 = bl2 ? this.y | 16 : this.y & -17;
        this.y = n2;
        this.a.b(false);
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.m = null;
        this.n = n2;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable2) {
        this.n = 0;
        this.m = drawable2;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.i == c2) {
            return this;
        }
        this.i = c2;
        this.a.b(false);
        return this;
    }

    @Override
    public MenuItem setNumericShortcut(char c2, int n2) {
        if (this.i == c2 && this.j == n2) {
            return this;
        }
        this.i = c2;
        this.j = KeyEvent.normalizeMetaState((int)n2);
        this.a.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.i = c2;
        this.k = Character.toLowerCase(c3);
        this.a.b(false);
        return this;
    }

    @Override
    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.i = c2;
        this.j = KeyEvent.normalizeMetaState((int)n2);
        this.k = Character.toLowerCase(c3);
        this.l = KeyEvent.normalizeMetaState((int)n3);
        this.a.b(false);
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
        switch (n2 & 3) {
            default: {
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            }
            case 0: 
            case 1: 
            case 2: 
        }
        this.z = n2;
        this.a.b(this);
    }

    @Override
    public /* synthetic */ MenuItem setShowAsActionFlags(int n2) {
        return this.b(n2);
    }

    public MenuItem setTitle(int n2) {
        return this.setTitle(this.a.f().getString(n2));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f = charSequence;
        this.a.b(false);
        if (this.o != null) {
            this.o.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.g = charSequence;
        if (charSequence == null) {
            charSequence = this.f;
        }
        this.a.b(false);
        return this;
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return this.b(charSequence);
    }

    public MenuItem setVisible(boolean bl2) {
        if (this.c(bl2)) {
            this.a.a(this);
        }
        return this;
    }

    public String toString() {
        if (this.f != null) {
            return this.f.toString();
        }
        return null;
    }

}

