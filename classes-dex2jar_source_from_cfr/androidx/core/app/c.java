/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 */
package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c {
    public static IBinder a(Bundle bundle, String string2) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(string2);
        }
        return a.a(bundle, string2);
    }

    static class a {
        private static Method a;
        private static boolean b;

        public static IBinder a(Bundle bundle, String string2) {
            if (!b) {
                try {
                    a = Bundle.class.getMethod("getIBinder", String.class);
                    a.setAccessible(true);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Log.i((String)"BundleCompatBaseImpl", (String)"Failed to retrieve getIBinder method", (Throwable)noSuchMethodException);
                }
                b = true;
            }
            if (a != null) {
                try {
                    bundle = (IBinder)a.invoke((Object)bundle, string2);
                    return bundle;
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
                    Log.i((String)"BundleCompatBaseImpl", (String)"Failed to invoke getIBinder via reflection", (Throwable)exception);
                    a = null;
                }
            }
            return null;
        }
    }

}

