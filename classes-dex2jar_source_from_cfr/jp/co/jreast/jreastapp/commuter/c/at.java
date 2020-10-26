/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.as;

public class at
extends as {
    private static final ViewDataBinding.b d;
    private static final SparseIntArray e;
    private long f = -1L;

    public at(e e2, View view) {
        this(e2, view, at.a(e2, view, 1, d, e));
    }

    private at(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (FrameLayout)arrobject[0]);
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
            long l2 = this.f;
            this.f = 0L;
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
            this.f = 1L;
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
            return this.f != 0L;
            {
            }
        }
    }
}

