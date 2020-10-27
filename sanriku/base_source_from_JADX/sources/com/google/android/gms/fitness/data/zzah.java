package com.google.android.gms.fitness.data;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
public final class zzah {
    private static final double zzme;
    private static final double zzmf;
    private static final double zzmg;
    private static final double zzmh;
    public static final Set<String> zzmi = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type", "debug_session", "google.android.fitness.SessionV2"})));
    private static final zzah zzml = new zzah();
    private final Map<String, Map<String, zzaj>> zzmj;
    private final Map<String, zzaj> zzmk;

    static {
        double nanos = (double) TimeUnit.SECONDS.toNanos(1);
        Double.isNaN(nanos);
        zzme = 10.0d / nanos;
        double nanos2 = (double) TimeUnit.SECONDS.toNanos(1);
        Double.isNaN(nanos2);
        zzmf = 1000.0d / nanos2;
        double nanos3 = (double) TimeUnit.HOURS.toNanos(1);
        Double.isNaN(nanos3);
        zzmg = 2000.0d / nanos3;
        double nanos4 = (double) TimeUnit.SECONDS.toNanos(1);
        Double.isNaN(nanos4);
        zzmh = 100.0d / nanos4;
    }

    private zzah() {
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", new zzaj(-90.0d, 90.0d));
        hashMap.put("longitude", new zzaj(-180.0d, 180.0d));
        hashMap.put("accuracy", new zzaj(0.0d, 10000.0d));
        hashMap.put("bpm", new zzaj(0.0d, 1000.0d));
        hashMap.put("altitude", new zzaj(-100000.0d, 100000.0d));
        hashMap.put("percentage", new zzaj(0.0d, 100.0d));
        hashMap.put("confidence", new zzaj(0.0d, 100.0d));
        hashMap.put("duration", new zzaj(0.0d, 9.223372036854776E18d));
        hashMap.put("height", new zzaj(0.0d, 3.0d));
        hashMap.put("weight", new zzaj(0.0d, 1000.0d));
        hashMap.put("speed", new zzaj(0.0d, 11000.0d));
        this.zzmk = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("com.google.step_count.delta", zza("steps", new zzaj(0.0d, zzme)));
        hashMap2.put("com.google.calories.consumed", zza(Field.NUTRIENT_CALORIES, new zzaj(0.0d, zzmf)));
        hashMap2.put("com.google.calories.expended", zza(Field.NUTRIENT_CALORIES, new zzaj(0.0d, zzmg)));
        hashMap2.put("com.google.distance.delta", zza("distance", new zzaj(0.0d, zzmh)));
        this.zzmj = Collections.unmodifiableMap(hashMap2);
    }

    private static <K, V> Map<K, V> zza(K k, V v) {
        HashMap hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    public static zzah zzw() {
        return zzml;
    }

    @Nullable
    public final zzaj zza(String str, String str2) {
        Map map = this.zzmj.get(str);
        if (map != null) {
            return (zzaj) map.get(str2);
        }
        return null;
    }

    @Nullable
    public final zzaj zzj(String str) {
        return this.zzmk.get(str);
    }
}
