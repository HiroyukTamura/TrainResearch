/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.d;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;

public abstract class o
extends n {
    private final d a;
    private final v b;
    private a.t c;
    private kotlin.reflect.jvm.internal.impl.h.e.h d;
    private final kotlin.reflect.jvm.internal.impl.d.b.a e;
    private final f f;

    public o(kotlin.reflect.jvm.internal.impl.e.b object, kotlin.reflect.jvm.internal.impl.i.i object2, y y2, a.t t2, kotlin.reflect.jvm.internal.impl.d.b.a a2, f f2) {
        kotlin.e.b.j.b(object, "fqName");
        kotlin.e.b.j.b(object2, "storageManager");
        kotlin.e.b.j.b(y2, "module");
        kotlin.e.b.j.b(t2, "proto");
        kotlin.e.b.j.b(a2, "metadataVersion");
        super((kotlin.reflect.jvm.internal.impl.e.b)object, (kotlin.reflect.jvm.internal.impl.i.i)object2, y2);
        this.e = a2;
        this.f = f2;
        object = t2.e();
        kotlin.e.b.j.a(object, "proto.strings");
        object2 = t2.g();
        kotlin.e.b.j.a(object2, "proto.qualifiedNames");
        this.a = new d((a.aa)object, (a.y)object2);
        this.b = new v(t2, this.a, this.e, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.a, ? extends an>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.a, an>(){

            @Override
            public final an a(kotlin.reflect.jvm.internal.impl.e.a object) {
                kotlin.e.b.j.b(object, "it");
                object = this.f;
                if (object != null) {
                    return (an)object;
                }
                object = an.a;
                kotlin.e.b.j.a(object, "SourceElement.NO_SOURCE");
                return object;
            }
        });
        this.c = t2;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h a() {
        kotlin.reflect.jvm.internal.impl.h.e.h h2 = this.d;
        if (h2 == null) {
            kotlin.e.b.j.b("_memberScope");
        }
        return h2;
    }

    public void a(j j2) {
        kotlin.e.b.j.b(j2, "components");
        i.c c2 = this.c;
        if (c2 != null) {
            this.c = null;
            ab ab2 = this;
            c2 = c2.k();
            kotlin.e.b.j.a((Object)c2, "proto.`package`");
            this.d = new i(ab2, (a.s)c2, this.a, this.e, this.f, j2, (kotlin.e.a.a<? extends Collection<kotlin.reflect.jvm.internal.impl.e.f>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.impl.e.f> b() {
                    Iterator iterator = this.g().a();
                    Collection collection = new ArrayList();
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        Object e2 = iterator.next();
                        kotlin.reflect.jvm.internal.impl.e.a a2 = (kotlin.reflect.jvm.internal.impl.e.a)e2;
                        boolean bl2 = !a2.f() && !h.a.a().contains(a2);
                        if (!bl2) continue;
                        collection.add(e2);
                    }
                    iterator = (List)collection;
                    collection = new ArrayList(m.a(iterator, 10));
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        collection.add(((kotlin.reflect.jvm.internal.impl.e.a)iterator.next()).c());
                    }
                    return (List)collection;
                }
            });
            return;
        }
        throw (Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override
    public /* synthetic */ g c() {
        return this.g();
    }

    public v g() {
        return this.b;
    }

}

