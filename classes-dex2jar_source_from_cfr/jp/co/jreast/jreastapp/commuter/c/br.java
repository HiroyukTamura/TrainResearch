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
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.bq;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.d;

public class br
extends bq
implements b.a {
    private static final ViewDataBinding.b g;
    private static final SparseIntArray h;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private long k = -1L;

    static {
        h = new SparseIntArray();
        h.put(2131231169, 2);
    }

    public br(androidx.databinding.e e2, View view) {
        this(e2, view, br.a(e2, view, 3, g, h));
    }

    private br(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (View)arrobject[2], (TextView)arrobject[1]);
        this.i = (ConstraintLayout)((Object)arrobject[0]);
        this.i.setTag(null);
        this.d.setTag(null);
        this.a(view);
        this.j = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.f;
        d d2 = this.e;
        n2 = d2 != null ? 1 : 0;
        if (n2 != 0) {
            d2.a((RailwayLineInformation)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(RailwayLineInformation railwayLineInformation) {
        this.f = railwayLineInformation;
        synchronized (this) {
            this.k |= 1L;
        }
        this.a(13);
        super.f();
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
            this.k |= 2L;
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
            l2 = this.k;
            this.k = 0L;
        }
        Object var5_2 = null;
        RailwayLineInformation railwayLineInformation = this.f;
        Object object = this.e;
        long l3 = 5L & l2 LCMP 0L;
        object = var5_2;
        if (l3 != false) {
            object = var5_2;
            if (railwayLineInformation != null) {
                object = railwayLineInformation.displayLineSectionName();
            }
        }
        if ((l2 & 4L) != 0L) {
            this.i.setOnClickListener(this.j);
        }
        if (l3 != false) {
            e.a(this.d, (CharSequence)object);
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
            this.k = 4L;
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
            return this.k != 0L;
            {
            }
        }
    }
}

