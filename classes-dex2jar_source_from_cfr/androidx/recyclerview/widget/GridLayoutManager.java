/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.a.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import java.util.Arrays;
import java.util.List;

public class GridLayoutManager
extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g = new a();
    final Rect h = new Rect();

    public GridLayoutManager(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.a(GridLayoutManager.a((Context)context, (AttributeSet)attributeSet, (int)n2, (int)n3).b);
    }

    private void K() {
        this.e.clear();
        this.f.clear();
    }

    private void L() {
        int n2 = this.v();
        for (int i2 = 0; i2 < n2; ++i2) {
            b b2 = (b)this.i(i2).getLayoutParams();
            int n3 = b2.f();
            this.e.put(n3, b2.b());
            this.f.put(n3, b2.a());
        }
    }

    private void M() {
        int n2;
        int n3;
        if (this.g() == 1) {
            n2 = this.y() - this.C();
            n3 = this.A();
        } else {
            n2 = this.z() - this.D();
            n3 = this.B();
        }
        this.m(n2 - n3);
    }

    private void N() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    private int a(RecyclerView.p object, RecyclerView.u u2, int n2) {
        if (!u2.a()) {
            return this.g.c(n2, this.b);
        }
        int n3 = ((RecyclerView.p)object).b(n2);
        if (n3 == -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot find span size for pre layout position. ");
            ((StringBuilder)object).append(n2);
            Log.w((String)"GridLayoutManager", (String)((StringBuilder)object).toString());
            return 0;
        }
        return this.g.c(n3, this.b);
    }

    private void a(float f2, int n2) {
        this.m(Math.max(Math.round(f2 * (float)this.b), n2));
    }

    private void a(View view, int n2, int n3, boolean bl2) {
        RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
        if (bl2 = bl2 ? this.a(view, n2, n3, j2) : this.b(view, n2, n3, j2)) {
            view.measure(n2, n3);
        }
    }

    private void a(View view, int n2, boolean bl2) {
        b b2 = (b)view.getLayoutParams();
        Rect rect = b2.d;
        int n3 = rect.top + rect.bottom + b2.topMargin + b2.bottomMargin;
        int n4 = rect.left + rect.right + b2.leftMargin + b2.rightMargin;
        int n5 = this.a(b2.a, b2.b);
        if (this.i == 1) {
            n4 = GridLayoutManager.a(n5, n2, n4, b2.width, false);
            n2 = GridLayoutManager.a(this.j.f(), this.x(), n3, b2.height, true);
        } else {
            n2 = GridLayoutManager.a(n5, n2, n3, b2.height, false);
            n4 = GridLayoutManager.a(this.j.f(), this.w(), n4, b2.width, true);
        }
        this.a(view, n4, n2, bl2);
    }

    private void a(RecyclerView.p p2, RecyclerView.u u2, int n2, int n3, boolean bl2) {
        int n4;
        n3 = -1;
        int n5 = 0;
        if (bl2) {
            n3 = n2;
            n2 = 0;
            n4 = 1;
        } else {
            --n2;
            n4 = -1;
        }
        while (n2 != n3) {
            View view = this.d[n2];
            b b2 = (b)view.getLayoutParams();
            b2.b = this.c(p2, u2, this.d(view));
            b2.a = n5;
            n5 += b2.b;
            n2 += n4;
        }
    }

    static int[] a(int[] arrn, int n2, int n3) {
        int n4;
        int[] arrn2;
        block7 : {
            block6 : {
                n4 = 1;
                if (arrn == null || arrn.length != n2 + 1) break block6;
                arrn2 = arrn;
                if (arrn[arrn.length - 1] == n3) break block7;
            }
            arrn2 = new int[n2 + 1];
        }
        int n5 = 0;
        arrn2[0] = 0;
        int n6 = n3 / n2;
        int n7 = n3 % n2;
        int n8 = 0;
        n3 = n5;
        while (n4 <= n2) {
            if ((n3 += n7) > 0 && n2 - n3 < n7) {
                n5 = n6 + 1;
                n3 -= n2;
            } else {
                n5 = n6;
            }
            arrn2[n4] = n8 += n5;
            ++n4;
        }
        return arrn2;
    }

    private int b(RecyclerView.p object, RecyclerView.u u2, int n2) {
        if (!u2.a()) {
            return this.g.b(n2, this.b);
        }
        int n3 = this.f.get(n2, -1);
        if (n3 != -1) {
            return n3;
        }
        n3 = ((RecyclerView.p)object).b(n2);
        if (n3 == -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            ((StringBuilder)object).append(n2);
            Log.w((String)"GridLayoutManager", (String)((StringBuilder)object).toString());
            return 0;
        }
        return this.g.b(n3, this.b);
    }

    private void b(RecyclerView.p p2, RecyclerView.u u2, LinearLayoutManager.a a2, int n2) {
        n2 = n2 == 1 ? 1 : 0;
        int n3 = this.b(p2, u2, a2.b);
        if (n2 != 0) {
            while (n3 > 0 && a2.b > 0) {
                --a2.b;
                n3 = this.b(p2, u2, a2.b);
            }
        } else {
            int n4;
            int n5;
            int n6 = u2.e();
            n2 = a2.b;
            while (n2 < n6 - 1 && (n4 = this.b(p2, u2, n5 = n2 + 1)) > n3) {
                n2 = n5;
                n3 = n4;
            }
            a2.b = n2;
        }
    }

    private int c(RecyclerView.p object, RecyclerView.u u2, int n2) {
        if (!u2.a()) {
            return this.g.a(n2);
        }
        int n3 = this.e.get(n2, -1);
        if (n3 != -1) {
            return n3;
        }
        n3 = ((RecyclerView.p)object).b(n2);
        if (n3 == -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            ((StringBuilder)object).append(n2);
            Log.w((String)"GridLayoutManager", (String)((StringBuilder)object).toString());
            return 1;
        }
        return this.g.a(n3);
    }

    private void m(int n2) {
        this.c = GridLayoutManager.a(this.c, this.b, n2);
    }

    int a(int n2, int n3) {
        if (this.i == 1 && this.h()) {
            return this.c[this.b - n2] - this.c[this.b - n2 - n3];
        }
        return this.c[n3 + n2] - this.c[n2];
    }

    @Override
    public int a(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        this.M();
        this.N();
        return super.a(n2, p2, u2);
    }

    @Override
    public int a(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.i == 0) {
            return this.b;
        }
        if (u2.e() < 1) {
            return 0;
        }
        return this.a(p2, u2, u2.e() - 1) + 1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public View a(View var1_1, int var2_2, RecyclerView.p var3_3, RecyclerView.u var4_4) {
        var21_8 = this.e(var1_1 /* !! */ );
        var22_9 = null;
        if (var21_8 == null) {
            return null;
        }
        var23_10 = (b)var21_8.getLayoutParams();
        var14_11 = var23_10.a;
        var15_12 = var23_10.a + var23_10.b;
        if (super.a(var1_1 /* !! */ , var2_5, (RecyclerView.p)var3_6, (RecyclerView.u)var4_7) == null) {
            return null;
        }
        var20_13 = this.f(var2_5) == 1;
        var2_5 = var20_13 != this.k ? 1 : 0;
        if (var2_5 != 0) {
            var7_14 = this.v() - 1;
            var5_15 = -1;
            var8_16 = -1;
        } else {
            var5_15 = this.v();
            var7_14 = 0;
            var8_16 = 1;
        }
        var9_17 = this.i == 1 && this.h() != false ? 1 : 0;
        var16_18 = this.a((RecyclerView.p)var3_6, (RecyclerView.u)var4_7, var7_14);
        var1_2 = null;
        var12_19 = -1;
        var11_20 = 0;
        var2_5 = 0;
        var6_21 = -1;
        var10_22 = var5_15;
        var5_15 = var12_19;
        while (var7_14 != var10_22) {
            block15 : {
                block16 : {
                    block14 : {
                        var12_19 = this.a((RecyclerView.p)var3_6, (RecyclerView.u)var4_7, var7_14);
                        var23_10 = this.i(var7_14);
                        if (var23_10 == var21_8) break;
                        if (!var23_10.hasFocusable() || var12_19 == var16_18) break block14;
                        if (var22_9 != null) {
                            break;
                        }
                        break block15;
                    }
                    var24_27 = (b)var23_10.getLayoutParams();
                    var17_24 = var24_27.a;
                    var18_25 = var24_27.a + var24_27.b;
                    if (var23_10.hasFocusable() && var17_24 == var14_11 && var18_25 == var15_12) {
                        return var23_10;
                    }
                    if (var23_10.hasFocusable() && var22_9 == null || !var23_10.hasFocusable() && var1_3 == null) ** GOTO lbl-1000
                    var12_19 = Math.max(var17_24, var14_11);
                    var19_26 = Math.min(var18_25, var15_12) - var12_19;
                    if (!var23_10.hasFocusable()) break block16;
                    if (var19_26 <= var11_20 && (var19_26 != var11_20 || var9_17 != (var12_19 = var17_24 > var5_15 ? 1 : 0))) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                if (var22_9 != null) ** GOTO lbl-1000
                var12_19 = 0;
                if (!this.a((View)var23_10, false, true)) ** GOTO lbl-1000
                var13_23 = var2_5;
                if (var19_26 > var13_23) ** GOTO lbl-1000
                if (var19_26 == var13_23) {
                    if (var17_24 > var6_21) {
                        var12_19 = 1;
                    }
                    ** if (var9_17 != var12_19) goto lbl-1000
                }
                ** GOTO lbl-1000
lbl-1000: // 4 sources:
                {
                    var12_19 = 1;
                    ** GOTO lbl63
                }
lbl-1000: // 5 sources:
                {
                    var12_19 = 0;
                }
lbl63: // 2 sources:
                if (var12_19 != 0) {
                    if (var23_10.hasFocusable()) {
                        var5_15 = var24_27.a;
                        var11_20 = Math.min(var18_25, var15_12) - Math.max(var17_24, var14_11);
                        var22_9 = var23_10;
                    } else {
                        var6_21 = var24_27.a;
                        var2_5 = Math.min(var18_25, var15_12);
                        var12_19 = Math.max(var17_24, var14_11);
                        var1_4 = var23_10;
                        var2_5 -= var12_19;
                    }
                }
            }
            var7_14 += var8_16;
        }
        if (var22_9 == null) return var1_3;
        return var22_9;
    }

    @Override
    View a(RecyclerView.p p2, RecyclerView.u u2, int n2, int n3, int n4) {
        this.i();
        int n5 = this.j.c();
        int n6 = this.j.d();
        int n7 = n3 > n2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (n2 != n3) {
            View view3 = this.i(n2);
            int n8 = this.d(view3);
            View view4 = view;
            View view5 = view2;
            if (n8 >= 0) {
                view4 = view;
                view5 = view2;
                if (n8 < n4) {
                    if (this.b(p2, u2, n8) != 0) {
                        view4 = view;
                        view5 = view2;
                    } else if (((RecyclerView.j)view3.getLayoutParams()).d()) {
                        view4 = view;
                        view5 = view2;
                        if (view2 == null) {
                            view5 = view3;
                            view4 = view;
                        }
                    } else {
                        if (this.j.a(view3) < n6 && this.j.b(view3) >= n5) {
                            return view3;
                        }
                        view4 = view;
                        view5 = view2;
                        if (view == null) {
                            view4 = view3;
                            view5 = view2;
                        }
                    }
                }
            }
            n2 += n7;
            view = view4;
            view2 = view5;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    @Override
    public RecyclerView.j a() {
        if (this.i == 0) {
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
        if (n2 == this.b) {
            return;
        }
        this.a = true;
        if (n2 >= 1) {
            this.b = n2;
            this.g.a();
            this.o();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Span count should be at least 1. Provided ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public void a(Rect rect, int n2, int n3) {
        if (this.c == null) {
            super.a(rect, n2, n3);
        }
        int n4 = this.A() + this.C();
        int n5 = this.B() + this.D();
        if (this.i == 1) {
            n3 = GridLayoutManager.a(n3, rect.height() + n5, this.G());
            n4 = GridLayoutManager.a(n2, this.c[this.c.length - 1] + n4, this.F());
            n2 = n3;
            n3 = n4;
        } else {
            n2 = GridLayoutManager.a(n2, rect.width() + n4, this.F());
            n4 = GridLayoutManager.a(n3, this.c[this.c.length - 1] + n5, this.G());
            n3 = n2;
            n2 = n4;
        }
        this.f(n3, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(RecyclerView.p p2, RecyclerView.u u2, View object, androidx.core.h.a.b b2) {
        boolean bl2;
        int n2;
        int n3;
        int n4;
        ViewGroup.LayoutParams layoutParams = object.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a((View)object, b2);
            return;
        }
        object = (b)layoutParams;
        int n5 = this.a(p2, u2, ((RecyclerView.j)((Object)object)).f());
        if (this.i == 0) {
            n2 = ((b)((Object)object)).a();
            int n6 = ((b)((Object)object)).b();
            n4 = 1;
            bl2 = this.b > 1 && ((b)((Object)object)).b() == this.b;
            n3 = n5;
            n5 = n6;
        } else {
            int n7 = 1;
            n3 = ((b)((Object)object)).a();
            n4 = ((b)((Object)object)).b();
            bl2 = this.b > 1 && ((b)((Object)object)).b() == this.b;
            n2 = n5;
            n5 = n7;
        }
        b2.b(b.b.a(n2, n5, n3, n4, bl2, false));
    }

    @Override
    void a(RecyclerView.p p2, RecyclerView.u u2, LinearLayoutManager.a a2, int n2) {
        super.a(p2, u2, a2, n2);
        this.M();
        if (u2.e() > 0 && !u2.a()) {
            this.b(p2, u2, a2, n2);
        }
        this.N();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void a(RecyclerView.p object, RecyclerView.u object2, LinearLayoutManager.c c2, LinearLayoutManager.b b2) {
        int n2;
        int n3;
        View view;
        int n4;
        int n5 = this.j.i();
        int n6 = n5 != 1073741824 ? 1 : 0;
        int n7 = this.v() > 0 ? this.c[this.b] : 0;
        if (n6 != 0) {
            this.M();
        }
        boolean bl2 = c2.e == 1;
        int n8 = this.b;
        if (!bl2) {
            n8 = this.b((RecyclerView.p)object, (RecyclerView.u)object2, c2.d) + this.c((RecyclerView.p)object, (RecyclerView.u)object2, c2.d);
        }
        int n9 = 0;
        for (n4 = 0; n4 < this.b && c2.a((RecyclerView.u)object2) && n8 > 0; n9 += n3, ++n4) {
            n2 = c2.d;
            n3 = this.c((RecyclerView.p)object, (RecyclerView.u)object2, n2);
            if (n3 > this.b) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Item at position ");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append(" requires ");
                ((StringBuilder)object).append(n3);
                ((StringBuilder)object).append(" spans but GridLayoutManager has only ");
                ((StringBuilder)object).append(this.b);
                ((StringBuilder)object).append(" spans.");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            if ((n8 -= n3) < 0 || (view = c2.a((RecyclerView.p)object)) == null) break;
            this.d[n4] = view;
        }
        if (n4 == 0) {
            b2.b = true;
            return;
        }
        float f2 = 0.0f;
        this.a((RecyclerView.p)object, (RecyclerView.u)object2, n4, n9, bl2);
        n8 = 0;
        for (n9 = 0; n9 < n4; ++n9) {
            object = this.d[n9];
            if (c2.k == null) {
                if (bl2) {
                    this.b((View)object);
                } else {
                    this.b((View)object, 0);
                }
            } else if (bl2) {
                this.a((View)object);
            } else {
                this.a((View)object, 0);
            }
            this.b((View)object, this.h);
            this.a((View)object, n5, false);
            n2 = this.j.e((View)object);
            n3 = n8;
            if (n2 > n8) {
                n3 = n2;
            }
            object2 = (b)object.getLayoutParams();
            float f3 = (float)this.j.f((View)object) * 1.0f / (float)((b)object2).b;
            float f4 = f2;
            if (f3 > f2) {
                f4 = f3;
            }
            n8 = n3;
            f2 = f4;
        }
        n9 = n8;
        if (n6 != 0) {
            this.a(f2, n7);
            n6 = 0;
            n8 = 0;
            do {
                n9 = n8;
                if (n6 >= n4) break;
                object = this.d[n6];
                this.a((View)object, 1073741824, true);
                n7 = this.j.e((View)object);
                n9 = n8;
                if (n7 > n8) {
                    n9 = n7;
                }
                ++n6;
                n8 = n9;
            } while (true);
        }
        for (n8 = 0; n8 < n4; ++n8) {
            object = this.d[n8];
            if (this.j.e((View)object) == n9) continue;
            object2 = (b)object.getLayoutParams();
            view = ((b)object2).d;
            n7 = view.top + view.bottom + ((b)object2).topMargin + ((b)object2).bottomMargin;
            n6 = view.left + view.right + ((b)object2).leftMargin + ((b)object2).rightMargin;
            n3 = this.a(((b)object2).a, ((b)object2).b);
            if (this.i == 1) {
                n6 = GridLayoutManager.a(n3, 1073741824, n6, ((b)object2).width, false);
                n7 = View.MeasureSpec.makeMeasureSpec((int)(n9 - n7), (int)1073741824);
            } else {
                n6 = View.MeasureSpec.makeMeasureSpec((int)(n9 - n6), (int)1073741824);
                n7 = GridLayoutManager.a(n3, 1073741824, n7, ((b)object2).height, false);
            }
            this.a((View)object, n6, n7, true);
        }
        n3 = 0;
        b2.a = n9;
        if (this.i == 1) {
            if (c2.f == -1) {
                n8 = n6 = c2.b;
                n9 = n8;
                n8 = n6 -= n9;
            } else {
                n8 = n6 = c2.b;
                n9 += n6;
            }
            n6 = 0;
            n7 = 0;
        } else if (c2.f == -1) {
            n6 = c2.b;
            n8 = 0;
            n2 = 0;
            n7 = n6;
            n6 -= n9;
            n9 = n2;
        } else {
            n6 = c2.b;
            n7 = n9 + n6;
            n8 = 0;
            n9 = 0;
        }
        do {
            block31 : {
                block32 : {
                    block29 : {
                        block30 : {
                            if (n3 >= n4) {
                                Arrays.fill((Object[])this.d, null);
                                return;
                            }
                            object = this.d[n3];
                            object2 = (b)object.getLayoutParams();
                            if (this.i != 1) break block29;
                            if (!this.h()) break block30;
                            n7 = this.A() + this.c[this.b - ((b)object2).a];
                            n2 = this.j.f((View)object);
                            n6 = n7;
                            n7 -= n2;
                            break block31;
                        }
                        n6 = this.A() + this.c[((b)object2).a];
                        n7 = this.j.f((View)object) + n6;
                        break block32;
                    }
                    n8 = this.B() + this.c[((b)object2).a];
                    n9 = this.j.f((View)object) + n8;
                }
                n2 = n6;
                n6 = n7;
                n7 = n2;
            }
            this.a((View)object, n7, n8, n6, n9);
            if (((RecyclerView.j)((Object)object2)).d() || ((RecyclerView.j)((Object)object2)).e()) {
                b2.c = true;
            }
            b2.d |= object.hasFocusable();
            n2 = n3 + 1;
            n3 = n6;
            n6 = n7;
            n7 = n3;
            n3 = n2;
        } while (true);
    }

    @Override
    public void a(RecyclerView.u u2) {
        super.a(u2);
        this.a = false;
    }

    @Override
    void a(RecyclerView.u u2, LinearLayoutManager.c c2, RecyclerView.i.a a2) {
        int n2 = this.b;
        for (int i2 = 0; i2 < this.b && c2.a(u2) && n2 > 0; ++i2) {
            int n3 = c2.d;
            a2.b(n3, Math.max(0, c2.g));
            n2 -= this.g.a(n3);
            c2.d += c2.e;
        }
    }

    @Override
    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3) {
        this.g.a();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, int n4) {
        this.g.a();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, Object object) {
        this.g.a();
    }

    @Override
    public void a(boolean bl2) {
        if (!bl2) {
            super.a(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override
    public boolean a(RecyclerView.j j2) {
        return j2 instanceof b;
    }

    @Override
    public int b(int n2, RecyclerView.p p2, RecyclerView.u u2) {
        this.M();
        this.N();
        return super.b(n2, p2, u2);
    }

    @Override
    public int b(RecyclerView.p p2, RecyclerView.u u2) {
        if (this.i == 1) {
            return this.b;
        }
        if (u2.e() < 1) {
            return 0;
        }
        return this.a(p2, u2, u2.e() - 1) + 1;
    }

    @Override
    public void b(RecyclerView recyclerView, int n2, int n3) {
        this.g.a();
    }

    @Override
    public boolean b() {
        return this.n == null && !this.a;
    }

    @Override
    public void c(RecyclerView.p p2, RecyclerView.u u2) {
        if (u2.a()) {
            this.L();
        }
        super.c(p2, u2);
        this.K();
    }

    public static final class a
    extends c {
        @Override
        public int a(int n2) {
            return 1;
        }

        @Override
        public int a(int n2, int n3) {
            return n2 % n3;
        }
    }

    public static class b
    extends RecyclerView.j {
        int a = -1;
        int b = 0;

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

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public static abstract class c {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;

        public abstract int a(int var1);

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public int a(int var1_1, int var2_2) {
            block6 : {
                var8_3 = this.a(var1_1);
                if (var8_3 == var2_2) {
                    return 0;
                }
                if (!this.b || this.a.size() <= 0 || (var5_4 = this.b(var1_1)) < 0) break block6;
                var3_5 = this.a.get(var5_4) + this.a(var5_4);
                ** GOTO lbl25
            }
            var4_6 = 0;
            var3_5 = 0;
            do {
                if (var4_6 >= var1_1) {
                    if (var8_3 + var3_5 > var2_2) return 0;
                    return var3_5;
                }
                var6_7 = this.a(var4_6);
                var7_8 = var3_5 + var6_7;
                if (var7_8 == var2_2) {
                    var3_5 = 0;
                    var5_4 = var4_6;
                } else {
                    var5_4 = var4_6;
                    var3_5 = var7_8;
                    if (var7_8 > var2_2) {
                        var3_5 = var6_7;
                        var5_4 = var4_6;
                    }
                }
lbl25: // 5 sources:
                var4_6 = var5_4 + 1;
            } while (true);
        }

        public void a() {
            this.a.clear();
        }

        int b(int n2) {
            int n3 = this.a.size() - 1;
            int n4 = 0;
            while (n4 <= n3) {
                int n5 = n4 + n3 >>> 1;
                if (this.a.keyAt(n5) < n2) {
                    n4 = n5 + 1;
                    continue;
                }
                n3 = n5 - 1;
            }
            n2 = n4 - 1;
            if (n2 >= 0 && n2 < this.a.size()) {
                return this.a.keyAt(n2);
            }
            return -1;
        }

        int b(int n2, int n3) {
            if (!this.b) {
                return this.a(n2, n3);
            }
            int n4 = this.a.get(n2, -1);
            if (n4 != -1) {
                return n4;
            }
            n3 = this.a(n2, n3);
            this.a.put(n2, n3);
            return n3;
        }

        public int c(int n2, int n3) {
            int n4 = this.a(n2);
            int n5 = 0;
            int n6 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n7;
                int n8 = this.a(i2);
                int n9 = n5 + n8;
                if (n9 == n3) {
                    n7 = n6 + 1;
                    n5 = 0;
                } else {
                    n5 = n9;
                    n7 = n6;
                    if (n9 > n3) {
                        n7 = n6 + 1;
                        n5 = n8;
                    }
                }
                n6 = n7;
            }
            n2 = n6;
            if (n5 + n4 > n3) {
                n2 = n6 + 1;
            }
            return n2;
        }
    }

}

