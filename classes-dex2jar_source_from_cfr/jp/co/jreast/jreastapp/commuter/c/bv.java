/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.bu;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.trainlocation.j;

public class bv
extends bu
implements b.a {
    private static final ViewDataBinding.b e;
    private static final SparseIntArray f;
    private final ConstraintLayout g;
    private final View.OnClickListener h;
    private long i = -1L;

    static {
        f = new SparseIntArray();
        f.put(2131230803, 1);
    }

    public bv(e e2, View view) {
        this(e2, view, bv.a(e2, view, 2, e, f));
    }

    private bv(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[1]);
        this.g = (ConstraintLayout)((Object)arrobject[0]);
        this.g.setTag(null);
        this.a(view);
        this.h = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.d;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((j)object).f();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.d = j2;
        synchronized (this) {
            this.i |= 1L;
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
            l2 = this.i;
            this.i = 0L;
        }
        j j2 = this.d;
        if ((l2 & 2L) != 0L) {
            this.g.setOnClickListener(this.h);
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

