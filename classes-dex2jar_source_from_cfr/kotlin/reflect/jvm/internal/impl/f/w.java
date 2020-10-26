/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.f.k;
import kotlin.reflect.jvm.internal.impl.f.q;

public class w
extends RuntimeException {
    private final List<String> a = null;

    public w(q q2) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public k a() {
        return new k(this.getMessage());
    }
}

