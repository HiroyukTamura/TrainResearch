/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.a.g;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class c {
    private static final f a = f.c("<root>");
    private static final Pattern b = Pattern.compile("\\.");
    private static final kotlin.e.a.b<String, f> c = new kotlin.e.a.b<String, f>(){

        @Override
        public f a(String string2) {
            return f.d(string2);
        }
    };
    private final String d;
    private transient b e;
    private transient c f;
    private transient f g;

    public c(String string2) {
        this.d = string2;
    }

    c(String string2, b b2) {
        this.d = string2;
        this.e = b2;
    }

    private c(String string2, c c2, f f2) {
        this.d = string2;
        this.f = c2;
        this.g = f2;
    }

    public static c c(f f2) {
        return new c(f2.a(), b.a.b(), f2);
    }

    private void i() {
        int n2 = this.d.lastIndexOf(46);
        if (n2 >= 0) {
            this.g = f.d(this.d.substring(n2 + 1));
            this.f = new c(this.d.substring(0, n2));
            return;
        }
        this.g = f.d(this.d);
        this.f = b.a.b();
    }

    public String a() {
        return this.d;
    }

    public c a(f f2) {
        CharSequence charSequence;
        if (this.d()) {
            charSequence = f2.a();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(this.d);
            ((StringBuilder)charSequence).append(".");
            ((StringBuilder)charSequence).append(f2.a());
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return new c((String)charSequence, this, f2);
    }

    public boolean b() {
        return this.e != null || this.a().indexOf(60) < 0;
        {
        }
    }

    public boolean b(f object) {
        boolean bl2;
        int n2 = this.d.indexOf(46);
        boolean bl3 = this.d();
        boolean bl4 = bl2 = false;
        if (!bl3) {
            String string2 = this.d;
            object = ((f)object).a();
            int n3 = n2;
            if (n2 == -1) {
                n3 = this.d.length();
            }
            bl4 = bl2;
            if (string2.regionMatches(0, (String)object, 0, n3)) {
                bl4 = true;
            }
        }
        return bl4;
    }

    public b c() {
        if (this.e != null) {
            return this.e;
        }
        this.e = new b(this);
        return this.e;
    }

    public boolean d() {
        return this.d.isEmpty();
    }

    public c e() {
        if (this.f != null) {
            return this.f;
        }
        if (!this.d()) {
            this.i();
            return this.f;
        }
        throw new IllegalStateException("root");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        object = (c)object;
        return this.d.equals(((c)object).d);
    }

    public f f() {
        if (this.g != null) {
            return this.g;
        }
        if (!this.d()) {
            this.i();
            return this.g;
        }
        throw new IllegalStateException("root");
    }

    public f g() {
        if (this.d()) {
            return a;
        }
        return this.f();
    }

    public List<f> h() {
        if (this.d()) {
            return Collections.emptyList();
        }
        return g.a(b.split(this.d), c);
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String toString() {
        if (this.d()) {
            return a.a();
        }
        return this.d;
    }

}

