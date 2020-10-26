/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 */
package androidx.j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.j.w;

class v
implements w {
    private final ViewGroupOverlay a;

    v(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override
    public void a(Drawable drawable2) {
        this.a.add(drawable2);
    }

    @Override
    public void a(View view) {
        this.a.add(view);
    }

    @Override
    public void b(Drawable drawable2) {
        this.a.remove(drawable2);
    }

    @Override
    public void b(View view) {
        this.a.remove(view);
    }
}

