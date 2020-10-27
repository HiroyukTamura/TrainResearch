package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.C2499H;
import kotlinx.coroutines.C2519a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.internal.p */
public class C2561p<T> extends C2519a<T> implements CoroutineStackFrame {
    @JvmField

    /* renamed from: d */
    public final Continuation<T> f4203d;

    public C2561p(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true);
        this.f4203d = continuation;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo21838a(Object obj) {
        C2499H.m4321a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.f4203d), C1532a.m2126a(obj, this.f4203d));
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo35496e(Object obj) {
        Continuation<T> continuation = this.f4203d;
        continuation.resumeWith(C1532a.m2126a(obj, continuation));
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final boolean mo21852f() {
        return true;
    }

    public final CoroutineStackFrame getCallerFrame() {
        return (CoroutineStackFrame) this.f4203d;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }
}
