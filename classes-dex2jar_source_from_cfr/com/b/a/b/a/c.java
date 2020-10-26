/*
 * Decompiled with CFR 0.139.
 */
package com.b.a.b.a;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"ABSENT_VALUE", "", "KOTLIN_METADATA", "Ljava/lang/Class;", "", "moshi-kotlin"}, k=2, mv={1, 1, 11})
public final class c {
    private static final Class<? extends Annotation> a;
    private static final Object b;

    static {
        Class<?> class_ = Class.forName("kotlin.Metadata");
        if (class_ != null) {
            a = class_;
            b = new Object();
            return;
        }
        throw new t("null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
    }

    public static final /* synthetic */ Object a() {
        return b;
    }

    public static final /* synthetic */ Class b() {
        return a;
    }
}

