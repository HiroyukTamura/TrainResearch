/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.be;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.p.f;

public class bf
extends be
implements b.a {
    private static final ViewDataBinding.b l;
    private static final SparseIntArray m;
    private final View.OnClickListener n;
    private long o = -1L;

    static {
        m = new SparseIntArray();
        m.put(2131231277, 2);
        m.put(2131231263, 3);
        m.put(2131231252, 4);
        m.put(2131231250, 5);
        m.put(2131231073, 6);
        m.put(2131230823, 7);
    }

    public bf(e e2, View view) {
        this(e2, view, bf.a(e2, view, 8, l, m));
    }

    private bf(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageButton)arrobject[1], (FrameLayout)arrobject[7], (FrameLayout)arrobject[6], (TextView)arrobject[5], (ConstraintLayout)((Object)arrobject[0]), (TextView)arrobject[4], (ConstraintLayout)((Object)arrobject[3]), (Toolbar)((Object)arrobject[2]));
        this.c.setTag(null);
        this.g.setTag(null);
        this.a(view);
        this.n = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.k;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((f)object).c();
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
            this.o |= 1L;
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
            l2 = this.o;
            this.o = 0L;
        }
        f f2 = this.k;
        if ((l2 & 2L) != 0L) {
            this.c.setOnClickListener(this.n);
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
            this.o = 2L;
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
            return this.o != 0L;
            {
            }
        }
    }
}

