/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.WindowInsets
 */
package androidx.core.h;

import android.os.Build;
import android.view.WindowInsets;

public class ab {
    private final Object a;

    private ab(Object object) {
        this.a = object;
    }

    static ab a(Object object) {
        if (object == null) {
            return null;
        }
        return new ab(object);
    }

    static Object a(ab ab2) {
        if (ab2 == null) {
            return null;
        }
        return ab2.a;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets)this.a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public ab a(int n2, int n3, int n4, int n5) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ab((Object)((WindowInsets)this.a).replaceSystemWindowInsets(n2, n3, n4, n5));
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets)this.a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets)this.a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets)this.a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets)this.a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            object = (ab)object;
            if (this.a == null) {
                return ((ab)object).a == null;
            }
            return this.a.equals(((ab)object).a);
        }
        return false;
    }

    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }
}

