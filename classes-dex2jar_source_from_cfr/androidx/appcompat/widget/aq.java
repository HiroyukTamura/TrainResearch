/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.ar;

public class aq {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        ar.a(view, charSequence);
    }
}

