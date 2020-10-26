/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.c;
import d.f;
import java.io.IOException;

public final class e {
    static final f a;
    static final String[] b;
    static final String[] c;
    private static final String[] d;

    static {
        int n2;
        int n32;
        String[] arrstring;
        int n4;
        String[] arrstring2;
        a = f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        d = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        b = new String[64];
        c = new String[256];
        int n5 = 0;
        for (n2 = 0; n2 < c.length; ++n2) {
            e.c[n2] = c.a("%8s", new Object[]{Integer.toBinaryString(n2)}).replace(' ', '0');
        }
        e.b[0] = "";
        e.b[1] = "END_STREAM";
        int[] arrn = new int[]{1};
        e.b[8] = "PADDED";
        for (int n32 : arrn) {
            arrstring = b;
            arrstring2 = new String[]();
            arrstring2.append(b[n32]);
            arrstring2.append("|PADDED");
            arrstring[n32 | 8] = arrstring2.toString();
        }
        e.b[4] = "END_HEADERS";
        e.b[32] = "PRIORITY";
        e.b[36] = "END_HEADERS|PRIORITY";
        String[] arrstring3 = arrstring = new int[3];
        arrstring3[0] = (String)4;
        arrstring3[1] = (String)32;
        arrstring3[2] = (String)36;
        n32 = arrstring.length;
        n2 = 0;
        do {
            if (n2 >= n32) break;
            String string2 = arrstring[n2];
            int n6 = arrn.length;
            for (n4 = 0; n4 < n6; ++n4) {
                int n7 = arrn[n4];
                arrstring2 = b;
                int n8 = n7 | string2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b[n7]);
                stringBuilder.append('|');
                stringBuilder.append(b[string2]);
                arrstring2[n8] = stringBuilder.toString();
                arrstring2 = b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(b[n7]);
                stringBuilder.append('|');
                stringBuilder.append(b[string2]);
                stringBuilder.append("|PADDED");
                arrstring2[n8 | 8] = stringBuilder.toString();
            }
            ++n2;
        } while (true);
        for (n4 = n5; n4 < b.length; ++n4) {
            if (b[n4] != null) continue;
            e.b[n4] = c[n4];
        }
    }

    private e() {
    }

    static /* varargs */ IllegalArgumentException a(String string2, Object ... arrobject) {
        throw new IllegalArgumentException(c.a(string2, arrobject));
    }

    static String a(byte by2, byte by3) {
        String string2;
        if (by3 == 0) {
            return "";
        }
        switch (by2) {
            default: {
                string2 = by3 < b.length ? b[by3] : c[by3];
            }
            case 4: 
            case 6: {
                if (by3 == 1) {
                    return "ACK";
                }
                return c[by3];
            }
            case 2: 
            case 3: 
            case 7: 
            case 8: {
                return c[by3];
            }
        }
        if (by2 == 5 && (by3 & 4) != 0) {
            return string2.replace("HEADERS", "PUSH_PROMISE");
        }
        if (by2 == 0 && (by3 & 32) != 0) {
            return string2.replace("PRIORITY", "COMPRESSED");
        }
        return string2;
    }

    static String a(boolean bl2, int n2, int n3, byte by2, byte by3) {
        String string2 = by2 < d.length ? d[by2] : c.a("0x%02x", new Object[]{by2});
        String string3 = e.a(by2, by3);
        String string4 = bl2 ? "<<" : ">>";
        return c.a("%s 0x%08x %5d %-13s %s", new Object[]{string4, n2, n3, string2, string3});
    }

    static /* varargs */ IOException b(String string2, Object ... arrobject) {
        throw new IOException(c.a(string2, arrobject));
    }
}

