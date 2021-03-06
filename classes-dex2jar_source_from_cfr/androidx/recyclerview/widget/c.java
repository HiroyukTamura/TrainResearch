/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.h.t;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class c
extends m {
    private static TimeInterpolator i;
    ArrayList<ArrayList<RecyclerView.x>> a = new ArrayList();
    ArrayList<ArrayList<b>> b = new ArrayList();
    ArrayList<ArrayList<a>> c = new ArrayList();
    ArrayList<RecyclerView.x> d = new ArrayList();
    ArrayList<RecyclerView.x> e = new ArrayList();
    ArrayList<RecyclerView.x> f = new ArrayList();
    ArrayList<RecyclerView.x> g = new ArrayList();
    private ArrayList<RecyclerView.x> j = new ArrayList();
    private ArrayList<RecyclerView.x> k = new ArrayList();
    private ArrayList<b> l = new ArrayList();
    private ArrayList<a> m = new ArrayList();

    private void a(List<a> list, RecyclerView.x x2) {
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            a a2 = list.get(i2);
            if (!this.a(a2, x2) || a2.a != null || a2.b != null) continue;
            list.remove(a2);
        }
    }

    private boolean a(a a2, RecyclerView.x x2) {
        block4 : {
            boolean bl2;
            block3 : {
                block2 : {
                    RecyclerView.x x3 = a2.b;
                    bl2 = false;
                    if (x3 != x2) break block2;
                    a2.b = null;
                    break block3;
                }
                if (a2.a != x2) break block4;
                a2.a = null;
                bl2 = true;
            }
            x2.a.setAlpha(1.0f);
            x2.a.setTranslationX(0.0f);
            x2.a.setTranslationY(0.0f);
            this.a(x2, bl2);
            return true;
        }
        return false;
    }

    private void b(a a2) {
        if (a2.a != null) {
            this.a(a2, a2.a);
        }
        if (a2.b != null) {
            this.a(a2, a2.b);
        }
    }

    private void u(final RecyclerView.x x2) {
        final View view = x2.a;
        final ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.f.add(x2);
        viewPropertyAnimator.setDuration(this.g()).alpha(0.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                c.this.i(x2);
                c.this.f.remove(x2);
                c.this.c();
            }

            public void onAnimationStart(Animator animator) {
                c.this.l(x2);
            }
        }).start();
    }

    private void v(RecyclerView.x x2) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        x2.a.animate().setInterpolator(i);
        this.d(x2);
    }

    @Override
    public void a() {
        Runnable runnable;
        boolean bl2 = this.j.isEmpty() ^ true;
        boolean bl3 = this.l.isEmpty() ^ true;
        boolean bl4 = this.m.isEmpty() ^ true;
        boolean bl5 = this.k.isEmpty() ^ true;
        if (!(bl2 || bl3 || bl5 || bl4)) {
            return;
        }
        final ArrayList<b> arrayList = this.j.iterator();
        while (arrayList.hasNext()) {
            this.u(arrayList.next());
        }
        this.j.clear();
        if (bl3) {
            arrayList = new ArrayList();
            arrayList.addAll(this.l);
            this.b.add(arrayList);
            this.l.clear();
            runnable = new Runnable(){

                @Override
                public void run() {
                    for (b b2 : arrayList) {
                        c.this.b(b2.a, b2.b, b2.c, b2.d, b2.e);
                    }
                    arrayList.clear();
                    c.this.b.remove(arrayList);
                }
            };
            if (bl2) {
                t.a(((b)arrayList.get((int)0)).a.a, runnable, this.g());
            } else {
                runnable.run();
            }
        }
        if (bl4) {
            arrayList = new ArrayList<b>();
            arrayList.addAll(this.m);
            this.c.add(arrayList);
            this.m.clear();
            runnable = new Runnable(){

                @Override
                public void run() {
                    for (a a2 : arrayList) {
                        c.this.a(a2);
                    }
                    arrayList.clear();
                    c.this.c.remove(arrayList);
                }
            };
            if (bl2) {
                t.a(((a)arrayList.get((int)0)).a.a, runnable, this.g());
            } else {
                runnable.run();
            }
        }
        if (bl5) {
            arrayList = new ArrayList();
            arrayList.addAll(this.k);
            this.a.add(arrayList);
            this.k.clear();
            runnable = new Runnable(){

                @Override
                public void run() {
                    for (RecyclerView.x x2 : arrayList) {
                        c.this.c(x2);
                    }
                    arrayList.clear();
                    c.this.a.remove(arrayList);
                }
            };
            if (!(bl2 || bl3 || bl4)) {
                runnable.run();
                return;
            }
            long l2 = 0L;
            long l3 = bl2 ? this.g() : 0L;
            long l4 = bl3 ? this.e() : 0L;
            if (bl4) {
                l2 = this.h();
            }
            l4 = Math.max(l4, l2);
            t.a(((RecyclerView.x)arrayList.get((int)0)).a, runnable, l3 + l4);
        }
    }

    void a(final a a2) {
        RecyclerView.x x2 = a2.a;
        View view = null;
        x2 = x2 == null ? null : x2.a;
        RecyclerView.x x3 = a2.b;
        if (x3 != null) {
            view = x3.a;
        }
        if (x2 != null) {
            x3 = x2.animate().setDuration(this.h());
            this.g.add(a2.a);
            x3.translationX((float)(a2.e - a2.c));
            x3.translationY((float)(a2.f - a2.d));
            x3.alpha(0.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter((ViewPropertyAnimator)x3, (View)x2){
                final /* synthetic */ ViewPropertyAnimator b;
                final /* synthetic */ View c;
                {
                    this.b = viewPropertyAnimator;
                    this.c = view;
                }

                public void onAnimationEnd(Animator animator) {
                    this.b.setListener(null);
                    this.c.setAlpha(1.0f);
                    this.c.setTranslationX(0.0f);
                    this.c.setTranslationY(0.0f);
                    c.this.a(a2.a, true);
                    c.this.g.remove(a2.a);
                    c.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    c.this.b(a2.a, true);
                }
            }).start();
        }
        if (view != null) {
            x2 = view.animate();
            this.g.add(a2.b);
            x2.translationX(0.0f).translationY(0.0f).setDuration(this.h()).alpha(1.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter((ViewPropertyAnimator)x2, view){
                final /* synthetic */ ViewPropertyAnimator b;
                final /* synthetic */ View c;
                {
                    this.b = viewPropertyAnimator;
                    this.c = view;
                }

                public void onAnimationEnd(Animator animator) {
                    this.b.setListener(null);
                    this.c.setAlpha(1.0f);
                    this.c.setTranslationX(0.0f);
                    this.c.setTranslationY(0.0f);
                    c.this.a(a2.b, false);
                    c.this.g.remove(a2.b);
                    c.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    c.this.b(a2.b, false);
                }
            }).start();
        }
    }

    void a(List<RecyclerView.x> list) {
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            list.get((int)i2).a.animate().cancel();
        }
    }

    @Override
    public boolean a(RecyclerView.x x2) {
        this.v(x2);
        this.j.add(x2);
        return true;
    }

    @Override
    public boolean a(RecyclerView.x x2, int n2, int n3, int n4, int n5) {
        View view = x2.a;
        this.v(x2);
        int n6 = n4 - (n2 += (int)x2.a.getTranslationX());
        int n7 = n5 - (n3 += (int)x2.a.getTranslationY());
        if (n6 == 0 && n7 == 0) {
            this.j(x2);
            return false;
        }
        if (n6 != 0) {
            view.setTranslationX((float)(-n6));
        }
        if (n7 != 0) {
            view.setTranslationY((float)(-n7));
        }
        this.l.add(new b(x2, n2, n3, n4, n5));
        return true;
    }

    @Override
    public boolean a(RecyclerView.x x2, RecyclerView.x x3, int n2, int n3, int n4, int n5) {
        if (x2 == x3) {
            return this.a(x2, n2, n3, n4, n5);
        }
        float f2 = x2.a.getTranslationX();
        float f3 = x2.a.getTranslationY();
        float f4 = x2.a.getAlpha();
        this.v(x2);
        int n6 = (int)((float)(n4 - n2) - f2);
        int n7 = (int)((float)(n5 - n3) - f3);
        x2.a.setTranslationX(f2);
        x2.a.setTranslationY(f3);
        x2.a.setAlpha(f4);
        if (x3 != null) {
            this.v(x3);
            x3.a.setTranslationX((float)(-n6));
            x3.a.setTranslationY((float)(-n7));
            x3.a.setAlpha(0.0f);
        }
        this.m.add(new a(x2, x3, n2, n3, n4, n5));
        return true;
    }

    @Override
    public boolean a(RecyclerView.x x2, List<Object> list) {
        return !list.isEmpty() || super.a(x2, list);
        {
        }
    }

    void b(final RecyclerView.x x2, final int n2, final int n3, int n4, int n5) {
        final View view = x2.a;
        n2 = n4 - n2;
        n3 = n5 - n3;
        if (n2 != 0) {
            view.animate().translationX(0.0f);
        }
        if (n3 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.e.add(x2);
        viewPropertyAnimator.setDuration(this.e()).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationCancel(Animator animator) {
                if (n2 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (n3 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimator.setListener(null);
                c.this.j(x2);
                c.this.e.remove(x2);
                c.this.c();
            }

            public void onAnimationStart(Animator animator) {
                c.this.m(x2);
            }
        }).start();
    }

    @Override
    public boolean b() {
        return !this.k.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.j.isEmpty() || !this.e.isEmpty() || !this.f.isEmpty() || !this.d.isEmpty() || !this.g.isEmpty() || !this.b.isEmpty() || !this.a.isEmpty() || !this.c.isEmpty();
        {
        }
    }

    @Override
    public boolean b(RecyclerView.x x2) {
        this.v(x2);
        x2.a.setAlpha(0.0f);
        this.k.add(x2);
        return true;
    }

    void c() {
        if (!this.b()) {
            this.i();
        }
    }

    void c(final RecyclerView.x x2) {
        final View view = x2.a;
        final ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.d.add(x2);
        viewPropertyAnimator.alpha(1.0f).setDuration(this.f()).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimator.setListener(null);
                c.this.k(x2);
                c.this.d.remove(x2);
                c.this.c();
            }

            public void onAnimationStart(Animator animator) {
                c.this.n(x2);
            }
        }).start();
    }

    @Override
    public void d() {
        ArrayList<Object> arrayList;
        Object object;
        int n2;
        int n3;
        for (n2 = this.l.size() - 1; n2 >= 0; --n2) {
            arrayList = this.l.get(n2);
            object = arrayList.a.a;
            object.setTranslationY(0.0f);
            object.setTranslationX(0.0f);
            this.j(((b)arrayList).a);
            this.l.remove(n2);
        }
        for (n2 = this.j.size() - 1; n2 >= 0; --n2) {
            this.i(this.j.get(n2));
            this.j.remove(n2);
        }
        for (n2 = this.k.size() - 1; n2 >= 0; --n2) {
            arrayList = this.k.get(n2);
            ((RecyclerView.x)arrayList).a.setAlpha(1.0f);
            this.k((RecyclerView.x)((Object)arrayList));
            this.k.remove(n2);
        }
        for (n2 = this.m.size() - 1; n2 >= 0; --n2) {
            this.b(this.m.get(n2));
        }
        this.m.clear();
        if (!this.b()) {
            return;
        }
        for (n2 = this.b.size() - 1; n2 >= 0; --n2) {
            arrayList = this.b.get(n2);
            for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                object = arrayList.get(n3);
                View view = object.a.a;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                this.j(object.a);
                arrayList.remove(n3);
                if (!arrayList.isEmpty()) continue;
                this.b.remove(arrayList);
            }
        }
        for (n2 = this.a.size() - 1; n2 >= 0; --n2) {
            arrayList = this.a.get(n2);
            for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                object = (RecyclerView.x)arrayList.get(n3);
                object.a.setAlpha(1.0f);
                this.k((RecyclerView.x)object);
                arrayList.remove(n3);
                if (!arrayList.isEmpty()) continue;
                this.a.remove(arrayList);
            }
        }
        for (n2 = this.c.size() - 1; n2 >= 0; --n2) {
            arrayList = this.c.get(n2);
            for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                this.b((a)arrayList.get(n3));
                if (!arrayList.isEmpty()) continue;
                this.c.remove(arrayList);
            }
        }
        this.a(this.f);
        this.a(this.e);
        this.a(this.d);
        this.a(this.g);
        this.i();
    }

    @Override
    public void d(RecyclerView.x x2) {
        ArrayList<Object> arrayList;
        int n2;
        View view = x2.a;
        view.animate().cancel();
        for (n2 = this.l.size() - 1; n2 >= 0; --n2) {
            if (this.l.get((int)n2).a != x2) continue;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            this.j(x2);
            this.l.remove(n2);
        }
        this.a(this.m, x2);
        if (this.j.remove(x2)) {
            view.setAlpha(1.0f);
            this.i(x2);
        }
        if (this.k.remove(x2)) {
            view.setAlpha(1.0f);
            this.k(x2);
        }
        for (n2 = this.c.size() - 1; n2 >= 0; --n2) {
            arrayList = this.c.get(n2);
            this.a(arrayList, x2);
            if (!arrayList.isEmpty()) continue;
            this.c.remove(n2);
        }
        block2 : for (n2 = this.b.size() - 1; n2 >= 0; --n2) {
            arrayList = this.b.get(n2);
            for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                if (((b)arrayList.get((int)i2)).a != x2) continue;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                this.j(x2);
                arrayList.remove(i2);
                if (!arrayList.isEmpty()) continue block2;
                this.b.remove(n2);
                continue block2;
            }
        }
        for (n2 = this.a.size() - 1; n2 >= 0; --n2) {
            arrayList = this.a.get(n2);
            if (!arrayList.remove(x2)) continue;
            view.setAlpha(1.0f);
            this.k(x2);
            if (!arrayList.isEmpty()) continue;
            this.a.remove(n2);
        }
        this.f.remove(x2);
        this.d.remove(x2);
        this.g.remove(x2);
        this.e.remove(x2);
        this.c();
    }

    private static class a {
        public RecyclerView.x a;
        public RecyclerView.x b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.x x2, RecyclerView.x x3) {
            this.a = x2;
            this.b = x3;
        }

        a(RecyclerView.x x2, RecyclerView.x x3, int n2, int n3, int n4, int n5) {
            this(x2, x3);
            this.c = n2;
            this.d = n3;
            this.e = n4;
            this.f = n5;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ChangeInfo{oldHolder=");
            stringBuilder.append(this.a);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.b);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.c);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.d);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.e);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class b {
        public RecyclerView.x a;
        public int b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.x x2, int n2, int n3, int n4, int n5) {
            this.a = x2;
            this.b = n2;
            this.c = n3;
            this.d = n4;
            this.e = n5;
        }
    }

}

