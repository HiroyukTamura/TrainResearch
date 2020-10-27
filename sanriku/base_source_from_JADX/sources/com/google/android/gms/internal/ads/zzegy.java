package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class zzegy {
    public static <T> List<T> zzhs(int i) {
        return i == 0 ? Collections.emptyList() : new ArrayList(i);
    }

    static <T> HashSet<T> zzht(int i) {
        return new HashSet<>(zzhv(i));
    }

    public static <K, V> LinkedHashMap<K, V> zzhu(int i) {
        return new LinkedHashMap<>(zzhv(i));
    }

    private static int zzhv(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
