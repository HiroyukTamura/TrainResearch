/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.a;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.au;
import androidx.core.h.d;
import androidx.core.h.t;

public class ab
extends ViewGroup {
    private boolean a = true;
    private int b = -1;
    private int c = 0;
    private int d;
    private int e = 8388659;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ab(Context object, AttributeSet attributeSet, int n2) {
        boolean bl2;
        super((Context)object, attributeSet, n2);
        object = ao.a((Context)object, attributeSet, a.j.LinearLayoutCompat, n2, 0);
        n2 = ((ao)object).a(a.j.LinearLayoutCompat_android_orientation, -1);
        if (n2 >= 0) {
            this.setOrientation(n2);
        }
        if ((n2 = ((ao)object).a(a.j.LinearLayoutCompat_android_gravity, -1)) >= 0) {
            this.setGravity(n2);
        }
        if (!(bl2 = ((ao)object).a(a.j.LinearLayoutCompat_android_baselineAligned, true))) {
            this.setBaselineAligned(bl2);
        }
        this.g = ((ao)object).a(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = ((ao)object).a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = ((ao)object).a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(((ao)object).a(a.j.LinearLayoutCompat_divider));
        this.n = ((ao)object).a(a.j.LinearLayoutCompat_showDividers, 0);
        this.o = ((ao)object).e(a.j.LinearLayoutCompat_dividerPadding, 0);
        ((ao)object).a();
    }

    private void a(View view, int n2, int n3, int n4, int n5) {
        view.layout(n2, n3, n4 + n2, n5 + n3);
    }

    private void c(int n2, int n3) {
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824);
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.b(i2);
            if (view.getVisibility() == 8) continue;
            a a2 = (a)view.getLayoutParams();
            if (a2.width != -1) continue;
            int n5 = a2.height;
            a2.height = view.getMeasuredHeight();
            this.measureChildWithMargins(view, n4, 0, n3, 0);
            a2.height = n5;
        }
    }

    private void d(int n2, int n3) {
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)1073741824);
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.b(i2);
            if (view.getVisibility() == 8) continue;
            a a2 = (a)view.getLayoutParams();
            if (a2.height != -1) continue;
            int n5 = a2.width;
            a2.width = view.getMeasuredWidth();
            this.measureChildWithMargins(view, n3, 0, n4, 0);
            a2.width = n5;
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int n2) {
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        boolean bl2;
        int n9;
        int n10;
        block37 : {
            int n11;
            a a2;
            View view;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            float f2;
            block36 : {
                block34 : {
                    block35 : {
                        block33 : {
                            this.f = 0;
                            n17 = this.getVirtualChildCount();
                            n6 = View.MeasureSpec.getMode((int)n2);
                            n16 = View.MeasureSpec.getMode((int)n3);
                            int n18 = this.b;
                            boolean bl3 = this.h;
                            f2 = 0.0f;
                            n5 = 0;
                            n4 = 0;
                            n12 = 0;
                            n9 = 0;
                            n14 = 0;
                            n13 = 0;
                            n8 = 1;
                            bl2 = false;
                            for (n15 = 0; n15 < n17; ++n15) {
                                view = this.b(n15);
                                if (view == null) {
                                    this.f += this.d(n15);
                                    continue;
                                }
                                if (view.getVisibility() == 8) {
                                    n15 += this.a(view, n15);
                                    continue;
                                }
                                if (this.c(n15)) {
                                    this.f += this.m;
                                }
                                a2 = (a)view.getLayoutParams();
                                f2 += a2.g;
                                if (n16 == 1073741824 && a2.height == 0 && a2.g > 0.0f) {
                                    n13 = this.f;
                                    this.f = Math.max(n13, a2.topMargin + n13 + a2.bottomMargin);
                                    n13 = 1;
                                } else {
                                    if (a2.height == 0 && a2.g > 0.0f) {
                                        a2.height = -2;
                                        n10 = 0;
                                    } else {
                                        n10 = Integer.MIN_VALUE;
                                    }
                                    n7 = f2 == 0.0f ? this.f : 0;
                                    this.a(view, n15, n2, 0, n3, n7);
                                    if (n10 != Integer.MIN_VALUE) {
                                        a2.height = n10;
                                    }
                                    n10 = view.getMeasuredHeight();
                                    n7 = this.f;
                                    this.f = Math.max(n7, n7 + n10 + a2.topMargin + a2.bottomMargin + this.b(view));
                                    if (bl3) {
                                        n12 = Math.max(n10, n12);
                                    }
                                }
                                n11 = n15;
                                if (n18 >= 0 && n18 == n11 + 1) {
                                    this.c = this.f;
                                }
                                if (n11 < n18 && a2.g > 0.0f) {
                                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                                }
                                if (n6 != 1073741824 && a2.width == -1) {
                                    n15 = 1;
                                    bl2 = true;
                                } else {
                                    n15 = 0;
                                }
                                n10 = a2.leftMargin + a2.rightMargin;
                                n7 = view.getMeasuredWidth() + n10;
                                int n19 = Math.max(n4, n7);
                                int n20 = View.combineMeasuredStates((int)n5, (int)view.getMeasuredState());
                                n5 = n8 != 0 && a2.width == -1 ? 1 : 0;
                                if (a2.g > 0.0f) {
                                    if (n15 == 0) {
                                        n10 = n7;
                                    }
                                    n8 = Math.max(n9, n10);
                                    n9 = n14;
                                } else {
                                    if (n15 == 0) {
                                        n10 = n7;
                                    }
                                    n14 = Math.max(n14, n10);
                                    n8 = n9;
                                    n9 = n14;
                                }
                                n15 = this.a(view, n11);
                                n14 = n5;
                                n4 = n8;
                                n5 = n20;
                                n15 += n11;
                                n10 = n19;
                                n8 = n14;
                                n14 = n9;
                                n9 = n4;
                                n4 = n10;
                            }
                            if (this.f > 0 && this.c(n17)) {
                                this.f += this.m;
                            }
                            n10 = n17;
                            if (bl3 && ((n15 = n16) == Integer.MIN_VALUE || n15 == 0)) {
                                this.f = 0;
                                for (n15 = 0; n15 < n10; ++n15) {
                                    view = this.b(n15);
                                    if (view == null) {
                                        n17 = this.f + this.d(n15);
                                    } else {
                                        if (view.getVisibility() == 8) {
                                            n15 += this.a(view, n15);
                                            continue;
                                        }
                                        a2 = (a)view.getLayoutParams();
                                        n17 = this.f;
                                        n17 = Math.max(n17, n17 + n12 + a2.topMargin + a2.bottomMargin + this.b(view));
                                    }
                                    this.f = n17;
                                }
                            }
                            n15 = n16;
                            this.f += this.getPaddingTop() + this.getPaddingBottom();
                            n7 = View.resolveSizeAndState((int)Math.max(this.f, this.getSuggestedMinimumHeight()), (int)n3, (int)0);
                            n17 = (16777215 & n7) - this.f;
                            if (n13 != 0 || n17 != 0 && f2 > 0.0f) break block33;
                            n16 = Math.max(n14, n9);
                            if (!bl3 || n15 == 1073741824) break block34;
                            break block35;
                        }
                        if (this.g > 0.0f) {
                            f2 = this.g;
                        }
                        this.f = 0;
                        n9 = 0;
                        n16 = n14;
                        n14 = n17;
                        n12 = n15;
                        break block36;
                    }
                    for (n9 = 0; n9 < n10; ++n9) {
                        view = this.b(n9);
                        if (view == null || view.getVisibility() == 8 || !(((a)view.getLayoutParams()).g > 0.0f)) continue;
                        view.measure(View.MeasureSpec.makeMeasureSpec((int)view.getMeasuredWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)n12, (int)1073741824));
                    }
                }
                n9 = n5;
                n5 = n16;
                break block37;
            }
            for (n15 = n9; n15 < n10; ++n15) {
                block39 : {
                    block44 : {
                        block40 : {
                            float f3;
                            block43 : {
                                block42 : {
                                    block41 : {
                                        block38 : {
                                            view = this.b(n15);
                                            if (view.getVisibility() != 8) break block38;
                                            n9 = n14;
                                            break block39;
                                        }
                                        a2 = (a)view.getLayoutParams();
                                        f3 = a2.g;
                                        if (!(f3 > 0.0f)) break block40;
                                        n17 = (int)((float)n14 * f3 / f2);
                                        n11 = ab.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight() + a2.leftMargin + a2.rightMargin), (int)a2.width);
                                        if (a2.height != 0 || n12 != 1073741824) break block41;
                                        if (n17 <= 0) break block42;
                                        n9 = n17;
                                        break block43;
                                    }
                                    n9 = n13 = view.getMeasuredHeight() + n17;
                                    if (n13 >= 0) break block43;
                                }
                                n9 = 0;
                            }
                            view.measure(n11, View.MeasureSpec.makeMeasureSpec((int)n9, (int)1073741824));
                            n5 = View.combineMeasuredStates((int)n5, (int)(view.getMeasuredState() & -256));
                            n9 = n14 - n17;
                            f2 -= f3;
                            break block44;
                        }
                        n9 = n14;
                    }
                    n17 = a2.leftMargin + a2.rightMargin;
                    n13 = view.getMeasuredWidth() + n17;
                    n4 = Math.max(n4, n13);
                    n14 = n6 != 1073741824 && a2.width == -1 ? 1 : 0;
                    n14 = n14 != 0 ? n17 : n13;
                    n14 = Math.max(n16, n14);
                    n16 = n8 != 0 && a2.width == -1 ? 1 : 0;
                    n8 = this.f;
                    this.f = Math.max(n8, n8 + view.getMeasuredHeight() + a2.topMargin + a2.bottomMargin + this.b(view));
                    n8 = n16;
                    n16 = n14;
                }
                n14 = n9;
            }
            this.f += this.getPaddingTop() + this.getPaddingBottom();
            n9 = n5;
            n5 = n16;
        }
        if (n8 != 0 || n6 == 1073741824) {
            n5 = n4;
        }
        this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max(n5 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), (int)n2, (int)n9), n7);
        if (bl2) {
            this.c(n10, n3);
        }
    }

    void a(int n2, int n3, int n4, int n5) {
        int n6 = this.getPaddingLeft();
        int n7 = n4 - n2;
        int n8 = this.getPaddingRight();
        int n9 = this.getPaddingRight();
        int n10 = this.getVirtualChildCount();
        n2 = this.e & 112;
        int n11 = this.e;
        if (n2 != 16) {
            n2 = n2 != 80 ? this.getPaddingTop() : this.getPaddingTop() + n5 - n3 - this.f;
        } else {
            n2 = this.getPaddingTop();
            n2 = (n5 - n3 - this.f) / 2 + n2;
        }
        n3 = 0;
        while (n3 < n10) {
            block6 : {
                int n12;
                View view;
                int n13;
                a a2;
                block9 : {
                    block10 : {
                        block7 : {
                            block8 : {
                                block5 : {
                                    view = this.b(n3);
                                    if (view != null) break block5;
                                    n4 = n2 + this.d(n3);
                                    n5 = n3;
                                    break block6;
                                }
                                n4 = n2;
                                n5 = n3;
                                if (view.getVisibility() == 8) break block6;
                                n12 = view.getMeasuredWidth();
                                n13 = view.getMeasuredHeight();
                                a2 = (a)view.getLayoutParams();
                                n4 = n5 = a2.h;
                                if (n5 < 0) {
                                    n4 = n11 & 8388615;
                                }
                                if ((n4 = d.a(n4, t.f((View)this)) & 7) == 1) break block7;
                                if (n4 == 5) break block8;
                                n4 = a2.leftMargin + n6;
                                break block9;
                            }
                            n4 = n7 - n8 - n12;
                            break block10;
                        }
                        n4 = (n7 - n6 - n9 - n12) / 2 + n6 + a2.leftMargin;
                    }
                    n4 -= a2.rightMargin;
                }
                n5 = n2;
                if (this.c(n3)) {
                    n5 = n2 + this.m;
                }
                n2 = n5 + a2.topMargin;
                this.a(view, n4, n2 + this.a(view), n12, n13);
                n4 = a2.bottomMargin;
                n12 = this.b(view);
                n5 = n3 + this.a(view, n3);
                n4 = n2 + (n13 + n4 + n12);
            }
            n3 = n5 + 1;
            n2 = n4;
        }
    }

    void a(Canvas canvas) {
        a a2;
        View view;
        int n2;
        int n3 = this.getVirtualChildCount();
        for (n2 = 0; n2 < n3; ++n2) {
            view = this.b(n2);
            if (view == null || view.getVisibility() == 8 || !this.c(n2)) continue;
            a2 = (a)view.getLayoutParams();
            this.a(canvas, view.getTop() - a2.topMargin - this.m);
        }
        if (this.c(n3)) {
            view = this.b(n3 - 1);
            if (view == null) {
                n2 = this.getHeight() - this.getPaddingBottom() - this.m;
            } else {
                a2 = (a)view.getLayoutParams();
                n2 = view.getBottom() + a2.bottomMargin;
            }
            this.a(canvas, n2);
        }
    }

    void a(Canvas canvas, int n2) {
        this.k.setBounds(this.getPaddingLeft() + this.o, n2, this.getWidth() - this.getPaddingRight() - this.o, this.m + n2);
        this.k.draw(canvas);
    }

    void a(View view, int n2, int n3, int n4, int n5, int n6) {
        this.measureChildWithMargins(view, n3, n4, n5, n6);
    }

    int b(View view) {
        return 0;
    }

    View b(int n2) {
        return this.getChildAt(n2);
    }

    public a b(AttributeSet attributeSet) {
        return new a(this.getContext(), attributeSet);
    }

    protected a b(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /*
     * Enabled aggressive block sorting
     */
    void b(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        boolean bl2;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        block56 : {
            View view;
            int n12;
            View view2;
            int n13;
            int n14;
            float f2;
            a a2;
            int[] arrn;
            int n15;
            boolean bl3;
            boolean bl4;
            int n16;
            int n17;
            block55 : {
                block53 : {
                    block54 : {
                        block52 : {
                            boolean bl5;
                            block50 : {
                                block51 : {
                                    this.f = 0;
                                    n13 = this.getVirtualChildCount();
                                    n12 = View.MeasureSpec.getMode((int)n2);
                                    n10 = View.MeasureSpec.getMode((int)n3);
                                    if (this.i == null || this.j == null) {
                                        this.i = new int[4];
                                        this.j = new int[4];
                                    }
                                    arrn = this.i;
                                    view2 = this.j;
                                    arrn[3] = -1;
                                    arrn[2] = -1;
                                    arrn[1] = -1;
                                    arrn[0] = -1;
                                    view2[3] = -1;
                                    view2[2] = -1;
                                    view2[1] = -1;
                                    view2[0] = -1;
                                    bl4 = this.a;
                                    bl5 = this.h;
                                    bl3 = n12 == 1073741824;
                                    f2 = 0.0f;
                                    n11 = 0;
                                    n5 = 0;
                                    n15 = 0;
                                    n6 = 0;
                                    n16 = 0;
                                    n4 = 0;
                                    n7 = 1;
                                    bl2 = false;
                                    for (n8 = 0; n8 < n13; ++n8) {
                                        int n18;
                                        block49 : {
                                            block48 : {
                                                block46 : {
                                                    block47 : {
                                                        view = this.b(n8);
                                                        if (view == null) {
                                                            this.f += this.d(n8);
                                                            continue;
                                                        }
                                                        if (view.getVisibility() == 8) {
                                                            n8 += this.a(view, n8);
                                                            continue;
                                                        }
                                                        if (this.c(n8)) {
                                                            this.f += this.l;
                                                        }
                                                        a2 = (a)view.getLayoutParams();
                                                        f2 += a2.g;
                                                        if (n12 != 1073741824 || a2.width != 0 || !(a2.g > 0.0f)) break block46;
                                                        if (bl3) {
                                                            n17 = this.f + (a2.leftMargin + a2.rightMargin);
                                                        } else {
                                                            n17 = this.f;
                                                            n17 = Math.max(n17, a2.leftMargin + n17 + a2.rightMargin);
                                                        }
                                                        this.f = n17;
                                                        if (!bl4) break block47;
                                                        n17 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                                                        view.measure(n17, n17);
                                                        n17 = n11;
                                                        break block48;
                                                    }
                                                    n15 = 1;
                                                    break block49;
                                                }
                                                if (a2.width == 0 && a2.g > 0.0f) {
                                                    a2.width = -2;
                                                    n17 = 0;
                                                } else {
                                                    n17 = Integer.MIN_VALUE;
                                                }
                                                n14 = f2 == 0.0f ? this.f : 0;
                                                this.a(view, n8, n2, n14, n3, 0);
                                                if (n17 != Integer.MIN_VALUE) {
                                                    a2.width = n17;
                                                }
                                                n14 = view.getMeasuredWidth();
                                                if (bl3) {
                                                    n17 = this.f + (a2.leftMargin + n14 + a2.rightMargin + this.b(view));
                                                } else {
                                                    n17 = this.f;
                                                    n17 = Math.max(n17, n17 + n14 + a2.leftMargin + a2.rightMargin + this.b(view));
                                                }
                                                this.f = n17;
                                                n17 = n11;
                                                if (bl5) {
                                                    n17 = Math.max(n14, n11);
                                                }
                                            }
                                            n11 = n17;
                                        }
                                        n9 = n8;
                                        if (n10 != 1073741824 && a2.height == -1) {
                                            n8 = 1;
                                            bl2 = true;
                                        } else {
                                            n8 = 0;
                                        }
                                        n17 = a2.topMargin + a2.bottomMargin;
                                        n14 = view.getMeasuredHeight() + n17;
                                        int n19 = View.combineMeasuredStates((int)n4, (int)view.getMeasuredState());
                                        if (bl4 && (n18 = view.getBaseline()) != -1) {
                                            n4 = a2.h < 0 ? this.e : a2.h;
                                            n4 = ((n4 & 112) >> 4 & -2) >> 1;
                                            arrn[n4] = Math.max(arrn[n4], n18);
                                            view2[n4] = (View)Math.max((int)view2[n4], n14 - n18);
                                        }
                                        n5 = Math.max(n5, n14);
                                        n7 = n7 != 0 && a2.height == -1 ? 1 : 0;
                                        if (a2.g > 0.0f) {
                                            if (n8 == 0) {
                                                n17 = n14;
                                            }
                                            n8 = Math.max(n16, n17);
                                        } else {
                                            if (n8 != 0) {
                                                n14 = n17;
                                            }
                                            n6 = Math.max(n6, n14);
                                            n8 = n16;
                                        }
                                        n16 = this.a(view, n9);
                                        n4 = n19;
                                        n17 = n16 + n9;
                                        n16 = n8;
                                        n8 = n17;
                                    }
                                    n8 = n5;
                                    if (this.f > 0 && this.c(n13)) {
                                        this.f += this.l;
                                    }
                                    if (arrn[1] != -1 || arrn[0] != -1 || arrn[2] != -1 || arrn[3] != -1) {
                                        n8 = Math.max(n8, Math.max(arrn[3], Math.max(arrn[0], Math.max(arrn[1], arrn[2]))) + Math.max(view2[3], Math.max(view2[0], Math.max(view2[1], view2[2]))));
                                    }
                                    n5 = n4;
                                    n17 = n8;
                                    if (!bl5) break block50;
                                    if (n12 == Integer.MIN_VALUE) break block51;
                                    n17 = n8;
                                    if (n12 != 0) break block50;
                                }
                                this.f = 0;
                                n4 = 0;
                                do {
                                    n17 = n8;
                                    if (n4 >= n13) break;
                                    view = this.b(n4);
                                    if (view == null) {
                                        this.f += this.d(n4);
                                    } else if (view.getVisibility() == 8) {
                                        n4 += this.a(view, n4);
                                    } else {
                                        a2 = (a)view.getLayoutParams();
                                        if (bl3) {
                                            this.f += a2.leftMargin + n11 + a2.rightMargin + this.b(view);
                                        } else {
                                            n17 = this.f;
                                            this.f = Math.max(n17, n17 + n11 + a2.leftMargin + a2.rightMargin + this.b(view));
                                        }
                                    }
                                    ++n4;
                                } while (true);
                            }
                            this.f += this.getPaddingLeft() + this.getPaddingRight();
                            n9 = View.resolveSizeAndState((int)Math.max(this.f, this.getSuggestedMinimumWidth()), (int)n2, (int)0);
                            n14 = (16777215 & n9) - this.f;
                            if (n15 != 0 || n14 != 0 && f2 > 0.0f) break block52;
                            n4 = Math.max(n6, n16);
                            if (!bl5 || n12 == 1073741824) break block53;
                            break block54;
                        }
                        if (this.g > 0.0f) {
                            f2 = this.g;
                        }
                        arrn[3] = -1;
                        arrn[2] = -1;
                        arrn[1] = -1;
                        arrn[0] = -1;
                        view2[3] = (View)-1;
                        view2[2] = (View)-1;
                        view2[1] = (View)-1;
                        view2[0] = (View)-1;
                        this.f = 0;
                        n15 = -1;
                        n11 = 0;
                        n4 = n7;
                        n8 = n13;
                        n16 = n6;
                        n7 = n5;
                        n6 = n14;
                        break block55;
                    }
                    for (n6 = 0; n6 < n13; ++n6) {
                        view2 = this.b(n6);
                        if (view2 == null || view2.getVisibility() == 8 || !(((a)view2.getLayoutParams()).g > 0.0f)) continue;
                        view2.measure(View.MeasureSpec.makeMeasureSpec((int)n11, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)view2.getMeasuredHeight(), (int)1073741824));
                    }
                }
                n8 = n13;
                n6 = n4;
                n4 = n7;
                n7 = n17;
                break block56;
            }
            for (n5 = n11; n5 < n8; ++n5) {
                block57 : {
                    float f3;
                    block60 : {
                        block59 : {
                            block58 : {
                                view = this.b(n5);
                                if (view == null || view.getVisibility() == 8) continue;
                                a2 = (a)view.getLayoutParams();
                                f3 = a2.g;
                                if (!(f3 > 0.0f)) break block57;
                                n17 = (int)((float)n6 * f3 / f2);
                                n14 = ab.getChildMeasureSpec((int)n3, (int)(this.getPaddingTop() + this.getPaddingBottom() + a2.topMargin + a2.bottomMargin), (int)a2.height);
                                if (a2.width != 0 || n12 != 1073741824) break block58;
                                if (n17 <= 0) break block59;
                                n11 = n17;
                                break block60;
                            }
                            n11 = n13 = view.getMeasuredWidth() + n17;
                            if (n13 >= 0) break block60;
                        }
                        n11 = 0;
                    }
                    view.measure(View.MeasureSpec.makeMeasureSpec((int)n11, (int)1073741824), n14);
                    n7 = View.combineMeasuredStates((int)n7, (int)(view.getMeasuredState() & -16777216));
                    f2 -= f3;
                    n6 -= n17;
                }
                if (bl3) {
                    this.f += view.getMeasuredWidth() + a2.leftMargin + a2.rightMargin + this.b(view);
                } else {
                    n11 = this.f;
                    this.f = Math.max(n11, view.getMeasuredWidth() + n11 + a2.leftMargin + a2.rightMargin + this.b(view));
                }
                n11 = n10 != 1073741824 && a2.height == -1 ? 1 : 0;
                n13 = a2.topMargin + a2.bottomMargin;
                n17 = view.getMeasuredHeight() + n13;
                n15 = Math.max(n15, n17);
                n11 = n11 != 0 ? n13 : n17;
                n16 = Math.max(n16, n11);
                n11 = n4 != 0 && a2.height == -1 ? 1 : 0;
                if (bl4 && (n13 = view.getBaseline()) != -1) {
                    n4 = a2.h < 0 ? this.e : a2.h;
                    n4 = ((n4 & 112) >> 4 & -2) >> 1;
                    arrn[n4] = Math.max(arrn[n4], n13);
                    view2[n4] = (View)Math.max((int)view2[n4], n17 - n13);
                }
                n4 = n11;
            }
            this.f += this.getPaddingLeft() + this.getPaddingRight();
            n6 = arrn[1] == -1 && arrn[0] == -1 && arrn[2] == -1 && arrn[3] == -1 ? n15 : Math.max(n15, Math.max(arrn[3], Math.max(arrn[0], Math.max(arrn[1], arrn[2]))) + Math.max((int)view2[3], Math.max((int)view2[0], Math.max((int)view2[1], (int)view2[2]))));
            n11 = n6;
            n5 = n7;
            n6 = n16;
            n7 = n11;
        }
        n11 = n7;
        if (n4 == 0) {
            n11 = n7;
            if (n10 != 1073741824) {
                n11 = n6;
            }
        }
        this.setMeasuredDimension(n9 | n5 & -16777216, View.resolveSizeAndState((int)Math.max(n11 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), (int)n3, (int)(n5 << 16)));
        if (bl2) {
            this.d(n8, n2);
        }
    }

    void b(int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        boolean bl2 = au.a((View)this);
        int n8 = this.getPaddingTop();
        int n9 = n5 - n3;
        int n10 = this.getPaddingBottom();
        int n11 = this.getPaddingBottom();
        int n12 = this.getVirtualChildCount();
        n5 = this.e;
        n3 = this.e & 112;
        boolean bl3 = this.a;
        int[] arrn = this.i;
        int[] arrn2 = this.j;
        if ((n5 = d.a(n5 & 8388615, t.f((View)this))) != 1) {
            n2 = n5 != 5 ? this.getPaddingLeft() : this.getPaddingLeft() + n4 - n2 - this.f;
        } else {
            n5 = this.getPaddingLeft();
            n2 = (n4 - n2 - this.f) / 2 + n5;
        }
        if (bl2) {
            n6 = n12 - 1;
            n7 = -1;
        } else {
            n6 = 0;
            n7 = 1;
        }
        n4 = n8;
        for (n5 = 0; n5 < n12; ++n5) {
            int n13;
            int n14 = n6 + n7 * n5;
            View view = this.b(n14);
            if (view == null) {
                n2 += this.d(n14);
                continue;
            }
            if (view.getVisibility() == 8) continue;
            int n15 = view.getMeasuredWidth();
            int n16 = view.getMeasuredHeight();
            a a2 = (a)view.getLayoutParams();
            int n17 = bl3 && a2.height != -1 ? view.getBaseline() : -1;
            int n18 = n13 = a2.h;
            if (n13 < 0) {
                n18 = n3;
            }
            if ((n18 &= 112) != 16) {
                if (n18 != 48) {
                    if (n18 != 80) {
                        n18 = n4;
                    } else {
                        n18 = n13 = n9 - n10 - n16 - a2.bottomMargin;
                        if (n17 != -1) {
                            n18 = view.getMeasuredHeight();
                            n18 = n13 - (arrn2[2] - (n18 - n17));
                        }
                    }
                } else {
                    n18 = a2.topMargin + n4;
                    if (n17 != -1) {
                        n18 += arrn[1] - n17;
                    }
                }
            } else {
                n18 = (n9 - n8 - n11 - n16) / 2 + n4 + a2.topMargin - a2.bottomMargin;
            }
            n17 = n2;
            if (this.c(n14)) {
                n17 = n2 + this.l;
            }
            n2 = a2.leftMargin + n17;
            this.a(view, n2 + this.a(view), n18, n15, n16);
            n18 = a2.rightMargin;
            n17 = this.b(view);
            n5 += this.a(view, n14);
            n2 += n15 + n18 + n17;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void b(Canvas var1_1) {
        block5 : {
            block3 : {
                block4 : {
                    var4_2 = this.getVirtualChildCount();
                    var5_3 = au.a((View)this);
                    for (var2_4 = 0; var2_4 < var4_2; ++var2_4) {
                        var6_6 = this.b(var2_4);
                        if (var6_6 == null || var6_6.getVisibility() == 8 || !this.c(var2_4)) continue;
                        var7_7 = (a)var6_6.getLayoutParams();
                        var3_5 = var5_3 != false ? var6_6.getRight() + var7_7.rightMargin : var6_6.getLeft() - var7_7.leftMargin - this.l;
                        this.b(var1_1, var3_5);
                    }
                    if (this.c(var4_2) == false) return;
                    var6_6 = this.b(var4_2 - 1);
                    if (var6_6 != null) break block3;
                    if (!var5_3) break block4;
                    var2_4 = this.getPaddingLeft();
                    break block5;
                }
                var2_4 = this.getWidth();
                var3_5 = this.getPaddingRight();
                ** GOTO lbl25
            }
            var7_7 = (a)var6_6.getLayoutParams();
            if (var5_3) {
                var2_4 = var6_6.getLeft();
                var3_5 = var7_7.leftMargin;
lbl25: // 2 sources:
                var2_4 = var2_4 - var3_5 - this.l;
            } else {
                var2_4 = var6_6.getRight() + var7_7.rightMargin;
            }
        }
        this.b(var1_1, var2_4);
    }

    void b(Canvas canvas, int n2) {
        this.k.setBounds(n2, this.getPaddingTop() + this.o, this.l + n2, this.getHeight() - this.getPaddingBottom() - this.o);
        this.k.draw(canvas);
    }

    protected boolean c(int n2) {
        boolean bl2 = false;
        boolean bl3 = false;
        if (n2 == 0) {
            if ((this.n & 1) != 0) {
                bl3 = true;
            }
            return bl3;
        }
        if (n2 == this.getChildCount()) {
            bl3 = bl2;
            if ((this.n & 4) != 0) {
                bl3 = true;
            }
            return bl3;
        }
        if ((this.n & 2) != 0) {
            --n2;
            while (n2 >= 0) {
                if (this.getChildAt(n2).getVisibility() != 8) {
                    return true;
                }
                --n2;
            }
        }
        return false;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    int d(int n2) {
        return 0;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.j();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.b(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.b(layoutParams);
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (this.getChildCount() > this.b) {
            int n2;
            View view = this.getChildAt(this.b);
            int n3 = view.getBaseline();
            if (n3 == -1) {
                if (this.b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int n4 = n2 = this.c;
            if (this.d == 1) {
                int n5 = this.e & 112;
                n4 = n2;
                if (n5 != 48) {
                    n4 = n5 != 16 ? (n5 != 80 ? n2 : this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f) : n2 + (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
                }
            }
            return n4 + ((a)view.getLayoutParams()).topMargin + n3;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    protected a j() {
        if (this.d == 0) {
            return new a(-2, -2);
        }
        if (this.d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            this.a(canvas);
            return;
        }
        this.b(canvas);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ab.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ab.class.getName());
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        if (this.d == 1) {
            this.a(n2, n3, n4, n5);
            return;
        }
        this.b(n2, n3, n4, n5);
    }

    protected void onMeasure(int n2, int n3) {
        if (this.d == 1) {
            this.a(n2, n3);
            return;
        }
        this.b(n2, n3);
    }

    public void setBaselineAligned(boolean bl2) {
        this.a = bl2;
    }

    public void setBaselineAlignedChildIndex(int n2) {
        if (n2 >= 0 && n2 < this.getChildCount()) {
            this.b = n2;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("base aligned child index out of range (0, ");
        stringBuilder.append(this.getChildCount());
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setDividerDrawable(Drawable drawable2) {
        if (drawable2 == this.k) {
            return;
        }
        this.k = drawable2;
        boolean bl2 = false;
        if (drawable2 != null) {
            this.l = drawable2.getIntrinsicWidth();
            this.m = drawable2.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        if (drawable2 == null) {
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
        this.requestLayout();
    }

    public void setDividerPadding(int n2) {
        this.o = n2;
    }

    public void setGravity(int n2) {
        if (this.e != n2) {
            int n3 = n2;
            if ((8388615 & n2) == 0) {
                n3 = n2 | 8388611;
            }
            n2 = n3;
            if ((n3 & 112) == 0) {
                n2 = n3 | 48;
            }
            this.e = n2;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int n2) {
        if ((8388615 & this.e) != (n2 &= 8388615)) {
            this.e = n2 | this.e & -8388616;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean bl2) {
        this.h = bl2;
    }

    public void setOrientation(int n2) {
        if (this.d != n2) {
            this.d = n2;
            this.requestLayout();
        }
    }

    public void setShowDividers(int n2) {
        if (n2 != this.n) {
            this.requestLayout();
        }
        this.n = n2;
    }

    public void setVerticalGravity(int n2) {
        if ((this.e & 112) != (n2 &= 112)) {
            this.e = n2 | this.e & -113;
            this.requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.g = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static class a
    extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h = -1;

        public a(int n2, int n3) {
            super(n2, n3);
            this.g = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.g = context.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = context.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            context.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

}

