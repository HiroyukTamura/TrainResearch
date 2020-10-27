package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class zzig extends zzih {
    private final AudioTimestamp zzakx = new AudioTimestamp();
    private long zzaky;
    private long zzakz;
    private long zzala;

    public zzig() {
        super((zzie) null);
    }

    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzaky = 0;
        this.zzakz = 0;
        this.zzala = 0;
    }

    public final boolean zzfx() {
        boolean timestamp = this.zzajg.getTimestamp(this.zzakx);
        if (timestamp) {
            long j = this.zzakx.framePosition;
            if (this.zzakz > j) {
                this.zzaky++;
            }
            this.zzakz = j;
            this.zzala = j + (this.zzaky << 32);
        }
        return timestamp;
    }

    public final long zzfy() {
        return this.zzakx.nanoTime;
    }

    public final long zzfz() {
        return this.zzala;
    }
}
