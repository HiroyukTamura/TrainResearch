/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.c.b.i;
import kotlin.reflect.jvm.internal.impl.c.b.m;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.c.b.p;
import kotlin.reflect.jvm.internal.impl.c.b.q;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.d.c.a.f;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.t;

public abstract class a<A, C, T>
implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.b<A, C, T> {
    @Deprecated
    public static final a a = new a(null);
    private static final Set<kotlin.reflect.jvm.internal.impl.e.a> d;
    private final kotlin.reflect.jvm.internal.impl.i.c<n, b<A, C>> b;
    private final m c;

    static {
        Object object = kotlin.a.m.b(o.a, o.d, o.e, new kotlin.reflect.jvm.internal.impl.e.b("java.lang.annotation.Target"), new kotlin.reflect.jvm.internal.impl.e.b("java.lang.annotation.Retention"), new kotlin.reflect.jvm.internal.impl.e.b("java.lang.annotation.Documented"));
        Collection collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(kotlin.reflect.jvm.internal.impl.e.a.a((kotlin.reflect.jvm.internal.impl.e.b)object.next()));
        }
        d = kotlin.a.m.m((List)collection);
    }

    public a(kotlin.reflect.jvm.internal.impl.i.i i2, m m2) {
        j.b(i2, "storageManager");
        j.b(m2, "kotlinClassFinder");
        this.c = m2;
        this.b = i2.a(new kotlin.e.a.b<n, b<? extends A, ? extends C>>(){

            @Override
            public final b<A, C> a(n n2) {
                j.b(n2, "kotlinClass");
                return this.b(n2);
            }
        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final int a(w object, kotlin.reflect.jvm.internal.impl.f.q q2) {
        if (q2 instanceof a.o) {
            if (!kotlin.reflect.jvm.internal.impl.d.b.g.a((a.o)q2)) return 0;
            do {
                return 1;
                break;
            } while (true);
        }
        if (q2 instanceof a.w) {
            if (!kotlin.reflect.jvm.internal.impl.d.b.g.a((a.w)q2)) return 0;
            return 1;
        }
        if (q2 instanceof a.e) {
            if (object == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            if (((w.a)(object = (w.a)object)).f() == a.c.b.c) {
                return 2;
            }
            if (!((w.a)object).g()) return 0;
            return 1;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unsupported message: ");
        ((StringBuilder)object).append(q2.getClass());
        throw (Throwable)new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    static /* synthetic */ List a(a a2, w w2, q q2, boolean bl2, boolean bl3, Boolean bl4, boolean bl5, int n2, Object object) {
        if (object == null) {
            if ((n2 & 4) != 0) {
                bl2 = false;
            }
            if ((n2 & 8) != 0) {
                bl3 = false;
            }
            if ((n2 & 16) != 0) {
                bl4 = null;
            }
            if ((n2 & 32) != 0) {
                bl5 = false;
            }
            return a2.a(w2, q2, bl2, bl3, bl4, bl5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final List<A> a(w list, q q2, boolean bl2, boolean bl3, Boolean bl4, boolean bl5) {
        if ((list = this.a((w)((Object)list), this.a((w)((Object)list), bl2, bl3, bl4, bl5))) != null) {
            if ((list = ((b)this.b.a((n)((Object)list))).a().get(q2)) != null) {
                return list;
            }
            return kotlin.a.m.a();
        }
        return kotlin.a.m.a();
    }

    private final n a(w w2, n n2) {
        if (n2 != null) {
            return n2;
        }
        if (w2 instanceof w.a) {
            return this.b((w.a)w2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final n a(w object, boolean bl2, boolean bl3, Boolean object2, boolean bl4) {
        block9 : {
            Object object3;
            block11 : {
                block10 : {
                    if (!bl2) break block9;
                    if (object2 == null) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("isConst should not be null for property (container=");
                        ((StringBuilder)object2).append(object);
                        ((StringBuilder)object2).append(')');
                        throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString().toString());
                    }
                    if (!(object instanceof w.a) || ((w.a)(object3 = (w.a)object)).f() != a.c.b.b) break block10;
                    object = this.c;
                    object2 = ((w.a)object3).e().a(f.a("DefaultImpls"));
                    object3 = "container.classId.create\u2026EFAULT_IMPLS_CLASS_NAME))";
                    break block11;
                }
                if (!((Boolean)object2).booleanValue() || !(object instanceof w.b)) break block9;
                object2 = object3 = ((w)object).d();
                if (!(object3 instanceof i)) {
                    object2 = null;
                }
                if ((object2 = (object2 = (i)object2) != null ? ((i)object2).e() : null) == null) break block9;
                object = this.c;
                object2 = ((kotlin.reflect.jvm.internal.impl.h.d.b)object2).c();
                j.a(object2, "facadeClassName.internalName");
                object2 = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b(kotlin.i.n.a((String)object2, '/', '.', false, 4, null)));
                object3 = "ClassId.topLevel(FqName(\u2026lName.replace('/', '.')))";
            }
            j.a(object2, (String)object3);
            return object.a((kotlin.reflect.jvm.internal.impl.e.a)object2);
        }
        if (bl3 && object instanceof w.a && ((w.a)(object2 = (w.a)object)).f() == a.c.b.g && (object2 = ((w.a)object2).i()) != null && (((w.a)object2).f() == a.c.b.a || ((w.a)object2).f() == a.c.b.c || bl4 && (((w.a)object2).f() == a.c.b.b || ((w.a)object2).f() == a.c.b.e))) {
            return this.b((w.a)object2);
        }
        if (object instanceof w.b && ((w)object).d() instanceof i) {
            if ((object = ((w)object).d()) == null) {
                throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            }
            object2 = ((i)(object = (i)object)).f();
            if (object2 != null) {
                return object2;
            }
            return this.c.a(((i)object).c());
        }
        return null;
    }

    static /* synthetic */ q a(a a2, a.w w2, kotlin.reflect.jvm.internal.impl.d.b.c c2, h h2, boolean bl2, boolean bl3, int n2, Object object) {
        if (object == null) {
            if ((n2 & 8) != 0) {
                bl2 = false;
            }
            if ((n2 & 16) != 0) {
                bl3 = false;
            }
            return a2.a(w2, c2, h2, bl2, bl3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final q a(a.w object, kotlin.reflect.jvm.internal.impl.d.b.c c2, h object2, boolean bl2, boolean bl3) {
        kotlin.reflect.jvm.internal.impl.f.i i2 = (i.c)object;
        i.f<a.w, b.e> f2 = kotlin.reflect.jvm.internal.impl.d.c.b.d;
        j.a(f2, "propertySignature");
        i2 = kotlin.reflect.jvm.internal.impl.d.b.f.a(i2, f2);
        if (i2 != null) {
            if (bl2) {
                if ((object = kotlin.reflect.jvm.internal.impl.d.c.a.j.a.a((a.w)object, c2, (h)object2)) != null) {
                    return q.a.a((kotlin.reflect.jvm.internal.impl.d.c.a.f)object);
                }
                return null;
            }
            if (bl3 && ((b.e)i2).f()) {
                object = q.a;
                object2 = ((b.e)i2).g();
                j.a(object2, "signature.syntheticMethod");
                return ((q.a)object).a(c2, (b.c)object2);
            }
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final q a(kotlin.reflect.jvm.internal.impl.f.q object, kotlin.reflect.jvm.internal.impl.d.b.c object2, h object3, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a object4) {
        void var2_4;
        b.c c2;
        Object object5;
        boolean bl2 = object instanceof a.e;
        i.c c3 = null;
        if (bl2) {
            object5 = q.a;
            if ((object = kotlin.reflect.jvm.internal.impl.d.c.a.j.a.a((a.e)object, (kotlin.reflect.jvm.internal.impl.d.b.c)object2, (h)((Object)c2))) == null) return null;
            q.a a2 = object5;
            do {
                return var2_4.a((kotlin.reflect.jvm.internal.impl.d.c.a.f)object);
                break;
            } while (true);
        }
        if (object instanceof a.o) {
            object5 = q.a;
            if ((object = kotlin.reflect.jvm.internal.impl.d.c.a.j.a.a((a.o)object, (kotlin.reflect.jvm.internal.impl.d.b.c)object2, (h)((Object)c2))) == null) return null;
            q.a a3 = object5;
            return var2_4.a((kotlin.reflect.jvm.internal.impl.d.c.a.f)object);
        }
        Object object6 = c3;
        if (!(object instanceof a.w)) return object6;
        object6 = (i.c)object;
        Object object7 = kotlin.reflect.jvm.internal.impl.d.c.b.d;
        j.a(object7, "propertySignature");
        object7 = kotlin.reflect.jvm.internal.impl.d.b.f.a(object6, object7);
        object6 = c3;
        if (object7 == null) return object6;
        switch (kotlin.reflect.jvm.internal.impl.c.b.b.a[((Enum)object5).ordinal()]) {
            default: {
                return null;
            }
            case 3: {
                return this.a((a.w)object, (kotlin.reflect.jvm.internal.impl.d.b.c)object2, (h)((Object)c2), true, true);
            }
            case 2: {
                object6 = c3;
                if (!((b.e)object7).l()) return object6;
                object = q.a;
                c2 = ((b.e)object7).p();
                object5 = "signature.setter";
                break;
            }
            case 1: {
                object6 = c3;
                if (!((b.e)object7).j()) return object6;
                object = q.a;
                c2 = ((b.e)object7).k();
                object5 = "signature.getter";
            }
        }
        j.a((Object)c2, (String)object5);
        return ((q.a)object).a((kotlin.reflect.jvm.internal.impl.d.b.c)object2, c2);
    }

    private final b<A, C> b(n n2) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        n2.a(new n.d(){

            @Override
            public n.c a(f object, String string2, Object object2) {
                j.b(object, "name");
                j.b(string2, "desc");
                q.a a2 = q.a;
                object = ((f)object).a();
                j.a(object, "name.asString()");
                object = a2.b((String)object, string2);
                if (object2 != null && (string2 = this.a(string2, object2)) != null) {
                    ((Map)hashMap2).put(object, string2);
                }
                return new b((q)object);
            }

            @Override
            public n.e a(f object, String string2) {
                j.b(object, "name");
                j.b(string2, "desc");
                q.a a2 = q.a;
                object = ((f)object).a();
                j.a(object, "name.asString()");
                return new a(a2.a((String)object, string2));
            }

            public final class a
            extends b
            implements n.e {
                public a(q q2) {
                    j.b(q2, "signature");
                    super(q2);
                }

                @Override
                public n.a a(int n2, kotlin.reflect.jvm.internal.impl.e.a a2, an an2) {
                    List list;
                    j.b(a2, "classId");
                    j.b(an2, "source");
                    q q2 = q.a.a(this.b(), n2);
                    List list2 = list = (List)hashMap.get(q2);
                    if (list == null) {
                        list2 = new ArrayList();
                        ((Map)hashMap).put(q2, list2);
                    }
                    return this.b(a2, an2, list2);
                }
            }

            public class b
            implements n.c {
                private final ArrayList<A> a;
                private final q c;

                public b(q q2) {
                    j.b(q2, "signature");
                    this.c = q2;
                    this.a = new ArrayList();
                }

                @Override
                public n.a a(kotlin.reflect.jvm.internal.impl.e.a a2, an an2) {
                    j.b(a2, "classId");
                    j.b(an2, "source");
                    return this.b(a2, an2, this.a);
                }

                @Override
                public void a() {
                    if (((Collection)this.a).isEmpty() ^ true) {
                        ((Map)hashMap).put(this.c, this.a);
                    }
                }

                protected final q b() {
                    return this.c;
                }
            }

        }, this.a(n2));
        return new b(hashMap, hashMap2);
    }

    private final n.a b(kotlin.reflect.jvm.internal.impl.e.a a2, an an2, List<A> list) {
        if (d.contains(a2)) {
            return null;
        }
        return this.a(a2, an2, list);
    }

    private final n b(w.a object) {
        object = ((w)object).d();
        boolean bl2 = object instanceof p;
        Object var3_3 = null;
        if (!bl2) {
            object = null;
        }
        p p2 = (p)object;
        object = var3_3;
        if (p2 != null) {
            object = p2.b();
        }
        return object;
    }

    protected abstract C a(C var1);

    protected abstract C a(String var1, Object var2);

    protected abstract A a(a.a var1, kotlin.reflect.jvm.internal.impl.d.b.c var2);

    @Override
    public C a(w object, a.w w2, kotlin.reflect.jvm.internal.impl.j.w w3) {
        j.b(object, "container");
        j.b(w2, "proto");
        j.b(w3, "expectedType");
        q q2 = this.a(w2, ((w)object).b(), ((w)object).c(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.b);
        if (q2 != null && (object = this.a((w)object, this.a((w)object, true, true, kotlin.reflect.jvm.internal.impl.d.b.b.w.a(w2.e()), kotlin.reflect.jvm.internal.impl.d.c.a.j.a(w2)))) != null && (w2 = ((b)this.b.a((n)object)).b().get(q2)) != null) {
            object = w2;
            if (UnsignedTypes.INSTANCE.isUnsignedType(w3)) {
                object = this.a(w2);
            }
            return (C)object;
        }
        return null;
    }

    protected abstract List<T> a(List<? extends A> var1);

    protected abstract List<T> a(List<? extends A> var1, List<? extends A> var2, kotlin.reflect.jvm.internal.impl.a.a.e var3);

    @Override
    public List<A> a(a.ac object, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        j.b(object, "proto");
        j.b(c2, "nameResolver");
        object = ((i.c)object).c(kotlin.reflect.jvm.internal.impl.d.c.b.f);
        j.a(object, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Object object2 = (Iterable)object;
        object = new ArrayList<E>(kotlin.a.m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            a.a a2 = (a.a)object2.next();
            j.a((Object)a2, "it");
            object.add(this.a(a2, c2));
        }
        return (List)object;
    }

    @Override
    public List<A> a(a.ag object, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        j.b(object, "proto");
        j.b(c2, "nameResolver");
        object = ((i.c)object).c(kotlin.reflect.jvm.internal.impl.d.c.b.h);
        j.a(object, "proto.getExtension(JvmPr\u2026.typeParameterAnnotation)");
        Object object2 = (Iterable)object;
        object = new ArrayList<E>(kotlin.a.m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            a.a a2 = (a.a)object2.next();
            j.a((Object)a2, "it");
            object.add(this.a(a2, c2));
        }
        return (List)object;
    }

    @Override
    public List<A> a(w.a object) {
        j.b(object, "container");
        Object object2 = this.b((w.a)object);
        if (object2 != null) {
            object = new ArrayList<E>(1);
            object2.a(new n.c((ArrayList)object){
                final /* synthetic */ ArrayList b;
                {
                    this.b = arrayList;
                }

                @Override
                public n.a a(kotlin.reflect.jvm.internal.impl.e.a a2, an an2) {
                    j.b(a2, "classId");
                    j.b(an2, "source");
                    return this.b(a2, an2, this.b);
                }

                @Override
                public void a() {
                }
            }, this.a((n)object2));
            return (List)object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Class for loading annotations is not found: ");
        ((StringBuilder)object2).append(((w.a)object).a());
        throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString().toString());
    }

    @Override
    public List<A> a(w w2, a.k object) {
        j.b(w2, "container");
        j.b(object, "proto");
        q.a a2 = q.a;
        object = w2.b().a(((a.k)object).e());
        String string2 = ((w.a)w2).e().h();
        j.a((Object)string2, "(container as ProtoConta\u2026Class).classId.asString()");
        return a.a(this, w2, a2.b((String)object, kotlin.reflect.jvm.internal.impl.d.c.a.c.a(string2)), false, false, null, false, 60, null);
    }

    @Override
    public List<T> a(w list, kotlin.reflect.jvm.internal.impl.f.q list2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a object) {
        j.b(list, "container");
        j.b(list2, "proto");
        j.b(object, "kind");
        if (object == kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.b) {
            boolean bl2;
            list2 = (a.w)((Object)list2);
            q q2 = a.a(this, (a.w)((Object)list2), ((w)((Object)list)).b(), ((w)((Object)list)).c(), false, true, 8, null);
            object = a.a(this, (a.w)((Object)list2), ((w)((Object)list)).b(), ((w)((Object)list)).c(), true, false, 16, null);
            Boolean bl3 = kotlin.reflect.jvm.internal.impl.d.b.b.w.a(((a.w)((Object)list2)).e());
            boolean bl4 = kotlin.reflect.jvm.internal.impl.d.c.a.j.a((a.w)((Object)list2));
            list2 = q2 != null ? a.a(this, (w)((Object)list), q2, true, false, bl3, bl4, 8, null) : null;
            if (list2 == null) {
                list2 = kotlin.a.m.a();
            }
            list = object != null ? this.a((w)((Object)list), (q)object, true, true, bl3, bl4) : null;
            if (list == null) {
                list = kotlin.a.m.a();
            }
            bl4 = bl2 = false;
            if (object != null) {
                object = ((q)object).a();
                bl4 = bl2;
                if (object != null) {
                    bl4 = kotlin.i.n.b((CharSequence)object, (CharSequence)"$delegate", false, 2, null);
                }
            }
            object = bl4 ? kotlin.reflect.jvm.internal.impl.a.a.e.i : kotlin.reflect.jvm.internal.impl.a.a.e.a;
            return this.a(list2, list, (kotlin.reflect.jvm.internal.impl.a.a.e)((Object)object));
        }
        if ((list2 = this.a((kotlin.reflect.jvm.internal.impl.f.q)((Object)list2), ((w)((Object)list)).b(), ((w)((Object)list)).c(), (kotlin.reflect.jvm.internal.impl.serialization.deserialization.a)((Object)object))) != null) {
            return this.a(a.a(this, (w)((Object)list), (q)((Object)list2), false, false, null, false, 60, null));
        }
        return kotlin.a.m.a();
    }

    @Override
    public List<A> a(w w2, kotlin.reflect.jvm.internal.impl.f.q q2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a object, int n2, a.ak ak2) {
        j.b(w2, "container");
        j.b(q2, "callableProto");
        j.b(object, "kind");
        j.b(ak2, "proto");
        object = this.a(q2, w2.b(), w2.c(), (kotlin.reflect.jvm.internal.impl.serialization.deserialization.a)((Object)object));
        if (object != null) {
            int n3 = this.a(w2, q2);
            return a.a(this, w2, q.a.a((q)object, n2 + n3), false, false, null, false, 60, null);
        }
        return kotlin.a.m.a();
    }

    protected abstract n.a a(kotlin.reflect.jvm.internal.impl.e.a var1, an var2, List<A> var3);

    protected byte[] a(n n2) {
        j.b(n2, "kotlinClass");
        return null;
    }

    @Override
    public List<A> b(w w2, kotlin.reflect.jvm.internal.impl.f.q object, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a2) {
        j.b(w2, "container");
        j.b(object, "proto");
        j.b((Object)((Object)a2), "kind");
        object = this.a((kotlin.reflect.jvm.internal.impl.f.q)object, w2.b(), w2.c(), a2);
        if (object != null) {
            return a.a(this, w2, q.a.a((q)object, 0), false, false, null, false, 60, null);
        }
        return kotlin.a.m.a();
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

    private static final class b<A, C> {
        private final Map<q, List<A>> a;
        private final Map<q, C> b;

        public b(Map<q, ? extends List<? extends A>> map, Map<q, ? extends C> map2) {
            j.b(map, "memberAnnotations");
            j.b(map2, "propertyConstants");
            this.a = map;
            this.b = map2;
        }

        public final Map<q, List<A>> a() {
            return this.a;
        }

        public final Map<q, C> b() {
            return this.b;
        }
    }

}

