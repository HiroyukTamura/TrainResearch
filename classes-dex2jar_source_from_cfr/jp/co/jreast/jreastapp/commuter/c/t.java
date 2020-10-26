/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.s;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;

public class t
extends s
implements b.a {
    private static final ViewDataBinding.b g;
    private static final SparseIntArray h;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private long k = -1L;

    static {
        h = new SparseIntArray();
        h.put(2131231178, 3);
    }

    public t(androidx.databinding.e e2, View view) {
        this(e2, view, t.a(e2, view, 4, g, h));
    }

    private t(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 1, (AppCompatImageView)arrobject[2], (RecyclerView)arrobject[3], (AppCompatTextView)arrobject[1]);
        this.c.setTag(null);
        this.i = (ConstraintLayout)((Object)arrobject[0]);
        this.i.setTag(null);
        this.e.setTag(null);
        this.a(view);
        this.j = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.k |= 1L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        object = this.f;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((d)object).g();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(d d2) {
        this.f = d2;
        synchronized (this) {
            this.k |= 2L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        if (n2 != 0) {
            return false;
        }
        return this.a((LiveData)object, n3);
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
        LiveData<String> liveData = this.f;
        String string2 = null;
        long l3 = 7L & l2 LCMP 0L;
        String string3 = string2;
        if (l3 != false) {
            liveData = liveData != null ? ((d)((Object)liveData)).b() : null;
            this.a(0, liveData);
            string3 = string2;
            if (liveData != null) {
                string3 = (String)liveData.a();
            }
        }
        if ((l2 & 4L) != 0L) {
            this.c.setOnClickListener(this.j);
        }
        if (l3 != false) {
            e.a(this.e, string3);
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
            this.k = 4L;
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

