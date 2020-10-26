/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.core.g;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

public class c {
    public static /* varargs */ int a(Object ... arrobject) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(arrobject);
        }
        return Arrays.hashCode(arrobject);
    }

    public static boolean a(Object object, Object object2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(object, object2);
        }
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }
}

