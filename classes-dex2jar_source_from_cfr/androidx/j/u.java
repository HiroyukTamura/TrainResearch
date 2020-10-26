/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.j.aa;
import androidx.j.w;

class u
extends aa
implements w {
    u(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static u a(ViewGroup viewGroup) {
        return (u)aa.d((View)viewGroup);
    }

    @Override
    public void a(View view) {
        this.a.a(view);
    }

    @Override
    public void b(View view) {
        this.a.b(view);
    }
}

