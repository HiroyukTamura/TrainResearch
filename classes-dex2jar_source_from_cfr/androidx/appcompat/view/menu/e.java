/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
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
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.ae;
import androidx.core.h.d;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e
extends m
implements View.OnKeyListener,
PopupWindow.OnDismissListener,
o {
    private static final int g = a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    final Handler a;
    final List<a> b = new ArrayList<a>();
    final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener(){

        public void onGlobalLayout() {
            if (e.this.d() && e.this.b.size() > 0 && !e.this.b.get((int)0).a.g()) {
                Object object = e.this.d;
                if (object != null && object.isShown()) {
                    object = e.this.b.iterator();
                    while (object.hasNext()) {
                        ((a)object.next()).a.a();
                    }
                } else {
                    e.this.c();
                }
            }
        }
    };
    View d;
    ViewTreeObserver e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private final List<h> m = new ArrayList<h>();
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener(){

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (e.this.e != null) {
                if (!e.this.e.isAlive()) {
                    e.this.e = view.getViewTreeObserver();
                }
                e.this.e.removeGlobalOnLayoutListener(e.this.c);
            }
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
    };
    private final ad o = new ad(){

        @Override
        public void a(h h2, MenuItem menuItem) {
            e.this.a.removeCallbacksAndMessages((Object)h2);
        }

        @Override
        public void b(h h2, MenuItem object) {
            a a2;
            int n2;
            block4 : {
                Handler handler = e.this.a;
                a2 = null;
                handler.removeCallbacksAndMessages(null);
                int n3 = e.this.b.size();
                for (n2 = 0; n2 < n3; ++n2) {
                    if (h2 != e.this.b.get((int)n2).b) {
                        continue;
                    }
                    break block4;
                }
                n2 = -1;
            }
            if (n2 == -1) {
                return;
            }
            if (++n2 < e.this.b.size()) {
                a2 = e.this.b.get(n2);
            }
            object = new Runnable((MenuItem)object, h2){
                final /* synthetic */ MenuItem b;
                final /* synthetic */ h c;
                {
                    this.b = menuItem;
                    this.c = h2;
                }

                @Override
                public void run() {
                    if (a2 != null) {
                        e.this.f = true;
                        a2.b.a(false);
                        e.this.f = false;
                    }
                    if (this.b.isEnabled() && this.b.hasSubMenu()) {
                        this.c.a(this.b, 4);
                    }
                }
            };
            long l2 = SystemClock.uptimeMillis();
            e.this.a.postAtTime((Runnable)object, (Object)h2, l2 + 200L);
        }

    };
    private int p = 0;
    private int q = 0;
    private View r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private o.a z;

    public e(Context context, View view, int n2, int n3, boolean bl2) {
        this.h = context;
        this.r = view;
        this.j = n2;
        this.k = n3;
        this.l = bl2;
        this.x = false;
        this.s = this.i();
        context = context.getResources();
        this.i = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(h h2, h h3) {
        int n2 = h2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            MenuItem menuItem = h2.getItem(i2);
            if (!menuItem.hasSubMenu() || h3 != menuItem.getSubMenu()) continue;
            return menuItem;
        }
        return null;
    }

    private View a(a object, h h2) {
        int n2;
        int n3;
        ListView listView;
        block8 : {
            if ((h2 = this.a(((a)object).b, h2)) == null) {
                return null;
            }
            listView = ((a)object).a();
            object = listView.getAdapter();
            boolean bl2 = object instanceof HeaderViewListAdapter;
            n3 = 0;
            if (bl2) {
                object = (HeaderViewListAdapter)object;
                n2 = object.getHeadersCount();
                object = (g)object.getWrappedAdapter();
            } else {
                object = (g)((Object)object);
                n2 = 0;
            }
            int n4 = ((g)((Object)object)).getCount();
            while (n3 < n4) {
                if (h2 != ((g)((Object)object)).a(n3)) {
                    ++n3;
                    continue;
                }
                break block8;
            }
            n3 = -1;
        }
        if (n3 == -1) {
            return null;
        }
        if ((n3 = n3 + n2 - listView.getFirstVisiblePosition()) >= 0) {
            if (n3 >= listView.getChildCount()) {
                return null;
            }
            return listView.getChildAt(n3);
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void c(h var1_1) {
        block14 : {
            block12 : {
                block13 : {
                    var9_2 = LayoutInflater.from((Context)this.h);
                    var6_3 = new g(var1_1, var9_2, this.l, e.g);
                    if (!this.d() && this.x) {
                        var6_3.a(true);
                    } else if (this.d()) {
                        var6_3.a(m.b(var1_1));
                    }
                    var3_8 = e.a((ListAdapter)var6_3, null, this.h, this.i);
                    var8_9 = this.h();
                    var8_9.a((ListAdapter)var6_3);
                    var8_9.g(var3_8);
                    var8_9.e(this.q);
                    if (this.b.size() > 0) {
                        var6_4 = this.b.get(this.b.size() - 1);
                        var7_10 = this.a(var6_4, var1_1);
                    } else {
                        var7_11 = var6_5 = null;
                    }
                    if (var7_12 == null) break block12;
                    var8_9.c(false);
                    var8_9.a((Object)null);
                    var2_15 = this.d(var3_8);
                    var4_16 = var2_15 == 1;
                    this.s = var2_15;
                    if (Build.VERSION.SDK_INT >= 26) {
                        var8_9.b((View)var7_12);
                        var2_15 = 0;
                        var5_17 = 0;
                    } else {
                        var10_18 = new int[2];
                        this.r.getLocationOnScreen(var10_18);
                        var11_19 = new int[2];
                        var7_12.getLocationOnScreen(var11_19);
                        if ((this.q & 7) == 5) {
                            var10_18[0] = var10_18[0] + this.r.getWidth();
                            var11_19[0] = var11_19[0] + var7_12.getWidth();
                        }
                        var5_17 = var11_19[0] - var10_18[0];
                        var2_15 = var11_19[1] - var10_18[1];
                    }
                    if ((this.q & 5) != 5) break block13;
                    if (var4_16) ** GOTO lbl45
                    var3_8 = var7_12.getWidth();
                    ** GOTO lbl-1000
                }
                if (var4_16) {
                    var3_8 = var7_12.getWidth();
lbl45: // 2 sources:
                    var3_8 = var5_17 + var3_8;
                } else lbl-1000: // 2 sources:
                {
                    var3_8 = var5_17 - var3_8;
                }
                var8_9.c(var3_8);
                var8_9.b(true);
                var8_9.d(var2_15);
                break block14;
            }
            if (this.t) {
                var8_9.c(this.v);
            }
            if (this.u) {
                var8_9.d(this.w);
            }
            var8_9.a(this.g());
        }
        var7_13 = new a(var8_9, var1_1, this.s);
        this.b.add(var7_13);
        var8_9.a();
        var7_14 = var8_9.e();
        var7_14.setOnKeyListener((View.OnKeyListener)this);
        if (var6_6 != null) return;
        if (this.y == false) return;
        if (var1_1.n() == null) return;
        var6_7 = (FrameLayout)var9_2.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)var7_14, false);
        var9_2 = (TextView)var6_7.findViewById(16908310);
        var6_7.setEnabled(false);
        var9_2.setText(var1_1.n());
        var7_14.addHeaderView((View)var6_7, null, false);
        var8_9.a();
    }

    private int d(int n2) {
        ListView listView = this.b.get(this.b.size() - 1).a();
        int[] arrn = new int[2];
        listView.getLocationOnScreen(arrn);
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        if (this.s == 1) {
            return arrn[0] + listView.getWidth() + n2 <= rect.right;
        }
        return arrn[0] - n2 < 0;
    }

    private int d(h h2) {
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (h2 != this.b.get((int)i2).b) continue;
            return i2;
        }
        return -1;
    }

    private ae h() {
        ae ae2 = new ae(this.h, null, this.j, this.k);
        ae2.a(this.o);
        ae2.a(this);
        ae2.a(this);
        ae2.b(this.r);
        ae2.e(this.q);
        ae2.a(true);
        ae2.h(2);
        return ae2;
    }

    private int i() {
        int n2 = t.f(this.r);
        int n3 = 1;
        if (n2 == 1) {
            n3 = 0;
        }
        return n3;
    }

    @Override
    public void a() {
        if (this.d()) {
            return;
        }
        Iterator<h> iterator = this.m.iterator();
        while (iterator.hasNext()) {
            this.c(iterator.next());
        }
        this.m.clear();
        this.d = this.r;
        if (this.d != null) {
            boolean bl2 = this.e == null;
            this.e = this.d.getViewTreeObserver();
            if (bl2) {
                this.e.addOnGlobalLayoutListener(this.c);
            }
            this.d.addOnAttachStateChangeListener(this.n);
        }
    }

    @Override
    public void a(int n2) {
        if (this.p != n2) {
            this.p = n2;
            this.q = d.a(n2, t.f(this.r));
        }
    }

    @Override
    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = d.a(this.p, t.f(this.r));
        }
    }

    @Override
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override
    public void a(h h2) {
        h2.a(this, this.h);
        if (this.d()) {
            this.c(h2);
            return;
        }
        this.m.add(h2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(h h2, boolean bl2) {
        int n2 = this.d(h2);
        if (n2 < 0) {
            return;
        }
        int n3 = n2 + 1;
        if (n3 < this.b.size()) {
            this.b.get((int)n3).b.a(false);
        }
        a a2 = this.b.remove(n2);
        a2.b.b(this);
        if (this.f) {
            a2.a.b(null);
            a2.a.b(0);
        }
        a2.a.c();
        n3 = this.b.size();
        n2 = n3 > 0 ? this.b.get((int)(n3 - 1)).c : this.i();
        this.s = n2;
        if (n3 == 0) {
            this.c();
            if (this.z != null) {
                this.z.a(h2, true);
            }
            if (this.e != null) {
                if (this.e.isAlive()) {
                    this.e.removeGlobalOnLayoutListener(this.c);
                }
                this.e = null;
            }
            this.d.removeOnAttachStateChangeListener(this.n);
            this.A.onDismiss();
            return;
        }
        if (bl2) {
            this.b.get((int)0).b.a(false);
        }
    }

    @Override
    public void a(o.a a2) {
        this.z = a2;
    }

    @Override
    public void a(boolean bl2) {
        Iterator<a> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            e.a(iterator.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override
    public boolean a(u u2) {
        for (a a2 : this.b) {
            if (u2 != a2.b) continue;
            a2.a().requestFocus();
            return true;
        }
        if (u2.hasVisibleItems()) {
            this.a((h)u2);
            if (this.z != null) {
                this.z.a(u2);
            }
            return true;
        }
        return false;
    }

    @Override
    public void b(int n2) {
        this.t = true;
        this.v = n2;
    }

    @Override
    public void b(boolean bl2) {
        this.x = bl2;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void c() {
        int n2 = this.b.size();
        if (n2 > 0) {
            a[] arra = this.b.toArray(new a[n2]);
            --n2;
            while (n2 >= 0) {
                a a2 = arra[n2];
                if (a2.a.d()) {
                    a2.a.c();
                }
                --n2;
            }
        }
    }

    @Override
    public void c(int n2) {
        this.u = true;
        this.w = n2;
    }

    @Override
    public void c(boolean bl2) {
        this.y = bl2;
    }

    @Override
    public boolean d() {
        boolean bl2;
        int n2 = this.b.size();
        boolean bl3 = bl2 = false;
        if (n2 > 0) {
            bl3 = bl2;
            if (this.b.get((int)0).a.d()) {
                bl3 = true;
            }
        }
        return bl3;
    }

    @Override
    public ListView e() {
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.get(this.b.size() - 1).a();
    }

    @Override
    protected boolean f() {
        return false;
    }

    public void onDismiss() {
        a a2;
        block3 : {
            int n2 = this.b.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                a2 = this.b.get(i2);
                if (a2.a.d()) {
                    continue;
                }
                break block3;
            }
            a2 = null;
        }
        if (a2 != null) {
            a2.b.a(false);
        }
    }

    public boolean onKey(View view, int n2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n2 == 82) {
            this.c();
            return true;
        }
        return false;
    }

    private static class a {
        public final ae a;
        public final h b;
        public final int c;

        public a(ae ae2, h h2, int n2) {
            this.a = ae2;
            this.b = h2;
            this.c = n2;
        }

        public ListView a() {
            return this.a.e();
        }
    }

}

