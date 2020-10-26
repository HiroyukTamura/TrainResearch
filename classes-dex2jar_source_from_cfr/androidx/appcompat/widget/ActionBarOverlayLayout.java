/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.AttributeSet
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.widget.OverScroller
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.w;
import androidx.core.h.m;
import androidx.core.h.o;
import androidx.core.h.t;

public class ActionBarOverlayLayout
extends ViewGroup
implements v,
m {
    static final int[] e = new int[]{a.a.actionBarSize, 16842841};
    private final Runnable A = new Runnable(){

        @Override
        public void run() {
            ActionBarOverlayLayout.this.d();
            ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY((float)(-ActionBarOverlayLayout.this.a.getHeight())).setListener((Animator.AnimatorListener)ActionBarOverlayLayout.this.d);
        }
    };
    private final o B;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d = new AnimatorListenerAdapter(){

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout.this.c = null;
            ActionBarOverlayLayout.this.b = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout.this.c = null;
            ActionBarOverlayLayout.this.b = false;
        }
    };
    private int f;
    private int g = 0;
    private ContentFrameLayout h;
    private w i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q = new Rect();
    private final Rect r = new Rect();
    private final Rect s = new Rect();
    private final Rect t = new Rect();
    private final Rect u = new Rect();
    private final Rect v = new Rect();
    private final Rect w = new Rect();
    private a x;
    private OverScroller y;
    private final Runnable z = new Runnable(){

        @Override
        public void run() {
            ActionBarOverlayLayout.this.d();
            ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0f).setListener((Animator.AnimatorListener)ActionBarOverlayLayout.this.d);
        }
    };

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
        this.B = new o(this);
    }

    private w a(View view) {
        if (view instanceof w) {
            return (w)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view.getClass().getSimpleName());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void a(Context context) {
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(e);
        boolean bl2 = false;
        this.f = typedArray.getDimensionPixelSize(0, 0);
        this.j = typedArray.getDrawable(1);
        boolean bl3 = this.j == null;
        this.setWillNotDraw(bl3);
        typedArray.recycle();
        bl3 = bl2;
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            bl3 = true;
        }
        this.k = bl3;
        this.y = new OverScroller(context);
    }

    private boolean a(float f2, float f3) {
        this.y.fling(0, 0, 0, (int)f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.y.getFinalY() > this.a.getHeight();
    }

    private boolean a(View object, Rect rect, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6;
        object = (b)object.getLayoutParams();
        if (bl2 && object.leftMargin != rect.left) {
            object.leftMargin = rect.left;
            bl6 = true;
        } else {
            bl6 = false;
        }
        bl2 = bl6;
        if (bl3) {
            bl2 = bl6;
            if (object.topMargin != rect.top) {
                object.topMargin = rect.top;
                bl2 = true;
            }
        }
        bl3 = bl2;
        if (bl5) {
            bl3 = bl2;
            if (object.rightMargin != rect.right) {
                object.rightMargin = rect.right;
                bl3 = true;
            }
        }
        bl2 = bl3;
        if (bl4) {
            bl2 = bl3;
            if (object.bottomMargin != rect.bottom) {
                object.bottomMargin = rect.bottom;
                bl2 = true;
            }
        }
        return bl2;
    }

    private void l() {
        this.d();
        this.postDelayed(this.z, 600L);
    }

    private void m() {
        this.d();
        this.postDelayed(this.A, 600L);
    }

    private void n() {
        this.d();
        this.z.run();
    }

    private void o() {
        this.d();
        this.A.run();
    }

    public b a(AttributeSet attributeSet) {
        return new b(this.getContext(), attributeSet);
    }

    @Override
    public void a(int n2) {
        this.c();
        if (n2 != 2) {
            if (n2 != 5) {
                if (n2 != 109) {
                    return;
                }
                this.setOverlayMode(true);
                return;
            }
            this.i.g();
            return;
        }
        this.i.f();
    }

    @Override
    public void a(Menu menu, o.a a2) {
        this.c();
        this.i.a(menu, a2);
    }

    public boolean a() {
        return this.l;
    }

    protected b b() {
        return new b(-1, -1);
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout)this.findViewById(a.f.action_bar_activity_content);
            this.a = (ActionBarContainer)this.findViewById(a.f.action_bar_container);
            this.i = this.a(this.findViewById(a.f.action_bar));
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    void d() {
        this.removeCallbacks(this.z);
        this.removeCallbacks(this.A);
        if (this.c != null) {
            this.c.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !this.k) {
            int n2 = this.a.getVisibility() == 0 ? (int)((float)this.a.getBottom() + this.a.getTranslationY() + 0.5f) : 0;
            this.j.setBounds(0, n2, this.getWidth(), this.j.getIntrinsicHeight() + n2);
            this.j.draw(canvas);
        }
    }

    @Override
    public boolean e() {
        this.c();
        return this.i.h();
    }

    @Override
    public boolean f() {
        this.c();
        return this.i.i();
    }

    protected boolean fitSystemWindows(Rect rect) {
        this.c();
        t.p((View)this);
        boolean bl2 = this.a((View)this.a, rect, true, true, false, true);
        this.t.set(rect);
        au.a((View)this, this.t, this.q);
        if (!this.u.equals((Object)this.t)) {
            this.u.set(this.t);
            bl2 = true;
        }
        if (!this.r.equals((Object)this.q)) {
            this.r.set(this.q);
            bl2 = true;
        }
        if (bl2) {
            this.requestLayout();
        }
        return true;
    }

    @Override
    public boolean g() {
        this.c();
        return this.i.j();
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.b();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.a != null) {
            return -((int)this.a.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        this.c();
        return this.i.e();
    }

    @Override
    public boolean h() {
        this.c();
        return this.i.k();
    }

    @Override
    public boolean i() {
        this.c();
        return this.i.l();
    }

    @Override
    public void j() {
        this.c();
        this.i.m();
    }

    @Override
    public void k() {
        this.c();
        this.i.n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a(this.getContext());
        t.q((View)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        n3 = this.getChildCount();
        n4 = this.getPaddingLeft();
        this.getPaddingRight();
        n5 = this.getPaddingTop();
        this.getPaddingBottom();
        for (n2 = 0; n2 < n3; ++n2) {
            View view = this.getChildAt(n2);
            if (view.getVisibility() == 8) continue;
            b b2 = (b)view.getLayoutParams();
            int n6 = view.getMeasuredWidth();
            int n7 = view.getMeasuredHeight();
            int n8 = b2.leftMargin + n4;
            int n9 = b2.topMargin + n5;
            view.layout(n8, n9, n6 + n8, n7 + n9);
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        this.c();
        this.measureChildWithMargins((View)this.a, n2, 0, n3, 0);
        b b2 = (b)this.a.getLayoutParams();
        int n6 = Math.max(0, this.a.getMeasuredWidth() + b2.leftMargin + b2.rightMargin);
        int n7 = Math.max(0, this.a.getMeasuredHeight() + b2.topMargin + b2.bottomMargin);
        int n8 = View.combineMeasuredStates((int)0, (int)this.a.getMeasuredState());
        int n9 = (t.p((View)this) & 256) != 0 ? 1 : 0;
        if (n9 != 0) {
            n5 = n4 = this.f;
            if (this.m) {
                n5 = n4;
                if (this.a.getTabContainer() != null) {
                    n5 = n4 + this.f;
                }
            }
        } else {
            n5 = this.a.getVisibility() != 8 ? this.a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        this.v.set(this.t);
        if (!this.l && n9 == 0) {
            b2 = this.s;
            ((Rect)b2).top += n5;
            b2 = this.s;
        } else {
            b2 = this.v;
            ((Rect)b2).top += n5;
            b2 = this.v;
        }
        ((Rect)b2).bottom += 0;
        this.a((View)this.h, this.s, true, true, true, true);
        if (!this.w.equals((Object)this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        this.measureChildWithMargins((View)this.h, n2, 0, n3, 0);
        b2 = (b)this.h.getLayoutParams();
        n5 = Math.max(n6, this.h.getMeasuredWidth() + b2.leftMargin + b2.rightMargin);
        n9 = Math.max(n7, this.h.getMeasuredHeight() + b2.topMargin + b2.bottomMargin);
        n4 = View.combineMeasuredStates((int)n8, (int)this.h.getMeasuredState());
        n8 = this.getPaddingLeft();
        n7 = this.getPaddingRight();
        n9 = Math.max(n9 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max(n5 + (n8 + n7), this.getSuggestedMinimumWidth()), (int)n2, (int)n4), View.resolveSizeAndState((int)n9, (int)n3, (int)(n4 << 16)));
    }

    @Override
    public boolean onNestedFling(View view, float f2, float f3, boolean bl2) {
        if (this.n && bl2) {
            if (this.a(f2, f3)) {
                this.o();
            } else {
                this.n();
            }
            this.b = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override
    public void onNestedPreScroll(View view, int n2, int n3, int[] arrn) {
    }

    @Override
    public void onNestedScroll(View view, int n2, int n3, int n4, int n5) {
        this.o += n3;
        this.setActionBarHideOffset(this.o);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n2) {
        this.B.a(view, view2, n2);
        this.o = this.getActionBarHideOffset();
        this.d();
        if (this.x != null) {
            this.x.l();
        }
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n2) {
        if ((n2 & 2) != 0 && this.a.getVisibility() == 0) {
            return this.n;
        }
        return false;
    }

    @Override
    public void onStopNestedScroll(View view) {
        if (this.n && !this.b) {
            if (this.o <= this.a.getHeight()) {
                this.l();
            } else {
                this.m();
            }
        }
        if (this.x != null) {
            this.x.m();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int n2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(n2);
        }
        this.c();
        int n3 = this.p;
        this.p = n2;
        boolean bl2 = false;
        boolean bl3 = (n2 & 4) == 0;
        if ((n2 & 256) != 0) {
            bl2 = true;
        }
        if (this.x != null) {
            this.x.h(bl2 ^ true);
            if (!bl3 && bl2) {
                this.x.k();
            } else {
                this.x.j();
            }
        }
        if (((n3 ^ n2) & 256) != 0 && this.x != null) {
            t.q((View)this);
        }
    }

    protected void onWindowVisibilityChanged(int n2) {
        super.onWindowVisibilityChanged(n2);
        this.g = n2;
        if (this.x != null) {
            this.x.a(n2);
        }
    }

    public void setActionBarHideOffset(int n2) {
        this.d();
        n2 = Math.max(0, Math.min(n2, this.a.getHeight()));
        this.a.setTranslationY((float)(-n2));
    }

    public void setActionBarVisibilityCallback(a a2) {
        this.x = a2;
        if (this.getWindowToken() != null) {
            this.x.a(this.g);
            if (this.p != 0) {
                this.onWindowSystemUiVisibilityChanged(this.p);
                t.q((View)this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean bl2) {
        this.m = bl2;
    }

    public void setHideOnContentScrollEnabled(boolean bl2) {
        if (bl2 != this.n) {
            this.n = bl2;
            if (!bl2) {
                this.d();
                this.setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int n2) {
        this.c();
        this.i.a(n2);
    }

    public void setIcon(Drawable drawable2) {
        this.c();
        this.i.a(drawable2);
    }

    public void setLogo(int n2) {
        this.c();
        this.i.b(n2);
    }

    public void setOverlayMode(boolean bl2) {
        this.l = bl2;
        bl2 = bl2 && this.getContext().getApplicationInfo().targetSdkVersion < 19;
        this.k = bl2;
    }

    public void setShowingForActionMode(boolean bl2) {
    }

    public void setUiOptions(int n2) {
    }

    @Override
    public void setWindowCallback(Window.Callback callback) {
        this.c();
        this.i.a(callback);
    }

    @Override
    public void setWindowTitle(CharSequence charSequence) {
        this.c();
        this.i.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static interface a {
        public void a(int var1);

        public void h(boolean var1);

        public void j();

        public void k();

        public void l();

        public void m();
    }

    public static class b
    extends ViewGroup.MarginLayoutParams {
        public b(int n2, int n3) {
            super(n2, n3);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

}

