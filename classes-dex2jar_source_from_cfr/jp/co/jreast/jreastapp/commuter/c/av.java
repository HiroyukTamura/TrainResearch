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
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.au;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.n.k;

public class av
extends au
implements b.a {
    private static final ViewDataBinding.b w;
    private static final SparseIntArray x;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private g E = new g(){

        @Override
        public void a() {
            boolean bl2 = av.this.k.isChecked();
            Object object = av.this.v;
            boolean bl3 = false;
            boolean bl4 = object != null;
            if (bl4) {
                object = ((k)object).m();
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
    private long F = -1L;
    private final View y;
    private final View.OnClickListener z;

    static {
        x = new SparseIntArray();
        x.put(2131231277, 8);
        x.put(2131231264, 9);
        x.put(2131230885, 10);
        x.put(2131231257, 11);
        x.put(2131231255, 12);
        x.put(2131231222, 13);
        x.put(2131230877, 14);
        x.put(2131231115, 15);
        x.put(2131230936, 16);
        x.put(2131230760, 17);
        x.put(2131230914, 18);
        x.put(2131230827, 19);
    }

    public av(e e2, View view) {
        this(e2, view, av.a(e2, view, 20, w, x));
    }

    private av(e e2, View view, Object[] arrobject) {
        super(e2, view, 5, (AppCompatImageView)arrobject[17], (AppCompatImageButton)arrobject[1], (AppCompatImageButton)arrobject[2], (CoordinatorLayout)arrobject[19], (FrameLayout)arrobject[14], (AppCompatImageView)arrobject[10], (ImageView)arrobject[18], (AppCompatImageButton)arrobject[16], (CheckBox)arrobject[6], (Button)arrobject[7], (Button)arrobject[3], (ConstraintLayout)((Object)arrobject[0]), (RecyclerView)arrobject[15], (ConstraintLayout)((Object)arrobject[4]), (TextView)arrobject[13], (TextView)arrobject[12], (TextView)arrobject[11], (ConstraintLayout)((Object)arrobject[9]), (Toolbar)((Object)arrobject[8]));
        this.d.setTag(null);
        this.e.setTag(null);
        this.y = (View)arrobject[5];
        this.y.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.p.setTag(null);
        this.a(view);
        this.z = new b(this, 4);
        this.A = new b(this, 5);
        this.B = new b(this, 2);
        this.C = new b(this, 3);
        this.D = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.F |= 1L;
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
                this.F |= 2L;
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
                this.F |= 4L;
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
                this.F |= 8L;
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
                this.F |= 16L;
                return true;
            }
        }
        return false;
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
                var2_2 = this.v;
                var1_1 = var3_7;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                ** GOTO lbl22
            }
            case 4: {
                var2_2 = this.v;
                var1_1 = var4_3;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
lbl22: // 2 sources:
                var2_2.z();
                return;
            }
            case 3: {
                var2_2 = this.v;
                var1_1 = var5_4;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                var2_2.t();
                return;
            }
            case 2: {
                var2_2 = this.v;
                var1_1 = var6_5;
                if (var2_2 != null) {
                    var1_1 = 1;
                }
                if (var1_1 == 0) return;
                var2_2.y();
                return;
            }
            case 1: 
        }
        var2_2 = this.v;
        var1_1 = var7_6;
        if (var2_2 != null) {
            var1_1 = 1;
        }
        if (var1_1 == 0) return;
        var2_2.x();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(k k2) {
        this.v = k2;
        synchronized (this) {
            this.F |= 32L;
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
            case 4: {
                return this.e((p)object, n3);
            }
            case 3: {
                return this.d((p)object, n3);
            }
            case 2: {
                return this.c((p)object, n3);
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
        block21 : {
            block20 : {
                // MONITORENTER : this
                var5_1 = this.F;
                this.F = 0L;
                // MONITOREXIT : this
                var14_2 = this.v;
                if ((127L & var5_1) == 0L) break block20;
                if ((var5_1 & 97L) == 0L) ** GOTO lbl-1000
                var12_3 = var14_2 != null ? var14_2.f() : null;
                this.a(0, var12_3);
                if (var12_3 != null) {
                    var12_3 = (String)var12_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var12_3 = null;
                }
                if ((var5_1 & 98L) != 0L) {
                    var13_4 = var14_2 != null ? var14_2.m() : null;
                    this.a(1, (LiveData<?>)var13_4);
                    var13_4 = var13_4 != null ? (Boolean)var13_4.a() : null;
                    var9_5 = ViewDataBinding.a(var13_4);
                } else {
                    var9_5 = false;
                }
                var1_6 = var5_1 & 100L LCMP 0L;
                var7_7 = var5_1;
                if (var1_6 == 0) ** GOTO lbl-1000
                var13_4 = var14_2 != null ? var14_2.l() : null;
                this.a(2, (LiveData<?>)var13_4);
                var13_4 = var13_4 != null ? (Boolean)var13_4.a() : null;
                var10_8 = ViewDataBinding.a(var13_4);
                var3_9 = var5_1;
                if (var1_6 != 0) {
                    var3_9 = var10_8 != false ? 1024L : 512L;
                    var3_9 = var5_1 | var3_9;
                }
                var7_7 = var3_9;
                if (var10_8) {
                    var1_6 = 8;
                } else lbl-1000: // 2 sources:
                {
                    var1_6 = 0;
                    var3_9 = var7_7;
                }
                if ((var3_9 & 104L) != 0L) {
                    var13_4 = var14_2 != null ? var14_2.e() : null;
                    this.a(3, (LiveData<?>)var13_4);
                    var13_4 = var13_4 != null ? (Boolean)var13_4.a() : null;
                    var10_8 = ViewDataBinding.a(var13_4);
                } else {
                    var10_8 = false;
                }
                var2_10 = var3_9 & 112L LCMP 0L;
                if (var2_10 != 0) {
                    var13_4 = var14_2 != null ? var14_2.g() : null;
                    this.a(4, (LiveData<?>)var13_4);
                    var13_4 = var13_4 != null ? (Boolean)var13_4.a() : null;
                    var11_11 = ViewDataBinding.a(var13_4);
                    var5_1 = var3_9;
                    if (var2_10 != 0) {
                        var5_1 = var11_11 != false ? 256L : 128L;
                        var5_1 = var3_9 | var5_1;
                    }
                    var2_10 = var11_11 != false ? 0 : 8;
                    var3_9 = var5_1;
                } else {
                    var2_10 = 0;
                }
                break block21;
            }
            var12_3 = null;
            var2_10 = 0;
            var1_6 = 0;
            var9_5 = false;
            var10_8 = false;
            var3_9 = var5_1;
        }
        if ((64L & var3_9) != 0L) {
            this.d.setOnClickListener(this.D);
            this.e.setOnClickListener(this.B);
            this.y.setOnClickListener(this.z);
            a.a((CompoundButton)this.k, null, this.E);
            this.l.setOnClickListener(this.A);
            this.m.setOnClickListener(this.C);
        }
        if ((var3_9 & 98L) != 0L) {
            a.a((CompoundButton)this.k, var9_5);
        }
        if ((104L & var3_9) != 0L) {
            this.m.setEnabled(var10_8);
        }
        if ((var3_9 & 97L) != 0L) {
            androidx.databinding.a.e.a((TextView)this.m, (CharSequence)var12_3);
        }
        if ((112L & var3_9) != 0L) {
            this.m.setVisibility(var2_10);
        }
        if ((var3_9 & 100L) == 0L) return;
        this.p.setVisibility(var1_6);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.F = 64L;
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
            return this.F != 0L;
            {
            }
        }
    }

}

