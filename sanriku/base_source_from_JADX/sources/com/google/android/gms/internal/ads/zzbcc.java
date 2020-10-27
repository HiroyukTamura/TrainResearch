package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@TargetApi(14)
public final class zzbcc implements AudioManager.OnAudioFocusChangeListener {
    private float zzcy = 1.0f;
    private boolean zzebp;
    private final AudioManager zzeeo;
    private final zzbcb zzeep;
    private boolean zzeeq;
    private boolean zzeer;

    public zzbcc(Context context, zzbcb zzbcb) {
        this.zzeeo = (AudioManager) context.getSystemService("audio");
        this.zzeep = zzbcb;
    }

    private final void zzzr() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = this.zzebp && !this.zzeer && this.zzcy > 0.0f;
        if (z4 && !(z2 = this.zzeeq)) {
            AudioManager audioManager = this.zzeeo;
            if (audioManager != null && !z2) {
                if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                    z3 = true;
                }
                this.zzeeq = z3;
            }
            this.zzeep.zzyo();
        } else if (!z4 && (z = this.zzeeq)) {
            AudioManager audioManager2 = this.zzeeo;
            if (audioManager2 != null && z) {
                if (audioManager2.abandonAudioFocus(this) == 0) {
                    z3 = true;
                }
                this.zzeeq = z3;
            }
            this.zzeep.zzyo();
        }
    }

    public final float getVolume() {
        float f = this.zzeer ? 0.0f : this.zzcy;
        if (this.zzeeq) {
            return f;
        }
        return 0.0f;
    }

    public final void onAudioFocusChange(int i) {
        this.zzeeq = i > 0;
        this.zzeep.zzyo();
    }

    public final void setMuted(boolean z) {
        this.zzeer = z;
        zzzr();
    }

    public final void setVolume(float f) {
        this.zzcy = f;
        zzzr();
    }

    public final void zzzp() {
        this.zzebp = true;
        zzzr();
    }

    public final void zzzq() {
        this.zzebp = false;
        zzzr();
    }
}
