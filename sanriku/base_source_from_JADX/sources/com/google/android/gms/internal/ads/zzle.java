package com.google.android.gms.internal.ads;

public final class zzle extends Exception {
    private final String mimeType;
    private final boolean zzbae;
    private final String zzbaf;
    private final String zzbag;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzle(com.google.android.gms.internal.ads.zzhf r3, java.lang.Throwable r4, boolean r5, int r6) {
        /*
            r2 = this;
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r0 = r5.length()
            int r0 = r0 + 36
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Decoder init failed: ["
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = "], "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r2.<init>(r5, r4)
            java.lang.String r3 = r3.zzagi
            r2.mimeType = r3
            r3 = 0
            r2.zzbae = r3
            r3 = 0
            r2.zzbaf = r3
            if (r6 >= 0) goto L_0x0035
            java.lang.String r3 = "neg_"
            goto L_0x0037
        L_0x0035:
            java.lang.String r3 = ""
        L_0x0037:
            int r4 = java.lang.Math.abs(r6)
            int r5 = r3.length()
            int r5 = r5 + 64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "com.google.android.exoplayer.MediaCodecTrackRenderer_"
            r6.append(r5)
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            r2.zzbag = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzle.<init>(com.google.android.gms.internal.ads.zzhf, java.lang.Throwable, boolean, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzle(com.google.android.gms.internal.ads.zzhf r4, java.lang.Throwable r5, boolean r6, java.lang.String r7) {
        /*
            r3 = this;
            java.lang.String r6 = java.lang.String.valueOf(r4)
            r0 = 23
            int r0 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r7, (int) r0)
            int r1 = r6.length()
            int r1 = r1 + r0
            java.lang.String r0 = "Decoder init failed: "
            java.lang.String r2 = ", "
            java.lang.String r6 = p009e.p010a.p011a.p012a.C0681a.m314a((int) r1, (java.lang.String) r0, (java.lang.String) r7, (java.lang.String) r2, (java.lang.String) r6)
            r3.<init>(r6, r5)
            java.lang.String r4 = r4.zzagi
            r3.mimeType = r4
            r4 = 0
            r3.zzbae = r4
            r3.zzbaf = r7
            int r4 = com.google.android.gms.internal.ads.zzov.SDK_INT
            r6 = 0
            r7 = 21
            if (r4 < r7) goto L_0x0034
            boolean r4 = r5 instanceof android.media.MediaCodec.CodecException
            if (r4 == 0) goto L_0x0034
            android.media.MediaCodec$CodecException r5 = (android.media.MediaCodec.CodecException) r5
            java.lang.String r6 = r5.getDiagnosticInfo()
        L_0x0034:
            r3.zzbag = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzle.<init>(com.google.android.gms.internal.ads.zzhf, java.lang.Throwable, boolean, java.lang.String):void");
    }
}
