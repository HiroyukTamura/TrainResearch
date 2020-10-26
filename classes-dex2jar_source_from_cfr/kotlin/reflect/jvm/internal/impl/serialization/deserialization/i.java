/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.j;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;

public interface i {
    public static final a a = a.a;

    public o<t.b<?>, Object> a(a.o var1, t var2, h var3, aa var4);

    public static final class kotlin.reflect.jvm.internal.impl.serialization.deserialization.i$a {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.i$a a;
        private static final i b;

        static {
            a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.i$a();
            b = new i(){

                public o a(a.o o2, t t2, h h2, aa aa2) {
                    j.b(o2, "proto");
                    j.b(t2, "ownerFunction");
                    j.b(h2, "typeTable");
                    j.b(aa2, "typeDeserializer");
                    return null;
                }
            };
        }

        private kotlin.reflect.jvm.internal.impl.serialization.deserialization.i$a() {
        }

        public final i a() {
            return b;
        }

    }

}

