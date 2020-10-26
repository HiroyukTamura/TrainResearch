/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  android.widget.Toolbar
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.lifecycle.LiveData;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import jp.co.jreast.jreastapp.commuter.c.bg;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;

public class bh
extends bg {
    private static final ViewDataBinding.b j;
    private static final SparseIntArray k;
    private final TextView l;
    private long m = -1L;

    static {
        k = new SparseIntArray();
        k.put(2131231281, 2);
        k.put(2131231277, 3);
        k.put(2131231283, 4);
        k.put(2131230967, 5);
        k.put(2131231169, 6);
    }

    public bh(androidx.databinding.e e2, View view) {
        this(e2, view, bh.a(e2, view, 7, j, k));
    }

    private bh(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 2, (TabLayout)((Object)arrobject[5]), (View)arrobject[6], (Toolbar)arrobject[3], (ViewPager)((Object)arrobject[2]), (ConstraintLayout)((Object)arrobject[0]), (TabLayout)((Object)arrobject[4]));
        this.l = (TextView)arrobject[1];
        this.l.setTag(null);
        this.g.setTag(null);
        this.a(view);
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
                this.m |= 1L;
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
                this.m |= 2L;
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
    @Override
    public void a(y y2) {
        this.i = y2;
        synchronized (this) {
            this.m |= 4L;
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
                return this.b((LiveData)object, n3);
            }
            case 0: 
        }
        return this.a((LiveData)object, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void b() {
        long l2;
        synchronized (this) {
            l2 = this.m;
            this.m = 0L;
        }
        LiveData<String> liveData = this.i;
        int n2 = 0;
        int n3 = 0;
        LiveData<Integer> liveData2 = null;
        Object object = liveData2;
        if ((15L & l2) != 0L) {
            if ((l2 & 13L) != 0L) {
                object = liveData != null ? ((y)((Object)liveData)).g() : null;
                this.a(0, (LiveData<?>)object);
                object = object != null ? ((LiveData)object).a() : null;
                n3 = ViewDataBinding.a(object);
            }
            n2 = n3;
            object = liveData2;
            if ((l2 & 14L) != 0L) {
                liveData = liveData != null ? ((y)((Object)liveData)).f() : null;
                this.a(1, liveData);
                n2 = n3;
                object = liveData2;
                if (liveData != null) {
                    object = (String)liveData.a();
                    n2 = n3;
                }
            }
        }
        if ((l2 & 14L) != 0L) {
            e.a(this.l, object);
        }
        if ((l2 & 13L) != 0L) {
            this.l.setVisibility(n2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c() {
        synchronized (this) {
            this.m = 8L;
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
            return this.m != 0L;
            {
            }
        }
    }
}

