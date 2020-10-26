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
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.g;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class h
extends g
implements b.a {
    private static final ViewDataBinding.b l;
    private static final SparseIntArray m;
    private final ConstraintLayout n;
    private final View.OnClickListener o;
    private long p = -1L;

    static {
        m = new SparseIntArray();
        m.put(2131231253, 2);
        m.put(2131231055, 3);
        m.put(2131231052, 4);
        m.put(2131231053, 5);
        m.put(2131231054, 6);
        m.put(2131230888, 7);
        m.put(2131230927, 8);
    }

    public h(e e2, View view) {
        this(e2, view, h.a(e2, view, 9, l, m));
    }

    private h(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[1], (View)arrobject[7], (RecyclerView)arrobject[8], (LinearLayout)arrobject[4], (TextView)arrobject[5], (TextView)arrobject[6], (TextView)arrobject[3], (AppCompatTextView)arrobject[2]);
        this.c.setTag(null);
        this.n = (ConstraintLayout)((Object)arrobject[0]);
        this.n.setTag(null);
        this.a(view);
        this.o = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.k;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((f)object).f();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(f f2) {
        this.k = f2;
        synchronized (this) {
            this.p |= 1L;
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
            l2 = this.p;
            this.p = 0L;
        }
        f f2 = this.k;
        if ((l2 & 2L) != 0L) {
            this.c.setOnClickListener(this.o);
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
            this.p = 2L;
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
            return this.p != 0L;
            {
            }
        }
    }
}

