/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.d.c.a.b;
import kotlin.reflect.jvm.internal.impl.d.c.a.c;
import kotlin.reflect.jvm.internal.impl.d.c.a.e;
import kotlin.reflect.jvm.internal.impl.d.c.a.f;
import kotlin.reflect.jvm.internal.impl.d.c.a.h;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.i;

public final class j {
    public static final j a = new j();
    private static final g b;

    static {
        g g2 = g.a();
        kotlin.reflect.jvm.internal.impl.d.c.b.a(g2);
        kotlin.e.b.j.a((Object)g2, "ExtensionRegistryLite.ne\u2026f::registerAllExtensions)");
        b = g2;
    }

    private j() {
    }

    private final String a(a.ac ac2, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        if (ac2.s()) {
            return c.a(c2.b(ac2.t()));
        }
        return null;
    }

    public static final o<h, a.c> a(byte[] object, String[] arrstring) {
        kotlin.e.b.j.b(object, "bytes");
        kotlin.e.b.j.b(arrstring, "strings");
        InputStream inputStream = new ByteArrayInputStream((byte[])object);
        object = a;
        inputStream = inputStream;
        return new o<h, a.c>(j.super.a(inputStream, arrstring), a.c.a(inputStream, b));
    }

    public static final o<h, a.c> a(String[] arrstring, String[] arrstring2) {
        kotlin.e.b.j.b(arrstring, "data");
        kotlin.e.b.j.b(arrstring2, "strings");
        arrstring = b.a(arrstring);
        kotlin.e.b.j.a((Object)arrstring, "BitEncoding.decodeBytes(data)");
        return j.a((byte[])arrstring, arrstring2);
    }

    private final h a(InputStream object, String[] arrstring) {
        object = b.g.a((InputStream)object, b);
        kotlin.e.b.j.a(object, "JvmProtoBuf.StringTableT\u2026this, EXTENSION_REGISTRY)");
        return new h((b.g)object, arrstring);
    }

    public static final boolean a(a.w serializable) {
        kotlin.e.b.j.b(serializable, "proto");
        b.a a2 = e.a.a();
        serializable = ((i.c)serializable).c(kotlin.reflect.jvm.internal.impl.d.c.b.e);
        kotlin.e.b.j.a((Object)serializable, "proto.getExtension(JvmProtoBuf.flags)");
        serializable = a2.a(((Number)serializable).intValue());
        kotlin.e.b.j.a((Object)serializable, "JvmFlags.IS_MOVED_FROM_I\u2026nsion(JvmProtoBuf.flags))");
        return (Boolean)serializable;
    }

    public static final o<h, a.s> b(byte[] object, String[] arrstring) {
        kotlin.e.b.j.b(object, "bytes");
        kotlin.e.b.j.b(arrstring, "strings");
        InputStream inputStream = new ByteArrayInputStream((byte[])object);
        object = a;
        inputStream = inputStream;
        return new o<h, a.s>(j.super.a(inputStream, arrstring), a.s.a(inputStream, b));
    }

    public static final o<h, a.s> b(String[] arrstring, String[] arrstring2) {
        kotlin.e.b.j.b(arrstring, "data");
        kotlin.e.b.j.b(arrstring2, "strings");
        arrstring = b.a(arrstring);
        kotlin.e.b.j.a((Object)arrstring, "BitEncoding.decodeBytes(data)");
        return j.b((byte[])arrstring, arrstring2);
    }

    public static final o<h, a.o> c(String[] object, String[] arrstring) {
        kotlin.e.b.j.b(object, "data");
        kotlin.e.b.j.b(arrstring, "strings");
        InputStream inputStream = new ByteArrayInputStream(b.a((String[])object));
        object = a;
        inputStream = inputStream;
        return new o<h, a.o>(j.super.a(inputStream, arrstring), a.o.a(inputStream, b));
    }

    public final f.a a(a.w object, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h2) {
        block2 : {
            int n2;
            block4 : {
                block3 : {
                    kotlin.e.b.j.b(object, "proto");
                    kotlin.e.b.j.b(c2, "nameResolver");
                    kotlin.e.b.j.b(h2, "typeTable");
                    i i2 = (i.c)object;
                    i.f<a.w, b.e> f2 = kotlin.reflect.jvm.internal.impl.d.c.b.d;
                    kotlin.e.b.j.a(f2, "JvmProtoBuf.propertySignature");
                    i2 = kotlin.reflect.jvm.internal.impl.d.b.f.a(i2, f2);
                    if (i2 == null) break block2;
                    i2 = ((b.e)i2).d() ? ((b.e)i2).e() : null;
                    n2 = i2 != null && ((b.a)i2).d() ? ((b.a)i2).e() : ((a.w)object).k();
                    if (i2 == null || !((b.a)i2).f()) break block3;
                    object = c2.a(((b.a)i2).g());
                    break block4;
                }
                if ((object = this.a(kotlin.reflect.jvm.internal.impl.d.b.g.a((a.w)object, h2), c2)) == null) break block2;
            }
            return new f.a(c2.a(n2), (String)object);
        }
        return null;
    }

    public final f.b a(a.e object, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h2) {
        kotlin.e.b.j.b(object, "proto");
        kotlin.e.b.j.b(c2, "nameResolver");
        kotlin.e.b.j.b(h2, "typeTable");
        Iterator iterator = (i.c)object;
        Object object2 = kotlin.reflect.jvm.internal.impl.d.c.b.a;
        kotlin.e.b.j.a(object2, "JvmProtoBuf.constructorSignature");
        iterator = kotlin.reflect.jvm.internal.impl.d.b.f.a(iterator, object2);
        if (iterator != null && ((b.c)((Object)iterator)).f()) {
            object = c2.a(((b.c)((Object)iterator)).g());
        } else {
            object = ((a.e)object).f();
            kotlin.e.b.j.a(object, "proto.valueParameterList");
            iterator = (Iterable)object;
            object = new ArrayList(m.a(iterator, 10));
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                object2 = (a.ak)iterator.next();
                j j2 = a;
                kotlin.e.b.j.a(object2, "it");
                object2 = j2.a(kotlin.reflect.jvm.internal.impl.d.b.g.a((a.ak)object2, h2), c2);
                if (object2 != null) {
                    object.add(object2);
                    continue;
                }
                return null;
            }
            object = m.a((List)object, "", "(", ")V", 0, null, null, 56, null);
        }
        return new f.b("<init>", (String)object);
    }

    public final f.b a(a.o object, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h object2) {
        block8 : {
            int n2;
            block7 : {
                Iterator iterator;
                Object object3;
                block6 : {
                    kotlin.e.b.j.b(object, "proto");
                    kotlin.e.b.j.b(c2, "nameResolver");
                    kotlin.e.b.j.b(object2, "typeTable");
                    object3 = (i.c)object;
                    iterator = kotlin.reflect.jvm.internal.impl.d.c.b.b;
                    kotlin.e.b.j.a(iterator, "JvmProtoBuf.methodSignature");
                    object3 = kotlin.reflect.jvm.internal.impl.d.b.f.a(object3, iterator);
                    n2 = object3 != null && ((b.c)object3).d() ? ((b.c)object3).e() : ((a.o)object).k();
                    if (object3 == null || !((b.c)object3).f()) break block6;
                    object = c2.a(((b.c)object3).g());
                    break block7;
                }
                object3 = m.b(kotlin.reflect.jvm.internal.impl.d.b.g.b((a.o)object, (kotlin.reflect.jvm.internal.impl.d.b.h)object2));
                iterator = ((a.o)object).y();
                kotlin.e.b.j.a((Object)iterator, "proto.valueParameterList");
                Object object4 = (Iterable)((Object)iterator);
                iterator = new ArrayList(m.a(object4, 10));
                object4 = object4.iterator();
                while (object4.hasNext()) {
                    a.ak ak2 = (a.ak)object4.next();
                    kotlin.e.b.j.a((Object)ak2, "it");
                    iterator.add(kotlin.reflect.jvm.internal.impl.d.b.g.a(ak2, (kotlin.reflect.jvm.internal.impl.d.b.h)object2));
                }
                iterator = m.b(object3, (List)((Object)iterator));
                object3 = new ArrayList(m.a(iterator, 10));
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    object4 = (a.ac)iterator.next();
                    if ((object4 = a.a((a.ac)object4, c2)) != null) {
                        object3.add(object4);
                        continue;
                    }
                    return null;
                }
                object3 = (List)object3;
                if ((object = this.a(kotlin.reflect.jvm.internal.impl.d.b.g.a((a.o)object, (kotlin.reflect.jvm.internal.impl.d.b.h)object2), c2)) == null) break block8;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(m.a((Iterable)object3, "", "(", ")", 0, null, null, 56, null));
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            }
            return new f.b(c2.a(n2), (String)object);
        }
        return null;
    }

    public final g a() {
        return b;
    }
}

