/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.a.j;
import kotlin.reflect.jvm.internal.ak;
import kotlin.reflect.jvm.internal.c.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class ab {
    private static final ConcurrentMap<ak, WeakReference<j>> a = new ConcurrentHashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final j a(Class<?> object) {
        j j2;
        kotlin.e.b.j.b(object, "$receiver");
        Object object2 = b.a(object);
        object = new ak((ClassLoader)object2);
        WeakReference<Object> weakReference = (WeakReference<Object>)a.get(object);
        if (weakReference != null) {
            j2 = (j)weakReference.get();
            if (j2 != null) {
                kotlin.e.b.j.a((Object)j2, "it");
                return j2;
            }
            a.remove(object, weakReference);
        }
        object2 = j.a.a((ClassLoader)object2);
        try {
            while ((weakReference = a.putIfAbsent((ak)object, new WeakReference<Object>(object2))) != null) {
                j2 = (j)weakReference.get();
                if (j2 != null) {
                    ((ak)object).a(null);
                    return j2;
                }
                a.remove(object, weakReference);
            }
            ((ak)object).a(null);
            return object2;
        }
        catch (Throwable throwable) {
            ((ak)object).a(null);
            throw throwable;
        }
    }
}

