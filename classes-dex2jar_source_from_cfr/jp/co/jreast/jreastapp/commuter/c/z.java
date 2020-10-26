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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.y;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.q.a.c;

public class z
extends y
implements b.a {
    private static final ViewDataBinding.b x;
    private static final SparseIntArray y;
    private final View.OnClickListener A;
    private long B = -1L;
    private final ConstraintLayout z;

    static {
        y = new SparseIntArray();
        y.put(2131231259, 2);
        y.put(2131231253, 3);
        y.put(2131231260, 4);
        y.put(2131231156, 5);
        y.put(2131231155, 6);
        y.put(2131230978, 7);
        y.put(2131231154, 8);
        y.put(2131230773, 9);
        y.put(2131231165, 10);
        y.put(2131230975, 11);
        y.put(2131231163, 12);
        y.put(2131230976, 13);
        y.put(2131231164, 14);
        y.put(2131231158, 15);
        y.put(2131231157, 16);
        y.put(2131231160, 17);
        y.put(2131231159, 18);
        y.put(2131231162, 19);
        y.put(2131231161, 20);
    }

    public z(e e2, View view) {
        this(e2, view, z.a(e2, view, 21, x, y));
    }

    private z(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (View)arrobject[9], (AppCompatImageView)arrobject[1], (TextView)arrobject[11], (TextView)arrobject[13], (TextView)arrobject[7], (TextView)arrobject[8], (TextView)arrobject[6], (TextView)arrobject[5], (TextView)arrobject[16], (TextView)arrobject[15], (TextView)arrobject[18], (TextView)arrobject[17], (TextView)arrobject[20], (TextView)arrobject[19], (TextView)arrobject[12], (TextView)arrobject[14], (TextView)arrobject[10], (AppCompatTextView)arrobject[3], (ConstraintLayout)((Object)arrobject[2]), (AppCompatImageView)arrobject[4]);
        this.d.setTag(null);
        this.z = (ConstraintLayout)((Object)arrobject[0]);
        this.z.setTag(null);
        this.a(view);
        this.A = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.w;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((c)object).c();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c c2) {
        this.w = c2;
        synchronized (this) {
            this.B |= 1L;
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
            l2 = this.B;
            this.B = 0L;
        }
        c c2 = this.w;
        if ((l2 & 2L) != 0L) {
            this.d.setOnClickListener(this.A);
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
            this.B = 2L;
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
            return this.B != 0L;
            {
            }
        }
    }
}

