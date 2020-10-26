/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.LinkedList;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.e;

public final class d
implements c {
    private final a.aa a;
    private final a.y b;

    public d(a.aa aa2, a.y y2) {
        j.b(aa2, "strings");
        j.b(y2, "qualifiedNames");
        this.a = aa2;
        this.b = y2;
    }

    private final r<List<String>, List<String>, Boolean> d(int n2) {
        LinkedList<Object> linkedList = new LinkedList<Object>();
        LinkedList<Object> linkedList2 = new LinkedList<Object>();
        boolean bl2 = false;
        while (n2 != -1) {
            a.y.b b2 = this.b.a(n2);
            Object object = this.a;
            j.a((Object)b2, "proto");
            object = ((a.aa)object).a(b2.g());
            a.y.b.b b3 = b2.k();
            if (b3 == null) {
                j.a();
            }
            switch (e.a[b3.ordinal()]) {
                default: {
                    break;
                }
                case 3: {
                    linkedList2.addFirst(object);
                    bl2 = true;
                    break;
                }
                case 2: {
                    linkedList.addFirst(object);
                    break;
                }
                case 1: {
                    linkedList2.addFirst(object);
                }
            }
            n2 = b2.e();
        }
        return new r<List<String>, List<String>, Boolean>(linkedList, linkedList2, bl2);
    }

    @Override
    public String a(int n2) {
        String string2 = this.a.a(n2);
        j.a((Object)string2, "strings.getString(index)");
        return string2;
    }

    @Override
    public String b(int n2) {
        Object object = this.d(n2);
        List<String> list = ((r)object).d();
        object = m.a(((r)object).e(), ".", null, null, 0, null, null, 62, null);
        if (list.isEmpty()) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m.a(list, "/", null, null, 0, null, null, 62, null));
        stringBuilder.append('/');
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    @Override
    public boolean c(int n2) {
        return this.d(n2).c();
    }
}

