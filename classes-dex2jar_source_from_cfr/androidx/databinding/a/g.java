/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.databinding.a;

import android.view.View;

public class g {
    public static void a(View view, View.OnClickListener onClickListener, boolean bl2) {
        view.setOnClickListener(onClickListener);
        view.setClickable(bl2);
    }
}

