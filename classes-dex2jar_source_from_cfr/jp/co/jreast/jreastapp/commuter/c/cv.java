/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.Button
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.cu;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.n.k;

public class cv
extends cu {
    private static final ViewDataBinding.b w;
    private static final SparseIntArray x;
    private long y = -1L;

    static {
        x = new SparseIntArray();
        x.put(2131231264, 5);
        x.put(2131230790, 6);
        x.put(2131230789, 7);
        x.put(2131231059, 8);
        x.put(2131230946, 9);
        x.put(2131231257, 10);
        x.put(2131230885, 11);
        x.put(2131231255, 12);
        x.put(2131230958, 13);
        x.put(2131231026, 14);
        x.put(2131231037, 15);
        x.put(2131231305, 16);
        x.put(2131230800, 17);
    }

    public cv(androidx.databinding.e e2, View view) {
        this(e2, view, cv.a(e2, view, 18, w, x));
    }

    private cv(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[7], (Button)arrobject[6], (AppCompatTextView)arrobject[17], (AppCompatImageView)arrobject[11], (AppCompatTextView)arrobject[4], (ConstraintLayout)((Object)arrobject[9]), (AppCompatTextView)arrobject[1], (AppCompatTextView)arrobject[13], (AppCompatTextView)arrobject[2], (AppCompatTextView)arrobject[14], (AppCompatTextView)arrobject[15], (TextView)arrobject[8], (AppCompatTextView)arrobject[3], (ConstraintLayout)((Object)arrobject[0]), (TextView)arrobject[12], (TextView)arrobject[10], (ConstraintLayout)((Object)arrobject[5]), (AppCompatTextView)arrobject[16]);
        this.g.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
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
        this.v = route;
        synchronized (this) {
            this.y |= 1L;
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
        this.u = k2;
        synchronized (this) {
            this.y |= 2L;
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
        k k2;
        long l2;
        Object object;
        Object object2;
        long l3;
        String string2;
        String string3;
        block11 : {
            block10 : {
                block9 : {
                    synchronized (this) {
                        l3 = this.y;
                        this.y = 0L;
                    }
                    object = this.v;
                    k2 = this.u;
                    string3 = null;
                    l2 = 5L & l3 LCMP 0L;
                    if (l2 == false) break block9;
                    if (object != null) {
                        object2 = ((Route)object).getAccuracy();
                        object = ((Route)object).getTransferCount();
                    } else {
                        object2 = object = null;
                    }
                    if (object2 == null) break block10;
                    string2 = ((Accuracy)object2).getHour();
                    object2 = ((Accuracy)object2).getMin();
                    break block11;
                }
                object = null;
            }
            object2 = null;
            string2 = null;
        }
        long l4 = l3 & 6L LCMP 0L;
        String string4 = string3;
        if (l4 != false) {
            string4 = string3;
            if (k2 != null) {
                string4 = k2.r();
            }
        }
        if (l4 != false) {
            e.a(this.g, string4);
        }
        if (l2 != false) {
            e.a(this.i, (CharSequence)string2);
            e.a(this.k, (CharSequence)object2);
            e.a(this.o, (CharSequence)object);
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
            this.y = 4L;
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

