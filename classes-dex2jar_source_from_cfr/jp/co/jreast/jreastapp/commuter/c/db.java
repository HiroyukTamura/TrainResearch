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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.da;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.n.k;

public class db
extends da {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k;
    private long l = -1L;

    static {
        k = new SparseIntArray();
        k.put(2131230993, 3);
        k.put(2131230798, 4);
    }

    public db(androidx.databinding.e e2, View view) {
        this(e2, view, db.a(e2, view, 5, j, k));
    }

    private db(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[2], (AppCompatImageView)arrobject[4], (TextView)arrobject[1], (ConstraintLayout)((Object)arrobject[0]), (LinearLayout)arrobject[3]);
        this.c.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.a(view);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(RailwayLine railwayLine) {
        this.i = railwayLine;
        synchronized (this) {
            this.l |= 1L;
        }
        this.a(3);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(k k2) {
        this.h = k2;
        synchronized (this) {
            this.l |= 2L;
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
        synchronized (this) {
            l2 = this.l;
            this.l = 0L;
        }
        RailwayLine railwayLine = this.i;
        k k2 = this.h;
        String string2 = null;
        long l3 = 7L & l2 LCMP 0L;
        if (l3 != false) {
            Object object2;
            object2 = (l2 & 5L) != 0L && (object2 = railwayLine != null ? railwayLine.getFrom() : null) != null ? ((BoardingStation)object2).getName() : null;
            object = object2;
            if (k2 != null) {
                string2 = k2.e(railwayLine);
                object = object2;
            }
        } else {
            object = null;
        }
        if (l3 != false) {
            e.a(this.c, string2);
        }
        if ((l2 & 5L) != 0L) {
            e.a(this.e, (CharSequence)object);
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
            this.l = 4L;
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
            return this.l != 0L;
            {
            }
        }
    }
}

