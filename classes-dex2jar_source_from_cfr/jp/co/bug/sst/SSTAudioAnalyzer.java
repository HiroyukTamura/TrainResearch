/*
 * Decompiled with CFR 0.139.
 */
package jp.co.bug.sst;

public class SSTAudioAnalyzer {
    a a;

    static {
        System.loadLibrary("SSTouchManager");
    }

    public void a(a a2) {
        this.a = a2;
    }

    public native byte[] addTone(short[] var1, int var2);

    public native void finish();

    public native void init(int var1);

    public static interface a {
    }

}

