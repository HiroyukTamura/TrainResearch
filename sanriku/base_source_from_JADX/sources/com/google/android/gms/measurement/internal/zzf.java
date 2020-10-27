package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzf {
    private final zzgd zza;
    private long zzaa;
    private long zzab;
    private long zzac;
    private String zzad;
    private boolean zzae;
    private long zzaf;
    private long zzag;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;
    private String zzs;
    private Boolean zzt;
    private long zzu;
    private List<String> zzv;
    private String zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    @WorkerThread
    zzf(zzgd zzgd, String str) {
        Preconditions.checkNotNull(zzgd);
        Preconditions.checkNotEmpty(str);
        this.zza = zzgd;
        this.zzb = str;
        zzgd.zzq().zzd();
    }

    @WorkerThread
    public final void zza(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzh != j;
        this.zzh = j;
    }

    @WorkerThread
    public final void zza(Boolean bool) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zza(this.zzt, bool);
        this.zzt = bool;
    }

    @WorkerThread
    public final void zza(String str) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zzc(this.zzc, str);
        this.zzc = str;
    }

    @WorkerThread
    public final void zza(@Nullable List<String> list) {
        this.zza.zzq().zzd();
        if (!zzkw.zza(this.zzv, list)) {
            this.zzae = true;
            this.zzv = list != null ? new ArrayList(list) : null;
        }
    }

    @WorkerThread
    public final void zza(boolean z) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzo != z;
        this.zzo = z;
    }

    @WorkerThread
    public final boolean zza() {
        this.zza.zzq().zzd();
        return this.zzae;
    }

    @WorkerThread
    public final long zzaa() {
        this.zza.zzq().zzd();
        return this.zzac;
    }

    @WorkerThread
    public final long zzab() {
        this.zza.zzq().zzd();
        return this.zzab;
    }

    @WorkerThread
    public final String zzac() {
        this.zza.zzq().zzd();
        return this.zzad;
    }

    @WorkerThread
    public final String zzad() {
        this.zza.zzq().zzd();
        String str = this.zzad;
        zzi((String) null);
        return str;
    }

    @WorkerThread
    public final long zzae() {
        this.zza.zzq().zzd();
        return this.zzp;
    }

    @WorkerThread
    public final boolean zzaf() {
        this.zza.zzq().zzd();
        return this.zzq;
    }

    @WorkerThread
    public final boolean zzag() {
        this.zza.zzq().zzd();
        return this.zzr;
    }

    @WorkerThread
    public final Boolean zzah() {
        this.zza.zzq().zzd();
        return this.zzt;
    }

    @WorkerThread
    @Nullable
    public final List<String> zzai() {
        this.zza.zzq().zzd();
        return this.zzv;
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzq().zzd();
        this.zzae = false;
    }

    @WorkerThread
    public final void zzb(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzi != j;
        this.zzi = j;
    }

    @WorkerThread
    public final void zzb(String str) {
        this.zza.zzq().zzd();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzae |= !zzkw.zzc(this.zzd, str);
        this.zzd = str;
    }

    @WorkerThread
    public final void zzb(boolean z) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzq != z;
        this.zzq = z;
    }

    @WorkerThread
    public final String zzc() {
        this.zza.zzq().zzd();
        return this.zzb;
    }

    @WorkerThread
    public final void zzc(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzk != j;
        this.zzk = j;
    }

    @WorkerThread
    public final void zzc(String str) {
        this.zza.zzq().zzd();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzae |= !zzkw.zzc(this.zzs, str);
        this.zzs = str;
    }

    @WorkerThread
    public final void zzc(boolean z) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzr != z;
        this.zzr = z;
    }

    @WorkerThread
    public final String zzd() {
        this.zza.zzq().zzd();
        return this.zzc;
    }

    @WorkerThread
    public final void zzd(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzm != j;
        this.zzm = j;
    }

    @WorkerThread
    public final void zzd(String str) {
        this.zza.zzq().zzd();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzae |= !zzkw.zzc(this.zzw, str);
        this.zzw = str;
    }

    @WorkerThread
    public final String zze() {
        this.zza.zzq().zzd();
        return this.zzd;
    }

    @WorkerThread
    public final void zze(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzn != j;
        this.zzn = j;
    }

    @WorkerThread
    public final void zze(String str) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zzc(this.zze, str);
        this.zze = str;
    }

    @WorkerThread
    public final String zzf() {
        this.zza.zzq().zzd();
        return this.zzs;
    }

    @WorkerThread
    public final void zzf(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzu != j;
        this.zzu = j;
    }

    @WorkerThread
    public final void zzf(String str) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zzc(this.zzf, str);
        this.zzf = str;
    }

    @WorkerThread
    public final String zzg() {
        this.zza.zzq().zzd();
        return this.zzw;
    }

    @WorkerThread
    public final void zzg(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzq().zzd();
        boolean z2 = this.zzae;
        if (this.zzg == j) {
            z = false;
        }
        this.zzae = z | z2;
        this.zzg = j;
    }

    @WorkerThread
    public final void zzg(String str) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zzc(this.zzj, str);
        this.zzj = str;
    }

    @WorkerThread
    public final String zzh() {
        this.zza.zzq().zzd();
        return this.zze;
    }

    @WorkerThread
    public final void zzh(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzaf != j;
        this.zzaf = j;
    }

    @WorkerThread
    public final void zzh(String str) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zzc(this.zzl, str);
        this.zzl = str;
    }

    @WorkerThread
    public final String zzi() {
        this.zza.zzq().zzd();
        return this.zzf;
    }

    @WorkerThread
    public final void zzi(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzag != j;
        this.zzag = j;
    }

    @WorkerThread
    public final void zzi(String str) {
        this.zza.zzq().zzd();
        this.zzae |= !zzkw.zzc(this.zzad, str);
        this.zzad = str;
    }

    @WorkerThread
    public final long zzj() {
        this.zza.zzq().zzd();
        return this.zzh;
    }

    @WorkerThread
    public final void zzj(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzx != j;
        this.zzx = j;
    }

    @WorkerThread
    public final long zzk() {
        this.zza.zzq().zzd();
        return this.zzi;
    }

    @WorkerThread
    public final void zzk(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzy != j;
        this.zzy = j;
    }

    @WorkerThread
    public final String zzl() {
        this.zza.zzq().zzd();
        return this.zzj;
    }

    @WorkerThread
    public final void zzl(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzz != j;
        this.zzz = j;
    }

    @WorkerThread
    public final long zzm() {
        this.zza.zzq().zzd();
        return this.zzk;
    }

    @WorkerThread
    public final void zzm(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzaa != j;
        this.zzaa = j;
    }

    @WorkerThread
    public final String zzn() {
        this.zza.zzq().zzd();
        return this.zzl;
    }

    @WorkerThread
    public final void zzn(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzac != j;
        this.zzac = j;
    }

    @WorkerThread
    public final long zzo() {
        this.zza.zzq().zzd();
        return this.zzm;
    }

    @WorkerThread
    public final void zzo(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzab != j;
        this.zzab = j;
    }

    @WorkerThread
    public final long zzp() {
        this.zza.zzq().zzd();
        return this.zzn;
    }

    @WorkerThread
    public final void zzp(long j) {
        this.zza.zzq().zzd();
        this.zzae |= this.zzp != j;
        this.zzp = j;
    }

    @WorkerThread
    public final long zzq() {
        this.zza.zzq().zzd();
        return this.zzu;
    }

    @WorkerThread
    public final boolean zzr() {
        this.zza.zzq().zzd();
        return this.zzo;
    }

    @WorkerThread
    public final long zzs() {
        this.zza.zzq().zzd();
        return this.zzg;
    }

    @WorkerThread
    public final long zzt() {
        this.zza.zzq().zzd();
        return this.zzaf;
    }

    @WorkerThread
    public final long zzu() {
        this.zza.zzq().zzd();
        return this.zzag;
    }

    @WorkerThread
    public final void zzv() {
        this.zza.zzq().zzd();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzr().zzi().zza("Bundle index overflow. appId", zzez.zza(this.zzb));
            j = 0;
        }
        this.zzae = true;
        this.zzg = j;
    }

    @WorkerThread
    public final long zzw() {
        this.zza.zzq().zzd();
        return this.zzx;
    }

    @WorkerThread
    public final long zzx() {
        this.zza.zzq().zzd();
        return this.zzy;
    }

    @WorkerThread
    public final long zzy() {
        this.zza.zzq().zzd();
        return this.zzz;
    }

    @WorkerThread
    public final long zzz() {
        this.zza.zzq().zzd();
        return this.zzaa;
    }
}
