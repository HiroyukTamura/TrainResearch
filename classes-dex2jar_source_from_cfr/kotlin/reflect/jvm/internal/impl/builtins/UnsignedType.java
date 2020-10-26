/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class UnsignedType
extends Enum<UnsignedType> {
    public static final /* enum */ UnsignedType UBYTE;
    public static final /* enum */ UnsignedType UINT;
    public static final /* enum */ UnsignedType ULONG;
    public static final /* enum */ UnsignedType USHORT;
    private static final /* synthetic */ UnsignedType[] a;
    private final f b;
    private final f c;
    private final a d;
    private final a e;

    static {
        Object object = a.a("kotlin/UByte");
        j.a(object, "ClassId.fromString(\"kotlin/UByte\")");
        object = new UnsignedType((a)object);
        UBYTE = object;
        Object object2 = a.a("kotlin/UShort");
        j.a(object2, "ClassId.fromString(\"kotlin/UShort\")");
        object2 = new UnsignedType((a)object2);
        USHORT = object2;
        Object object3 = a.a("kotlin/UInt");
        j.a(object3, "ClassId.fromString(\"kotlin/UInt\")");
        object3 = new UnsignedType((a)object3);
        UINT = object3;
        Object object4 = a.a("kotlin/ULong");
        j.a(object4, "ClassId.fromString(\"kotlin/ULong\")");
        object4 = new UnsignedType((a)object4);
        ULONG = object4;
        a = new UnsignedType[]{object, object2, object3, object4};
    }

    protected UnsignedType(a a2) {
        j.b(a2, "classId");
        this.e = a2;
        this.b = this.e.c();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(this.b.a());
        ((StringBuilder)charSequence).append("Array");
        this.c = f.a(((StringBuilder)charSequence).toString());
        this.d = new a(this.e.a(), this.c);
    }

    public static UnsignedType valueOf(String string2) {
        return Enum.valueOf(UnsignedType.class, string2);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[])a.clone();
    }

    public final a getArrayClassId() {
        return this.d;
    }

    public final a getClassId() {
        return this.e;
    }

    public final f getTypeName() {
        return this.b;
    }
}

