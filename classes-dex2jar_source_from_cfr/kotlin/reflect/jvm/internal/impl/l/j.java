/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.g;
import kotlin.e.b.a.d;
import kotlin.e.b.z;
import kotlin.t;

public final class j<T>
extends AbstractSet<T> {
    public static final b a = new b(null);
    private static final int d = 5;
    private Object b;
    private int c;

    static {
        d = 5;
    }

    private j() {
    }

    public /* synthetic */ j(kotlin.e.b.g g2) {
        this();
    }

    public static final <T> j<T> b() {
        return a.a();
    }

    public int a() {
        return this.c;
    }

    public void a(int n2) {
        this.c = n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean add(T var1_1) {
        block8 : {
            block9 : {
                block7 : {
                    if (this.size() != 0) break block7;
                    this.b = var1_1 /* !! */ ;
                    break block8;
                }
                if (this.size() != 1) break block9;
                if (kotlin.e.b.j.a(this.b, var1_1 /* !! */ )) {
                    return false;
                }
                var2_6 = new Object[]{this.b, var1_1 /* !! */ };
                var1_2 = var2_6;
                ** GOTO lbl25
            }
            if (this.size() < j.d) {
                var2_7 = this.b;
                if (var2_7 == null) throw new t("null cannot be cast to non-null type kotlin.Array<T>");
                if (g.a(var2_7 = (Object[])var2_7, var1_1 /* !! */ )) {
                    return false;
                }
                if (this.size() == j.d - 1) {
                    var2_7 = al.b(Arrays.copyOf(var2_7, ((Object[])var2_7).length));
                    var2_7.add(var1_1 /* !! */ );
                    var1_4 = var2_7;
                } else {
                    var2_7 = Arrays.copyOf(var2_7, this.size() + 1);
                    var2_7[((Object)var2_7).length - 1] = var1_1 /* !! */ ;
                    var1_5 = var2_7;
                }
lbl25: // 3 sources:
                this.b = var1_3;
            } else {
                var2_8 = this.b;
                if (var2_8 == null) throw new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                if (!z.c(var2_8).add(var1_1 /* !! */ )) {
                    return false;
                }
            }
        }
        this.a(this.size() + 1);
        return true;
    }

    @Override
    public void clear() {
        this.b = null;
        this.a(0);
    }

    @Override
    public boolean contains(Object object) {
        if (this.size() == 0) {
            return false;
        }
        if (this.size() == 1) {
            return kotlin.e.b.j.a(this.b, object);
        }
        if (this.size() < d) {
            Object object2 = this.b;
            if (object2 != null) {
                return g.a((Object[])object2, object);
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object object3 = this.b;
        if (object3 != null) {
            return ((Set)object3).contains(object);
        }
        throw new t("null cannot be cast to non-null type kotlin.collections.Set<T>");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Iterator<T> iterator() {
        Object object;
        Object object2;
        if (this.size() == 0) {
            object2 = Collections.emptySet();
            do {
                return object2.iterator();
                break;
            } while (true);
        }
        if (this.size() == 1) {
            object = new c<Object>(this.b);
            do {
                return (Iterator)object;
                break;
            } while (true);
        }
        if (this.size() < d) {
            object = this.b;
            if (object == null) throw new t("null cannot be cast to non-null type kotlin.Array<T>");
            object = new a<Object>((Object[])object);
            return (Iterator)object;
        }
        object2 = this.b;
        if (object2 == null) throw new t("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
        object2 = z.c(object2);
        return object2.iterator();
    }

    @Override
    public final int size() {
        return this.a();
    }

    private static final class a<T>
    implements Iterator<T>,
    d {
        private final Iterator<T> a;

        public a(T[] arrT) {
            kotlin.e.b.j.b(arrT, "array");
            this.a = kotlin.e.b.b.a(arrT);
        }

        public Void a() {
            throw (Throwable)new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override
        public T next() {
            return this.a.next();
        }

        @Override
        public /* synthetic */ void remove() {
            this.a();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.e.b.g g2) {
            this();
        }

        public final <T> j<T> a() {
            return new j(null);
        }

        public final <T> j<T> a(Collection<? extends T> collection) {
            kotlin.e.b.j.b(collection, "set");
            j j2 = new j(null);
            j2.addAll(collection);
            return j2;
        }
    }

    private static final class c<T>
    implements Iterator<T>,
    d {
        private boolean a;
        private final T b;

        public c(T t2) {
            this.b = t2;
            this.a = true;
        }

        public Void a() {
            throw (Throwable)new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return this.a;
        }

        @Override
        public T next() {
            if (this.a) {
                this.a = false;
                return this.b;
            }
            throw (Throwable)new NoSuchElementException();
        }

        @Override
        public /* synthetic */ void remove() {
            this.a();
        }
    }

}

