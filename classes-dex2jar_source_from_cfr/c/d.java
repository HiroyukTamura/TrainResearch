/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c.e;
import c.s;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class d {
    public static final d a = new a().a().c();
    public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    @Nullable
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    d(a a2) {
        this.d = a2.a;
        this.e = a2.b;
        this.f = a2.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = a2.d;
        this.l = a2.e;
        this.m = a2.f;
        this.n = a2.g;
        this.o = a2.h;
    }

    private d(boolean bl2, boolean bl3, int n2, int n3, boolean bl4, boolean bl5, boolean bl6, int n4, int n5, boolean bl7, boolean bl8, boolean bl9, @Nullable String string2) {
        this.d = bl2;
        this.e = bl3;
        this.f = n2;
        this.g = n3;
        this.h = bl4;
        this.i = bl5;
        this.j = bl6;
        this.k = n4;
        this.l = n5;
        this.m = bl7;
        this.n = bl8;
        this.o = bl9;
        this.c = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static d a(s s2) {
        int n2 = s2.a();
        int n3 = 0;
        int n4 = 1;
        String string2 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        int n5 = -1;
        int n6 = -1;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        int n7 = -1;
        int n8 = -1;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        do {
            boolean bl10;
            int n9;
            int n10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            int n11;
            boolean bl15;
            int n12;
            String string3;
            int n13;
            boolean bl16;
            boolean bl17;
            block34 : {
                String string4;
                String string5;
                block33 : {
                    block30 : {
                        block32 : {
                            block31 : {
                                if (n3 >= n2) break block30;
                                string5 = s2.a(n3);
                                string4 = s2.b(n3);
                                if (!string5.equalsIgnoreCase("Cache-Control")) break block31;
                                if (string2 != null) break block32;
                                string2 = string4;
                                break block33;
                            }
                            n13 = n4;
                            string3 = string2;
                            bl12 = bl2;
                            bl17 = bl3;
                            n9 = n5;
                            n11 = n6;
                            bl11 = bl4;
                            bl15 = bl5;
                            bl14 = bl6;
                            n10 = n7;
                            n12 = n8;
                            bl10 = bl7;
                            bl16 = bl8;
                            bl13 = bl9;
                            if (!string5.equalsIgnoreCase("Pragma")) break block34;
                        }
                        n4 = 0;
                        break block33;
                    }
                    if (n4 == 0) {
                        string2 = null;
                    }
                    return new d(bl2, bl3, n5, n6, bl4, bl5, bl6, n7, n8, bl7, bl8, bl9, string2);
                }
                int n14 = 0;
                do {
                    n13 = n4;
                    string3 = string2;
                    bl12 = bl2;
                    bl17 = bl3;
                    n9 = n5;
                    n11 = n6;
                    bl11 = bl4;
                    bl15 = bl5;
                    bl14 = bl6;
                    n10 = n7;
                    n12 = n8;
                    bl10 = bl7;
                    bl16 = bl8;
                    bl13 = bl9;
                    if (n14 >= string4.length()) break;
                    n9 = e.a(string4, n14, "=,;");
                    string5 = string4.substring(n14, n9).trim();
                    if (n9 != string4.length() && string4.charAt(n9) != ',' && string4.charAt(n9) != ';') {
                        n11 = e.a(string4, n9 + 1);
                        if (n11 < string4.length() && string4.charAt(n11) == '\"') {
                            n9 = n11 + 1;
                            n11 = e.a(string4, n9, "\"");
                            string3 = string4.substring(n9, n11);
                            n9 = n11 + 1;
                        } else {
                            n9 = e.a(string4, n11, ",;");
                            string3 = string4.substring(n11, n9).trim();
                        }
                    } else {
                        ++n9;
                        string3 = null;
                    }
                    if ("no-cache".equalsIgnoreCase(string5)) {
                        bl12 = true;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("no-store".equalsIgnoreCase(string5)) {
                        bl17 = true;
                        bl12 = bl2;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("max-age".equalsIgnoreCase(string5)) {
                        n11 = e.b(string3, -1);
                        bl12 = bl2;
                        bl17 = bl3;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("s-maxage".equalsIgnoreCase(string5)) {
                        n10 = e.b(string3, -1);
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("private".equalsIgnoreCase(string5)) {
                        bl11 = true;
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("public".equalsIgnoreCase(string5)) {
                        bl15 = true;
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("must-revalidate".equalsIgnoreCase(string5)) {
                        bl14 = true;
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("max-stale".equalsIgnoreCase(string5)) {
                        n12 = e.b(string3, Integer.MAX_VALUE);
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("min-fresh".equalsIgnoreCase(string5)) {
                        n13 = e.b(string3, -1);
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        bl10 = bl7;
                        bl16 = bl8;
                    } else if ("only-if-cached".equalsIgnoreCase(string5)) {
                        bl10 = true;
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl16 = bl8;
                    } else if ("no-transform".equalsIgnoreCase(string5)) {
                        bl16 = true;
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                    } else {
                        bl12 = bl2;
                        bl17 = bl3;
                        n11 = n5;
                        n10 = n6;
                        bl11 = bl4;
                        bl15 = bl5;
                        bl14 = bl6;
                        n12 = n7;
                        n13 = n8;
                        bl10 = bl7;
                        bl16 = bl8;
                        if ("immutable".equalsIgnoreCase(string5)) {
                            bl9 = true;
                            bl16 = bl8;
                            bl10 = bl7;
                            n13 = n8;
                            n12 = n7;
                            bl14 = bl6;
                            bl15 = bl5;
                            bl11 = bl4;
                            n10 = n6;
                            n11 = n5;
                            bl17 = bl3;
                            bl12 = bl2;
                        }
                    }
                    n14 = n9;
                    bl2 = bl12;
                    bl3 = bl17;
                    n5 = n11;
                    n6 = n10;
                    bl4 = bl11;
                    bl5 = bl15;
                    bl6 = bl14;
                    n7 = n12;
                    n8 = n13;
                    bl7 = bl10;
                    bl8 = bl16;
                } while (true);
            }
            ++n3;
            n4 = n13;
            string2 = string3;
            bl2 = bl12;
            bl3 = bl17;
            n5 = n9;
            n6 = n11;
            bl4 = bl11;
            bl5 = bl15;
            bl6 = bl14;
            n7 = n10;
            n8 = n12;
            bl7 = bl10;
            bl8 = bl16;
            bl9 = bl13;
        } while (true);
    }

    private String k() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f != -1) {
            stringBuilder.append("max-age=");
            stringBuilder.append(this.f);
            stringBuilder.append(", ");
        }
        if (this.g != -1) {
            stringBuilder.append("s-maxage=");
            stringBuilder.append(this.g);
            stringBuilder.append(", ");
        }
        if (this.h) {
            stringBuilder.append("private, ");
        }
        if (this.i) {
            stringBuilder.append("public, ");
        }
        if (this.j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.k != -1) {
            stringBuilder.append("max-stale=");
            stringBuilder.append(this.k);
            stringBuilder.append(", ");
        }
        if (this.l != -1) {
            stringBuilder.append("min-fresh=");
            stringBuilder.append(this.l);
            stringBuilder.append(", ");
        }
        if (this.m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.n) {
            stringBuilder.append("no-transform, ");
        }
        if (this.o) {
            stringBuilder.append("immutable, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public boolean j() {
        return this.o;
    }

    public String toString() {
        String string2 = this.c;
        if (string2 != null) {
            return string2;
        }
        this.c = string2 = this.k();
        return string2;
    }

    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a a() {
            this.a = true;
            return this;
        }

        public a a(int n2, TimeUnit object) {
            if (n2 >= 0) {
                long l2 = ((TimeUnit)((Object)object)).toSeconds(n2);
                n2 = l2 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l2;
                this.d = n2;
                return this;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("maxStale < 0: ");
            ((StringBuilder)object).append(n2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        public a b() {
            this.f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }
    }

}

