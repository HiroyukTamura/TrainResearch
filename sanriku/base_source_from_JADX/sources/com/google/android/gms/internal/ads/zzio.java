package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzio extends zzlb implements zzol {
    private int zzags;
    private int zzagu;
    /* access modifiers changed from: private */
    public final zzhw zzalq;
    private final zzif zzalr;
    private boolean zzals;
    private boolean zzalt;
    private MediaFormat zzalu;
    private long zzalv;
    /* access modifiers changed from: private */
    public boolean zzalw;

    public zzio(zzld zzld) {
        this(zzld, (zzjf<zzjh>) null, true);
    }

    private zzio(zzld zzld, zzjf<zzjh> zzjf, boolean z) {
        this(zzld, (zzjf<zzjh>) null, true, (zzdns) null, (zzhx) null);
    }

    private zzio(zzld zzld, zzjf<zzjh> zzjf, boolean z, zzdns zzdns, zzhx zzhx) {
        this(zzld, (zzjf<zzjh>) null, true, (zzdns) null, (zzhx) null, (zzhs) null, new zzhv[0]);
    }

    private zzio(zzld zzld, zzjf<zzjh> zzjf, boolean z, zzdns zzdns, zzhx zzhx, zzhs zzhs, zzhv... zzhvArr) {
        super(1, zzld, zzjf, z);
        this.zzalr = new zzif((zzhs) null, zzhvArr, new zziq(this));
        this.zzalq = new zzhw((zzdns) null, (zzhx) null);
    }

    private final boolean zzay(String str) {
        return this.zzalr.zzaw(str);
    }

    protected static void zzb(int i, long j, long j2) {
    }

    protected static void zzgc() {
    }

    protected static void zzu(int i) {
    }

    public final boolean isReady() {
        return this.zzalr.zzfq() || super.isReady();
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzgq {
        int[] iArr;
        int i;
        boolean z = this.zzalu != null;
        String string = z ? this.zzalu.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzalu;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzalt || integer != 6 || (i = this.zzags) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzags; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.zzalr.zza(string, integer, integer2, this.zzagu, 0, iArr);
        } catch (zzij e) {
            throw zzgq.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzalr.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzalr.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzld zzld, zzhf zzhf) throws zzlj {
        int i;
        int i2;
        String str = zzhf.zzagi;
        boolean z = false;
        if (!zzoo.zzbd(str)) {
            return 0;
        }
        int i3 = zzov.SDK_INT >= 21 ? 16 : 0;
        int i4 = 3;
        if (zzay(str) && zzld.zzhi() != null) {
            return i3 | 4 | 3;
        }
        zzlc zzb = zzld.zzb(str, false);
        if (zzb == null) {
            return 1;
        }
        if (zzov.SDK_INT < 21 || (((i = zzhf.zzagt) == -1 || zzb.zzas(i)) && ((i2 = zzhf.zzags) == -1 || zzb.zzat(i2)))) {
            z = true;
        }
        if (!z) {
            i4 = 2;
        }
        return i3 | 4 | i4;
    }

    /* access modifiers changed from: protected */
    public final zzlc zza(zzld zzld, zzhf zzhf, boolean z) throws zzlj {
        zzlc zzhi;
        if (!zzay(zzhf.zzagi) || (zzhi = zzld.zzhi()) == null) {
            this.zzals = false;
            return super.zza(zzld, zzhf, z);
        }
        this.zzals = true;
        return zzhi;
    }

    public final void zza(int i, Object obj) throws zzgq {
        if (i == 2) {
            this.zzalr.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzalr.setStreamType(((Integer) obj).intValue());
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzgq {
        super.zza(j, z);
        this.zzalr.reset();
        this.zzalv = j;
        this.zzalw = true;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzlc zzlc, MediaCodec mediaCodec, zzhf zzhf, MediaCrypto mediaCrypto) {
        this.zzalt = zzov.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzlc.name) && "samsung".equals(zzov.MANUFACTURER) && (zzov.DEVICE.startsWith("zeroflte") || zzov.DEVICE.startsWith("herolte") || zzov.DEVICE.startsWith("heroqlte"));
        if (this.zzals) {
            MediaFormat zzez = zzhf.zzez();
            this.zzalu = zzez;
            zzez.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzalu, (Surface) null, (MediaCrypto) null, 0);
            this.zzalu.setString("mime", zzhf.zzagi);
            return;
        }
        mediaCodec.configure(zzhf.zzez(), (Surface) null, (MediaCrypto) null, 0);
        this.zzalu = null;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzgq {
        if (this.zzals && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzazz.zzani++;
            this.zzalr.zzfn();
            return true;
        } else {
            try {
                if (!this.zzalr.zza(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzazz.zzanh++;
                return true;
            } catch (zzii | zzin e) {
                throw zzgq.zza(e, getIndex());
            }
        }
    }

    public final zzhl zzb(zzhl zzhl) {
        return this.zzalr.zzb(zzhl);
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzalq.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhf zzhf) throws zzgq {
        super.zzd(zzhf);
        this.zzalq.zzb(zzhf);
        this.zzagu = "audio/raw".equals(zzhf.zzagi) ? zzhf.zzagu : 2;
        this.zzags = zzhf.zzags;
    }

    public final zzol zzdz() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) throws zzgq {
        super.zze(z);
        this.zzalq.zza(this.zzazz);
        int i = zzeh().zzahj;
        if (i != 0) {
            this.zzalr.zzv(i);
        } else {
            this.zzalr.zzfs();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzeg() {
        try {
            this.zzalr.release();
            try {
                super.zzeg();
            } finally {
                this.zzazz.zzgm();
                this.zzalq.zzb(this.zzazz);
            }
        } catch (Throwable th) {
            super.zzeg();
            throw th;
        } finally {
            this.zzazz.zzgm();
            this.zzalq.zzb(this.zzazz);
        }
    }

    public final boolean zzfd() {
        return super.zzfd() && this.zzalr.zzfd();
    }

    public final zzhl zzfr() {
        return this.zzalr.zzfr();
    }

    public final long zzgb() {
        long zzj = this.zzalr.zzj(zzfd());
        if (zzj != Long.MIN_VALUE) {
            if (!this.zzalw) {
                zzj = Math.max(this.zzalv, zzj);
            }
            this.zzalv = zzj;
            this.zzalw = false;
        }
        return this.zzalv;
    }

    /* access modifiers changed from: protected */
    public final void zzgd() throws zzgq {
        try {
            this.zzalr.zzfo();
        } catch (zzin e) {
            throw zzgq.zza(e, getIndex());
        }
    }
}
