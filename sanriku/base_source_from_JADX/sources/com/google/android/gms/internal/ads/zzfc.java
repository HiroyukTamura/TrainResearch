package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfc extends zzfz {
    private static zzgc<String> zzaai = new zzgc<>();
    private final Context zzaag;

    public zzfc(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2, Context context) {
        super(zzeo, str, str2, zza, i, 29);
        this.zzaag = context;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zzv(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zzar = zzaai.zzar(this.zzaag.getPackageName());
        if (zzar.get() == null) {
            synchronized (zzar) {
                if (zzar.get() == null) {
                    zzar.set((String) this.zzaaw.invoke((Object) null, new Object[]{this.zzaag}));
                }
            }
        }
        String str = zzar.get();
        synchronized (this.zzaam) {
            this.zzaam.zzv(zzcl.zza(str.getBytes(), true));
        }
    }
}
