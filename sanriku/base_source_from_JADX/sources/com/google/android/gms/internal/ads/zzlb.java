package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(19)
@TargetApi(19)
public abstract class zzlb extends zzgp {
    private static final byte[] zzayp = zzov.zzbk("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzhf zzahd;
    private ByteBuffer[] zzakl;
    private final zzld zzayq;
    private final zzjf<zzjh> zzayr;
    private final boolean zzays;
    private final zzjb zzayt;
    private final zzjb zzayu;
    private final zzhh zzayv;
    private final List<Long> zzayw;
    private final MediaCodec.BufferInfo zzayx;
    private zzjd<zzjh> zzayy;
    private zzjd<zzjh> zzayz;
    private MediaCodec zzaza;
    private zzlc zzazb;
    private boolean zzazc;
    private boolean zzazd;
    private boolean zzaze;
    private boolean zzazf;
    private boolean zzazg;
    private boolean zzazh;
    private boolean zzazi;
    private boolean zzazj;
    private boolean zzazk;
    private ByteBuffer[] zzazl;
    private long zzazm;
    private int zzazn;
    private int zzazo;
    private boolean zzazp;
    private boolean zzazq;
    private int zzazr;
    private int zzazs;
    private boolean zzazt;
    private boolean zzazu;
    private boolean zzazv;
    private boolean zzazw;
    private boolean zzazx;
    private boolean zzazy;
    protected zziy zzazz;

    public zzlb(int i, zzld zzld, zzjf<zzjh> zzjf, boolean z) {
        super(i);
        zzoh.checkState(zzov.SDK_INT >= 16);
        this.zzayq = (zzld) zzoh.checkNotNull(zzld);
        this.zzayr = zzjf;
        this.zzays = z;
        this.zzayt = new zzjb(0);
        this.zzayu = new zzjb(0);
        this.zzayv = new zzhh();
        this.zzayw = new ArrayList();
        this.zzayx = new MediaCodec.BufferInfo();
        this.zzazr = 0;
        this.zzazs = 0;
    }

    private final void zza(zzle zzle) throws zzgq {
        throw zzgq.zza(zzle, getIndex());
    }

    private final boolean zzd(long j, long j2) throws zzgq {
        boolean z;
        boolean z2;
        if (this.zzazo < 0) {
            if (!this.zzazh || !this.zzazu) {
                this.zzazo = this.zzaza.dequeueOutputBuffer(this.zzayx, 0);
            } else {
                try {
                    this.zzazo = this.zzaza.dequeueOutputBuffer(this.zzayx, 0);
                } catch (IllegalStateException unused) {
                    zzhg();
                    if (this.zzazw) {
                        zzhe();
                    }
                    return false;
                }
            }
            int i = this.zzazo;
            if (i >= 0) {
                if (this.zzazk) {
                    this.zzazk = false;
                    this.zzaza.releaseOutputBuffer(i, false);
                    this.zzazo = -1;
                    return true;
                }
                MediaCodec.BufferInfo bufferInfo = this.zzayx;
                if ((bufferInfo.flags & 4) != 0) {
                    zzhg();
                    this.zzazo = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.zzakl[i];
                if (byteBuffer != null) {
                    byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.zzayx;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                long j3 = this.zzayx.presentationTimeUs;
                int size = this.zzayw.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z2 = false;
                        break;
                    } else if (this.zzayw.get(i2).longValue() == j3) {
                        this.zzayw.remove(i2);
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                this.zzazp = z2;
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzaza.getOutputFormat();
                if (this.zzaze && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzazk = true;
                } else {
                    if (this.zzazi) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzaza, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzakl = this.zzaza.getOutputBuffers();
                return true;
            } else {
                if (this.zzazf && (this.zzazv || this.zzazs == 2)) {
                    zzhg();
                }
                return false;
            }
        }
        if (!this.zzazh || !this.zzazu) {
            MediaCodec mediaCodec = this.zzaza;
            ByteBuffer[] byteBufferArr = this.zzakl;
            int i3 = this.zzazo;
            ByteBuffer byteBuffer2 = byteBufferArr[i3];
            MediaCodec.BufferInfo bufferInfo3 = this.zzayx;
            z = zza(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzazp);
        } else {
            try {
                z = zza(j, j2, this.zzaza, this.zzakl[this.zzazo], this.zzazo, this.zzayx.flags, this.zzayx.presentationTimeUs, this.zzazp);
            } catch (IllegalStateException unused2) {
                zzhg();
                if (this.zzazw) {
                    zzhe();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzayx.presentationTimeUs;
        this.zzazo = -1;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0147 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzhf() throws com.google.android.gms.internal.ads.zzgq {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.zzaza
            r1 = 0
            if (r0 == 0) goto L_0x01d2
            int r2 = r14.zzazs
            r3 = 2
            if (r2 == r3) goto L_0x01d2
            boolean r2 = r14.zzazv
            if (r2 == 0) goto L_0x0010
            goto L_0x01d2
        L_0x0010:
            int r2 = r14.zzazn
            if (r2 >= 0) goto L_0x002a
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.zzazn = r0
            if (r0 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            com.google.android.gms.internal.ads.zzjb r2 = r14.zzayt
            java.nio.ByteBuffer[] r4 = r14.zzazl
            r0 = r4[r0]
            r2.zzcs = r0
            r2.clear()
        L_0x002a:
            int r0 = r14.zzazs
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0047
            boolean r0 = r14.zzazf
            if (r0 != 0) goto L_0x0044
            r14.zzazu = r4
            android.media.MediaCodec r5 = r14.zzaza
            int r6 = r14.zzazn
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzazn = r2
        L_0x0044:
            r14.zzazs = r3
            return r1
        L_0x0047:
            boolean r0 = r14.zzazj
            if (r0 == 0) goto L_0x0069
            r14.zzazj = r1
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            java.nio.ByteBuffer r0 = r0.zzcs
            byte[] r1 = zzayp
            r0.put(r1)
            android.media.MediaCodec r5 = r14.zzaza
            int r6 = r14.zzazn
            r7 = 0
            byte[] r0 = zzayp
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzazn = r2
            r14.zzazt = r4
            return r4
        L_0x0069:
            boolean r0 = r14.zzazx
            if (r0 == 0) goto L_0x0070
            r0 = -4
            r5 = 0
            goto L_0x00a8
        L_0x0070:
            int r0 = r14.zzazr
            if (r0 != r4) goto L_0x0095
            r0 = 0
        L_0x0075:
            com.google.android.gms.internal.ads.zzhf r5 = r14.zzahd
            java.util.List<byte[]> r5 = r5.zzagk
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0093
            com.google.android.gms.internal.ads.zzhf r5 = r14.zzahd
            java.util.List<byte[]> r5 = r5.zzagk
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zzjb r6 = r14.zzayt
            java.nio.ByteBuffer r6 = r6.zzcs
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0075
        L_0x0093:
            r14.zzazr = r3
        L_0x0095:
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            java.nio.ByteBuffer r0 = r0.zzcs
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzhh r5 = r14.zzayv
            com.google.android.gms.internal.ads.zzjb r6 = r14.zzayt
            int r5 = r14.zza((com.google.android.gms.internal.ads.zzhh) r5, (com.google.android.gms.internal.ads.zzjb) r6, (boolean) r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00a8:
            r6 = -3
            if (r0 != r6) goto L_0x00ac
            return r1
        L_0x00ac:
            r6 = -5
            if (r0 != r6) goto L_0x00c2
            int r0 = r14.zzazr
            if (r0 != r3) goto L_0x00ba
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            r0.clear()
            r14.zzazr = r4
        L_0x00ba:
            com.google.android.gms.internal.ads.zzhh r0 = r14.zzayv
            com.google.android.gms.internal.ads.zzhf r0 = r0.zzahd
            r14.zzd(r0)
            return r4
        L_0x00c2:
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            boolean r0 = r0.zzgh()
            if (r0 == 0) goto L_0x00fe
            int r0 = r14.zzazr
            if (r0 != r3) goto L_0x00d5
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            r0.clear()
            r14.zzazr = r4
        L_0x00d5:
            r14.zzazv = r4
            boolean r0 = r14.zzazt
            if (r0 != 0) goto L_0x00df
            r14.zzhg()
            return r1
        L_0x00df:
            boolean r0 = r14.zzazf     // Catch:{ CryptoException -> 0x00f4 }
            if (r0 != 0) goto L_0x00f3
            r14.zzazu = r4     // Catch:{ CryptoException -> 0x00f4 }
            android.media.MediaCodec r5 = r14.zzaza     // Catch:{ CryptoException -> 0x00f4 }
            int r6 = r14.zzazn     // Catch:{ CryptoException -> 0x00f4 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f4 }
            r14.zzazn = r2     // Catch:{ CryptoException -> 0x00f4 }
        L_0x00f3:
            return r1
        L_0x00f4:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzgq r0 = com.google.android.gms.internal.ads.zzgq.zza(r0, r1)
            throw r0
        L_0x00fe:
            boolean r0 = r14.zzazy
            if (r0 == 0) goto L_0x0116
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            boolean r0 = r0.zzgi()
            if (r0 != 0) goto L_0x0116
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            r0.clear()
            int r0 = r14.zzazr
            if (r0 != r3) goto L_0x0115
            r14.zzazr = r4
        L_0x0115:
            return r4
        L_0x0116:
            r14.zzazy = r1
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt
            boolean r0 = r0.isEncrypted()
            com.google.android.gms.internal.ads.zzjd<com.google.android.gms.internal.ads.zzjh> r3 = r14.zzayy
            if (r3 == 0) goto L_0x0142
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0133
            r6 = 4
            if (r3 == r6) goto L_0x0142
            if (r0 != 0) goto L_0x0131
            boolean r3 = r14.zzays
            if (r3 != 0) goto L_0x0142
        L_0x0131:
            r3 = 1
            goto L_0x0143
        L_0x0133:
            com.google.android.gms.internal.ads.zzjd<com.google.android.gms.internal.ads.zzjh> r0 = r14.zzayy
            com.google.android.gms.internal.ads.zzjg r0 = r0.zzgo()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzgq r0 = com.google.android.gms.internal.ads.zzgq.zza(r0, r1)
            throw r0
        L_0x0142:
            r3 = 0
        L_0x0143:
            r14.zzazx = r3
            if (r3 == 0) goto L_0x0148
            return r1
        L_0x0148:
            boolean r3 = r14.zzazc
            if (r3 == 0) goto L_0x0162
            if (r0 != 0) goto L_0x0162
            com.google.android.gms.internal.ads.zzjb r3 = r14.zzayt
            java.nio.ByteBuffer r3 = r3.zzcs
            com.google.android.gms.internal.ads.zzon.zzk(r3)
            com.google.android.gms.internal.ads.zzjb r3 = r14.zzayt
            java.nio.ByteBuffer r3 = r3.zzcs
            int r3 = r3.position()
            if (r3 != 0) goto L_0x0160
            return r4
        L_0x0160:
            r14.zzazc = r1
        L_0x0162:
            com.google.android.gms.internal.ads.zzjb r3 = r14.zzayt     // Catch:{ CryptoException -> 0x01c8 }
            long r10 = r3.timeUs     // Catch:{ CryptoException -> 0x01c8 }
            com.google.android.gms.internal.ads.zzjb r3 = r14.zzayt     // Catch:{ CryptoException -> 0x01c8 }
            boolean r3 = r3.zzgg()     // Catch:{ CryptoException -> 0x01c8 }
            if (r3 == 0) goto L_0x0177
            java.util.List<java.lang.Long> r3 = r14.zzayw     // Catch:{ CryptoException -> 0x01c8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01c8 }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01c8 }
        L_0x0177:
            com.google.android.gms.internal.ads.zzjb r3 = r14.zzayt     // Catch:{ CryptoException -> 0x01c8 }
            java.nio.ByteBuffer r3 = r3.zzcs     // Catch:{ CryptoException -> 0x01c8 }
            r3.flip()     // Catch:{ CryptoException -> 0x01c8 }
            com.google.android.gms.internal.ads.zzjb r3 = r14.zzayt     // Catch:{ CryptoException -> 0x01c8 }
            r14.zza((com.google.android.gms.internal.ads.zzjb) r3)     // Catch:{ CryptoException -> 0x01c8 }
            if (r0 == 0) goto L_0x01a9
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt     // Catch:{ CryptoException -> 0x01c8 }
            com.google.android.gms.internal.ads.zzix r0 = r0.zzano     // Catch:{ CryptoException -> 0x01c8 }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzgl()     // Catch:{ CryptoException -> 0x01c8 }
            if (r5 != 0) goto L_0x0190
            goto L_0x019f
        L_0x0190:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01c8 }
            if (r0 != 0) goto L_0x0198
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01c8 }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01c8 }
        L_0x0198:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01c8 }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01c8 }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01c8 }
        L_0x019f:
            android.media.MediaCodec r6 = r14.zzaza     // Catch:{ CryptoException -> 0x01c8 }
            int r7 = r14.zzazn     // Catch:{ CryptoException -> 0x01c8 }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01c8 }
            goto L_0x01ba
        L_0x01a9:
            android.media.MediaCodec r6 = r14.zzaza     // Catch:{ CryptoException -> 0x01c8 }
            int r7 = r14.zzazn     // Catch:{ CryptoException -> 0x01c8 }
            r8 = 0
            com.google.android.gms.internal.ads.zzjb r0 = r14.zzayt     // Catch:{ CryptoException -> 0x01c8 }
            java.nio.ByteBuffer r0 = r0.zzcs     // Catch:{ CryptoException -> 0x01c8 }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01c8 }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01c8 }
        L_0x01ba:
            r14.zzazn = r2     // Catch:{ CryptoException -> 0x01c8 }
            r14.zzazt = r4     // Catch:{ CryptoException -> 0x01c8 }
            r14.zzazr = r1     // Catch:{ CryptoException -> 0x01c8 }
            com.google.android.gms.internal.ads.zziy r0 = r14.zzazz     // Catch:{ CryptoException -> 0x01c8 }
            int r1 = r0.zzang     // Catch:{ CryptoException -> 0x01c8 }
            int r1 = r1 + r4
            r0.zzang = r1     // Catch:{ CryptoException -> 0x01c8 }
            return r4
        L_0x01c8:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzgq r0 = com.google.android.gms.internal.ads.zzgq.zza(r0, r1)
            throw r0
        L_0x01d2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlb.zzhf():boolean");
    }

    private final void zzhg() throws zzgq {
        if (this.zzazs == 2) {
            zzhe();
            zzhb();
            return;
        }
        this.zzazw = true;
        zzgd();
    }

    public boolean isReady() {
        if (this.zzahd == null || this.zzazx) {
            return false;
        }
        if (zzei() || this.zzazo >= 0) {
            return true;
        }
        return this.zzazm != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzazm;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzgq {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    public final int zza(zzhf zzhf) throws zzgq {
        try {
            return zza(this.zzayq, zzhf);
        } catch (zzlj e) {
            throw zzgq.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzld zzld, zzhf zzhf) throws zzlj;

    /* access modifiers changed from: protected */
    public zzlc zza(zzld zzld, zzhf zzhf, boolean z) throws zzlj {
        return zzld.zzb(zzhf.zzagi, z);
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzgq {
        this.zzazv = false;
        this.zzazw = false;
        if (this.zzaza != null) {
            this.zzazm = -9223372036854775807L;
            this.zzazn = -1;
            this.zzazo = -1;
            this.zzazy = true;
            this.zzazx = false;
            this.zzazp = false;
            this.zzayw.clear();
            this.zzazj = false;
            this.zzazk = false;
            if (this.zzazd || ((this.zzazg && this.zzazu) || this.zzazs != 0)) {
                zzhe();
                zzhb();
            } else {
                this.zzaza.flush();
                this.zzazt = false;
            }
            if (this.zzazq && this.zzahd != null) {
                this.zzazr = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzjb zzjb) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzlc zzlc, MediaCodec mediaCodec, zzhf zzhf, MediaCrypto mediaCrypto) throws zzlj;

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzgq;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzhf zzhf, zzhf zzhf2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzlc zzlc) {
        return true;
    }

    public final void zzb(long j, long j2) throws zzgq {
        if (this.zzazw) {
            zzgd();
            return;
        }
        if (this.zzahd == null) {
            this.zzayu.clear();
            int zza = zza(this.zzayv, this.zzayu, true);
            if (zza == -5) {
                zzd(this.zzayv.zzahd);
            } else if (zza == -4) {
                zzoh.checkState(this.zzayu.zzgh());
                this.zzazv = true;
                zzhg();
                return;
            } else {
                return;
            }
        }
        zzhb();
        if (this.zzaza != null) {
            zzow.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzhf());
            zzow.endSection();
        } else {
            zzdn(j);
            this.zzayu.clear();
            int zza2 = zza(this.zzayv, this.zzayu, false);
            if (zza2 == -5) {
                zzd(this.zzayv.zzahd);
            } else if (zza2 == -4) {
                zzoh.checkState(this.zzayu.zzgh());
                this.zzazv = true;
                zzhg();
            }
        }
        this.zzazz.zzgm();
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r5.height == r0.height) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzd(com.google.android.gms.internal.ads.zzhf r5) throws com.google.android.gms.internal.ads.zzgq {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzhf r0 = r4.zzahd
            r4.zzahd = r5
            com.google.android.gms.internal.ads.zzja r5 = r5.zzagl
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x000d
        L_0x000b:
            com.google.android.gms.internal.ads.zzja r2 = r0.zzagl
        L_0x000d:
            boolean r5 = com.google.android.gms.internal.ads.zzov.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzhf r5 = r4.zzahd
            com.google.android.gms.internal.ads.zzja r5 = r5.zzagl
            if (r5 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzjf<com.google.android.gms.internal.ads.zzjh> r5 = r4.zzayr
            if (r5 == 0) goto L_0x0037
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzhf r3 = r4.zzahd
            com.google.android.gms.internal.ads.zzja r3 = r3.zzagl
            com.google.android.gms.internal.ads.zzjd r5 = r5.zza(r1, r3)
            r4.zzayz = r5
            com.google.android.gms.internal.ads.zzjd<com.google.android.gms.internal.ads.zzjh> r1 = r4.zzayy
            if (r5 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzjf<com.google.android.gms.internal.ads.zzjh> r1 = r4.zzayr
            r1.zza(r5)
            goto L_0x0049
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.google.android.gms.internal.ads.zzgq r5 = com.google.android.gms.internal.ads.zzgq.zza(r5, r0)
            throw r5
        L_0x0047:
            r4.zzayz = r1
        L_0x0049:
            com.google.android.gms.internal.ads.zzjd<com.google.android.gms.internal.ads.zzjh> r5 = r4.zzayz
            com.google.android.gms.internal.ads.zzjd<com.google.android.gms.internal.ads.zzjh> r1 = r4.zzayy
            if (r5 != r1) goto L_0x007a
            android.media.MediaCodec r5 = r4.zzaza
            if (r5 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzlc r1 = r4.zzazb
            boolean r1 = r1.zzbaa
            com.google.android.gms.internal.ads.zzhf r3 = r4.zzahd
            boolean r5 = r4.zza((android.media.MediaCodec) r5, (boolean) r1, (com.google.android.gms.internal.ads.zzhf) r0, (com.google.android.gms.internal.ads.zzhf) r3)
            if (r5 == 0) goto L_0x007a
            r4.zzazq = r2
            r4.zzazr = r2
            boolean r5 = r4.zzaze
            if (r5 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzhf r5 = r4.zzahd
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L_0x0076
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r2 = 0
        L_0x0077:
            r4.zzazj = r2
            return
        L_0x007a:
            boolean r5 = r4.zzazt
            if (r5 == 0) goto L_0x0081
            r4.zzazs = r2
            return
        L_0x0081:
            r4.zzhe()
            r4.zzhb()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlb.zzd(com.google.android.gms.internal.ads.zzhf):void");
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) throws zzgq {
        this.zzazz = new zziy();
    }

    public final int zzef() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzeg() {
        this.zzahd = null;
        try {
            zzhe();
            try {
                if (this.zzayy != null) {
                    this.zzayr.zza(this.zzayy);
                }
                try {
                    if (!(this.zzayz == null || this.zzayz == this.zzayy)) {
                        this.zzayr.zza(this.zzayz);
                    }
                } finally {
                    this.zzayy = null;
                    this.zzayz = null;
                }
            } catch (Throwable th) {
                if (!(this.zzayz == null || this.zzayz == this.zzayy)) {
                    this.zzayr.zza(this.zzayz);
                }
                throw th;
            } finally {
                this.zzayy = null;
                this.zzayz = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzayz == null || this.zzayz == this.zzayy)) {
                    this.zzayr.zza(this.zzayz);
                }
                throw th2;
            } finally {
                this.zzayy = null;
                this.zzayz = null;
            }
        } finally {
        }
    }

    public boolean zzfd() {
        return this.zzazw;
    }

    /* access modifiers changed from: protected */
    public void zzgd() throws zzgq {
    }

    /* access modifiers changed from: protected */
    public final void zzhb() throws zzgq {
        zzhf zzhf;
        if (this.zzaza == null && (zzhf = this.zzahd) != null) {
            zzjd<zzjh> zzjd = this.zzayz;
            this.zzayy = zzjd;
            String str = zzhf.zzagi;
            if (zzjd != null) {
                int state = zzjd.getState();
                if (state == 0) {
                    throw zzgq.zza(this.zzayy.zzgo(), getIndex());
                } else if (state == 3 || state == 4) {
                    zzjh zzgn = this.zzayy.zzgn();
                    throw new NoSuchMethodError();
                }
            } else {
                if (this.zzazb == null) {
                    try {
                        this.zzazb = zza(this.zzayq, zzhf, false);
                    } catch (zzlj e) {
                        zza(new zzle(this.zzahd, (Throwable) e, false, -49998));
                    }
                    if (this.zzazb == null) {
                        zza(new zzle(this.zzahd, (Throwable) null, false, -49999));
                    }
                }
                if (zza(this.zzazb)) {
                    String str2 = this.zzazb.name;
                    this.zzazc = zzov.SDK_INT < 21 && this.zzahd.zzagk.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                    int i = zzov.SDK_INT;
                    this.zzazd = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzov.SDK_INT == 19 && zzov.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                    this.zzaze = zzov.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzov.DEVICE) || "flounder_lte".equals(zzov.DEVICE) || "grouper".equals(zzov.DEVICE) || "tilapia".equals(zzov.DEVICE));
                    this.zzazf = zzov.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.zzazg = (zzov.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzov.SDK_INT <= 19 && "hb2000".equals(zzov.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.zzazh = zzov.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
                    this.zzazi = zzov.SDK_INT <= 18 && this.zzahd.zzags == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String valueOf = String.valueOf(str2);
                        zzow.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                        this.zzaza = MediaCodec.createByCodecName(str2);
                        zzow.endSection();
                        zzow.beginSection("configureCodec");
                        zza(this.zzazb, this.zzaza, this.zzahd, (MediaCrypto) null);
                        zzow.endSection();
                        zzow.beginSection("startCodec");
                        this.zzaza.start();
                        zzow.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.zzazl = this.zzaza.getInputBuffers();
                        this.zzakl = this.zzaza.getOutputBuffers();
                    } catch (Exception e2) {
                        zza(new zzle(this.zzahd, (Throwable) e2, false, str2));
                    }
                    this.zzazm = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzazn = -1;
                    this.zzazo = -1;
                    this.zzazy = true;
                    this.zzazz.zzane++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzhc() {
        return this.zzaza;
    }

    /* access modifiers changed from: protected */
    public final zzlc zzhd() {
        return this.zzazb;
    }

    /* access modifiers changed from: protected */
    public void zzhe() {
        this.zzazm = -9223372036854775807L;
        this.zzazn = -1;
        this.zzazo = -1;
        this.zzazx = false;
        this.zzazp = false;
        this.zzayw.clear();
        this.zzazl = null;
        this.zzakl = null;
        this.zzazb = null;
        this.zzazq = false;
        this.zzazt = false;
        this.zzazc = false;
        this.zzazd = false;
        this.zzaze = false;
        this.zzazf = false;
        this.zzazg = false;
        this.zzazi = false;
        this.zzazj = false;
        this.zzazk = false;
        this.zzazu = false;
        this.zzazr = 0;
        this.zzazs = 0;
        this.zzayt.zzcs = null;
        MediaCodec mediaCodec = this.zzaza;
        if (mediaCodec != null) {
            this.zzazz.zzanf++;
            try {
                mediaCodec.stop();
                try {
                    this.zzaza.release();
                    this.zzaza = null;
                    zzjd<zzjh> zzjd = this.zzayy;
                    if (zzjd != null && this.zzayz != zzjd) {
                        try {
                            this.zzayr.zza(zzjd);
                        } finally {
                            this.zzayy = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzaza = null;
                    zzjd<zzjh> zzjd2 = this.zzayy;
                    if (!(zzjd2 == null || this.zzayz == zzjd2)) {
                        this.zzayr.zza(zzjd2);
                    }
                    throw th;
                } finally {
                    this.zzayy = null;
                }
            } catch (Throwable th2) {
                this.zzaza = null;
                zzjd<zzjh> zzjd3 = this.zzayy;
                if (!(zzjd3 == null || this.zzayz == zzjd3)) {
                    try {
                        this.zzayr.zza(zzjd3);
                    } finally {
                        this.zzayy = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }
}
