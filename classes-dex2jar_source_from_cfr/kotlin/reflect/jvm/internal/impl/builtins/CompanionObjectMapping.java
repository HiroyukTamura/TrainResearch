/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.c.a;

public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
    private static final LinkedHashSet<kotlin.reflect.jvm.internal.impl.e.a> a;

    static {
        Collection<PrimitiveType> collection = PrimitiveType.NUMBER_TYPES;
        j.a(collection, "PrimitiveType.NUMBER_TYPES");
        Iterator iterator = collection;
        collection = new ArrayList(kotlin.a.m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            collection.add((PrimitiveType)((Object)KotlinBuiltIns.getPrimitiveFqName((PrimitiveType)((Object)iterator.next()))));
        }
        iterator = kotlin.a.m.a((Collection)kotlin.a.m.a((List)collection, KotlinBuiltIns.FQ_NAMES.string.c()), KotlinBuiltIns.FQ_NAMES._enum.c());
        collection = new LinkedHashSet();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            collection.add((PrimitiveType)((Object)kotlin.reflect.jvm.internal.impl.e.a.a((b)iterator.next())));
        }
        a = (LinkedHashSet)collection;
    }

    private CompanionObjectMapping() {
    }

    public final Set<kotlin.reflect.jvm.internal.impl.e.a> allClassesWithIntrinsicCompanions() {
        Set<kotlin.reflect.jvm.internal.impl.e.a> set = Collections.unmodifiableSet((Set)a);
        j.a(set, "Collections.unmodifiableSet(classIds)");
        return set;
    }

    public final boolean isMappedIntrinsicCompanionObject(e object) {
        Iterable iterable;
        j.b(object, "classDescriptor");
        return c.i((m)object) && kotlin.a.m.a(iterable = (Iterable)a, object = (object = a.a((i)object)) != null ? ((kotlin.reflect.jvm.internal.impl.e.a)object).e() : null);
    }
}

