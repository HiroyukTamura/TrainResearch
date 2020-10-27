package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlinx.coroutines.w */
final class C2607w extends Lambda implements Function1<CoroutineContext.Element, C1120x> {

    /* renamed from: a */
    public static final C2607w f4279a = new C2607w();

    C2607w() {
        super(1);
    }

    public Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (!(element instanceof C1120x)) {
            element = null;
        }
        return (C1120x) element;
    }
}
