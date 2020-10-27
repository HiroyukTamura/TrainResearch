package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.C2562q;
import p009e.p028d.p030b.p054b.C1532a;

@PublishedApi
/* renamed from: kotlinx.coroutines.g */
public class C2532g<T> extends C2501J<T> implements C2531f<T>, CoroutineStackFrame {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f4145f = AtomicIntegerFieldUpdater.newUpdater(C2532g.class, "_decision");

    /* renamed from: g */
    private static final AtomicReferenceFieldUpdater f4146g = AtomicReferenceFieldUpdater.newUpdater(C2532g.class, Object.class, "_state");
    private volatile int _decision = 0;
    private volatile Object _parentHandle = null;
    private volatile Object _state = C2523b.f4140a;

    /* renamed from: d */
    private final CoroutineContext f4147d;

    /* renamed from: e */
    private final Continuation<T> f4148e;

    public C2532g(Continuation<? super T> continuation, int i) {
        super(i);
        this.f4148e = continuation;
        this.f4147d = continuation.getContext();
    }

    /* renamed from: a */
    private final void m4392a(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    /* renamed from: e */
    private final void m4393e() {
        if (!m4394f()) {
            C1110L l = (C1110L) this._parentHandle;
            if (l != null) {
                l.mo21829b();
            }
            this._parentHandle = C2571k0.f4212a;
        }
    }

    /* renamed from: f */
    private final boolean m4394f() {
        Continuation<T> continuation = this.f4148e;
        return (continuation instanceof C2498G) && ((C2498G) continuation).mo35492a((C2532g<?>) this);
    }

    /* renamed from: a */
    public <T> T mo35498a(Object obj) {
        return obj instanceof C2581q ? ((C2581q) obj).f4219a : obj instanceof C2583r ? ((C2583r) obj).f4222a : obj;
    }

    /* renamed from: a */
    public final Continuation<T> mo35490a() {
        return this.f4148e;
    }

    /* renamed from: a */
    public boolean mo35544a(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof C2572l0)) {
                return false;
            }
            z = obj instanceof C2529e;
        } while (!f4146g.compareAndSet(this, obj, new C2534h(this, th, z)));
        if (z) {
            try {
                ((C2529e) obj).mo35527a(th);
            } catch (Throwable th2) {
                CoroutineContext coroutineContext = this.f4147d;
                C1532a.m2140a(coroutineContext, (Throwable) new C2587t("Exception in cancellation handler for " + this, th2));
            }
        }
        m4393e();
        m4391a(0);
        return true;
    }

    /* renamed from: b */
    public final void mo35545b(Throwable th) {
        boolean z = false;
        if (this.f4113c == 0) {
            Continuation<T> continuation = this.f4148e;
            if (!(continuation instanceof C2498G)) {
                continuation = null;
            }
            C2498G g = (C2498G) continuation;
            if (g != null) {
                z = g.mo35491a(th);
            }
        }
        if (!z) {
            mo35544a(th);
            m4393e();
        }
    }

    /* renamed from: c */
    public final void mo35546c() {
        C1110L l = (C1110L) this._parentHandle;
        if (l != null) {
            l.mo21829b();
        }
        this._parentHandle = C2571k0.f4212a;
    }

    @PublishedApi
    /* renamed from: d */
    public final Object mo35547d() {
        boolean z;
        C1111a0 a0Var;
        C1111a0 a0Var2;
        Throwable a;
        boolean z2 = !(this._state instanceof C2572l0);
        if (this.f4113c == 0) {
            Continuation<T> continuation = this.f4148e;
            if (!(continuation instanceof C2498G)) {
                continuation = null;
            }
            C2498G g = (C2498G) continuation;
            if (!(g == null || (a = g.mo35489a((C2531f<?>) this)) == null)) {
                if (!z2) {
                    mo35544a(a);
                }
                z2 = true;
            }
        }
        if (!z2 && ((C1110L) this._parentHandle) == null && (a0Var2 = (C1111a0) this.f4148e.getContext().get(C1111a0.f916k)) != null) {
            a0Var2.start();
            C1110L a2 = C1532a.m2133a(a0Var2, true, false, new C2536i(a0Var2, this), 2, (Object) null);
            this._parentHandle = a2;
            if ((!(this._state instanceof C2572l0)) && !m4394f()) {
                a2.mo21829b();
                this._parentHandle = C2571k0.f4212a;
            }
        }
        while (true) {
            int i = this._decision;
            z = false;
            if (i == 0) {
                if (f4145f.compareAndSet(this, 0, 1)) {
                    z = true;
                    break;
                }
            } else if (i != 2) {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object obj = this._state;
        if (obj instanceof C2579p) {
            Throwable th = ((C2579p) obj).f4218a;
            if (C2496E.m4308d()) {
                th = C2562q.m4462a(th, this);
            }
            throw th;
        } else if (this.f4113c != 1 || (a0Var = (C1111a0) this.f4147d.get(C1111a0.f916k)) == null || a0Var.isActive()) {
            return mo35498a(obj);
        } else {
            Throwable h = a0Var.mo21833h();
            mo35499a(obj, h);
            if (C2496E.m4308d()) {
                h = C2562q.m4462a(h, this);
            }
            throw h;
        }
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f4148e;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    public CoroutineContext getContext() {
        return this.f4147d;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object obj) {
        Object obj2;
        Throwable r0 = Result.m4631exceptionOrNullimpl(obj);
        if (r0 != null) {
            if (C2496E.m4308d()) {
                r0 = C2562q.m4462a(r0, this);
            }
            obj = new C2579p(r0, false, 2);
        }
        int i = this.f4113c;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof C2572l0)) {
                if (!(obj2 instanceof C2534h) || !((C2534h) obj2).mo35549c()) {
                    throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
                }
                return;
            }
        } while (!f4146g.compareAndSet(this, obj2, obj));
        m4393e();
        m4391a(i);
    }

    public String toString() {
        return "CancellableContinuation" + '(' + C1532a.m2132a((Continuation<?>) this.f4148e) + "){" + this._state + "}@" + C1532a.m2147b(this);
    }

    /* renamed from: a */
    public void mo35499a(Object obj, Throwable th) {
        if (obj instanceof C2583r) {
            try {
                ((C2583r) obj).f4223b.invoke(th);
            } catch (Throwable th2) {
                CoroutineContext coroutineContext = this.f4147d;
                C1532a.m2140a(coroutineContext, (Throwable) new C2587t("Exception in cancellation handler for " + this, th2));
            }
        }
    }

    /* renamed from: b */
    public Object mo35493b() {
        return this._state;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m4391a(int r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r5._decision
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0017
            if (r0 != r3) goto L_0x000b
            r0 = 0
            goto L_0x0020
        L_0x000b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0017:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4145f
            boolean r0 = r0.compareAndSet(r5, r2, r1)
            if (r0 == 0) goto L_0x0000
            r0 = 1
        L_0x0020:
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            kotlin.coroutines.Continuation<T> r0 = r5.f4148e
            if (r6 == 0) goto L_0x0029
            if (r6 != r3) goto L_0x002a
        L_0x0029:
            r2 = 1
        L_0x002a:
            if (r2 == 0) goto L_0x007c
            boolean r2 = r0 instanceof kotlinx.coroutines.C2498G
            if (r2 == 0) goto L_0x007c
            boolean r2 = kotlinx.coroutines.C2527d.m4384a(r6)
            int r4 = r5.f4113c
            boolean r4 = kotlinx.coroutines.C2527d.m4384a(r4)
            if (r2 != r4) goto L_0x007c
            r6 = r0
            kotlinx.coroutines.G r6 = (kotlinx.coroutines.C2498G) r6
            kotlinx.coroutines.x r6 = r6.f4108g
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            boolean r2 = r6.isDispatchNeeded(r0)
            if (r2 == 0) goto L_0x004f
            r6.dispatch(r0, r5)
            goto L_0x007f
        L_0x004f:
            kotlinx.coroutines.q0 r6 = kotlinx.coroutines.C2582q0.f4221b
            kotlinx.coroutines.N r6 = kotlinx.coroutines.C2582q0.m4503a()
            boolean r0 = r6.mo35507p()
            if (r0 == 0) goto L_0x005f
            r6.mo35503a((kotlinx.coroutines.C2501J<?>) r5)
            goto L_0x007f
        L_0x005f:
            r6.mo35505b(r3)
            kotlin.coroutines.Continuation<T> r0 = r5.f4148e     // Catch:{ all -> 0x006e }
            kotlinx.coroutines.C2527d.m4383a(r5, r0, (int) r1)     // Catch:{ all -> 0x006e }
        L_0x0067:
            boolean r0 = r6.mo35509r()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x0067
            goto L_0x0073
        L_0x006e:
            r0 = move-exception
            r1 = 0
            r5.mo35500a((java.lang.Throwable) r0, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0077 }
        L_0x0073:
            r6.mo35504a((boolean) r3)
            goto L_0x007f
        L_0x0077:
            r0 = move-exception
            r6.mo35504a((boolean) r3)
            throw r0
        L_0x007c:
            kotlinx.coroutines.C2527d.m4383a(r5, r0, (int) r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2532g.m4391a(int):void");
    }

    /* renamed from: a */
    public void mo35543a(Function1<? super Throwable, Unit> function1) {
        Object obj;
        Throwable th = null;
        Object obj2 = null;
        do {
            obj = this._state;
            if (obj instanceof C2523b) {
                if (obj2 == null) {
                    obj2 = function1 instanceof C2529e ? (C2529e) function1 : new C2516X(function1);
                }
            } else if (obj instanceof C2529e) {
                m4392a(function1, obj);
                throw null;
            } else if (!(obj instanceof C2534h)) {
                return;
            } else {
                if (((C2534h) obj).mo35593b()) {
                    try {
                        if (!(obj instanceof C2579p)) {
                            obj = null;
                        }
                        C2579p pVar = (C2579p) obj;
                        if (pVar != null) {
                            th = pVar.f4218a;
                        }
                        function1.invoke(th);
                        return;
                    } catch (Throwable th2) {
                        C1532a.m2140a(this.f4147d, (Throwable) new C2587t("Exception in cancellation handler for " + this, th2));
                        return;
                    }
                } else {
                    m4392a(function1, obj);
                    throw null;
                }
            }
        } while (!f4146g.compareAndSet(this, obj, obj2));
    }
}
