/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.a.g;
import androidx.lifecycle.LiveData;
import jp.co.jreast.jreastapp.commuter.c.ck;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.webview.j;

public class cl
extends ck
implements b.a {
    private static final ViewDataBinding.b k;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p = -1L;

    static {
        l = new SparseIntArray();
        l.put(2131230905, 6);
        l.put(2131231099, 7);
    }

    public cl(androidx.databinding.e e2, View view) {
        this(e2, view, cl.a(e2, view, 8, k, l));
    }

    private cl(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 5, (AppCompatImageButton)arrobject[5], (ConstraintLayout)((Object)arrobject[6]), (TextView)arrobject[3], (TextView)arrobject[1], (ConstraintLayout)((Object)arrobject[2]), (AppCompatImageView)arrobject[7], (TextView)arrobject[4]);
        this.c.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.m = (ConstraintLayout)((Object)arrobject[0]);
        this.m.setTag(null);
        this.i.setTag(null);
        this.a(view);
        this.n = new b(this, 1);
        this.o = new b(this, 2);
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
    private boolean b(LiveData<CharSequence> liveData, int n2) {
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
    private boolean c(LiveData<String> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.p |= 4L;
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
    private boolean d(LiveData<Boolean> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.p |= 8L;
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
                this.p |= 16L;
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
                object = this.j;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).L();
                return;
            }
            case 1: {
                object = this.j;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((j)object).I();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(j j2) {
        this.j = j2;
        synchronized (this) {
            this.p |= 32L;
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
        block19 : {
            block18 : {
                // MONITORENTER : this
                var2_1 = this.p;
                this.p = 0L;
                // MONITOREXIT : this
                var8_2 = this.j;
                if ((127L & var2_1) == 0L) break block18;
                if ((var2_1 & 97L) != 0L) {
                    var5_3 = var8_2 != null ? var8_2.j() : null;
                    this.a(0, var5_3);
                    var5_3 = var5_3 != null ? var5_3.a() : null;
                    var1_4 = ViewDataBinding.a(var5_3);
                } else {
                    var1_4 = 0;
                }
                if ((var2_1 & 98L) == 0L) ** GOTO lbl-1000
                var5_3 = var8_2 != null ? var8_2.e() : null;
                this.a(1, var5_3);
                if (var5_3 != null) {
                    var5_3 = (CharSequence)var5_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var5_3 = null;
                }
                if ((var2_1 & 100L) == 0L) ** GOTO lbl-1000
                var6_5 = var8_2 != null ? var8_2.d() : null;
                this.a(2, var6_5);
                if (var6_5 != null) {
                    var6_5 = var6_5.a();
                } else lbl-1000: // 2 sources:
                {
                    var6_5 = null;
                }
                if ((var2_1 & 104L) != 0L) {
                    var7_6 = var8_2 != null ? var8_2.i() : null;
                    this.a(3, var7_6);
                    var7_6 = var7_6 != null ? var7_6.a() : null;
                    var4_7 = ViewDataBinding.a(var7_6);
                } else {
                    var4_7 = false;
                }
                if ((var2_1 & 112L) == 0L) ** GOTO lbl-1000
                var7_6 = var8_2 != null ? var8_2.c() : null;
                this.a(4, var7_6);
                if (var7_6 != null) {
                    var7_6 = (String)var7_6.a();
                } else lbl-1000: // 2 sources:
                {
                    var7_6 = null;
                }
                break block19;
            }
            var7_6 = null;
            var1_4 = 0;
            var5_3 = null;
            var4_7 = false;
            var6_5 = null;
        }
        if ((64L & var2_1) != 0L) {
            this.c.setOnClickListener(this.o);
        }
        if ((100L & var2_1) != 0L) {
            e.a(this.e, var6_5);
        }
        if ((112L & var2_1) != 0L) {
            e.a(this.f, var7_6);
        }
        if ((var2_1 & 97L) != 0L) {
            this.g.setVisibility(var1_4);
        }
        if ((104L & var2_1) != 0L) {
            g.a((View)this.g, this.n, var4_7);
        }
        if ((var2_1 & 98L) == 0L) return;
        e.a(this.i, (CharSequence)var5_3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.p = 64L;
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

