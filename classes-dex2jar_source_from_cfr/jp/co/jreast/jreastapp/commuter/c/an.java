/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.am;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class an
extends am
implements b.a {
    private static final ViewDataBinding.b m;
    private static final SparseIntArray n;
    private final View.OnClickListener o;
    private long p = -1L;

    static {
        n = new SparseIntArray();
        n.put(2131230876, 5);
        n.put(2131231047, 6);
        n.put(2131231048, 7);
        n.put(2131230907, 8);
    }

    public an(e e2, View view) {
        this(e2, view, an.a(e2, view, 9, m, n));
    }

    private an(e e2, View view, Object[] arrobject) {
        super(e2, view, 3, (RecyclerView)arrobject[5], (TextView)arrobject[8], (ConstraintLayout)((Object)arrobject[3]), (ProgressBar)arrobject[1], (ConstraintLayout)((Object)arrobject[0]), (AppCompatImageView)arrobject[6], (TextView)arrobject[7], (ConstraintLayout)((Object)arrobject[2]), (Button)arrobject[4]);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.a(view);
        this.o = new b(this, 1);
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
                this.p |= 1L;
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
                this.p |= 2L;
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
                this.p |= 4L;
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
            ((g)object).k();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(g g2) {
        this.l = g2;
        synchronized (this) {
            this.p |= 8L;
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
        block17 : {
            block16 : {
                // MONITORENTER : this
                var6_1 = this.p;
                this.p = 0L;
                // MONITOREXIT : this
                var11_2 = this.l;
                if ((31L & var6_1) == 0L) break block16;
                var10_3 = null;
                var1_4 = var6_1 & 25L LCMP 0L;
                var4_5 = var6_1;
                if (var1_4 == 0) ** GOTO lbl-1000
                var9_6 = var11_2 != null ? var11_2.h() : null;
                this.a(0, var9_6);
                var9_6 = var9_6 != null ? var9_6.a() : null;
                var8_7 = ViewDataBinding.a(var9_6);
                var4_5 = var6_1;
                if (var1_4 != 0) {
                    var4_5 = var8_7 != false ? 64L : 32L;
                    var4_5 = var6_1 | var4_5;
                }
                if (!var8_7) {
                    var1_4 = 4;
                } else lbl-1000: // 2 sources:
                {
                    var1_4 = 0;
                }
                var2_8 = var4_5 & 26L LCMP 0L;
                var6_1 = var4_5;
                if (var2_8 == 0) ** GOTO lbl-1000
                var9_6 = var11_2 != null ? var11_2.g() : null;
                this.a(1, var9_6);
                var9_6 = var9_6 != null ? var9_6.a() : null;
                var8_7 = ViewDataBinding.a(var9_6);
                var6_1 = var4_5;
                if (var2_8 != 0) {
                    var6_1 = var8_7 != false ? 1024L : 512L;
                    var6_1 = var4_5 | var6_1;
                }
                if (!var8_7) {
                    var2_8 = 8;
                    var4_5 = var6_1;
                } else lbl-1000: // 2 sources:
                {
                    var2_8 = 0;
                    var4_5 = var6_1;
                }
                var3_9 = (int)(var4_5 & 28L LCMP 0L);
                if (var3_9 != 0) {
                    var9_6 = var11_2 != null ? var11_2.f() : null;
                    this.a(2, var9_6);
                    if (var9_6 != null) {
                        var10_3 = var9_6.a();
                    }
                    var8_7 = ViewDataBinding.a(var10_3);
                    var6_1 = var4_5;
                    if (var3_9 != 0) {
                        var6_1 = var8_7 != false ? 256L : 128L;
                        var6_1 = var4_5 | var6_1;
                    }
                    var3_9 = var8_7 != false ? 0 : 4;
                    var4_5 = var6_1;
                } else {
                    var3_9 = 0;
                }
                break block17;
            }
            var3_9 = 0;
            var1_4 = 0;
            var2_8 = 0;
            var4_5 = var6_1;
        }
        if ((25L & var4_5) != 0L) {
            this.e.setVisibility(var1_4);
        }
        if ((var4_5 & 26L) != 0L) {
            this.f.setVisibility(var2_8);
        }
        if ((var4_5 & 28L) != 0L) {
            this.j.setVisibility(var3_9);
        }
        if ((var4_5 & 16L) == 0L) return;
        this.k.setOnClickListener(this.o);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.p = 16L;
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
            return this.p != 0L;
            {
            }
        }
    }
}

