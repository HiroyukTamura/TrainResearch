package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C2537i0;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: kotlinx.coroutines.android.a */
public final class C2520a extends C2521b {
    private volatile C2520a _immediate;

    /* renamed from: a */
    private final C2520a f4136a;

    /* renamed from: b */
    private final Handler f4137b;

    /* renamed from: c */
    private final String f4138c;

    /* renamed from: d */
    private final boolean f4139d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2520a(Handler handler, String str) {
        this(handler, str, false);
        Intrinsics.checkParameterIsNotNull(handler, "handler");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private C2520a(Handler handler, String str, boolean z) {
        super((DefaultConstructorMarker) null);
        C2520a aVar = null;
        this.f4137b = handler;
        this.f4138c = str;
        this.f4139d = z;
        this._immediate = z ? this : aVar;
        C2520a aVar2 = this._immediate;
        if (aVar2 == null) {
            aVar2 = new C2520a(this.f4137b, this.f4138c, true);
            this._immediate = aVar2;
        }
        this.f4136a = aVar2;
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        this.f4137b.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2520a) && ((C2520a) obj).f4137b == this.f4137b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f4137b);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return !this.f4139d || (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) this.f4137b.getLooper()) ^ true);
    }

    /* renamed from: o */
    public C2537i0 mo35536o() {
        return this.f4136a;
    }

    public String toString() {
        String str = this.f4138c;
        if (str != null) {
            return this.f4139d ? C0681a.m324a(new StringBuilder(), this.f4138c, " [immediate]") : str;
        }
        String handler = this.f4137b.toString();
        Intrinsics.checkExpressionValueIsNotNull(handler, "handler.toString()");
        return handler;
    }
}
