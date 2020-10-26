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
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.dg;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.Settings;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;

public class dh
extends dg
implements b.a {
    private static final ViewDataBinding.b f;
    private static final SparseIntArray g;
    private final ConstraintLayout h;
    private final AppCompatCheckedTextView i;
    private final View.OnClickListener j;
    private long k = -1L;

    public dh(androidx.databinding.e e2, View view) {
        this(e2, view, dh.a(e2, view, 2, f, g));
    }

    private dh(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0);
        this.h = (ConstraintLayout)((Object)arrobject[0]);
        this.h.setTag(null);
        this.i = (AppCompatCheckedTextView)((Object)arrobject[1]);
        this.i.setTag(null);
        this.a(view);
        this.j = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.c;
        Settings settings = this.d;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((d)object).a(settings);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(Settings settings) {
        this.d = settings;
        synchronized (this) {
            this.k |= 1L;
        }
        this.a(7);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(d d2) {
        this.c = d2;
        synchronized (this) {
            this.k |= 4L;
        }
        this.a(11);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(boolean bl2) {
        this.e = bl2;
        synchronized (this) {
            this.k |= 2L;
        }
        this.a(10);
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
            l2 = this.k;
            this.k = 0L;
        }
        String string2 = null;
        int n2 = 0;
        Settings settings = this.d;
        boolean bl2 = this.e;
        d d2 = this.c;
        long l3 = 13L & l2 LCMP 0L;
        String string3 = string2;
        if (l3 != false) {
            if (settings != null) {
                n2 = settings.getLabel();
            }
            string3 = string2;
            if (d2 != null) {
                string3 = d2.a(n2);
            }
        }
        if ((10L & l2) != 0L) {
            this.i.setChecked(bl2);
        }
        if ((l2 & 8L) != 0L) {
            this.i.setOnClickListener(this.j);
        }
        if (l3 != false) {
            e.a((TextView)this.i, (CharSequence)string3);
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
            this.k = 8L;
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

