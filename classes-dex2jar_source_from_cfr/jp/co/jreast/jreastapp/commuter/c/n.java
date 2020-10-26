/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.m;
import jp.co.jreast.jreastapp.commuter.others.d;

public class n
extends m {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private final ConstraintLayout h;
    private long i = -1L;

    static {
        g = new SparseIntArray();
        g.put(2131231277, 1);
        g.put(2131231066, 2);
    }

    public n(e e2, View view) {
        this(e2, view, n.a(e2, view, 3, f, g));
    }

    private n(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (RecyclerView)arrobject[2], (Toolbar)((Object)arrobject[1]));
        this.h = (ConstraintLayout)((Object)arrobject[0]);
        this.h.setTag(null);
        this.a(view);
        this.c();
    }

    @Override
    public void a(d d2) {
        this.e = d2;
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
        synchronized (this) {
            long l2 = this.i;
            this.i = 0L;
            return;
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
            this.i = 2L;
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
            return this.i != 0L;
            {
            }
        }
    }
}

