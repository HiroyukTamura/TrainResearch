package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

public final class zzdhe {
    public final zzum zzbmp;
    public final zzaci zzdhc;
    @Nullable
    public final zzahm zzdno;
    public final int zzgkg;
    public final boolean zzglu;
    @Nullable
    public final zzwn zzguu;
    @Nullable
    public final zzze zzguv;
    public final zzuj zzguw;
    public final String zzgux;
    public final ArrayList<String> zzguy;
    public final ArrayList<String> zzguz;
    public final zzut zzgva;
    public final PublisherAdViewOptions zzgvb;
    public final zzwh zzgvc;
    public final zzdgr zzgvd;

    private zzdhe(zzdhg zzdhg) {
        this.zzbmp = zzdhg.zzbmp;
        this.zzgux = zzdhg.zzgux;
        this.zzguu = zzdhg.zzguu;
        this.zzguw = new zzuj(zzdhg.zzguw.versionCode, zzdhg.zzguw.zzceg, zzdhg.zzguw.extras, zzdhg.zzguw.zzceh, zzdhg.zzguw.zzcei, zzdhg.zzguw.zzcej, zzdhg.zzguw.zzacq, zzdhg.zzguw.zzbli || zzdhg.zzbli, zzdhg.zzguw.zzcek, zzdhg.zzguw.zzcel, zzdhg.zzguw.zzmp, zzdhg.zzguw.zzcem, zzdhg.zzguw.zzcen, zzdhg.zzguw.zzceo, zzdhg.zzguw.zzcep, zzdhg.zzguw.zzceq, zzdhg.zzguw.zzcer, zzdhg.zzguw.zzces, zzdhg.zzguw.zzceu, zzdhg.zzguw.zzacr, zzdhg.zzguw.zzacs, zzdhg.zzguw.zzcet);
        this.zzguv = zzdhg.zzguv != null ? zzdhg.zzguv : zzdhg.zzdhc != null ? zzdhg.zzdhc.zzcyu : null;
        this.zzguy = zzdhg.zzguy;
        this.zzguz = zzdhg.zzguz;
        this.zzdhc = zzdhg.zzguy == null ? null : zzdhg.zzdhc == null ? new zzaci(new NativeAdOptions.Builder().build()) : zzdhg.zzdhc;
        this.zzgva = zzdhg.zzgva;
        this.zzgkg = zzdhg.zzgkg;
        this.zzgvb = zzdhg.zzgvb;
        this.zzgvc = zzdhg.zzgvc;
        this.zzdno = zzdhg.zzdno;
        this.zzgvd = new zzdgr(zzdhg.zzgve);
        this.zzglu = zzdhg.zzglu;
    }

    public final zzaem zzarx() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzgvb;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzju();
    }
}
