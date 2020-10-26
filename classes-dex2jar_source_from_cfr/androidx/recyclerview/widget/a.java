/*
 * Decompiled with CFR 0.139.
 */
package androidx.recyclerview.widget;

import androidx.core.g.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.ArrayList;
import java.util.List;

class a
implements i.a {
    final ArrayList<b> a = new ArrayList();
    final ArrayList<b> b = new ArrayList();
    final a c;
    Runnable d;
    final boolean e;
    final i f;
    private d.a<b> g = new d.b<b>(30);
    private int h = 0;

    a(a a2) {
        this(a2, false);
    }

    a(a a2, boolean bl2) {
        this.c = a2;
        this.e = bl2;
        this.f = new i(this);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int b(int n2, int n3) {
        b b2;
        int n4 = n2;
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            block32 : {
                block40 : {
                    block39 : {
                        block38 : {
                            block26 : {
                                block37 : {
                                    block36 : {
                                        block27 : {
                                            block35 : {
                                                block34 : {
                                                    block33 : {
                                                        block28 : {
                                                            block31 : {
                                                                block30 : {
                                                                    block29 : {
                                                                        int n5;
                                                                        b2 = this.b.get(i2);
                                                                        if (b2.a != 8) break block26;
                                                                        if (b2.b < b2.d) {
                                                                            n2 = b2.b;
                                                                            n5 = b2.d;
                                                                        } else {
                                                                            n2 = b2.d;
                                                                            n5 = b2.b;
                                                                        }
                                                                        if (n4 < n2 || n4 > n5) break block27;
                                                                        if (n2 != b2.b) break block28;
                                                                        if (n3 != 1) break block29;
                                                                        n2 = b2.d + 1;
                                                                        break block30;
                                                                    }
                                                                    if (n3 != 2) break block31;
                                                                    n2 = b2.d - 1;
                                                                }
                                                                b2.d = n2;
                                                            }
                                                            n2 = n4 + 1;
                                                            break block32;
                                                        }
                                                        if (n3 != 1) break block33;
                                                        n2 = b2.b + 1;
                                                        break block34;
                                                    }
                                                    if (n3 != 2) break block35;
                                                    n2 = b2.b - 1;
                                                }
                                                b2.b = n2;
                                            }
                                            n2 = n4 - 1;
                                            break block32;
                                        }
                                        n2 = n4;
                                        if (n4 >= b2.b) break block32;
                                        if (n3 != 1) break block36;
                                        ++b2.b;
                                        n2 = b2.d + 1;
                                        break block37;
                                    }
                                    n2 = n4;
                                    if (n3 != 2) break block32;
                                    --b2.b;
                                    n2 = b2.d - 1;
                                }
                                b2.d = n2;
                                n2 = n4;
                                break block32;
                            }
                            if (b2.b > n4) break block38;
                            if (b2.a == 1) {
                                n2 = n4 - b2.d;
                            } else {
                                n2 = n4;
                                if (b2.a == 2) {
                                    n2 = n4 + b2.d;
                                }
                            }
                            break block32;
                        }
                        if (n3 != 1) break block39;
                        n2 = b2.b + 1;
                        break block40;
                    }
                    n2 = n4;
                    if (n3 != 2) break block32;
                    n2 = b2.b - 1;
                }
                b2.b = n2;
                n2 = n4;
            }
            n4 = n2;
        }
        n2 = this.b.size() - 1;
        while (n2 >= 0) {
            b2 = this.b.get(n2);
            if (b2.a == 8 ? b2.d == b2.b || b2.d < 0 : b2.d <= 0) {
                this.b.remove(n2);
                this.a(b2);
            }
            --n2;
        }
        return n4;
    }

    private void b(b b2) {
        this.g(b2);
    }

    private void c(b b2) {
        int n2 = b2.b;
        int n3 = b2.b + b2.d;
        int n4 = 0;
        int n5 = -1;
        for (int i2 = b2.b; i2 < n3; ++i2) {
            int n6;
            if (this.c.a(i2) == null && !this.d(i2)) {
                if (n5 == 1) {
                    this.g(this.a(2, n2, n4, null));
                    n5 = 1;
                } else {
                    n5 = 0;
                }
                int n7 = 0;
                n6 = n5;
                n5 = n7;
            } else {
                if (n5 == 0) {
                    this.e(this.a(2, n2, n4, null));
                    n6 = 1;
                } else {
                    n6 = 0;
                }
                n5 = 1;
            }
            if (n6 != 0) {
                i2 -= n4;
                n3 -= n4;
                n6 = 1;
            } else {
                n6 = n4 + 1;
            }
            n4 = n6;
        }
        b b3 = b2;
        if (n4 != b2.d) {
            this.a(b2);
            b3 = this.a(2, n2, n4, null);
        }
        if (n5 == 0) {
            this.e(b3);
            return;
        }
        this.g(b3);
    }

    private void d(b b2) {
        int n2 = b2.b;
        int n3 = b2.b;
        int n4 = b2.d;
        int n5 = -1;
        int n6 = 0;
        for (int i2 = b2.b; i2 < n3 + n4; ++i2) {
            int n7;
            int n8;
            if (this.c.a(i2) == null && !this.d(i2)) {
                n8 = n6;
                n7 = n2;
                if (n5 == 1) {
                    this.g(this.a(4, n2, n6, b2.c));
                    n7 = i2;
                    n8 = 0;
                }
                n2 = 0;
                n6 = n8;
                n8 = n2;
                n2 = n7;
            } else {
                n7 = n6;
                n8 = n2;
                if (n5 == 0) {
                    this.e(this.a(4, n2, n6, b2.c));
                    n8 = i2;
                    n7 = 0;
                }
                n6 = 1;
                n2 = n8;
                n8 = n6;
                n6 = n7;
            }
            ++n6;
            n5 = n8;
        }
        Object object = b2;
        if (n6 != b2.d) {
            object = b2.c;
            this.a(b2);
            object = this.a(4, n2, n6, object);
        }
        if (n5 == 0) {
            this.e((b)object);
            return;
        }
        this.g((b)object);
    }

    private boolean d(int n2) {
        int n3 = this.b.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            b b2 = this.b.get(i2);
            if (b2.a == 8) {
                if (this.a(b2.d, i2 + 1) != n2) continue;
                return true;
            }
            if (b2.a != 1) continue;
            int n4 = b2.b;
            int n5 = b2.d;
            for (int i3 = b2.b; i3 < n4 + n5; ++i3) {
                if (this.a(i3, i2 + 1) != n2) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e(b b2) {
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        int n6;
        if (b2.a != 1 && b2.a != 8) {
            n3 = this.b(b2.b, b2.a);
            n5 = b2.b;
            n4 = b2.a;
            if (n4 != 2) {
                if (n4 != 4) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("op should be remove or update.");
                    stringBuilder.append(b2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                n2 = 1;
            } else {
                n2 = 0;
            }
            n6 = 1;
        } else {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        for (int i2 = 1; i2 < b2.d; ++i2) {
            int n7 = this.b(b2.b + n2 * i2, b2.a);
            n4 = b2.a;
            n4 = !(n4 != 2 ? n4 == 4 && n7 == n3 + 1 : n7 == n3) ? 0 : 1;
            if (n4 != 0) {
                n4 = n6 + 1;
            } else {
                object = this.a(b2.a, n3, n6, b2.c);
                this.a((b)object, n5);
                this.a((b)object);
                n4 = n5;
                if (b2.a == 4) {
                    n4 = n5 + n6;
                }
                n3 = n7;
                n6 = 1;
                n5 = n4;
                n4 = n6;
            }
            n6 = n4;
        }
        object = b2.c;
        this.a(b2);
        if (n6 > 0) {
            b2 = this.a(b2.a, n3, n6, object);
            this.a(b2, n5);
            this.a(b2);
        }
    }

    private void f(b b2) {
        this.g(b2);
    }

    private void g(b b2) {
        this.b.add(b2);
        int n2 = b2.a;
        if (n2 != 4) {
            if (n2 != 8) {
                switch (n2) {
                    default: {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown update op type for ");
                        stringBuilder.append(b2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    case 2: {
                        this.c.b(b2.b, b2.d);
                        return;
                    }
                    case 1: 
                }
                this.c.c(b2.b, b2.d);
                return;
            }
            this.c.d(b2.b, b2.d);
            return;
        }
        this.c.a(b2.b, b2.d, b2.c);
    }

    int a(int n2, int n3) {
        int n4 = this.b.size();
        int n5 = n3;
        n3 = n2;
        while (n5 < n4) {
            b b2 = this.b.get(n5);
            if (b2.a == 8) {
                if (b2.b == n3) {
                    n2 = b2.d;
                } else {
                    int n6 = n3;
                    if (b2.b < n3) {
                        n6 = n3 - 1;
                    }
                    n2 = n6;
                    if (b2.d <= n6) {
                        n2 = n6 + 1;
                    }
                }
            } else {
                n2 = n3;
                if (b2.b <= n3) {
                    if (b2.a == 2) {
                        if (n3 < b2.b + b2.d) {
                            return -1;
                        }
                        n2 = n3 - b2.d;
                    } else {
                        n2 = n3;
                        if (b2.a == 1) {
                            n2 = n3 + b2.d;
                        }
                    }
                }
            }
            ++n5;
            n3 = n2;
        }
        return n3;
    }

    @Override
    public b a(int n2, int n3, int n4, Object object) {
        b b2 = this.g.a();
        if (b2 == null) {
            return new b(n2, n3, n4, object);
        }
        b2.a = n2;
        b2.b = n3;
        b2.d = n4;
        b2.c = object;
        return b2;
    }

    void a() {
        this.a(this.a);
        this.a(this.b);
        this.h = 0;
    }

    @Override
    public void a(b b2) {
        if (!this.e) {
            b2.c = null;
            this.g.a(b2);
        }
    }

    void a(b b2, int n2) {
        this.c.a(b2);
        int n3 = b2.a;
        if (n3 != 2) {
            if (n3 == 4) {
                this.c.a(n2, b2.d, b2.c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        this.c.a(n2, b2.d);
    }

    void a(List<b> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(list.get(i2));
        }
        list.clear();
    }

    boolean a(int n2) {
        return (n2 & this.h) != 0;
    }

    boolean a(int n2, int n3, int n4) {
        boolean bl2 = false;
        if (n2 == n3) {
            return false;
        }
        if (n4 == 1) {
            this.a.add(this.a(8, n2, n3, null));
            this.h |= 8;
            if (this.a.size() == 1) {
                bl2 = true;
            }
            return bl2;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    boolean a(int n2, int n3, Object object) {
        boolean bl2 = false;
        if (n3 < 1) {
            return false;
        }
        this.a.add(this.a(4, n2, n3, object));
        this.h |= 4;
        if (this.a.size() == 1) {
            bl2 = true;
        }
        return bl2;
    }

    int b(int n2) {
        return this.a(n2, 0);
    }

    void b() {
        this.f.a(this.a);
        int n2 = this.a.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            b b2 = this.a.get(i2);
            int n3 = b2.a;
            if (n3 != 4) {
                if (n3 != 8) {
                    switch (n3) {
                        default: {
                            break;
                        }
                        case 2: {
                            this.c(b2);
                            break;
                        }
                        case 1: {
                            this.f(b2);
                            break;
                        }
                    }
                } else {
                    this.b(b2);
                }
            } else {
                this.d(b2);
            }
            if (this.d == null) continue;
            this.d.run();
        }
        this.a.clear();
    }

    public int c(int n2) {
        int n3 = this.a.size();
        int n4 = n2;
        for (int i2 = 0; i2 < n3; ++i2) {
            block13 : {
                b b2;
                block12 : {
                    b2 = this.a.get(i2);
                    n2 = b2.a;
                    if (n2 == 8) break block12;
                    switch (n2) {
                        default: {
                            n2 = n4;
                            break;
                        }
                        case 2: {
                            n2 = n4;
                            if (b2.b <= n4) {
                                if (b2.b + b2.d > n4) {
                                    return -1;
                                }
                                n2 = n4 - b2.d;
                                break;
                            }
                            break block13;
                        }
                        case 1: {
                            n2 = n4;
                            if (b2.b <= n4) {
                                n2 = n4 + b2.d;
                                break;
                            }
                            break block13;
                        }
                    }
                    break block13;
                }
                if (b2.b == n4) {
                    n2 = b2.d;
                } else {
                    int n5 = n4;
                    if (b2.b < n4) {
                        n5 = n4 - 1;
                    }
                    n2 = n5;
                    if (b2.d <= n5) {
                        n2 = n5 + 1;
                    }
                }
            }
            n4 = n2;
        }
        return n4;
    }

    void c() {
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c.b(this.b.get(i2));
        }
        this.a(this.b);
        this.h = 0;
    }

    boolean d() {
        return this.a.size() > 0;
    }

    void e() {
        this.c();
        int n2 = this.a.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            b b2 = this.a.get(i2);
            int n3 = b2.a;
            if (n3 != 4) {
                if (n3 != 8) {
                    switch (n3) {
                        default: {
                            break;
                        }
                        case 2: {
                            this.c.b(b2);
                            this.c.a(b2.b, b2.d);
                            break;
                        }
                        case 1: {
                            this.c.b(b2);
                            this.c.c(b2.b, b2.d);
                            break;
                        }
                    }
                } else {
                    this.c.b(b2);
                    this.c.d(b2.b, b2.d);
                }
            } else {
                this.c.b(b2);
                this.c.a(b2.b, b2.d, b2.c);
            }
            if (this.d == null) continue;
            this.d.run();
        }
        this.a(this.a);
        this.h = 0;
    }

    boolean f() {
        return !this.b.isEmpty() && !this.a.isEmpty();
    }

    static interface a {
        public RecyclerView.x a(int var1);

        public void a(int var1, int var2);

        public void a(int var1, int var2, Object var3);

        public void a(b var1);

        public void b(int var1, int var2);

        public void b(b var1);

        public void c(int var1, int var2);

        public void d(int var1, int var2);
    }

    static class b {
        int a;
        int b;
        Object c;
        int d;

        b(int n2, int n3, int n4, Object object) {
            this.a = n2;
            this.b = n3;
            this.d = n4;
            this.c = object;
        }

        String a() {
            int n2 = this.a;
            if (n2 != 4) {
                if (n2 != 8) {
                    switch (n2) {
                        default: {
                            return "??";
                        }
                        case 2: {
                            return "rm";
                        }
                        case 1: 
                    }
                    return "add";
                }
                return "mv";
            }
            return "up";
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
                if (this.a != ((b)object).a) {
                    return false;
                }
                if (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == ((b)object).b && this.b == ((b)object).d) {
                    return true;
                }
                if (this.d != ((b)object).d) {
                    return false;
                }
                if (this.b != ((b)object).b) {
                    return false;
                }
                return !(this.c != null ? !this.c.equals(((b)object).c) : ((b)object).c != null);
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31 + this.b) * 31 + this.d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append("[");
            stringBuilder.append(this.a());
            stringBuilder.append(",s:");
            stringBuilder.append(this.b);
            stringBuilder.append("c:");
            stringBuilder.append(this.d);
            stringBuilder.append(",p:");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

}

