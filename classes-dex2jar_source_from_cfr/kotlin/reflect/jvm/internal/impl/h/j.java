/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.ap;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.x;
import kotlin.reflect.jvm.internal.impl.a.c.y;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.q;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.v;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.d;
import kotlin.reflect.jvm.internal.impl.h.i;
import kotlin.reflect.jvm.internal.impl.h.l;
import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.w;

public class j {
    public static final j a;
    static final /* synthetic */ boolean b;
    private static final List<d> c;
    private final c.a d;

    static {
        b = j.class.desiredAssertionStatus() ^ true;
        c = m.k(ServiceLoader.load(d.class, d.class.getClassLoader()));
        a = new j(new c.a(){

            @Override
            public boolean a(an an2, an an3) {
                return an2.equals(an3);
            }
        });
    }

    private j(c.a a2) {
        this.d = a2;
    }

    public static <H> H a(Collection<H> collection, b<H, kotlin.reflect.jvm.internal.impl.a.a> b2) {
        if (!b && collection.isEmpty()) {
            throw new AssertionError((Object)"Should have at least one overridable descriptor");
        }
        if (collection.size() == 1) {
            return m.b(collection);
        }
        ArrayList<H> arrayList = new ArrayList<H>(2);
        Object object = m.c(collection, b2);
        H h2 = m.b(collection);
        kotlin.reflect.jvm.internal.impl.a.a a2 = b2.a(h2);
        Iterator<H> iterator = collection.iterator();
        collection = h2;
        while (iterator.hasNext()) {
            h2 = iterator.next();
            kotlin.reflect.jvm.internal.impl.a.a a3 = b2.a(h2);
            if (j.a(a3, object)) {
                arrayList.add(h2);
            }
            if (!j.c(a3, a2) || j.c(a2, a3)) continue;
            collection = h2;
        }
        if (arrayList.isEmpty()) {
            return (H)collection;
        }
        if (arrayList.size() == 1) {
            return (H)m.b(arrayList);
        }
        h2 = null;
        object = arrayList.iterator();
        do {
            collection = h2;
        } while (object.hasNext() && kotlin.reflect.jvm.internal.impl.j.t.a(b2.a(collection = object.next()).g()));
        if (collection != null) {
            return (H)collection;
        }
        return (H)m.b(arrayList);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static <H> Collection<H> a(H h2, Collection<H> iterator, b<H, kotlin.reflect.jvm.internal.impl.a.a> b2, b<H, w> b3) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(h2);
        kotlin.reflect.jvm.internal.impl.a.a a2 = b2.a(h2);
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            kotlin.reflect.jvm.internal.impl.a.a a3 = b2.a(e2);
            if (h2 != e2) {
                a.a a4 = j.d(a2, a3);
                if (a4 == a.a.a) {
                    arrayList.add(e2);
                } else {
                    if (a4 != a.a.c) continue;
                    b3.a(e2);
                }
            }
            iterator.remove();
        }
        return arrayList;
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.a.b> a(kotlin.reflect.jvm.internal.impl.a.b b2, Collection<? extends kotlin.reflect.jvm.internal.impl.a.b> object, e e2, i i2) {
        ArrayList<kotlin.reflect.jvm.internal.impl.a.b> arrayList = new ArrayList<kotlin.reflect.jvm.internal.impl.a.b>(object.size());
        kotlin.reflect.jvm.internal.impl.l.j j2 = kotlin.reflect.jvm.internal.impl.l.j.b();
        object = object.iterator();
        block4 : while (object.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.b b3 = (kotlin.reflect.jvm.internal.impl.a.b)object.next();
            a.a a2 = a.a((kotlin.reflect.jvm.internal.impl.a.a)b3, (kotlin.reflect.jvm.internal.impl.a.a)b2, e2).b();
            boolean bl2 = j.a((v)b2, b3);
            switch (a2) {
                default: {
                    continue block4;
                }
                case c: {
                    if (!bl2) break;
                    i2.b(b3, b2);
                    break;
                }
                case a: {
                    if (!bl2) break;
                    j2.add(b3);
                }
            }
            arrayList.add(b3);
        }
        i2.a(b2, j2);
        return arrayList;
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.a.b> a(final kotlin.reflect.jvm.internal.impl.a.b b2, Queue<kotlin.reflect.jvm.internal.impl.a.b> queue, final i i2) {
        return j.a(b2, queue, new b<kotlin.reflect.jvm.internal.impl.a.b, kotlin.reflect.jvm.internal.impl.a.a>(){

            @Override
            public kotlin.reflect.jvm.internal.impl.a.a a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                return b2;
            }
        }, new b<kotlin.reflect.jvm.internal.impl.a.b, w>(){

            @Override
            public w a(kotlin.reflect.jvm.internal.impl.a.b b22) {
                i2.c(b2, b22);
                return w.a;
            }
        });
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.a.b> a(final e e2, Collection<kotlin.reflect.jvm.internal.impl.a.b> collection) {
        return m.b(collection, new b<kotlin.reflect.jvm.internal.impl.a.b, Boolean>(){

            @Override
            public Boolean a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                boolean bl2 = !az.a(b2.p()) && az.a(b2, (kotlin.reflect.jvm.internal.impl.a.m)e2);
                return bl2;
            }
        });
    }

    private static List<kotlin.reflect.jvm.internal.impl.j.w> a(kotlin.reflect.jvm.internal.impl.a.a object) {
        al al2 = object.d();
        ArrayList<kotlin.reflect.jvm.internal.impl.j.w> arrayList = new ArrayList<kotlin.reflect.jvm.internal.impl.j.w>();
        if (al2 != null) {
            arrayList.add(al2.r());
        }
        object = object.i().iterator();
        while (object.hasNext()) {
            arrayList.add(((av)object.next()).r());
        }
        return arrayList;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.a.a> Set<D> a(Set<D> set) {
        return j.a(set, new kotlin.e.a.m<D, D, o<kotlin.reflect.jvm.internal.impl.a.a, kotlin.reflect.jvm.internal.impl.a.a>>(){

            @Override
            public o<kotlin.reflect.jvm.internal.impl.a.a, kotlin.reflect.jvm.internal.impl.a.a> a(D d2, D d3) {
                return new o<kotlin.reflect.jvm.internal.impl.a.a, kotlin.reflect.jvm.internal.impl.a.a>((kotlin.reflect.jvm.internal.impl.a.a)d2, (kotlin.reflect.jvm.internal.impl.a.a)d3);
            }
        });
    }

    public static <D> Set<D> a(Set<D> set, kotlin.e.a.m<? super D, ? super D, o<kotlin.reflect.jvm.internal.impl.a.a, kotlin.reflect.jvm.internal.impl.a.a>> object) {
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet<D> linkedHashSet = new LinkedHashSet<D>();
        block0 : for (D d2 : set) {
            Iterator iterator = linkedHashSet.iterator();
            while (iterator.hasNext()) {
                Object object2 = (o)object.a(d2, iterator.next());
                kotlin.reflect.jvm.internal.impl.a.a a2 = (kotlin.reflect.jvm.internal.impl.a.a)((o)object2).c();
                if (j.a(a2, object2 = (kotlin.reflect.jvm.internal.impl.a.a)((o)object2).d())) {
                    iterator.remove();
                    continue;
                }
                if (!j.a(object2, a2)) continue;
                continue block0;
            }
            linkedHashSet.add(d2);
        }
        if (!b) {
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("All candidates filtered out from ");
            ((StringBuilder)object).append(set);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return linkedHashSet;
    }

    public static Set<kotlin.reflect.jvm.internal.impl.a.b> a(kotlin.reflect.jvm.internal.impl.a.b b2) {
        LinkedHashSet<kotlin.reflect.jvm.internal.impl.a.b> linkedHashSet = new LinkedHashSet<kotlin.reflect.jvm.internal.impl.a.b>();
        j.a(b2, linkedHashSet);
        return linkedHashSet;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ba a(Collection<? extends kotlin.reflect.jvm.internal.impl.a.b> object) {
        Object object2;
        ba ba2;
        if (object.isEmpty()) {
            return az.k;
        }
        Iterator iterator = object.iterator();
        block0 : do {
            ba2 = null;
            while (iterator.hasNext()) {
                Object object3 = (kotlin.reflect.jvm.internal.impl.a.b)iterator.next();
                object2 = object3.p();
                if (!b && object2 == az.g) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Visibility should have been computed for ");
                    ((StringBuilder)object).append(object3);
                    throw new AssertionError((Object)((StringBuilder)object).toString());
                }
                if (ba2 != null) {
                    object3 = az.b((ba)object2, ba2);
                    if (object3 == null) continue block0;
                    if ((Integer)object3 <= 0) continue;
                }
                ba2 = object2;
            }
            break;
        } while (true);
        if (ba2 == null) {
            return null;
        }
        object = object.iterator();
        do {
            if (object.hasNext()) continue;
            return ba2;
        } while ((object2 = az.b(ba2, ((kotlin.reflect.jvm.internal.impl.a.b)object.next()).p())) != null && (Integer)object2 >= 0);
        return null;
    }

    private static kotlin.reflect.jvm.internal.impl.a.w a(Collection<kotlin.reflect.jvm.internal.impl.a.b> iterator, e e2) {
        Object object;
        Iterator<kotlin.reflect.jvm.internal.impl.a.b> iterator2 = iterator.iterator();
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        block6 : while (iterator2.hasNext()) {
            object = iterator2.next();
            switch (object.m()) {
                default: {
                    continue block6;
                }
                case d: {
                    bl4 = true;
                    continue block6;
                }
                case c: {
                    bl3 = true;
                    continue block6;
                }
                case b: {
                    iterator = new StringBuilder();
                    ((StringBuilder)((Object)iterator)).append("Member cannot have SEALED modality: ");
                    ((StringBuilder)((Object)iterator)).append(object);
                    throw new IllegalStateException(((StringBuilder)((Object)iterator)).toString());
                }
                case a: 
            }
            return kotlin.reflect.jvm.internal.impl.a.w.a;
        }
        boolean bl5 = bl2;
        if (e2.u()) {
            bl5 = bl2;
            if (e2.m() != kotlin.reflect.jvm.internal.impl.a.w.d) {
                bl5 = bl2;
                if (e2.m() != kotlin.reflect.jvm.internal.impl.a.w.b) {
                    bl5 = true;
                }
            }
        }
        if (bl3 && !bl4) {
            return kotlin.reflect.jvm.internal.impl.a.w.c;
        }
        if (!bl3 && bl4) {
            if (bl5) {
                return e2.m();
            }
            return kotlin.reflect.jvm.internal.impl.a.w.d;
        }
        object = new HashSet();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object.addAll(j.a((kotlin.reflect.jvm.internal.impl.a.b)iterator.next()));
        }
        return j.a(j.a(object), bl5, e2.m());
    }

    private static kotlin.reflect.jvm.internal.impl.a.w a(Collection<kotlin.reflect.jvm.internal.impl.a.b> object, boolean bl2, kotlin.reflect.jvm.internal.impl.a.w w2) {
        Object object2 = kotlin.reflect.jvm.internal.impl.a.w.d;
        Iterator<kotlin.reflect.jvm.internal.impl.a.b> iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            object = bl2 && object.m() == kotlin.reflect.jvm.internal.impl.a.w.d ? w2 : object.m();
            if (((Enum)object).compareTo(object2) >= 0) continue;
            object2 = object;
        }
        return object2;
    }

    public static j a(c.a a2) {
        return new j(a2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private kotlin.reflect.jvm.internal.impl.j.a.c a(List<as> object, List<as> list) {
        if (!b && object.size() != list.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Should be the same number of type parameters: ");
            stringBuilder.append(object);
            stringBuilder.append(" vs ");
            stringBuilder.append(list);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        if (object.isEmpty()) {
            object = this.d;
            do {
                return kotlin.reflect.jvm.internal.impl.j.a.d.a((c.a)object);
                break;
            } while (true);
        }
        final HashMap<an, an> hashMap = new HashMap<an, an>();
        for (int i2 = 0; i2 < object.size(); ++i2) {
            hashMap.put(((as)object.get(i2)).e(), list.get(i2).e());
        }
        object = new c.a(){

            @Override
            public boolean a(an an2, an an3) {
                boolean bl2 = j.this.d.a(an2, an3);
                boolean bl3 = true;
                if (bl2) {
                    return true;
                }
                an an4 = (an)hashMap.get(an2);
                an an5 = (an)hashMap.get(an3);
                if (an4 == null || !an4.equals(an3)) {
                    if (an5 != null && an5.equals(an2)) {
                        return true;
                    }
                    bl3 = false;
                }
                return bl3;
            }
        };
        return kotlin.reflect.jvm.internal.impl.j.a.d.a((c.a)object);
    }

    private static void a(Collection<kotlin.reflect.jvm.internal.impl.a.b> object, e ap2, i i2) {
        Collection<kotlin.reflect.jvm.internal.impl.a.b> collection = j.a((e)ap2, object);
        boolean bl2 = collection.isEmpty();
        if (!bl2) {
            object = collection;
        }
        kotlin.reflect.jvm.internal.impl.a.w w2 = j.a(object, (e)ap2);
        collection = bl2 ? az.h : az.g;
        ap2 = j.a(object, new b<kotlin.reflect.jvm.internal.impl.a.b, kotlin.reflect.jvm.internal.impl.a.a>(){

            @Override
            public kotlin.reflect.jvm.internal.impl.a.b a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                return b2;
            }
        }).a((kotlin.reflect.jvm.internal.impl.a.m)((Object)ap2), w2, (ba)((Object)collection), b.a.b, false);
        i2.a((kotlin.reflect.jvm.internal.impl.a.b)ap2, (Collection<? extends kotlin.reflect.jvm.internal.impl.a.b>)object);
        if (!b && ap2.k().isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Overridden descriptors should be set for ");
            ((StringBuilder)object).append((Object)b.a.b);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        i2.a((kotlin.reflect.jvm.internal.impl.a.b)ap2);
    }

    private static void a(kotlin.reflect.jvm.internal.impl.a.b object, Set<kotlin.reflect.jvm.internal.impl.a.b> object2) {
        if (object.n().a()) {
            object2.add((kotlin.reflect.jvm.internal.impl.a.b)object);
            return;
        }
        if (!object.k().isEmpty()) {
            object = object.k().iterator();
            while (object.hasNext()) {
                j.a((kotlin.reflect.jvm.internal.impl.a.b)object.next(), (Set<kotlin.reflect.jvm.internal.impl.a.b>)object2);
            }
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("No overridden descriptors found for (fake override) ");
        ((StringBuilder)object2).append(object);
        throw new IllegalStateException(((StringBuilder)object2).toString());
    }

    public static void a(kotlin.reflect.jvm.internal.impl.a.b object, b<kotlin.reflect.jvm.internal.impl.a.b, w> b2) {
        Iterator<ah> iterator;
        for (kotlin.reflect.jvm.internal.impl.a.b object22 : object.k()) {
            if (object22.p() != az.g) continue;
            j.a(object22, b2);
        }
        if (object.p() != az.g) {
            return;
        }
        ba ba2 = j.b((kotlin.reflect.jvm.internal.impl.a.b)((Object)object));
        if (ba2 == null) {
            if (b2 != null) {
                b2.a((kotlin.reflect.jvm.internal.impl.a.b)((Object)object));
            }
            iterator = az.e;
        } else {
            iterator = ba2;
        }
        if (object instanceof y) {
            ((y)((Object)object)).a((ba)((Object)iterator));
            for (ah ah2 : ((ai)((Object)object)).o()) {
                object = ba2 == null ? null : b2;
                j.a((kotlin.reflect.jvm.internal.impl.a.b)ah2, object);
            }
        } else {
            if (object instanceof kotlin.reflect.jvm.internal.impl.a.c.o) {
                ((kotlin.reflect.jvm.internal.impl.a.c.o)((Object)object)).a((ba)((Object)iterator));
                return;
            }
            if (!b && !(object instanceof x)) {
                throw new AssertionError();
            }
            object = (x)((Object)object);
            ((x)((Object)object)).a((ba)((Object)iterator));
            if (iterator != ((x)((Object)object)).q().p()) {
                ((x)((Object)object)).a(false);
            }
        }
    }

    private static void a(e e2, Collection<kotlin.reflect.jvm.internal.impl.a.b> linkedList, i i2) {
        if (j.b(linkedList)) {
            linkedList = linkedList.iterator();
            while (linkedList.hasNext()) {
                j.a(Collections.singleton((kotlin.reflect.jvm.internal.impl.a.b)linkedList.next()), e2, i2);
            }
            return;
        }
        linkedList = new LinkedList<kotlin.reflect.jvm.internal.impl.a.b>(linkedList);
        while (!linkedList.isEmpty()) {
            j.a(j.a(l.a(linkedList), linkedList, i2), e2, i2);
        }
    }

    public static void a(f object, Collection<? extends kotlin.reflect.jvm.internal.impl.a.b> collection, Collection<? extends kotlin.reflect.jvm.internal.impl.a.b> object2, e e2, i i2) {
        object = new LinkedHashSet<kotlin.reflect.jvm.internal.impl.a.b>(collection);
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.removeAll(j.a((kotlin.reflect.jvm.internal.impl.a.b)object2.next(), collection, e2, i2));
        }
        j.a(e2, (Collection<kotlin.reflect.jvm.internal.impl.a.b>)object, i2);
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.a.a a2, Collection<kotlin.reflect.jvm.internal.impl.a.a> object) {
        object = object.iterator();
        while (object.hasNext()) {
            if (j.c(a2, (kotlin.reflect.jvm.internal.impl.a.a)object.next())) continue;
            return false;
        }
        return true;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.a.a> boolean a(D object, D object2) {
        if (!object.equals(object2) && kotlin.reflect.jvm.internal.impl.h.a.a.a(object.h(), object2.h())) {
            return true;
        }
        object2 = object2.h();
        for (kotlin.reflect.jvm.internal.impl.a.a a2 : c.a(object)) {
            if (!kotlin.reflect.jvm.internal.impl.h.a.a.a((kotlin.reflect.jvm.internal.impl.a.m)object2, a2)) continue;
            return true;
        }
        return false;
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.a.a a3, kotlin.reflect.jvm.internal.impl.j.w w3) {
        return a.a(a2.f(), a3.f()).a(w2, w3);
    }

    private static boolean a(ah ah2, ah ah3) {
        if (ah2 != null && ah3 != null) {
            return j.a((q)ah2, (q)ah3);
        }
        return true;
    }

    private static boolean a(as object, as object2, kotlin.reflect.jvm.internal.impl.j.a.c c2) {
        Object object3 = object.j();
        object = new ArrayList<kotlin.reflect.jvm.internal.impl.j.w>(object2.j());
        if (object3.size() != object.size()) {
            return false;
        }
        object2 = object3.iterator();
        block0 : while (object2.hasNext()) {
            object3 = (kotlin.reflect.jvm.internal.impl.j.w)object2.next();
            ListIterator listIterator = object.listIterator();
            while (listIterator.hasNext()) {
                if (!j.a((kotlin.reflect.jvm.internal.impl.j.w)object3, (kotlin.reflect.jvm.internal.impl.j.w)listIterator.next(), c2)) continue;
                listIterator.remove();
                continue block0;
            }
            return false;
        }
        return true;
    }

    private static boolean a(q object, q q2) {
        return (object = az.b(object.p(), q2.p())) == null || (Integer)object >= 0;
        {
        }
    }

    public static boolean a(v v2, v v3) {
        return !az.a(v3.p()) && az.a(v3, (kotlin.reflect.jvm.internal.impl.a.m)v2);
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.j.w w3, kotlin.reflect.jvm.internal.impl.j.a.c c2) {
        boolean bl2 = kotlin.reflect.jvm.internal.impl.j.y.a(w2);
        boolean bl3 = true;
        boolean bl4 = bl2 && kotlin.reflect.jvm.internal.impl.j.y.a(w3);
        if (!bl4) {
            if (c2.b(w2, w3)) {
                return true;
            }
            bl3 = false;
        }
        return bl3;
    }

    private static ba b(kotlin.reflect.jvm.internal.impl.a.b object) {
        Object object2 = object.k();
        ba ba2 = j.a(object2);
        if (ba2 == null) {
            return null;
        }
        if (object.n() == b.a.b) {
            object = object2.iterator();
            while (object.hasNext()) {
                object2 = (kotlin.reflect.jvm.internal.impl.a.b)object.next();
                if (object2.m() == kotlin.reflect.jvm.internal.impl.a.w.d || object2.p().equals(ba2)) continue;
                return null;
            }
            return ba2;
        }
        return ba2.b();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static a b(kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.a object2) {
        boolean bl2;
        boolean bl3 = object instanceof t;
        if (bl3 && !(object2 instanceof t) || (bl2 = object instanceof ai) && !(object2 instanceof ai)) {
            object = "Member kind mismatch";
            do {
                return a.a((String)object);
                break;
            } while (true);
        }
        if (!bl3 && !bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("This type of CallableDescriptor cannot be checked for overridability: ");
            ((StringBuilder)object2).append(object);
            throw new IllegalArgumentException(((StringBuilder)object2).toString());
        }
        if (!object.h_().equals(object2.h_())) {
            object = "Name mismatch";
            return a.a((String)object);
        }
        if ((object = j.e((kotlin.reflect.jvm.internal.impl.a.a)object, (kotlin.reflect.jvm.internal.impl.a.a)object2)) == null) return null;
        return object;
    }

    private static boolean b(Collection<kotlin.reflect.jvm.internal.impl.a.b> collection) {
        if (collection.size() < 2) {
            return true;
        }
        return m.d(collection, new b<kotlin.reflect.jvm.internal.impl.a.b, Boolean>(collection.iterator().next().b()){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.m a;
            {
                this.a = m2;
            }

            @Override
            public Boolean a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                boolean bl2 = b2.b() == this.a;
                return bl2;
            }
        });
    }

    public static boolean c(kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.a object2) {
        block12 : {
            boolean bl2;
            block14 : {
                boolean bl3;
                kotlin.reflect.jvm.internal.impl.j.w w2;
                kotlin.reflect.jvm.internal.impl.j.w w3;
                block13 : {
                    w2 = object.g();
                    w3 = object2.g();
                    if (!b && w2 == null) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Return type of ");
                        ((StringBuilder)object2).append(object);
                        ((StringBuilder)object2).append(" is null");
                        throw new AssertionError((Object)((StringBuilder)object2).toString());
                    }
                    if (!b && w3 == null) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Return type of ");
                        ((StringBuilder)object).append(object2);
                        ((StringBuilder)object).append(" is null");
                        throw new AssertionError((Object)((StringBuilder)object).toString());
                    }
                    bl2 = j.a((q)object, (q)object2);
                    bl3 = false;
                    if (!bl2) {
                        return false;
                    }
                    if (object instanceof t) {
                        if (!b && !(object2 instanceof t)) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("b is ");
                            ((StringBuilder)object).append(object2.getClass());
                            throw new AssertionError((Object)((StringBuilder)object).toString());
                        }
                        return j.a((kotlin.reflect.jvm.internal.impl.a.a)object, w2, (kotlin.reflect.jvm.internal.impl.a.a)object2, w3);
                    }
                    if (!(object instanceof ai)) break block12;
                    if (!b && !(object2 instanceof ai)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("b is ");
                        ((StringBuilder)object).append(object2.getClass());
                        throw new AssertionError((Object)((StringBuilder)object).toString());
                    }
                    ai ai2 = (ai)object;
                    ai ai3 = (ai)object2;
                    if (!j.a(ai2.c(), ai3.c())) {
                        return false;
                    }
                    if (ai2.s() && ai3.s()) {
                        return a.a(object.f(), object2.f()).b(w2, w3);
                    }
                    if (ai2.s()) break block13;
                    bl2 = bl3;
                    if (ai3.s()) break block14;
                }
                bl2 = bl3;
                if (j.a((kotlin.reflect.jvm.internal.impl.a.a)object, w2, (kotlin.reflect.jvm.internal.impl.a.a)object2, w3)) {
                    bl2 = true;
                }
            }
            return bl2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unexpected callable: ");
        ((StringBuilder)object2).append(object.getClass());
        throw new IllegalArgumentException(((StringBuilder)object2).toString());
    }

    public static a.a d(kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.a a2) {
        a.a a3 = a.a(a2, (kotlin.reflect.jvm.internal.impl.a.a)object, null).b();
        object = a.a((kotlin.reflect.jvm.internal.impl.a.a)object, a2, null).b();
        if (a3 == a.a.a && object == a.a.a) {
            return a.a.a;
        }
        if (a3 != a.a.c && object != a.a.c) {
            return a.a.b;
        }
        return a.a.c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static a e(kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.a a2) {
        al al2 = object.d();
        boolean bl2 = false;
        boolean bl3 = al2 == null;
        if (a2.d() == null) {
            bl2 = true;
        }
        if (bl3 != bl2) {
            object = "Receiver presence mismatch";
            do {
                return a.a((String)object);
                break;
            } while (true);
        }
        if (object.i().size() == a2.i().size()) return null;
        object = "Value parameter number mismatch";
        return a.a((String)object);
    }

    public a a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.a.a a3, e e2) {
        return this.a(a2, a3, e2, false);
    }

    public a a(kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.a a2, e e2, boolean bl2) {
        a object22 = this.a((kotlin.reflect.jvm.internal.impl.a.a)object, a2, bl2);
        boolean bl3 = object22.b() == a.a.a;
        block10 : for (d d2 : c) {
            if (d2.a() == d.a.a || bl3 && d2.a() == d.a.b) continue;
            d.b b2 = d2.a((kotlin.reflect.jvm.internal.impl.a.a)object, a2, e2);
            switch (b2) {
                default: {
                    continue block10;
                }
                case c: {
                    return a.a("External condition");
                }
                case b: {
                    return a.b("External condition failed");
                }
                case a: 
            }
            bl3 = true;
        }
        if (!bl3) {
            return object22;
        }
        block11 : for (d d3 : c) {
            if (d3.a() != d.a.a) continue;
            d.b b3 = d3.a((kotlin.reflect.jvm.internal.impl.a.a)object, a2, e2);
            switch (b3) {
                default: {
                    continue block11;
                }
                case c: {
                    return a.a("External condition");
                }
                case b: {
                    return a.b("External condition failed");
                }
                case a: 
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Contract violation in ");
            ((StringBuilder)object).append(d3.getClass().getName());
            ((StringBuilder)object).append(" condition. It's not supposed to end with success");
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        return a.a();
    }

    public a a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.a.a a3, boolean bl2) {
        int n2;
        Object object = j.b(a2, a3);
        if (object != null) {
            return object;
        }
        List<kotlin.reflect.jvm.internal.impl.j.w> list = j.a(a2);
        List<kotlin.reflect.jvm.internal.impl.j.w> list2 = j.a(a3);
        List<as> list3 = a2.f();
        List<as> list4 = a3.f();
        int n3 = list3.size();
        int n4 = list4.size();
        int n5 = 0;
        if (n3 != n4) {
            for (n2 = 0; n2 < list.size(); ++n2) {
                if (kotlin.reflect.jvm.internal.impl.j.a.c.a.b(list.get(n2), list2.get(n2))) continue;
                return a.a("Type parameter number mismatch");
            }
            return a.b("Type parameter number mismatch");
        }
        object = this.a(list3, list4);
        for (n2 = 0; n2 < list3.size(); ++n2) {
            if (j.a(list3.get(n2), list4.get(n2), (kotlin.reflect.jvm.internal.impl.j.a.c)object)) continue;
            return a.a("Type parameter bounds mismatch");
        }
        for (n2 = 0; n2 < list.size(); ++n2) {
            if (j.a(list.get(n2), list2.get(n2), (kotlin.reflect.jvm.internal.impl.j.a.c)object)) continue;
            return a.a("Value parameter type mismatch");
        }
        if (a2 instanceof t && a3 instanceof t && ((t)a2).D() != ((t)a3).D()) {
            return a.b("Incompatible suspendability");
        }
        if (bl2) {
            a2 = a2.g();
            a3 = a3.g();
            if (a2 != null && a3 != null) {
                n2 = n5;
                if (kotlin.reflect.jvm.internal.impl.j.y.a((kotlin.reflect.jvm.internal.impl.j.w)a3)) {
                    n2 = n5;
                    if (kotlin.reflect.jvm.internal.impl.j.y.a((kotlin.reflect.jvm.internal.impl.j.w)a2)) {
                        n2 = 1;
                    }
                }
                if (n2 == 0 && !object.a((kotlin.reflect.jvm.internal.impl.j.w)a3, (kotlin.reflect.jvm.internal.impl.j.w)a2)) {
                    return a.b("Return type mismatch");
                }
            }
        }
        return a.a();
    }

    public static class kotlin.reflect.jvm.internal.impl.h.j$a {
        private static final kotlin.reflect.jvm.internal.impl.h.j$a a = new kotlin.reflect.jvm.internal.impl.h.j$a(a.a, "SUCCESS");
        private final a b;
        private final String c;

        public kotlin.reflect.jvm.internal.impl.h.j$a(a a2, String string2) {
            this.b = a2;
            this.c = string2;
        }

        public static kotlin.reflect.jvm.internal.impl.h.j$a a() {
            return a;
        }

        public static kotlin.reflect.jvm.internal.impl.h.j$a a(String string2) {
            return new kotlin.reflect.jvm.internal.impl.h.j$a(a.b, string2);
        }

        public static kotlin.reflect.jvm.internal.impl.h.j$a b(String string2) {
            return new kotlin.reflect.jvm.internal.impl.h.j$a(a.c, string2);
        }

        public a b() {
            return this.b;
        }

        public static enum a {
            a,
            b,
            c;
            
        }

    }

}

