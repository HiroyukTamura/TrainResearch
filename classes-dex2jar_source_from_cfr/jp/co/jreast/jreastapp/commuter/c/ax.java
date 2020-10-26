/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.aw;
import jp.co.jreast.jreastapp.commuter.commuterpager.b.c;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class ax
extends aw
implements b.a {
    private static final ViewDataBinding.b u;
    private static final SparseIntArray v;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private long G = -1L;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        v = new SparseIntArray();
        v.put(2131231017, 13);
        v.put(2131230945, 14);
        v.put(2131231314, 15);
        v.put(2131231270, 16);
    }

    public ax(e e2, View view) {
        this(e2, view, ax.a(e2, view, 17, u, v));
    }

    private ax(e e2, View view, Object[] arrobject) {
        super(e2, view, 13, (TextView)arrobject[7], (Button)arrobject[12], (TextView)arrobject[9], (LinearLayout)arrobject[8], (TextView)arrobject[10], (TextView)arrobject[1], (FrameLayout)arrobject[0], (TextView)arrobject[14], (ConstraintLayout)((Object)arrobject[13]), (Button)arrobject[11], (TextView)arrobject[16], (AppCompatImageView)arrobject[3], (AppCompatImageView)arrobject[5], (Button)arrobject[6], (ConstraintLayout)((Object)arrobject[15]), (Button)arrobject[2], (Button)arrobject[4]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.l.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.a(view);
        this.w = new b(this, 1);
        this.x = new b(this, 5);
        this.y = new b(this, 4);
        this.z = new b(this, 6);
        this.A = new b(this, 2);
        this.B = new b(this, 3);
        this.C = new b(this, 9);
        this.D = new b(this, 10);
        this.E = new b(this, 7);
        this.F = new b(this, 8);
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
                this.G |= 1L;
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
                this.G |= 2L;
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
    private boolean c(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 4L;
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
    private boolean d(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 8L;
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
                this.G |= 16L;
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
    private boolean f(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 32L;
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
    private boolean g(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 64L;
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
    private boolean h(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 128L;
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
                this.G |= 256L;
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
    private boolean j(p<Integer> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 512L;
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
    private boolean k(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 1024L;
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
    private boolean l(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 2048L;
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
    private boolean m(p<Boolean> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.G |= 4096L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 1;
        switch (n2) {
            default: {
                return;
            }
            case 10: {
                object = this.t;
                n2 = n11;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).x();
                return;
            }
            case 9: {
                object = this.t;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).w();
                return;
            }
            case 8: {
                object = this.t;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).v();
                return;
            }
            case 7: {
                object = this.t;
                n2 = n5;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).u();
                return;
            }
            case 6: {
                object = this.t;
                n2 = n6;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).y();
                return;
            }
            case 5: {
                object = this.t;
                n2 = n7;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).a(1);
                return;
            }
            case 4: {
                object = this.t;
                n2 = n8;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).A();
                return;
            }
            case 3: {
                object = this.t;
                n2 = object != null ? n12 : 0;
                if (n2 == 0) break;
                ((c)object).a(0);
                return;
            }
            case 2: {
                object = this.t;
                n2 = n9;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).z();
                return;
            }
            case 1: {
                object = this.t;
                n2 = n10;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((c)object).t();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c c2) {
        this.t = c2;
        synchronized (this) {
            this.G |= 8192L;
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
            case 12: {
                return this.m((p)object, n3);
            }
            case 11: {
                return this.l((p)object, n3);
            }
            case 10: {
                return this.k((p)object, n3);
            }
            case 9: {
                return this.j((p)object, n3);
            }
            case 8: {
                return this.i((p)object, n3);
            }
            case 7: {
                return this.h((p)object, n3);
            }
            case 6: {
                return this.g((p)object, n3);
            }
            case 5: {
                return this.f((p)object, n3);
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
        block46 : {
            block45 : {
                // MONITORENTER : this
                var10_1 = this.G;
                this.G = 0L;
                // MONITOREXIT : this
                var22_2 = this.t;
                if ((32767L & var10_1) == 0L) break block45;
                if ((var10_1 & 24577L) == 0L) ** GOTO lbl-1000
                var15_3 = var22_2 != null ? var22_2.c() : null;
                this.a(0, var15_3);
                if (var15_3 != null) {
                    var15_3 = (String)var15_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var15_3 = null;
                }
                if ((var10_1 & 24578L) != 0L) {
                    var16_4 = var22_2 != null ? var22_2.j() : null;
                    this.a(1, var16_4);
                    var16_4 = var16_4 != null ? (Integer)var16_4.a() : null;
                    var2_5 = ViewDataBinding.a(var16_4);
                } else {
                    var2_5 = 0;
                }
                if ((var10_1 & 24580L) == 0L) ** GOTO lbl-1000
                var16_4 = var22_2 != null ? var22_2.d() : null;
                this.a(2, var16_4);
                if (var16_4 != null) {
                    var16_4 = (String)var16_4.a();
                } else lbl-1000: // 2 sources:
                {
                    var16_4 = null;
                }
                if ((var10_1 & 24584L) == 0L) ** GOTO lbl-1000
                var17_6 = var22_2 != null ? var22_2.b() : null;
                this.a(3, var17_6);
                if (var17_6 != null) {
                    var17_6 = (String)var17_6.a();
                } else lbl-1000: // 2 sources:
                {
                    var17_6 = null;
                }
                if ((var10_1 & 24592L) != 0L) {
                    var18_7 = var22_2 != null ? var22_2.g() : null;
                    this.a(4, var18_7);
                    var18_7 = var18_7 != null ? (Boolean)var18_7.a() : null;
                    var12_8 = ViewDataBinding.a(var18_7);
                } else {
                    var12_8 = false;
                }
                if ((var10_1 & 24608L) == 0L) ** GOTO lbl-1000
                var18_7 = var22_2 != null ? var22_2.l() : null;
                this.a(5, var18_7);
                if (var18_7 != null) {
                    var18_7 = (String)var18_7.a();
                } else lbl-1000: // 2 sources:
                {
                    var18_7 = null;
                }
                if ((var10_1 & 24640L) == 0L) ** GOTO lbl-1000
                var19_9 = var22_2 != null ? var22_2.i() : null;
                this.a(6, var19_9);
                if (var19_9 != null) {
                    var19_9 = (String)var19_9.a();
                } else lbl-1000: // 2 sources:
                {
                    var19_9 = null;
                }
                if ((var10_1 & 24704L) == 0L) ** GOTO lbl-1000
                var20_10 = var22_2 != null ? var22_2.e() : null;
                this.a(7, var20_10);
                if (var20_10 != null) {
                    var20_10 = (String)var20_10.a();
                } else lbl-1000: // 2 sources:
                {
                    var20_10 = null;
                }
                var1_11 = var10_1 & 24832L LCMP 0L;
                var8_12 = var10_1;
                if (var1_11 == 0) ** GOTO lbl-1000
                var21_13 = var22_2 != null ? var22_2.k() : null;
                this.a(8, (LiveData<?>)var21_13);
                var21_13 = var21_13 != null ? (Boolean)var21_13.a() : null;
                var13_14 = ViewDataBinding.a(var21_13);
                var8_12 = var10_1;
                if (var1_11 != 0) {
                    var8_12 = var13_14 != false ? 65536L : 32768L;
                    var8_12 = var10_1 | var8_12;
                }
                if (!var13_14) {
                    var4_15 = 8;
                } else lbl-1000: // 2 sources:
                {
                    var4_15 = 0;
                }
                if ((var8_12 & 25088L) != 0L) {
                    var21_13 = var22_2 != null ? var22_2.m() : null;
                    this.a(9, (LiveData<?>)var21_13);
                    var21_13 = var21_13 != null ? (Integer)var21_13.a() : null;
                    var3_16 = ViewDataBinding.a(var21_13);
                } else {
                    var3_16 = 0;
                }
                if ((var8_12 & 25600L) != 0L) {
                    var21_13 = var22_2 != null ? var22_2.f() : null;
                    this.a(10, (LiveData<?>)var21_13);
                    var21_13 = var21_13 != null ? (Boolean)var21_13.a() : null;
                    var13_14 = ViewDataBinding.a((Boolean)var21_13);
                } else {
                    var13_14 = false;
                }
                var1_11 = (int)(var8_12 & 26624L LCMP 0L);
                if (var1_11 == 0) ** GOTO lbl107
                var21_13 = var22_2 != null ? var22_2.n() : null;
                this.a(11, (LiveData<?>)var21_13);
                var21_13 = var21_13 != null ? (Boolean)var21_13.a() : null;
                var14_17 = ViewDataBinding.a(var21_13);
                var10_1 = var8_12;
                if (var1_11 != 0) {
                    var10_1 = var14_17 != false ? 262144L : 131072L;
                    var10_1 = var8_12 | var10_1;
                }
                if (!var14_17) {
                    var1_11 = 8;
                    var8_12 = var10_1;
                } else {
                    var8_12 = var10_1;
lbl107: // 2 sources:
                    var1_11 = 0;
                }
                var5_18 = (int)(var8_12 & 28672L LCMP 0L);
                if (var5_18 != 0) {
                    var21_13 = var22_2 != null ? var22_2.h() : null;
                    this.a(12, (LiveData<?>)var21_13);
                    var21_13 = var21_13 != null ? (Boolean)var21_13.a() : null;
                    var14_17 = ViewDataBinding.a(var21_13);
                    var10_1 = var8_12;
                    if (var5_18 != 0) {
                        var10_1 = var14_17 != false ? 0x100000L : 524288L;
                        var10_1 = var8_12 | var10_1;
                    }
                    var5_18 = var14_17 != false ? 0 : 8;
                    var6_19 = var1_11;
                    var1_11 = var5_18;
                    var7_21 = var3_16;
                    var8_12 = var10_1;
                    var3_16 = var4_15;
                    var4_15 = var6_19;
                    var5_18 = var2_5;
                    var2_5 = var7_21;
                } else {
                    var5_18 = var1_11;
                    var6_20 = var3_16;
                    var1_11 = 0;
                    var3_16 = var4_15;
                    var4_15 = var5_18;
                    var5_18 = var2_5;
                    var2_5 = var6_20;
                }
                break block46;
            }
            var1_11 = 0;
            var3_16 = 0;
            var4_15 = 0;
            var15_3 = null;
            var17_6 = null;
            var18_7 = null;
            var19_9 = null;
            var5_18 = 0;
            var16_4 = null;
            var12_8 = false;
            var20_10 = null;
            var13_14 = false;
            var2_5 = 0;
            var8_12 = var10_1;
        }
        if ((var8_12 & 16384L) != 0L) {
            this.c.setOnClickListener(this.E);
            this.d.setOnClickListener(this.D);
            this.f.setOnClickListener(this.F);
            this.h.setOnClickListener(this.w);
            this.l.setOnClickListener(this.C);
            this.n.setOnClickListener(this.B);
            this.o.setOnClickListener(this.x);
            this.p.setOnClickListener(this.z);
            this.r.setOnClickListener(this.A);
            this.s.setOnClickListener(this.y);
        }
        if ((var8_12 & 24577L) != 0L) {
            androidx.databinding.a.e.a(this.c, (CharSequence)var15_3);
        }
        if ((var8_12 & 24592L) != 0L) {
            this.d.setEnabled(var12_8);
        }
        if ((var8_12 & 24580L) != 0L) {
            androidx.databinding.a.e.a(this.e, (CharSequence)var16_4);
        }
        if ((var8_12 & 24704L) != 0L) {
            androidx.databinding.a.e.a(this.g, var20_10);
        }
        if ((var8_12 & 24584L) != 0L) {
            androidx.databinding.a.e.a(this.h, (CharSequence)var17_6);
        }
        if ((25600L & var8_12) != 0L) {
            this.l.setEnabled(var13_14);
            this.p.setEnabled(var13_14);
        }
        if ((28672L & var8_12) != 0L) {
            this.n.setVisibility(var1_11);
            this.r.setVisibility(var1_11);
        }
        if ((24832L & var8_12) != 0L) {
            this.o.setVisibility(var3_16);
            this.s.setVisibility(var3_16);
        }
        if ((26624L & var8_12) != 0L) {
            this.p.setVisibility(var4_15);
        }
        if ((24640L & var8_12) != 0L) {
            androidx.databinding.a.e.a((TextView)this.r, (CharSequence)var19_9);
        }
        if ((var8_12 & 24578L) != 0L) {
            this.r.setTextColor(var5_18);
        }
        if ((var8_12 & 24608L) != 0L) {
            androidx.databinding.a.e.a((TextView)this.s, (CharSequence)var18_7);
        }
        if ((var8_12 & 25088L) == 0L) return;
        this.s.setTextColor(var2_5);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.G = 16384L;
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

