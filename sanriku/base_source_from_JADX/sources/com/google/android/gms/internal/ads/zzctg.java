package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzctg extends zzvv {
    private zzvm zzbmt;
    private final zzbgy zzggh;
    private final Context zzgiz;
    @VisibleForTesting
    private final zzdhg zzgja = new zzdhg();
    @VisibleForTesting
    private final zzcag zzgjb = new zzcag();

    public zzctg(zzbgy zzbgy, Context context, String str) {
        this.zzggh = zzbgy;
        this.zzgja.zzgr(str);
        this.zzgiz = context;
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgja.zzb(publisherAdViewOptions);
    }

    public final void zza(zzaci zzaci) {
        this.zzgja.zzb(zzaci);
    }

    public final void zza(zzads zzads) {
        this.zzgjb.zzb(zzads);
    }

    public final void zza(zzadx zzadx) {
        this.zzgjb.zzb(zzadx);
    }

    public final void zza(zzaeg zzaeg, zzum zzum) {
        this.zzgjb.zza(zzaeg);
        this.zzgja.zzd(zzum);
    }

    public final void zza(zzael zzael) {
        this.zzgjb.zzb(zzael);
    }

    public final void zza(zzahm zzahm) {
        this.zzgja.zzb(zzahm);
    }

    public final void zza(zzahu zzahu) {
        this.zzgjb.zzb(zzahu);
    }

    public final void zza(String str, zzaed zzaed, zzady zzady) {
        this.zzgjb.zzb(str, zzaed, zzady);
    }

    public final void zzb(zzvm zzvm) {
        this.zzbmt = zzvm;
    }

    public final void zzb(zzwn zzwn) {
        this.zzgja.zzc(zzwn);
    }

    public final zzvr zzqa() {
        zzcae zzals = this.zzgjb.zzals();
        this.zzgja.zzc(zzals.zzalq());
        this.zzgja.zzd(zzals.zzalr());
        zzdhg zzdhg = this.zzgja;
        if (zzdhg.zzkg() == null) {
            zzdhg.zzd(zzum.zzph());
        }
        return new zzctj(this.zzgiz, this.zzggh, this.zzgja, zzals, this.zzbmt);
    }
}
