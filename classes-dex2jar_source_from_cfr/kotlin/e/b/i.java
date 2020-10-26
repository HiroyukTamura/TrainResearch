/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import kotlin.e.b.c;
import kotlin.e.b.h;
import kotlin.e.b.j;
import kotlin.e.b.v;
import kotlin.reflect.b;
import kotlin.reflect.e;
import kotlin.reflect.f;

public class i
extends c
implements h,
f {
    private final int c;

    public i(int n2) {
        this.c = n2;
    }

    public i(int n2, Object object) {
        super(object);
        this.c = n2;
    }

    protected f a() {
        return (f)super.e();
    }

    @Override
    protected b b() {
        return v.a(this);
    }

    @Override
    protected /* synthetic */ b e() {
        return this.a();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof i) {
            object = (i)object;
            return (this.f() == null ? ((c)object).f() == null : this.f().equals(((c)object).f())) && this.g().equals(((c)object).g()) && this.h().equals(((c)object).h()) && j.a(this.c(), ((c)object).c());
        }
        if (object instanceof f) {
            return object.equals(this.d());
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.f() == null ? 0 : this.f().hashCode() * 31;
        return (n2 + this.g().hashCode()) * 31 + this.h().hashCode();
    }

    public String toString() {
        Object object = this.d();
        if (object != this) {
            return object.toString();
        }
        if ("<init>".equals(this.g())) {
            return "constructor (Kotlin reflection is not available)";
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("function ");
        ((StringBuilder)object).append(this.g());
        ((StringBuilder)object).append(" (Kotlin reflection is not available)");
        return ((StringBuilder)object).toString();
    }
}

