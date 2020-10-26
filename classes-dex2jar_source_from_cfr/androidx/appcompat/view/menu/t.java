/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.Gravity
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ae;

final class t
extends m
implements View.OnKeyListener,
AdapterView.OnItemClickListener,
PopupWindow.OnDismissListener,
o {
    private static final int e = a.g.abc_popup_menu_item_layout;
    final ae a;
    final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener(){

        public void onGlobalLayout() {
            if (t.this.d() && !t.this.a.g()) {
                View view = t.this.c;
                if (view != null && view.isShown()) {
                    t.this.a.a();
                    return;
                }
                t.this.c();
            }
        }
    };
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final h g;
    private final g h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener(){

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (t.this.d != null) {
                if (!t.this.d.isAlive()) {
                    t.this.d = view.getViewTreeObserver();
                }
                t.this.d.removeGlobalOnLayoutListener(t.this.b);
            }
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
    };
    private PopupWindow.OnDismissListener n;
    private View o;
    private o.a p;
    private boolean q;
    private boolean r;
    private int s;
    private int t = 0;
    private boolean u;

    public t(Context context, h h2, View view, int n2, int n3, boolean bl2) {
        this.f = context;
        this.g = h2;
        this.i = bl2;
        this.h = new g(h2, LayoutInflater.from((Context)context), this.i, e);
        this.k = n2;
        this.l = n3;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.o = view;
        this.a = new ae(this.f, null, this.k, this.l);
        h2.a(this, context);
    }

    private boolean h() {
        if (this.d()) {
            return true;
        }
        if (!this.q) {
            if (this.o == null) {
                return false;
            }
            this.c = this.o;
            this.a.a(this);
            this.a.a(this);
            this.a.a(true);
            View view = this.c;
            boolean bl2 = this.d == null;
            this.d = view.getViewTreeObserver();
            if (bl2) {
                this.d.addOnGlobalLayoutListener(this.b);
            }
            view.addOnAttachStateChangeListener(this.m);
            this.a.b(view);
            this.a.e(this.t);
            if (!this.r) {
                this.s = t.a((ListAdapter)this.h, null, this.f, this.j);
                this.r = true;
            }
            this.a.g(this.s);
            this.a.h(2);
            this.a.a(this.g());
            this.a.a();
            view = this.a.e();
            view.setOnKeyListener((View.OnKeyListener)this);
            if (this.u && this.g.n() != null) {
                FrameLayout frameLayout = (FrameLayout)LayoutInflater.from((Context)this.f).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)view, false);
                TextView textView = (TextView)frameLayout.findViewById(16908310);
                if (textView != null) {
                    textView.setText(this.g.n());
                }
                frameLayout.setEnabled(false);
                view.addHeaderView((View)frameLayout, null, false);
            }
            this.a.a((ListAdapter)this.h);
            this.a.a();
            return true;
        }
        return false;
    }

    @Override
    public void a() {
        if (this.h()) {
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override
    public void a(int n2) {
        this.t = n2;
    }

    @Override
    public void a(View view) {
        this.o = view;
    }

    @Override
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override
    public void a(h h2) {
    }

    @Override
    public void a(h h2, boolean bl2) {
        if (h2 != this.g) {
            return;
        }
        this.c();
        if (this.p != null) {
            this.p.a(h2, bl2);
        }
    }

    @Override
    public void a(o.a a2) {
        this.p = a2;
    }

    @Override
    public void a(boolean bl2) {
        this.r = false;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override
    public boolean a(u u2) {
        if (u2.hasVisibleItems()) {
            n n2 = new n(this.f, u2, this.c, this.i, this.k, this.l);
            n2.a(this.p);
            n2.a(m.b(u2));
            n2.a(this.n);
            this.n = null;
            this.g.a(false);
            int n3 = this.a.j();
            int n4 = this.a.k();
            int n5 = n3;
            if ((Gravity.getAbsoluteGravity((int)this.t, (int)androidx.core.h.t.f(this.o)) & 7) == 5) {
                n5 = n3 + this.o.getWidth();
            }
            if (n2.a(n5, n4)) {
                if (this.p != null) {
                    this.p.a(u2);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void b(int n2) {
        this.a.c(n2);
    }

    @Override
    public void b(boolean bl2) {
        this.h.a(bl2);
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void c() {
        if (this.d()) {
            this.a.c();
        }
    }

    @Override
    public void c(int n2) {
        this.a.d(n2);
    }

    @Override
    public void c(boolean bl2) {
        this.u = bl2;
    }

    @Override
    public boolean d() {
        return !this.q && this.a.d();
    }

    @Override
    public ListView e() {
        return this.a.e();
    }

    public void onDismiss() {
        this.q = true;
        this.g.close();
        if (this.d != null) {
            if (!this.d.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        if (this.n != null) {
            this.n.onDismiss();
        }
    }

    public boolean onKey(View view, int n2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n2 == 82) {
            this.c();
            return true;
        }
        return false;
    }

}

