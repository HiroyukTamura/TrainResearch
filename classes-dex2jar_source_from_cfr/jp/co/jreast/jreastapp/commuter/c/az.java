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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.ay;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.o.h;

public class az
extends ay
implements b.a {
    private static final ViewDataBinding.b o;
    private static final SparseIntArray p;
    private final View.OnClickListener q;
    private long r = -1L;

    static {
        p = new SparseIntArray();
        p.put(2131231277, 2);
        p.put(2131231264, 3);
        p.put(2131230885, 4);
        p.put(2131231256, 5);
        p.put(2131231254, 6);
        p.put(2131231223, 7);
        p.put(2131231224, 8);
        p.put(2131231073, 9);
        p.put(2131230823, 10);
    }

    public az(e e2, View view) {
        this(e2, view, az.a(e2, view, 11, o, p));
    }

    private az(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageButton)arrobject[1], (FrameLayout)arrobject[10], (AppCompatImageView)arrobject[4], (FrameLayout)arrobject[9], (ConstraintLayout)((Object)arrobject[0]), (TextView)arrobject[7], (TextView)arrobject[8], (TextView)arrobject[6], (TextView)arrobject[5], (ConstraintLayout)((Object)arrobject[3]), (Toolbar)((Object)arrobject[2]));
        this.c.setTag(null);
        this.g.setTag(null);
        this.a(view);
        this.q = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.n;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((h)object).c();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(h h2) {
        this.n = h2;
        synchronized (this) {
            this.r |= 1L;
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
            l2 = this.r;
            this.r = 0L;
        }
        h h2 = this.n;
        if ((l2 & 2L) != 0L) {
            this.c.setOnClickListener(this.q);
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
            this.r = 2L;
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
            return this.r != 0L;
            {
            }
        }
    }
}

