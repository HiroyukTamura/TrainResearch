/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.h;
import com.b.a.i;
import com.b.a.k;
import d.c;
import d.e;
import d.f;
import java.io.EOFException;
import java.math.BigDecimal;
import javax.annotation.Nullable;

final class m
extends k {
    private static final f g = f.a("'\\");
    private static final f h = f.a("\"\\");
    private static final f i = f.a("{}[]:, \n\t\r\f/\\;#=");
    private static final f j = f.a("\n\r");
    private static final f k = f.a("*/");
    private final e l;
    private final c m;
    private int n = 0;
    private long o;
    private int p;
    @Nullable
    private String q;

    m(e e2) {
        if (e2 != null) {
            this.l = e2;
            this.m = e2.d();
            this.a(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private boolean A() {
        long l2 = this.l.b(k);
        boolean bl2 = l2 != -1L;
        c c2 = this.m;
        l2 = bl2 ? (l2 += (long)k.g()) : this.m.b();
        c2.i(l2);
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private char B() {
        if (!this.l.b(1L)) {
            throw this.a("Unterminated escape sequence");
        }
        int n2 = this.m.i();
        if (n2 != 10 && n2 != 34 && n2 != 39 && n2 != 47 && n2 != 92) {
            if (n2 == 98) {
                return '\b';
            }
            if (n2 == 102) {
                return '\f';
            }
            if (n2 == 110) {
                return '\n';
            }
            if (n2 == 114) {
                return '\r';
            }
            switch (n2) {
                default: {
                    if (this.e) {
                        return (char)n2;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid escape sequence: \\");
                    stringBuilder.append((char)n2);
                    throw this.a(stringBuilder.toString());
                }
                case 117: {
                    if (!this.l.b(4L)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unterminated escape sequence at path ");
                        stringBuilder.append(this.q());
                        throw new EOFException(stringBuilder.toString());
                    }
                    n2 = 0;
                    char c2 = '\u0000';
                    do {
                        if (n2 >= 4) {
                            this.m.i(4L);
                            return c2;
                        }
                        int n3 = this.m.c((long)n2);
                        char c3 = (char)(c2 << 4);
                        if (n3 >= 48 && n3 <= 57) {
                            n3 -= 48;
                        } else {
                            if (n3 >= 97 && n3 <= 102) {
                                n3 -= 97;
                            } else {
                                if (n3 < 65 || n3 > 70) break;
                                n3 -= 65;
                            }
                            n3 += 10;
                        }
                        c2 = (char)(c3 + n3);
                        ++n2;
                    } while (true);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\\u");
                    stringBuilder.append(this.m.e(4L));
                    throw this.a(stringBuilder.toString());
                }
                case 116: 
            }
            return '\t';
        }
        return (char)n2;
    }

    private int a(String string2, k.a a2) {
        int n2 = a2.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equals(a2.a[i2])) continue;
            this.n = 0;
            this.c[this.a - 1] = string2;
            return i2;
        }
        return -1;
    }

    private String a(f object) {
        long l2;
        StringBuilder stringBuilder = null;
        while ((l2 = this.l.c((f)object)) != -1L) {
            if (this.m.c(l2) == 92) {
                StringBuilder stringBuilder2 = stringBuilder;
                if (stringBuilder == null) {
                    stringBuilder2 = new StringBuilder();
                }
                stringBuilder2.append(this.m.e(l2));
                this.m.i();
                stringBuilder2.append(this.B());
                stringBuilder = stringBuilder2;
                continue;
            }
            if (stringBuilder == null) {
                object = this.m.e(l2);
                this.m.i();
                return object;
            }
            stringBuilder.append(this.m.e(l2));
            this.m.i();
            return stringBuilder.toString();
        }
        throw this.a("Unterminated string");
    }

    private int b(String arrn, k.a a2) {
        int n2 = a2.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!arrn.equals(a2.a[i2])) continue;
            this.n = 0;
            arrn = this.d;
            n2 = this.a - 1;
            arrn[n2] = arrn[n2] + 1;
            return i2;
        }
        return -1;
    }

    private void b(f f2) {
        long l2;
        while ((l2 = this.l.c(f2)) != -1L) {
            if (this.m.c(l2) == 92) {
                this.m.i(l2 + 1L);
                this.B();
                continue;
            }
            this.m.i(l2 + 1L);
            return;
        }
        throw this.a("Unterminated string");
    }

    private boolean b(int n2) {
        switch (n2) {
            default: {
                return true;
            }
            case 35: 
            case 47: 
            case 59: 
            case 61: 
            case 92: {
                this.y();
            }
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 32: 
            case 44: 
            case 58: 
            case 91: 
            case 93: 
            case 123: 
            case 125: 
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int c(boolean var1_1) {
        block0 : do {
            var2_2 = 0;
            do {
                block7 : {
                    if (!(var4_4 = this.l).b(var3_3 = var2_2 + 1)) {
                        if (var1_1 != false) throw new EOFException("End of input");
                        return -1;
                    }
                    if ((var2_2 = (int)this.m.c((long)var2_2)) == 10 || var2_2 == 32 || var2_2 == 13 || var2_2 == 9) break block7;
                    this.m.i((long)(var3_3 - 1));
                    if (var2_2 != 47) ** GOTO lbl24
                    if (!this.l.b(2L)) {
                        return var2_2;
                    }
                    this.y();
                    var3_3 = this.m.c(1L);
                    if (var3_3 != 42) {
                        if (var3_3 != 47) {
                            return var2_2;
                        }
                        this.m.i();
                        this.m.i();
                    } else {
                        this.m.i();
                        this.m.i();
                        if (this.A() == false) throw this.a("Unterminated comment");
                        continue block0;
lbl24: // 1 sources:
                        if (var2_2 != 35) return var2_2;
                        this.y();
                    }
                    this.z();
                    continue block0;
                }
                var2_2 = var3_3;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int t() {
        block26 : {
            block27 : {
                block28 : {
                    block22 : {
                        block19 : {
                            block25 : {
                                block21 : {
                                    block24 : {
                                        block23 : {
                                            block20 : {
                                                block18 : {
                                                    var1_1 = this.b[this.a - 1];
                                                    if (var1_1 != 1) break block18;
                                                    this.b[this.a - 1] = 2;
                                                    break block19;
                                                }
                                                if (var1_1 != 2) break block20;
                                                var2_2 = this.c(true);
                                                this.m.i();
                                                if (var2_2 == 44) break block19;
                                                if (var2_2 != 59) {
                                                    if (var2_2 != 93) throw this.a("Unterminated array");
                                                    this.n = 4;
                                                    return 4;
                                                }
                                                break block21;
                                            }
                                            if (var1_1 == 3 || var1_1 == 5) break block22;
                                            if (var1_1 != 4) break block23;
                                            this.b[this.a - 1] = 5;
                                            var2_2 = this.c(true);
                                            this.m.i();
                                            if (var2_2 != 58) {
                                                if (var2_2 != 61) throw this.a("Expected ':'");
                                                this.y();
                                                if (this.l.b(1L) && this.m.c(0L) == 62) {
                                                    this.m.i();
                                                }
                                            }
                                            break block19;
                                        }
                                        if (var1_1 != 6) break block24;
                                        this.b[this.a - 1] = 7;
                                        break block19;
                                    }
                                    if (var1_1 != 7) break block25;
                                    if (this.c(false) != -1) break block21;
                                    var1_1 = 18;
                                    break block26;
                                }
                                this.y();
                                break block19;
                            }
                            if (var1_1 == 8) throw new IllegalStateException("JsonReader is closed");
                        }
                        var2_2 = this.c(true);
                        if (var2_2 == 34) ** GOTO lbl78
                        if (var2_2 == 39) {
                            this.y();
                            this.m.i();
                            this.n = 8;
                            return 8;
                        }
                        if (var2_2 == 44 || var2_2 == 59) ** GOTO lbl73
                        if (var2_2 == 91) {
                            this.m.i();
                            this.n = 3;
                            return 3;
                        }
                        if (var2_2 != 93) {
                            if (var2_2 == 123) {
                                this.m.i();
                                this.n = 1;
                                return 1;
                            }
                            var1_1 = this.u();
                            if (var1_1 != 0) {
                                return var1_1;
                            }
                            var1_1 = this.v();
                            if (var1_1 != 0) {
                                return var1_1;
                            }
                            if (this.b(this.m.c(0L)) == false) throw this.a("Expected value");
                            this.y();
                            var1_1 = 10;
                        } else {
                            if (var1_1 == 1) {
                                this.m.i();
                                this.n = 4;
                                return 4;
                            }
lbl73: // 3 sources:
                            if (var1_1 != 1) {
                                if (var1_1 != 2) throw this.a("Unexpected value");
                            }
                            this.y();
                            this.n = 7;
                            return 7;
lbl78: // 1 sources:
                            this.m.i();
                            var1_1 = 9;
                        }
                        break block26;
                    }
                    this.b[this.a - 1] = 4;
                    if (var1_1 != 5) break block27;
                    var2_3 = this.c(true);
                    this.m.i();
                    if (var2_3 == 44) break block27;
                    if (var2_3 == 59) break block28;
                    if (var2_3 != 125) throw this.a("Unterminated object");
                    ** GOTO lbl102
                }
                this.y();
            }
            if ((var2_3 = this.c(true)) != 34) {
                if (var2_3 != 39) {
                    if (var2_3 != 125) {
                        this.y();
                        if (this.b((char)var2_3) == false) throw this.a("Expected name");
                        var1_1 = 14;
                    } else {
                        if (var1_1 == 5) throw this.a("Expected name");
                        this.m.i();
lbl102: // 2 sources:
                        var1_1 = 2;
                    }
                } else {
                    this.m.i();
                    this.y();
                    var1_1 = 12;
                }
            } else {
                this.m.i();
                var1_1 = 13;
            }
        }
        this.n = var1_1;
        return var1_1;
    }

    private int u() {
        String string2;
        String string3;
        int n2 = this.m.c(0L);
        if (n2 != 116 && n2 != 84) {
            if (n2 != 102 && n2 != 70) {
                if (n2 != 110 && n2 != 78) {
                    return 0;
                }
                string3 = "null";
                string2 = "NULL";
                n2 = 7;
            } else {
                string3 = "false";
                string2 = "FALSE";
                n2 = 6;
            }
        } else {
            string3 = "true";
            string2 = "TRUE";
            n2 = 5;
        }
        int n3 = string3.length();
        int n4 = 1;
        while (n4 < n3) {
            e e2 = this.l;
            int n5 = n4 + 1;
            if (!e2.b(n5)) {
                return 0;
            }
            byte by2 = this.m.c((long)n4);
            if (by2 != string3.charAt(n4) && by2 != string2.charAt(n4)) {
                return 0;
            }
            n4 = n5;
        }
        if (this.l.b(n3 + 1) && this.b(this.m.c((long)n3))) {
            return 0;
        }
        this.m.i((long)n3);
        this.n = n2;
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int v() {
        var2_1 = 0;
        var8_2 = 0L;
        var4_3 = 0;
        var1_4 = 0;
        var3_5 = 1;
        var5_6 = false;
        do {
            block16 : {
                block17 : {
                    block14 : {
                        block15 : {
                            if (!(var12_10 = this.l).b(var6_7 = var4_3 + 1)) ** GOTO lbl45
                            var7_8 = this.m.c((long)var4_3);
                            if (var7_8 == 43) break block14;
                            if (var7_8 == 69 || var7_8 == 101) break block15;
                            switch (var7_8) {
                                default: {
                                    if (var7_8 < 48 || var7_8 > 57) ** GOTO lbl44
                                    if (var1_4 == 1 || var1_4 == 0) ** GOTO lbl40
                                    if (var1_4 != 2) ** GOTO lbl24
                                    if (var8_2 == 0L) {
                                        return var2_1;
                                    }
                                    var10_9 = 10L * var8_2 - (long)(var7_8 - 48);
                                    var2_1 = (int)(var8_2 LCMP -922337203685477580L);
                                    var2_1 = var2_1 <= 0 && (var2_1 != 0 || var10_9 >= var8_2) ? 0 : 1;
                                    var4_3 = var2_1 & var3_5;
                                    ** GOTO lbl-1000
lbl24: // 1 sources:
                                    if (var1_4 != 3) ** GOTO lbl28
                                    var2_1 = 0;
                                    var1_4 = 4;
                                    break block16;
lbl28: // 1 sources:
                                    if (var1_4 != 5) {
                                        var10_9 = var8_2;
                                        var4_3 = var3_5;
                                        ** if (var1_4 == 6) goto lbl-1000
                                    }
                                    ** GOTO lbl-1000
lbl-1000: // 2 sources:
                                    {
                                        var2_1 = 0;
                                        var8_2 = var10_9;
                                        var3_5 = var4_3;
                                        ** GOTO lbl79
                                    }
lbl-1000: // 2 sources:
                                    {
                                        var2_1 = 0;
                                        var1_4 = 7;
                                    }
                                    break block16;
lbl40: // 1 sources:
                                    var8_2 = -(var7_8 - 48);
                                    var2_1 = 0;
                                    var1_4 = 2;
                                    break block16;
lbl44: // 1 sources:
                                    if (this.b(var7_8) != false) return 0;
lbl45: // 2 sources:
                                    if (!(var1_4 != 2 || var3_5 == 0 || var8_2 == Long.MIN_VALUE && !var5_6 || var8_2 == 0L && var5_6)) {
                                        if (!var5_6) {
                                            var8_2 = -var8_2;
                                        }
                                        this.o = var8_2;
                                        this.m.i((long)var4_3);
                                        var1_4 = 16;
                                    } else {
                                        if (var1_4 != 2 && var1_4 != 4) {
                                            if (var1_4 != 7) return 0;
                                        }
                                        this.p = var4_3;
                                        var1_4 = 17;
                                    }
                                    this.n = var1_4;
                                    return var1_4;
                                }
                                case 46: {
                                    if (var1_4 != 2) return var2_1;
                                    var1_4 = 3;
                                    break block16;
                                }
                                case 45: {
                                    if (var1_4 != 0) ** GOTO lbl67
                                    var1_4 = 1;
                                    var5_6 = true;
                                    break block16;
lbl67: // 1 sources:
                                    if (var1_4 != 5) return var2_1;
                                    break;
                                }
                            }
                            break block17;
                        }
                        if (var1_4 != 2) {
                            if (var1_4 != 4) return var2_1;
                        }
                        var1_4 = 5;
                        break block16;
                    }
                    if (var1_4 != 5) return var2_1;
                }
                var1_4 = 6;
            }
            var4_3 = var6_7;
        } while (true);
    }

    private String w() {
        long l2 = this.l.c(i);
        if (l2 != -1L) {
            return this.m.e(l2);
        }
        return this.m.p();
    }

    private void x() {
        long l2 = this.l.c(i);
        c c2 = this.m;
        if (l2 == -1L) {
            l2 = this.m.b();
        }
        c2.i(l2);
    }

    private void y() {
        if (this.e) {
            return;
        }
        throw this.a("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void z() {
        long l2 = this.l.c(j);
        c c2 = this.m;
        l2 = l2 != -1L ? ++l2 : this.m.b();
        c2.i(l2);
    }

    @Override
    public int a(k.a a2) {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 >= 12) {
            if (n3 > 15) {
                return -1;
            }
            if (n3 == 15) {
                return this.a(this.q, a2);
            }
            n3 = this.l.a(a2.b);
            if (n3 != -1) {
                this.n = 0;
                this.c[this.a - 1] = a2.a[n3];
                return n3;
            }
            String string2 = this.c[this.a - 1];
            String string3 = this.s();
            n3 = this.a(string3, a2);
            if (n3 == -1) {
                this.n = 15;
                this.q = string3;
                this.c[this.a - 1] = string2;
            }
            return n3;
        }
        return -1;
    }

    @Override
    public int b(k.a arrn) {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 >= 8) {
            if (n3 > 11) {
                return -1;
            }
            if (n3 == 11) {
                return this.b(this.q, (k.a)arrn);
            }
            n3 = this.l.a(arrn.b);
            if (n3 != -1) {
                this.n = 0;
                arrn = this.d;
                n2 = this.a - 1;
                arrn[n2] = arrn[n2] + 1;
                return n3;
            }
            String string2 = this.j();
            n3 = this.b(string2, (k.a)arrn);
            if (n3 == -1) {
                this.n = 11;
                this.q = string2;
                arrn = this.d;
                n2 = this.a - 1;
                arrn[n2] = arrn[n2] - 1;
            }
            return n3;
        }
        return -1;
    }

    @Override
    public void c() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 3) {
            this.a(1);
            this.d[this.a - 1] = 0;
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.h());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    @Override
    public void close() {
        this.n = 0;
        this.b[0] = 8;
        this.a = 1;
        this.m.s();
        this.l.close();
    }

    @Override
    public void d() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 4) {
            --this.a;
            int[] arrn = this.d;
            n3 = this.a - 1;
            arrn[n3] = arrn[n3] + 1;
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.h());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    @Override
    public void e() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 1) {
            this.a(3);
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.h());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    @Override
    public void f() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 2) {
            --this.a;
            this.c[this.a] = null;
            int[] arrn = this.d;
            n3 = this.a - 1;
            arrn[n3] = arrn[n3] + 1;
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.h());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    @Override
    public boolean g() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        return n3 != 2 && n3 != 4 && n3 != 18;
    }

    @Override
    public k.b h() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        switch (n3) {
            default: {
                throw new AssertionError();
            }
            case 18: {
                return k.b.j;
            }
            case 16: 
            case 17: {
                return k.b.g;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return k.b.e;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return k.b.f;
            }
            case 7: {
                return k.b.i;
            }
            case 5: 
            case 6: {
                return k.b.h;
            }
            case 4: {
                return k.b.b;
            }
            case 3: {
                return k.b.a;
            }
            case 2: {
                return k.b.d;
            }
            case 1: 
        }
        return k.b.c;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void i() {
        block6 : {
            block7 : {
                block5 : {
                    if (this.f) {
                        var3_5 = new StringBuilder();
                        var3_5.append("Cannot skip unexpected ");
                        var3_5.append((Object)this.h());
                        var3_5.append(" at ");
                        var3_5.append(this.q());
                        throw new h(var3_5.toString());
                    }
                    var1_2 = var2_1 = this.n;
                    if (var2_1 == 0) {
                        var1_2 = this.t();
                    }
                    if (var1_2 != 14) break block5;
                    this.x();
                    break block6;
                }
                if (var1_2 != 13) break block7;
                var3_3 = m.h;
                ** GOTO lbl21
            }
            if (var1_2 == 12) {
                var3_3 = m.g;
lbl21: // 2 sources:
                this.b(var3_3);
            } else if (var1_2 != 15) {
                var3_4 = new StringBuilder();
                var3_4.append("Expected a name but was ");
                var3_4.append((Object)this.h());
                var3_4.append(" at path ");
                var3_4.append(this.q());
                throw new h(var3_4.toString());
            }
        }
        this.n = 0;
        this.c[this.a - 1] = "null";
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public String j() {
        block9 : {
            block10 : {
                block8 : {
                    var1_2 = var2_1 = this.n;
                    if (var2_1 == 0) {
                        var1_2 = this.t();
                    }
                    if (var1_2 != 10) break block8;
                    var3_3 = this.w();
                    break block9;
                }
                if (var1_2 != 9) break block10;
                var3_3 = m.h;
                ** GOTO lbl14
            }
            if (var1_2 == 8) {
                var3_3 = m.g;
lbl14: // 2 sources:
                var3_3 = this.a((f)var3_3);
            } else if (var1_2 == 11) {
                var3_3 = this.q;
                this.q = null;
            } else if (var1_2 == 16) {
                var3_3 = Long.toString(this.o);
            } else {
                if (var1_2 != 17) {
                    var3_4 = new StringBuilder();
                    var3_4.append("Expected a string but was ");
                    var3_4.append((Object)this.h());
                    var3_4.append(" at path ");
                    var3_4.append(this.q());
                    throw new h(var3_4.toString());
                }
                var3_3 = this.m.e((long)this.p);
            }
        }
        this.n = 0;
        var4_5 = this.d;
        var1_2 = this.a - 1;
        var4_5[var1_2] = var4_5[var1_2] + 1;
        return var3_3;
    }

    @Override
    public boolean k() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 5) {
            this.n = 0;
            int[] arrn = this.d;
            n3 = this.a - 1;
            arrn[n3] = arrn[n3] + 1;
            return true;
        }
        if (n3 == 6) {
            this.n = 0;
            int[] arrn = this.d;
            n3 = this.a - 1;
            arrn[n3] = arrn[n3] + 1;
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append((Object)this.h());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    @Nullable
    @Override
    public <T> T l() {
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 7) {
            this.n = 0;
            int[] arrn = this.d;
            n3 = this.a - 1;
            arrn[n3] = arrn[n3] + 1;
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append((Object)this.h());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public double m() {
        block11 : {
            block10 : {
                block9 : {
                    block8 : {
                        var3_2 = var4_1 = this.n;
                        if (var4_1 == 0) {
                            var3_2 = this.t();
                        }
                        if (var3_2 == 16) {
                            this.n = 0;
                            var5_3 = this.d;
                            var3_2 = this.a - 1;
                            var5_3[var3_2] = var5_3[var3_2] + 1;
                            return this.o;
                        }
                        if (var3_2 != 17) break block8;
                        var5_4 = this.m.e((long)this.p);
                        ** GOTO lbl26
                    }
                    if (var3_2 != 9) break block9;
                    var5_4 = m.h;
                    break block10;
                }
                if (var3_2 != 8) break block11;
                var5_4 = m.g;
            }
            var5_4 = this.a((f)var5_4);
            ** GOTO lbl26
        }
        if (var3_2 == 10) {
            var5_4 = this.w();
lbl26: // 3 sources:
            this.q = var5_4;
        } else if (var3_2 != 11) {
            var5_7 = new StringBuilder();
            var5_7.append("Expected a double but was ");
            var5_7.append((Object)this.h());
            var5_7.append(" at path ");
            var5_7.append(this.q());
            throw new h(var5_7.toString());
        }
        this.n = 11;
        try {
            var1_8 = Double.parseDouble(this.q);
        }
        catch (NumberFormatException var5_5) {}
        if (!this.e && (Double.isNaN(var1_8) || Double.isInfinite(var1_8))) {
            var5_4 = new StringBuilder();
            var5_4.append("JSON forbids NaN and infinities: ");
            var5_4.append(var1_8);
            var5_4.append(" at path ");
            var5_4.append(this.q());
            throw new i(var5_4.toString());
        }
        this.q = null;
        this.n = 0;
        var5_4 = this.d;
        var3_2 = this.a - 1;
        var5_4[var3_2] = var5_4[var3_2] + 1;
        return var1_8;
        var5_6 = new StringBuilder();
        var5_6.append("Expected a double but was ");
        var5_6.append(this.q);
        var5_6.append(" at path ");
        var5_6.append(this.q());
        throw new h(var5_6.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public long n() {
        int n2;
        long l2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 16) {
            this.n = 0;
            int[] arrn = this.d;
            n3 = this.a - 1;
            arrn[n3] = arrn[n3] + 1;
            return this.o;
        }
        if (n3 == 17) {
            this.q = this.m.e((long)this.p);
        } else if (n3 != 9 && n3 != 8) {
            if (n3 != 11) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a long but was ");
                stringBuilder.append((Object)this.h());
                stringBuilder.append(" at path ");
                stringBuilder.append(this.q());
                throw new h(stringBuilder.toString());
            }
        } else {
            long l3;
            Object object = n3 == 9 ? h : g;
            object = this.a((f)object);
            this.q = object;
            try {
                l3 = Long.parseLong(this.q);
                this.n = 0;
                object = this.d;
                n3 = this.a - 1;
            }
            catch (NumberFormatException numberFormatException) {}
            object[n3] = object[n3] + 1;
            return l3;
        }
        this.n = 11;
        try {
            l2 = new BigDecimal(this.q).longValueExact();
        }
        catch (ArithmeticException | NumberFormatException runtimeException) {}
        this.q = null;
        this.n = 0;
        int[] arrn = this.d;
        n3 = this.a - 1;
        arrn[n3] = arrn[n3] + 1;
        return l2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a long but was ");
        stringBuilder.append(this.q);
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int o() {
        double d2;
        int n2;
        int n3 = n2 = this.n;
        if (n2 == 0) {
            n3 = this.t();
        }
        if (n3 == 16) {
            n3 = (int)this.o;
            if (this.o == (long)n3) {
                this.n = 0;
                int[] arrn = this.d;
                n2 = this.a - 1;
                arrn[n2] = arrn[n2] + 1;
                return n3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected an int but was ");
            stringBuilder.append(this.o);
            stringBuilder.append(" at path ");
            stringBuilder.append(this.q());
            throw new h(stringBuilder.toString());
        }
        if (n3 == 17) {
            this.q = this.m.e((long)this.p);
        } else if (n3 != 9 && n3 != 8) {
            if (n3 != 11) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected an int but was ");
                stringBuilder.append((Object)this.h());
                stringBuilder.append(" at path ");
                stringBuilder.append(this.q());
                throw new h(stringBuilder.toString());
            }
        } else {
            Object object = n3 == 9 ? h : g;
            object = this.a((f)object);
            this.q = object;
            try {
                n3 = Integer.parseInt(this.q);
                this.n = 0;
                object = this.d;
                n2 = this.a - 1;
            }
            catch (NumberFormatException numberFormatException) {}
            object[n2] = object[n2] + 1;
            return n3;
        }
        this.n = 11;
        try {
            d2 = Double.parseDouble(this.q);
        }
        catch (NumberFormatException numberFormatException) {}
        n3 = (int)d2;
        if ((double)n3 == d2) {
            this.q = null;
            this.n = 0;
            int[] arrn = this.d;
            n2 = this.a - 1;
            arrn[n2] = arrn[n2] + 1;
            return n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected an int but was ");
        stringBuilder.append(this.q);
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new h(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Expected an int but was ");
        stringBuilder2.append(this.q);
        stringBuilder2.append(" at path ");
        stringBuilder2.append(this.q());
        throw new h(stringBuilder2.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void p() {
        int n2;
        if (this.f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot skip unexpected ");
            stringBuilder.append((Object)this.h());
            stringBuilder.append(" at ");
            stringBuilder.append(this.q());
            throw new h(stringBuilder.toString());
        }
        int n3 = 0;
        do {
            block7 : {
                block9 : {
                    void var4_4;
                    block12 : {
                        block10 : {
                            block11 : {
                                int n4;
                                block8 : {
                                    block6 : {
                                        block5 : {
                                            block4 : {
                                                n4 = n2 = this.n;
                                                if (n2 == 0) {
                                                    n4 = this.t();
                                                }
                                                if (n4 != 3) break block4;
                                                this.a(1);
                                                break block5;
                                            }
                                            if (n4 != 1) break block6;
                                            this.a(3);
                                        }
                                        n2 = n3 + 1;
                                        break block7;
                                    }
                                    if (n4 != 4 && n4 != 2) break block8;
                                    --this.a;
                                    n2 = n3 - 1;
                                    break block7;
                                }
                                if (n4 == 14 || n4 == 10) break block9;
                                if (n4 == 9 || n4 == 13) break block10;
                                if (n4 == 8 || n4 == 12) break block11;
                                n2 = n3;
                                if (n4 == 17) {
                                    this.m.i((long)this.p);
                                    n2 = n3;
                                }
                                break block7;
                            }
                            f f2 = g;
                            break block12;
                        }
                        f f3 = h;
                    }
                    this.b((f)var4_4);
                    n2 = n3;
                    break block7;
                }
                this.x();
                n2 = n3;
            }
            this.n = 0;
            n3 = n2;
        } while (n2 != 0);
        int[] arrn = this.d;
        n2 = this.a - 1;
        arrn[n2] = arrn[n2] + 1;
        this.c[this.a - 1] = "null";
    }

    @Override
    void r() {
        if (this.g()) {
            this.q = this.s();
            this.n = 11;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String s() {
        block5 : {
            block6 : {
                block4 : {
                    var1_2 = var2_1 = this.n;
                    if (var2_1 == 0) {
                        var1_2 = this.t();
                    }
                    if (var1_2 != 14) break block4;
                    var3_3 = this.w();
                    break block5;
                }
                if (var1_2 != 13) break block6;
                var3_3 = m.h;
                ** GOTO lbl14
            }
            if (var1_2 == 12) {
                var3_3 = m.g;
lbl14: // 2 sources:
                var3_3 = this.a((f)var3_3);
            } else {
                if (var1_2 != 15) {
                    var3_4 = new StringBuilder();
                    var3_4.append("Expected a name but was ");
                    var3_4.append((Object)this.h());
                    var3_4.append(" at path ");
                    var3_4.append(this.q());
                    throw new h(var3_4.toString());
                }
                var3_3 = this.q;
            }
        }
        this.n = 0;
        this.c[this.a - 1] = var3_3;
        return var3_3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonReader(");
        stringBuilder.append(this.l);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

