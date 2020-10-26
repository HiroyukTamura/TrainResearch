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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.aq;
import jp.co.jreast.jreastapp.commuter.trainlocation.p;

public class ar
extends aq {
    private static final ViewDataBinding.b e;
    private static final SparseIntArray f;
    private final ConstraintLayout g;
    private long h = -1L;

    static {
        f = new SparseIntArray();
        f.put(2131231094, 1);
    }

    public ar(e e2, View view) {
        this(e2, view, ar.a(e2, view, 2, e, f));
    }

    private ar(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (RecyclerView)arrobject[1]);
        this.g = (ConstraintLayout)((Object)arrobject[0]);
        this.g.setTag(null);
        this.a(view);
        this.c();
    }

    @Override
    public void a(p p2) {
        this.d = p2;
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
            long l2 = this.h;
            this.h = 0L;
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
            this.h = 2L;
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
            return this.h != 0L;
            {
            }
        }
    }
}

