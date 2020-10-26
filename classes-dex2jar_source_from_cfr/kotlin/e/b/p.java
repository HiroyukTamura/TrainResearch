/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import kotlin.e.b.c;
import kotlin.e.b.j;
import kotlin.reflect.b;
import kotlin.reflect.e;
import kotlin.reflect.l;

public abstract class p
extends c
implements l {
    @Override
    protected /* synthetic */ b e() {
        return this.o();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof p) {
            object = (p)object;
            return this.f().equals(((c)object).f()) && this.g().equals(((c)object).g()) && this.h().equals(((c)object).h()) && j.a(this.c(), ((c)object).c());
        }
        if (object instanceof l) {
            return object.equals(this.d());
        }
        return false;
    }

    public int hashCode() {
        return (this.f().hashCode() * 31 + this.g().hashCode()) * 31 + this.h().hashCode();
    }

    protected l o() {
        return (l)super.e();
    }

    public String toString() {
        Object object = this.d();
        if (object != this) {
            return object.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("property ");
        ((StringBuilder)object).append(this.g());
        ((StringBuilder)object).append(" (Kotlin reflection is not available)");
        return ((StringBuilder)object).toString();
    }
}

