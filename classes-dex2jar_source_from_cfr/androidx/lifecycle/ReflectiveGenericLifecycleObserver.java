/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.j;

class ReflectiveGenericLifecycleObserver
implements f {
    private final Object a;
    private final b.a b;

    ReflectiveGenericLifecycleObserver(Object object) {
        this.a = object;
        this.b = b.a.b(this.a.getClass());
    }

    @Override
    public void a(j j2, g.a a2) {
        this.b.a(j2, a2, this.a);
    }
}

