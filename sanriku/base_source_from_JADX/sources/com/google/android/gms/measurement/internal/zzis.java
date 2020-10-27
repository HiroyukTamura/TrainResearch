package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzis extends zzg {
    /* access modifiers changed from: private */
    public final zzjn zza;
    /* access modifiers changed from: private */
    public zzer zzb;
    private volatile Boolean zzc;
    private final zzag zzd;
    private final zzkh zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzag zzg;

    protected zzis(zzgd zzgd) {
        super(zzgd);
        this.zze = new zzkh(zzgd.zzm());
        this.zza = new zzjn(this);
        this.zzd = new zziv(this, zzgd);
        this.zzg = new zzjf(this, zzgd);
    }

    @WorkerThread
    @Nullable
    private final zzn zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    @WorkerThread
    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzr().zzf().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzaf();
        }
    }

    private final boolean zzaj() {
        zzu();
        return true;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzak() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzaq.zzai.zza(null).longValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f1  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzal() {
        /*
            r5 = this;
            r5.zzd()
            r5.zzw()
            java.lang.Boolean r0 = r5.zzc
            if (r0 != 0) goto L_0x00fe
            r5.zzd()
            r5.zzw()
            com.google.android.gms.measurement.internal.zzfl r0 = r5.zzs()
            java.lang.Boolean r0 = r0.zzj()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00f8
        L_0x0023:
            r5.zzu()
            com.google.android.gms.measurement.internal.zzes r2 = r5.zzg()
            int r2 = r2.zzag()
            r3 = 0
            if (r2 != r1) goto L_0x0034
        L_0x0031:
            r0 = 1
            goto L_0x00d4
        L_0x0034:
            com.google.android.gms.measurement.internal.zzez r2 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzx()
            java.lang.String r4 = "Checking service availability"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkw r2 = r5.zzp()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.zza((int) r4)
            if (r2 == 0) goto L_0x00c5
            if (r2 == r1) goto L_0x00b5
            r4 = 2
            if (r2 == r4) goto L_0x0095
            r0 = 3
            if (r2 == r0) goto L_0x0086
            r0 = 9
            if (r2 == r0) goto L_0x007b
            r0 = 18
            if (r2 == r0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.zza(r2, r1)
            goto L_0x0093
        L_0x0070:
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.String r2 = "Service updating"
            goto L_0x00cf
        L_0x007b:
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.String r1 = "Service invalid"
            goto L_0x0090
        L_0x0086:
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.String r1 = "Service disabled"
        L_0x0090:
            r0.zza(r1)
        L_0x0093:
            r0 = 0
            goto L_0x00c3
        L_0x0095:
            com.google.android.gms.measurement.internal.zzez r2 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzw()
            java.lang.String r4 = "Service container out of date"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkw r2 = r5.zzp()
            int r2 = r2.zzj()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x00af
            goto L_0x00c2
        L_0x00af:
            if (r0 != 0) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r1 = 0
        L_0x00b3:
            r0 = 0
            goto L_0x00d4
        L_0x00b5:
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()
            java.lang.String r2 = "Service missing"
            r0.zza(r2)
        L_0x00c2:
            r0 = 1
        L_0x00c3:
            r1 = 0
            goto L_0x00d4
        L_0x00c5:
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()
            java.lang.String r2 = "Service available"
        L_0x00cf:
            r0.zza(r2)
            goto L_0x0031
        L_0x00d4:
            if (r1 != 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzy r2 = r5.zzt()
            boolean r2 = r2.zzy()
            if (r2 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzez r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r2)
            goto L_0x00ef
        L_0x00ee:
            r3 = r0
        L_0x00ef:
            if (r3 == 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzfl r0 = r5.zzs()
            r0.zza((boolean) r1)
        L_0x00f8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.zzc = r0
        L_0x00fe:
            java.lang.Boolean r0 = r5.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzis.zzal():boolean");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzam() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzan() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        zzd();
        zzw();
        zza((Runnable) new zzjd(this, bundle, zza(false)));
    }

    @WorkerThread
    public final void zza(zzw zzw) {
        zzd();
        zzw();
        zza((Runnable) new zziy(this, zza(false), zzw));
    }

    @WorkerThread
    public final void zza(zzw zzw, zzao zzao, String str) {
        zzd();
        zzw();
        if (zzp().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzw, new byte[0]);
            return;
        }
        zza((Runnable) new zzjc(this, zzao, str, zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzw zzw, String str, String str2) {
        zzd();
        zzw();
        zza((Runnable) new zzji(this, str, str2, zza(false), zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzw zzw, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzjk(this, str, str2, z, zza(false), zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzao zzao, String str) {
        Preconditions.checkNotNull(zzao);
        zzd();
        zzw();
        boolean zzaj = zzaj();
        zza((Runnable) new zzjh(this, zzaj, zzaj && zzj().zza(zzao), zzao, zza(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzer zzer) {
        zzd();
        Preconditions.checkNotNull(zzer);
        this.zzb = zzer;
        zzak();
        zzan();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzer zzer, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        zzfb zzf2;
        String str;
        List<AbstractSafeParcelable> zza2;
        zzd();
        zzb();
        zzw();
        boolean zzaj = zzaj();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzaj || (zza2 = zzj().zza(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zza2);
                i = zza2.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzao) {
                    try {
                        zzer.zza((zzao) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        e = e;
                        zzf2 = zzr().zzf();
                        str = "Failed to send event to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzkr) {
                    try {
                        zzer.zza((zzkr) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        e = e2;
                        zzf2 = zzr().zzf();
                        str = "Failed to send user property to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzw) {
                    try {
                        zzer.zza((zzw) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        e = e3;
                        zzf2 = zzr().zzf();
                        str = "Failed to send conditional user property to the service";
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
        return;
        zzf2.zza(str, e);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzik zzik) {
        zzd();
        zzw();
        zza((Runnable) new zzja(this, zzik));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzkr zzkr) {
        zzd();
        zzw();
        zza((Runnable) new zziu(this, zzaj() && zzj().zza(zzkr), zzkr, zza(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        zzd();
        zzw();
        zzu();
        zza((Runnable) new zzjg(this, true, zzj().zza(zzw), new zzw(zzw), zza(true), zzw));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza((Runnable) new zziz(this, atomicReference, zza(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzw>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza((Runnable) new zzjj(this, atomicReference, str, str2, str3, zza(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzkr>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzjl(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzkr>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzix(this, atomicReference, zza(false), z));
    }

    @WorkerThread
    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzac() {
        zzd();
        zzw();
        zza((Runnable) new zzje(this, zza(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzad() {
        zzd();
        zzb();
        zzw();
        zzn zza2 = zza(false);
        if (zzaj()) {
            zzj().zzab();
        }
        zza((Runnable) new zziw(this, zza2));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzae() {
        zzd();
        zzw();
        zzn zza2 = zza(true);
        zzj().zzac();
        zza((Runnable) new zzjb(this, zza2));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzaf() {
        zzd();
        zzw();
        if (!zzab()) {
            if (zzal()) {
                this.zza.zzb();
            } else if (!zzt().zzy()) {
                zzu();
                List<ResolveInfo> queryIntentServices = zzn().getPackageManager().queryIntentServices(new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context zzn = zzn();
                    zzu();
                    intent.setComponent(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzag() {
        return this.zzc;
    }

    @WorkerThread
    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzai() {
        zzd();
        zzw();
        return !zzal() || zzp().zzj() >= 200900;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
