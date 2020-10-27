package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class zzpw {
    private final Object lock = new Object();
    private final zzazz zzbmo;
    private final WeakHashMap<Object, Object> zzbow = new WeakHashMap<>();
    private final ArrayList<Object> zzbox = new ArrayList<>();
    private final zzajf zzboy;
    private final Context zzzo;

    public zzpw(Context context, zzazz zzazz) {
        this.zzzo = context.getApplicationContext();
        this.zzbmo = zzazz;
        this.zzboy = new zzajf(context.getApplicationContext(), zzazz, (String) zzvj.zzpv().zzd(zzzz.zzciv));
    }
}
