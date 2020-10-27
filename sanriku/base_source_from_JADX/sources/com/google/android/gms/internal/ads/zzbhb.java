package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;

public class zzbhb {
    private final zzazz zzbml;
    private final WeakReference<Context> zzenh;
    private final Context zzzo;

    public static class zza {
        /* access modifiers changed from: private */
        public zzazz zzbml;
        /* access modifiers changed from: private */
        public WeakReference<Context> zzenh;
        /* access modifiers changed from: private */
        public Context zzzo;

        public final zza zza(zzazz zzazz) {
            this.zzbml = zzazz;
            return this;
        }

        public final zza zzbu(Context context) {
            this.zzenh = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzzo = context;
            return this;
        }
    }

    private zzbhb(zza zza2) {
        this.zzbml = zza2.zzbml;
        this.zzzo = zza2.zzzo;
        this.zzenh = zza2.zzenh;
    }

    /* access modifiers changed from: package-private */
    public final Context zzadl() {
        return this.zzzo;
    }

    /* access modifiers changed from: package-private */
    public final WeakReference<Context> zzadm() {
        return this.zzenh;
    }

    /* access modifiers changed from: package-private */
    public final zzazz zzadn() {
        return this.zzbml;
    }

    /* access modifiers changed from: package-private */
    public final String zzado() {
        return zzq.zzkw().zzr(this.zzzo, this.zzbml.zzbnd);
    }

    public final zzdt zzadp() {
        return new zzdt(new zzh(this.zzzo, this.zzbml));
    }
}
