package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzc;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcfa {
    private final zzaun zzblv;
    private final zzdt zzejl;
    private final Executor zzfhi;
    /* access modifiers changed from: private */
    public final zzbrx zzflh;
    private final zzbsu zzfpb;
    private final zzbqw zzfqd;
    private final zzbkp zzfqe;
    private final zzbvs zzfqg;
    private final zzbsl zzfwn;
    private final zzbtw zzfwo;
    private final zzc zzfxc;
    private final zzbrr zzfxd;
    /* access modifiers changed from: private */
    public final zzbtl zzfxe;

    public zzcfa(zzbqw zzbqw, zzbrx zzbrx, zzbsl zzbsl, zzbsu zzbsu, zzbtw zzbtw, Executor executor, zzbvs zzbvs, zzbkp zzbkp, zzc zzc, zzbrr zzbrr, @Nullable zzaun zzaun, zzdt zzdt, zzbtl zzbtl) {
        this.zzfqd = zzbqw;
        this.zzflh = zzbrx;
        this.zzfwn = zzbsl;
        this.zzfpb = zzbsu;
        this.zzfwo = zzbtw;
        this.zzfhi = executor;
        this.zzfqg = zzbvs;
        this.zzfqe = zzbkp;
        this.zzfxc = zzc;
        this.zzfxd = zzbrr;
        this.zzblv = zzaun;
        this.zzejl = zzdt;
        this.zzfxe = zzbtl;
    }

    public static zzdri<?> zza(zzbek zzbek, String str, String str2) {
        zzbaj zzbaj = new zzbaj();
        zzbek.zzabj().zza((zzbfv) new zzcfl(zzbaj));
        zzbek.zzb(str, str2, (String) null);
        return zzbaj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbek zzbek, zzbek zzbek2, Map map) {
        this.zzfqe.zzf(zzbek);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzfxc.recordClick();
        zzaun zzaun = this.zzblv;
        if (zzaun == null) {
            return false;
        }
        zzaun.zzvh();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzad(View view) {
        this.zzfxc.recordClick();
        zzaun zzaun = this.zzblv;
        if (zzaun != null) {
            zzaun.zzvh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzamw() {
        this.zzflh.onAdLeftApplication();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzamx() {
        this.zzfqd.onAdClicked();
    }

    public final void zzb(zzbek zzbek, boolean z) {
        zzdj zzcb;
        zzbek.zzabj().zza(new zzcfd(this), this.zzfwn, this.zzfpb, new zzcfc(this), new zzcff(this), z, (zzagd) null, this.zzfxc, new zzcfk(this), this.zzblv);
        zzbek.setOnTouchListener(new zzcfe(this));
        zzbek.setOnClickListener(new zzcfh(this));
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnt)).booleanValue() && (zzcb = this.zzejl.zzcb()) != null) {
            zzcb.zzb(zzbek.getView());
        }
        this.zzfqg.zza(zzbek, this.zzfhi);
        this.zzfqg.zza(new zzcfg(zzbek), this.zzfhi);
        this.zzfqg.zzu(zzbek.getView());
        zzbek.zza("/trackActiveViewUnit", (zzaga<? super zzbek>) new zzcfj(this, zzbek));
        this.zzfqe.zzo(zzbek);
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcli)).booleanValue()) {
            zzbrr zzbrr = this.zzfxd;
            zzbek.getClass();
            zzbrr.zza(zzcfi.zzn(zzbek), this.zzfhi);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str, String str2) {
        this.zzfwo.onAppEvent(str, str2);
    }
}
