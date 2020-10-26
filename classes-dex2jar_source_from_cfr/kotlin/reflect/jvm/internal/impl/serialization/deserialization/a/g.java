/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.v;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.d.b.i;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;

public interface g
extends v {
    public q K();

    public c L();

    public h M();

    public k N();

    public f O();

    public List<i> P();

    public static final class a {
        public static List<i> a(g g2) {
            return i.a.a(g2.K(), g2.L(), g2.N());
        }
    }

}

