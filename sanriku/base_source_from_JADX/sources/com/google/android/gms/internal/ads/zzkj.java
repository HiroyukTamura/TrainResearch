package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzln;
import java.util.ArrayList;
import java.util.List;

final class zzkj {
    private static final int zzavb = zzov.zzbj("meta");
    private static final int zzavp = zzov.zzbj("vide");
    private static final int zzavq = zzov.zzbj("soun");
    private static final int zzavr = zzov.zzbj("text");
    private static final int zzavs = zzov.zzbj("sbtl");
    private static final int zzavt = zzov.zzbj("subt");
    private static final int zzavu = zzov.zzbj("clcp");
    private static final int zzavv = zzov.zzbj("cenc");

    private static int zza(zzos zzos, int i, int i2, zzko zzko, int i3) {
        zzos zzos2 = zzos;
        int position = zzos.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzos.zzbi(position);
            int readInt = zzos.readInt();
            zzoh.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzos.readInt() == zzki.zzatv) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzla zzla = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzos.zzbi(i4);
                    int readInt2 = zzos.readInt();
                    int readInt3 = zzos.readInt();
                    if (readInt3 == zzki.zzaub) {
                        num = Integer.valueOf(zzos.readInt());
                    } else if (readInt3 == zzki.zzatw) {
                        zzos.zzbj(4);
                        z2 = zzos.readInt() == zzavv;
                    } else if (readInt3 == zzki.zzatx) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzla = null;
                                break;
                            }
                            zzos.zzbi(i5);
                            int readInt4 = zzos.readInt();
                            if (zzos.readInt() == zzki.zzaty) {
                                zzos.zzbj(6);
                                boolean z3 = zzos.readUnsignedByte() == 1;
                                int readUnsignedByte = zzos.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzos.zze(bArr, 0, 16);
                                zzla = new zzla(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzoh.checkArgument(num != null, "frma atom is mandatory");
                    if (zzla != null) {
                        z = true;
                    }
                    zzoh.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzla);
                }
                if (pair != null) {
                    zzko.zzawg[i3] = (zzla) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzko zzko2 = zzko;
            position += readInt;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0495: MOVE  (r10v11 java.lang.String) = (r25v11 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public static com.google.android.gms.internal.ads.zzkx zza(com.google.android.gms.internal.ads.zzkh r50, com.google.android.gms.internal.ads.zzkk r51, long r52, com.google.android.gms.internal.ads.zzja r54, boolean r55) throws com.google.android.gms.internal.ads.zzhi {
        /*
            r0 = r50
            int r1 = com.google.android.gms.internal.ads.zzki.zzate
            com.google.android.gms.internal.ads.zzkh r1 = r0.zzao(r1)
            int r2 = com.google.android.gms.internal.ads.zzki.zzats
            com.google.android.gms.internal.ads.zzkk r2 = r1.zzan(r2)
            com.google.android.gms.internal.ads.zzos r2 = r2.zzavw
            r3 = 16
            r2.zzbi(r3)
            int r2 = r2.readInt()
            int r4 = zzavq
            r5 = 4
            r6 = 3
            r8 = -1
            if (r2 != r4) goto L_0x0022
            r12 = 1
            goto L_0x0042
        L_0x0022:
            int r4 = zzavp
            if (r2 != r4) goto L_0x0028
            r12 = 2
            goto L_0x0042
        L_0x0028:
            int r4 = zzavr
            if (r2 == r4) goto L_0x0041
            int r4 = zzavs
            if (r2 == r4) goto L_0x0041
            int r4 = zzavt
            if (r2 == r4) goto L_0x0041
            int r4 = zzavu
            if (r2 != r4) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            int r4 = zzavb
            if (r2 != r4) goto L_0x003f
            r12 = 4
            goto L_0x0042
        L_0x003f:
            r12 = -1
            goto L_0x0042
        L_0x0041:
            r12 = 3
        L_0x0042:
            r2 = 0
            if (r12 != r8) goto L_0x0046
            return r2
        L_0x0046:
            int r4 = com.google.android.gms.internal.ads.zzki.zzato
            com.google.android.gms.internal.ads.zzkk r4 = r0.zzan(r4)
            com.google.android.gms.internal.ads.zzos r4 = r4.zzavw
            r10 = 8
            r4.zzbi(r10)
            int r11 = r4.readInt()
            int r11 = com.google.android.gms.internal.ads.zzki.zzap(r11)
            if (r11 != 0) goto L_0x0060
            r13 = 8
            goto L_0x0062
        L_0x0060:
            r13 = 16
        L_0x0062:
            r4.zzbj(r13)
            int r13 = r4.readInt()
            r4.zzbj(r5)
            int r14 = r4.getPosition()
            if (r11 != 0) goto L_0x0074
            r15 = 4
            goto L_0x0076
        L_0x0074:
            r15 = 8
        L_0x0076:
            r9 = 0
        L_0x0077:
            if (r9 >= r15) goto L_0x0086
            byte[] r7 = r4.data
            int r16 = r14 + r9
            byte r7 = r7[r16]
            if (r7 == r8) goto L_0x0083
            r7 = 0
            goto L_0x0087
        L_0x0083:
            int r9 = r9 + 1
            goto L_0x0077
        L_0x0086:
            r7 = 1
        L_0x0087:
            r16 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 == 0) goto L_0x0096
            r4.zzbj(r15)
        L_0x0093:
            r14 = r18
            goto L_0x00a6
        L_0x0096:
            if (r11 != 0) goto L_0x009d
            long r14 = r4.zzjb()
            goto L_0x00a1
        L_0x009d:
            long r14 = r4.zzjf()
        L_0x00a1:
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 != 0) goto L_0x00a6
            goto L_0x0093
        L_0x00a6:
            r4.zzbj(r3)
            int r7 = r4.readInt()
            int r9 = r4.readInt()
            r4.zzbj(r5)
            int r11 = r4.readInt()
            int r4 = r4.readInt()
            r5 = 65536(0x10000, float:9.18355E-41)
            r3 = -65536(0xffffffffffff0000, float:NaN)
            if (r7 != 0) goto L_0x00cb
            if (r9 != r5) goto L_0x00cb
            if (r11 != r3) goto L_0x00cb
            if (r4 != 0) goto L_0x00cb
            r3 = 90
            goto L_0x00e2
        L_0x00cb:
            if (r7 != 0) goto L_0x00d6
            if (r9 != r3) goto L_0x00d6
            if (r11 != r5) goto L_0x00d6
            if (r4 != 0) goto L_0x00d6
            r3 = 270(0x10e, float:3.78E-43)
            goto L_0x00e2
        L_0x00d6:
            if (r7 != r3) goto L_0x00e1
            if (r9 != 0) goto L_0x00e1
            if (r11 != 0) goto L_0x00e1
            if (r4 != r3) goto L_0x00e1
            r3 = 180(0xb4, float:2.52E-43)
            goto L_0x00e2
        L_0x00e1:
            r3 = 0
        L_0x00e2:
            com.google.android.gms.internal.ads.zzkp r4 = new com.google.android.gms.internal.ads.zzkp
            r4.<init>(r13, r14, r3)
            long r22 = r4.zzcw
            r3 = r51
            com.google.android.gms.internal.ads.zzos r3 = r3.zzavw
            r3.zzbi(r10)
            int r5 = r3.readInt()
            int r5 = com.google.android.gms.internal.ads.zzki.zzap(r5)
            if (r5 != 0) goto L_0x00ff
            r5 = 8
            goto L_0x0101
        L_0x00ff:
            r5 = 16
        L_0x0101:
            r3.zzbj(r5)
            long r28 = r3.zzjb()
            int r3 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r3 != 0) goto L_0x010d
            goto L_0x0118
        L_0x010d:
            r24 = 1000000(0xf4240, double:4.940656E-318)
            r26 = r28
            long r13 = com.google.android.gms.internal.ads.zzov.zza((long) r22, (long) r24, (long) r26)
            r18 = r13
        L_0x0118:
            int r3 = com.google.android.gms.internal.ads.zzki.zzatf
            com.google.android.gms.internal.ads.zzkh r3 = r1.zzao(r3)
            int r5 = com.google.android.gms.internal.ads.zzki.zzatg
            com.google.android.gms.internal.ads.zzkh r3 = r3.zzao(r5)
            int r5 = com.google.android.gms.internal.ads.zzki.zzatr
            com.google.android.gms.internal.ads.zzkk r1 = r1.zzan(r5)
            com.google.android.gms.internal.ads.zzos r1 = r1.zzavw
            r1.zzbi(r10)
            int r5 = r1.readInt()
            int r5 = com.google.android.gms.internal.ads.zzki.zzap(r5)
            if (r5 != 0) goto L_0x013c
            r7 = 8
            goto L_0x013e
        L_0x013c:
            r7 = 16
        L_0x013e:
            r1.zzbj(r7)
            long r13 = r1.zzjb()
            if (r5 != 0) goto L_0x0149
            r5 = 4
            goto L_0x014b
        L_0x0149:
            r5 = 8
        L_0x014b:
            r1.zzbj(r5)
            int r1 = r1.readUnsignedShort()
            int r5 = r1 >> 10
            r5 = r5 & 31
            int r5 = r5 + 96
            char r5 = (char) r5
            int r7 = r1 >> 5
            r7 = r7 & 31
            int r7 = r7 + 96
            char r7 = (char) r7
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r6)
            r9.append(r5)
            r9.append(r7)
            r9.append(r1)
            java.lang.String r1 = r9.toString()
            java.lang.Long r5 = java.lang.Long.valueOf(r13)
            android.util.Pair r1 = android.util.Pair.create(r5, r1)
            int r5 = com.google.android.gms.internal.ads.zzki.zzatt
            com.google.android.gms.internal.ads.zzkk r3 = r3.zzan(r5)
            com.google.android.gms.internal.ads.zzos r3 = r3.zzavw
            int r5 = r4.f360id
            int r7 = r4.zzagn
            java.lang.Object r9 = r1.second
            java.lang.String r9 = (java.lang.String) r9
            r11 = 12
            r3.zzbi(r11)
            int r11 = r3.readInt()
            com.google.android.gms.internal.ads.zzko r13 = new com.google.android.gms.internal.ads.zzko
            r13.<init>(r11)
            r14 = 0
        L_0x01a2:
            if (r14 >= r11) goto L_0x0672
            int r15 = r3.getPosition()
            int r6 = r3.readInt()
            if (r6 <= 0) goto L_0x01b0
            r10 = 1
            goto L_0x01b1
        L_0x01b0:
            r10 = 0
        L_0x01b1:
            java.lang.String r2 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzoh.checkArgument(r10, r2)
            int r10 = r3.readInt()
            int r8 = com.google.android.gms.internal.ads.zzki.zzasb
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzasc
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzatz
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzaul
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzasd
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzase
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzasf
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzavk
            if (r10 == r8) goto L_0x04cd
            int r8 = com.google.android.gms.internal.ads.zzki.zzavl
            if (r10 != r8) goto L_0x01e0
            goto L_0x04cd
        L_0x01e0:
            int r8 = com.google.android.gms.internal.ads.zzki.zzasi
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzaua
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasn
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasp
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasr
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasu
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzass
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzast
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzauy
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzauz
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasl
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasm
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzasj
            if (r10 == r8) goto L_0x02b6
            int r8 = com.google.android.gms.internal.ads.zzki.zzavo
            if (r10 != r8) goto L_0x021a
            goto L_0x02b6
        L_0x021a:
            int r2 = com.google.android.gms.internal.ads.zzki.zzauj
            if (r10 == r2) goto L_0x0247
            int r2 = com.google.android.gms.internal.ads.zzki.zzauu
            if (r10 == r2) goto L_0x0247
            int r2 = com.google.android.gms.internal.ads.zzki.zzauv
            if (r10 == r2) goto L_0x0247
            int r2 = com.google.android.gms.internal.ads.zzki.zzauw
            if (r10 == r2) goto L_0x0247
            int r2 = com.google.android.gms.internal.ads.zzki.zzaux
            if (r10 != r2) goto L_0x022f
            goto L_0x0247
        L_0x022f:
            int r2 = com.google.android.gms.internal.ads.zzki.zzavn
            if (r10 != r2) goto L_0x0243
            java.lang.String r2 = java.lang.Integer.toString(r5)
            java.lang.String r8 = "application/x-camera-motion"
            r51 = r11
            r10 = -1
            r11 = 0
            com.google.android.gms.internal.ads.zzhf r2 = com.google.android.gms.internal.ads.zzhf.zza(r2, r8, r11, r10, r11)
            goto L_0x02ad
        L_0x0243:
            r51 = r11
            goto L_0x02f9
        L_0x0247:
            r51 = r11
            int r2 = r15 + 8
            r8 = 8
            int r2 = r2 + r8
            r3.zzbi(r2)
            r25 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = com.google.android.gms.internal.ads.zzki.zzauj
            java.lang.String r11 = "application/ttml+xml"
            if (r10 != r2) goto L_0x0263
            r31 = r11
        L_0x025e:
            r38 = r25
        L_0x0260:
            r40 = 0
            goto L_0x0299
        L_0x0263:
            int r2 = com.google.android.gms.internal.ads.zzki.zzauu
            if (r10 != r2) goto L_0x027d
            int r2 = r6 + -8
            int r2 = r2 - r8
            byte[] r8 = new byte[r2]
            r10 = 0
            r3.zze(r8, r10, r2)
            java.util.List r2 = java.util.Collections.singletonList(r8)
            java.lang.String r8 = "application/x-quicktime-tx3g"
            r40 = r2
            r31 = r8
            r38 = r25
            goto L_0x0299
        L_0x027d:
            int r2 = com.google.android.gms.internal.ads.zzki.zzauv
            if (r10 != r2) goto L_0x0286
            java.lang.String r2 = "application/x-mp4-vtt"
        L_0x0283:
            r31 = r2
            goto L_0x025e
        L_0x0286:
            int r2 = com.google.android.gms.internal.ads.zzki.zzauw
            if (r10 != r2) goto L_0x028f
            r31 = r11
            r38 = r16
            goto L_0x0260
        L_0x028f:
            int r2 = com.google.android.gms.internal.ads.zzki.zzaux
            if (r10 != r2) goto L_0x02b0
            r2 = 1
            r13.zzawh = r2
            java.lang.String r2 = "application/x-mp4-cea-608"
            goto L_0x0283
        L_0x0299:
            java.lang.String r30 = java.lang.Integer.toString(r5)
            r32 = 0
            r33 = -1
            r34 = 0
            r36 = -1
            r37 = 0
            r35 = r9
            com.google.android.gms.internal.ads.zzhf r2 = com.google.android.gms.internal.ads.zzhf.zza(r30, r31, r32, r33, r34, r35, r36, r37, r38, r40)
        L_0x02ad:
            r13.zzahd = r2
            goto L_0x02f9
        L_0x02b0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02b6:
            r51 = r11
            int r8 = r15 + 8
            r11 = 8
            int r8 = r8 + r11
            r3.zzbi(r8)
            r8 = 6
            if (r55 == 0) goto L_0x02cd
            int r22 = r3.readUnsignedShort()
            r3.zzbj(r8)
            r11 = r22
            goto L_0x02d1
        L_0x02cd:
            r3.zzbj(r11)
            r11 = 0
        L_0x02d1:
            if (r11 == 0) goto L_0x0304
            r8 = 1
            if (r11 != r8) goto L_0x02d7
            goto L_0x0304
        L_0x02d7:
            r8 = 2
            if (r11 != r8) goto L_0x02f9
            r8 = 16
            r3.zzbj(r8)
            long r25 = r3.readLong()
            double r25 = java.lang.Double.longBitsToDouble(r25)
            r8 = r12
            long r11 = java.lang.Math.round(r25)
            int r12 = (int) r11
            int r11 = r3.zzje()
            r25 = r11
            r11 = 20
            r3.zzbj(r11)
            goto L_0x0321
        L_0x02f9:
            r46 = r1
            r47 = r4
            r48 = r7
            r45 = r12
        L_0x0301:
            r1 = 3
            goto L_0x0659
        L_0x0304:
            r8 = r12
            int r12 = r3.readUnsignedShort()
            r26 = r12
            r12 = 6
            r3.zzbj(r12)
            int r12 = r3.zzjd()
            r25 = r12
            r12 = 1
            if (r11 != r12) goto L_0x031d
            r11 = 16
            r3.zzbj(r11)
        L_0x031d:
            r12 = r25
            r25 = r26
        L_0x0321:
            int r11 = r3.getPosition()
            r26 = r12
            int r12 = com.google.android.gms.internal.ads.zzki.zzaua
            if (r10 != r12) goto L_0x0332
            int r10 = zza((com.google.android.gms.internal.ads.zzos) r3, (int) r15, (int) r6, (com.google.android.gms.internal.ads.zzko) r13, (int) r14)
            r3.zzbi(r11)
        L_0x0332:
            int r12 = com.google.android.gms.internal.ads.zzki.zzasn
            r27 = r11
            java.lang.String r11 = "audio/raw"
            if (r10 != r12) goto L_0x033d
            java.lang.String r10 = "audio/ac3"
            goto L_0x0386
        L_0x033d:
            int r12 = com.google.android.gms.internal.ads.zzki.zzasp
            if (r10 != r12) goto L_0x0344
            java.lang.String r10 = "audio/eac3"
            goto L_0x0386
        L_0x0344:
            int r12 = com.google.android.gms.internal.ads.zzki.zzasr
            if (r10 != r12) goto L_0x034b
            java.lang.String r10 = "audio/vnd.dts"
            goto L_0x0386
        L_0x034b:
            int r12 = com.google.android.gms.internal.ads.zzki.zzass
            if (r10 == r12) goto L_0x0384
            int r12 = com.google.android.gms.internal.ads.zzki.zzast
            if (r10 != r12) goto L_0x0354
            goto L_0x0384
        L_0x0354:
            int r12 = com.google.android.gms.internal.ads.zzki.zzasu
            if (r10 != r12) goto L_0x035b
            java.lang.String r10 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0386
        L_0x035b:
            int r12 = com.google.android.gms.internal.ads.zzki.zzauy
            if (r10 != r12) goto L_0x0362
            java.lang.String r10 = "audio/3gpp"
            goto L_0x0386
        L_0x0362:
            int r12 = com.google.android.gms.internal.ads.zzki.zzauz
            if (r10 != r12) goto L_0x0369
            java.lang.String r10 = "audio/amr-wb"
            goto L_0x0386
        L_0x0369:
            int r12 = com.google.android.gms.internal.ads.zzki.zzasl
            if (r10 == r12) goto L_0x0382
            int r12 = com.google.android.gms.internal.ads.zzki.zzasm
            if (r10 != r12) goto L_0x0372
            goto L_0x0382
        L_0x0372:
            int r12 = com.google.android.gms.internal.ads.zzki.zzasj
            if (r10 != r12) goto L_0x0379
            java.lang.String r10 = "audio/mpeg"
            goto L_0x0386
        L_0x0379:
            int r12 = com.google.android.gms.internal.ads.zzki.zzavo
            if (r10 != r12) goto L_0x0380
            java.lang.String r10 = "audio/alac"
            goto L_0x0386
        L_0x0380:
            r10 = 0
            goto L_0x0386
        L_0x0382:
            r10 = r11
            goto L_0x0386
        L_0x0384:
            java.lang.String r10 = "audio/vnd.dts.hd"
        L_0x0386:
            r45 = r8
            r12 = 0
            r49 = r25
            r25 = r10
            r10 = r27
            r27 = r26
            r26 = r49
        L_0x0393:
            int r8 = r10 - r15
            if (r8 >= r6) goto L_0x048a
            r3.zzbi(r10)
            int r8 = r3.readInt()
            r46 = r1
            if (r8 <= 0) goto L_0x03a4
            r1 = 1
            goto L_0x03a5
        L_0x03a4:
            r1 = 0
        L_0x03a5:
            com.google.android.gms.internal.ads.zzoh.checkArgument(r1, r2)
            int r1 = r3.readInt()
            r47 = r4
            int r4 = com.google.android.gms.internal.ads.zzki.zzatj
            if (r1 == r4) goto L_0x0416
            if (r55 == 0) goto L_0x03b9
            int r4 = com.google.android.gms.internal.ads.zzki.zzask
            if (r1 != r4) goto L_0x03b9
            goto L_0x0416
        L_0x03b9:
            int r4 = com.google.android.gms.internal.ads.zzki.zzaso
            if (r1 != r4) goto L_0x03cf
            int r1 = r10 + 8
            r3.zzbi(r1)
            java.lang.String r1 = java.lang.Integer.toString(r5)
            r4 = 0
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzht.zza(r3, r1, r9, r4)
        L_0x03cb:
            r13.zzahd = r1
        L_0x03cd:
            r4 = 0
            goto L_0x0411
        L_0x03cf:
            int r4 = com.google.android.gms.internal.ads.zzki.zzasq
            if (r1 != r4) goto L_0x03e2
            int r1 = r10 + 8
            r3.zzbi(r1)
            java.lang.String r1 = java.lang.Integer.toString(r5)
            r4 = 0
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzht.zzb(r3, r1, r9, r4)
            goto L_0x03cb
        L_0x03e2:
            int r4 = com.google.android.gms.internal.ads.zzki.zzasv
            if (r1 != r4) goto L_0x0403
            java.lang.String r30 = java.lang.Integer.toString(r5)
            r32 = 0
            r33 = -1
            r34 = -1
            r37 = 0
            r38 = 0
            r39 = 0
            r31 = r25
            r35 = r26
            r36 = r27
            r40 = r9
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzhf.zza(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            goto L_0x03cb
        L_0x0403:
            int r4 = com.google.android.gms.internal.ads.zzki.zzavo
            if (r1 != r4) goto L_0x03cd
            byte[] r1 = new byte[r8]
            r3.zzbi(r10)
            r4 = 0
            r3.zze(r1, r4, r8)
            r12 = r1
        L_0x0411:
            r48 = r7
            r0 = -1
            goto L_0x047f
        L_0x0416:
            int r4 = com.google.android.gms.internal.ads.zzki.zzatj
            if (r1 != r4) goto L_0x041f
            r48 = r7
            r1 = r10
        L_0x041d:
            r0 = -1
            goto L_0x044b
        L_0x041f:
            int r1 = r3.getPosition()
        L_0x0423:
            int r4 = r1 - r10
            if (r4 >= r8) goto L_0x0447
            r3.zzbi(r1)
            int r4 = r3.readInt()
            if (r4 <= 0) goto L_0x0432
            r0 = 1
            goto L_0x0433
        L_0x0432:
            r0 = 0
        L_0x0433:
            com.google.android.gms.internal.ads.zzoh.checkArgument(r0, r2)
            int r0 = r3.readInt()
            r48 = r7
            int r7 = com.google.android.gms.internal.ads.zzki.zzatj
            if (r0 != r7) goto L_0x0441
            goto L_0x041d
        L_0x0441:
            int r1 = r1 + r4
            r0 = r50
            r7 = r48
            goto L_0x0423
        L_0x0447:
            r48 = r7
            r0 = -1
            r1 = -1
        L_0x044b:
            if (r1 == r0) goto L_0x047f
            android.util.Pair r1 = zzb(r3, r1)
            java.lang.Object r4 = r1.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r1 = r1.second
            r12 = r1
            byte[] r12 = (byte[]) r12
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x047d
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzok.zze(r12)
            java.lang.Object r7 = r1.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r26 = r1
            r25 = r4
            r27 = r7
            goto L_0x047f
        L_0x047d:
            r25 = r4
        L_0x047f:
            int r10 = r10 + r8
            r0 = r50
            r1 = r46
            r4 = r47
            r7 = r48
            goto L_0x0393
        L_0x048a:
            r46 = r1
            r47 = r4
            r48 = r7
            r0 = -1
            com.google.android.gms.internal.ads.zzhf r1 = r13.zzahd
            if (r1 != 0) goto L_0x0301
            r10 = r25
            if (r10 == 0) goto L_0x0301
            boolean r1 = r11.equals(r10)
            if (r1 == 0) goto L_0x04a2
            r37 = 2
            goto L_0x04a4
        L_0x04a2:
            r37 = -1
        L_0x04a4:
            java.lang.String r30 = java.lang.Integer.toString(r5)
            r32 = 0
            r33 = -1
            r34 = -1
            if (r12 != 0) goto L_0x04b3
            r38 = 0
            goto L_0x04b9
        L_0x04b3:
            java.util.List r1 = java.util.Collections.singletonList(r12)
            r38 = r1
        L_0x04b9:
            r39 = 0
            r40 = 0
            r31 = r10
            r35 = r26
            r36 = r27
            r41 = r9
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzhf.zza(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r13.zzahd = r1
            goto L_0x0301
        L_0x04cd:
            r46 = r1
            r47 = r4
            r48 = r7
            r51 = r11
            r45 = r12
            r0 = -1
            int r1 = r15 + 8
            r4 = 8
            int r1 = r1 + r4
            r3.zzbi(r1)
            r1 = 16
            r3.zzbj(r1)
            int r35 = r3.readUnsignedShort()
            int r36 = r3.readUnsignedShort()
            r4 = 1065353216(0x3f800000, float:1.0)
            r7 = 50
            r3.zzbj(r7)
            int r7 = r3.getPosition()
            int r8 = com.google.android.gms.internal.ads.zzki.zzatz
            if (r10 != r8) goto L_0x0503
            int r10 = zza((com.google.android.gms.internal.ads.zzos) r3, (int) r15, (int) r6, (com.google.android.gms.internal.ads.zzko) r13, (int) r14)
            r3.zzbi(r7)
        L_0x0503:
            r4 = 0
            r31 = 0
            r38 = 0
            r40 = 1065353216(0x3f800000, float:1.0)
            r41 = 0
            r42 = -1
        L_0x050e:
            int r8 = r7 - r15
            if (r8 >= r6) goto L_0x063e
            r3.zzbi(r7)
            int r8 = r3.getPosition()
            int r11 = r3.readInt()
            if (r11 != 0) goto L_0x0526
            int r12 = r3.getPosition()
            int r12 = r12 - r15
            if (r12 == r6) goto L_0x063e
        L_0x0526:
            if (r11 <= 0) goto L_0x052a
            r12 = 1
            goto L_0x052b
        L_0x052a:
            r12 = 0
        L_0x052b:
            com.google.android.gms.internal.ads.zzoh.checkArgument(r12, r2)
            int r12 = r3.readInt()
            int r0 = com.google.android.gms.internal.ads.zzki.zzath
            if (r12 != r0) goto L_0x0556
            if (r31 != 0) goto L_0x053a
            r0 = 1
            goto L_0x053b
        L_0x053a:
            r0 = 0
        L_0x053b:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            int r8 = r8 + 8
            r3.zzbi(r8)
            com.google.android.gms.internal.ads.zzox r0 = com.google.android.gms.internal.ads.zzox.zzf(r3)
            java.util.List<byte[]> r8 = r0.zzagk
            int r12 = r0.zzart
            r13.zzart = r12
            if (r4 != 0) goto L_0x0553
            float r0 = r0.zzbhm
            r40 = r0
        L_0x0553:
            java.lang.String r31 = "video/avc"
            goto L_0x0573
        L_0x0556:
            int r0 = com.google.android.gms.internal.ads.zzki.zzati
            if (r12 != r0) goto L_0x057a
            if (r31 != 0) goto L_0x055e
            r0 = 1
            goto L_0x055f
        L_0x055e:
            r0 = 0
        L_0x055f:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            int r8 = r8 + 8
            r3.zzbi(r8)
            com.google.android.gms.internal.ads.zzpd r0 = com.google.android.gms.internal.ads.zzpd.zzh(r3)
            java.util.List<byte[]> r8 = r0.zzagk
            int r0 = r0.zzart
            r13.zzart = r0
            java.lang.String r31 = "video/hevc"
        L_0x0573:
            r25 = r2
            r38 = r8
        L_0x0577:
            r1 = 3
            goto L_0x0636
        L_0x057a:
            int r0 = com.google.android.gms.internal.ads.zzki.zzavm
            if (r12 != r0) goto L_0x0592
            if (r31 != 0) goto L_0x0582
            r0 = 1
            goto L_0x0583
        L_0x0582:
            r0 = 0
        L_0x0583:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            int r0 = com.google.android.gms.internal.ads.zzki.zzavk
            if (r10 != r0) goto L_0x058d
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x058f
        L_0x058d:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
        L_0x058f:
            r31 = r0
            goto L_0x05a0
        L_0x0592:
            int r0 = com.google.android.gms.internal.ads.zzki.zzasg
            if (r12 != r0) goto L_0x05a3
            if (r31 != 0) goto L_0x059a
            r0 = 1
            goto L_0x059b
        L_0x059a:
            r0 = 0
        L_0x059b:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            java.lang.String r31 = "video/3gpp"
        L_0x05a0:
            r25 = r2
            goto L_0x0577
        L_0x05a3:
            int r0 = com.google.android.gms.internal.ads.zzki.zzatj
            if (r12 != r0) goto L_0x05c2
            if (r31 != 0) goto L_0x05ab
            r0 = 1
            goto L_0x05ac
        L_0x05ab:
            r0 = 0
        L_0x05ac:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            android.util.Pair r0 = zzb(r3, r8)
            java.lang.Object r8 = r0.first
            r31 = r8
            java.lang.String r31 = (java.lang.String) r31
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            java.util.List r38 = java.util.Collections.singletonList(r0)
            goto L_0x05a0
        L_0x05c2:
            int r0 = com.google.android.gms.internal.ads.zzki.zzaui
            if (r12 != r0) goto L_0x05dc
            int r8 = r8 + 8
            r3.zzbi(r8)
            int r0 = r3.zzje()
            int r4 = r3.zzje()
            float r0 = (float) r0
            float r4 = (float) r4
            float r40 = r0 / r4
            r25 = r2
            r1 = 3
            r4 = 1
            goto L_0x0636
        L_0x05dc:
            int r0 = com.google.android.gms.internal.ads.zzki.zzavi
            if (r12 != r0) goto L_0x060c
            int r0 = r8 + 8
        L_0x05e2:
            int r12 = r0 - r8
            if (r12 >= r11) goto L_0x0605
            r3.zzbi(r0)
            int r12 = r3.readInt()
            int r1 = r3.readInt()
            r25 = r2
            int r2 = com.google.android.gms.internal.ads.zzki.zzavj
            if (r1 != r2) goto L_0x05ff
            byte[] r1 = r3.data
            int r12 = r12 + r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r0, r12)
            goto L_0x0608
        L_0x05ff:
            int r0 = r0 + r12
            r2 = r25
            r1 = 16
            goto L_0x05e2
        L_0x0605:
            r25 = r2
            r0 = 0
        L_0x0608:
            r41 = r0
            goto L_0x0577
        L_0x060c:
            r25 = r2
            int r0 = com.google.android.gms.internal.ads.zzki.zzavh
            if (r12 != r0) goto L_0x0577
            int r0 = r3.readUnsignedByte()
            r1 = 3
            r3.zzbj(r1)
            if (r0 != 0) goto L_0x0636
            int r0 = r3.readUnsignedByte()
            if (r0 == 0) goto L_0x0634
            r2 = 1
            if (r0 == r2) goto L_0x0631
            r2 = 2
            if (r0 == r2) goto L_0x062e
            if (r0 == r1) goto L_0x062b
            goto L_0x0636
        L_0x062b:
            r42 = 3
            goto L_0x0636
        L_0x062e:
            r42 = 2
            goto L_0x0636
        L_0x0631:
            r42 = 1
            goto L_0x0636
        L_0x0634:
            r42 = 0
        L_0x0636:
            int r7 = r7 + r11
            r2 = r25
            r0 = -1
            r1 = 16
            goto L_0x050e
        L_0x063e:
            r1 = 3
            if (r31 == 0) goto L_0x0659
            java.lang.String r30 = java.lang.Integer.toString(r5)
            r32 = 0
            r33 = -1
            r34 = -1
            r37 = -1082130432(0xffffffffbf800000, float:-1.0)
            r43 = 0
            r44 = 0
            r39 = r48
            com.google.android.gms.internal.ads.zzhf r0 = com.google.android.gms.internal.ads.zzhf.zza(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r13.zzahd = r0
        L_0x0659:
            int r15 = r15 + r6
            r3.zzbi(r15)
            int r14 = r14 + 1
            r0 = r50
            r11 = r51
            r12 = r45
            r1 = r46
            r4 = r47
            r7 = r48
            r2 = 0
            r6 = 3
            r8 = -1
            r10 = 8
            goto L_0x01a2
        L_0x0672:
            r46 = r1
            r47 = r4
            r45 = r12
            int r0 = com.google.android.gms.internal.ads.zzki.zzatp
            r1 = r50
            com.google.android.gms.internal.ads.zzkh r0 = r1.zzao(r0)
            if (r0 == 0) goto L_0x06dd
            int r1 = com.google.android.gms.internal.ads.zzki.zzatq
            com.google.android.gms.internal.ads.zzkk r0 = r0.zzan(r1)
            if (r0 != 0) goto L_0x068b
            goto L_0x06dd
        L_0x068b:
            com.google.android.gms.internal.ads.zzos r0 = r0.zzavw
            r1 = 8
            r0.zzbi(r1)
            int r1 = r0.readInt()
            int r1 = com.google.android.gms.internal.ads.zzki.zzap(r1)
            int r2 = r0.zzje()
            long[] r3 = new long[r2]
            long[] r4 = new long[r2]
            r7 = 0
        L_0x06a3:
            if (r7 >= r2) goto L_0x06d6
            r5 = 1
            if (r1 != r5) goto L_0x06ad
            long r8 = r0.zzjf()
            goto L_0x06b1
        L_0x06ad:
            long r8 = r0.zzjb()
        L_0x06b1:
            r3[r7] = r8
            if (r1 != r5) goto L_0x06ba
            long r8 = r0.readLong()
            goto L_0x06bf
        L_0x06ba:
            int r6 = r0.readInt()
            long r8 = (long) r6
        L_0x06bf:
            r4[r7] = r8
            short r6 = r0.readShort()
            if (r6 != r5) goto L_0x06ce
            r6 = 2
            r0.zzbj(r6)
            int r7 = r7 + 1
            goto L_0x06a3
        L_0x06ce:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x06d6:
            android.util.Pair r0 = android.util.Pair.create(r3, r4)
            r1 = r0
            r0 = 0
            goto L_0x06e2
        L_0x06dd:
            r0 = 0
            android.util.Pair r1 = android.util.Pair.create(r0, r0)
        L_0x06e2:
            com.google.android.gms.internal.ads.zzhf r2 = r13.zzahd
            if (r2 != 0) goto L_0x06e7
            return r0
        L_0x06e7:
            com.google.android.gms.internal.ads.zzkx r0 = new com.google.android.gms.internal.ads.zzkx
            int r11 = r47.f360id
            r2 = r46
            java.lang.Object r2 = r2.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            com.google.android.gms.internal.ads.zzhf r4 = r13.zzahd
            int r5 = r13.zzawh
            com.google.android.gms.internal.ads.zzla[] r6 = r13.zzawg
            int r7 = r13.zzart
            java.lang.Object r8 = r1.first
            r23 = r8
            long[] r23 = (long[]) r23
            java.lang.Object r1 = r1.second
            r24 = r1
            long[] r24 = (long[]) r24
            r10 = r0
            r12 = r45
            r13 = r2
            r15 = r28
            r17 = r18
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r10.<init>(r11, r12, r13, r15, r17, r19, r20, r21, r22, r23, r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkj.zza(com.google.android.gms.internal.ads.zzkh, com.google.android.gms.internal.ads.zzkk, long, com.google.android.gms.internal.ads.zzja, boolean):com.google.android.gms.internal.ads.zzkx");
    }

    public static zzkz zza(zzkx zzkx, zzkh zzkh, zzjq zzjq) throws zzhi {
        zzkl zzkl;
        boolean z;
        int i;
        int i2;
        long j;
        int i3;
        int[] iArr;
        int i4;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        zzkx zzkx2;
        long j2;
        long[] jArr3;
        boolean z2;
        long[] jArr4;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int i5;
        int i6;
        int i7;
        int i8;
        zzkx zzkx3 = zzkx;
        zzkh zzkh2 = zzkh;
        zzjq zzjq2 = zzjq;
        zzkk zzan = zzkh2.zzan(zzki.zzauq);
        if (zzan != null) {
            zzkl = new zzkn(zzan);
        } else {
            zzkk zzan2 = zzkh2.zzan(zzki.zzaur);
            if (zzan2 != null) {
                zzkl = new zzkq(zzan2);
            } else {
                throw new zzhi("Track has no sample table size information");
            }
        }
        int zzgw = zzkl.zzgw();
        if (zzgw == 0) {
            return new zzkz(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzkk zzan3 = zzkh2.zzan(zzki.zzaus);
        if (zzan3 == null) {
            zzan3 = zzkh2.zzan(zzki.zzaut);
            z = true;
        } else {
            z = false;
        }
        zzos zzos = zzan3.zzavw;
        zzos zzos2 = zzkh2.zzan(zzki.zzaup).zzavw;
        zzos zzos3 = zzkh2.zzan(zzki.zzaum).zzavw;
        zzkk zzan4 = zzkh2.zzan(zzki.zzaun);
        zzos zzos4 = null;
        zzos zzos5 = zzan4 != null ? zzan4.zzavw : null;
        zzkk zzan5 = zzkh2.zzan(zzki.zzauo);
        zzos zzos6 = zzan5 != null ? zzan5.zzavw : null;
        zzkm zzkm = new zzkm(zzos2, zzos, z);
        zzos3.zzbi(12);
        int zzje = zzos3.zzje() - 1;
        int zzje2 = zzos3.zzje();
        int zzje3 = zzos3.zzje();
        if (zzos6 != null) {
            zzos6.zzbi(12);
            i = zzos6.zzje();
        } else {
            i = 0;
        }
        int i9 = -1;
        if (zzos5 != null) {
            zzos5.zzbi(12);
            i2 = zzos5.zzje();
            if (i2 > 0) {
                i9 = zzos5.zzje() - 1;
                zzos4 = zzos5;
            }
        } else {
            zzos4 = zzos5;
            i2 = 0;
        }
        long j3 = 0;
        if (!(zzkl.zzgy() && "audio/raw".equals(zzkx3.zzahd.zzagi) && zzje == 0 && i == 0 && i2 == 0)) {
            long[] jArr5 = new long[zzgw];
            iArr = new int[zzgw];
            jArr = new long[zzgw];
            int i10 = i2;
            iArr2 = new int[zzgw];
            zzos zzos7 = zzos3;
            int i11 = i9;
            long j4 = 0;
            j = 0;
            int i12 = 0;
            i4 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = i;
            int i17 = zzje3;
            int i18 = zzje2;
            int i19 = zzje;
            int i20 = i10;
            while (i12 < zzgw) {
                while (i14 == 0) {
                    zzoh.checkState(zzkm.zzgz());
                    j4 = zzkm.zzavy;
                    i14 = zzkm.zzavx;
                    i17 = i17;
                    i18 = i18;
                }
                int i21 = i18;
                int i22 = i17;
                if (zzos6 != null) {
                    while (i13 == 0 && i16 > 0) {
                        i13 = zzos6.zzje();
                        i15 = zzos6.readInt();
                        i16--;
                    }
                    i13--;
                }
                int i23 = i15;
                jArr5[i12] = j4;
                iArr[i12] = zzkl.zzgx();
                if (iArr[i12] > i4) {
                    i4 = iArr[i12];
                }
                int i24 = zzgw;
                zzkl zzkl2 = zzkl;
                jArr[i12] = j + ((long) i23);
                iArr2[i12] = zzos4 == null ? 1 : 0;
                if (i12 == i11) {
                    iArr2[i12] = 1;
                    i20--;
                    if (i20 > 0) {
                        i11 = zzos4.zzje() - 1;
                    }
                }
                int i25 = i22;
                long[] jArr6 = jArr5;
                j += (long) i25;
                int i26 = i21 - 1;
                if (i26 != 0 || i19 <= 0) {
                    int i27 = i26;
                    i7 = i25;
                    i8 = i27;
                } else {
                    i8 = zzos7.zzje();
                    i7 = zzos7.zzje();
                    i19--;
                }
                int i28 = i8;
                j4 += (long) iArr[i12];
                i14--;
                i12++;
                zzgw = i24;
                jArr5 = jArr6;
                i11 = i11;
                i15 = i23;
                i18 = i28;
                zzkl zzkl3 = zzkl2;
                i17 = i7;
                zzkl = zzkl3;
            }
            i3 = zzgw;
            long[] jArr7 = jArr5;
            int i29 = i18;
            zzoh.checkArgument(i13 == 0);
            while (i16 > 0) {
                zzoh.checkArgument(zzos6.zzje() == 0);
                zzos6.readInt();
                i16--;
            }
            if (i20 == 0 && i29 == 0) {
                i6 = i14;
                if (i6 == 0 && i19 == 0) {
                    zzkx2 = zzkx;
                    jArr2 = jArr7;
                }
            } else {
                i6 = i14;
            }
            zzkx2 = zzkx;
            int i30 = zzkx2.f361id;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i30);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i20);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i29);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i6);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i19);
            Log.w("AtomParsers", sb.toString());
            jArr2 = jArr7;
        } else {
            zzkx2 = zzkx3;
            i3 = zzgw;
            zzkl zzkl4 = zzkl;
            int i31 = zzkm.length;
            long[] jArr8 = new long[i31];
            int[] iArr6 = new int[i31];
            while (zzkm.zzgz()) {
                int i32 = zzkm.index;
                jArr8[i32] = zzkm.zzavy;
                iArr6[i32] = zzkm.zzavx;
            }
            int zzgx = zzkl4.zzgx();
            long j5 = (long) zzje3;
            int i33 = 8192 / zzgx;
            int i34 = 0;
            for (int i35 = 0; i35 < i31; i35++) {
                i34 += zzov.zzf(iArr6[i35], i33);
            }
            long[] jArr9 = new long[i34];
            int[] iArr7 = new int[i34];
            long[] jArr10 = new long[i34];
            int[] iArr8 = new int[i34];
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            while (i36 < i31) {
                int i40 = iArr6[i36];
                long j6 = jArr8[i36];
                int i41 = i40;
                int i42 = i31;
                int i43 = i41;
                while (i43 > 0) {
                    int min = Math.min(i33, i43);
                    jArr9[i38] = j6;
                    iArr7[i38] = zzgx * min;
                    i39 = Math.max(i39, iArr7[i38]);
                    jArr10[i38] = ((long) i37) * j5;
                    iArr8[i38] = 1;
                    j6 += (long) iArr7[i38];
                    i37 += min;
                    i43 -= min;
                    i38++;
                    jArr8 = jArr8;
                    iArr6 = iArr6;
                }
                long[] jArr11 = jArr8;
                int[] iArr9 = iArr6;
                i36++;
                i31 = i42;
            }
            zzkr zzkr = new zzkr(jArr9, iArr7, i39, jArr10, iArr8);
            jArr2 = zzkr.zzany;
            iArr = zzkr.zzanx;
            i4 = zzkr.zzawl;
            jArr = zzkr.zzawm;
            iArr2 = zzkr.zzawn;
            j = 0;
        }
        if (zzkx2.zzayi == null || zzjq.zzgs()) {
            zzov.zza(jArr, 1000000, zzkx2.zzcv);
            return new zzkz(jArr2, iArr, i4, jArr, iArr2);
        }
        long[] jArr12 = zzkx2.zzayi;
        if (jArr12.length == 1 && zzkx2.type == 1 && jArr.length >= 2) {
            long j7 = zzkx2.zzayj[0];
            long zza = zzov.zza(jArr12[0], zzkx2.zzcv, zzkx2.zzayf) + j7;
            if (jArr[0] <= j7 && j7 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j8 = j - zza;
                long zza2 = zzov.zza(j7 - jArr[0], (long) zzkx2.zzahd.zzagt, zzkx2.zzcv);
                long zza3 = zzov.zza(j8, (long) zzkx2.zzahd.zzagt, zzkx2.zzcv);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    int i44 = (int) zza2;
                    zzjq zzjq3 = zzjq;
                    zzjq3.zzagv = i44;
                    zzjq3.zzagw = (int) zza3;
                    zzov.zza(jArr, 1000000, zzkx2.zzcv);
                    return new zzkz(jArr2, iArr, i4, jArr, iArr2);
                }
            }
        }
        long[] jArr13 = zzkx2.zzayi;
        if (jArr13.length == 1) {
            char c = 0;
            if (jArr13[0] == 0) {
                int i45 = 0;
                while (i45 < jArr.length) {
                    jArr[i45] = zzov.zza(jArr[i45] - zzkx2.zzayj[c], 1000000, zzkx2.zzcv);
                    i45++;
                    c = 0;
                }
                return new zzkz(jArr2, iArr, i4, jArr, iArr2);
            }
        }
        boolean z3 = zzkx2.type == 1;
        boolean z4 = false;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        while (true) {
            long[] jArr14 = zzkx2.zzayi;
            j2 = -1;
            if (i48 >= jArr14.length) {
                break;
            }
            int i49 = i4;
            int[] iArr10 = iArr;
            long j9 = zzkx2.zzayj[i48];
            if (j9 != -1) {
                i5 = i49;
                long zza4 = zzov.zza(jArr14[i48], zzkx2.zzcv, zzkx2.zzayf);
                int zzb = zzov.zzb(jArr, j9, true, true);
                int zzb2 = zzov.zzb(jArr, j9 + zza4, z3, false);
                int i50 = (zzb2 - zzb) + i46;
                z4 |= i47 != zzb;
                i46 = i50;
                i47 = zzb2;
            } else {
                i5 = i49;
            }
            i48++;
            iArr = iArr10;
            i4 = i5;
        }
        int i51 = i4;
        int[] iArr11 = iArr;
        boolean z5 = z4 | (i46 != i3);
        long[] jArr15 = z5 ? new long[i46] : jArr2;
        int[] iArr12 = z5 ? new int[i46] : iArr11;
        int i52 = z5 ? 0 : i51;
        int[] iArr13 = z5 ? new int[i46] : iArr2;
        long[] jArr16 = new long[i46];
        int i53 = i52;
        int i54 = 0;
        int i55 = 0;
        while (true) {
            long[] jArr17 = zzkx2.zzayi;
            if (i54 >= jArr17.length) {
                break;
            }
            int[] iArr14 = iArr12;
            int[] iArr15 = iArr13;
            long j10 = zzkx2.zzayj[i54];
            long j11 = jArr17[i54];
            if (j10 != j2) {
                long j12 = zzkx2.zzcv;
                jArr4 = jArr15;
                long[] jArr18 = jArr2;
                int zzb3 = zzov.zzb(jArr, j10, true, true);
                int zzb4 = zzov.zzb(jArr, zzov.zza(j11, j12, zzkx2.zzayf) + j10, z3, false);
                if (z5) {
                    int i56 = zzb4 - zzb3;
                    System.arraycopy(jArr18, zzb3, jArr4, i55, i56);
                    iArr4 = iArr11;
                    int[] iArr16 = iArr14;
                    z2 = z3;
                    iArr3 = iArr16;
                    System.arraycopy(iArr4, zzb3, iArr3, i55, i56);
                    jArr3 = jArr18;
                    iArr5 = iArr15;
                    System.arraycopy(iArr2, zzb3, iArr5, i55, i56);
                } else {
                    iArr4 = iArr11;
                    jArr3 = jArr18;
                    iArr5 = iArr15;
                    int[] iArr17 = iArr14;
                    z2 = z3;
                    iArr3 = iArr17;
                }
                int i57 = i53;
                while (zzb3 < zzb4) {
                    int[] iArr18 = iArr5;
                    int[] iArr19 = iArr4;
                    long j13 = j10;
                    jArr16[i55] = zzov.zza(j3, 1000000, zzkx2.zzayf) + zzov.zza(jArr[zzb3] - j10, 1000000, zzkx2.zzcv);
                    if (z5 && iArr3[i55] > i57) {
                        i57 = iArr19[zzb3];
                    }
                    i55++;
                    zzb3++;
                    iArr4 = iArr19;
                    j10 = j13;
                    iArr5 = iArr18;
                }
                iArr15 = iArr5;
                iArr11 = iArr4;
                i53 = i57;
            } else {
                jArr4 = jArr15;
                jArr3 = jArr2;
                int[] iArr20 = iArr14;
                z2 = z3;
                iArr3 = iArr20;
            }
            j3 += j11;
            i54++;
            iArr12 = iArr3;
            jArr15 = jArr4;
            z3 = z2;
            iArr13 = iArr15;
            jArr2 = jArr3;
            j2 = -1;
        }
        long[] jArr19 = jArr15;
        int[] iArr21 = iArr12;
        int[] iArr22 = iArr13;
        boolean z6 = false;
        for (int i58 = 0; i58 < iArr22.length && !z6; i58++) {
            z6 |= (iArr22[i58] & 1) != 0;
        }
        if (z6) {
            return new zzkz(jArr19, iArr21, i53, jArr16, iArr22);
        }
        throw new zzhi("The edited sample sequence does not contain a sync sample.");
    }

    public static zzln zza(zzkk zzkk, boolean z) {
        if (z) {
            return null;
        }
        zzos zzos = zzkk.zzavw;
        zzos.zzbi(8);
        while (zzos.zziz() >= 8) {
            int position = zzos.getPosition();
            int readInt = zzos.readInt();
            if (zzos.readInt() == zzki.zzavb) {
                zzos.zzbi(position);
                int i = position + readInt;
                zzos.zzbj(12);
                while (true) {
                    if (zzos.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzos.getPosition();
                    int readInt2 = zzos.readInt();
                    if (zzos.readInt() == zzki.zzavc) {
                        zzos.zzbi(position2);
                        int i2 = position2 + readInt2;
                        zzos.zzbj(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzos.getPosition() < i2) {
                            zzln.zza zzd = zzku.zzd(zzos);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzln((List<? extends zzln.zza>) arrayList);
                        }
                    } else {
                        zzos.zzbj(readInt2 - 8);
                    }
                }
                return null;
            }
            zzos.zzbj(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzos zzos, int i) {
        zzos.zzbi(i + 8 + 4);
        zzos.zzbj(1);
        zzc(zzos);
        zzos.zzbj(2);
        int readUnsignedByte = zzos.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzos.zzbj(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzos.zzbj(zzos.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzos.zzbj(2);
        }
        zzos.zzbj(1);
        zzc(zzos);
        int readUnsignedByte2 = zzos.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", (Object) null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", (Object) null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzos.zzbj(12);
        zzos.zzbj(1);
        int zzc = zzc(zzos);
        byte[] bArr = new byte[zzc];
        zzos.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zzc(zzos zzos) {
        int readUnsignedByte = zzos.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzos.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
