/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.ba;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.j;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class bb
extends ba
implements b.a {
    private static final ViewDataBinding.b y;
    private static final SparseIntArray z;
    private final ConstraintLayout A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private final View.OnClickListener J;
    private final View.OnClickListener K;
    private long L = -1L;

    static {
        z = new SparseIntArray();
        z.put(2131231134, 14);
        z.put(2131230920, 15);
        z.put(2131230925, 16);
        z.put(2131231291, 17);
        z.put(2131231033, 18);
        z.put(2131231034, 19);
        z.put(2131231310, 20);
    }

    public bb(androidx.databinding.e e2, View view) {
        this(e2, view, bb.a(e2, view, 21, y, z));
    }

    private bb(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 4, (Button)arrobject[13], (Button)arrobject[12], (TextView)arrobject[2], (LinearLayout)arrobject[1], (TextView)arrobject[15], (TextView)arrobject[4], (LinearLayout)arrobject[3], (TextView)arrobject[16], (Button)arrobject[9], (Button)arrobject[8], (TextView)arrobject[18], (LinearLayout)arrobject[19], (Button)arrobject[11], (Button)arrobject[7], (TextView)arrobject[14], (Button)arrobject[10], (TextView)arrobject[6], (LinearLayout)arrobject[5], (TextView)arrobject[17], (TextView)arrobject[20]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.A = (ConstraintLayout)((Object)arrobject[0]);
        this.A.setTag(null);
        this.l.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.a(view);
        this.B = new b(this, 2);
        this.C = new b(this, 4);
        this.D = new b(this, 3);
        this.E = new b(this, 9);
        this.F = new b(this, 10);
        this.G = new b(this, 7);
        this.H = new b(this, 8);
        this.I = new b(this, 5);
        this.J = new b(this, 1);
        this.K = new b(this, 6);
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
                this.L |= 1L;
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
    private boolean b(p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.L |= 2L;
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
                this.L |= 4L;
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
                this.L |= 8L;
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
        int n12 = 0;
        switch (n2) {
            default: {
                return;
            }
            case 10: {
                object = this.w;
                n2 = n12;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).u();
                return;
            }
            case 9: {
                object = this.w;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).t();
                return;
            }
            case 8: {
                object = this.w;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).s();
                return;
            }
            case 7: {
                object = this.w;
                n2 = n5;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).r();
                return;
            }
            case 6: {
                object = this.w;
                n2 = n6;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).q();
                return;
            }
            case 5: {
                object = this.x;
                n2 = n7;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((d)object).j();
                return;
            }
            case 4: {
                object = this.w;
                n2 = n8;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).p();
                return;
            }
            case 3: {
                object = this.w;
                n2 = n9;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).o();
                return;
            }
            case 2: {
                object = this.w;
                n2 = n10;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).n();
                return;
            }
            case 1: {
                object = this.w;
                n2 = n11;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).m();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(d d2) {
        this.x = d2;
        synchronized (this) {
            this.L |= 16L;
        }
        this.a(6);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.w = j2;
        synchronized (this) {
            this.L |= 32L;
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
        block15 : {
            block14 : {
                // MONITORENTER : this
                var1_1 = this.L;
                this.L = 0L;
                // MONITOREXIT : this
                var5_2 = this.x;
                var7_3 = this.w;
                var4_4 = false;
                var3_5 = false;
                if ((111L & var1_1) == 0L) break block14;
                if ((var1_1 & 97L) != 0L) {
                    var5_2 = var7_3 != null ? var7_3.e() : null;
                    this.a(0, var5_2);
                    var5_2 = var5_2 != null ? (Boolean)var5_2.a() : null;
                    var3_5 = ViewDataBinding.a(var5_2);
                }
                if ((var1_1 & 98L) == 0L) ** GOTO lbl-1000
                var5_2 = var7_3 != null ? var7_3.d() : null;
                this.a(1, var5_2);
                if (var5_2 != null) {
                    var5_2 = (String)var5_2.a();
                } else lbl-1000: // 2 sources:
                {
                    var5_2 = null;
                }
                if ((var1_1 & 100L) == 0L) ** GOTO lbl-1000
                var6_6 = var7_3 != null ? var7_3.c() : null;
                this.a(2, var6_6);
                if (var6_6 != null) {
                    var6_6 = (String)var6_6.a();
                } else lbl-1000: // 2 sources:
                {
                    var6_6 = null;
                }
                if ((var1_1 & 104L) == 0L) ** GOTO lbl-1000
                var7_3 = var7_3 != null ? var7_3.b() : null;
                this.a(3, var7_3);
                if (var7_3 != null) {
                    var7_3 = (String)var7_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var7_3 = null;
                }
                break block15;
            }
            var7_3 = null;
            var5_2 = null;
            var6_6 = null;
            var3_5 = var4_4;
        }
        if ((var1_1 & 64L) != 0L) {
            this.c.setOnClickListener(this.F);
            this.d.setOnClickListener(this.E);
            this.f.setOnClickListener(this.J);
            this.i.setOnClickListener(this.B);
            this.k.setOnClickListener(this.K);
            this.l.setOnClickListener(this.I);
            this.o.setOnClickListener(this.H);
            this.p.setOnClickListener(this.C);
            this.r.setOnClickListener(this.G);
            this.t.setOnClickListener(this.D);
        }
        if ((104L & var1_1) != 0L) {
            e.a(this.e, (CharSequence)var7_3);
        }
        if ((var1_1 & 100L) != 0L) {
            e.a(this.h, var6_6);
        }
        if ((var1_1 & 97L) != 0L) {
            this.p.setEnabled(var3_5);
        }
        if ((var1_1 & 98L) == 0L) return;
        e.a(this.s, (CharSequence)var5_2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.L = 64L;
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
            return this.L != 0L;
            {
            }
        }
    }
}

