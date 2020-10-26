/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import jp.co.jreast.jreastapp.commuter.c.o;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.push.c;

public class p
extends o
implements b.a {
    private static final ViewDataBinding.b i;
    private static final SparseIntArray j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private g n = new g(){

        @Override
        public void a() {
            String string2 = androidx.databinding.a.e.a(p.this.d);
            Object object = p.this.h;
            boolean bl2 = false;
            boolean bl3 = object != null;
            if (bl3) {
                object = ((c)object).e();
                bl3 = bl2;
                if (object != null) {
                    bl3 = true;
                }
                if (bl3) {
                    ((androidx.lifecycle.p)object).b(string2);
                }
            }
        }
    };
    private g o = new g(){

        @Override
        public void a() {
            String string2 = androidx.databinding.a.e.a(p.this.g);
            Object object = p.this.h;
            boolean bl2 = false;
            boolean bl3 = object != null;
            if (bl3) {
                object = ((c)object).d();
                bl3 = bl2;
                if (object != null) {
                    bl3 = true;
                }
                if (bl3) {
                    ((androidx.lifecycle.p)object).b(string2);
                }
            }
        }
    };
    private long p = -1L;

    public p(e e2, View view) {
        this(e2, view, p.a(e2, view, 5, i, j));
    }

    private p(e e2, View view, Object[] arrobject) {
        super(e2, view, 2, (Button)arrobject[4], (TextView)arrobject[2], (Button)arrobject[3], (FrameLayout)arrobject[0], (TextView)arrobject[1]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.a(view);
        this.k = new b(this, 3);
        this.l = new b(this, 1);
        this.m = new b(this, 2);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(androidx.lifecycle.p<String> p2, int n2) {
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
    private boolean b(androidx.lifecycle.p<String> p2, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.p |= 2L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, View object) {
        block10 : {
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            switch (n2) {
                default: {
                    return;
                }
                case 3: {
                    object = this.h;
                    n2 = n5;
                    if (object != null) {
                        n2 = 1;
                    }
                    if (n2 != 0) {
                        break;
                    }
                    break block10;
                }
                case 2: {
                    object = this.h;
                    n2 = n3;
                    if (object != null) {
                        n2 = 1;
                    }
                    if (n2 != 0) {
                        ((c)object).f();
                        return;
                    }
                    break block10;
                }
                case 1: {
                    object = this.h;
                    n2 = n4;
                    if (object != null) {
                        n2 = 1;
                    }
                    if (n2 == 0) break block10;
                }
            }
            ((c)object).g();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c c2) {
        this.h = c2;
        synchronized (this) {
            this.p |= 4L;
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
                return this.b((androidx.lifecycle.p)object, n3);
            }
            case 0: 
        }
        return this.a((androidx.lifecycle.p)object, n3);
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
                var1_1 = this.p;
                this.p = 0L;
                // MONITOREXIT : this
                var4_2 = this.h;
                if ((15L & var1_1) == 0L) break block9;
                if ((var1_1 & 13L) == 0L) ** GOTO lbl-1000
                var3_3 = var4_2 != null ? var4_2.d() : null;
                this.a(0, var3_3);
                if (var3_3 != null) {
                    var3_3 = (String)var3_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var3_3 = null;
                }
                if ((var1_1 & 14L) == 0L) ** GOTO lbl-1000
                var4_2 = var4_2 != null ? var4_2.e() : null;
                this.a(1, var4_2);
                if (var4_2 != null) {
                    var4_2 = (String)var4_2.a();
                } else lbl-1000: // 2 sources:
                {
                    var4_2 = null;
                }
                break block10;
            }
            var3_3 = var4_2 = null;
        }
        if ((8L & var1_1) != 0L) {
            this.c.setOnClickListener(this.k);
            var5_4 = this.d;
            var6_5 = null;
            var7_6 = null;
            var8_7 = null;
            androidx.databinding.a.e.a(var5_4, var6_5, var7_6, var8_7, this.n);
            this.e.setOnClickListener(this.m);
            this.f.setOnClickListener(this.l);
            androidx.databinding.a.e.a(this.g, var6_5, var7_6, var8_7, this.o);
        }
        if ((var1_1 & 14L) != 0L) {
            androidx.databinding.a.e.a(this.d, (CharSequence)var4_2);
        }
        if ((var1_1 & 13L) == 0L) return;
        androidx.databinding.a.e.a(this.g, (CharSequence)var3_3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.p = 8L;
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

