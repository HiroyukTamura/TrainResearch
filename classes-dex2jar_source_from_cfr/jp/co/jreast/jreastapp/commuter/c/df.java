/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.de;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.j;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;

public class df
extends de
implements b.a {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private final ConstraintLayout h;
    private final View.OnClickListener i;
    private long j = -1L;

    public df(androidx.databinding.e e2, View view) {
        this(e2, view, df.a(e2, view, 2, f, g));
    }

    private df(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (Button)arrobject[1]);
        this.h = (ConstraintLayout)((Object)arrobject[0]);
        this.h.setTag(null);
        this.c.setTag(null);
        this.a(view);
        this.i = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.d;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((j)object).l();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.d = j2;
        synchronized (this) {
            this.j |= 2L;
        }
        this.a(11);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(FavoriteRoute favoriteRoute) {
        this.e = favoriteRoute;
        synchronized (this) {
            this.j |= 1L;
        }
        this.a(2);
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
            l2 = this.j;
            this.j = 0L;
        }
        FavoriteRoute favoriteRoute = this.e;
        Object var5_3 = null;
        Object object = this.d;
        long l3 = 5L & l2 LCMP 0L;
        object = var5_3;
        if (l3 != false) {
            object = var5_3;
            if (favoriteRoute != null) {
                object = favoriteRoute.getName();
            }
        }
        if ((l2 & 4L) != 0L) {
            this.c.setOnClickListener(this.i);
        }
        if (l3 != false) {
            e.a((TextView)this.c, (CharSequence)object);
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

