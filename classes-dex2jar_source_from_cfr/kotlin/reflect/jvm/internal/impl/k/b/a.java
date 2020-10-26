/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k.b;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.e.b.j;

public final class a {
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        j.b(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet)collection).addAll(collection2);
            return collection;
        }
        collection = new LinkedHashSet<T>(collection);
        ((AbstractCollection)collection).addAll(collection2);
        return collection;
    }
}

