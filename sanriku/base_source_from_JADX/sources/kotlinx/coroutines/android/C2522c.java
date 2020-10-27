package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlinx.coroutines.android.c */
public final class C2522c {
    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            obj = Result.m4628constructorimpl(new C2520a(m4376a(mainLooper, true), "Main"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4628constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4634isFailureimpl(obj)) {
            obj = null;
        }
        C2521b bVar = (C2521b) obj;
    }

    @VisibleForTesting
    /* renamed from: a */
    public static final Handler m4376a(Looper looper, boolean z) {
        Intrinsics.checkParameterIsNotNull(looper, "$this$asHandler");
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
        }
        Class<Handler> cls = Handler.class;
        try {
            Constructor<Handler> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});
            Intrinsics.checkExpressionValueIsNotNull(declaredConstructor, "Handler::class.java.getD…:class.javaPrimitiveType)");
            Handler newInstance = declaredConstructor.newInstance(new Object[]{looper, null, true});
            Intrinsics.checkExpressionValueIsNotNull(newInstance, "constructor.newInstance(this, null, true)");
            return newInstance;
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
