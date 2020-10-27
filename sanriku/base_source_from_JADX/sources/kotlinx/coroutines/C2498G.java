package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.C2542c;
import kotlinx.coroutines.internal.C2563r;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.G */
public final class C2498G<T> extends C2501J<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: i */
    private static final AtomicReferenceFieldUpdater f4104i = AtomicReferenceFieldUpdater.newUpdater(C2498G.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    @JvmField

    /* renamed from: d */
    public Object f4105d = C2499H.f4110a;

    /* renamed from: e */
    private final CoroutineStackFrame f4106e;
    @JvmField

    /* renamed from: f */
    public final Object f4107f;
    @JvmField

    /* renamed from: g */
    public final C1120x f4108g;
    @JvmField

    /* renamed from: h */
    public final Continuation<T> f4109h;

    public C2498G(C1120x xVar, Continuation<? super T> continuation) {
        super(0);
        this.f4108g = xVar;
        this.f4109h = continuation;
        Continuation<T> continuation2 = this.f4109h;
        this.f4106e = (CoroutineStackFrame) (!(continuation2 instanceof CoroutineStackFrame) ? null : continuation2);
        this.f4107f = C2542c.m4421a(getContext());
        this._reusableCancellableContinuation = null;
    }

    /* renamed from: a */
    public final Throwable mo35489a(C2531f<?> fVar) {
        C2563r rVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            rVar = C2499H.f4111b;
            if (obj != rVar) {
                if (obj == null) {
                    return null;
                }
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (f4104i.compareAndSet(this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!f4104i.compareAndSet(this, rVar, fVar));
        return null;
    }

    /* renamed from: a */
    public Continuation<T> mo35490a() {
        return this;
    }

    /* renamed from: a */
    public final boolean mo35491a(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (Intrinsics.areEqual(obj, (Object) C2499H.f4111b)) {
                if (f4104i.compareAndSet(this, C2499H.f4111b, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f4104i.compareAndSet(this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo35492a(C2532g<?> gVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof C2532g) || obj == gVar;
        }
        return false;
    }

    /* renamed from: b */
    public Object mo35493b() {
        Object obj = this.f4105d;
        if (C2496E.m4305a()) {
            if (!(obj != C2499H.f4110a)) {
                throw new AssertionError();
            }
        }
        this.f4105d = C2499H.f4110a;
        return obj;
    }

    /* renamed from: c */
    public final C2532g<?> mo35494c() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof C2532g)) {
            obj = null;
        }
        return (C2532g) obj;
    }

    public CoroutineStackFrame getCallerFrame() {
        return this.f4106e;
    }

    public CoroutineContext getContext() {
        return this.f4109h.getContext();
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object b;
        CoroutineContext context2 = this.f4109h.getContext();
        Object c = C1532a.m2148c(obj);
        if (this.f4108g.isDispatchNeeded(context2)) {
            this.f4105d = c;
            this.f4113c = 0;
            this.f4108g.dispatch(context2, this);
            return;
        }
        C2582q0 q0Var = C2582q0.f4221b;
        C2504N a = C2582q0.m4503a();
        if (a.mo35507p()) {
            this.f4105d = c;
            this.f4113c = 0;
            a.mo35503a((C2501J<?>) this);
            return;
        }
        a.mo35505b(true);
        try {
            context = getContext();
            b = C2542c.m4423b(context, this.f4107f);
            this.f4109h.resumeWith(obj);
            Unit unit = Unit.INSTANCE;
            C2542c.m4422a(context, b);
            do {
            } while (a.mo35509r());
        } catch (Throwable th) {
            try {
                mo35500a(th, (Throwable) null);
            } catch (Throwable th2) {
                a.mo35504a(true);
                throw th2;
            }
        }
        a.mo35504a(true);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("DispatchedContinuation[");
        a.append(this.f4108g);
        a.append(", ");
        a.append(C1532a.m2132a((Continuation<?>) this.f4109h));
        a.append(']');
        return a.toString();
    }
}
