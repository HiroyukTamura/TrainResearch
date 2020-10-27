package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzawd {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzazz zzbmo;
    private final zzawo zzdtl = new zzawo(zzvj.zzpw(), this.zzdtu);
    private zzpw zzdtt;
    private final zzaww zzdtu = new zzaww();
    /* access modifiers changed from: private */
    @Nullable
    public zzaac zzdtv = null;
    @Nullable
    private Boolean zzdtw = null;
    private final AtomicInteger zzdtx = new AtomicInteger(0);
    private final zzawi zzdty = new zzawi((zzawf) null);
    private final Object zzdtz = new Object();
    @GuardedBy("grantedPermissionLock")
    private zzdri<ArrayList<String>> zzdua;
    /* access modifiers changed from: private */
    public Context zzvf;
    private boolean zzyw = false;

    @TargetApi(16)
    private static ArrayList<String> zzal(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.zzvf;
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzbmo.zzdzp) {
            return this.zzvf.getResources();
        }
        try {
            zzazv.zzbr(this.zzvf).getResources();
            return null;
        } catch (zzazx e) {
            zzazw.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdtw = bool;
        }
    }

    public final void zza(Throwable th, String str) {
        zzaqm.zzc(this.zzvf, this.zzbmo).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzaqm.zzc(this.zzvf, this.zzbmo).zza(th, str, zzabt.zzcxt.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzazz zzazz) {
        synchronized (this.lock) {
            if (!this.zzyw) {
                this.zzvf = context.getApplicationContext();
                this.zzbmo = zzazz;
                zzq.zzkz().zza(this.zzdtl);
                zzaac zzaac = null;
                this.zzdtu.zza(this.zzvf, (String) null, true);
                zzaqm.zzc(this.zzvf, this.zzbmo);
                this.zzdtt = new zzpw(context.getApplicationContext(), this.zzbmo);
                zzq.zzlf();
                if (!zzabg.zzcwa.get().booleanValue()) {
                    zzawr.zzeg("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzaac = new zzaac();
                }
                this.zzdtv = zzaac;
                if (zzaac != null) {
                    zzbaf.zza(new zzawf(this).zzwn(), "AppState.registerCsiReporter");
                }
                this.zzyw = true;
                zzwc();
            }
        }
        zzq.zzkw().zzr(context, zzazz.zzbnd);
    }

    @Nullable
    public final zzaac zzvv() {
        zzaac zzaac;
        synchronized (this.lock) {
            zzaac = this.zzdtv;
        }
        return zzaac;
    }

    public final Boolean zzvw() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdtw;
        }
        return bool;
    }

    public final void zzvx() {
        this.zzdty.zzvx();
    }

    public final void zzvy() {
        this.zzdtx.incrementAndGet();
    }

    public final void zzvz() {
        this.zzdtx.decrementAndGet();
    }

    public final int zzwa() {
        return this.zzdtx.get();
    }

    public final zzawt zzwb() {
        zzaww zzaww;
        synchronized (this.lock) {
            zzaww = this.zzdtu;
        }
        return zzaww;
    }

    public final zzdri<ArrayList<String>> zzwc() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzvf != null) {
            if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcnw)).booleanValue()) {
                synchronized (this.zzdtz) {
                    if (this.zzdua != null) {
                        zzdri<ArrayList<String>> zzdri = this.zzdua;
                        return zzdri;
                    }
                    zzdri<ArrayList<String>> zzd = zzbab.zzdzr.zzd(new zzawg(this));
                    this.zzdua = zzd;
                    return zzd;
                }
            }
        }
        return zzdqw.zzag(new ArrayList());
    }

    public final zzawo zzwd() {
        return this.zzdtl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzwe() throws Exception {
        return zzal(zzase.zzaa(this.zzvf));
    }
}
