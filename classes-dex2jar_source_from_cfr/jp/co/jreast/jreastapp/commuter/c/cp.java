/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.legacy.widget.Space;
import jp.co.jreast.jreastapp.commuter.c.co;

public class cp
extends co {
    private static final ViewDataBinding.b n;
    private static final SparseIntArray o;
    private long p = -1L;

    static {
        o = new SparseIntArray();
        o.put(2131231288, 1);
        o.put(2131231000, 2);
        o.put(2131230883, 3);
        o.put(2131230882, 4);
        o.put(2131230881, 5);
        o.put(2131230999, 6);
        o.put(2131230994, 7);
        o.put(2131231002, 8);
        o.put(2131231004, 9);
        o.put(2131230845, 10);
    }

    public cp(e e2, View view) {
        this(e2, view, cp.a(e2, view, 11, n, o));
    }

    private cp(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[10], (View)arrobject[5], (View)arrobject[4], (FrameLayout)arrobject[3], (View)arrobject[7], (View)arrobject[6], (LinearLayout)arrobject[2], (Space)((Object)arrobject[8]), (AppCompatImageView)arrobject[9], (ConstraintLayout)((Object)arrobject[0]), (TextView)arrobject[1]);
        this.l.setTag(null);
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
            long l2 = this.p;
            this.p = 0L;
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
            this.p = 1L;
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
            return this.p != 0L;
            {
            }
        }
    }
}

