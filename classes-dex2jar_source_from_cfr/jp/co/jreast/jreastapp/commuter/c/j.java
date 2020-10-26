/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.i;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class j
extends i
implements b.a {
    private static final ViewDataBinding.b h;
    private static final SparseIntArray i;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private g o = new g(){

        @Override
        public void a() {
            String string2 = androidx.databinding.a.e.a((TextView)j.this.e);
            Object object = j.this.g;
            boolean bl2 = false;
            boolean bl3 = object != null;
            if (bl3) {
                object = ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object).d();
                bl3 = bl2;
                if (object != null) {
                    bl3 = true;
                }
                if (bl3) {
                    ((p)object).b(string2);
                }
            }
        }
    };
    private long p = -1L;

    public j(e e2, View view) {
        this(e2, view, j.a(e2, view, 5, h, i));
    }

    private j(e e2, View view, Object[] arrobject) {
        super(e2, view, 3, (AppCompatImageView)arrobject[3], (AppCompatImageView)arrobject[2], (AppCompatEditText)arrobject[1], (Button)arrobject[4]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.j = (ConstraintLayout)((Object)arrobject[0]);
        this.j.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.a(view);
        this.k = new b(this, 4);
        this.l = new b(this, 1);
        this.m = new b(this, 3);
        this.n = new b(this, 2);
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
    private boolean a(p<String> p2, int n2) {
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
    private boolean b(LiveData<Integer> liveData, int n2) {
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
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        switch (n2) {
            default: {
                return;
            }
            case 4: {
                object = this.g;
                n2 = n6;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object).i();
                return;
            }
            case 3: {
                object = this.g;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object).h();
                return;
            }
            case 2: {
                object = this.g;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object).j();
                return;
            }
            case 1: {
                object = this.g;
                n2 = n5;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object).g();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(jp.co.jreast.jreastapp.commuter.favoriteroute.b b2) {
        this.g = b2;
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
                return this.b((LiveData)object, n3);
            }
            case 1: {
                return this.a((LiveData)object, n3);
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
        block13 : {
            block12 : {
                // MONITORENTER : this
                var2_1 = this.p;
                this.p = 0L;
                // MONITOREXIT : this
                var7_2 = this.g;
                if ((31L & var2_1) == 0L) break block12;
                if ((var2_1 & 25L) == 0L) ** GOTO lbl-1000
                var5_3 = var7_2 != null ? var7_2.d() : null;
                this.a(0, var5_3);
                if (var5_3 != null) {
                    var5_3 = (String)var5_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var5_3 = null;
                }
                if ((var2_1 & 26L) != 0L) {
                    var6_4 = var7_2 != null ? var7_2.f() : null;
                    this.a(1, (LiveData<?>)var6_4);
                    var6_4 = var6_4 != null ? var6_4.a() : null;
                    var4_5 = ViewDataBinding.a(var6_4);
                } else {
                    var4_5 = false;
                }
                if ((var2_1 & 28L) != 0L) {
                    var6_4 = var7_2 != null ? var7_2.e() : null;
                    this.a(2, (LiveData<?>)var6_4);
                    var6_4 = var6_4 != null ? (Integer)var6_4.a() : null;
                    var1_6 = ViewDataBinding.a((Integer)var6_4);
                } else {
                    var1_6 = 0;
                }
                break block13;
            }
            var5_3 = null;
            var1_6 = 0;
            var4_5 = false;
        }
        if ((var2_1 & 16L) != 0L) {
            this.c.setOnClickListener(this.m);
            this.d.setOnClickListener(this.n);
            this.j.setOnClickListener(this.l);
            androidx.databinding.a.e.a((TextView)this.e, null, null, null, this.o);
            this.f.setOnClickListener(this.k);
        }
        if ((var2_1 & 28L) != 0L) {
            this.d.setVisibility(var1_6);
        }
        if ((25L & var2_1) != 0L) {
            androidx.databinding.a.e.a((TextView)this.e, (CharSequence)var5_3);
        }
        if ((var2_1 & 26L) == 0L) return;
        this.f.setEnabled(var4_5);
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

