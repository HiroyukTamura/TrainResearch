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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.dk;

public class dl
extends dk {
    private static final ViewDataBinding.b d;
    private static final SparseIntArray e;
    private final FrameLayout f;
    private long g = -1L;

    static {
        e = new SparseIntArray();
        e.put(2131231230, 1);
    }

    public dl(e e2, View view) {
        this(e2, view, dl.a(e2, view, 2, d, e));
    }

    private dl(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[1]);
        this.f = (FrameLayout)arrobject[0];
        this.f.setTag(null);
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
            long l2 = this.g;
            this.g = 0L;
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
            this.g = 1L;
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
            return this.g != 0L;
            {
            }
        }
    }
}

