/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.ab;
import c.s;
import c.w;
import f.p;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

abstract class j<T> {
    j() {
    }

    final j<Iterable<T>> a() {
        return new j<Iterable<T>>(){

            @Override
            void a(f.l l2, @Nullable Iterable<T> object) {
                if (object == null) {
                    return;
                }
                object = object.iterator();
                while (object.hasNext()) {
                    Object e2 = object.next();
                    j.this.a(l2, e2);
                }
            }
        };
    }

    abstract void a(f.l var1, @Nullable T var2);

    final j<Object> b() {
        return new j<Object>(){

            @Override
            void a(f.l l2, @Nullable Object object) {
                if (object == null) {
                    return;
                }
                int n2 = Array.getLength(object);
                for (int i2 = 0; i2 < n2; ++i2) {
                    j.this.a(l2, Array.get(object, i2));
                }
            }
        };
    }

    static final class a<T>
    extends j<T> {
        private final f.e<T, ab> a;

        a(f.e<T, ab> e2) {
            this.a = e2;
        }

        @Override
        void a(f.l l2, @Nullable T t2) {
            if (t2 != null) {
                try {
                    ab ab2 = this.a.a(t2);
                    l2.a(ab2);
                    return;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to convert ");
                    stringBuilder.append(t2);
                    stringBuilder.append(" to RequestBody");
                    throw new RuntimeException(stringBuilder.toString(), iOException);
                }
            }
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    static final class b<T>
    extends j<T> {
        private final String a;
        private final f.e<T, String> b;
        private final boolean c;

        b(String string2, f.e<T, String> e2, boolean bl2) {
            this.a = p.a(string2, "name == null");
            this.b = e2;
            this.c = bl2;
        }

        @Override
        void a(f.l l2, @Nullable T object) {
            if (object == null) {
                return;
            }
            if ((object = this.b.a(object)) == null) {
                return;
            }
            l2.c(this.a, (String)object, this.c);
        }
    }

    static final class c<T>
    extends j<Map<String, T>> {
        private final f.e<T, String> a;
        private final boolean b;

        c(f.e<T, String> e2, boolean bl2) {
            this.a = e2;
            this.b = bl2;
        }

        @Override
        void a(f.l object, @Nullable Map<String, T> object2) {
            if (object2 != null) {
                for (Map.Entry<String, Object> entry : object2.entrySet()) {
                    object2 = entry.getKey();
                    if (object2 != null) {
                        if ((entry = entry.getValue()) != null) {
                            String string2 = this.a.a(entry);
                            if (string2 != null) {
                                ((f.l)object).c((String)object2, string2, this.b);
                                continue;
                            }
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Field map value '");
                            ((StringBuilder)object).append(entry);
                            ((StringBuilder)object).append("' converted to null by ");
                            ((StringBuilder)object).append(this.a.getClass().getName());
                            ((StringBuilder)object).append(" for key '");
                            ((StringBuilder)object).append((String)object2);
                            ((StringBuilder)object).append("'.");
                            throw new IllegalArgumentException(((StringBuilder)object).toString());
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Field map contained null value for key '");
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append("'.");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    static final class d<T>
    extends j<T> {
        private final String a;
        private final f.e<T, String> b;

        d(String string2, f.e<T, String> e2) {
            this.a = p.a(string2, "name == null");
            this.b = e2;
        }

        @Override
        void a(f.l l2, @Nullable T object) {
            if (object == null) {
                return;
            }
            if ((object = this.b.a(object)) == null) {
                return;
            }
            l2.a(this.a, (String)object);
        }
    }

    static final class e<T>
    extends j<Map<String, T>> {
        private final f.e<T, String> a;

        e(f.e<T, String> e2) {
            this.a = e2;
        }

        @Override
        void a(f.l object, @Nullable Map<String, T> object2) {
            if (object2 != null) {
                for (Map.Entry<String, Object> entry : object2.entrySet()) {
                    object2 = entry.getKey();
                    if (object2 != null) {
                        if ((entry = entry.getValue()) != null) {
                            ((f.l)object).a((String)object2, this.a.a(entry));
                            continue;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Header map contained null value for key '");
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append("'.");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    static final class f<T>
    extends j<T> {
        private final s a;
        private final f.e<T, ab> b;

        f(s s2, f.e<T, ab> e2) {
            this.a = s2;
            this.b = e2;
        }

        @Override
        void a(f.l l2, @Nullable T t2) {
            if (t2 == null) {
                return;
            }
            try {
                ab ab2 = this.b.a(t2);
                l2.a(this.a, ab2);
                return;
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to convert ");
                stringBuilder.append(t2);
                stringBuilder.append(" to RequestBody");
                throw new RuntimeException(stringBuilder.toString(), iOException);
            }
        }
    }

    static final class g<T>
    extends j<Map<String, T>> {
        private final f.e<T, ab> a;
        private final String b;

        g(f.e<T, ab> e2, String string2) {
            this.a = e2;
            this.b = string2;
        }

        @Override
        void a(f.l object, @Nullable Map<String, T> object2) {
            if (object2 != null) {
                for (Map.Entry<String, Object> entry : object2.entrySet()) {
                    object2 = entry.getKey();
                    if (object2 != null) {
                        if ((entry = entry.getValue()) != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("form-data; name=\"");
                            stringBuilder.append((String)object2);
                            stringBuilder.append("\"");
                            ((f.l)object).a(s.a("Content-Disposition", stringBuilder.toString(), "Content-Transfer-Encoding", this.b), this.a.a(entry));
                            continue;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Part map contained null value for key '");
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append("'.");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class h<T>
    extends j<T> {
        private final String a;
        private final f.e<T, String> b;
        private final boolean c;

        h(String string2, f.e<T, String> e2, boolean bl2) {
            this.a = p.a(string2, "name == null");
            this.b = e2;
            this.c = bl2;
        }

        @Override
        void a(f.l object, @Nullable T t2) {
            if (t2 != null) {
                ((f.l)object).a(this.a, this.b.a(t2), this.c);
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Path parameter \"");
            ((StringBuilder)object).append(this.a);
            ((StringBuilder)object).append("\" value must not be null.");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
    }

    static final class i<T>
    extends j<T> {
        private final String a;
        private final f.e<T, String> b;
        private final boolean c;

        i(String string2, f.e<T, String> e2, boolean bl2) {
            this.a = p.a(string2, "name == null");
            this.b = e2;
            this.c = bl2;
        }

        @Override
        void a(f.l l2, @Nullable T object) {
            if (object == null) {
                return;
            }
            if ((object = this.b.a(object)) == null) {
                return;
            }
            l2.b(this.a, (String)object, this.c);
        }
    }

    static final class j<T>
    extends j<Map<String, T>> {
        private final f.e<T, String> a;
        private final boolean b;

        j(f.e<T, String> e2, boolean bl2) {
            this.a = e2;
            this.b = bl2;
        }

        @Override
        void a(f.l object, @Nullable Map<String, T> object2) {
            if (object2 != null) {
                for (Map.Entry<String, Object> entry : object2.entrySet()) {
                    object2 = entry.getKey();
                    if (object2 != null) {
                        if ((entry = entry.getValue()) != null) {
                            String string2 = this.a.a(entry);
                            if (string2 != null) {
                                ((f.l)object).b((String)object2, string2, this.b);
                                continue;
                            }
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Query map value '");
                            ((StringBuilder)object).append(entry);
                            ((StringBuilder)object).append("' converted to null by ");
                            ((StringBuilder)object).append(this.a.getClass().getName());
                            ((StringBuilder)object).append(" for key '");
                            ((StringBuilder)object).append((String)object2);
                            ((StringBuilder)object).append("'.");
                            throw new IllegalArgumentException(((StringBuilder)object).toString());
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Query map contained null value for key '");
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append("'.");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    static final class k<T>
    extends j<T> {
        private final f.e<T, String> a;
        private final boolean b;

        k(f.e<T, String> e2, boolean bl2) {
            this.a = e2;
            this.b = bl2;
        }

        @Override
        void a(f.l l2, @Nullable T t2) {
            if (t2 == null) {
                return;
            }
            l2.b(this.a.a(t2), null, this.b);
        }
    }

    static final class l
    extends j<w.b> {
        static final l a = new l();

        private l() {
        }

        @Override
        void a(f.l l2, @Nullable w.b b2) {
            if (b2 != null) {
                l2.a(b2);
            }
        }
    }

    static final class m
    extends j<Object> {
        m() {
        }

        @Override
        void a(f.l l2, @Nullable Object object) {
            p.a(object, "@Url parameter is null.");
            l2.a(object);
        }
    }

}

