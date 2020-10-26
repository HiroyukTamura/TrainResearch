/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.e;
import kotlin.reflect.jvm.internal.impl.e.i;
import kotlin.t;

public final class d {
    public static final boolean a(String string2) {
        boolean bl2 = false;
        if (string2 == null) {
            return false;
        }
        i i2 = i.a;
        int n2 = string2.length();
        block4 : for (int i3 = 0; i3 < n2; ++i3) {
            char c2 = string2.charAt(i3);
            switch (e.a[i2.ordinal()]) {
                default: {
                    continue block4;
                }
                case 3: {
                    if (c2 == '.') {
                        i2 = i.c;
                        continue block4;
                    }
                    if (Character.isJavaIdentifierPart(c2)) continue block4;
                    return false;
                }
                case 1: 
                case 2: {
                    if (!Character.isJavaIdentifierPart(c2)) {
                        return false;
                    }
                    i2 = i.b;
                }
            }
        }
        if (i2 != i.c) {
            bl2 = true;
        }
        return bl2;
    }

    private static final boolean a(String string2, String string3) {
        boolean bl2;
        boolean bl3 = bl2 = false;
        if (n.a(string2, string3, false, 2, null)) {
            bl3 = bl2;
            if (string2.charAt(string3.length()) == '.') {
                bl3 = true;
            }
        }
        return bl3;
    }

    public static final boolean a(b object, b object2) {
        j.b(object, "$receiver");
        j.b(object2, "packageName");
        if (j.a(object, object2)) {
            return true;
        }
        if (((b)object2).c()) {
            return true;
        }
        object = ((b)object).a();
        j.a(object, "this.asString()");
        object2 = ((b)object2).a();
        j.a(object2, "packageName.asString()");
        return d.a((String)object, (String)object2);
    }

    public static final b b(b object, b b2) {
        j.b(object, "$receiver");
        j.b(b2, "prefix");
        if (d.a((b)object, b2)) {
            if (b2.c()) {
                return object;
            }
            if (j.a(object, (Object)b2)) {
                object = b.a;
                j.a(object, "FqName.ROOT");
                return object;
            }
            object = ((b)object).a();
            j.a(object, "asString()");
            int n2 = b2.a().length();
            if (object != null) {
                object = ((String)object).substring(n2 + 1);
                j.a(object, "(this as java.lang.String).substring(startIndex)");
                return new b((String)object);
            }
            throw new t("null cannot be cast to non-null type java.lang.String");
        }
        return object;
    }
}

