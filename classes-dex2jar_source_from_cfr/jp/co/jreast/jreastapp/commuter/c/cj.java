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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.ci;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.webview.j;

public class cj
extends ci
implements b.a {
    private static final ViewDataBinding.b i;
    private static final SparseIntArray j;
    private final View.OnClickListener k;
    private long l = -1L;

    static {
        j = new SparseIntArray();
        j.put(2131230766, 2);
        j.put(2131230767, 3);
        j.put(2131230768, 4);
    }

    public cj(e e2, View view) {
        this(e2, view, cj.a(e2, view, 5, i, j));
    }

    private cj(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[2], (TextView)arrobject[3], (TextView)arrobject[4], (ConstraintLayout)((Object)arrobject[0]), (AppCompatImageButton)arrobject[1]);
        this.f.setTag(null);
        this.g.setTag(null);
        this.a(view);
        this.k = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.h;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((j)object).M();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.h = j2;
        synchronized (this) {
            this.l |= 1L;
        }
        this.a(11);
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
        j j2 = this.h;
        if ((l2 & 2L) != 0L) {
            this.g.setOnClickListener(this.k);
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
            this.l = 2L;
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

