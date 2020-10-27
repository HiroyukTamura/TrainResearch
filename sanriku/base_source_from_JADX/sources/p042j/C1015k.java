package p042j;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.k */
public abstract class C1015k implements C1016z {
    private final C1016z delegate;

    public C1015k(C1016z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, "delegate");
        this.delegate = zVar;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    @JvmName(name = "-deprecated_delegate")
    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final C1016z m4599deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    @JvmName(name = "delegate")
    public final C1016z delegate() {
        return this.delegate;
    }

    public long read(C2068f fVar, long j) throws IOException {
        Intrinsics.checkParameterIsNotNull(fVar, "sink");
        return this.delegate.read(fVar, j);
    }

    public C2057A timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
