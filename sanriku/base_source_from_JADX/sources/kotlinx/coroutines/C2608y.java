package kotlinx.coroutines;

import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.CoroutineContext;

/* renamed from: kotlinx.coroutines.y */
public final class C2608y {

    /* renamed from: a */
    private static final List<CoroutineExceptionHandler> f4280a = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(C0000a.m0a()));

    /* renamed from: a */
    public static final void m4554a(CoroutineContext coroutineContext, Throwable th) {
        Throwable th2;
        for (CoroutineExceptionHandler handleException : f4280a) {
            try {
                handleException.handleException(coroutineContext, th);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = currentThread.getUncaughtExceptionHandler();
                if (th == th3) {
                    th2 = th;
                } else {
                    th2 = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, th);
                }
                uncaughtExceptionHandler.uncaughtException(currentThread, th2);
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
