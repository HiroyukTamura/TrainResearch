/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.google.android.material.tabs.TabLayout;
import jp.co.jreast.jreastapp.commuter.c.k;
import jp.co.jreast.jreastapp.commuter.main.MainViewPager;

public class l
extends k {
    private static final ViewDataBinding.b g;
    private static final SparseIntArray h;
    private long i = -1L;

    static {
        h = new SparseIntArray();
        h.put(2131231231, 1);
        h.put(2131231070, 2);
        h.put(2131231124, 3);
    }

    public l(e e2, View view) {
        this(e2, view, l.a(e2, view, 4, g, h));
    }

    private l(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (ConstraintLayout)((Object)arrobject[0]), (MainViewPager)((Object)arrobject[2]), (View)arrobject[3], (TabLayout)((Object)arrobject[1]));
        this.c.setTag(null);
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
            long l2 = this.i;
            this.i = 0L;
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
            this.i = 1L;
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
            return this.i != 0L;
            {
            }
        }
    }
}

