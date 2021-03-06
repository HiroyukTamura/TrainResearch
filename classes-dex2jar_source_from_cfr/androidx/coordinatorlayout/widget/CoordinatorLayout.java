/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.AbsSavedState
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.a;
import androidx.core.g.d;
import androidx.core.h.ab;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.p;
import androidx.core.h.t;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
extends ViewGroup
implements n {
    static final String a;
    static final Class<?>[] b;
    static final ThreadLocal<Map<String, Constructor<b>>> c;
    static final Comparator<View> d;
    private static final d.a<Rect> f;
    ViewGroup.OnHierarchyChangeListener e;
    private final List<View> g = new ArrayList<View>();
    private final androidx.coordinatorlayout.widget.a<View> h = new androidx.coordinatorlayout.widget.a();
    private final List<View> i = new ArrayList<View>();
    private final List<View> j = new ArrayList<View>();
    private final int[] k = new int[2];
    private Paint l;
    private boolean m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private f r;
    private boolean s;
    private ab t;
    private boolean u;
    private Drawable v;
    private p w;
    private final o x = new o(this);

    static {
        Object object = CoordinatorLayout.class.getPackage();
        object = object != null ? ((Package)object).getName() : null;
        a = object;
        d = Build.VERSION.SDK_INT >= 21 ? new h() : null;
        b = new Class[]{Context.class, AttributeSet.class};
        c = new ThreadLocal();
        f = new d.c<Rect>(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        int n3 = 0;
        attributeSet = n2 == 0 ? context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout, n2, 0);
        n2 = attributeSet.getResourceId(a.c.CoordinatorLayout_keylines, 0);
        if (n2 != 0) {
            context = context.getResources();
            this.o = context.getIntArray(n2);
            float f2 = context.getDisplayMetrics().density;
            int n4 = this.o.length;
            for (n2 = n3; n2 < n4; ++n2) {
                this.o[n2] = (int)((float)this.o[n2] * f2);
            }
        }
        this.v = attributeSet.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
        attributeSet.recycle();
        this.g();
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)new d());
    }

    private static int a(int n2, int n3, int n4) {
        if (n2 < n3) {
            return n3;
        }
        if (n2 > n4) {
            return n4;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static b a(Context object, AttributeSet object2, String hashMap) {
        Map<String, Constructor<b>> map;
        StringBuilder stringBuilder;
        CharSequence charSequence;
        if (TextUtils.isEmpty((CharSequence)((Object)map))) {
            return null;
        }
        if (((String)((Object)map)).startsWith(".")) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(object.getPackageName());
            ((StringBuilder)charSequence).append((String)((Object)map));
            charSequence = ((StringBuilder)charSequence).toString();
        } else if (((String)((Object)map)).indexOf(46) >= 0) {
            charSequence = map;
        } else {
            charSequence = map;
            if (!TextUtils.isEmpty((CharSequence)a)) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(a);
                ((StringBuilder)charSequence).append('.');
                ((StringBuilder)charSequence).append((String)((Object)map));
                charSequence = ((StringBuilder)charSequence).toString();
            }
        }
        try {
            Constructor<?> constructor = c.get();
            map = constructor;
            if (constructor == null) {
                map = new HashMap<String, Constructor<b>>();
                c.set(map);
            }
            Constructor<b> constructor2 = map.get(charSequence);
            constructor = constructor2;
            if (constructor2 == null) {
                constructor = object.getClassLoader().loadClass((String)charSequence).getConstructor(b);
                constructor.setAccessible(true);
                map.put((String)charSequence, constructor);
            }
            return (b)constructor.newInstance(object, stringBuilder);
        }
        catch (Exception exception) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not inflate Behavior subclass ");
            stringBuilder.append((String)charSequence);
            throw new RuntimeException(stringBuilder.toString(), exception);
        }
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f.a(rect);
    }

    private void a(View view, int n2, Rect rect, Rect rect2, e e2, int n3, int n4) {
        int n5 = androidx.core.h.d.a(CoordinatorLayout.e(e2.c), n2);
        n2 = androidx.core.h.d.a(CoordinatorLayout.c(e2.d), n2);
        int n6 = n5 & 7;
        int n7 = n5 & 112;
        int n8 = n2 & 7;
        n5 = n2 & 112;
        n2 = n8 != 1 ? (n8 != 5 ? rect.left : rect.right) : rect.left + rect.width() / 2;
        n5 = n5 != 16 ? (n5 != 80 ? rect.top : rect.bottom) : rect.top + rect.height() / 2;
        if (n6 != 1) {
            n8 = n2;
            if (n6 != 5) {
                n8 = n2 - n3;
            }
        } else {
            n8 = n2 - n3 / 2;
        }
        if (n7 != 16) {
            n2 = n5;
            if (n7 != 80) {
                n2 = n5 - n4;
            }
        } else {
            n2 = n5 - n4 / 2;
        }
        rect2.set(n8, n2, n3 + n8, n4 + n2);
    }

    private void a(View object, Rect rect, int n2) {
        if (!t.y((View)object)) {
            return;
        }
        if (object.getWidth() > 0) {
            if (object.getHeight() <= 0) {
                return;
            }
            e e2 = (e)object.getLayoutParams();
            b b2 = e2.b();
            Rect rect2 = CoordinatorLayout.e();
            Rect rect3 = CoordinatorLayout.e();
            rect3.set(object.getLeft(), object.getTop(), object.getRight(), object.getBottom());
            if (b2 != null && b2.a(this, object, rect2)) {
                if (!rect3.contains(rect2)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Rect should be within the child's bounds. Rect:");
                    ((StringBuilder)object).append(rect2.toShortString());
                    ((StringBuilder)object).append(" | Bounds:");
                    ((StringBuilder)object).append(rect3.toShortString());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
            } else {
                rect2.set(rect3);
            }
            CoordinatorLayout.a(rect3);
            if (rect2.isEmpty()) {
                CoordinatorLayout.a(rect2);
                return;
            }
            int n3 = androidx.core.h.d.a(e2.h, n2);
            if ((n3 & 48) == 48 && (n2 = rect2.top - e2.topMargin - e2.j) < rect.top) {
                this.f((View)object, rect.top - n2);
                n2 = 1;
            } else {
                n2 = 0;
            }
            int n4 = n2;
            if ((n3 & 80) == 80) {
                int n5 = this.getHeight() - rect2.bottom - e2.bottomMargin + e2.j;
                n4 = n2;
                if (n5 < rect.bottom) {
                    this.f((View)object, n5 - rect.bottom);
                    n4 = 1;
                }
            }
            if (n4 == 0) {
                this.f((View)object, 0);
            }
            if ((n3 & 3) == 3 && (n2 = rect2.left - e2.leftMargin - e2.i) < rect.left) {
                this.e((View)object, rect.left - n2);
                n2 = 1;
            } else {
                n2 = 0;
            }
            n4 = n2;
            if ((n3 & 5) == 5) {
                n3 = this.getWidth() - rect2.right - e2.rightMargin + e2.i;
                n4 = n2;
                if (n3 < rect.right) {
                    this.e((View)object, n3 - rect.right);
                    n4 = 1;
                }
            }
            if (n4 == 0) {
                this.e((View)object, 0);
            }
            CoordinatorLayout.a(rect2);
        }
    }

    private void a(View view, View view2, int n2) {
        Rect rect = CoordinatorLayout.e();
        Rect rect2 = CoordinatorLayout.e();
        try {
            this.a(view2, rect);
            this.a(view, n2, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return;
        }
        finally {
            CoordinatorLayout.a(rect);
            CoordinatorLayout.a(rect2);
        }
    }

    private void a(e e2, Rect rect, int n2, int n3) {
        int n4 = this.getWidth();
        int n5 = this.getHeight();
        n4 = Math.max(this.getPaddingLeft() + e2.leftMargin, Math.min(rect.left, n4 - this.getPaddingRight() - n2 - e2.rightMargin));
        n5 = Math.max(this.getPaddingTop() + e2.topMargin, Math.min(rect.top, n5 - this.getPaddingBottom() - n3 - e2.bottomMargin));
        rect.set(n4, n5, n2 + n4, n3 + n5);
    }

    private void a(List<View> list) {
        list.clear();
        boolean bl2 = this.isChildrenDrawingOrderEnabled();
        int n2 = this.getChildCount();
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            int n3 = bl2 ? this.getChildDrawingOrder(n2, i2) : i2;
            list.add(this.getChildAt(n3));
        }
        if (d != null) {
            Collections.sort(list, d);
        }
    }

    private void a(boolean bl2) {
        int n2;
        int n3 = this.getChildCount();
        for (n2 = 0; n2 < n3; ++n2) {
            View view = this.getChildAt(n2);
            b b2 = ((e)view.getLayoutParams()).b();
            if (b2 == null) continue;
            long l2 = SystemClock.uptimeMillis();
            MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
            if (bl2) {
                b2.a(this, view, motionEvent);
            } else {
                b2.b(this, view, motionEvent);
            }
            motionEvent.recycle();
        }
        for (n2 = 0; n2 < n3; ++n2) {
            ((e)this.getChildAt(n2).getLayoutParams()).f();
        }
        this.p = null;
        this.m = false;
    }

    private boolean a(MotionEvent motionEvent, int n2) {
        boolean bl2;
        int n3 = motionEvent.getActionMasked();
        List<View> list = this.i;
        this.a(list);
        int n4 = list.size();
        e e2 = null;
        int n5 = 0;
        boolean bl3 = false;
        boolean bl4 = false;
        do {
            boolean bl5;
            boolean bl6;
            bl2 = bl3;
            if (n5 >= n4) break;
            View view = list.get(n5);
            e e3 = (e)view.getLayoutParams();
            b b2 = e3.b();
            if ((bl3 || bl4) && n3 != 0) {
                bl5 = bl3;
                bl6 = bl4;
                e3 = e2;
                if (b2 != null) {
                    e3 = e2;
                    if (e2 == null) {
                        long l2 = SystemClock.uptimeMillis();
                        e3 = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
                    }
                    switch (n2) {
                        default: {
                            bl5 = bl3;
                            bl6 = bl4;
                            break;
                        }
                        case 1: {
                            b2.b(this, view, (MotionEvent)e3);
                            bl5 = bl3;
                            bl6 = bl4;
                            break;
                        }
                        case 0: {
                            b2.a(this, view, (MotionEvent)e3);
                            bl5 = bl3;
                            bl6 = bl4;
                            break;
                        }
                    }
                }
            } else {
                bl2 = bl3;
                if (!bl3) {
                    bl2 = bl3;
                    if (b2 != null) {
                        switch (n2) {
                            default: {
                                break;
                            }
                            case 1: {
                                bl3 = b2.b(this, view, motionEvent);
                                break;
                            }
                            case 0: {
                                bl3 = b2.a(this, view, motionEvent);
                            }
                        }
                        bl2 = bl3;
                        if (bl3) {
                            this.p = view;
                            bl2 = bl3;
                        }
                    }
                }
                bl5 = e3.e();
                bl3 = e3.a(this, view);
                bl4 = bl3 && !bl5;
                bl5 = bl2;
                bl6 = bl4;
                e3 = e2;
                if (bl3) {
                    bl5 = bl2;
                    bl6 = bl4;
                    e3 = e2;
                    if (!bl4) break;
                }
            }
            ++n5;
            bl3 = bl5;
            bl4 = bl6;
            e2 = e3;
        } while (true);
        list.clear();
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int b(int n2) {
        StringBuilder stringBuilder;
        if (this.o == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("No keylines defined for ");
            stringBuilder.append(this);
            stringBuilder.append(" - attempted index lookup ");
            stringBuilder.append(n2);
        } else {
            if (n2 >= 0 && n2 < this.o.length) {
                return this.o[n2];
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Keyline index ");
            stringBuilder.append(n2);
            stringBuilder.append(" out of range for ");
            stringBuilder.append(this);
        }
        Log.e((String)"CoordinatorLayout", (String)stringBuilder.toString());
        return 0;
    }

    private ab b(ab ab2) {
        if (ab2.e()) {
            return ab2;
        }
        int n2 = this.getChildCount();
        ab ab3 = ab2;
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.getChildAt(i2);
            ab2 = ab3;
            if (t.r(view)) {
                b b2 = ((e)view.getLayoutParams()).b();
                ab2 = ab3;
                if (b2 != null) {
                    ab2 = ab3 = b2.a(this, view, ab3);
                    if (ab3.e()) {
                        return ab3;
                    }
                }
            }
            ab3 = ab2;
        }
        return ab3;
    }

    private void b(View view, int n2, int n3) {
        e e2 = (e)view.getLayoutParams();
        int n4 = androidx.core.h.d.a(CoordinatorLayout.d(e2.c), n3);
        int n5 = n4 & 7;
        int n6 = n4 & 112;
        int n7 = this.getWidth();
        int n8 = this.getHeight();
        int n9 = view.getMeasuredWidth();
        int n10 = view.getMeasuredHeight();
        n4 = n2;
        if (n3 == 1) {
            n4 = n7 - n2;
        }
        n2 = this.b(n4) - n9;
        n3 = 0;
        if (n5 != 1) {
            if (n5 == 5) {
                n2 += n9;
            }
        } else {
            n2 += n9 / 2;
        }
        if (n6 != 16) {
            if (n6 == 80) {
                n3 = n10 + 0;
            }
        } else {
            n3 = 0 + n10 / 2;
        }
        n2 = Math.max(this.getPaddingLeft() + e2.leftMargin, Math.min(n2, n7 - this.getPaddingRight() - n9 - e2.rightMargin));
        n3 = Math.max(this.getPaddingTop() + e2.topMargin, Math.min(n3, n8 - this.getPaddingBottom() - n10 - e2.bottomMargin));
        view.layout(n2, n3, n9 + n2, n10 + n3);
    }

    private static int c(int n2) {
        int n3 = n2;
        if ((n2 & 7) == 0) {
            n3 = n2 | 8388611;
        }
        n2 = n3;
        if ((n3 & 112) == 0) {
            n2 = n3 | 48;
        }
        return n2;
    }

    private static int d(int n2) {
        int n3 = n2;
        if (n2 == 0) {
            n3 = 8388661;
        }
        return n3;
    }

    private void d(View view, int n2) {
        e e2 = (e)view.getLayoutParams();
        Rect rect = CoordinatorLayout.e();
        rect.set(this.getPaddingLeft() + e2.leftMargin, this.getPaddingTop() + e2.topMargin, this.getWidth() - this.getPaddingRight() - e2.rightMargin, this.getHeight() - this.getPaddingBottom() - e2.bottomMargin);
        if (this.t != null && t.r((View)this) && !t.r(view)) {
            rect.left += this.t.a();
            rect.top += this.t.b();
            rect.right -= this.t.c();
            rect.bottom -= this.t.d();
        }
        Rect rect2 = CoordinatorLayout.e();
        androidx.core.h.d.a(CoordinatorLayout.c(e2.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, n2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        CoordinatorLayout.a(rect);
        CoordinatorLayout.a(rect2);
    }

    private static int e(int n2) {
        int n3 = n2;
        if (n2 == 0) {
            n3 = 17;
        }
        return n3;
    }

    private static Rect e() {
        Rect rect;
        Rect rect2 = rect = f.a();
        if (rect == null) {
            rect2 = new Rect();
        }
        return rect2;
    }

    private void e(View view, int n2) {
        e e2 = (e)view.getLayoutParams();
        if (e2.i != n2) {
            t.f(view, n2 - e2.i);
            e2.i = n2;
        }
    }

    private boolean e(View view) {
        return this.h.e(view);
    }

    private void f() {
        this.g.clear();
        this.h.a();
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.getChildAt(i2);
            e e2 = this.a(view);
            e2.b(this, view);
            this.h.a(view);
            for (int i3 = 0; i3 < n2; ++i3) {
                View view2;
                if (i3 == i2 || !e2.a(this, view, view2 = this.getChildAt(i3))) continue;
                if (!this.h.b(view2)) {
                    this.h.a(view2);
                }
                this.h.a(view2, view);
            }
        }
        this.g.addAll(this.h.b());
        Collections.reverse(this.g);
    }

    private void f(View view, int n2) {
        e e2 = (e)view.getLayoutParams();
        if (e2.j != n2) {
            t.e(view, n2 - e2.j);
            e2.j = n2;
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (t.r((View)this)) {
            if (this.w == null) {
                this.w = new p(){

                    @Override
                    public ab a(View view, ab ab2) {
                        return CoordinatorLayout.this.a(ab2);
                    }
                };
            }
            t.a((View)this, this.w);
            this.setSystemUiVisibility(1280);
            return;
        }
        t.a((View)this, null);
    }

    public e a(AttributeSet attributeSet) {
        return new e(this.getContext(), attributeSet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    e a(View object) {
        e e2 = (e)object.getLayoutParams();
        if (e2.b) {
            return e2;
        }
        if (object instanceof a) {
            if ((object = ((a)object).getBehavior()) == null) {
                Log.e((String)"CoordinatorLayout", (String)"Attached behavior class is null");
            }
            e2.a((b)object);
        } else {
            Object object2;
            Class<?> class_ = object.getClass();
            object = null;
            while (class_ != null) {
                object = object2 = class_.getAnnotation(c.class);
                if (object2 != null) break;
                class_ = class_.getSuperclass();
                object = object2;
            }
            if (object != null) {
                try {
                    e2.a(object.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Default behavior class ");
                    ((StringBuilder)object2).append(object.a().getName());
                    ((StringBuilder)object2).append(" could not be instantiated. Did you forget");
                    ((StringBuilder)object2).append(" a default constructor?");
                    Log.e((String)"CoordinatorLayout", (String)((StringBuilder)object2).toString(), (Throwable)exception);
                }
            }
        }
        e2.b = true;
        return e2;
    }

    protected e a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e)layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams)layoutParams);
        }
        return new e(layoutParams);
    }

    final ab a(ab ab2) {
        ab ab3 = ab2;
        if (!androidx.core.g.c.a((Object)this.t, (Object)ab2)) {
            this.t = ab2;
            boolean bl2 = true;
            boolean bl3 = ab2 != null && ab2.b() > 0;
            this.u = bl3;
            bl3 = !this.u && this.getBackground() == null ? bl2 : false;
            this.setWillNotDraw(bl3);
            ab3 = this.b(ab2);
            this.requestLayout();
        }
        return ab3;
    }

    void a() {
        boolean bl2;
        int n2 = this.getChildCount();
        boolean bl3 = false;
        int n3 = 0;
        do {
            bl2 = bl3;
            if (n3 >= n2) break;
            if (this.e(this.getChildAt(n3))) {
                bl2 = true;
                break;
            }
            ++n3;
        } while (true);
        if (bl2 != this.s) {
            if (bl2) {
                this.b();
                return;
            }
            this.c();
        }
    }

    final void a(int n2) {
        int n3 = t.f((View)this);
        int n4 = this.g.size();
        Rect rect = CoordinatorLayout.e();
        Rect rect2 = CoordinatorLayout.e();
        Rect rect3 = CoordinatorLayout.e();
        for (int i2 = 0; i2 < n4; ++i2) {
            Object object;
            int n5;
            View view = this.g.get(i2);
            e e2 = (e)view.getLayoutParams();
            if (n2 == 0 && view.getVisibility() == 8) continue;
            for (n5 = 0; n5 < i2; ++n5) {
                object = this.g.get(n5);
                if (e2.l != object) continue;
                this.b(view, n3);
            }
            this.a(view, true, rect2);
            if (e2.g != 0 && !rect2.isEmpty()) {
                n5 = androidx.core.h.d.a(e2.g, n3);
                int n6 = n5 & 112;
                if (n6 != 48) {
                    if (n6 == 80) {
                        rect.bottom = Math.max(rect.bottom, this.getHeight() - rect2.top);
                    }
                } else {
                    rect.top = Math.max(rect.top, rect2.bottom);
                }
                if ((n5 &= 7) != 3) {
                    if (n5 == 5) {
                        rect.right = Math.max(rect.right, this.getWidth() - rect2.left);
                    }
                } else {
                    rect.left = Math.max(rect.left, rect2.right);
                }
            }
            if (e2.h != 0 && view.getVisibility() == 0) {
                this.a(view, rect, n3);
            }
            if (n2 != 2) {
                this.c(view, rect3);
                if (rect3.equals((Object)rect2)) continue;
                this.b(view, rect2);
            }
            for (n5 = i2 + 1; n5 < n4; ++n5) {
                boolean bl2;
                e2 = this.g.get(n5);
                object = (e)e2.getLayoutParams();
                b b2 = object.b();
                if (b2 == null || !b2.a(this, e2, view)) continue;
                if (n2 == 0 && object.g()) {
                    object.h();
                    continue;
                }
                if (n2 != 2) {
                    bl2 = b2.b(this, e2, view);
                } else {
                    b2.c(this, e2, view);
                    bl2 = true;
                }
                if (n2 != 1) continue;
                object.a(bl2);
            }
        }
        CoordinatorLayout.a(rect);
        CoordinatorLayout.a(rect2);
        CoordinatorLayout.a(rect3);
    }

    public void a(View view, int n2) {
        e e2 = (e)view.getLayoutParams();
        if (!e2.d()) {
            if (e2.k != null) {
                this.a(view, e2.k, n2);
                return;
            }
            if (e2.e >= 0) {
                this.b(view, e2.e, n2);
                return;
            }
            this.d(view, n2);
            return;
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public void a(View view, int n2, int n3, int n4, int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }

    @Override
    public void a(View view, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.getChildCount();
        boolean bl2 = false;
        for (int i2 = 0; i2 < n7; ++i2) {
            Object object;
            View view2 = this.getChildAt(i2);
            if (view2.getVisibility() == 8 || !((e)((Object)(object = (e)view2.getLayoutParams()))).b(n6) || (object = ((e)((Object)object)).b()) == null) continue;
            ((b)object).a(this, view2, view, n2, n3, n4, n5, n6);
            bl2 = true;
        }
        if (bl2) {
            this.a(1);
        }
    }

    @Override
    public void a(View view, int n2, int n3, int[] arrn, int n4) {
        int n5 = this.getChildCount();
        boolean bl2 = false;
        int n6 = 0;
        int n7 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n8;
            int n9;
            View view2 = this.getChildAt(i2);
            if (view2.getVisibility() == 8) {
                n8 = n6;
                n9 = n7;
            } else {
                Object object = (e)view2.getLayoutParams();
                if (!object.b(n4)) {
                    n8 = n6;
                    n9 = n7;
                } else {
                    object = object.b();
                    n8 = n6;
                    n9 = n7;
                    if (object != null) {
                        int[] arrn2 = this.k;
                        this.k[1] = 0;
                        arrn2[0] = 0;
                        ((b)object).a(this, view2, view, n2, n3, this.k, n4);
                        n9 = n2 > 0 ? Math.max(n6, this.k[0]) : Math.min(n6, this.k[0]);
                        n7 = n3 > 0 ? Math.max(n7, this.k[1]) : Math.min(n7, this.k[1]);
                        n8 = n9;
                        n9 = n7;
                        bl2 = true;
                    }
                }
            }
            n6 = n8;
            n7 = n9;
        }
        arrn[0] = n6;
        arrn[1] = n7;
        if (bl2) {
            this.a(1);
        }
    }

    void a(View view, int n2, Rect rect, Rect rect2) {
        e e2 = (e)view.getLayoutParams();
        int n3 = view.getMeasuredWidth();
        int n4 = view.getMeasuredHeight();
        this.a(view, n2, rect, rect2, e2, n3, n4);
        this.a(e2, rect2, n3, n4);
    }

    void a(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.b(this, view, rect);
    }

    void a(View view, boolean bl2, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (bl2) {
                this.a(view, rect);
                return;
            }
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            return;
        }
        rect.setEmpty();
    }

    public boolean a(View view, int n2, int n3) {
        Rect rect = CoordinatorLayout.e();
        this.a(view, rect);
        try {
            boolean bl2 = rect.contains(n2, n3);
            return bl2;
        }
        finally {
            CoordinatorLayout.a(rect);
        }
    }

    @Override
    public boolean a(View view, View view2, int n2, int n3) {
        int n4 = this.getChildCount();
        boolean bl2 = false;
        for (int i2 = 0; i2 < n4; ++i2) {
            View view3 = this.getChildAt(i2);
            if (view3.getVisibility() == 8) continue;
            e e2 = (e)view3.getLayoutParams();
            b b2 = e2.b();
            if (b2 != null) {
                boolean bl3 = b2.a(this, view3, view, view2, n2, n3);
                e2.a(n3, bl3);
                bl2 |= bl3;
                continue;
            }
            e2.a(n3, false);
        }
        return bl2;
    }

    void b() {
        if (this.n) {
            if (this.r == null) {
                this.r = new f();
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.r);
        }
        this.s = true;
    }

    public void b(View view) {
        List list = this.h.c(view);
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                View view2 = (View)list.get(i2);
                b b2 = ((e)view2.getLayoutParams()).b();
                if (b2 == null) continue;
                b2.b(this, view2, view);
            }
        }
    }

    void b(View view, int n2) {
        block6 : {
            int n3;
            Rect rect;
            b b2;
            int n4;
            Rect rect2;
            e e2;
            Rect rect3;
            int n5;
            block8 : {
                block7 : {
                    e2 = (e)view.getLayoutParams();
                    if (e2.k == null) break block6;
                    rect2 = CoordinatorLayout.e();
                    rect3 = CoordinatorLayout.e();
                    rect = CoordinatorLayout.e();
                    this.a(e2.k, rect2);
                    n4 = 0;
                    this.a(view, false, rect3);
                    n5 = view.getMeasuredWidth();
                    n3 = view.getMeasuredHeight();
                    this.a(view, n2, rect2, rect, e2, n5, n3);
                    if (rect.left != rect3.left) break block7;
                    n2 = n4;
                    if (rect.top == rect3.top) break block8;
                }
                n2 = 1;
            }
            this.a(e2, rect, n5, n3);
            n4 = rect.left - rect3.left;
            n5 = rect.top - rect3.top;
            if (n4 != 0) {
                t.f(view, n4);
            }
            if (n5 != 0) {
                t.e(view, n5);
            }
            if (n2 != 0 && (b2 = e2.b()) != null) {
                b2.b(this, view, e2.k);
            }
            CoordinatorLayout.a(rect2);
            CoordinatorLayout.a(rect3);
            CoordinatorLayout.a(rect);
        }
    }

    void b(View view, Rect rect) {
        ((e)view.getLayoutParams()).a(rect);
    }

    @Override
    public void b(View view, View view2, int n2, int n3) {
        this.x.a(view, view2, n2, n3);
        this.q = view2;
        int n4 = this.getChildCount();
        for (int i2 = 0; i2 < n4; ++i2) {
            View view3 = this.getChildAt(i2);
            Object object = (e)view3.getLayoutParams();
            if (!object.b(n3) || (object = object.b()) == null) continue;
            ((b)object).b(this, view3, view, view2, n2, n3);
        }
    }

    public List<View> c(View object) {
        object = this.h.d((View)object);
        this.j.clear();
        if (object != null) {
            this.j.addAll((Collection<View>)object);
        }
        return this.j;
    }

    void c() {
        if (this.n && this.r != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.r);
        }
        this.s = false;
    }

    @Override
    public void c(View view, int n2) {
        this.x.a(view, n2);
        int n3 = this.getChildCount();
        for (int i2 = 0; i2 < n3; ++i2) {
            View view2 = this.getChildAt(i2);
            e e2 = (e)view2.getLayoutParams();
            if (!e2.b(n2)) continue;
            b b2 = e2.b();
            if (b2 != null) {
                b2.a(this, view2, view, n2);
            }
            e2.a(n2);
            e2.h();
        }
        this.q = null;
    }

    void c(View view, Rect rect) {
        rect.set(((e)view.getLayoutParams()).c());
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e && super.checkLayoutParams(layoutParams);
    }

    protected e d() {
        return new e(-2, -2);
    }

    public List<View> d(View object) {
        object = this.h.c((View)object);
        this.j.clear();
        if (object != null) {
            this.j.addAll((Collection<View>)object);
        }
        return this.j;
    }

    protected boolean drawChild(Canvas canvas, View view, long l2) {
        float f2;
        e e2 = (e)view.getLayoutParams();
        if (e2.a != null && (f2 = e2.a.b(this, view)) > 0.0f) {
            if (this.l == null) {
                this.l = new Paint();
            }
            this.l.setColor(e2.a.a(this, view));
            this.l.setAlpha(CoordinatorLayout.a(Math.round(f2 * 255.0f), 0, 255));
            int n2 = canvas.save();
            if (view.isOpaque()) {
                canvas.clipRect((float)view.getLeft(), (float)view.getTop(), (float)view.getRight(), (float)view.getBottom(), Region.Op.DIFFERENCE);
            }
            canvas.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), this.l);
            canvas.restoreToCount(n2);
        }
        return super.drawChild(canvas, view, l2);
    }

    protected void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        int[] arrn = this.getDrawableState();
        Drawable drawable2 = this.v;
        boolean bl3 = bl2 = false;
        if (drawable2 != null) {
            bl3 = bl2;
            if (drawable2.isStateful()) {
                bl3 = false | drawable2.setState(arrn);
            }
        }
        if (bl3) {
            this.invalidate();
        }
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.d();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    final List<View> getDependencySortedChildren() {
        this.f();
        return Collections.unmodifiableList(this.g);
    }

    public final ab getLastWindowInsets() {
        return this.t;
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new f();
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.r);
        }
        if (this.t == null && t.r((View)this)) {
            t.q((View)this);
        }
        this.n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a(false);
        if (this.s && this.r != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.r);
        }
        if (this.q != null) {
            this.onStopNestedScroll(this.q);
        }
        this.n = false;
    }

    public void onDraw(Canvas canvas) {
        int n2;
        super.onDraw(canvas);
        if (this.u && this.v != null && (n2 = this.t != null ? this.t.b() : 0) > 0) {
            this.v.setBounds(0, 0, this.getWidth(), n2);
            this.v.draw(canvas);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 0) {
            this.a(true);
        }
        boolean bl2 = this.a(motionEvent, 0);
        if (n2 == 1 || n2 == 3) {
            this.a(true);
        }
        return bl2;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        n3 = t.f((View)this);
        n4 = this.g.size();
        for (n2 = 0; n2 < n4; ++n2) {
            b b2;
            View view = this.g.get(n2);
            if (view.getVisibility() == 8 || (b2 = ((e)view.getLayoutParams()).b()) != null && b2.a(this, view, n3)) continue;
            this.a(view, n3);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onMeasure(int var1_1, int var2_2) {
        this.f();
        this.a();
        var13_3 = this.getPaddingLeft();
        var14_4 = this.getPaddingTop();
        var15_5 = this.getPaddingRight();
        var16_6 = this.getPaddingBottom();
        var17_7 = t.f((View)this);
        var5_8 = var17_7 == 1;
        var18_9 = View.MeasureSpec.getMode((int)var1_1);
        var19_10 = View.MeasureSpec.getSize((int)var1_1);
        var20_11 = View.MeasureSpec.getMode((int)var2_2);
        var21_12 = View.MeasureSpec.getSize((int)var2_2);
        var10_13 = this.getSuggestedMinimumWidth();
        var4_14 = this.getSuggestedMinimumHeight();
        var6_15 = this.t != null && t.r((View)this) != false;
        var7_16 = this.g.size();
        var9_17 = 0;
        var8_18 = 0;
        do {
            block9 : {
                if (var8_18 >= var7_16) {
                    this.setMeasuredDimension(View.resolveSizeAndState((int)var10_13, (int)var1_1, (int)(-16777216 & var9_17)), View.resolveSizeAndState((int)var4_14, (int)var2_2, (int)(var9_17 << 16)));
                    return;
                }
                var25_25 = this.g.get(var8_18);
                if (var25_25.getVisibility() == 8) break block9;
                var24_24 = (e)var25_25.getLayoutParams();
                if (var24_24.e < 0 || var18_9 == 0) ** GOTO lbl-1000
                var3_19 = this.b(var24_24.e);
                var11_20 = androidx.core.h.d.a(CoordinatorLayout.d(var24_24.c), var17_7) & 7;
                if (var11_20 == 3 && !var5_8 || var11_20 == 5 && var5_8) {
                    var3_19 = Math.max(0, var19_10 - var15_5 - var3_19);
                } else if (var11_20 == 5 && !var5_8 || var11_20 == 3 && var5_8) {
                    var3_19 = Math.max(0, var3_19 - var13_3);
                } else lbl-1000: // 2 sources:
                {
                    var3_19 = 0;
                }
                var12_21 = var4_14;
                if (var6_15 && !t.r(var25_25)) {
                    var4_14 = this.t.a();
                    var23_23 = this.t.c();
                    var11_20 = this.t.b();
                    var22_22 = this.t.d();
                    var4_14 = View.MeasureSpec.makeMeasureSpec((int)(var19_10 - (var4_14 + var23_23)), (int)var18_9);
                    var11_20 = View.MeasureSpec.makeMeasureSpec((int)(var21_12 - (var11_20 + var22_22)), (int)var20_11);
                } else {
                    var4_14 = var1_1;
                    var11_20 = var2_2;
                }
                var26_26 = var24_24.b();
                if (var26_26 == null || !var26_26.a(this, var25_25, var4_14, var3_19, var11_20, 0)) {
                    this.a(var25_25, var4_14, var3_19, var11_20, 0);
                }
                var10_13 = Math.max(var10_13, var13_3 + var15_5 + var25_25.getMeasuredWidth() + var24_24.leftMargin + var24_24.rightMargin);
                var4_14 = Math.max(var12_21, var14_4 + var16_6 + var25_25.getMeasuredHeight() + var24_24.topMargin + var24_24.bottomMargin);
                var9_17 = View.combineMeasuredStates((int)var9_17, (int)var25_25.getMeasuredState());
            }
            ++var8_18;
        } while (true);
    }

    @Override
    public boolean onNestedFling(View view, float f2, float f3, boolean bl2) {
        int n2 = this.getChildCount();
        boolean bl3 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl4;
            View view2 = this.getChildAt(i2);
            if (view2.getVisibility() == 8) {
                bl4 = bl3;
            } else {
                Object object = (e)view2.getLayoutParams();
                if (!object.b(0)) {
                    bl4 = bl3;
                } else {
                    object = object.b();
                    bl4 = bl3;
                    if (object != null) {
                        bl4 = bl3 | ((b)object).a(this, view2, view, f2, f3, bl2);
                    }
                }
            }
            bl3 = bl4;
        }
        if (bl3) {
            this.a(1);
        }
        return bl3;
    }

    @Override
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int n2 = this.getChildCount();
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl3;
            View view2 = this.getChildAt(i2);
            if (view2.getVisibility() == 8) {
                bl3 = bl2;
            } else {
                Object object = (e)view2.getLayoutParams();
                if (!object.b(0)) {
                    bl3 = bl2;
                } else {
                    object = object.b();
                    bl3 = bl2;
                    if (object != null) {
                        bl3 = bl2 | ((b)object).a(this, view2, view, f2, f3);
                    }
                }
            }
            bl2 = bl3;
        }
        return bl2;
    }

    @Override
    public void onNestedPreScroll(View view, int n2, int n3, int[] arrn) {
        this.a(view, n2, n3, arrn, 0);
    }

    @Override
    public void onNestedScroll(View view, int n2, int n3, int n4, int n5) {
        this.a(view, n2, n3, n4, n5, 0);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n2) {
        this.b(view, view2, n2, 0);
    }

    protected void onRestoreInstanceState(Parcelable sparseArray) {
        if (!(sparseArray instanceof g)) {
            super.onRestoreInstanceState((Parcelable)sparseArray);
            return;
        }
        sparseArray = (g)sparseArray;
        super.onRestoreInstanceState(sparseArray.a());
        sparseArray = sparseArray.a;
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            Parcelable parcelable;
            View view = this.getChildAt(i2);
            int n3 = view.getId();
            b b2 = this.a(view).b();
            if (n3 == -1 || b2 == null || (parcelable = (Parcelable)sparseArray.get(n3)) == null) continue;
            b2.a(this, view, parcelable);
        }
    }

    protected Parcelable onSaveInstanceState() {
        g g2 = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.getChildAt(i2);
            int n3 = view.getId();
            b b2 = ((e)view.getLayoutParams()).b();
            if (n3 == -1 || b2 == null || (view = b2.d(this, view)) == null) continue;
            sparseArray.append(n3, (Object)view);
        }
        g2.a = sparseArray;
        return g2;
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n2) {
        return this.a(view, view2, n2, 0);
    }

    @Override
    public void onStopNestedScroll(View view) {
        this.c(view, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block8 : {
            block7 : {
                var2_6 = var1_1 /* !! */ .getActionMasked();
                if (this.p != null) break block7;
                var4_8 = var3_7 = this.a(var1_1 /* !! */ , 1);
                if (!var3_7) ** GOTO lbl-1000
                break block8;
            }
            var3_7 = false;
        }
        var8_9 = ((e)this.p.getLayoutParams()).b();
        var4_8 = var3_7;
        if (var8_9 != null) {
            var4_8 = var8_9.b(this, this.p, var1_1 /* !! */ );
        } else lbl-1000: // 2 sources:
        {
            var5_10 = false;
            var3_7 = var4_8;
            var4_8 = var5_10;
        }
        var9_11 = this.p;
        var8_9 = null;
        if (var9_11 == null) {
            var5_10 = var4_8 | super.onTouchEvent(var1_1 /* !! */ );
            var1_2 = var8_9;
        } else {
            var5_10 = var4_8;
            var1_3 = var8_9;
            if (var3_7) {
                var6_12 = SystemClock.uptimeMillis();
                var1_4 = MotionEvent.obtain((long)var6_12, (long)var6_12, (int)3, (float)0.0f, (float)0.0f, (int)0);
                super.onTouchEvent(var1_4);
                var5_10 = var4_8;
            }
        }
        if (var1_5 != null) {
            var1_5.recycle();
        }
        if (var2_6 != 1) {
            if (var2_6 != 3) return var5_10;
        }
        this.a(false);
        return var5_10;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        b b2 = ((e)view.getLayoutParams()).b();
        if (b2 != null && b2.a(this, view, rect, bl2)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        super.requestDisallowInterceptTouchEvent(bl2);
        if (bl2 && !this.m) {
            this.a(false);
            this.m = true;
        }
    }

    public void setFitsSystemWindows(boolean bl2) {
        super.setFitsSystemWindows(bl2);
        this.g();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable2) {
        if (this.v != drawable2) {
            Drawable drawable3 = this.v;
            Drawable drawable4 = null;
            if (drawable3 != null) {
                this.v.setCallback(null);
            }
            if (drawable2 != null) {
                drawable4 = drawable2.mutate();
            }
            this.v = drawable4;
            if (this.v != null) {
                if (this.v.isStateful()) {
                    this.v.setState(this.getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.v, t.f((View)this));
                drawable2 = this.v;
                boolean bl2 = this.getVisibility() == 0;
                drawable2.setVisible(bl2, false);
                this.v.setCallback((Drawable.Callback)this);
            }
            t.d((View)this);
        }
    }

    public void setStatusBarBackgroundColor(int n2) {
        this.setStatusBarBackground((Drawable)new ColorDrawable(n2));
    }

    public void setStatusBarBackgroundResource(int n2) {
        Drawable drawable2 = n2 != 0 ? androidx.core.a.a.a(this.getContext(), n2) : null;
        this.setStatusBarBackground(drawable2);
    }

    public void setVisibility(int n2) {
        super.setVisibility(n2);
        boolean bl2 = n2 == 0;
        if (this.v != null && this.v.isVisible() != bl2) {
            this.v.setVisible(bl2, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        return super.verifyDrawable(drawable2) || drawable2 == this.v;
        {
        }
    }

    public static interface a {
        public b getBehavior();
    }

    public static abstract class b<V extends View> {
        public b() {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public int a(CoordinatorLayout coordinatorLayout, V v2) {
            return -16777216;
        }

        public ab a(CoordinatorLayout coordinatorLayout, V v2, ab ab2) {
            return ab2;
        }

        public void a() {
        }

        public void a(e e2) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int n2) {
            if (n2 == 0) {
                this.d(coordinatorLayout, v2, view);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int n2, int n3, int n4, int n5) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int n2, int n3, int n4, int n5, int n6) {
            if (n6 == 0) {
                this.a(coordinatorLayout, v2, view, n2, n3, n4, n5);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int n2, int n3, int[] arrn) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int n2, int n3, int[] arrn, int n4) {
            if (n4 == 0) {
                this.a(coordinatorLayout, v2, view, n2, n3, arrn);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, int n2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, int n2, int n3, int n4, int n5) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, Rect rect, boolean bl2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3, boolean bl2) {
            return false;
        }

        @Deprecated
        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int n2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int n2, int n3) {
            if (n3 == 0) {
                return this.a(coordinatorLayout, v2, view, view2, n2);
            }
            return false;
        }

        public float b(CoordinatorLayout coordinatorLayout, V v2) {
            return 0.0f;
        }

        @Deprecated
        public void b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int n2) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int n2, int n3) {
            if (n3 == 0) {
                this.b(coordinatorLayout, v2, view, view2, n2);
            }
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v2, View view) {
            return false;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v2, View view) {
        }

        public boolean c(CoordinatorLayout coordinatorLayout, V v2) {
            return this.b(coordinatorLayout, v2) > 0.0f;
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v2, View view) {
        }
    }

    @Deprecated
    @Retention(value=RetentionPolicy.RUNTIME)
    public static @interface c {
        public Class<? extends b> a();
    }

    private class d
    implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class e
    extends ViewGroup.MarginLayoutParams {
        b a;
        boolean b = false;
        public int c = 0;
        public int d = 0;
        public int e = -1;
        int f = -1;
        public int g = 0;
        public int h = 0;
        int i;
        int j;
        View k;
        View l;
        final Rect m = new Rect();
        Object n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        public e(int n2, int n3) {
            super(n2, n3);
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout_Layout);
            this.c = typedArray.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = typedArray.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = typedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = typedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = typedArray.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = typedArray.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.b = typedArray.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.b) {
                this.a = CoordinatorLayout.a(context, attributeSet, typedArray.getString(a.c.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArray.recycle();
            if (this.a != null) {
                this.a.a(this);
            }
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public e(e e2) {
            super((ViewGroup.MarginLayoutParams)e2);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(View view, CoordinatorLayout coordinatorLayout) {
            block5 : {
                View view2;
                block8 : {
                    block6 : {
                        block7 : {
                            this.k = coordinatorLayout.findViewById(this.f);
                            if (this.k == null) break block6;
                            if (this.k != coordinatorLayout) break block7;
                            if (!coordinatorLayout.isInEditMode()) {
                                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                            }
                            break block5;
                        }
                        view2 = this.k;
                        break block8;
                    }
                    if (!coordinatorLayout.isInEditMode()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
                        stringBuilder.append(coordinatorLayout.getResources().getResourceName(this.f));
                        stringBuilder.append(" to anchor view ");
                        stringBuilder.append((Object)view);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    break block5;
                }
                for (ViewParent viewParent = this.k.getParent(); viewParent != coordinatorLayout && viewParent != null; viewParent = viewParent.getParent()) {
                    if (viewParent == view) {
                        if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                        break block5;
                    }
                    if (!(viewParent instanceof View)) continue;
                    view2 = (View)viewParent;
                }
                this.l = view2;
                return;
            }
            this.l = null;
            this.k = null;
        }

        private boolean a(View view, int n2) {
            int n3 = androidx.core.h.d.a(((e)view.getLayoutParams()).g, n2);
            return n3 != 0 && (androidx.core.h.d.a(this.h, n2) & n3) == n3;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent viewParent = this.k.getParent(); viewParent != coordinatorLayout; viewParent = viewParent.getParent()) {
                if (viewParent != null && viewParent != view) {
                    if (!(viewParent instanceof View)) continue;
                    view2 = (View)viewParent;
                    continue;
                }
                this.l = null;
                this.k = null;
                return false;
            }
            this.l = view2;
            return true;
        }

        public int a() {
            return this.f;
        }

        void a(int n2) {
            this.a(n2, false);
        }

        void a(int n2, boolean bl2) {
            switch (n2) {
                default: {
                    return;
                }
                case 1: {
                    this.q = bl2;
                    return;
                }
                case 0: 
            }
            this.p = bl2;
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        public void a(b b2) {
            if (this.a != b2) {
                if (this.a != null) {
                    this.a.a();
                }
                this.a = b2;
                this.n = null;
                this.b = true;
                if (b2 != null) {
                    b2.a(this);
                }
            }
        }

        void a(boolean bl2) {
            this.r = bl2;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.o) {
                return true;
            }
            boolean bl2 = this.o;
            boolean bl3 = this.a != null ? this.a.c(coordinatorLayout, view) : false;
            this.o = bl3 |= bl2;
            return bl3;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.l || this.a(view2, t.f((View)coordinatorLayout)) || this.a != null && this.a.a(coordinatorLayout, view, view2);
            {
            }
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !this.b(view, coordinatorLayout)) {
                this.a(view, coordinatorLayout);
            }
            return this.k;
        }

        public b b() {
            return this.a;
        }

        boolean b(int n2) {
            switch (n2) {
                default: {
                    return false;
                }
                case 1: {
                    return this.q;
                }
                case 0: 
            }
            return this.p;
        }

        Rect c() {
            return this.m;
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.a == null) {
                this.o = false;
            }
            return this.o;
        }

        void f() {
            this.o = false;
        }

        boolean g() {
            return this.r;
        }

        void h() {
            this.r = false;
        }
    }

    class f
    implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    protected static class g
    extends androidx.e.a.a {
        public static final Parcelable.Creator<g> CREATOR = new Parcelable.ClassLoaderCreator<g>(){

            public g a(Parcel parcel) {
                return new g(parcel, null);
            }

            public g a(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            public g[] a(int n2) {
                return new g[n2];
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
        SparseArray<Parcelable> a;

        public g(Parcel arrparcelable, ClassLoader classLoader) {
            super((Parcel)arrparcelable, classLoader);
            int n2 = arrparcelable.readInt();
            int[] arrn = new int[n2];
            arrparcelable.readIntArray(arrn);
            arrparcelable = arrparcelable.readParcelableArray(classLoader);
            this.a = new SparseArray(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.a.append(arrn[i2], (Object)arrparcelable[i2]);
            }
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            int[] arrn = this.a;
            int n3 = arrn != null ? this.a.size() : 0;
            parcel.writeInt(n3);
            arrn = new int[n3];
            Parcelable[] arrparcelable = new Parcelable[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                arrn[i2] = this.a.keyAt(i2);
                arrparcelable[i2] = (Parcelable)this.a.valueAt(i2);
            }
            parcel.writeIntArray(arrn);
            parcel.writeParcelableArray(arrparcelable, n2);
        }

    }

    static class h
    implements Comparator<View> {
        h() {
        }

        public int a(View view, View view2) {
            float f2;
            float f3 = t.z(view);
            if (f3 > (f2 = t.z(view2))) {
                return -1;
            }
            return f3 < f2;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((View)object, (View)object2);
        }
    }

}

