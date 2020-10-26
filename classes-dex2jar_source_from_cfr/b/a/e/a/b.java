/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.a;

import b.a.c.e;
import b.a.f.a;
import java.util.concurrent.atomic.AtomicReference;

public enum b implements b.a.b.b
{
    a;
    

    public static boolean a(b.a.b.b b2, b.a.b.b b3) {
        if (b3 == null) {
            a.a(new NullPointerException("next is null"));
            return false;
        }
        if (b2 != null) {
            b3.a();
            b.b();
            return false;
        }
        return true;
    }

    public static boolean a(AtomicReference<b.a.b.b> object) {
        b b2;
        b.a.b.b b3 = ((AtomicReference)object).get();
        if (b3 != (b2 = a) && (object = ((AtomicReference)object).getAndSet((b.a.b.b)b2)) != b2) {
            if (object != null) {
                object.a();
            }
            return true;
        }
        return false;
    }

    public static boolean a(AtomicReference<b.a.b.b> atomicReference, b.a.b.b b2) {
        b.a.e.b.b.a(b2, "d is null");
        if (!atomicReference.compareAndSet(null, b2)) {
            b2.a();
            if (atomicReference.get() != a) {
                b.b();
            }
            return false;
        }
        return true;
    }

    public static void b() {
        a.a(new e("Disposable already set!"));
    }

    @Override
    public void a() {
    }
}

