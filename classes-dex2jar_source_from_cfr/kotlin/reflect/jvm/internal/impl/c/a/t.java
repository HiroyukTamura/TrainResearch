/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.b.a.b;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.f;
import kotlin.reflect.jvm.internal.impl.c.a.g;
import kotlin.reflect.jvm.internal.impl.c.a.k;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class t {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final k a(w object, String object2) {
        Object var4_5;
        block11 : {
            block12 : {
                j.b(object, "$receiver");
                j.b(object2, "value");
                Object object3 = ((w)object).g().d();
                boolean bl2 = object3 instanceof e;
                var4_5 = null;
                kotlin.reflect.jvm.internal.impl.l.f f2 = null;
                if (bl2 && (object3 = (e)object3).l() == kotlin.reflect.jvm.internal.impl.a.f.c) {
                    object = object3.C();
                    object2 = kotlin.reflect.jvm.internal.impl.e.f.a((String)object2);
                    j.a(object2, "Name.identifier(value)");
                    object2 = object.c((kotlin.reflect.jvm.internal.impl.e.f)object2, d.b);
                    object = f2;
                    if (!(object2 instanceof e)) return object;
                    object2 = (e)object2;
                    object = f2;
                    if (object2.l() != kotlin.reflect.jvm.internal.impl.a.f.d) return object;
                    return new g((e)object2);
                }
                object = a.c((w)object);
                f2 = kotlin.reflect.jvm.internal.impl.l.g.a((String)object2);
                object3 = f2.a();
                int n2 = f2.b();
                try {
                    if (KotlinBuiltIns.isBoolean((w)object)) {
                        object2 = Boolean.parseBoolean((String)object2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isChar((w)object)) {
                        object2 = n.e((CharSequence)object2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isByte((w)object)) {
                        object2 = n.a((String)object3, n2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isShort((w)object)) {
                        object2 = n.b((String)object3, n2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isInt((w)object)) {
                        object2 = n.c((String)object3, n2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isLong((w)object)) {
                        object2 = n.d((String)object3, n2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isFloat((w)object)) {
                        object2 = n.a((String)object2);
                        break block11;
                    }
                    if (KotlinBuiltIns.isDouble((w)object)) {
                        object2 = n.b((String)object2);
                        break block11;
                    }
                    bl2 = KotlinBuiltIns.isString((w)object);
                    if (!bl2) break block12;
                    break block11;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
            }
            object2 = null;
        }
        object = var4_5;
        if (object2 == null) return object;
        return new f(object2);
    }
}

