package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlinx.coroutines.S */
final class C2510S extends Lambda implements Function1<CoroutineContext.Element, C2511T> {

    /* renamed from: a */
    public static final C2510S f4127a = new C2510S();

    C2510S() {
        super(1);
    }

    public Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (!(element instanceof C2511T)) {
            element = null;
        }
        return (C2511T) element;
    }
}
