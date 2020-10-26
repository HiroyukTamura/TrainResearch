/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.c.cy;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.n.k;

public class cz
extends cy
implements b.a {
    private static final ViewDataBinding.b B;
    private static final SparseIntArray C;
    private final View.OnClickListener D;
    private long E = -1L;

    static {
        C = new SparseIntArray();
        C.put(2131230799, 15);
        C.put(2131231171, 16);
        C.put(2131230993, 17);
        C.put(2131231004, 18);
        C.put(2131231011, 19);
        C.put(2131231005, 20);
        C.put(2131230858, 21);
    }

    public cz(e e2, View view) {
        this(e2, view, cz.a(e2, view, 22, B, C));
    }

    private cz(e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (TextView)arrobject[7], (TextView)arrobject[3], (AppCompatImageView)arrobject[2], (LinearLayout)arrobject[15], (ConstraintLayout)((Object)arrobject[11]), (TextView)arrobject[12], (TextView)arrobject[13], (AppCompatImageView)arrobject[21], (TextView)arrobject[1], (TextView)arrobject[4], (AppCompatTextView)arrobject[5], (ConstraintLayout)((Object)arrobject[0]), (View)arrobject[17], (AppCompatImageView)arrobject[18], (LinearLayout)arrobject[20], (TextView)arrobject[10], (TextView)arrobject[9], (LinearLayout)arrobject[19], (View)arrobject[14], (View)arrobject[16], (AppCompatTextView)arrobject[6], (TextView)arrobject[8]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.a(view);
        this.D = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View object) {
        object = this.z;
        k k2 = this.y;
        n2 = k2 != null ? 1 : 0;
        if (n2 != 0) {
            k2.c((RailwayLine)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(RailwayLine railwayLine) {
        this.z = railwayLine;
        synchronized (this) {
            this.E |= 2L;
        }
        this.a(3);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(k k2) {
        this.y = k2;
        synchronized (this) {
            this.E |= 4L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        return false;
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
        var15_1 = this.E;
        this.E = 0L;
        // MONITOREXIT : this
        var23_2 = this.A;
        var38_3 = this.z;
        var34_4 = this.y;
        var1_5 = var15_1 & 11L LCMP 0L;
        if (var1_5 != false) {
            var20_7 = var19_6 = ViewDataBinding.a((Boolean)var23_2);
            var13_8 = var15_1;
            if (var1_5 != false) {
                if (var19_6) {
                    var13_8 = var15_1 | 131072L;
                    var20_7 = var19_6;
                } else {
                    var13_8 = var15_1 | 65536L;
                    var20_7 = var19_6;
                }
            }
        } else {
            var20_7 = false;
            var13_8 = var15_1;
        }
        var12_9 = 1;
        var37_10 = null;
        if ((var13_8 & 14L) != 0L) {
            var1_5 = var13_8 & 10L LCMP 0L;
            if (var1_5 != false) {
                if (var38_3 != null) {
                    var31_11 = var38_3.getChangeTime();
                    var21_12 = var38_3.getDirectOperationDeparture();
                    var30_13 = var38_3.getName();
                    var23_2 = var38_3.getFrom();
                    var19_6 = var38_3.isWalking();
                    var28_14 = var38_3.getKindAndBoundFor();
                    var24_15 = var38_3.getServiceStatus();
                    var25_16 = var38_3.getTo();
                } else {
                    var25_16 = var24_15 = (var28_14 = (var23_2 = (var30_13 = (var31_11 = null))));
                    var21_12 = false;
                    var19_6 = false;
                }
                var17_17 = var13_8;
                if (var1_5 != false) {
                    if (var21_12) {
                        var13_8 |= 8192L;
                        var15_1 = 524288L;
                    } else {
                        var13_8 |= 4096L;
                        var15_1 = 262144L;
                    }
                    var17_17 = var13_8 | var15_1;
                }
                var15_1 = var17_17;
                if ((var17_17 & 10L) != 0L) {
                    var15_1 = var19_6 != false ? var17_17 | 512L | 0x200000L : var17_17 | 256L | 0x100000L;
                }
                var8_18 = var31_11 != null ? 1 : 0;
                var6_19 = 4;
                var5_20 = var21_12 != false ? 4 : 0;
                var7_21 = var21_12 != false ? 8 : 0;
                if (!var19_6) {
                    var6_19 = 0;
                }
                var4_22 = var19_6 != false ? 0 : 8;
                var13_8 = var15_1;
                if ((var15_1 & 10L) != 0L) {
                    var13_8 = var8_18 != 0 ? var15_1 | 32768L : var15_1 | 16384L;
                }
                if (var23_2 != null) {
                    var26_23 = var23_2.getName();
                    var27_24 = var23_2.getAccuracy();
                    var29_25 = var23_2.platformNameWithSuffix();
                    var23_2 = var27_24;
                } else {
                    var23_2 = var26_23 = (var29_25 = null);
                }
                var21_12 = var28_14 != null ? var28_14.isEmpty() : false;
                var15_1 = var13_8;
                if ((var13_8 & 10L) != 0L) {
                    var15_1 = var21_12 != false ? 128L : 64L;
                    var15_1 = var13_8 | var15_1;
                }
                if (var24_15 != null) {
                    var27_24 = var24_15.getDelayReason();
                    var32_26 = var24_15.getDelayMinute();
                    var24_15 = var27_24;
                } else {
                    var24_15 = var32_26 = null;
                }
                if (var25_16 != null) {
                    var33_27 = var25_16.getAccuracy();
                    var27_24 = var25_16.platformNameWithSuffix();
                } else {
                    var33_27 = var27_24 = null;
                }
                var25_16 = var23_2 != null ? var23_2.fourDigitString() : null;
                var3_28 = var21_12 != false ? 8 : 0;
                var21_12 = var24_15 != null ? var24_15.isEmpty() : false;
                var13_8 = var15_1;
                if ((var15_1 & 10L) != 0L) {
                    var13_8 = var21_12 != false ? 2048L : 1024L;
                    var13_8 = var15_1 | var13_8;
                }
                var22_29 = var32_26 != null ? var32_26.isEmpty() : false;
                var15_1 = var13_8;
                if ((var13_8 & 10L) != 0L) {
                    var15_1 = var22_29 != false ? 0x800000L : 0x400000L;
                    var15_1 = var13_8 | var15_1;
                }
                var23_2 = var33_27 != null ? var33_27.fourDigitString() : null;
                var2_30 = var21_12 != false ? 8 : 0;
                if (var22_29) {
                    var1_5 = 8;
                    var13_8 = var15_1;
                } else {
                    var1_5 = 0;
                    var13_8 = var15_1;
                }
            } else {
                var23_2 = var24_15 = (var25_16 = (var26_23 = (var27_24 = (var28_14 = (var29_25 = (var30_13 = (var31_11 = null)))))));
                var8_18 = 0;
                var7_21 = 0;
                var19_6 = false;
                var1_5 = 0;
                var6_19 = 0;
                var5_20 = 0;
                var4_22 = 0;
                var3_28 = 0;
                var2_30 = 0;
            }
            if (var34_4 != null) {
                var36_31 = var34_4.e(var38_3);
                var35_33 = var34_4.d(var38_3);
                var10_35 = var7_21;
                var33_27 = var29_25;
                var29_25 = var28_14;
                var7_21 = (int)var1_5;
                var32_26 = var27_24;
                var1_5 = var5_20;
                var34_4 = var26_23;
                var27_24 = var25_16;
                var5_20 = var3_28;
                var28_14 = var24_15;
                var24_15 = var23_2;
                var11_37 = var2_30;
                var25_16 = var36_31;
                var15_1 = var13_8;
                var23_2 = var33_27;
                var9_39 = var8_18;
                var33_27 = var31_11;
                var2_30 = var10_35;
                var26_23 = var30_13;
                var3_28 = var4_22;
                var4_22 = var5_20;
                var5_20 = var7_21;
                var30_13 = var34_4;
                var31_11 = var32_26;
                var7_21 = var11_37;
                var32_26 = var35_33;
            } else {
                var32_26 = var33_27 = null;
                var10_36 = var7_21;
                var36_32 = var29_25;
                var29_25 = var28_14;
                var7_21 = (int)var1_5;
                var34_4 = var27_24;
                var1_5 = var5_20;
                var35_34 = var26_23;
                var27_24 = var25_16;
                var5_20 = var3_28;
                var28_14 = var24_15;
                var24_15 = var23_2;
                var11_38 = var2_30;
                var15_1 = var13_8;
                var23_2 = var36_32;
                var25_16 = var33_27;
                var9_39 = var8_18;
                var33_27 = var31_11;
                var2_30 = var10_36;
                var26_23 = var30_13;
                var3_28 = var4_22;
                var4_22 = var5_20;
                var5_20 = var7_21;
                var30_13 = var35_34;
                var31_11 = var34_4;
                var7_21 = var11_38;
            }
        } else {
            var32_26 = var31_11 = (var30_13 = (var29_25 = (var28_14 = (var27_24 = (var26_23 = (var23_2 = (var25_16 = (var24_15 = (var34_4 = null)))))))));
            var1_5 = 0;
            var9_39 = 0;
            var19_6 = false;
            var2_30 = 0;
            var3_28 = 0;
            var4_22 = 0;
            var5_20 = 0;
            var6_19 = 0;
            var7_21 = 0;
            var33_27 = var23_2;
            var23_2 = var34_4;
            var15_1 = var13_8;
        }
        var17_17 = var15_1;
        if ((131072L & var15_1) == 0L) ** GOTO lbl-1000
        if (var38_3 != null) {
            var19_6 = var38_3.isWalking();
        }
        var13_8 = var15_1;
        if ((var15_1 & 10L) != 0L) {
            var13_8 = var19_6 != false ? var15_1 | 512L | 0x200000L : var15_1 | 256L | 0x100000L;
        }
        var17_17 = var13_8;
        if (!var19_6) {
            var8_18 = var12_9;
        } else lbl-1000: // 2 sources:
        {
            var8_18 = 0;
            var13_8 = var17_17;
        }
        var33_27 = (var13_8 & 32768L) != 0L && var33_27 != null ? var33_27.displayString() : null;
        var34_4 = var37_10;
        if ((var13_8 & 10L) != 0L) {
            if (var9_39 == 0) {
                var33_27 = "";
            }
            var34_4 = var33_27;
        }
        if ((var9_39 = (var13_8 & 11L LCMP 0L)) != 0) {
            if (!var20_7) {
                var8_18 = 0;
            }
            var15_1 = var13_8;
            if (var9_39 != 0) {
                var15_1 = var8_18 != 0 ? 32L : 16L;
                var15_1 = var13_8 | var15_1;
            }
            var8_18 = var8_18 != 0 ? 0 : 8;
            var13_8 = var15_1;
        } else {
            var8_18 = 0;
        }
        if ((var13_8 & 10L) != 0L) {
            androidx.databinding.a.e.a(this.c, (CharSequence)var24_15);
            this.c.setVisibility(var2_30);
            androidx.databinding.a.e.a(this.d, (CharSequence)var34_4);
            this.h.setVisibility(var5_20);
            androidx.databinding.a.e.a(this.i, (CharSequence)var28_14);
            this.i.setVisibility(var7_21);
            androidx.databinding.a.e.a(this.k, (CharSequence)var30_13);
            androidx.databinding.a.e.a(this.l, (CharSequence)var27_24);
            androidx.databinding.a.e.a(this.m, (CharSequence)var23_2);
            androidx.databinding.a.e.a(this.r, (CharSequence)var29_25);
            this.r.setVisibility(var4_22);
            androidx.databinding.a.e.a(this.s, (CharSequence)var26_23);
            this.s.setVisibility(var6_19);
            this.u.setVisibility((int)var1_5);
            androidx.databinding.a.e.a(this.w, (CharSequence)var31_11);
            this.w.setVisibility(var2_30);
            this.x.setVisibility(var3_28);
        }
        if ((var13_8 & 11L) != 0L) {
            this.d.setVisibility(var8_18);
            this.e.setVisibility(var8_18);
        }
        if ((8L & var13_8) != 0L) {
            this.g.setOnClickListener(this.D);
        }
        if ((var13_8 & 14L) == 0L) return;
        androidx.databinding.a.e.a(this.h, (CharSequence)var32_26);
        androidx.databinding.a.e.a(this.x, (CharSequence)var25_16);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(Boolean bl2) {
        this.A = bl2;
        synchronized (this) {
            this.E |= 1L;
        }
        this.a(15);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.E = 8L;
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
            return this.E != 0L;
            {
            }
        }
    }
}

