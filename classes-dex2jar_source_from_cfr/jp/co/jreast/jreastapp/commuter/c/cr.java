/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.cq;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.n.k;

public class cr
extends cq {
    private static final ViewDataBinding.b r;
    private static final SparseIntArray s;
    private long t = -1L;

    static {
        s = new SparseIntArray();
        s.put(2131231171, 6);
        s.put(2131230781, 7);
        s.put(2131230958, 8);
        s.put(2131231026, 9);
        s.put(2131231037, 10);
        s.put(2131231305, 11);
        s.put(2131230800, 12);
    }

    public cr(androidx.databinding.e e2, View view) {
        this(e2, view, cr.a(e2, view, 13, r, s));
    }

    private cr(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[1], (LinearLayout)arrobject[7], (TextView)arrobject[12], (TextView)arrobject[5], (ConstraintLayout)((Object)arrobject[0]), (TextView)arrobject[2], (TextView)arrobject[8], (TextView)arrobject[3], (TextView)arrobject[9], (TextView)arrobject[10], (TextView)arrobject[4], (View)arrobject[6], (TextView)arrobject[11]);
        this.c.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        this.m.setTag(null);
        this.a(view);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(Route route) {
        this.q = route;
        synchronized (this) {
            this.t |= 1L;
        }
        this.a(8);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(k k2) {
        this.p = k2;
        synchronized (this) {
            this.t |= 2L;
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
        Object object;
        long l2;
        Object object2;
        Object object3;
        Object object4;
        synchronized (this) {
            l2 = this.t;
            this.t = 0L;
        }
        Object object5 = this.q;
        int n2 = 0;
        k k2 = this.p;
        Object var10_5 = null;
        long l3 = 5L & l2 LCMP 0L;
        if (l3 != false) {
            if (object5 != null) {
                object = ((Route)object5).getAccuracy();
                object4 = ((Route)object5).getLines();
                object5 = ((Route)object5).getTransferCount();
            } else {
                object4 = object5 = (object3 = null);
                object = object5;
                object5 = object3;
            }
            if (object != null) {
                object2 = ((Accuracy)object).getHour();
                object3 = ((Accuracy)object).getMin();
                object = object2;
            } else {
                object = object3 = null;
            }
            if (object4 != null) {
                n2 = object4.size();
            }
            object4 = object4 != null ? (RailwayLine)object4.get(n2 - 1) : null;
            if ((object4 = object4 != null ? ((RailwayLine)object4).getTo() : null) != null) {
                object2 = ((BoardingStation)object4).getName();
                object4 = object5;
                object5 = object2;
                object2 = object;
            } else {
                object2 = null;
                object4 = object5;
                object5 = object2;
                object2 = object;
            }
        } else {
            object2 = object = (object5 = (object4 = null));
            object3 = object;
        }
        n2 = l2 & 6L LCMP 0L;
        object = var10_5;
        if (n2 != 0) {
            object = var10_5;
            if (k2 != null) {
                object = k2.r();
            }
        }
        if (l3 != false) {
            e.a(this.c, (CharSequence)object5);
            e.a(this.h, (CharSequence)object2);
            e.a(this.j, (CharSequence)object3);
            e.a(this.m, (CharSequence)object4);
        }
        if (n2 != 0) {
            e.a(this.f, (CharSequence)object);
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
            this.t = 4L;
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
            return this.t != 0L;
            {
            }
        }
    }
}

