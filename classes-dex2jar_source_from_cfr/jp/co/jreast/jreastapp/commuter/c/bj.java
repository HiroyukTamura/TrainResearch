/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.c;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import jp.co.jreast.jreastapp.commuter.c.bi;
import jp.co.jreast.jreastapp.commuter.c.cm;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.h.a.d;
import jp.co.jreast.jreastapp.commuter.q.h;

public class bj
extends bi
implements b.a,
d.a {
    private static final ViewDataBinding.b q = new ViewDataBinding.b(16);
    private static final SparseIntArray r;
    private final ConstraintLayout s;
    private final ConstraintLayout t;
    private final FrameLayout u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final SwipeRefreshLayout.b x;
    private final View.OnClickListener y;
    private long z = -1L;

    static {
        q.a(0, new String[]{"popup_train_service_area_select"}, new int[]{10}, new int[]{2131427440});
        r = new SparseIntArray();
        r.put(2131231286, 11);
        r.put(2131230911, 12);
        r.put(2131230904, 13);
        r.put(2131231277, 14);
        r.put(2131230759, 15);
    }

    public bj(e e2, View view) {
        this(e2, view, bj.a(e2, view, 16, q, r));
    }

    private bj(e e2, View view, Object[] arrobject) {
        super(e2, view, 8, (AppCompatImageView)arrobject[15], (TextView)arrobject[13], (ConstraintLayout)((Object)arrobject[4]), (TextView)arrobject[12], (AppCompatImageButton)arrobject[5], (ConstraintLayout)((Object)arrobject[1]), (AppCompatImageView)arrobject[2], (cm)arrobject[10], (SwipeRefreshLayout)arrobject[3], (TextView)arrobject[7], (TextView)arrobject[8], (Toolbar)((Object)arrobject[14]), (RecyclerView)arrobject[11]);
        this.e.setTag(null);
        this.g.setTag(null);
        this.s = (ConstraintLayout)((Object)arrobject[0]);
        this.s.setTag(null);
        this.t = (ConstraintLayout)((Object)arrobject[6]);
        this.t.setTag(null);
        this.u = (FrameLayout)arrobject[9];
        this.u.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.a(view);
        this.v = new b(this, 4);
        this.w = new b(this, 3);
        this.x = new d(this, 1);
        this.y = new b(this, 2);
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
                this.z |= 1L;
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
                this.z |= 8L;
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
    private boolean a(cm cm2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.z |= 128L;
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
    private boolean b(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.z |= 2L;
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
                this.z |= 64L;
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
    private boolean c(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.z |= 4L;
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
    private boolean d(LiveData<Drawable> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.z |= 16L;
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
    private boolean e(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.z |= 32L;
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
        switch (n2) {
            default: {
                return;
            }
            case 4: {
                h h2 = this.p;
                n2 = n5;
                if (h2 != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                h2.a((View)object);
                return;
            }
            case 3: {
                object = this.p;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((h)object).w();
                return;
            }
            case 2: {
                object = this.p;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((h)object).y();
            }
        }
    }

    @Override
    public void a(j j2) {
        super.a(j2);
        this.j.a(j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(h h2) {
        this.p = h2;
        synchronized (this) {
            this.z |= 256L;
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
            case 7: {
                return this.a((cm)object, n3);
            }
            case 6: {
                return this.b((p)object, n3);
            }
            case 5: {
                return this.e((LiveData)object, n3);
            }
            case 4: {
                return this.d((LiveData)object, n3);
            }
            case 3: {
                return this.a((p)object, n3);
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
        block30 : {
            block29 : {
                // MONITORENTER : this
                var8_1 = this.z;
                this.z = 0L;
                // MONITOREXIT : this
                var15_2 = this.p;
                if ((895L & var8_1) == 0L) break block29;
                var4_3 = 8;
                var1_4 = var8_1 & 769L LCMP 0L;
                var6_5 = var8_1;
                if (var1_4 == 0) ** GOTO lbl-1000
                var12_6 = var15_2 != null ? var15_2.l() : null;
                this.a(0, var12_6);
                var12_6 = var12_6 != null ? var12_6.a() : null;
                var10_7 = ViewDataBinding.a(var12_6);
                var6_5 = var8_1;
                if (var1_4 != 0) {
                    var6_5 = var10_7 != false ? 8192L : 4096L;
                    var6_5 = var8_1 | var6_5;
                }
                if (!var10_7) {
                    var3_8 = 8;
                } else lbl-1000: // 2 sources:
                {
                    var3_8 = 0;
                }
                if ((var6_5 & 770L) != 0L) {
                    var12_6 = var15_2 != null ? var15_2.q() : null;
                    this.a(1, var12_6);
                    var12_6 = var12_6 != null ? (Integer)var12_6.a() : null;
                    var2_9 = ViewDataBinding.a(var12_6);
                } else {
                    var2_9 = 0;
                }
                if ((var6_5 & 772L) != 0L) {
                    var12_6 = var15_2 != null ? var15_2.s() : null;
                    this.a(2, var12_6);
                    var12_6 = var12_6 != null ? (Integer)var12_6.a() : null;
                    var1_4 = ViewDataBinding.a(var12_6);
                } else {
                    var1_4 = 0;
                }
                if ((var6_5 & 776L) != 0L) {
                    var12_6 = var15_2 != null ? var15_2.o() : null;
                    this.a(3, var12_6);
                    var12_6 = var12_6 != null ? (Boolean)var12_6.a() : null;
                    var10_7 = ViewDataBinding.a(var12_6);
                } else {
                    var10_7 = false;
                }
                if ((var6_5 & 784L) == 0L) ** GOTO lbl-1000
                var12_6 = var15_2 != null ? var15_2.u() : null;
                this.a(4, var12_6);
                if (var12_6 != null) {
                    var12_6 = (Drawable)var12_6.a();
                } else lbl-1000: // 2 sources:
                {
                    var12_6 = null;
                }
                if ((var6_5 & 800L) == 0L) ** GOTO lbl-1000
                var13_10 = var15_2 != null ? var15_2.t() : null;
                this.a(5, var13_10);
                if (var13_10 != null) {
                    var13_10 = var13_10.a();
                } else lbl-1000: // 2 sources:
                {
                    var13_10 = null;
                }
                var5_11 = var6_5 & 832L LCMP 0L;
                if (var5_11 != false) {
                    var14_12 = var15_2 != null ? var15_2.m() : null;
                    this.a(6, (LiveData<?>)var14_12);
                    var14_12 = var14_12 != null ? (Boolean)var14_12.a() : null;
                    var11_13 = ViewDataBinding.a(var14_12);
                    var8_1 = var6_5;
                    if (var5_11 != false) {
                        var8_1 = var11_13 != false ? 2048L : 1024L;
                        var8_1 = var6_5 | var8_1;
                    }
                    if (var11_13) {
                        var4_3 = 0;
                    }
                    var5_11 = var1_4;
                    var1_4 = var4_3;
                    var6_5 = var8_1;
                    var4_3 = var3_8;
                    var3_8 = (int)var5_11;
                } else {
                    var5_11 = var1_4;
                    var1_4 = 0;
                    var4_3 = var3_8;
                    var3_8 = (int)var5_11;
                }
                break block30;
            }
            var4_3 = 0;
            var1_4 = 0;
            var13_10 = null;
            var3_8 = 0;
            var2_9 = 0;
            var10_7 = false;
            var12_6 = null;
            var6_5 = var8_1;
        }
        if ((var6_5 & 770L) != 0L) {
            this.e.setVisibility(var2_9);
        }
        if ((512L & var6_5) != 0L) {
            this.g.setOnClickListener(this.y);
            this.t.setOnClickListener(this.w);
            this.u.setOnClickListener(this.v);
            this.k.setOnRefreshListener(this.x);
        }
        if ((var6_5 & 769L) != 0L) {
            this.u.setVisibility(var4_3);
            this.j.e().setVisibility(var4_3);
        }
        if ((832L & var6_5) != 0L) {
            this.h.setVisibility(var1_4);
        }
        if ((784L & var6_5) != 0L) {
            c.a(this.i, var12_6);
        }
        if ((768L & var6_5) != 0L) {
            this.j.a(var15_2);
        }
        if ((776L & var6_5) != 0L) {
            this.k.setRefreshing(var10_7);
        }
        if ((800L & var6_5) != 0L) {
            androidx.databinding.a.e.a(this.l, (CharSequence)var13_10);
        }
        if ((var6_5 & 772L) != 0L) {
            this.m.setVisibility(var3_8);
        }
        bj.a(this.j);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.z = 512L;
        }
        this.j.c();
        this.f();
    }

    @Override
    public final void c(int n2) {
        h h2 = this.p;
        n2 = h2 != null ? 1 : 0;
        if (n2 != 0) {
            h2.z();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean d() {
        synchronized (this) {
            if (this.z != 0L) {
                return true;
            }
            return this.j.d();
        }
    }
}

