package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzdhg {
    /* access modifiers changed from: private */
    public boolean zzbli;
    /* access modifiers changed from: private */
    public zzum zzbmp;
    /* access modifiers changed from: private */
    public zzaci zzdhc;
    /* access modifiers changed from: private */
    public zzahm zzdno;
    /* access modifiers changed from: private */
    public int zzgkg = 1;
    /* access modifiers changed from: private */
    public boolean zzglu = false;
    /* access modifiers changed from: private */
    public zzwn zzguu;
    /* access modifiers changed from: private */
    public zzze zzguv;
    /* access modifiers changed from: private */
    public zzuj zzguw;
    /* access modifiers changed from: private */
    public String zzgux;
    /* access modifiers changed from: private */
    public ArrayList<String> zzguy;
    /* access modifiers changed from: private */
    public ArrayList<String> zzguz;
    /* access modifiers changed from: private */
    public zzut zzgva;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzgvb;
    /* access modifiers changed from: private */
    @Nullable
    public zzwh zzgvc;
    /* access modifiers changed from: private */
    public zzdgt zzgve = new zzdgt();

    public final zzuj zzarz() {
        return this.zzguw;
    }

    public final String zzasa() {
        return this.zzgux;
    }

    public final zzdgt zzasb() {
        return this.zzgve;
    }

    public final zzdhe zzasc() {
        Preconditions.checkNotNull(this.zzgux, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbmp, "ad size must not be null");
        Preconditions.checkNotNull(this.zzguw, "ad request must not be null");
        return new zzdhe(this);
    }

    public final zzdhg zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgvb = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbli = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzgvc = publisherAdViewOptions.zzjt();
        }
        return this;
    }

    public final zzdhg zzb(zzaci zzaci) {
        this.zzdhc = zzaci;
        return this;
    }

    public final zzdhg zzb(zzahm zzahm) {
        this.zzdno = zzahm;
        this.zzguv = new zzze(false, true, false);
        return this;
    }

    public final zzdhg zzb(zzut zzut) {
        this.zzgva = zzut;
        return this;
    }

    public final zzdhg zzbo(boolean z) {
        this.zzglu = z;
        return this;
    }

    public final zzdhg zzbp(boolean z) {
        this.zzbli = z;
        return this;
    }

    public final zzdhg zzc(zzdhe zzdhe) {
        this.zzgve.zza(zzdhe.zzgvd);
        this.zzguw = zzdhe.zzguw;
        this.zzbmp = zzdhe.zzbmp;
        this.zzguu = zzdhe.zzguu;
        this.zzgux = zzdhe.zzgux;
        this.zzguv = zzdhe.zzguv;
        this.zzguy = zzdhe.zzguy;
        this.zzguz = zzdhe.zzguz;
        this.zzdhc = zzdhe.zzdhc;
        this.zzgva = zzdhe.zzgva;
        zzdhg zzb = zzb(zzdhe.zzgvb);
        zzb.zzglu = zzdhe.zzglu;
        return zzb;
    }

    public final zzdhg zzc(zzwn zzwn) {
        this.zzguu = zzwn;
        return this;
    }

    public final zzdhg zzc(zzze zzze) {
        this.zzguv = zzze;
        return this;
    }

    public final zzdhg zzc(ArrayList<String> arrayList) {
        this.zzguy = arrayList;
        return this;
    }

    public final zzdhg zzd(zzum zzum) {
        this.zzbmp = zzum;
        return this;
    }

    public final zzdhg zzd(ArrayList<String> arrayList) {
        this.zzguz = arrayList;
        return this;
    }

    public final zzdhg zzdv(int i) {
        this.zzgkg = i;
        return this;
    }

    public final zzdhg zzgr(String str) {
        this.zzgux = str;
        return this;
    }

    public final zzdhg zzh(zzuj zzuj) {
        this.zzguw = zzuj;
        return this;
    }

    public final zzum zzkg() {
        return this.zzbmp;
    }
}
