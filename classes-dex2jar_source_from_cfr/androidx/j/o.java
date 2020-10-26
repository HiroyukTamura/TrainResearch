/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.h.t;
import androidx.j.b;
import androidx.j.l;
import androidx.j.m;
import androidx.j.n;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class o {
    static ArrayList<ViewGroup> a;
    private static m b;
    private static ThreadLocal<WeakReference<androidx.c.a<ViewGroup, ArrayList<m>>>> c;

    static {
        b = new b();
        c = new ThreadLocal();
        a = new ArrayList();
    }

    static androidx.c.a<ViewGroup, ArrayList<m>> a() {
        Object object = c.get();
        if (object != null && (object = (androidx.c.a)((Reference)object).get()) != null) {
            return object;
        }
        object = new androidx.c.a<ViewGroup, ArrayList<m>>();
        WeakReference<androidx.c.a<ViewGroup, ArrayList<m>>> weakReference = new WeakReference<androidx.c.a<ViewGroup, ArrayList<m>>>((androidx.c.a<ViewGroup, ArrayList<m>>)object);
        c.set(weakReference);
        return object;
    }

    public static void a(ViewGroup viewGroup, m m2) {
        if (!a.contains((Object)viewGroup) && t.y((View)viewGroup)) {
            a.add(viewGroup);
            m m3 = m2;
            if (m2 == null) {
                m3 = b;
            }
            m2 = m3.o();
            o.c(viewGroup, m2);
            l.a((View)viewGroup, null);
            o.b(viewGroup, m2);
        }
    }

    private static void b(ViewGroup viewGroup, m object) {
        if (object != null && viewGroup != null) {
            object = new a((m)object, viewGroup);
            viewGroup.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)object);
            viewGroup.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)object);
        }
    }

    private static void c(ViewGroup object, m m2) {
        Object object2 = (ArrayList)o.a().get(object);
        if (object2 != null && ((ArrayList)object2).size() > 0) {
            object2 = ((ArrayList)object2).iterator();
            while (object2.hasNext()) {
                ((m)object2.next()).d((View)object);
            }
        }
        if (m2 != null) {
            m2.a((ViewGroup)object, true);
        }
        if ((object = l.a((View)object)) != null) {
            ((l)object).a();
        }
    }

    private static class a
    implements View.OnAttachStateChangeListener,
    ViewTreeObserver.OnPreDrawListener {
        m a;
        ViewGroup b;

        a(m m2, ViewGroup viewGroup) {
            this.a = m2;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
            this.b.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }

        public boolean onPreDraw() {
            Object object;
            this.a();
            if (!o.a.remove((Object)this.b)) {
                return true;
            }
            final androidx.c.a<ViewGroup, ArrayList<m>> a2 = o.a();
            ArrayList<m> arrayList = (ArrayList<m>)a2.get((Object)this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                object = new ArrayList<m>();
                a2.put(this.b, (ArrayList<m>)object);
            } else {
                object = arrayList;
                if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                    object = arrayList;
                }
            }
            ((ArrayList)object).add(this.a);
            this.a.a(new n(){

                @Override
                public void a(m m2) {
                    ((ArrayList)a2.get((Object)a.this.b)).remove(m2);
                }
            });
            this.a.a(this.b, false);
            if (arrayList2 != null) {
                object = arrayList2.iterator();
                while (object.hasNext()) {
                    ((m)object.next()).e((View)this.b);
                }
            }
            this.a.a(this.b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View object) {
            this.a();
            o.a.remove((Object)this.b);
            object = (ArrayList)o.a().get((Object)this.b);
            if (object != null && ((ArrayList)object).size() > 0) {
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    ((m)object.next()).e((View)this.b);
                }
            }
            this.a.a(true);
        }

    }

}

