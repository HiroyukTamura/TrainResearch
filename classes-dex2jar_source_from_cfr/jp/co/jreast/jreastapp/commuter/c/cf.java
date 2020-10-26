/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.c;
import androidx.databinding.a.e;
import jp.co.jreast.jreastapp.commuter.c.ce;
import jp.co.jreast.jreastapp.commuter.h.a.b;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;
import jp.co.jreast.jreastapp.commuter.q.h;

public class cf
extends ce
implements b.a {
    private static final ViewDataBinding.b B;
    private static final SparseIntArray C;
    private final View.OnClickListener D;
    private long E = -1L;

    static {
        C = new SparseIntArray();
        C.put(2131231284, 14);
        C.put(2131231010, 15);
        C.put(2131231004, 16);
        C.put(2131231173, 17);
        C.put(2131230822, 18);
        C.put(2131230857, 19);
        C.put(2131230875, 20);
        C.put(2131230795, 21);
    }

    public cf(androidx.databinding.e e2, View view) {
        this(e2, view, cf.a(e2, view, 22, B, C));
    }

    private cf(androidx.databinding.e e2, View view, Object[] arrobject) {
        super(e2, view, 0, (AppCompatImageView)arrobject[21], (ConstraintLayout)((Object)arrobject[18]), (TextView)arrobject[2], (TextView)arrobject[3], (TextView)arrobject[9], (TextView)arrobject[8], (AppCompatImageView)arrobject[19], (AppCompatImageView)arrobject[10], (AppCompatImageView)arrobject[20], (TextView)arrobject[13], (AppCompatImageView)arrobject[16], (AppCompatTextView)arrobject[1], (ConstraintLayout)((Object)arrobject[15]), (TextView)arrobject[5], (TextView)arrobject[4], (TextView)arrobject[7], (TextView)arrobject[6], (View)arrobject[11], (View)arrobject[17], (ConstraintLayout)((Object)arrobject[14]), (ConstraintLayout)((Object)arrobject[12]), (ConstraintLayout)((Object)arrobject[0]));
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        this.l.setTag(null);
        this.n.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.a(view);
        this.D = new b(this, 1);
        this.c();
    }

    @Override
    public final void a(int n2, View view) {
        int n3 = this.y;
        LineServiceStatusItem lineServiceStatusItem = this.A;
        h h2 = this.z;
        n2 = h2 != null ? 1 : 0;
        if (n2 != 0) {
            h2.a(view, n3, lineServiceStatusItem);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(LineServiceStatusItem lineServiceStatusItem) {
        this.A = lineServiceStatusItem;
        synchronized (this) {
            this.E |= 1L;
        }
        this.a(12);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(h h2) {
        this.z = h2;
        synchronized (this) {
            this.E |= 4L;
        }
        this.a(11);
        super.f();
    }

    @Override
    protected boolean a(int n2, Object object, int n3) {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void b() {
        Object object;
        Object object2;
        Object object3;
        int n2;
        Object object4;
        Object object5;
        long l2;
        int n3;
        Object object6;
        synchronized (this) {
            l2 = this.E;
            this.E = 0L;
        }
        Object object7 = this.A;
        int n4 = this.y;
        Object object8 = this.z;
        Object object9 = null;
        Object object10 = null;
        int n5 = 0;
        n4 = (int)(l2 & 13L LCMP 0L);
        if (n4 != 0) {
            boolean bl2;
            boolean bl3;
            object2 = object7 != null ? ((LineServiceStatusItem)object7).getLineServiceStatus() : null;
            if (object8 != null) {
                bl3 = ((h)object8).b((LineServiceStatus)object2);
                object7 = ((h)object8).a((LineServiceStatus)object2);
                bl2 = ((h)object8).c((LineServiceStatus)object2);
            } else {
                object7 = null;
                bl2 = false;
                bl3 = false;
            }
            long l3 = l2;
            if (n4 != 0) {
                l3 = bl3 ? 32L : 16L;
                l3 = l2 | l3;
            }
            l2 = l3;
            if ((l3 & 13L) != 0L) {
                l2 = bl2 ? 8192L : 4096L;
                l2 = l3 | l2;
            }
            n4 = bl3 ? 8 : 0;
            n2 = bl2 ? 8 : 0;
            n3 = (int)(l2 & 9L LCMP 0L);
            if (n3 != 0) {
                if (object2 != null) {
                    object10 = ((LineServiceStatus)object2).getResumeTime();
                    object6 = ((LineServiceStatus)object2).getDelayDetailText();
                    object4 = ((LineServiceStatus)object2).getLineName();
                    object8 = ((LineServiceStatus)object2).getDelayDirection();
                    object5 = ((LineServiceStatus)object2).getOccurrenceTime();
                    object3 = ((LineServiceStatus)object2).getDelayStatus();
                    bl2 = ((LineServiceStatus)object2).getDetailVisibility();
                    object2 = ((LineServiceStatus)object2).getDelayReason();
                } else {
                    object3 = object5 = (object8 = (object4 = (object6 = (object2 = null))));
                    bl2 = false;
                }
                l3 = l2;
                if (n3 != 0) {
                    if (bl2) {
                        l2 = l2 | 128L | 512L;
                        l3 = 2048L;
                    } else {
                        l2 = l2 | 64L | 256L;
                        l3 = 1024L;
                    }
                    l3 = l2 | l3;
                }
                n3 = bl2 ? 8 : 0;
                if (!bl2) {
                    n5 = 8;
                }
                object = bl2 ? cf.a((View)this.j, 2131165382) : cf.a((View)this.j, 2131165381);
                int n6 = n2;
                int n7 = n4;
                n2 = n5;
                object9 = object7;
                n4 = n3;
                Object object11 = object10;
                Object object12 = object8;
                object7 = object2;
                l2 = l3;
                object2 = object3;
                object8 = object;
                object10 = object6;
                object3 = object4;
                object = object12;
                object4 = object11;
                object6 = object9;
                n3 = n7;
                n5 = n6;
            } else {
                n5 = n2;
                n3 = n4;
                object = null;
                object4 = object5 = (object3 = (object10 = (object8 = (object2 = object))));
                object6 = object7;
                n4 = 0;
                n2 = 0;
                object7 = object;
                object = object9;
            }
        } else {
            object6 = object4 = (object5 = (object3 = (object10 = (object8 = (object2 = (object7 = null))))));
            n4 = 0;
            n2 = 0;
            n3 = 0;
            n5 = 0;
            object = object9;
        }
        if ((9L & l2) != 0L) {
            e.a(this.e, object);
            e.a(this.g, (CharSequence)object7);
            e.a(this.h, (CharSequence)object2);
            c.a(this.j, (Drawable)object8);
            e.a(this.l, (CharSequence)object10);
            e.a(this.n, (CharSequence)object3);
            e.a(this.p, (CharSequence)object5);
            e.a(this.r, (CharSequence)object4);
            this.t.setVisibility(n4);
            this.w.setVisibility(n2);
        }
        if ((13L & l2) != 0L) {
            e.a(this.f, (CharSequence)object6);
            this.p.setVisibility(n3);
            this.q.setVisibility(n3);
            this.r.setVisibility(n5);
            this.s.setVisibility(n5);
        }
        if ((l2 & 8L) != 0L) {
            e.a(this.q, (CharSequence)this.q.getResources().getString(2131558541));
            e.a(this.s, (CharSequence)this.s.getResources().getString(2131558565));
            this.x.setOnClickListener(this.D);
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
            this.E = 8L;
        }
        this.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c(int n2) {
        this.y = n2;
        synchronized (this) {
            this.E |= 2L;
        }
        this.a(14);
        super.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean d() {
        synchronized (this) {
            return this.E != 0L;
            {
            }
        }
    }
}

