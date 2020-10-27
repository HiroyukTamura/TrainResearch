package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, mo21739d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, mo21740k = 1, mo21741mv = {1, 1, 16})
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* renamed from: j */
    public static final C2494a f4096j = C2494a.f4097a;

    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$a */
    public static final class C2494a implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: a */
        static final /* synthetic */ C2494a f4097a = new C2494a();

        private C2494a() {
        }
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
