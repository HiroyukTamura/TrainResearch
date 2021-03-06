/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.w;
import androidx.core.h.t;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;

public class ap
implements w {
    Toolbar a;
    CharSequence b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private c n;
    private int o = 0;
    private int p = 0;
    private Drawable q;

    public ap(Toolbar toolbar, boolean bl2) {
        this(toolbar, bl2, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public ap(Toolbar object, boolean bl2, int n2, int n3) {
        this.a = object;
        this.b = ((Toolbar)((Object)object)).getTitle();
        this.l = ((Toolbar)((Object)object)).getSubtitle();
        boolean bl3 = this.b != null;
        this.k = bl3;
        this.j = ((Toolbar)((Object)object)).getNavigationIcon();
        object = ao.a(object.getContext(), null, a.j.ActionBar, a.a.actionBarStyle, 0);
        this.q = ((ao)object).a(a.j.ActionBar_homeAsUpIndicator);
        if (bl2) {
            CharSequence charSequence = ((ao)object).c(a.j.ActionBar_title);
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                this.b(charSequence);
            }
            if (!TextUtils.isEmpty((CharSequence)(charSequence = ((ao)object).c(a.j.ActionBar_subtitle)))) {
                this.c(charSequence);
            }
            if ((charSequence = ((ao)object).a(a.j.ActionBar_logo)) != null) {
                this.b((Drawable)charSequence);
            }
            if ((charSequence = ((ao)object).a(a.j.ActionBar_icon)) != null) {
                this.a((Drawable)charSequence);
            }
            if (this.j == null && this.q != null) {
                this.c(this.q);
            }
            this.c(((ao)object).a(a.j.ActionBar_displayOptions, 0));
            n3 = ((ao)object).g(a.j.ActionBar_customNavigationLayout, 0);
            if (n3 != 0) {
                this.a(LayoutInflater.from((Context)this.a.getContext()).inflate(n3, (ViewGroup)this.a, false));
                this.c(this.e | 16);
            }
            if ((n3 = ((ao)object).f(a.j.ActionBar_height, 0)) > 0) {
                charSequence = this.a.getLayoutParams();
                ((ViewGroup.LayoutParams)charSequence).height = n3;
                this.a.setLayoutParams((ViewGroup.LayoutParams)charSequence);
            }
            n3 = ((ao)object).d(a.j.ActionBar_contentInsetStart, -1);
            int n4 = ((ao)object).d(a.j.ActionBar_contentInsetEnd, -1);
            if (n3 >= 0 || n4 >= 0) {
                this.a.a(Math.max(n3, 0), Math.max(n4, 0));
            }
            if ((n3 = ((ao)object).g(a.j.ActionBar_titleTextStyle, 0)) != 0) {
                this.a.a(this.a.getContext(), n3);
            }
            if ((n3 = ((ao)object).g(a.j.ActionBar_subtitleTextStyle, 0)) != 0) {
                this.a.b(this.a.getContext(), n3);
            }
            if ((n3 = ((ao)object).g(a.j.ActionBar_popupTheme, 0)) != 0) {
                this.a.setPopupTheme(n3);
            }
        } else {
            this.e = this.r();
        }
        ((ao)object).a();
        this.e(n2);
        this.m = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new View.OnClickListener(){
            final androidx.appcompat.view.menu.a a;
            {
                this.a = new androidx.appcompat.view.menu.a(ap.this.a.getContext(), 0, 16908332, 0, 0, ap.this.b);
            }

            public void onClick(View view) {
                if (ap.this.c != null && ap.this.d) {
                    ap.this.c.onMenuItemSelected(0, (MenuItem)this.a);
                }
            }
        });
    }

    private void e(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private int r() {
        if (this.a.getNavigationIcon() != null) {
            this.q = this.a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    private void s() {
        Drawable drawable2 = (this.e & 2) != 0 ? ((this.e & 1) != 0 && this.i != null ? this.i : this.h) : null;
        this.a.setLogo(drawable2);
    }

    private void t() {
        Toolbar toolbar;
        Drawable drawable2;
        if ((this.e & 4) != 0) {
            toolbar = this.a;
            drawable2 = this.j != null ? this.j : this.q;
        } else {
            toolbar = this.a;
            drawable2 = null;
        }
        toolbar.setNavigationIcon(drawable2);
    }

    private void u() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty((CharSequence)this.m)) {
                this.a.setNavigationContentDescription(this.p);
                return;
            }
            this.a.setNavigationContentDescription(this.m);
        }
    }

    @Override
    public ViewGroup a() {
        return this.a;
    }

    @Override
    public x a(final int n2, long l2) {
        x x2 = t.m((View)this.a);
        float f2 = n2 == 0 ? 1.0f : 0.0f;
        return x2.a(f2).a(l2).a(new z(){
            private boolean c = false;

            @Override
            public void a(View view) {
                ap.this.a.setVisibility(0);
            }

            @Override
            public void b(View view) {
                if (!this.c) {
                    ap.this.a.setVisibility(n2);
                }
            }

            @Override
            public void c(View view) {
                this.c = true;
            }
        });
    }

    @Override
    public void a(int n2) {
        Drawable drawable2 = n2 != 0 ? androidx.appcompat.a.a.a.b(this.b(), n2) : null;
        this.a(drawable2);
    }

    @Override
    public void a(Drawable drawable2) {
        this.h = drawable2;
        this.s();
    }

    @Override
    public void a(Menu menu, o.a a2) {
        if (this.n == null) {
            this.n = new c(this.a.getContext());
            this.n.a(a.f.action_menu_presenter);
        }
        this.n.a(a2);
        this.a.a((h)menu, this.n);
    }

    public void a(View view) {
        if (this.g != null && (this.e & 16) != 0) {
            this.a.removeView(this.g);
        }
        this.g = view;
        if (view != null && (this.e & 16) != 0) {
            this.a.addView(this.g);
        }
    }

    @Override
    public void a(Window.Callback callback) {
        this.c = callback;
    }

    @Override
    public void a(o.a a2, h.a a3) {
        this.a.a(a2, a3);
    }

    @Override
    public void a(ah ah2) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = ah2;
        if (ah2 != null && this.o == 2) {
            this.a.addView(this.f, 0);
            Toolbar.b b2 = (Toolbar.b)this.f.getLayoutParams();
            b2.width = -2;
            b2.height = -2;
            b2.a = 8388691;
            ah2.setAllowCollapse(true);
        }
    }

    @Override
    public void a(CharSequence charSequence) {
        if (!this.k) {
            this.e(charSequence);
        }
    }

    @Override
    public void a(boolean bl2) {
        this.a.setCollapsible(bl2);
    }

    @Override
    public Context b() {
        return this.a.getContext();
    }

    @Override
    public void b(int n2) {
        Drawable drawable2 = n2 != 0 ? androidx.appcompat.a.a.a.b(this.b(), n2) : null;
        this.b(drawable2);
    }

    public void b(Drawable drawable2) {
        this.i = drawable2;
        this.s();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        this.e(charSequence);
    }

    @Override
    public void b(boolean bl2) {
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void c(int n2) {
        int n3 = this.e ^ n2;
        this.e = n2;
        if (n3 != 0) {
            if ((n3 & 4) != 0) {
                if ((n2 & 4) != 0) {
                    this.u();
                }
                this.t();
            }
            if ((n3 & 3) != 0) {
                this.s();
            }
            if ((n3 & 8) != 0) {
                CharSequence charSequence;
                Toolbar toolbar;
                if ((n2 & 8) != 0) {
                    this.a.setTitle(this.b);
                    toolbar = this.a;
                    charSequence = this.l;
                } else {
                    toolbar = this.a;
                    charSequence = null;
                    toolbar.setTitle(null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((n3 & 16) != 0 && this.g != null) {
                if ((n2 & 16) != 0) {
                    this.a.addView(this.g);
                    return;
                }
                this.a.removeView(this.g);
            }
        }
    }

    public void c(Drawable drawable2) {
        this.j = drawable2;
        this.t();
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    @Override
    public boolean c() {
        return this.a.g();
    }

    @Override
    public void d() {
        this.a.h();
    }

    @Override
    public void d(int n2) {
        this.a.setVisibility(n2);
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        this.u();
    }

    @Override
    public CharSequence e() {
        return this.a.getTitle();
    }

    public void e(int n2) {
        if (n2 == this.p) {
            return;
        }
        this.p = n2;
        if (TextUtils.isEmpty((CharSequence)this.a.getNavigationContentDescription())) {
            this.f(this.p);
        }
    }

    @Override
    public void f() {
        Log.i((String)"ToolbarWidgetWrapper", (String)"Progress display unsupported");
    }

    public void f(int n2) {
        String string2 = n2 == 0 ? null : this.b().getString(n2);
        this.d(string2);
    }

    @Override
    public void g() {
        Log.i((String)"ToolbarWidgetWrapper", (String)"Progress display unsupported");
    }

    @Override
    public boolean h() {
        return this.a.a();
    }

    @Override
    public boolean i() {
        return this.a.b();
    }

    @Override
    public boolean j() {
        return this.a.c();
    }

    @Override
    public boolean k() {
        return this.a.d();
    }

    @Override
    public boolean l() {
        return this.a.e();
    }

    @Override
    public void m() {
        this.d = true;
    }

    @Override
    public void n() {
        this.a.f();
    }

    @Override
    public int o() {
        return this.e;
    }

    @Override
    public int p() {
        return this.o;
    }

    @Override
    public Menu q() {
        return this.a.getMenu();
    }

}

