/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.c.b.r;
import kotlin.t;

public final class u {
    public static final u a = new u();

    private u() {
    }

    private final String d(String string2) {
        CharSequence charSequence = string2;
        if (string2.length() > 1) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append('L');
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(';');
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final String a(String string2) {
        j.b(string2, "name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java/lang/");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final String a(String string2, String string3) {
        j.b(string2, "internalName");
        j.b(string3, "jvmDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final String a(String string2, List<String> list, String string3) {
        j.b(string2, "name");
        j.b(list, "parameters");
        j.b(string3, "ret");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append('(');
        stringBuilder.append(m.a(list, "", null, null, 0, null, a.a, 30, null));
        stringBuilder.append(')');
        stringBuilder.append(this.d(string3));
        return stringBuilder.toString();
    }

    public final String a(e e2, String string2) {
        j.b(e2, "classDescriptor");
        j.b(string2, "jvmDescriptor");
        return this.a(r.a(e2), string2);
    }

    public final /* varargs */ LinkedHashSet<String> a(String string2, String ... arrstring) {
        j.b(string2, "name");
        j.b(arrstring, "signatures");
        return this.c(this.a(string2), Arrays.copyOf(arrstring, arrstring.length));
    }

    public final /* varargs */ String[] a(String ... arrstring) {
        j.b(arrstring, "signatures");
        Collection collection = new ArrayList(arrstring.length);
        for (String string2 : arrstring) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<init>(");
            stringBuilder.append(string2);
            stringBuilder.append(")V");
            collection.add(stringBuilder.toString());
        }
        arrstring = ((Collection)((List)collection)).toArray(new String[0]);
        if (arrstring != null) {
            return arrstring;
        }
        throw new t("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String b(String string2) {
        j.b(string2, "name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java/util/");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final /* varargs */ LinkedHashSet<String> b(String string2, String ... arrstring) {
        j.b(string2, "name");
        j.b(arrstring, "signatures");
        return this.c(this.b(string2), Arrays.copyOf(arrstring, arrstring.length));
    }

    public final String c(String string2) {
        j.b(string2, "name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java/util/function/");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final /* varargs */ LinkedHashSet<String> c(String string2, String ... arrstring) {
        j.b(string2, "internalName");
        j.b(arrstring, "signatures");
        Collection collection = new LinkedHashSet();
        for (String string3 : arrstring) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(".");
            stringBuilder.append(string3);
            collection.add(stringBuilder.toString());
        }
        return (LinkedHashSet)collection;
    }

}

