/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.DatePicker
 *  android.widget.DatePicker$OnDateChangedListener
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.Space
 *  android.widget.TimePicker
 *  android.widget.TimePicker$OnTimeChangedListener
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Space;
import android.widget.TimePicker;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.a;
import androidx.databinding.a.f;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.w;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.h.a.c;
import jp.co.jreast.jreastapp.commuter.h.a.e;

public class x
extends w
implements b.a,
c.a,
e.a {
    private static final ViewDataBinding.b o;
    private static final SparseIntArray p;
    private long A = -1L;
    private final ConstraintLayout q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final DatePicker.OnDateChangedListener u;
    private final TimePicker.OnTimeChangedListener v;
    private g w = new g(){

        @Override
        public void a() {
            boolean bl2 = x.this.i.isChecked();
            Object object = x.this.n;
            boolean bl3 = false;
            boolean bl4 = object != null;
            if (bl4) {
                object = ((jp.co.jreast.jreastapp.commuter.timeselect.b)object).d();
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
    private g x = new g(){

        @Override
        public void a() {
            boolean bl2 = x.this.j.isChecked();
            Object object = x.this.n;
            boolean bl3 = false;
            boolean bl4 = object != null;
            if (bl4) {
                object = ((jp.co.jreast.jreastapp.commuter.timeselect.b)object).e();
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
    private g y = new g(){

        @Override
        public void a() {
            boolean bl2 = x.this.k.isChecked();
            Object object = x.this.n;
            boolean bl3 = false;
            boolean bl4 = object != null;
            if (bl4) {
                object = ((jp.co.jreast.jreastapp.commuter.timeselect.b)object).b();
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
    private g z = new g(){

        @Override
        public void a() {
            boolean bl2 = x.this.l.isChecked();
            Object object = x.this.n;
            boolean bl3 = false;
            boolean bl4 = object != null;
            if (bl4) {
                object = ((jp.co.jreast.jreastapp.commuter.timeselect.b)object).c();
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

    static {
        p = new SparseIntArray();
        p.put(2131230868, 10);
        p.put(2131230838, 11);
    }

    public x(e e2, View view) {
        this(e2, view, x.a(e2, view, 12, o, p));
    }

    private x(e e2, View view, Object[] arrobject) {
        super(e2, view, 10, (AppCompatImageView)arrobject[1], (Button)arrobject[8], (DatePicker)arrobject[6], (Space)arrobject[11], (Button)arrobject[9], (RadioGroup)arrobject[10], (RadioButton)arrobject[4], (RadioButton)arrobject[5], (RadioButton)arrobject[2], (RadioButton)arrobject[3], (TimePicker)arrobject[7]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.q = (ConstraintLayout)((Object)arrobject[0]);
        this.q.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.a(view);
        this.r = new b(this, 1);
        this.s = new b(this, 4);
        this.t = new b(this, 5);
        this.u = new c(this, 2);
        this.v = new jp.co.jreast.jreastapp.commuter.h.a.e(this, 3);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(n<Integer> n2, int n3) {
        if (n3 == 0) {
            synchronized (this) {
                this.A |= 2L;
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
    private boolean a(p<Integer> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 1L;
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
    private boolean b(p<Integer> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 4L;
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
    private boolean c(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 8L;
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
    private boolean d(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 16L;
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
    private boolean e(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 32L;
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
    private boolean f(p<Integer> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 64L;
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
    private boolean g(p<Integer> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 128L;
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
    private boolean h(p<Integer> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 256L;
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
    private boolean i(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.A |= 512L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        block11 : {
            int n3;
            block10 : {
                int n4 = 0;
                n3 = 0;
                int n5 = 0;
                if (n2 == 1) break block10;
                switch (n2) {
                    default: {
                        return;
                    }
                    case 5: {
                        jp.co.jreast.jreastapp.commuter.timeselect.b b2 = this.n;
                        n2 = n5;
                        if (b2 != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            b2.b((View)object);
                            return;
                        }
                        break block11;
                    }
                    case 4: {
                        object = this.n;
                        n2 = n4;
                        if (object != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            ((jp.co.jreast.jreastapp.commuter.timeselect.b)object).o();
                            return;
                        }
                        break block11;
                    }
                }
            }
            object = this.n;
            n2 = n3;
            if (object != null) {
                n2 = 1;
            }
            if (n2 != 0) {
                ((jp.co.jreast.jreastapp.commuter.timeselect.b)object).n();
            }
        }
    }

    @Override
    public final void a(int n2, DatePicker datePicker, int n3, int n4, int n5) {
        jp.co.jreast.jreastapp.commuter.timeselect.b b2 = this.n;
        n2 = b2 != null ? 1 : 0;
        if (n2 != 0) {
            b2.a((View)datePicker);
        }
    }

    @Override
    public final void a(int n2, TimePicker timePicker, int n3, int n4) {
        jp.co.jreast.jreastapp.commuter.timeselect.b b2 = this.n;
        n2 = b2 != null ? 1 : 0;
        if (n2 != 0) {
            b2.a((View)timePicker);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(jp.co.jreast.jreastapp.commuter.timeselect.b b2) {
        this.n = b2;
        synchronized (this) {
            this.A |= 1024L;
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
            case 9: {
                return this.i((p)object, n3);
            }
            case 8: {
                return this.h((p)object, n3);
            }
            case 7: {
                return this.g((p)object, n3);
            }
            case 6: {
                return this.f((p)object, n3);
            }
            case 5: {
                return this.e((p)object, n3);
            }
            case 4: {
                return this.d((p)object, n3);
            }
            case 3: {
                return this.c((p)object, n3);
            }
            case 2: {
                return this.b((p)object, n3);
            }
            case 1: {
                return this.a((n)object, n3);
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
        block30 : {
            block29 : {
                // MONITORENTER : this
                var6_1 = this.A;
                this.A = 0L;
                // MONITOREXIT : this
                var15_2 = this.n;
                if ((4095L & var6_1) == 0L) break block29;
                if ((var6_1 & 3265L) != 0L) {
                    if (var15_2 != null) {
                        var13_3 = var15_2.i();
                        var14_4 = var15_2.h();
                        var12_5 = var15_2.g();
                    } else {
                        var13_3 = null;
                        var14_4 = null;
                        var12_5 = null;
                    }
                    this.a(0, var13_3);
                    this.a(6, (LiveData<?>)var14_4);
                    this.a(7, var12_5);
                    var13_3 = var13_3 != null ? (Integer)var13_3.a() : null;
                    var14_4 = var14_4 != null ? (Integer)var14_4.a() : null;
                    var12_5 = var12_5 != null ? (Integer)var12_5.a() : null;
                    var1_6 = ViewDataBinding.a(var13_3);
                    var2_7 = ViewDataBinding.a((Integer)var14_4);
                    var3_8 = ViewDataBinding.a((Integer)var12_5);
                } else {
                    var3_8 = 0;
                    var2_7 = 0;
                    var1_6 = 0;
                }
                if ((var6_1 & 3074L) != 0L) {
                    var12_5 = var15_2 != null ? var15_2.f() : null;
                    this.a(1, var12_5);
                    var12_5 = var12_5 != null ? (Integer)var12_5.a() : null;
                    var4_9 = ViewDataBinding.a(var12_5);
                } else {
                    var4_9 = 0;
                }
                if ((var6_1 & 3076L) == 0L) ** GOTO lbl-1000
                var12_5 = var15_2 != null ? var15_2.k() : null;
                this.a(2, var12_5);
                if (var12_5 != null) {
                    var12_5 = (Integer)var12_5.a();
                } else lbl-1000: // 2 sources:
                {
                    var12_5 = null;
                }
                if ((var6_1 & 3080L) != 0L) {
                    var13_3 = var15_2 != null ? var15_2.b() : null;
                    this.a(3, var13_3);
                    var13_3 = var13_3 != null ? (Boolean)var13_3.a() : null;
                    var8_10 = ViewDataBinding.a(var13_3);
                } else {
                    var8_10 = false;
                }
                if ((var6_1 & 3088L) != 0L) {
                    var13_3 = var15_2 != null ? var15_2.d() : null;
                    this.a(4, var13_3);
                    var13_3 = var13_3 != null ? (Boolean)var13_3.a() : null;
                    var9_11 = ViewDataBinding.a(var13_3);
                } else {
                    var9_11 = false;
                }
                if ((var6_1 & 3104L) != 0L) {
                    var13_3 = var15_2 != null ? var15_2.e() : null;
                    this.a(5, var13_3);
                    var13_3 = var13_3 != null ? (Boolean)var13_3.a() : null;
                    var10_12 = ViewDataBinding.a(var13_3);
                } else {
                    var10_12 = false;
                }
                if ((var6_1 & 3328L) == 0L) ** GOTO lbl-1000
                var13_3 = var15_2 != null ? var15_2.j() : null;
                this.a(8, var13_3);
                if (var13_3 != null) {
                    var13_3 = (Integer)var13_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var13_3 = null;
                }
                if ((var6_1 & 3584L) != 0L) {
                    var14_4 = var15_2 != null ? var15_2.c() : null;
                    this.a(9, (LiveData<?>)var14_4);
                    var14_4 = var14_4 != null ? (Boolean)var14_4.a() : null;
                    var11_13 = ViewDataBinding.a((Boolean)var14_4);
                    var5_14 = var1_6;
                    var1_6 = var3_8;
                    var3_8 = var5_14;
                } else {
                    var5_15 = var1_6;
                    var11_13 = false;
                    var1_6 = var3_8;
                    var3_8 = var5_15;
                }
                break block30;
            }
            var11_13 = false;
            var4_9 = 0;
            var8_10 = false;
            var12_5 = null;
            var10_12 = false;
            var13_3 = null;
            var9_11 = false;
            var1_6 = 0;
            var2_7 = 0;
            var3_8 = 0;
        }
        if ((2048L & var6_1) != 0L) {
            this.c.setOnClickListener(this.r);
            this.d.setOnClickListener(this.s);
            this.g.setOnClickListener(this.t);
            var14_4 = this.i;
            var15_2 = null;
            a.a((CompoundButton)var14_4, (CompoundButton.OnCheckedChangeListener)var15_2, this.w);
            a.a((CompoundButton)this.j, (CompoundButton.OnCheckedChangeListener)var15_2, this.x);
            a.a((CompoundButton)this.k, (CompoundButton.OnCheckedChangeListener)var15_2, this.y);
            a.a((CompoundButton)this.l, (CompoundButton.OnCheckedChangeListener)var15_2, this.z);
            var14_4 = this.m;
            var15_2 = this.v;
            var16_16 = null;
            f.a((TimePicker)var14_4, (TimePicker.OnTimeChangedListener)var15_2, var16_16, var16_16);
        }
        if ((var6_1 & 3265L) != 0L) {
            var14_4 = this.e;
            var15_2 = this.u;
            var16_16 = null;
            androidx.databinding.a.b.a((DatePicker)var14_4, var1_6, var2_7, var3_8, (DatePicker.OnDateChangedListener)var15_2, var16_16, var16_16, var16_16);
        }
        if ((var6_1 & 3088L) != 0L) {
            a.a((CompoundButton)this.i, var9_11);
        }
        if ((3104L & var6_1) != 0L) {
            a.a((CompoundButton)this.j, var10_12);
        }
        if ((3080L & var6_1) != 0L) {
            a.a((CompoundButton)this.k, var8_10);
        }
        if ((3584L & var6_1) != 0L) {
            a.a((CompoundButton)this.l, var11_13);
        }
        if ((3328L & var6_1) != 0L) {
            this.m.setCurrentHour((Integer)var13_3);
        }
        if ((var6_1 & 3076L) != 0L) {
            this.m.setCurrentMinute((Integer)var12_5);
        }
        if ((var6_1 & 3074L) == 0L) return;
        this.m.setVisibility(var4_9);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.A = 2048L;
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
            return this.A != 0L;
            {
            }
        }
    }

}

