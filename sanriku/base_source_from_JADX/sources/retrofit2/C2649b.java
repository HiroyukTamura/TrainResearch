package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* renamed from: retrofit2.b */
/* compiled from: lambda */
public final /* synthetic */ class C2649b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.C26381 f4365a;

    /* renamed from: b */
    private final /* synthetic */ Callback f4366b;

    /* renamed from: c */
    private final /* synthetic */ Throwable f4367c;

    public /* synthetic */ C2649b(DefaultCallAdapterFactory.ExecutorCallbackCall.C26381 r1, Callback callback, Throwable th) {
        this.f4365a = r1;
        this.f4366b = callback;
        this.f4367c = th;
    }

    public final void run() {
        this.f4365a.mo35681a(this.f4366b, this.f4367c);
    }
}
