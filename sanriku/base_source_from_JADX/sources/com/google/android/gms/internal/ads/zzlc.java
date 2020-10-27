package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import p009e.p010a.p011a.p012a.C0681a;

@TargetApi(16)
public final class zzlc {
    private final String mimeType;
    public final String name;
    public final boolean zzaku;
    public final boolean zzbaa;
    public final boolean zzbab;
    private final MediaCodecInfo.CodecCapabilities zzbac;

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        if ((com.google.android.gms.internal.ads.zzov.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzlc(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzoh.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzbac = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L_0x002a
            if (r4 == 0) goto L_0x002a
            int r5 = com.google.android.gms.internal.ads.zzov.SDK_INT
            r0 = 19
            if (r5 < r0) goto L_0x0025
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            if (r5 == 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            r1.zzbaa = r5
            r5 = 21
            if (r4 == 0) goto L_0x0044
            int r0 = com.google.android.gms.internal.ads.zzov.SDK_INT
            if (r0 < r5) goto L_0x003f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            r1.zzaku = r0
            if (r6 != 0) goto L_0x005e
            if (r4 == 0) goto L_0x005d
            int r6 = com.google.android.gms.internal.ads.zzov.SDK_INT
            if (r6 < r5) goto L_0x0059
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x0059
            r4 = 1
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            r1.zzbab = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static zzlc zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzlc(str, str2, codecCapabilities, z, z2);
    }

    @TargetApi(21)
    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    public static zzlc zzaz(String str) {
        return new zzlc(str, (String) null, (MediaCodecInfo.CodecCapabilities) null, false, false);
    }

    private final void zzbb(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzov.zzbhv;
        StringBuilder b = C0681a.m337b(C0681a.m336b(str4, C0681a.m336b(str3, C0681a.m336b(str2, C0681a.m336b(str, 20)))), "NoSupport [", str, "] [", str2);
        C0681a.m335a(b, ", ", str3, "] [", str4);
        b.append("]");
        Log.d("MediaCodecInfo", b.toString());
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbac;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "sizeAndRate.vCaps";
            } else if (zza(videoCapabilities, i, i2, d)) {
                return true;
            } else {
                if (i >= i2 || !zza(videoCapabilities, i2, i, d)) {
                    StringBuilder sb = new StringBuilder(69);
                    sb.append("sizeAndRate.support, ");
                    sb.append(i);
                    sb.append("x");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(d);
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder(69);
                    sb2.append("sizeAndRate.rotated, ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                    sb2.append("x");
                    sb2.append(d);
                    String sb3 = sb2.toString();
                    String str2 = this.name;
                    String str3 = this.mimeType;
                    String str4 = zzov.zzbhv;
                    StringBuilder b = C0681a.m337b(C0681a.m336b(str4, C0681a.m336b(str3, C0681a.m336b(str2, C0681a.m336b(sb3, 25)))), "AssumedSupport [", sb3, "] [", str2);
                    C0681a.m335a(b, ", ", str3, "] [", str4);
                    b.append("]");
                    Log.d("MediaCodecInfo", b.toString());
                    return true;
                }
            }
        }
        zzbb(str);
        return false;
    }

    @TargetApi(21)
    public final boolean zzas(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbac;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else if (audioCapabilities.isSampleRateSupported(i)) {
                return true;
            } else {
                str = C0681a.m309a(31, "sampleRate.support, ", i);
            }
        }
        zzbb(str);
        return false;
    }

    @TargetApi(21)
    public final boolean zzat(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbac;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
                return true;
            } else {
                str = C0681a.m309a(33, "channelCount.support, ", i);
            }
        }
        zzbb(str);
        return false;
    }

    public final boolean zzba(String str) {
        String str2;
        StringBuilder sb;
        if (str == null || this.mimeType == null) {
            return true;
        }
        String trim = str.trim();
        String str3 = (trim.startsWith("avc1") || trim.startsWith("avc3")) ? "video/avc" : (trim.startsWith("hev1") || trim.startsWith("hvc1")) ? "video/hevc" : trim.startsWith("vp9") ? "video/x-vnd.on2.vp9" : trim.startsWith("vp8") ? "video/x-vnd.on2.vp8" : trim.startsWith("mp4a") ? "audio/mp4a-latm" : (trim.startsWith("ac-3") || trim.startsWith("dac3")) ? "audio/ac3" : (trim.startsWith("ec-3") || trim.startsWith("dec3")) ? "audio/eac3" : (trim.startsWith("dtsc") || trim.startsWith("dtse")) ? "audio/vnd.dts" : (trim.startsWith("dtsh") || trim.startsWith("dtsl")) ? "audio/vnd.dts.hd" : trim.startsWith("opus") ? "audio/opus" : trim.startsWith("vorbis") ? "audio/vorbis" : null;
        if (str3 == null) {
            return true;
        }
        if (!this.mimeType.equals(str3)) {
            sb = new StringBuilder(str3.length() + str.length() + 13);
            str2 = "codec.mime ";
        } else {
            Pair<Integer, Integer> zzbc = zzlf.zzbc(str);
            if (zzbc == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzhh()) {
                if (codecProfileLevel.profile == ((Integer) zzbc.first).intValue() && codecProfileLevel.level >= ((Integer) zzbc.second).intValue()) {
                    return true;
                }
            }
            sb = new StringBuilder(str3.length() + str.length() + 22);
            str2 = "codec.profileLevel, ";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        zzbb(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final Point zzd(int i, int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbac;
        if (codecCapabilities == null) {
            str = "align.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "align.vCaps";
            } else {
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                return new Point(zzov.zzf(i, widthAlignment) * widthAlignment, zzov.zzf(i2, heightAlignment) * heightAlignment);
            }
        }
        zzbb(str);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.MediaCodecInfo.CodecProfileLevel[] zzhh() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.zzbac
            if (r0 == 0) goto L_0x000a
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.zzhh():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }
}
