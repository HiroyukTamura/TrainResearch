/*
 * Decompiled with CFR 0.139.
 */
package b.a.c;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class a
extends RuntimeException {
    private final List<Throwable> a;
    private final String b;
    private Throwable c;

    /*
     * Enabled aggressive block sorting
     */
    public a(Iterable<? extends Throwable> object) {
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object == null) {
            linkedHashSet.add(new NullPointerException("errors was null"));
        } else {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                object = (Throwable)iterator.next();
                if (object instanceof a) {
                    linkedHashSet.addAll(((a)object).a());
                    continue;
                }
                if (object == null) {
                    object = new NullPointerException("Throwable was null!");
                }
                linkedHashSet.add(object);
            }
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.a = Collections.unmodifiableList(arrayList);
            object = new StringBuilder();
            ((StringBuilder)object).append(this.a.size());
            ((StringBuilder)object).append(" exceptions occurred. ");
            this.b = ((StringBuilder)object).toString();
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public /* varargs */ a(Throwable ... object) {
        object = object == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(object);
        this((Iterable<? extends Throwable>)object);
    }

    private List<Throwable> a(Throwable throwable) {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null) {
            Throwable throwable3 = throwable2;
            if (throwable2 == throwable) {
                return arrayList;
            }
            do {
                arrayList.add(throwable3);
                throwable = throwable3.getCause();
                if (throwable == null) break;
                if (throwable == throwable3) {
                    return arrayList;
                }
                throwable3 = throwable;
            } while (true);
        }
        return arrayList;
    }

    private void a(b b2) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append('\n');
        for (Serializable serializable : this.getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(serializable);
            stringBuilder.append('\n');
        }
        Iterator<Throwable> iterator = this.a.iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            Serializable serializable;
            serializable = (Throwable)iterator.next();
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(n2);
            stringBuilder.append(" :\n");
            this.a(stringBuilder, (Throwable)serializable, "\t");
            ++n2;
        }
        b2.a(stringBuilder.toString());
    }

    private void a(StringBuilder stringBuilder, Throwable throwable, String arrstackTraceElement) {
        stringBuilder.append((String)arrstackTraceElement);
        stringBuilder.append(throwable);
        stringBuilder.append('\n');
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            stringBuilder.append("\t\tat ");
            stringBuilder.append(stackTraceElement);
            stringBuilder.append('\n');
        }
        if (throwable.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            this.a(stringBuilder, throwable.getCause(), "");
        }
    }

    private Throwable b(Throwable throwable) {
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null) {
            Throwable throwable3 = throwable2;
            if (this.c == throwable2) {
                return throwable;
            }
            while ((throwable = throwable3.getCause()) != null) {
                if (throwable == throwable3) {
                    return throwable3;
                }
                throwable3 = throwable;
            }
            return throwable3;
        }
        return throwable;
    }

    public List<Throwable> a() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Throwable getCause() {
        synchronized (this) {
            if (this.c != null) return this.c;
            a a2 = new a();
            HashSet<Throwable> hashSet = new HashSet<Throwable>();
            Iterator<Throwable> iterator = this.a.iterator();
            Throwable throwable = a2;
            do {
                Iterator<Throwable> iterator2;
                Throwable throwable2;
                if (iterator.hasNext()) {
                    throwable2 = iterator.next();
                    if (hashSet.contains(throwable2)) continue;
                    hashSet.add(throwable2);
                    iterator2 = this.a(throwable2).iterator();
                } else {
                    this.c = a2;
                    return this.c;
                }
                while (iterator2.hasNext()) {
                    Throwable throwable3 = iterator2.next();
                    if (hashSet.contains(throwable3)) {
                        throwable2 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        continue;
                    }
                    hashSet.add(throwable3);
                }
                try {
                    throwable.initCause(throwable2);
                }
                catch (Throwable throwable4) {}
                throwable = this.b(throwable);
            } while (true);
        }
    }

    @Override
    public String getMessage() {
        return this.b;
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream printStream) {
        this.a(new c(printStream));
    }

    @Override
    public void printStackTrace(PrintWriter printWriter) {
        this.a(new d(printWriter));
    }

    static final class a
    extends RuntimeException {
        a() {
        }

        @Override
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class b {
        b() {
        }

        abstract void a(Object var1);
    }

    static final class c
    extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override
        void a(Object object) {
            this.a.println(object);
        }
    }

    static final class d
    extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override
        void a(Object object) {
            this.a.println(object);
        }
    }

}

