/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.c;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import jp.co.jreast.jreastapp.commuter.c.ai;
import jp.co.jreast.jreastapp.commuter.c.ci;
import jp.co.jreast.jreastapp.commuter.c.ck;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.webview.j;

public class aj
extends ai
implements b.a {
    private static final ViewDataBinding.b q = new ViewDataBinding.b(16);
    private static final SparseIntArray r;
    private final ConstraintLayout s;
    private final FrameLayout t;
    private final FrameLayout u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private long y = -1L;

    static {
        q.a(6, new String[]{"layout_beacon_status_view"}, new int[]{10}, new int[]{2131427419});
        q.a(7, new String[]{"layout_error_status_view"}, new int[]{11}, new int[]{2131427420});
        r = new SparseIntArray();
        r.put(2131231277, 12);
        r.put(2131231259, 13);
        r.put(2131231327, 14);
        r.put(2131231328, 15);
    }

    public aj(e e2, View view) {
        this(e2, view, aj.a(e2, view, 16, q, r));
    }

    private aj(e e2, View view, Object[] arrobject) {
        super(e2, view, 12, (AppCompatImageButton)arrobject[1], (ci)arrobject[10], (ck)arrobject[11], (AppCompatImageView)arrobject[3], (ProgressBar)arrobject[9], (AppCompatImageButton)arrobject[2], (TextView)arrobject[5], (AppCompatImageButton)arrobject[8], (TextView)arrobject[4], (ConstraintLayout)((Object)arrobject[13]), (Toolbar)((Object)arrobject[12]), (ConstraintLayout)((Object)arrobject[14]), (WebView)arrobject[15]);
        this.c.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.s = (ConstraintLayout)((Object)arrobject[0]);
        this.s.setTag(null);
        this.t = (FrameLayout)arrobject[6];
        this.t.setTag(null);
        this.u = (FrameLayout)arrobject[7];
        this.u.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.a(view);
        this.v = new b(this, 3);
        this.w = new b(this, 1);
        this.x = new b(this, 2);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 1L;
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
    private boolean a(ci ci2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 256L;
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
    private boolean a(ck ck2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 8L;
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
    private boolean b(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 2L;
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
                this.y |= 4L;
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
                this.y |= 16L;
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
    private boolean e(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 32L;
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
    private boolean f(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 64L;
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
    private boolean g(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 128L;
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
    private boolean h(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.y |= 512L;
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
                this.y |= 1024L;
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
                this.y |= 2048L;
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
            case 3: {
                object = this.p;
                n2 = n5;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).J();
                return;
            }
            case 2: {
                object = this.p;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).O();
                return;
            }
            case 1: {
                object = this.p;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).P();
            }
        }
    }

    @Override
    public void a(androidx.lifecycle.j j2) {
        super.a(j2);
        this.d.a(j2);
        this.e.a(j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.p = j2;
        synchronized (this) {
            this.y |= 4096L;
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
            case 11: {
                return this.j((LiveData)object, n3);
            }
            case 10: {
                return this.i((LiveData)object, n3);
            }
            case 9: {
                return this.h((LiveData)object, n3);
            }
            case 8: {
                return this.a((ci)object, n3);
            }
            case 7: {
                return this.g((LiveData)object, n3);
            }
            case 6: {
                return this.f((LiveData)object, n3);
            }
            case 5: {
                return this.e((LiveData)object, n3);
            }
            case 4: {
                return this.d((LiveData)object, n3);
            }
            case 3: {
                return this.a((ck)object, n3);
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
        block36 : {
            block35 : {
                // MONITORENTER : this
                var8_1 = this.y;
                this.y = 0L;
                // MONITOREXIT : this
                var14_2 = this.p;
                if ((16119L & var8_1) == 0L) break block35;
                if ((var8_1 & 12289L) == 0L) ** GOTO lbl-1000
                var10_3 = var14_2 != null ? var14_2.o() : null;
                this.a(0, var10_3);
                if (var10_3 != null) {
                    var10_3 = var10_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var10_3 = null;
                }
                if ((var8_1 & 12290L) == 0L) ** GOTO lbl-1000
                var11_4 = var14_2 != null ? var14_2.b() : null;
                this.a(1, var11_4);
                if (var11_4 != null) {
                    var11_4 = var11_4.a();
                } else lbl-1000: // 2 sources:
                {
                    var11_4 = null;
                }
                if ((var8_1 & 12292L) != 0L) {
                    var12_5 = var14_2 != null ? var14_2.p() : null;
                    this.a(2, var12_5);
                    var12_5 = var12_5 != null ? var12_5.a() : null;
                    var1_6 = ViewDataBinding.a(var12_5);
                } else {
                    var1_6 = 0;
                }
                if ((var8_1 & 12304L) == 0L) ** GOTO lbl-1000
                var12_5 = var14_2 != null ? var14_2.n() : null;
                this.a(4, var12_5);
                if (var12_5 != null) {
                    var12_5 = (Drawable)var12_5.a();
                } else lbl-1000: // 2 sources:
                {
                    var12_5 = null;
                }
                if ((var8_1 & 12320L) != 0L) {
                    var13_7 = var14_2 != null ? var14_2.h() : null;
                    this.a(5, (LiveData<?>)var13_7);
                    var13_7 = var13_7 != null ? var13_7.a() : null;
                    var3_8 = ViewDataBinding.a(var13_7);
                } else {
                    var3_8 = 0;
                }
                if ((var8_1 & 12352L) != 0L) {
                    var13_7 = var14_2 != null ? var14_2.l() : null;
                    this.a(6, (LiveData<?>)var13_7);
                    var13_7 = var13_7 != null ? (Integer)var13_7.a() : null;
                    var4_9 = ViewDataBinding.a(var13_7);
                } else {
                    var4_9 = 0;
                }
                if ((var8_1 & 12416L) != 0L) {
                    var13_7 = var14_2 != null ? var14_2.f() : null;
                    this.a(7, (LiveData<?>)var13_7);
                    var13_7 = var13_7 != null ? (Integer)var13_7.a() : null;
                    var2_10 = ViewDataBinding.a(var13_7);
                } else {
                    var2_10 = 0;
                }
                if ((var8_1 & 12800L) != 0L) {
                    var13_7 = var14_2 != null ? var14_2.r() : null;
                    this.a(9, (LiveData<?>)var13_7);
                    var13_7 = var13_7 != null ? (Integer)var13_7.a() : null;
                    var5_11 = ViewDataBinding.a(var13_7);
                } else {
                    var5_11 = 0;
                }
                if ((var8_1 & 13312L) != 0L) {
                    var13_7 = var14_2 != null ? var14_2.q() : null;
                    this.a(10, (LiveData<?>)var13_7);
                    var13_7 = var13_7 != null ? (Integer)var13_7.a() : null;
                    var7_12 = ViewDataBinding.a(var13_7);
                } else {
                    var7_12 = 0;
                }
                if ((var8_1 & 14336L) != 0L) {
                    var13_7 = var14_2 != null ? var14_2.m() : null;
                    this.a(11, (LiveData<?>)var13_7);
                    var13_7 = var13_7 != null ? (Integer)var13_7.a() : null;
                    var6_13 = ViewDataBinding.a((Integer)var13_7);
                } else {
                    var6_13 = 0;
                }
                break block36;
            }
            var6_13 = 0;
            var10_3 = null;
            var11_4 = null;
            var3_8 = 0;
            var4_9 = 0;
            var5_11 = 0;
            var7_12 = 0;
            var1_6 = 0;
            var12_5 = null;
            var2_10 = 0;
        }
        if ((var8_1 & 8192L) != 0L) {
            this.c.setOnClickListener(this.w);
            this.h.setOnClickListener(this.x);
            this.j.setOnClickListener(this.v);
        }
        if ((var8_1 & 12288L) != 0L) {
            this.d.a(var14_2);
            this.e.a(var14_2);
        }
        if ((var8_1 & 12304L) != 0L) {
            c.a(this.f, (Drawable)var12_5);
        }
        if ((var8_1 & 14336L) != 0L) {
            this.f.setVisibility(var6_13);
        }
        if ((12352L & var8_1) != 0L) {
            this.g.setVisibility(var4_9);
        }
        if ((13312L & var8_1) != 0L) {
            this.h.setVisibility(var7_12);
        }
        if ((var8_1 & 12290L) != 0L) {
            androidx.databinding.a.e.a(this.i, (CharSequence)var11_4);
        }
        if ((12416L & var8_1) != 0L) {
            this.t.setVisibility(var2_10);
        }
        if ((var8_1 & 12320L) != 0L) {
            this.u.setVisibility(var3_8);
        }
        if ((12800L & var8_1) != 0L) {
            this.j.setVisibility(var5_11);
        }
        if ((var8_1 & 12289L) != 0L) {
            androidx.databinding.a.e.a(this.k, (CharSequence)var10_3);
        }
        if ((var8_1 & 12292L) != 0L) {
            this.k.setVisibility(var1_6);
        }
        aj.a(this.d);
        aj.a(this.e);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.y = 8192L;
        }
        this.d.c();
        this.e.c();
        this.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public boolean d() {
        // MONITORENTER : this
        if (this.y != 0L) {
            // MONITOREXIT : this
            return true;
        }
        // MONITOREXIT : this
        if (this.d.d()) {
            return true;
        }
        if (!this.e.d()) return false;
        return true;
    }
}

