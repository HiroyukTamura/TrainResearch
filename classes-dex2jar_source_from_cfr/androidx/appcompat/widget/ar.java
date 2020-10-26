/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnHoverListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewConfiguration
 *  android.view.accessibility.AccessibilityManager
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.as;
import androidx.core.h.t;
import androidx.core.h.u;

class ar
implements View.OnAttachStateChangeListener,
View.OnHoverListener,
View.OnLongClickListener {
    private static ar j;
    private static ar k;
    private final View a;
    private final CharSequence b;
    private final int c;
    private final Runnable d = new Runnable(){

        @Override
        public void run() {
            ar.this.a(false);
        }
    };
    private final Runnable e = new Runnable(){

        @Override
        public void run() {
            ar.this.a();
        }
    };
    private int f;
    private int g;
    private as h;
    private boolean i;

    private ar(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.c = u.a(ViewConfiguration.get((Context)this.a.getContext()));
        this.d();
        this.a.setOnLongClickListener((View.OnLongClickListener)this);
        this.a.setOnHoverListener((View.OnHoverListener)this);
    }

    public static void a(View view, CharSequence charSequence) {
        if (j != null && ar.j.a == view) {
            ar.a(null);
        }
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            if (k != null && ar.k.a == view) {
                k.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new ar(view, charSequence);
    }

    private static void a(ar ar2) {
        if (j != null) {
            j.c();
        }
        if ((j = ar2) != null) {
            j.b();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int n2 = (int)motionEvent.getX();
        int n3 = (int)motionEvent.getY();
        if (Math.abs(n2 - this.f) <= this.c && Math.abs(n3 - this.g) <= this.c) {
            return false;
        }
        this.f = n2;
        this.g = n3;
        return true;
    }

    private void b() {
        this.a.postDelayed(this.d, (long)ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.a.removeCallbacks(this.d);
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }

    void a() {
        if (k == this) {
            k = null;
            if (this.h != null) {
                this.h.a();
                this.h = null;
                this.d();
                this.a.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            } else {
                Log.e((String)"TooltipCompatHandler", (String)"sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            ar.a(null);
        }
        this.a.removeCallbacks(this.e);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(boolean bl2) {
        long l2;
        if (!t.B(this.a)) {
            return;
        }
        ar.a(null);
        if (k != null) {
            k.a();
        }
        k = this;
        this.i = bl2;
        this.h = new as(this.a.getContext());
        this.h.a(this.a, this.f, this.g, this.i, this.b);
        this.a.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        if (this.i) {
            l2 = 2500L;
        } else {
            l2 = (t.p(this.a) & 1) == 1 ? 3000L : 15000L;
            l2 -= (long)ViewConfiguration.getLongPressTimeout();
        }
        this.a.removeCallbacks(this.e);
        this.a.postDelayed(this.e, l2);
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        view = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
        if (view.isEnabled() && view.isTouchExplorationEnabled()) {
            return false;
        }
        int n2 = motionEvent.getAction();
        if (n2 != 7) {
            if (n2 != 10) {
                return false;
            }
            this.d();
            this.a();
            return false;
        }
        if (this.a.isEnabled() && this.h == null && this.a(motionEvent)) {
            ar.a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        this.a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.a();
    }

}

