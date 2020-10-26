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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.cw;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.n.k;

public class cx
extends cw
implements b.a {
    private static final ViewDataBinding.b v;
    private static final SparseIntArray w;
    private final View.OnClickListener x;
    private long y = -1L;

    static {
        w = new SparseIntArray();
        w.put(2131230998, 11);
        w.put(2131230997, 12);
        w.put(2131230996, 13);
        w.put(2131231004, 14);
        w.put(2131231005, 15);
        w.put(2131230858, 16);
    }

    public cx(androidx.databinding.e e2, View view) {
        this(e2, view, cx.a(e2, view, 17, v, w));
    }

    private cx(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[2], (ConstraintLayout)((Object)arrobject[7]), (TextView)arrobject[8], (TextView)arrobject[9], (AppCompatImageView)arrobject[16], (AppCompatTextView)arrobject[3], (ConstraintLayout)((Object)arrobject[0]), (View)arrobject[4], (View)arrobject[13], (AppCompatImageView)arrobject[12], (AppCompatImageView)arrobject[11], (AppCompatImageView)arrobject[14], (LinearLayout)arrobject[15], (TextView)arrobject[6], (TextView)arrobject[5], (View)arrobject[10], (AppCompatTextView)arrobject[1]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.a(view);
        this.x = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.u;
        k k2 = this.t;
        n2 = k2 != null ? 1 : 0;
        if (n2 != 0) {
            k2.c((RailwayLine)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(RailwayLine railwayLine) {
        this.u = railwayLine;
        synchronized (this) {
            this.y |= 2L;
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
        this.t = k2;
        synchronized (this) {
            this.y |= 4L;
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
        int n2;
        String string2;
        Object object;
        long l2;
        int n3;
        Object object2;
        int n4;
        Object object3;
        long l3;
        int n5;
        int n6;
        Object object4;
        Object object5;
        long l4;
        Object object6;
        synchronized (this) {
            l4 = this.y;
            this.y = 0L;
        }
        RailwayLine railwayLine = this.u;
        k k2 = this.t;
        Object var24_4 = null;
        Object var23_5 = null;
        int n7 = 0;
        int n8 = 0;
        if ((l4 & 14L) != 0L) {
            String string3;
            l2 = l4 & 10L LCMP 0L;
            if (l2 != false) {
                boolean bl2;
                boolean bl3;
                if (railwayLine != null) {
                    bl3 = railwayLine.getDirectOperationDeparture();
                    string3 = railwayLine.getName();
                    object5 = railwayLine.getFrom();
                    bl2 = railwayLine.isWalking();
                    object6 = railwayLine.getKindAndBoundFor();
                    object2 = railwayLine.getServiceStatus();
                    object = railwayLine.getTo();
                } else {
                    string3 = string2 = null;
                    object = object5 = (object6 = string3);
                    bl3 = false;
                    bl2 = false;
                    object2 = object5;
                    object5 = string3;
                    string3 = string2;
                }
                l3 = l4;
                if (l2 != false) {
                    if (bl3) {
                        l3 = l4 | 128L | 8192L;
                        l4 = 32768L;
                    } else {
                        l3 = l4 | 64L | 4096L;
                        l4 = 16384L;
                    }
                    l3 |= l4;
                }
                l4 = l3;
                if ((l3 & 10L) != 0L) {
                    l4 = bl2 ? 512L : 256L;
                    l4 = l3 | l4;
                }
                n3 = 8;
                l2 = bl3 ? (long)0 : (long)8;
                n6 = 4;
                n4 = bl3 ? 4 : 0;
                n5 = bl3 ? 8 : 0;
                if (!bl2) {
                    n6 = 0;
                }
                object5 = object5 != null ? ((BoardingStation)object5).getName() : null;
                bl3 = object6 != null ? ((String)object6).isEmpty() : false;
                l3 = l4;
                if ((l4 & 10L) != 0L) {
                    l3 = bl3 ? 32L : 16L;
                    l3 = l4 | l3;
                }
                if (object2 != null) {
                    string2 = ((ServiceStatus)object2).getDelayReason();
                    object4 = ((ServiceStatus)object2).getDelayMinute();
                    object2 = string2;
                } else {
                    object2 = object4 = null;
                }
                if (object != null) {
                    object3 = ((BoardingStation)object).getAccuracy();
                    string2 = ((BoardingStation)object).platformNameWithSuffix();
                    object = object3;
                } else {
                    string2 = null;
                    object = string2;
                }
                n2 = bl3 ? 8 : 0;
                bl3 = object2 != null ? ((String)object2).isEmpty() : false;
                l4 = l3;
                if ((l3 & 10L) != 0L) {
                    l4 = bl3 ? 2048L : 1024L;
                    l4 = l3 | l4;
                }
                bl2 = object4 != null ? ((String)object4).isEmpty() : false;
                l3 = l4;
                if ((l4 & 10L) != 0L) {
                    l3 = bl2 ? 131072L : 65536L;
                    l3 = l4 | l3;
                }
                object3 = object != null ? ((Accuracy)object).fourDigitString() : null;
                n7 = bl3 ? 8 : 0;
                if (!bl2) {
                    n3 = 0;
                }
                n8 = n2;
                n2 = n3;
                object4 = string3;
                object = object5;
                object5 = object6;
                string3 = string2;
                n3 = (int)l2;
                object6 = object3;
                l2 = n7;
            } else {
                object5 = object = (object4 = null);
                string3 = object5;
                object6 = object2 = string3;
                n2 = 0;
                n5 = 0;
                n3 = 0;
                n6 = 0;
                n4 = 0;
                l2 = 0;
                l3 = l4;
            }
            string2 = var23_5;
            if (k2 != null) {
                string2 = k2.d(railwayLine);
            }
            object3 = object;
            object = object2;
            object2 = object6;
            n7 = l2;
            object6 = object3;
            l2 = n8;
            object3 = string3;
        } else {
            object6 = object = null;
            String string4 = object6;
            object2 = object5 = string4;
            string2 = object2;
            l2 = 0;
            n2 = 0;
            n5 = 0;
            n3 = 0;
            n6 = 0;
            n4 = 0;
            object3 = object2;
            object4 = object5;
            object2 = var24_4;
            object5 = string4;
            l3 = l4;
        }
        if ((10L & l3) != 0L) {
            e.a(this.c, (CharSequence)object2);
            this.c.setVisibility(n5);
            this.e.setVisibility(n2);
            e.a(this.f, (CharSequence)object);
            this.f.setVisibility(n7);
            e.a(this.h, (CharSequence)object6);
            this.j.setVisibility(n3);
            e.a(this.p, (CharSequence)object5);
            this.p.setVisibility((int)l2);
            e.a(this.q, (CharSequence)object4);
            this.q.setVisibility(n6);
            this.r.setVisibility(n4);
            e.a(this.s, (CharSequence)object3);
            this.s.setVisibility(n5);
        }
        if ((8L & l3) != 0L) {
            this.d.setOnClickListener(this.x);
        }
        if ((l3 & 14L) != 0L) {
            e.a(this.e, (CharSequence)string2);
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
            this.y = 8L;
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
            return this.y != 0L;
            {
            }
        }
    }
}

