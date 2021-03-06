/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.n;
import java.util.List;

public class LinearLayoutManager
extends RecyclerView.i
implements RecyclerView.t.b {
    private c a;
    private boolean b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f;
    private final b g = new b();
    private int h = 2;
    int i = 1;
    j j;
    boolean k = false;
    int l = -1;
    int m = Integer.MIN_VALUE;
    d n = null;
    final a o = new a();

    public LinearLayoutManager(Context context, int n2, boolean bl2) {
        this.b(n2);
        this.b(bl2);
    }

    public LinearLayoutManager(Context object, AttributeSet attributeSet, int n2, int n3) {
        object = LinearLayoutManager.a(object, attributeSet, n2, n3);
        this.b(object.a);
        this.b(object.c);
        this.a(object.d);
    }

    private void K() {
        boolean bl2 = this.i != 1 && this.h() ? this.c ^ true : this.c;
        this.k = bl2;
    }

    private View L() {
        int n2 = this.k ? this.v() - 1 : 0;
        return this.i(n2);
    }

    private View M() {
        int n2 = this.k ? 0 : this.v() - 1;
        return this.i(n2);
    }

    private int a(int n2, RecyclerView.p p2, RecyclerView.u u2, boolean bl2) {
        int n3 = this.j.d() - n2;
        if (n3 > 0) {
            n3 = -this.c(-n3, p2, u2);
            if (bl2 && (n2 = this.j.d() - (n2 + n3)) > 0) {
                this.j.a(n2);
                return n2 + n3;
            }
            return n3;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private View a(boolean bl2, boolean bl3) {
        int n2;
        int n3;
        if (this.k) {
            n2 = this.v() - 1;
            n3 = -1;
            do {
                return this.a(n2, n3, bl2, bl3);
                break;
            } while (true);
        }
        n2 = 0;
        n3 = this.v();
        return this.a(n2, n3, bl2, bl3);
    }

    private void a(int n2, int n3) {
        this.a.c = this.j.d() - n3;
        c c2 = this.a;
        int n4 = this.k ? -1 : 1;
        c2.e = n4;
        this.a.d = n2;
        this.a.f = 1;
        this.a.b = n3;
        this.a.g = Integer.MIN_VALUE;
    }

    private void a(int n2, int n3, boolean bl2, RecyclerView.u object) {
        this.a.l = this.k();
        this.a.h = this.b((RecyclerView.u)object);
        this.a.f = n2;
        int n4 = -1;
        if (n2 == 1) {
            object = this.a;
            ((c)object).h += this.j.g();
            object = this.M();
            c c2 = this.a;
            if (!this.k) {
                n4 = 1;
            }
            c2.e = n4;
            this.a.d = this.d((View)object) + this.a.e;
            this.a.b = this.j.b((View)object);
            n2 = this.j.b((View)object) - this.j.d();
        } else {
            object = this.L();
            c c3 = this.a;
            c3.h += this.j.c();
            c3 = this.a;
            if (this.k) {
                n4 = 1;
            }
            c3.e = n4;
            this.a.d = this.d((View)object) + this.a.e;
            this.a.b = this.j.a((View)object);
            n2 = -this.j.a((View)object) + this.j.c();
        }
        this.a.c = n3;
        if (bl2) {
            object = this.a;
            ((c)object).c -= n2;
        }
        this.a.g = n2;
    }

    private void a(a a2) {
        this.a(a2.b, a2.c);
    }

    private void a(RecyclerView.p p2, int n2) {
        if (n2 < 0) {
            return;
        }
        int n3 = this.v();
        if (this.k) {
            for (int i2 = --n3; i2 >= 0; --i2) {
                View view = this.i(i2);
                if (this.j.b(view) <= n2 && this.j.c(view) <= n2) {
                    continue;
                }
                this.a(p2, n3, i2);
                return;
            }
        } else {
            for (int i3 = 0; i3 < n3; ++i3) {
                View view = this.i(i3);
                if (this.j.b(view) <= n2 && this.j.c(view) <= n2) {
                    continue;
                }
                this.a(p2, 0, i3);
                break;
            }
        }
    }

    private void a(RecyclerView.p p2, int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        if (n3 > n2) {
            --n3;
            while (n3 >= n2) {
                this.a(n3, p2);
                --n3;
            }
        } else {
            for (int i2 = n2; i2 > n3; --i2) {
                this.a(i2, p2);
            }
        }
    }

    private void a(RecyclerView.p p2, c c2) {
        if (c2.a) {
            if (c2.l) {
                return;
            }
            if (c2.f == -1) {
                this.b(p2, c2.g);
                return;
            }
            this.a(p2, c2.g);
        }
    }

    private void a(RecyclerView.p p2, RecyclerView.u u2, a a2) {
        if (this.a(u2, a2)) {
            return;
        }
        if (this.b(p2, u2, a2)) {
            return;
        }
        a2.b();
        int n2 = this.d ? u2.e() - 1 : 0;
        a2.b = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(RecyclerView.u u2, a a2) {
        boolean bl2 = u2.a();
        boolean bl3 = false;
        if (bl2) return false;
        if (this.l == -1) {
            return false;
        }
        if (this.l >= 0 && this.l < u2.e()) {
            a2.b = this.l;
            if (this.n != null && this.n.a()) {
                a2.d = this.n.c;
                int n2 = a2.d ? this.j.d() - this.n.b : this.j.c() + this.n.b;
                a2.c = n2;
                return true;
            }
            if (this.m == Integer.MIN_VALUE) {
                u2 = this.c(this.l);
                if (u2 != null) {
                    if (this.j.e((View)u2) > this.j.f()) {
                        a2.b();
                        return true;
                    }
                    if (this.j.a((View)u2) - this.j.c() < 0) {
                        a2.c = this.j.c();
                        a2.d = false;
                        return true;
                    }
                    if (this.j.d() - this.j.b((View)u2) < 0) {
                        a2.c = this.j.d();
                        a2.d = true;
                        return true;
                    }
                    int n3 = a2.d ? this.j.b((View)u2) + this.j.b() : this.j.a((View)u2);
                    a2.c = n3;
                    return true;
                }
                if (this.v() > 0) {
                    int n4 = this.d(this.i(0));
                    bl2 = this.l < n4;
                    if (bl2 == this.k) {
                        bl3 = true;
                    }
                    a2.d = bl3;
                }
                a2.b();
                return true;
            }
            a2.d = this.k;
            int n5 = this.k ? this.j.d() - this.m : this.j.c() + this.m;
            a2.c = n5;
            return true;
        }
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        return false;
    }

    private int b(int n2, RecyclerView.p p2, RecyclerView.u u2, boolean bl2) {
        int n3 = n2 - this.j.c();
        if (n3 > 0) {
            int n4;
            n3 = n4 = -this.c(n3, p2, u2);
            if (bl2) {
                n2 = n2 + n4 - this.j.c();
                n3 = n4;
                if (n2 > 0) {
                    this.j.a(-n2);
                    n3 = n4 - n2;
                }
            }
            return n3;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private View b(boolean bl2, boolean bl3) {
        int n2;
        int n3;
        if (this.k) {
            n2 = 0;
            n3 = this.v();
            do {
                return this.a(n2, n3, bl2, bl3);
                break;
            } while (true);
        }
        n2 = this.v() - 1;
        n3 = -1;
        return this.a(n2, n3, bl2, bl3);
    }

    private void b(a a2) {
        this.g(a2.b, a2.c);
    }

    private void b(RecyclerView.p p2, int n2) {
        int n3 = this.v();
        if (n2 < 0) {
            return;
        }
        int n4 = this.j.e() - n2;
        if (this.k) {
            for (n2 = 0; n2 < n3; ++n2) {
                View view = this.i(n2);
                if (this.j.a(view) >= n4 && this.j.d(view) >= n4) {
                    continue;
                }
                this.a(p2, 0, n2);
                return;
            }
        } else {
            for (n2 = --n3; n2 >= 0; --n2) {
                View view = this.i(n2);
                if (this.j.a(view) >= n4 && this.j.d(view) >= n4) {
                    continue;
                }
                this.a(p2, n3, n2);
                break;
            }
        }
    }

    private void b(RecyclerView.p p2, RecyclerView.u u2, int n2, int n3) {
        if (u2.b() && this.v() != 0 && !u2.a()) {
            if (!this.b()) {
                return;
            }
            List<RecyclerView.x> list = p2.c();
            int n4 = list.size();
            int n5 = this.d(this.i(0));
            int n6 = 0;
            int n7 = 0;
            for (int i2 = 0; i2 < n4; ++i2) {
                RecyclerView.x x2 = list.get(i2);
                if (x2.q()) continue;
                int n8 = x2.d();
                int n9 = 1;
                boolean bl2 = n8 < n5;
                if (bl2 != this.k) {
                    n9 = -1;
                }
                if (n9 == -1) {
                    n6 += this.j.e(x2.a);
                    continue;
                }
                n7 += this.j.e(x2.a);
            }
            this.a.k = list;
            if (n6 > 0) {
                this.g(this.d(this.L()), n2);
                this.a.h = n6;
                this.a.c = 0;
                this.a.a();
                this.a(p2, this.a, u2, false);
            }
            if (n7 > 0) {
                this.a(this.d(this.M()), n3);
                this.a.h = n7;
                this.a.c = 0;
                this.a.a();
                this.a(p2, this.a, u2, false);
            }
            this.a.k = null;
        }
    }

    private boolean b(RecyclerView.p p2, RecyclerView.u u2, a a2) {
        int n2 = this.v();
        int n3 = 0;
        if (n2 == 0) {
            return false;
        }
        View view = this.E();
        if (view != null && a2.a(view, u2)) {
            a2.a(view, this.d(view));
            return true;
        }
        if (this.b != this.d) {
            return false;
        }
        p2 = a2.d ? this.f(p2, u2) : this.g(p2, u2);
        if (p2 != null) {
            a2.b((View)p2, this.d((View)p2));
            if (!u2.a() && this.b()) {
                if (this.j.a((View)p2) >= this.j.d() || this.j.b((View)p2) < this.j.c()) {
                    n3 = 1;
                }
                if (n3 != 0) {
                    n3 = a2.d ? this.j.d() : this.j.c();
                    a2.c = n3;
                }
            }
            return true;
        }
        return false;
    }

    private View f(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.k) {
            return this.h(p2, u2);
        }
        return this.i(p2, u2);
    }

    private View g(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.k) {
            return this.i(p2, u2);
        }
        return this.h(p2, u2);
    }

    private void g(int n2, int n3) {
        this.a.c = n3 - this.j.c();
        this.a.d = n2;
        c c2 = this.a;
        n2 = this.k ? 1 : -1;
        c2.e = n2;
        this.a.f = -1;
        this.a.b = n3;
        this.a.g = Integer.MIN_VALUE;
    }

    private View h(RecyclerView.p p2, RecyclerView.u u2) {
        return this.a(p2, u2, 0, this.v(), u2.e());
    }

    private int i(RecyclerView.u u2) {
        if (this.v() == 0) {
            return 0;
        }
        this.i();
        return l.a(u2, this.j, this.a(this.e ^ true, true), this.b(this.e ^ true, true), this, this.e, this.k);
    }

    private View i(RecyclerView.p p2, RecyclerView.u u2) {
        return this.a(p2, u2, this.v() - 1, -1, u2.e());
    }

    private int j(RecyclerView.u u2) {
        if (this.v() == 0) {
            return 0;
        }
        this.i();
        return l.a(u2, this.j, this.a(this.e ^ true, true), this.b(this.e ^ true, true), this, this.e);
    }

    private View j(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.k) {
            return this.l(p2, u2);
        }
        return this.m(p2, u2);
    }

    private int k(RecyclerView.u u2) {
        if (this.v() == 0) {
            return 0;
        }
        this.i();
        return l.b(u2, this.j, this.a(this.e ^ true, true), this.b(this.e ^ true, true), this, this.e);
    }

    private View k(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.k) {
            return this.m(p2, u2);
        }
        return this.l(p2, u2);
    }

    private View l(RecyclerView.p p2, RecyclerView.u u2) {
        return this.b(0, this.v());
    }

    private View m(RecyclerView.p p2, RecyclerView.u u2) {
        return this.b(this.v() - 1, -1);
    }

    @Override
    public int a(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        if (this.i == 1) {
            return 0;
        }
        return this.c(n2, p2, u2);
    }

    int a(RecyclerView.p p2, c c2, RecyclerView.u u2, boolean bl2) {
        int n2 = c2.c;
        if (c2.g != Integer.MIN_VALUE) {
            if (c2.c < 0) {
                c2.g += c2.c;
            }
            this.a(p2, c2);
        }
        int n3 = c2.c + c2.h;
        b b2 = this.g;
        while ((c2.l || n3 > 0) && c2.a(u2)) {
            int n4;
            block9 : {
                block8 : {
                    b2.a();
                    this.a(p2, u2, c2, b2);
                    if (b2.b) break;
                    c2.b += b2.a * c2.f;
                    if (!b2.c || this.a.k != null) break block8;
                    n4 = n3;
                    if (u2.a()) break block9;
                }
                c2.c -= b2.a;
                n4 = n3 - b2.a;
            }
            if (c2.g != Integer.MIN_VALUE) {
                c2.g += b2.a;
                if (c2.c < 0) {
                    c2.g += c2.c;
                }
                this.a(p2, c2);
            }
            n3 = n4;
            if (!bl2) continue;
            n3 = n4;
            if (!b2.d) continue;
        }
        return n2 - c2.c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    View a(int n2, int n3, boolean bl2, boolean bl3) {
        n n4;
        this.i();
        int n5 = 320;
        int n6 = bl2 ? 24579 : 320;
        if (!bl3) {
            n5 = 0;
        }
        if (this.i == 0) {
            n4 = this.r;
            do {
                return n4.a(n2, n3, n6, n5);
                break;
            } while (true);
        }
        n4 = this.s;
        return n4.a(n2, n3, n6, n5);
    }

    @Override
    public View a(View view, int n2, RecyclerView.p p2, RecyclerView.u u2) {
        this.K();
        if (this.v() == 0) {
            return null;
        }
        if ((n2 = this.f(n2)) == Integer.MIN_VALUE) {
            return null;
        }
        this.i();
        this.i();
        this.a(n2, (int)((float)this.j.f() * 0.33333334f), false, u2);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        this.a(p2, this.a, u2, true);
        view = n2 == -1 ? this.k(p2, u2) : this.j(p2, u2);
        p2 = n2 == -1 ? this.L() : this.M();
        if (p2.hasFocusable()) {
            if (view == null) {
                return null;
            }
            return p2;
        }
        return view;
    }

    View a(RecyclerView.p p2, RecyclerView.u u2, int n2, int n3, int n4) {
        this.i();
        int n5 = this.j.c();
        int n6 = this.j.d();
        int n7 = n3 > n2 ? 1 : -1;
        u2 = null;
        p2 = null;
        while (n2 != n3) {
            View view = this.i(n2);
            int n8 = this.d(view);
            RecyclerView.u u3 = u2;
            RecyclerView.p p3 = p2;
            if (n8 >= 0) {
                u3 = u2;
                p3 = p2;
                if (n8 < n4) {
                    if (((RecyclerView.j)view.getLayoutParams()).d()) {
                        u3 = u2;
                        p3 = p2;
                        if (p2 == null) {
                            p3 = view;
                            u3 = u2;
                        }
                    } else {
                        if (this.j.a(view) < n6 && this.j.b(view) >= n5) {
                            return view;
                        }
                        u3 = u2;
                        p3 = p2;
                        if (u2 == null) {
                            u3 = view;
                            p3 = p2;
                        }
                    }
                }
            }
            n2 += n7;
            u2 = u3;
            p2 = p3;
        }
        if (u2 != null) {
            return u2;
        }
        return p2;
    }

    @Override
    public RecyclerView.j a() {
        return new RecyclerView.j(-2, -2);
    }

    @Override
    public void a(int n2, int n3, RecyclerView.u u2, RecyclerView.i.a a2) {
        if (this.i != 0) {
            n2 = n3;
        }
        if (this.v() != 0) {
            if (n2 == 0) {
                return;
            }
            this.i();
            n3 = n2 > 0 ? 1 : -1;
            this.a(n3, Math.abs(n2), true, u2);
            this.a(u2, this.a, a2);
        }
    }

    @Override
    public void a(int n2, RecyclerView.i.a a2) {
        boolean bl2;
        int n3;
        d d2 = this.n;
        int n4 = -1;
        if (d2 != null && this.n.a()) {
            bl2 = this.n.c;
            n3 = this.n.a;
        } else {
            this.K();
            bl2 = this.k;
            n3 = this.l == -1 ? (bl2 ? n2 - 1 : 0) : this.l;
        }
        if (!bl2) {
            n4 = 1;
        }
        int n5 = 0;
        int n6 = n3;
        for (n3 = n5; n3 < this.h && n6 >= 0 && n6 < n2; n6 += n4, ++n3) {
            a2.b(n6, 0);
        }
    }

    @Override
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.n = (d)parcelable;
            this.o();
        }
    }

    @Override
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (this.v() > 0) {
            accessibilityEvent.setFromIndex(this.m());
            accessibilityEvent.setToIndex(this.n());
        }
    }

    void a(RecyclerView.p p2, RecyclerView.u u2, a a2, int n2) {
    }

    void a(RecyclerView.p p2, RecyclerView.u object, c c2, b b2) {
        int n2;
        int n3;
        int n4;
        int n5;
        if ((p2 = c2.a(p2)) == null) {
            b2.b = true;
            return;
        }
        object = (RecyclerView.j)p2.getLayoutParams();
        if (c2.k == null) {
            boolean bl2 = this.k;
            boolean bl3 = c2.f == -1;
            if (bl2 == bl3) {
                this.b((View)p2);
            } else {
                this.b((View)p2, 0);
            }
        } else {
            boolean bl4 = this.k;
            boolean bl5 = c2.f == -1;
            if (bl4 == bl5) {
                this.a((View)p2);
            } else {
                this.a((View)p2, 0);
            }
        }
        this.a((View)p2, 0, 0);
        b2.a = this.j.e((View)p2);
        if (this.i == 1) {
            if (this.h()) {
                n2 = this.y() - this.C();
                n5 = n2 - this.j.f((View)p2);
            } else {
                n5 = this.A();
                n2 = this.j.f((View)p2) + n5;
            }
            if (c2.f == -1) {
                n4 = c2.b;
                int n6 = c2.b - b2.a;
                n3 = n2;
                n2 = n6;
            } else {
                int n7 = c2.b;
                n4 = c2.b + b2.a;
                n3 = n2;
                n2 = n7;
            }
        } else {
            n3 = this.B();
            n2 = this.j.f((View)p2) + n3;
            if (c2.f == -1) {
                n4 = c2.b;
                n5 = c2.b;
                int n8 = b2.a;
                int n9 = n2;
                n5 -= n8;
                n2 = n3;
                n3 = n4;
                n4 = n9;
            } else {
                int n10 = c2.b;
                int n11 = c2.b + b2.a;
                n5 = n3;
                n4 = n2;
                n3 = n11;
                n2 = n5;
                n5 = n10;
            }
        }
        this.a((View)p2, n5, n2, n3, n4);
        if (((RecyclerView.j)((Object)object)).d() || ((RecyclerView.j)((Object)object)).e()) {
            b2.c = true;
        }
        b2.d = p2.hasFocusable();
    }

    @Override
    public void a(RecyclerView.u u2) {
        super.a(u2);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    void a(RecyclerView.u u2, c c2, RecyclerView.i.a a2) {
        int n2 = c2.d;
        if (n2 >= 0 && n2 < u2.e()) {
            a2.b(n2, Math.max(0, c2.g));
        }
    }

    @Override
    public void a(RecyclerView recyclerView, RecyclerView.p p2) {
        super.a(recyclerView, p2);
        if (this.f) {
            this.c(p2);
            p2.a();
        }
    }

    @Override
    public void a(String string2) {
        if (this.n == null) {
            super.a(string2);
        }
    }

    public void a(boolean bl2) {
        this.a((String)null);
        if (this.d == bl2) {
            return;
        }
        this.d = bl2;
        this.o();
    }

    @Override
    public int b(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        if (this.i == 0) {
            return 0;
        }
        return this.c(n2, p2, u2);
    }

    protected int b(RecyclerView.u u2) {
        if (u2.d()) {
            return this.j.f();
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    View b(int n2, int n3) {
        int n4;
        n n5;
        this.i();
        int n6 = n3 > n2 ? 1 : (n3 < n2 ? -1 : 0);
        if (n6 == 0) {
            return this.i(n2);
        }
        if (this.j.a(this.i(n2)) < this.j.c()) {
            n6 = 16644;
            n4 = 16388;
        } else {
            n6 = 4161;
            n4 = 4097;
        }
        if (this.i == 0) {
            n5 = this.r;
            do {
                return n5.a(n2, n3, n6, n4);
                break;
            } while (true);
        }
        n5 = this.s;
        return n5.a(n2, n3, n6, n4);
    }

    public void b(int n2) {
        if (n2 != 0 && n2 != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid orientation:");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.a((String)null);
        if (n2 != this.i || this.j == null) {
            this.o.a = this.j = j.a(this, n2);
            this.i = n2;
            this.o();
        }
    }

    public void b(boolean bl2) {
        this.a((String)null);
        if (bl2 == this.c) {
            return;
        }
        this.c = bl2;
        this.o();
    }

    @Override
    public boolean b() {
        return this.n == null && this.b == this.d;
    }

    int c(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        if (this.v() != 0) {
            if (n2 == 0) {
                return 0;
            }
            this.a.a = true;
            this.i();
            int n3 = n2 > 0 ? 1 : -1;
            int n4 = Math.abs(n2);
            this.a(n3, n4, true, u2);
            int n5 = this.a.g + this.a(p2, this.a, u2, false);
            if (n5 < 0) {
                return 0;
            }
            if (n4 > n5) {
                n2 = n3 * n5;
            }
            this.j.a(-n2);
            this.a.j = n2;
            return n2;
        }
        return 0;
    }

    @Override
    public int c(RecyclerView.u u2) {
        return this.i(u2);
    }

    @Override
    public View c(int n2) {
        View view;
        int n3 = this.v();
        if (n3 == 0) {
            return null;
        }
        int n4 = n2 - this.d(this.i(0));
        if (n4 >= 0 && n4 < n3 && this.d(view = this.i(n4)) == n2) {
            return view;
        }
        return super.c(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void c(RecyclerView.p p2, RecyclerView.u u2) {
        int n2;
        Object object = this.n;
        int n3 = -1;
        if ((object != null || this.l != -1) && u2.e() == 0) {
            this.c(p2);
            return;
        }
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        this.i();
        this.a.a = false;
        this.K();
        object = this.E();
        if (this.o.e && this.l == -1 && this.n == null) {
            if (object != null && (this.j.a((View)object) >= this.j.d() || this.j.b((View)object) <= this.j.c())) {
                this.o.a((View)object, this.d((View)object));
            }
        } else {
            this.o.a();
            this.o.d = this.k ^ this.d;
            this.a(p2, u2, this.o);
            this.o.e = true;
        }
        int n4 = this.b(u2);
        if (this.a.j >= 0) {
            n2 = n4;
            n4 = 0;
        } else {
            n2 = 0;
        }
        int n5 = n4 + this.j.c();
        int n6 = n2 + this.j.g();
        n2 = n5;
        n4 = n6;
        if (u2.a()) {
            n2 = n5;
            n4 = n6;
            if (this.l != -1) {
                n2 = n5;
                n4 = n6;
                if (this.m != Integer.MIN_VALUE) {
                    object = this.c(this.l);
                    n2 = n5;
                    n4 = n6;
                    if (object != null) {
                        if (this.k) {
                            n4 = this.j.d() - this.j.b((View)object);
                            n2 = this.m;
                        } else {
                            n2 = this.j.a((View)object) - this.j.c();
                            n4 = this.m;
                        }
                        n2 = n4 - n2;
                        if (n2 > 0) {
                            n2 = n5 + n2;
                            n4 = n6;
                        } else {
                            n4 = n6 - n2;
                            n2 = n5;
                        }
                    }
                }
            }
        }
        if (this.o.d ? this.k : !this.k) {
            n3 = 1;
        }
        this.a(p2, u2, this.o, n3);
        this.a(p2);
        this.a.l = this.k();
        this.a.i = u2.a();
        if (this.o.d) {
            this.b(this.o);
            this.a.h = n2;
            this.a(p2, this.a, u2, false);
            n3 = this.a.b;
            n6 = this.a.d;
            n2 = n4;
            if (this.a.c > 0) {
                n2 = n4 + this.a.c;
            }
            this.a(this.o);
            this.a.h = n2;
            object = this.a;
            ((c)object).d += this.a.e;
            this.a(p2, this.a, u2, false);
            n5 = this.a.b;
            n4 = n3;
            n2 = n5;
            if (this.a.c > 0) {
                n2 = this.a.c;
                this.g(n6, n3);
                this.a.h = n2;
                this.a(p2, this.a, u2, false);
                n4 = this.a.b;
                n2 = n5;
            }
        } else {
            this.a(this.o);
            this.a.h = n4;
            this.a(p2, this.a, u2, false);
            n3 = this.a.b;
            n6 = this.a.d;
            n4 = n2;
            if (this.a.c > 0) {
                n4 = n2 + this.a.c;
            }
            this.b(this.o);
            this.a.h = n4;
            object = this.a;
            ((c)object).d += this.a.e;
            this.a(p2, this.a, u2, false);
            n4 = n5 = this.a.b;
            n2 = n3;
            if (this.a.c > 0) {
                n2 = this.a.c;
                this.a(n6, n3);
                this.a.h = n2;
                this.a(p2, this.a, u2, false);
                n2 = this.a.b;
                n4 = n5;
            }
        }
        n3 = n4;
        n5 = n2;
        if (this.v() > 0) {
            if (this.k ^ this.d) {
                n5 = this.a(n2, p2, u2, true);
                n3 = n4 + n5;
                n4 = n2 + n5;
                n2 = this.b(n3, p2, u2, false);
            } else {
                n5 = this.b(n4, p2, u2, true);
                n3 = n4 + n5;
                n4 = n2 + n5;
                n2 = this.a(n4, p2, u2, false);
            }
            n3 += n2;
            n5 = n4 + n2;
        }
        this.b(p2, u2, n3, n5);
        if (!u2.a()) {
            this.j.a();
        } else {
            this.o.a();
        }
        this.b = this.d;
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public int d(RecyclerView.u u2) {
        return this.i(u2);
    }

    @Override
    public PointF d(int n2) {
        if (this.v() == 0) {
            return null;
        }
        boolean bl2 = false;
        int n3 = this.d(this.i(0));
        int n4 = 1;
        if (n2 < n3) {
            bl2 = true;
        }
        n2 = n4;
        if (bl2 != this.k) {
            n2 = -1;
        }
        if (this.i == 0) {
            return new PointF((float)n2, 0.0f);
        }
        return new PointF(0.0f, (float)n2);
    }

    @Override
    public Parcelable d() {
        if (this.n != null) {
            return new d(this.n);
        }
        d d2 = new d();
        if (this.v() > 0) {
            boolean bl2;
            this.i();
            d2.c = bl2 = this.b ^ this.k;
            if (bl2) {
                View view = this.M();
                d2.b = this.j.d() - this.j.b(view);
                d2.a = this.d(view);
                return d2;
            }
            View view = this.L();
            d2.a = this.d(view);
            d2.b = this.j.a(view) - this.j.c();
            return d2;
        }
        d2.b();
        return d2;
    }

    @Override
    public int e(RecyclerView.u u2) {
        return this.j(u2);
    }

    @Override
    public void e(int n2) {
        this.l = n2;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        this.o();
    }

    @Override
    public boolean e() {
        return this.i == 0;
    }

    int f(int n2) {
        int n3 = Integer.MIN_VALUE;
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 != 130) {
                        switch (n2) {
                            default: {
                                return Integer.MIN_VALUE;
                            }
                            case 2: {
                                if (this.i == 1) {
                                    return 1;
                                }
                                if (this.h()) {
                                    return -1;
                                }
                                return 1;
                            }
                            case 1: 
                        }
                        if (this.i == 1) {
                            return -1;
                        }
                        if (this.h()) {
                            return 1;
                        }
                        return -1;
                    }
                    if (this.i == 1) {
                        n3 = 1;
                    }
                    return n3;
                }
                if (this.i == 0) {
                    n3 = 1;
                }
                return n3;
            }
            if (this.i == 1) {
                return -1;
            }
            return Integer.MIN_VALUE;
        }
        if (this.i == 0) {
            return -1;
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public int f(RecyclerView.u u2) {
        return this.j(u2);
    }

    @Override
    public boolean f() {
        return this.i == 1;
    }

    public int g() {
        return this.i;
    }

    @Override
    public int g(RecyclerView.u u2) {
        return this.k(u2);
    }

    @Override
    public int h(RecyclerView.u u2) {
        return this.k(u2);
    }

    protected boolean h() {
        return this.t() == 1;
    }

    void i() {
        if (this.a == null) {
            this.a = this.j();
        }
    }

    c j() {
        return new c();
    }

    boolean k() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    @Override
    boolean l() {
        return this.x() != 1073741824 && this.w() != 1073741824 && this.J();
    }

    public int m() {
        View view = this.a(0, this.v(), false, true);
        if (view == null) {
            return -1;
        }
        return this.d(view);
    }

    public int n() {
        View view = this.a(this.v() - 1, -1, false, true);
        if (view == null) {
            return -1;
        }
        return this.d(view);
    }

    static class a {
        j a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            this.a();
        }

        void a() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public void a(View view, int n2) {
            int n3 = this.a.b();
            if (n3 >= 0) {
                this.b(view, n2);
                return;
            }
            this.b = n2;
            if (this.d) {
                n2 = this.a.d() - n3 - this.a.b(view);
                this.c = this.a.d() - n2;
                if (n2 > 0) {
                    n3 = this.a.e(view);
                    int n4 = this.c;
                    int n5 = this.a.c();
                    if ((n3 = n4 - n3 - (n5 + Math.min(this.a.a(view) - n5, 0))) < 0) {
                        this.c += Math.min(n2, -n3);
                        return;
                    }
                }
            } else {
                int n6 = this.a.a(view);
                n2 = n6 - this.a.c();
                this.c = n6;
                if (n2 > 0) {
                    int n7 = this.a.e(view);
                    int n8 = this.a.d();
                    int n9 = this.a.b(view);
                    n3 = this.a.d() - Math.min(0, n8 - n3 - n9) - (n6 + n7);
                    if (n3 < 0) {
                        this.c -= Math.min(n2, -n3);
                    }
                }
            }
        }

        boolean a(View object, RecyclerView.u u2) {
            return !((RecyclerView.j)((Object)(object = (RecyclerView.j)object.getLayoutParams()))).d() && ((RecyclerView.j)((Object)object)).f() >= 0 && ((RecyclerView.j)((Object)object)).f() < u2.e();
        }

        void b() {
            int n2 = this.d ? this.a.d() : this.a.c();
            this.c = n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void b(View view, int n2) {
            int n3 = this.d ? this.a.b(view) + this.a.b() : this.a.a(view);
            this.c = n3;
            this.b = n2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AnchorInfo{mPosition=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {
        boolean a = true;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<RecyclerView.x> k = null;
        boolean l;

        c() {
        }

        private View b() {
            int n2 = this.k.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = this.k.get((int)i2).a;
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                if (j2.d() || this.d != j2.f()) continue;
                this.a(view);
                return view;
            }
            return null;
        }

        View a(RecyclerView.p p2) {
            if (this.k != null) {
                return this.b();
            }
            p2 = p2.c(this.d);
            this.d += this.e;
            return p2;
        }

        public void a() {
            this.a((View)null);
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(View view) {
            int n2 = (view = this.b(view)) == null ? -1 : ((RecyclerView.j)view.getLayoutParams()).f();
            this.d = n2;
        }

        boolean a(RecyclerView.u u2) {
            return this.d >= 0 && this.d < u2.e();
        }

        public View b(View view) {
            int n2 = this.k.size();
            View view2 = null;
            int n3 = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < n2; ++i2) {
                View view3 = this.k.get((int)i2).a;
                RecyclerView.j j2 = (RecyclerView.j)view3.getLayoutParams();
                View view4 = view2;
                int n4 = n3;
                if (view3 != view) {
                    if (j2.d()) {
                        view4 = view2;
                        n4 = n3;
                    } else {
                        int n5 = (j2.f() - this.d) * this.e;
                        if (n5 < 0) {
                            view4 = view2;
                            n4 = n3;
                        } else {
                            view4 = view2;
                            n4 = n3;
                            if (n5 < n3) {
                                if (n5 == 0) {
                                    return view3;
                                }
                                view4 = view3;
                                n4 = n5;
                            }
                        }
                    }
                }
                view2 = view4;
                n3 = n4;
            }
            return view2;
        }
    }

    public static class d
    implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>(){

            public d a(Parcel parcel) {
                return new d(parcel);
            }

            public d[] a(int n2) {
                return new d[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        int a;
        int b;
        boolean c;

        public d() {
        }

        d(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            int n2 = parcel.readInt();
            boolean bl2 = true;
            if (n2 != 1) {
                bl2 = false;
            }
            this.c = bl2;
        }

        public d(d d2) {
            this.a = d2.a;
            this.b = d2.b;
            this.c = d2.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            RuntimeException runtimeException;
            super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            throw runtimeException;
        }

    }

}

