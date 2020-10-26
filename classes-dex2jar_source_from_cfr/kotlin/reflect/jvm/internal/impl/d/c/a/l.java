/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import kotlin.i.n;

public final class l {
    public static final /* synthetic */ String a(String string2, String string3) {
        return l.b(string2, string3);
    }

    private static final String b(String string2, String string3) {
        boolean bl2 = ((CharSequence)string2).length() == 0;
        if (bl2) {
            return string3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n.a(string2, '.', '/', false, 4, null));
        stringBuilder.append("/");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

