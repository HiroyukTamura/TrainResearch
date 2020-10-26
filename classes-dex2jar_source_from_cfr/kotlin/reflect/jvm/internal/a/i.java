/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimeErrorReporter;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter;", "()V", "reportCannotInferVisibility", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "reportIncompleteHierarchy", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "unresolvedSuperClasses", "", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class i
implements p {
    public static final i a = new i();

    private i() {
    }

    @Override
    public void a(b b2) {
        j.b(b2, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot infer visibility for ");
        stringBuilder.append(b2);
        throw (Throwable)new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void a(e e2, List<String> list) {
        j.b(e2, "descriptor");
        j.b(list, "unresolvedSuperClasses");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Incomplete hierarchy for class ");
        stringBuilder.append(e2.h_());
        stringBuilder.append(", unresolved classes ");
        stringBuilder.append(list);
        throw (Throwable)new IllegalStateException(stringBuilder.toString());
    }
}

