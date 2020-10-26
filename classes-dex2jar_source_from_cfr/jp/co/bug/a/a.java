/*
 * Decompiled with CFR 0.139.
 */
package jp.co.bug.a;

public class a {
    public static String a(byte[] object) {
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer();
        int n4 = 0;
        for (n2 = 0; n2 < ((byte[])object).length; ++n2) {
            int n5;
            n3 = n5 = object[n2];
            if (n5 < 0) {
                n3 = n5 + 256;
            }
            String string2 = Integer.toBinaryString(n3);
            while (string2.length() < 8) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("0");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            stringBuffer.append(string2);
        }
        while (stringBuffer.length() % 6 != 0) {
            stringBuffer.append("0");
        }
        object = new StringBuffer();
        n2 = n4;
        while (n2 < stringBuffer.length()) {
            n3 = n2 + 6;
            n2 = Integer.parseInt(stringBuffer.substring(n2, n3), 2);
            ((StringBuffer)object).append(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "-", "_"}[n2]);
            n2 = n3;
        }
        return ((StringBuffer)object).toString();
    }
}

