package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
final class zzlk implements zzli {
    private final int zzbao;
    private MediaCodecInfo[] zzbap;

    public zzlk(boolean z) {
        this.zzbao = z ? 1 : 0;
    }

    private final void zzhl() {
        if (this.zzbap == null) {
            this.zzbap = new MediaCodecList(this.zzbao).getCodecInfos();
        }
    }

    public final int getCodecCount() {
        zzhl();
        return this.zzbap.length;
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzhl();
        return this.zzbap[i];
    }

    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public final boolean zzhk() {
        return true;
    }
}
