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
import jp.co.jreast.jreastapp.commuter.c.ac;
import jp.co.jreast.jreastapp.commuter.common.o;
import jp.co.jreast.jreastapp.commuter.common.view.ScalableImageView;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class ad
extends ac
implements b.a {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private final ConstraintLayout h;
    private final View.OnClickListener i;
    private long j = -1L;

    public ad(e e2, View view) {
        this(e2, view, ad.a(e2, view, 3, f, g));
    }

    private ad(e e2, View view, Object[] arrobject) {
        super(e2, view, 1, (AppCompatImageView)arrobject[2], (ScalableImageView)arrobject[1]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.h = (ConstraintLayout)((Object)arrobject[0]);
        this.h.setTag(null);
        this.a(view);
        this.i = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(LiveData<Drawable> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.j |= 1L;
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
            ((o)object).e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(o o2) {
        this.e = o2;
        synchronized (this) {
            this.j |= 2L;
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
            l2 = this.j;
            this.j = 0L;
        }
        LiveData<Object> liveData = this.e;
        Drawable drawable2 = null;
        long l3 = 7L & l2 LCMP 0L;
        Drawable drawable3 = drawable2;
        if (l3 != false) {
            liveData = liveData != null ? ((o)((Object)liveData)).b() : null;
            this.a(0, liveData);
            drawable3 = drawable2;
            if (liveData != null) {
                drawable3 = (Drawable)liveData.a();
            }
        }
        if ((l2 & 4L) != 0L) {
            this.c.setOnClickListener(this.i);
        }
        if (l3 != false) {
            c.a(this.d, drawable3);
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
            this.j = 4L;
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
            return this.j != 0L;
            {
            }
        }
    }
}

