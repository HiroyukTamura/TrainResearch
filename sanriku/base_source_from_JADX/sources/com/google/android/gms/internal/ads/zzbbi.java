package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
public abstract class zzbbi extends TextureView implements zzbcb {
    protected final zzbbs zzebg = new zzbbs();
    protected final zzbcc zzebh;

    public zzbbi(Context context) {
        super(context);
        this.zzebh = new zzbcc(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbbf zzbbf);

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }

    public void zzde(int i) {
    }

    public void zzdf(int i) {
    }

    public void zzdg(int i) {
    }

    public void zzdh(int i) {
    }

    public void zzdi(int i) {
    }

    public abstract String zzyk();

    public abstract void zzyo();
}
