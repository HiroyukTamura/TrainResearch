/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.widget.ab;
import androidx.core.h.d;
import androidx.core.h.t;

public class AlertDialogLayout
extends ab {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, int n2, int n3, int n4, int n5) {
        view.layout(n2, n3, n4 + n2, n5 + n3);
    }

    private static int c(View view) {
        int n2 = t.l(view);
        if (n2 > 0) {
            return n2;
        }
        if (view instanceof ViewGroup && (view = (ViewGroup)view).getChildCount() == 1) {
            return AlertDialogLayout.c(view.getChildAt(0));
        }
        return 0;
    }

    private boolean c(int n2, int n3) {
        View view;
        int n4;
        View view2;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9 = this.getChildCount();
        View view3 = view = (view2 = null);
        View view4 = view;
        for (n5 = 0; n5 < n9; ++n5) {
            view = this.getChildAt(n5);
            if (view.getVisibility() == 8) continue;
            n8 = view.getId();
            if (n8 == a.f.topPanel) {
                view2 = view;
                continue;
            }
            if (n8 == a.f.buttonPanel) {
                view4 = view;
                continue;
            }
            if (n8 != a.f.contentPanel && n8 != a.f.customPanel) {
                return false;
            }
            if (view3 != null) {
                return false;
            }
            view3 = view;
        }
        int n10 = View.MeasureSpec.getMode((int)n3);
        int n11 = View.MeasureSpec.getSize((int)n3);
        int n12 = View.MeasureSpec.getMode((int)n2);
        int n13 = this.getPaddingTop() + this.getPaddingBottom();
        if (view2 != null) {
            view2.measure(n2, 0);
            n13 += view2.getMeasuredHeight();
            n8 = View.combineMeasuredStates((int)0, (int)view2.getMeasuredState());
        } else {
            n8 = 0;
        }
        if (view4 != null) {
            view4.measure(n2, 0);
            n5 = AlertDialogLayout.c(view4);
            n4 = view4.getMeasuredHeight() - n5;
            n13 += n5;
            n8 = View.combineMeasuredStates((int)n8, (int)view4.getMeasuredState());
        } else {
            n5 = 0;
            n4 = 0;
        }
        if (view3 != null) {
            n7 = n10 == 0 ? 0 : View.MeasureSpec.makeMeasureSpec((int)Math.max(0, n11 - n13), (int)n10);
            view3.measure(n2, n7);
            n6 = view3.getMeasuredHeight();
            n13 += n6;
            n8 = View.combineMeasuredStates((int)n8, (int)view3.getMeasuredState());
        } else {
            n6 = 0;
        }
        int n14 = n11 - n13;
        n11 = n8;
        int n15 = n14;
        n7 = n13;
        if (view4 != null) {
            n4 = Math.min(n14, n4);
            n11 = n14;
            n7 = n5;
            if (n4 > 0) {
                n11 = n14 - n4;
                n7 = n5 + n4;
            }
            view4.measure(n2, View.MeasureSpec.makeMeasureSpec((int)n7, (int)1073741824));
            n7 = n13 - n5 + view4.getMeasuredHeight();
            n5 = View.combineMeasuredStates((int)n8, (int)view4.getMeasuredState());
            n15 = n11;
            n11 = n5;
        }
        n8 = n11;
        n5 = n7;
        if (view3 != null) {
            n8 = n11;
            n5 = n7;
            if (n15 > 0) {
                view3.measure(n2, View.MeasureSpec.makeMeasureSpec((int)(n6 + n15), (int)n10));
                n5 = n7 - n6 + view3.getMeasuredHeight();
                n8 = View.combineMeasuredStates((int)n11, (int)view3.getMeasuredState());
            }
        }
        n7 = 0;
        for (n13 = 0; n13 < n9; ++n13) {
            view = this.getChildAt(n13);
            n11 = n7;
            if (view.getVisibility() != 8) {
                n11 = Math.max(n7, view.getMeasuredWidth());
            }
            n7 = n11;
        }
        this.setMeasuredDimension(View.resolveSizeAndState((int)(n7 + (this.getPaddingLeft() + this.getPaddingRight())), (int)n2, (int)n8), View.resolveSizeAndState((int)n5, (int)n3, (int)0));
        if (n12 != 1073741824) {
            this.d(n9, n3);
        }
        return true;
    }

    private void d(int n2, int n3) {
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824);
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            ab.a a2 = (ab.a)view.getLayoutParams();
            if (a2.width != -1) continue;
            int n5 = a2.height;
            a2.height = view.getMeasuredHeight();
            this.measureChildWithMargins(view, n4, 0, n3, 0);
            a2.height = n5;
        }
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6 = this.getPaddingLeft();
        int n7 = n4 - n2;
        int n8 = this.getPaddingRight();
        int n9 = this.getPaddingRight();
        n2 = this.getMeasuredHeight();
        int n10 = this.getChildCount();
        int n11 = this.getGravity();
        n4 = n11 & 112;
        if (n4 != 16) {
            n2 = n4 != 80 ? this.getPaddingTop() : this.getPaddingTop() + n5 - n3 - n2;
        } else {
            n4 = this.getPaddingTop();
            n2 = (n5 - n3 - n2) / 2 + n4;
        }
        Drawable drawable2 = this.getDividerDrawable();
        n3 = drawable2 == null ? 0 : drawable2.getIntrinsicHeight();
        for (n4 = 0; n4 < n10; ++n4) {
            block5 : {
                int n12;
                int n13;
                ab.a a2;
                int n14;
                block8 : {
                    block9 : {
                        block6 : {
                            block7 : {
                                drawable2 = this.getChildAt(n4);
                                n5 = n2;
                                if (drawable2 == null) break block5;
                                n5 = n2;
                                if (drawable2.getVisibility() == 8) break block5;
                                n14 = drawable2.getMeasuredWidth();
                                n13 = drawable2.getMeasuredHeight();
                                a2 = (ab.a)drawable2.getLayoutParams();
                                n5 = n12 = a2.h;
                                if (n12 < 0) {
                                    n5 = n11 & 8388615;
                                }
                                if ((n5 = d.a(n5, t.f((View)this)) & 7) == 1) break block6;
                                if (n5 == 5) break block7;
                                n5 = a2.leftMargin + n6;
                                break block8;
                            }
                            n5 = n7 - n8 - n14;
                            break block9;
                        }
                        n5 = (n7 - n6 - n9 - n14) / 2 + n6 + a2.leftMargin;
                    }
                    n5 -= a2.rightMargin;
                }
                n12 = n2;
                if (this.c(n4)) {
                    n12 = n2 + n3;
                }
                n2 = n12 + a2.topMargin;
                this.a((View)drawable2, n5, n2, n14, n13);
                n5 = n2 + (n13 + a2.bottomMargin);
            }
            n2 = n5;
        }
    }

    @Override
    protected void onMeasure(int n2, int n3) {
        if (!this.c(n2, n3)) {
            super.onMeasure(n2, n3);
        }
    }
}

