// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class ads
{
    public static final String[] EMPTY_STRING_ARRAY;
    private static int zzcsA;
    private static int zzcsB;
    public static final int[] zzcsC;
    public static final long[] zzcsD;
    public static final float[] zzcsE;
    private static double[] zzcsF;
    public static final boolean[] zzcsG;
    public static final byte[][] zzcsH;
    public static final byte[] zzcsI;
    private static int zzcsy;
    private static int zzcsz;
    
    static {
        ads.zzcsy = 11;
        ads.zzcsz = 12;
        ads.zzcsA = 16;
        ads.zzcsB = 26;
        zzcsC = new int[0];
        zzcsD = new long[0];
        zzcsE = new float[0];
        ads.zzcsF = new double[0];
        zzcsG = new boolean[0];
        EMPTY_STRING_ARRAY = new String[0];
        zzcsH = new byte[0][];
        zzcsI = new byte[0];
    }
    
    public static final int zzb(final adg adg, final int n) throws IOException {
        int n2 = 1;
        final int position = adg.getPosition();
        adg.zzcm(n);
        while (adg.zzLA() == n) {
            adg.zzcm(n);
            ++n2;
        }
        adg.zzq(position, n);
        return n2;
    }
}
