/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.a.o;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.d;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.f;
import androidx.constraintlayout.widget.g;
import androidx.constraintlayout.widget.h;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstraintLayout
extends ViewGroup {
    SparseArray<View> a = new SparseArray();
    androidx.constraintlayout.b.a.g b = new androidx.constraintlayout.b.a.g();
    protected d c = null;
    int d = -1;
    int e = -1;
    int f = 0;
    int g = 0;
    Handler h = new Handler(Looper.getMainLooper()){

        public void handleMessage(Message message) {
            ConstraintLayout.this.a(ConstraintLayout.this.r, message.arg1, message.arg2);
        }
    };
    private ArrayList<c> i = new ArrayList(4);
    private final ArrayList<androidx.constraintlayout.b.a.f> j = new ArrayList(100);
    private int k = 0;
    private int l = 0;
    private int m = Integer.MAX_VALUE;
    private int n = Integer.MAX_VALUE;
    private boolean o = true;
    private int p = 3;
    private e q = null;
    private int r = -1;
    private HashMap<String, Integer> s = new HashMap();
    private int t = -1;
    private int u = -1;
    private g v;
    private androidx.constraintlayout.b.f w;

    public ConstraintLayout(Context context) {
        super(context);
        this.b(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.b(attributeSet);
    }

    private void a(int n2, int n3) {
        int n4 = this.getPaddingTop() + this.getPaddingBottom();
        int n5 = this.getPaddingLeft() + this.getPaddingRight();
        int n6 = this.getChildCount();
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7;
            boolean bl2;
            int n8;
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            a a2 = (a)view.getLayoutParams();
            androidx.constraintlayout.b.a.f f2 = a2.am;
            if (a2.Y || a2.Z && !a2.ab) continue;
            f2.e(view.getVisibility());
            if (a2.ab) {
                f2.e(0);
            }
            int n9 = a2.width;
            int n10 = a2.height;
            int n11 = !a2.V && !a2.W && (a2.V || a2.I != 1) && a2.width != -1 && (a2.W || a2.J != 1 && a2.height != -1) ? 0 : 1;
            if (n11 != 0) {
                if (n9 == 0) {
                    n7 = ConstraintLayout.getChildMeasureSpec((int)n2, (int)n5, (int)-2);
                    n11 = 1;
                } else if (n9 == -1) {
                    n7 = ConstraintLayout.getChildMeasureSpec((int)n2, (int)n5, (int)-1);
                    n11 = 0;
                } else {
                    n11 = n9 == -2 ? 1 : 0;
                    n7 = ConstraintLayout.getChildMeasureSpec((int)n2, (int)n5, (int)n9);
                }
                if (n10 == 0) {
                    n8 = ConstraintLayout.getChildMeasureSpec((int)n3, (int)n4, (int)-2);
                    bl2 = true;
                } else if (n10 == -1) {
                    n8 = ConstraintLayout.getChildMeasureSpec((int)n3, (int)n4, (int)-1);
                    bl2 = false;
                } else {
                    bl2 = n10 == -2;
                    n8 = ConstraintLayout.getChildMeasureSpec((int)n3, (int)n4, (int)n10);
                }
                view.measure(n7, n8);
                if (this.w != null) {
                    androidx.constraintlayout.b.f f3 = this.w;
                    ++f3.a;
                }
                boolean bl3 = n9 == -2;
                f2.b(bl3);
                bl3 = n10 == -2;
                f2.c(bl3);
                n7 = view.getMeasuredWidth();
                n8 = view.getMeasuredHeight();
            } else {
                n11 = 0;
                bl2 = false;
                n8 = n10;
                n7 = n9;
            }
            f2.h(n7);
            f2.i(n8);
            if (n11 != 0) {
                f2.l(n7);
            }
            if (bl2) {
                f2.m(n8);
            }
            if (!a2.X || (n11 = view.getBaseline()) == -1) continue;
            f2.n(n11);
        }
    }

    private final androidx.constraintlayout.b.a.f b(int n2) {
        if (n2 == 0) {
            return this.b;
        }
        View view = (View)this.a.get(n2);
        if (view == this) {
            return this.b;
        }
        if (view == null) {
            return null;
        }
        return ((a)view.getLayoutParams()).am;
    }

    private void b() {
        boolean bl2;
        int n2 = this.getChildCount();
        boolean bl3 = false;
        int n3 = 0;
        do {
            bl2 = bl3;
            if (n3 >= n2) break;
            if (this.getChildAt(n3).isLayoutRequested()) {
                bl2 = true;
                break;
            }
            ++n3;
        } while (true);
        if (bl2) {
            this.j.clear();
            this.c();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void b(int var1_1, int var2_2) {
        var3_3 = this.getPaddingTop() + this.getPaddingBottom();
        var15_4 = this.getPaddingLeft() + this.getPaddingRight();
        var10_5 = this.getChildCount();
        var4_6 = 0;
        do {
            var16_12 = 1L;
            if (var4_6 >= var10_5) break;
            var21_14 = this.getChildAt(var4_6);
            if (var21_14.getVisibility() != 8) {
                var22_15 = (a)var21_14.getLayoutParams();
                var23_16 = var22_15.am;
                if (!var22_15.Y && !var22_15.Z) {
                    var23_16.e(var21_14.getVisibility());
                    var7_9 = var22_15.width;
                    var8_10 = var22_15.height;
                    if (var7_9 != 0 && var8_10 != 0) {
                        var5_7 = var7_9 == -2 ? 1 : 0;
                        var9_11 = ConstraintLayout.getChildMeasureSpec((int)var1_1, (int)var15_4, (int)var7_9);
                        var6_8 = var8_10 == -2 ? 1 : 0;
                        var21_14.measure(var9_11, ConstraintLayout.getChildMeasureSpec((int)var2_2, (int)var3_3, (int)var8_10));
                        if (this.w != null) {
                            var24_17 = this.w;
                            ++var24_17.a;
                        }
                        var20_13 = var7_9 == -2;
                        var23_16.b(var20_13);
                        var20_13 = var8_10 == -2;
                        var23_16.c(var20_13);
                        var7_9 = var21_14.getMeasuredWidth();
                        var8_10 = var21_14.getMeasuredHeight();
                        var23_16.h(var7_9);
                        var23_16.i(var8_10);
                        if (var5_7 != 0) {
                            var23_16.l(var7_9);
                        }
                        if (var6_8 != 0) {
                            var23_16.m(var8_10);
                        }
                        if (var22_15.X && (var5_7 = var21_14.getBaseline()) != -1) {
                            var23_16.n(var5_7);
                        }
                        if (var22_15.V && var22_15.W) {
                            var23_16.i().a(var7_9);
                            var23_16.j().a(var8_10);
                        }
                    } else {
                        var23_16.i().e();
                        var23_16.j().e();
                    }
                }
            }
            ++var4_6;
        } while (true);
        this.b.P();
        var11_18 = 0;
        while (var11_18 < var10_5) {
            block27 : {
                block34 : {
                    block32 : {
                        block33 : {
                            block31 : {
                                block29 : {
                                    block30 : {
                                        block28 : {
                                            var21_14 = this.getChildAt(var11_18);
                                            if (var21_14.getVisibility() == 8) break block27;
                                            var22_15 = (a)var21_14.getLayoutParams();
                                            var23_16 = var22_15.am;
                                            if (var22_15.Y || var22_15.Z) break block27;
                                            var23_16.e(var21_14.getVisibility());
                                            var8_10 = var22_15.width;
                                            var9_11 = var22_15.height;
                                            if (var8_10 != 0 && var9_11 != 0) break block27;
                                            var24_17 = var23_16.a(e.c.b).a();
                                            var25_23 = var23_16.a(e.c.d).a();
                                            var5_7 = var23_16.a(e.c.b).g() != null && var23_16.a(e.c.d).g() != null ? 1 : 0;
                                            var26_24 = var23_16.a(e.c.c).a();
                                            var27_25 = var23_16.a(e.c.e).a();
                                            var14_21 = var23_16.a(e.c.c).g() != null && var23_16.a(e.c.e).g() != null;
                                            if (var8_10 != 0 || var9_11 != 0 || var5_7 == 0 || !var14_21) break block28;
                                            var16_12 = 1L;
                                            break block27;
                                        }
                                        var7_9 = this.b.G() != f.a.b ? 1 : 0;
                                        var4_6 = this.b.H() != f.a.b ? 1 : 0;
                                        if (var7_9 == 0) {
                                            var23_16.i().e();
                                        }
                                        if (var4_6 == 0) {
                                            var23_16.j().e();
                                        }
                                        if (var8_10 != 0) break block29;
                                        if (var7_9 == 0 || !var23_16.e() || var5_7 == 0 || !var24_17.g() || !var25_23.g()) break block30;
                                        var8_10 = (int)(var25_23.d() - var24_17.d());
                                        var23_16.i().a(var8_10);
                                        var6_8 = ConstraintLayout.getChildMeasureSpec((int)var1_1, (int)var15_4, (int)var8_10);
                                        ** GOTO lbl89
                                    }
                                    var6_8 = ConstraintLayout.getChildMeasureSpec((int)var1_1, (int)var15_4, (int)-2);
                                    var12_19 = 0;
                                    var5_7 = 1;
                                    var13_20 = var8_10;
                                    break block31;
                                }
                                if (var8_10 == -1) {
                                    var6_8 = ConstraintLayout.getChildMeasureSpec((int)var1_1, (int)var15_4, (int)-1);
lbl89: // 2 sources:
                                    var5_7 = 0;
                                    var12_19 = var7_9;
                                    var13_20 = var8_10;
                                } else {
                                    var5_7 = var8_10 == -2 ? 1 : 0;
                                    var6_8 = ConstraintLayout.getChildMeasureSpec((int)var1_1, (int)var15_4, (int)var8_10);
                                    var13_20 = var8_10;
                                    var12_19 = var7_9;
                                }
                            }
                            if (var9_11 != 0) break block32;
                            if (var4_6 == 0 || !var23_16.f() || !var14_21 || !var26_24.g() || !var27_25.g()) break block33;
                            var9_11 = (int)(var27_25.d() - var26_24.d());
                            var23_16.j().a(var9_11);
                            var8_10 = ConstraintLayout.getChildMeasureSpec((int)var2_2, (int)var3_3, (int)var9_11);
                            ** GOTO lbl113
                        }
                        var8_10 = ConstraintLayout.getChildMeasureSpec((int)var2_2, (int)var3_3, (int)-2);
                        var4_6 = 0;
                        var7_9 = 1;
                        break block34;
                    }
                    var8_10 = var3_3;
                    if (var9_11 == -1) {
                        var8_10 = ConstraintLayout.getChildMeasureSpec((int)var2_2, (int)var8_10, (int)-1);
lbl113: // 2 sources:
                        var7_9 = 0;
                    } else {
                        var7_9 = var9_11 == -2 ? 1 : 0;
                        var8_10 = ConstraintLayout.getChildMeasureSpec((int)var2_2, (int)var8_10, (int)var9_11);
                    }
                }
                var21_14.measure(var6_8, var8_10);
                if (this.w != null) {
                    var24_17 = this.w;
                    ++var24_17.a;
                }
                var18_22 = 1L;
                var20_13 = var13_20 == -2;
                var23_16.b(var20_13);
                var20_13 = var9_11 == -2;
                var23_16.c(var20_13);
                var6_8 = var21_14.getMeasuredWidth();
                var8_10 = var21_14.getMeasuredHeight();
                var23_16.h(var6_8);
                var23_16.i(var8_10);
                if (var5_7 != 0) {
                    var23_16.l(var6_8);
                }
                if (var7_9 != 0) {
                    var23_16.m(var8_10);
                }
                if (var12_19 != 0) {
                    var23_16.i().a(var6_8);
                } else {
                    var23_16.i().c();
                }
                if (var4_6 != 0) {
                    var23_16.j().a(var8_10);
                } else {
                    var23_16.j().c();
                }
                if (var22_15.X) {
                    var4_6 = var21_14.getBaseline();
                    var16_12 = var18_22;
                    if (var4_6 != -1) {
                        var23_16.n(var4_6);
                        var16_12 = var18_22;
                    }
                } else {
                    var16_12 = var18_22;
                }
            }
            ++var11_18;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b(AttributeSet attributeSet) {
        this.b.a((Object)this);
        this.a.put(this.getId(), (Object)this);
        this.q = null;
        if (attributeSet == null) ** GOTO lbl39
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, j.b.ConstraintLayout_Layout);
        n2 = attributeSet.getIndexCount();
        n3 = 0;
        do {
            block22 : {
                block21 : {
                    if (n3 < n2) {
                        n4 = attributeSet.getIndex(n3);
                        if (n4 == j.b.ConstraintLayout_Layout_android_minWidth) {
                            this.k = attributeSet.getDimensionPixelOffset(n4, this.k);
                        } else if (n4 == j.b.ConstraintLayout_Layout_android_minHeight) {
                            this.l = attributeSet.getDimensionPixelOffset(n4, this.l);
                        } else if (n4 == j.b.ConstraintLayout_Layout_android_maxWidth) {
                            this.m = attributeSet.getDimensionPixelOffset(n4, this.m);
                        } else if (n4 == j.b.ConstraintLayout_Layout_android_maxHeight) {
                            this.n = attributeSet.getDimensionPixelOffset(n4, this.n);
                        } else if (n4 == j.b.ConstraintLayout_Layout_layout_optimizationLevel) {
                            this.p = attributeSet.getInt(n4, this.p);
                        } else if (n4 == j.b.ConstraintLayout_Layout_layoutDescription) {
                            if ((n4 = attributeSet.getResourceId(n4, 0)) != 0) {
                                this.a(n4);
                            }
                        } else if (n4 == j.b.ConstraintLayout_Layout_constraintSet) {
                            n4 = attributeSet.getResourceId(n4, 0);
                            this.q = new e();
                            this.q.b(this.getContext(), n4);
                            break block21;
                        }
                    } else {
                        attributeSet.recycle();
lbl39: // 2 sources:
                        this.b.a(this.p);
                        return;
                        catch (Resources.NotFoundException notFoundException) {}
                        this.c = null;
                    }
                    break block22;
                    catch (Resources.NotFoundException notFoundException) {}
                    this.q = null;
                }
                this.r = n4;
            }
            ++n3;
        } while (true);
    }

    private void c() {
        int n2;
        Object object;
        boolean bl2 = this.isInEditMode();
        int n3 = this.getChildCount();
        boolean bl3 = false;
        for (n2 = 0; n2 < n3; ++n2) {
            object = this.a(this.getChildAt(n2));
            if (object == null) continue;
            ((androidx.constraintlayout.b.a.f)object).g();
        }
        if (this.r != -1) {
            for (n2 = 0; n2 < n3; ++n2) {
                object = this.getChildAt(n2);
                if (object.getId() != this.r || !(object instanceof f)) continue;
                this.q = ((f)((Object)object)).getConstraintSet();
            }
        }
        if (this.q != null) {
            this.q.c(this);
        }
        this.b.U();
        int n4 = this.i.size();
        if (n4 > 0) {
            for (n2 = 0; n2 < n4; ++n2) {
                this.i.get(n2).a(this);
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            object = this.getChildAt(n2);
            if (!(object instanceof i)) continue;
            ((i)((Object)object)).a(this);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            boolean bl4;
            block57 : {
                androidx.constraintlayout.b.a.f f2;
                a a2;
                block73 : {
                    block74 : {
                        block71 : {
                            block72 : {
                                block61 : {
                                    Object object2;
                                    float f3;
                                    block69 : {
                                        e.c c2;
                                        block70 : {
                                            block68 : {
                                                block66 : {
                                                    block67 : {
                                                        block65 : {
                                                            block63 : {
                                                                int n5;
                                                                block64 : {
                                                                    int n6;
                                                                    block62 : {
                                                                        int n7;
                                                                        int n8;
                                                                        int n9;
                                                                        block60 : {
                                                                            block59 : {
                                                                                block58 : {
                                                                                    block56 : {
                                                                                        object = this.getChildAt(i2);
                                                                                        f2 = this.a((View)object);
                                                                                        if (f2 != null) break block56;
                                                                                        bl4 = bl3;
                                                                                        break block57;
                                                                                    }
                                                                                    a2 = (a)object.getLayoutParams();
                                                                                    a2.a();
                                                                                    if (a2.an) {
                                                                                        a2.an = bl3;
                                                                                    }
                                                                                    f2.e(object.getVisibility());
                                                                                    if (a2.aa) {
                                                                                        f2.e(8);
                                                                                    }
                                                                                    f2.a(object);
                                                                                    this.b.b(f2);
                                                                                    if (!a2.W || !a2.V) {
                                                                                        this.j.add(f2);
                                                                                    }
                                                                                    if (!a2.Y) break block58;
                                                                                    object = (androidx.constraintlayout.b.a.i)f2;
                                                                                    n2 = a2.aj;
                                                                                    n4 = a2.ak;
                                                                                    f3 = a2.al;
                                                                                    if (Build.VERSION.SDK_INT < 17) {
                                                                                        n2 = a2.a;
                                                                                        n4 = a2.b;
                                                                                        f3 = a2.c;
                                                                                    }
                                                                                    if (f3 != -1.0f) {
                                                                                        ((androidx.constraintlayout.b.a.i)object).e(f3);
                                                                                        bl4 = bl3;
                                                                                    } else if (n2 != -1) {
                                                                                        ((androidx.constraintlayout.b.a.i)object).q(n2);
                                                                                        bl4 = bl3;
                                                                                    } else {
                                                                                        bl4 = bl3;
                                                                                        if (n4 != -1) {
                                                                                            ((androidx.constraintlayout.b.a.i)object).r(n4);
                                                                                            bl4 = bl3;
                                                                                        }
                                                                                    }
                                                                                    break block57;
                                                                                }
                                                                                if (a2.d != -1 || a2.e != -1 || a2.f != -1 || a2.g != -1 || a2.q != -1 || a2.p != -1 || a2.r != -1 || a2.s != -1 || a2.h != -1 || a2.i != -1 || a2.j != -1 || a2.k != -1 || a2.l != -1 || a2.Q != -1 || a2.R != -1 || a2.m != -1 || a2.width == -1) break block59;
                                                                                bl4 = bl3;
                                                                                if (a2.height != -1) break block57;
                                                                            }
                                                                            n7 = a2.ac;
                                                                            n8 = a2.ad;
                                                                            n4 = a2.ae;
                                                                            n2 = a2.af;
                                                                            n9 = a2.ag;
                                                                            n5 = a2.ah;
                                                                            f3 = a2.ai;
                                                                            if (Build.VERSION.SDK_INT < 17) {
                                                                                n5 = a2.d;
                                                                                n8 = a2.e;
                                                                                n7 = a2.f;
                                                                                int n10 = a2.g;
                                                                                n9 = a2.t;
                                                                                n6 = a2.v;
                                                                                f3 = a2.z;
                                                                                n4 = n5;
                                                                                n2 = n8;
                                                                                if (n5 == -1) {
                                                                                    n4 = n5;
                                                                                    n2 = n8;
                                                                                    if (n8 == -1) {
                                                                                        if (a2.q != -1) {
                                                                                            n4 = a2.q;
                                                                                            n2 = n8;
                                                                                        } else {
                                                                                            n4 = n5;
                                                                                            n2 = n8;
                                                                                            if (a2.p != -1) {
                                                                                                n2 = a2.p;
                                                                                                n4 = n5;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                n5 = n4;
                                                                                n8 = n2;
                                                                                n4 = n7;
                                                                                n2 = n10;
                                                                                if (n7 == -1) {
                                                                                    n4 = n7;
                                                                                    n2 = n10;
                                                                                    if (n10 == -1) {
                                                                                        if (a2.r != -1) {
                                                                                            n4 = a2.r;
                                                                                            n2 = n10;
                                                                                        } else {
                                                                                            n4 = n7;
                                                                                            n2 = n10;
                                                                                            if (a2.s != -1) {
                                                                                                n2 = a2.s;
                                                                                                n4 = n7;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                n7 = n5;
                                                                                n5 = n6;
                                                                            }
                                                                            if (a2.m == -1) break block60;
                                                                            object = this.b(a2.m);
                                                                            if (object != null) {
                                                                                f2.a((androidx.constraintlayout.b.a.f)object, a2.o, a2.n);
                                                                            }
                                                                            break block61;
                                                                        }
                                                                        if (n7 != -1) {
                                                                            object = this.b(n7);
                                                                            if (object != null) {
                                                                                f2.a(e.c.b, (androidx.constraintlayout.b.a.f)object, e.c.b, a2.leftMargin, n9);
                                                                            }
                                                                            n6 = n2;
                                                                        } else {
                                                                            n6 = n2;
                                                                            if (n8 != -1) {
                                                                                object = this.b(n8);
                                                                                n6 = n2;
                                                                                if (object != null) {
                                                                                    f2.a(e.c.b, (androidx.constraintlayout.b.a.f)object, e.c.d, a2.leftMargin, n9);
                                                                                    n6 = n2;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (n4 == -1) break block62;
                                                                        object2 = this.b(n4);
                                                                        if (object2 == null) break block63;
                                                                        object = e.c.d;
                                                                        c2 = e.c.b;
                                                                        break block64;
                                                                    }
                                                                    if (n6 == -1 || (object2 = this.b(n6)) == null) break block63;
                                                                    object = e.c.d;
                                                                    c2 = e.c.d;
                                                                }
                                                                f2.a((e.c)((Object)object), (androidx.constraintlayout.b.a.f)object2, c2, a2.rightMargin, n5);
                                                            }
                                                            if (a2.h == -1) break block65;
                                                            object2 = this.b(a2.h);
                                                            if (object2 == null) break block66;
                                                            object = e.c.c;
                                                            c2 = e.c.c;
                                                            break block67;
                                                        }
                                                        if (a2.i == -1 || (object2 = this.b(a2.i)) == null) break block66;
                                                        object = e.c.c;
                                                        c2 = e.c.e;
                                                    }
                                                    f2.a((e.c)((Object)object), (androidx.constraintlayout.b.a.f)object2, c2, a2.topMargin, a2.u);
                                                }
                                                if (a2.j == -1) break block68;
                                                object2 = this.b(a2.j);
                                                if (object2 == null) break block69;
                                                object = e.c.e;
                                                c2 = e.c.c;
                                                break block70;
                                            }
                                            if (a2.k == -1 || (object2 = this.b(a2.k)) == null) break block69;
                                            object = e.c.e;
                                            c2 = e.c.e;
                                        }
                                        f2.a((e.c)((Object)object), (androidx.constraintlayout.b.a.f)object2, c2, a2.bottomMargin, a2.w);
                                    }
                                    if (a2.l != -1) {
                                        object2 = (View)this.a.get(a2.l);
                                        object = this.b(a2.l);
                                        if (object != null && object2 != null && object2.getLayoutParams() instanceof a) {
                                            object2 = (a)object2.getLayoutParams();
                                            a2.X = true;
                                            ((a)object2).X = true;
                                            f2.a(e.c.f).a(((androidx.constraintlayout.b.a.f)object).a(e.c.f), 0, -1, e.b.b, 0, true);
                                            f2.a(e.c.c).i();
                                            f2.a(e.c.e).i();
                                        }
                                    }
                                    if (f3 >= 0.0f && f3 != 0.5f) {
                                        f2.a(f3);
                                    }
                                    if (a2.A >= 0.0f && a2.A != 0.5f) {
                                        f2.b(a2.A);
                                    }
                                }
                                if (bl2 && (a2.Q != -1 || a2.R != -1)) {
                                    f2.a(a2.Q, a2.R);
                                }
                                if (a2.V) break block71;
                                if (a2.width != -1) break block72;
                                f2.a(f.a.d);
                                f2.a((e.c)e.c.b).d = a2.leftMargin;
                                f2.a((e.c)e.c.d).d = a2.rightMargin;
                                break block73;
                            }
                            f2.a(f.a.c);
                            n2 = 0;
                            break block74;
                        }
                        f2.a(f.a.a);
                        n2 = a2.width;
                    }
                    f2.h(n2);
                }
                if (!a2.W) {
                    if (a2.height == -1) {
                        f2.b(f.a.d);
                        f2.a((e.c)e.c.c).d = a2.topMargin;
                        f2.a((e.c)e.c.e).d = a2.bottomMargin;
                    } else {
                        f2.b(f.a.c);
                        f2.i(0);
                    }
                } else {
                    f2.b(f.a.a);
                    f2.i(a2.height);
                }
                bl4 = false;
                if (a2.B != null) {
                    f2.a(a2.B);
                }
                f2.c(a2.E);
                f2.d(a2.F);
                f2.o(a2.G);
                f2.p(a2.H);
                f2.a(a2.I, a2.K, a2.M, a2.O);
                f2.b(a2.J, a2.L, a2.N, a2.P);
            }
            bl3 = bl4;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(int n2, int n3) {
        f.a a2;
        f.a a3;
        block7 : {
            block4 : {
                block6 : {
                    block5 : {
                        int n4;
                        int n5;
                        int n6;
                        block3 : {
                            block0 : {
                                block2 : {
                                    block1 : {
                                        int n7 = View.MeasureSpec.getMode((int)n2);
                                        n2 = View.MeasureSpec.getSize((int)n2);
                                        n5 = View.MeasureSpec.getMode((int)n3);
                                        n3 = View.MeasureSpec.getSize((int)n3);
                                        n4 = this.getPaddingTop();
                                        n6 = this.getPaddingBottom();
                                        int n8 = this.getPaddingLeft();
                                        int n9 = this.getPaddingRight();
                                        a2 = f.a.a;
                                        a3 = f.a.a;
                                        this.getLayoutParams();
                                        if (n7 == Integer.MIN_VALUE) break block0;
                                        if (n7 == 0) break block1;
                                        if (n7 != 1073741824) break block2;
                                        n2 = Math.min(this.m, n2) - (n8 + n9);
                                        break block3;
                                    }
                                    a2 = f.a.b;
                                }
                                n2 = 0;
                                break block3;
                            }
                            a2 = f.a.b;
                        }
                        if (n5 == Integer.MIN_VALUE) break block4;
                        if (n5 == 0) break block5;
                        if (n5 != 1073741824) break block6;
                        n3 = Math.min(this.n, n3) - (n4 + n6);
                        break block7;
                    }
                    a3 = f.a.b;
                }
                n3 = 0;
                break block7;
            }
            a3 = f.a.b;
        }
        this.b.j(0);
        this.b.k(0);
        this.b.a(a2);
        this.b.h(n2);
        this.b.b(a3);
        this.b.i(n3);
        this.b.j(this.k - this.getPaddingLeft() - this.getPaddingRight());
        this.b.k(this.l - this.getPaddingTop() - this.getPaddingBottom());
    }

    private void d() {
        int n2;
        int n3 = this.getChildCount();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            View view = this.getChildAt(n2);
            if (!(view instanceof i)) continue;
            ((i)view).b(this);
        }
        n3 = this.i.size();
        if (n3 > 0) {
            for (n2 = n4; n2 < n3; ++n2) {
                this.i.get(n2).c(this);
            }
        }
    }

    public final androidx.constraintlayout.b.a.f a(View view) {
        if (view == this) {
            return this.b;
        }
        if (view == null) {
            return null;
        }
        return ((a)view.getLayoutParams()).am;
    }

    protected a a() {
        return new a(-2, -2);
    }

    public a a(AttributeSet attributeSet) {
        return new a(this.getContext(), attributeSet);
    }

    public Object a(int n2, Object object) {
        if (n2 == 0 && object instanceof String) {
            object = (String)object;
            if (this.s != null && this.s.containsKey(object)) {
                return this.s.get(object);
            }
        }
        return null;
    }

    protected void a(int n2) {
        this.c = new d(this.getContext(), this, n2);
    }

    public void a(int n2, int n3, int n4) {
        if (this.c != null) {
            this.c.a(n2, n3, n4);
        }
    }

    protected void a(String object) {
        if (this.w != null) {
            object = this.w;
            ++((androidx.constraintlayout.b.f)object).c;
        }
        this.b.N();
    }

    public void addView(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            this.onViewAdded(view);
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.isInEditMode()) {
            int n2 = this.getChildCount();
            float f2 = this.getWidth();
            float f3 = this.getHeight();
            for (int i2 = 0; i2 < n2; ++i2) {
                Paint paint = this.getChildAt(i2);
                if (paint.getVisibility() == 8 || (paint = paint.getTag()) == null || !(paint instanceof String) || ((String[])(paint = ((String)paint).split(","))).length != 4) continue;
                int n3 = Integer.parseInt(paint[0]);
                int n4 = Integer.parseInt(paint[1]);
                int n5 = Integer.parseInt(paint[2]);
                int n6 = Integer.parseInt(paint[3]);
                n3 = (int)((float)n3 / 1080.0f * f2);
                n4 = (int)((float)n4 / 1920.0f * f3);
                n5 = (int)((float)n5 / 1080.0f * f2);
                n6 = (int)((float)n6 / 1920.0f * f3);
                paint = new Paint();
                paint.setColor(-65536);
                float f4 = n3;
                float f5 = n4;
                float f6 = n3 + n5;
                canvas.drawLine(f4, f5, f6, f5, paint);
                float f7 = n4 + n6;
                canvas.drawLine(f6, f5, f6, f7, paint);
                canvas.drawLine(f6, f7, f4, f7, paint);
                canvas.drawLine(f4, f7, f4, f5, paint);
                paint.setColor(-16711936);
                canvas.drawLine(f4, f5, f6, f7, paint);
                canvas.drawLine(f4, f7, f6, f5, paint);
            }
        }
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getMaxHeight() {
        return this.n;
    }

    public int getMaxWidth() {
        return this.m;
    }

    public int getMinHeight() {
        return this.l;
    }

    public int getMinWidth() {
        return this.k;
    }

    public int getOptimizationLevel() {
        return this.b.b();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        n4 = this.getChildCount();
        bl2 = this.isInEditMode();
        n3 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            View view = this.getChildAt(n2);
            a a2 = (a)view.getLayoutParams();
            androidx.constraintlayout.b.a.f f2 = a2.am;
            if (view.getVisibility() == 8 && !a2.Y && !a2.Z && !a2.ab && !bl2 || a2.aa) continue;
            n5 = f2.t();
            int n6 = f2.u();
            int n7 = f2.p() + n5;
            int n8 = f2.r() + n6;
            view.layout(n5, n6, n7, n8);
            if (!(view instanceof i) || (view = ((i)view).getContent()) == null) continue;
            view.setVisibility(0);
            view.layout(n5, n6, n7, n8);
        }
        n4 = this.i.size();
        if (n4 > 0) {
            for (n2 = n3; n2 < n4; ++n2) {
                this.i.get(n2).b(this);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onMeasure(int n2, int n3) {
        Object object;
        int n4;
        boolean bl2;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        block55 : {
            block57 : {
                block56 : {
                    System.currentTimeMillis();
                    n4 = View.MeasureSpec.getMode((int)n2);
                    n10 = View.MeasureSpec.getSize((int)n2);
                    n12 = View.MeasureSpec.getMode((int)n3);
                    n7 = View.MeasureSpec.getSize((int)n3);
                    n11 = this.getPaddingLeft();
                    n6 = this.getPaddingTop();
                    this.b.f(n11);
                    this.b.g(n6);
                    this.b.c(this.m);
                    this.b.d(this.n);
                    if (Build.VERSION.SDK_INT >= 17) {
                        object = this.b;
                        boolean bl3 = this.getLayoutDirection() == 1;
                        ((androidx.constraintlayout.b.a.g)object).a(bl3);
                    }
                    this.c(n2, n3);
                    n9 = this.b.p();
                    n5 = this.b.r();
                    if (this.o) {
                        this.o = false;
                        this.b();
                        n8 = 1;
                    } else {
                        n8 = 0;
                    }
                    bl2 = (this.p & 8) == 8;
                    if (bl2) {
                        this.b.O();
                        this.b.e(n9, n5);
                        this.b(n2, n3);
                    } else {
                        this.a(n2, n3);
                    }
                    this.d();
                    if (this.getChildCount() > 0 && n8 != 0) {
                        androidx.constraintlayout.b.a.a.a(this.b);
                    }
                    if (this.b.ap) {
                        if (this.b.aq && n4 == Integer.MIN_VALUE) {
                            if (this.b.as < n10) {
                                this.b.h(this.b.as);
                            }
                            this.b.a(f.a.a);
                        }
                        if (this.b.ar && n12 == Integer.MIN_VALUE) {
                            if (this.b.at < n7) {
                                this.b.i(this.b.at);
                            }
                            this.b.b(f.a.a);
                        }
                    }
                    if (!this.b.au) break block55;
                    if (n4 != 1073741824 || n12 != 1073741824) break block56;
                    if (this.t != n10) {
                        androidx.constraintlayout.b.a.a.a(this.b.ao, 0, n10);
                    }
                    if (this.u == n7) break block55;
                    break block57;
                }
                if (!this.b.aq || !this.b.ar) break block55;
                if (this.b.as > n10) {
                    androidx.constraintlayout.b.a.a.a(this.b.ao, 0, n10);
                }
                if (this.b.at <= n7) break block55;
            }
            androidx.constraintlayout.b.a.a.a(this.b.ao, 1, n7);
        }
        if (this.getChildCount() > 0) {
            this.a("First pass");
        }
        int n13 = this.j.size();
        int n14 = n6 + this.getPaddingBottom();
        int n15 = n11 + this.getPaddingRight();
        if (n13 <= 0) {
            n8 = 0;
        } else {
            View view;
            n12 = this.b.G() == f.a.b ? 1 : 0;
            n7 = this.b.H() == f.a.b ? 1 : 0;
            n6 = Math.max(this.b.p(), this.k);
            n11 = Math.max(this.b.r(), this.l);
            n8 = 0;
            n4 = 0;
            for (int i2 = 0; i2 < n13; ++i2) {
                int n16;
                object = this.j.get(i2);
                view = (View)((androidx.constraintlayout.b.a.f)object).C();
                if (view == null) {
                    n16 = n11;
                } else {
                    a a2 = (a)view.getLayoutParams();
                    if (a2.Z && !a2.ab || a2.Y) {
                        n16 = n11;
                    } else {
                        n16 = view.getVisibility();
                        n10 = n8;
                        if (n16 == 8) {
                            n16 = n11;
                            n8 = n10;
                        } else if (bl2 && ((androidx.constraintlayout.b.a.f)object).i().g() && ((androidx.constraintlayout.b.a.f)object).j().g()) {
                            n8 = n10;
                            n16 = n11;
                        } else {
                            n8 = a2.width == -2 && a2.V ? ConstraintLayout.getChildMeasureSpec((int)n2, (int)n15, (int)a2.width) : View.MeasureSpec.makeMeasureSpec((int)((androidx.constraintlayout.b.a.f)object).p(), (int)1073741824);
                            n16 = a2.height == -2 && a2.W ? ConstraintLayout.getChildMeasureSpec((int)n3, (int)n14, (int)a2.height) : View.MeasureSpec.makeMeasureSpec((int)((androidx.constraintlayout.b.a.f)object).r(), (int)1073741824);
                            view.measure(n8, n16);
                            if (this.w != null) {
                                androidx.constraintlayout.b.f f2 = this.w;
                                ++f2.b;
                            }
                            int n17 = view.getMeasuredWidth();
                            n16 = view.getMeasuredHeight();
                            n8 = n6;
                            if (n17 != ((androidx.constraintlayout.b.a.f)object).p()) {
                                ((androidx.constraintlayout.b.a.f)object).h(n17);
                                if (bl2) {
                                    ((androidx.constraintlayout.b.a.f)object).i().a(n17);
                                }
                                n8 = n6;
                                if (n12 != 0) {
                                    n8 = n6;
                                    if (((androidx.constraintlayout.b.a.f)object).x() > n6) {
                                        n8 = Math.max(n6, ((androidx.constraintlayout.b.a.f)object).x() + ((androidx.constraintlayout.b.a.f)object).a(e.c.d).e());
                                    }
                                }
                                n10 = 1;
                            }
                            n6 = n11;
                            if (n16 != ((androidx.constraintlayout.b.a.f)object).r()) {
                                ((androidx.constraintlayout.b.a.f)object).i(n16);
                                if (bl2) {
                                    ((androidx.constraintlayout.b.a.f)object).j().a(n16);
                                }
                                n6 = n11;
                                if (n7 != 0) {
                                    n6 = n11;
                                    if (((androidx.constraintlayout.b.a.f)object).y() > n11) {
                                        n6 = Math.max(n11, ((androidx.constraintlayout.b.a.f)object).y() + ((androidx.constraintlayout.b.a.f)object).a(e.c.e).e());
                                    }
                                }
                                n10 = 1;
                            }
                            n11 = n10;
                            if (a2.X) {
                                n16 = view.getBaseline();
                                n11 = n10;
                                if (n16 != -1) {
                                    n11 = n10;
                                    if (n16 != ((androidx.constraintlayout.b.a.f)object).B()) {
                                        ((androidx.constraintlayout.b.a.f)object).n(n16);
                                        n11 = 1;
                                    }
                                }
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                n4 = ConstraintLayout.combineMeasuredStates((int)n4, (int)view.getMeasuredState());
                                n16 = n6;
                                n6 = n8;
                                n8 = n11;
                            } else {
                                n16 = n6;
                                n6 = n8;
                                n8 = n11;
                            }
                        }
                    }
                }
                n11 = n16;
            }
            if (n8 != 0) {
                this.b.h(n9);
                this.b.i(n5);
                if (bl2) {
                    this.b.P();
                }
                this.a("2nd pass");
                if (this.b.p() < n6) {
                    this.b.h(n6);
                    n8 = 1;
                } else {
                    n8 = 0;
                }
                if (this.b.r() < n11) {
                    this.b.i(n11);
                    n8 = 1;
                }
                if (n8 != 0) {
                    this.a("3rd pass");
                }
            }
            n11 = 0;
            do {
                n8 = n4;
                if (n11 >= n13) break;
                object = this.j.get(n11);
                view = (View)((androidx.constraintlayout.b.a.f)object).C();
                if (view != null && (view.getMeasuredWidth() != ((androidx.constraintlayout.b.a.f)object).p() || view.getMeasuredHeight() != ((androidx.constraintlayout.b.a.f)object).r()) && ((androidx.constraintlayout.b.a.f)object).l() != 8) {
                    view.measure(View.MeasureSpec.makeMeasureSpec((int)((androidx.constraintlayout.b.a.f)object).p(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)((androidx.constraintlayout.b.a.f)object).r(), (int)1073741824));
                    if (this.w != null) {
                        object = this.w;
                        ++((androidx.constraintlayout.b.f)object).b;
                    }
                }
                ++n11;
            } while (true);
        }
        n11 = this.b.p() + n15;
        n6 = this.b.r() + n14;
        if (Build.VERSION.SDK_INT < 11) {
            this.setMeasuredDimension(n11, n6);
            this.t = n11;
            this.u = n6;
            return;
        }
        n2 = ConstraintLayout.resolveSizeAndState((int)n11, (int)n2, (int)n8);
        n8 = ConstraintLayout.resolveSizeAndState((int)n6, (int)n3, (int)(n8 << 16));
        n3 = Math.min(this.m, n2 & 16777215);
        n8 = Math.min(this.n, n8 & 16777215);
        n2 = n3;
        if (this.b.K()) {
            n2 = n3 | 16777216;
        }
        n3 = n8;
        if (this.b.L()) {
            n3 = n8 | 16777216;
        }
        this.setMeasuredDimension(n2, n3);
        this.t = n2;
        this.u = n3;
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        Object object = this.a(view);
        if (view instanceof h && !(object instanceof androidx.constraintlayout.b.a.i)) {
            object = (a)view.getLayoutParams();
            ((a)object).am = new androidx.constraintlayout.b.a.i();
            ((a)object).Y = true;
            ((androidx.constraintlayout.b.a.i)((a)object).am).a(((a)object).S);
        }
        if (view instanceof c) {
            object = (c)view;
            ((c)((Object)object)).b();
            ((a)view.getLayoutParams()).Z = true;
            if (!this.i.contains(object)) {
                this.i.add((c)((Object)object));
            }
        }
        this.a.put(view.getId(), (Object)view);
        this.o = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.a.remove(view.getId());
        androidx.constraintlayout.b.a.f f2 = this.a(view);
        this.b.c(f2);
        this.i.remove((Object)view);
        this.j.remove(f2);
        this.o = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            this.onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.o = true;
        this.t = -1;
        this.u = -1;
        this.d = -1;
        this.e = -1;
        this.f = 0;
        this.g = 0;
    }

    public void setConstraintSet(e e2) {
        this.q = e2;
    }

    public void setId(int n2) {
        this.a.remove(this.getId());
        super.setId(n2);
        this.a.put(this.getId(), (Object)this);
    }

    public void setMaxHeight(int n2) {
        if (n2 == this.n) {
            return;
        }
        this.n = n2;
        this.requestLayout();
    }

    public void setMaxWidth(int n2) {
        if (n2 == this.m) {
            return;
        }
        this.m = n2;
        this.requestLayout();
    }

    public void setMinHeight(int n2) {
        if (n2 == this.l) {
            return;
        }
        this.l = n2;
        this.requestLayout();
    }

    public void setMinWidth(int n2) {
        if (n2 == this.k) {
            return;
        }
        this.k = n2;
        this.requestLayout();
    }

    public void setOnConstraintsChanged(g g2) {
        this.v = g2;
        if (this.c != null) {
            this.c.a(g2);
        }
    }

    public void setOptimizationLevel(int n2) {
        this.b.a(n2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static class androidx.constraintlayout.widget.ConstraintLayout$a
    extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;
        public int a;
        boolean aa;
        boolean ab;
        int ac;
        int ad;
        int ae;
        int af;
        int ag;
        int ah;
        float ai;
        int aj;
        int ak;
        float al;
        androidx.constraintlayout.b.a.f am;
        public boolean an;
        public int b;
        public float c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        public androidx.constraintlayout.widget.ConstraintLayout$a(int n2, int n3) {
            super(n2, n3);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = false;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = -1;
            this.ai = 0.5f;
            this.am = new androidx.constraintlayout.b.a.f();
            this.an = false;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public androidx.constraintlayout.widget.ConstraintLayout$a(Context var1_1, AttributeSet var2_7) {
            block74 : {
                block73 : {
                    super((Context)var1_1, var2_7);
                    this.a = -1;
                    this.b = -1;
                    this.c = -1.0f;
                    this.d = -1;
                    this.e = -1;
                    this.f = -1;
                    this.g = -1;
                    this.h = -1;
                    this.i = -1;
                    this.j = -1;
                    this.k = -1;
                    this.l = -1;
                    this.m = -1;
                    this.n = 0;
                    this.o = 0.0f;
                    this.p = -1;
                    this.q = -1;
                    this.r = -1;
                    this.s = -1;
                    this.t = -1;
                    this.u = -1;
                    this.v = -1;
                    this.w = -1;
                    this.x = -1;
                    this.y = -1;
                    this.z = 0.5f;
                    this.A = 0.5f;
                    this.B = null;
                    this.C = 0.0f;
                    this.D = 1;
                    this.E = -1.0f;
                    this.F = -1.0f;
                    this.G = 0;
                    this.H = 0;
                    this.I = 0;
                    this.J = 0;
                    this.K = 0;
                    this.L = 0;
                    this.M = 0;
                    this.N = 0;
                    this.O = 1.0f;
                    this.P = 1.0f;
                    this.Q = -1;
                    this.R = -1;
                    this.S = -1;
                    this.T = false;
                    this.U = false;
                    this.V = true;
                    this.W = true;
                    this.X = false;
                    this.Y = false;
                    this.Z = false;
                    this.aa = false;
                    this.ab = false;
                    this.ac = -1;
                    this.ad = -1;
                    this.ae = -1;
                    this.af = -1;
                    this.ag = -1;
                    this.ah = -1;
                    this.ai = 0.5f;
                    this.am = new androidx.constraintlayout.b.a.f();
                    this.an = false;
                    var2_7 = var1_1.obtainStyledAttributes(var2_7, j.b.ConstraintLayout_Layout);
                    var7_8 = var2_7.getIndexCount();
                    var5_9 = 0;
lbl68: // 2 sources:
                    while (var5_9 < var7_8) {
                        var6_12 = var2_7.getIndex(var5_9);
                        switch (a.a.get(var6_12)) {
                            default: {
                                ** break;
                            }
                            case 50: {
                                this.R = var2_7.getDimensionPixelOffset(var6_12, this.R);
                                ** break;
                            }
                            case 49: {
                                this.Q = var2_7.getDimensionPixelOffset(var6_12, this.Q);
                                ** break;
                            }
                            case 48: {
                                this.H = var2_7.getInt(var6_12, 0);
                                ** break;
                            }
                            case 47: {
                                this.G = var2_7.getInt(var6_12, 0);
                                ** break;
                            }
                            case 46: {
                                this.F = var2_7.getFloat(var6_12, this.F);
                                ** break;
                            }
                            case 45: {
                                this.E = var2_7.getFloat(var6_12, this.E);
                                ** break;
                            }
                            case 44: {
                                this.B = var2_7.getString(var6_12);
                                this.C = Float.NaN;
                                this.D = -1;
                                if (this.B == null) ** break;
                                var8_13 = this.B.length();
                                var6_12 = this.B.indexOf(44);
                                if (var6_12 > 0 && var6_12 < var8_13 - 1) {
                                    var1_1 = this.B.substring(0, var6_12);
                                    if (var1_1.equalsIgnoreCase("W")) {
                                        this.D = 0;
                                    } else if (var1_1.equalsIgnoreCase("H")) {
                                        this.D = 1;
                                    }
                                    ++var6_12;
                                } else {
                                    var6_12 = 0;
                                }
                                var9_14 = this.B.indexOf(58);
                                if (var9_14 < 0 || var9_14 >= var8_13 - 1) ** GOTO lbl125
                                var1_1 = this.B.substring(var6_12, var9_14);
                                var10_15 = this.B.substring(var9_14 + 1);
                                if (var1_1.length() <= 0 || var10_15.length() <= 0) break block73;
                                var3_10 = Float.parseFloat((String)var1_1);
                                var4_11 = Float.parseFloat(var10_15);
                                if (!(var3_10 > 0.0f) || !(var4_11 > 0.0f)) break block73;
                                if (this.D == 1) {
                                    var3_10 = Math.abs(var4_11 / var3_10);
lbl120: // 3 sources:
                                    do {
                                        this.C = var3_10;
                                        ** break;
                                        break;
                                    } while (true);
                                }
                                var3_10 = Math.abs(var3_10 / var4_11);
                                ** GOTO lbl120
lbl125: // 1 sources:
                                var1_1 = this.B.substring(var6_12);
                                if (var1_1.length() <= 0) ** break;
                                var3_10 = Float.parseFloat((String)var1_1);
                                ** continue;
                            }
                            case 38: {
                                this.P = Math.max(0.0f, var2_7.getFloat(var6_12, this.P));
                                ** break;
                            }
                            case 37: {
                                this.N = var2_7.getDimensionPixelSize(var6_12, this.N);
                                ** break;
                            }
lbl137: // 1 sources:
                            do {
                                if (var2_7.getInt(var6_12, this.N) != -2) ** break;
                                this.N = -2;
                                ** break;
                                break;
                            } while (true);
                            case 36: {
                                this.L = var2_7.getDimensionPixelSize(var6_12, this.L);
                                ** break;
                            }
lbl145: // 1 sources:
                            do {
                                if (var2_7.getInt(var6_12, this.L) != -2) ** break;
                                this.L = -2;
                                ** break;
                                break;
                            } while (true);
                            case 35: {
                                this.O = Math.max(0.0f, var2_7.getFloat(var6_12, this.O));
                                ** break;
                            }
                            case 34: {
                                this.M = var2_7.getDimensionPixelSize(var6_12, this.M);
                                ** break;
                            }
lbl156: // 1 sources:
                            do {
                                if (var2_7.getInt(var6_12, this.M) != -2) ** break;
                                this.M = -2;
                                ** break;
                                break;
                            } while (true);
                            case 33: {
                                this.K = var2_7.getDimensionPixelSize(var6_12, this.K);
                                ** break;
                            }
lbl164: // 1 sources:
                            do {
                                if (var2_7.getInt(var6_12, this.K) != -2) ** break;
                                this.K = -2;
                                ** break;
                                break;
                            } while (true);
                            case 32: {
                                this.J = var2_7.getInt(var6_12, 0);
                                if (this.J != 1) ** break;
                                var1_1 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                                ** GOTO lbl177
                            }
                            case 31: {
                                this.I = var2_7.getInt(var6_12, 0);
                                if (this.I != 1) ** break;
                                var1_1 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
lbl177: // 2 sources:
                                Log.e((String)"ConstraintLayout", (String)var1_1);
                                ** break;
                            }
                            case 30: {
                                this.A = var2_7.getFloat(var6_12, this.A);
                                ** break;
                            }
                            case 29: {
                                this.z = var2_7.getFloat(var6_12, this.z);
                                ** break;
                            }
                            case 28: {
                                this.U = var2_7.getBoolean(var6_12, this.U);
                                ** break;
                            }
                            case 27: {
                                this.T = var2_7.getBoolean(var6_12, this.T);
                                ** break;
                            }
                            case 26: {
                                this.y = var2_7.getDimensionPixelSize(var6_12, this.y);
                                ** break;
                            }
                            case 25: {
                                this.x = var2_7.getDimensionPixelSize(var6_12, this.x);
                                ** break;
                            }
                            case 24: {
                                this.w = var2_7.getDimensionPixelSize(var6_12, this.w);
                                ** break;
                            }
                            case 23: {
                                this.v = var2_7.getDimensionPixelSize(var6_12, this.v);
                                ** break;
                            }
                            case 22: {
                                this.u = var2_7.getDimensionPixelSize(var6_12, this.u);
                                ** break;
                            }
                            case 21: {
                                this.t = var2_7.getDimensionPixelSize(var6_12, this.t);
                                ** break;
                            }
                            case 20: {
                                this.s = var2_7.getResourceId(var6_12, this.s);
                                if (this.s != -1) ** break;
                                this.s = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 19: {
                                this.r = var2_7.getResourceId(var6_12, this.r);
                                if (this.r != -1) ** break;
                                this.r = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 18: {
                                this.q = var2_7.getResourceId(var6_12, this.q);
                                if (this.q != -1) ** break;
                                this.q = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 17: {
                                this.p = var2_7.getResourceId(var6_12, this.p);
                                if (this.p != -1) ** break;
                                this.p = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 16: {
                                this.l = var2_7.getResourceId(var6_12, this.l);
                                if (this.l != -1) ** break;
                                this.l = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 15: {
                                this.k = var2_7.getResourceId(var6_12, this.k);
                                if (this.k != -1) ** break;
                                this.k = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 14: {
                                this.j = var2_7.getResourceId(var6_12, this.j);
                                if (this.j != -1) ** break;
                                this.j = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 13: {
                                this.i = var2_7.getResourceId(var6_12, this.i);
                                if (this.i != -1) ** break;
                                this.i = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 12: {
                                this.h = var2_7.getResourceId(var6_12, this.h);
                                if (this.h != -1) ** break;
                                this.h = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 11: {
                                this.g = var2_7.getResourceId(var6_12, this.g);
                                if (this.g != -1) ** break;
                                this.g = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 10: {
                                this.f = var2_7.getResourceId(var6_12, this.f);
                                if (this.f != -1) ** break;
                                this.f = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 9: {
                                this.e = var2_7.getResourceId(var6_12, this.e);
                                if (this.e != -1) ** break;
                                this.e = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 8: {
                                this.d = var2_7.getResourceId(var6_12, this.d);
                                if (this.d != -1) ** break;
                                this.d = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 7: {
                                this.c = var2_7.getFloat(var6_12, this.c);
                                ** break;
                            }
                            case 6: {
                                this.b = var2_7.getDimensionPixelOffset(var6_12, this.b);
                                ** break;
                            }
                            case 5: {
                                this.a = var2_7.getDimensionPixelOffset(var6_12, this.a);
                                ** break;
                            }
                            case 4: {
                                this.o = var2_7.getFloat(var6_12, this.o) % 360.0f;
                                if (!(this.o < 0.0f)) ** break;
                                this.o = (360.0f - this.o) % 360.0f;
                                ** break;
                            }
                            case 3: {
                                this.n = var2_7.getDimensionPixelSize(var6_12, this.n);
                                ** break;
                            }
                            case 2: {
                                this.m = var2_7.getResourceId(var6_12, this.m);
                                if (this.m != -1) ** break;
                                this.m = var2_7.getInt(var6_12, -1);
                                ** break;
                            }
                            case 1: {
                                this.S = var2_7.getInt(var6_12, this.S);
                            }
                            case 0: 
                            case 39: 
                            case 40: 
                            case 41: 
                            case 42: {
                                break block73;
                            }
                        }
                    }
                    break block74;
                }
lbl302: // 2 sources:
                do {
                    ++var5_9;
                    ** GOTO lbl68
                    break;
                } while (true);
            }
            var2_7.recycle();
            this.a();
            return;
            catch (NumberFormatException var1_6) {
                ** continue;
            }
            catch (Exception var1_2) {
                ** continue;
            }
            catch (Exception var1_3) {
                ** continue;
            }
            catch (Exception var1_4) {
                ** continue;
            }
            catch (Exception var1_5) {
                ** continue;
            }
        }

        public androidx.constraintlayout.widget.ConstraintLayout$a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = false;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = -1;
            this.ai = 0.5f;
            this.am = new androidx.constraintlayout.b.a.f();
            this.an = false;
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (this.width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (this.height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.c != -1.0f || this.a != -1 || this.b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.am instanceof androidx.constraintlayout.b.a.i)) {
                    this.am = new androidx.constraintlayout.b.a.i();
                }
                ((androidx.constraintlayout.b.a.i)this.am).a(this.S);
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        @TargetApi(value=17)
        public void resolveLayoutDirection(int n2) {
            block33 : {
                int n3;
                block38 : {
                    block37 : {
                        block35 : {
                            int n4;
                            block36 : {
                                block34 : {
                                    block29 : {
                                        block25 : {
                                            block32 : {
                                                block31 : {
                                                    block30 : {
                                                        block28 : {
                                                            block27 : {
                                                                int n5;
                                                                block26 : {
                                                                    n3 = this.leftMargin;
                                                                    n4 = this.rightMargin;
                                                                    super.resolveLayoutDirection(n2);
                                                                    this.ae = -1;
                                                                    this.af = -1;
                                                                    this.ac = -1;
                                                                    this.ad = -1;
                                                                    this.ag = -1;
                                                                    this.ah = -1;
                                                                    this.ag = this.t;
                                                                    this.ah = this.v;
                                                                    this.ai = this.z;
                                                                    this.aj = this.a;
                                                                    this.ak = this.b;
                                                                    this.al = this.c;
                                                                    n2 = this.getLayoutDirection();
                                                                    n5 = 0;
                                                                    n2 = 1 == n2 ? 1 : 0;
                                                                    if (n2 == 0) break block25;
                                                                    if (this.p == -1) break block26;
                                                                    this.ae = this.p;
                                                                    break block27;
                                                                }
                                                                n2 = n5;
                                                                if (this.q == -1) break block28;
                                                                this.af = this.q;
                                                            }
                                                            n2 = 1;
                                                        }
                                                        if (this.r != -1) {
                                                            this.ad = this.r;
                                                            n2 = 1;
                                                        }
                                                        if (this.s != -1) {
                                                            this.ac = this.s;
                                                            n2 = 1;
                                                        }
                                                        if (this.x != -1) {
                                                            this.ah = this.x;
                                                        }
                                                        if (this.y != -1) {
                                                            this.ag = this.y;
                                                        }
                                                        if (n2 != 0) {
                                                            this.ai = 1.0f - this.z;
                                                        }
                                                        if (!this.Y || this.S != 1) break block29;
                                                        if (this.c == -1.0f) break block30;
                                                        this.al = 1.0f - this.c;
                                                        this.aj = -1;
                                                        this.ak = -1;
                                                        break block29;
                                                    }
                                                    if (this.a == -1) break block31;
                                                    this.ak = this.a;
                                                    this.aj = -1;
                                                    break block32;
                                                }
                                                if (this.b == -1) break block29;
                                                this.aj = this.b;
                                                this.ak = -1;
                                            }
                                            this.al = -1.0f;
                                            break block29;
                                        }
                                        if (this.p != -1) {
                                            this.ad = this.p;
                                        }
                                        if (this.q != -1) {
                                            this.ac = this.q;
                                        }
                                        if (this.r != -1) {
                                            this.ae = this.r;
                                        }
                                        if (this.s != -1) {
                                            this.af = this.s;
                                        }
                                        if (this.x != -1) {
                                            this.ag = this.x;
                                        }
                                        if (this.y != -1) {
                                            this.ah = this.y;
                                        }
                                    }
                                    if (this.r != -1 || this.s != -1 || this.q != -1 || this.p != -1) break block33;
                                    if (this.f == -1) break block34;
                                    this.ae = this.f;
                                    if (this.rightMargin > 0 || n4 <= 0) break block35;
                                    break block36;
                                }
                                if (this.g == -1) break block35;
                                this.af = this.g;
                                if (this.rightMargin > 0 || n4 <= 0) break block35;
                            }
                            this.rightMargin = n4;
                        }
                        if (this.d == -1) break block37;
                        this.ac = this.d;
                        if (this.leftMargin > 0 || n3 <= 0) break block33;
                        break block38;
                    }
                    if (this.e == -1) break block33;
                    this.ad = this.e;
                    if (this.leftMargin > 0 || n3 <= 0) break block33;
                }
                this.leftMargin = n3;
                return;
            }
        }

        private static class a {
            public static final SparseIntArray a = new SparseIntArray();

            static {
                a.append(j.b.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintCircle, 2);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                a.append(j.b.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                a.append(j.b.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                a.append(j.b.ConstraintLayout_Layout_android_orientation, 1);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                a.append(j.b.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                a.append(j.b.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                a.append(j.b.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                a.append(j.b.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                a.append(j.b.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                a.append(j.b.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                a.append(j.b.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                a.append(j.b.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                a.append(j.b.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

    }

}

