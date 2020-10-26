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
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.c;
import jp.co.jreast.jreastapp.commuter.h.a.a;
import jp.co.jreast.jreastapp.commuter.h.a.b;

public class d
extends c
implements a.a,
b.a {
    private static final ViewDataBinding.b i;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final e.a o;
    private g p = new g(){

        @Override
        public void a() {
            String string2 = androidx.databinding.a.e.a((TextView)d.this.g);
            Object object = d.this.h;
            boolean bl2 = false;
            boolean bl3 = object != null;
            if (bl3) {
                object = ((jp.co.jreast.jreastapp.commuter.trainlocation.d)object).e();
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
    private long q = -1L;

    static {
        j = new SparseIntArray();
        j.put(2131231142, 4);
        j.put(2131231008, 5);
    }

    public d(e e2, View view) {
        this(e2, view, d.a(e2, view, 6, i, j));
    }

    private d(e e2, View view, Object[] arrobject) {
        super(e2, view, 2, (AppCompatImageView)arrobject[2], (AppCompatImageView)arrobject[3], (RecyclerView)arrobject[5], (AppCompatImageView)arrobject[4], (AppCompatEditText)arrobject[1]);
        this.c.setTag(null);
        this.d.setTag(null);
        this.k = (ConstraintLayout)((Object)arrobject[0]);
        this.k.setTag(null);
        this.g.setTag(null);
        this.a(view);
        this.l = new b(this, 3);
        this.m = new b(this, 1);
        this.n = new b(this, 4);
        this.o = new a(this, 2);
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
                this.q |= 2L;
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
                this.q |= 1L;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(int n2, Editable editable) {
        jp.co.jreast.jreastapp.commuter.trainlocation.d d2 = this.h;
        n2 = d2 != null ? 1 : 0;
        if (n2 != 0) {
            d2.a(editable);
        }
    }

    @Override
    public final void a(int n2, View object) {
        block11 : {
            int n3;
            block10 : {
                int n4 = 0;
                n3 = 0;
                int n5 = 0;
                if (n2 == 1) break block10;
                switch (n2) {
                    default: {
                        return;
                    }
                    case 4: {
                        object = this.h;
                        n2 = n5;
                        if (object != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            ((jp.co.jreast.jreastapp.commuter.trainlocation.d)object).h();
                            return;
                        }
                        break block11;
                    }
                    case 3: {
                        object = this.h;
                        n2 = n4;
                        if (object != null) {
                            n2 = 1;
                        }
                        if (n2 != 0) {
                            ((jp.co.jreast.jreastapp.commuter.trainlocation.d)object).i();
                            return;
                        }
                        break block11;
                    }
                }
            }
            object = this.h;
            n2 = n3;
            if (object != null) {
                n2 = 1;
            }
            if (n2 != 0) {
                ((jp.co.jreast.jreastapp.commuter.trainlocation.d)object).j();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(jp.co.jreast.jreastapp.commuter.trainlocation.d d2) {
        this.h = d2;
        synchronized (this) {
            this.q |= 4L;
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
        block9 : {
            block8 : {
                // MONITORENTER : this
                var2_1 = this.q;
                this.q = 0L;
                // MONITOREXIT : this
                var6_2 = this.h;
                var1_3 = 0;
                if ((15L & var2_1) == 0L) break block8;
                if ((var2_1 & 13L) == 0L) ** GOTO lbl-1000
                var4_4 = var6_2 != null ? var6_2.e() : null;
                this.a(0, var4_4);
                if (var4_4 != null) {
                    var4_4 = (String)var4_4.a();
                } else lbl-1000: // 2 sources:
                {
                    var4_4 = null;
                }
                var5_5 = var4_4;
                if ((var2_1 & 14L) != 0L) {
                    var5_5 = var6_2 != null ? var6_2.f() : null;
                    this.a(1, (LiveData<?>)var5_5);
                    var5_5 = var5_5 != null ? (Integer)var5_5.a() : null;
                    var1_3 = ViewDataBinding.a((Integer)var5_5);
                    var5_5 = var4_4;
                }
                break block9;
            }
            var5_5 = null;
        }
        if ((8L & var2_1) != 0L) {
            this.c.setOnClickListener(this.l);
            this.d.setOnClickListener(this.n);
            this.k.setOnClickListener(this.m);
            androidx.databinding.a.e.a((TextView)this.g, null, null, this.o, this.p);
        }
        if ((var2_1 & 14L) != 0L) {
            this.c.setVisibility(var1_3);
        }
        if ((var2_1 & 13L) == 0L) return;
        androidx.databinding.a.e.a((TextView)this.g, var5_5);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.q = 8L;
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
            return this.q != 0L;
            {
            }
        }
    }

}

