/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.d;
import com.b.a.f;
import com.b.a.k;
import com.b.a.p;
import com.b.a.r;
import com.b.a.t;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class s {
    static final List<f.a> a = new ArrayList<f.a>(5);
    private final List<f.a> b;
    private final ThreadLocal<c> c = new ThreadLocal();
    private final Map<Object, f<?>> d = new LinkedHashMap();

    static {
        a.add(t.a);
        a.add(d.a);
        a.add(r.a);
        a.add(com.b.a.a.a);
        a.add(com.b.a.c.a);
    }

    s(a a2) {
        ArrayList<f.a> arrayList = new ArrayList<f.a>(a2.a.size() + a.size());
        arrayList.addAll(a2.a);
        arrayList.addAll(a);
        this.b = Collections.unmodifiableList(arrayList);
    }

    private Object b(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        return Arrays.asList(type, set);
    }

    @CheckReturnValue
    public <T> f<T> a(Class<T> class_) {
        return this.a(class_, com.b.a.a.a.a);
    }

    @CheckReturnValue
    public <T> f<T> a(Type type) {
        return this.a(type, com.b.a.a.a.a);
    }

    @CheckReturnValue
    public <T> f<T> a(Type type, Set<? extends Annotation> set) {
        return this.a(type, set, null);
    }

    /*
     * Exception decompiling
     */
    @CheckReturnValue
    public <T> f<T> a(Type var1_1, Set<? extends Annotation> var2_2, @Nullable String var3_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 8[FORLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static final class a {
        final List<f.a> a = new ArrayList<f.a>();

        public a a(f.a a2) {
            if (a2 != null) {
                this.a.add(a2);
                return this;
            }
            throw new IllegalArgumentException("factory == null");
        }

        @CheckReturnValue
        public s a() {
            return new s(this);
        }
    }

    static final class b<T>
    extends f<T> {
        final Type a;
        @Nullable
        final String b;
        final Object c;
        @Nullable
        f<T> d;

        b(Type type, @Nullable String string2, Object object) {
            this.a = type;
            this.b = string2;
            this.c = object;
        }

        @Override
        public T a(k k2) {
            if (this.d != null) {
                return this.d.a(k2);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        @Override
        public void a(p p2, T t2) {
            if (this.d != null) {
                this.d.a(p2, t2);
                return;
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public String toString() {
            if (this.d != null) {
                return this.d.toString();
            }
            return Object.super.toString();
        }
    }

    final class c {
        final List<b<?>> a = new ArrayList();
        final Deque<b<?>> b = new ArrayDeque();
        boolean c;

        c() {
        }

        <T> f<T> a(Type f2, @Nullable String string2, Object object) {
            int n2 = this.a.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                b<?> b2 = this.a.get(i2);
                if (!b2.c.equals(object)) continue;
                this.b.add(b2);
                f2 = b2;
                if (b2.d != null) {
                    f2 = b2.d;
                }
                return f2;
            }
            f2 = new b((Type)((Object)f2), string2, object);
            this.a.add((b<?>)f2);
            this.b.add((b<?>)f2);
            return null;
        }

        IllegalArgumentException a(IllegalArgumentException illegalArgumentException) {
            if (this.c) {
                return illegalArgumentException;
            }
            this.c = true;
            if (this.b.size() == 1 && this.b.getFirst().b == null) {
                return illegalArgumentException;
            }
            StringBuilder stringBuilder = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<b<?>> iterator = this.b.descendingIterator();
            while (iterator.hasNext()) {
                b<?> b2 = iterator.next();
                stringBuilder.append("\nfor ");
                stringBuilder.append(b2.a);
                if (b2.b == null) continue;
                stringBuilder.append(' ');
                stringBuilder.append(b2.b);
            }
            return new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
        }

        <T> void a(f<T> f2) {
            this.b.getLast().d = f2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void a(boolean bl2) {
            this.b.removeLast();
            if (!this.b.isEmpty()) {
                return;
            }
            s.this.c.remove();
            if (!bl2) {
                return;
            }
            Map map = s.this.d;
            synchronized (map) {
                int n2 = 0;
                int n3 = this.a.size();
                while (n2 < n3) {
                    b<?> b2 = this.a.get(n2);
                    f f2 = s.this.d.put(b2.c, b2.d);
                    if (f2 != null) {
                        b2.d = f2;
                        s.this.d.put(b2.c, f2);
                    }
                    ++n2;
                }
                return;
            }
        }
    }

}

