package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C2580p0;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo21739d2 = {"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.internal.c */
public final class C2542c {

    /* renamed from: a */
    private static final C2563r f4167a = new C2563r("ZERO");

    /* renamed from: b */
    private static final Function2<Object, CoroutineContext.Element, Object> f4168b = C2544b.f4175a;

    /* renamed from: c */
    private static final Function2<C2580p0<?>, CoroutineContext.Element, C2580p0<?>> f4169c = C2545c.f4176a;

    /* renamed from: d */
    private static final Function2<C2568w, CoroutineContext.Element, C2568w> f4170d = C2543a.f4173c;

    /* renamed from: e */
    private static final Function2<C2568w, CoroutineContext.Element, C2568w> f4171e = C2543a.f4172b;

    /* renamed from: kotlinx.coroutines.internal.c$a */
    /* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
    static final class C2543a extends Lambda implements Function2<C2568w, CoroutineContext.Element, C2568w> {

        /* renamed from: b */
        public static final C2543a f4172b = new C2543a(0);

        /* renamed from: c */
        public static final C2543a f4173c = new C2543a(1);

        /* renamed from: a */
        public final /* synthetic */ int f4174a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2543a(int i) {
            super(2);
            this.f4174a = i;
        }

        public final Object invoke(Object obj, Object obj2) {
            int i = this.f4174a;
            if (i == 0) {
                C2568w wVar = (C2568w) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                if (element instanceof C2580p0) {
                    ((C2580p0) element).mo35596a(wVar.mo35583a(), wVar.mo35586c());
                }
                return wVar;
            } else if (i == 1) {
                C2568w wVar2 = (C2568w) obj;
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                if (element2 instanceof C2580p0) {
                    wVar2.mo35584a(((C2580p0) element2).mo35595a(wVar2.mo35583a()));
                }
                return wVar2;
            } else {
                throw null;
            }
        }
    }

    /* renamed from: kotlinx.coroutines.internal.c$b */
    static final class C2544b extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {

        /* renamed from: a */
        public static final C2544b f4175a = new C2544b();

        C2544b() {
            super(2);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineContext.Element element = (CoroutineContext.Element) obj2;
            if (!(element instanceof C2580p0)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? element : Integer.valueOf(intValue + 1);
        }
    }

    /* renamed from: kotlinx.coroutines.internal.c$c */
    static final class C2545c extends Lambda implements Function2<C2580p0<?>, CoroutineContext.Element, C2580p0<?>> {

        /* renamed from: a */
        public static final C2545c f4176a = new C2545c();

        C2545c() {
            super(2);
        }

        public Object invoke(Object obj, Object obj2) {
            C2580p0 p0Var = (C2580p0) obj;
            CoroutineContext.Element element = (CoroutineContext.Element) obj2;
            if (p0Var != null) {
                return p0Var;
            }
            if (!(element instanceof C2580p0)) {
                element = null;
            }
            return (C2580p0) element;
        }
    }

    /* renamed from: a */
    public static final Object m4421a(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f4168b);
        if (fold == null) {
            Intrinsics.throwNpe();
        }
        return fold;
    }

    /* renamed from: a */
    public static final void m4422a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f4167a) {
            if (obj instanceof C2568w) {
                ((C2568w) obj).mo35585b();
                coroutineContext.fold(obj, f4171e);
                return;
            }
            Object fold = coroutineContext.fold(null, f4169c);
            if (fold != null) {
                ((C2580p0) fold).mo35596a(coroutineContext, obj);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    /* renamed from: b */
    public static final Object m4423b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null && (obj = coroutineContext.fold(0, f4168b)) == null) {
            Intrinsics.throwNpe();
        }
        if (obj == 0) {
            return f4167a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new C2568w(coroutineContext, ((Number) obj).intValue()), f4170d);
        }
        if (obj != null) {
            return ((C2580p0) obj).mo35595a(coroutineContext);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
