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
import jp.co.jreast.jreastapp.commuter.c.by;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;

public class bz
extends by
implements b.a {
    private static final ViewDataBinding.b k;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private long o = -1L;

    static {
        l = new SparseIntArray();
        l.put(2131230960, 6);
    }

    public bz(androidx.databinding.e e2, View view) {
        this(e2, view, bz.a(e2, view, 7, k, l));
    }

    private bz(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[4], (TextView)arrobject[1], (AppCompatImageView)arrobject[6], (TextView)arrobject[3], (TextView)arrobject[2], (TextView)arrobject[5]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.f.setTag(null);
        this.m = (ConstraintLayout)((Object)arrobject[0]);
        this.m.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.a(view);
        this.n = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.i;
        RailwayLineInformation railwayLineInformation = this.j;
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
        this.j = railwayLineInformation;
        synchronized (this) {
            this.o |= 2L;
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
        this.i = y2;
        synchronized (this) {
            this.o |= 1L;
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
        int n2;
        long l2;
        Object object;
        synchronized (this) {
            l2 = this.o;
            this.o = 0L;
        }
        Object object2 = this.i;
        RailwayLineInformation railwayLineInformation = this.j;
        int n3 = 0;
        String string2 = null;
        long l3 = 6L & l2 LCMP 0L;
        if (l3 != false && railwayLineInformation != null) {
            string2 = railwayLineInformation.getDisplayName();
            n3 = railwayLineInformation.showUnderLinerText();
            object2 = railwayLineInformation.displayDirectionOfList();
            object = railwayLineInformation.getSection();
            n2 = railwayLineInformation.showLinerText();
        } else {
            object = object2 = null;
            n2 = 0;
        }
        if (l3 != false) {
            e.a(this.c, (CharSequence)object2);
            e.a(this.d, (CharSequence)string2);
            this.f.setVisibility(n2);
            e.a(this.g, (CharSequence)object);
            this.h.setVisibility(n3);
        }
        if ((l2 & 4L) != 0L) {
            this.m.setOnClickListener(this.n);
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
            this.o = 4L;
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

