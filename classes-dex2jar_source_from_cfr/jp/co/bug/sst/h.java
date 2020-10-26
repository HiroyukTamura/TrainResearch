/*
 * Decompiled with CFR 0.139.
 */
package jp.co.bug.sst;

import jp.co.bug.sst.c;
import jp.co.bug.sst.g;

public class h
implements c {
    /*
     * Exception decompiling
     */
    public static a a(int var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 12[SWITCH]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
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

    static g b(int n2, int n3) {
        Object object = h.a(jp.co.bug.sst.a.a());
        int n4 = ((a)object).a;
        int n5 = ((a)object).b;
        if (n2 == -1) {
            n2 = n4;
        }
        if (n3 == -1) {
            n3 = n5;
        }
        n5 = n2;
        if (n2 == 32000) {
            n5 = 44100;
        }
        object = new g();
        ((g)object).b(n5);
        ((g)object).a(n3);
        return object;
    }

    @Override
    public g a(int n2, int n3) {
        return h.b(n2, n3);
    }

    public static class a {
        public int a;
        public int b;

        public a(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }
    }

}

