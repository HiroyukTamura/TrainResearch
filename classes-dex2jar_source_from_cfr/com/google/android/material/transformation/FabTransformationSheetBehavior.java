/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
extends FabTransformationBehavior {
    private Map<View, Integer> a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, boolean bl2) {
        Object object = view.getParent();
        if (!(object instanceof CoordinatorLayout)) {
            return;
        }
        object = (CoordinatorLayout)object;
        int n2 = object.getChildCount();
        if (Build.VERSION.SDK_INT >= 16 && bl2) {
            this.a = new HashMap<View, Integer>(n2);
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            View view2 = object.getChildAt(i2);
            int n3 = view2.getLayoutParams() instanceof CoordinatorLayout.e && ((CoordinatorLayout.e)view2.getLayoutParams()).b() instanceof FabTransformationScrimBehavior ? 1 : 0;
            if (view2 == view || n3 != 0) continue;
            if (!bl2) {
                if (this.a == null || !this.a.containsKey((Object)view2)) continue;
                n3 = this.a.get((Object)view2);
            } else {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.a.put(view2, view2.getImportantForAccessibility());
                }
                n3 = 4;
            }
            t.b(view2, n3);
        }
        if (!bl2) {
            this.a = null;
        }
    }

    @Override
    protected FabTransformationBehavior.a a(Context context, boolean bl2) {
        int n2 = bl2 ? a.a.mtrl_fab_transformation_sheet_expand_spec : a.a.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.a a2 = new FabTransformationBehavior.a();
        a2.a = h.a(context, n2);
        a2.b = new j(17, 0.0f, 0.0f);
        return a2;
    }

    @Override
    protected boolean a(View view, View view2, boolean bl2, boolean bl3) {
        this.a(view2, bl2);
        return super.a(view, view2, bl2, bl3);
    }
}

