/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.w;
import androidx.core.h.aa;
import androidx.core.h.t;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l
extends androidx.appcompat.app.a
implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s;
    private static final Interpolator t;
    private static final Interpolator u;
    private boolean A;
    private boolean B;
    private ArrayList<a.b> C = new ArrayList();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = true;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    w d;
    ActionBarContextView e;
    View f;
    ah g;
    a h;
    b i;
    b.a j;
    boolean k = true;
    boolean l;
    boolean m;
    androidx.appcompat.view.h n;
    boolean o;
    final y p = new z(){

        @Override
        public void b(View view) {
            if (l.this.k && l.this.f != null) {
                l.this.f.setTranslationY(0.0f);
                l.this.c.setTranslationY(0.0f);
            }
            l.this.c.setVisibility(8);
            l.this.c.setTransitioning(false);
            l.this.n = null;
            l.this.h();
            if (l.this.b != null) {
                t.q((View)l.this.b);
            }
        }
    };
    final y q = new z(){

        @Override
        public void b(View view) {
            l.this.n = null;
            l.this.c.requestLayout();
        }
    };
    final aa r = new aa(){

        @Override
        public void a(View view) {
            ((View)l.this.c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList();
    private int z = -1;

    static {
        s = l.class.desiredAssertionStatus() ^ true;
        t = new AccelerateInterpolator();
        u = new DecelerateInterpolator();
    }

    public l(Activity activity, boolean bl2) {
        this.w = activity;
        activity = activity.getWindow().getDecorView();
        this.a((View)activity);
        if (!bl2) {
            this.f = activity.findViewById(16908290);
        }
    }

    public l(Dialog dialog) {
        this.x = dialog;
        this.a(dialog.getWindow().getDecorView());
    }

    private void a(View object) {
        this.b = (ActionBarOverlayLayout)object.findViewById(a.f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = this.b(object.findViewById(a.f.action_bar));
        this.e = (ActionBarContextView)object.findViewById(a.f.action_context_bar);
        this.c = (ActionBarContainer)object.findViewById(a.f.action_bar_container);
        if (this.d != null && this.e != null && this.c != null) {
            this.a = this.d.b();
            int n2 = (this.d.o() & 4) != 0 ? 1 : 0;
            if (n2 != 0) {
                this.A = true;
            }
            boolean bl2 = ((androidx.appcompat.view.a)(object = androidx.appcompat.view.a.a(this.a))).f() || n2 != 0;
            this.b(bl2);
            this.l(((androidx.appcompat.view.a)object).d());
            object = this.a.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
            if (object.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
                this.c(true);
            }
            if ((n2 = object.getDimensionPixelSize(a.j.ActionBar_elevation, 0)) != 0) {
                this.a((float)n2);
            }
            object.recycle();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(this.getClass().getSimpleName());
        ((StringBuilder)object).append(" can only be used ");
        ((StringBuilder)object).append("with a compatible window decor layout");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    static boolean a(boolean bl2, boolean bl3, boolean bl4) {
        if (bl4) {
            return true;
        }
        return !bl2 && !bl3;
        {
        }
    }

    private w b(View object) {
        if (object instanceof w) {
            return (w)object;
        }
        if (object instanceof Toolbar) {
            return ((Toolbar)((Object)object)).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        object = object != null ? object.getClass().getSimpleName() : "null";
        stringBuilder.append((String)object);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void l(boolean bl2) {
        this.D = bl2;
        if (!this.D) {
            this.d.a((ah)null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        }
        int n2 = this.i();
        boolean bl3 = true;
        n2 = n2 == 2 ? 1 : 0;
        if (this.g != null) {
            if (n2 != 0) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    t.q((View)this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        Object object = this.d;
        bl2 = !this.D && n2 != 0;
        object.a(bl2);
        object = this.b;
        bl2 = !this.D && n2 != 0 ? bl3 : false;
        ((ActionBarOverlayLayout)object).setHasNonEmbeddedTabs(bl2);
    }

    private void m(boolean bl2) {
        if (l.a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                this.i(bl2);
                return;
            }
        } else if (this.G) {
            this.G = false;
            this.j(bl2);
        }
    }

    private void n() {
        if (!this.F) {
            this.F = true;
            if (this.b != null) {
                this.b.setShowingForActionMode(true);
            }
            this.m(false);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            this.m(false);
        }
    }

    private boolean p() {
        return t.y((View)this.c);
    }

    @Override
    public int a() {
        return this.d.o();
    }

    @Override
    public b a(b.a object) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        object = new a(this.e.getContext(), (b.a)object);
        if (((a)object).e()) {
            this.h = object;
            ((a)object).d();
            this.e.a((b)object);
            this.k(true);
            this.e.sendAccessibilityEvent(32);
            return object;
        }
        return null;
    }

    @Override
    public void a(float f2) {
        t.c((View)this.c, f2);
    }

    @Override
    public void a(int n2) {
        this.E = n2;
    }

    public void a(int n2, int n3) {
        int n4 = this.d.o();
        if ((n3 & 4) != 0) {
            this.A = true;
        }
        this.d.c(n2 & n3 | n3 & n4);
    }

    @Override
    public void a(Configuration configuration) {
        this.l(androidx.appcompat.view.a.a(this.a).d());
    }

    @Override
    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        int n2 = bl2 ? 8 : 0;
        this.a(n2, 8);
    }

    @Override
    public boolean a(int n2, KeyEvent keyEvent) {
        if (this.h == null) {
            return false;
        }
        Menu menu = this.h.b();
        if (menu != null) {
            int n3 = keyEvent != null ? keyEvent.getDeviceId() : -1;
            n3 = KeyCharacterMap.load((int)n3).getKeyboardType();
            boolean bl2 = true;
            if (n3 == 1) {
                bl2 = false;
            }
            menu.setQwertyMode(bl2);
            return menu.performShortcut(n2, keyEvent, 0);
        }
        return false;
    }

    @Override
    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
            int n2 = typedValue.resourceId;
            this.v = n2 != 0 ? new ContextThemeWrapper(this.a, n2) : this.a;
        }
        return this.v;
    }

    @Override
    public void b(boolean bl2) {
        this.d.b(bl2);
    }

    @Override
    public void c(boolean bl2) {
        if (bl2 && !this.b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = bl2;
        this.b.setHideOnContentScrollEnabled(bl2);
    }

    @Override
    public void d(boolean bl2) {
        if (!this.A) {
            this.g(bl2);
        }
    }

    @Override
    public void e(boolean bl2) {
        this.H = bl2;
        if (!bl2 && this.n != null) {
            this.n.c();
        }
    }

    @Override
    public void f(boolean bl2) {
        if (bl2 == this.B) {
            return;
        }
        this.B = bl2;
        int n2 = this.C.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.C.get(i2).a(bl2);
        }
    }

    @Override
    public boolean f() {
        if (this.d != null && this.d.c()) {
            this.d.d();
            return true;
        }
        return false;
    }

    public void g(boolean bl2) {
        int n2 = bl2 ? 4 : 0;
        this.a(n2, 4);
    }

    void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    @Override
    public void h(boolean bl2) {
        this.k = bl2;
    }

    public int i() {
        return this.d.p();
    }

    public void i(boolean bl2) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || bl2)) {
            Object object;
            float f2;
            this.c.setTranslationY(0.0f);
            float f3 = f2 = (float)(-this.c.getHeight());
            if (bl2) {
                object = new int[2];
                int[] arrn = object;
                arrn[0] = 0;
                arrn[1] = 0;
                this.c.getLocationInWindow((int[])object);
                f3 = f2 - (float)object[1];
            }
            this.c.setTranslationY(f3);
            object = new androidx.appcompat.view.h();
            x x2 = t.m((View)this.c).b(0.0f);
            x2.a(this.r);
            ((androidx.appcompat.view.h)object).a(x2);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f3);
                ((androidx.appcompat.view.h)object).a(t.m(this.f).b(0.0f));
            }
            ((androidx.appcompat.view.h)object).a(u);
            ((androidx.appcompat.view.h)object).a(250L);
            ((androidx.appcompat.view.h)object).a(this.q);
            this.n = object;
            ((androidx.appcompat.view.h)object).a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.b != null) {
            t.q((View)this.b);
        }
    }

    @Override
    public void j() {
        if (this.m) {
            this.m = false;
            this.m(true);
        }
    }

    public void j(boolean bl2) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E == 0 && (this.H || bl2)) {
            float f2;
            Object object;
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            androidx.appcompat.view.h h2 = new androidx.appcompat.view.h();
            float f3 = f2 = (float)(-this.c.getHeight());
            if (bl2) {
                object = new int[2];
                int[] arrn = object;
                arrn[0] = 0;
                arrn[1] = 0;
                this.c.getLocationInWindow((int[])object);
                f3 = f2 - (float)object[1];
            }
            object = t.m((View)this.c).b(f3);
            ((x)object).a(this.r);
            h2.a((x)object);
            if (this.k && this.f != null) {
                h2.a(t.m(this.f).b(f3));
            }
            h2.a(t);
            h2.a(250L);
            h2.a(this.p);
            this.n = h2;
            h2.a();
            return;
        }
        this.p.b(null);
    }

    @Override
    public void k() {
        if (!this.m) {
            this.m = true;
            this.m(true);
        }
    }

    public void k(boolean bl2) {
        if (bl2) {
            this.n();
        } else {
            this.o();
        }
        if (this.p()) {
            x x2;
            x x3;
            if (bl2) {
                x2 = this.d.a(4, 100L);
                x3 = this.e.a(0, 200L);
            } else {
                x3 = this.d.a(0, 200L);
                x2 = this.e.a(8, 100L);
            }
            androidx.appcompat.view.h h2 = new androidx.appcompat.view.h();
            h2.a(x2, x3);
            h2.a();
            return;
        }
        if (bl2) {
            this.d.d(4);
            this.e.setVisibility(0);
            return;
        }
        this.d.d(0);
        this.e.setVisibility(8);
    }

    @Override
    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    @Override
    public void m() {
    }

    public class a
    extends b
    implements h.a {
        private final Context b;
        private final h c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a a2) {
            this.b = context;
            this.d = a2;
            this.c = new h(context).a(1);
            this.c.a(this);
        }

        @Override
        public MenuInflater a() {
            return new g(this.b);
        }

        @Override
        public void a(int n2) {
            this.b(l.this.a.getResources().getString(n2));
        }

        @Override
        public void a(View view) {
            l.this.e.setCustomView(view);
            this.e = new WeakReference<View>(view);
        }

        @Override
        public void a(h h2) {
            if (this.d == null) {
                return;
            }
            this.d();
            l.this.e.a();
        }

        @Override
        public void a(CharSequence charSequence) {
            l.this.e.setSubtitle(charSequence);
        }

        @Override
        public void a(boolean bl2) {
            super.a(bl2);
            l.this.e.setTitleOptional(bl2);
        }

        @Override
        public boolean a(h h2, MenuItem menuItem) {
            if (this.d != null) {
                return this.d.a((b)this, menuItem);
            }
            return false;
        }

        @Override
        public Menu b() {
            return this.c;
        }

        @Override
        public void b(int n2) {
            this.a(l.this.a.getResources().getString(n2));
        }

        @Override
        public void b(CharSequence charSequence) {
            l.this.e.setTitle(charSequence);
        }

        @Override
        public void c() {
            if (l.this.h != this) {
                return;
            }
            if (!l.a(l.this.l, l.this.m, false)) {
                l.this.i = this;
                l.this.j = this.d;
            } else {
                this.d.a(this);
            }
            this.d = null;
            l.this.k(false);
            l.this.e.b();
            l.this.d.a().sendAccessibilityEvent(32);
            l.this.b.setHideOnContentScrollEnabled(l.this.o);
            l.this.h = null;
        }

        @Override
        public void d() {
            if (l.this.h != this) {
                return;
            }
            this.c.h();
            try {
                this.d.b(this, this.c);
                return;
            }
            finally {
                this.c.i();
            }
        }

        public boolean e() {
            this.c.h();
            try {
                boolean bl2 = this.d.a((b)this, this.c);
                return bl2;
            }
            finally {
                this.c.i();
            }
        }

        @Override
        public CharSequence f() {
            return l.this.e.getTitle();
        }

        @Override
        public CharSequence g() {
            return l.this.e.getSubtitle();
        }

        @Override
        public boolean h() {
            return l.this.e.d();
        }

        @Override
        public View i() {
            if (this.e != null) {
                return (View)this.e.get();
            }
            return null;
        }
    }

}

