package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import p009e.p010a.p011a.p012a.C0681a;

@TargetApi(16)
public final class zzpg extends zzlb {
    private static final int[] zzbil = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzahj;
    private boolean zzaku;
    private final zzpk zzbim;
    private final zzpl zzbin;
    private final long zzbio;
    private final int zzbip;
    private final boolean zzbiq;
    private final long[] zzbir;
    private zzhf[] zzbis;
    private zzpi zzbit;
    private Surface zzbiu;
    private Surface zzbiv;
    private int zzbiw;
    private boolean zzbix;
    private long zzbiy;
    private long zzbiz;
    private int zzbja;
    private int zzbjb;
    private int zzbjc;
    private float zzbjd;
    private int zzbje;
    private int zzbjf;
    private int zzbjg;
    private float zzbjh;
    private int zzbji;
    private int zzbjj;
    private int zzbjk;
    private float zzbjl;
    zzph zzbjm;
    private long zzbjn;
    private int zzbjo;
    private final Context zzvf;

    public zzpg(Context context, zzld zzld, long j, zzdns zzdns, zzpm zzpm, int i) {
        this(context, zzld, 0, (zzjf<zzjh>) null, false, zzdns, zzpm, -1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzpg(Context context, zzld zzld, long j, zzjf<zzjh> zzjf, boolean z, zzdns zzdns, zzpm zzpm, int i) {
        super(2, zzld, (zzjf<zzjh>) null, false);
        boolean z2 = false;
        this.zzbio = 0;
        this.zzbip = -1;
        this.zzvf = context.getApplicationContext();
        this.zzbim = new zzpk(context);
        this.zzbin = new zzpl(zzdns, zzpm);
        if (zzov.SDK_INT <= 22 && "foster".equals(zzov.DEVICE) && "NVIDIA".equals(zzov.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbiq = z2;
        this.zzbir = new long[10];
        this.zzbjn = -9223372036854775807L;
        this.zzbiy = -9223372036854775807L;
        this.zzbje = -1;
        this.zzbjf = -1;
        this.zzbjh = -1.0f;
        this.zzbjd = -1.0f;
        this.zzbiw = 1;
        zzjj();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0085
            if (r9 != r0) goto L_0x0007
            goto L_0x0085
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 3
            r5 = 4
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007c
            if (r7 == r3) goto L_0x007c
            if (r7 == r6) goto L_0x0061
            if (r7 == r4) goto L_0x007c
            if (r7 == r5) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x007f
        L_0x0061:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzov.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzov.zzf(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzov.zzf(r9, r7)
            int r7 = r7 * r8
            int r7 = r7 << r5
            int r8 = r7 << 4
            goto L_0x007e
        L_0x007c:
            int r8 = r8 * r9
        L_0x007e:
            r5 = 2
        L_0x007f:
            int r8 = r8 * 3
            int r5 = r5 * 2
            int r8 = r8 / r5
            return r8
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpg.zza(java.lang.String, int, int):int");
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzow.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzow.endSection();
        this.zzazz.zzani++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjk();
        zzow.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzow.endSection();
        this.zzazz.zzanh++;
        this.zzbjb = 0;
        zzji();
    }

    private static boolean zza(boolean z, zzhf zzhf, zzhf zzhf2) {
        if (!zzhf.zzagi.equals(zzhf2.zzagi) || zzj(zzhf) != zzj(zzhf2)) {
            return false;
        }
        if (!z) {
            return zzhf.width == zzhf2.width && zzhf.height == zzhf2.height;
        }
        return true;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjk();
        zzow.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzow.endSection();
        this.zzazz.zzanh++;
        this.zzbjb = 0;
        zzji();
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    private static int zzi(zzhf zzhf) {
        int i = zzhf.zzagj;
        return i != -1 ? i : zza(zzhf.zzagi, zzhf.width, zzhf.height);
    }

    private static int zzj(zzhf zzhf) {
        int i = zzhf.zzagn;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final void zzjg() {
        this.zzbiy = this.zzbio > 0 ? SystemClock.elapsedRealtime() + this.zzbio : -9223372036854775807L;
    }

    private final void zzjh() {
        MediaCodec zzhc;
        this.zzbix = false;
        if (zzov.SDK_INT >= 23 && this.zzaku && (zzhc = zzhc()) != null) {
            this.zzbjm = new zzph(this, zzhc);
        }
    }

    private final void zzjj() {
        this.zzbji = -1;
        this.zzbjj = -1;
        this.zzbjl = -1.0f;
        this.zzbjk = -1;
    }

    private final void zzjk() {
        if (this.zzbji != this.zzbje || this.zzbjj != this.zzbjf || this.zzbjk != this.zzbjg || this.zzbjl != this.zzbjh) {
            this.zzbin.zza(this.zzbje, this.zzbjf, this.zzbjg, this.zzbjh);
            this.zzbji = this.zzbje;
            this.zzbjj = this.zzbjf;
            this.zzbjk = this.zzbjg;
            this.zzbjl = this.zzbjh;
        }
    }

    private final void zzjl() {
        if (this.zzbji != -1 || this.zzbjj != -1) {
            this.zzbin.zza(this.zzbje, this.zzbjf, this.zzbjg, this.zzbjh);
        }
    }

    private final void zzjm() {
        if (this.zzbja > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbin.zze(this.zzbja, elapsedRealtime - this.zzbiz);
            this.zzbja = 0;
            this.zzbiz = elapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzov.SDK_INT < 23 || this.zzaku) {
            return false;
        }
        return !z || zzpc.zzc(this.zzvf);
    }

    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzbix || (((surface = this.zzbiv) != null && this.zzbiu == surface) || zzhc() == null))) {
            this.zzbiy = -9223372036854775807L;
            return true;
        } else if (this.zzbiy == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzbiy) {
                return true;
            }
            this.zzbiy = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.zzbje = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        this.zzbjf = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.zzbjh = this.zzbjd;
        if (zzov.SDK_INT >= 21) {
            int i = this.zzbjc;
            if (i == 90 || i == 270) {
                int i2 = this.zzbje;
                this.zzbje = this.zzbjf;
                this.zzbjf = i2;
                this.zzbjh = 1.0f / this.zzbjh;
            }
        } else {
            this.zzbjg = this.zzbjc;
        }
        mediaCodec.setVideoScalingMode(this.zzbiw);
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzbja = 0;
        this.zzbiz = SystemClock.elapsedRealtime();
        this.zzbiy = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        zzjm();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzld zzld, zzhf zzhf) throws zzlj {
        boolean z;
        int i;
        int i2;
        String str = zzhf.zzagi;
        int i3 = 0;
        if (!zzoo.zzbe(str)) {
            return 0;
        }
        zzja zzja = zzhf.zzagl;
        if (zzja != null) {
            z = false;
            for (int i4 = 0; i4 < zzja.zzann; i4++) {
                z |= zzja.zzaa(i4).zzanq;
            }
        } else {
            z = false;
        }
        zzlc zzb = zzld.zzb(str, z);
        boolean z2 = true;
        if (zzb == null) {
            return 1;
        }
        boolean zzba = zzb.zzba(zzhf.zzagf);
        if (zzba && (i = zzhf.width) > 0 && (i2 = zzhf.height) > 0) {
            if (zzov.SDK_INT >= 21) {
                zzba = zzb.zza(i, i2, (double) zzhf.zzagm);
            } else {
                if (i * i2 > zzlf.zzhj()) {
                    z2 = false;
                }
                if (!z2) {
                    int i5 = zzhf.width;
                    int i6 = zzhf.height;
                    String str2 = zzov.zzbhv;
                    StringBuilder sb = new StringBuilder(C0681a.m336b(str2, 56));
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i5);
                    sb.append("x");
                    sb.append(i6);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
                zzba = z2;
            }
        }
        int i7 = zzb.zzbaa ? 8 : 4;
        if (zzb.zzaku) {
            i3 = 16;
        }
        return (zzba ? 3 : 2) | i7 | i3;
    }

    public final void zza(int i, Object obj) throws zzgq {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzbiv;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzlc zzhd = zzhd();
                    if (zzhd != null && zzn(zzhd.zzbab)) {
                        surface = zzpc.zzc(this.zzvf, zzhd.zzbab);
                        this.zzbiv = surface;
                    }
                }
            }
            if (this.zzbiu != surface) {
                this.zzbiu = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhc = zzhc();
                    if (zzov.SDK_INT < 23 || zzhc == null || surface == null) {
                        zzhe();
                        zzhb();
                    } else {
                        zzhc.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzbiv) {
                    zzjj();
                    zzjh();
                    return;
                }
                zzjl();
                zzjh();
                if (state == 2) {
                    zzjg();
                }
            } else if (surface != null && surface != this.zzbiv) {
                zzjl();
                if (this.zzbix) {
                    this.zzbin.zza(this.zzbiu);
                }
            }
        } else if (i == 4) {
            this.zzbiw = ((Integer) obj).intValue();
            MediaCodec zzhc2 = zzhc();
            if (zzhc2 != null) {
                zzhc2.setVideoScalingMode(this.zzbiw);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzgq {
        super.zza(j, z);
        zzjh();
        this.zzbjb = 0;
        int i = this.zzbjo;
        if (i != 0) {
            this.zzbjn = this.zzbir[i - 1];
            this.zzbjo = 0;
        }
        if (z) {
            zzjg();
        } else {
            this.zzbiy = -9223372036854775807L;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzjb zzjb) {
        if (zzov.SDK_INT < 23 && this.zzaku) {
            zzji();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r10 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzlc r21, android.media.MediaCodec r22, com.google.android.gms.internal.ads.zzhf r23, android.media.MediaCrypto r24) throws com.google.android.gms.internal.ads.zzlj {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            com.google.android.gms.internal.ads.zzhf[] r4 = r0.zzbis
            int r5 = r3.width
            int r6 = r3.height
            int r7 = zzi(r23)
            int r8 = r4.length
            r9 = -1
            r10 = 1
            if (r8 != r10) goto L_0x001e
            com.google.android.gms.internal.ads.zzpi r4 = new com.google.android.gms.internal.ads.zzpi
            r4.<init>(r5, r6, r7)
            goto L_0x0115
        L_0x001e:
            int r8 = r4.length
            r10 = 0
            r11 = 0
        L_0x0021:
            if (r10 >= r8) goto L_0x0051
            r12 = r4[r10]
            boolean r13 = r1.zzbaa
            boolean r13 = zza((boolean) r13, (com.google.android.gms.internal.ads.zzhf) r3, (com.google.android.gms.internal.ads.zzhf) r12)
            if (r13 == 0) goto L_0x004e
            int r13 = r12.width
            if (r13 == r9) goto L_0x0038
            int r13 = r12.height
            if (r13 != r9) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r13 = 0
            goto L_0x0039
        L_0x0038:
            r13 = 1
        L_0x0039:
            r11 = r11 | r13
            int r13 = r12.width
            int r5 = java.lang.Math.max(r5, r13)
            int r13 = r12.height
            int r6 = java.lang.Math.max(r6, r13)
            int r12 = zzi(r12)
            int r7 = java.lang.Math.max(r7, r12)
        L_0x004e:
            int r10 = r10 + 1
            goto L_0x0021
        L_0x0051:
            if (r11 == 0) goto L_0x0110
            r4 = 66
            java.lang.String r8 = "Resolutions unknown. Codec max resolution: "
            java.lang.String r9 = "x"
            java.lang.String r4 = p009e.p010a.p011a.p012a.C0681a.m311a((int) r4, (java.lang.String) r8, (int) r5, (java.lang.String) r9, (int) r6)
            java.lang.String r8 = "MediaCodecVideoRenderer"
            android.util.Log.w(r8, r4)
            int r4 = r3.height
            int r10 = r3.width
            if (r4 <= r10) goto L_0x006a
            r4 = 1
            goto L_0x006b
        L_0x006a:
            r4 = 0
        L_0x006b:
            if (r4 == 0) goto L_0x0070
            int r10 = r3.height
            goto L_0x0072
        L_0x0070:
            int r10 = r3.width
        L_0x0072:
            if (r4 == 0) goto L_0x0077
            int r11 = r3.width
            goto L_0x0079
        L_0x0077:
            int r11 = r3.height
        L_0x0079:
            float r12 = (float) r11
            float r13 = (float) r10
            float r12 = r12 / r13
            int[] r13 = zzbil
            int r14 = r13.length
            r15 = 0
        L_0x0080:
            if (r15 >= r14) goto L_0x00ec
            r24 = r14
            r14 = r13[r15]
            r16 = r13
            float r13 = (float) r14
            float r13 = r13 * r12
            int r13 = (int) r13
            if (r14 <= r10) goto L_0x00ec
            if (r13 > r11) goto L_0x0092
            goto L_0x00ec
        L_0x0092:
            r17 = r10
            int r10 = com.google.android.gms.internal.ads.zzov.SDK_INT
            r18 = r11
            r11 = 21
            if (r10 < r11) goto L_0x00bb
            if (r4 == 0) goto L_0x00a0
            r10 = r13
            goto L_0x00a1
        L_0x00a0:
            r10 = r14
        L_0x00a1:
            if (r4 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r14 = r13
        L_0x00a5:
            android.graphics.Point r10 = r1.zzd(r10, r14)
            float r11 = r3.zzagm
            int r13 = r10.x
            int r14 = r10.y
            r19 = r10
            double r10 = (double) r11
            boolean r10 = r1.zza(r13, r14, r10)
            if (r10 == 0) goto L_0x00e1
            r10 = r19
            goto L_0x00ed
        L_0x00bb:
            r10 = 16
            int r11 = com.google.android.gms.internal.ads.zzov.zzf(r14, r10)
            int r11 = r11 << 4
            int r10 = com.google.android.gms.internal.ads.zzov.zzf(r13, r10)
            int r10 = r10 << 4
            int r13 = r11 * r10
            int r14 = com.google.android.gms.internal.ads.zzlf.zzhj()
            if (r13 > r14) goto L_0x00e1
            android.graphics.Point r12 = new android.graphics.Point
            if (r4 == 0) goto L_0x00d7
            r13 = r10
            goto L_0x00d8
        L_0x00d7:
            r13 = r11
        L_0x00d8:
            if (r4 == 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r11 = r10
        L_0x00dc:
            r12.<init>(r13, r11)
            r10 = r12
            goto L_0x00ed
        L_0x00e1:
            int r15 = r15 + 1
            r14 = r24
            r13 = r16
            r10 = r17
            r11 = r18
            goto L_0x0080
        L_0x00ec:
            r10 = 0
        L_0x00ed:
            if (r10 == 0) goto L_0x0110
            int r4 = r10.x
            int r5 = java.lang.Math.max(r5, r4)
            int r4 = r10.y
            int r6 = java.lang.Math.max(r6, r4)
            java.lang.String r4 = r3.zzagi
            int r4 = zza((java.lang.String) r4, (int) r5, (int) r6)
            int r7 = java.lang.Math.max(r7, r4)
            r4 = 57
            java.lang.String r10 = "Codec max resolution adjusted to: "
            java.lang.String r4 = p009e.p010a.p011a.p012a.C0681a.m311a((int) r4, (java.lang.String) r10, (int) r5, (java.lang.String) r9, (int) r6)
            android.util.Log.w(r8, r4)
        L_0x0110:
            com.google.android.gms.internal.ads.zzpi r4 = new com.google.android.gms.internal.ads.zzpi
            r4.<init>(r5, r6, r7)
        L_0x0115:
            r0.zzbit = r4
            boolean r5 = r0.zzbiq
            int r6 = r0.zzahj
            android.media.MediaFormat r3 = r23.zzez()
            int r7 = r4.width
            java.lang.String r8 = "max-width"
            r3.setInteger(r8, r7)
            int r7 = r4.height
            java.lang.String r8 = "max-height"
            r3.setInteger(r8, r7)
            int r4 = r4.zzbjq
            r7 = -1
            if (r4 == r7) goto L_0x0137
            java.lang.String r7 = "max-input-size"
            r3.setInteger(r7, r4)
        L_0x0137:
            if (r5 == 0) goto L_0x013f
            java.lang.String r4 = "auto-frc"
            r5 = 0
            r3.setInteger(r4, r5)
        L_0x013f:
            if (r6 == 0) goto L_0x014c
            java.lang.String r4 = "tunneled-playback"
            r5 = 1
            r3.setFeatureEnabled(r4, r5)
            java.lang.String r4 = "audio-session-id"
            r3.setInteger(r4, r6)
        L_0x014c:
            android.view.Surface r4 = r0.zzbiu
            if (r4 != 0) goto L_0x016b
            boolean r4 = r1.zzbab
            boolean r4 = r0.zzn(r4)
            com.google.android.gms.internal.ads.zzoh.checkState(r4)
            android.view.Surface r4 = r0.zzbiv
            if (r4 != 0) goto L_0x0167
            android.content.Context r4 = r0.zzvf
            boolean r1 = r1.zzbab
            com.google.android.gms.internal.ads.zzpc r1 = com.google.android.gms.internal.ads.zzpc.zzc(r4, r1)
            r0.zzbiv = r1
        L_0x0167:
            android.view.Surface r1 = r0.zzbiv
            r0.zzbiu = r1
        L_0x016b:
            android.view.Surface r1 = r0.zzbiu
            r4 = 0
            r5 = 0
            r2.configure(r3, r1, r4, r5)
            int r1 = com.google.android.gms.internal.ads.zzov.SDK_INT
            r3 = 23
            if (r1 < r3) goto L_0x0183
            boolean r1 = r0.zzaku
            if (r1 == 0) goto L_0x0183
            com.google.android.gms.internal.ads.zzph r1 = new com.google.android.gms.internal.ads.zzph
            r1.<init>(r0, r2)
            r0.zzbjm = r1
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpg.zza(com.google.android.gms.internal.ads.zzlc, android.media.MediaCodec, com.google.android.gms.internal.ads.zzhf, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhf[] zzhfArr, long j) throws zzgq {
        this.zzbis = zzhfArr;
        if (this.zzbjn == -9223372036854775807L) {
            this.zzbjn = j;
        } else {
            int i = this.zzbjo;
            long[] jArr = this.zzbir;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbjo = i + 1;
            }
            this.zzbir[this.zzbjo - 1] = j;
        }
        super.zza(zzhfArr, j);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzbjo;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzbir;
            if (j4 < jArr[0]) {
                break;
            }
            this.zzbjn = jArr[0];
            int i5 = i4 - 1;
            this.zzbjo = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.zzbjn;
        if (z) {
            zza(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.zzbiu == this.zzbiv) {
            if (!zzem(j6)) {
                return false;
            }
            zza(mediaCodec2, i3, j5);
            return true;
        } else if (!this.zzbix) {
            if (zzov.SDK_INT >= 21) {
                zza(mediaCodec, i, j5, System.nanoTime());
            } else {
                zzb(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzbim.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (zzem(j7)) {
                zzow.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzow.endSection();
                zziy zziy = this.zzazz;
                zziy.zzanj++;
                this.zzbja++;
                int i6 = this.zzbjb + 1;
                this.zzbjb = i6;
                zziy.zzank = Math.max(i6, zziy.zzank);
                if (this.zzbja == this.zzbip) {
                    zzjm();
                }
                return true;
            }
            if (zzov.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i, j5, zzf);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzhf zzhf, zzhf zzhf2) {
        if (!zza(z, zzhf, zzhf2)) {
            return false;
        }
        int i = zzhf2.width;
        zzpi zzpi = this.zzbit;
        return i <= zzpi.width && zzhf2.height <= zzpi.height && zzhf2.zzagj <= zzpi.zzbjq;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzlc zzlc) {
        return this.zzbiu != null || zzn(zzlc.zzbab);
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzbin.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhf zzhf) throws zzgq {
        super.zzd(zzhf);
        this.zzbin.zzb(zzhf);
        float f = zzhf.zzago;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzbjd = f;
        this.zzbjc = zzj(zzhf);
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) throws zzgq {
        super.zze(z);
        int i = zzeh().zzahj;
        this.zzahj = i;
        this.zzaku = i != 0;
        this.zzbin.zza(this.zzazz);
        this.zzbim.enable();
    }

    /* access modifiers changed from: protected */
    public final void zzeg() {
        this.zzbje = -1;
        this.zzbjf = -1;
        this.zzbjh = -1.0f;
        this.zzbjd = -1.0f;
        this.zzbjn = -9223372036854775807L;
        this.zzbjo = 0;
        zzjj();
        zzjh();
        this.zzbim.disable();
        this.zzbjm = null;
        this.zzaku = false;
        try {
            super.zzeg();
        } finally {
            this.zzazz.zzgm();
            this.zzbin.zzb(this.zzazz);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzhe() {
        try {
            super.zzhe();
        } finally {
            Surface surface = this.zzbiv;
            if (surface != null) {
                if (this.zzbiu == surface) {
                    this.zzbiu = null;
                }
                this.zzbiv.release();
                this.zzbiv = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzji() {
        if (!this.zzbix) {
            this.zzbix = true;
            this.zzbin.zza(this.zzbiu);
        }
    }
}
