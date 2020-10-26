/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.e.b.j;

public final class c {
    public final InputStream a(String string2) {
        j.b(string2, "path");
        Object object = this.getClass().getClassLoader();
        if (object != null && (object = ((ClassLoader)object).getResourceAsStream(string2)) != null) {
            return object;
        }
        return ClassLoader.getSystemResourceAsStream(string2);
    }
}

