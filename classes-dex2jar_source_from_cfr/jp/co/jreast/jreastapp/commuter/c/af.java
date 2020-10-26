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
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.ae;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;

public class af
extends ae
implements b.a {
    private static final ViewDataBinding.b w;
    private static final SparseIntArray x;
    private long A = -1L;
    private final ConstraintLayout y;
    private final View.OnClickListener z;

    static {
        x = new SparseIntArray();
        x.put(2131231219, 5);
        x.put(2131231091, 6);
        x.put(2131231001, 7);
        x.put(2131230999, 8);
        x.put(2131230994, 9);
        x.put(2131230995, 10);
        x.put(2131230971, 11);
        x.put(2131230847, 12);
        x.put(2131230858, 13);
        x.put(2131230848, 14);
        x.put(2131231004, 15);
        x.put(2131230993, 16);
        x.put(2131231324, 17);
        x.put(2131231323, 18);
    }

    public af(androidx.databinding.e e2, View view) {
        this(e2, view, af.a(e2, view, 19, w, x));
    }

    private af(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (ConstraintLayout)((Object)arrobject[1]), (LinearLayout)arrobject[12], (ConstraintLayout)((Object)arrobject[14]), (TextView)arrobject[3], (TextView)arrobject[4], (TextView)arrobject[2], (AppCompatImageView)arrobject[13], (ConstraintLayout)((Object)arrobject[11]), (View)arrobject[16], (View)arrobject[9], (View)arrobject[10], (View)arrobject[8], (View)arrobject[7], (AppCompatImageView)arrobject[15], (ConstraintLayout)((Object)arrobject[6]), (TextView)arrobject[5], (LinearLayout)arrobject[18], (LinearLayout)arrobject[17]);
        this.c.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.y = (ConstraintLayout)((Object)arrobject[0]);
        this.y.setTag(null);
        this.a(view);
        this.z = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.v;
        g g2 = this.u;
        n2 = g2 != null ? 1 : 0;
        if (n2 != 0) {
            g2.c((RailwayLine)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(g g2) {
        this.u = g2;
        synchronized (this) {
            this.A |= 2L;
        }
        this.a(11);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(RailwayLine railwayLine) {
        this.v = railwayLine;
        synchronized (this) {
            this.A |= 1L;
        }
        this.a(3);
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
        Object object2;
        long l2;
        synchronized (this) {
            l2 = this.A;
            this.A = 0L;
        }
        RailwayLine railwayLine = this.v;
        g g2 = this.u;
        String string2 = null;
        long l3 = 7L & l2 LCMP 0L;
        if (l3 != false) {
            Object object3;
            Object object4;
            if ((l2 & 5L) != 0L && (object4 = railwayLine != null ? railwayLine.getServiceStatus() : null) != null) {
                object3 = ((ServiceStatus)object4).getDelayReason();
                object4 = ((ServiceStatus)object4).getDelayStatus();
            } else {
                object3 = object4 = null;
            }
            object = object4;
            object2 = object3;
            if (g2 != null) {
                string2 = g2.d(railwayLine);
                object = object4;
                object2 = object3;
            }
        } else {
            object2 = object = null;
        }
        if ((4L & l2) != 0L) {
            this.c.setOnClickListener(this.z);
        }
        if (l3 != false) {
            e.a(this.f, string2);
        }
        if ((l2 & 5L) != 0L) {
            e.a(this.g, (CharSequence)object2);
            e.a(this.h, (CharSequence)object);
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
            this.A = 4L;
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
            return this.A != 0L;
            {
            }
        }
    }
}

