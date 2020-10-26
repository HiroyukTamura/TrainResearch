/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.f.a;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.h;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.r;
import kotlin.reflect.jvm.internal.impl.f.s;
import kotlin.reflect.jvm.internal.impl.f.z;

public abstract class i
extends kotlin.reflect.jvm.internal.impl.f.a
implements Serializable {
    protected i() {
    }

    protected i(a a2) {
    }

    static /* varargs */ Object a(Method object, Object object2, Object ... arrobject) {
        try {
            object = ((Method)object).invoke(object2, arrobject);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (!(throwable instanceof RuntimeException)) {
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
            }
            throw (RuntimeException)throwable;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
        }
    }

    static /* varargs */ Method a(Class object, String string2, Class ... object2) {
        try {
            object2 = ((Class)object).getMethod(string2, (Class<?>)object2);
            return object2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = String.valueOf(String.valueOf(((Class)object).getName()));
            string2 = String.valueOf(String.valueOf(string2));
            StringBuilder stringBuilder = new StringBuilder(((String)object).length() + 45 + string2.length());
            stringBuilder.append("Generated message class \"");
            stringBuilder.append((String)object);
            stringBuilder.append("\" missing method \"");
            stringBuilder.append(string2);
            stringBuilder.append("\".");
            throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
        }
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType ContainingType, Type Type2, q q2, j.b<?> b2, int n2, z.a a2, Class class_) {
        return new f<ContainingType, Type>(ContainingType, Type2, q2, new e(b2, n2, a2, false, false), class_);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType ContainingType, q q2, j.b<?> b2, int n2, z.a a2, boolean bl2, Class class_) {
        return new f(ContainingType, Collections.emptyList(), q2, new e(b2, n2, a2, true, bl2), class_);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static <MessageType extends q> boolean b(h<e> var0, MessageType var1_1, kotlin.reflect.jvm.internal.impl.f.e var2_2, kotlin.reflect.jvm.internal.impl.f.f var3_3, g var4_4, int var5_5) {
        block19 : {
            block18 : {
                block17 : {
                    block16 : {
                        var6_18 = z.a(var5_17);
                        var8_19 = var4_16.a(var1_1 /* !! */ , z.b(var5_17));
                        if (var8_19 == null) ** GOTO lbl-1000
                        if (var6_18 != h.a(var8_19.d.b(), false)) break block16;
                        var6_18 = 0;
                        ** GOTO lbl13
                    }
                    if (var8_19.d.d && var8_19.d.c.c() && var6_18 == h.a(var8_19.d.b(), true)) {
                        var6_18 = 0;
                        var7_20 = true;
                    } else lbl-1000: // 2 sources:
                    {
                        var6_18 = 1;
lbl13: // 2 sources:
                        var7_20 = false;
                    }
                    if (var6_18 != 0) {
                        return var2_14.a(var5_17, (kotlin.reflect.jvm.internal.impl.f.f)var3_15);
                    }
                    if (!var7_20) break block17;
                    var5_17 = var2_14.c(var2_14.s());
                    if (var8_19.d.b() == z.a.n) break block18;
                    while (var2_14.x() > 0) {
                        var1_5 = h.a((kotlin.reflect.jvm.internal.impl.f.e)var2_14, var8_19.d.b(), false);
                        var0.b(var8_19.d, var1_5);
                    }
                    break block19;
                }
                switch (1.a[var8_19.d.c().ordinal()]) {
                    default: {
                        var1_6 = h.a((kotlin.reflect.jvm.internal.impl.f.e)var2_14, var8_19.d.b(), false);
                        break;
                    }
                    case 2: {
                        var6_18 = var2_14.n();
                        var1_7 = var2_14 = var8_19.d.f().b(var6_18);
                        if (var2_14 != null) break;
                        var3_15.p(var5_17);
                        var3_15.d(var6_18);
                        return true;
                    }
                    case 1: {
                        var3_15 = null;
                        var1_8 = var3_15;
                        if (!var8_19.d.d()) {
                            var9_21 = (q)var0.b(var8_19.d);
                            var1_9 = var3_15;
                            if (var9_21 != null) {
                                var1_10 = var9_21.m();
                            }
                        }
                        var3_15 = var1_11;
                        if (var1_11 == null) {
                            var3_15 = var8_19.c().n();
                        }
                        if (var8_19.d.b() == z.a.j) {
                            var2_14.a(var8_19.b(), (q.a)var3_15, (g)var4_16);
                        } else {
                            var2_14.a((q.a)var3_15, (g)var4_16);
                        }
                        var1_12 = var3_15.l();
                    }
                }
                if (var8_19.d.d()) {
                    var0.b(var8_19.d, var8_19.c(var1_13));
                    return true;
                }
                var0.a(var8_19.d, var8_19.c(var1_13));
                return true;
            }
            while (var2_14.x() > 0) {
                var6_18 = var2_14.n();
                var1_3 = var8_19.d.f().b(var6_18);
                if (var1_3 == null) {
                    return true;
                }
                var0.b(var8_19.d, var8_19.c(var1_3));
            }
        }
        var2_14.d(var5_17);
        return true;
    }

    protected void O() {
    }

    protected boolean a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.f f2, g g2, int n2) {
        return e2.a(n2, f2);
    }

    @Override
    public s<? extends q> c() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public static abstract class a<MessageType extends i, BuilderType extends a>
    extends a.a<BuilderType> {
        private kotlin.reflect.jvm.internal.impl.f.d a = kotlin.reflect.jvm.internal.impl.f.d.a;

        protected a() {
        }

        public final BuilderType a(kotlin.reflect.jvm.internal.impl.f.d d2) {
            this.a = d2;
            return (BuilderType)this;
        }

        public abstract BuilderType a(MessageType var1);

        @Override
        public /* synthetic */ Object clone() {
            return this.j();
        }

        public abstract MessageType i();

        public BuilderType j() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override
        public /* synthetic */ a.a k() {
            return this.j();
        }

        @Override
        public /* synthetic */ q o() {
            return this.i();
        }

        public final kotlin.reflect.jvm.internal.impl.f.d x() {
            return this.a;
        }
    }

    public static abstract class b<MessageType extends c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends a<MessageType, BuilderType>
    implements d<MessageType> {
        private h<e> a = h.b();
        private boolean b;

        protected b() {
        }

        private void a() {
            if (!this.b) {
                this.a = this.a.d();
                this.b = true;
            }
        }

        private h<e> b() {
            this.a.c();
            this.b = false;
            return this.a;
        }

        @Override
        protected final void a(MessageType MessageType) {
            this.a();
            this.a.a(MessageType.a);
        }

        @Override
        public /* synthetic */ Object clone() {
            return this.u();
        }

        @Override
        public /* synthetic */ a j() {
            return this.u();
        }

        @Override
        public /* synthetic */ a.a k() {
            return this.u();
        }

        public BuilderType u() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean y() {
            return this.a.f();
        }
    }

    public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements d<MessageType> {
        private final h<e> a;

        protected c() {
            this.a = h.a();
        }

        protected c(b<MessageType, ?> b2) {
            this.a = b2.b();
        }

        private void d(f<MessageType, ?> f2) {
            if (f2.a() == this.o()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override
        protected void O() {
            this.a.c();
        }

        protected boolean P() {
            return this.a.f();
        }

        protected c<MessageType> Q() {
            return new a(false);
        }

        protected int R() {
            return this.a.g();
        }

        public final <Type> Type a(f<MessageType, List<Type>> f2, int n2) {
            this.d(f2);
            return (Type)f2.b(this.a.a(f2.d, n2));
        }

        @Override
        protected boolean a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.f f2, g g2, int n2) {
            return i.b(this.a, this.o(), e2, f2, g2, n2);
        }

        public final <Type> boolean a(f<MessageType, Type> f2) {
            this.d(f2);
            return this.a.a(f2.d);
        }

        public final <Type> int b(f<MessageType, List<Type>> f2) {
            this.d(f2);
            return this.a.c(f2.d);
        }

        public final <Type> Type c(f<MessageType, Type> f2) {
            this.d(f2);
            Object object = this.a.b(f2.d);
            if (object == null) {
                return f2.b;
            }
            return (Type)f2.a(object);
        }

        protected class a {
            private final Iterator<Map.Entry<e, Object>> b;
            private Map.Entry<e, Object> c;
            private final boolean d;

            private a(boolean bl2) {
                this.b = c.this.a.e();
                if (this.b.hasNext()) {
                    this.c = this.b.next();
                }
                this.d = bl2;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void a(int n2, kotlin.reflect.jvm.internal.impl.f.f f2) {
                while (this.c != null && this.c.getKey().a() < n2) {
                    Map.Entry<e, Object> entry = this.c.getKey();
                    if (this.d && ((e)((Object)entry)).c() == z.b.i && !((e)((Object)entry)).d()) {
                        f2.c(((e)((Object)entry)).a(), (q)this.c.getValue());
                    } else {
                        h.a(entry, this.c.getValue(), f2);
                    }
                    entry = this.b.hasNext() ? this.b.next() : null;
                    this.c = entry;
                }
            }
        }

    }

    public static interface d
    extends r {
    }

    static final class e
    implements h.a<e> {
        final j.b<?> a;
        final int b;
        final z.a c;
        final boolean d;
        final boolean e;

        e(j.b<?> b2, int n2, z.a a2, boolean bl2, boolean bl3) {
            this.a = b2;
            this.b = n2;
            this.c = a2;
            this.d = bl2;
            this.e = bl3;
        }

        @Override
        public int a() {
            return this.b;
        }

        public int a(e e2) {
            return this.b - e2.b;
        }

        @Override
        public q.a a(q.a a2, q q2) {
            return ((a)a2).a((i)q2);
        }

        @Override
        public z.a b() {
            return this.c;
        }

        @Override
        public z.b c() {
            return this.c.a();
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this.a((e)object);
        }

        @Override
        public boolean d() {
            return this.d;
        }

        @Override
        public boolean e() {
            return this.e;
        }

        public j.b<?> f() {
            return this.a;
        }
    }

    public static class f<ContainingType extends q, Type> {
        final ContainingType a;
        final Type b;
        final q c;
        final e d;
        final Class e;
        final Method f;

        /*
         * Enabled aggressive block sorting
         */
        f(ContainingType object, Type Type2, q q2, e e2, Class class_) {
            void var4_7;
            void var1_3;
            void var2_5;
            void var3_6;
            void var5_8;
            if (object == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (var4_7.b() == z.a.k && var3_6 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.a = object;
            this.b = var2_5;
            this.c = var3_6;
            this.d = var4_7;
            this.e = var5_8;
            if (j.a.class.isAssignableFrom((Class<?>)var5_8)) {
                Method method = i.a((Class)var5_8, "valueOf", Integer.TYPE);
            } else {
                Object var1_4 = null;
            }
            this.f = var1_3;
        }

        Object a(Object iterator) {
            if (this.d.d()) {
                if (this.d.c() == z.b.h) {
                    ArrayList<Object> arrayList = new ArrayList<Object>();
                    iterator = ((List)((Object)iterator)).iterator();
                    while (iterator.hasNext()) {
                        arrayList.add(this.b(iterator.next()));
                    }
                    return arrayList;
                }
                return iterator;
            }
            return this.b(iterator);
        }

        public ContainingType a() {
            return this.a;
        }

        public int b() {
            return this.d.a();
        }

        Object b(Object object) {
            Object object2 = object;
            if (this.d.c() == z.b.h) {
                object2 = i.a(this.f, null, (Integer)object);
            }
            return object2;
        }

        Object c(Object object) {
            Object object2 = object;
            if (this.d.c() == z.b.h) {
                object2 = ((j.a)object).a();
            }
            return object2;
        }

        public q c() {
            return this.c;
        }
    }

}

