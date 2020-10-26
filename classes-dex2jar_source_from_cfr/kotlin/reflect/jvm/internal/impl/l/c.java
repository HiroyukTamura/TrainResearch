/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import java.io.Serializable;
import kotlin.e.b.j;

public final class c {
    public static final RuntimeException a(Throwable throwable) {
        j.b(throwable, "e");
        throw throwable;
    }

    public static final boolean b(Throwable serializable) {
        j.b(serializable, "$receiver");
        serializable = serializable.getClass();
        do {
            if (!j.a((Object)((Class)serializable).getCanonicalName(), (Object)"com.intellij.openapi.progress.ProcessCanceledException")) continue;
            return true;
        } while ((serializable = ((Class)serializable).getSuperclass()) != null);
        return false;
    }
}

