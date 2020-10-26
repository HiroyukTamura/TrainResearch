/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.PropertyValuesHolder
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Paint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationSet
 *  android.view.animation.AnimationUtils
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.ScaleAnimation
 *  android.view.animation.Transformation
 */
package androidx.f.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.k;
import androidx.f.a.l;
import androidx.f.a.n;
import androidx.f.a.p;
import androidx.f.a.q;
import androidx.f.a.t;
import androidx.f.a.u;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class j
extends androidx.f.a.i
implements LayoutInflater.Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    ArrayList<j> C;
    k D;
    Runnable E = new Runnable(){

        @Override
        public void run() {
            j.this.i();
        }
    };
    private final CopyOnWriteArrayList<f> J = new CopyOnWriteArrayList();
    ArrayList<h> b;
    boolean c;
    int d = 0;
    final ArrayList<androidx.f.a.d> e = new ArrayList();
    SparseArray<androidx.f.a.d> f;
    ArrayList<androidx.f.a.a> g;
    ArrayList<androidx.f.a.d> h;
    ArrayList<androidx.f.a.a> i;
    ArrayList<Integer> j;
    ArrayList<i.c> k;
    int l = 0;
    androidx.f.a.h m;
    androidx.f.a.f n;
    androidx.f.a.d o;
    androidx.f.a.d p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<androidx.f.a.a> x;
    ArrayList<Boolean> y;
    ArrayList<androidx.f.a.d> z;

    j() {
    }

    private void A() {
        if (!this.f()) {
            if (this.v == null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not perform this action inside of ");
            stringBuilder.append(this.v);
            throw new IllegalStateException(stringBuilder.toString());
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void B() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    private void C() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void D() {
        Object object = this.f;
        int n2 = object == null ? 0 : this.f.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            object = (androidx.f.a.d)this.f.valueAt(i2);
            if (object == null) continue;
            if (((androidx.f.a.d)object).ad() != null) {
                int n3 = ((androidx.f.a.d)object).af();
                View view = ((androidx.f.a.d)object).ad();
                Animation animation = view.getAnimation();
                if (animation != null) {
                    animation.cancel();
                    view.clearAnimation();
                }
                ((androidx.f.a.d)object).a((View)null);
                this.a((androidx.f.a.d)object, n3, 0, 0, false);
                continue;
            }
            if (((androidx.f.a.d)object).ae() == null) continue;
            ((androidx.f.a.d)object).ae().end();
        }
    }

    private void E() {
        if (this.f != null) {
            for (int i2 = this.f.size() - 1; i2 >= 0; --i2) {
                if (this.f.valueAt(i2) != null) continue;
                this.f.delete(this.f.keyAt(i2));
            }
        }
    }

    private int a(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2, int n2, int n3, androidx.c.b<androidx.f.a.d> b2) {
        int n4 = n3;
        for (int i2 = n3 - 1; i2 >= n2; --i2) {
            androidx.f.a.a a2 = arrayList.get(i2);
            boolean bl2 = arrayList2.get(i2);
            boolean bl3 = a2.h() && !a2.a(arrayList, i2 + 1, n3);
            int n5 = n4;
            if (bl3) {
                if (this.C == null) {
                    this.C = new ArrayList();
                }
                j j2 = new j(a2, bl2);
                this.C.add(j2);
                a2.a(j2);
                if (bl2) {
                    a2.g();
                } else {
                    a2.b(false);
                }
                n5 = n4 - 1;
                if (i2 != n5) {
                    arrayList.remove(i2);
                    arrayList.add(n5, a2);
                }
                this.b(b2);
            }
            n4 = n5;
        }
        return n4;
    }

    private static Animation.AnimationListener a(Animation object) {
        void var1_3;
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            object = (Animation.AnimationListener)q.get(object);
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = "Cannot access Animation's mListener field";
        }
        catch (NoSuchFieldException noSuchFieldException) {
            object = "No field with the name mListener is found in Animation class";
        }
        Log.e((String)"FragmentManager", (String)object, (Throwable)var1_3);
        return null;
    }

    static c a(Context context, float f2, float f3) {
        context = new AlphaAnimation(f2, f3);
        context.setInterpolator(G);
        context.setDuration(220L);
        return new c((Animation)context);
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        context = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220L);
        context.addAnimation((Animation)scaleAnimation);
        scaleAnimation = new AlphaAnimation(f4, f5);
        scaleAnimation.setInterpolator(G);
        scaleAnimation.setDuration(220L);
        context.addAnimation((Animation)scaleAnimation);
        return new c((Animation)context);
    }

    private void a(androidx.c.b<androidx.f.a.d> b2) {
        int n2 = b2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            androidx.f.a.d d2 = b2.b(i2);
            if (d2.u) continue;
            View view = d2.y();
            d2.Z = view.getAlpha();
            view.setAlpha(0.0f);
        }
    }

    private void a(final androidx.f.a.d d2, c c2, int n2) {
        final View view = d2.S;
        final ViewGroup viewGroup = d2.R;
        viewGroup.startViewTransition(view);
        d2.b(n2);
        if (c2.a != null) {
            e e2 = new e(c2.a, viewGroup, view);
            d2.a(d2.S);
            e2.setAnimationListener((Animation.AnimationListener)new b(j.a((Animation)e2)){

                @Override
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable(){

                        @Override
                        public void run() {
                            if (d2.ad() != null) {
                                d2.a((View)null);
                                j.this.a(d2, d2.af(), 0, 0, false);
                            }
                        }
                    });
                }

            });
            j.b(view, c2);
            d2.S.startAnimation((Animation)e2);
            return;
        }
        Animator animator = c2.b;
        d2.a(c2.b);
        animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                animator = d2.ae();
                d2.a((Animator)null);
                if (animator != null && viewGroup.indexOfChild(view) < 0) {
                    j.this.a(d2, d2.af(), 0, 0, false);
                }
            }
        });
        animator.setTarget((Object)d2.S);
        j.b(d2.S, c2);
        animator.start();
    }

    private static void a(k iterator) {
        if (iterator == null) {
            return;
        }
        List<androidx.f.a.d> list = ((k)((Object)iterator)).a();
        if (list != null) {
            list = list.iterator();
            while (list.hasNext()) {
                ((androidx.f.a.d)list.next()).N = true;
            }
        }
        if ((iterator = ((k)((Object)iterator)).b()) != null) {
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                j.a((k)iterator.next());
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(RuntimeException var1_1) {
        Log.e((String)"FragmentManager", (String)var1_1.getMessage());
        Log.e((String)"FragmentManager", (String)"Activity state:");
        var2_2 = new PrintWriter(new androidx.core.g.b("FragmentManager"));
        if (this.m == null) ** GOTO lbl8
        try {
            this.m.a("  ", null, var2_2, new String[0]);
            throw var1_1;
lbl8: // 1 sources:
            this.a("  ", null, var2_2, new String[0]);
            throw var1_1;
        }
        catch (Exception var2_3) {
            Log.e((String)"FragmentManager", (String)"Failed dumping state", (Throwable)var2_3);
            throw var1_1;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(ArrayList<androidx.f.a.a> var1_1, ArrayList<Boolean> var2_2) {
        var3_3 = this.C == null ? 0 : this.C.size();
        var5_4 = 0;
        var4_5 = var3_3;
        var3_3 = var5_4;
        while (var3_3 < var4_5) {
            block6 : {
                block5 : {
                    var7_7 = this.C.get(var3_3);
                    if (var1_1 != null && !var7_7.a && (var5_4 = var1_1.indexOf(var7_7.b)) != -1 && var2_2.get(var5_4).booleanValue()) ** GOTO lbl-1000
                    if (var7_7.c()) break block5;
                    var6_6 = var3_3;
                    var5_4 = var4_5;
                    if (var1_1 == null) break block6;
                    var6_6 = var3_3;
                    var5_4 = var4_5;
                    if (!var7_7.b.a(var1_1, 0, var1_1.size())) break block6;
                }
                this.C.remove(var3_3);
                --var3_3;
                --var4_5;
                ** if (var1_1 == null || var7_7.a || (var5_4 = var1_1.indexOf((Object)var7_7.b)) == -1 || !var2_2.get((int)var5_4).booleanValue()) goto lbl-1000
lbl-1000: // 2 sources:
                {
                    var7_7.e();
                    var6_6 = var3_3;
                    var5_4 = var4_5;
                    ** GOTO lbl28
                }
lbl-1000: // 1 sources:
                {
                    var7_7.d();
                    var5_4 = var4_5;
                    var6_6 = var3_3;
                }
            }
            var3_3 = var6_6 + 1;
            var4_5 = var5_4;
        }
    }

    private void a(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2, int n2, int n3) {
        int n4;
        int n5 = n2;
        boolean bl2 = arrayList.get((int)n5).t;
        if (this.z == null) {
            this.z = new ArrayList();
        } else {
            this.z.clear();
        }
        this.z.addAll(this.e);
        Object object = this.y();
        boolean bl3 = false;
        for (n4 = n5; n4 < n3; ++n4) {
            androidx.f.a.a a2 = arrayList.get(n4);
            object = arrayList2.get(n4) == false ? a2.a(this.z, (androidx.f.a.d)object) : a2.b(this.z, (androidx.f.a.d)object);
            if (!bl3 && !a2.i) {
                bl3 = false;
                continue;
            }
            bl3 = true;
        }
        this.z.clear();
        if (!bl2) {
            q.a(this, arrayList, arrayList2, n2, n3, false);
        }
        j.b(arrayList, arrayList2, n2, n3);
        if (bl2) {
            object = new androidx.c.b();
            this.b((androidx.c.b<androidx.f.a.d>)object);
            n4 = this.a(arrayList, arrayList2, n2, n3, (androidx.c.b<androidx.f.a.d>)object);
            this.a((androidx.c.b<androidx.f.a.d>)object);
        } else {
            n4 = n3;
        }
        int n6 = n5;
        if (n4 != n5) {
            n6 = n5;
            if (bl2) {
                q.a(this, arrayList, arrayList2, n2, n4, true);
                this.a(this.l, true);
                n6 = n5;
            }
        }
        while (n6 < n3) {
            object = arrayList.get(n6);
            if (arrayList2.get(n6).booleanValue() && ((androidx.f.a.a)object).m >= 0) {
                this.d(((androidx.f.a.a)object).m);
                ((androidx.f.a.a)object).m = -1;
            }
            ((androidx.f.a.a)object).c();
            ++n6;
        }
        if (bl3) {
            this.k();
        }
    }

    static boolean a(Animator object) {
        block4 : {
            block3 : {
                if (object == null) {
                    return false;
                }
                if (!(object instanceof ValueAnimator)) break block3;
                object = ((ValueAnimator)object).getValues();
                for (int i2 = 0; i2 < ((PropertyValuesHolder[])object).length; ++i2) {
                    if (!"alpha".equals(object[i2].getPropertyName())) continue;
                    return true;
                }
                break block4;
            }
            if (!(object instanceof AnimatorSet)) break block4;
            object = ((AnimatorSet)object).getChildAnimations();
            for (int i3 = 0; i3 < object.size(); ++i3) {
                if (!j.a((Animator)object.get(i3))) continue;
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, c c2) {
        boolean bl2;
        boolean bl3 = bl2 = false;
        if (view != null) {
            if (c2 == null) {
                return false;
            }
            bl3 = bl2;
            if (Build.VERSION.SDK_INT >= 19) {
                bl3 = bl2;
                if (view.getLayerType() == 0) {
                    bl3 = bl2;
                    if (androidx.core.h.t.s(view)) {
                        bl3 = bl2;
                        if (j.a(c2)) {
                            bl3 = true;
                        }
                    }
                }
            }
        }
        return bl3;
    }

    static boolean a(c object) {
        if (((c)object).a instanceof AlphaAnimation) {
            return true;
        }
        if (((c)object).a instanceof AnimationSet) {
            object = ((AnimationSet)((c)object).a).getAnimations();
            for (int i2 = 0; i2 < object.size(); ++i2) {
                if (!(object.get(i2) instanceof AlphaAnimation)) continue;
                return true;
            }
            return false;
        }
        return j.a(((c)object).b);
    }

    private boolean a(String string2, int n2, int n3) {
        boolean bl2;
        androidx.f.a.i i2;
        this.i();
        this.c(true);
        if (this.p != null && n2 < 0 && string2 == null && (i2 = this.p.t()) != null && i2.c()) {
            return true;
        }
        bl2 = this.a(this.x, this.y, string2, n2, n3);
        if (bl2) {
            this.c = true;
            try {
                this.b(this.x, this.y);
            }
            finally {
                this.B();
            }
        }
        this.j();
        this.E();
        return bl2;
    }

    public static int b(int n2, boolean bl2) {
        if (n2 != 4097) {
            if (n2 != 4099) {
                if (n2 != 8194) {
                    return -1;
                }
                if (bl2) {
                    return 3;
                }
                return 4;
            }
            if (bl2) {
                return 5;
            }
            return 6;
        }
        if (bl2) {
            return 1;
        }
        return 2;
    }

    private static void b(View view, c c2) {
        if (view != null) {
            if (c2 == null) {
                return;
            }
            if (j.a(view, c2)) {
                if (c2.b != null) {
                    c2.b.addListener((Animator.AnimatorListener)new d(view));
                    return;
                }
                Animation.AnimationListener animationListener = j.a(c2.a);
                view.setLayerType(2, null);
                c2.a.setAnimationListener((Animation.AnimationListener)new a(view, animationListener));
            }
        }
    }

    private void b(androidx.c.b<androidx.f.a.d> b2) {
        if (this.l < 1) {
            return;
        }
        int n2 = Math.min(this.l, 3);
        int n3 = this.e.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2.k >= n2) continue;
            this.a(d2, n2, d2.Y(), d2.Z(), false);
            if (d2.S == null || d2.K || !d2.X) continue;
            b2.add(d2);
        }
    }

    private void b(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                return;
            }
            if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
                this.a(arrayList, arrayList2);
                int n2 = arrayList.size();
                int n3 = 0;
                int n4 = 0;
                while (n3 < n2) {
                    int n5 = n3;
                    int n6 = n4;
                    if (!arrayList.get((int)n3).t) {
                        if (n4 != n3) {
                            this.a(arrayList, arrayList2, n4, n3);
                        }
                        n6 = n4 = n3 + 1;
                        if (arrayList2.get(n3).booleanValue()) {
                            do {
                                n6 = n4;
                                if (n4 >= n2) break;
                                n6 = n4;
                                if (!arrayList2.get(n4).booleanValue()) break;
                                n6 = n4++;
                            } while (!arrayList.get((int)n4).t);
                        }
                        this.a(arrayList, arrayList2, n3, n6);
                        n5 = n6 - 1;
                    }
                    n3 = n5 + 1;
                    n4 = n6;
                }
                if (n4 != n2) {
                    this.a(arrayList, arrayList2, n4, n2);
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private static void b(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2, int n2, int n3) {
        while (n2 < n3) {
            androidx.f.a.a a2 = arrayList.get(n2);
            boolean bl2 = arrayList2.get(n2);
            boolean bl3 = true;
            if (bl2) {
                a2.a(-1);
                if (n2 != n3 - 1) {
                    bl3 = false;
                }
                a2.b(bl3);
            } else {
                a2.a(1);
                a2.g();
            }
            ++n2;
        }
    }

    private void c(boolean bl2) {
        if (!this.c) {
            if (this.m != null) {
                if (Looper.myLooper() == this.m.h().getLooper()) {
                    if (!bl2) {
                        this.A();
                    }
                    if (this.x == null) {
                        this.x = new ArrayList();
                        this.y = new ArrayList();
                    }
                    this.c = true;
                    try {
                        this.a((ArrayList<androidx.f.a.a>)null, (ArrayList<Boolean>)null);
                        return;
                    }
                    finally {
                        this.c = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean c(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            ArrayList<h> arrayList3 = this.b;
            int n2 = 0;
            if (arrayList3 != null && this.b.size() != 0) {
                int n3 = this.b.size();
                boolean bl2 = false;
                do {
                    if (n2 >= n3) {
                        this.b.clear();
                        this.m.h().removeCallbacks(this.E);
                        return bl2;
                    }
                    bl2 |= this.b.get(n2).a(arrayList, arrayList2);
                    ++n2;
                } while (true);
            }
            return false;
        }
    }

    public static int e(int n2) {
        int n3 = 8194;
        if (n2 != 4097) {
            if (n2 != 4099) {
                if (n2 != 8194) {
                    return 0;
                }
                return 4097;
            }
            n3 = 4099;
        }
        return n3;
    }

    private void f(int n2) {
        try {
            this.c = true;
            this.a(n2, false);
            this.i();
            return;
        }
        finally {
            this.c = false;
        }
    }

    private androidx.f.a.d q(androidx.f.a.d d2) {
        ViewGroup viewGroup = d2.R;
        View view = d2.S;
        if (viewGroup != null) {
            if (view == null) {
                return null;
            }
            for (int i2 = this.e.indexOf((Object)d2) - 1; i2 >= 0; --i2) {
                d2 = this.e.get(i2);
                if (d2.R != viewGroup || d2.S == null) continue;
                return d2;
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(androidx.f.a.a a2) {
        synchronized (this) {
            if (this.j != null && this.j.size() > 0) {
                int n2 = this.j.remove(this.j.size() - 1);
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Adding back stack index ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" with ");
                    stringBuilder.append(a2);
                    Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                }
                this.i.set(n2, a2);
                return n2;
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            int n3 = this.i.size();
            if (a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Setting back stack index ");
                stringBuilder.append(n3);
                stringBuilder.append(" to ");
                stringBuilder.append(a2);
                Log.v((String)"FragmentManager", (String)stringBuilder.toString());
            }
            this.i.add(a2);
            return n3;
        }
    }

    @Override
    public d.d a(androidx.f.a.d d2) {
        Object object;
        if (d2.o < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Fragment ");
            ((StringBuilder)object).append(d2);
            ((StringBuilder)object).append(" is not currently in the FragmentManager");
            this.a(new IllegalStateException(((StringBuilder)object).toString()));
        }
        int n2 = d2.k;
        Object var4_4 = null;
        object = var4_4;
        if (n2 > 0) {
            d2 = this.o(d2);
            object = var4_4;
            if (d2 != null) {
                object = new d.d((Bundle)d2);
            }
        }
        return object;
    }

    @Override
    public androidx.f.a.d a(Bundle object, String string2) {
        int n2 = object.getInt(string2, -1);
        if (n2 == -1) {
            return null;
        }
        object = (androidx.f.a.d)this.f.get(n2);
        if (object == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment no longer exists for key ");
            stringBuilder.append(string2);
            stringBuilder.append(": index ");
            stringBuilder.append(n2);
            this.a(new IllegalStateException(stringBuilder.toString()));
        }
        return object;
    }

    @Override
    public androidx.f.a.d a(String string2) {
        int n2;
        androidx.f.a.d d2;
        if (string2 != null) {
            for (n2 = this.e.size() - 1; n2 >= 0; --n2) {
                d2 = this.e.get(n2);
                if (d2 == null || !string2.equals(d2.J)) continue;
                return d2;
            }
        }
        if (this.f != null && string2 != null) {
            for (n2 = this.f.size() - 1; n2 >= 0; --n2) {
                d2 = (androidx.f.a.d)this.f.valueAt(n2);
                if (d2 == null || !string2.equals(d2.J)) continue;
                return d2;
            }
        }
        return null;
    }

    @Override
    public i.a a(int n2) {
        return this.g.get(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    c a(androidx.f.a.d object, int n2, boolean bl2, int n3) {
        block23 : {
            int n4 = ((androidx.f.a.d)object).Y();
            Animation animation = ((androidx.f.a.d)object).a(n2, bl2, n4);
            if (animation != null) {
                return new c(animation);
            }
            if ((object = ((androidx.f.a.d)object).b(n2, bl2, n4)) != null) {
                return new c((Animator)object);
            }
            if (n4 != 0) {
                boolean bl3;
                boolean bl4 = "anim".equals(this.m.g().getResources().getResourceTypeName(n4));
                boolean bl5 = bl3 = false;
                if (bl4) {
                    try {
                        object = AnimationUtils.loadAnimation((Context)this.m.g(), (int)n4);
                        if (object != null) {
                            return new c((Animation)object);
                        }
                        bl5 = true;
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        throw notFoundException;
                    }
                    catch (RuntimeException runtimeException) {
                        bl5 = bl3;
                    }
                }
                if (!bl5) {
                    try {
                        object = AnimatorInflater.loadAnimator((Context)this.m.g(), (int)n4);
                        if (object != null) {
                            return new c((Animator)object);
                        }
                    }
                    catch (RuntimeException runtimeException) {
                        if (bl4) {
                            throw runtimeException;
                        }
                        Animation animation2 = AnimationUtils.loadAnimation((Context)this.m.g(), (int)n4);
                        if (animation2 == null) break block23;
                        return new c(animation2);
                    }
                }
            }
        }
        if (n2 == 0) {
            return null;
        }
        if ((n2 = j.b(n2, bl2)) < 0) {
            return null;
        }
        switch (n2) {
            default: {
                n2 = n3;
                if (n3 != 0) break;
                n2 = n3;
                if (!this.m.d()) break;
                n2 = this.m.e();
                break;
            }
            case 6: {
                return j.a(this.m.g(), 1.0f, 0.0f);
            }
            case 5: {
                return j.a(this.m.g(), 0.0f, 1.0f);
            }
            case 4: {
                return j.a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            }
            case 3: {
                return j.a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            }
            case 2: {
                return j.a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            }
            case 1: {
                return j.a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            }
        }
        if (n2 != 0) return null;
        return null;
    }

    @Override
    public p a() {
        return new androidx.f.a.a(this);
    }

    @Override
    public void a(int n2, int n3) {
        if (n2 >= 0) {
            this.a(new i(null, n2, n3), false);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2, androidx.f.a.a a2) {
        synchronized (this) {
            int n3;
            if (this.i == null) {
                this.i = new ArrayList();
            }
            if (n2 < n3) {
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Setting back stack index ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" to ");
                    stringBuilder.append(a2);
                    Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                }
                this.i.set(n2, a2);
            } else {
                StringBuilder stringBuilder;
                for (int i2 = n3 = this.i.size(); i2 < n2; ++i2) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList();
                    }
                    if (a) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Adding available back stack index ");
                        stringBuilder.append(i2);
                        Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                    }
                    this.j.add(i2);
                }
                if (a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Adding back stack index ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" with ");
                    stringBuilder.append(a2);
                    Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                }
                this.i.add(a2);
            }
            return;
        }
    }

    void a(int n2, boolean bl2) {
        if (this.m == null && n2 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (!bl2 && n2 == this.l) {
            return;
        }
        this.l = n2;
        if (this.f != null) {
            int n3 = this.e.size();
            for (n2 = 0; n2 < n3; ++n2) {
                this.f(this.e.get(n2));
            }
            n3 = this.f.size();
            for (n2 = 0; n2 < n3; ++n2) {
                androidx.f.a.d d2 = (androidx.f.a.d)this.f.valueAt(n2);
                if (d2 == null || !d2.v && !d2.L || d2.X) continue;
                this.f(d2);
            }
            this.g();
            if (this.r && this.m != null && this.l == 4) {
                this.m.c();
                this.r = false;
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.e.size(); ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null) continue;
            d2.a(configuration);
        }
    }

    @Override
    public void a(Bundle bundle, String string2, androidx.f.a.d d2) {
        if (d2.o < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(d2);
            stringBuilder.append(" is not currently in the FragmentManager");
            this.a(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putInt(string2, d2.o);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(Parcelable object, k object2) {
        Object object3;
        Object object4;
        Object object5;
        int n2;
        int n3;
        Object object6;
        if (object == null) {
            return;
        }
        l l2 = (l)object;
        if (l2.a == null) {
            return;
        }
        if (object2 == null) {
            object = object5 = null;
        } else {
            object6 = ((k)object2).a();
            object3 = ((k)object2).b();
            object4 = ((k)object2).c();
            n2 = object6 != null ? object6.size() : 0;
            n3 = 0;
            do {
                int n4;
                object5 = object3;
                object = object4;
                if (n3 >= n2) break;
                object = object6.get(n3);
                if (a) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("restoreAllState: re-attaching retained ");
                    ((StringBuilder)object5).append(object);
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object5).toString());
                }
                for (n4 = 0; n4 < l2.a.length && l2.a[n4].b != ((androidx.f.a.d)object).o; ++n4) {
                }
                if (n4 == l2.a.length) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("Could not find active fragment with index ");
                    ((StringBuilder)object5).append(((androidx.f.a.d)object).o);
                    this.a(new IllegalStateException(((StringBuilder)object5).toString()));
                }
                object5 = l2.a[n4];
                ((n)object5).l = object;
                ((androidx.f.a.d)object).m = null;
                ((androidx.f.a.d)object).A = 0;
                ((androidx.f.a.d)object).x = false;
                ((androidx.f.a.d)object).u = false;
                ((androidx.f.a.d)object).r = null;
                if (((n)object5).k != null) {
                    ((n)object5).k.setClassLoader(this.m.g().getClassLoader());
                    ((androidx.f.a.d)object).m = ((n)object5).k.getSparseParcelableArray("android:view_state");
                    ((androidx.f.a.d)object).l = ((n)object5).k;
                }
                ++n3;
            } while (true);
        }
        this.f = new SparseArray(l2.a.length);
        for (n2 = 0; n2 < l2.a.length; ++n2) {
            object6 = l2.a[n2];
            if (object6 == null) continue;
            object3 = object5 != null && n2 < object5.size() ? (k)object5.get(n2) : null;
            object4 = object != null && n2 < object.size() ? (y)object.get(n2) : null;
            object3 = ((n)object6).a(this.m, this.n, this.o, (k)object3, (y)object4);
            if (a) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("restoreAllState: active #");
                ((StringBuilder)object4).append(n2);
                ((StringBuilder)object4).append(": ");
                ((StringBuilder)object4).append(object3);
                Log.v((String)"FragmentManager", (String)((StringBuilder)object4).toString());
            }
            this.f.put(((androidx.f.a.d)object3).o, object3);
            ((n)object6).l = null;
        }
        if (object2 != null) {
            object = ((k)object2).a();
            n2 = object != null ? object.size() : 0;
            for (n3 = 0; n3 < n2; ++n3) {
                object2 = (androidx.f.a.d)object.get(n3);
                if (((androidx.f.a.d)object2).s < 0) continue;
                ((androidx.f.a.d)object2).r = (androidx.f.a.d)this.f.get(((androidx.f.a.d)object2).s);
                if (((androidx.f.a.d)object2).r != null) continue;
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("Re-attaching retained fragment ");
                ((StringBuilder)object5).append(object2);
                ((StringBuilder)object5).append(" target no longer exists: ");
                ((StringBuilder)object5).append(((androidx.f.a.d)object2).s);
                Log.w((String)"FragmentManager", (String)((StringBuilder)object5).toString());
            }
        }
        this.e.clear();
        if (l2.b != null) {
            for (n2 = 0; n2 < l2.b.length; ++n2) {
                object = (androidx.f.a.d)this.f.get(l2.b[n2]);
                if (object == null) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("No instantiated fragment for index #");
                    ((StringBuilder)object2).append(l2.b[n2]);
                    this.a(new IllegalStateException(((StringBuilder)object2).toString()));
                }
                ((androidx.f.a.d)object).u = true;
                if (a) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("restoreAllState: added #");
                    ((StringBuilder)object2).append(n2);
                    ((StringBuilder)object2).append(": ");
                    ((StringBuilder)object2).append(object);
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
                }
                if (this.e.contains(object)) {
                    throw new IllegalStateException("Already added!");
                }
                object2 = this.e;
                synchronized (object2) {
                    this.e.add((androidx.f.a.d)object);
                    continue;
                }
            }
        }
        if (l2.c != null) {
            this.g = new ArrayList(l2.c.length);
            for (n2 = 0; n2 < l2.c.length; ++n2) {
                object = l2.c[n2].a(this);
                if (a) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("restoreAllState: back stack #");
                    ((StringBuilder)object2).append(n2);
                    ((StringBuilder)object2).append(" (index ");
                    ((StringBuilder)object2).append(((androidx.f.a.a)object).m);
                    ((StringBuilder)object2).append("): ");
                    ((StringBuilder)object2).append(object);
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
                    object2 = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                    ((androidx.f.a.a)object).a("  ", (PrintWriter)object2, false);
                    ((PrintWriter)object2).close();
                }
                this.g.add((androidx.f.a.a)object);
                if (((androidx.f.a.a)object).m < 0) continue;
                this.a(((androidx.f.a.a)object).m, (androidx.f.a.a)object);
            }
        } else {
            this.g = null;
        }
        if (l2.d >= 0) {
            this.p = (androidx.f.a.d)this.f.get(l2.d);
        }
        this.d = l2.e;
    }

    void a(androidx.f.a.a a2, boolean bl2, boolean bl3, boolean bl4) {
        if (bl2) {
            a2.b(bl4);
        } else {
            a2.g();
        }
        Object object = new ArrayList<androidx.f.a.a>(1);
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>(1);
        ((ArrayList)object).add(a2);
        arrayList.add(bl2);
        if (bl3) {
            q.a(this, object, arrayList, 0, 1, true);
        }
        if (bl4) {
            this.a(this.l, true);
        }
        if (this.f != null) {
            int n2 = this.f.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                object = (androidx.f.a.d)this.f.valueAt(i2);
                if (object == null || ((androidx.f.a.d)object).S == null || !((androidx.f.a.d)object).X || !a2.b(((androidx.f.a.d)object).I)) continue;
                if (((androidx.f.a.d)object).Z > 0.0f) {
                    ((androidx.f.a.d)object).S.setAlpha(((androidx.f.a.d)object).Z);
                }
                if (bl4) {
                    ((androidx.f.a.d)object).Z = 0.0f;
                    continue;
                }
                ((androidx.f.a.d)object).Z = -1.0f;
                ((androidx.f.a.d)object).X = false;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    void a(androidx.f.a.d var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        block68 : {
            block67 : {
                var9_6 = var1_1.u;
                var7_7 = 1;
                var8_8 = true;
                if (!var9_6 || var1_1.L) {
                    var2_2 = var6_9 = var2_2;
                    if (var6_9 > 1) {
                        var2_2 = 1;
                    }
                }
                var6_9 = var2_2;
                if (var1_1.v) {
                    var6_9 = var2_2;
                    if (var2_2 > var1_1.k) {
                        var6_9 = var1_1.k == 0 && var1_1.j() != false ? 1 : var1_1.k;
                    }
                }
                if (var1_1.k > (var2_2 = var1_1.U != false && var1_1.k < 3 && var6_9 > 2 ? 2 : var6_9)) break block67;
                if (var1_1.w && !var1_1.x) {
                    return;
                }
                if (var1_1.ad() != null || var1_1.ae() != null) {
                    var1_1.a((View)null);
                    var1_1.a((Animator)null);
                    this.a(var1_1, var1_1.af(), 0, 0, true);
                }
                var4_4 = var2_2;
                var6_9 = var2_2;
                var3_3 = var2_2;
                switch (var1_1.k) {
                    default: {
                        var6_9 = var2_2;
                        break;
                    }
                    case 0: {
                        var4_4 = var2_2;
                        if (var2_2 <= 0) ** GOTO lbl92
                        if (j.a) {
                            var10_10 = new StringBuilder();
                            var10_10.append("moveto CREATED: ");
                            var10_10.append(var1_1);
                            Log.v((String)"FragmentManager", (String)var10_10.toString());
                        }
                        var4_4 = var2_2;
                        if (var1_1.l != null) {
                            var1_1.l.setClassLoader(this.m.g().getClassLoader());
                            var1_1.m = var1_1.l.getSparseParcelableArray("android:view_state");
                            var1_1.r = this.a(var1_1.l, "android:target_state");
                            if (var1_1.r != null) {
                                var1_1.t = var1_1.l.getInt("android:target_req_state", 0);
                            }
                            if (var1_1.n != null) {
                                var1_1.V = var1_1.n;
                                var1_1.n = null;
                            } else {
                                var1_1.V = var1_1.l.getBoolean("android:user_visible_hint", true);
                            }
                            var4_4 = var2_2;
                            if (!var1_1.V) {
                                var1_1.U = true;
                                var4_4 = var2_2;
                                if (var2_2 > 2) {
                                    var4_4 = 2;
                                }
                            }
                        }
                        var1_1.C = this.m;
                        var1_1.G = this.o;
                        var10_10 = this.o != null ? this.o.D : this.m.i();
                        var1_1.B = var10_10;
                        if (var1_1.r != null) {
                            if (this.f.get(var1_1.r.o) == var1_1.r) {
                                if (var1_1.r.k < 1) {
                                    this.a(var1_1.r, 1, 0, 0, true);
                                }
                            } else {
                                var10_10 = new StringBuilder();
                                var10_10.append("Fragment ");
                                var10_10.append(var1_1);
                                var10_10.append(" declared target fragment ");
                                var10_10.append(var1_1.r);
                                var10_10.append(" that does not belong to this FragmentManager!");
                                throw new IllegalStateException(var10_10.toString());
                            }
                        }
                        this.a(var1_1, this.m.g(), false);
                        var1_1.Q = false;
                        var1_1.a(this.m.g());
                        if (!var1_1.Q) ** GOTO lbl87
                        if (var1_1.G == null) {
                            this.m.b(var1_1);
                        } else {
                            var1_1.G.a(var1_1);
                        }
                        this.b(var1_1, this.m.g(), false);
                        if (!var1_1.ab) {
                            this.a(var1_1, var1_1.l, false);
                            var1_1.l(var1_1.l);
                            this.b(var1_1, var1_1.l, false);
                        } else {
                            var1_1.j(var1_1.l);
                            var1_1.k = 1;
                        }
                        var1_1.N = false;
                        ** GOTO lbl92
lbl87: // 1 sources:
                        var10_10 = new StringBuilder();
                        var10_10.append("Fragment ");
                        var10_10.append(var1_1);
                        var10_10.append(" did not call through to super.onAttach()");
                        throw new u(var10_10.toString());
                    }
lbl92: // 3 sources:
                    case 1: {
                        this.d(var1_1);
                        var6_9 = var4_4;
                        if (var4_4 <= 1) ** GOTO lbl151
                        if (j.a) {
                            var10_10 = new StringBuilder();
                            var10_10.append("moveto ACTIVITY_CREATED: ");
                            var10_10.append(var1_1);
                            Log.v((String)"FragmentManager", (String)var10_10.toString());
                        }
                        if (var1_1.w) ** GOTO lbl145
                        if (var1_1.I == 0) ** GOTO lbl129
                        if (var1_1.I == -1) {
                            var10_10 = new StringBuilder();
                            var10_10.append("Cannot create fragment ");
                            var10_10.append(var1_1);
                            var10_10.append(" for a container view with no id");
                            this.a(new IllegalArgumentException(var10_10.toString()));
                        }
                        var11_12 = (ViewGroup)this.n.a(var1_1.I);
                        var10_10 = var11_12;
                        if (var11_12 != null) ** GOTO lbl130
                        var10_10 = var11_12;
                        if (var1_1.y) ** GOTO lbl130
                        var10_10 = var1_1.q().getResourceName(var1_1.I);
                        ** GOTO lbl119
                    }
lbl117: // 1 sources:
                    do {
                        var10_10 = "unknown";
lbl119: // 2 sources:
                        var12_13 = new StringBuilder();
                        var12_13.append("No view found for id 0x");
                        var12_13.append(Integer.toHexString(var1_1.I));
                        var12_13.append(" (");
                        var12_13.append((String)var10_10);
                        var12_13.append(") for fragment ");
                        var12_13.append(var1_1);
                        this.a(new IllegalArgumentException(var12_13.toString()));
                        var10_10 = var11_12;
                        ** GOTO lbl130
                        break;
                    } while (true);
lbl129: // 1 sources:
                    var10_10 = null;
lbl130: // 4 sources:
                    var1_1.R = var10_10;
                    var1_1.b(var1_1.h(var1_1.l), (ViewGroup)var10_10, var1_1.l);
                    if (var1_1.S != null) {
                        var1_1.T = var1_1.S;
                        var1_1.S.setSaveFromParentEnabled(false);
                        if (var10_10 != null) {
                            var10_10.addView(var1_1.S);
                        }
                        if (var1_1.K) {
                            var1_1.S.setVisibility(8);
                        }
                        var1_1.a(var1_1.S, var1_1.l);
                        this.a(var1_1, var1_1.S, var1_1.l, false);
                        var5_5 = var1_1.S.getVisibility() == 0 && var1_1.R != null ? var8_8 : false;
                        var1_1.X = var5_5;
                    } else {
                        var1_1.T = null;
                    }
lbl145: // 3 sources:
                    var1_1.m(var1_1.l);
                    this.c(var1_1, var1_1.l, false);
                    if (var1_1.S != null) {
                        var1_1.f(var1_1.l);
                    }
                    var1_1.l = null;
                    var6_9 = var4_4;
lbl151: // 3 sources:
                    case 2: {
                        var3_3 = var6_9;
                        if (var6_9 > 2) {
                            if (j.a) {
                                var10_10 = new StringBuilder();
                                var10_10.append("moveto STARTED: ");
                                var10_10.append(var1_1);
                                Log.v((String)"FragmentManager", (String)var10_10.toString());
                            }
                            var1_1.P();
                            this.b(var1_1, false);
                            var3_3 = var6_9;
                        }
                    }
                    case 3: {
                        var6_9 = var3_3;
                        if (var3_3 > 3) {
                            if (j.a) {
                                var10_10 = new StringBuilder();
                                var10_10.append("moveto RESUMED: ");
                                var10_10.append(var1_1);
                                Log.v((String)"FragmentManager", (String)var10_10.toString());
                            }
                            var1_1.Q();
                            this.c(var1_1, false);
                            var1_1.l = null;
                            var1_1.m = null;
                            var6_9 = var3_3;
                            break;
                        }
                        break block68;
                    }
                }
                break block68;
            }
            var6_9 = var2_2;
            if (var1_1.k > var2_2) {
                switch (var1_1.k) {
                    default: {
                        var6_9 = var2_2;
                        break;
                    }
                    case 4: {
                        if (var2_2 < 4) {
                            if (j.a) {
                                var10_10 = new StringBuilder();
                                var10_10.append("movefrom RESUMED: ");
                                var10_10.append(var1_1);
                                Log.v((String)"FragmentManager", (String)var10_10.toString());
                            }
                            var1_1.T();
                            this.d(var1_1, false);
                        }
                    }
                    case 3: {
                        if (var2_2 < 3) {
                            if (j.a) {
                                var10_10 = new StringBuilder();
                                var10_10.append("movefrom STARTED: ");
                                var10_10.append(var1_1);
                                Log.v((String)"FragmentManager", (String)var10_10.toString());
                            }
                            var1_1.U();
                            this.e(var1_1, false);
                        }
                    }
                    case 2: {
                        if (var2_2 < 2) {
                            if (j.a) {
                                var10_10 = new StringBuilder();
                                var10_10.append("movefrom ACTIVITY_CREATED: ");
                                var10_10.append(var1_1);
                                Log.v((String)"FragmentManager", (String)var10_10.toString());
                            }
                            if (var1_1.S != null && this.m.a(var1_1) && var1_1.m == null) {
                                this.n(var1_1);
                            }
                            var1_1.V();
                            this.f(var1_1, false);
                            if (var1_1.S != null && var1_1.R != null) {
                                var1_1.R.endViewTransition(var1_1.S);
                                var1_1.S.clearAnimation();
                                var10_10 = this.l > 0 && this.u == false && var1_1.S.getVisibility() == 0 && var1_1.Z >= 0.0f ? this.a(var1_1, var3_3, false, var4_4) : null;
                                var1_1.Z = 0.0f;
                                if (var10_10 != null) {
                                    this.a(var1_1, (c)var10_10, var2_2);
                                }
                                var1_1.R.removeView(var1_1.S);
                            }
                            var1_1.R = null;
                            var1_1.S = null;
                            var1_1.ae = null;
                            var1_1.af.b(null);
                            var1_1.T = null;
                            var1_1.x = false;
                        }
                    }
                    case 1: {
                        var6_9 = var2_2;
                        if (var2_2 >= 1) break;
                        if (this.u) {
                            if (var1_1.ad() != null) {
                                var10_10 = var1_1.ad();
                                var1_1.a((View)null);
                                var10_10.clearAnimation();
                            } else if (var1_1.ae() != null) {
                                var10_10 = var1_1.ae();
                                var1_1.a((Animator)null);
                                var10_10.cancel();
                            }
                        }
                        if (var1_1.ad() == null && var1_1.ae() == null) {
                            if (j.a) {
                                var10_10 = new StringBuilder();
                                var10_10.append("movefrom CREATED: ");
                                var10_10.append(var1_1);
                                Log.v((String)"FragmentManager", (String)var10_10.toString());
                            }
                            if (!var1_1.N) {
                                var1_1.W();
                                this.g(var1_1, false);
                            } else {
                                var1_1.k = 0;
                            }
                            var1_1.X();
                            this.h(var1_1, false);
                            var6_9 = var2_2;
                            if (var5_5) break;
                            if (!var1_1.N) {
                                this.h(var1_1);
                                var6_9 = var2_2;
                                break;
                            }
                            var1_1.C = null;
                            var1_1.G = null;
                            var1_1.B = null;
                            var6_9 = var2_2;
                            break;
                        }
                        var1_1.b(var2_2);
                        var6_9 = var7_7;
                        break;
                    }
                }
            }
        }
        if (var1_1.k != var6_9) {
            var10_10 = new StringBuilder();
            var10_10.append("moveToState: Fragment state for ");
            var10_10.append(var1_1);
            var10_10.append(" not updated inline; ");
            var10_10.append("expected state ");
            var10_10.append(var6_9);
            var10_10.append(" found ");
            var10_10.append(var1_1.k);
            Log.w((String)"FragmentManager", (String)var10_10.toString());
            var1_1.k = var6_9;
        }
        return;
        catch (Resources.NotFoundException var10_11) {
            ** continue;
        }
    }

    void a(androidx.f.a.d d2, Context context, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).a(d2, context, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.a((androidx.f.a.i)this, d2, context);
        }
    }

    void a(androidx.f.a.d d2, Bundle bundle, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).a(d2, bundle, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.a((androidx.f.a.i)this, d2, bundle);
        }
    }

    void a(androidx.f.a.d d2, View view, Bundle bundle, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).a(d2, view, bundle, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.a(this, d2, view, bundle);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(androidx.f.a.d d2, boolean bl2) {
        Serializable serializable;
        if (a) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("add: ");
            ((StringBuilder)serializable).append(d2);
            Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).toString());
        }
        this.g(d2);
        if (!d2.L) {
            if (this.e.contains(d2)) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("Fragment already added: ");
                ((StringBuilder)serializable).append(d2);
                throw new IllegalStateException(((StringBuilder)serializable).toString());
            }
            serializable = this.e;
            synchronized (serializable) {
                this.e.add(d2);
            }
            d2.u = true;
            d2.v = false;
            if (d2.S == null) {
                d2.Y = false;
            }
            if (d2.O && d2.P) {
                this.r = true;
            }
            if (bl2) {
                this.c(d2);
                return;
            }
        }
    }

    public void a(androidx.f.a.h h2, androidx.f.a.f f2, androidx.f.a.d d2) {
        if (this.m == null) {
            this.m = h2;
            this.n = f2;
            this.o = d2;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    @Override
    public void a(i.b b2, boolean bl2) {
        this.J.add(new f(b2, bl2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(h h2, boolean bl2) {
        if (!bl2) {
            this.A();
        }
        synchronized (this) {
            if (!this.u && this.m != null) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                this.b.add(h2);
                this.h();
                return;
            }
            if (bl2) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void a(String string2, FileDescriptor object, PrintWriter printWriter, String[] arrstring) {
        int n2;
        int n3;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append("    ");
        charSequence = charSequence.toString();
        Object object2 = this.f;
        int n4 = 0;
        if (object2 != null && (n3 = this.f.size()) > 0) {
            printWriter.print(string2);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (n2 = 0; n2 < n3; ++n2) {
                object2 = (androidx.f.a.d)this.f.valueAt(n2);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n2);
                printWriter.print(": ");
                printWriter.println(object2);
                if (object2 == null) continue;
                ((androidx.f.a.d)object2).a((String)charSequence, (FileDescriptor)object, printWriter, arrstring);
            }
        }
        if ((n3 = this.e.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Added Fragments:");
            for (n2 = 0; n2 < n3; ++n2) {
                object2 = this.e.get(n2);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n2);
                printWriter.print(": ");
                printWriter.println(((androidx.f.a.d)object2).toString());
            }
        }
        if (this.h != null && (n3 = this.h.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Fragments Created Menus:");
            for (n2 = 0; n2 < n3; ++n2) {
                object2 = this.h.get(n2);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n2);
                printWriter.print(": ");
                printWriter.println(((androidx.f.a.d)object2).toString());
            }
        }
        if (this.g != null && (n3 = this.g.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Back Stack:");
            for (n2 = 0; n2 < n3; ++n2) {
                object2 = this.g.get(n2);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n2);
                printWriter.print(": ");
                printWriter.println(((androidx.f.a.a)object2).toString());
                ((androidx.f.a.a)object2).a((String)charSequence, (FileDescriptor)object, printWriter, arrstring);
            }
        }
        // MONITORENTER : this
        if (this.i != null && (n3 = this.i.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Back Stack Indices:");
            for (n2 = 0; n2 < n3; ++n2) {
                object = this.i.get(n2);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n2);
                printWriter.print(": ");
                printWriter.println(object);
            }
        }
        if (this.j != null && this.j.size() > 0) {
            printWriter.print(string2);
            printWriter.print("mAvailBackStackIndices: ");
            printWriter.println(Arrays.toString(this.j.toArray()));
        }
        // MONITOREXIT : this
        if (this.b != null && (n3 = this.b.size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Pending Actions:");
            for (n2 = n4; n2 < n3; ++n2) {
                object = this.b.get(n2);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n2);
                printWriter.print(": ");
                printWriter.println(object);
            }
        }
        printWriter.print(string2);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(string2);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(string2);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(string2);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(string2);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(string2);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v == null) return;
        printWriter.print(string2);
        printWriter.print("  mNoTransactionsBecause=");
        printWriter.println(this.v);
    }

    public void a(boolean bl2) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null) continue;
            d2.g(bl2);
        }
    }

    public boolean a(Menu menu) {
        int n2 = this.l;
        if (n2 < 1) {
            return false;
        }
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.e.size(); ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            boolean bl3 = bl2;
            if (d2 != null) {
                bl3 = bl2;
                if (d2.c(menu)) {
                    bl3 = true;
                }
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public boolean a(Menu object, MenuInflater menuInflater) {
        int n2 = this.l;
        int n3 = 0;
        if (n2 < 1) {
            return false;
        }
        ArrayList<androidx.f.a.d> arrayList = null;
        boolean bl2 = false;
        for (n2 = 0; n2 < this.e.size(); ++n2) {
            androidx.f.a.d d2 = this.e.get(n2);
            ArrayList<androidx.f.a.d> arrayList2 = arrayList;
            boolean bl3 = bl2;
            if (d2 != null) {
                arrayList2 = arrayList;
                bl3 = bl2;
                if (d2.b((Menu)object, menuInflater)) {
                    arrayList2 = arrayList;
                    if (arrayList == null) {
                        arrayList2 = new ArrayList<androidx.f.a.d>();
                    }
                    arrayList2.add(d2);
                    bl3 = true;
                }
            }
            arrayList = arrayList2;
            bl2 = bl3;
        }
        if (this.h != null) {
            for (n2 = n3; n2 < this.h.size(); ++n2) {
                object = this.h.get(n2);
                if (arrayList != null && arrayList.contains(object)) continue;
                ((androidx.f.a.d)object).D();
            }
        }
        this.h = arrayList;
        return bl2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.e.size(); ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null || !d2.c(menuItem)) continue;
            return true;
        }
        return false;
    }

    boolean a(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2, String string2, int n2, int n3) {
        int n4;
        if (this.g == null) {
            return false;
        }
        if (string2 == null && n2 < 0 && (n3 & 1) == 0) {
            n2 = this.g.size() - 1;
            if (n2 < 0) {
                return false;
            }
            arrayList.add(this.g.remove(n2));
            arrayList2.add(true);
            return true;
        }
        if (string2 == null && n2 < 0) {
            n4 = -1;
        } else {
            int n5;
            androidx.f.a.a a2;
            for (n5 = this.g.size() - 1; n5 >= 0; --n5) {
                a2 = this.g.get(n5);
                if (string2 != null && string2.equals(a2.i()) || n2 >= 0 && n2 == a2.m) break;
            }
            if (n5 < 0) {
                return false;
            }
            n4 = n5;
            if ((n3 & 1) != 0) {
                do {
                    n4 = n3 = n5 - 1;
                    if (n3 < 0) break;
                    a2 = this.g.get(n3);
                    if (string2 != null) {
                        n5 = n3;
                        if (string2.equals(a2.i())) continue;
                    }
                    n4 = n3;
                    if (n2 < 0) break;
                    n4 = n3;
                    if (n2 != a2.m) break;
                    n5 = n3;
                } while (true);
            }
        }
        if (n4 == this.g.size() - 1) {
            return false;
        }
        for (n2 = this.g.size() - 1; n2 > n4; --n2) {
            arrayList.add(this.g.remove(n2));
            arrayList2.add(true);
        }
        return true;
    }

    public androidx.f.a.d b(String string2) {
        if (this.f != null && string2 != null) {
            for (int i2 = this.f.size() - 1; i2 >= 0; --i2) {
                androidx.f.a.d d2 = (androidx.f.a.d)this.f.valueAt(i2);
                if (d2 == null || (d2 = d2.b(string2)) == null) continue;
                return d2;
            }
        }
        return null;
    }

    @Override
    public void b() {
        this.a(new i(null, -1, 0), false);
    }

    public void b(Menu menu) {
        if (this.l < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.e.size(); ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null) continue;
            d2.d(menu);
        }
    }

    void b(androidx.f.a.a a2) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(a2);
    }

    public void b(androidx.f.a.d d2) {
        if (d2.U) {
            if (this.c) {
                this.w = true;
                return;
            }
            d2.U = false;
            this.a(d2, this.l, 0, 0, false);
        }
    }

    void b(androidx.f.a.d d2, Context context, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).b(d2, context, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.b((androidx.f.a.i)this, d2, context);
        }
    }

    void b(androidx.f.a.d d2, Bundle bundle, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).b(d2, bundle, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.b((androidx.f.a.i)this, d2, bundle);
        }
    }

    void b(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).b(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.a(this, d2);
        }
    }

    public void b(h h2, boolean bl2) {
        if (bl2 && (this.m == null || this.u)) {
            return;
        }
        this.c(bl2);
        if (h2.a(this.x, this.y)) {
            this.c = true;
            try {
                this.b(this.x, this.y);
            }
            finally {
                this.B();
            }
        }
        this.j();
        this.E();
    }

    public void b(boolean bl2) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null) continue;
            d2.h(bl2);
        }
    }

    boolean b(int n2) {
        return this.l >= n2;
    }

    @Override
    public boolean b(int n2, int n3) {
        this.A();
        this.i();
        if (n2 >= 0) {
            return this.a(null, n2, n3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.e.size(); ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null || !d2.d(menuItem)) continue;
            return true;
        }
        return false;
    }

    public androidx.f.a.d c(int n2) {
        int n3;
        androidx.f.a.d d2;
        for (n3 = this.e.size() - 1; n3 >= 0; --n3) {
            d2 = this.e.get(n3);
            if (d2 == null || d2.H != n2) continue;
            return d2;
        }
        if (this.f != null) {
            for (n3 = this.f.size() - 1; n3 >= 0; --n3) {
                d2 = (androidx.f.a.d)this.f.valueAt(n3);
                if (d2 == null || d2.H != n2) continue;
                return d2;
            }
        }
        return null;
    }

    void c(androidx.f.a.d d2) {
        this.a(d2, this.l, 0, 0, false);
    }

    void c(androidx.f.a.d d2, Bundle bundle, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).c(d2, bundle, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.c(this, d2, bundle);
        }
    }

    void c(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).c(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.b(this, d2);
        }
    }

    @Override
    public boolean c() {
        this.A();
        return this.a(null, -1, 0);
    }

    @Override
    public int d() {
        if (this.g != null) {
            return this.g.size();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(int n2) {
        synchronized (this) {
            this.i.set(n2, null);
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing back stack index ");
                stringBuilder.append(n2);
                Log.v((String)"FragmentManager", (String)stringBuilder.toString());
            }
            this.j.add(n2);
            return;
        }
    }

    void d(androidx.f.a.d d2) {
        if (d2.w && !d2.z) {
            d2.b(d2.h(d2.l), null, d2.l);
            if (d2.S != null) {
                d2.T = d2.S;
                d2.S.setSaveFromParentEnabled(false);
                if (d2.K) {
                    d2.S.setVisibility(8);
                }
                d2.a(d2.S, d2.l);
                this.a(d2, d2.S, d2.l, false);
                return;
            }
            d2.T = null;
        }
    }

    void d(androidx.f.a.d d2, Bundle bundle, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).d(d2, bundle, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.d(this, d2, bundle);
        }
    }

    void d(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).d(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.c(this, d2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<androidx.f.a.d> e() {
        if (this.e.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<androidx.f.a.d> arrayList = this.e;
        synchronized (arrayList) {
            return (List)this.e.clone();
        }
    }

    void e(final androidx.f.a.d d2) {
        if (d2.S != null) {
            c c2 = this.a(d2, d2.Z(), d2.K ^ true, d2.aa());
            if (c2 != null && c2.b != null) {
                c2.b.setTarget((Object)d2.S);
                if (d2.K) {
                    if (d2.ah()) {
                        d2.i(false);
                    } else {
                        final ViewGroup viewGroup = d2.R;
                        final View view = d2.S;
                        viewGroup.startViewTransition(view);
                        c2.b.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener((Animator.AnimatorListener)this);
                                if (d2.S != null) {
                                    d2.S.setVisibility(8);
                                }
                            }
                        });
                    }
                } else {
                    d2.S.setVisibility(0);
                }
                j.b(d2.S, c2);
                c2.b.start();
            } else {
                if (c2 != null) {
                    j.b(d2.S, c2);
                    d2.S.startAnimation(c2.a);
                    c2.a.start();
                }
                int n2 = d2.K && !d2.ah() ? 8 : 0;
                d2.S.setVisibility(n2);
                if (d2.ah()) {
                    d2.i(false);
                }
            }
        }
        if (d2.u && d2.O && d2.P) {
            this.r = true;
        }
        d2.Y = false;
        d2.b(d2.K);
    }

    void e(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).e(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.d(this, d2);
        }
    }

    void f(androidx.f.a.d d2) {
        int n2;
        if (d2 == null) {
            return;
        }
        int n3 = n2 = this.l;
        if (d2.v) {
            n3 = d2.j() ? Math.min(n2, 1) : Math.min(n2, 0);
        }
        this.a(d2, n3, d2.Z(), d2.aa(), false);
        if (d2.S != null) {
            Object object = this.q(d2);
            if (object != null) {
                object = ((androidx.f.a.d)object).S;
                ViewGroup viewGroup = d2.R;
                n3 = viewGroup.indexOfChild((View)object);
                n2 = viewGroup.indexOfChild(d2.S);
                if (n2 < n3) {
                    viewGroup.removeViewAt(n2);
                    viewGroup.addView(d2.S, n3);
                }
            }
            if (d2.X && d2.R != null) {
                if (d2.Z > 0.0f) {
                    d2.S.setAlpha(d2.Z);
                }
                d2.Z = 0.0f;
                d2.X = false;
                object = this.a(d2, d2.Z(), true, d2.aa());
                if (object != null) {
                    j.b(d2.S, (c)object);
                    if (((c)object).a != null) {
                        d2.S.startAnimation(((c)object).a);
                    } else {
                        ((c)object).b.setTarget((Object)d2.S);
                        ((c)object).b.start();
                    }
                }
            }
        }
        if (d2.Y) {
            this.e(d2);
        }
    }

    void f(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).f(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.e(this, d2);
        }
    }

    @Override
    public boolean f() {
        return this.s || this.t;
        {
        }
    }

    void g() {
        if (this.f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            androidx.f.a.d d2 = (androidx.f.a.d)this.f.valueAt(i2);
            if (d2 == null) continue;
            this.b(d2);
        }
    }

    void g(androidx.f.a.d d2) {
        if (d2.o >= 0) {
            return;
        }
        int n2 = this.d;
        this.d = n2 + 1;
        d2.a(n2, this.o);
        if (this.f == null) {
            this.f = new SparseArray();
        }
        this.f.put(d2.o, (Object)d2);
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Allocated fragment index ");
            stringBuilder.append(d2);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
    }

    void g(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).g(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.f(this, d2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void h() {
        synchronized (this) {
            ArrayList<j> arrayList = this.C;
            boolean bl2 = false;
            boolean bl3 = arrayList != null && !this.C.isEmpty();
            boolean bl4 = bl2;
            if (this.b != null) {
                bl4 = bl2;
                if (this.b.size() == 1) {
                    bl4 = true;
                }
            }
            if (bl3 || bl4) {
                this.m.h().removeCallbacks(this.E);
                this.m.h().post(this.E);
            }
            return;
        }
    }

    void h(androidx.f.a.d d2) {
        if (d2.o < 0) {
            return;
        }
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Freeing fragment index ");
            stringBuilder.append(d2);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.f.put(d2.o, null);
        d2.C();
    }

    void h(androidx.f.a.d d2, boolean bl2) {
        Object object;
        if (this.o != null && (object = this.o.r()) instanceof j) {
            ((j)object).h(d2, true);
        }
        for (f f2 : this.J) {
            if (bl2 && !f2.b) continue;
            f2.a.g(this, d2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void i(androidx.f.a.d d2) {
        Serializable serializable;
        if (a) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("remove: ");
            ((StringBuilder)serializable).append(d2);
            ((StringBuilder)serializable).append(" nesting=");
            ((StringBuilder)serializable).append(d2.A);
            Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).toString());
        }
        boolean bl2 = d2.j();
        if (d2.L) {
            if (!(bl2 ^ true)) return;
        }
        serializable = this.e;
        // MONITORENTER : serializable
        this.e.remove(d2);
        // MONITOREXIT : serializable
        if (d2.O && d2.P) {
            this.r = true;
        }
        d2.u = false;
        d2.v = true;
    }

    public boolean i() {
        this.c(true);
        boolean bl2 = false;
        while (this.c(this.x, this.y)) {
            this.c = true;
            try {
                this.b(this.x, this.y);
                bl2 = true;
            }
            finally {
                this.B();
            }
        }
        this.j();
        this.E();
        return bl2;
    }

    void j() {
        if (this.w) {
            this.w = false;
            this.g();
        }
    }

    public void j(androidx.f.a.d d2) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(d2);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        if (!d2.K) {
            d2.K = true;
            d2.Y = true ^ d2.Y;
        }
    }

    void k() {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); ++i2) {
                this.k.get(i2).a();
            }
        }
    }

    public void k(androidx.f.a.d d2) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(d2);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        if (d2.K) {
            d2.K = false;
            d2.Y ^= true;
        }
    }

    k l() {
        j.a(this.D);
        return this.D;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void l(androidx.f.a.d d2) {
        Serializable serializable;
        if (a) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("detach: ");
            ((StringBuilder)serializable).append(d2);
            Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).toString());
        }
        if (d2.L) return;
        d2.L = true;
        if (!d2.u) return;
        if (a) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("remove from detach: ");
            ((StringBuilder)serializable).append(d2);
            Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).toString());
        }
        serializable = this.e;
        // MONITORENTER : serializable
        this.e.remove(d2);
        // MONITOREXIT : serializable
        if (d2.O && d2.P) {
            this.r = true;
        }
        d2.u = false;
    }

    void m() {
        Object object;
        Object object2;
        Object object3;
        if (this.f != null) {
            Object object4;
            Object object5;
            Object object6 = object5 = (object4 = null);
            int n2 = 0;
            do {
                object = object4;
                object3 = object5;
                object2 = object6;
                if (n2 < this.f.size()) {
                    androidx.f.a.d d2 = (androidx.f.a.d)this.f.valueAt(n2);
                    object3 = object4;
                    object = object5;
                    Object object7 = object6;
                    if (d2 != null) {
                        int n3;
                        object2 = object4;
                        if (d2.M) {
                            object3 = object4;
                            if (object4 == null) {
                                object3 = new ArrayList();
                            }
                            ((ArrayList)object3).add(d2);
                            n3 = d2.r != null ? d2.r.o : -1;
                            d2.s = n3;
                            object2 = object3;
                            if (a) {
                                object4 = new StringBuilder();
                                ((StringBuilder)object4).append("retainNonConfig: keeping retained ");
                                ((StringBuilder)object4).append(d2);
                                Log.v((String)"FragmentManager", (String)((StringBuilder)object4).toString());
                                object2 = object3;
                            }
                        }
                        if (d2.D != null) {
                            d2.D.m();
                            object3 = d2.D.D;
                        } else {
                            object3 = d2.E;
                        }
                        object4 = object5;
                        if (object5 == null) {
                            object4 = object5;
                            if (object3 != null) {
                                object5 = new ArrayList(this.f.size());
                                n3 = 0;
                                do {
                                    object4 = object5;
                                    if (n3 >= n2) break;
                                    ((ArrayList)object5).add(null);
                                    ++n3;
                                } while (true);
                            }
                        }
                        if (object4 != null) {
                            ((ArrayList)object4).add(object3);
                        }
                        object5 = object6;
                        if (object6 == null) {
                            object5 = object6;
                            if (d2.F != null) {
                                object6 = new ArrayList(this.f.size());
                                n3 = 0;
                                do {
                                    object5 = object6;
                                    if (n3 >= n2) break;
                                    ((ArrayList)object6).add(null);
                                    ++n3;
                                } while (true);
                            }
                        }
                        object3 = object2;
                        object = object4;
                        object7 = object5;
                        if (object5 != null) {
                            ((ArrayList)object5).add(d2.F);
                            object7 = object5;
                            object = object4;
                            object3 = object2;
                        }
                    }
                    ++n2;
                    object4 = object3;
                    object5 = object;
                    object6 = object7;
                    continue;
                }
                break;
            } while (true);
        } else {
            object = null;
            k k2 = object;
            object2 = k2;
            object3 = k2;
        }
        if (object == null && object3 == null && object2 == null) {
            this.D = null;
            return;
        }
        this.D = new k((List<androidx.f.a.d>)object, (List<k>)object3, (List<y>)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m(androidx.f.a.d d2) {
        Serializable serializable;
        if (a) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("attach: ");
            ((StringBuilder)serializable).append(d2);
            Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).toString());
        }
        if (d2.L) {
            d2.L = false;
            if (!d2.u) {
                if (this.e.contains(d2)) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Fragment already added: ");
                    ((StringBuilder)serializable).append(d2);
                    throw new IllegalStateException(((StringBuilder)serializable).toString());
                }
                if (a) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("add from attach: ");
                    ((StringBuilder)serializable).append(d2);
                    Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).toString());
                }
                serializable = this.e;
                synchronized (serializable) {
                    this.e.add(d2);
                }
                d2.u = true;
                if (d2.O && d2.P) {
                    this.r = true;
                    return;
                }
            }
        }
    }

    Parcelable n() {
        this.C();
        this.D();
        this.i();
        this.s = true;
        androidx.f.a.b[] arrb = null;
        this.D = null;
        if (this.f != null) {
            Object object;
            Object object2;
            int n2;
            if (this.f.size() <= 0) {
                return null;
            }
            int n3 = this.f.size();
            n[] arrn = new n[n3];
            int n4 = 0;
            int n5 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                StringBuilder stringBuilder;
                object = (int[])this.f.valueAt(n2);
                if (object == null) continue;
                if (((androidx.f.a.d)object).o < 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Failure saving state: active ");
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append(" has cleared index: ");
                    ((StringBuilder)object2).append(((androidx.f.a.d)object).o);
                    this.a(new IllegalStateException(((StringBuilder)object2).toString()));
                }
                arrn[n2] = object2 = new n((androidx.f.a.d)object);
                if (((androidx.f.a.d)object).k > 0 && ((n)object2).k == null) {
                    ((n)object2).k = this.o((androidx.f.a.d)object);
                    if (((androidx.f.a.d)object).r != null) {
                        if (object.r.o < 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Failure saving state: ");
                            stringBuilder.append(object);
                            stringBuilder.append(" has target not in fragment manager: ");
                            stringBuilder.append(((androidx.f.a.d)object).r);
                            this.a(new IllegalStateException(stringBuilder.toString()));
                        }
                        if (((n)object2).k == null) {
                            ((n)object2).k = new Bundle();
                        }
                        this.a(((n)object2).k, "android:target_state", ((androidx.f.a.d)object).r);
                        if (((androidx.f.a.d)object).t != 0) {
                            ((n)object2).k.putInt("android:target_req_state", ((androidx.f.a.d)object).t);
                        }
                    }
                } else {
                    ((n)object2).k = ((androidx.f.a.d)object).l;
                }
                if (a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Saved state of ");
                    stringBuilder.append(object);
                    stringBuilder.append(": ");
                    stringBuilder.append((Object)((n)object2).k);
                    Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                }
                n5 = 1;
            }
            if (n5 == 0) {
                if (a) {
                    Log.v((String)"FragmentManager", (String)"saveAllState: no fragments!");
                }
                return null;
            }
            n5 = this.e.size();
            if (n5 > 0) {
                object2 = new int[n5];
                n2 = 0;
                do {
                    object = object2;
                    if (n2 < n5) {
                        object2[n2] = this.e.get((int)n2).o;
                        if (object2[n2] < 0) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Failure saving state: active ");
                            ((StringBuilder)object).append(this.e.get(n2));
                            ((StringBuilder)object).append(" has cleared index: ");
                            ((StringBuilder)object).append((int)object2[n2]);
                            this.a(new IllegalStateException(((StringBuilder)object).toString()));
                        }
                        if (a) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("saveAllState: adding fragment #");
                            ((StringBuilder)object).append(n2);
                            ((StringBuilder)object).append(": ");
                            ((StringBuilder)object).append(this.e.get(n2));
                            Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
                        }
                        ++n2;
                        continue;
                    }
                    break;
                } while (true);
            } else {
                object = null;
            }
            object2 = arrb;
            if (this.g != null) {
                n5 = this.g.size();
                object2 = arrb;
                if (n5 > 0) {
                    arrb = new androidx.f.a.b[n5];
                    n2 = n4;
                    do {
                        object2 = arrb;
                        if (n2 >= n5) break;
                        arrb[n2] = new androidx.f.a.b(this.g.get(n2));
                        if (a) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("saveAllState: adding back stack #");
                            ((StringBuilder)object2).append(n2);
                            ((StringBuilder)object2).append(": ");
                            ((StringBuilder)object2).append(this.g.get(n2));
                            Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
                        }
                        ++n2;
                    } while (true);
                }
            }
            arrb = new androidx.f.a.b[]();
            arrb.a = arrn;
            arrb.b = object;
            arrb.c = object2;
            if (this.p != null) {
                arrb.d = this.p.o;
            }
            arrb.e = this.d;
            this.m();
            return arrb;
        }
        return null;
    }

    void n(androidx.f.a.d d2) {
        if (d2.T == null) {
            return;
        }
        if (this.B == null) {
            this.B = new SparseArray();
        } else {
            this.B.clear();
        }
        d2.T.saveHierarchyState(this.B);
        if (this.B.size() > 0) {
            d2.m = this.B;
            this.B = null;
        }
    }

    Bundle o(androidx.f.a.d d2) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        d2.n(this.A);
        this.d(d2, this.A, false);
        if (!this.A.isEmpty()) {
            bundle = this.A;
            this.A = null;
        } else {
            bundle = null;
        }
        if (d2.S != null) {
            this.n(d2);
        }
        Bundle bundle2 = bundle;
        if (d2.m != null) {
            bundle2 = bundle;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            bundle2.putSparseParcelableArray("android:view_state", d2.m);
        }
        bundle = bundle2;
        if (!d2.V) {
            bundle = bundle2;
            if (bundle2 == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", d2.V);
        }
        return bundle;
    }

    public void o() {
        this.D = null;
        this.s = false;
        this.t = false;
        int n2 = this.e.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null) continue;
            d2.R();
        }
    }

    public View onCreateView(View object, String object2, Context context, AttributeSet attributeSet) {
        String string2;
        int n2;
        int n3;
        String string3;
        block21 : {
            block20 : {
                block19 : {
                    if (!"fragment".equals(object2)) {
                        return null;
                    }
                    object2 = attributeSet.getAttributeValue(null, "class");
                    TypedArray typedArray = context.obtainStyledAttributes(attributeSet, g.a);
                    n2 = 0;
                    string3 = object2;
                    if (object2 == null) {
                        string3 = typedArray.getString(0);
                    }
                    n3 = typedArray.getResourceId(1, -1);
                    string2 = typedArray.getString(2);
                    typedArray.recycle();
                    if (!androidx.f.a.d.a(this.m.g(), string3)) {
                        return null;
                    }
                    if (object != null) {
                        n2 = object.getId();
                    }
                    if (n2 == -1 && n3 == -1 && string2 == null) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(attributeSet.getPositionDescription());
                        ((StringBuilder)object).append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
                        ((StringBuilder)object).append(string3);
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    object2 = n3 != -1 ? this.c(n3) : null;
                    object = object2;
                    if (object2 == null) {
                        object = object2;
                        if (string2 != null) {
                            object = this.a(string2);
                        }
                    }
                    object2 = object;
                    if (object == null) {
                        object2 = object;
                        if (n2 != -1) {
                            object2 = this.c(n2);
                        }
                    }
                    if (a) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("onCreateView: id=0x");
                        ((StringBuilder)object).append(Integer.toHexString(n3));
                        ((StringBuilder)object).append(" fname=");
                        ((StringBuilder)object).append(string3);
                        ((StringBuilder)object).append(" existing=");
                        ((StringBuilder)object).append(object2);
                        Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
                    }
                    if (object2 != null) break block19;
                    object = this.n.a(context, string3, null);
                    ((androidx.f.a.d)object).w = true;
                    int n4 = n3 != 0 ? n3 : n2;
                    ((androidx.f.a.d)object).H = n4;
                    ((androidx.f.a.d)object).I = n2;
                    ((androidx.f.a.d)object).J = string2;
                    ((androidx.f.a.d)object).x = true;
                    ((androidx.f.a.d)object).B = this;
                    ((androidx.f.a.d)object).C = this.m;
                    ((androidx.f.a.d)object).a(this.m.g(), attributeSet, ((androidx.f.a.d)object).l);
                    this.a((androidx.f.a.d)object, true);
                    break block20;
                }
                if (((androidx.f.a.d)object2).x) break block21;
                ((androidx.f.a.d)object2).x = true;
                ((androidx.f.a.d)object2).C = this.m;
                if (!((androidx.f.a.d)object2).N) {
                    ((androidx.f.a.d)object2).a(this.m.g(), attributeSet, ((androidx.f.a.d)object2).l);
                }
                object = object2;
            }
            if (this.l < 1 && ((androidx.f.a.d)object).w) {
                this.a((androidx.f.a.d)object, 1, 0, 0, false);
            } else {
                this.c((androidx.f.a.d)object);
            }
            if (((androidx.f.a.d)object).S != null) {
                if (n3 != 0) {
                    ((androidx.f.a.d)object).S.setId(n3);
                }
                if (((androidx.f.a.d)object).S.getTag() == null) {
                    ((androidx.f.a.d)object).S.setTag((Object)string2);
                }
                return ((androidx.f.a.d)object).S;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Fragment ");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(" did not create a view.");
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(attributeSet.getPositionDescription());
        ((StringBuilder)object).append(": Duplicate id 0x");
        ((StringBuilder)object).append(Integer.toHexString(n3));
        ((StringBuilder)object).append(", tag ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", or parent id 0x");
        ((StringBuilder)object).append(Integer.toHexString(n2));
        ((StringBuilder)object).append(" with another fragment for ");
        ((StringBuilder)object).append(string3);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string2, context, attributeSet);
    }

    public void p() {
        this.s = false;
        this.t = false;
        this.f(1);
    }

    public void p(androidx.f.a.d d2) {
        if (d2 != null && (this.f.get(d2.o) != d2 || d2.C != null && d2.r() != this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(d2);
            stringBuilder.append(" is not an active fragment of FragmentManager ");
            stringBuilder.append(this);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.p = d2;
    }

    public void q() {
        this.s = false;
        this.t = false;
        this.f(2);
    }

    public void r() {
        this.s = false;
        this.t = false;
        this.f(3);
    }

    public void s() {
        this.s = false;
        this.t = false;
        this.f(4);
    }

    public void t() {
        this.f(3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        Object object = this.o != null ? this.o : this.m;
        androidx.core.g.a.a(object, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void u() {
        this.t = true;
        this.f(2);
    }

    public void v() {
        this.f(1);
    }

    public void w() {
        this.u = true;
        this.i();
        this.f(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void x() {
        for (int i2 = 0; i2 < this.e.size(); ++i2) {
            androidx.f.a.d d2 = this.e.get(i2);
            if (d2 == null) continue;
            d2.S();
        }
    }

    public androidx.f.a.d y() {
        return this.p;
    }

    LayoutInflater.Factory2 z() {
        return this;
    }

    private static class a
    extends b {
        View a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (!androidx.core.h.t.B(this.a) && Build.VERSION.SDK_INT < 24) {
                this.a.setLayerType(0, null);
            } else {
                this.a.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.a.setLayerType(0, null);
                    }
                });
            }
            super.onAnimationEnd(animation);
        }

    }

    private static class b
    implements Animation.AnimationListener {
        private final Animation.AnimationListener a;

        b(Animation.AnimationListener animationListener) {
            this.a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }
    }

    private static class c {
        public final Animation a;
        public final Animator b;

        c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator != null) {
                return;
            }
            throw new IllegalStateException("Animator cannot be null");
        }

        c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation != null) {
                return;
            }
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    private static class d
    extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, null);
            animator.removeListener((Animator.AnimatorListener)this);
        }

        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, null);
        }
    }

    private static class e
    extends AnimationSet
    implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.a = viewGroup;
            this.b = view;
            this.addAnimation(animation);
            this.a.post((Runnable)this);
        }

        public boolean getTransformation(long l2, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return this.d ^ true;
            }
            if (!super.getTransformation(l2, transformation)) {
                this.c = true;
                t.a((View)this.a, this);
            }
            return true;
        }

        public boolean getTransformation(long l2, Transformation transformation, float f2) {
            this.e = true;
            if (this.c) {
                return this.d ^ true;
            }
            if (!super.getTransformation(l2, transformation, f2)) {
                this.c = true;
                t.a((View)this.a, this);
            }
            return true;
        }

        @Override
        public void run() {
            if (!this.c && this.e) {
                this.e = false;
                this.a.post((Runnable)this);
                return;
            }
            this.a.endViewTransition(this.b);
            this.d = true;
        }
    }

    private static final class f {
        final i.b a;
        final boolean b;

        f(i.b b2, boolean bl2) {
            this.a = b2;
            this.b = bl2;
        }
    }

    static class g {
        public static final int[] a = new int[]{16842755, 16842960, 16842961};
    }

    static interface h {
        public boolean a(ArrayList<androidx.f.a.a> var1, ArrayList<Boolean> var2);
    }

    private class i
    implements h {
        final String a;
        final int b;
        final int c;

        i(String string2, int n2, int n3) {
            this.a = string2;
            this.b = n2;
            this.c = n3;
        }

        @Override
        public boolean a(ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2) {
            androidx.f.a.i i2;
            if (j.this.p != null && this.b < 0 && this.a == null && (i2 = j.this.p.t()) != null && i2.c()) {
                return false;
            }
            return j.this.a(arrayList, arrayList2, this.a, this.b, this.c);
        }
    }

    static class j
    implements d.c {
        final boolean a;
        final androidx.f.a.a b;
        private int c;

        j(androidx.f.a.a a2, boolean bl2) {
            this.a = bl2;
            this.b = a2;
        }

        @Override
        public void a() {
            --this.c;
            if (this.c != 0) {
                return;
            }
            this.b.a.h();
        }

        @Override
        public void b() {
            ++this.c;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            int n2 = this.c;
            n2 = n2 > 0 ? 1 : 0;
            j j2 = this.b.a;
            int n3 = j2.e.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                androidx.f.a.d d2 = j2.e.get(i2);
                d2.a((d.c)null);
                if (n2 == 0 || !d2.ag()) continue;
                d2.M();
            }
            this.b.a.a(this.b, this.a, (boolean)(n2 ^ 1), true);
        }

        public void e() {
            this.b.a.a(this.b, this.a, false, false);
        }
    }

}

