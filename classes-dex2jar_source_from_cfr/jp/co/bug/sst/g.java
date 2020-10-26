/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.AudioRecord
 *  android.os.Handler
 */
package jp.co.bug.sst;

import android.media.AudioRecord;
import android.os.Handler;
import jp.co.bug.sst.SSTAudioAnalyzer;
import jp.co.bug.sst.b;
import jp.co.bug.sst.d;

public class g
implements Thread.UncaughtExceptionHandler,
SSTAudioAnalyzer.a,
b {
    static long c;
    static volatile d d;
    short[] a;
    boolean b = false;
    private AudioRecord e = null;
    private volatile Handler f;
    private SSTAudioAnalyzer g;
    private int h = 6;
    private int i = 32000;
    private a j;
    private b.a k;

    static /* synthetic */ AudioRecord a(g g2, AudioRecord audioRecord) {
        g2.e = audioRecord;
        return audioRecord;
    }

    private void a(final b.c c2) {
        this.f.post(new Runnable(){

            @Override
            public void run() {
                if (g.this.k != null) {
                    g.this.k.a(c2);
                }
            }
        });
    }

    static /* synthetic */ void a(g g2, b.c c2) {
        g2.a(c2);
    }

    static /* synthetic */ void a(g g2, byte[] arrby) {
        g2.a(arrby);
    }

    private void a(final byte[] arrby) {
        this.f.post(new Runnable(){

            @Override
            public void run() {
                if (g.this.k != null) {
                    g.this.k.a(arrby);
                }
            }
        });
    }

    static /* synthetic */ AudioRecord b(g g2) {
        return g2.e;
    }

    static /* synthetic */ int c(g g2) {
        return g2.i;
    }

    static /* synthetic */ SSTAudioAnalyzer d(g g2) {
        return g2.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        synchronized (this) {
            boolean bl2 = this.b;
            if (!bl2) {
                return;
            }
            if (this.j != null) {
                this.j.a = true;
                try {
                    this.j.join();
                }
                catch (InterruptedException interruptedException) {}
                this.j = null;
            }
            if (this.g != null) {
                this.g.finish();
                this.g = null;
            }
            c = System.currentTimeMillis();
            return;
        }
    }

    @Override
    public void a(int n2) {
        this.h = n2;
    }

    @Override
    public void a(b.a a2) {
        this.k = a2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean a(Handler var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[CATCHBLOCK]], but top level block is 6[TRYBLOCK]
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

    public void b(int n2) {
        this.i = n2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    boolean b() {
        int n2;
        block7 : {
            try {
                n2 = AudioRecord.getMinBufferSize((int)this.i, (int)2, (int)2);
                if (n2 < 0) {
                    this.a = null;
                    this.e = null;
                    return false;
                }
                this.a = new short[256];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FrameRate:");
                stringBuilder.append(this.i);
                stringBuilder.append(" AudioSource:");
                stringBuilder.append(this.h);
                jp.co.bug.b.a.b(stringBuilder.toString());
                jp.co.bug.b.a.b("MinBufferSize:", n2 *= 4);
                this.e = new AudioRecord(this.h, this.i, 16, 2, n2);
                int n3 = this.e.getState();
                if (n3 == 1) break block7;
                this.a = null;
                this.e = null;
                return false;
            }
            catch (Throwable throwable) {
                this.a = null;
                this.e = null;
                throw throwable;
            }
        }
        this.e.setPositionNotificationPeriod(n2);
        return true;
        catch (IllegalArgumentException illegalArgumentException) {}
        this.a = null;
        this.e = null;
        return false;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (this.b) {
            if (throwable instanceof b.c) {
                this.a((b.c)throwable);
            } else {
                this.a(new b.c("unknown error", throwable));
            }
            this.a();
        }
    }

    private class a
    extends Thread {
        public volatile boolean a = false;
        int b = 0;
        final int c = 3;

        private a() {
        }

        /*
         * Exception decompiling
         */
        @Override
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
            // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}

