package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlinx.coroutines.b0 */
public final class C2524b0 extends CancellationException implements C2590u<C2524b0> {
    @JvmField

    /* renamed from: a */
    public final C1111a0 f4141a;

    public C2524b0(String str, Throwable th, C1111a0 a0Var) {
        super(str);
        this.f4141a = a0Var;
        if (th != null) {
            initCause(th);
        }
    }

    /* renamed from: a */
    public Throwable mo35538a() {
        if (!C2496E.m4307c()) {
            return null;
        }
        String message = getMessage();
        if (message == null) {
            Intrinsics.throwNpe();
        }
        return new C2524b0(message, this, this.f4141a);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C2524b0) {
                C2524b0 b0Var = (C2524b0) obj;
                if (!Intrinsics.areEqual((Object) b0Var.getMessage(), (Object) getMessage()) || !Intrinsics.areEqual((Object) b0Var.f4141a, (Object) this.f4141a) || !Intrinsics.areEqual((Object) b0Var.getCause(), (Object) getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        if (C2496E.m4307c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        if (message == null) {
            Intrinsics.throwNpe();
        }
        int hashCode = (this.f4141a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + "; job=" + this.f4141a;
    }
}
