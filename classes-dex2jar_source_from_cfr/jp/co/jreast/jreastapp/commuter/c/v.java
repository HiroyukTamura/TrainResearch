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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.u;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;

public class v
extends u
implements b.a {
    private static final ViewDataBinding.b t;
    private static final SparseIntArray u;
    private final ConstraintLayout v;
    private final View.OnClickListener w;
    private long x = -1L;

    static {
        u = new SparseIntArray();
        u.put(2131231007, 12);
        u.put(2131231003, 13);
        u.put(2131231177, 14);
        u.put(2131231308, 15);
        u.put(2131231016, 16);
    }

    public v(androidx.databinding.e e2, View view) {
        this(e2, view, v.a(e2, view, 17, t, u));
    }

    private v(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[2], (TextView)arrobject[6], (TextView)arrobject[5], (TextView)arrobject[8], (TextView)arrobject[7], (TextView)arrobject[10], (TextView)arrobject[9], (AppCompatImageView)arrobject[13], (ConstraintLayout)((Object)arrobject[12]), (TextView)arrobject[1], (View)arrobject[16], (TextView)arrobject[3], (TextView)arrobject[11], (TextView)arrobject[4], (AppCompatImageView)arrobject[14], (View)arrobject[15]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.l.setTag(null);
        this.v = (ConstraintLayout)((Object)arrobject[0]);
        this.v.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.a(view);
        this.w = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.s;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((jp.co.jreast.jreastapp.commuter.servicestatus.b)object).g();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(jp.co.jreast.jreastapp.commuter.servicestatus.b b2) {
        this.s = b2;
        synchronized (this) {
            this.x |= 1L;
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
        Object object2;
        int n2;
        Object object3;
        String string2;
        CharSequence charSequence;
        String string3;
        Object object4;
        String string4;
        String string5;
        long l2;
        int n3;
        long l3;
        synchronized (this) {
            l3 = this.x;
            this.x = 0L;
        }
        Object object5 = this.s;
        boolean bl2 = false;
        int n4 = 0;
        long l4 = l3 & 3L LCMP 0L;
        if (l4 != false) {
            String string6;
            if (object5 != null) {
                charSequence = ((jp.co.jreast.jreastapp.commuter.servicestatus.b)object5).d();
                object5 = ((jp.co.jreast.jreastapp.commuter.servicestatus.b)object5).c();
            } else {
                object5 = null;
                charSequence = null;
            }
            if (object5 != null) {
                object = ((RailwayLine)object5).getServiceStatus();
                object5 = ((RailwayLine)object5).getName();
            } else {
                object5 = null;
                object = null;
            }
            if (object != null) {
                string3 = ((ServiceStatus)object).getDelayDirection();
                string6 = ((ServiceStatus)object).getDelayToStation();
                string5 = ((ServiceStatus)object).getDelayReason();
                object2 = ((ServiceStatus)object).getDelayFromStation();
                string2 = ((ServiceStatus)object).getDelayDetailText();
                object3 = ((ServiceStatus)object).getDelayMinute();
                string4 = ((ServiceStatus)object).getDelayStatus();
                object = string6;
            } else {
                string4 = null;
                string3 = null;
                object = null;
                string5 = null;
                object2 = null;
                string2 = null;
                object3 = null;
            }
            boolean bl3 = string3 != null ? string3.isEmpty() : false;
            long l5 = l3;
            if (l4 != false) {
                l5 = bl3 ? 8L : 4L;
                l5 = l3 | l5;
            }
            bl2 = object != null ? ((String)object).isEmpty() : false;
            l3 = l5;
            if ((l5 & 3L) != 0L) {
                l3 = bl2 ? l5 | 128L : l5 | 64L;
            }
            boolean bl4 = string5 != null ? string5.isEmpty() : false;
            l5 = l3;
            if ((l3 & 3L) != 0L) {
                l5 = bl4 ? 32L : 16L;
                l5 = l3 | l5;
            }
            boolean bl5 = object2 != null ? ((String)object2).isEmpty() : false;
            l3 = l5;
            if ((l5 & 3L) != 0L) {
                l3 = bl5 ? 2048L : 1024L;
                l3 = l5 | l3;
            }
            boolean bl6 = object3 != null ? ((String)object3).isEmpty() : false;
            l5 = l3;
            if ((l3 & 3L) != 0L) {
                l5 = bl6 ? 512L : 256L;
                l5 = l3 | l5;
            }
            l4 = bl3 ? (long)8 : (long)0;
            n3 = bl4 ? 8 : 0;
            n2 = bl5 ? 8 : 0;
            if (bl6) {
                n4 = 8;
            }
            object3 = object5;
            string6 = string4;
            string4 = string3;
            object5 = object2;
            string3 = string2;
            l2 = n2;
            n2 = n4;
            l3 = l5;
            object4 = object;
            object = charSequence;
            string2 = string5;
            n4 = (int)l2;
            object2 = object3;
            string5 = string6;
        } else {
            object5 = null;
            object4 = null;
            object = null;
            n3 = 0;
            n2 = 0;
            string2 = null;
            n4 = 0;
            object2 = null;
            string5 = null;
            string3 = null;
            string4 = null;
            l4 = 0;
        }
        if ((64L & l3) != 0L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object5);
            ((StringBuilder)charSequence).append("\u301c");
            charSequence = ((StringBuilder)charSequence).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)charSequence);
            ((StringBuilder)object3).append((String)object4);
            charSequence = ((StringBuilder)object3).toString();
        } else {
            charSequence = null;
        }
        l2 = 3L & l3 LCMP 0L;
        if (l2 != false) {
            if (!bl2) {
                object5 = charSequence;
            }
        } else {
            object5 = null;
        }
        if ((l3 & 2L) != 0L) {
            this.c.setOnClickListener(this.w);
        }
        if (l2 != false) {
            e.a(this.d, (CharSequence)object);
            this.d.setVisibility(n2);
            this.e.setVisibility(n2);
            e.a(this.f, (CharSequence)string2);
            this.f.setVisibility(n3);
            this.g.setVisibility(n3);
            e.a(this.h, (CharSequence)object5);
            this.h.setVisibility(n4);
            this.i.setVisibility(n4);
            e.a(this.l, (CharSequence)object2);
            e.a(this.n, (CharSequence)string5);
            e.a(this.o, (CharSequence)string3);
            e.a(this.p, (CharSequence)string4);
            this.p.setVisibility((int)l4);
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
            this.x = 2L;
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
            return this.x != 0L;
            {
            }
        }
    }
}

