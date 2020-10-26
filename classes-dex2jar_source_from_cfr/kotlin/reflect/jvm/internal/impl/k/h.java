/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.h.c.a;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.k.b;

final class h
implements b {
    public static final h a = new h();
    private static final String b = "should not have varargs or parameters with default values";

    static {
        b = b;
    }

    private h() {
    }

    @Override
    public String a() {
        return b;
    }

    @Override
    public boolean a(t iterator) {
        boolean bl2;
        block2 : {
            boolean bl3;
            av av2;
            j.b(iterator, "functionDescriptor");
            iterator = iterator.i();
            j.a((Object)iterator, "functionDescriptor.valueParameters");
            iterator = (Iterable)((Object)iterator);
            bl2 = iterator instanceof Collection;
            boolean bl4 = true;
            if (bl2 && ((Collection)((Object)iterator)).isEmpty()) {
                return true;
            }
            iterator = iterator.iterator();
            do {
                bl2 = bl4;
                if (!iterator.hasNext()) break block2;
                av2 = (av)iterator.next();
                j.a((Object)av2, "it");
            } while (bl3 = !a.a(av2) && av2.m() == null);
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public String b(t t2) {
        j.b(t2, "functionDescriptor");
        return b.a.a(this, t2);
    }
}

