/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebView
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.c;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import jp.co.jreast.jreastapp.commuter.c.aa;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.webview.r;

public class ab
extends aa
implements b.a {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o = -1L;

    static {
        k = new SparseIntArray();
        k.put(2131231262, 5);
        k.put(2131231328, 6);
    }

    public ab(e e2, View view) {
        this(e2, view, ab.a(e2, view, 7, j, k));
    }

    private ab(e e2, View view, Object[] arrobject) {
        super(e2, view, 4, (AppCompatImageView)arrobject[3], (AppCompatImageButton)arrobject[4], (AppCompatImageView)arrobject[1], (LinearLayout)arrobject[5], (AppCompatTextView)arrobject[2], (WebView)arrobject[6]);
        this.c.setTag(null);
        this.l = (ConstraintLayout)((Object)arrobject[0]);
        this.l.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.a(view);
        this.m = new b(this, 1);
        this.n = new b(this, 2);
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
                this.o |= 2L;
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
                this.o |= 1L;
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
    private boolean b(LiveData<Drawable> liveData, int n2) {
        if (n2 == 0) {
            synchronized (this) {
                this.o |= 4L;
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
                this.o |= 8L;
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
                object = this.i;
                n2 = n4;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((r)object).m();
                return;
            }
            case 1: {
                object = this.i;
                n2 = n3;
                if (object != null) {
                    n2 = 1;
                }
                if (n2 == 0) break;
                ((r)object).l();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(r r2) {
        this.i = r2;
        synchronized (this) {
            this.o |= 16L;
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
                return this.c((LiveData)object, n3);
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
        block16 : {
            block15 : {
                // MONITORENTER : this
                var3_1 = this.o;
                this.o = 0L;
                // MONITOREXIT : this
                var7_2 = this.i;
                if ((63L & var3_1) == 0L) break block15;
                if ((var3_1 & 49L) == 0L) ** GOTO lbl-1000
                var5_3 = var7_2 != null ? var7_2.b() : null;
                this.a(0, var5_3);
                if (var5_3 != null) {
                    var5_3 = (String)var5_3.a();
                } else lbl-1000: // 2 sources:
                {
                    var5_3 = null;
                }
                if ((var3_1 & 50L) != 0L) {
                    var6_4 = var7_2 != null ? var7_2.i() : null;
                    this.a(1, var6_4);
                    var6_4 = var6_4 != null ? var6_4.a() : null;
                    var1_5 = ViewDataBinding.a(var6_4);
                } else {
                    var1_5 = 0;
                }
                if ((var3_1 & 52L) == 0L) ** GOTO lbl-1000
                var6_4 = var7_2 != null ? var7_2.h() : null;
                this.a(2, var6_4);
                if (var6_4 != null) {
                    var6_4 = (Drawable)var6_4.a();
                } else lbl-1000: // 2 sources:
                {
                    var6_4 = null;
                }
                if ((var3_1 & 56L) != 0L) {
                    var7_2 = var7_2 != null ? var7_2.g() : null;
                    this.a(3, (LiveData<?>)var7_2);
                    var7_2 = var7_2 != null ? (Integer)var7_2.a() : null;
                    var2_6 = ViewDataBinding.a((Integer)var7_2);
                } else {
                    var2_6 = 0;
                }
                break block16;
            }
            var2_6 = 0;
            var5_3 = null;
            var1_5 = 0;
            var6_4 = null;
        }
        if ((var3_1 & 32L) != 0L) {
            this.c.setOnClickListener(this.m);
            this.d.setOnClickListener(this.n);
        }
        if ((50L & var3_1) != 0L) {
            this.d.setVisibility(var1_5);
        }
        if ((var3_1 & 52L) != 0L) {
            c.a(this.e, (Drawable)var6_4);
        }
        if ((56L & var3_1) != 0L) {
            this.e.setVisibility(var2_6);
        }
        if ((var3_1 & 49L) == 0L) return;
        androidx.databinding.a.e.a(this.g, (CharSequence)var5_3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.o = 32L;
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
            return this.o != 0L;
            {
            }
        }
    }
}

