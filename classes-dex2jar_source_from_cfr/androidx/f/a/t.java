/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.f.a;

import android.view.View;
import android.view.ViewTreeObserver;

class t
implements View.OnAttachStateChangeListener,
ViewTreeObserver.OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private t(View view, Runnable runnable) {
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static t a(View view, Runnable object) {
        object = new t(view, (Runnable)object);
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)object);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)object);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        ViewTreeObserver viewTreeObserver = this.b.isAlive() ? this.b : this.a.getViewTreeObserver();
        viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        this.a.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public boolean onPreDraw() {
        this.a();
        this.c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        this.a();
    }
}

