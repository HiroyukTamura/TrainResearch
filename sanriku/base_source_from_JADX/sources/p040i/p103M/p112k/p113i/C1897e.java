package p040i.p103M.p112k.p113i;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.k.i.e */
public final class C1897e {

    /* renamed from: a */
    private final Method f2691a;

    /* renamed from: b */
    private final Method f2692b;

    /* renamed from: c */
    private final Method f2693c;

    public C1897e(Method method, Method method2, Method method3) {
        this.f2691a = method;
        this.f2692b = method2;
        this.f2693c = method3;
    }

    /* renamed from: a */
    public final Object mo27994a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "closer");
        Method method = this.f2691a;
        if (method != null) {
            try {
                Object invoke = method.invoke((Object) null, new Object[0]);
                Method method2 = this.f2692b;
                if (method2 == null) {
                    Intrinsics.throwNpe();
                }
                method2.invoke(invoke, new Object[]{str});
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public final boolean mo27995a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f2693c;
            if (method == null) {
                Intrinsics.throwNpe();
            }
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
