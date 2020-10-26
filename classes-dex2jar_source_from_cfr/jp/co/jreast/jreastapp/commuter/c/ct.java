/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.Button
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.cs;

public class ct
extends cs {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private long h = -1L;

    static {
        g = new SparseIntArray();
        g.put(2131230937, 1);
        g.put(2131230788, 2);
    }

    public ct(e e2, View view) {
        this(e2, view, ct.a(e2, view, 3, f, g));
    }

    private ct(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (Button)arrobject[2], (LinearLayout)arrobject[1], (ConstraintLayout)((Object)arrobject[0]));
        this.e.setTag(null);
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
            long l2 = this.h;
            this.h = 0L;
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
            this.h = 1L;
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
            return this.h != 0L;
            {
            }
        }
    }
}

