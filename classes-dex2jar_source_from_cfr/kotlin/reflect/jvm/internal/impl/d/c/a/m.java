/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.a.al;
import kotlin.e.b.j;
import kotlin.e.b.z;
import kotlin.t;

public final class m {
    private final LinkedHashMap<String, String> a;
    private final Set<String> b;
    private final String c;

    public m(String string2) {
        j.b(string2, "packageFqName");
        this.c = string2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashSet();
    }

    public final Set<String> a() {
        Set<String> set = this.a.keySet();
        j.a(set, "packageParts.keys");
        return set;
    }

    public final void a(String string2) {
        j.b(string2, "shortName");
        Set<String> set = this.b;
        if (set != null) {
            z.c(set).add(string2);
            return;
        }
        throw new t("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
    }

    public final void a(String string2, String string3) {
        j.b(string2, "partInternalName");
        ((Map)this.a).put(string2, string3);
    }

    public boolean equals(Object object) {
        if (object instanceof m) {
            object = (m)object;
            if (j.a((Object)((m)object).c, (Object)this.c) && j.a(((m)object).a, this.a) && j.a(((m)object).b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.c.hashCode() * 31 + this.a.hashCode()) * 31 + ((Object)this.b).hashCode();
    }

    public String toString() {
        return al.a(this.a(), (Iterable)this.b).toString();
    }
}

