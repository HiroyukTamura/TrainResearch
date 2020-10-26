/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.l.f;

public final class g {
    public static final f a(String string2) {
        j.b(string2, "value");
        if (!n.a(string2, "0x", false, 2, null) && !n.a(string2, "0X", false, 2, null)) {
            if (!n.a(string2, "0b", false, 2, null) && !n.a(string2, "0B", false, 2, null)) {
                return new f(string2, 10);
            }
            string2 = string2.substring(2);
            j.a((Object)string2, "(this as java.lang.String).substring(startIndex)");
            return new f(string2, 2);
        }
        string2 = string2.substring(2);
        j.a((Object)string2, "(this as java.lang.String).substring(startIndex)");
        return new f(string2, 16);
    }
}

