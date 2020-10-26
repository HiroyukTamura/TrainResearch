/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class t {
    private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    final String b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;
    @Nullable
    private final List<String> h;
    @Nullable
    private final String i;
    private final String j;

    t(a a2) {
        this.a = a2.a;
        this.e = t.a(a2.b, false);
        this.f = t.a(a2.c, false);
        this.b = a2.d;
        this.c = a2.a();
        this.g = this.a(a2.f, false);
        List<String> list = a2.g;
        Object var3_3 = null;
        list = list != null ? this.a(a2.g, true) : null;
        this.h = list;
        list = var3_3;
        if (a2.h != null) {
            list = t.a(a2.h, false);
        }
        this.i = list;
        this.j = a2.toString();
    }

    public static int a(String string2) {
        if (string2.equals("http")) {
            return 80;
        }
        if (string2.equals("https")) {
            return 443;
        }
        return -1;
    }

    static String a(String string2, int n2, int n3, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Charset charset) {
        int n4;
        for (int i2 = n2; i2 < n3; i2 += Character.charCount((int)n4)) {
            n4 = string2.codePointAt(i2);
            if (!(n4 < 32 || n4 == 127 || n4 >= 128 && bl5 || string3.indexOf(n4) != -1 || n4 == 37 && (!bl2 || bl3 && !t.a(string2, i2, n3)) || n4 == 43 && bl4)) {
                continue;
            }
            d.c c2 = new d.c();
            c2.a(string2, n2, i2);
            t.a(c2, string2, i2, n3, string3, bl2, bl3, bl4, bl5, charset);
            return c2.p();
        }
        return string2.substring(n2, n3);
    }

    static String a(String string2, int n2, int n3, boolean bl2) {
        for (int i2 = n2; i2 < n3; ++i2) {
            char c2 = string2.charAt(i2);
            if (!(c2 == '%' || c2 == '+' && bl2)) {
                continue;
            }
            d.c c3 = new d.c();
            c3.a(string2, n2, i2);
            t.a(c3, string2, i2, n3, bl2);
            return c3.p();
        }
        return string2.substring(n2, n3);
    }

    static String a(String string2, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return t.a(string2, 0, string2.length(), string3, bl2, bl3, bl4, bl5, null);
    }

    static String a(String string2, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Charset charset) {
        return t.a(string2, 0, string2.length(), string3, bl2, bl3, bl4, bl5, charset);
    }

    static String a(String string2, boolean bl2) {
        return t.a(string2, 0, string2.length(), bl2);
    }

    private List<String> a(List<String> list, boolean bl2) {
        int n2 = list.size();
        ArrayList<String> arrayList = new ArrayList<String>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = list.get(i2);
            string2 = string2 != null ? t.a(string2, bl2) : null;
            arrayList.add(string2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /*
     * Exception decompiling
     */
    static void a(d.c var0, String var1_1, int var2_2, int var3_3, String var4_4, boolean var5_5, boolean var6_6, boolean var7_7, boolean var8_8, Charset var9_9) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:226)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:576)
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(d.c var0, String var1_1, int var2_2, int var3_3, boolean var4_4) {
        while (var2_2 < var3_3) {
            block4 : {
                block3 : {
                    var6_6 = var1_1.codePointAt(var2_2);
                    if (var6_6 != 37 || (var5_5 = var2_2 + 2) >= var3_3) break block3;
                    var7_7 = c.a(var1_1.charAt(var2_2 + 1));
                    var8_8 = c.a(var1_1.charAt(var5_5));
                    if (var7_7 == -1 || var8_8 == -1) ** GOTO lbl-1000
                    var0.b((var7_7 << 4) + var8_8);
                    var2_2 = var5_5;
                    break block4;
                }
                if (var6_6 == 43 && var4_4) {
                    var0.b(32);
                } else lbl-1000: // 2 sources:
                {
                    var0.a(var6_6);
                }
            }
            var2_2 += Character.charCount(var6_6);
        }
    }

    static void a(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append('/');
            stringBuilder.append(list.get(i2));
        }
    }

    static boolean a(String string2, int n2, int n3) {
        int n4 = n2 + 2;
        return n4 < n3 && string2.charAt(n2) == '%' && c.a(string2.charAt(n2 + 1)) != -1 && c.a(string2.charAt(n4)) != -1;
    }

    static List<String> b(String string2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 0;
        while (n2 <= string2.length()) {
            int n3;
            String string3;
            int n4 = n3 = string2.indexOf(38, n2);
            if (n3 == -1) {
                n4 = string2.length();
            }
            if ((n3 = string2.indexOf(61, n2)) != -1 && n3 <= n4) {
                arrayList.add(string2.substring(n2, n3));
                string3 = string2.substring(n3 + 1, n4);
            } else {
                arrayList.add(string2.substring(n2, n4));
                string3 = null;
            }
            arrayList.add(string3);
            n2 = n4 + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            String string2 = list.get(i2);
            String string3 = list.get(i2 + 1);
            if (i2 > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(string2);
            if (string3 == null) continue;
            stringBuilder.append('=');
            stringBuilder.append(string3);
        }
    }

    @Nullable
    public static t e(String string2) {
        a a2 = new a();
        t t2 = null;
        if (a2.a((t)null, string2) == a.a.a) {
            t2 = a2.c();
        }
        return t2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public URI a() {
        String string2 = this.o().b().toString();
        try {
            return new URI(string2);
        }
        catch (URISyntaxException uRISyntaxException) {
            try {
                return URI.create(string2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            }
            catch (Exception exception) {
                throw new RuntimeException(uRISyntaxException);
            }
        }
    }

    public String b() {
        return this.a;
    }

    @Nullable
    public t c(String object) {
        if ((object = this.d((String)object)) != null) {
            return ((a)object).c();
        }
        return null;
    }

    public boolean c() {
        return this.a.equals("https");
    }

    @Nullable
    public a d(String string2) {
        a a2 = new a();
        if (a2.a(this, string2) == a.a.a) {
            return a2;
        }
        return null;
    }

    public String d() {
        if (this.e.isEmpty()) {
            return "";
        }
        int n2 = this.a.length() + 3;
        int n3 = c.a(this.j, n2, this.j.length(), ":@");
        return this.j.substring(n2, n3);
    }

    public String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        int n2 = this.j.indexOf(58, this.a.length() + 3);
        int n3 = this.j.indexOf(64);
        return this.j.substring(n2 + 1, n3);
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof t && ((t)object).j.equals(this.j);
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public String h() {
        int n2 = this.j.indexOf(47, this.a.length() + 3);
        int n3 = c.a(this.j, n2, this.j.length(), "?#");
        return this.j.substring(n2, n3);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public List<String> i() {
        int n2 = this.j.indexOf(47, this.a.length() + 3);
        int n3 = c.a(this.j, n2, this.j.length(), "?#");
        ArrayList<String> arrayList = new ArrayList<String>();
        while (n2 < n3) {
            int n4 = n2 + 1;
            n2 = c.a(this.j, n4, n3, '/');
            arrayList.add(this.j.substring(n4, n2));
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    @Nullable
    public String k() {
        if (this.h == null) {
            return null;
        }
        int n2 = this.j.indexOf(63) + 1;
        int n3 = c.a(this.j, n2, this.j.length(), '#');
        return this.j.substring(n2, n3);
    }

    @Nullable
    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        t.b(stringBuilder, this.h);
        return stringBuilder.toString();
    }

    @Nullable
    public String m() {
        if (this.i == null) {
            return null;
        }
        int n2 = this.j.indexOf(35);
        return this.j.substring(n2 + 1);
    }

    public String n() {
        return this.d("/...").b("").c("").c().toString();
    }

    public a o() {
        a a2 = new a();
        a2.a = this.a;
        a2.b = this.d();
        a2.c = this.e();
        a2.d = this.b;
        int n2 = this.c != t.a(this.a) ? this.c : -1;
        a2.e = n2;
        a2.f.clear();
        a2.f.addAll(this.i());
        a2.e(this.k());
        a2.h = this.m();
        return a2;
    }

    public String toString() {
        return this.j;
    }

    public static final class c.t$a {
        @Nullable
        String a;
        String b = "";
        String c = "";
        @Nullable
        String d;
        int e = -1;
        final List<String> f = new ArrayList<String>();
        @Nullable
        List<String> g;
        @Nullable
        String h;

        public c.t$a() {
            this.f.add("");
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void a(String var1_1, int var2_2, int var3_3) {
            block2 : {
                if (var2_2 == var3_3) {
                    return;
                }
                var4_4 = var1_1.charAt(var2_2);
                if (var4_4 != 47 && var4_4 != 92) break block2;
                this.f.clear();
                this.f.add("");
                ** GOTO lbl17
            }
            this.f.set(this.f.size() - 1, "");
            while (var2_2 < var3_3) {
                var4_4 = c.a(var1_1, var2_2, var3_3, "/\\");
                var5_5 = var4_4 < var3_3;
                this.a(var1_1, var2_2, var4_4, var5_5, true);
                var2_2 = var4_4;
                if (!var5_5) continue;
                var2_2 = var4_4;
lbl17: // 2 sources:
                ++var2_2;
            }
        }

        private void a(String string2, int n2, int n3, boolean bl2, boolean bl3) {
            if (this.f(string2 = t.a(string2, n2, n3, " \"<>^`{}|/\\?#", bl3, false, false, true, null))) {
                return;
            }
            if (this.g(string2)) {
                this.d();
                return;
            }
            if (this.f.get(this.f.size() - 1).isEmpty()) {
                this.f.set(this.f.size() - 1, string2);
            } else {
                this.f.add(string2);
            }
            if (bl2) {
                this.f.add("");
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private static int b(String string2, int n2, int n3) {
            int n4;
            char c2;
            block11 : {
                block10 : {
                    if (n3 - n2 < 2) {
                        return -1;
                    }
                    c2 = string2.charAt(n2);
                    if (c2 < 'a') break block10;
                    n4 = n2;
                    if (c2 <= 'z') break block11;
                }
                if (c2 < 'A') return -1;
                n4 = n2;
                if (c2 > 'Z') {
                    return -1;
                }
            }
            while ((n2 = n4 + 1) < n3) {
                c2 = string2.charAt(n2);
                if (c2 >= 'a') {
                    n4 = n2;
                    if (c2 <= 'z') continue;
                }
                if (c2 >= 'A') {
                    n4 = n2;
                    if (c2 <= 'Z') continue;
                }
                if (c2 >= '0') {
                    n4 = n2;
                    if (c2 <= '9') continue;
                }
                n4 = n2;
                if (c2 == '+') continue;
                n4 = n2;
                if (c2 == '-') continue;
                if (c2 == '.') {
                    n4 = n2;
                    continue;
                }
                if (c2 != ':') return -1;
                return n2;
            }
            return -1;
        }

        private static int c(String string2, int n2, int n3) {
            char c2;
            int n4 = 0;
            while (n2 < n3 && ((c2 = string2.charAt(n2)) == '\\' || c2 == '/')) {
                ++n4;
                ++n2;
            }
            return n4;
        }

        private static int d(String string2, int n2, int n3) {
            while (n2 < n3) {
                char c2 = string2.charAt(n2);
                if (c2 != ':') {
                    int n4;
                    block5 : {
                        n4 = n2;
                        if (c2 != '[') {
                            n4 = n2;
                        } else {
                            do {
                                n4 = n2 = n4 + 1;
                                if (n2 >= n3) break block5;
                                n4 = n2;
                            } while (string2.charAt(n2) != ']');
                            n4 = n2;
                        }
                    }
                    n2 = n4 + 1;
                    continue;
                }
                return n2;
            }
            return n3;
        }

        private void d() {
            if (this.f.remove(this.f.size() - 1).isEmpty() && !this.f.isEmpty()) {
                this.f.set(this.f.size() - 1, "");
                return;
            }
            this.f.add("");
        }

        private static String e(String string2, int n2, int n3) {
            return c.a(t.a(string2, n2, n3, false));
        }

        private static int f(String string2, int n2, int n3) {
            try {
                n2 = Integer.parseInt(t.a(string2, n2, n3, "", false, false, false, true, null));
                if (n2 > 0 && n2 <= 65535) {
                    return n2;
                }
                return -1;
            }
            catch (NumberFormatException numberFormatException) {
                return -1;
            }
        }

        private boolean f(String string2) {
            return string2.equals(".") || string2.equalsIgnoreCase("%2e");
            {
            }
        }

        private boolean g(String string2) {
            return string2.equals("..") || string2.equalsIgnoreCase("%2e.") || string2.equalsIgnoreCase(".%2e") || string2.equalsIgnoreCase("%2e%2e");
            {
            }
        }

        int a() {
            if (this.e != -1) {
                return this.e;
            }
            return t.a(this.a);
        }

        /*
         * Enabled aggressive block sorting
         */
        a a(@Nullable t object, String string2) {
            String string3;
            int n2;
            int n3;
            int n4 = c.a(string2, 0, string2.length());
            if (c.t$a.b(string2, n4, n2 = c.b(string2, n4, string2.length())) != -1) {
                if (string2.regionMatches(true, n4, "https:", 0, 6)) {
                    this.a = "https";
                    string3 = "https:";
                } else {
                    if (!string2.regionMatches(true, n4, "http:", 0, 5)) {
                        return a.c;
                    }
                    this.a = "http";
                    string3 = "http:";
                }
                n4 += string3.length();
            } else {
                if (object == null) {
                    return a.b;
                }
                this.a = ((t)object).a;
            }
            int n5 = c.t$a.c(string2, n4, n2);
            if (n5 < 2 && object != null && ((t)object).a.equals(this.a)) {
                this.b = ((t)object).d();
                this.c = ((t)object).e();
                this.d = ((t)object).b;
                this.e = ((t)object).c;
                this.f.clear();
                this.f.addAll(((t)object).i());
                if (n4 == n2 || string2.charAt(n4) == '#') {
                    this.e(((t)object).k());
                }
                n3 = n4;
            } else {
                int n6;
                int n7 = n4 + n5;
                n4 = 0;
                n5 = 0;
                block4 : while ((n6 = (n3 = c.a(string2, n7, n2, "@/\\?#")) != n2 ? (int)string2.charAt(n3) : -1) != -1 && n6 != 35 && n6 != 47 && n6 != 92) {
                    switch (n6) {
                        default: {
                            continue block4;
                        }
                        case 64: {
                            if (n4 == 0) {
                                int n8 = c.a(string2, n7, n3, ':');
                                n6 = n3;
                                string3 = t.a(string2, n7, n8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                object = string3;
                                if (n5 != 0) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append(this.b);
                                    ((StringBuilder)object).append("%40");
                                    ((StringBuilder)object).append(string3);
                                    object = ((StringBuilder)object).toString();
                                }
                                this.b = object;
                                if (n8 != n6) {
                                    this.c = t.a(string2, n8 + 1, n6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    n4 = 1;
                                }
                                n5 = 1;
                            } else {
                                object = new StringBuilder();
                                ((StringBuilder)object).append(this.c);
                                ((StringBuilder)object).append("%40");
                                ((StringBuilder)object).append(t.a(string2, n7, n3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                                this.c = ((StringBuilder)object).toString();
                            }
                            n7 = n3 + 1;
                            continue block4;
                        }
                        case 63: {
                            break block4;
                        }
                    }
                }
                if ((n5 = (n4 = c.t$a.d(string2, n7, n3)) + 1) < n3) {
                    this.d = c.t$a.e(string2, n7, n4);
                    this.e = c.t$a.f(string2, n5, n3);
                    if (this.e == -1) {
                        return a.d;
                    }
                } else {
                    this.d = c.t$a.e(string2, n7, n4);
                    this.e = t.a(this.a);
                }
                if (this.d == null) {
                    return a.e;
                }
            }
            n5 = c.a(string2, n3, n2, "?#");
            this.a(string2, n3, n5);
            n4 = n5;
            if (n5 < n2) {
                n4 = n5;
                if (string2.charAt(n5) == '?') {
                    n4 = c.a(string2, n5, n2, '#');
                    this.g = t.b(t.a(string2, n5 + 1, n4, " \"'<>#", true, false, true, true, null));
                }
            }
            if (n4 < n2 && string2.charAt(n4) == '#') {
                this.h = t.a(string2, 1 + n4, n2, "", true, false, false, false, null);
            }
            return a.a;
        }

        public c.t$a a(int n2) {
            if (n2 > 0 && n2 <= 65535) {
                this.e = n2;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected port: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /*
         * Enabled aggressive block sorting
         */
        public c.t$a a(String string2) {
            if (string2 == null) {
                throw new NullPointerException("scheme == null");
            }
            if (string2.equalsIgnoreCase("http")) {
                string2 = "http";
            } else {
                if (!string2.equalsIgnoreCase("https")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unexpected scheme: ");
                    stringBuilder.append(string2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                string2 = "https";
            }
            this.a = string2;
            return this;
        }

        public c.t$a a(String string2, @Nullable String string3) {
            if (string2 != null) {
                if (this.g == null) {
                    this.g = new ArrayList<String>();
                }
                this.g.add(t.a(string2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                List<String> list = this.g;
                string2 = string3 != null ? t.a(string3, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null;
                list.add(string2);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        c.t$a b() {
            int n2;
            String string2;
            int n3 = this.f.size();
            int n4 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                string2 = this.f.get(n2);
                this.f.set(n2, t.a(string2, "[]", true, true, false, true));
            }
            if (this.g != null) {
                n3 = this.g.size();
                for (n2 = n4; n2 < n3; ++n2) {
                    string2 = this.g.get(n2);
                    if (string2 == null) continue;
                    this.g.set(n2, t.a(string2, "\\^`{|}", true, true, true, true));
                }
            }
            if (this.h != null) {
                this.h = t.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public c.t$a b(String string2) {
            if (string2 != null) {
                this.b = t.a(string2, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public c.t$a b(String string2, @Nullable String string3) {
            if (string2 != null) {
                if (this.g == null) {
                    this.g = new ArrayList<String>();
                }
                this.g.add(t.a(string2, " \"'<>#&=", true, false, true, true));
                List<String> list = this.g;
                string2 = string3 != null ? t.a(string3, " \"'<>#&=", true, false, true, true) : null;
                list.add(string2);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public c.t$a c(String string2) {
            if (string2 != null) {
                this.c = t.a(string2, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public t c() {
            if (this.a != null) {
                if (this.d != null) {
                    return new t(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public c.t$a d(String string2) {
            if (string2 != null) {
                CharSequence charSequence = c.t$a.e(string2, 0, string2.length());
                if (charSequence != null) {
                    this.d = charSequence;
                    return this;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("unexpected host: ");
                ((StringBuilder)charSequence).append(string2);
                throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
            }
            throw new NullPointerException("host == null");
        }

        public c.t$a e(@Nullable String list) {
            list = list != null ? t.b(t.a((String)((Object)list), " \"'<>#", true, false, true, true)) : null;
            this.g = list;
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                stringBuilder.append(this.b);
                if (!this.c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.c);
                }
                stringBuilder.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.d);
            }
            int n2 = this.a();
            if (n2 != t.a(this.a)) {
                stringBuilder.append(':');
                stringBuilder.append(n2);
            }
            t.a(stringBuilder, this.f);
            if (this.g != null) {
                stringBuilder.append('?');
                t.b(stringBuilder, this.g);
            }
            if (this.h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.h);
            }
            return stringBuilder.toString();
        }

        static enum a {
            a,
            b,
            c,
            d,
            e;
            
        }

    }

}

