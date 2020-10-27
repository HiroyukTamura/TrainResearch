package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* renamed from: retrofit2.a */
/* compiled from: lambda */
public final /* synthetic */ class C2648a implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.C26381 f4362a;

    /* renamed from: b */
    private final /* synthetic */ Callback f4363b;

    /* renamed from: c */
    private final /* synthetic */ Response f4364c;

    public /* synthetic */ C2648a(DefaultCallAdapterFactory.ExecutorCallbackCall.C26381 r1, Callback callback, Response response) {
        this.f4362a = r1;
        this.f4363b = callback;
        this.f4364c = response;
    }

    public final void run() {
        this.f4362a.mo35682a(this.f4363b, this.f4364c);
    }
}
