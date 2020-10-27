package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

class zzih {
    private int zzagt;
    protected AudioTrack zzajg;
    private boolean zzalb;
    private long zzalc;
    private long zzald;
    private long zzale;
    private long zzalf;
    private long zzalg;
    private long zzalh;

    private zzih() {
    }

    /* synthetic */ zzih(zzie zzie) {
        this();
    }

    public final void pause() {
        if (this.zzalf == -9223372036854775807L) {
            this.zzajg.pause();
        }
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzajg = audioTrack;
        this.zzalb = z;
        this.zzalf = -9223372036854775807L;
        this.zzalc = 0;
        this.zzald = 0;
        this.zzale = 0;
        if (audioTrack != null) {
            this.zzagt = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzalg = zzga();
        this.zzalf = SystemClock.elapsedRealtime() * 1000;
        this.zzalh = j;
        this.zzajg.stop();
    }

    public boolean zzfx() {
        return false;
    }

    public long zzfy() {
        throw new UnsupportedOperationException();
    }

    public long zzfz() {
        throw new UnsupportedOperationException();
    }

    public final long zzga() {
        if (this.zzalf != -9223372036854775807L) {
            return Math.min(this.zzalh, this.zzalg + ((((SystemClock.elapsedRealtime() * 1000) - this.zzalf) * ((long) this.zzagt)) / 1000000));
        }
        int playState = this.zzajg.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.zzajg.getPlaybackHeadPosition());
        if (this.zzalb) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzale = this.zzalc;
            }
            playbackHeadPosition += this.zzale;
        }
        if (this.zzalc > playbackHeadPosition) {
            this.zzald++;
        }
        this.zzalc = playbackHeadPosition;
        return playbackHeadPosition + (this.zzald << 32);
    }

    public final long zzgb() {
        return (zzga() * 1000000) / ((long) this.zzagt);
    }
}
