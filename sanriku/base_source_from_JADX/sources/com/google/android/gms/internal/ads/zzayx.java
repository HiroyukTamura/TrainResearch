package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzayx {
    private Map<Integer, Bitmap> zzdyd = new ConcurrentHashMap();
    private AtomicInteger zzdye = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzdyd.get(num);
    }
}
