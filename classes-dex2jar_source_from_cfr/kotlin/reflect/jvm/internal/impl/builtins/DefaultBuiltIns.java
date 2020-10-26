/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.e.b.g;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsInitializer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.i.b;
import kotlin.reflect.jvm.internal.impl.i.i;

public final class DefaultBuiltIns
extends KotlinBuiltIns {
    public static final Companion Companion = new Companion(null);
    private static final BuiltInsInitializer<DefaultBuiltIns> b = new BuiltInsInitializer(a.a);

    private DefaultBuiltIns() {
        super(new b());
        this.a();
    }

    public /* synthetic */ DefaultBuiltIns(g g2) {
        this();
    }

    public static final DefaultBuiltIns getInstance() {
        return Companion.getInstance();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g g2) {
            this();
        }

        public final DefaultBuiltIns getInstance() {
            return (DefaultBuiltIns)b.get();
        }
    }

}

