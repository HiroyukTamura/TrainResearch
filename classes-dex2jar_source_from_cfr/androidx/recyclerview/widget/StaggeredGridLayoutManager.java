/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
extends RecyclerView.i
implements RecyclerView.t.b {
    private d A;
    private int B;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private int[] G;
    private final Runnable H = new Runnable(){

        @Override
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };
    e[] a;
    j b;
    j c;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    c h = new c();
    private int i = -1;
    private int j;
    private int k;
    private final h l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean z;

    public StaggeredGridLayoutManager(Context object, AttributeSet attributeSet, int n2, int n3) {
        object = StaggeredGridLayoutManager.a(object, attributeSet, n2, n3);
        this.b(object.a);
        this.a(object.b);
        this.a(object.c);
        this.l = new h();
        this.M();
    }

    private void M() {
        this.b = j.a(this, this.j);
        this.c = j.a(this, 1 - this.j);
    }

    private void N() {
        boolean bl2 = this.j != 1 && this.j() ? this.d ^ true : this.d;
        this.e = bl2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void O() {
        if (this.c.h() == 1073741824) {
            return;
        }
        var7_1 = this.v();
        var5_2 = 0;
        var1_4 = 0.0f;
        for (var4_3 = 0; var4_3 < var7_1; ++var4_3) {
            var9_7 = this.i(var4_3);
            var3_6 = this.c.e(var9_7);
            if (var3_6 < var1_4) continue;
            var2_5 = var3_6;
            if (((b)var9_7.getLayoutParams()).a()) {
                var2_5 = var3_6 * 1.0f / (float)this.i;
            }
            var1_4 = Math.max(var1_4, var2_5);
        }
        var8_8 = this.k;
        var4_3 = var6_9 = Math.round(var1_4 * (float)this.i);
        if (this.c.h() == Integer.MIN_VALUE) {
            var4_3 = Math.min(var6_9, this.c.f());
        }
        this.f(var4_3);
        var4_3 = var5_2;
        if (this.k == var8_8) {
            return;
        }
        while (var4_3 < var7_1) {
            block8 : {
                block9 : {
                    var9_7 = this.i(var4_3);
                    var10_10 = (b)var9_7.getLayoutParams();
                    if (var10_10.b) break block8;
                    if (!this.j() || this.j != 1) break block9;
                    var6_9 = -(this.i - 1 - var10_10.a.e) * this.k;
                    var5_2 = -(this.i - 1 - var10_10.a.e) * var8_8;
                    ** GOTO lbl-1000
                }
                var6_9 = var10_10.a.e * this.k;
                var5_2 = var10_10.a.e * var8_8;
                if (this.j == 1) lbl-1000: // 2 sources:
                {
                    var9_7.offsetLeftAndRight(var6_9 - var5_2);
                } else {
                    var9_7.offsetTopAndBottom(var6_9 - var5_2);
                }
            }
            ++var4_3;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(RecyclerView.p p2, h h2, RecyclerView.u u2) {
        int n2;
        int n3;
        int n4;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            n4 = h2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            n3 = h2.e == 1 ? h2.g + h2.b : h2.f - h2.b;
            n4 = n3;
        }
        this.a(h2.e, n4);
        int n5 = this.e ? this.b.d() : this.b.c();
        n3 = 0;
        while (h2.a(u2) && (this.l.i || !this.m.isEmpty())) {
            int n6;
            b b2;
            View view;
            int n7;
            e e2;
            int n8;
            block27 : {
                block28 : {
                    c.a a2;
                    view = h2.a(p2);
                    b2 = (b)view.getLayoutParams();
                    n7 = b2.f();
                    n3 = this.h.c(n7);
                    n6 = n3 == -1 ? 1 : 0;
                    if (n6 != 0) {
                        e2 = b2.b ? this.a[0] : this.a(h2);
                        this.h.a(n7, e2);
                    } else {
                        e2 = this.a[n3];
                    }
                    b2.a = e2;
                    if (h2.e == 1) {
                        this.b(view);
                    } else {
                        this.b(view, 0);
                    }
                    this.a(view, b2, false);
                    if (h2.e == 1) {
                        n3 = b2.b ? this.r(n5) : e2.b(n5);
                        n2 = this.b.e(view);
                        if (n6 != 0 && b2.b) {
                            a2 = this.n(n3);
                            a2.b = -1;
                            a2.a = n7;
                            this.h.a(a2);
                        }
                        n8 = n2 + n3;
                        n2 = n3;
                        n3 = n8;
                    } else {
                        n3 = b2.b ? this.q(n5) : e2.a(n5);
                        n2 = n3 - this.b.e(view);
                        if (n6 != 0 && b2.b) {
                            a2 = this.o(n3);
                            a2.b = 1;
                            a2.a = n7;
                            this.h.a(a2);
                        }
                    }
                    if (!b2.b || h2.d != -1) break block27;
                    if (n6 != 0) break block28;
                    boolean bl2 = h2.e == 1 ? this.m() : this.n();
                    if (!(bl2 ^ true)) break block27;
                    a2 = this.h.f(n7);
                    if (a2 != null) {
                        a2.d = true;
                    }
                }
                this.E = true;
            }
            this.a(view, b2, h2);
            if (this.j() && this.j == 1) {
                n6 = b2.b ? this.c.d() : this.c.d() - (this.i - 1 - e2.e) * this.k;
                n7 = this.c.e(view);
                n8 = n6;
                n6 -= n7;
            } else {
                n6 = b2.b ? this.c.c() : e2.e * this.k + this.c.c();
                n8 = this.c.e(view);
                n7 = n6;
                n8 += n6;
                n6 = n7;
            }
            if (this.j == 1) {
                n7 = n3;
                n3 = n6;
            } else {
                n7 = n3;
                int n9 = n8;
                n3 = n2;
                n2 = n6;
                n8 = n7;
                n7 = n9;
            }
            this.a(view, n3, n2, n8, n7);
            if (b2.b) {
                this.a(this.l.e, n4);
            } else {
                this.a(e2, this.l.e, n4);
            }
            this.a(p2, this.l);
            if (this.l.h && view.hasFocusable()) {
                if (b2.b) {
                    this.m.clear();
                } else {
                    this.m.set(e2.e, false);
                }
            }
            n3 = 1;
        }
        n2 = 0;
        if (n3 == 0) {
            this.a(p2, this.l);
        }
        if (this.l.e == -1) {
            n3 = this.q(this.b.c());
            n3 = this.b.c() - n3;
        } else {
            n3 = this.r(this.b.d()) - this.b.d();
        }
        if (n3 <= 0) return n2;
        return Math.min(h2.b, n3);
    }

    private e a(h object) {
        int n2;
        int n3;
        boolean bl2 = this.t(((h)object).e);
        int n4 = -1;
        if (bl2) {
            n3 = this.i - 1;
            n2 = -1;
        } else {
            n3 = 0;
            n4 = this.i;
            n2 = 1;
        }
        int n5 = ((h)object).e;
        e e2 = null;
        object = null;
        if (n5 == 1) {
            n5 = Integer.MAX_VALUE;
            int n6 = this.b.c();
            while (n3 != n4) {
                e2 = this.a[n3];
                int n7 = e2.b(n6);
                int n8 = n5;
                if (n7 < n5) {
                    object = e2;
                    n8 = n7;
                }
                n3 += n2;
                n5 = n8;
            }
            return object;
        }
        n5 = Integer.MIN_VALUE;
        int n9 = this.b.d();
        object = e2;
        while (n3 != n4) {
            e2 = this.a[n3];
            int n10 = e2.a(n9);
            int n11 = n5;
            if (n10 > n5) {
                object = e2;
                n11 = n10;
            }
            n3 += n2;
            n5 = n11;
        }
        return object;
    }

    private void a(int n2, int n3) {
        for (int i2 = 0; i2 < this.i; ++i2) {
            if (this.a[i2].a.isEmpty()) continue;
            this.a(this.a[i2], n2, n3);
        }
    }

    private void a(View view, int n2, int n3, boolean bl2) {
        this.b(view, this.C);
        b b2 = (b)view.getLayoutParams();
        n2 = this.b(n2, b2.leftMargin + this.C.left, b2.rightMargin + this.C.right);
        n3 = this.b(n3, b2.topMargin + this.C.top, b2.bottomMargin + this.C.bottom);
        bl2 = bl2 ? this.a(view, n2, n3, b2) : this.b(view, n2, n3, b2);
        if (bl2) {
            view.measure(n2, n3);
        }
    }

    private void a(View view, b b2, h h2) {
        if (h2.e == 1) {
            if (b2.b) {
                this.p(view);
                return;
            }
            b2.a.b(view);
            return;
        }
        if (b2.b) {
            this.q(view);
            return;
        }
        b2.a.a(view);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(View var1_1, b var2_2, boolean var3_3) {
        block3 : {
            if (!var2_2.b) break block3;
            if (this.j != 1) {
                this.a(var1_1, StaggeredGridLayoutManager.a(this.y(), this.w(), this.A() + this.C(), var2_2.width, true), this.B, var3_3);
                return;
            }
            var4_4 = this.B;
            ** GOTO lbl10
        }
        if (this.j == 1) {
            var4_4 = StaggeredGridLayoutManager.a(this.k, this.w(), 0, var2_2.width, false);
lbl10: // 2 sources:
            var5_5 = StaggeredGridLayoutManager.a(this.z(), this.x(), this.B() + this.D(), var2_2.height, true);
        } else {
            var4_4 = StaggeredGridLayoutManager.a(this.y(), this.w(), this.A() + this.C(), var2_2.width, true);
            var5_5 = StaggeredGridLayoutManager.a(this.k, this.x(), 0, var2_2.height, false);
        }
        this.a(var1_1, var4_4, var5_5, var3_3);
    }

    private void a(RecyclerView.p p2, int n2) {
        while (this.v() > 0) {
            int n3 = 0;
            View view = this.i(0);
            if (this.b.b(view) > n2 || this.b.c(view) > n2) break;
            b b2 = (b)view.getLayoutParams();
            if (b2.b) {
                int n4 = 0;
                do {
                    if (n4 >= this.i) break;
                    if (this.a[n4].a.size() == 1) {
                        return;
                    }
                    ++n4;
                } while (true);
                for (int i2 = n3; i2 < this.i; ++i2) {
                    this.a[i2].h();
                }
            } else {
                if (b2.a.a.size() == 1) {
                    return;
                }
                b2.a.h();
            }
            this.a(view, p2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(RecyclerView.p var1_1, RecyclerView.u var2_2, boolean var3_3) {
        var7_4 = this.D;
        if ((this.A != null || this.f != -1) && var2_2.e() == 0) {
            this.c(var1_1);
            var7_4.a();
            return;
        }
        var6_5 = var7_4.e;
        var5_6 = 1;
        var4_7 = var6_5 && this.f == -1 && this.A == null ? 0 : 1;
        if (var4_7 != 0) {
            var7_4.a();
            if (this.A != null) {
                this.a(var7_4);
            } else {
                this.N();
                var7_4.c = this.e;
            }
            this.a(var2_2, var7_4);
            var7_4.e = true;
        }
        if (this.A == null && this.f == -1 && (var7_4.c != this.o || this.j() != this.z)) {
            this.h.a();
            var7_4.d = true;
        }
        if (this.v() > 0 && (this.A == null || this.A.c < 1)) {
            if (var7_4.d) {
                for (var4_7 = 0; var4_7 < this.i; ++var4_7) {
                    this.a[var4_7].e();
                    if (var7_4.b == Integer.MIN_VALUE) continue;
                    this.a[var4_7].c(var7_4.b);
                }
            } else if (var4_7 == 0 && this.D.f != null) {
                for (var4_7 = 0; var4_7 < this.i; ++var4_7) {
                    var8_8 = this.a[var4_7];
                    var8_8.e();
                    var8_8.c(this.D.f[var4_7]);
                }
            } else {
                for (var4_7 = 0; var4_7 < this.i; ++var4_7) {
                    this.a[var4_7].a(this.e, var7_4.b);
                }
                this.D.a(this.a);
            }
        }
        this.a(var1_1);
        this.l.a = false;
        this.E = false;
        this.f(this.c.f());
        this.b(var7_4.a, var2_2);
        if (var7_4.c) {
            this.m(-1);
            this.a(var1_1, this.l, var2_2);
            this.m(1);
        } else {
            this.m(1);
            this.a(var1_1, this.l, var2_2);
            this.m(-1);
        }
        this.l.c = var7_4.a + this.l.d;
        this.a(var1_1, this.l, var2_2);
        this.O();
        if (this.v() > 0) {
            if (this.e) {
                this.b(var1_1, var2_2, true);
                this.c(var1_1, var2_2, false);
            } else {
                this.c(var1_1, var2_2, true);
                this.b(var1_1, var2_2, false);
            }
        }
        if (!var3_3 || var2_2.a() || (var4_7 = this.n != 0 && this.v() > 0 && (this.E != false || this.h() != null) ? 1 : 0) == 0) ** GOTO lbl-1000
        this.a(this.H);
        if (this.g()) {
            var4_7 = var5_6;
        } else lbl-1000: // 2 sources:
        {
            var4_7 = 0;
        }
        if (var2_2.a()) {
            this.D.a();
        }
        this.o = var7_4.c;
        this.z = this.j();
        if (var4_7 == 0) return;
        this.D.a();
        this.a(var1_1, var2_2, false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(RecyclerView.p var1_1, h var2_2) {
        block7 : {
            block6 : {
                if (var2_2.a == false) return;
                if (var2_2.i) {
                    return;
                }
                if (var2_2.b != 0) break block6;
                if (var2_2.e != -1) ** GOTO lbl-1000
                ** GOTO lbl-1000
            }
            if (var2_2.e == -1) {
                var3_3 = var2_2.f - this.p(var2_2.f);
                ** if (var3_3 >= 0) goto lbl-1000
            }
            break block7;
lbl-1000: // 2 sources:
            {
                var3_3 = var2_2.g;
                ** GOTO lbl15
            }
lbl-1000: // 1 sources:
            {
                var3_3 = var2_2.g - Math.min(var3_3, var2_2.b);
            }
lbl15: // 2 sources:
            this.b(var1_1, var3_3);
            return;
        }
        var3_4 = this.s(var2_2.g) - var2_2.g;
        if (var3_4 < 0) lbl-1000: // 2 sources:
        {
            var3_4 = var2_2.f;
        } else {
            var4_5 = var2_2.f;
            var3_4 = Math.min(var3_4, var2_2.b) + var4_5;
        }
        this.a(var1_1, var3_4);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(a a2) {
        boolean bl2;
        if (this.A.c > 0) {
            if (this.A.c != this.i) {
                this.A.a();
                this.A.a = this.A.b;
            } else {
                for (int i2 = 0; i2 < this.i; ++i2) {
                    int n2;
                    this.a[i2].e();
                    int n3 = n2 = this.A.d[i2];
                    if (n2 != Integer.MIN_VALUE) {
                        n3 = this.A.i ? this.b.d() : this.b.c();
                        n3 = n2 + n3;
                    }
                    this.a[i2].c(n3);
                }
            }
        }
        this.z = this.A.j;
        this.a(this.A.h);
        this.N();
        if (this.A.a != -1) {
            this.f = this.A.a;
            bl2 = this.A.i;
        } else {
            bl2 = this.e;
        }
        a2.c = bl2;
        if (this.A.e > 1) {
            this.h.a = this.A.f;
            this.h.b = this.A.g;
        }
    }

    private void a(e e2, int n2, int n3) {
        int n4 = e2.i();
        if (n2 == -1 ? e2.b() + n4 <= n3 : e2.d() - n4 >= n3) {
            this.m.set(e2.e, false);
        }
    }

    private boolean a(e e2) {
        if (this.e) {
            if (e2.d() < this.b.d()) {
                return e2.c((View)e2.a.get((int)(e2.a.size() - 1))).b ^ true;
            }
        } else if (e2.b() > this.b.c()) {
            return e2.c((View)e2.a.get((int)0)).b ^ true;
        }
        return false;
    }

    private int b(int n2, int n3, int n4) {
        if (n3 == 0 && n4 == 0) {
            return n2;
        }
        int n5 = View.MeasureSpec.getMode((int)n2);
        if (n5 != Integer.MIN_VALUE && n5 != 1073741824) {
            return n2;
        }
        return View.MeasureSpec.makeMeasureSpec((int)Math.max(0, View.MeasureSpec.getSize((int)n2) - n3 - n4), (int)n5);
    }

    private int b(RecyclerView.u u2) {
        if (this.v() == 0) {
            return 0;
        }
        return l.a(u2, this.b, this.b(this.F ^ true), this.c(this.F ^ true), this, this.F, this.e);
    }

    private void b(int n2, RecyclerView.u object) {
        int n3;
        boolean bl2;
        boolean bl3;
        block6 : {
            block7 : {
                block4 : {
                    block5 : {
                        h h2 = this.l;
                        bl2 = false;
                        h2.b = 0;
                        this.l.c = n2;
                        if (!this.s() || (n3 = ((RecyclerView.u)object).c()) == -1) break block4;
                        boolean bl4 = this.e;
                        bl3 = n3 < n2;
                        if (bl4 != bl3) break block5;
                        n3 = this.b.f();
                        n2 = 0;
                        break block6;
                    }
                    n2 = this.b.f();
                    break block7;
                }
                n2 = 0;
            }
            n3 = 0;
        }
        if (this.r()) {
            this.l.f = this.b.c() - n2;
            this.l.g = this.b.d() + n3;
        } else {
            this.l.g = this.b.e() + n3;
            this.l.f = -n2;
        }
        this.l.h = false;
        this.l.a = true;
        object = this.l;
        bl3 = bl2;
        if (this.b.h() == 0) {
            bl3 = bl2;
            if (this.b.e() == 0) {
                bl3 = true;
            }
        }
        ((h)object).i = bl3;
    }

    private void b(RecyclerView.p p2, int n2) {
        View view;
        for (int i2 = this.v() - 1; i2 >= 0 && this.b.a(view = this.i(i2)) >= n2 && this.b.d(view) >= n2; --i2) {
            b b2 = (b)view.getLayoutParams();
            if (b2.b) {
                int n3 = 0;
                int n4 = 0;
                do {
                    if (n4 >= this.i) break;
                    if (this.a[n4].a.size() == 1) {
                        return;
                    }
                    ++n4;
                } while (true);
                for (int i3 = n3; i3 < this.i; ++i3) {
                    this.a[i3].g();
                }
            } else {
                if (b2.a.a.size() == 1) {
                    return;
                }
                b2.a.g();
            }
            this.a(view, p2);
        }
    }

    private void b(RecyclerView.p p2, RecyclerView.u u2, boolean bl2) {
        int n2 = this.r(Integer.MIN_VALUE);
        if (n2 == Integer.MIN_VALUE) {
            return;
        }
        n2 = this.b.d() - n2;
        if (n2 > 0) {
            n2 -= -this.c(-n2, p2, u2);
            if (bl2 && n2 > 0) {
                this.b.a(n2);
            }
        }
    }

    private void c(int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        block11 : {
            block10 : {
                block8 : {
                    block9 : {
                        n7 = this.e ? this.K() : this.L();
                        if (n4 != 8) break block8;
                        if (n2 >= n3) break block9;
                        n5 = n3 + 1;
                        break block10;
                    }
                    n6 = n2 + 1;
                    n5 = n3;
                    break block11;
                }
                n5 = n2 + n3;
            }
            n6 = n5;
            n5 = n2;
        }
        this.h.b(n5);
        if (n4 != 8) {
            switch (n4) {
                default: {
                    break;
                }
                case 2: {
                    this.h.a(n2, n3);
                    break;
                }
                case 1: {
                    this.h.b(n2, n3);
                    break;
                }
            }
        } else {
            this.h.a(n2, 1);
            this.h.b(n3, 1);
        }
        if (n6 <= n7) {
            return;
        }
        n2 = this.e ? this.L() : this.K();
        if (n5 <= n2) {
            this.o();
        }
    }

    private void c(RecyclerView.p p2, RecyclerView.u u2, boolean bl2) {
        int n2 = this.q(Integer.MAX_VALUE);
        if (n2 == Integer.MAX_VALUE) {
            return;
        }
        if ((n2 -= this.b.c()) > 0) {
            n2 -= this.c(n2, p2, u2);
            if (bl2 && n2 > 0) {
                this.b.a(-n2);
            }
        }
    }

    private boolean c(RecyclerView.u u2, a a2) {
        int n2 = this.o ? this.w(u2.e()) : this.v(u2.e());
        a2.a = n2;
        a2.b = Integer.MIN_VALUE;
        return true;
    }

    private int i(RecyclerView.u u2) {
        if (this.v() == 0) {
            return 0;
        }
        return l.a(u2, this.b, this.b(this.F ^ true), this.c(this.F ^ true), this, this.F);
    }

    private int j(RecyclerView.u u2) {
        if (this.v() == 0) {
            return 0;
        }
        return l.b(u2, this.b, this.b(this.F ^ true), this.c(this.F ^ true), this, this.F);
    }

    private void m(int n2) {
        this.l.e = n2;
        h h2 = this.l;
        boolean bl2 = this.e;
        int n3 = 1;
        boolean bl3 = n2 == -1;
        n2 = bl2 == bl3 ? n3 : -1;
        h2.d = n2;
    }

    private c.a n(int n2) {
        c.a a2 = new c.a();
        a2.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; ++i2) {
            a2.c[i2] = n2 - this.a[i2].b(n2);
        }
        return a2;
    }

    private c.a o(int n2) {
        c.a a2 = new c.a();
        a2.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; ++i2) {
            a2.c[i2] = this.a[i2].a(n2) - n2;
        }
        return a2;
    }

    private int p(int n2) {
        int n3 = this.a[0].a(n2);
        for (int i2 = 1; i2 < this.i; ++i2) {
            int n4 = this.a[i2].a(n2);
            int n5 = n3;
            if (n4 > n3) {
                n5 = n4;
            }
            n3 = n5;
        }
        return n3;
    }

    private void p(View view) {
        for (int i2 = this.i - 1; i2 >= 0; --i2) {
            this.a[i2].b(view);
        }
    }

    private int q(int n2) {
        int n3 = this.a[0].a(n2);
        for (int i2 = 1; i2 < this.i; ++i2) {
            int n4 = this.a[i2].a(n2);
            int n5 = n3;
            if (n4 < n3) {
                n5 = n4;
            }
            n3 = n5;
        }
        return n3;
    }

    private void q(View view) {
        for (int i2 = this.i - 1; i2 >= 0; --i2) {
            this.a[i2].a(view);
        }
    }

    private int r(int n2) {
        int n3 = this.a[0].b(n2);
        for (int i2 = 1; i2 < this.i; ++i2) {
            int n4 = this.a[i2].b(n2);
            int n5 = n3;
            if (n4 > n3) {
                n5 = n4;
            }
            n3 = n5;
        }
        return n3;
    }

    private int s(int n2) {
        int n3 = this.a[0].b(n2);
        for (int i2 = 1; i2 < this.i; ++i2) {
            int n4 = this.a[i2].b(n2);
            int n5 = n3;
            if (n4 < n3) {
                n5 = n4;
            }
            n3 = n5;
        }
        return n3;
    }

    private boolean t(int n2) {
        int n3 = this.j;
        boolean bl2 = false;
        boolean bl3 = false;
        if (n3 == 0) {
            boolean bl4 = n2 == -1;
            bl2 = bl3;
            if (bl4 != this.e) {
                bl2 = true;
            }
            return bl2;
        }
        boolean bl5 = n2 == -1;
        if ((bl5 = bl5 == this.e) == this.j()) {
            bl2 = true;
        }
        return bl2;
    }

    private int u(int n2) {
        int n3 = this.v();
        int n4 = -1;
        if (n3 == 0) {
            n2 = n4;
            if (this.e) {
                n2 = 1;
            }
            return n2;
        }
        boolean bl2 = n2 < this.L();
        if (bl2 != this.e) {
            return -1;
        }
        return 1;
    }

    private int v(int n2) {
        int n3 = this.v();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.d(this.i(i2));
            if (n4 < 0 || n4 >= n2) continue;
            return n4;
        }
        return 0;
    }

    private int w(int n2) {
        for (int i2 = this.v() - 1; i2 >= 0; --i2) {
            int n3 = this.d(this.i(i2));
            if (n3 < 0 || n3 >= n2) continue;
            return n3;
        }
        return 0;
    }

    private int x(int n2) {
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
                                if (this.j == 1) {
                                    return 1;
                                }
                                if (this.j()) {
                                    return -1;
                                }
                                return 1;
                            }
                            case 1: 
                        }
                        if (this.j == 1) {
                            return -1;
                        }
                        if (this.j()) {
                            return 1;
                        }
                        return -1;
                    }
                    if (this.j == 1) {
                        n3 = 1;
                    }
                    return n3;
                }
                if (this.j == 0) {
                    n3 = 1;
                }
                return n3;
            }
            if (this.j == 1) {
                return -1;
            }
            return Integer.MIN_VALUE;
        }
        if (this.j == 0) {
            return -1;
        }
        return Integer.MIN_VALUE;
    }

    int K() {
        int n2 = this.v();
        if (n2 == 0) {
            return 0;
        }
        return this.d(this.i(n2 - 1));
    }

    int L() {
        if (this.v() == 0) {
            return 0;
        }
        return this.d(this.i(0));
    }

    @Override
    public int a(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        return this.c(n2, p2, u2);
    }

    @Override
    public int a(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.j == 0) {
            return this.i;
        }
        return super.a(p2, u2);
    }

    @Override
    public View a(View view, int n2, RecyclerView.p p2, RecyclerView.u u2) {
        int n3;
        if (this.v() == 0) {
            return null;
        }
        if ((view = this.e(view)) == null) {
            return null;
        }
        this.N();
        int n4 = this.x(n2);
        if (n4 == Integer.MIN_VALUE) {
            return null;
        }
        Object object = (b)view.getLayoutParams();
        boolean bl2 = ((b)object).b;
        object = ((b)object).a;
        n2 = n4 == 1 ? this.K() : this.L();
        this.b(n2, u2);
        this.m(n4);
        this.l.c = this.l.d + n2;
        this.l.b = (int)((float)this.b.f() * 0.33333334f);
        this.l.h = true;
        h h2 = this.l;
        int n5 = 0;
        h2.a = false;
        this.a(p2, this.l, u2);
        this.o = this.e;
        if (!bl2 && (p2 = ((e)object).a(n2, n4)) != null && p2 != view) {
            return p2;
        }
        if (this.t(n4)) {
            for (n3 = this.i - 1; n3 >= 0; --n3) {
                p2 = this.a[n3].a(n2, n4);
                if (p2 == null || p2 == view) continue;
                return p2;
            }
        } else {
            for (n3 = 0; n3 < this.i; ++n3) {
                p2 = this.a[n3].a(n2, n4);
                if (p2 == null || p2 == view) continue;
                return p2;
            }
        }
        boolean bl3 = this.d;
        n2 = n4 == -1 ? 1 : 0;
        n2 = (bl3 ^ true) == n2 ? 1 : 0;
        if (!bl2 && (p2 = this.c(n3 = n2 != 0 ? ((e)object).j() : ((e)object).k())) != null && p2 != view) {
            return p2;
        }
        if (this.t(n4)) {
            for (n3 = this.i - 1; n3 >= 0; --n3) {
                if (n3 == ((e)object).e || (p2 = this.c(n5 = n2 != 0 ? this.a[n3].j() : this.a[n3].k())) == null || p2 == view) continue;
                return p2;
            }
        } else {
            for (n3 = n5; n3 < this.i; ++n3) {
                n5 = n2 != 0 ? this.a[n3].j() : this.a[n3].k();
                p2 = this.c(n5);
                if (p2 == null || p2 == view) continue;
                return p2;
            }
        }
        return null;
    }

    @Override
    public RecyclerView.j a() {
        if (this.j == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override
    public RecyclerView.j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override
    public RecyclerView.j a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams)layoutParams);
        }
        return new b(layoutParams);
    }

    public void a(int n2) {
        this.a((String)null);
        if (n2 != this.i) {
            this.i();
            this.i = n2;
            this.m = new BitSet(this.i);
            this.a = new e[this.i];
            for (n2 = 0; n2 < this.i; ++n2) {
                this.a[n2] = new e(n2);
            }
            this.o();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(int n2, int n3, RecyclerView.u u2, RecyclerView.i.a a2) {
        if (this.j != 0) {
            n2 = n3;
        }
        if (this.v() != 0) {
            if (n2 == 0) {
                return;
            }
            this.a(n2, u2);
            if (this.G == null || this.G.length < this.i) {
                this.G = new int[this.i];
            }
            int n4 = 0;
            n2 = 0;
            for (n3 = 0; n3 < this.i; ++n3) {
                int n5;
                int n6;
                if (this.l.d == -1) {
                    n6 = this.l.f;
                    n5 = this.a[n3].a(this.l.f);
                } else {
                    n6 = this.a[n3].b(this.l.g);
                    n5 = this.l.g;
                }
                n5 = n6 - n5;
                n6 = n2;
                if (n5 >= 0) {
                    this.G[n2] = n5;
                    n6 = n2 + 1;
                }
                n2 = n6;
            }
            Arrays.sort(this.G, 0, n2);
            for (n3 = n4; n3 < n2 && this.l.a(u2); h2.c += this.l.d, ++n3) {
                a2.b(this.l.c, this.G[n3]);
                h h2 = this.l;
            }
        }
    }

    void a(int n2, RecyclerView.u u2) {
        int n3;
        int n4;
        if (n2 > 0) {
            n3 = this.K();
            n4 = 1;
        } else {
            n3 = this.L();
            n4 = -1;
        }
        this.l.a = true;
        this.b(n3, u2);
        this.m(n4);
        this.l.c = n3 + this.l.d;
        this.l.b = Math.abs(n2);
    }

    @Override
    public void a(Rect rect, int n2, int n3) {
        int n4 = this.A() + this.C();
        int n5 = this.B() + this.D();
        if (this.j == 1) {
            n3 = StaggeredGridLayoutManager.a(n3, rect.height() + n5, this.G());
            n4 = StaggeredGridLayoutManager.a(n2, this.k * this.i + n4, this.F());
            n2 = n3;
            n3 = n4;
        } else {
            n2 = StaggeredGridLayoutManager.a(n2, rect.width() + n4, this.F());
            n4 = StaggeredGridLayoutManager.a(n3, this.k * this.i + n5, this.G());
            n3 = n2;
            n2 = n4;
        }
        this.f(n3, n2);
    }

    @Override
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.A = (d)parcelable;
            this.o();
        }
    }

    @Override
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (this.v() > 0) {
            View view = this.b(false);
            View view2 = this.c(false);
            if (view != null) {
                int n2;
                if (view2 == null) {
                    return;
                }
                int n3 = this.d(view);
                if (n3 < (n2 = this.d(view2))) {
                    accessibilityEvent.setFromIndex(n3);
                    accessibilityEvent.setToIndex(n2);
                    return;
                }
                accessibilityEvent.setFromIndex(n2);
                accessibilityEvent.setToIndex(n3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(RecyclerView.p object, RecyclerView.u u2, View view, androidx.core.h.a.b b2) {
        int n2;
        int n3;
        int n4;
        int n5;
        object = view.getLayoutParams();
        if (!(object instanceof b)) {
            super.a(view, b2);
            return;
        }
        object = (b)((Object)object);
        if (this.j == 0) {
            int n6 = ((b)((Object)object)).b();
            n2 = ((b)object).b ? this.i : 1;
            n5 = -1;
            n3 = -1;
            n4 = n2;
            n2 = n6;
        } else {
            n2 = -1;
            n4 = -1;
            n5 = ((b)((Object)object)).b();
            n3 = ((b)object).b ? this.i : 1;
        }
        b2.b(b.b.a(n2, n4, n5, n3, ((b)object).b, false));
    }

    @Override
    public void a(RecyclerView.u u2) {
        super.a(u2);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    void a(RecyclerView.u u2, a a2) {
        if (this.b(u2, a2)) {
            return;
        }
        if (this.c(u2, a2)) {
            return;
        }
        a2.b();
        a2.a = 0;
    }

    @Override
    public void a(RecyclerView recyclerView) {
        this.h.a();
        this.o();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3) {
        this.c(n2, n3, 1);
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, int n4) {
        this.c(n2, n3, 8);
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, Object object) {
        this.c(n2, n3, 4);
    }

    @Override
    public void a(RecyclerView recyclerView, RecyclerView.p p2) {
        super.a(recyclerView, p2);
        this.a(this.H);
        for (int i2 = 0; i2 < this.i; ++i2) {
            this.a[i2].e();
        }
        recyclerView.requestLayout();
    }

    @Override
    public void a(String string2) {
        if (this.A == null) {
            super.a(string2);
        }
    }

    public void a(boolean bl2) {
        this.a((String)null);
        if (this.A != null && this.A.h != bl2) {
            this.A.h = bl2;
        }
        this.d = bl2;
        this.o();
    }

    @Override
    public boolean a(RecyclerView.j j2) {
        return j2 instanceof b;
    }

    @Override
    public int b(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        return this.c(n2, p2, u2);
    }

    @Override
    public int b(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.j == 1) {
            return this.i;
        }
        return super.b(p2, u2);
    }

    View b(boolean bl2) {
        int n2 = this.b.c();
        int n3 = this.b.d();
        int n4 = this.v();
        View view = null;
        for (int i2 = 0; i2 < n4; ++i2) {
            View view2 = this.i(i2);
            int n5 = this.b.a(view2);
            View view3 = view;
            if (this.b.b(view2) > n2) {
                if (n5 >= n3) {
                    view3 = view;
                } else if (n5 < n2) {
                    if (!bl2) {
                        return view2;
                    }
                    view3 = view;
                    if (view == null) {
                        view3 = view2;
                    }
                } else {
                    return view2;
                }
            }
            view = view3;
        }
        return view;
    }

    public void b(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        this.a((String)null);
        if (n2 == this.j) {
            return;
        }
        this.j = n2;
        j j2 = this.b;
        this.b = this.c;
        this.c = j2;
        this.o();
    }

    @Override
    public void b(RecyclerView recyclerView, int n2, int n3) {
        this.c(n2, n3, 2);
    }

    @Override
    public boolean b() {
        return this.A == null;
    }

    /*
     * Enabled aggressive block sorting
     */
    boolean b(RecyclerView.u u2, a a2) {
        boolean bl2 = u2.a();
        boolean bl3 = false;
        if (bl2) return false;
        if (this.f == -1) {
            return false;
        }
        if (this.f >= 0 && this.f < u2.e()) {
            if (this.A != null && this.A.a != -1 && this.A.c >= 1) {
                a2.b = Integer.MIN_VALUE;
                a2.a = this.f;
                return true;
            }
            u2 = this.c(this.f);
            if (u2 != null) {
                int n2 = this.e ? this.K() : this.L();
                a2.a = n2;
                if (this.g != Integer.MIN_VALUE) {
                    int n3;
                    if (a2.c) {
                        n2 = this.b.d() - this.g;
                        n3 = this.b.b((View)u2);
                    } else {
                        n2 = this.b.c() + this.g;
                        n3 = this.b.a((View)u2);
                    }
                    a2.b = n2 - n3;
                    return true;
                }
                if (this.b.e((View)u2) > this.b.f()) {
                    n2 = a2.c ? this.b.d() : this.b.c();
                    a2.b = n2;
                    return true;
                }
                n2 = this.b.a((View)u2) - this.b.c();
                if (n2 < 0) {
                    a2.b = -n2;
                    return true;
                }
                n2 = this.b.d() - this.b.b((View)u2);
                if (n2 < 0) {
                    a2.b = n2;
                    return true;
                }
                a2.b = Integer.MIN_VALUE;
                return true;
            }
            a2.a = this.f;
            if (this.g == Integer.MIN_VALUE) {
                if (this.u(a2.a) == 1) {
                    bl3 = true;
                }
                a2.c = bl3;
                a2.b();
            } else {
                a2.a(this.g);
            }
            a2.d = true;
            return true;
        }
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        return false;
    }

    int c(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        if (this.v() != 0) {
            if (n2 == 0) {
                return 0;
            }
            this.a(n2, u2);
            int n3 = this.a(p2, this.l, u2);
            if (this.l.b >= n3) {
                n2 = n2 < 0 ? -n3 : n3;
            }
            this.b.a(-n2);
            this.o = this.e;
            this.l.b = 0;
            this.a(p2, this.l);
            return n2;
        }
        return 0;
    }

    @Override
    public int c(RecyclerView.u u2) {
        return this.b(u2);
    }

    View c(boolean bl2) {
        int n2 = this.b.c();
        int n3 = this.b.d();
        View view = null;
        for (int i2 = this.v() - 1; i2 >= 0; --i2) {
            View view2 = this.i(i2);
            int n4 = this.b.a(view2);
            int n5 = this.b.b(view2);
            View view3 = view;
            if (n5 > n2) {
                if (n4 >= n3) {
                    view3 = view;
                } else if (n5 > n3) {
                    if (!bl2) {
                        return view2;
                    }
                    view3 = view;
                    if (view == null) {
                        view3 = view2;
                    }
                } else {
                    return view2;
                }
            }
            view = view3;
        }
        return view;
    }

    @Override
    public void c(RecyclerView.p p2, RecyclerView.u u2) {
        this.a(p2, u2, true);
    }

    @Override
    public boolean c() {
        return this.n != 0;
    }

    @Override
    public int d(RecyclerView.u u2) {
        return this.b(u2);
    }

    @Override
    public PointF d(int n2) {
        n2 = this.u(n2);
        PointF pointF = new PointF();
        if (n2 == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = n2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = n2;
        return pointF;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Parcelable d() {
        if (this.A != null) {
            return new d(this.A);
        }
        d d2 = new d();
        d2.h = this.d;
        d2.i = this.o;
        d2.j = this.z;
        c c2 = this.h;
        int n2 = 0;
        if (c2 != null && this.h.a != null) {
            d2.f = this.h.a;
            d2.e = d2.f.length;
            d2.g = this.h.b;
        } else {
            d2.e = 0;
        }
        if (this.v() <= 0) {
            d2.a = -1;
            d2.b = -1;
            d2.c = 0;
            return d2;
        }
        int n3 = this.o ? this.K() : this.L();
        d2.a = n3;
        d2.b = this.k();
        d2.c = this.i;
        d2.d = new int[this.i];
        while (n2 < this.i) {
            block10 : {
                int n4;
                block11 : {
                    block9 : {
                        if (!this.o) break block9;
                        n3 = n4 = this.a[n2].b(Integer.MIN_VALUE);
                        if (n4 == Integer.MIN_VALUE) break block10;
                        n3 = this.b.d();
                        break block11;
                    }
                    n3 = n4 = this.a[n2].a(Integer.MIN_VALUE);
                    if (n4 == Integer.MIN_VALUE) break block10;
                    n3 = this.b.c();
                }
                n3 = n4 - n3;
            }
            d2.d[n2] = n3;
            ++n2;
        }
        return d2;
    }

    @Override
    public int e(RecyclerView.u u2) {
        return this.i(u2);
    }

    @Override
    public void e(int n2) {
        if (this.A != null && this.A.a != n2) {
            this.A.b();
        }
        this.f = n2;
        this.g = Integer.MIN_VALUE;
        this.o();
    }

    @Override
    public boolean e() {
        return this.j == 0;
    }

    @Override
    public int f(RecyclerView.u u2) {
        return this.i(u2);
    }

    void f(int n2) {
        this.k = n2 / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec((int)n2, (int)this.c.h());
    }

    @Override
    public boolean f() {
        return this.j == 1;
    }

    @Override
    public int g(RecyclerView.u u2) {
        return this.j(u2);
    }

    /*
     * Enabled aggressive block sorting
     */
    boolean g() {
        if (this.v() != 0 && this.n != 0) {
            int n2;
            int n3;
            if (!this.q()) {
                return false;
            }
            if (this.e) {
                n2 = this.K();
                n3 = this.L();
            } else {
                n2 = this.L();
                n3 = this.K();
            }
            if (n2 == 0 && this.h() != null) {
                this.h.a();
            } else {
                if (!this.E) {
                    return false;
                }
                int n4 = this.e ? -1 : 1;
                Object object = this.h;
                if ((object = ((c)object).a(n2, ++n3, n4, true)) == null) {
                    this.E = false;
                    this.h.a(n3);
                    return false;
                }
                c.a a2 = this.h.a(n2, ((c.a)object).a, n4 * -1, true);
                if (a2 == null) {
                    this.h.a(((c.a)object).a);
                } else {
                    this.h.a(a2.a + 1);
                }
            }
            this.I();
            this.o();
            return true;
        }
        return false;
    }

    @Override
    public int h(RecyclerView.u u2) {
        return this.j(u2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    View h() {
        var1_1 = this.v() - 1;
        var7_2 = new BitSet(this.i);
        var7_2.set(0, this.i, true);
        var2_3 = this.j;
        var5_4 = -1;
        var2_3 = var2_3 == 1 && this.j() != false ? 1 : -1;
        if (this.e) {
            var3_5 = -1;
        } else {
            var3_5 = var1_1 + 1;
            var1_1 = 0;
        }
        var4_6 = var1_1;
        if (var1_1 < var3_5) {
            var5_4 = 1;
            var4_6 = var1_1;
        }
        while (var4_6 != var3_5) {
            block12 : {
                block13 : {
                    var8_8 = this.i(var4_6);
                    var9_9 = (b)var8_8.getLayoutParams();
                    if (var7_2.get(var9_9.a.e)) {
                        if (this.a(var9_9.a)) {
                            return var8_8;
                        }
                        var7_2.clear(var9_9.a.e);
                    }
                    if (var9_9.b || (var1_1 = var4_6 + var5_4) == var3_5) break block12;
                    var10_11 = this.i(var1_1);
                    if (!this.e) break block13;
                    var1_1 = this.b.b(var8_8);
                    if (var1_1 < (var6_7 = this.b.b(var10_11))) {
                        return var8_8;
                    }
                    if (var1_1 != var6_7) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                var1_1 = this.b.a(var8_8);
                if (var1_1 > (var6_7 = this.b.a(var10_11))) {
                    return var8_8;
                }
                if (var1_1 == var6_7) lbl-1000: // 2 sources:
                {
                    var1_1 = 1;
                } else lbl-1000: // 2 sources:
                {
                    var1_1 = 0;
                }
                if (var1_1 != 0) {
                    var10_12 = (b)var10_11.getLayoutParams();
                    var1_1 = var9_9.a.e - var10_12.a.e < 0 ? 1 : 0;
                    if (var1_1 != (var6_7 = var2_3 < 0 ? 1 : 0)) {
                        return var8_8;
                    }
                }
            }
            var4_6 += var5_4;
        }
        return null;
    }

    public void i() {
        this.h.a();
        this.o();
    }

    @Override
    public void j(int n2) {
        super.j(n2);
        for (int i2 = 0; i2 < this.i; ++i2) {
            this.a[i2].d(n2);
        }
    }

    boolean j() {
        return this.t() == 1;
    }

    int k() {
        View view = this.e ? this.c(true) : this.b(true);
        if (view == null) {
            return -1;
        }
        return this.d(view);
    }

    @Override
    public void k(int n2) {
        super.k(n2);
        for (int i2 = 0; i2 < this.i; ++i2) {
            this.a[i2].d(n2);
        }
    }

    @Override
    public void l(int n2) {
        if (n2 == 0) {
            this.g();
        }
    }

    boolean m() {
        int n2 = this.a[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.i; ++i2) {
            if (this.a[i2].b(Integer.MIN_VALUE) == n2) continue;
            return false;
        }
        return true;
    }

    boolean n() {
        int n2 = this.a[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.i; ++i2) {
            if (this.a[i2].a(Integer.MIN_VALUE) == n2) continue;
            return false;
        }
        return true;
    }

    class a {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            this.a();
        }

        void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(int n2) {
            n2 = this.c ? StaggeredGridLayoutManager.this.b.d() - n2 : StaggeredGridLayoutManager.this.b.c() + n2;
            this.b = n2;
        }

        void a(e[] arre) {
            int n2 = arre.length;
            if (this.f == null || this.f.length < n2) {
                this.f = new int[StaggeredGridLayoutManager.this.a.length];
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                this.f[i2] = arre[i2].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            int n2 = this.c ? StaggeredGridLayoutManager.this.b.d() : StaggeredGridLayoutManager.this.b.c();
            this.b = n2;
        }
    }

    public static class b
    extends RecyclerView.j {
        e a;
        boolean b;

        public b(int n2, int n3) {
            super(n2, n3);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean a() {
            return this.b;
        }

        public final int b() {
            if (this.a == null) {
                return -1;
            }
            return this.a.e;
        }
    }

    static class c {
        int[] a;
        List<a> b;

        c() {
        }

        private void c(int n2, int n3) {
            if (this.b == null) {
                return;
            }
            for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
                a a2 = this.b.get(i2);
                if (a2.a < n2) continue;
                if (a2.a < n2 + n3) {
                    this.b.remove(i2);
                    continue;
                }
                a2.a -= n3;
            }
        }

        private void d(int n2, int n3) {
            if (this.b == null) {
                return;
            }
            for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
                a a2 = this.b.get(i2);
                if (a2.a < n2) continue;
                a2.a += n3;
            }
        }

        private int g(int n2) {
            a a2;
            int n3;
            block5 : {
                if (this.b == null) {
                    return -1;
                }
                a2 = this.f(n2);
                if (a2 != null) {
                    this.b.remove(a2);
                }
                int n4 = this.b.size();
                for (n3 = 0; n3 < n4; ++n3) {
                    if (this.b.get((int)n3).a < n2) {
                        continue;
                    }
                    break block5;
                }
                n3 = -1;
            }
            if (n3 != -1) {
                a2 = this.b.get(n3);
                this.b.remove(n3);
                return a2.a;
            }
            return -1;
        }

        int a(int n2) {
            if (this.b != null) {
                for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
                    if (this.b.get((int)i2).a < n2) continue;
                    this.b.remove(i2);
                }
            }
            return this.b(n2);
        }

        public a a(int n2, int n3, int n4, boolean bl2) {
            if (this.b == null) {
                return null;
            }
            int n5 = this.b.size();
            for (int i2 = 0; i2 < n5; ++i2) {
                a a2 = this.b.get(i2);
                if (a2.a >= n3) {
                    return null;
                }
                if (a2.a < n2 || n4 != 0 && a2.b != n4 && (!bl2 || !a2.d)) continue;
                return a2;
            }
            return null;
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        void a(int n2, int n3) {
            if (this.a != null) {
                if (n2 >= this.a.length) {
                    return;
                }
                int n4 = n2 + n3;
                this.e(n4);
                System.arraycopy(this.a, n4, this.a, n2, this.a.length - n2 - n3);
                Arrays.fill(this.a, this.a.length - n3, this.a.length, -1);
                this.c(n2, n3);
            }
        }

        void a(int n2, e e2) {
            this.e(n2);
            this.a[n2] = e2.e;
        }

        public void a(a a2) {
            if (this.b == null) {
                this.b = new ArrayList<a>();
            }
            int n2 = this.b.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                a a3 = this.b.get(i2);
                if (a3.a == a2.a) {
                    this.b.remove(i2);
                }
                if (a3.a < a2.a) continue;
                this.b.add(i2, a2);
                return;
            }
            this.b.add(a2);
        }

        int b(int n2) {
            if (this.a == null) {
                return -1;
            }
            if (n2 >= this.a.length) {
                return -1;
            }
            int n3 = this.g(n2);
            if (n3 == -1) {
                Arrays.fill(this.a, n2, this.a.length, -1);
                return this.a.length;
            }
            int[] arrn = this.a;
            Arrays.fill(arrn, n2, ++n3, -1);
            return n3;
        }

        void b(int n2, int n3) {
            if (this.a != null) {
                if (n2 >= this.a.length) {
                    return;
                }
                int n4 = n2 + n3;
                this.e(n4);
                System.arraycopy(this.a, n2, this.a, n4, this.a.length - n2 - n3);
                Arrays.fill(this.a, n2, n4, -1);
                this.d(n2, n3);
            }
        }

        int c(int n2) {
            if (this.a != null && n2 < this.a.length) {
                return this.a[n2];
            }
            return -1;
        }

        int d(int n2) {
            int n3;
            for (n3 = this.a.length; n3 <= n2; n3 *= 2) {
            }
            return n3;
        }

        void e(int n2) {
            if (this.a == null) {
                this.a = new int[Math.max(n2, 10) + 1];
                Arrays.fill(this.a, -1);
                return;
            }
            if (n2 >= this.a.length) {
                int[] arrn = this.a;
                this.a = new int[this.d(n2)];
                System.arraycopy(arrn, 0, this.a, 0, arrn.length);
                Arrays.fill(this.a, arrn.length, this.a.length, -1);
            }
        }

        public a f(int n2) {
            if (this.b == null) {
                return null;
            }
            for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
                a a2 = this.b.get(i2);
                if (a2.a != n2) continue;
                return a2;
            }
            return null;
        }

        static class a
        implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

                public a a(Parcel parcel) {
                    return new a(parcel);
                }

                public a[] a(int n2) {
                    return new a[n2];
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
            int[] c;
            boolean d;

            a() {
            }

            a(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                int n2 = parcel.readInt();
                boolean bl2 = true;
                if (n2 != 1) {
                    bl2 = false;
                }
                this.d = bl2;
                n2 = parcel.readInt();
                if (n2 > 0) {
                    this.c = new int[n2];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int n2) {
                if (this.c == null) {
                    return 0;
                }
                return this.c[n2];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FullSpanItem{mPosition=");
                stringBuilder.append(this.a);
                stringBuilder.append(", mGapDir=");
                stringBuilder.append(this.b);
                stringBuilder.append(", mHasUnwantedGapAfter=");
                stringBuilder.append(this.d);
                stringBuilder.append(", mGapPerSpan=");
                stringBuilder.append(Arrays.toString(this.c));
                stringBuilder.append('}');
                return stringBuilder.toString();
            }

            public void writeToParcel(Parcel parcel, int n2) {
                RuntimeException runtimeException;
                super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
                throw runtimeException;
            }

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
        int c;
        int[] d;
        int e;
        int[] f;
        List<c.a> g;
        boolean h;
        boolean i;
        boolean j;

        public d() {
        }

        d(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            int n2 = parcel.readInt();
            boolean bl2 = false;
            boolean bl3 = n2 == 1;
            this.h = bl3;
            bl3 = parcel.readInt() == 1;
            this.i = bl3;
            bl3 = bl2;
            if (parcel.readInt() == 1) {
                bl3 = true;
            }
            this.j = bl3;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d d2) {
            this.c = d2.c;
            this.a = d2.a;
            this.b = d2.b;
            this.d = d2.d;
            this.e = d2.e;
            this.f = d2.f;
            this.h = d2.h;
            this.i = d2.i;
            this.j = d2.j;
            this.g = d2.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
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

    class e {
        ArrayList<View> a = new ArrayList();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        e(int n2) {
            this.e = n2;
        }

        int a(int n2) {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            if (this.a.size() == 0) {
                return n2;
            }
            this.a();
            return this.b;
        }

        int a(int n2, int n3, boolean bl2) {
            return this.a(n2, n3, false, false, bl2);
        }

        /*
         * Enabled aggressive block sorting
         */
        int a(int n2, int n3, boolean bl2, boolean bl3, boolean bl4) {
            int n4 = StaggeredGridLayoutManager.this.b.c();
            int n5 = StaggeredGridLayoutManager.this.b.d();
            int n6 = n3 > n2 ? 1 : -1;
            while (n2 != n3) {
                View view = this.a.get(n2);
                int n7 = StaggeredGridLayoutManager.this.b.a(view);
                int n8 = StaggeredGridLayoutManager.this.b.b(view);
                boolean bl5 = false;
                boolean bl6 = bl4 ? n7 <= n5 : n7 < n5;
                if (bl4 ? n8 >= n4 : n8 > n4) {
                    bl5 = true;
                }
                if (bl6 && bl5) {
                    if (bl2 && bl3) {
                        if (n7 >= n4 && n8 <= n5) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    } else {
                        if (bl3) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                        if (n7 < n4) return StaggeredGridLayoutManager.this.d(view);
                        if (n8 > n5) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    }
                }
                n2 += n6;
            }
            return -1;
        }

        public View a(int n2, int n3) {
            View view;
            block9 : {
                view = null;
                View view2 = null;
                if (n3 == -1) {
                    int n4 = this.a.size();
                    n3 = 0;
                    do {
                        view = view2;
                        if (n3 >= n4) break block9;
                        View view3 = this.a.get(n3);
                        if (StaggeredGridLayoutManager.this.d) {
                            view = view2;
                            if (StaggeredGridLayoutManager.this.d(view3) <= n2) break block9;
                        }
                        if (!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) >= n2) {
                            return view2;
                        }
                        view = view2;
                        if (view3.hasFocusable()) {
                            ++n3;
                            view2 = view3;
                            continue;
                        }
                        break block9;
                        break;
                    } while (true);
                }
                n3 = this.a.size() - 1;
                view2 = view;
                do {
                    view = view2;
                    if (n3 < 0) break;
                    View view4 = this.a.get(n3);
                    if (StaggeredGridLayoutManager.this.d) {
                        view = view2;
                        if (StaggeredGridLayoutManager.this.d(view4) >= n2) break;
                    }
                    if (!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view4) <= n2) {
                        return view2;
                    }
                    view = view2;
                    if (!view4.hasFocusable()) break;
                    --n3;
                    view2 = view4;
                } while (true);
            }
            return view;
        }

        void a() {
            Object object = this.a.get(0);
            b b2 = this.c((View)object);
            this.b = StaggeredGridLayoutManager.this.b.a((View)object);
            if (b2.b && (object = StaggeredGridLayoutManager.this.h.f(b2.f())) != null && ((c.a)object).b == -1) {
                this.b -= ((c.a)object).a(this.e);
            }
        }

        void a(View view) {
            b b2 = this.c(view);
            b2.a = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (b2.d() || b2.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        void a(boolean bl2, int n2) {
            int n3 = bl2 ? this.b(Integer.MIN_VALUE) : this.a(Integer.MIN_VALUE);
            this.e();
            if (n3 == Integer.MIN_VALUE) {
                return;
            }
            if (bl2 && n3 < StaggeredGridLayoutManager.this.b.d() || !bl2 && n3 > StaggeredGridLayoutManager.this.b.c()) {
                return;
            }
            int n4 = n3;
            if (n2 != Integer.MIN_VALUE) {
                n4 = n3 + n2;
            }
            this.c = n4;
            this.b = n4;
        }

        int b() {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            this.a();
            return this.b;
        }

        int b(int n2) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.a.size() == 0) {
                return n2;
            }
            this.c();
            return this.c;
        }

        void b(View view) {
            b b2 = this.c(view);
            b2.a = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (b2.d() || b2.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        b c(View view) {
            return (b)view.getLayoutParams();
        }

        void c() {
            Object object = this.a.get(this.a.size() - 1);
            b b2 = this.c((View)object);
            this.c = StaggeredGridLayoutManager.this.b.b((View)object);
            if (b2.b && (object = StaggeredGridLayoutManager.this.h.f(b2.f())) != null && ((c.a)object).b == 1) {
                this.c += ((c.a)object).a(this.e);
            }
        }

        void c(int n2) {
            this.b = n2;
            this.c = n2;
        }

        int d() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            this.c();
            return this.c;
        }

        void d(int n2) {
            if (this.b != Integer.MIN_VALUE) {
                this.b += n2;
            }
            if (this.c != Integer.MIN_VALUE) {
                this.c += n2;
            }
        }

        void e() {
            this.a.clear();
            this.f();
            this.d = 0;
        }

        void f() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void g() {
            int n2 = this.a.size();
            View view = this.a.remove(n2 - 1);
            b b2 = this.c(view);
            b2.a = null;
            if (b2.d() || b2.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(view);
            }
            if (n2 == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void h() {
            View view = this.a.remove(0);
            b b2 = this.c(view);
            b2.a = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (b2.d() || b2.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(view);
            }
            this.b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int j() {
            int n2;
            int n3;
            if (StaggeredGridLayoutManager.this.d) {
                n2 = this.a.size() - 1;
                n3 = -1;
                do {
                    return this.a(n2, n3, true);
                    break;
                } while (true);
            }
            n2 = 0;
            n3 = this.a.size();
            return this.a(n2, n3, true);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int k() {
            int n2;
            int n3;
            if (StaggeredGridLayoutManager.this.d) {
                n2 = 0;
                n3 = this.a.size();
                do {
                    return this.a(n2, n3, true);
                    break;
                } while (true);
            }
            n2 = this.a.size() - 1;
            n3 = -1;
            return this.a(n2, n3, true);
        }
    }

}

