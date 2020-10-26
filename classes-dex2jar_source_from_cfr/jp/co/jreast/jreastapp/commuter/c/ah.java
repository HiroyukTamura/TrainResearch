/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.ag;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class ah
extends ag
implements b.a {
    private static final ViewDataBinding.b k;
    private static final SparseIntArray l;
    private final FrameLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p = -1L;

    static {
        l = new SparseIntArray();
        l.put(2131231318, 3);
        l.put(2131231317, 4);
        l.put(2131231243, 5);
        l.put(2131231004, 6);
    }

    public ah(e e2, View view) {
        this(e2, view, ah.a(e2, view, 7, k, l));
    }

    private ah(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[6], (TextView)arrobject[5], (FrameLayout)arrobject[4], (LinearLayout)arrobject[3], (AppCompatImageView)arrobject[1], (AppCompatImageView)arrobject[2]);
        this.m = (FrameLayout)arrobject[0];
        this.m.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.a(view);
        this.n = new b(this, 2);
        this.o = new b(this, 1);
        this.c();
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
                object = this.j;
                f f2 = this.i;
                n2 = n4;
                if (f2 != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                f2.c((Integer)object);
                return;
            }
            case 1: {
                object = this.j;
                f f3 = this.i;
                n2 = n3;
                if (f3 != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                f3.b((Integer)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(f f2) {
        this.i = f2;
        synchronized (this) {
            this.p |= 2L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        return false;
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
            l2 = this.p;
            this.p = 0L;
        }
        Object object = this.j;
        object = this.i;
        if ((l2 & 4L) != 0L) {
            this.g.setOnClickListener(this.o);
            this.h.setOnClickListener(this.n);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(Integer n2) {
        this.j = n2;
        synchronized (this) {
            this.p |= 1L;
        }
        this.a(14);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.p = 4L;
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
            return this.p != 0L;
            {
            }
        }
    }
}

