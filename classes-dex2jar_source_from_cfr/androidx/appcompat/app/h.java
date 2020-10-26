/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.LongSparseArray
 */
package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class h {
    private static Field a;
    private static boolean b;
    private static Class c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    static void a(Resources resources) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            h.d(resources);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            h.c(resources);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            h.b(resources);
        }
    }

    private static void a(Object object) {
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            }
            catch (ClassNotFoundException classNotFoundException) {
                Log.e((String)"ResourcesFlusher", (String)"Could not find ThemedResourceCache class", (Throwable)classNotFoundException);
            }
            d = true;
        }
        if (c == null) {
            return;
        }
        if (!f) {
            try {
                e = c.getDeclaredField("mUnthemedEntries");
                e.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.e((String)"ResourcesFlusher", (String)"Could not retrieve ThemedResourceCache#mUnthemedEntries field", (Throwable)noSuchFieldException);
            }
            f = true;
        }
        if (e == null) {
            return;
        }
        try {
            object = (LongSparseArray)e.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)"ResourcesFlusher", (String)"Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)illegalAccessException);
            object = null;
        }
        if (object != null) {
            object.clear();
        }
    }

    private static void b(Resources object) {
        if (!b) {
            try {
                a = Resources.class.getDeclaredField("mDrawableCache");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.e((String)"ResourcesFlusher", (String)"Could not retrieve Resources#mDrawableCache field", (Throwable)noSuchFieldException);
            }
            b = true;
        }
        if (a != null) {
            try {
                object = (Map)a.get(object);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)"ResourcesFlusher", (String)"Could not retrieve value from Resources#mDrawableCache", (Throwable)illegalAccessException);
                object = null;
            }
            if (object != null) {
                object.clear();
            }
        }
    }

    private static void c(Resources object) {
        block7 : {
            if (!b) {
                try {
                    a = Resources.class.getDeclaredField("mDrawableCache");
                    a.setAccessible(true);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Log.e((String)"ResourcesFlusher", (String)"Could not retrieve Resources#mDrawableCache field", (Throwable)noSuchFieldException);
                }
                b = true;
            }
            if (a != null) {
                try {
                    object = a.get(object);
                    break block7;
                }
                catch (IllegalAccessException illegalAccessException) {
                    Log.e((String)"ResourcesFlusher", (String)"Could not retrieve value from Resources#mDrawableCache", (Throwable)illegalAccessException);
                }
            }
            object = null;
        }
        if (object == null) {
            return;
        }
        h.a(object);
    }

    private static void d(Resources object) {
        block14 : {
            if (!h) {
                try {
                    g = Resources.class.getDeclaredField("mResourcesImpl");
                    g.setAccessible(true);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Log.e((String)"ResourcesFlusher", (String)"Could not retrieve Resources#mResourcesImpl field", (Throwable)noSuchFieldException);
                }
                h = true;
            }
            if (g == null) {
                return;
            }
            try {
                object = g.get(object);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)"ResourcesFlusher", (String)"Could not retrieve value from Resources#mResourcesImpl", (Throwable)illegalAccessException);
                object = null;
            }
            if (object == null) {
                return;
            }
            if (!b) {
                try {
                    a = object.getClass().getDeclaredField("mDrawableCache");
                    a.setAccessible(true);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Log.e((String)"ResourcesFlusher", (String)"Could not retrieve ResourcesImpl#mDrawableCache field", (Throwable)noSuchFieldException);
                }
                b = true;
            }
            if (a != null) {
                try {
                    object = a.get(object);
                    break block14;
                }
                catch (IllegalAccessException illegalAccessException) {
                    Log.e((String)"ResourcesFlusher", (String)"Could not retrieve value from ResourcesImpl#mDrawableCache", (Throwable)illegalAccessException);
                }
            }
            object = null;
        }
        if (object != null) {
            h.a(object);
        }
    }
}

