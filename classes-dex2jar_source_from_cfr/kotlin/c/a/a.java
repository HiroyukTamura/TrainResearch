/*
 * Decompiled with CFR 0.139.
 */
package kotlin.c.a;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "kotlin-stdlib-jdk7"}, k=1, mv={1, 1, 11})
public class a
extends kotlin.c.a {
    @Override
    public void a(Throwable throwable, Throwable throwable2) {
        j.b(throwable, "cause");
        j.b(throwable2, "exception");
        throwable.addSuppressed(throwable2);
    }
}
