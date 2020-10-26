/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.g.d;
import kotlin.i.n;
import kotlin.w;

public final class c {
    public static final c a;
    private static final Map<String, String> b;

    static {
        CharSequence charSequence;
        StringBuilder stringBuilder;
        a = new c();
        final Map map = new LinkedHashMap();
        Object object = m.b("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        Iterator<String> iterator = d.a(m.a((Collection)object), 2);
        int n2 = ((kotlin.g.a)((Object)iterator)).a();
        int n3 = ((kotlin.g.a)((Object)iterator)).b();
        int n4 = ((kotlin.g.a)((Object)iterator)).c();
        if (n4 > 0 ? n2 <= n3 : n2 >= n3) {
            do {
                iterator = new StringBuilder();
                ((StringBuilder)((Object)iterator)).append("kotlin/");
                ((StringBuilder)((Object)iterator)).append((String)object.get(n2));
                iterator = ((StringBuilder)((Object)iterator)).toString();
                int n5 = n2 + 1;
                map.put(iterator, object.get(n5));
                iterator = new StringBuilder();
                ((StringBuilder)((Object)iterator)).append("kotlin/");
                ((StringBuilder)((Object)iterator)).append((String)object.get(n2));
                ((StringBuilder)((Object)iterator)).append("Array");
                iterator = ((StringBuilder)((Object)iterator)).toString();
                StringBuilder charSequence22 = new StringBuilder();
                charSequence22.append('[');
                charSequence22.append((String)object.get(n5));
                map.put(iterator, charSequence22.toString());
                if (n2 == n3) break;
                n2 += n4;
            } while (true);
        }
        map.put("kotlin/Unit", "V");
        object = new kotlin.e.a.m<String, String, w>(){

            @Override
            public final void a(String string2, String string3) {
                j.b(string2, "kotlinSimpleName");
                j.b(string3, "javaInternalName");
                Map map2 = map;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("kotlin/");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append('L');
                stringBuilder.append(string3);
                stringBuilder.append(';');
                map2.put(string2, stringBuilder.toString());
            }
        };
        object.a("Any", "java/lang/Object");
        object.a("Nothing", "java/lang/Void");
        object.a("Annotation", "java/lang/annotation/Annotation");
        for (String string2 : m.b("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("java/lang/");
            ((StringBuilder)charSequence).append(string2);
            object.a(string2, ((StringBuilder)charSequence).toString());
        }
        for (String string3 : m.b("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("collections/");
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("java/util/");
            stringBuilder.append(string3);
            object.a((String)charSequence, stringBuilder.toString());
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("collections/Mutable");
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("java/util/");
            stringBuilder.append(string3);
            object.a((String)charSequence, stringBuilder.toString());
        }
        object.a("collections/Iterable", "java/lang/Iterable");
        object.a("collections/MutableIterable", "java/lang/Iterable");
        object.a("collections/Map.Entry", "java/util/Map$Entry");
        object.a("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (n2 = 0; n2 <= 22; ++n2) {
            iterator = new StringBuilder();
            ((StringBuilder)((Object)iterator)).append("Function");
            ((StringBuilder)((Object)iterator)).append(n2);
            iterator = ((StringBuilder)((Object)iterator)).toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("kotlin/jvm/functions/Function");
            stringBuilder2.append(n2);
            object.a((String)((Object)iterator), stringBuilder2.toString());
            iterator = new StringBuilder();
            ((StringBuilder)((Object)iterator)).append("reflect/KFunction");
            ((StringBuilder)((Object)iterator)).append(n2);
            object.a(((StringBuilder)((Object)iterator)).toString(), "kotlin/reflect/KFunction");
        }
        for (String string4 : m.b("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(".Companion");
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin/jvm/internal/");
            stringBuilder.append(string4);
            stringBuilder.append("CompanionObject");
            object.a((String)charSequence, stringBuilder.toString());
        }
        b = map;
    }

    private c() {
    }

    public static final String a(String string2) {
        j.b(string2, "classId");
        CharSequence charSequence = b.get(string2);
        if (charSequence != null) {
            return charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append('L');
        ((StringBuilder)charSequence).append(n.a(string2, '.', '$', false, 4, null));
        ((StringBuilder)charSequence).append(';');
        return ((StringBuilder)charSequence).toString();
    }

}

