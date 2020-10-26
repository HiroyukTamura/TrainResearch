/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.legacy.widget.Space;
import jp.co.jreast.jreastapp.commuter.c.dm;

public class dn
extends dm {
    private static final ViewDataBinding.b i;
    private static final SparseIntArray j;
    private long k = -1L;

    static {
        j = new SparseIntArray();
        j.put(2131231288, 1);
        j.put(2131230999, 2);
        j.put(2131230994, 3);
        j.put(2131231002, 4);
        j.put(2131231004, 5);
    }

    public dn(e e2, View view) {
        this(e2, view, dn.a(e2, view, 6, i, j));
    }

    private dn(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (LinearLayout)arrobject[3], (LinearLayout)arrobject[2], (Space)((Object)arrobject[4]), (AppCompatImageView)arrobject[5], (TextView)arrobject[1], (ConstraintLayout)((Object)arrobject[0]));
        this.h.setTag(null);
        this.a(view);
        this.c();
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
        synchronized (this) {
            long l2 = this.k;
            this.k = 0L;
            return;
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
            this.k = 1L;
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

