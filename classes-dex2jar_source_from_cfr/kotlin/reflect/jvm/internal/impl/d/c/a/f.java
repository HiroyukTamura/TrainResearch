/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import kotlin.e.b.g;
import kotlin.e.b.j;

public abstract class f {
    private f() {
    }

    public /* synthetic */ f(g g2) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return this.c();
    }

    public static final class a
    extends f {
        private final String a;
        private final String b;

        public a(String string2, String string3) {
            j.b(string2, "name");
            j.b(string3, "desc");
            super(null);
            this.a = string2;
            this.b = string3;
        }

        @Override
        public String a() {
            return this.a;
        }

        @Override
        public String b() {
            return this.b;
        }

        @Override
        public String c() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a());
            stringBuilder.append(':');
            stringBuilder.append(this.b());
            return stringBuilder.toString();
        }

        public final String d() {
            return this.a();
        }

        public final String e() {
            return this.b();
        }

        public boolean equals(Object object) {
            block2 : {
                block3 : {
                    if (this == object) break block2;
                    if (!(object instanceof a)) break block3;
                    object = (a)object;
                    if (j.a((Object)this.a(), (Object)((a)object).a()) && j.a((Object)this.b(), (Object)((a)object).b())) break block2;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String string2 = this.a();
            int n2 = 0;
            int n3 = string2 != null ? string2.hashCode() : 0;
            string2 = this.b();
            if (string2 != null) {
                n2 = string2.hashCode();
            }
            return n3 * 31 + n2;
        }
    }

    public static final class b
    extends f {
        private final String a;
        private final String b;

        public b(String string2, String string3) {
            j.b(string2, "name");
            j.b(string3, "desc");
            super(null);
            this.a = string2;
            this.b = string3;
        }

        @Override
        public String a() {
            return this.a;
        }

        @Override
        public String b() {
            return this.b;
        }

        @Override
        public String c() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a());
            stringBuilder.append(this.b());
            return stringBuilder.toString();
        }

        public boolean equals(Object object) {
            block2 : {
                block3 : {
                    if (this == object) break block2;
                    if (!(object instanceof b)) break block3;
                    object = (b)object;
                    if (j.a((Object)this.a(), (Object)((b)object).a()) && j.a((Object)this.b(), (Object)((b)object).b())) break block2;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String string2 = this.a();
            int n2 = 0;
            int n3 = string2 != null ? string2.hashCode() : 0;
            string2 = this.b();
            if (string2 != null) {
                n2 = string2.hashCode();
            }
            return n3 * 31 + n2;
        }
    }

}

