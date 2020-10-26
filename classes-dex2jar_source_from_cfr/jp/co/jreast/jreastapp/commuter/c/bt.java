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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.bs;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;

public class bt
extends bs
implements b.a {
    private static final ViewDataBinding.b h;
    private static final SparseIntArray i;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l = -1L;

    static {
        i = new SparseIntArray();
        i.put(2131230960, 3);
    }

    public bt(androidx.databinding.e e2, View view) {
        this(e2, view, bt.a(e2, view, 4, h, i));
    }

    private bt(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[1], (AppCompatImageView)arrobject[3], (TextView)arrobject[2]);
        this.c.setTag(null);
        this.j = (ConstraintLayout)((Object)arrobject[0]);
        this.j.setTag(null);
        this.e.setTag(null);
        this.a(view);
        this.k = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.f;
        RailwayLineInformation railwayLineInformation = this.g;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((y)object).a(railwayLineInformation);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(RailwayLineInformation railwayLineInformation) {
        this.g = railwayLineInformation;
        synchronized (this) {
            this.l |= 2L;
        }
        this.a(4);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(y y2) {
        this.f = y2;
        synchronized (this) {
            this.l |= 1L;
        }
        this.a(1);
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
            l2 = this.l;
            this.l = 0L;
        }
        Object object = this.f;
        object = this.g;
        String string2 = null;
        long l3 = 6L & l2 LCMP 0L;
        if (l3 != false && object != null) {
            string2 = ((RailwayLineInformation)object).getDisplayName();
            object = ((RailwayLineInformation)object).getSection();
        } else {
            object = null;
        }
        if (l3 != false) {
            e.a(this.c, (CharSequence)string2);
            e.a(this.e, (CharSequence)object);
        }
        if ((l2 & 4L) != 0L) {
            this.j.setOnClickListener(this.k);
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
            this.l = 4L;
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
            return this.l != 0L;
            {
            }
        }
    }
}

