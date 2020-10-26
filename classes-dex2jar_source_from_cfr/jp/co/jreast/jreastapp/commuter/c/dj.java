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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.di;
import jp.co.jreast.jreastapp.commuter.candidatestation.c;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.Station;

public class dj
extends di
implements b.a {
    private static final ViewDataBinding.b i;
    private static final SparseIntArray j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m = -1L;

    static {
        j = new SparseIntArray();
        j.put(2131231169, 3);
    }

    public dj(androidx.databinding.e e2, View view) {
        this(e2, view, dj.a(e2, view, 4, i, j));
    }

    private dj(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageButton)arrobject[1], (View)arrobject[3], (ConstraintLayout)((Object)arrobject[0]), (TextView)arrobject[2]);
        this.c.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.a(view);
        this.k = new b(this, 1);
        this.l = new b(this, 2);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        int n3 = 0;
        int n4 = 0;
        switch (n2) {
            default: {
                return;
            }
            case 2: {
                object = this.h;
                c c2 = this.g;
                n2 = n4;
                if (c2 != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                c2.a((Station)object);
                return;
            }
            case 1: {
                object = this.h;
                c c3 = this.g;
                n2 = n3;
                if (c3 != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                c3.b((Station)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c c2) {
        this.g = c2;
        synchronized (this) {
            this.m |= 2L;
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
    public void a(Station station) {
        this.h = station;
        synchronized (this) {
            this.m |= 1L;
        }
        this.a(9);
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
            l2 = this.m;
            this.m = 0L;
        }
        Station station = this.h;
        Object var5_3 = null;
        Object object = this.g;
        long l3 = 5L & l2 LCMP 0L;
        object = var5_3;
        if (l3 != false) {
            object = var5_3;
            if (station != null) {
                object = station.getName();
            }
        }
        if ((l2 & 4L) != 0L) {
            this.c.setOnClickListener(this.l);
            this.e.setOnClickListener(this.k);
        }
        if (l3 != false) {
            e.a(this.f, (CharSequence)object);
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
            this.m = 4L;
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
            return this.m != 0L;
            {
            }
        }
    }
}

