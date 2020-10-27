package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.text.Typography;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.a */
public abstract class C2519a<T> extends C1113f0 implements C1111a0, Continuation<T>, C2492B {

    /* renamed from: b */
    private final CoroutineContext f4134b;
    @JvmField

    /* renamed from: c */
    protected final CoroutineContext f4135c;

    public C2519a(CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.f4135c = coroutineContext;
        this.f4134b = coroutineContext.plus(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo21836a() {
        return getClass().getSimpleName() + " was cancelled";
    }

    /* renamed from: c */
    public final void mo21847c(Throwable th) {
        C1532a.m2140a(this.f4134b, th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo21850d(Object obj) {
        if (obj instanceof C2579p) {
            C2579p pVar = (C2579p) obj;
            Throwable th = pVar.f4218a;
            pVar.mo35592a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo35496e(Object obj) {
        mo21838a(obj);
    }

    /* renamed from: g */
    public String mo21853g() {
        String a = C2606v.m4551a(this.f4134b);
        if (a == null) {
            return super.mo21853g();
        }
        return Typography.quote + a + "\":" + super.mo21853g();
    }

    public final CoroutineContext getContext() {
        return this.f4134b;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f4134b;
    }

    /* renamed from: i */
    public final void mo21854i() {
        mo35530k();
    }

    public boolean isActive() {
        return super.isActive();
    }

    /* renamed from: j */
    public final void mo35529j() {
        mo21839a((C1111a0) this.f4135c.get(C1111a0.f916k));
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo35530k() {
    }

    public final void resumeWith(Object obj) {
        Object c = mo21846c(C1532a.m2148c(obj));
        if (c != C2533g0.f4150b) {
            mo35496e(c);
        }
    }
}
