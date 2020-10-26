/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.c.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class ah {
    public static final /* synthetic */ String a(Method method) {
        return ah.b(method);
    }

    private static final String b(Method genericDeclaration) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(genericDeclaration.getName());
        Object[] arrobject = genericDeclaration.getParameterTypes();
        j.a(arrobject, "parameterTypes");
        stringBuilder.append(g.a(arrobject, "", "(", ")", 0, null, a.a, 24, null));
        genericDeclaration = genericDeclaration.getReturnType();
        j.a((Object)genericDeclaration, "returnType");
        stringBuilder.append(b.f(genericDeclaration));
        return stringBuilder.toString();
    }

}

