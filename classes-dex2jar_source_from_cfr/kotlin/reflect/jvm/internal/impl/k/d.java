/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import java.util.Arrays;
import java.util.Collection;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.k;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.k.b;
import kotlin.reflect.jvm.internal.impl.k.c;

public final class d {
    private final f a;
    private final k b;
    private final Collection<f> c;
    private final kotlin.e.a.b<t, String> d;
    private final b[] e;

    public d(Collection<f> collection, b[] arrb, kotlin.e.a.b<? super t, String> b2) {
        j.b(collection, "nameList");
        j.b(arrb, "checks");
        j.b(b2, "additionalChecks");
        this(null, null, collection, b2, Arrays.copyOf(arrb, arrb.length));
    }

    public /* synthetic */ d(Collection collection, b[] arrb, kotlin.e.a.b b2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            b2 = 3.a;
        }
        this(collection, arrb, (kotlin.e.a.b<? super t, String>)b2);
    }

    public d(k k2, b[] arrb, kotlin.e.a.b<? super t, String> b2) {
        j.b(k2, "regex");
        j.b(arrb, "checks");
        j.b(b2, "additionalChecks");
        this(null, k2, null, b2, Arrays.copyOf(arrb, arrb.length));
    }

    public /* synthetic */ d(k k2, b[] arrb, kotlin.e.a.b b2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            b2 = 2.a;
        }
        this(k2, arrb, (kotlin.e.a.b<? super t, String>)b2);
    }

    private /* varargs */ d(f f2, k k2, Collection<f> collection, kotlin.e.a.b<? super t, String> b2, b ... arrb) {
        this.a = f2;
        this.b = k2;
        this.c = collection;
        this.d = b2;
        this.e = arrb;
    }

    public d(f f2, b[] arrb, kotlin.e.a.b<? super t, String> b2) {
        j.b(f2, "name");
        j.b(arrb, "checks");
        j.b(b2, "additionalChecks");
        this(f2, null, null, b2, Arrays.copyOf(arrb, arrb.length));
    }

    public /* synthetic */ d(f f2, b[] arrb, kotlin.e.a.b b2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            b2 = 1.a;
        }
        this(f2, arrb, (kotlin.e.a.b<? super t, String>)b2);
    }

    public final boolean a(t t2) {
        j.b(t2, "functionDescriptor");
        if (this.a != null && j.a((Object)t2.h_(), (Object)this.a) ^ true) {
            return false;
        }
        if (this.b != null) {
            CharSequence charSequence = t2.h_().a();
            j.a((Object)charSequence, "functionDescriptor.name.asString()");
            charSequence = charSequence;
            if (!this.b.a(charSequence)) {
                return false;
            }
        }
        return this.c == null || this.c.contains(t2.h_());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final c b(t object) {
        j.b(object, "functionDescriptor");
        b[] arrb = this.e;
        int n2 = arrb.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = arrb[i2].b((t)object);
            if (string2 == null) continue;
            object = new c.b(string2);
            do {
                return (c)object;
                break;
            } while (true);
        }
        if ((object = this.d.a((t)object)) != null) {
            return new c.b((String)object);
        }
        object = c.c.a;
        return (c)object;
    }

}

