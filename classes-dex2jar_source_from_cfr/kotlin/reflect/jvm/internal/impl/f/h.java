/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.f;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.l;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.v;
import kotlin.reflect.jvm.internal.impl.f.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class h<FieldDescriptorType extends a<FieldDescriptorType>> {
    private static final h d = new h<FieldDescriptorType>(true);
    private final v<FieldDescriptorType, Object> a;
    private boolean b;
    private boolean c = false;

    private h() {
        this.a = v.a(16);
    }

    private h(boolean bl2) {
        this.a = v.a(0);
        this.c();
    }

    private static int a(z.a a2, int n2, Object object) {
        int n3;
        n2 = n3 = f.o(n2);
        if (a2 == z.a.j) {
            n2 = n3 * 2;
        }
        return n2 + h.b(a2, object);
    }

    static int a(z.a a2, boolean bl2) {
        if (bl2) {
            return 2;
        }
        return a2.b();
    }

    private Object a(Object arrby) {
        if (arrby instanceof byte[]) {
            arrby = arrby;
            byte[] arrby2 = new byte[arrby.length];
            System.arraycopy(arrby, 0, arrby2, 0, arrby.length);
            return arrby2;
        }
        return arrby;
    }

    public static Object a(e e2, z.a a2, boolean bl2) {
        switch (a2) {
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
            case n: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            }
            case k: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            }
            case j: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            }
            case r: {
                return e2.r();
            }
            case q: {
                return e2.q();
            }
            case p: {
                return e2.p();
            }
            case o: {
                return e2.o();
            }
            case m: {
                return e2.m();
            }
            case l: {
                return e2.l();
            }
            case i: {
                if (bl2) {
                    return e2.k();
                }
                return e2.j();
            }
            case h: {
                return e2.i();
            }
            case g: {
                return e2.h();
            }
            case f: {
                return e2.g();
            }
            case e: {
                return e2.f();
            }
            case d: {
                return e2.d();
            }
            case c: {
                return e2.e();
            }
            case b: {
                return Float.valueOf(e2.c());
            }
            case a: 
        }
        return e2.b();
    }

    public static <T extends a<T>> h<T> a() {
        return new h<FieldDescriptorType>();
    }

    private static void a(f f2, z.a a2, int n2, Object object) {
        if (a2 == z.a.j) {
            f2.a(n2, (q)object);
            return;
        }
        f2.f(n2, h.a(a2, false));
        h.a(f2, a2, object);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(f f2, z.a a2, Object object) {
        switch (a2) {
            default: {
                return;
            }
            case n: {
                int n2 = object instanceof j.a ? ((j.a)object).a() : ((Integer)object).intValue();
                f2.e(n2);
                return;
            }
            case k: {
                f2.b((q)object);
                return;
            }
            case j: {
                f2.a((q)object);
                return;
            }
            case r: {
                f2.e((Long)object);
                return;
            }
            case q: {
                f2.g((Integer)object);
                return;
            }
            case p: {
                f2.d((Long)object);
                return;
            }
            case o: {
                f2.f((Integer)object);
                return;
            }
            case m: {
                f2.d((Integer)object);
                return;
            }
            case l: {
                if (object instanceof d) {
                    f2.a((d)object);
                    return;
                }
                f2.a((byte[])object);
                return;
            }
            case i: {
                f2.a((String)object);
                return;
            }
            case h: {
                f2.a((Boolean)object);
                return;
            }
            case g: {
                f2.c((Integer)object);
                return;
            }
            case f: {
                f2.c((Long)object);
                return;
            }
            case e: {
                f2.b((Integer)object);
                return;
            }
            case d: {
                f2.a((Long)object);
                return;
            }
            case c: {
                f2.b((Long)object);
                return;
            }
            case b: {
                f2.a(((Float)object).floatValue());
                return;
            }
            case a: 
        }
        f2.a((Double)object);
    }

    public static void a(a<?> iterator, Object object, f f2) {
        z.a a2 = iterator.b();
        int n2 = iterator.a();
        if (iterator.d()) {
            object = (List)object;
            if (iterator.e()) {
                f2.f(n2, 2);
                n2 = 0;
                iterator = object.iterator();
                while (iterator.hasNext()) {
                    n2 += h.b(a2, iterator.next());
                }
                f2.p(n2);
                iterator = object.iterator();
                while (iterator.hasNext()) {
                    h.a(f2, a2, iterator.next());
                }
            } else {
                iterator = object.iterator();
                while (iterator.hasNext()) {
                    h.a(f2, a2, n2, iterator.next());
                }
            }
        } else {
            if (object instanceof l) {
                h.a(f2, a2, n2, ((l)object).a());
                return;
            }
            h.a(f2, a2, n2, object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(z.a a2, Object object) {
        if (object == null) throw new NullPointerException();
        int n2 = 1.a[a2.a().ordinal()];
        boolean bl2 = false;
        switch (n2) {
            default: {
                break;
            }
            case 9: {
                if (object instanceof q) return;
                if (!(object instanceof l)) break;
                do {
                    return;
                    break;
                } while (true);
            }
            case 8: {
                if (object instanceof Integer) return;
                if (!(object instanceof j.a)) break;
                return;
            }
            case 7: {
                if (object instanceof d) return;
                if (!(object instanceof byte[])) break;
                return;
            }
            case 6: {
                bl2 = object instanceof String;
                break;
            }
            case 5: {
                bl2 = object instanceof Boolean;
                break;
            }
            case 4: {
                bl2 = object instanceof Double;
                break;
            }
            case 3: {
                bl2 = object instanceof Float;
                break;
            }
            case 2: {
                bl2 = object instanceof Long;
                break;
            }
            case 1: {
                bl2 = object instanceof Integer;
            }
        }
        if (!bl2) throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private boolean a(Map.Entry<FieldDescriptorType, Object> iterator) {
        a a2 = (a)iterator.getKey();
        if (a2.c() == z.b.i) {
            if (a2.d()) {
                iterator = ((List)iterator.getValue()).iterator();
                while (iterator.hasNext()) {
                    if (((q)iterator.next()).h()) continue;
                    return false;
                }
            } else if ((iterator = iterator.getValue()) instanceof q) {
                if (!((q)((Object)iterator)).h()) {
                    return false;
                }
            } else {
                if (iterator instanceof l) {
                    return true;
                }
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static int b(z.a a2, Object object) {
        switch (a2) {
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
            case n: {
                if (object instanceof j.a) {
                    return f.k(((j.a)object).a());
                }
                return f.k((Integer)object);
            }
            case k: {
                if (object instanceof l) {
                    return f.a((l)object);
                }
                return f.d((q)object);
            }
            case j: {
                return f.c((q)object);
            }
            case r: {
                return f.j((Long)object);
            }
            case q: {
                return f.m((Integer)object);
            }
            case p: {
                return f.i((Long)object);
            }
            case o: {
                return f.l((Integer)object);
            }
            case m: {
                return f.j((Integer)object);
            }
            case l: {
                if (object instanceof d) {
                    return f.b((d)object);
                }
                return f.b((byte[])object);
            }
            case i: {
                return f.b((String)object);
            }
            case h: {
                return f.b((Boolean)object);
            }
            case g: {
                return f.i((Integer)object);
            }
            case f: {
                return f.h((Long)object);
            }
            case e: {
                return f.h((Integer)object);
            }
            case d: {
                return f.f((Long)object);
            }
            case c: {
                return f.g((Long)object);
            }
            case b: {
                return f.b(((Float)object).floatValue());
            }
            case a: 
        }
        return f.b((Double)object);
    }

    public static <T extends a<T>> h<T> b() {
        return d;
    }

    private void b(Map.Entry<FieldDescriptorType, Object> v2) {
        a a2 = (a)v2.getKey();
        Object object = v2.getValue();
        v2 = object;
        if (object instanceof l) {
            v2 = ((l)object).a();
        }
        if (a2.d()) {
            Object object22;
            object = object22 = this.b(a2);
            if (object22 == null) {
                object = new ArrayList();
            }
            for (Object object22 : (List)((Object)v2)) {
                ((List)object).add(this.a(object22));
            }
            this.a.a(a2, object);
            return;
        }
        if (a2.c() == z.b.i && (object = this.b(a2)) != null) {
            object = a2.a(((q)object).m(), (q)((Object)v2)).l();
            v2 = this.a;
        } else {
            v<FieldDescriptorType, Object> v3 = this.a;
            object = this.a(v2);
            v2 = v3;
        }
        v2.a(a2, object);
    }

    public static int c(a<?> iterator, Object object) {
        z.a a2 = iterator.b();
        int n2 = iterator.a();
        if (iterator.d()) {
            boolean bl2 = iterator.e();
            int n3 = 0;
            int n4 = 0;
            if (bl2) {
                iterator = ((List)object).iterator();
                while (iterator.hasNext()) {
                    n4 += h.b(a2, iterator.next());
                }
                return f.o(n2) + n4 + f.q(n4);
            }
            iterator = ((List)object).iterator();
            n4 = n3;
            while (iterator.hasNext()) {
                n4 += h.a(a2, n2, iterator.next());
            }
            return n4;
        }
        return h.a(a2, n2, object);
    }

    public Object a(FieldDescriptorType object, int n2) {
        if (object.d()) {
            if ((object = this.b(object)) != null) {
                return ((List)object).get(n2);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(FieldDescriptorType FieldDescriptorType, Object object) {
        if (FieldDescriptorType.d()) {
            if (!(object instanceof List)) throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List)object);
            for (Object e2 : arrayList) {
                h.a(FieldDescriptorType.b(), e2);
            }
            object = arrayList;
        } else {
            h.a(FieldDescriptorType.b(), object);
        }
        if (object instanceof l) {
            this.c = true;
        }
        this.a.a(FieldDescriptorType, object);
    }

    public void a(h<FieldDescriptorType> object) {
        for (int i2 = 0; i2 < ((h)object).a.c(); ++i2) {
            this.b(((h)object).a.b(i2));
        }
        object = ((h)object).a.d().iterator();
        while (object.hasNext()) {
            this.b((Map.Entry)object.next());
        }
    }

    public boolean a(FieldDescriptorType FieldDescriptorType) {
        if (!FieldDescriptorType.d()) {
            return this.a.get(FieldDescriptorType) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public Object b(FieldDescriptorType object) {
        Object object2 = this.a.get(object);
        object = object2;
        if (object2 instanceof l) {
            object = ((l)object2).a();
        }
        return object;
    }

    public void b(FieldDescriptorType object, Object object2) {
        if (object.d()) {
            h.a(object.b(), object2);
            ArrayList arrayList = this.b(object);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.a(object, arrayList);
                object = arrayList;
            } else {
                object = arrayList;
            }
            object.add((Object)object2);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public int c(FieldDescriptorType object) {
        if (object.d()) {
            if ((object = this.b(object)) == null) {
                return 0;
            }
            return ((List)object).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void c() {
        if (this.b) {
            return;
        }
        this.a.a();
        this.b = true;
    }

    public /* synthetic */ Object clone() {
        return this.d();
    }

    public h<FieldDescriptorType> d() {
        h<T> h2 = h.a();
        for (int i2 = 0; i2 < this.a.c(); ++i2) {
            Map.Entry<FieldDescriptorType, Object> entry = this.a.b(i2);
            h2.a((a)entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry : this.a.d()) {
            h2.a((a)entry.getKey(), entry.getValue());
        }
        h2.c = this.c;
        return h2;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.c) {
            return new l.b(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }

    public boolean f() {
        for (int i2 = 0; i2 < this.a.c(); ++i2) {
            if (this.a((FieldDescriptorType)this.a.b(i2))) continue;
            return false;
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = this.a.d().iterator();
        while (iterator.hasNext()) {
            if (this.a((FieldDescriptorType)iterator.next())) continue;
            return false;
        }
        return true;
    }

    public int g() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.a.c(); ++i2) {
            Map.Entry<FieldDescriptorType, Object> entry = this.a.b(i2);
            n2 += h.c((a)entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry : this.a.d()) {
            n2 += h.c((a)entry.getKey(), entry.getValue());
        }
        return n2;
    }

    public static interface a<T extends a<T>>
    extends Comparable<T> {
        public int a();

        public q.a a(q.a var1, q var2);

        public z.a b();

        public z.b c();

        public boolean d();

        public boolean e();
    }

}

