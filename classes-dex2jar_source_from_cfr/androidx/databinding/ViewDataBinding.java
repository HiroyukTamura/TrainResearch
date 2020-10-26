/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.databinding;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.b;
import androidx.databinding.b.a;
import androidx.databinding.i;
import androidx.databinding.j;
import androidx.databinding.k;
import androidx.databinding.l;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.g;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class ViewDataBinding
extends androidx.databinding.a {
    static int a = Build.VERSION.SDK_INT;
    private static final int c = "binding_".length();
    private static final boolean d;
    private static final a e;
    private static final a f;
    private static final a g;
    private static final a h;
    private static final b.a<l, ViewDataBinding, Void> i;
    private static final ReferenceQueue<ViewDataBinding> j;
    private static final View.OnAttachStateChangeListener k;
    protected final androidx.databinding.e b;
    private final Runnable l = new Runnable(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.m = false;
            }
            ViewDataBinding.k();
            if (Build.VERSION.SDK_INT >= 19 && !ViewDataBinding.this.p.isAttachedToWindow()) {
                ViewDataBinding.this.p.removeOnAttachStateChangeListener(k);
                ViewDataBinding.this.p.addOnAttachStateChangeListener(k);
                return;
            }
            ViewDataBinding.this.a();
        }
    };
    private boolean m = false;
    private boolean n = false;
    private f[] o;
    private final View p;
    private androidx.databinding.b<l, ViewDataBinding, Void> q;
    private boolean r;
    private Choreographer s;
    private final Choreographer.FrameCallback t;
    private Handler u;
    private ViewDataBinding v;
    private androidx.lifecycle.j w;
    private OnStartListener x;
    private boolean y;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = a >= 16;
        d = bl2;
        e = new a(){

            @Override
            public f a(ViewDataBinding viewDataBinding, int n2) {
                return new h(viewDataBinding, n2).a();
            }
        };
        f = new a(){

            @Override
            public f a(ViewDataBinding viewDataBinding, int n2) {
                return new e(viewDataBinding, n2).a();
            }
        };
        g = new a(){

            @Override
            public f a(ViewDataBinding viewDataBinding, int n2) {
                return new g(viewDataBinding, n2).a();
            }
        };
        h = new a(){

            @Override
            public f a(ViewDataBinding viewDataBinding, int n2) {
                return new c(viewDataBinding, n2).a();
            }
        };
        i = new b.a<l, ViewDataBinding, Void>(){

            @Override
            public void a(l l2, ViewDataBinding viewDataBinding, int n2, Void void_) {
                switch (n2) {
                    default: {
                        return;
                    }
                    case 3: {
                        l2.c(viewDataBinding);
                        return;
                    }
                    case 2: {
                        l2.b(viewDataBinding);
                        return;
                    }
                    case 1: 
                }
                if (!l2.a(viewDataBinding)) {
                    viewDataBinding.n = true;
                }
            }
        };
        j = new ReferenceQueue();
        View.OnAttachStateChangeListener onAttachStateChangeListener = Build.VERSION.SDK_INT < 19 ? null : new View.OnAttachStateChangeListener(){

            @TargetApi(value=19)
            public void onViewAttachedToWindow(View view) {
                ViewDataBinding.b(view).l.run();
                view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            }

            public void onViewDetachedFromWindow(View view) {
            }
        };
        k = onAttachStateChangeListener;
    }

    protected ViewDataBinding(androidx.databinding.e e2, View view, int n2) {
        this.b = e2;
        this.o = new f[n2];
        this.p = view;
        if (Looper.myLooper() != null) {
            if (d) {
                this.s = Choreographer.getInstance();
                this.t = new Choreographer.FrameCallback(){

                    public void doFrame(long l2) {
                        ViewDataBinding.this.l.run();
                    }
                };
                return;
            }
            this.t = null;
            this.u = new Handler(Looper.myLooper());
            return;
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    private static int a(ViewGroup viewGroup, int n2) {
        String string2 = (String)viewGroup.getChildAt(n2).getTag();
        String string3 = string2.substring(0, string2.length() - 1);
        int n3 = string3.length();
        int n4 = viewGroup.getChildCount();
        int n5 = n2 + 1;
        int n6 = n2;
        for (n2 = n5; n2 < n4; ++n2) {
            Object object = viewGroup.getChildAt(n2);
            object = object.getTag() instanceof String ? (String)object.getTag() : null;
            n5 = n6;
            if (object != null) {
                n5 = n6;
                if (((String)object).startsWith(string3)) {
                    if (((String)object).length() == string2.length() && ((String)object).charAt(((String)object).length() - 1) == '0') {
                        return n6;
                    }
                    n5 = n6;
                    if (ViewDataBinding.a((String)object, n3)) {
                        n5 = n2;
                    }
                }
            }
            n6 = n5;
        }
        return n6;
    }

    protected static int a(Integer n2) {
        if (n2 == null) {
            return 0;
        }
        return n2;
    }

    private static int a(String charSequence, int n2, b arrstring, int n3) {
        charSequence = charSequence.subSequence(charSequence.indexOf(47) + 1, charSequence.length() - 2);
        arrstring = arrstring.a[n3];
        n3 = arrstring.length;
        while (n2 < n3) {
            if (TextUtils.equals((CharSequence)charSequence, (CharSequence)arrstring[n2])) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    protected static Drawable a(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getContext().getDrawable(n2);
        }
        return view.getResources().getDrawable(n2);
    }

    protected static void a(ViewDataBinding viewDataBinding) {
        viewDataBinding.j();
    }

    private static void a(androidx.databinding.e e2, View view, Object[] arrobject, b b2, SparseIntArray sparseIntArray, boolean bl2) {
        int n2;
        int n3;
        if (ViewDataBinding.b(view) != null) {
            return;
        }
        Object object = view.getTag();
        object = object instanceof String ? (String)object : null;
        if (bl2 && object != null && ((String)object).startsWith("layout")) {
            n2 = ((String)object).lastIndexOf(95);
            if (n2 > 0 && ViewDataBinding.a((String)object, ++n2)) {
                if (arrobject[n2 = ViewDataBinding.b((String)object, n2)] == null) {
                    arrobject[n2] = view;
                }
                if (b2 == null) {
                    n2 = -1;
                }
                n3 = n2;
                n2 = 1;
            } else {
                n2 = 0;
                n3 = -1;
            }
        } else if (object != null && ((String)object).startsWith("binding_")) {
            n2 = ViewDataBinding.b((String)object, c);
            if (arrobject[n2] == null) {
                arrobject[n2] = view;
            }
            if (b2 == null) {
                n2 = -1;
            }
            n3 = n2;
            n2 = 1;
        } else {
            n2 = 0;
            n3 = -1;
        }
        if (n2 == 0 && (n2 = view.getId()) > 0 && sparseIntArray != null && (n2 = sparseIntArray.get(n2, -1)) >= 0 && arrobject[n2] == null) {
            arrobject[n2] = view;
        }
        if (view instanceof ViewGroup) {
            view = (ViewGroup)view;
            int n4 = view.getChildCount();
            n2 = 0;
            int n5 = 0;
            do {
                int n6;
                View[] arrview;
                int n7 = 1;
                if (n2 >= n4) break;
                object = view.getChildAt(n2);
                if (n3 >= 0 && object.getTag() instanceof String && (arrview = (View[])object.getTag()).endsWith("_0") && arrview.startsWith("layout") && arrview.indexOf(47) > 0 && (n6 = ViewDataBinding.a((String)arrview, n5, b2, n3)) >= 0) {
                    n5 = n6 + 1;
                    int n8 = b2.b[n3][n6];
                    int n9 = b2.c[n3][n6];
                    n6 = ViewDataBinding.a((ViewGroup)view, n2);
                    if (n6 == n2) {
                        arrobject[n8] = androidx.databinding.f.a(e2, (View)object, n9);
                        n6 = n2;
                        n2 = n5;
                        n5 = n6;
                        n6 = n7;
                    } else {
                        n7 = n6 - n2 + 1;
                        arrview = new View[n7];
                        for (n6 = 0; n6 < n7; ++n6) {
                            arrview[n6] = view.getChildAt(n2 + n6);
                        }
                        arrobject[n8] = androidx.databinding.f.a(e2, arrview, n9);
                        n6 = n2 + (n7 - 1);
                        n2 = n5;
                        n7 = 1;
                        n5 = n6;
                        n6 = n7;
                    }
                } else {
                    n7 = n2;
                    n2 = n5;
                    n6 = 0;
                    n5 = n7;
                }
                if (n6 == 0) {
                    ViewDataBinding.a(e2, (View)object, arrobject, b2, sparseIntArray, false);
                }
                n6 = n5 + 1;
                n5 = n2;
                n2 = n6;
            } while (true);
        }
    }

    protected static boolean a(Boolean bl2) {
        if (bl2 == null) {
            return false;
        }
        return bl2;
    }

    private static boolean a(String string2, int n2) {
        int n3 = string2.length();
        if (n3 == n2) {
            return false;
        }
        for (int i2 = n2; i2 < n3; ++i2) {
            if (Character.isDigit(string2.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    protected static Object[] a(androidx.databinding.e e2, View view, int n2, b b2, SparseIntArray sparseIntArray) {
        Object[] arrobject = new Object[n2];
        ViewDataBinding.a(e2, view, arrobject, b2, sparseIntArray, true);
        return arrobject;
    }

    private static int b(String string2, int n2) {
        int n3 = string2.length();
        int n4 = 0;
        while (n2 < n3) {
            n4 = n4 * 10 + (string2.charAt(n2) - 48);
            ++n2;
        }
        return n4;
    }

    static ViewDataBinding b(View view) {
        if (view != null) {
            return (ViewDataBinding)view.getTag(a.a.dataBinding);
        }
        return null;
    }

    private void b(int n2, Object object, int n3) {
        if (this.y) {
            return;
        }
        if (this.a(n2, object, n3)) {
            this.f();
        }
    }

    private boolean b(int n2, Object object, a a2) {
        if (object == null) {
            return this.b(n2);
        }
        f f2 = this.o[n2];
        if (f2 == null) {
            this.a(n2, object, a2);
            return true;
        }
        if (f2.b() == object) {
            return false;
        }
        this.b(n2);
        this.a(n2, object, a2);
        return true;
    }

    private void j() {
        if (this.r) {
            this.f();
            return;
        }
        if (!this.d()) {
            return;
        }
        this.r = true;
        this.n = false;
        if (this.q != null) {
            this.q.a(this, 1, null);
            if (this.n) {
                this.q.a(this, 2, null);
            }
        }
        if (!this.n) {
            this.b();
            if (this.q != null) {
                this.q.a(this, 3, null);
            }
        }
        this.r = false;
    }

    private static void k() {
        Reference<ViewDataBinding> reference;
        while ((reference = j.poll()) != null) {
            if (!(reference instanceof f)) continue;
            ((f)reference).a();
        }
    }

    public void a() {
        if (this.v == null) {
            this.j();
            return;
        }
        this.v.a();
    }

    protected void a(int n2, Object object, a object2) {
        if (object == null) {
            return;
        }
        f f2 = this.o[n2];
        Object object3 = f2;
        if (f2 == null) {
            this.o[n2] = object2 = object2.a(this, n2);
            object3 = object2;
            if (this.w != null) {
                ((f)object2).a(this.w);
                object3 = object2;
            }
        }
        ((f)object3).a(object);
    }

    protected void a(View view) {
        view.setTag(a.a.dataBinding, (Object)this);
    }

    public void a(androidx.lifecycle.j j2) {
        if (this.w == j2) {
            return;
        }
        if (this.w != null) {
            this.w.g().b(this.x);
        }
        this.w = j2;
        if (j2 != null) {
            if (this.x == null) {
                this.x = new OnStartListener();
            }
            j2.g().a(this.x);
        }
        for (f f2 : this.o) {
            if (f2 == null) continue;
            f2.a(j2);
        }
    }

    protected boolean a(int n2, LiveData<?> liveData) {
        this.y = true;
        try {
            boolean bl2 = this.b(n2, liveData, h);
            return bl2;
        }
        finally {
            this.y = false;
        }
    }

    protected abstract boolean a(int var1, Object var2, int var3);

    protected abstract void b();

    protected void b(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.v = this;
        }
    }

    protected boolean b(int n2) {
        f f2 = this.o[n2];
        if (f2 != null) {
            return f2.a();
        }
        return false;
    }

    public abstract void c();

    public abstract boolean d();

    public View e() {
        return this.p;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void f() {
        if (this.v != null) {
            this.v.f();
            return;
        }
        // MONITORENTER : this
        if (this.m) {
            // MONITOREXIT : this
            return;
        }
        this.m = true;
        // MONITOREXIT : this
        if (this.w != null && !this.w.g().a().a(g.b.d)) {
            return;
        }
        if (d) {
            this.s.postFrameCallback(this.t);
            return;
        }
        this.u.post(this.l);
    }

    public class OnStartListener
    implements androidx.lifecycle.i {
        private OnStartListener() {
        }

        @r(a=g.a.ON_START)
        public void onStart() {
            ViewDataBinding.this.a();
        }
    }

    private static interface a {
        public f a(ViewDataBinding var1, int var2);
    }

    protected static class b {
        public final String[][] a;
        public final int[][] b;
        public final int[][] c;

        public b(int n2) {
            this.a = new String[n2][];
            this.b = new int[n2][];
            this.c = new int[n2][];
        }

        public void a(int n2, String[] arrstring, int[] arrn, int[] arrn2) {
            this.a[n2] = arrstring;
            this.b[n2] = arrn;
            this.c[n2] = arrn2;
        }
    }

    private static class c
    implements d<LiveData<?>>,
    q {
        final f<LiveData<?>> a;
        androidx.lifecycle.j b;

        public c(ViewDataBinding viewDataBinding, int n2) {
            this.a = new f(viewDataBinding, n2, this);
        }

        public f<LiveData<?>> a() {
            return this.a;
        }

        public void a(LiveData<?> liveData) {
            if (this.b != null) {
                liveData.a(this.b, this);
            }
        }

        @Override
        public void a(androidx.lifecycle.j j2) {
            LiveData<?> liveData = this.a.b();
            if (liveData != null) {
                if (this.b != null) {
                    liveData.b(this);
                }
                if (j2 != null) {
                    liveData.a(j2, this);
                }
            }
            this.b = j2;
        }

        public void a(Object object) {
            this.a.c().b(this.a.a, this.a.b(), 0);
        }

        @Override
        public void b(LiveData<?> liveData) {
            liveData.b(this);
        }

        @Override
        public /* synthetic */ void c(Object object) {
            this.a((LiveData)object);
        }
    }

    private static interface d<T> {
        public void a(androidx.lifecycle.j var1);

        public void b(T var1);

        public void c(T var1);
    }

    private static class e
    extends j.a
    implements d<j> {
        final f<j> a;

        public e(ViewDataBinding viewDataBinding, int n2) {
            this.a = new f<j>(viewDataBinding, n2, this);
        }

        public f<j> a() {
            return this.a;
        }

        public void a(j j2) {
            j2.a(this);
        }

        @Override
        public void a(androidx.lifecycle.j j2) {
        }

        @Override
        public void b(j j2) {
            j2.b(this);
        }

        @Override
        public /* synthetic */ void c(Object object) {
            this.a((j)object);
        }
    }

    private static class f<T>
    extends WeakReference<ViewDataBinding> {
        protected final int a;
        private final d<T> b;
        private T c;

        public f(ViewDataBinding viewDataBinding, int n2, d<T> d2) {
            super(viewDataBinding, j);
            this.a = n2;
            this.b = d2;
        }

        public void a(androidx.lifecycle.j j2) {
            this.b.a(j2);
        }

        public void a(T t2) {
            this.a();
            this.c = t2;
            if (this.c != null) {
                this.b.c(this.c);
            }
        }

        public boolean a() {
            boolean bl2;
            if (this.c != null) {
                this.b.b(this.c);
                bl2 = true;
            } else {
                bl2 = false;
            }
            this.c = null;
            return bl2;
        }

        public T b() {
            return this.c;
        }

        protected ViewDataBinding c() {
            ViewDataBinding viewDataBinding = (ViewDataBinding)this.get();
            if (viewDataBinding == null) {
                this.a();
            }
            return viewDataBinding;
        }
    }

    private static class g
    extends k.a
    implements d<k> {
        final f<k> a;

        public g(ViewDataBinding viewDataBinding, int n2) {
            this.a = new f<k>(viewDataBinding, n2, this);
        }

        public f<k> a() {
            return this.a;
        }

        public void a(k k2) {
            k2.a(this);
        }

        @Override
        public void a(androidx.lifecycle.j j2) {
        }

        @Override
        public void b(k k2) {
            k2.b(this);
        }

        @Override
        public /* synthetic */ void c(Object object) {
            this.a((k)object);
        }
    }

    private static class h
    extends i.a
    implements d<i> {
        final f<i> a;

        public h(ViewDataBinding viewDataBinding, int n2) {
            this.a = new f<i>(viewDataBinding, n2, this);
        }

        public f<i> a() {
            return this.a;
        }

        public void a(i i2) {
            i2.a(this);
        }

        @Override
        public void a(i i2, int n2) {
            ViewDataBinding viewDataBinding = this.a.c();
            if (viewDataBinding == null) {
                return;
            }
            if (this.a.b() != i2) {
                return;
            }
            viewDataBinding.b(this.a.a, i2, n2);
        }

        @Override
        public void a(androidx.lifecycle.j j2) {
        }

        @Override
        public void b(i i2) {
            i2.b(this);
        }

        @Override
        public /* synthetic */ void c(Object object) {
            this.a((i)object);
        }
    }

}

