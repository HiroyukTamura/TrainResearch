/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewOverlay
 */
package androidx.j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.j.ac;

class ab
implements ac {
    private final ViewOverlay a;

    ab(View view) {
        this.a = view.getOverlay();
    }

    @Override
    public void a(Drawable drawable2) {
        this.a.add(drawable2);
    }

    @Override
    public void b(Drawable drawable2) {
        this.a.remove(drawable2);
    }
}

