/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.h.e.h;

public interface ae
extends m {
    public b a();

    public h c();

    public y e();

    public List<ab> f();

    public boolean g();

    public static final class a {
        public static boolean a(ae ae2) {
            return ae2.f().isEmpty();
        }
    }

}

