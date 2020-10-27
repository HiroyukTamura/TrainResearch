package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzq;

public final class zzcww implements zzdak<zzcwt> {
    private final zzdrh zzfur;
    private final Context zzvf;

    public zzcww(zzdrh zzdrh, Context context) {
        this.zzfur = zzdrh;
        this.zzvf = context;
    }

    public final zzdri<zzcwt> zzaqa() {
        return this.zzfur.zzd(new zzcwv(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcwt zzaqe() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzvf.getSystemService("audio");
        return new zzcwt(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzq.zzlb().zzqb(), zzq.zzlb().zzqc());
    }
}
