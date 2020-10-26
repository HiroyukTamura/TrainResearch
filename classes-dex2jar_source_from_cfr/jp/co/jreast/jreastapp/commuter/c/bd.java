/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.bc;
import jp.co.jreast.jreastapp.commuter.common.view.LockableScrollView;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;

public class bd
extends bc
implements b.a {
    private static final ViewDataBinding.b r;
    private static final SparseIntArray s;
    private final ConstraintLayout t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private long w = -1L;

    static {
        s = new SparseIntArray();
        s.put(2131231117, 10);
        s.put(2131231096, 11);
        s.put(2131230906, 12);
        s.put(2131231042, 13);
        s.put(2131230967, 14);
    }

    public bd(e e2, View view) {
        this(e2, view, bd.a(e2, view, 15, r, s));
    }

    private bd(e e2, View view, Object[] arrobject) {
        super(e2, view, 11, (LinearLayout)arrobject[2], (AppCompatImageView)arrobject[12], (LinearLayout)arrobject[4], (ProgressBar)arrobject[14], (LinearLayout)arrobject[5], (Button)arrobject[7], (AppCompatImageView)arrobject[13], (Button)arrobject[6], (RecyclerView)arrobject[11], (LinearLayout)arrobject[10], (LockableScrollView)((Object)arrobject[1]), (TextView)arrobject[9], (TextView)arrobject[3], (ConstraintLayout)((Object)arrobject[0]));
        this.c.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.t = (ConstraintLayout)((Object)arrobject[8]);
        this.t.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.a(view);
        this.u = new b(this, 2);
        this.v = new b(this, 1);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 1L;
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
    private boolean b(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 2L;
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
    private boolean c(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 4L;
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
    private boolean d(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 8L;
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
    private boolean e(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 16L;
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
    private boolean f(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 32L;
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
    private boolean g(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 64L;
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
    private boolean h(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 128L;
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
    private boolean i(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 256L;
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
    private boolean j(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 512L;
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
    private boolean k(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.w |= 1024L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        int n3 = 0;
        int n4 = 0;
        switch (n2) {
            default: {
                return;
            }
            case 2: {
                object = this.q;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((h)object).B();
                return;
            }
            case 1: {
                object = this.q;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((h)object).A();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(h h2) {
        this.q = h2;
        synchronized (this) {
            this.w |= 2048L;
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
            case 10: {
                return this.k((LiveData)object, n3);
            }
            case 9: {
                return this.j((LiveData)object, n3);
            }
            case 8: {
                return this.i((LiveData)object, n3);
            }
            case 7: {
                return this.h((LiveData)object, n3);
            }
            case 6: {
                return this.g((LiveData)object, n3);
            }
            case 5: {
                return this.f((LiveData)object, n3);
            }
            case 4: {
                return this.e((LiveData)object, n3);
            }
            case 3: {
                return this.d((LiveData)object, n3);
            }
            case 2: {
                return this.c((LiveData)object, n3);
            }
            case 1: {
                return this.b((LiveData)object, n3);
            }
            case 0: 
        }
        return this.a((LiveData)object, n3);
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
        block71 : {
            block66 : {
                block70 : {
                    block69 : {
                        block67 : {
                            block68 : {
                                // MONITORENTER : this
                                var10_1 = this.w;
                                this.w = 0L;
                                // MONITOREXIT : this
                                var28_2 = this.q;
                                var27_3 = null;
                                if ((8191L & var10_1) == 0L) break block66;
                                if ((var10_1 & 6145L) != 0L) {
                                    var19_4 = var28_2 != null ? var28_2.t() : null;
                                    this.a(0, var19_4);
                                    var19_4 = var19_4 != null ? var19_4.a() : null;
                                    var13_5 = ViewDataBinding.a(var19_4);
                                } else {
                                    var13_5 = false;
                                }
                                var1_6 = var10_1 & 6150L LCMP 0L;
                                if (var1_6 != false) {
                                    var19_4 = var28_2 != null ? var28_2.n() : null;
                                    this.a(1, var19_4);
                                    var19_4 = var19_4 != null ? var19_4.a() : null;
                                    var14_7 = ViewDataBinding.a(var19_4);
                                    var8_8 = var10_1;
                                    var12_9 = var14_7;
                                    if (var1_6 != false) {
                                        if (var14_7) {
                                            var8_8 = var10_1 | 16384L;
                                            var12_9 = var14_7;
                                        } else {
                                            var8_8 = var10_1 | 8192L;
                                            var12_9 = var14_7;
                                        }
                                    }
                                } else {
                                    var12_9 = false;
                                    var8_8 = var10_1;
                                }
                                if ((var1_6 = (var8_8 & 6148L LCMP 0L)) == false) break block67;
                                var19_4 = var28_2 != null ? var28_2.i() : null;
                                this.a(2, var19_4);
                                var20_10 = var19_4 != null ? var19_4.a() : null;
                                var14_7 = ViewDataBinding.a(var20_10);
                                var10_1 = var8_8;
                                if (var1_6 != false) {
                                    var10_1 = var14_7 != false ? 0x100000L : 524288L;
                                    var10_1 = var8_8 | var10_1;
                                }
                                if (!var14_7) break block68;
                                var8_8 = var10_1;
                                break block69;
                            }
                            var2_11 = 4;
                            var8_8 = var10_1;
                            break block70;
                        }
                        var19_4 = null;
                        var20_10 = var19_4;
                    }
                    var2_11 = 0;
                }
                if ((var8_8 & 6152L) == 0L) ** GOTO lbl-1000
                var21_12 /* !! */  = var28_2 != null ? var28_2.m() : null;
                this.a(3, var21_12 /* !! */ );
                if (var21_12 /* !! */  != null) {
                    var21_12 /* !! */  = (String)var21_12 /* !! */ .a();
                } else lbl-1000: // 2 sources:
                {
                    var21_12 /* !! */  = null;
                }
                if ((var8_8 & 7216L) != 0L) {
                    var22_13 = var28_2 != null ? var28_2.l() : null;
                    this.a(4, var22_13);
                    var22_13 = var22_13 != null ? var22_13.a() : null;
                    var15_14 = ViewDataBinding.a(var22_13);
                    var10_1 = var8_8;
                    if ((var8_8 & 7184L) != 0L) {
                        var10_1 = var15_14 != false ? 0x400000L : 0x200000L;
                        var10_1 = var8_8 | var10_1;
                    }
                    var8_8 = var10_1;
                    var14_7 = var15_14;
                    if ((var10_1 & 6192L) != 0L) {
                        if (var15_14) {
                            var8_8 = var10_1 | 0x4000000L;
                            var14_7 = var15_14;
                        } else {
                            var8_8 = var10_1 | 0x2000000L;
                            var14_7 = var15_14;
                        }
                    }
                } else {
                    var14_7 = false;
                }
                if ((var8_8 & 6208L) == 0L) ** GOTO lbl-1000
                var22_13 = var28_2 != null ? var28_2.y() : null;
                this.a(6, var22_13);
                if (var22_13 != null) {
                    var22_13 = (String)var22_13.a();
                } else lbl-1000: // 2 sources:
                {
                    var22_13 = null;
                }
                if ((var8_8 & 6272L) != 0L) {
                    var23_15 = var28_2 != null ? var28_2.u() : null;
                    this.a(7, var23_15);
                    var23_15 = var23_15 != null ? var23_15.a() : null;
                    var15_14 = ViewDataBinding.a(var23_15);
                } else {
                    var15_14 = false;
                }
                if ((var8_8 & 6400L) != 0L) {
                    var23_15 = var28_2 != null ? var28_2.v() : null;
                    this.a(8, var23_15);
                    var23_15 = var23_15 != null ? (Integer)var23_15.a() : null;
                    var1_6 = ViewDataBinding.a(var23_15);
                } else {
                    var1_6 = 0;
                }
                if ((var8_8 & 6656L) != 0L) {
                    var23_15 = var28_2 != null ? var28_2.w() : null;
                    this.a(9, var23_15);
                    var23_15 = var23_15 != null ? (Integer)var23_15.a() : null;
                    var3_17 = ViewDataBinding.a((Integer)var23_15);
                } else {
                    var3_17 = 0;
                }
                var4_18 = var8_8 & 7168L LCMP 0L;
                if (var4_18 != 0) {
                    var23_15 = var28_2 != null ? var28_2.j() : null;
                    this.a(10, var23_15);
                    var24_19 = var23_15 != null ? var23_15.a() : null;
                    var16_20 = ViewDataBinding.a((Boolean)var24_19);
                    var10_1 = var8_8;
                    if (var4_18 != 0) {
                        var10_1 = var16_20 != false ? 65536L : 32768L;
                        var10_1 = var8_8 | var10_1;
                    }
                    var5_21 = var16_20 != false ? 0 : 4;
                    var25_22 = var24_19;
                    var8_8 = var10_1;
                    var4_18 = var1_6;
                    var1_6 = var5_21;
                    var24_19 = var23_15;
                    var23_15 = var25_22;
                } else {
                    var23_15 = var24_19 = null;
                    var4_18 = var1_6;
                    var1_6 = 0;
                    var16_20 = false;
                }
                var25_22 = var22_13;
                var26_23 = var21_12 /* !! */ ;
                var17_24 = var13_5;
                var18_25 = var12_9;
                var22_13 = var19_4;
                var21_12 /* !! */  = var20_10;
                var5_21 = (int)var1_6;
                var12_9 = var16_20;
                var20_10 = var24_19;
                var19_4 = var23_15;
                break block71;
            }
            var25_22 = null;
            var23_16 = var25_22;
            var22_13 = var23_16;
            var21_12 /* !! */  = var22_13;
            var20_10 = var21_12 /* !! */ ;
            var19_4 = var20_10;
            var3_17 = 0;
            var2_11 = 0;
            var17_24 = false;
            var14_7 = false;
            var18_25 = false;
            var4_18 = 0;
            var15_14 = false;
            var5_21 = 0;
            var12_9 = false;
            var26_23 = var23_16;
            var8_8 = var10_1;
        }
        if ((var8_8 & 16384L) != 0L) {
            if (var28_2 != null) {
                var22_13 = var28_2.i();
            }
            this.a(2, var22_13);
            if (var22_13 != null) {
                var21_12 /* !! */  = var22_13.a();
            }
            var13_5 = ViewDataBinding.a(var21_12 /* !! */ );
            var10_1 = var8_8;
            if ((var8_8 & 6148L) != 0L) {
                var10_1 = var13_5 != false ? 0x100000L : 524288L;
                var10_1 = var8_8 | var10_1;
            }
            var1_6 = var13_5 ^ true;
        } else {
            var1_6 = 0;
            var10_1 = var8_8;
        }
        if ((var10_1 & 0x2000000L) != 0L) {
            var21_12 /* !! */  = var28_2 != null ? var28_2.k() : null;
            this.a(5, var21_12 /* !! */ );
            var22_13 = var27_3;
            if (var21_12 /* !! */  != null) {
                var22_13 = var21_12 /* !! */ .a();
            }
            var13_5 = ViewDataBinding.a((Boolean)var22_13);
        } else {
            var13_5 = false;
        }
        if ((var10_1 & 0x200000L) != 0L) {
            if (var28_2 != null) {
                var20_10 = var28_2.j();
            }
            this.a(10, (LiveData<?>)var20_10);
            if (var20_10 != null) {
                var19_4 = var20_10.a();
            }
            var12_9 = var16_20 = ViewDataBinding.a(var19_4);
            var8_8 = var10_1;
            if ((var10_1 & 7168L) != 0L) {
                var8_8 = var16_20 != false ? 65536L : 32768L;
                var8_8 = var10_1 | var8_8;
                var12_9 = var16_20;
            }
        } else {
            var8_8 = var10_1;
        }
        var6_26 = var8_8 & 6150L LCMP 0L;
        var10_1 = var8_8;
        if (var6_26 == false) ** GOTO lbl-1000
        if (!var18_25) {
            var1_6 = 0;
        }
        var10_1 = var8_8;
        if (var6_26 != false) {
            var10_1 = var1_6 != false ? 0x10000000L : 0x8000000L;
            var10_1 = var8_8 | var10_1;
        }
        if (var1_6 == false) {
            var6_26 = 8;
            var8_8 = var10_1;
        } else lbl-1000: // 2 sources:
        {
            var6_26 = 0;
            var8_8 = var10_1;
        }
        var1_6 = var8_8 & 7184L LCMP 0L;
        if (var1_6 != false) {
            if (var14_7) {
                var12_9 = true;
            }
            var10_1 = var8_8;
            if (var1_6 != false) {
                var10_1 = var12_9 != false ? 262144L : 131072L;
                var10_1 = var8_8 | var10_1;
            }
            var1_6 = var12_9 != false ? (long)8 : (long)0;
            var7_27 = var1_6;
            var8_8 = var10_1;
        } else {
            var7_27 = 0;
        }
        var1_6 = var8_8 & 6192L LCMP 0L;
        if (var1_6 != false) {
            if (var14_7) {
                var13_5 = true;
            }
            var10_1 = var8_8;
            if (var1_6 != false) {
                var10_1 = var13_5 != false ? 0x1000000L : 0x800000L;
                var10_1 = var8_8 | var10_1;
            }
            var1_6 = var13_5 != false ? (long)0 : (long)4;
            var8_8 = var10_1;
        } else {
            var1_6 = 0;
        }
        if ((var8_8 & 6150L) != 0L) {
            this.c.setVisibility((int)var6_26);
        }
        if ((var8_8 & 7168L) != 0L) {
            this.e.setVisibility(var5_21);
        }
        if ((var8_8 & 6192L) != 0L) {
            this.g.setVisibility((int)var1_6);
        }
        if ((var8_8 & 6148L) != 0L) {
            this.t.setVisibility(var2_11);
        }
        if ((6272L & var8_8) != 0L) {
            this.h.setEnabled(var15_14);
        }
        if ((4096L & var8_8) != 0L) {
            this.h.setOnClickListener(this.u);
            this.j.setOnClickListener(this.v);
        }
        if ((6656L & var8_8) != 0L) {
            this.h.setVisibility(var3_17);
        }
        if ((6145L & var8_8) != 0L) {
            this.j.setEnabled(var17_24);
        }
        if ((6400L & var8_8) != 0L) {
            this.j.setVisibility(var4_18);
        }
        if ((var8_8 & 7184L) != 0L) {
            this.m.setVisibility(var7_27);
        }
        if ((6208L & var8_8) != 0L) {
            androidx.databinding.a.e.a(this.n, (CharSequence)var25_22);
        }
        if ((var8_8 & 6152L) == 0L) return;
        androidx.databinding.a.e.a(this.o, var26_23);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.w = 4096L;
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
            return this.w != 0L;
            {
            }
        }
    }
}

