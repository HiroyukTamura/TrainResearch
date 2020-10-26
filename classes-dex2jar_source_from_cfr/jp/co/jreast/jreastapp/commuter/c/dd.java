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
import androidx.databinding.e;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.dc;
import jp.co.jreast.jreastapp.commuter.common.view.OutlineTextView;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.skewscroll.c;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;

public class dd
extends dc
implements b.a {
    private static final ViewDataBinding.b q;
    private static final SparseIntArray r;
    private final View.OnClickListener s;
    private long t = -1L;

    static {
        r = new SparseIntArray();
        r.put(2131231093, 9);
        r.put(2131231044, 10);
        r.put(2131231045, 11);
    }

    public dd(e e2, View view) {
        this(e2, view, dd.a(e2, view, 12, q, r));
    }

    private dd(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (OutlineTextView)((Object)arrobject[1]), (OutlineTextView)((Object)arrobject[4]), (TextView)arrobject[3], (OutlineTextView)((Object)arrobject[2]), (OutlineTextView)((Object)arrobject[5]), (AppCompatImageView)arrobject[8], (AppCompatImageView)arrobject[7], (AppCompatImageView)arrobject[6], (ConstraintLayout)((Object)arrobject[10]), (TextView)arrobject[11], (LinearLayout)arrobject[9], (ConstraintLayout)((Object)arrobject[0]));
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.n.setTag(null);
        this.a(view);
        this.s = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.p;
        h h2 = this.o;
        n2 = h2 != null ? 1 : 0;
        if (n2 != 0) {
            h2.a((Route)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(Route route) {
        this.p = route;
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
    public void a(h h2) {
        this.o = h2;
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
        Object object2;
        long l2;
        String string2;
        boolean bl2;
        long l3;
        Object object3;
        boolean bl3;
        int n2;
        h h2;
        long l4;
        long l5;
        boolean bl4;
        Object object4;
        String string3;
        block25 : {
            block26 : {
                block23 : {
                    block24 : {
                        synchronized (this) {
                            l4 = this.t;
                            this.t = 0L;
                        }
                        object2 = this.p;
                        h2 = this.o;
                        l5 = l4 & 7L LCMP 0L;
                        if (l5 == false) break block23;
                        if (object2 != null) {
                            bl3 = ((Route)object2).getShortestTime();
                            bl4 = ((Route)object2).getMinimumTransfer();
                        } else {
                            bl3 = false;
                            bl4 = false;
                        }
                        l3 = l4;
                        if (l5 != false) {
                            l3 = bl3 ? 1024L : 512L;
                            l3 = l4 | l3;
                        }
                        l4 = l3;
                        if ((l3 & 7L) != 0L) {
                            l4 = bl4 ? 64L : 32L;
                            l4 = l3 | l4;
                        }
                        if (h2 != null) {
                            string2 = h2.b((Route)object2);
                            l5 = h2.c((Route)object2);
                            string3 = h2.d((Route)object2);
                        } else {
                            string2 = null;
                            l5 = 0;
                            string3 = null;
                        }
                        if ((l4 & 5L) == 0L) break block24;
                        if (object2 != null) {
                            object3 = ((Route)object2).getAccuracy();
                            object2 = ((Route)object2).getLines();
                        } else {
                            object2 = null;
                            object3 = null;
                        }
                        object3 = object3 != null ? ((Accuracy)object3).displayString() : null;
                        if (object2 != null) {
                            object = (RailwayLine)object2.get(0);
                            l2 = object2.size();
                        } else {
                            object = null;
                            l2 = 0;
                        }
                        object = object != null ? ((RailwayLine)object).getFrom() : null;
                        object = object != null ? ((BoardingStation)object).getAccuracy() : null;
                        object4 = object2 != null ? (RailwayLine)object2.get((int)(l2 - true)) : null;
                        object2 = object != null ? ((Accuracy)object).fourDigitString() : null;
                        object = object4 != null ? ((RailwayLine)object4).getTo() : null;
                        object = object != null ? ((BoardingStation)object).getAccuracy() : null;
                        if (object != null) {
                            String string4 = ((Accuracy)object).fourDigitString();
                            object = string2;
                            string2 = string3;
                            object4 = object3;
                            string3 = string4;
                            object3 = object;
                            bl2 = bl4;
                            object = object4;
                        } else {
                            object = string2;
                            string2 = string3;
                            object4 = object3;
                            string3 = null;
                            object3 = object;
                            bl2 = bl4;
                            object = object4;
                        }
                        break block25;
                    }
                    object3 = string2;
                    string2 = string3;
                    break block26;
                }
                l5 = 0;
                bl3 = false;
                string2 = null;
                object3 = null;
                bl4 = false;
            }
            string3 = null;
            object2 = null;
            object = null;
            bl2 = bl4;
        }
        bl4 = (l4 & 1088L) != 0L && (object4 = h2 != null ? h2.g() : null) != null ? object4.a() : false;
        l2 = l4 & 7L LCMP 0L;
        if (l2 != false) {
            bl2 = bl2 ? bl4 : false;
            if (!bl3) {
                bl4 = false;
            }
            l3 = l4;
            if (l2 != false) {
                l3 = bl2 ? 16L : 8L;
                l3 = l4 | l3;
            }
            l4 = l3;
            if ((l3 & 7L) != 0L) {
                l4 = bl4 ? 256L : 128L;
                l4 = l3 | l4;
            }
            l2 = bl2 ? (long)0 : (long)8;
            n2 = bl4 ? 0 : 8;
        } else {
            n2 = 0;
            l2 = 0;
        }
        if ((l4 & 5L) != 0L) {
            OutlineTextView.a(this.c, object);
            OutlineTextView.a(this.d, string3);
            OutlineTextView.a(this.f, (String)object2);
        }
        if ((7L & l4) != 0L) {
            androidx.databinding.a.e.a(this.e, (CharSequence)string2);
            OutlineTextView.a(this.g, (String)object3);
            this.h.setVisibility((int)l5);
            this.i.setVisibility((int)l2);
            this.j.setVisibility(n2);
        }
        if ((l4 & 4L) != 0L) {
            this.n.setOnClickListener(this.s);
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

