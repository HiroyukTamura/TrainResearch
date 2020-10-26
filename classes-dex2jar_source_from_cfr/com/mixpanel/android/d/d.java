/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.Window
 */
package com.mixpanel.android.d;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.mixpanel.android.d.k;
import com.mixpanel.android.d.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class d
extends k<Activity> {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final Map<String, List<o>> b = new HashMap<String, List<o>>();
    private final Set<a> c = new HashSet<a>();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(View view, List<o> list) {
        Set<a> set = this.c;
        synchronized (set) {
            int n2 = list.size();
            int n3 = 0;
            while (n3 < n2) {
                a a2 = new a(view, list.get(n3), this.a);
                this.c.add(a2);
                ++n3;
            }
            return;
        }
    }

    private void b() {
        if (Thread.currentThread() == this.a.getLooper().getThread()) {
            this.c();
            return;
        }
        this.a.post(new Runnable(){

            @Override
            public void run() {
                d.this.c();
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void c() {
        Iterator iterator = this.a().iterator();
        while (iterator.hasNext()) {
            Object object = (Activity)iterator.next();
            Object object2 = object.getClass().getCanonicalName();
            View view = object.getWindow().getDecorView().getRootView();
            object = this.b;
            // MONITORENTER : object
            object2 = this.b.get(object2);
            List<o> list = this.b.get(null);
            // MONITOREXIT : object
            if (object2 != null) {
                this.a(view, (List<o>)object2);
            }
            if (list == null) continue;
            this.a(view, list);
        }
    }

    @Override
    public void a(Activity activity) {
        super.b(activity);
        this.b();
    }

    @Override
    public /* synthetic */ void a(Object object) {
        this.b((Activity)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(Map<String, List<o>> map) {
        Object object = this.c;
        synchronized (object) {
            Iterator<a> iterator = this.c.iterator();
            do {
                if (!iterator.hasNext()) {
                    this.c.clear();
                    // MONITOREXIT [4, 6, 7] lbl7 : MonitorExitStatement: MONITOREXIT : var2_2
                    object = this.b;
                    synchronized (object) {
                        this.b.clear();
                        this.b.putAll(map);
                    }
                    this.b();
                    return;
                }
                iterator.next().a();
            } while (true);
        }
    }

    @Override
    public void b(Activity activity) {
        super.a(activity);
    }

    @Override
    public /* synthetic */ void b(Object object) {
        this.a((Activity)object);
    }

    private static class a
    implements ViewTreeObserver.OnGlobalLayoutListener,
    Runnable {
        private volatile boolean a;
        private boolean b;
        private final WeakReference<View> c;
        private final o d;
        private final Handler e;

        public a(View view, o o2, Handler handler) {
            this.d = o2;
            this.c = new WeakReference<View>(view);
            this.e = handler;
            this.b = true;
            this.a = false;
            view = view.getViewTreeObserver();
            if (view.isAlive()) {
                view.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            }
            this.run();
        }

        private void b() {
            if (this.b) {
                View view = (View)this.c.get();
                if (view != null && (view = view.getViewTreeObserver()).isAlive()) {
                    view.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                }
                this.d.a();
            }
            this.b = false;
        }

        public void a() {
            this.a = true;
            this.e.post((Runnable)this);
        }

        public void onGlobalLayout() {
            this.run();
        }

        @Override
        public void run() {
            if (!this.b) {
                return;
            }
            View view = (View)this.c.get();
            if (view != null && !this.a) {
                this.d.b(view);
                this.e.removeCallbacks((Runnable)this);
                this.e.postDelayed((Runnable)this, 1000L);
                return;
            }
            this.b();
        }
    }

}

