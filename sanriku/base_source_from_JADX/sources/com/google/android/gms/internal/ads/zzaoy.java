package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

public final class zzaoy extends zzapb implements zzaga<zzbek> {
    private float density;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int rotation;
    private final WindowManager zzboo;
    private final zzbek zzdce;
    private final zzzg zzdjh;
    private int zzdji = -1;
    private int zzdjj = -1;
    private int zzdjk = -1;
    private int zzdjl = -1;
    private final Context zzvf;
    private DisplayMetrics zzwz;

    public zzaoy(zzbek zzbek, Context context, zzzg zzzg) {
        super(zzbek);
        this.zzdce = zzbek;
        this.zzvf = context;
        this.zzdjh = zzzg;
        this.zzboo = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        zzbek zzbek = (zzbek) obj;
        this.zzwz = new DisplayMetrics();
        Display defaultDisplay = this.zzboo.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzwz);
        this.density = this.zzwz.density;
        this.rotation = defaultDisplay.getRotation();
        zzvj.zzpr();
        DisplayMetrics displayMetrics = this.zzwz;
        this.zzdji = zzazm.zzb(displayMetrics, displayMetrics.widthPixels);
        zzvj.zzpr();
        DisplayMetrics displayMetrics2 = this.zzwz;
        this.zzdjj = zzazm.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzzh = this.zzdce.zzzh();
        if (zzzh == null || zzzh.getWindow() == null) {
            this.maxWidth = this.zzdji;
            i = this.zzdjj;
        } else {
            zzq.zzkw();
            int[] zzd = zzaxa.zzd(zzzh);
            zzvj.zzpr();
            this.maxWidth = zzazm.zzb(this.zzwz, zzd[0]);
            zzvj.zzpr();
            i = zzazm.zzb(this.zzwz, zzd[1]);
        }
        this.maxHeight = i;
        if (this.zzdce.zzabh().zzaco()) {
            this.zzdjk = this.zzdji;
            this.zzdjl = this.zzdjj;
        } else {
            this.zzdce.measure(0, 0);
        }
        zza(this.zzdji, this.zzdjj, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzdce.zzb("onDeviceFeaturesReceived", new zzaox(new zzaoz().zzae(this.zzdjh.zzqv()).zzad(this.zzdjh.zzqw()).zzaf(this.zzdjh.zzqy()).zzag(this.zzdjh.zzqx()).zzah(true)).zzuc());
        int[] iArr = new int[2];
        this.zzdce.getLocationOnScreen(iArr);
        zzj(zzvj.zzpr().zzb(this.zzvf, iArr[0]), zzvj.zzpr().zzb(this.zzvf, iArr[1]));
        if (zzazw.isLoggable(2)) {
            zzazw.zzfb("Dispatching Ready Event.");
        }
        zzdw(this.zzdce.zzzk().zzbnd);
    }

    public final void zzj(int i, int i2) {
        int i3 = 0;
        if (this.zzvf instanceof Activity) {
            i3 = zzq.zzkw().zzf((Activity) this.zzvf)[0];
        }
        if (this.zzdce.zzabh() == null || !this.zzdce.zzabh().zzaco()) {
            int width = this.zzdce.getWidth();
            int height = this.zzdce.getHeight();
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzckd)).booleanValue()) {
                if (width == 0 && this.zzdce.zzabh() != null) {
                    width = this.zzdce.zzabh().widthPixels;
                }
                if (height == 0 && this.zzdce.zzabh() != null) {
                    height = this.zzdce.zzabh().heightPixels;
                }
            }
            this.zzdjk = zzvj.zzpr().zzb(this.zzvf, width);
            this.zzdjl = zzvj.zzpr().zzb(this.zzvf, height);
        }
        zzc(i, i2 - i3, this.zzdjk, this.zzdjl);
        this.zzdce.zzabj().zzi(i, i2);
    }
}
