package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbm;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdlk {
    private static volatile zzbm.zza.zzc zzhbc = zzbm.zza.zzc.UNKNOWN;
    private final Executor executor;
    private final Task<zzsy> zzhbb;
    private final Context zzvf;

    private zzdlk(@NonNull Context context, @NonNull Executor executor2, @NonNull Task<zzsy> task) {
        this.zzvf = context;
        this.executor = executor2;
        this.zzhbb = task;
    }

    public static zzdlk zza(@NonNull Context context, @NonNull Executor executor2) {
        return new zzdlk(context, executor2, Tasks.call(executor2, new zzdlm(context)));
    }

    private final Task<Boolean> zza(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbm.zza.C2651zza zzc = zzbm.zza.zzt().zzi(this.zzvf.getPackageName()).zzc(j);
        zzc.zza(zzhbc);
        if (exc != null) {
            zzc.zzj(zzdom.zza(exc)).zzk(exc.getClass().getName());
        }
        if (str2 != null) {
            zzc.zzl(str2);
        }
        if (str != null) {
            zzc.zzm(str);
        }
        return this.zzhbb.continueWith(this.executor, new zzdll(zzc, i));
    }

    static final /* synthetic */ Boolean zza(zzbm.zza.C2651zza zza, int i, Task task) throws Exception {
        boolean z;
        if (task.isSuccessful()) {
            zztc zzf = ((zzsy) task.getResult()).zzf(((zzbm.zza) ((zzecd) zza.zzbet())).toByteArray());
            zzf.zzbs(i);
            zzf.zzdx();
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    static void zzb(zzbm.zza.zzc zzc) {
        zzhbc = zzc;
    }

    static final /* synthetic */ zzsy zzcg(Context context) throws Exception {
        return new zzsy(context, "GLAS", (String) null);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, (Exception) null, str, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzg(int i, long j) {
        return zza(i, j, (Exception) null, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzi(int i, String str) {
        return zza(4007, 0, (Exception) null, (String) null, (Map<String, String>) null, str);
    }
}
