/*
 * Decompiled with CFR 0.139.
 */
package f.b.a;

import c.ab;
import c.ad;
import com.b.a.f;
import com.b.a.j;
import com.b.a.s;
import f.b.a.b;
import f.b.a.c;
import f.e;
import f.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class a
extends e.a {
    private final s a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    private a(s s2, boolean bl2, boolean bl3, boolean bl4) {
        this.a = s2;
        this.b = bl2;
        this.c = bl3;
        this.d = bl4;
    }

    public static a a(s s2) {
        if (s2 != null) {
            return new a(s2, false, false, false);
        }
        throw new NullPointerException("moshi == null");
    }

    private static Set<? extends Annotation> a(Annotation[] arrannotation) {
        int n2 = arrannotation.length;
        LinkedHashSet<Annotation> linkedHashSet = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            Annotation annotation = arrannotation[i2];
            LinkedHashSet<Annotation> linkedHashSet2 = linkedHashSet;
            if (annotation.annotationType().isAnnotationPresent(j.class)) {
                linkedHashSet2 = linkedHashSet;
                if (linkedHashSet == null) {
                    linkedHashSet2 = new LinkedHashSet<Annotation>();
                }
                linkedHashSet2.add(annotation);
            }
            linkedHashSet = linkedHashSet2;
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    @Override
    public e<ad, ?> a(Type object, Annotation[] object2, n n2) {
        object = object2 = this.a.a((Type)object, a.a((Annotation[])object2));
        if (this.b) {
            object = ((f)object2).e();
        }
        object2 = object;
        if (this.c) {
            object2 = ((f)object).f();
        }
        object = object2;
        if (this.d) {
            object = ((f)object2).c();
        }
        return new c(object);
    }

    @Override
    public e<?, ab> a(Type object, Annotation[] object2, Annotation[] arrannotation, n n2) {
        object = object2 = this.a.a((Type)object, a.a((Annotation[])object2));
        if (this.b) {
            object = ((f)object2).e();
        }
        object2 = object;
        if (this.c) {
            object2 = ((f)object).f();
        }
        object = object2;
        if (this.d) {
            object = ((f)object2).c();
        }
        return new b(object);
    }
}

