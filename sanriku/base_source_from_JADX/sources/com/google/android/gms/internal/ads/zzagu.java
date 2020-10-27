package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzq;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzagu implements zzn {
    /* access modifiers changed from: private */
    public volatile zzagn zzdbd;
    private final Context zzvf;

    public zzagu(Context context) {
        this.zzvf = context;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdbd != null) {
            this.zzdbd.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzo zzc(zzq<?> zzq) throws zzae {
        zzagm zzh = zzagm.zzh(zzq);
        long elapsedRealtime = zzq.zzld().elapsedRealtime();
        try {
            zzbaj zzbaj = new zzbaj();
            this.zzdbd = new zzagn(this.zzvf, zzq.zzlk().zzxx(), new zzagy(this, zzbaj), new zzahb(this, zzbaj));
            this.zzdbd.checkAvailabilityAndConnect();
            zzdri zza = zzdqw.zza(zzdqw.zzb(zzbaj, new zzagx(this, zzh), (Executor) zzbab.zzdzr), (long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcqc)).intValue(), TimeUnit.MILLISECONDS, zzbab.zzdzu);
            zza.addListener(new zzagz(this), zzbab.zzdzr);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzq.zzld().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzawr.zzeg(sb.toString());
            zzago zzago = (zzago) new zzari(parcelFileDescriptor).zza(zzago.CREATOR);
            if (zzago == null) {
                return null;
            }
            if (zzago.zzdbb) {
                throw new zzae(zzago.zzdbc);
            } else if (zzago.zzdaz.length != zzago.zzdba.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    String[] strArr = zzago.zzdaz;
                    if (i >= strArr.length) {
                        return new zzo(zzago.statusCode, zzago.data, (Map<String, String>) hashMap, zzago.zzac, zzago.zzad);
                    }
                    hashMap.put(strArr[i], zzago.zzdba[i]);
                    i++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(zzq.zzld().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzawr.zzeg(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = zzq.zzld().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            zzawr.zzeg(sb3.toString());
            throw th;
        }
    }
}
