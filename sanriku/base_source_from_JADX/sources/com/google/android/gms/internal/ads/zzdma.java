package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzdma {
    private final zzdmd zzhbr;
    private final Task<zzbv.zza> zzhbs;
    private final zzdmg zzhbt;
    private final Task<zzbv.zza> zzhbu;
    private final Context zzvf;
    private final zzdlk zzvj;
    private final zzdlo zzxy;

    public zzdma(@NonNull Context context, @NonNull Executor executor, @NonNull zzdlk zzdlk, @NonNull zzdlo zzdlo) {
        this(context, executor, zzdlk, zzdlo, new zzdmg(), new zzdmd());
    }

    @VisibleForTesting
    private zzdma(Context context, Executor executor, zzdlk zzdlk, zzdlo zzdlo, zzdmg zzdmg, zzdmd zzdmd) {
        this.zzvf = context;
        this.zzvj = zzdlk;
        this.zzxy = zzdlo;
        this.zzhbt = zzdmg;
        this.zzhbr = zzdmd;
        this.zzhbs = Tasks.call(executor, new zzdlz(this)).addOnFailureListener(new zzdmc(this));
        this.zzhbu = Tasks.call(executor, new zzdmb(this)).addOnFailureListener(new zzdme(this));
    }

    private final synchronized zzbv.zza zza(Task<zzbv.zza> task) {
        if (!task.isComplete()) {
            try {
                Tasks.await(task, 200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                zze(e);
            }
        }
        if (!task.isSuccessful()) {
            return (zzbv.zza) ((zzecd) zzbv.zza.zzar().zzu(ExifInterface.LONGITUDE_EAST).zzbet());
        }
        return task.getResult();
    }

    private final synchronized zzbv.zza zzaum() {
        return zza(this.zzhbs);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final void zze(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvj.zza(2025, -1, exc);
    }

    private final synchronized zzbv.zza zzcp() {
        return zza(this.zzhbu);
    }

    public final String zzag() {
        return zzcp().zzag();
    }

    public final String zzam() {
        return zzaum().zzam();
    }

    public final boolean zzao() {
        return zzaum().zzao();
    }

    public final int zzaun() {
        return zzaum().zzan().zzw();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbv.zza zzauo() throws Exception {
        PackageInfo packageInfo = this.zzvf.getPackageManager().getPackageInfo(this.zzvf.getPackageName(), 0);
        Context context = this.zzvf;
        return zzdlu.zzj(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbv.zza zzaup() throws Exception {
        if (!this.zzxy.zzaug()) {
            return zzbv.zza.zzas();
        }
        Context context = this.zzvf;
        zzbv.zza.C2654zza zzar = zzbv.zza.zzar();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zzar.zzaa(id);
            zzar.zza(info.isLimitAdTrackingEnabled());
            zzar.zza(zzbv.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzbv.zza) ((zzecd) zzar.zzbet());
    }
}
