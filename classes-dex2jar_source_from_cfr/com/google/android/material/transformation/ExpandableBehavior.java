/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.f.b;
import java.util.List;

public abstract class ExpandableBehavior
extends CoordinatorLayout.b<View> {
    private int a = 0;

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(boolean bl2) {
        boolean bl3;
        block4 : {
            block6 : {
                block5 : {
                    bl3 = false;
                    boolean bl4 = false;
                    if (!bl2) break block4;
                    if (this.a == 0) break block5;
                    bl2 = bl4;
                    if (this.a != 2) break block6;
                }
                bl2 = true;
            }
            return bl2;
        }
        bl2 = bl3;
        if (this.a == 1) {
            bl2 = true;
        }
        return bl2;
    }

    protected abstract boolean a(View var1, View var2, boolean var3, boolean var4);

    @Override
    public boolean a(CoordinatorLayout object, final View view, final int n2) {
        if (!t.y(view) && (object = this.e((CoordinatorLayout)object, view)) != null && this.a(object.a())) {
            n2 = object.a() ? 1 : 2;
            n2 = this.a = n2;
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener((b)object){
                final /* synthetic */ b c;
                {
                    this.c = b2;
                }

                public boolean onPreDraw() {
                    view.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
                    if (ExpandableBehavior.this.a == n2) {
                        ExpandableBehavior.this.a((View)this.c, view, this.c.a(), false);
                    }
                    return false;
                }
            });
        }
        return false;
    }

    @Override
    public abstract boolean a(CoordinatorLayout var1, View var2, View var3);

    @Override
    public boolean b(CoordinatorLayout object, View view, View view2) {
        object = (b)view2;
        if (this.a(object.a())) {
            int n2 = object.a() ? 1 : 2;
            this.a = n2;
            return this.a((View)object, view, object.a(), true);
        }
        return false;
    }

    protected b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> list = coordinatorLayout.c(view);
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view2 = list.get(i2);
            if (!this.a(coordinatorLayout, view, view2)) continue;
            return (b)view2;
        }
        return null;
    }

}

