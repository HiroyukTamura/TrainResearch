/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import kotlin.reflect.jvm.internal.impl.d.c.a.n;

public class b {
    static final /* synthetic */ boolean a;
    private static final boolean b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        String string2;
        block2 : {
            a = b.class.desiredAssertionStatus() ^ true;
            try {
                string2 = System.getProperty("kotlin.jvm.serialization.use8to7");
                break block2;
            }
            catch (SecurityException securityException) {}
            string2 = null;
        }
        b = "true".equals(string2);
    }

    private b() {
    }

    private static void a(byte[] arrby, int n2) {
        int n3 = arrby.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            arrby[i2] = (byte)(arrby[i2] + n2 & 127);
        }
    }

    private static byte[] a(byte[] arrby) {
        int n2 = arrby.length * 7 / 8;
        byte[] arrby2 = new byte[n2];
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by2 = arrby[n3];
            byte by3 = arrby[++n3];
            int n5 = n4 + 1;
            arrby2[i2] = (byte)(((by2 & 255) >>> n4) + ((by3 & (1 << n5) - 1) << 7 - n4));
            if (n4 == 6) {
                ++n3;
                n4 = 0;
                continue;
            }
            n4 = n5;
        }
        return arrby2;
    }

    public static byte[] a(String[] arrstring) {
        String[] arrstring2 = arrstring;
        if (arrstring.length > 0) {
            arrstring2 = arrstring;
            if (!arrstring[0].isEmpty()) {
                char c2 = arrstring[0].charAt(0);
                if (c2 == '\u0000') {
                    return n.a(b.b(arrstring));
                }
                arrstring2 = arrstring;
                if (c2 == '\uffff') {
                    arrstring2 = b.b(arrstring);
                }
            }
        }
        arrstring = b.c(arrstring2);
        b.a((byte[])arrstring, 127);
        return b.a((byte[])arrstring);
    }

    private static String[] b(String[] arrstring) {
        arrstring = (String[])arrstring.clone();
        arrstring[0] = arrstring[0].substring(1);
        return arrstring;
    }

    private static byte[] c(String[] object) {
        int n2;
        Object object2;
        int n3 = ((String[])object).length;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            object2 = object[n2];
            if (!a && ((String)object2).length() > 65535) {
                object = new StringBuilder();
                ((StringBuilder)object).append("String is too long: ");
                ((StringBuilder)object).append(((String)object2).length());
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            n4 += ((String)object2).length();
        }
        object2 = new byte[n4];
        int n5 = ((String[])object).length;
        n2 = 0;
        for (n4 = 0; n4 < n5; ++n4) {
            String string2 = object[n4];
            int n6 = string2.length();
            n3 = 0;
            while (n3 < n6) {
                object2[n2] = (byte)string2.charAt(n3);
                ++n3;
                ++n2;
            }
        }
        return object2;
    }
}

