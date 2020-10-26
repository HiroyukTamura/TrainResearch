/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.aa;
import c.ab;
import c.q;
import c.s;
import c.t;
import c.v;
import c.w;
import d.c;
import d.d;
import javax.annotation.Nullable;

final class l {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final t c;
    @Nullable
    private String d;
    @Nullable
    private t.a e;
    private final aa.a f;
    @Nullable
    private v g;
    private final boolean h;
    @Nullable
    private w.a i;
    @Nullable
    private q.a j;
    @Nullable
    private ab k;

    l(String string2, t t2, @Nullable String string3, @Nullable s s2, @Nullable v v2, boolean bl2, boolean bl3, boolean bl4) {
        this.b = string2;
        this.c = t2;
        this.d = string3;
        this.f = new aa.a();
        this.g = v2;
        this.h = bl2;
        if (s2 != null) {
            this.f.a(s2);
        }
        if (bl3) {
            this.j = new q.a();
            return;
        }
        if (bl4) {
            this.i = new w.a();
            this.i.a(w.e);
        }
    }

    private static String a(String string2, boolean bl2) {
        Object object;
        block1 : {
            int n2 = string2.length();
            int n3 = 0;
            do {
                object = string2;
                if (n3 >= n2) break block1;
                int n4 = string2.codePointAt(n3);
                if (n4 < 32 || n4 >= 127 || " \"<>^`{}|\\?#".indexOf(n4) != -1 || !bl2 && (n4 == 47 || n4 == 37)) break;
                n3 += Character.charCount(n4);
            } while (true);
            object = new c();
            ((c)object).a(string2, 0, n3);
            l.a((c)object, string2, n3, n2, bl2);
            object = ((c)object).p();
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    private static void a(c var0, String var1_1, int var2_2, int var3_3, boolean var4_4) {
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

    aa a() {
        Object object;
        block14 : {
            t t2;
            Object object2;
            block13 : {
                block12 : {
                    object = this.e;
                    if (object == null) break block12;
                    t2 = ((t.a)object).c();
                    break block13;
                }
                t2 = this.c.c(this.d);
                if (t2 == null) break block14;
            }
            object = object2 = this.k;
            if (object2 == null) {
                if (this.j != null) {
                    object = this.j.a();
                } else if (this.i != null) {
                    object = this.i.a();
                } else {
                    object = object2;
                    if (this.h) {
                        object = ab.a(null, new byte[0]);
                    }
                }
            }
            v v2 = this.g;
            object2 = object;
            if (v2 != null) {
                if (object != null) {
                    object2 = new a((ab)object, v2);
                } else {
                    this.f.b("Content-Type", v2.toString());
                    object2 = object;
                }
            }
            return this.f.a(t2).a(this.b, (ab)object2).a();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Malformed URL. Base: ");
        ((StringBuilder)object).append(this.c);
        ((StringBuilder)object).append(", Relative: ");
        ((StringBuilder)object).append(this.d);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    void a(ab ab2) {
        this.k = ab2;
    }

    void a(s s2, ab ab2) {
        this.i.a(s2, ab2);
    }

    void a(w.b b2) {
        this.i.a(b2);
    }

    void a(Object object) {
        this.d = object.toString();
    }

    void a(String object, String string2) {
        if ("Content-Type".equalsIgnoreCase((String)object)) {
            object = v.a(string2);
            if (object != null) {
                this.g = object;
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Malformed content type: ");
            ((StringBuilder)object).append(string2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        this.f.b((String)object, string2);
    }

    void a(String string2, String string3, boolean bl2) {
        if (this.d != null) {
            String string4 = this.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append(string2);
            stringBuilder.append("}");
            this.d = string4.replace(stringBuilder.toString(), l.a(string3, bl2));
            return;
        }
        throw new AssertionError();
    }

    void b(String charSequence, @Nullable String string2, boolean bl2) {
        if (this.d != null) {
            this.e = this.c.d(this.d);
            if (this.e != null) {
                this.d = null;
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Malformed URL. Base: ");
                ((StringBuilder)charSequence).append(this.c);
                ((StringBuilder)charSequence).append(", Relative: ");
                ((StringBuilder)charSequence).append(this.d);
                throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
            }
        }
        if (bl2) {
            this.e.b((String)charSequence, string2);
            return;
        }
        this.e.a((String)charSequence, string2);
    }

    void c(String string2, String string3, boolean bl2) {
        if (bl2) {
            this.j.b(string2, string3);
            return;
        }
        this.j.a(string2, string3);
    }

    private static class a
    extends ab {
        private final ab a;
        private final v b;

        a(ab ab2, v v2) {
            this.a = ab2;
            this.b = v2;
        }

        @Override
        public v a() {
            return this.b;
        }

        @Override
        public void a(d d2) {
            this.a.a(d2);
        }

        @Override
        public long b() {
            return this.a.b();
        }
    }

}

