/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.g;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.j;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.f.q;

public final class i {
    public static final a a = new a(null);
    private final b b;
    private final a.am.c c;
    private final kotlin.a d;
    private final Integer e;
    private final String f;

    public i(b b2, a.am.c c2, kotlin.a a2, Integer n2, String string2) {
        kotlin.e.b.j.b(b2, "version");
        kotlin.e.b.j.b(c2, "kind");
        kotlin.e.b.j.b((Object)a2, "level");
        this.b = b2;
        this.c = c2;
        this.d = a2;
        this.e = n2;
        this.f = string2;
    }

    public final b a() {
        return this.b;
    }

    public final a.am.c b() {
        return this.c;
    }

    public String toString() {
        CharSequence charSequence;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("since ");
        stringBuilder.append(this.b);
        stringBuilder.append(' ');
        stringBuilder.append((Object)this.d);
        if (this.e != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(" error ");
            ((StringBuilder)charSequence).append(this.e);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        stringBuilder.append((String)charSequence);
        if (this.f != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(": ");
            ((StringBuilder)charSequence).append(this.f);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final List<i> a(q collection, c object, k k2) {
            block8 : {
                block4 : {
                    block7 : {
                        block6 : {
                            block5 : {
                                block3 : {
                                    kotlin.e.b.j.b(collection, "proto");
                                    kotlin.e.b.j.b(object, "nameResolver");
                                    kotlin.e.b.j.b(k2, "table");
                                    if (!(collection instanceof a.c)) break block3;
                                    collection = ((a.c)((Object)collection)).H();
                                    break block4;
                                }
                                if (!(collection instanceof a.e)) break block5;
                                collection = ((a.e)((Object)collection)).j();
                                break block4;
                            }
                            if (!(collection instanceof a.o)) break block6;
                            collection = ((a.o)((Object)collection)).C();
                            break block4;
                        }
                        if (!(collection instanceof a.w)) break block7;
                        collection = ((a.w)((Object)collection)).E();
                        break block4;
                    }
                    if (!(collection instanceof a.ad)) break block8;
                    collection = ((a.ad)((Object)collection)).y();
                }
                kotlin.e.b.j.a(collection, "ids");
                Object object2 = collection;
                collection = new ArrayList();
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    Object object3 = (Integer)object2.next();
                    a a2 = i.a;
                    kotlin.e.b.j.a(object3, "id");
                    if ((object3 = a2.a((Integer)object3, (c)object, k2)) == null) continue;
                    collection.add((Integer)object3);
                }
                return (List)collection;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Unexpected declaration: ");
            ((StringBuilder)object).append(collection.getClass());
            throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
        }

        public final i a(int n2, c object, k object2) {
            kotlin.e.b.j.b(object, "nameResolver");
            kotlin.e.b.j.b(object2, "table");
            a.am am2 = ((k)object2).a(n2);
            String string2 = null;
            if (am2 != null) {
                Object object3 = b.b;
                object2 = am2.d() ? Integer.valueOf(am2.e()) : null;
                Integer n3 = am2.f() ? Integer.valueOf(am2.g()) : null;
                object3 = ((b.a)object3).a((Integer)object2, n3);
                object2 = am2.k();
                if (object2 == null) {
                    kotlin.e.b.j.a();
                }
                switch (j.a[((Enum)object2).ordinal()]) {
                    default: {
                        throw new m();
                    }
                    case 3: {
                        object2 = kotlin.a.c;
                        break;
                    }
                    case 2: {
                        object2 = kotlin.a.b;
                        break;
                    }
                    case 1: {
                        object2 = kotlin.a.a;
                    }
                }
                n3 = am2.l() ? Integer.valueOf(am2.p()) : null;
                if (am2.q()) {
                    string2 = object.a(am2.r());
                }
                object = am2.t();
                kotlin.e.b.j.a(object, "info.versionKind");
                return new i((b)object3, (a.am.c)object, (kotlin.a)((Object)object2), n3, string2);
            }
            return null;
        }
    }

    public static final class b {
        public static final b a;
        public static final a b;
        private final int c;
        private final int d;
        private final int e;

        static {
            b = new a(null);
            a = new b(256, 256, 256);
        }

        public b(int n2, int n3, int n4) {
            this.c = n2;
            this.d = n3;
            this.e = n4;
        }

        public /* synthetic */ b(int n2, int n3, int n4, int n5, g g2) {
            if ((n5 & 4) != 0) {
                n4 = 0;
            }
            this(n2, n3, n4);
        }

        /*
         * Enabled aggressive block sorting
         */
        public final String a() {
            int n2;
            StringBuilder stringBuilder;
            if (this.e == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.c);
                stringBuilder.append('.');
                n2 = this.d;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.c);
                stringBuilder.append('.');
                stringBuilder.append(this.d);
                stringBuilder.append('.');
                n2 = this.e;
            }
            stringBuilder.append(n2);
            return stringBuilder.toString();
        }

        public boolean equals(Object object) {
            if (this != object) {
                if (object instanceof b) {
                    object = (b)object;
                    boolean bl2 = this.c == ((b)object).c;
                    if (bl2 && (bl2 = this.d == ((b)object).d) && (bl2 = this.e == ((b)object).e)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.c * 31 + this.d) * 31 + this.e;
        }

        public String toString() {
            return this.a();
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(g g2) {
                this();
            }

            public final b a(Integer n2, Integer n3) {
                if (n3 != null) {
                    return new b(n3 & 255, n3 >> 8 & 255, n3 >> 16 & 255);
                }
                if (n2 != null) {
                    return new b(n2 & 7, n2 >> 3 & 15, n2 >> 7 & 127);
                }
                return b.a;
            }
        }

    }

}

