/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ag;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.ap;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.w;
import androidx.core.h.g;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E = new ArrayList();
    private final ArrayList<View> F = new ArrayList();
    private final int[] G = new int[2];
    private final ActionMenuView.e H = new ActionMenuView.e(){

        @Override
        public boolean a(MenuItem menuItem) {
            if (Toolbar.this.d != null) {
                return Toolbar.this.d.a(menuItem);
            }
            return false;
        }
    };
    private ap I;
    private androidx.appcompat.widget.c J;
    private a K;
    private o.a L;
    private h.a M;
    private boolean N;
    private final Runnable O = new Runnable(){

        @Override
        public void run() {
            Toolbar.this.d();
        }
    };
    ImageButton a;
    View b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ag u;
    private int v;
    private int w;
    private int x = 8388627;
    private CharSequence y;
    private CharSequence z;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.toolbarStyle);
    }

    public Toolbar(Context object, AttributeSet object2, int n2) {
        int n3;
        super((Context)object, object2, n2);
        object = ao.a(this.getContext(), object2, a.j.Toolbar, n2, 0);
        this.n = ((ao)object).g(a.j.Toolbar_titleTextAppearance, 0);
        this.o = ((ao)object).g(a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = ((ao)object).c(a.j.Toolbar_android_gravity, this.x);
        this.c = ((ao)object).c(a.j.Toolbar_buttonGravity, 48);
        n2 = n3 = ((ao)object).d(a.j.Toolbar_titleMargin, 0);
        if (((ao)object).g(a.j.Toolbar_titleMargins)) {
            n2 = ((ao)object).d(a.j.Toolbar_titleMargins, n3);
        }
        this.t = n2;
        this.s = n2;
        this.r = n2;
        this.q = n2;
        n2 = ((ao)object).d(a.j.Toolbar_titleMarginStart, -1);
        if (n2 >= 0) {
            this.q = n2;
        }
        if ((n2 = ((ao)object).d(a.j.Toolbar_titleMarginEnd, -1)) >= 0) {
            this.r = n2;
        }
        if ((n2 = ((ao)object).d(a.j.Toolbar_titleMarginTop, -1)) >= 0) {
            this.s = n2;
        }
        if ((n2 = ((ao)object).d(a.j.Toolbar_titleMarginBottom, -1)) >= 0) {
            this.t = n2;
        }
        this.p = ((ao)object).e(a.j.Toolbar_maxButtonHeight, -1);
        n2 = ((ao)object).d(a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        n3 = ((ao)object).d(a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int n4 = ((ao)object).e(a.j.Toolbar_contentInsetLeft, 0);
        int n5 = ((ao)object).e(a.j.Toolbar_contentInsetRight, 0);
        this.s();
        this.u.b(n4, n5);
        if (n2 != Integer.MIN_VALUE || n3 != Integer.MIN_VALUE) {
            this.u.a(n2, n3);
        }
        this.v = ((ao)object).d(a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = ((ao)object).d(a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = ((ao)object).a(a.j.Toolbar_collapseIcon);
        this.k = ((ao)object).c(a.j.Toolbar_collapseContentDescription);
        object2 = ((ao)object).c(a.j.Toolbar_title);
        if (!TextUtils.isEmpty((CharSequence)object2)) {
            this.setTitle((CharSequence)object2);
        }
        if (!TextUtils.isEmpty((CharSequence)(object2 = ((ao)object).c(a.j.Toolbar_subtitle)))) {
            this.setSubtitle((CharSequence)object2);
        }
        this.l = this.getContext();
        this.setPopupTheme(((ao)object).g(a.j.Toolbar_popupTheme, 0));
        object2 = ((ao)object).a(a.j.Toolbar_navigationIcon);
        if (object2 != null) {
            this.setNavigationIcon((Drawable)object2);
        }
        if (!TextUtils.isEmpty((CharSequence)(object2 = ((ao)object).c(a.j.Toolbar_navigationContentDescription)))) {
            this.setNavigationContentDescription((CharSequence)object2);
        }
        if ((object2 = ((ao)object).a(a.j.Toolbar_logo)) != null) {
            this.setLogo((Drawable)object2);
        }
        if (!TextUtils.isEmpty((CharSequence)(object2 = ((ao)object).c(a.j.Toolbar_logoDescription)))) {
            this.setLogoDescription((CharSequence)object2);
        }
        if (((ao)object).g(a.j.Toolbar_titleTextColor)) {
            this.setTitleTextColor(((ao)object).b(a.j.Toolbar_titleTextColor, -1));
        }
        if (((ao)object).g(a.j.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(((ao)object).b(a.j.Toolbar_subtitleTextColor, -1));
        }
        ((ao)object).a();
    }

    private int a(int n2) {
        int n3;
        n2 = n3 = n2 & 112;
        if (n3 != 16) {
            n2 = n3;
            if (n3 != 48) {
                n2 = n3;
                if (n3 != 80) {
                    n2 = this.x & 112;
                }
            }
        }
        return n2;
    }

    private int a(View view, int n2) {
        b b2 = (b)view.getLayoutParams();
        int n3 = view.getMeasuredHeight();
        n2 = n2 > 0 ? (n3 - n2) / 2 : 0;
        int n4 = this.a(b2.a);
        if (n4 != 48) {
            if (n4 != 80) {
                int n5 = this.getPaddingTop();
                n2 = this.getPaddingBottom();
                int n6 = this.getHeight();
                n4 = (n6 - n5 - n2 - n3) / 2;
                if (n4 < b2.topMargin) {
                    n2 = b2.topMargin;
                } else {
                    n3 = n6 - n2 - n3 - n4 - n5;
                    n2 = n4;
                    if (n3 < b2.bottomMargin) {
                        n2 = Math.max(0, n4 - (b2.bottomMargin - n3));
                    }
                }
                return n5 + n2;
            }
            return this.getHeight() - this.getPaddingBottom() - n3 - b2.bottomMargin - n2;
        }
        return this.getPaddingTop() - n2;
    }

    private int a(View view, int n2, int n3, int n4, int n5, int[] arrn) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n6 = marginLayoutParams.leftMargin - arrn[0];
        int n7 = marginLayoutParams.rightMargin - arrn[1];
        int n8 = Math.max(0, n6) + Math.max(0, n7);
        arrn[0] = Math.max(0, -n6);
        arrn[1] = Math.max(0, -n7);
        view.measure(Toolbar.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight() + n8 + n3), (int)marginLayoutParams.width), Toolbar.getChildMeasureSpec((int)n4, (int)(this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + n5), (int)marginLayoutParams.height));
        return view.getMeasuredWidth() + n8;
    }

    private int a(View view, int n2, int[] arrn, int n3) {
        b b2 = (b)view.getLayoutParams();
        int n4 = b2.leftMargin - arrn[0];
        arrn[0] = Math.max(0, -n4);
        n3 = this.a(view, n3);
        n4 = view.getMeasuredWidth();
        view.layout(n2 += Math.max(0, n4), n3, n2 + n4, view.getMeasuredHeight() + n3);
        return n2 + (n4 + b2.rightMargin);
    }

    private int a(List<View> list, int[] view) {
        int n2 = view[0];
        int n3 = view[1];
        int n4 = list.size();
        int n5 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            view = list.get(i2);
            b b2 = (b)view.getLayoutParams();
            n2 = b2.leftMargin - n2;
            n3 = b2.rightMargin - n3;
            int n6 = Math.max(0, n2);
            int n7 = Math.max(0, n3);
            n2 = Math.max(0, -n2);
            n3 = Math.max(0, -n3);
            n5 += n6 + view.getMeasuredWidth() + n7;
        }
        return n5;
    }

    private void a(View view, int n2, int n3, int n4, int n5, int n6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n7 = Toolbar.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + n3), (int)marginLayoutParams.width);
        n3 = Toolbar.getChildMeasureSpec((int)n4, (int)(this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + n5), (int)marginLayoutParams.height);
        n4 = View.MeasureSpec.getMode((int)n3);
        n2 = n3;
        if (n4 != 1073741824) {
            n2 = n3;
            if (n6 >= 0) {
                n2 = n6;
                if (n4 != 0) {
                    n2 = Math.min(View.MeasureSpec.getSize((int)n3), n6);
                }
                n2 = View.MeasureSpec.makeMeasureSpec((int)n2, (int)1073741824);
            }
        }
        view.measure(n7, n2);
    }

    private void a(View view, boolean bl2) {
        Object object = view.getLayoutParams();
        object = object == null ? this.j() : (!this.checkLayoutParams((ViewGroup.LayoutParams)object) ? this.a((ViewGroup.LayoutParams)object) : (b)((Object)object));
        object.b = 1;
        if (bl2 && this.b != null) {
            view.setLayoutParams(object);
            this.F.add(view);
            return;
        }
        this.addView(view, object);
    }

    private void a(List<View> list, int n2) {
        int n3 = t.f((View)this);
        int n4 = 0;
        n3 = n3 == 1 ? 1 : 0;
        int n5 = this.getChildCount();
        int n6 = androidx.core.h.d.a(n2, t.f((View)this));
        list.clear();
        if (n3 != 0) {
            for (n2 = n5 - 1; n2 >= 0; --n2) {
                View view = this.getChildAt(n2);
                b b2 = (b)view.getLayoutParams();
                if (b2.b != 0 || !this.a(view) || this.b(b2.a) != n6) continue;
                list.add(view);
            }
        } else {
            for (n2 = n4; n2 < n5; ++n2) {
                View view = this.getChildAt(n2);
                b b3 = (b)view.getLayoutParams();
                if (b3.b != 0 || !this.a(view) || this.b(b3.a) != n6) continue;
                list.add(view);
            }
        }
    }

    private boolean a(View view) {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }

    private int b(int n2) {
        int n3 = t.f((View)this);
        int n4 = androidx.core.h.d.a(n2, n3) & 7;
        if (n4 != 1) {
            n2 = 3;
            if (n4 != 3 && n4 != 5) {
                if (n3 == 1) {
                    n2 = 5;
                }
                return n2;
            }
        }
        return n4;
    }

    private int b(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return g.a((ViewGroup.MarginLayoutParams)view) + g.b((ViewGroup.MarginLayoutParams)view);
    }

    private int b(View view, int n2, int[] arrn, int n3) {
        b b2 = (b)view.getLayoutParams();
        int n4 = b2.rightMargin - arrn[1];
        arrn[1] = Math.max(0, -n4);
        n3 = this.a(view, n3);
        n4 = view.getMeasuredWidth();
        view.layout((n2 -= Math.max(0, n4)) - n4, n3, n2, view.getMeasuredHeight() + n3);
        return n2 - (n4 + b2.leftMargin);
    }

    private int c(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return view.topMargin + view.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains((Object)view);
        {
        }
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(this.getContext());
    }

    private void m() {
        if (this.i == null) {
            this.i = new AppCompatImageView(this.getContext());
        }
    }

    private void n() {
        this.o();
        if (this.e.d() == null) {
            h h2 = (h)this.e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.e.setExpandedActionViewsExclusive(true);
            h2.a(this.K, this.l);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new ActionMenuView(this.getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            b b2 = this.j();
            b2.a = 8388613 | this.c & 112;
            this.e.setLayoutParams((ViewGroup.LayoutParams)b2);
            this.a((View)this.e, false);
        }
    }

    private void p() {
        if (this.h == null) {
            this.h = new AppCompatImageButton(this.getContext(), null, a.a.toolbarNavigationButtonStyle);
            b b2 = this.j();
            b2.a = 8388611 | this.c & 112;
            this.h.setLayoutParams((ViewGroup.LayoutParams)b2);
        }
    }

    private void q() {
        this.removeCallbacks(this.O);
        this.post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.getChildAt(i2);
            if (!this.a(view) || view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) continue;
            return false;
        }
        return true;
    }

    private void s() {
        if (this.u == null) {
            this.u = new ag();
        }
    }

    public b a(AttributeSet attributeSet) {
        return new b(this.getContext(), attributeSet);
    }

    protected b a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b)layoutParams);
        }
        if (layoutParams instanceof a.a) {
            return new b((a.a)layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams)layoutParams);
        }
        return new b(layoutParams);
    }

    public void a(int n2, int n3) {
        this.s();
        this.u.a(n2, n3);
    }

    public void a(Context context, int n2) {
        this.n = n2;
        if (this.f != null) {
            this.f.setTextAppearance(context, n2);
        }
    }

    public void a(h h2, androidx.appcompat.widget.c c2) {
        if (h2 == null && this.e == null) {
            return;
        }
        this.o();
        h h3 = this.e.d();
        if (h3 == h2) {
            return;
        }
        if (h3 != null) {
            h3.b(this.J);
            h3.b(this.K);
        }
        if (this.K == null) {
            this.K = new a();
        }
        c2.c(true);
        if (h2 != null) {
            h2.a(c2, this.l);
            h2.a(this.K, this.l);
        } else {
            c2.a(this.l, null);
            this.K.a(this.l, null);
            c2.a(true);
            this.K.a(true);
        }
        this.e.setPopupTheme(this.m);
        this.e.setPresenter(c2);
        this.J = c2;
    }

    public void a(o.a a2, h.a a3) {
        this.L = a2;
        this.M = a3;
        if (this.e != null) {
            this.e.a(a2, a3);
        }
    }

    public boolean a() {
        return this.getVisibility() == 0 && this.e != null && this.e.a();
    }

    public void b(Context context, int n2) {
        this.o = n2;
        if (this.g != null) {
            this.g.setTextAppearance(context, n2);
        }
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    public boolean c() {
        return this.e != null && this.e.h();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && layoutParams instanceof b;
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    public boolean g() {
        return this.K != null && this.K.b != null;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.j();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public int getContentInsetEnd() {
        if (this.u != null) {
            return this.u.d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        if (this.w != Integer.MIN_VALUE) {
            return this.w;
        }
        return this.getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        if (this.u != null) {
            return this.u.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.u != null) {
            return this.u.b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        if (this.u != null) {
            return this.u.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.v != Integer.MIN_VALUE) {
            return this.v;
        }
        return this.getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        h h2;
        boolean bl2 = this.e != null && (h2 = this.e.d()) != null && h2.hasVisibleItems();
        if (bl2) {
            return Math.max(this.getContentInsetEnd(), Math.max(this.w, 0));
        }
        return this.getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (t.f((View)this) == 1) {
            return this.getCurrentContentInsetEnd();
        }
        return this.getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (t.f((View)this) == 1) {
            return this.getCurrentContentInsetStart();
        }
        return this.getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (this.getNavigationIcon() != null) {
            return Math.max(this.getContentInsetStart(), Math.max(this.v, 0));
        }
        return this.getContentInsetStart();
    }

    public Drawable getLogo() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        this.n();
        return this.e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.h != null) {
            return this.h.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.h != null) {
            return this.h.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        this.n();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public w getWrapper() {
        if (this.I == null) {
            this.I = new ap(this, true);
        }
        return this.I;
    }

    public void h() {
        j j2 = this.K == null ? null : this.K.b;
        if (j2 != null) {
            j2.collapseActionView();
        }
    }

    void i() {
        if (this.a == null) {
            this.a = new AppCompatImageButton(this.getContext(), null, a.a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            b b2 = this.j();
            b2.a = 8388611 | this.c & 112;
            b2.b = 2;
            this.a.setLayoutParams((ViewGroup.LayoutParams)b2);
            this.a.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    protected b j() {
        return new b(-2, -2);
    }

    void k() {
        for (int i2 = this.getChildCount() - 1; i2 >= 0; --i2) {
            View view = this.getChildAt(i2);
            if (((b)view.getLayoutParams()).b == 2 || view == this.e) continue;
            this.removeViewAt(i2);
            this.F.add(view);
        }
    }

    void l() {
        for (int i2 = this.F.size() - 1; i2 >= 0; --i2) {
            this.addView(this.F.get(i2));
        }
        this.F.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean bl2 = super.onHoverEvent(motionEvent);
            if (n2 == 9 && !bl2) {
                this.D = true;
            }
        }
        if (n2 == 10 || n2 == 3) {
            this.D = false;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onLayout(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block45 : {
            block43 : {
                block44 : {
                    block41 : {
                        block42 : {
                            var8_6 = t.f((View)this) == 1 ? 1 : 0;
                            var10_7 = this.getWidth();
                            var13_8 = this.getHeight();
                            var6_9 = this.getPaddingLeft();
                            var11_10 = this.getPaddingRight();
                            var12_11 = this.getPaddingTop();
                            var14_12 = this.getPaddingBottom();
                            var9_13 = var10_7 - var11_10;
                            var18_14 = this.G;
                            var18_14[1] = 0;
                            var18_14[0] = 0;
                            var2_2 = t.l((View)this);
                            var5_5 = var2_2 >= 0 ? Math.min(var2_2, var5_5 - var3_3) : 0;
                            if (!this.a((View)this.h)) break block41;
                            if (var8_6 == 0) break block42;
                            var4_4 = this.b((View)this.h, var9_13, var18_14, var5_5);
                            var7_15 = var6_9;
                            break block43;
                        }
                        var7_15 = this.a((View)this.h, var6_9, var18_14, var5_5);
                        break block44;
                    }
                    var7_15 = var6_9;
                }
                var4_4 = var9_13;
            }
            var2_2 = var4_4;
            var3_3 = var7_15;
            if (this.a((View)this.a)) {
                if (var8_6 != 0) {
                    var2_2 = this.b((View)this.a, var4_4, var18_14, var5_5);
                    var3_3 = var7_15;
                } else {
                    var3_3 = this.a((View)this.a, var7_15, var18_14, var5_5);
                    var2_2 = var4_4;
                }
            }
            var4_4 = var2_2;
            var7_15 = var3_3;
            if (this.a((View)this.e)) {
                if (var8_6 != 0) {
                    var7_15 = this.a((View)this.e, var3_3, var18_14, var5_5);
                    var4_4 = var2_2;
                } else {
                    var4_4 = this.b((View)this.e, var2_2, var18_14, var5_5);
                    var7_15 = var3_3;
                }
            }
            var3_3 = this.getCurrentContentInsetLeft();
            var2_2 = this.getCurrentContentInsetRight();
            var18_14[0] = Math.max(0, var3_3 - var7_15);
            var18_14[1] = Math.max(0, var2_2 - (var9_13 - var4_4));
            var3_3 = Math.max(var7_15, var3_3);
            var4_4 = Math.min(var4_4, var9_13 - var2_2);
            var2_2 = var3_3;
            var7_15 = var4_4;
            if (this.a(this.b)) {
                if (var8_6 != 0) {
                    var7_15 = this.b(this.b, var4_4, var18_14, var5_5);
                    var2_2 = var3_3;
                } else {
                    var2_2 = this.a(this.b, var3_3, var18_14, var5_5);
                    var7_15 = var4_4;
                }
            }
            var4_4 = var2_2;
            var3_3 = var7_15;
            if (this.a((View)this.i)) {
                if (var8_6 != 0) {
                    var3_3 = this.b((View)this.i, var7_15, var18_14, var5_5);
                    var4_4 = var2_2;
                } else {
                    var4_4 = this.a((View)this.i, var2_2, var18_14, var5_5);
                    var3_3 = var7_15;
                }
            }
            var1_1 = this.a((View)this.f);
            var15_16 = this.a((View)this.g);
            if (var1_1) {
                var16_17 = (b)this.f.getLayoutParams();
                var2_2 = var16_17.topMargin + this.f.getMeasuredHeight() + var16_17.bottomMargin + 0;
            } else {
                var2_2 = 0;
            }
            if (var15_16) {
                var16_17 = (b)this.g.getLayoutParams();
                var2_2 += var16_17.topMargin + this.g.getMeasuredHeight() + var16_17.bottomMargin;
            }
            if (var1_1 || var15_16) break block45;
            var2_2 = var4_4;
            ** GOTO lbl135
        }
        var16_17 = var1_1 != false ? this.f : this.g;
        if (var15_16) {
            var17_19 = this.g;
        } else {
            var17_20 = this.f;
        }
        var16_17 = (b)var16_17.getLayoutParams();
        var17_18 = (b)var17_21.getLayoutParams();
        var7_15 = var1_1 != false && this.f.getMeasuredWidth() > 0 || var15_16 != false && this.g.getMeasuredWidth() > 0 ? 1 : 0;
        var9_13 = this.x & 112;
        if (var9_13 != 48) {
            if (var9_13 != 80) {
                var9_13 = (var13_8 - var12_11 - var14_12 - var2_2) / 2;
                if (var9_13 < var16_17.topMargin + this.s) {
                    var2_2 = var16_17.topMargin + this.s;
                } else {
                    var13_8 = var13_8 - var14_12 - var2_2 - var9_13 - var12_11;
                    var2_2 = var9_13;
                    if (var13_8 < var16_17.bottomMargin + this.t) {
                        var2_2 = Math.max(0, var9_13 - (var17_18.bottomMargin + this.t - var13_8));
                    }
                }
                var2_2 = var12_11 + var2_2;
            } else {
                var2_2 = var13_8 - var14_12 - var17_18.bottomMargin - this.t - var2_2;
            }
        } else {
            var2_2 = this.getPaddingTop() + var16_17.topMargin + this.s;
        }
        if (var8_6 != 0) {
            var8_6 = var7_15 != 0 ? this.q : 0;
            var3_3 -= Math.max(0, var8_6 -= var18_14[1]);
            var18_14[1] = Math.max(0, -var8_6);
            if (var1_1) {
                var16_17 = (b)this.f.getLayoutParams();
                var9_13 = var3_3 - this.f.getMeasuredWidth();
                var8_6 = this.f.getMeasuredHeight() + var2_2;
                this.f.layout(var9_13, var2_2, var3_3, var8_6);
                var2_2 = var9_13 - this.r;
                var9_13 = var8_6 + var16_17.bottomMargin;
            } else {
                var8_6 = var3_3;
                var9_13 = var2_2;
                var2_2 = var8_6;
            }
            if (var15_16) {
                var16_17 = (b)this.g.getLayoutParams();
                var8_6 = var9_13 + var16_17.topMargin;
                var9_13 = this.g.getMeasuredWidth();
                var12_11 = this.g.getMeasuredHeight();
                this.g.layout(var3_3 - var9_13, var8_6, var3_3, var12_11 + var8_6);
                var8_6 = var3_3 - this.r;
                var9_13 = var16_17.bottomMargin;
            } else {
                var8_6 = var3_3;
            }
            if (var7_15 != 0) {
                var3_3 = Math.min(var2_2, var8_6);
            }
            var2_2 = var4_4;
lbl135: // 2 sources:
            var4_4 = var3_3;
        } else {
            var8_6 = var7_15 != 0 ? this.q : 0;
            var4_4 += Math.max(0, var8_6 -= var18_14[0]);
            var18_14[0] = Math.max(0, -var8_6);
            if (var1_1) {
                var16_17 = (b)this.f.getLayoutParams();
                var8_6 = this.f.getMeasuredWidth() + var4_4;
                var9_13 = this.f.getMeasuredHeight() + var2_2;
                this.f.layout(var4_4, var2_2, var8_6, var9_13);
                var8_6 += this.r;
                var2_2 = var9_13 + var16_17.bottomMargin;
            } else {
                var8_6 = var4_4;
            }
            if (var15_16) {
                var16_17 = (b)this.g.getLayoutParams();
                var9_13 = this.g.getMeasuredWidth() + var4_4;
                var12_11 = this.g.getMeasuredHeight();
                this.g.layout(var4_4, var2_2 += var16_17.topMargin, var9_13, var12_11 + var2_2);
                var9_13 += this.r;
                var2_2 = var16_17.bottomMargin;
            } else {
                var9_13 = var4_4;
            }
            var2_2 = var4_4;
            var4_4 = var3_3;
            if (var7_15 != 0) {
                var2_2 = Math.max(var8_6, var9_13);
                var4_4 = var3_3;
            }
        }
        var7_15 = var6_9;
        var6_9 = 0;
        this.a(this.E, 3);
        var8_6 = this.E.size();
        for (var3_3 = 0; var3_3 < var8_6; ++var3_3) {
            var2_2 = this.a(this.E.get(var3_3), var2_2, var18_14, var5_5);
        }
        this.a(this.E, 5);
        var8_6 = this.E.size();
        for (var3_3 = 0; var3_3 < var8_6; ++var3_3) {
            var4_4 = this.b(this.E.get(var3_3), var4_4, var18_14, var5_5);
        }
        this.a(this.E, 1);
        var8_6 = this.a(this.E, var18_14);
        var3_3 = var7_15 + (var10_7 - var7_15 - var11_10) / 2 - var8_6 / 2;
        var7_15 = var8_6 + var3_3;
        if (var3_3 >= var2_2) {
            var2_2 = var7_15 > var4_4 ? var3_3 - (var7_15 - var4_4) : var3_3;
        }
        var4_4 = this.E.size();
        var3_3 = var6_9;
        do {
            if (var3_3 >= var4_4) {
                this.E.clear();
                return;
            }
            var2_2 = this.a(this.E.get(var3_3), var2_2, var18_14, var5_5);
            ++var3_3;
        } while (true);
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int[] arrn = this.G;
        if (au.a((View)this)) {
            n6 = 1;
            n5 = 0;
        } else {
            n6 = 0;
            n5 = 1;
        }
        if (this.a((View)this.h)) {
            this.a((View)this.h, n2, 0, n3, 0, this.p);
            n8 = this.h.getMeasuredWidth() + this.b((View)this.h);
            n7 = Math.max(0, this.h.getMeasuredHeight() + this.c((View)this.h));
            n4 = View.combineMeasuredStates((int)0, (int)this.h.getMeasuredState());
        } else {
            n8 = 0;
            n7 = 0;
            n4 = 0;
        }
        int n9 = n8;
        int n10 = n7;
        n8 = n4;
        if (this.a((View)this.a)) {
            this.a((View)this.a, n2, 0, n3, 0, this.p);
            n9 = this.a.getMeasuredWidth() + this.b((View)this.a);
            n10 = Math.max(n7, this.a.getMeasuredHeight() + this.c((View)this.a));
            n8 = View.combineMeasuredStates((int)n4, (int)this.a.getMeasuredState());
        }
        n4 = this.getCurrentContentInsetStart();
        n7 = Math.max(n4, n9) + 0;
        arrn[n6] = Math.max(0, n4 - n9);
        if (this.a((View)this.e)) {
            this.a((View)this.e, n2, n7, n3, 0, this.p);
            n4 = this.e.getMeasuredWidth() + this.b((View)this.e);
            n10 = Math.max(n10, this.e.getMeasuredHeight() + this.c((View)this.e));
            n8 = View.combineMeasuredStates((int)n8, (int)this.e.getMeasuredState());
        } else {
            n4 = 0;
        }
        n9 = this.getCurrentContentInsetEnd();
        n6 = n7 + Math.max(n9, n4);
        arrn[n5] = Math.max(0, n9 - n4);
        n5 = n6;
        n7 = n10;
        n4 = n8;
        if (this.a(this.b)) {
            n5 = n6 + this.a(this.b, n2, n6, n3, 0, arrn);
            n7 = Math.max(n10, this.b.getMeasuredHeight() + this.c(this.b));
            n4 = View.combineMeasuredStates((int)n8, (int)this.b.getMeasuredState());
        }
        n10 = n5;
        n6 = n7;
        n8 = n4;
        if (this.a((View)this.i)) {
            n10 = n5 + this.a((View)this.i, n2, n5, n3, 0, arrn);
            n6 = Math.max(n7, this.i.getMeasuredHeight() + this.c((View)this.i));
            n8 = View.combineMeasuredStates((int)n4, (int)this.i.getMeasuredState());
        }
        int n11 = this.getChildCount();
        n5 = n6;
        n4 = 0;
        n7 = n10;
        for (n10 = n4; n10 < n11; ++n10) {
            View view = this.getChildAt(n10);
            n9 = n7;
            n6 = n8;
            n4 = n5;
            if (((b)view.getLayoutParams()).b == 0) {
                if (!this.a(view)) {
                    n9 = n7;
                    n6 = n8;
                    n4 = n5;
                } else {
                    n9 = n7 + this.a(view, n2, n7, n3, 0, arrn);
                    n4 = Math.max(n5, view.getMeasuredHeight() + this.c(view));
                    n6 = View.combineMeasuredStates((int)n8, (int)view.getMeasuredState());
                }
            }
            n7 = n9;
            n8 = n6;
            n5 = n4;
        }
        n6 = this.s + this.t;
        n9 = this.q + this.r;
        if (this.a((View)this.f)) {
            this.a((View)this.f, n2, n7 + n9, n3, n6, arrn);
            n10 = this.f.getMeasuredWidth();
            n11 = this.b((View)this.f);
            n4 = this.f.getMeasuredHeight();
            int n12 = this.c((View)this.f);
            n8 = View.combineMeasuredStates((int)n8, (int)this.f.getMeasuredState());
            n4 += n12;
            n10 += n11;
        } else {
            n10 = 0;
            n4 = 0;
        }
        if (this.a((View)this.g)) {
            n10 = Math.max(n10, this.a((View)this.g, n2, n7 + n9, n3, n4 + n6, arrn));
            n4 += this.g.getMeasuredHeight() + this.c((View)this.g);
            n8 = View.combineMeasuredStates((int)n8, (int)this.g.getMeasuredState());
        }
        n4 = Math.max(n5, n4);
        n9 = this.getPaddingLeft();
        n11 = this.getPaddingRight();
        n5 = this.getPaddingTop();
        n6 = this.getPaddingBottom();
        n10 = View.resolveSizeAndState((int)Math.max(n7 + n10 + (n9 + n11), this.getSuggestedMinimumWidth()), (int)n2, (int)(-16777216 & n8));
        n2 = View.resolveSizeAndState((int)Math.max(n4 + (n5 + n6), this.getSuggestedMinimumHeight()), (int)n3, (int)(n8 << 16));
        if (this.r()) {
            n2 = 0;
        }
        this.setMeasuredDimension(n10, n2);
    }

    protected void onRestoreInstanceState(Parcelable object) {
        if (!(object instanceof d)) {
            super.onRestoreInstanceState(object);
            return;
        }
        d d2 = (d)object;
        super.onRestoreInstanceState(d2.a());
        object = this.e != null ? this.e.d() : null;
        if (d2.a != 0 && this.K != null && object != null && (object = object.findItem(d2.a)) != null) {
            object.expandActionView();
        }
        if (d2.b) {
            this.q();
        }
    }

    public void onRtlPropertiesChanged(int n2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(n2);
        }
        this.s();
        ag ag2 = this.u;
        boolean bl2 = true;
        if (n2 != 1) {
            bl2 = false;
        }
        ag2.a(bl2);
    }

    protected Parcelable onSaveInstanceState() {
        d d2 = new d(super.onSaveInstanceState());
        if (this.K != null && this.K.b != null) {
            d2.a = this.K.b.getItemId();
        }
        d2.b = this.b();
        return d2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean bl2 = super.onTouchEvent(motionEvent);
            if (n2 == 0 && !bl2) {
                this.C = true;
            }
        }
        if (n2 == 1 || n2 == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapsible(boolean bl2) {
        this.N = bl2;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int n2) {
        int n3 = n2;
        if (n2 < 0) {
            n3 = Integer.MIN_VALUE;
        }
        if (n3 != this.w) {
            this.w = n3;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int n2) {
        int n3 = n2;
        if (n2 < 0) {
            n3 = Integer.MIN_VALUE;
        }
        if (n3 != this.v) {
            this.v = n3;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setLogo(int n2) {
        this.setLogo(androidx.appcompat.a.a.a.b(this.getContext(), n2));
    }

    public void setLogo(Drawable drawable2) {
        if (drawable2 != null) {
            this.m();
            if (!this.d((View)this.i)) {
                this.a((View)this.i, true);
            }
        } else if (this.i != null && this.d((View)this.i)) {
            this.removeView((View)this.i);
            this.F.remove((Object)this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable2);
        }
    }

    public void setLogoDescription(int n2) {
        this.setLogoDescription(this.getContext().getText(n2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.m();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int n2) {
        CharSequence charSequence = n2 != 0 ? this.getContext().getText(n2) : null;
        this.setNavigationContentDescription(charSequence);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.p();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int n2) {
        this.setNavigationIcon(androidx.appcompat.a.a.a.b(this.getContext(), n2));
    }

    public void setNavigationIcon(Drawable drawable2) {
        if (drawable2 != null) {
            this.p();
            if (!this.d((View)this.h)) {
                this.a((View)this.h, true);
            }
        } else if (this.h != null && this.d((View)this.h)) {
            this.removeView((View)this.h);
            this.F.remove((Object)this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable2);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        this.p();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c c2) {
        this.d = c2;
    }

    public void setOverflowIcon(Drawable drawable2) {
        this.n();
        this.e.setOverflowIcon(drawable2);
    }

    public void setPopupTheme(int n2) {
        if (this.m != n2) {
            this.m = n2;
            if (n2 == 0) {
                this.l = this.getContext();
                return;
            }
            this.l = new ContextThemeWrapper(this.getContext(), n2);
        }
    }

    public void setSubtitle(int n2) {
        this.setSubtitle(this.getContext().getText(n2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.g == null) {
                Context context = this.getContext();
                this.g = new AppCompatTextView(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!this.d((View)this.g)) {
                this.a((View)this.g, true);
            }
        } else if (this.g != null && this.d((View)this.g)) {
            this.removeView((View)this.g);
            this.F.remove((Object)this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int n2) {
        this.B = n2;
        if (this.g != null) {
            this.g.setTextColor(n2);
        }
    }

    public void setTitle(int n2) {
        this.setTitle(this.getContext().getText(n2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.f == null) {
                Context context = this.getContext();
                this.f = new AppCompatTextView(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!this.d((View)this.f)) {
                this.a((View)this.f, true);
            }
        } else if (this.f != null && this.d((View)this.f)) {
            this.removeView((View)this.f);
            this.F.remove((Object)this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int n2) {
        this.t = n2;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int n2) {
        this.r = n2;
        this.requestLayout();
    }

    public void setTitleMarginStart(int n2) {
        this.q = n2;
        this.requestLayout();
    }

    public void setTitleMarginTop(int n2) {
        this.s = n2;
        this.requestLayout();
    }

    public void setTitleTextColor(int n2) {
        this.A = n2;
        if (this.f != null) {
            this.f.setTextColor(n2);
        }
    }

    private class a
    implements o {
        h a;
        j b;

        a() {
        }

        @Override
        public void a(Context context, h h2) {
            if (this.a != null && this.b != null) {
                this.a.d(this.b);
            }
            this.a = h2;
        }

        @Override
        public void a(h h2, boolean bl2) {
        }

        @Override
        public void a(o.a a2) {
        }

        @Override
        public void a(boolean bl2) {
            if (this.b != null) {
                boolean bl3;
                h h2 = this.a;
                boolean bl4 = bl3 = false;
                if (h2 != null) {
                    int n2 = this.a.size();
                    int n3 = 0;
                    do {
                        bl4 = bl3;
                        if (n3 >= n2) break;
                        if (this.a.getItem(n3) == this.b) {
                            bl4 = true;
                            break;
                        }
                        ++n3;
                    } while (true);
                }
                if (!bl4) {
                    this.b(this.a, this.b);
                }
            }
        }

        @Override
        public boolean a(h object, j j2) {
            Toolbar.this.i();
            object = Toolbar.this.a.getParent();
            if (object != Toolbar.this) {
                if (object instanceof ViewGroup) {
                    ((ViewGroup)object).removeView((View)Toolbar.this.a);
                }
                Toolbar.this.addView((View)Toolbar.this.a);
            }
            Toolbar.this.b = j2.getActionView();
            this.b = j2;
            object = Toolbar.this.b.getParent();
            if (object != Toolbar.this) {
                if (object instanceof ViewGroup) {
                    ((ViewGroup)object).removeView(Toolbar.this.b);
                }
                object = Toolbar.this.j();
                ((b)object).a = 8388611 | Toolbar.this.c & 112;
                ((b)object).b = 2;
                Toolbar.this.b.setLayoutParams((ViewGroup.LayoutParams)object);
                Toolbar.this.addView(Toolbar.this.b);
            }
            Toolbar.this.k();
            Toolbar.this.requestLayout();
            j2.e(true);
            if (Toolbar.this.b instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c)Toolbar.this.b).a();
            }
            return true;
        }

        @Override
        public boolean a(u u2) {
            return false;
        }

        @Override
        public boolean b() {
            return false;
        }

        @Override
        public boolean b(h h2, j j2) {
            if (Toolbar.this.b instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c)Toolbar.this.b).b();
            }
            Toolbar.this.removeView(Toolbar.this.b);
            Toolbar.this.removeView((View)Toolbar.this.a);
            Toolbar.this.b = null;
            Toolbar.this.l();
            this.b = null;
            Toolbar.this.requestLayout();
            j2.e(false);
            return true;
        }
    }

    public static class b
    extends a.a {
        int b = 0;

        public b(int n2, int n3) {
            super(n2, n3);
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams)marginLayoutParams);
            this.a(marginLayoutParams);
        }

        public b(a.a a2) {
            super(a2);
        }

        public b(b b2) {
            super(b2);
            this.b = b2.b;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static interface c {
        public boolean a(MenuItem var1);
    }

    public static class d
    extends androidx.e.a.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>(){

            public d a(Parcel parcel) {
                return new d(parcel, null);
            }

            public d a(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            public d[] a(int n2) {
                return new d[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return this.a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        int a;
        boolean b;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            boolean bl2 = parcel.readInt() != 0;
            this.b = bl2;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            RuntimeException runtimeException;
            super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            throw runtimeException;
        }

    }

}

