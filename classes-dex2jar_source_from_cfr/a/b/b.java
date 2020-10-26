/*
 * Decompiled with CFR 0.139.
 */
package a.b;

import a.b.e;
import a.b.f;
import javax.a.a;

public final class b<T>
implements a<T> {
    static final /* synthetic */ boolean a;
    private static final Object b;
    private volatile a<T> c;
    private volatile Object d = b;

    static {
        a = b.class.desiredAssertionStatus() ^ true;
        b = new Object();
    }

    private b(a<T> a2) {
        if (!a && a2 == null) {
            throw new AssertionError();
        }
        this.c = a2;
    }

    public static Object a(Object object, Object object2) {
        boolean bl2 = object != b && !(object instanceof e);
        if (bl2) {
            if (object == object2) {
                return object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scoped provider was invoked recursively returning different results: ");
            stringBuilder.append(object);
            stringBuilder.append(" & ");
            stringBuilder.append(object2);
            stringBuilder.append(". This is likely due to a circular dependency.");
            throw new IllegalStateException(stringBuilder.toString());
        }
        return object2;
    }

    public static <P extends a<T>, T> a<T> a(P p2) {
        f.a(p2);
        if (p2 instanceof b) {
            return p2;
        }
        return new b<T>(p2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public T b() {
        Object object = this.d;
        if (object != b) {
            return (T)object;
        }
        synchronized (this) {
            Object object2;
            object = object2 = this.d;
            if (object2 == b) {
                object = this.c.b();
                this.d = b.a(this.d, object);
                this.c = null;
            }
            return (T)object;
        }
    }
}

