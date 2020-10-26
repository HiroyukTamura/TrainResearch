/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.c;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.cc;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.q.h;

public class cd
extends cc
implements b.a {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private final ConstraintLayout h;
    private final AppCompatImageView i;
    private final View.OnClickListener j;
    private long k = -1L;

    static {
        g = new SparseIntArray();
        g.put(2131231172, 3);
    }

    public cd(e e2, View view) {
        this(e2, view, cd.a(e2, view, 4, f, g));
    }

    private cd(e e2, View view, Object[] arrobject) {
        super(e2, view, 2, (AppCompatImageView)arrobject[1], (View)arrobject[3]);
        this.c.setTag(null);
        this.h = (ConstraintLayout)((Object)arrobject[0]);
        this.h.setTag(null);
        this.i = (AppCompatImageView)arrobject[2];
        this.i.setTag(null);
        this.a(view);
        this.j = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.k |= 1L;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean b(p<Drawable> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.k |= 2L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        object = this.e;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((h)object).x();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(h h2) {
        this.e = h2;
        synchronized (this) {
            this.k |= 4L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        switch (n2) {
            default: {
                return false;
            }
            case 1: {
                return this.b((p)object, n3);
            }
            case 0: 
        }
        return this.a((p)object, n3);
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
            l2 = this.k;
            this.k = 0L;
        }
        p<Object> p2 = this.e;
        int n2 = 0;
        int n3 = 0;
        Drawable drawable2 = null;
        long l3 = l2;
        Object object = drawable2;
        if ((15L & l2) != 0L) {
            n2 = l2 & 13L LCMP 0L;
            long l4 = l2;
            int n4 = n3;
            if (n2 != 0) {
                object = p2 != null ? ((h)((Object)p2)).p() : null;
                this.a(0, (LiveData<?>)object);
                object = object != null ? (Boolean)object.a() : null;
                boolean bl2 = ViewDataBinding.a(object);
                l4 = l2;
                if (n2 != 0) {
                    l4 = bl2 ? 32L : 16L;
                    l4 = l2 | l4;
                }
                n4 = bl2 ? n3 : 8;
            }
            l3 = l4;
            n2 = n4;
            object = drawable2;
            if ((l4 & 14L) != 0L) {
                p2 = p2 != null ? ((h)((Object)p2)).n() : null;
                this.a(1, p2);
                l3 = l4;
                n2 = n4;
                object = drawable2;
                if (p2 != null) {
                    object = (Drawable)p2.a();
                    n2 = n4;
                    l3 = l4;
                }
            }
        }
        if ((8L & l3) != 0L) {
            this.c.setOnClickListener(this.j);
        }
        if ((l3 & 14L) != 0L) {
            c.a(this.c, object);
        }
        if ((l3 & 13L) != 0L) {
            this.i.setVisibility(n2);
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
            this.k = 8L;
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
            return this.k != 0L;
            {
            }
        }
    }
}

