/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.a.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.t;

public final class a
implements kotlin.reflect.jvm.internal.impl.a.b.b {
    public static final a a = new a(null);
    private final i b;
    private final y c;

    public a(i i2, y y2) {
        j.b(i2, "storageManager");
        j.b(y2, "module");
        this.b = i2;
        this.c = y2;
    }

    @Override
    public Collection<e> a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "packageFqName");
        return al.a();
    }

    @Override
    public e a(kotlin.reflect.jvm.internal.impl.e.a object) {
        j.b(object, "classId");
        if (!((kotlin.reflect.jvm.internal.impl.e.a)object).d()) {
            if (((kotlin.reflect.jvm.internal.impl.e.a)object).f()) {
                return null;
            }
            Iterator iterator = ((kotlin.reflect.jvm.internal.impl.e.a)object).b().a();
            j.a((Object)iterator, "className");
            if (!n.b((CharSequence)((Object)iterator), (CharSequence)"Function", false, 2, null)) {
                return null;
            }
            Object object2 = ((kotlin.reflect.jvm.internal.impl.e.a)object).a();
            object = a;
            j.a(object2, "packageFqName");
            iterator = ((a)object).b((String)((Object)iterator), (kotlin.reflect.jvm.internal.impl.e.b)object2);
            if (iterator != null) {
                object = ((b)((Object)iterator)).b();
                int n2 = ((b)((Object)iterator)).c();
                iterator = this.c.a((kotlin.reflect.jvm.internal.impl.e.b)object2).f();
                object2 = new ArrayList();
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    Object t2 = iterator.next();
                    if (!(t2 instanceof BuiltInsPackageFragment)) continue;
                    object2.add(t2);
                }
                object2 = (BuiltInsPackageFragment)m.f((List)object2);
                return new kotlin.reflect.jvm.internal.impl.builtins.a.b(this.b, (ab)object2, (b.b)((Object)object), n2);
            }
        }
        return null;
    }

    @Override
    public boolean a(kotlin.reflect.jvm.internal.impl.e.b b2, f object) {
        boolean bl2;
        block5 : {
            boolean bl3;
            block4 : {
                j.b(b2, "packageFqName");
                j.b(object, "name");
                object = ((f)object).a();
                j.a(object, "string");
                bl3 = false;
                if (n.a((String)object, "Function", false, 2, null) || n.a((String)object, "KFunction", false, 2, null) || n.a((String)object, "SuspendFunction", false, 2, null)) break block4;
                bl2 = bl3;
                if (!n.a((String)object, "KSuspendFunction", false, 2, null)) break block5;
            }
            bl2 = bl3;
            if (a.a.b((String)object, b2) != null) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final Integer a(String string2) {
            int n2 = ((CharSequence)string2).length();
            int n3 = 0;
            if ((n2 = n2 == 0 ? 1 : 0) != 0) {
                return null;
            }
            int n4 = string2.length();
            int n5 = 0;
            for (n2 = n3; n2 < n4; ++n2) {
                n3 = string2.charAt(n2) - 48;
                if (n3 >= 0) {
                    if (9 < n3) {
                        return null;
                    }
                    n5 = n5 * 10 + n3;
                    continue;
                }
                return null;
            }
            return n5;
        }

        private final b b(String object, kotlin.reflect.jvm.internal.impl.e.b b2) {
            b.b b3 = b.b.e.a(b2, (String)object);
            b2 = null;
            if (b3 != null) {
                String string2 = b3.b();
                Object object2 = this;
                int n2 = string2.length();
                if (object != null) {
                    object = ((String)object).substring(n2);
                    j.a(object, "(this as java.lang.String).substring(startIndex)");
                    object2 = ((a)object2).a((String)object);
                    object = b2;
                    if (object2 != null) {
                        object = new b(b3, (Integer)object2);
                    }
                    return object;
                }
                throw new t("null cannot be cast to non-null type java.lang.String");
            }
            return null;
        }

        public final b.b a(String object, kotlin.reflect.jvm.internal.impl.e.b b2) {
            j.b(object, "className");
            j.b(b2, "packageFqName");
            object = this.b((String)object, b2);
            if (object != null) {
                return ((b)object).a();
            }
            return null;
        }
    }

    private static final class b {
        private final b.b a;
        private final int b;

        public b(b.b b2, int n2) {
            j.b((Object)b2, "kind");
            this.a = b2;
            this.b = n2;
        }

        public final b.b a() {
            return this.a;
        }

        public final b.b b() {
            return this.a;
        }

        public final int c() {
            return this.b;
        }

        public boolean equals(Object object) {
            if (this != object) {
                if (object instanceof b) {
                    boolean bl2;
                    object = (b)object;
                    if (j.a((Object)this.a, (Object)((b)object).a) && (bl2 = this.b == ((b)object).b)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            b.b b2 = this.a;
            int n2 = b2 != null ? ((Object)((Object)b2)).hashCode() : 0;
            return n2 * 31 + this.b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("KindWithArity(kind=");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(", arity=");
            stringBuilder.append(this.b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

}

