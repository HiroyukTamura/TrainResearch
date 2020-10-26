/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  com.google.errorprone.annotations.CanIgnoreReturnValue
 */
package a.a;

import a.a.b;
import a.b.f;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class e<T>
implements b<T> {
    private final Map<Class<? extends T>, javax.a.a<b.b<? extends T>>> a;

    e(Map<Class<? extends T>, javax.a.a<b.b<? extends T>>> map) {
        this.a = map;
    }

    private String c(T t2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Class<T> class_ : this.a.keySet()) {
            if (!class_.isInstance(t2)) continue;
            arrayList.add(class_.getCanonicalName());
        }
        Collections.sort(arrayList);
        if (arrayList.isEmpty()) {
            return String.format("No injector factory bound for Class<%s>", t2.getClass().getCanonicalName());
        }
        return String.format("No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?", t2.getClass().getCanonicalName(), arrayList);
    }

    @Override
    public void a(T t2) {
        if (this.b(t2)) {
            return;
        }
        throw new IllegalArgumentException(this.c(t2));
    }

    @CanIgnoreReturnValue
    public boolean b(T t2) {
        javax.a.a<b.b<T>> a2 = this.a.get(t2.getClass());
        if (a2 == null) {
            return false;
        }
        a2 = a2.b();
        try {
            f.a(a2.a((b.b<T>)t2), "%s.create(I) should not return null.", a2.getClass()).a(t2);
            return true;
        }
        catch (ClassCastException classCastException) {
            throw new a(String.format("%s does not implement AndroidInjector.Factory<%s>", a2.getClass().getCanonicalName(), t2.getClass().getCanonicalName()), classCastException);
        }
    }

    public static final class a
    extends RuntimeException {
        a(String string2, ClassCastException classCastException) {
            super(string2, classCastException);
        }
    }

}

