/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.ad;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.c;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.s;

public final class BuiltInsLoaderImpl
implements BuiltInsLoader {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.c a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.c();

    public final ac a(kotlin.reflect.jvm.internal.impl.i.i object, y object2, Set<kotlin.reflect.jvm.internal.impl.e.b> collection, Iterable<? extends kotlin.reflect.jvm.internal.impl.a.b.b> iterable, kotlin.reflect.jvm.internal.impl.a.b.c c2, kotlin.reflect.jvm.internal.impl.a.b.a a2, kotlin.e.a.b<? super String, ? extends InputStream> object3) {
        Object object4;
        Object object5;
        kotlin.e.b.j.b(object, "storageManager");
        kotlin.e.b.j.b(object2, "module");
        kotlin.e.b.j.b(collection, "packageFqNames");
        kotlin.e.b.j.b(iterable, "classDescriptorFactories");
        kotlin.e.b.j.b(c2, "platformDependentDeclarationFilter");
        kotlin.e.b.j.b(a2, "additionalClassPartsProvider");
        kotlin.e.b.j.b(object3, "loadResource");
        Object object6 = collection;
        collection = new ArrayList(kotlin.a.m.a(object6, 10));
        Object object7 = object6.iterator();
        while (object7.hasNext()) {
            object4 = (kotlin.reflect.jvm.internal.impl.e.b)object7.next();
            object6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.a.a((kotlin.reflect.jvm.internal.impl.e.b)object4);
            object5 = object3.a((String)object6);
            if (object5 != null) {
                collection.add((kotlin.reflect.jvm.internal.impl.e.b)((Object)kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.b.a.a((kotlin.reflect.jvm.internal.impl.e.b)object4, (kotlin.reflect.jvm.internal.impl.i.i)object, (y)object2, (InputStream)object5)));
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Resource not found in classpath: ");
            ((StringBuilder)object).append((String)object6);
            throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
        }
        collection = (List)collection;
        object3 = new ad((Collection<? extends ab>)collection);
        object6 = new aa((kotlin.reflect.jvm.internal.impl.i.i)object, (y)object2);
        object7 = k.a.a;
        object3 = (ac)object3;
        object4 = new m((ac)object3);
        object5 = new c((y)object2, (aa)object6, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.a);
        s s2 = s.a.a;
        p p2 = p.b;
        kotlin.e.b.j.a((Object)p2, "ErrorReporter.DO_NOTHING");
        object = new j((kotlin.reflect.jvm.internal.impl.i.i)object, (y)object2, (k)object7, (g)object4, (b<? extends kotlin.reflect.jvm.internal.impl.a.a.c, ? extends f<?>, kotlin.reflect.jvm.internal.impl.a.a.g>)object5, (ac)object3, s2, p2, c.a.a, q.a.a, iterable, (aa)object6, i.a.a(), a2, c2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.a.a());
        object2 = collection.iterator();
        while (object2.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.b)object2.next()).a((j)object);
        }
        return object3;
    }

    @Override
    public ac createPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.i.i i2, y y2, Iterable<? extends kotlin.reflect.jvm.internal.impl.a.b.b> iterable, kotlin.reflect.jvm.internal.impl.a.b.c c2, kotlin.reflect.jvm.internal.impl.a.b.a a2) {
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(y2, "builtInsModule");
        kotlin.e.b.j.b(iterable, "classDescriptorFactories");
        kotlin.e.b.j.b(c2, "platformDependentDeclarationFilter");
        kotlin.e.b.j.b(a2, "additionalClassPartsProvider");
        Set<kotlin.reflect.jvm.internal.impl.e.b> set = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAMES;
        kotlin.e.b.j.a(set, "KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAMES");
        return this.a(i2, y2, set, iterable, c2, a2, (kotlin.e.a.b<? super String, ? extends InputStream>)new kotlin.e.a.b<String, InputStream>(this.a){

            @Override
            public final InputStream a(String string2) {
                kotlin.e.b.j.b(string2, "p1");
                return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.c)this.a).a(string2);
            }

            @Override
            public final e f() {
                return v.a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.c.class);
            }

            @Override
            public final String g() {
                return "loadResource";
            }

            @Override
            public final String h() {
                return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
            }
        });
    }

}

