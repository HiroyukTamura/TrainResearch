/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.q;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.e;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class r
extends q
implements b.a {
    private static final ViewDataBinding.b i;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n = -1L;

    static {
        j = new SparseIntArray();
        j.put(2131231104, 3);
        j.put(2131231102, 4);
        j.put(2131231103, 5);
    }

    public r(androidx.databinding.e e2, View view) {
        this(e2, view, r.a(e2, view, 6, i, j));
    }

    private r(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 1, (AppCompatImageView)arrobject[1], (AppCompatButton)arrobject[2], (AppCompatTextView)arrobject[4], (AppCompatImageView)arrobject[5], (AppCompatTextView)arrobject[3]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.k = (ConstraintLayout)((Object)arrobject[0]);
        this.k.setTag(null);
        this.a(view);
        this.l = new b(this, 2);
        this.m = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.n |= 1L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        int n3 = 0;
        int n4 = 0;
        switch (n2) {
            default: {
                return;
            }
            case 2: {
                object = this.h;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((e)object).i();
                return;
            }
            case 1: {
                object = this.h;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((e)object).h();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(e e2) {
        this.h = e2;
        synchronized (this) {
            this.n |= 2L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        if (n2 != 0) {
            return false;
        }
        return this.a((p)object, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void b() {
        long l2;
        synchronized (this) {
            l2 = this.n;
            this.n = 0L;
        }
        p<Boolean> p2 = this.h;
        boolean bl2 = false;
        long l3 = 7L & l2 LCMP 0L;
        if (l3 != false) {
            Boolean bl3 = null;
            p2 = p2 != null ? ((e)((Object)p2)).f() : null;
            this.a(0, p2);
            if (p2 != null) {
                bl3 = (Boolean)p2.a();
            }
            bl2 = ViewDataBinding.a(bl3);
        }
        if ((l2 & 4L) != 0L) {
            this.c.setOnClickListener(this.m);
            this.d.setOnClickListener(this.l);
        }
        if (l3 != false) {
            this.d.setEnabled(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.n = 4L;
        }
        this.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean d() {
        synchronized (this) {
            return this.n != 0L;
            {
            }
        }
    }
}

