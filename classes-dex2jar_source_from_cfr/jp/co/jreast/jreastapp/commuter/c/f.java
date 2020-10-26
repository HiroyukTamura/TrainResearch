/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.e;
import jp.co.jreast.jreastapp.commuter.candidatestation.c;
import jp.co.jreast.jreastapp.commuter.h.a.a;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class f
extends e
implements a.a,
b.a {
    private static final ViewDataBinding.b m;
    private static final SparseIntArray n;
    private final ConstraintLayout o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final e.a s;
    private final View.OnClickListener t;
    private g u = new g(){

        @Override
        public void a() {
            String string2 = androidx.databinding.a.e.a((TextView)f.this.i);
            Object object = f.this.l;
            boolean bl2 = false;
            boolean bl3 = object != null;
            if (bl3) {
                object = ((c)object).o();
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
    private long v = -1L;

    static {
        n = new SparseIntArray();
        n.put(2131231142, 8);
        n.put(2131231217, 9);
    }

    public f(androidx.databinding.e e2, View view) {
        this(e2, view, f.a(e2, view, 10, m, n));
    }

    private f(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 8, (AppCompatImageView)arrobject[2], (AppCompatImageView)arrobject[3], (TextView)arrobject[7], (TextView)arrobject[6], (TextView)arrobject[5], (AppCompatImageView)arrobject[8], (AppCompatEditText)arrobject[1], (TextView)arrobject[4], (RecyclerView)arrobject[9]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.o = (ConstraintLayout)((Object)arrobject[0]);
        this.o.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.a(view);
        this.p = new b(this, 3);
        this.q = new b(this, 4);
        this.r = new b(this, 1);
        this.s = new a(this, 2);
        this.t = new b(this, 5);
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.v |= 1L;
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
                this.v |= 8L;
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
                this.v |= 2L;
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
                this.v |= 4L;
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
    private boolean d(LiveData<Integer> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.v |= 16L;
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
                this.v |= 32L;
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
                this.v |= 64L;
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
                this.v |= 128L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, Editable editable) {
        c c2 = this.l;
        n2 = c2 != null ? 1 : 0;
        if (n2 != 0) {
            c2.a(editable);
        }
    }

    @Override
    public final void a(int n2, View object) {
        block14 : {
            int n3;
            block13 : {
                int n4 = 0;
                int n5 = 0;
                n3 = 0;
                int n6 = 0;
                if (n2 == 1) break block13;
                switch (n2) {
                    default: {
                        return;
                    }
                    case 5: {
                        object = this.l;
                        n2 = n6;
                        if (object != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            ((c)object).s();
                            return;
                        }
                        break block14;
                    }
                    case 4: {
                        object = this.l;
                        n2 = n4;
                        if (object != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            ((c)object).q();
                            return;
                        }
                        break block14;
                    }
                    case 3: {
                        object = this.l;
                        n2 = n5;
                        if (object != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            ((c)object).t();
                            return;
                        }
                        break block14;
                    }
                }
            }
            object = this.l;
            n2 = n3;
            if (object != null) {
                n2 = 1;
            }
            if (n2 != 0) {
                ((c)object).r();
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
        this.l = c2;
        synchronized (this) {
            this.v |= 256L;
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
        block28 : {
            block27 : {
                // MONITORENTER : this
                var6_1 = this.v;
                this.v = 0L;
                // MONITOREXIT : this
                var12_2 = this.l;
                if ((1023L & var6_1) == 0L) break block27;
                if ((var6_1 & 769L) != 0L) {
                    var9_3 = var12_2 != null ? var12_2.d() : null;
                    this.a(0, var9_3);
                    var9_3 = var9_3 != null ? var9_3.a() : null;
                    var1_4 = ViewDataBinding.a(var9_3);
                } else {
                    var1_4 = 0;
                }
                if ((var6_1 & 770L) != 0L) {
                    var9_3 = var12_2 != null ? var12_2.i() : null;
                    this.a(1, var9_3);
                    var9_3 = var9_3 != null ? (Boolean)var9_3.a() : null;
                    var8_5 = ViewDataBinding.a(var9_3);
                } else {
                    var8_5 = false;
                }
                if ((var6_1 & 772L) != 0L) {
                    var9_3 = var12_2 != null ? var12_2.c() : null;
                    this.a(2, var9_3);
                    var9_3 = var9_3 != null ? (Integer)var9_3.a() : null;
                    var2_6 = ViewDataBinding.a(var9_3);
                } else {
                    var2_6 = 0;
                }
                if ((var6_1 & 776L) == 0L) ** GOTO lbl-1000
                var9_3 = var12_2 != null ? var12_2.o() : null;
                this.a(3, var9_3);
                if (var9_3 != null) {
                    var9_3 = (String)var9_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var9_3 = null;
                }
                if ((var6_1 & 784L) != 0L) {
                    var10_7 = var12_2 != null ? var12_2.f() : null;
                    this.a(4, var10_7);
                    var10_7 = var10_7 != null ? var10_7.a() : null;
                    var3_8 = ViewDataBinding.a(var10_7);
                } else {
                    var3_8 = 0;
                }
                if ((var6_1 & 800L) == 0L) ** GOTO lbl-1000
                var10_7 = var12_2 != null ? var12_2.h() : null;
                this.a(5, var10_7);
                if (var10_7 != null) {
                    var10_7 = (String)var10_7.a();
                } else lbl-1000: // 2 sources:
                {
                    var10_7 = null;
                }
                if ((var6_1 & 832L) != 0L) {
                    var11_9 = var12_2 != null ? var12_2.e() : null;
                    this.a(6, (LiveData<?>)var11_9);
                    var11_9 = var11_9 != null ? var11_9.a() : null;
                    var4_10 = ViewDataBinding.a(var11_9);
                } else {
                    var4_10 = 0;
                }
                if ((var6_1 & 896L) != 0L) {
                    var11_9 = var12_2 != null ? var12_2.p() : null;
                    this.a(7, (LiveData<?>)var11_9);
                    var11_9 = var11_9 != null ? (Integer)var11_9.a() : null;
                    var5_11 = ViewDataBinding.a((Integer)var11_9);
                } else {
                    var5_11 = 0;
                }
                break block28;
            }
            var5_11 = 0;
            var1_4 = 0;
            var2_6 = 0;
            var8_5 = false;
            var9_3 = null;
            var10_7 = null;
            var4_10 = 0;
            var3_8 = 0;
        }
        if ((var6_1 & 512L) != 0L) {
            this.c.setOnClickListener(this.p);
            this.d.setOnClickListener(this.q);
            this.g.setOnClickListener(this.t);
            this.o.setOnClickListener(this.r);
            androidx.databinding.a.e.a((TextView)this.i, null, null, this.s, this.u);
        }
        if ((var6_1 & 896L) != 0L) {
            this.c.setVisibility(var5_11);
        }
        if ((var6_1 & 769L) != 0L) {
            this.e.setVisibility(var1_4);
        }
        if ((784L & var6_1) != 0L) {
            this.f.setVisibility(var3_8);
        }
        if ((800L & var6_1) != 0L) {
            androidx.databinding.a.e.a(this.g, var10_7);
        }
        if ((832L & var6_1) != 0L) {
            this.g.setVisibility(var4_10);
            this.j.setVisibility(var4_10);
        }
        if ((var6_1 & 770L) != 0L) {
            this.i.setEnabled(var8_5);
        }
        if ((var6_1 & 772L) != 0L) {
            this.i.setHint(var2_6);
        }
        if ((var6_1 & 776L) == 0L) return;
        androidx.databinding.a.e.a((TextView)this.i, (CharSequence)var9_3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.v = 512L;
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
            return this.v != 0L;
            {
            }
        }
    }

}

