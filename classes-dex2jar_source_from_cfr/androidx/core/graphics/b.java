/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class b {
    private static int a(String string2, int n2) {
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (((c2 - 65) * (c2 - 90) <= 0 || (c2 - 97) * (c2 - 122) <= 0) && c2 != 'e' && c2 != 'E') {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static Path a(String string2) {
        Path path = new Path();
        Object object = b.b(string2);
        if (object != null) {
            try {
                b.a((b[])object, path);
                return path;
            }
            catch (RuntimeException runtimeException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Error in parsing ");
                ((StringBuilder)object).append(string2);
                throw new RuntimeException(((StringBuilder)object).toString(), runtimeException);
            }
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void a(String var0, int var1_1, a var2_2) {
        var2_2.b = false;
        var3_4 = false;
        var6_5 = false;
        var5_6 = false;
        for (var4_3 = var1_1; var4_3 < var0.length(); ++var4_3) {
            block9 : {
                block8 : {
                    var7_7 = var0.charAt(var4_3);
                    if (var7_7 == ' ') break block8;
                    if (var7_7 == 'E' || var7_7 == 'e') ** GOTO lbl23
                    switch (var7_7) {
                        default: {
                            ** GOTO lbl21
                        }
                        case '.': {
                            if (var6_5) ** GOTO lbl19
                            var3_4 = false;
                            var6_5 = true;
                            break block9;
                        }
                        case '-': {
                            if (var4_3 == var1_1 || var3_4) ** GOTO lbl21
lbl19: // 2 sources:
                            var2_2.b = true;
                            break;
lbl21: // 2 sources:
                            var3_4 = false;
                            break block9;
                        }
lbl23: // 1 sources:
                        var3_4 = true;
                        break block9;
                        case ',': 
                    }
                }
                var3_4 = false;
                var5_6 = true;
            }
            if (var5_6) break;
        }
        var2_2.a = var4_3;
    }

    private static void a(ArrayList<b> arrayList, char c2, float[] arrf) {
        arrayList.add(new b(c2, arrf));
    }

    public static boolean a(b[] arrb, b[] arrb2) {
        if (arrb != null) {
            if (arrb2 == null) {
                return false;
            }
            if (arrb.length != arrb2.length) {
                return false;
            }
            for (int i2 = 0; i2 < arrb.length; ++i2) {
                if (arrb[i2].a == arrb2[i2].a) {
                    if (arrb[i2].b.length == arrb2[i2].b.length) continue;
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    static float[] a(float[] arrf, int n2, int n3) {
        if (n2 <= n3) {
            int n4 = arrf.length;
            if (n2 >= 0 && n2 <= n4) {
                n4 = Math.min(n3 -= n2, n4 - n2);
                float[] arrf2 = new float[n3];
                System.arraycopy(arrf, n2, arrf2, 0, n4);
                return arrf2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static b[] a(b[] arrb) {
        if (arrb == null) {
            return null;
        }
        b[] arrb2 = new b[arrb.length];
        for (int i2 = 0; i2 < arrb.length; ++i2) {
            arrb2[i2] = new b(arrb[i2]);
        }
        return arrb2;
    }

    public static void b(b[] arrb, b[] arrb2) {
        for (int i2 = 0; i2 < arrb2.length; ++i2) {
            arrb[i2].a = arrb2[i2].a;
            for (int i3 = 0; i3 < arrb2[i2].b.length; ++i3) {
                arrb[i2].b[i3] = arrb2[i2].b[i3];
            }
        }
    }

    public static b[] b(String string2) {
        if (string2 == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<b>();
        int n2 = 1;
        int n3 = 0;
        while (n2 < string2.length()) {
            String string3 = string2.substring(n3, n2 = b.a(string2, n2)).trim();
            if (string3.length() > 0) {
                float[] arrf = b.c(string3);
                b.a(arrayList, string3.charAt(0), arrf);
            }
            n3 = n2++;
        }
        if (n2 - n3 == 1 && n3 < string2.length()) {
            b.a(arrayList, string2.charAt(n3), new float[0]);
        }
        return arrayList.toArray(new b[arrayList.size()]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static float[] c(String string2) {
        int n2;
        a a2;
        float[] arrf;
        int n3;
        int n4;
        if (string2.charAt(0) == 'z') return new float[0];
        if (string2.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            arrf = new float[string2.length()];
            a2 = new a();
            n4 = string2.length();
            n3 = 1;
            n2 = 0;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error in parsing \"");
            stringBuilder.append(string2);
            stringBuilder.append("\"");
            throw new RuntimeException(stringBuilder.toString(), numberFormatException);
        }
        while (n3 < n4) {
            b.a(string2, n3, a2);
            int n5 = a2.a;
            int n6 = n2;
            if (n3 < n5) {
                arrf[n2] = Float.parseFloat(string2.substring(n3, n5));
                n6 = n2 + 1;
            }
            if (a2.b) {
                n3 = n5;
                n2 = n6;
                continue;
            }
            n3 = n5 + 1;
            n2 = n6;
        }
        return b.a(arrf, 0, n2);
    }

    private static class a {
        int a;
        boolean b;

        a() {
        }
    }

    public static class b {
        public char a;
        public float[] b;

        b(char c2, float[] arrf) {
            this.a = c2;
            this.b = arrf;
        }

        b(b b2) {
            this.a = b2.a;
            this.b = b.a(b2.b, 0, b2.b.length);
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            int n2 = (int)Math.ceil(Math.abs(d10 * 4.0 / 3.141592653589793));
            double d11 = Math.cos(d8);
            double d12 = Math.sin(d8);
            double d13 = Math.cos(d9);
            double d14 = Math.sin(d9);
            d8 = -d4;
            double d15 = d8 * d11;
            double d16 = d5 * d12;
            double d17 = d8 * d12;
            d8 = d5 * d11;
            double d18 = d10 / (double)n2;
            int n3 = 0;
            double d19 = d14 * d17 + d13 * d8;
            d13 = d15 * d14 - d16 * d13;
            d14 = d7;
            d10 = d6;
            double d20 = d9;
            d5 = d12;
            d6 = d11;
            d7 = d17;
            d9 = d18;
            do {
                d11 = d4;
                if (n3 >= n2) break;
                d17 = d20 + d9;
                d18 = Math.sin(d17);
                double d21 = Math.cos(d17);
                d12 = d2 + d11 * d6 * d21 - d16 * d18;
                double d22 = d3 + d11 * d5 * d21 + d8 * d18;
                d11 = d15 * d18 - d16 * d21;
                d18 = d18 * d7 + d21 * d8;
                d20 = d17 - d20;
                d21 = Math.tan(d20 / 2.0);
                d20 = Math.sin(d20) * (Math.sqrt(d21 * 3.0 * d21 + 4.0) - 1.0) / 3.0;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float)(d10 + d13 * d20), (float)(d14 + d19 * d20), (float)(d12 - d20 * d11), (float)(d22 - d20 * d18), (float)d12, (float)d22);
                ++n3;
                d14 = d22;
                d10 = d12;
                d20 = d17;
                d19 = d18;
                d13 = d11;
            } while (true);
        }

        private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl2, boolean bl3) {
            double d2 = Math.toRadians(f8);
            double d3 = Math.cos(d2);
            double d4 = Math.sin(d2);
            double d5 = f2;
            double d6 = f3;
            double d7 = f6;
            double d8 = (d5 * d3 + d6 * d4) / d7;
            double d9 = -f2;
            double d10 = f7;
            double d11 = (d9 * d4 + d6 * d3) / d10;
            double d12 = f4;
            d9 = f5;
            double d13 = (d12 * d3 + d9 * d4) / d7;
            double d14 = ((double)(-f4) * d4 + d9 * d3) / d10;
            double d15 = d8 - d13;
            double d16 = d11 - d14;
            d12 = (d8 + d13) / 2.0;
            d9 = (d11 + d14) / 2.0;
            double d17 = d15 * d15 + d16 * d16;
            if (d17 == 0.0) {
                Log.w((String)"PathParser", (String)" Points are coincident");
                return;
            }
            double d18 = 1.0 / d17 - 0.25;
            if (d18 < 0.0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Points are too far apart ");
                stringBuilder.append(d17);
                Log.w((String)"PathParser", (String)stringBuilder.toString());
                float f9 = (float)(Math.sqrt(d17) / 1.99999);
                b.a(path, f2, f3, f4, f5, f6 * f9, f7 * f9, f8, bl2, bl3);
                return;
            }
            d17 = Math.sqrt(d18);
            d15 *= d17;
            d16 = d17 * d16;
            if (bl2 == bl3) {
                d12 -= d16;
                d9 += d15;
            } else {
                d12 += d16;
                d9 -= d15;
            }
            d16 = Math.atan2(d11 - d9, d8 - d12);
            d11 = Math.atan2(d14 - d9, d13 - d12) - d16;
            double d19 = d11 DCMPL 0.0;
            bl2 = d19 >= 0;
            d8 = d11;
            if (bl3 != bl2) {
                d8 = d19 > 0 ? d11 - 6.283185307179586 : d11 + 6.283185307179586;
            }
            b.a(path, (d12 *= d7) * d3 - (d9 *= d10) * d4, d12 * d4 + d9 * d3, d7, d10, d5, d6, d2, d16, d8);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static void a(Path var0, float[] var1_1, char var2_2, char var3_3, float[] var4_4) {
            var11_5 = var1_1[0];
            var12_6 = var1_1[1];
            var13_7 = var1_1[2];
            var14_8 = var1_1[3];
            var10_9 = var1_1[4];
            var9_10 = var1_1[5];
            var5_11 = var11_5;
            var6_12 = var12_6;
            var7_13 = var13_7;
            var8_14 = var14_8;
            switch (var3_3) {
                default: {
                    var8_14 = var14_8;
                    var7_13 = var13_7;
                    var6_12 = var12_6;
                    var5_11 = var11_5;
                    ** GOTO lbl23
                }
                case 'Z': 
                case 'z': {
                    var0.close();
                    var0.moveTo(var10_9, var9_10);
                    var7_13 = var5_11 = var10_9;
                    var8_14 = var6_12 = var9_10;
                }
lbl23: // 3 sources:
                case 'L': 
                case 'M': 
                case 'T': 
                case 'l': 
                case 'm': 
                case 't': {
                    var15_15 = 2;
                    ** break;
                }
                case 'Q': 
                case 'S': 
                case 'q': 
                case 's': {
                    var15_15 = 4;
                    var5_11 = var11_5;
                    var6_12 = var12_6;
                    var7_13 = var13_7;
                    var8_14 = var14_8;
                    ** break;
                }
                case 'H': 
                case 'V': 
                case 'h': 
                case 'v': {
                    var15_15 = 1;
                    var5_11 = var11_5;
                    var6_12 = var12_6;
                    var7_13 = var13_7;
                    var8_14 = var14_8;
                    ** break;
                }
                case 'C': 
                case 'c': {
                    var15_15 = 6;
                    var5_11 = var11_5;
                    var6_12 = var12_6;
                    var7_13 = var13_7;
                    var8_14 = var14_8;
                    ** break;
                }
                case 'A': 
                case 'a': 
            }
            var15_15 = 7;
            var8_14 = var14_8;
            var7_13 = var13_7;
            var6_12 = var12_6;
            var5_11 = var11_5;
lbl53: // 5 sources:
            var11_5 = var6_12;
            var17_16 = 0;
            var16_17 = var2_2;
            var2_2 = var17_16;
            var6_12 = var5_11;
            var5_11 = var11_5;
            do {
                block43 : {
                    block44 : {
                        if (var2_2 >= var4_4.length) {
                            var1_1[0] = var6_12;
                            var1_1[1] = var5_11;
                            var1_1[2] = var7_13;
                            var1_1[3] = var8_14;
                            var1_1[4] = var10_9;
                            var1_1[5] = var9_10;
                            return;
                        }
                        var11_5 = 0.0f;
                        switch (var3_3) {
                            case 'v': {
                                var16_17 = var2_2 + 0;
                                var0.rLineTo(0.0f, var4_4[var16_17]);
                                var11_5 = var4_4[var16_17];
                                ** GOTO lbl146
                            }
                            case 't': {
                                if (var16_17 != 113 && var16_17 != 116 && var16_17 != 81 && var16_17 != 84) {
                                    var8_14 = 0.0f;
                                    var7_13 = var11_5;
                                } else {
                                    var7_13 = var6_12 - var7_13;
                                    var8_14 = var5_11 - var8_14;
                                }
                                var16_17 = var2_2 + 0;
                                var11_5 = var4_4[var16_17];
                                var17_16 = var2_2 + 1;
                                var0.rQuadTo(var7_13, var8_14, var11_5, var4_4[var17_16]);
                                var11_5 = var6_12 + var4_4[var16_17];
                                var12_6 = var5_11 + var4_4[var17_16];
                                var8_14 += var5_11;
                                var7_13 += var6_12;
                                var5_11 = var12_6;
                                var6_12 = var11_5;
                                ** GOTO lbl169
                            }
                            case 's': {
                                if (var16_17 != 99 && var16_17 != 115 && var16_17 != 67 && var16_17 != 83) {
                                    var7_13 = 0.0f;
                                    var8_14 = 0.0f;
                                } else {
                                    var8_14 = var5_11 - var8_14;
                                    var7_13 = var6_12 - var7_13;
                                }
                                var16_17 = var2_2 + 0;
                                var11_5 = var4_4[var16_17];
                                var17_16 = var2_2 + 1;
                                var12_6 = var4_4[var17_16];
                                var18_18 = var2_2 + 2;
                                var13_7 = var4_4[var18_18];
                                var19_19 = var2_2 + 3;
                                var0.rCubicTo(var7_13, var8_14, var11_5, var12_6, var13_7, var4_4[var19_19]);
                                var7_13 = var4_4[var16_17] + var6_12;
                                var8_14 = var4_4[var17_16] + var5_11;
                                var6_12 += var4_4[var18_18];
                                var11_5 = var4_4[var19_19];
                                ** GOTO lbl168
                            }
                            case 'q': {
                                var16_17 = var2_2 + 0;
                                var7_13 = var4_4[var16_17];
                                var17_16 = var2_2 + 1;
                                var8_14 = var4_4[var17_16];
                                var18_18 = var2_2 + 2;
                                var11_5 = var4_4[var18_18];
                                var19_19 = var2_2 + 3;
                                var0.rQuadTo(var7_13, var8_14, var11_5, var4_4[var19_19]);
                                var7_13 = var4_4[var16_17] + var6_12;
                                var8_14 = var4_4[var17_16] + var5_11;
                                var6_12 += var4_4[var18_18];
                                var11_5 = var4_4[var19_19];
                                ** GOTO lbl168
                            }
                            case 'm': {
                                var16_17 = var2_2 + 0;
                                var6_12 += var4_4[var16_17];
                                var17_16 = var2_2 + 1;
                                var5_11 += var4_4[var17_16];
                                if (var2_2 > 0) {
                                    var0.rLineTo(var4_4[var16_17], var4_4[var17_16]);
                                } else {
                                    var0.rMoveTo(var4_4[var16_17], var4_4[var17_16]);
                                    var9_10 = var5_11;
                                    var10_9 = var6_12;
                                }
                                ** GOTO lbl169
                            }
                            case 'l': {
                                var16_17 = var2_2 + 0;
                                var11_5 = var4_4[var16_17];
                                var17_16 = var2_2 + 1;
                                var0.rLineTo(var11_5, var4_4[var17_16]);
                                var6_12 += var4_4[var16_17];
                                var11_5 = var4_4[var17_16];
lbl146: // 2 sources:
                                var5_11 += var11_5;
                                ** GOTO lbl169
                            }
                            case 'h': {
                                var16_17 = var2_2 + 0;
                                var0.rLineTo(var4_4[var16_17], 0.0f);
                                var6_12 += var4_4[var16_17];
                                ** GOTO lbl169
                            }
                            case 'c': {
                                var7_13 = var4_4[var2_2 + 0];
                                var8_14 = var4_4[var2_2 + 1];
                                var16_17 = var2_2 + 2;
                                var11_5 = var4_4[var16_17];
                                var17_16 = var2_2 + 3;
                                var12_6 = var4_4[var17_16];
                                var18_18 = var2_2 + 4;
                                var13_7 = var4_4[var18_18];
                                var19_19 = var2_2 + 5;
                                var0.rCubicTo(var7_13, var8_14, var11_5, var12_6, var13_7, var4_4[var19_19]);
                                var7_13 = var4_4[var16_17] + var6_12;
                                var8_14 = var4_4[var17_16] + var5_11;
                                var6_12 += var4_4[var18_18];
                                var11_5 = var4_4[var19_19];
lbl168: // 3 sources:
                                var5_11 += var11_5;
                            }
lbl169: // 7 sources:
                            default: {
                                break block43;
                            }
                            case 'a': {
                                var16_17 = var2_2 + 5;
                                var7_13 = var4_4[var16_17];
                                var17_16 = var2_2 + 6;
                                var8_14 = var4_4[var17_16];
                                var11_5 = var4_4[var2_2 + 0];
                                var12_6 = var4_4[var2_2 + 1];
                                var13_7 = var4_4[var2_2 + 2];
                                var20_20 = var4_4[var2_2 + 3] != 0.0f;
                                var21_21 = var4_4[var2_2 + 4] != 0.0f;
                                b.a(var0, var6_12, var5_11, var7_13 + var6_12, var8_14 + var5_11, var11_5, var12_6, var13_7, var20_20, var21_21);
                                var6_12 += var4_4[var16_17];
                                var5_11 += var4_4[var17_16];
                                break block44;
                            }
                            case 'V': {
                                var16_17 = var2_2 + 0;
                                var0.lineTo(var6_12, var4_4[var16_17]);
                                var5_11 = var4_4[var16_17];
                                break block43;
                            }
                            case 'T': {
                                var11_5 = var5_11;
                                var12_6 = var6_12;
                                var17_16 = var2_2;
                                if (var16_17 == 113 || var16_17 == 116 || var16_17 == 81) ** GOTO lbl198
                                var6_12 = var12_6;
                                var5_11 = var11_5;
                                if (var16_17 != 84) ** GOTO lbl200
lbl198: // 2 sources:
                                var5_11 = var11_5 * 2.0f - var8_14;
                                var6_12 = var12_6 * 2.0f - var7_13;
lbl200: // 2 sources:
                                var16_17 = var17_16 + 0;
                                var7_13 = var4_4[var16_17];
                                var0.quadTo(var6_12, var5_11, var7_13, var4_4[++var17_16]);
                                var11_5 = var4_4[var16_17];
                                var12_6 = var4_4[var17_16];
                                var7_13 = var6_12;
                                var8_14 = var5_11;
                                var5_11 = var12_6;
                                var6_12 = var11_5;
                                break block43;
                            }
                            case 'S': {
                                var17_16 = var2_2;
                                if (var16_17 != 99 && var16_17 != 115 && var16_17 != 67 && var16_17 != 83) {
                                    var7_13 = var5_11;
                                    var5_11 = var6_12;
                                    var6_12 = var7_13;
                                } else {
                                    var5_11 = var5_11 * 2.0f - var8_14;
                                    var7_13 = var6_12 * 2.0f - var7_13;
                                    var6_12 = var5_11;
                                    var5_11 = var7_13;
                                }
                                var16_17 = var17_16 + 0;
                                var7_13 = var4_4[var16_17];
                                var18_18 = var17_16 + 1;
                                var8_14 = var4_4[var18_18];
                                var19_19 = var17_16 + 2;
                                var11_5 = var4_4[var19_19];
                                var0.cubicTo(var5_11, var6_12, var7_13, var8_14, var11_5, var4_4[var17_16 += 3]);
                                var8_14 = var4_4[var16_17];
                                var7_13 = var4_4[var18_18];
                                var6_12 = var4_4[var19_19];
                                var5_11 = var4_4[var17_16];
                                ** GOTO lbl246
                            }
                            case 'Q': {
                                var16_17 = var2_2;
                                var17_16 = var16_17 + 0;
                                var5_11 = var4_4[var17_16];
                                var18_18 = var16_17 + 1;
                                var6_12 = var4_4[var18_18];
                                var19_19 = var16_17 + 2;
                                var7_13 = var4_4[var19_19];
                                var0.quadTo(var5_11, var6_12, var7_13, var4_4[var16_17 += 3]);
                                var8_14 = var4_4[var17_16];
                                var7_13 = var4_4[var18_18];
                                var6_12 = var4_4[var19_19];
                                var5_11 = var4_4[var16_17];
lbl246: // 2 sources:
                                var11_5 = var7_13;
                                var7_13 = var8_14;
                                var8_14 = var11_5;
                                break block43;
                            }
                            case 'M': {
                                var16_17 = var2_2;
                                var17_16 = var16_17 + 0;
                                var6_12 = var4_4[var17_16];
                                var18_18 = var16_17 + 1;
                                var5_11 = var4_4[var18_18];
                                if (var16_17 > 0) {
                                    var0.lineTo(var4_4[var17_16], var4_4[var18_18]);
                                } else {
                                    var0.moveTo(var4_4[var17_16], var4_4[var18_18]);
                                    var9_10 = var5_11;
                                    var10_9 = var6_12;
                                }
                                break block43;
                            }
                            case 'L': {
                                var16_17 = var2_2;
                                var17_16 = var16_17 + 0;
                                var5_11 = var4_4[var17_16];
                                var0.lineTo(var5_11, var4_4[++var16_17]);
                                var6_12 = var4_4[var17_16];
                                var5_11 = var4_4[var16_17];
                                break block43;
                            }
                            case 'H': {
                                var16_17 = var2_2 + 0;
                                var0.lineTo(var4_4[var16_17], var5_11);
                                var6_12 = var4_4[var16_17];
                                break block43;
                            }
                            case 'C': {
                                var16_17 = var2_2;
                                var5_11 = var4_4[var16_17 + 0];
                                var6_12 = var4_4[var16_17 + 1];
                                var17_16 = var16_17 + 2;
                                var7_13 = var4_4[var17_16];
                                var18_18 = var16_17 + 3;
                                var8_14 = var4_4[var18_18];
                                var19_19 = var16_17 + 4;
                                var11_5 = var4_4[var19_19];
                                var0.cubicTo(var5_11, var6_12, var7_13, var8_14, var11_5, var4_4[var16_17 += 5]);
                                var6_12 = var4_4[var19_19];
                                var5_11 = var4_4[var16_17];
                                var7_13 = var4_4[var17_16];
                                var8_14 = var4_4[var18_18];
                                break block43;
                            }
                            case 'A': 
                        }
                        var16_17 = var2_2;
                        var17_16 = var16_17 + 5;
                        var7_13 = var4_4[var17_16];
                        var18_18 = var16_17 + 6;
                        var8_14 = var4_4[var18_18];
                        var11_5 = var4_4[var16_17 + 0];
                        var12_6 = var4_4[var16_17 + 1];
                        var13_7 = var4_4[var16_17 + 2];
                        var20_20 = var4_4[var16_17 + 3] != 0.0f;
                        var21_21 = var4_4[var16_17 + 4] != 0.0f;
                        b.a(var0, var6_12, var5_11, var7_13, var8_14, var11_5, var12_6, var13_7, var20_20, var21_21);
                        var6_12 = var4_4[var17_16];
                        var5_11 = var4_4[var18_18];
                    }
                    var8_14 = var5_11;
                    var7_13 = var6_12;
                }
                var2_2 += var15_15;
                var16_17 = var3_3;
            } while (true);
        }

        public static void a(b[] arrb, Path path) {
            float[] arrf = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < arrb.length; ++i2) {
                b.a(path, arrf, c2, arrb[i2].a, arrb[i2].b);
                c2 = arrb[i2].a;
            }
        }

        public void a(b b2, b b3, float f2) {
            for (int i2 = 0; i2 < b2.b.length; ++i2) {
                this.b[i2] = b2.b[i2] * (1.0f - f2) + b3.b[i2] * f2;
            }
        }
    }

}

