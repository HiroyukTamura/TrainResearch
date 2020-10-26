/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.core.h;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.a;
import androidx.core.h.t;

public final class v {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bl2 = (Boolean)viewGroup.getTag(a.b.tag_transition_group);
        return bl2 != null && bl2.booleanValue() || viewGroup.getBackground() != null || t.o((View)viewGroup) != null;
        {
        }
    }
}

