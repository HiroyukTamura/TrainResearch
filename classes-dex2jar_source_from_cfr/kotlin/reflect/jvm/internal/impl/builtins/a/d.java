/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.a;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.builtins.a.b;
import kotlin.reflect.jvm.internal.impl.builtins.a.e;
import kotlin.reflect.jvm.internal.impl.builtins.a.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.t;

public final class d
extends kotlin.reflect.jvm.internal.impl.h.e.e {
    public d(i i2, b b2) {
        j.b(i2, "storageManager");
        j.b(b2, "containingClass");
        super(i2, b2);
    }

    @Override
    protected List<kotlin.reflect.jvm.internal.impl.a.t> a() {
        Object object = this.c();
        if (object != null) {
            boolean bl2;
            b b2;
            object = ((b)object).A();
            switch (e.a[((Enum)object).ordinal()]) {
                default: {
                    return m.a();
                }
                case 2: {
                    object = f.a;
                    b2 = (b)this.c();
                    bl2 = true;
                    break;
                }
                case 1: {
                    object = f.a;
                    b2 = (b)this.c();
                    bl2 = false;
                }
            }
            return m.a(((f.a)object).a(b2, bl2));
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
    }
}

