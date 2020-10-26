/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.ao;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.trainlocation.j;

public class ap
extends ao
implements b.a {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private long n = -1L;

    static {
        k = new SparseIntArray();
        k.put(2131231142, 3);
        k.put(2131231135, 4);
        k.put(2131231216, 5);
        k.put(2131231215, 6);
    }

    public ap(e e2, View view) {
        this(e2, view, ap.a(e2, view, 7, j, k));
    }

    private ap(e e2, View view, Object[] arrobject) {
        super(e2, view, 1, (TextView)arrobject[2], (AppCompatImageView)arrobject[3], (LinearLayout)arrobject[1], (TextView)arrobject[4], (RecyclerView)arrobject[6], (TextView)arrobject[5]);
        this.c.setTag(null);
        this.l = (ConstraintLayout)((Object)arrobject[0]);
        this.l.setTag(null);
        this.e.setTag(null);
        this.a(view);
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
        object = this.i;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((j)object).e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.i = j2;
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
        p<Boolean> p2 = this.i;
        int n2 = 0;
        long l3 = l2 & 7L LCMP 0L;
        long l4 = l2;
        int n3 = n2;
        if (l3 != false) {
            Boolean bl2 = null;
            p2 = p2 != null ? ((j)((Object)p2)).d() : null;
            this.a(0, p2);
            if (p2 != null) {
                bl2 = (Boolean)p2.a();
            }
            boolean bl3 = ViewDataBinding.a(bl2);
            long l5 = l2;
            if (l3 != false) {
                l5 = bl3 ? 16L : 8L;
                l5 = l2 | l5;
            }
            l4 = l5;
            n3 = n2;
            if (bl3) {
                n3 = 8;
                l4 = l5;
            }
        }
        if ((l4 & 7L) != 0L) {
            this.c.setVisibility(n3);
        }
        if ((l4 & 4L) != 0L) {
            this.e.setOnClickListener(this.m);
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

