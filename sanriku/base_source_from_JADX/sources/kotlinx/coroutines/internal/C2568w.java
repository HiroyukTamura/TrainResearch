package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* renamed from: kotlinx.coroutines.internal.w */
final class C2568w {

    /* renamed from: a */
    private Object[] f4208a;

    /* renamed from: b */
    private int f4209b;

    /* renamed from: c */
    private final CoroutineContext f4210c;

    public C2568w(CoroutineContext coroutineContext, int i) {
        this.f4210c = coroutineContext;
        this.f4208a = new Object[i];
    }

    /* renamed from: a */
    public final CoroutineContext mo35583a() {
        return this.f4210c;
    }

    /* renamed from: a */
    public final void mo35584a(Object obj) {
        Object[] objArr = this.f4208a;
        int i = this.f4209b;
        this.f4209b = i + 1;
        objArr[i] = obj;
    }

    /* renamed from: b */
    public final void mo35585b() {
        this.f4209b = 0;
    }

    /* renamed from: c */
    public final Object mo35586c() {
        Object[] objArr = this.f4208a;
        int i = this.f4209b;
        this.f4209b = i + 1;
        return objArr[i];
    }
}
