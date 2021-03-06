/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.y;
import androidx.core.h.t;
import androidx.core.widget.h;
import java.lang.reflect.Method;

public class ac
implements s {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D = new d();
    private final c E = new c();
    private final a F = new a();
    private Runnable G;
    private final Rect H = new Rect();
    private Rect I;
    private boolean J;
    y c;
    int d = Integer.MAX_VALUE;
    final e e = new e();
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k = -2;
    private int l = -2;
    private int m;
    private int n;
    private int o = 1002;
    private boolean p;
    private boolean q = true;
    private boolean r;
    private boolean s;
    private int t = 0;
    private boolean u = false;
    private boolean v = false;
    private View w;
    private int x = 0;
    private DataSetObserver y;
    private View z;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        block7 : {
            block6 : {
                try {
                    a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
                    break block6;
                }
                catch (NoSuchMethodException noSuchMethodException) {}
                Log.i((String)"ListPopupWindow", (String)"Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
                break block7;
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            Log.i((String)"ListPopupWindow", (String)"Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        Log.i((String)"ListPopupWindow", (String)"Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    }

    public ac(Context context) {
        this(context, null, a.a.listPopupWindowStyle);
    }

    public ac(Context context, AttributeSet attributeSet, int n2) {
        this(context, attributeSet, n2, 0);
    }

    public ac(Context context, AttributeSet attributeSet, int n2, int n3) {
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, n2, n3);
        this.m = typedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = typedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        typedArray.recycle();
        this.g = new m(context, attributeSet, n2, n3);
        this.g.setInputMethodMode(1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int a(View view, int n2, boolean bl2) {
        if (b == null) return this.g.getMaxAvailableHeight(view, n2);
        try {
            return (Integer)b.invoke((Object)this.g, new Object[]{view, n2, bl2});
        }
        catch (Exception exception) {}
        Log.i((String)"ListPopupWindow", (String)"Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
        return this.g.getMaxAvailableHeight(view, n2);
    }

    private void b() {
        ViewParent viewParent;
        if (this.w != null && (viewParent = this.w.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(this.w);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(boolean bl2) {
        if (a != null) {
            try {
                a.invoke((Object)this.g, bl2);
                return;
            }
            catch (Exception exception) {}
            Log.i((String)"ListPopupWindow", (String)"Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int f() {
        var6_1 = this.c;
        var5_2 = true;
        if (var6_1 == null) {
            var6_1 = this.i;
            this.G = new Runnable(){

                @Override
                public void run() {
                    View view = ac.this.i();
                    if (view != null && view.getWindowToken() != null) {
                        ac.this.a();
                    }
                }
            };
            this.c = this.a((Context)var6_1, this.J ^ true);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                public void onItemSelected(AdapterView<?> object, View view, int n2, long l2) {
                    if (n2 != -1 && (object = ac.this.c) != null) {
                        ((y)((Object)object)).setListSelectionHidden(false);
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener((AbsListView.OnScrollListener)this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            var7_3 = this.c;
            var8_5 = this.w;
            if (var8_5 != null) {
                var6_1 = new LinearLayout((Context)var6_1);
                var6_1.setOrientation(1);
                var9_6 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    default: {
                        var7_3 = new StringBuilder();
                        var7_3.append("Invalid hint position ");
                        var7_3.append(this.x);
                        Log.e((String)"ListPopupWindow", (String)var7_3.toString());
                        ** break;
                    }
                    case 1: {
                        var6_1.addView((View)var7_3, (ViewGroup.LayoutParams)var9_6);
                        var6_1.addView(var8_5);
                        ** break;
                    }
                    case 0: 
                }
                var6_1.addView(var8_5);
                var6_1.addView((View)var7_3, (ViewGroup.LayoutParams)var9_6);
lbl37: // 3 sources:
                if (this.l >= 0) {
                    var1_7 = this.l;
                    var2_8 = Integer.MIN_VALUE;
                } else {
                    var1_7 = 0;
                    var2_8 = 0;
                }
                var8_5.measure(View.MeasureSpec.makeMeasureSpec((int)var1_7, (int)var2_8), 0);
                var7_3 = (LinearLayout.LayoutParams)var8_5.getLayoutParams();
                var1_7 = var8_5.getMeasuredHeight() + var7_3.topMargin + var7_3.bottomMargin;
            } else {
                var1_7 = 0;
                var6_1 = var7_3;
            }
            this.g.setContentView((View)var6_1);
        } else {
            var6_1 = (ViewGroup)this.g.getContentView();
            var6_1 = this.w;
            if (var6_1 != null) {
                var7_4 = (LinearLayout.LayoutParams)var6_1.getLayoutParams();
                var1_7 = var6_1.getMeasuredHeight() + var7_4.topMargin + var7_4.bottomMargin;
            } else {
                var1_7 = 0;
            }
        }
        var6_1 = this.g.getBackground();
        if (var6_1 != null) {
            var6_1.getPadding(this.H);
            var2_8 = var3_9 = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
                var2_8 = var3_9;
            }
        } else {
            this.H.setEmpty();
            var2_8 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            var5_2 = false;
        }
        var4_10 = this.a(this.i(), this.n, var5_2);
        if (this.u != false) return var4_10 + var2_8;
        if (this.k == -1) {
            return var4_10 + var2_8;
        }
        switch (this.l) {
            default: {
                var3_9 = this.l;
                ** GOTO lbl80
            }
            case -1: {
                var3_9 = this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right);
lbl80: // 2 sources:
                var3_9 = View.MeasureSpec.makeMeasureSpec((int)var3_9, (int)1073741824);
                ** break;
            }
            case -2: 
        }
        var3_9 = View.MeasureSpec.makeMeasureSpec((int)(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right)), (int)Integer.MIN_VALUE);
        ** break;
lbl85: // 2 sources:
        var4_10 = this.c.a(var3_9, 0, -1, var4_10 - var1_7, -1);
        var3_9 = var1_7;
        if (var4_10 <= 0) return var4_10 + var3_9;
        var3_9 = var1_7 + (var2_8 + (this.c.getPaddingTop() + this.c.getPaddingBottom()));
        return var4_10 + var3_9;
    }

    y a(Context context, boolean bl2) {
        return new y(context, bl2);
    }

    @Override
    public void a() {
        int n2 = this.f();
        boolean bl2 = this.n();
        h.a(this.g, this.o);
        boolean bl3 = this.g.isShowing();
        boolean bl4 = true;
        if (bl3) {
            PopupWindow popupWindow;
            int n3;
            if (!t.B(this.i())) {
                return;
            }
            int n4 = this.l == -1 ? -1 : (this.l == -2 ? this.i().getWidth() : this.l);
            if (this.k == -1) {
                if (!bl2) {
                    n2 = -1;
                }
                if (bl2) {
                    popupWindow = this.g;
                    n3 = this.l == -1 ? -1 : 0;
                    popupWindow.setWidth(n3);
                    this.g.setHeight(0);
                } else {
                    popupWindow = this.g;
                    n3 = this.l == -1 ? -1 : 0;
                    popupWindow.setWidth(n3);
                    this.g.setHeight(-1);
                }
            } else if (this.k != -2) {
                n2 = this.k;
            }
            popupWindow = this.g;
            if (this.v || this.u) {
                bl4 = false;
            }
            popupWindow.setOutsideTouchable(bl4);
            popupWindow = this.g;
            View view = this.i();
            n3 = this.m;
            int n5 = this.n;
            if (n4 < 0) {
                n4 = -1;
            }
            if (n2 < 0) {
                n2 = -1;
            }
            popupWindow.update(view, n3, n5, n4, n2);
            return;
        }
        int n6 = this.l == -1 ? -1 : (this.l == -2 ? this.i().getWidth() : this.l);
        if (this.k == -1) {
            n2 = -1;
        } else if (this.k != -2) {
            n2 = this.k;
        }
        this.g.setWidth(n6);
        this.g.setHeight(n2);
        this.c(true);
        PopupWindow popupWindow = this.g;
        bl4 = !this.v && !this.u;
        popupWindow.setOutsideTouchable(bl4);
        this.g.setTouchInterceptor((View.OnTouchListener)this.D);
        if (this.s) {
            h.a(this.g, this.r);
        }
        if (h != null) {
            try {
                h.invoke((Object)this.g, new Object[]{this.I});
            }
            catch (Exception exception) {
                Log.e((String)"ListPopupWindow", (String)"Could not invoke setEpicenterBounds on PopupWindow", (Throwable)exception);
            }
        }
        h.a(this.g, this.i(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            this.m();
        }
        if (!this.J) {
            this.f.post((Runnable)this.F);
        }
    }

    public void a(int n2) {
        this.x = n2;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(Drawable drawable2) {
        this.g.setBackgroundDrawable(drawable2);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b();
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean bl2) {
        this.J = bl2;
        this.g.setFocusable(bl2);
    }

    public void b(int n2) {
        this.g.setAnimationStyle(n2);
    }

    public void b(View view) {
        this.z = view;
    }

    public void b(boolean bl2) {
        this.s = true;
        this.r = bl2;
    }

    @Override
    public void c() {
        this.g.dismiss();
        this.b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks((Runnable)this.e);
    }

    public void c(int n2) {
        this.m = n2;
    }

    public void d(int n2) {
        this.n = n2;
        this.p = true;
    }

    @Override
    public boolean d() {
        return this.g.isShowing();
    }

    @Override
    public ListView e() {
        return this.c;
    }

    public void e(int n2) {
        this.t = n2;
    }

    public void f(int n2) {
        this.l = n2;
    }

    public void g(int n2) {
        Drawable drawable2 = this.g.getBackground();
        if (drawable2 != null) {
            drawable2.getPadding(this.H);
            this.l = this.H.left + this.H.right + n2;
            return;
        }
        this.f(n2);
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int n2) {
        this.g.setInputMethodMode(n2);
    }

    public View i() {
        return this.z;
    }

    public void i(int n2) {
        y y2 = this.c;
        if (this.d() && y2 != null) {
            y2.setListSelectionHidden(false);
            y2.setSelection(n2);
            if (y2.getChoiceMode() != 0) {
                y2.setItemChecked(n2, true);
            }
        }
    }

    public int j() {
        return this.m;
    }

    public int k() {
        if (!this.p) {
            return 0;
        }
        return this.n;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        y y2 = this.c;
        if (y2 != null) {
            y2.setListSelectionHidden(true);
            y2.requestLayout();
        }
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }

    private class a
    implements Runnable {
        a() {
        }

        @Override
        public void run() {
            ac.this.m();
        }
    }

    private class b
    extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (ac.this.d()) {
                ac.this.a();
            }
        }

        public void onInvalidated() {
            ac.this.c();
        }
    }

    private class c
    implements AbsListView.OnScrollListener {
        c() {
        }

        public void onScroll(AbsListView absListView, int n2, int n3, int n4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int n2) {
            if (n2 == 1 && !ac.this.n() && ac.this.g.getContentView() != null) {
                ac.this.f.removeCallbacks((Runnable)ac.this.e);
                ac.this.e.run();
            }
        }
    }

    private class d
    implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int n2 = motionEvent.getAction();
            int n3 = (int)motionEvent.getX();
            int n4 = (int)motionEvent.getY();
            if (n2 == 0 && ac.this.g != null && ac.this.g.isShowing() && n3 >= 0 && n3 < ac.this.g.getWidth() && n4 >= 0 && n4 < ac.this.g.getHeight()) {
                ac.this.f.postDelayed((Runnable)ac.this.e, 250L);
            } else if (n2 == 1) {
                ac.this.f.removeCallbacks((Runnable)ac.this.e);
            }
            return false;
        }
    }

    private class e
    implements Runnable {
        e() {
        }

        @Override
        public void run() {
            if (ac.this.c != null && t.B((View)ac.this.c) && ac.this.c.getCount() > ac.this.c.getChildCount() && ac.this.c.getChildCount() <= ac.this.d) {
                ac.this.g.setInputMethodMode(2);
                ac.this.a();
            }
        }
    }

}

