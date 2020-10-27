package kotlinx.coroutines.p130u0;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C2497F;
import kotlinx.coroutines.C2511T;

/* renamed from: kotlinx.coroutines.u0.c */
public class C2595c extends C2511T {

    /* renamed from: a */
    private C2591a f4253a;

    /* renamed from: b */
    private final int f4254b;

    /* renamed from: c */
    private final int f4255c;

    /* renamed from: d */
    private final long f4256d;

    /* renamed from: e */
    private final String f4257e;

    public /* synthetic */ C2595c(int i, int i2, String str, int i3) {
        i = (i3 & 1) != 0 ? C2603k.f4269b : i;
        i2 = (i3 & 2) != 0 ? C2603k.f4270c : i2;
        str = (i3 & 4) != 0 ? "DefaultDispatcher" : str;
        long j = C2603k.f4271d;
        this.f4254b = i;
        this.f4255c = i2;
        this.f4256d = j;
        this.f4257e = str;
        this.f4253a = new C2591a(this.f4254b, this.f4255c, this.f4256d, this.f4257e);
    }

    /* renamed from: a */
    public final void mo35620a(Runnable runnable, C2601i iVar, boolean z) {
        try {
            this.f4253a.mo35600a(runnable, iVar, z);
        } catch (RejectedExecutionException unused) {
            C2497F.f4103g.mo35511a((Runnable) this.f4253a.mo35599a(runnable, iVar));
        }
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            C2591a.m4509a(this.f4253a, runnable, (C2601i) null, false, 6);
        } catch (RejectedExecutionException unused) {
            C2497F.f4103g.mo35511a(runnable);
        }
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            C2591a.m4509a(this.f4253a, runnable, (C2601i) null, true, 2);
        } catch (RejectedExecutionException unused) {
            C2497F.f4103g.dispatchYield(coroutineContext, runnable);
        }
    }
}
