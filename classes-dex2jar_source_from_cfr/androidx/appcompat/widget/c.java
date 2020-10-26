/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.IBinder
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.SparseBooleanArray
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.aq;
import androidx.core.h.b;
import java.util.ArrayList;

class c
extends androidx.appcompat.view.menu.b
implements b.a {
    private b A;
    d g;
    e h;
    a i;
    c j;
    final f k = new f();
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private View z;

    public c(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup)this.f;
        if (viewGroup == null) {
            return null;
        }
        int n2 = viewGroup.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = viewGroup.getChildAt(i2);
            if (!(view instanceof p.a) || ((p.a)view).getItemData() != menuItem) continue;
            return view;
        }
        return null;
    }

    @Override
    public View a(j object, View view, ViewGroup viewGroup) {
        View view2 = ((j)object).getActionView();
        if (view2 == null || ((j)object).n()) {
            view2 = super.a((j)object, view, viewGroup);
        }
        int n2 = ((j)object).isActionViewExpanded() ? 8 : 0;
        view2.setVisibility(n2);
        object = (ActionMenuView)viewGroup;
        view = view2.getLayoutParams();
        if (!((ActionMenuView)object).checkLayoutParams((ViewGroup.LayoutParams)view)) {
            view2.setLayoutParams((ViewGroup.LayoutParams)((ActionMenuView)object).a((ViewGroup.LayoutParams)view));
        }
        return view2;
    }

    @Override
    public p a(ViewGroup object) {
        p p2 = this.f;
        if (p2 != (object = super.a((ViewGroup)object))) {
            ((ActionMenuView)object).setPresenter(this);
        }
        return object;
    }

    @Override
    public void a(Context object, h h2) {
        super.a((Context)object, h2);
        h2 = object.getResources();
        object = androidx.appcompat.view.a.a((Context)object);
        if (!this.p) {
            this.o = ((androidx.appcompat.view.a)object).b();
        }
        if (!this.v) {
            this.q = ((androidx.appcompat.view.a)object).c();
        }
        if (!this.t) {
            this.s = ((androidx.appcompat.view.a)object).a();
        }
        int n2 = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                this.g.measure(n3, n3);
            }
            n2 -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = n2;
        this.x = (int)(h2.getDisplayMetrics().density * 56.0f);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(Drawable drawable2) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable2);
            return;
        }
        this.n = true;
        this.m = drawable2;
    }

    @Override
    public void a(h h2, boolean bl2) {
        this.f();
        super.a(h2, bl2);
    }

    @Override
    public void a(j object, p.a a2) {
        a2.a((j)object, 0);
        object = (ActionMenuView)this.f;
        a2 = (ActionMenuItemView)a2;
        ((ActionMenuItemView)a2).setItemInvoker((h.b)object);
        if (this.A == null) {
            this.A = new b();
        }
        ((ActionMenuItemView)a2).setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    @Override
    public void a(boolean bl2) {
        int n2;
        int n3;
        super.a(bl2);
        ((View)this.f).requestLayout();
        Object object = this.c;
        int n4 = 0;
        if (object != null) {
            object = this.c.l();
            n2 = object.size();
            for (n3 = 0; n3 < n2; ++n3) {
                androidx.core.h.b b2 = object.get(n3).a();
                if (b2 == null) continue;
                b2.a(this);
            }
        }
        object = this.c != null ? this.c.m() : null;
        n3 = n4;
        if (this.o) {
            n3 = n4;
            if (object != null) {
                n2 = object.size();
                if (n2 == 1) {
                    n3 = ((j)object.get(0)).isActionViewExpanded() ^ true;
                } else {
                    n3 = n4;
                    if (n2 > 0) {
                        n3 = 1;
                    }
                }
            }
        }
        if (n3 != 0) {
            if (this.g == null) {
                this.g = new d(this.a);
            }
            if ((object = (ViewGroup)this.g.getParent()) != this.f) {
                if (object != null) {
                    object.removeView((View)this.g);
                }
                object = (ActionMenuView)this.f;
                object.addView((View)this.g, (ViewGroup.LayoutParams)object.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup)this.f).removeView((View)this.g);
        }
        ((ActionMenuView)this.f).setOverflowReserved(this.o);
    }

    @Override
    public boolean a(int n2, j j2) {
        return j2.j();
    }

    @Override
    public boolean a(ViewGroup viewGroup, int n2) {
        if (viewGroup.getChildAt(n2) == this.g) {
            return false;
        }
        return super.a(viewGroup, n2);
    }

    @Override
    public boolean a(u u2) {
        boolean bl2 = u2.hasVisibleItems();
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        u u3 = u2;
        while (u3.t() != this.c) {
            u3 = (u)u3.t();
        }
        if ((u3 = this.a(u3.getItem())) == null) {
            return false;
        }
        this.l = u2.getItem().getItemId();
        int n2 = u2.size();
        int n3 = 0;
        do {
            bl2 = bl3;
            if (n3 >= n2) break;
            MenuItem menuItem = u2.getItem(n3);
            if (menuItem.isVisible() && menuItem.getIcon() != null) {
                bl2 = true;
                break;
            }
            ++n3;
        } while (true);
        this.i = new a(this.b, u2, (View)u3);
        this.i.a(bl2);
        this.i.a();
        super.a(u2);
        return true;
    }

    public void b(boolean bl2) {
        this.o = bl2;
        this.p = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean b() {
        int n2;
        Object object;
        int n3;
        ArrayList<j> arrayList;
        j j2;
        int n4;
        ViewGroup viewGroup;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        block39 : {
            block40 : {
                object = this;
                if (((c)object).c != null) {
                    arrayList = ((c)object).c.j();
                    n8 = arrayList.size();
                } else {
                    arrayList = null;
                    n8 = 0;
                }
                n7 = ((c)object).s;
                n3 = ((c)object).r;
                n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                viewGroup = (ViewGroup)((c)object).f;
                n2 = 0;
                n9 = 0;
                n6 = 0;
                for (n5 = 0; n5 < n8; ++n5) {
                    j2 = arrayList.get(n5);
                    if (j2.l()) {
                        ++n2;
                    } else if (j2.k()) {
                        ++n6;
                    } else {
                        n9 = 1;
                    }
                    n10 = n7;
                    if (((c)object).w) {
                        n10 = n7;
                        if (j2.isActionViewExpanded()) {
                            n10 = 0;
                        }
                    }
                    n7 = n10;
                }
                n5 = n7;
                if (!((c)object).o) break block39;
                if (n9 != 0) break block40;
                n5 = n7;
                if (n6 + n2 <= n7) break block39;
            }
            n5 = n7 - 1;
        }
        n7 = n5 - n2;
        j2 = ((c)object).y;
        j2.clear();
        if (((c)object).u) {
            n5 = n3 / ((c)object).x;
            n6 = ((c)object).x;
            n2 = ((c)object).x;
            n9 = n3 % n6 / n5 + n2;
        } else {
            n5 = 0;
            n9 = 0;
        }
        n2 = n3;
        n3 = 0;
        n6 = 0;
        n10 = n8;
        do {
            View view;
            object = this;
            if (n3 >= n10) {
                return true;
            }
            j j3 = arrayList.get(n3);
            if (j3.l()) {
                view = ((c)object).a(j3, ((c)object).z, viewGroup);
                if (((c)object).z == null) {
                    ((c)object).z = view;
                }
                if (((c)object).u) {
                    n5 -= ActionMenuView.a(view, n9, n5, n4, 0);
                } else {
                    view.measure(n4, n4);
                }
                n8 = view.getMeasuredWidth();
                n2 -= n8;
                if (n6 == 0) {
                    n6 = n8;
                }
                if ((n8 = j3.getGroupId()) != 0) {
                    j2.put(n8, true);
                }
                j3.d(true);
            } else if (j3.k()) {
                int n11;
                int n12 = j3.getGroupId();
                boolean bl2 = j2.get(n12);
                int n13 = !(n7 <= 0 && !bl2 || n2 <= 0 || ((c)object).u && n5 <= 0) ? 1 : 0;
                if (n13 != 0) {
                    view = ((c)object).a(j3, ((c)object).z, viewGroup);
                    if (((c)object).z == null) {
                        ((c)object).z = view;
                    }
                    if (((c)object).u) {
                        n11 = ActionMenuView.a(view, n9, n5, n4, 0);
                        n5 = n8 = n5 - n11;
                        if (n11 == 0) {
                            n13 = 0;
                            n5 = n8;
                        }
                    } else {
                        view.measure(n4, n4);
                    }
                    n11 = view.getMeasuredWidth();
                    n2 -= n11;
                    n8 = n6;
                    if (n6 == 0) {
                        n8 = n11;
                    }
                    n6 = (((c)object).u ? n2 >= 0 : n2 + n8 > 0) ? 1 : 0;
                    n13 &= n6;
                    n6 = n8;
                }
                if (n13 != 0 && n12 != 0) {
                    j2.put(n12, true);
                    n8 = n7;
                } else {
                    n8 = n7;
                    if (bl2) {
                        j2.put(n12, false);
                        n11 = 0;
                        do {
                            n8 = n7;
                            if (n11 >= n3) break;
                            object = arrayList.get(n11);
                            n8 = n7;
                            if (((j)object).getGroupId() == n12) {
                                n8 = n7;
                                if (((j)object).j()) {
                                    n8 = n7 + 1;
                                }
                                ((j)object).d(false);
                            }
                            ++n11;
                            n7 = n8;
                        } while (true);
                    }
                }
                n7 = n8;
                if (n13 != 0) {
                    n7 = n8 - 1;
                }
                j3.d((boolean)n13);
            } else {
                j3.d(false);
            }
            ++n3;
        } while (true);
    }

    public Drawable c() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public void c(boolean bl2) {
        this.w = bl2;
    }

    @Override
    public void d(boolean bl2) {
        if (bl2) {
            super.a((u)null);
            return;
        }
        if (this.c != null) {
            this.c.a(false);
        }
    }

    public boolean d() {
        if (this.o && !this.h() && this.c != null && this.f != null && this.j == null && !this.c.m().isEmpty()) {
            this.j = new c(new e(this.b, this.c, (View)this.g, true));
            ((View)this.f).post((Runnable)this.j);
            super.a((u)null);
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.j != null && this.f != null) {
            ((View)this.f).removeCallbacks((Runnable)this.j);
            this.j = null;
            return true;
        }
        e e2 = this.h;
        if (e2 != null) {
            e2.d();
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.e() | this.g();
    }

    public boolean g() {
        if (this.i != null) {
            this.i.d();
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.h != null && this.h.f();
    }

    public boolean i() {
        return this.j != null || this.h();
        {
        }
    }

    private class a
    extends n {
        public a(Context object, u u2, View view) {
            super((Context)object, u2, view, false, a.a.actionOverflowMenuStyle);
            if (!((j)u2.getItem()).j()) {
                object = c.this.g == null ? (View)c.this.f : c.this.g;
                this.a((View)object);
            }
            this.a(c.this.k);
        }

        @Override
        protected void e() {
            c.this.i = null;
            c.this.l = 0;
            super.e();
        }
    }

    private class b
    extends ActionMenuItemView.b {
        b() {
        }

        @Override
        public s a() {
            if (c.this.i != null) {
                return c.this.i.b();
            }
            return null;
        }
    }

    private class c
    implements Runnable {
        private e b;

        public c(e e2) {
            this.b = e2;
        }

        @Override
        public void run() {
            View view;
            if (c.this.c != null) {
                c.this.c.g();
            }
            if ((view = (View)c.this.f) != null && view.getWindowToken() != null && this.b.c()) {
                c.this.h = this.b;
            }
            c.this.j = null;
        }
    }

    private class d
    extends AppCompatImageView
    implements ActionMenuView.a {
        private final float[] b;

        public d(Context context) {
            super(context, null, a.a.actionOverflowButtonStyle);
            this.b = new float[2];
            this.setClickable(true);
            this.setFocusable(true);
            this.setVisibility(0);
            this.setEnabled(true);
            aq.a((View)this, this.getContentDescription());
            this.setOnTouchListener((View.OnTouchListener)new aa((View)this){

                @Override
                public s a() {
                    if (c.this.h == null) {
                        return null;
                    }
                    return c.this.h.b();
                }

                @Override
                public boolean b() {
                    c.this.d();
                    return true;
                }

                @Override
                public boolean c() {
                    if (c.this.j != null) {
                        return false;
                    }
                    c.this.e();
                    return true;
                }
            });
        }

        @Override
        public boolean c() {
            return false;
        }

        @Override
        public boolean d() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            this.playSoundEffect(0);
            c.this.d();
            return true;
        }

        protected boolean setFrame(int n2, int n3, int n4, int n5) {
            boolean bl2 = super.setFrame(n2, n3, n4, n5);
            Drawable drawable2 = this.getDrawable();
            Drawable drawable3 = this.getBackground();
            if (drawable2 != null && drawable3 != null) {
                int n6 = this.getWidth();
                n3 = this.getHeight();
                n2 = Math.max(n6, n3) / 2;
                int n7 = this.getPaddingLeft();
                int n8 = this.getPaddingRight();
                n4 = this.getPaddingTop();
                n5 = this.getPaddingBottom();
                n6 = (n6 + (n7 - n8)) / 2;
                n3 = (n3 + (n4 - n5)) / 2;
                androidx.core.graphics.drawable.a.a(drawable3, n6 - n2, n3 - n2, n6 + n2, n3 + n2);
            }
            return bl2;
        }

    }

    private class e
    extends n {
        public e(Context context, h h2, View view, boolean bl2) {
            super(context, h2, view, bl2, a.a.actionOverflowMenuStyle);
            this.a(8388613);
            this.a(c.this.k);
        }

        @Override
        protected void e() {
            if (c.this.c != null) {
                c.this.c.close();
            }
            c.this.h = null;
            super.e();
        }
    }

    private class f
    implements o.a {
        f() {
        }

        @Override
        public void a(h h2, boolean bl2) {
            o.a a2;
            if (h2 instanceof u) {
                h2.q().a(false);
            }
            if ((a2 = c.this.a()) != null) {
                a2.a(h2, bl2);
            }
        }

        @Override
        public boolean a(h h2) {
            boolean bl2 = false;
            if (h2 == null) {
                return false;
            }
            c.this.l = ((u)h2).getItem().getItemId();
            o.a a2 = c.this.a();
            if (a2 != null) {
                bl2 = a2.a(h2);
            }
            return bl2;
        }
    }

}

