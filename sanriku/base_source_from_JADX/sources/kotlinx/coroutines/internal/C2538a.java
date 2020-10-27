package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlinx.coroutines.internal.a */
/* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
public final class C2538a extends Lambda implements Function1<Throwable, Throwable> {

    /* renamed from: a */
    public final /* synthetic */ int f4159a;

    /* renamed from: b */
    public final /* synthetic */ Object f4160b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2538a(int i, Object obj) {
        super(1);
        this.f4159a = i;
        this.f4160b = obj;
    }

    public final Object invoke(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        int i = this.f4159a;
        Throwable th = null;
        if (i == 0) {
            Throwable th2 = (Throwable) obj;
            try {
                Result.Companion companion = Result.Companion;
                Constructor constructor = (Constructor) this.f4160b;
                Object newInstance = constructor.newInstance(new Object[]{th2.getMessage(), th2});
                if (newInstance != null) {
                    obj2 = Result.m4628constructorimpl((Throwable) newInstance);
                    if (!Result.m4634isFailureimpl(obj2)) {
                        th = obj2;
                    }
                    return th;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4628constructorimpl(ResultKt.createFailure(th3));
            }
        } else if (i == 1) {
            Throwable th4 = (Throwable) obj;
            try {
                Result.Companion companion3 = Result.Companion;
                Object newInstance2 = ((Constructor) this.f4160b).newInstance(new Object[]{th4});
                if (newInstance2 != null) {
                    obj3 = Result.m4628constructorimpl((Throwable) newInstance2);
                    if (!Result.m4634isFailureimpl(obj3)) {
                        th = obj3;
                    }
                    return (Throwable) th;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th5) {
                Result.Companion companion4 = Result.Companion;
                obj3 = Result.m4628constructorimpl(ResultKt.createFailure(th5));
            }
        } else if (i == 2) {
            Throwable th6 = (Throwable) obj;
            try {
                Result.Companion companion5 = Result.Companion;
                Constructor constructor2 = (Constructor) this.f4160b;
                Object newInstance3 = constructor2.newInstance(new Object[]{th6.getMessage()});
                if (newInstance3 != null) {
                    Throwable th7 = (Throwable) newInstance3;
                    th7.initCause(th6);
                    obj4 = Result.m4628constructorimpl(th7);
                    if (!Result.m4634isFailureimpl(obj4)) {
                        th = obj4;
                    }
                    return (Throwable) th;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th8) {
                Result.Companion companion6 = Result.Companion;
                obj4 = Result.m4628constructorimpl(ResultKt.createFailure(th8));
            }
        } else if (i == 3) {
            Throwable th9 = (Throwable) obj;
            try {
                Result.Companion companion7 = Result.Companion;
                Object newInstance4 = ((Constructor) this.f4160b).newInstance(new Object[0]);
                if (newInstance4 != null) {
                    Throwable th10 = (Throwable) newInstance4;
                    th10.initCause(th9);
                    obj5 = Result.m4628constructorimpl(th10);
                    if (!Result.m4634isFailureimpl(obj5)) {
                        th = obj5;
                    }
                    return (Throwable) th;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th11) {
                Result.Companion companion8 = Result.Companion;
                obj5 = Result.m4628constructorimpl(ResultKt.createFailure(th11));
            }
        } else {
            throw null;
        }
    }
}
