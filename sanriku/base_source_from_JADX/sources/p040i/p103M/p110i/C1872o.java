package p040i.p103M.p110i;

import java.io.IOException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.i.o */
public final class C1872o extends IOException {
    @JvmField

    /* renamed from: a */
    public final C1834b f2649a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1872o(C1834b bVar) {
        super("stream was reset: " + bVar);
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        this.f2649a = bVar;
    }
}
