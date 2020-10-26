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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.cg;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;

public class ch
extends cg {
    private static final ViewDataBinding.b e;
    private static final SparseIntArray f;
    private final LinearLayout g;
    private long h = -1L;

    public ch(androidx.databinding.e e2, View view) {
        this(e2, view, ch.a(e2, view, 2, e, f));
    }

    private ch(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[1]);
        this.g = (LinearLayout)arrobject[0];
        this.g.setTag(null);
        this.c.setTag(null);
        this.a(view);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(LineServiceStatusItem lineServiceStatusItem) {
        this.d = lineServiceStatusItem;
        synchronized (this) {
            this.h |= 1L;
        }
        this.a(12);
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
            l2 = this.h;
            this.h = 0L;
        }
        String string2 = null;
        LineServiceStatusItem lineServiceStatusItem = this.d;
        long l3 = l2 & 3L LCMP 0L;
        String string3 = string2;
        if (l3 != false) {
            string3 = string2;
            if (lineServiceStatusItem != null) {
                string3 = lineServiceStatusItem.getSubTitle();
            }
        }
        if (l3 != false) {
            e.a(this.c, string3);
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
            this.h = 2L;
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

