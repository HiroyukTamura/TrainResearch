/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  android.view.View
 */
package androidx.databinding.a;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class d {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> a = new SparseArray();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> T a(View object, int n2) {
        if (Build.VERSION.SDK_INT >= 14) {
            return (T)object.getTag(n2);
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = a;
        synchronized (sparseArray) {
            WeakHashMap weakHashMap = (WeakHashMap)a.get(n2);
            if (weakHashMap == null) {
                return null;
            }
            if ((object = (WeakReference)weakHashMap.get(object)) == null) {
                return null;
            }
            object = object.get();
            return (T)object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> T a(View object, T t2, int n2) {
        if (Build.VERSION.SDK_INT >= 14) {
            Object object2 = object.getTag(n2);
            object.setTag(n2, t2);
            return (T)object2;
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = a;
        synchronized (sparseArray) {
            WeakHashMap<View, WeakReference<T>> weakHashMap;
            WeakHashMap<View, WeakReference<T>> weakHashMap2 = weakHashMap = (WeakHashMap<View, WeakReference<T>>)a.get(n2);
            if (weakHashMap == null) {
                weakHashMap2 = new WeakHashMap<View, WeakReference<T>>();
                a.put(n2, weakHashMap2);
            }
            object = t2 == null ? weakHashMap2.remove(object) : weakHashMap2.put((View)object, new WeakReference<T>(t2));
            if ((object = (WeakReference)object) != null) {
                object = object.get();
                return (T)object;
            }
            return null;
        }
    }
}

