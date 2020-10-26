/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.b.b;
import kotlin.reflect.jvm.internal.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class i {
    private static b<String, Object> a = b.a();

    /*
     * Enabled aggressive block sorting
     */
    public static final <T> j<T> a(Class<T> j2) {
        void var4_13;
        block8 : {
            Object object;
            int n2;
            String string2;
            WeakReference[] arrweakReference;
            int n3;
            block7 : {
                block6 : {
                    block5 : {
                        void var4_6;
                        kotlin.e.b.j.b(j2, "jClass");
                        string2 = ((Class)((Object)j2)).getName();
                        object = a.a(string2);
                        boolean bl2 = object instanceof WeakReference;
                        Object var4_4 = null;
                        if (!bl2) break block5;
                        if ((object = (j)((WeakReference)object).get()) != null) {
                            Class class_ = ((j)object).a();
                        }
                        if (kotlin.e.b.j.a((Object)var4_6, j2)) {
                            return object;
                        }
                        break block6;
                    }
                    if (object == null) break block6;
                    arrweakReference = (WeakReference[])object;
                    n3 = arrweakReference.length;
                    break block7;
                }
                j2 = new j(j2);
                b b2 = a.a(string2, new WeakReference(j2));
                break block8;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                void var4_10;
                j j3 = (j)arrweakReference[n2].get();
                if (j3 != null) {
                    Class class_ = j3.a();
                } else {
                    Object var4_9 = null;
                }
                if (!kotlin.e.b.j.a((Object)var4_10, j2)) continue;
                return j3;
            }
            n2 = ((Object[])object).length;
            WeakReference[] arrweakReference2 = new WeakReference[n2 + 1];
            System.arraycopy(object, 0, arrweakReference2, 0, n2);
            j2 = new j(j2);
            arrweakReference2[n2] = new WeakReference(j2);
            b<String, Object> b3 = a.a(string2, arrweakReference2);
        }
        a = var4_13;
        return j2;
    }
}

