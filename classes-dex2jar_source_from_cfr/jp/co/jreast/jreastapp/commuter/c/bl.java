/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.bk;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class bl
extends bk
implements b.a {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private final ConstraintLayout h;
    private final View.OnClickListener i;
    private long j = -1L;

    static {
        g = new SparseIntArray();
        g.put(2131231301, 2);
    }

    public bl(e e2, View view) {
        this(e2, view, bl.a(e2, view, 3, f, g));
    }

    private bl(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (Button)arrobject[1], (RecyclerView)arrobject[2]);
        this.h = (ConstraintLayout)((Object)arrobject[0]);
        this.h.setTag(null);
        this.c.setTag(null);
        this.a(view);
        this.i = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.e;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((d)object).i();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(d d2) {
        this.e = d2;
        synchronized (this) {
            this.j |= 1L;
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
            l2 = this.j;
            this.j = 0L;
        }
        d d2 = this.e;
        if ((l2 & 2L) != 0L) {
            this.c.setOnClickListener(this.i);
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
            this.j = 2L;
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
            return this.j != 0L;
            {
            }
        }
    }
}

