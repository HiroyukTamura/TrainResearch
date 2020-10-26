/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 */
package androidx.j;

import android.os.Build;
import android.view.ViewGroup;
import androidx.j.u;
import androidx.j.v;
import androidx.j.w;
import androidx.j.y;
import androidx.j.z;

class x {
    static w a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new v(viewGroup);
        }
        return u.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean bl2) {
        if (Build.VERSION.SDK_INT >= 18) {
            z.a(viewGroup, bl2);
            return;
        }
        y.a(viewGroup, bl2);
    }
}

