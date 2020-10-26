/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import jp.co.jreast.jreastapp.commuter.c.ak;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class al
extends ak
implements b.a {
    private static final ViewDataBinding.b k;
    private static final SparseIntArray l;
    private final View.OnClickListener m;
    private g n = new g(){

        @Override
        public void a() {
            boolean bl2 = al.this.h.isChecked();
            Object object = al.this.j;
            boolean bl3 = false;
            boolean bl4 = object != null;
            if (bl4) {
                object = ((d)object).c();
                bl4 = bl3;
                if (object != null) {
                    bl4 = true;
                }
                if (bl4) {
                    ((p)object).b(bl2);
                }
            }
        }
    };
    private long o = -1L;

    static {
        l = new SparseIntArray();
        l.put(2131230821, 4);
        l.put(2131230820, 5);
        l.put(2131230967, 6);
    }

    public al(e e2, View view) {
        this(e2, view, al.a(e2, view, 7, k, l));
    }

    private al(e e2, View view, Object[] arrobject) {
        super(e2, view, 2, (ViewPager)((Object)arrobject[5]), (TabLayout)((Object)arrobject[4]), (ConstraintLayout)((Object)arrobject[0]), (TabLayout)((Object)arrobject[6]), (LinearLayout)arrobject[1], (CheckBox)arrobject[2], (Button)arrobject[3]);
        this.e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.a(view);
        this.m = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.o |= 1L;
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
    private boolean b(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.o |= 2L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        object = this.j;
        n2 = object != null ? 1 : 0;
        if (n2 != 0) {
            ((d)object).k();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(d d2) {
        this.j = d2;
        synchronized (this) {
            this.o |= 4L;
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
                return this.b((p)object, n3);
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
        block10 : {
            block9 : {
                // MONITORENTER : this
                var5_1 = this.o;
                this.o = 0L;
                // MONITOREXIT : this
                var12_2 = this.j;
                var9_3 = false;
                if ((15L & var5_1) == 0L) break block9;
                var1_4 = var5_1 & 13L LCMP 0L;
                var7_5 = var5_1;
                if (var1_4 == false) ** GOTO lbl-1000
                var11_6 = var12_2 != null ? var12_2.d() : null;
                this.a(0, (LiveData<?>)var11_6);
                var11_6 = var11_6 != null ? (Boolean)var11_6.a() : null;
                var10_7 = ViewDataBinding.a(var11_6);
                var3_8 = var5_1;
                if (var1_4 != false) {
                    var3_8 = var10_7 != false ? 32L : 16L;
                    var3_8 = var5_1 | var3_8;
                }
                var7_5 = var3_8;
                if (var10_7) {
                    var1_4 = 8;
                } else lbl-1000: // 2 sources:
                {
                    var1_4 = 0;
                    var3_8 = var7_5;
                }
                var5_1 = var3_8;
                var2_9 = (int)var1_4;
                if ((var3_8 & 14L) != 0L) {
                    var11_6 = var12_2 != null ? var12_2.c() : null;
                    this.a(1, (LiveData<?>)var11_6);
                    var11_6 = var11_6 != null ? (Boolean)var11_6.a() : null;
                    var9_3 = ViewDataBinding.a(var11_6);
                    var5_1 = var3_8;
                    var2_9 = (int)var1_4;
                }
                break block10;
            }
            var2_9 = 0;
        }
        if ((13L & var5_1) != 0L) {
            this.g.setVisibility(var2_9);
        }
        if ((var5_1 & 14L) != 0L) {
            a.a((CompoundButton)this.h, var9_3);
        }
        if ((var5_1 & 8L) == 0L) return;
        a.a((CompoundButton)this.h, null, this.n);
        this.i.setOnClickListener(this.m);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.o = 8L;
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
            return this.o != 0L;
            {
            }
        }
    }

}

