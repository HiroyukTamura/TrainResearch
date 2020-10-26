/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.g;
import androidx.lifecycle.j;
import androidx.lifecycle.r;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class b {
    static b a = new b();
    private final Map<Class, a> b = new HashMap<Class, a>();
    private final Map<Class, Boolean> c = new HashMap<Class, Boolean>();

    b() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private a a(Class class_, Method[] object) {
        void var2_4;
        int n2;
        Object object2 = class_.getSuperclass();
        HashMap<b, g.a> hashMap = new HashMap<b, g.a>();
        if (object2 != null && (object2 = this.b((Class)object2)) != null) {
            hashMap.putAll(((a)object2).b);
        }
        object2 = class_.getInterfaces();
        int n3 = ((Class<?>[])object2).length;
        for (n2 = 0; n2 < n3; ++n2) {
            for (Map.Entry<b, g.a> entry : this.b(object2[n2]).b.entrySet()) {
                this.a(hashMap, entry.getKey(), entry.getValue(), class_);
            }
        }
        if (object == null) {
            Method[] arrmethod = this.c(class_);
        }
        int n4 = ((void)var2_4).length;
        boolean bl2 = false;
        for (n3 = 0; n3 < n4; ++n3) {
            object2 = var2_4[n3];
            r r2 = ((Method)object2).getAnnotation(r.class);
            if (r2 == null) continue;
            Class<?>[] arrclass = ((Method)object2).getParameterTypes();
            if (arrclass.length > 0) {
                if (!arrclass[0].isAssignableFrom(j.class)) throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                n2 = 1;
            } else {
                n2 = 0;
            }
            g.a a2 = r2.a();
            if (arrclass.length > 1) {
                if (!arrclass[1].isAssignableFrom(g.a.class)) throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                if (a2 != g.a.ON_ANY) throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                n2 = 2;
            }
            if (arrclass.length > 2) throw new IllegalArgumentException("cannot have more than 2 params");
            this.a(hashMap, new b(n2, (Method)object2), a2, class_);
            bl2 = true;
        }
        a a3 = new a(hashMap);
        this.b.put(class_, a3);
        this.c.put(class_, bl2);
        return a3;
    }

    private void a(Map<b, g.a> object, b object2, g.a a2, Class class_) {
        g.a a3 = object.get(object2);
        if (a3 != null && a2 != a3) {
            object = ((b)object2).b;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Method ");
            ((StringBuilder)object2).append(((Method)object).getName());
            ((StringBuilder)object2).append(" in ");
            ((StringBuilder)object2).append(class_.getName());
            ((StringBuilder)object2).append(" already declared with different @OnLifecycleEvent value: previous");
            ((StringBuilder)object2).append(" value ");
            ((StringBuilder)object2).append((Object)a3);
            ((StringBuilder)object2).append(", new value ");
            ((StringBuilder)object2).append((Object)a2);
            throw new IllegalArgumentException(((StringBuilder)object2).toString());
        }
        if (a3 == null) {
            object.put((b)object2, (g.a)a2);
        }
    }

    private Method[] c(Class arrmethod) {
        try {
            arrmethod = arrmethod.getDeclaredMethods();
            return arrmethod;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", noClassDefFoundError);
        }
    }

    boolean a(Class class_) {
        if (this.c.containsKey(class_)) {
            return this.c.get(class_);
        }
        Method[] arrmethod = this.c(class_);
        int n2 = arrmethod.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrmethod[i2].getAnnotation(r.class) == null) continue;
            this.a(class_, arrmethod);
            return true;
        }
        this.c.put(class_, false);
        return false;
    }

    a b(Class class_) {
        a a2 = this.b.get(class_);
        if (a2 != null) {
            return a2;
        }
        return this.a(class_, null);
    }

    static class a {
        final Map<g.a, List<b>> a;
        final Map<b, g.a> b;

        a(Map<b, g.a> arrayList) {
            this.b = arrayList;
            this.a = new HashMap<g.a, List<b>>();
            for (Map.Entry<b, g.a> entry : arrayList.entrySet()) {
                g.a a2 = entry.getValue();
                List<b> list = this.a.get((Object)a2);
                arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList<b>();
                    this.a.put(a2, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void a(List<b> list, j j2, g.a a2, Object object) {
            if (list != null) {
                for (int i2 = list.size() - 1; i2 >= 0; --i2) {
                    list.get(i2).a(j2, a2, object);
                }
            }
        }

        void a(j j2, g.a a2, Object object) {
            a.a(this.a.get((Object)a2), j2, a2, object);
            a.a(this.a.get((Object)g.a.ON_ANY), j2, a2, object);
        }
    }

    static class b {
        final int a;
        final Method b;

        b(int n2, Method method) {
            this.a = n2;
            this.b = method;
            this.b.setAccessible(true);
        }

        /*
         * Exception decompiling
         */
        void a(j var1_1, g.a var2_4, Object var3_5) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:478)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
            // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null) {
                if (this.getClass() != object.getClass()) {
                    return false;
                }
                object = (b)object;
                return this.a == ((b)object).a && this.b.getName().equals(((b)object).b.getName());
            }
            return false;
        }

        public int hashCode() {
            return this.a * 31 + this.b.getName().hashCode();
        }
    }

}

