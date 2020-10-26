/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/components/SignatureSerializer;", "", "()V", "constructorDesc", "", "constructor", "Ljava/lang/reflect/Constructor;", "fieldDesc", "field", "Ljava/lang/reflect/Field;", "methodDesc", "method", "Ljava/lang/reflect/Method;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
final class m {
    public static final m a = new m();

    private m() {
    }

    public final String a(Constructor<?> object) {
        j.b(object, "constructor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Class<?> class_ : object.getParameterTypes()) {
            j.a(class_, "parameterType");
            stringBuilder.append(b.f(class_));
        }
        stringBuilder.append(")V");
        object = stringBuilder.toString();
        j.a(object, "sb.toString()");
        return object;
    }

    public final String a(Field annotatedElement) {
        j.b(annotatedElement, "field");
        annotatedElement = annotatedElement.getType();
        j.a((Object)annotatedElement, "field.type");
        return b.f(annotatedElement);
    }

    public final String a(Method object) {
        j.b(object, "method");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Class<?> class_ : ((Method)object).getParameterTypes()) {
            j.a(class_, "parameterType");
            stringBuilder.append(b.f(class_));
        }
        stringBuilder.append(")");
        object = ((Method)object).getReturnType();
        j.a(object, "method.returnType");
        stringBuilder.append(b.f(object));
        object = stringBuilder.toString();
        j.a(object, "sb.toString()");
        return object;
    }
}

