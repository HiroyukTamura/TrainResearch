/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.cm;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.q.h;

public class cn
extends cm
implements b.a {
    private static final SparseIntArray A = new SparseIntArray();
    private static final ViewDataBinding.b z;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private long G = -1L;

    static {
        A.put(2131230875, 5);
        A.put(2131231082, 6);
        A.put(2131231275, 7);
        A.put(2131231276, 8);
        A.put(2131231273, 9);
        A.put(2131231274, 10);
        A.put(2131230984, 11);
        A.put(2131230985, 12);
        A.put(2131230982, 13);
        A.put(2131230983, 14);
        A.put(2131231182, 15);
        A.put(2131231183, 16);
        A.put(2131231180, 17);
        A.put(2131231181, 18);
        A.put(2131231187, 19);
        A.put(2131231185, 20);
        A.put(2131231186, 21);
    }

    public cn(e e2, View view) {
        this(e2, view, cn.a(e2, view, 22, z, A));
    }

    private cn(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[5], (ConstraintLayout)((Object)arrobject[2]), (AppCompatImageView)arrobject[13], (AppCompatTextView)arrobject[14], (AppCompatTextView)arrobject[11], (AppCompatTextView)arrobject[12], (ConstraintLayout)((Object)arrobject[0]), (ConstraintLayout)((Object)arrobject[6]), (ConstraintLayout)((Object)arrobject[3]), (AppCompatImageView)arrobject[17], (AppCompatTextView)arrobject[18], (AppCompatTextView)arrobject[15], (AppCompatTextView)arrobject[16], (ConstraintLayout)((Object)arrobject[4]), (AppCompatImageView)arrobject[20], (AppCompatTextView)arrobject[21], (AppCompatTextView)arrobject[19], (ConstraintLayout)((Object)arrobject[1]), (AppCompatImageView)arrobject[9], (AppCompatTextView)arrobject[10], (AppCompatTextView)arrobject[7], (AppCompatTextView)arrobject[8]);
        this.d.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.p.setTag(null);
        this.t.setTag(null);
        this.a(view);
        this.B = new b(this, 2);
        this.C = new b(this, 4);
        this.D = new b(this, 3);
        this.E = new b(this, 5);
        this.F = new b(this, 1);
        this.c();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(int var1_1, View var2_2) {
        var4_3 = 0;
        var5_4 = 0;
        var6_5 = 0;
        var7_6 = 0;
        var3_7 = 0;
        switch (var1_1) {
            default: {
                return;
            }
            case 5: {
                var2_2 = this.y;
                var1_1 = var3_7;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                var1_1 = 4;
                ** GOTO lbl32
            }
            case 4: {
                var2_2 = this.y;
                var1_1 = var4_3;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                var1_1 = 3;
                ** GOTO lbl32
            }
            case 3: {
                var2_2 = this.y;
                var1_1 = var5_4;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                var1_1 = 2;
lbl32: // 3 sources:
                var2_2.a(var1_1);
                return;
            }
            case 2: {
                var2_2 = this.y;
                var1_1 = var6_5;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                var2_2.a(1);
                return;
            }
            case 1: 
        }
        var8_8 = this.y;
        var1_1 = var7_6;
        if (var8_8 != null) {
            var1_1 = 1;
        }
        if (var1_1 == 0) return;
        var8_8.a((View)var2_2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(h h2) {
        this.y = h2;
        synchronized (this) {
            this.G |= 1L;
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
            l2 = this.G;
            this.G = 0L;
        }
        h h2 = this.y;
        if ((l2 & 2L) != 0L) {
            this.d.setOnClickListener(this.D);
            this.i.setOnClickListener(this.F);
            this.k.setOnClickListener(this.C);
            this.p.setOnClickListener(this.E);
            this.t.setOnClickListener(this.B);
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
            this.G = 2L;
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
            return this.G != 0L;
            {
            }
        }
    }
}

