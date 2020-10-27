package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

public final class zzix {

    /* renamed from: iv */
    public byte[] f359iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzana;
    private int zzanb;
    private final MediaCodec.CryptoInfo zzanc;
    private final zziz zzand;

    public zzix() {
        zziz zziz = null;
        MediaCodec.CryptoInfo cryptoInfo = zzov.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzanc = cryptoInfo;
        this.zzand = zzov.SDK_INT >= 24 ? new zziz(cryptoInfo) : zziz;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f359iv = bArr2;
        this.mode = i2;
        this.zzana = 0;
        this.zzanb = 0;
        int i3 = zzov.SDK_INT;
        if (i3 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzanc;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i2;
            if (i3 >= 24) {
                this.zzand.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzgl() {
        return this.zzanc;
    }
}
