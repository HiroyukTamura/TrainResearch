/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.af;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.r;
import kotlin.reflect.k;

@Metadata(bv={1, 0, 2}, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class ae {
    public static final ae a = new ae();
    private static final c b = c.f;

    private ae() {
    }

    private final String a(kotlin.reflect.jvm.internal.impl.a.a a2) {
        if (a2 instanceof ai) {
            return this.a((ai)a2);
        }
        if (a2 instanceof t) {
            return this.a((t)a2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal callable: ");
        stringBuilder.append(a2);
        throw (Throwable)new IllegalStateException(stringBuilder.toString().toString());
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.a.a a2) {
        al al2 = a2.e();
        a2 = a2.d();
        this.a(stringBuilder, al2);
        boolean bl2 = al2 != null && a2 != null;
        if (bl2) {
            stringBuilder.append("(");
        }
        this.a(stringBuilder, (al)a2);
        if (bl2) {
            stringBuilder.append(")");
        }
    }

    private final void a(StringBuilder stringBuilder, al a2) {
        if (a2 != null) {
            a2 = a2.r();
            j.a((Object)a2, "receiver.type");
            stringBuilder.append(this.a((w)a2));
            stringBuilder.append(".");
        }
    }

    public final String a(ai object) {
        j.b(object, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = object.s() ? "var " : "val ";
        stringBuilder.append((String)object2);
        a.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a)object);
        object2 = b;
        f f2 = object.h_();
        j.a((Object)f2, "descriptor.name");
        stringBuilder.append(((c)object2).a(f2, true));
        stringBuilder.append(": ");
        object2 = a;
        object = object.r();
        j.a(object, "descriptor.type");
        stringBuilder.append(((ae)object2).a((w)object));
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final String a(as var1_1) {
        j.b(var1_1, "typeParameter");
        var3_2 = new StringBuilder();
        var2_3 = var1_1.k();
        switch (af.b[var2_3.ordinal()]) {
            default: {
                break;
            }
            case 3: {
                var2_4 = "out ";
                ** GOTO lbl12
            }
            case 2: {
                var2_5 = "in ";
lbl12: // 2 sources:
                var3_2.append((String)var2_6);
            }
            case 1: 
        }
        var3_2.append(var1_1.h_());
        var1_1 = var3_2.toString();
        j.a(var1_1, "StringBuilder().apply(builderAction).toString()");
        return var1_1;
    }

    public final String a(t object) {
        j.b(object, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fun ");
        a.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a)object);
        Object object2 = b;
        f f2 = object.h_();
        j.a((Object)f2, "descriptor.name");
        stringBuilder.append(((c)object2).a(f2, true));
        object2 = object.i();
        j.a(object2, "descriptor.valueParameters");
        m.a((Iterable)object2, stringBuilder, ", ", "(", ")", 0, null, a.a, 48, null);
        stringBuilder.append(": ");
        object2 = a;
        object = object.g();
        if (object == null) {
            j.a();
        }
        j.a(object, "descriptor.returnType!!");
        stringBuilder.append(((ae)object2).a((w)object));
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public final String a(w w2) {
        j.b(w2, "type");
        return b.a(w2);
    }

    public final String a(r object) {
        StringBuilder stringBuilder;
        block5 : {
            j.b(object, "parameter");
            stringBuilder = new StringBuilder();
            Object object2 = ((r)object).d();
            switch (af.a[((Enum)object2).ordinal()]) {
                default: {
                    break block5;
                }
                case 3: {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("parameter #");
                    ((StringBuilder)object2).append(((r)object).a());
                    ((StringBuilder)object2).append(' ');
                    ((StringBuilder)object2).append(((r)object).b());
                    object2 = ((StringBuilder)object2).toString();
                    break;
                }
                case 2: {
                    object2 = "instance";
                    break;
                }
                case 1: {
                    object2 = "extension receiver";
                }
            }
            stringBuilder.append((String)object2);
        }
        stringBuilder.append(" of ");
        stringBuilder.append(a.a(((r)object).f().c()));
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public final String b(t object) {
        j.b(object, "invoke");
        StringBuilder stringBuilder = new StringBuilder();
        a.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a)object);
        Object object2 = object.i();
        j.a(object2, "invoke.valueParameters");
        m.a((Iterable)object2, stringBuilder, ", ", "(", ")", 0, null, b.a, 48, null);
        stringBuilder.append(" -> ");
        object2 = a;
        object = object.g();
        if (object == null) {
            j.a();
        }
        j.a(object, "invoke.returnType!!");
        stringBuilder.append(((ae)object2).a((w)object));
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

}

