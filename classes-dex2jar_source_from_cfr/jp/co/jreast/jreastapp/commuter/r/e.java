/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.r;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/util/FontUtil;", "", "()V", "setTabsFont", "", "tabs", "Lcom/google/android/material/tabs/TabLayout;", "isBold", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e {
    public final void a(TabLayout tabLayout, boolean bl2) {
        j.b((Object)tabLayout, "tabs");
        String string2 = bl2 ? "fonts/TT-UDShinGoPro-Bold.ttf" : "fonts/TT-UDShinGoPro-Medium.ttf";
        View view = tabLayout.getChildAt(0);
        if (view != null) {
            view = (ViewGroup)view;
            int n2 = view.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view2 = view.getChildAt(i2);
                if (view2 != null) {
                    view2 = (ViewGroup)view2;
                    int n3 = view2.getChildCount();
                    for (int i3 = 0; i3 < n3; ++i3) {
                        View view3 = view2.getChildAt(i3);
                        if (!(view3 instanceof TextView)) continue;
                        CalligraphyUtils.applyFontToTextView(tabLayout.getContext(), (TextView)view3, string2);
                    }
                    continue;
                }
                throw new t("null cannot be cast to non-null type android.view.ViewGroup");
            }
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
}

