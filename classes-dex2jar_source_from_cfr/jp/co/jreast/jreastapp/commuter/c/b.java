/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.a;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.Acknowledgement;

public class b
extends a
implements b.a {
    private static final ViewDataBinding.b m;
    private static final SparseIntArray n;
    private final ConstraintLayout o;
    private final View.OnClickListener p;
    private long q = -1L;

    static {
        n = new SparseIntArray();
        n.put(2131230774, 7);
        n.put(2131230775, 8);
        n.put(2131230776, 9);
    }

    public b(androidx.databinding.e e2, View view) {
        this(e2, view, b.a(e2, view, 10, m, n));
    }

    private b(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 2, (TextView)arrobject[4], (View)arrobject[7], (View)arrobject[8], (View)arrobject[9], (AppCompatImageView)arrobject[2], (TextView)arrobject[5], (ProgressBar)arrobject[6], (TextView)arrobject[3], (AppCompatTextView)arrobject[1]);
        this.c.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.o = (ConstraintLayout)((Object)arrobject[0]);
        this.o.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.a(view);
        this.p = new jp.co.jreast.jreastapp.commuter.h.a.b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(LiveData<Acknowledgement> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.q |= 2L;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.q |= 1L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        object = this.l;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((jp.co.jreast.jreastapp.commuter.acknowledgement.b)object).e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(jp.co.jreast.jreastapp.commuter.acknowledgement.b b2) {
        this.l = b2;
        synchronized (this) {
            this.q |= 4L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        switch (n2) {
            default: {
                return false;
            }
            case 1: {
                return this.a((LiveData)object, n3);
            }
            case 0: 
        }
        return this.a((p)object, n3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    protected void b() {
        // MONITORENTER : this
        var6_1 = this.q;
        this.q = 0L;
        // MONITOREXIT : this
        var12_2 = this.l;
        var2_3 = 0;
        var3_4 = 0;
        var15_5 = null;
        var8_6 = var6_1;
        if ((15L & var6_1) == 0L) ** GOTO lbl-1000
        var2_3 = var6_1 & 13L LCMP 0L;
        var4_7 = var6_1;
        var1_8 = var3_4;
        if (var2_3 != 0) {
            var11_9 = var12_2 != null ? var12_2.c() : null;
            this.a(0, (LiveData<?>)var11_9);
            var11_9 = var11_9 != null ? (Boolean)var11_9.a() : null;
            var10_10 = ViewDataBinding.a((Boolean)var11_9);
            var4_7 = var6_1;
            if (var2_3 != 0) {
                var4_7 = var10_10 != false ? 32L : 16L;
                var4_7 = var6_1 | var4_7;
            }
            var1_8 = var10_10 != false ? var3_4 : 8;
        }
        var8_6 = var4_7;
        var2_3 = var1_8;
        if ((var4_7 & 14L) == 0L) ** GOTO lbl-1000
        var11_9 = var12_2 != null ? var12_2.b() : null;
        this.a(1, (LiveData<?>)var11_9);
        var11_9 = var11_9 != null ? var11_9.a() : null;
        var8_6 = var4_7;
        var2_3 = var1_8;
        if (var11_9 != null) {
            var12_2 = var11_9.getMessage();
            var13_11 = var11_9.getCreditToEkitan();
            var15_5 = var11_9.getApprovalNumber();
            var14_12 = var11_9.getTitle();
            var15_5 = var11_9 = var15_5;
        } else lbl-1000: // 3 sources:
        {
            var14_12 = var11_9 = (var12_2 = null);
            var1_8 = var2_3;
            var13_11 = var11_9;
            var4_7 = var8_6;
        }
        if ((14L & var4_7) != 0L) {
            e.a(this.c, var15_5);
            e.a(this.h, (CharSequence)var13_11);
            e.a(this.j, (CharSequence)var12_2);
            e.a(this.k, (CharSequence)var14_12);
        }
        if ((8L & var4_7) != 0L) {
            this.g.setOnClickListener(this.p);
        }
        if ((var4_7 & 13L) == 0L) return;
        this.i.setVisibility(var1_8);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.q = 8L;
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
            return this.q != 0L;
            {
            }
        }
    }
}

