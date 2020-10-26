/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.d;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.e.b;

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean");
    public static final /* enum */ c b = new c(PrimitiveType.CHAR, "char", "C", "java.lang.Character");
    public static final /* enum */ c c = new c(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte");
    public static final /* enum */ c d = new c(PrimitiveType.SHORT, "short", "S", "java.lang.Short");
    public static final /* enum */ c e = new c(PrimitiveType.INT, "int", "I", "java.lang.Integer");
    public static final /* enum */ c f = new c(PrimitiveType.FLOAT, "float", "F", "java.lang.Float");
    public static final /* enum */ c g = new c(PrimitiveType.LONG, "long", "J", "java.lang.Long");
    public static final /* enum */ c h = new c(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    private static final Set<b> i;
    private static final Map<String, c> j;
    private static final Map<PrimitiveType, c> k;
    private static final /* synthetic */ c[] p;
    private final PrimitiveType l;
    private final String m;
    private final String n;
    private final b o;

    static {
        c[] arrc = a;
        p = new c[]{arrc, b, c, d, e, f, g, h};
        i = new HashSet<b>();
        j = new HashMap<String, c>();
        k = new EnumMap<PrimitiveType, c>(PrimitiveType.class);
        for (c c2 : c.values()) {
            i.add(c2.d());
            j.put(c2.b(), c2);
            k.put(c2.a(), c2);
        }
    }

    private c(PrimitiveType primitiveType, String string3, String string4, String string5) {
        this.l = primitiveType;
        this.m = string3;
        this.n = string4;
        this.o = new b(string5);
    }

    public static c a(String string2) {
        Object object = j.get(string2);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Non-primitive type name passed: ");
        ((StringBuilder)object).append(string2);
        throw new AssertionError((Object)((StringBuilder)object).toString());
    }

    public static c a(PrimitiveType primitiveType) {
        return k.get((Object)primitiveType);
    }

    public static c valueOf(String string2) {
        return Enum.valueOf(c.class, string2);
    }

    public static c[] values() {
        return (c[])p.clone();
    }

    public PrimitiveType a() {
        return this.l;
    }

    public String b() {
        return this.m;
    }

    public String c() {
        return this.n;
    }

    public b d() {
        return this.o;
    }
}

