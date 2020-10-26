/*
 * Decompiled with CFR 0.139.
 */
package a.b;

import java.util.LinkedHashMap;

public final class a {
    static <K, V> LinkedHashMap<K, V> a(int n2) {
        return new LinkedHashMap(a.b(n2));
    }

    private static int b(int n2) {
        if (n2 < 3) {
            return n2 + 1;
        }
        if (n2 < 1073741824) {
            return (int)((float)n2 / 0.75f + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}

