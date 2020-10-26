/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.b;
import kotlin.reflect.f;
import kotlin.reflect.g;
import kotlin.reflect.jvm.c;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.l;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class a {
    /*
     * Enabled aggressive block sorting
     */
    public static final void a(b<?> constructor, boolean bl2) {
        Constructor constructor2;
        d<?> d2;
        void var0_12;
        void var1_15;
        AccessibleObject accessibleObject;
        h<?> h2;
        block18 : {
            void var0_4;
            block15 : {
                Method method;
                block17 : {
                    Method method2;
                    block16 : {
                        Method method3;
                        block14 : {
                            Method method4;
                            j.b(constructor, "$receiver");
                            if (!(constructor instanceof g)) break block14;
                            Object object = (l)((Object)constructor);
                            Field field = c.a(object);
                            if (field != null) {
                                field.setAccessible((boolean)var1_15);
                            }
                            if ((object = c.b(object)) != null) {
                                ((AccessibleObject)object).setAccessible((boolean)var1_15);
                            }
                            if ((method4 = c.a((g)((Object)constructor))) == null) return;
                            break block15;
                        }
                        if (!(constructor instanceof l)) break block16;
                        l l2 = (l)((Object)constructor);
                        Field field = c.a(l2);
                        if (field != null) {
                            field.setAccessible((boolean)var1_15);
                        }
                        if ((method3 = c.b(l2)) == null) return;
                        break block15;
                    }
                    if (!(constructor instanceof l.b)) break block17;
                    Field field = c.a(((l.b)((Object)constructor)).b());
                    if (field != null) {
                        field.setAccessible((boolean)var1_15);
                    }
                    if ((method2 = c.a((f)((Object)constructor))) == null) return;
                    break block15;
                }
                if (!(constructor instanceof g.a)) break block18;
                Field field = c.a(((g.a)((Object)constructor)).b());
                if (field != null) {
                    field.setAccessible((boolean)var1_15);
                }
                if ((method = c.a((f)((Object)constructor))) == null) return;
            }
            var0_4.setAccessible((boolean)var1_15);
            return;
        }
        if (!(constructor instanceof f)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown callable: ");
            stringBuilder.append(constructor);
            stringBuilder.append(" (");
            stringBuilder.append(constructor.getClass());
            stringBuilder.append(')');
            throw (Throwable)new UnsupportedOperationException(stringBuilder.toString());
        }
        f f2 = (f)((Object)constructor);
        Method method = c.a(f2);
        if (method != null) {
            method.setAccessible((boolean)var1_15);
        }
        if ((h2 = ai.c(constructor)) != null && (d2 = h2.e()) != null) {
            Object obj = d2.c();
        } else {
            Object var0_11 = null;
        }
        method = var0_12;
        if (!(var0_12 instanceof AccessibleObject)) {
            method = null;
        }
        if ((accessibleObject = (AccessibleObject)method) != null) {
            accessibleObject.setAccessible(true);
        }
        if ((constructor2 = c.b(f2)) == null) return;
        {
            constructor2.setAccessible((boolean)var1_15);
        }
    }
}

