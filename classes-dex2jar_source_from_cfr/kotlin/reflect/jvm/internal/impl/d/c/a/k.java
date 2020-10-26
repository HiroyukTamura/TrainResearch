/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.d;
import kotlin.reflect.jvm.internal.impl.d.c.a;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.d.c.a.l;
import kotlin.reflect.jvm.internal.impl.d.c.a.m;
import kotlin.reflect.jvm.internal.impl.f.t;
import kotlin.w;

public final class k {
    public static final k a;
    public static final k b;
    public static final a c;
    private final Map<String, m> d;
    private final kotlin.reflect.jvm.internal.impl.d.c.a.a e;
    private final String f;

    static {
        c = new a(null);
        a = new k(af.<String, m>a(), new kotlin.reflect.jvm.internal.impl.d.c.a.a(kotlin.a.m.<String>a()), "EMPTY");
        b = new k(af.<String, m>a(), new kotlin.reflect.jvm.internal.impl.d.c.a.a(kotlin.a.m.<String>a()), "CORRUPTED");
    }

    private k(Map<String, m> map, kotlin.reflect.jvm.internal.impl.d.c.a.a a2, String string2) {
        this.d = map;
        this.e = a2;
        this.f = string2;
    }

    public /* synthetic */ k(Map map, kotlin.reflect.jvm.internal.impl.d.c.a.a a2, String string2, kotlin.e.b.g g2) {
        this(map, a2, string2);
    }

    public final Map<String, m> a() {
        return this.d;
    }

    public String toString() {
        return this.f;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final k a(byte[] object, String string2, boolean bl2, boolean bl3, b<? super g, w> object2) {
            Object object3;
            int n2;
            Iterator iterator;
            Object object4;
            int n3;
            j.b(string2, "debugName");
            j.b(object2, "reportIncompatibleVersionError");
            if (object == null) {
                return k.a;
            }
            object = new DataInputStream(new ByteArrayInputStream((byte[])object));
            try {
                object4 = new int[((DataInputStream)object).readInt()];
                n3 = ((int[])object4).length;
            }
            catch (IOException iOException) {
                return k.b;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                object4[n2] = ((DataInputStream)object).readInt();
                continue;
            }
            object4 = new g(Arrays.copyOf((int[])object4, ((int[])object4).length));
            if (!bl2 && !((g)object4).a()) {
                object2.a(object4);
                return k.a;
            }
            Object object5 = a.a.a((InputStream)object);
            if (object5 == null) return k.a;
            object4 = new LinkedHashMap();
            for (a.c c2 : ((a.a)object5).d()) {
                j.a((Object)c2, "proto");
                iterator = c2.e();
                object3 = (Map)object4;
                j.a((Object)iterator, "packageFqName");
                object = object2 = object3.get(iterator);
                if (object2 == null) {
                    object = new m((String)((Object)iterator));
                    object3.put(iterator, object);
                }
                object2 = (m)object;
                object = c2.g();
                j.a(object, "proto.shortClassNameList");
                object3 = ((Iterable)object).iterator();
                n2 = 0;
                while (object3.hasNext()) {
                    String string3 = (String)object3.next();
                    object = c2.j();
                    j.a(object, "proto.multifileFacadeShortNameIdList");
                    object = (Integer)kotlin.a.m.c(object, n2);
                    object = object != null ? Integer.valueOf((Integer)object - 1) : null;
                    if (object != null) {
                        t t2 = c2.k();
                        j.a((Object)t2, "proto.multifileFacadeShortNameList");
                        n3 = ((Number)object).intValue();
                        object = (String)kotlin.a.m.c(t2, n3);
                    } else {
                        object = null;
                    }
                    object = object != null ? l.a(iterator, (String)object) : null;
                    j.a((Object)string3, "partShortName");
                    ((m)object2).a(l.a(iterator, string3), (String)object);
                    ++n2;
                }
                if (!bl3) continue;
                object = c2.l();
                j.a(object, "proto.classWithJvmPackageNameShortNameList");
                iterator = ((Iterable)object).iterator();
                n2 = 0;
                while (iterator.hasNext()) {
                    object3 = (String)iterator.next();
                    object = c2.p();
                    j.a(object, "proto.classWithJvmPackageNamePackageIdList");
                    object = (Integer)kotlin.a.m.c(object, n2);
                    if (object == null) {
                        object = c2.p();
                        j.a(object, "proto.classWithJvmPackageNamePackageIdList");
                        object = (Integer)kotlin.a.m.i(object);
                    }
                    if (object != null) {
                        n3 = (Integer)object;
                        object = ((a.a)object5).j();
                        j.a(object, "moduleProto.jvmPackageNameList");
                        object = (String)kotlin.a.m.c((List)object, n3);
                        if (object != null) {
                            j.a(object3, "partShortName");
                            ((m)object2).a(l.a((String)object, (String)object3), null);
                        }
                    }
                    ++n2;
                }
            }
            for (a.c c2 : ((a.a)object5).f()) {
                iterator = (Map)object4;
                j.a((Object)c2, "proto");
                object3 = c2.e();
                j.a(object3, "proto.packageFqName");
                object = object2 = iterator.get(object3);
                if (object2 == null) {
                    object = c2.e();
                    j.a(object, "proto.packageFqName");
                    object = new m((String)object);
                    iterator.put(object3, object);
                }
                object = (m)object;
                object2 = c2.g();
                j.a(object2, "proto.shortClassNameList");
                object2 = ((Iterable)object2).iterator();
                while (object2.hasNext()) {
                    ((m)object).a((String)object2.next());
                }
            }
            object = ((a.a)object5).l();
            j.a(object, "moduleProto.stringTable");
            object2 = ((a.a)object5).q();
            j.a(object2, "moduleProto.qualifiedNameTable");
            object = new d((a.aa)object, (a.y)object2);
            object2 = ((a.a)object5).r();
            j.a(object2, "moduleProto.annotationList");
            object5 = (Iterable)object2;
            object2 = new ArrayList(kotlin.a.m.a(object5, 10));
            object5 = object5.iterator();
            while (object5.hasNext()) {
                a.a a2 = (a.a)object5.next();
                j.a((Object)a2, "proto");
                object2.add(((d)object).b(a2.e()));
            }
            object = (List)object2;
            return new k((Map)object4, new kotlin.reflect.jvm.internal.impl.d.c.a.a((List<String>)object), string2, null);
        }
    }

}

