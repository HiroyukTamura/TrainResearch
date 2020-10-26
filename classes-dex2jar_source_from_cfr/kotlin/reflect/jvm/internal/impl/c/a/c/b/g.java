/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.i.n;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.e;
import kotlin.reflect.jvm.internal.impl.j.ac;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class g
extends q
implements ac {
    public g(ad ad2, ad ad3) {
        j.b(ad2, "lowerBound");
        j.b(ad3, "upperBound");
        super(ad2, ad3);
        boolean bl2 = kotlin.reflect.jvm.internal.impl.j.a.c.a.a(ad2, ad3);
        if (y.a) {
            if (bl2) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Lower bound ");
            stringBuilder.append(ad2);
            stringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
            stringBuilder.append(ad3);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.g.c object, kotlin.reflect.jvm.internal.impl.g.h object2) {
        Object object3;
        c c2;
        String string2;
        Object object4;
        boolean bl2;
        block7 : {
            j.b(object, "renderer");
            j.b(object2, "options");
            object3 = a.a;
            object4 = new kotlin.e.a.b<w, List<? extends String>>((kotlin.reflect.jvm.internal.impl.g.c)object){
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.g.c a;
                {
                    this.a = c2;
                    super(1);
                }

                @Override
                public final List<String> a(w object) {
                    j.b(object, "type");
                    Object object2 = ((w)object).a();
                    object = new ArrayList(m.a(object2, 10));
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        ap ap2 = (ap)object2.next();
                        object.add(this.a.a(ap2));
                    }
                    return (List)object;
                }
            };
            c2 = c.a;
            string2 = ((kotlin.reflect.jvm.internal.impl.g.c)object).a(this.f());
            object3 = ((kotlin.reflect.jvm.internal.impl.g.c)object).a(this.h());
            if (object2.h()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("raw (");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("..");
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(')');
                return ((StringBuilder)object).toString();
            }
            if (this.h().a().isEmpty()) {
                return ((kotlin.reflect.jvm.internal.impl.g.c)object).a(string2, (String)object3, kotlin.reflect.jvm.internal.impl.j.c.a.a((w)this));
            }
            Object object5 = object4.a(this.f());
            object2 = object4.a(this.h());
            object5 = (Iterable)object5;
            object4 = m.a(object5, ", ", null, null, 0, null, d.a, 30, null);
            object2 = m.a(object5, (Iterable)object2);
            boolean bl3 = object2 instanceof Collection;
            boolean bl4 = true;
            if (bl3 && ((Collection)object2).isEmpty()) {
                bl2 = bl4;
            } else {
                object2 = object2.iterator();
                do {
                    bl2 = bl4;
                    if (!object2.hasNext()) break block7;
                } while (a.a.a((String)((o)(object5 = (o)object2.next())).a(), (String)((o)object5).b()));
                bl2 = false;
            }
        }
        object2 = object3;
        if (bl2) {
            object2 = c2.a((String)object3, (String)object4);
        }
        if (j.a(object3 = c2.a(string2, (String)object4), object2)) {
            return object3;
        }
        return ((kotlin.reflect.jvm.internal.impl.g.c)object).a((String)object3, (String)object2, kotlin.reflect.jvm.internal.impl.j.c.a.a((w)this));
    }

    public g a(h h2) {
        j.b(h2, "newAnnotations");
        return new g(this.f().c(h2), this.h().c(h2));
    }

    public g a(boolean bl2) {
        return new g(this.f().a(bl2), this.h().a(bl2));
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        kotlin.reflect.jvm.internal.impl.a.h h2 = this.g().d();
        Object object = h2;
        if (!(h2 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            object = null;
        }
        if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object) != null) {
            object = object.a(e.a);
            j.a(object, "classDescriptor.getMemberScope(RawSubstitution)");
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Incorrect classifier: ");
        ((StringBuilder)object).append(this.g().d());
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.a(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public ad p_() {
        return this.f();
    }

}

