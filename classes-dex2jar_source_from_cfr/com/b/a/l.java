/*
 * Decompiled with CFR 0.139.
 */
package com.b.a;

final class l {
    static String a(int n2, int[] arrn, String[] arrstring, int[] arrn2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        block4 : for (int i2 = 0; i2 < n2; ++i2) {
            switch (arrn[i2]) {
                default: {
                    continue block4;
                }
                case 3: 
                case 4: 
                case 5: {
                    stringBuilder.append('.');
                    if (arrstring[i2] == null) continue block4;
                    stringBuilder.append(arrstring[i2]);
                    continue block4;
                }
                case 1: 
                case 2: {
                    stringBuilder.append('[');
                    stringBuilder.append(arrn2[i2]);
                    stringBuilder.append(']');
                }
            }
        }
        return stringBuilder.toString();
    }
}

