/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.PointerIcon
 */
package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class q {
    private Object a;

    private q(Object object) {
        this.a = object;
    }

    public static q a(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new q((Object)PointerIcon.getSystemIcon((Context)context, (int)n2));
        }
        return new q(null);
    }

    public Object a() {
        return this.a;
    }
}

