/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.j;

import android.view.View;
import android.view.ViewGroup;
import androidx.j.j;

public class l {
    private ViewGroup a;
    private Runnable b;

    static l a(View view) {
        return (l)view.getTag(j.a.transition_current_scene);
    }

    static void a(View view, l l2) {
        view.setTag(j.a.transition_current_scene, (Object)l2);
    }

    public void a() {
        if (l.a((View)this.a) == this && this.b != null) {
            this.b.run();
        }
    }
}

