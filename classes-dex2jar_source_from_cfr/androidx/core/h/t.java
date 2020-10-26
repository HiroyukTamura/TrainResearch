/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.SparseArray
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.PointerIcon
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.WindowInsets
 *  android.view.WindowManager
 */
package androidx.core.h;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.a;
import androidx.core.h.ab;
import androidx.core.h.j;
import androidx.core.h.k;
import androidx.core.h.p;
import androidx.core.h.q;
import androidx.core.h.r;
import androidx.core.h.x;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class t {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static WeakHashMap<View, x> g;
    private static Field h;
    private static boolean i;
    private static ThreadLocal<Rect> j;

    static {
        g = null;
        i = false;
    }

    public static Rect A(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean C(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static Display D(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (t.B(view)) {
            return ((WindowManager)view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    private static void E(View view) {
        float f2 = view.getTranslationY();
        view.setTranslationY(1.0f + f2);
        view.setTranslationY(f2);
    }

    @SuppressLint(value={"InlinedApi"})
    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    private static Rect a() {
        Rect rect;
        if (j == null) {
            j = new ThreadLocal();
        }
        Rect rect2 = rect = j.get();
        if (rect == null) {
            rect2 = new Rect();
            j.set(rect2);
        }
        rect2.setEmpty();
        return rect2;
    }

    public static ab a(View object, ab ab2) {
        if (Build.VERSION.SDK_INT >= 21) {
            ab2 = (WindowInsets)ab.a(ab2);
            WindowInsets windowInsets = object.onApplyWindowInsets((WindowInsets)ab2);
            object = ab2;
            if (windowInsets != ab2) {
                object = new WindowInsets(windowInsets);
            }
            return ab.a(object);
        }
        return ab2;
    }

    @Deprecated
    public static void a(View view, float f2) {
        view.setTranslationX(f2);
    }

    public static void a(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(n2);
        }
    }

    public static void a(View view, int n2, int n3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(n2, n3);
        }
    }

    public static void a(View view, int n2, int n3, int n4, int n5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(n2, n3, n4, n5);
            return;
        }
        view.setPadding(n2, n3, n4, n5);
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                colorStateList = view.getBackground();
                boolean bl2 = view.getBackgroundTintList() != null || view.getBackgroundTintMode() != null;
                if (colorStateList != null && bl2) {
                    if (colorStateList.isStateful()) {
                        colorStateList.setState(view.getDrawableState());
                    }
                    view.setBackground((Drawable)colorStateList);
                    return;
                }
            }
        } else if (view instanceof r) {
            ((r)view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                mode = view.getBackground();
                boolean bl2 = view.getBackgroundTintList() != null || view.getBackgroundTintMode() != null;
                if (mode != null && bl2) {
                    if (mode.isStateful()) {
                        mode.setState(view.getDrawableState());
                    }
                    view.setBackground((Drawable)mode);
                    return;
                }
            }
        } else if (view instanceof r) {
            ((r)view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable2);
            return;
        }
        view.setBackgroundDrawable(drawable2);
    }

    public static void a(View view, androidx.core.h.a a2) {
        a2 = a2 == null ? null : a2.a();
        view.setAccessibilityDelegate((View.AccessibilityDelegate)a2);
    }

    public static void a(View view, final p p2) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (p2 == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(){

                public WindowInsets onApplyWindowInsets(View view, WindowInsets object) {
                    object = ab.a(object);
                    return (WindowInsets)ab.a(p2.a(view, (ab)object));
                }
            });
        }
    }

    public static void a(View view, q object) {
        if (Build.VERSION.SDK_INT >= 24) {
            object = object != null ? ((q)object).a() : null;
            view.setPointerIcon((PointerIcon)object);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
            return;
        }
        view.postDelayed(runnable, ValueAnimator.getFrameDelay());
    }

    public static void a(View view, Runnable runnable, long l2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, l2);
            return;
        }
        view.postDelayed(runnable, ValueAnimator.getFrameDelay() + l2);
    }

    public static void a(View view, String string2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(string2);
            return;
        }
        if (f == null) {
            f = new WeakHashMap();
        }
        f.put(view, string2);
    }

    public static void a(View view, boolean bl2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(bl2);
        }
    }

    static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return b.a(view).a(keyEvent);
    }

    public static ab b(View object, ab ab2) {
        if (Build.VERSION.SDK_INT >= 21) {
            ab2 = (WindowInsets)ab.a(ab2);
            WindowInsets windowInsets = object.dispatchApplyWindowInsets((WindowInsets)ab2);
            object = ab2;
            if (windowInsets != ab2) {
                object = new WindowInsets(windowInsets);
            }
            return ab.a(object);
        }
        return ab2;
    }

    @Deprecated
    public static void b(View view, float f2) {
        view.setTranslationY(f2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void b(View view, int n2) {
        int n3;
        if (Build.VERSION.SDK_INT >= 19) {
            n3 = n2;
        } else {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            n3 = n2;
            if (n2 == 4) {
                n3 = 2;
            }
        }
        view.setImportantForAccessibility(n3);
    }

    @Deprecated
    public static void b(View view, boolean bl2) {
        view.setFitsSystemWindows(bl2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean b(View object) {
        boolean bl2 = i;
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        if (h == null) {
            h = View.class.getDeclaredField("mAccessibilityDelegate");
            h.setAccessible(true);
        }
        try {
            Object object2 = h.get(object);
            if (object2 == null) return bl3;
            return true;
        }
        catch (Throwable throwable) {}
        catch (Throwable throwable) {}
        i = true;
        return false;
        i = true;
        return false;
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return b.a(view).a(view, keyEvent);
    }

    public static void c(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void c(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(n2);
        }
    }

    public static boolean c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
            return;
        }
        view.postInvalidate();
    }

    public static void d(View view, int n2) {
        if (view instanceof k) {
            ((k)view).a(n2);
            return;
        }
        if (n2 == 0) {
            t.x(view);
        }
    }

    public static int e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void e(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect rect = t.a();
            boolean bl2 = false;
            ViewParent viewParent = view.getParent();
            if (viewParent instanceof View) {
                View view2 = (View)viewParent;
                rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                bl2 = rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ true;
            }
            t.g(view, n2);
            if (bl2 && rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View)viewParent).invalidate(rect);
                return;
            }
        } else {
            t.g(view, n2);
        }
    }

    public static int f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void f(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect rect = t.a();
            boolean bl2 = false;
            ViewParent viewParent = view.getParent();
            if (viewParent instanceof View) {
                View view2 = (View)viewParent;
                rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                bl2 = rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ true;
            }
            t.h(view, n2);
            if (bl2 && rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View)viewParent).invalidate(rect);
                return;
            }
        } else {
            t.h(view, n2);
        }
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    private static void g(View view, int n2) {
        view.offsetTopAndBottom(n2);
        if (view.getVisibility() == 0) {
            t.E(view);
            view = view.getParent();
            if (view instanceof View) {
                t.E(view);
            }
        }
    }

    public static int h(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    private static void h(View view, int n2) {
        view.offsetLeftAndRight(n2);
        if (view.getVisibility() == 0) {
            t.E(view);
            view = view.getParent();
            if (view instanceof View) {
                t.E(view);
            }
        }
    }

    @Deprecated
    public static float i(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float j(View view) {
        return view.getTranslationY();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                b = View.class.getDeclaredField("mMinWidth");
                b.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            c = true;
        }
        if (b == null) return 0;
        try {
            return (Integer)b.get((Object)view);
        }
        catch (Exception exception) {
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinHeight");
                d.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            e = true;
        }
        if (d == null) return 0;
        try {
            return (Integer)d.get((Object)view);
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public static x m(View view) {
        x x2;
        if (g == null) {
            g = new WeakHashMap();
        }
        x x3 = x2 = g.get((Object)view);
        if (x2 == null) {
            x3 = new x(view);
            g.put(view, x3);
        }
        return x3;
    }

    public static float n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static String o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        if (f == null) {
            return null;
        }
        return f.get((Object)view);
    }

    public static int p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void q(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean r(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static boolean s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean t(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static ColorStateList u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof r) {
            return ((r)view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode v(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof r) {
            return ((r)view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static boolean w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof j) {
            return ((j)view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void x(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
            return;
        }
        if (view instanceof j) {
            ((j)view).stopNestedScroll();
        }
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float z(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static interface a {
        public boolean a(View var1, KeyEvent var2);
    }

    static class b {
        private static final ArrayList<WeakReference<View>> a = new ArrayList();
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        b() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray();
            }
            return this.c;
        }

        static b a(View view) {
            b b2;
            b b3 = b2 = (b)view.getTag(a.b.tag_unhandled_key_event_manager);
            if (b2 == null) {
                b3 = new b();
                view.setTag(a.b.tag_unhandled_key_event_manager, (Object)b3);
            }
            return b3;
        }

        private View b(View view, KeyEvent keyEvent) {
            if (this.b != null) {
                if (!this.b.containsKey((Object)view)) {
                    return null;
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup)view;
                    for (int i2 = viewGroup.getChildCount() - 1; i2 >= 0; --i2) {
                        View view2 = this.b(viewGroup.getChildAt(i2), keyEvent);
                        if (view2 == null) continue;
                        return view2;
                    }
                }
                if (this.c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void b() {
            if (this.b != null) {
                this.b.clear();
            }
            if (a.isEmpty()) {
                return;
            }
            ArrayList<WeakReference<View>> arrayList = a;
            synchronized (arrayList) {
                if (this.b == null) {
                    this.b = new WeakHashMap();
                }
                int n2 = a.size() - 1;
                while (n2 >= 0) {
                    View view = (View)a.get(n2).get();
                    if (view == null) {
                        a.remove(n2);
                    } else {
                        this.b.put(view, Boolean.TRUE);
                        view = view.getParent();
                        while (view instanceof View) {
                            this.b.put(view, Boolean.TRUE);
                            view = view.getParent();
                        }
                    }
                    --n2;
                }
                return;
            }
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList)view.getTag(a.b.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                    if (!((a)arrayList.get(i2)).a(view, keyEvent)) continue;
                    return true;
                }
            }
            return false;
        }

        boolean a(KeyEvent keyEvent) {
            if (this.d != null && this.d.get() == keyEvent) {
                return false;
            }
            this.d = new WeakReference<KeyEvent>(keyEvent);
            Reference reference = null;
            SparseArray<WeakReference<View>> sparseArray = this.a();
            Reference reference2 = reference;
            if (keyEvent.getAction() == 1) {
                int n2 = sparseArray.indexOfKey(keyEvent.getKeyCode());
                reference2 = reference;
                if (n2 >= 0) {
                    reference2 = (WeakReference)sparseArray.valueAt(n2);
                    sparseArray.removeAt(n2);
                }
            }
            reference = reference2;
            if (reference2 == null) {
                reference = (WeakReference)sparseArray.get(keyEvent.getKeyCode());
            }
            if (reference != null) {
                reference2 = (View)reference.get();
                if (reference2 != null && t.B((View)reference2)) {
                    this.c((View)reference2, keyEvent);
                }
                return true;
            }
            return false;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                this.b();
            }
            view = this.b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int n2 = keyEvent.getKeyCode();
                if (view != null && !KeyEvent.isModifierKey((int)n2)) {
                    this.a().put(n2, new WeakReference<View>(view));
                }
            }
            return view != null;
        }
    }

}

