/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.graphics.Path
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.ListAdapter
 *  android.widget.ListView
 */
package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.c.d;
import androidx.j.ad;
import androidx.j.al;
import androidx.j.g;
import androidx.j.p;
import androidx.j.q;
import androidx.j.s;
import androidx.j.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class m
implements Cloneable {
    private static ThreadLocal<androidx.c.a<Animator, a>> A;
    private static final int[] h;
    private static final g i;
    private ViewGroup B = null;
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList();
    private b H;
    private androidx.c.a<String, String> I;
    private g J = i;
    long a = -1L;
    ArrayList<Integer> b = new ArrayList();
    ArrayList<View> c = new ArrayList();
    q d = null;
    boolean e = false;
    ArrayList<Animator> f = new ArrayList();
    p g;
    private String j = this.getClass().getName();
    private long k = -1L;
    private TimeInterpolator l = null;
    private ArrayList<String> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<Integer> o = null;
    private ArrayList<View> p = null;
    private ArrayList<Class> q = null;
    private ArrayList<String> r = null;
    private ArrayList<Integer> s = null;
    private ArrayList<View> t = null;
    private ArrayList<Class> u = null;
    private t v = new t();
    private t w = new t();
    private int[] x = h;
    private ArrayList<s> y;
    private ArrayList<s> z;

    static {
        h = new int[]{2, 1, 3, 4};
        i = new g(){

            @Override
            public Path a(float f2, float f3, float f4, float f5) {
                Path path = new Path();
                path.moveTo(f2, f3);
                path.lineTo(f4, f5);
                return path;
            }
        };
        A = new ThreadLocal();
    }

    private void a(Animator animator, final androidx.c.a<Animator, a> a2) {
        if (animator != null) {
            animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    a2.remove((Object)animator);
                    m.this.f.remove((Object)animator);
                }

                public void onAnimationStart(Animator animator) {
                    m.this.f.add(animator);
                }
            });
            this.a(animator);
        }
    }

    private void a(androidx.c.a<View, s> a2, androidx.c.a<View, s> a3) {
        for (int i2 = a2.size() - 1; i2 >= 0; --i2) {
            Object object = (View)a2.b(i2);
            if (object == null || !this.a((View)object) || (object = (s)a3.remove(object)) == null || object.b == null || !this.a(object.b)) continue;
            s s2 = (s)a2.d(i2);
            this.y.add(s2);
            this.z.add((s)object);
        }
    }

    private void a(androidx.c.a<View, s> a2, androidx.c.a<View, s> a3, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int n2 = sparseArray.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view;
            View view2 = (View)sparseArray.valueAt(i2);
            if (view2 == null || !this.a(view2) || (view = (View)sparseArray2.get(sparseArray.keyAt(i2))) == null || !this.a(view)) continue;
            s s2 = (s)a2.get((Object)view2);
            s s3 = (s)a3.get((Object)view);
            if (s2 == null || s3 == null) continue;
            this.y.add(s2);
            this.z.add(s3);
            a2.remove((Object)view2);
            a3.remove((Object)view);
        }
    }

    private void a(androidx.c.a<View, s> a2, androidx.c.a<View, s> a3, androidx.c.a<String, View> a4, androidx.c.a<String, View> a5) {
        int n2 = a4.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view;
            View view2 = (View)a4.c(i2);
            if (view2 == null || !this.a(view2) || (view = (View)a5.get(a4.b(i2))) == null || !this.a(view)) continue;
            s s2 = (s)a2.get((Object)view2);
            s s3 = (s)a3.get((Object)view);
            if (s2 == null || s3 == null) continue;
            this.y.add(s2);
            this.z.add(s3);
            a2.remove((Object)view2);
            a3.remove((Object)view);
        }
    }

    private void a(androidx.c.a<View, s> a2, androidx.c.a<View, s> a3, d<View> d2, d<View> d3) {
        int n2 = d2.b();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view;
            View view2 = d2.c(i2);
            if (view2 == null || !this.a(view2) || (view = d3.a(d2.b(i2))) == null || !this.a(view)) continue;
            s s2 = (s)a2.get((Object)view2);
            s s3 = (s)a3.get((Object)view);
            if (s2 == null || s3 == null) continue;
            this.y.add(s2);
            this.z.add(s3);
            a2.remove((Object)view2);
            a3.remove((Object)view);
        }
    }

    private static void a(t t2, View view, s object) {
        t2.a.put(view, (s)object);
        int n2 = view.getId();
        if (n2 >= 0) {
            if (t2.b.indexOfKey(n2) >= 0) {
                t2.b.put(n2, null);
            } else {
                t2.b.put(n2, (Object)view);
            }
        }
        if ((object = androidx.core.h.t.o(view)) != null) {
            if (t2.d.containsKey(object)) {
                t2.d.put((String)object, null);
            } else {
                t2.d.put((String)object, view);
            }
        }
        if (view.getParent() instanceof ListView && (object = (ListView)view.getParent()).getAdapter().hasStableIds()) {
            long l2 = object.getItemIdAtPosition(object.getPositionForView(view));
            if (t2.c.c(l2) >= 0) {
                view = t2.c.a(l2);
                if (view != null) {
                    androidx.core.h.t.a(view, false);
                    t2.c.b(l2, null);
                    return;
                }
            } else {
                androidx.core.h.t.a(view, true);
                t2.c.b(l2, view);
            }
        }
    }

    private void a(t t2, t t3) {
        androidx.c.a<View, s> a2 = new androidx.c.a<View, s>(t2.a);
        androidx.c.a<View, s> a3 = new androidx.c.a<View, s>(t3.a);
        block6 : for (int i2 = 0; i2 < this.x.length; ++i2) {
            switch (this.x[i2]) {
                default: {
                    continue block6;
                }
                case 4: {
                    this.a(a2, a3, t2.c, t3.c);
                    continue block6;
                }
                case 3: {
                    this.a(a2, a3, t2.b, t3.b);
                    continue block6;
                }
                case 2: {
                    this.a(a2, a3, t2.d, t3.d);
                    continue block6;
                }
                case 1: {
                    this.a(a2, a3);
                }
            }
        }
        this.b(a2, a3);
    }

    private static boolean a(s object, s object2, String string2) {
        object = ((s)object).a.get(string2);
        object2 = ((s)object2).a.get(string2);
        boolean bl2 = true;
        if (object == null && object2 == null) {
            return false;
        }
        if (object != null) {
            if (object2 == null) {
                return true;
            }
            bl2 = true ^ object.equals(object2);
        }
        return bl2;
    }

    private void b(androidx.c.a<View, s> object, androidx.c.a<View, s> a2) {
        int n2 = 0;
        int n3 = 0;
        do {
            if (n3 >= ((androidx.c.g)object).size()) break;
            s s2 = (s)((androidx.c.g)object).c(n3);
            if (this.a(s2.b)) {
                this.y.add(s2);
                this.z.add(null);
            }
            ++n3;
        } while (true);
        for (int i2 = n2; i2 < a2.size(); ++i2) {
            object = (s)a2.c(i2);
            if (!this.a(((s)object).b)) continue;
            this.z.add((s)object);
            this.y.add(null);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(View view, boolean bl2) {
        int n2;
        if (view == null) {
            return;
        }
        int n3 = view.getId();
        if (this.o != null && this.o.contains(n3)) {
            return;
        }
        if (this.p != null && this.p.contains((Object)view)) {
            return;
        }
        Object object = this.q;
        int n4 = 0;
        if (object != null) {
            int n5 = this.q.size();
            for (n2 = 0; n2 < n5; ++n2) {
                if (!this.q.get(n2).isInstance((Object)view)) continue;
                return;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            s s2 = new s();
            s2.b = view;
            if (bl2) {
                this.a(s2);
            } else {
                this.b(s2);
            }
            s2.c.add(this);
            this.c(s2);
            object = bl2 ? this.v : this.w;
            m.a((t)object, view, s2);
        }
        if (view instanceof ViewGroup) {
            if (this.s != null && this.s.contains(n3)) {
                return;
            }
            if (this.t != null && this.t.contains((Object)view)) {
                return;
            }
            if (this.u != null) {
                n3 = this.u.size();
                for (n2 = 0; n2 < n3; ++n2) {
                    if (!this.u.get(n2).isInstance((Object)view)) continue;
                    return;
                }
            }
            view = (ViewGroup)view;
            for (n2 = n4; n2 < view.getChildCount(); ++n2) {
                this.c(view.getChildAt(n2), bl2);
            }
        }
    }

    private static androidx.c.a<Animator, a> q() {
        androidx.c.a<Animator, a> a2;
        androidx.c.a<Object, a> a3 = a2 = A.get();
        if (a2 == null) {
            a3 = new androidx.c.a();
            A.set(a3);
        }
        return a3;
    }

    public Animator a(ViewGroup viewGroup, s s2, s s3) {
        return null;
    }

    public m a(long l2) {
        this.a = l2;
        return this;
    }

    public m a(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    public m a(c c2) {
        if (this.F == null) {
            this.F = new ArrayList();
        }
        this.F.add(c2);
        return this;
    }

    public s a(View view, boolean bl2) {
        if (this.d != null) {
            return this.d.a(view, bl2);
        }
        t t2 = bl2 ? this.v : this.w;
        return (s)t2.a.get((Object)view);
    }

    String a(String charSequence) {
        CharSequence charSequence2;
        block13 : {
            block12 : {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(this.getClass().getSimpleName());
                ((StringBuilder)charSequence2).append("@");
                ((StringBuilder)charSequence2).append(Integer.toHexString(this.hashCode()));
                ((StringBuilder)charSequence2).append(": ");
                charSequence2 = ((StringBuilder)charSequence2).toString();
                charSequence = charSequence2;
                if (this.a != -1L) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append("dur(");
                    ((StringBuilder)charSequence).append(this.a);
                    ((StringBuilder)charSequence).append(") ");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                charSequence2 = charSequence;
                if (this.k != -1L) {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append("dly(");
                    ((StringBuilder)charSequence2).append(this.k);
                    ((StringBuilder)charSequence2).append(") ");
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                charSequence = charSequence2;
                if (this.l != null) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append("interp(");
                    ((StringBuilder)charSequence).append((Object)this.l);
                    ((StringBuilder)charSequence).append(") ");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                if (this.b.size() > 0) break block12;
                charSequence2 = charSequence;
                if (this.c.size() <= 0) break block13;
            }
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("tgts(");
            charSequence2 = ((StringBuilder)charSequence2).toString();
            int n2 = this.b.size();
            int n3 = 0;
            charSequence = charSequence2;
            if (n2 > 0) {
                charSequence = charSequence2;
                for (n2 = 0; n2 < this.b.size(); ++n2) {
                    charSequence2 = charSequence;
                    if (n2 > 0) {
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        ((StringBuilder)charSequence2).append(", ");
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                    }
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(this.b.get(n2));
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            }
            charSequence2 = charSequence;
            if (this.c.size() > 0) {
                n2 = n3;
                do {
                    charSequence2 = charSequence;
                    if (n2 >= this.c.size()) break;
                    charSequence2 = charSequence;
                    if (n2 > 0) {
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        ((StringBuilder)charSequence2).append(", ");
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                    }
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append((Object)this.c.get(n2));
                    charSequence = ((StringBuilder)charSequence).toString();
                    ++n2;
                } while (true);
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(")");
            charSequence2 = ((StringBuilder)charSequence).toString();
        }
        return charSequence2;
    }

    protected void a(Animator animator) {
        if (animator == null) {
            this.k();
            return;
        }
        if (this.b() >= 0L) {
            animator.setDuration(this.b());
        }
        if (this.c() >= 0L) {
            animator.setStartDelay(this.c());
        }
        if (this.d() != null) {
            animator.setInterpolator(this.d());
        }
        animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                m.this.k();
                animator.removeListener((Animator.AnimatorListener)this);
            }
        });
        animator.start();
    }

    void a(ViewGroup viewGroup) {
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.a(this.v, this.w);
        androidx.c.a<Animator, a> a2 = m.q();
        int n2 = a2.size();
        al al2 = ad.b((View)viewGroup);
        --n2;
        while (n2 >= 0) {
            a a3;
            Animator animator = (Animator)a2.b(n2);
            if (animator != null && (a3 = (a)a2.get((Object)animator)) != null && a3.a != null && al2.equals(a3.d)) {
                s s2 = a3.c;
                Object object = a3.a;
                s s3 = this.a((View)object, true);
                object = this.b((View)object, true);
                boolean bl2 = (s3 != null || object != null) && a3.e.a(s2, (s)object);
                if (bl2) {
                    if (!animator.isRunning() && !animator.isStarted()) {
                        a2.remove((Object)animator);
                    } else {
                        animator.cancel();
                    }
                }
            }
            --n2;
        }
        this.a(viewGroup, this.v, this.w, this.y, this.z);
        this.e();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void a(ViewGroup viewGroup, t object, t t2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        androidx.c.a<Animator, a> a2 = m.q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n2 = arrayList.size();
        long l2 = Long.MAX_VALUE;
        int n3 = 0;
        do {
            long l3;
            int n4;
            block19 : {
                Object object2;
                Object object3;
                s s2;
                View view;
                block14 : {
                    s s3;
                    int n5;
                    block20 : {
                        block15 : {
                            block17 : {
                                block18 : {
                                    block13 : {
                                        block16 : {
                                            if (n3 >= n2) break block15;
                                            object3 = arrayList.get(n3);
                                            object = arrayList2.get(n3);
                                            s2 = object3;
                                            if (object3 != null) {
                                                s2 = object3;
                                                if (!((s)object3).c.contains(this)) {
                                                    s2 = null;
                                                }
                                            }
                                            object2 = object;
                                            if (object != null) {
                                                object2 = object;
                                                if (!((s)object).c.contains(this)) {
                                                    object2 = null;
                                                }
                                            }
                                            if (s2 == null && object2 == null) break block16;
                                            n4 = s2 != null && object2 != null && !this.a(s2, (s)object2) ? 0 : 1;
                                            if (n4 == 0 || (object = this.a(viewGroup, s2, (s)object2)) == null) break block16;
                                            if (object2 == null) break block17;
                                            view = ((s)object2).b;
                                            String[] arrstring = this.a();
                                            if (view == null || arrstring == null || arrstring.length <= 0) break block18;
                                            s3 = new s();
                                            s3.b = view;
                                            object3 = (s)t2.a.get((Object)view);
                                            n4 = n3;
                                            if (object3 != null) {
                                                n5 = 0;
                                                do {
                                                    n4 = n3;
                                                    if (n5 < arrstring.length) {
                                                        s3.a.put(arrstring[n5], ((s)object3).a.get(arrstring[n5]));
                                                        ++n5;
                                                        continue;
                                                    }
                                                    break block13;
                                                    break;
                                                } while (true);
                                            }
                                            break block13;
                                        }
                                        l3 = l2;
                                        n4 = n3;
                                        break block19;
                                    }
                                    n3 = n4;
                                    n5 = a2.size();
                                    break block20;
                                }
                                object3 = null;
                                break block14;
                            }
                            view = s2.b;
                            object3 = null;
                            break block14;
                        }
                        if (l2 != 0L) {
                            for (n3 = 0; n3 < sparseIntArray.size(); ++n3) {
                                n4 = sparseIntArray.keyAt(n3);
                                viewGroup = this.G.get(n4);
                                viewGroup.setStartDelay((long)sparseIntArray.valueAt(n3) - l2 + viewGroup.getStartDelay());
                            }
                        }
                        return;
                    }
                    for (n4 = 0; n4 < n5; ++n4) {
                        object3 = (a)a2.get((Object)((Animator)a2.b(n4)));
                        if (((a)object3).c == null || ((a)object3).a != view || !((a)object3).b.equals(this.p()) || !((a)object3).c.equals(s3)) continue;
                        object = null;
                        object3 = s3;
                        break block14;
                    }
                    object3 = s3;
                }
                l3 = l2;
                n4 = n3;
                if (object != null) {
                    l3 = l2;
                    if (this.g != null) {
                        l3 = this.g.a(viewGroup, this, s2, (s)object2);
                        sparseIntArray.put(this.G.size(), (int)l3);
                        l3 = Math.min(l3, l2);
                    }
                    a2.put((Animator)object, new a(view, this.p(), this, ad.b((View)viewGroup), (s)object3));
                    this.G.add((Animator)object);
                    n4 = n3;
                }
            }
            n3 = n4 + 1;
            l2 = l3;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(ViewGroup object, boolean bl2) {
        this.a(bl2);
        int n2 = this.b.size();
        int n3 = 0;
        if (n2 <= 0 && this.c.size() <= 0 || this.m != null && !this.m.isEmpty() || this.n != null && !this.n.isEmpty()) {
            this.c((View)object, bl2);
        } else {
            for (n2 = 0; n2 < this.b.size(); ++n2) {
                void var7_5;
                View view = object.findViewById(this.b.get(n2).intValue());
                if (view == null) continue;
                s s2 = new s();
                s2.b = view;
                if (bl2) {
                    this.a(s2);
                } else {
                    this.b(s2);
                }
                s2.c.add(this);
                this.c(s2);
                if (bl2) {
                    t t2 = this.v;
                } else {
                    t t3 = this.w;
                }
                m.a((t)var7_5, view, s2);
            }
            for (n2 = 0; n2 < this.c.size(); ++n2) {
                View view = this.c.get(n2);
                s s3 = new s();
                s3.b = view;
                if (bl2) {
                    this.a(s3);
                } else {
                    this.b(s3);
                }
                s3.c.add(this);
                this.c(s3);
                object = bl2 ? this.v : this.w;
                m.a((t)object, view, s3);
            }
        }
        if (!bl2 && this.I != null) {
            int n4 = this.I.size();
            object = new ArrayList(n4);
            n2 = 0;
            do {
                if (n2 >= n4) break;
                String string2 = (String)this.I.b(n2);
                ((ArrayList)object).add(this.v.d.remove(string2));
                ++n2;
            } while (true);
            for (int i2 = n3; i2 < n4; ++i2) {
                View view = (View)((ArrayList)object).get(i2);
                if (view == null) continue;
                String string3 = (String)this.I.c(i2);
                this.v.d.put(string3, view);
            }
        }
    }

    public void a(g g2) {
        g g3 = g2;
        if (g2 == null) {
            g3 = i;
        }
        this.J = g3;
    }

    public void a(b b2) {
        this.H = b2;
    }

    public void a(p p2) {
        this.g = p2;
    }

    public abstract void a(s var1);

    /*
     * Enabled aggressive block sorting
     */
    void a(boolean bl2) {
        t t2;
        if (bl2) {
            this.v.a.clear();
            this.v.b.clear();
            t2 = this.v;
        } else {
            this.w.a.clear();
            this.w.b.clear();
            t2 = this.w;
        }
        t2.c.c();
    }

    boolean a(View view) {
        int n2;
        int n3 = view.getId();
        if (this.o != null && this.o.contains(n3)) {
            return false;
        }
        if (this.p != null && this.p.contains((Object)view)) {
            return false;
        }
        if (this.q != null) {
            int n4 = this.q.size();
            for (n2 = 0; n2 < n4; ++n2) {
                if (!this.q.get(n2).isInstance((Object)view)) continue;
                return false;
            }
        }
        if (this.r != null && androidx.core.h.t.o(view) != null && this.r.contains(androidx.core.h.t.o(view))) {
            return false;
        }
        if (this.b.size() == 0 && this.c.size() == 0 && (this.n == null || this.n.isEmpty()) && (this.m == null || this.m.isEmpty())) {
            return true;
        }
        if (!this.b.contains(n3)) {
            if (this.c.contains((Object)view)) {
                return true;
            }
            if (this.m != null && this.m.contains(androidx.core.h.t.o(view))) {
                return true;
            }
            if (this.n != null) {
                for (n2 = 0; n2 < this.n.size(); ++n2) {
                    if (!this.n.get(n2).isInstance((Object)view)) continue;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean a(s s2, s s3) {
        boolean bl2;
        block6 : {
            boolean bl3;
            bl2 = bl3 = false;
            if (s2 != null) {
                bl2 = bl3;
                if (s3 != null) {
                    block7 : {
                        Object object = this.a();
                        if (object != null) {
                            int n2 = ((String[])object).length;
                            int n3 = 0;
                            do {
                                bl2 = bl3;
                                if (n3 >= n2) break block6;
                                if (!m.a(s2, s3, (String)object[n3])) {
                                    ++n3;
                                    continue;
                                }
                                break block7;
                                break;
                            } while (true);
                        }
                        object = s2.a.keySet().iterator();
                        do {
                            bl2 = bl3;
                            if (!object.hasNext()) break block6;
                        } while (!m.a(s2, s3, (String)object.next()));
                    }
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public String[] a() {
        return null;
    }

    public long b() {
        return this.a;
    }

    public m b(long l2) {
        this.k = l2;
        return this;
    }

    public m b(View view) {
        this.c.add(view);
        return this;
    }

    public m b(c c2) {
        if (this.F == null) {
            return this;
        }
        this.F.remove(c2);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    s b(View object, boolean bl2) {
        int n2;
        if (this.d != null) {
            return this.d.b((View)object, bl2);
        }
        ArrayList<s> arrayList = bl2 ? this.y : this.z;
        Object var8_4 = null;
        if (arrayList == null) {
            return null;
        }
        int n3 = arrayList.size();
        int n4 = -1;
        int n5 = 0;
        do {
            n2 = n4;
            if (n5 >= n3) break;
            s s2 = arrayList.get(n5);
            if (s2 == null) {
                return null;
            }
            if (s2.b == object) {
                n2 = n5;
                break;
            }
            ++n5;
        } while (true);
        object = var8_4;
        if (n2 >= 0) {
            object = bl2 ? this.z : this.y;
            object = (s)((ArrayList)object).get(n2);
        }
        return object;
    }

    public abstract void b(s var1);

    public long c() {
        return this.k;
    }

    public m c(View view) {
        this.c.remove((Object)view);
        return this;
    }

    void c(s s2) {
        if (this.g != null && !s2.a.isEmpty()) {
            int n2;
            block4 : {
                String[] arrstring = this.g.a();
                if (arrstring == null) {
                    return;
                }
                int n3 = 0;
                for (n2 = 0; n2 < arrstring.length; ++n2) {
                    if (s2.a.containsKey(arrstring[n2])) continue;
                    n2 = n3;
                    break block4;
                }
                n2 = 1;
            }
            if (n2 == 0) {
                this.g.a(s2);
            }
        }
    }

    public /* synthetic */ Object clone() {
        return this.o();
    }

    public TimeInterpolator d() {
        return this.l;
    }

    public void d(View object) {
        if (!this.E) {
            androidx.c.a<Animator, a> a2 = m.q();
            int n2 = a2.size();
            object = ad.b((View)object);
            --n2;
            while (n2 >= 0) {
                a a3 = (a)a2.c(n2);
                if (a3.a != null && object.equals(a3.d)) {
                    androidx.j.a.a((Animator)a2.b(n2));
                }
                --n2;
            }
            if (this.F != null && this.F.size() > 0) {
                object = (ArrayList)this.F.clone();
                int n3 = ((ArrayList)object).size();
                for (n2 = 0; n2 < n3; ++n2) {
                    ((c)((ArrayList)object).get(n2)).b(this);
                }
            }
            this.D = true;
        }
    }

    protected void e() {
        this.j();
        androidx.c.a<Animator, a> a2 = m.q();
        for (Animator animator : this.G) {
            if (!a2.containsKey((Object)animator)) continue;
            this.j();
            this.a(animator, a2);
        }
        this.G.clear();
        this.k();
    }

    public void e(View object) {
        if (this.D) {
            if (!this.E) {
                androidx.c.a<Animator, a> a2 = m.q();
                int n2 = a2.size();
                object = ad.b((View)object);
                --n2;
                while (n2 >= 0) {
                    a a3 = (a)a2.c(n2);
                    if (a3.a != null && object.equals(a3.d)) {
                        androidx.j.a.b((Animator)a2.b(n2));
                    }
                    --n2;
                }
                if (this.F != null && this.F.size() > 0) {
                    object = (ArrayList)this.F.clone();
                    int n3 = ((ArrayList)object).size();
                    for (n2 = 0; n2 < n3; ++n2) {
                        ((c)((ArrayList)object).get(n2)).c(this);
                    }
                }
            }
            this.D = false;
        }
    }

    public List<Integer> f() {
        return this.b;
    }

    public List<View> g() {
        return this.c;
    }

    public List<String> h() {
        return this.m;
    }

    public List<Class> i() {
        return this.n;
    }

    protected void j() {
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList)this.F.clone();
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((c)arrayList.get(i2)).d(this);
                }
            }
            this.E = false;
        }
        ++this.C;
    }

    protected void k() {
        --this.C;
        if (this.C == 0) {
            ArrayList arrayList;
            int n2;
            if (this.F != null && this.F.size() > 0) {
                arrayList = (ArrayList)this.F.clone();
                int n3 = arrayList.size();
                for (n2 = 0; n2 < n3; ++n2) {
                    ((c)arrayList.get(n2)).a(this);
                }
            }
            for (n2 = 0; n2 < this.v.c.b(); ++n2) {
                arrayList = this.v.c.c(n2);
                if (arrayList == null) continue;
                androidx.core.h.t.a((View)arrayList, false);
            }
            for (n2 = 0; n2 < this.w.c.b(); ++n2) {
                arrayList = this.w.c.c(n2);
                if (arrayList == null) continue;
                androidx.core.h.t.a((View)arrayList, false);
            }
            this.E = true;
        }
    }

    public g l() {
        return this.J;
    }

    public b m() {
        return this.H;
    }

    public p n() {
        return this.g;
    }

    public m o() {
        try {
            m m2 = (m)super.clone();
            m2.G = new ArrayList<E>();
            m2.v = new t();
            m2.w = new t();
            m2.y = null;
            m2.z = null;
            return m2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public String p() {
        return this.j;
    }

    public String toString() {
        return this.a("");
    }

    private static class a {
        View a;
        String b;
        s c;
        al d;
        m e;

        a(View view, String string2, m m2, al al2, s s2) {
            this.a = view;
            this.b = string2;
            this.c = s2;
            this.d = al2;
            this.e = m2;
        }
    }

    public static abstract class b {
    }

    public static interface c {
        public void a(m var1);

        public void b(m var1);

        public void c(m var1);

        public void d(m var1);
    }

}

