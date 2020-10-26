/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import kotlin.e.b.m;
import kotlin.reflect.e;
import kotlin.reflect.i;
import kotlin.reflect.n;

public class n
extends m {
    private final e c;
    private final String d;
    private final String e;

    public n(e e2, String string2, String string3) {
        this.c = e2;
        this.d = string2;
        this.e = string3;
    }

    public void a(Object object, Object object2) {
        this.l().a(object, object2);
    }

    @Override
    public Object b(Object object) {
        return this.a().a(new Object[]{object});
    }

    @Override
    public e f() {
        return this.c;
    }

    @Override
    public String g() {
        return this.d;
    }

    @Override
    public String h() {
        return this.e;
    }
}

