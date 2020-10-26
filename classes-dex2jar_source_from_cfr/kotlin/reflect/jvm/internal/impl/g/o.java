/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.e.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.g.k;

public final class o {
    public static final String a(List<f> object) {
        j.b(object, "pathSegments");
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while (object.hasNext()) {
            f f2 = (f)object.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(o.a(f2));
        }
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public static final String a(c object) {
        j.b(object, "$receiver");
        object = ((c)object).h();
        j.a(object, "pathSegments()");
        return o.a((List<f>)object);
    }

    public static final String a(f object) {
        j.b(object, "$receiver");
        if (o.b((f)object)) {
            StringBuilder stringBuilder = new StringBuilder();
            object = ((f)object).a();
            j.a(object, "asString()");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(String.valueOf('`'));
            stringBuilder2.append((String)object);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append('`');
            return stringBuilder.toString();
        }
        object = ((f)object).a();
        j.a(object, "asString()");
        return object;
    }

    private static final boolean b(f object) {
        boolean bl2;
        block7 : {
            block6 : {
                int n2;
                block5 : {
                    boolean bl3 = ((f)object).c();
                    bl2 = false;
                    if (bl3) {
                        return false;
                    }
                    if (k.a.contains(object = ((f)object).a())) break block6;
                    j.a(object, "string");
                    object = (CharSequence)object;
                    for (n2 = 0; n2 < object.length(); ++n2) {
                        char c2 = object.charAt(n2);
                        boolean bl4 = !Character.isLetterOrDigit(c2) && c2 != '_';
                        if (!bl4) continue;
                        n2 = 1;
                        break block5;
                    }
                    n2 = 0;
                }
                if (n2 == 0) break block7;
            }
            bl2 = true;
        }
        return bl2;
    }
}

