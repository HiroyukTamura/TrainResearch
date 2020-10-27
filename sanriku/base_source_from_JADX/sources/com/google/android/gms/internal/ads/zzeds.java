package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import sun.misc.Unsafe;

final class zzeds<T> implements zzeek<T> {
    private static final Unsafe zzhgt = zzefi.zzbhj();
    private static final int[] zziac = new int[0];
    private final int[] zziad;
    private final Object[] zziae;
    private final int zziaf;
    private final int zziag;
    private final zzedo zziah;
    private final boolean zziai;
    private final boolean zziaj;
    private final boolean zziak;
    private final boolean zzial;
    private final int[] zziam;
    private final int zzian;
    private final int zziao;
    private final zzedw zziap;
    private final zzecy zziaq;
    private final zzefc<?, ?> zziar;
    private final zzebs<?> zzias;
    private final zzedh zziat;

    private zzeds(int[] iArr, Object[] objArr, int i, int i2, zzedo zzedo, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzedw zzedw, zzecy zzecy, zzefc<?, ?> zzefc, zzebs<?> zzebs, zzedh zzedh) {
        this.zziad = iArr;
        this.zziae = objArr;
        this.zziaf = i;
        this.zziag = i2;
        this.zziaj = zzedo instanceof zzecd;
        this.zziak = z;
        this.zziai = zzebs != null && zzebs.zzj(zzedo);
        this.zzial = false;
        this.zziam = iArr2;
        this.zzian = i3;
        this.zziao = i4;
        this.zziap = zzedw;
        this.zziaq = zzecy;
        this.zziar = zzefc;
        this.zzias = zzebs;
        this.zziah = zzedo;
        this.zziat = zzedh;
    }

    private static <UT, UB> int zza(zzefc<UT, UB> zzefc, T t) {
        return zzefc.zzau(zzefc.zzay(t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0140, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0144, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0152, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0163, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0168, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.ads.zzeap r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzhgt
            int[] r7 = r0.zziad
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0158;
                case 52: goto L_0x0148;
                case 53: goto L_0x0138;
                case 54: goto L_0x0138;
                case 55: goto L_0x012b;
                case 56: goto L_0x011f;
                case 57: goto L_0x0114;
                case 58: goto L_0x00fe;
                case 59: goto L_0x00d0;
                case 60: goto L_0x00ac;
                case 61: goto L_0x00a2;
                case 62: goto L_0x012b;
                case 63: goto L_0x0074;
                case 64: goto L_0x0114;
                case 65: goto L_0x011f;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x016c
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x016c
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.ads.zzeek r2 = r0.zzgz(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.ads.zzeap) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.zzhtd
            if (r15 != 0) goto L_0x0052
            goto L_0x0144
        L_0x0052:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzecg.zzd(r15, r3)
            goto L_0x0144
        L_0x0058:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r11)
            long r3 = r11.zzhtc
            long r3 = com.google.android.gms.internal.ads.zzebf.zzfh(r3)
            goto L_0x0140
        L_0x0066:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r3 = r11.zzhtb
            int r3 = com.google.android.gms.internal.ads.zzebf.zzfw(r3)
            goto L_0x0133
        L_0x0074:
            if (r5 != 0) goto L_0x016c
            int r3 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r4 = r11.zzhtb
            com.google.android.gms.internal.ads.zzech r5 = r0.zzhb(r6)
            if (r5 == 0) goto L_0x0098
            boolean r5 = r5.zzf(r4)
            if (r5 == 0) goto L_0x0089
            goto L_0x0098
        L_0x0089:
            com.google.android.gms.internal.ads.zzefb r1 = zzav(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzd(r2, r4)
            r2 = r3
            goto L_0x016d
        L_0x0098:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x0168
        L_0x00a2:
            if (r5 != r15) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzhtd
            goto L_0x0144
        L_0x00ac:
            if (r5 != r15) goto L_0x016c
            com.google.android.gms.internal.ads.zzeek r2 = r0.zzgz(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeap) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00c3
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00c4
        L_0x00c3:
            r15 = 0
        L_0x00c4:
            java.lang.Object r3 = r11.zzhtd
            if (r15 != 0) goto L_0x00ca
            goto L_0x0144
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzecg.zzd(r15, r3)
            goto L_0x0144
        L_0x00d0:
            if (r5 != r15) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r4 = r11.zzhtb
            if (r4 != 0) goto L_0x00dd
            java.lang.String r3 = ""
            goto L_0x0144
        L_0x00dd:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00f1
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.ads.zzefk.zzm(r3, r2, r5)
            if (r5 == 0) goto L_0x00ec
            goto L_0x00f1
        L_0x00ec:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfo()
            throw r1
        L_0x00f1:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
            goto L_0x0168
        L_0x00fe:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r11)
            long r3 = r11.zzhtc
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x010e
            r15 = 1
            goto L_0x010f
        L_0x010e:
            r15 = 0
        L_0x010f:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x0144
        L_0x0114:
            if (r5 != r7) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zzf(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0152
        L_0x011f:
            r2 = 1
            if (r5 != r2) goto L_0x016c
            long r2 = com.google.android.gms.internal.ads.zzeam.zzg(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0163
        L_0x012b:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r3 = r11.zzhtb
        L_0x0133:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0144
        L_0x0138:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r11)
            long r3 = r11.zzhtc
        L_0x0140:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0144:
            r12.putObject(r1, r9, r3)
            goto L_0x0168
        L_0x0148:
            if (r5 != r7) goto L_0x016c
            float r2 = com.google.android.gms.internal.ads.zzeam.zzi(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0152:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0168
        L_0x0158:
            r2 = 1
            if (r5 != r2) goto L_0x016c
            double r2 = com.google.android.gms.internal.ads.zzeam.zzh(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
        L_0x0163:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x0168:
            r12.putInt(r1, r13, r8)
            goto L_0x016d
        L_0x016c:
            r2 = r4
        L_0x016d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x026e, code lost:
        if (r7.zzhtc != 0) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0270, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0272, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0273, code lost:
        r11.addBoolean(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0276, code lost:
        if (r4 >= r5) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0278, code lost:
        r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x027e, code lost:
        if (r2 != r7.zzhtb) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0280, code lost:
        r4 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0288, code lost:
        if (r7.zzhtc == 0) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0140, code lost:
        if (r4 == 0) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0142, code lost:
        r11.add(com.google.android.gms.internal.ads.zzeaq.zzhtf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0148, code lost:
        r11.add(com.google.android.gms.internal.ads.zzeaq.zzh(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0150, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0152, code lost:
        r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0158, code lost:
        if (r2 != r7.zzhtb) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015a, code lost:
        r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7);
        r4 = r7.zzhtb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0160, code lost:
        if (r4 < 0) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0164, code lost:
        if (r4 > (r3.length - r1)) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0166, code lost:
        if (r4 != 0) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x016d, code lost:
        throw com.google.android.gms.internal.ads.zzeco.zzbfg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0172, code lost:
        throw com.google.android.gms.internal.ads.zzeco.zzbfh();
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.ads.zzeap r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzhgt
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzecl r11 = (com.google.android.gms.internal.ads.zzecl) r11
            boolean r12 = r11.zzbci()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.ads.zzecl r11 = r11.zzfn(r12)
            sun.misc.Unsafe r12 = zzhgt
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x0399;
                case 19: goto L_0x035b;
                case 20: goto L_0x0323;
                case 21: goto L_0x0323;
                case 22: goto L_0x0309;
                case 23: goto L_0x02ca;
                case 24: goto L_0x028b;
                case 25: goto L_0x023a;
                case 26: goto L_0x0197;
                case 27: goto L_0x017d;
                case 28: goto L_0x0132;
                case 29: goto L_0x0309;
                case 30: goto L_0x00fa;
                case 31: goto L_0x028b;
                case 32: goto L_0x02ca;
                case 33: goto L_0x00ba;
                case 34: goto L_0x007a;
                case 35: goto L_0x0399;
                case 36: goto L_0x035b;
                case 37: goto L_0x0323;
                case 38: goto L_0x0323;
                case 39: goto L_0x0309;
                case 40: goto L_0x02ca;
                case 41: goto L_0x028b;
                case 42: goto L_0x023a;
                case 43: goto L_0x0309;
                case 44: goto L_0x00fa;
                case 45: goto L_0x028b;
                case 46: goto L_0x02ca;
                case 47: goto L_0x00ba;
                case 48: goto L_0x007a;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x03d7
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x03d7
            com.google.android.gms.internal.ads.zzeek r1 = r0.zzgz(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.ads.zzeap) r27)
        L_0x005a:
            java.lang.Object r8 = r7.zzhtd
            r11.add(r8)
            if (r4 >= r5) goto L_0x03d7
            int r8 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r9 = r7.zzhtb
            if (r2 != r9) goto L_0x03d7
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.ads.zzeap) r27)
            goto L_0x005a
        L_0x007a:
            if (r6 != r10) goto L_0x009e
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r1, r7)
            long r4 = r7.zzhtc
            long r4 = com.google.android.gms.internal.ads.zzebf.zzfh(r4)
            r11.zzfs(r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x03d8
        L_0x0099:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
        L_0x00a2:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            long r8 = com.google.android.gms.internal.ads.zzebf.zzfh(r8)
            r11.zzfs(r8)
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            goto L_0x00a2
        L_0x00ba:
            if (r6 != r10) goto L_0x00de
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x00c5:
            if (r1 >= r2) goto L_0x00d5
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r4 = r7.zzhtb
            int r4 = com.google.android.gms.internal.ads.zzebf.zzfw(r4)
            r11.zzgw(r4)
            goto L_0x00c5
        L_0x00d5:
            if (r1 != r2) goto L_0x00d9
            goto L_0x03d8
        L_0x00d9:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x00de:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
        L_0x00e2:
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            int r4 = com.google.android.gms.internal.ads.zzebf.zzfw(r4)
            r11.zzgw(r4)
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            goto L_0x00e2
        L_0x00fa:
            if (r6 != r10) goto L_0x0101
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.ads.zzecl<?>) r11, (com.google.android.gms.internal.ads.zzeap) r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x03d7
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzecl<?>) r6, (com.google.android.gms.internal.ads.zzeap) r7)
        L_0x0112:
            com.google.android.gms.internal.ads.zzecd r1 = (com.google.android.gms.internal.ads.zzecd) r1
            com.google.android.gms.internal.ads.zzefb r3 = r1.zzhxv
            com.google.android.gms.internal.ads.zzefb r4 = com.google.android.gms.internal.ads.zzefb.zzbhd()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.ads.zzech r4 = r0.zzhb(r8)
            com.google.android.gms.internal.ads.zzefc<?, ?> r5 = r0.zziar
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzeem.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.ads.zzefb r3 = (com.google.android.gms.internal.ads.zzefb) r3
            if (r3 == 0) goto L_0x012f
            r1.zzhxv = r3
        L_0x012f:
            r1 = r2
            goto L_0x03d8
        L_0x0132:
            if (r6 != r10) goto L_0x03d7
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            if (r4 < 0) goto L_0x0178
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0173
            if (r4 != 0) goto L_0x0148
        L_0x0142:
            com.google.android.gms.internal.ads.zzeaq r4 = com.google.android.gms.internal.ads.zzeaq.zzhtf
            r11.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.ads.zzeaq r6 = com.google.android.gms.internal.ads.zzeaq.zzh((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            if (r4 < 0) goto L_0x016e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0169
            if (r4 != 0) goto L_0x0148
            goto L_0x0142
        L_0x0169:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x016e:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x0173:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x0178:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x017d:
            if (r6 != r10) goto L_0x03d7
            com.google.android.gms.internal.ads.zzeek r1 = r0.zzgz(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x03d8
        L_0x0197:
            if (r6 != r10) goto L_0x03d7
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            if (r6 != 0) goto L_0x01e4
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x01df
            if (r6 != 0) goto L_0x01b2
        L_0x01ae:
            r11.add(r1)
            goto L_0x01bd
        L_0x01b2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r8.<init>(r3, r4, r6, r9)
        L_0x01b9:
            r11.add(r8)
            int r4 = r4 + r6
        L_0x01bd:
            if (r4 >= r5) goto L_0x03d7
            int r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r8 = r7.zzhtb
            if (r2 != r8) goto L_0x03d7
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r6, r7)
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x01da
            if (r6 != 0) goto L_0x01d2
            goto L_0x01ae
        L_0x01d2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r8.<init>(r3, r4, r6, r9)
            goto L_0x01b9
        L_0x01da:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x01df:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x01e4:
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x0235
            if (r6 != 0) goto L_0x01ee
        L_0x01ea:
            r11.add(r1)
            goto L_0x0201
        L_0x01ee:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzefk.zzm(r3, r4, r8)
            if (r9 == 0) goto L_0x0230
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r9.<init>(r3, r4, r6, r10)
        L_0x01fd:
            r11.add(r9)
            r4 = r8
        L_0x0201:
            if (r4 >= r5) goto L_0x03d7
            int r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r8 = r7.zzhtb
            if (r2 != r8) goto L_0x03d7
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r6, r7)
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x022b
            if (r6 != 0) goto L_0x0216
            goto L_0x01ea
        L_0x0216:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzefk.zzm(r3, r4, r8)
            if (r9 == 0) goto L_0x0226
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01fd
        L_0x0226:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfo()
            throw r1
        L_0x022b:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x0230:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfo()
            throw r1
        L_0x0235:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x023a:
            r1 = 0
            if (r6 != r10) goto L_0x0262
            com.google.android.gms.internal.ads.zzeao r11 = (com.google.android.gms.internal.ads.zzeao) r11
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            int r4 = r4 + r2
        L_0x0246:
            if (r2 >= r4) goto L_0x0259
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r2, r7)
            long r5 = r7.zzhtc
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0254
            r5 = 1
            goto L_0x0255
        L_0x0254:
            r5 = 0
        L_0x0255:
            r11.addBoolean(r5)
            goto L_0x0246
        L_0x0259:
            if (r2 != r4) goto L_0x025d
            goto L_0x012f
        L_0x025d:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x0262:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.ads.zzeao r11 = (com.google.android.gms.internal.ads.zzeao) r11
            int r4 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0272
        L_0x0270:
            r6 = 1
            goto L_0x0273
        L_0x0272:
            r6 = 0
        L_0x0273:
            r11.addBoolean(r6)
            if (r4 >= r5) goto L_0x03d7
            int r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r8 = r7.zzhtb
            if (r2 != r8) goto L_0x03d7
            int r4 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r6, r7)
            long r8 = r7.zzhtc
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0272
            goto L_0x0270
        L_0x028b:
            if (r6 != r10) goto L_0x02ab
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x0296:
            if (r1 >= r2) goto L_0x02a2
            int r4 = com.google.android.gms.internal.ads.zzeam.zzf(r3, r1)
            r11.zzgw(r4)
            int r1 = r1 + 4
            goto L_0x0296
        L_0x02a2:
            if (r1 != r2) goto L_0x02a6
            goto L_0x03d8
        L_0x02a6:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x02ab:
            if (r6 != r9) goto L_0x03d7
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zzf(r18, r19)
            r11.zzgw(r1)
        L_0x02b6:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            int r1 = com.google.android.gms.internal.ads.zzeam.zzf(r3, r4)
            r11.zzgw(r1)
            goto L_0x02b6
        L_0x02ca:
            if (r6 != r10) goto L_0x02ea
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x02d5:
            if (r1 >= r2) goto L_0x02e1
            long r4 = com.google.android.gms.internal.ads.zzeam.zzg(r3, r1)
            r11.zzfs(r4)
            int r1 = r1 + 8
            goto L_0x02d5
        L_0x02e1:
            if (r1 != r2) goto L_0x02e5
            goto L_0x03d8
        L_0x02e5:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x02ea:
            if (r6 != r13) goto L_0x03d7
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            long r8 = com.google.android.gms.internal.ads.zzeam.zzg(r18, r19)
            r11.zzfs(r8)
        L_0x02f5:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            long r8 = com.google.android.gms.internal.ads.zzeam.zzg(r3, r4)
            r11.zzfs(r8)
            goto L_0x02f5
        L_0x0309:
            if (r6 != r10) goto L_0x0311
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.ads.zzecl<?>) r11, (com.google.android.gms.internal.ads.zzeap) r7)
            goto L_0x03d8
        L_0x0311:
            if (r6 != 0) goto L_0x03d7
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.ads.zzecl<?>) r25, (com.google.android.gms.internal.ads.zzeap) r26)
            goto L_0x03d8
        L_0x0323:
            if (r6 != r10) goto L_0x0343
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x032e:
            if (r1 >= r2) goto L_0x033a
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r1, r7)
            long r4 = r7.zzhtc
            r11.zzfs(r4)
            goto L_0x032e
        L_0x033a:
            if (r1 != r2) goto L_0x033e
            goto L_0x03d8
        L_0x033e:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x0343:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
        L_0x0347:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            r11.zzfs(r8)
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            goto L_0x0347
        L_0x035b:
            if (r6 != r10) goto L_0x037a
            com.google.android.gms.internal.ads.zzebz r11 = (com.google.android.gms.internal.ads.zzebz) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x0366:
            if (r1 >= r2) goto L_0x0372
            float r4 = com.google.android.gms.internal.ads.zzeam.zzi(r3, r1)
            r11.zzh(r4)
            int r1 = r1 + 4
            goto L_0x0366
        L_0x0372:
            if (r1 != r2) goto L_0x0375
            goto L_0x03d8
        L_0x0375:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x037a:
            if (r6 != r9) goto L_0x03d7
            com.google.android.gms.internal.ads.zzebz r11 = (com.google.android.gms.internal.ads.zzebz) r11
            float r1 = com.google.android.gms.internal.ads.zzeam.zzi(r18, r19)
            r11.zzh(r1)
        L_0x0385:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            float r1 = com.google.android.gms.internal.ads.zzeam.zzi(r3, r4)
            r11.zzh(r1)
            goto L_0x0385
        L_0x0399:
            if (r6 != r10) goto L_0x03b8
            com.google.android.gms.internal.ads.zzebp r11 = (com.google.android.gms.internal.ads.zzebp) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x03a4:
            if (r1 >= r2) goto L_0x03b0
            double r4 = com.google.android.gms.internal.ads.zzeam.zzh(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03a4
        L_0x03b0:
            if (r1 != r2) goto L_0x03b3
            goto L_0x03d8
        L_0x03b3:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x03b8:
            if (r6 != r13) goto L_0x03d7
            com.google.android.gms.internal.ads.zzebp r11 = (com.google.android.gms.internal.ads.zzebp) r11
            double r8 = com.google.android.gms.internal.ads.zzeam.zzh(r18, r19)
            r11.zzd(r8)
        L_0x03c3:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x03d8
            double r8 = com.google.android.gms.internal.ads.zzeam.zzh(r3, r4)
            r11.zzd(r8)
            goto L_0x03c3
        L_0x03d7:
            r1 = r4
        L_0x03d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.ads.zzeap r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzhgt
            java.lang.Object r12 = r7.zzha(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.ads.zzedh r2 = r7.zziat
            boolean r2 = r2.zzap(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzedh r2 = r7.zziat
            java.lang.Object r2 = r2.zzar(r12)
            com.google.android.gms.internal.ads.zzedh r3 = r7.zziat
            r3.zze(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzedh r8 = r7.zziat
            com.google.android.gms.internal.ads.zzedf r8 = r8.zzas(r12)
            com.google.android.gms.internal.ads.zzedh r12 = r7.zziat
            java.util.Map r12 = r12.zzan(r1)
            int r10 = com.google.android.gms.internal.ads.zzeam.zza(r9, r10, r15)
            int r13 = r15.zzhtb
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzhzx
            V r0 = r8.zzcif
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.ads.zzeap) r15)
            int r10 = r15.zzhtb
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.ads.zzefp r1 = r8.zzhzy
            int r1 = r1.zzbho()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.ads.zzefp r4 = r8.zzhzy
            V r10 = r8.zzcif
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefp) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzeap) r6)
            java.lang.Object r0 = r15.zzhtd
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.ads.zzefp r1 = r8.zzhzw
            int r1 = r1.zzbho()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.ads.zzefp r4 = r8.zzhzw
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefp) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzeap) r6)
            java.lang.Object r14 = r15.zzhtd
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.ads.zzeam.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.ads.zzeap) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.ads.zzeco r8 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.ads.zzeco r8 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        r2 = java.lang.Integer.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r6.zzhtd = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6.zzhtd = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.zzhtd = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        r2 = java.lang.Long.valueOf(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.ads.zzefp r4, java.lang.Class<?> r5, com.google.android.gms.internal.ads.zzeap r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.ads.zzedr.zzhuk
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0080;
                case 3: goto L_0x0073;
                case 4: goto L_0x0066;
                case 5: goto L_0x0066;
                case 6: goto L_0x005d;
                case 7: goto L_0x005d;
                case 8: goto L_0x0054;
                case 9: goto L_0x0047;
                case 10: goto L_0x0047;
                case 11: goto L_0x0047;
                case 12: goto L_0x003c;
                case 13: goto L_0x003c;
                case 14: goto L_0x002f;
                case 15: goto L_0x0024;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzd(r1, r2, r6)
            goto L_0x0099
        L_0x0019:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r1, r2, r6)
            long r2 = r6.zzhtc
            long r2 = com.google.android.gms.internal.ads.zzebf.zzfh(r2)
            goto L_0x0042
        L_0x0024:
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r1, r2, r6)
            int r2 = r6.zzhtb
            int r2 = com.google.android.gms.internal.ads.zzebf.zzfw(r2)
            goto L_0x004d
        L_0x002f:
            com.google.android.gms.internal.ads.zzedz r4 = com.google.android.gms.internal.ads.zzedz.zzbgk()
            com.google.android.gms.internal.ads.zzeek r4 = r4.zzh(r5)
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzeap) r6)
            goto L_0x0099
        L_0x003c:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r1, r2, r6)
            long r2 = r6.zzhtc
        L_0x0042:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0051
        L_0x0047:
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r1, r2, r6)
            int r2 = r6.zzhtb
        L_0x004d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0051:
            r6.zzhtd = r2
            goto L_0x0099
        L_0x0054:
            float r1 = com.google.android.gms.internal.ads.zzeam.zzi(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x006e
        L_0x005d:
            long r3 = com.google.android.gms.internal.ads.zzeam.zzg(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L_0x007b
        L_0x0066:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzf(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x006e:
            r6.zzhtd = r1
            int r1 = r2 + 4
            goto L_0x0099
        L_0x0073:
            double r3 = com.google.android.gms.internal.ads.zzeam.zzh(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
        L_0x007b:
            r6.zzhtd = r1
            int r1 = r2 + 8
            goto L_0x0099
        L_0x0080:
            int r1 = com.google.android.gms.internal.ads.zzeam.zze(r1, r2, r6)
            goto L_0x0099
        L_0x0085:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r1, r2, r6)
            long r2 = r6.zzhtc
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            r2 = 1
            goto L_0x0094
        L_0x0093:
            r2 = 0
        L_0x0094:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0051
        L_0x0099:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(byte[], int, int, com.google.android.gms.internal.ads.zzefp, java.lang.Class, com.google.android.gms.internal.ads.zzeap):int");
    }

    static <T> zzeds<T> zza(Class<T> cls, zzedm zzedm, zzedw zzedw, zzecy zzecy, zzefc<?, ?> zzefc, zzebs<?> zzebs, zzedh zzedh) {
        int i;
        char c;
        int[] iArr;
        char c2;
        int i2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i3;
        boolean z;
        int i4;
        zzeeb zzeeb;
        int i5;
        Class<?> cls2;
        int i6;
        String str;
        int i7;
        int i8;
        char c7;
        char c8;
        Field field;
        int i9;
        char charAt;
        int i10;
        Field field2;
        Field field3;
        int i11;
        char charAt2;
        int i12;
        char charAt3;
        int i13;
        char charAt4;
        int i14;
        int i15;
        char charAt5;
        int i16;
        char charAt6;
        int i17;
        char charAt7;
        int i18;
        char charAt8;
        int i19;
        char charAt9;
        int i20;
        char charAt10;
        int i21;
        char charAt11;
        int i22;
        char charAt12;
        int i23;
        char charAt13;
        char charAt14;
        zzedm zzedm2 = zzedm;
        if (zzedm2 instanceof zzeeb) {
            zzeeb zzeeb2 = (zzeeb) zzedm2;
            char c9 = 0;
            boolean z2 = zzeeb2.zzbge() == zzecd.zzf.zzhyk;
            String zzbgl = zzeeb2.zzbgl();
            int length = zzbgl.length();
            char charAt15 = zzbgl.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzbgl.charAt(i24);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c10 |= (charAt14 & 8191) << i25;
                    i25 += 13;
                    i24 = i;
                }
                charAt15 = c10 | (charAt14 << i25);
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt16 = zzbgl.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzbgl.charAt(i26);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c11 |= (charAt13 & 8191) << i27;
                    i27 += 13;
                    i26 = i23;
                }
                charAt16 = c11 | (charAt13 << i27);
                i26 = i23;
            }
            if (charAt16 == 0) {
                iArr = zziac;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                i2 = 0;
                c2 = 0;
                c = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzbgl.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzbgl.charAt(i28);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c12 |= (charAt12 & 8191) << i29;
                        i29 += 13;
                        i28 = i22;
                    }
                    charAt17 = c12 | (charAt12 << i29);
                    i28 = i22;
                }
                int i30 = i28 + 1;
                char charAt18 = zzbgl.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzbgl.charAt(i30);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c13 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i30 = i21;
                    }
                    charAt18 = c13 | (charAt11 << i31);
                    i30 = i21;
                }
                int i32 = i30 + 1;
                c3 = zzbgl.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzbgl.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c14 |= (charAt10 & 8191) << i33;
                        i33 += 13;
                        i32 = i20;
                    }
                    c3 = c14 | (charAt10 << i33);
                    i32 = i20;
                }
                int i34 = i32 + 1;
                char charAt19 = zzbgl.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzbgl.charAt(i34);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c15 |= (charAt9 & 8191) << i35;
                        i35 += 13;
                        i34 = i19;
                    }
                    charAt19 = c15 | (charAt9 << i35);
                    i34 = i19;
                }
                int i36 = i34 + 1;
                c2 = zzbgl.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzbgl.charAt(i36);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c16 |= (charAt8 & 8191) << i37;
                        i37 += 13;
                        i36 = i18;
                    }
                    c2 = c16 | (charAt8 << i37);
                    i36 = i18;
                }
                int i38 = i36 + 1;
                char charAt20 = zzbgl.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzbgl.charAt(i38);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c17 |= (charAt7 & 8191) << i39;
                        i39 += 13;
                        i38 = i17;
                    }
                    charAt20 = c17 | (charAt7 << i39);
                    i38 = i17;
                }
                int i40 = i38 + 1;
                char charAt21 = zzbgl.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzbgl.charAt(i41);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c18 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i41 = i16;
                    }
                    charAt21 = c18 | (charAt6 << i42);
                    i14 = i16;
                } else {
                    i14 = i40;
                }
                int i43 = i14 + 1;
                char charAt22 = zzbgl.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzbgl.charAt(i44);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c19 |= (charAt5 & 8191) << i45;
                        i45 += 13;
                        i44 = i15;
                    }
                    charAt22 = c19 | (charAt5 << i45);
                    i43 = i15;
                }
                int i46 = (charAt17 << 1) + charAt18;
                c4 = charAt19;
                i2 = i46;
                c = charAt22;
                c9 = charAt17;
                i26 = i43;
                char c20 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c5 = c20;
            }
            Unsafe unsafe = zzhgt;
            Object[] zzbgm = zzeeb2.zzbgm();
            Class<?> cls3 = zzeeb2.zzbgg().getClass();
            int i47 = i26;
            int[] iArr2 = new int[(c2 * 3)];
            Object[] objArr = new Object[(c2 << 1)];
            int i48 = c + c5;
            char c21 = c;
            int i49 = i47;
            int i50 = i48;
            int i51 = 0;
            int i52 = 0;
            while (i49 < length) {
                int i53 = i49 + 1;
                int charAt23 = zzbgl.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzbgl.charAt(i56);
                        c6 = c;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i55 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i56 = i13;
                        c = c6;
                    }
                    charAt23 = i55 | (charAt4 << i57);
                    i3 = i13;
                } else {
                    c6 = c;
                    i3 = i53;
                }
                int i58 = i3 + 1;
                char charAt24 = zzbgl.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzbgl.charAt(i60);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c22 |= (charAt3 & 8191) << i61;
                        i61 += 13;
                        i60 = i12;
                        z2 = z;
                    }
                    charAt24 = c22 | (charAt3 << i61);
                    i4 = i12;
                } else {
                    z = z2;
                    i4 = i59;
                }
                char c23 = charAt24 & 255;
                char c24 = c4;
                if ((charAt24 & 1024) != 0) {
                    iArr[i51] = i52;
                    i51++;
                }
                char c25 = c3;
                if (c23 >= '3') {
                    int i62 = i4 + 1;
                    char charAt25 = zzbgl.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzbgl.charAt(i62);
                            if (charAt2 < c26) {
                                break;
                            }
                            c27 |= (charAt2 & 8191) << i63;
                            i63 += 13;
                            i62 = i11;
                            c26 = 55296;
                        }
                        charAt25 = c27 | (charAt2 << i63);
                        i62 = i11;
                    }
                    int i64 = c23 - '3';
                    int i65 = i62;
                    if (i64 == 9 || i64 == 17) {
                        objArr[((i52 / 3) << 1) + 1] = zzbgm[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzbgm[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzbgm[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzbgm[i66] = field2;
                    }
                    zzeeb = zzeeb2;
                    String str2 = zzbgl;
                    i8 = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzbgm[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzbgm[i67] = field3;
                    }
                    cls2 = cls3;
                    i5 = i2;
                    i4 = i65;
                    str = str2;
                    i6 = 0;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    c7 = c9;
                } else {
                    zzeeb = zzeeb2;
                    String str3 = zzbgl;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzbgm[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzbgm[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzbgm[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzbgm[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzbgm[i71];
                                    c21 = i69;
                                } else {
                                    i68 = i71;
                                    c8 = 1;
                                    c21 = i69;
                                }
                            }
                            c8 = 1;
                        }
                        i68 = i10;
                    }
                    i8 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != c8 || c23 > 17) {
                        i5 = i68;
                        c7 = c9;
                        cls2 = cls3;
                        str = str3;
                        i7 = 0;
                        i6 = 0;
                    } else {
                        int i72 = i4 + 1;
                        str = str3;
                        char charAt26 = str.charAt(i4);
                        if (charAt26 >= 55296) {
                            char c28 = charAt26 & 8191;
                            int i73 = 13;
                            while (true) {
                                i9 = i72 + 1;
                                charAt = str.charAt(i72);
                                if (charAt < 55296) {
                                    break;
                                }
                                c28 |= (charAt & 8191) << i73;
                                i73 += 13;
                                i72 = i9;
                            }
                            charAt26 = c28 | (charAt << i73);
                            i72 = i9;
                        }
                        int i74 = (charAt26 / ' ') + (c9 << 1);
                        Object obj3 = zzbgm[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzbgm[i74] = field;
                        }
                        c7 = c9;
                        cls2 = cls3;
                        i7 = (int) unsafe.objectFieldOffset(field);
                        i6 = charAt26 % ' ';
                        i4 = i72;
                    }
                    if (c23 >= 18 && c23 <= '1') {
                        iArr[i50] = i8;
                        i50++;
                    }
                }
                int i75 = i52 + 1;
                iArr2[i52] = charAt23;
                int i76 = i75 + 1;
                iArr2[i75] = i8 | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (c23 << 20);
                i52 = i76 + 1;
                iArr2[i76] = (i6 << 20) | i7;
                c9 = c7;
                zzbgl = str;
                i49 = i4;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                cls3 = cls2;
                c3 = c25;
                i2 = i5;
                zzeeb2 = zzeeb;
            }
            char c29 = c4;
            boolean z3 = z2;
            return new zzeds(iArr2, objArr, c3, c4, zzeeb2.zzbgg(), z2, false, iArr, c, i48, zzedw, zzecy, zzefc, zzebs, zzedh);
        }
        int zzbge = ((zzeev) zzedm2).zzbge();
        int i77 = zzecd.zzf.zzhyk;
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzech zzech, UB ub, zzefc<UT, UB> zzefc) {
        zzedf<?, ?> zzas = this.zziat.zzas(zzha(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzech.zzf(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzefc.zzbhg();
                }
                zzeay zzfq = zzeaq.zzfq(zzedg.zza(zzas, next.getKey(), next.getValue()));
                try {
                    zzedg.zza(zzfq.zzbcx(), zzas, next.getKey(), next.getValue());
                    zzefc.zza(ub, i2, zzfq.zzbcw());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzefc<UT, UB> zzefc) {
        zzech zzhb;
        int i2 = this.zziad[i];
        Object zzp = zzefi.zzp(obj, (long) (zzhc(i) & 1048575));
        if (zzp == null || (zzhb = zzhb(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zziat.zzan(zzp), zzhb, ub, zzefc);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(C0681a.m324a(C0681a.m337b(C0681a.m336b(arrays, name.length() + C0681a.m336b(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", arrays));
        }
    }

    private static void zza(int i, Object obj, zzefv zzefv) throws IOException {
        if (obj instanceof String) {
            zzefv.zzk(i, (String) obj);
        } else {
            zzefv.zza(i, (zzeaq) obj);
        }
    }

    private static <UT, UB> void zza(zzefc<UT, UB> zzefc, T t, zzefv zzefv) throws IOException {
        zzefc.zza(zzefc.zzay(t), zzefv);
    }

    private final <K, V> void zza(zzefv zzefv, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzefv.zza(i, this.zziat.zzas(zzha(i2)), this.zziat.zzao(obj));
        }
    }

    private final void zza(Object obj, int i, zzeee zzeee) throws IOException {
        long j;
        Object zzbdg;
        if (zzhe(i)) {
            j = (long) (i & 1048575);
            zzbdg = zzeee.zzbdf();
        } else {
            int i2 = i & 1048575;
            if (this.zziaj) {
                j = (long) i2;
                zzbdg = zzeee.readString();
            } else {
                j = (long) i2;
                zzbdg = zzeee.zzbdg();
            }
        }
        zzefi.zza(obj, j, zzbdg);
    }

    private final void zza(T t, T t2, int i) {
        long zzhc = (long) (zzhc(i) & 1048575);
        if (zze(t2, i)) {
            Object zzp = zzefi.zzp(t, zzhc);
            Object zzp2 = zzefi.zzp(t2, zzhc);
            if (zzp != null && zzp2 != null) {
                zzefi.zza((Object) t, zzhc, zzecg.zzd(zzp, zzp2));
                zzf(t, i);
            } else if (zzp2 != null) {
                zzefi.zza((Object) t, zzhc, zzp2);
                zzf(t, i);
            }
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzefi.zzk(t, (long) (zzhd(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zziak ? zze(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzeek zzeek) {
        return zzeek.zzaw(zzefi.zzp(obj, (long) (i & 1048575)));
    }

    private final int zzan(int i, int i2) {
        if (i < this.zziaf || i > this.zziag) {
            return -1;
        }
        return zzao(i, i2);
    }

    private final int zzao(int i, int i2) {
        int length = (this.zziad.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zziad[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static zzefb zzav(Object obj) {
        zzecd zzecd = (zzecd) obj;
        zzefb zzefb = zzecd.zzhxv;
        if (zzefb != zzefb.zzbhd()) {
            return zzefb;
        }
        zzefb zzbhe = zzefb.zzbhe();
        zzecd.zzhxv = zzbhe;
        return zzbhe;
    }

    private final void zzb(T t, int i, int i2) {
        zzefi.zzb((Object) t, (long) (zzhd(i2) & 1048575), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.ads.zzefv r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zziai
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzebs<?> r3 = r0.zzias
            com.google.android.gms.internal.ads.zzebt r3 = r3.zzai(r1)
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r5 = r3.zzhut
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zziad
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzhgt
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzhc(r10)
            int[] r13 = r0.zziad
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zziak
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005d
            r4 = 17
            if (r15 > r4) goto L_0x005d
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0057
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
        L_0x0057:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0060
        L_0x005d:
            r17 = r10
            r4 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzebs<?> r9 = r0.zzias
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.ads.zzebs<?> r9 = r0.zzias
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0060
        L_0x007c:
            r5 = 0
            goto L_0x0060
        L_0x007e:
            r9 = r12 & r16
            long r9 = (long) r9
            r12 = r17
            switch(r15) {
                case 0: goto L_0x0485;
                case 1: goto L_0x0479;
                case 2: goto L_0x046d;
                case 3: goto L_0x0461;
                case 4: goto L_0x0455;
                case 5: goto L_0x0449;
                case 6: goto L_0x043d;
                case 7: goto L_0x0431;
                case 8: goto L_0x0425;
                case 9: goto L_0x0414;
                case 10: goto L_0x0405;
                case 11: goto L_0x03f8;
                case 12: goto L_0x03eb;
                case 13: goto L_0x03de;
                case 14: goto L_0x03d1;
                case 15: goto L_0x03c4;
                case 16: goto L_0x03b7;
                case 17: goto L_0x03a6;
                case 18: goto L_0x0396;
                case 19: goto L_0x0386;
                case 20: goto L_0x0376;
                case 21: goto L_0x0366;
                case 22: goto L_0x0356;
                case 23: goto L_0x0346;
                case 24: goto L_0x0336;
                case 25: goto L_0x0326;
                case 26: goto L_0x0317;
                case 27: goto L_0x0304;
                case 28: goto L_0x02f5;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02d5;
                case 31: goto L_0x02c5;
                case 32: goto L_0x02b5;
                case 33: goto L_0x02a5;
                case 34: goto L_0x0295;
                case 35: goto L_0x0285;
                case 36: goto L_0x0275;
                case 37: goto L_0x0265;
                case 38: goto L_0x0255;
                case 39: goto L_0x0245;
                case 40: goto L_0x0235;
                case 41: goto L_0x0225;
                case 42: goto L_0x0215;
                case 43: goto L_0x0205;
                case 44: goto L_0x01f5;
                case 45: goto L_0x01e5;
                case 46: goto L_0x01d5;
                case 47: goto L_0x01c5;
                case 48: goto L_0x01b5;
                case 49: goto L_0x01a2;
                case 50: goto L_0x0199;
                case 51: goto L_0x018a;
                case 52: goto L_0x017b;
                case 53: goto L_0x016c;
                case 54: goto L_0x015d;
                case 55: goto L_0x014e;
                case 56: goto L_0x013f;
                case 57: goto L_0x0130;
                case 58: goto L_0x0121;
                case 59: goto L_0x0112;
                case 60: goto L_0x00ff;
                case 61: goto L_0x00ef;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00d3;
                case 64: goto L_0x00c5;
                case 65: goto L_0x00b7;
                case 66: goto L_0x00a9;
                case 67: goto L_0x009b;
                case 68: goto L_0x0089;
                default: goto L_0x0086;
            }
        L_0x0086:
            r13 = 0
            goto L_0x0490
        L_0x0089:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzad(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzq(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzal(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzam(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzac(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            r2.zza((int) r14, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0086
        L_0x0112:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzefv) r2)
            goto L_0x0086
        L_0x0121:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            boolean r4 = zzj(r1, r9)
            r2.zzh((int) r14, (boolean) r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzae(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzab(r14, r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzh((int) r14, (long) r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzp(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzg(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zzf(r1, (long) r9)
            r2.zzb((int) r14, (double) r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza((com.google.android.gms.internal.ads.zzefv) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r10 = r0.zzgz(r12)
            com.google.android.gms.internal.ads.zzeem.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.ads.zzeem.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.ads.zzeem.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r10 = r0.zzgz(r12)
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.ads.zzefv) r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.ads.zzeem.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0490
        L_0x03b7:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0490
        L_0x03c4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzad(r14, r4)
            goto L_0x0490
        L_0x03d1:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzq(r14, r9)
            goto L_0x0490
        L_0x03de:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzal(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzam(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzac(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            r2.zza((int) r14, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0490
        L_0x0425:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzefv) r2)
            goto L_0x0490
        L_0x0431:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            boolean r4 = com.google.android.gms.internal.ads.zzefi.zzm(r1, r9)
            r2.zzh((int) r14, (boolean) r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzae(r14, r4)
            goto L_0x0490
        L_0x0449:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0490
        L_0x0455:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzab(r14, r4)
            goto L_0x0490
        L_0x0461:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzh((int) r14, (long) r9)
            goto L_0x0490
        L_0x046d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzp(r14, r9)
            goto L_0x0490
        L_0x0479:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            float r4 = com.google.android.gms.internal.ads.zzefi.zzn(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.ads.zzefi.zzo(r1, r9)
            r2.zzb((int) r14, (double) r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.ads.zzebs<?> r4 = r0.zzias
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0494
        L_0x04a9:
            r5 = 0
            goto L_0x0494
        L_0x04ab:
            com.google.android.gms.internal.ads.zzefc<?, ?> r3 = r0.zziar
            zza(r3, r1, (com.google.android.gms.internal.ads.zzefv) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzefv):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzhc = zzhc(i);
        int i2 = this.zziad[i];
        long j = (long) (zzhc & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzefi.zzp(t, j);
            Object zzp2 = zzefi.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzefi.zza((Object) t, j, zzecg.zzd(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzefi.zza((Object) t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze(t, i) == zze(t2, i);
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzefi.zzp(obj, j);
    }

    private final boolean zze(T t, int i) {
        if (this.zziak) {
            int zzhc = zzhc(i);
            long j = (long) (zzhc & 1048575);
            switch ((zzhc & 267386880) >>> 20) {
                case 0:
                    return zzefi.zzo(t, j) != 0.0d;
                case 1:
                    return zzefi.zzn(t, j) != 0.0f;
                case 2:
                    return zzefi.zzl(t, j) != 0;
                case 3:
                    return zzefi.zzl(t, j) != 0;
                case 4:
                    return zzefi.zzk(t, j) != 0;
                case 5:
                    return zzefi.zzl(t, j) != 0;
                case 6:
                    return zzefi.zzk(t, j) != 0;
                case 7:
                    return zzefi.zzm(t, j);
                case 8:
                    Object zzp = zzefi.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeaq) {
                        return !zzeaq.zzhtf.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzefi.zzp(t, j) != null;
                case 10:
                    return !zzeaq.zzhtf.equals(zzefi.zzp(t, j));
                case 11:
                    return zzefi.zzk(t, j) != 0;
                case 12:
                    return zzefi.zzk(t, j) != 0;
                case 13:
                    return zzefi.zzk(t, j) != 0;
                case 14:
                    return zzefi.zzl(t, j) != 0;
                case 15:
                    return zzefi.zzk(t, j) != 0;
                case 16:
                    return zzefi.zzl(t, j) != 0;
                case 17:
                    return zzefi.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzhd = zzhd(i);
            return (zzefi.zzk(t, (long) (zzhd & 1048575)) & (1 << (zzhd >>> 20))) != 0;
        }
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzefi.zzp(t, j)).doubleValue();
    }

    private final void zzf(T t, int i) {
        if (!this.zziak) {
            int zzhd = zzhd(i);
            long j = (long) (zzhd & 1048575);
            zzefi.zzb((Object) t, j, zzefi.zzk(t, j) | (1 << (zzhd >>> 20)));
        }
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzefi.zzp(t, j)).floatValue();
    }

    private final zzeek zzgz(int i) {
        int i2 = (i / 3) << 1;
        zzeek zzeek = (zzeek) this.zziae[i2];
        if (zzeek != null) {
            return zzeek;
        }
        zzeek zzh = zzedz.zzbgk().zzh((Class) this.zziae[i2 + 1]);
        this.zziae[i2] = zzh;
        return zzh;
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzefi.zzp(t, j)).intValue();
    }

    private final Object zzha(int i) {
        return this.zziae[(i / 3) << 1];
    }

    private final zzech zzhb(int i) {
        return (zzech) this.zziae[((i / 3) << 1) + 1];
    }

    private final int zzhc(int i) {
        return this.zziad[i + 1];
    }

    private final int zzhd(int i) {
        return this.zziad[i + 2];
    }

    private static boolean zzhe(int i) {
        return (i & 536870912) != 0;
    }

    private final int zzhf(int i) {
        if (i < this.zziaf || i > this.zziag) {
            return -1;
        }
        return zzao(i, 0);
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzefi.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzefi.zzp(t, j)).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzm(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzm(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzefi.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzefi.zzn(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzefi.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzefi.zzo(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zziad
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01ba
            int r4 = r9.zzhc(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0198;
                case 1: goto L_0x017f;
                case 2: goto L_0x016c;
                case 3: goto L_0x0159;
                case 4: goto L_0x0148;
                case 5: goto L_0x0135;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01b3
        L_0x001c:
            int r4 = r9.zzhd(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r4)
            if (r8 != r4) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.ads.zzeem.zzg(r3, r4)
            goto L_0x01b3
        L_0x004a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x0074:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0086:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x009a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00ac:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x00be:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00d0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            boolean r4 = com.google.android.gms.internal.ads.zzefi.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.ads.zzefi.zzm(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0124:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0135:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0148:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0159:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x016c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            float r4 = com.google.android.gms.internal.ads.zzefi.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.ads.zzefi.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01b3
        L_0x0197:
            goto L_0x01b2
        L_0x0198:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            double r4 = com.google.android.gms.internal.ads.zzefi.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.ads.zzefi.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
        L_0x01b2:
            r3 = 0
        L_0x01b3:
            if (r3 != 0) goto L_0x01b6
            return r1
        L_0x01b6:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01ba:
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r9.zziar
            java.lang.Object r0 = r0.zzay(r10)
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r9.zziar
            java.lang.Object r2 = r2.zzay(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01cd
            return r1
        L_0x01cd:
            boolean r0 = r9.zziai
            if (r0 == 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzebs<?> r0 = r9.zzias
            com.google.android.gms.internal.ads.zzebt r10 = r0.zzai(r10)
            com.google.android.gms.internal.ads.zzebs<?> r0 = r9.zzias
            com.google.android.gms.internal.ads.zzebt r11 = r0.zzai(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01e2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = zzh(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = zzi(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = com.google.android.gms.internal.ads.zzecg.zzbu(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0108, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0117, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0122, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0126, code lost:
        r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012a, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012c, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zziad
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0130
            int r3 = r8.zzhc(r1)
            int[] r4 = r8.zziad
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011c;
                case 1: goto L_0x0111;
                case 2: goto L_0x010a;
                case 3: goto L_0x010a;
                case 4: goto L_0x0102;
                case 5: goto L_0x010a;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x010a;
                case 15: goto L_0x0102;
                case 16: goto L_0x010a;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012c
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x0061:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x0093:
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0108
        L_0x009b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            goto L_0x0126
        L_0x00b0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            float r3 = zzg(r9, r5)
            goto L_0x0117
        L_0x00bd:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            double r3 = zzf(r9, (long) r5)
            goto L_0x0122
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x012a
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012c
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x012a
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzefi.zzm(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.ads.zzecg.zzbu(r3)
            goto L_0x012a
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
        L_0x0108:
            int r2 = r2 + r3
            goto L_0x012c
        L_0x010a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzefi.zzl(r9, r5)
            goto L_0x0126
        L_0x0111:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzefi.zzn(r9, r5)
        L_0x0117:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x012a
        L_0x011c:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzefi.zzo(r9, r5)
        L_0x0122:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0126:
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
        L_0x012a:
            int r3 = r3 + r2
            r2 = r3
        L_0x012c:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0130:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r8.zziar
            java.lang.Object r0 = r0.zzay(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.zziai
            if (r1 == 0) goto L_0x014e
            int r0 = r0 * 53
            com.google.android.gms.internal.ads.zzebs<?> r1 = r8.zzias
            com.google.android.gms.internal.ads.zzebt r9 = r1.zzai(r9)
            int r9 = r9.hashCode()
            int r0 = r0 + r9
        L_0x014e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zziap.newInstance(this.zziah);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0357, code lost:
        if (r0 == r15) goto L_0x03c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03a0, code lost:
        if (r0 == r15) goto L_0x03c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0120, code lost:
        r10.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0169, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01bc, code lost:
        r10.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0200, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0202, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r34;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x022c, code lost:
        r32 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02a3, code lost:
        r0 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a5, code lost:
        r6 = r6 | r22;
        r7 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02a9, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ad, code lost:
        r13 = r33;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b3, code lost:
        r2 = r7;
        r18 = r9;
        r26 = r10;
        r24 = r11;
        r7 = r32;
        r9 = r8;
        r8 = r34;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.ads.zzeap r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzhgt
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x0468
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.ads.zzeap) r9)
            int r3 = r9.zzhtb
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0037
            int r2 = r2 / r8
            int r1 = r15.zzan(r3, r2)
            goto L_0x003b
        L_0x0037:
            int r1 = r15.zzhf(r3)
        L_0x003b:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004a
            r24 = r3
            r2 = r4
            r9 = r5
            r26 = r10
            r8 = r11
            r18 = 0
            goto L_0x03cc
        L_0x004a:
            int[] r1 = r15.zziad
            int r18 = r2 + 1
            r8 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r8 & r18
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02c1
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r18
            r5 = -1
            if (r1 == r7) goto L_0x007e
            if (r7 == r5) goto L_0x0078
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0078:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
        L_0x007e:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x028b;
                case 1: goto L_0x0271;
                case 2: goto L_0x024b;
                case 3: goto L_0x024b;
                case 4: goto L_0x0230;
                case 5: goto L_0x020b;
                case 6: goto L_0x01e8;
                case 7: goto L_0x01c0;
                case 8: goto L_0x019b;
                case 9: goto L_0x016d;
                case 10: goto L_0x0152;
                case 11: goto L_0x0230;
                case 12: goto L_0x0124;
                case 13: goto L_0x01e8;
                case 14: goto L_0x020b;
                case 15: goto L_0x0109;
                case 16: goto L_0x00dc;
                case 17: goto L_0x0091;
                default: goto L_0x0082;
            }
        L_0x0082:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r32 = r7
            r8 = r19
            r18 = -1
        L_0x008e:
            r7 = r4
            goto L_0x02b3
        L_0x0091:
            r8 = 3
            if (r0 != r8) goto L_0x00d0
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r8 = r19
            r18 = -1
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.ads.zzeap) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00b5
            java.lang.Object r1 = r5.zzhtd
            goto L_0x00bf
        L_0x00b5:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzhtd
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzecg.zzd(r1, r2)
        L_0x00bf:
            r10.putObject(r14, r12, r1)
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x0017
        L_0x00d0:
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            goto L_0x022c
        L_0x00dc:
            r5 = r35
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            if (r0 != 0) goto L_0x0104
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r4, r5)
            long r0 = r5.zzhtc
            long r19 = com.google.android.gms.internal.ads.zzebf.zzfh(r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            goto L_0x02a9
        L_0x0104:
            r12 = r31
            r13 = r5
            goto L_0x022c
        L_0x0109:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x022c
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r4, r13)
            int r1 = r13.zzhtb
            int r1 = com.google.android.gms.internal.ads.zzebf.zzfw(r1)
        L_0x0120:
            r10.putInt(r14, r2, r1)
            goto L_0x0169
        L_0x0124:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x022c
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r4, r13)
            int r1 = r13.zzhtb
            com.google.android.gms.internal.ads.zzech r4 = r15.zzhb(r9)
            if (r4 == 0) goto L_0x0120
            boolean r4 = r4.zzf(r1)
            if (r4 == 0) goto L_0x0144
            goto L_0x0120
        L_0x0144:
            com.google.android.gms.internal.ads.zzefb r2 = zzav(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzd(r8, r1)
            goto L_0x02a9
        L_0x0152:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x022c
            int r0 = com.google.android.gms.internal.ads.zzeam.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzhtd
            r10.putObject(r14, r2, r1)
        L_0x0169:
            r6 = r6 | r22
            goto L_0x02a9
        L_0x016d:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0197
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeap) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x018c
            java.lang.Object r1 = r13.zzhtd
            goto L_0x01bc
        L_0x018c:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzhtd
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzecg.zzd(r1, r4)
            goto L_0x01bc
        L_0x0197:
            r5 = r33
            goto L_0x022c
        L_0x019b:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x022c
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01b6
            int r0 = com.google.android.gms.internal.ads.zzeam.zzc(r12, r4, r13)
            goto L_0x01ba
        L_0x01b6:
            int r0 = com.google.android.gms.internal.ads.zzeam.zzd(r12, r4, r13)
        L_0x01ba:
            java.lang.Object r1 = r13.zzhtd
        L_0x01bc:
            r10.putObject(r14, r2, r1)
            goto L_0x0200
        L_0x01c0:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x022c
            int r0 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzhtc
            r19 = 0
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x01df
            r0 = 1
            goto L_0x01e0
        L_0x01df:
            r0 = 0
        L_0x01e0:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r32
            goto L_0x0202
        L_0x01e8:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x022c
            int r0 = com.google.android.gms.internal.ads.zzeam.zzf(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0200:
            r6 = r6 | r22
        L_0x0202:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x0017
        L_0x020b:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x022c
            long r19 = com.google.android.gms.internal.ads.zzeam.zzg(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x02a3
        L_0x022c:
            r32 = r7
            goto L_0x008e
        L_0x0230:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02b3
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r7, r13)
            int r1 = r13.zzhtb
            r10.putInt(r14, r2, r1)
            goto L_0x02a5
        L_0x024b:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02b3
            int r7 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r7, r13)
            long r4 = r13.zzhtc
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            goto L_0x02ad
        L_0x0271:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02b3
            float r0 = com.google.android.gms.internal.ads.zzeam.zzi(r12, r7)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x02a5
        L_0x028b:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02b3
            double r0 = com.google.android.gms.internal.ads.zzeam.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x02a3:
            int r0 = r7 + 8
        L_0x02a5:
            r6 = r6 | r22
            r7 = r32
        L_0x02a9:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02ad:
            r13 = r33
            r11 = r34
            goto L_0x0017
        L_0x02b3:
            r2 = r7
            r18 = r9
            r26 = r10
            r24 = r11
            r7 = r32
            r9 = r8
            r8 = r34
            goto L_0x03cc
        L_0x02c1:
            r5 = r3
            r17 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x0326
            r1 = 2
            if (r0 != r1) goto L_0x0319
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.ads.zzecl r0 = (com.google.android.gms.internal.ads.zzecl) r0
            boolean r1 = r0.zzbci()
            if (r1 != 0) goto L_0x02f6
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02ed
            r1 = 10
            goto L_0x02ef
        L_0x02ed:
            int r1 = r1 << 1
        L_0x02ef:
            com.google.android.gms.internal.ads.zzecl r0 = r0.zzfn(r1)
            r10.putObject(r14, r2, r0)
        L_0x02f6:
            r11 = r0
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r19 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r17
            r6 = r19
            r13 = r33
            goto L_0x0017
        L_0x0319:
            r19 = r6
            r24 = r5
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            goto L_0x03a3
        L_0x0326:
            r19 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x0375
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r29
            r32 = r1
            r1 = r30
            r22 = r2
            r2 = r31
            r3 = r7
            r20 = r4
            r4 = r33
            r5 = r8
            r24 = r6
            r15 = r7
            r7 = r32
            r25 = r8
            r8 = r9
            r18 = r9
            r26 = r10
            r9 = r20
            r12 = r22
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.ads.zzeap) r14)
            if (r0 != r15) goto L_0x035b
            goto L_0x03c8
        L_0x035b:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
            r10 = r26
            goto L_0x0017
        L_0x0375:
            r32 = r0
            r22 = r2
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r5 = r20
            r0 = 50
            r7 = r32
            if (r11 != r0) goto L_0x03ad
            r0 = 2
            if (r7 != r0) goto L_0x03a3
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r22
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.ads.zzeap) r8)
            if (r0 != r15) goto L_0x035b
            goto L_0x03c8
        L_0x03a3:
            r8 = r34
            r2 = r15
        L_0x03a6:
            r7 = r17
            r6 = r19
            r9 = r25
            goto L_0x03cc
        L_0x03ad:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r8 = r5
            r5 = r25
            r6 = r24
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.ads.zzeap) r13)
            if (r0 != r15) goto L_0x044c
        L_0x03c8:
            r8 = r34
            r2 = r0
            goto L_0x03a6
        L_0x03cc:
            if (r9 != r8) goto L_0x03da
            if (r8 != 0) goto L_0x03d1
            goto L_0x03da
        L_0x03d1:
            r1 = -1
            r10 = r29
            r13 = r30
            r0 = r2
            r3 = r9
            goto L_0x0472
        L_0x03da:
            r10 = r29
            boolean r0 = r10.zziai
            if (r0 == 0) goto L_0x0427
            r11 = r35
            com.google.android.gms.internal.ads.zzebq r0 = r11.zzhte
            com.google.android.gms.internal.ads.zzebq r1 = com.google.android.gms.internal.ads.zzebq.zzbec()
            if (r0 == r1) goto L_0x0424
            com.google.android.gms.internal.ads.zzedo r0 = r10.zziah
            com.google.android.gms.internal.ads.zzebq r1 = r11.zzhte
            r12 = r24
            com.google.android.gms.internal.ads.zzecd$zzd r0 = r1.zza(r0, r12)
            if (r0 != 0) goto L_0x0414
            com.google.android.gms.internal.ads.zzefb r4 = zzav(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefb) r4, (com.google.android.gms.internal.ads.zzeap) r5)
            r14 = r30
            r13 = r33
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r18
            r10 = r26
            r12 = r31
            goto L_0x0449
        L_0x0414:
            r13 = r30
            r0 = r13
            com.google.android.gms.internal.ads.zzecd$zzb r0 = (com.google.android.gms.internal.ads.zzecd.zzb) r0
            r0.zzbfd()
            com.google.android.gms.internal.ads.zzebt<com.google.android.gms.internal.ads.zzecd$zze> r0 = r0.zzhxy
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0424:
            r13 = r30
            goto L_0x042b
        L_0x0427:
            r13 = r30
            r11 = r35
        L_0x042b:
            r12 = r24
            com.google.android.gms.internal.ads.zzefb r4 = zzav(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefb) r4, (com.google.android.gms.internal.ads.zzeap) r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r18
            r10 = r26
            r12 = r31
            r13 = r33
        L_0x0449:
            r11 = r8
            goto L_0x0017
        L_0x044c:
            r12 = r24
            r9 = r25
            r15 = r29
            r14 = r30
            r13 = r33
            r11 = r34
            r3 = r9
            r1 = r12
            r7 = r17
            r2 = r18
            r6 = r19
            r10 = r26
            r12 = r31
            r9 = r35
            goto L_0x0017
        L_0x0468:
            r19 = r6
            r17 = r7
            r26 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r1 = -1
        L_0x0472:
            if (r7 == r1) goto L_0x047a
            long r1 = (long) r7
            r4 = r26
            r4.putInt(r13, r1, r6)
        L_0x047a:
            r1 = 0
            int r2 = r10.zzian
        L_0x047d:
            int r4 = r10.zziao
            if (r2 >= r4) goto L_0x0490
            int[] r4 = r10.zziam
            r4 = r4[r2]
            com.google.android.gms.internal.ads.zzefc<?, ?> r5 = r10.zziar
            java.lang.Object r1 = r10.zza((java.lang.Object) r13, (int) r4, r1, r5)
            com.google.android.gms.internal.ads.zzefb r1 = (com.google.android.gms.internal.ads.zzefb) r1
            int r2 = r2 + 1
            goto L_0x047d
        L_0x0490:
            if (r1 == 0) goto L_0x0497
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r10.zziar
            r2.zzi(r13, r1)
        L_0x0497:
            r1 = r33
            if (r8 != 0) goto L_0x04a3
            if (r0 != r1) goto L_0x049e
            goto L_0x04a7
        L_0x049e:
            com.google.android.gms.internal.ads.zzeco r0 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            throw r0
        L_0x04a3:
            if (r0 > r1) goto L_0x04a8
            if (r3 != r8) goto L_0x04a8
        L_0x04a7:
            return r0
        L_0x04a8:
            com.google.android.gms.internal.ads.zzeco r0 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            goto L_0x04ae
        L_0x04ad:
            throw r0
        L_0x04ae:
            goto L_0x04ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzeap):int");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.ads.zzeee r14, com.google.android.gms.internal.ads.zzebq r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x0535
            com.google.android.gms.internal.ads.zzefc<?, ?> r8 = r12.zziar
            com.google.android.gms.internal.ads.zzebs<?> r9 = r12.zzias
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzbdw()     // Catch:{ all -> 0x051d }
            int r3 = r12.zzhf(r2)     // Catch:{ all -> 0x051d }
            if (r3 >= 0) goto L_0x0078
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzian
        L_0x001a:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzi(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zziai     // Catch:{ all -> 0x051d }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzedo r3 = r12.zziah     // Catch:{ all -> 0x051d }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x051d }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzebt r1 = r9.zzaj(r13)     // Catch:{ all -> 0x051d }
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x051d }
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zza(r14)     // Catch:{ all -> 0x051d }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r2 = r8.zzaz(r13)     // Catch:{ all -> 0x051d }
            r10 = r2
        L_0x005b:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ all -> 0x051d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzian
        L_0x0063:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x0072
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0072:
            if (r10 == 0) goto L_0x0077
            r8.zzi(r13, r10)
        L_0x0077:
            return
        L_0x0078:
            int r4 = r12.zzhc(r3)     // Catch:{ all -> 0x051d }
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x04cc;
                case 1: goto L_0x04c0;
                case 2: goto L_0x04b4;
                case 3: goto L_0x04a8;
                case 4: goto L_0x049c;
                case 5: goto L_0x0490;
                case 6: goto L_0x0484;
                case 7: goto L_0x0478;
                case 8: goto L_0x0473;
                case 9: goto L_0x0448;
                case 10: goto L_0x043d;
                case 11: goto L_0x0432;
                case 12: goto L_0x041b;
                case 13: goto L_0x0410;
                case 14: goto L_0x0405;
                case 15: goto L_0x03fa;
                case 16: goto L_0x03ef;
                case 17: goto L_0x03be;
                case 18: goto L_0x03b3;
                case 19: goto L_0x03a8;
                case 20: goto L_0x039d;
                case 21: goto L_0x0392;
                case 22: goto L_0x0387;
                case 23: goto L_0x037c;
                case 24: goto L_0x0371;
                case 25: goto L_0x0366;
                case 26: goto L_0x0344;
                case 27: goto L_0x0332;
                case 28: goto L_0x0324;
                case 29: goto L_0x0319;
                case 30: goto L_0x0308;
                case 31: goto L_0x02fd;
                case 32: goto L_0x02f2;
                case 33: goto L_0x02e7;
                case 34: goto L_0x02dc;
                case 35: goto L_0x02ce;
                case 36: goto L_0x02c0;
                case 37: goto L_0x02b2;
                case 38: goto L_0x02a4;
                case 39: goto L_0x0296;
                case 40: goto L_0x0288;
                case 41: goto L_0x027a;
                case 42: goto L_0x026c;
                case 43: goto L_0x025e;
                case 44: goto L_0x0249;
                case 45: goto L_0x023b;
                case 46: goto L_0x022d;
                case 47: goto L_0x021f;
                case 48: goto L_0x0211;
                case 49: goto L_0x01ff;
                case 50: goto L_0x01bd;
                case 51: goto L_0x01ae;
                case 52: goto L_0x019f;
                case 53: goto L_0x0190;
                case 54: goto L_0x0181;
                case 55: goto L_0x0172;
                case 56: goto L_0x0163;
                case 57: goto L_0x0154;
                case 58: goto L_0x0145;
                case 59: goto L_0x0140;
                case 60: goto L_0x0112;
                case 61: goto L_0x0108;
                case 62: goto L_0x00fa;
                case 63: goto L_0x00d9;
                case 64: goto L_0x00cb;
                case 65: goto L_0x00bd;
                case 66: goto L_0x00af;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x0087;
            }
        L_0x0087:
            if (r10 != 0) goto L_0x04d9
            java.lang.Object r2 = r8.zzbhg()     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x04d8
        L_0x008f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r6 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
        L_0x009c:
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x00a1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbdm()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x00af:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            int r6 = r14.zzbdl()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x00bd:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbdk()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x00cb:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            int r6 = r14.zzbdj()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x00d9:
            int r5 = r14.zzbdi()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzech r7 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x04f6 }
            if (r7 == 0) goto L_0x00f0
            boolean r7 = r7.zzf(r5)     // Catch:{ zzecn -> 0x04f6 }
            if (r7 == 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeem.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x00f0:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x00fa:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            int r6 = r14.zzbdh()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0108:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeaq r6 = r14.zzbdg()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0112:
            boolean r5 = r12.zza(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x04f6 }
            r4 = r4 & r6
            if (r5 == 0) goto L_0x012f
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r4)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r7 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzecg.zzd(r6, r7)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x012f:
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r6 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0140:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0145:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            boolean r6 = r14.zzbde()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0154:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            int r6 = r14.zzbdd()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0163:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbdc()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0172:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            int r6 = r14.zzbdb()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0181:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbcz()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x0190:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbda()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x019f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            float r6 = r14.readFloat()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            double r6 = r14.readDouble()     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x009c
        L_0x01bd:
            java.lang.Object r2 = r12.zzha(r3)     // Catch:{ zzecn -> 0x04f6 }
            int r3 = r12.zzhc(r3)     // Catch:{ zzecn -> 0x04f6 }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            if (r5 != 0) goto L_0x01d7
            com.google.android.gms.internal.ads.zzedh r5 = r12.zziat     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r5 = r5.zzar(r2)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x01ee
        L_0x01d7:
            com.google.android.gms.internal.ads.zzedh r6 = r12.zziat     // Catch:{ zzecn -> 0x04f6 }
            boolean r6 = r6.zzap(r5)     // Catch:{ zzecn -> 0x04f6 }
            if (r6 == 0) goto L_0x01ee
            com.google.android.gms.internal.ads.zzedh r6 = r12.zziat     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r6 = r6.zzar(r2)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzedh r7 = r12.zziat     // Catch:{ zzecn -> 0x04f6 }
            r7.zze(r6, r5)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x04f6 }
            r5 = r6
        L_0x01ee:
            com.google.android.gms.internal.ads.zzedh r3 = r12.zziat     // Catch:{ zzecn -> 0x04f6 }
            java.util.Map r3 = r3.zzan(r5)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzedh r4 = r12.zziat     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzedf r2 = r4.zzas(r2)     // Catch:{ zzecn -> 0x04f6 }
            r14.zza(r3, r2, (com.google.android.gms.internal.ads.zzebq) r15)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x01ff:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzecy r3 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzecn -> 0x04f6 }
            r14.zzb(r3, r2, r15)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0211:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x021a:
            r14.zzy(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x021f:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0228:
            r14.zzx(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x022d:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0236:
            r14.zzw(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x023b:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0244:
            r14.zzv(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0249:
            com.google.android.gms.internal.ads.zzecy r5 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzecn -> 0x04f6 }
            r14.zzu(r4)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzech r3 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0258:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeem.zza(r2, r4, r3, r10, r8)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x025e:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0267:
            r14.zzt(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x026c:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0275:
            r14.zzq(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x027a:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0283:
            r14.zzp(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0288:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x0291:
            r14.zzo(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0296:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x029f:
            r14.zzn(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x02a4:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x02ad:
            r14.zzl(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x02b2:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x02bb:
            r14.zzm(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x02c0:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x02c9:
            r14.zzk(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x02ce:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x02d7:
            r14.zzj(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x02dc:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x021a
        L_0x02e7:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0228
        L_0x02f2:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0236
        L_0x02fd:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0244
        L_0x0308:
            com.google.android.gms.internal.ads.zzecy r5 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzecn -> 0x04f6 }
            r14.zzu(r4)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzech r3 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0258
        L_0x0319:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0267
        L_0x0324:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            r14.zzs(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0332:
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzecy r5 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            r14.zza(r3, r2, (com.google.android.gms.internal.ads.zzebq) r15)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0344:
            boolean r2 = zzhe(r4)     // Catch:{ zzecn -> 0x04f6 }
            if (r2 == 0) goto L_0x0358
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            r14.zzr(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0358:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            r14.readStringList(r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x0366:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0275
        L_0x0371:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0283
        L_0x037c:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0291
        L_0x0387:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x029f
        L_0x0392:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x02ad
        L_0x039d:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x02bb
        L_0x03a8:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x02c9
        L_0x03b3:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x02d7
        L_0x03be:
            boolean r2 = r12.zze(r13, (int) r3)     // Catch:{ zzecn -> 0x04f6 }
            if (r2 == 0) goto L_0x03dc
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r4)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r3 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzecg.zzd(r2, r3)     // Catch:{ zzecn -> 0x04f6 }
        L_0x03d7:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x03dc:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x04f6 }
        L_0x03ea:
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x0009
        L_0x03ef:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbdm()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x03fa:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            int r2 = r14.zzbdl()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0405:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbdk()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0410:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            int r2 = r14.zzbdj()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x041b:
            int r5 = r14.zzbdi()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzech r7 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x04f6 }
            if (r7 == 0) goto L_0x042b
            boolean r7 = r7.zzf(r5)     // Catch:{ zzecn -> 0x04f6 }
            if (r7 == 0) goto L_0x00ea
        L_0x042b:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0432:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            int r2 = r14.zzbdh()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x043d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeaq r2 = r14.zzbdg()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0448:
            boolean r2 = r12.zze(r13, (int) r3)     // Catch:{ zzecn -> 0x04f6 }
            if (r2 == 0) goto L_0x0463
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r4)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r3 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzecg.zzd(r2, r3)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03d7
        L_0x0463:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x04f6 }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0473:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0478:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            boolean r2 = r14.zzbde()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0484:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            int r2 = r14.zzbdd()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x0490:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbdc()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x049c:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            int r2 = r14.zzbdb()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x04a8:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbcz()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x04b4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            long r6 = r14.zzbda()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            float r2 = r14.readFloat()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x04cc:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x04f6 }
            double r6 = r14.readDouble()     // Catch:{ zzecn -> 0x04f6 }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ zzecn -> 0x04f6 }
            goto L_0x03ea
        L_0x04d8:
            r10 = r2
        L_0x04d9:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ zzecn -> 0x04f6 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzian
        L_0x04e1:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x04f0
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x04e1
        L_0x04f0:
            if (r10 == 0) goto L_0x04f5
            r8.zzi(r13, r10)
        L_0x04f5:
            return
        L_0x04f6:
            r8.zza(r14)     // Catch:{ all -> 0x051d }
            if (r10 != 0) goto L_0x0500
            java.lang.Object r2 = r8.zzaz(r13)     // Catch:{ all -> 0x051d }
            r10 = r2
        L_0x0500:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ all -> 0x051d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzian
        L_0x0508:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x0517
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0508
        L_0x0517:
            if (r10 == 0) goto L_0x051c
            r8.zzi(r13, r10)
        L_0x051c:
            return
        L_0x051d:
            r14 = move-exception
            int r15 = r12.zzian
        L_0x0520:
            int r0 = r12.zziao
            if (r15 >= r0) goto L_0x052f
            int[] r0 = r12.zziam
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x0520
        L_0x052f:
            if (r10 == 0) goto L_0x0534
            r8.zzi(r13, r10)
        L_0x0534:
            throw r14
        L_0x0535:
            goto L_0x0537
        L_0x0536:
            throw r0
        L_0x0537:
            goto L_0x0536
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, com.google.android.gms.internal.ads.zzeee, com.google.android.gms.internal.ads.zzebq):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0387, code lost:
        r15.zzb(r9, com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r8 & 1048575)), zzgz(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a2, code lost:
        r15.zzi(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b3, code lost:
        r15.zzad(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03c4, code lost:
        r15.zzq(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d5, code lost:
        r15.zzal(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03e6, code lost:
        r15.zzam(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03f7, code lost:
        r15.zzac(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0402, code lost:
        r15.zza(r9, (com.google.android.gms.internal.ads.zzeaq) com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0415, code lost:
        r15.zza(r9, com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r8 & 1048575)), zzgz(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x042a, code lost:
        zza(r9, com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0441, code lost:
        r15.zzh(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0452, code lost:
        r15.zzae(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0462, code lost:
        r15.zzj(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0472, code lost:
        r15.zzab(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0482, code lost:
        r15.zzh(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0492, code lost:
        r15.zzp(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04a2, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04b2, code lost:
        r15.zzb(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0846, code lost:
        r15.zzb(r10, com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r9 & 1048575)), zzgz(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0861, code lost:
        r15.zzi(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0872, code lost:
        r15.zzad(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0883, code lost:
        r15.zzq(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0894, code lost:
        r15.zzal(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x08a5, code lost:
        r15.zzam(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x08b6, code lost:
        r15.zzac(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x08c1, code lost:
        r15.zza(r10, (com.google.android.gms.internal.ads.zzeaq) com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x08d4, code lost:
        r15.zza(r10, com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r9 & 1048575)), zzgz(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x08e9, code lost:
        zza(r10, com.google.android.gms.internal.ads.zzefi.zzp(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0900, code lost:
        r15.zzh(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0911, code lost:
        r15.zzae(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0921, code lost:
        r15.zzj(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0931, code lost:
        r15.zzab(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0941, code lost:
        r15.zzh(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0951, code lost:
        r15.zzp(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0961, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0971, code lost:
        r15.zzb(r10, r11);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x097a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzefv r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzbeb()
            int r1 = com.google.android.gms.internal.ads.zzecd.zzf.zzhyn
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04d1
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r13.zziar
            zza(r0, r14, (com.google.android.gms.internal.ads.zzefv) r15)
            boolean r0 = r13.zziai
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzebs<?> r0 = r13.zzias
            com.google.android.gms.internal.ads.zzebt r0 = r0.zzai(r14)
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r1 = r0.zzhut
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zziad
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x04b9
            int r8 = r13.zzhc(r7)
            int[] r9 = r13.zziad
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzebs<?> r10 = r13.zzias
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.ads.zzebs<?> r10 = r13.zzias
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04a6;
                case 1: goto L_0x0496;
                case 2: goto L_0x0486;
                case 3: goto L_0x0476;
                case 4: goto L_0x0466;
                case 5: goto L_0x0456;
                case 6: goto L_0x0446;
                case 7: goto L_0x0435;
                case 8: goto L_0x0424;
                case 9: goto L_0x040f;
                case 10: goto L_0x03fc;
                case 11: goto L_0x03eb;
                case 12: goto L_0x03da;
                case 13: goto L_0x03c9;
                case 14: goto L_0x03b8;
                case 15: goto L_0x03a7;
                case 16: goto L_0x0396;
                case 17: goto L_0x0381;
                case 18: goto L_0x0370;
                case 19: goto L_0x035f;
                case 20: goto L_0x034e;
                case 21: goto L_0x033d;
                case 22: goto L_0x032c;
                case 23: goto L_0x031b;
                case 24: goto L_0x030a;
                case 25: goto L_0x02f9;
                case 26: goto L_0x02e8;
                case 27: goto L_0x02d3;
                case 28: goto L_0x02c2;
                case 29: goto L_0x02b1;
                case 30: goto L_0x02a0;
                case 31: goto L_0x028f;
                case 32: goto L_0x027e;
                case 33: goto L_0x026d;
                case 34: goto L_0x025c;
                case 35: goto L_0x024b;
                case 36: goto L_0x023a;
                case 37: goto L_0x0229;
                case 38: goto L_0x0218;
                case 39: goto L_0x0207;
                case 40: goto L_0x01f6;
                case 41: goto L_0x01e5;
                case 42: goto L_0x01d4;
                case 43: goto L_0x01c3;
                case 44: goto L_0x01b2;
                case 45: goto L_0x01a1;
                case 46: goto L_0x0190;
                case 47: goto L_0x017f;
                case 48: goto L_0x016e;
                case 49: goto L_0x0159;
                case 50: goto L_0x014e;
                case 51: goto L_0x0140;
                case 52: goto L_0x0132;
                case 53: goto L_0x0124;
                case 54: goto L_0x0116;
                case 55: goto L_0x0108;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00ec;
                case 58: goto L_0x00de;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00ce;
                case 61: goto L_0x00c6;
                case 62: goto L_0x00b8;
                case 63: goto L_0x00aa;
                case 64: goto L_0x009c;
                case 65: goto L_0x008e;
                case 66: goto L_0x0080;
                case 67: goto L_0x0072;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x04b5
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0387
        L_0x0072:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            goto L_0x03a2
        L_0x0080:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            goto L_0x03b3
        L_0x008e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            goto L_0x03c4
        L_0x009c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            goto L_0x03d5
        L_0x00aa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            goto L_0x03e6
        L_0x00b8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            goto L_0x03f7
        L_0x00c6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0402
        L_0x00ce:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0415
        L_0x00d6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x042a
        L_0x00de:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            goto L_0x0441
        L_0x00ec:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            goto L_0x0452
        L_0x00fa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            goto L_0x0462
        L_0x0108:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            goto L_0x0472
        L_0x0116:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            goto L_0x0482
        L_0x0124:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            goto L_0x0492
        L_0x0132:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            goto L_0x04a2
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, (long) r10)
            goto L_0x04b2
        L_0x014e:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            r13.zza((com.google.android.gms.internal.ads.zzefv) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x04b5
        L_0x0159:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            com.google.android.gms.internal.ads.zzeem.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x04b5
        L_0x016e:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zze(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x017f:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzj(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0190:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzg(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01a1:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzl(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01b2:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzm(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01c3:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzi(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01d4:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzn(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01e5:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzk(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01f6:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzf(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0207:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzh(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0218:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzd(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0229:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzc(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x023a:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x04b5
        L_0x024b:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x04b5
        L_0x025c:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zze(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x026d:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzj(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x027e:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzg(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x028f:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzl(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02a0:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzm(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02b1:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzi(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02c2:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzb(r9, r8, r15)
            goto L_0x04b5
        L_0x02d3:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x04b5
        L_0x02e8:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x04b5
        L_0x02f9:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzn(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x030a:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzk(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x031b:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzf(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x032c:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzh(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x033d:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzd(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x034e:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzc(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x035f:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0370:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0381:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0387:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x04b5
        L_0x0396:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
        L_0x03a2:
            r15.zzi(r9, r10)
            goto L_0x04b5
        L_0x03a7:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
        L_0x03b3:
            r15.zzad(r9, r8)
            goto L_0x04b5
        L_0x03b8:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
        L_0x03c4:
            r15.zzq(r9, r10)
            goto L_0x04b5
        L_0x03c9:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
        L_0x03d5:
            r15.zzal(r9, r8)
            goto L_0x04b5
        L_0x03da:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
        L_0x03e6:
            r15.zzam(r9, r8)
            goto L_0x04b5
        L_0x03eb:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
        L_0x03f7:
            r15.zzac(r9, r8)
            goto L_0x04b5
        L_0x03fc:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0402:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeaq r8 = (com.google.android.gms.internal.ads.zzeaq) r8
            r15.zza((int) r9, (com.google.android.gms.internal.ads.zzeaq) r8)
            goto L_0x04b5
        L_0x040f:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0415:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x04b5
        L_0x0424:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x042a:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x04b5
        L_0x0435:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.ads.zzefi.zzm(r14, r10)
        L_0x0441:
            r15.zzh((int) r9, (boolean) r8)
            goto L_0x04b5
        L_0x0446:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
        L_0x0452:
            r15.zzae(r9, r8)
            goto L_0x04b5
        L_0x0456:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
        L_0x0462:
            r15.zzj(r9, r10)
            goto L_0x04b5
        L_0x0466:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
        L_0x0472:
            r15.zzab(r9, r8)
            goto L_0x04b5
        L_0x0476:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
        L_0x0482:
            r15.zzh((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0486:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
        L_0x0492:
            r15.zzp(r9, r10)
            goto L_0x04b5
        L_0x0496:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.ads.zzefi.zzn(r14, r10)
        L_0x04a2:
            r15.zza((int) r9, (float) r8)
            goto L_0x04b5
        L_0x04a6:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.ads.zzefi.zzo(r14, r10)
        L_0x04b2:
            r15.zzb((int) r9, (double) r10)
        L_0x04b5:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x04b9:
            if (r1 == 0) goto L_0x04d0
            com.google.android.gms.internal.ads.zzebs<?> r14 = r13.zzias
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04ce
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04b9
        L_0x04ce:
            r1 = r3
            goto L_0x04b9
        L_0x04d0:
            return
        L_0x04d1:
            boolean r0 = r13.zziak
            if (r0 == 0) goto L_0x0994
            boolean r0 = r13.zziai
            if (r0 == 0) goto L_0x04f2
            com.google.android.gms.internal.ads.zzebs<?> r0 = r13.zzias
            com.google.android.gms.internal.ads.zzebt r0 = r0.zzai(r14)
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r1 = r0.zzhut
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04f2
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f4
        L_0x04f2:
            r0 = r3
            r1 = r0
        L_0x04f4:
            int[] r7 = r13.zziad
            int r7 = r7.length
            r8 = 0
        L_0x04f8:
            if (r8 >= r7) goto L_0x0978
            int r9 = r13.zzhc(r8)
            int[] r10 = r13.zziad
            r10 = r10[r8]
        L_0x0502:
            if (r1 == 0) goto L_0x0520
            com.google.android.gms.internal.ads.zzebs<?> r11 = r13.zzias
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0520
            com.google.android.gms.internal.ads.zzebs<?> r11 = r13.zzias
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x051e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0502
        L_0x051e:
            r1 = r3
            goto L_0x0502
        L_0x0520:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0965;
                case 1: goto L_0x0955;
                case 2: goto L_0x0945;
                case 3: goto L_0x0935;
                case 4: goto L_0x0925;
                case 5: goto L_0x0915;
                case 6: goto L_0x0905;
                case 7: goto L_0x08f4;
                case 8: goto L_0x08e3;
                case 9: goto L_0x08ce;
                case 10: goto L_0x08bb;
                case 11: goto L_0x08aa;
                case 12: goto L_0x0899;
                case 13: goto L_0x0888;
                case 14: goto L_0x0877;
                case 15: goto L_0x0866;
                case 16: goto L_0x0855;
                case 17: goto L_0x0840;
                case 18: goto L_0x082f;
                case 19: goto L_0x081e;
                case 20: goto L_0x080d;
                case 21: goto L_0x07fc;
                case 22: goto L_0x07eb;
                case 23: goto L_0x07da;
                case 24: goto L_0x07c9;
                case 25: goto L_0x07b8;
                case 26: goto L_0x07a7;
                case 27: goto L_0x0792;
                case 28: goto L_0x0781;
                case 29: goto L_0x0770;
                case 30: goto L_0x075f;
                case 31: goto L_0x074e;
                case 32: goto L_0x073d;
                case 33: goto L_0x072c;
                case 34: goto L_0x071b;
                case 35: goto L_0x070a;
                case 36: goto L_0x06f9;
                case 37: goto L_0x06e8;
                case 38: goto L_0x06d7;
                case 39: goto L_0x06c6;
                case 40: goto L_0x06b5;
                case 41: goto L_0x06a4;
                case 42: goto L_0x0693;
                case 43: goto L_0x0682;
                case 44: goto L_0x0671;
                case 45: goto L_0x0660;
                case 46: goto L_0x064f;
                case 47: goto L_0x063e;
                case 48: goto L_0x062d;
                case 49: goto L_0x0618;
                case 50: goto L_0x060d;
                case 51: goto L_0x05ff;
                case 52: goto L_0x05f1;
                case 53: goto L_0x05e3;
                case 54: goto L_0x05d5;
                case 55: goto L_0x05c7;
                case 56: goto L_0x05b9;
                case 57: goto L_0x05ab;
                case 58: goto L_0x059d;
                case 59: goto L_0x0595;
                case 60: goto L_0x058d;
                case 61: goto L_0x0585;
                case 62: goto L_0x0577;
                case 63: goto L_0x0569;
                case 64: goto L_0x055b;
                case 65: goto L_0x054d;
                case 66: goto L_0x053f;
                case 67: goto L_0x0531;
                case 68: goto L_0x0529;
                default: goto L_0x0527;
            }
        L_0x0527:
            goto L_0x0974
        L_0x0529:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x0846
        L_0x0531:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            goto L_0x0861
        L_0x053f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            goto L_0x0872
        L_0x054d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            goto L_0x0883
        L_0x055b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            goto L_0x0894
        L_0x0569:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            goto L_0x08a5
        L_0x0577:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            goto L_0x08b6
        L_0x0585:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x08c1
        L_0x058d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x08d4
        L_0x0595:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x08e9
        L_0x059d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            goto L_0x0900
        L_0x05ab:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            goto L_0x0911
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            goto L_0x0921
        L_0x05c7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            goto L_0x0931
        L_0x05d5:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            goto L_0x0941
        L_0x05e3:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            goto L_0x0951
        L_0x05f1:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            goto L_0x0961
        L_0x05ff:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, (long) r11)
            goto L_0x0971
        L_0x060d:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            r13.zza((com.google.android.gms.internal.ads.zzefv) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0974
        L_0x0618:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            com.google.android.gms.internal.ads.zzeem.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0974
        L_0x062d:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zze(r10, r9, r15, r4)
            goto L_0x0974
        L_0x063e:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r10, r9, r15, r4)
            goto L_0x0974
        L_0x064f:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0660:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0671:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0682:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0693:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzn(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06a4:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06b5:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06c6:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06d7:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06e8:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06f9:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x0974
        L_0x070a:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x0974
        L_0x071b:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zze(r10, r9, r15, r5)
            goto L_0x0974
        L_0x072c:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r10, r9, r15, r5)
            goto L_0x0974
        L_0x073d:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r10, r9, r15, r5)
            goto L_0x0974
        L_0x074e:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r10, r9, r15, r5)
            goto L_0x0974
        L_0x075f:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r10, r9, r15, r5)
            goto L_0x0974
        L_0x0770:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r10, r9, r15, r5)
            goto L_0x0974
        L_0x0781:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb(r10, r9, r15)
            goto L_0x0974
        L_0x0792:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0974
        L_0x07a7:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x0974
        L_0x07b8:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzn(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07c9:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07da:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07eb:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07fc:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r10, r9, r15, r5)
            goto L_0x0974
        L_0x080d:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r10, r9, r15, r5)
            goto L_0x0974
        L_0x081e:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x0974
        L_0x082f:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x0974
        L_0x0840:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x0846:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0974
        L_0x0855:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
        L_0x0861:
            r15.zzi(r10, r11)
            goto L_0x0974
        L_0x0866:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
        L_0x0872:
            r15.zzad(r10, r9)
            goto L_0x0974
        L_0x0877:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
        L_0x0883:
            r15.zzq(r10, r11)
            goto L_0x0974
        L_0x0888:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
        L_0x0894:
            r15.zzal(r10, r9)
            goto L_0x0974
        L_0x0899:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
        L_0x08a5:
            r15.zzam(r10, r9)
            goto L_0x0974
        L_0x08aa:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
        L_0x08b6:
            r15.zzac(r10, r9)
            goto L_0x0974
        L_0x08bb:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08c1:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeaq r9 = (com.google.android.gms.internal.ads.zzeaq) r9
            r15.zza((int) r10, (com.google.android.gms.internal.ads.zzeaq) r9)
            goto L_0x0974
        L_0x08ce:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08d4:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0974
        L_0x08e3:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08e9:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x0974
        L_0x08f4:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.ads.zzefi.zzm(r14, r11)
        L_0x0900:
            r15.zzh((int) r10, (boolean) r9)
            goto L_0x0974
        L_0x0905:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
        L_0x0911:
            r15.zzae(r10, r9)
            goto L_0x0974
        L_0x0915:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
        L_0x0921:
            r15.zzj(r10, r11)
            goto L_0x0974
        L_0x0925:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
        L_0x0931:
            r15.zzab(r10, r9)
            goto L_0x0974
        L_0x0935:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
        L_0x0941:
            r15.zzh((int) r10, (long) r11)
            goto L_0x0974
        L_0x0945:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
        L_0x0951:
            r15.zzp(r10, r11)
            goto L_0x0974
        L_0x0955:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.ads.zzefi.zzn(r14, r11)
        L_0x0961:
            r15.zza((int) r10, (float) r9)
            goto L_0x0974
        L_0x0965:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.ads.zzefi.zzo(r14, r11)
        L_0x0971:
            r15.zzb((int) r10, (double) r11)
        L_0x0974:
            int r8 = r8 + 3
            goto L_0x04f8
        L_0x0978:
            if (r1 == 0) goto L_0x098e
            com.google.android.gms.internal.ads.zzebs<?> r2 = r13.zzias
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x098c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0978
        L_0x098c:
            r1 = r3
            goto L_0x0978
        L_0x098e:
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r13.zziar
            zza(r0, r14, (com.google.android.gms.internal.ads.zzefv) r15)
            return
        L_0x0994:
            r13.zzb(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, com.google.android.gms.internal.ads.zzefv):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        if (r6 == 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r1 = r11.zzhtd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r9.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f1, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0107, code lost:
        if (r6 == 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0109, code lost:
        r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r8, r11);
        r1 = r11.zzhtb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010f, code lost:
        r9.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0120, code lost:
        r0.putLong(r1, r2, r4);
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013f, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0141, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0145, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c8, code lost:
        if (r0 == r15) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f5, code lost:
        if (r0 == r15) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0212, code lost:
        if (r0 == r15) goto L_0x0214;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.zzeap r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zziak
            if (r0 == 0) goto L_0x0241
            sun.misc.Unsafe r9 = zzhgt
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0238
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.ads.zzeap) r11)
            int r3 = r11.zzhtb
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.zzan(r7, r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzhf(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0215
        L_0x004b:
            int[] r0 = r15.zziad
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x014d
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0134;
                case 1: goto L_0x0125;
                case 2: goto L_0x0113;
                case 3: goto L_0x0113;
                case 4: goto L_0x0105;
                case 5: goto L_0x00f5;
                case 6: goto L_0x00e4;
                case 7: goto L_0x00ce;
                case 8: goto L_0x00bc;
                case 9: goto L_0x00a1;
                case 10: goto L_0x0094;
                case 11: goto L_0x0105;
                case 12: goto L_0x008e;
                case 13: goto L_0x00e4;
                case 14: goto L_0x00f5;
                case 15: goto L_0x007e;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x018a
        L_0x0066:
            if (r6 != 0) goto L_0x018a
            int r6 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzhtc
            long r21 = com.google.android.gms.internal.ads.zzebf.zzfh(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            goto L_0x0120
        L_0x007e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r8, r11)
            int r1 = r11.zzhtb
            int r1 = com.google.android.gms.internal.ads.zzebf.zzfw(r1)
            goto L_0x010f
        L_0x008e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
            goto L_0x0109
        L_0x0094:
            r2 = r1
            if (r6 != r10) goto L_0x018a
            int r0 = com.google.android.gms.internal.ads.zzeam.zze(r12, r8, r11)
        L_0x009b:
            java.lang.Object r1 = r11.zzhtd
        L_0x009d:
            r9.putObject(r14, r2, r1)
            goto L_0x00f1
        L_0x00a1:
            r2 = r1
            if (r6 != r10) goto L_0x018a
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r4)
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.ads.zzeap) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00b5
            java.lang.Object r1 = r11.zzhtd
            goto L_0x009d
        L_0x00b5:
            java.lang.Object r5 = r11.zzhtd
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzecg.zzd(r1, r5)
            goto L_0x009d
        L_0x00bc:
            r2 = r1
            if (r6 != r10) goto L_0x018a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00c9
            int r0 = com.google.android.gms.internal.ads.zzeam.zzc(r12, r8, r11)
            goto L_0x009b
        L_0x00c9:
            int r0 = com.google.android.gms.internal.ads.zzeam.zzd(r12, r8, r11)
            goto L_0x009b
        L_0x00ce:
            r2 = r1
            if (r6 != 0) goto L_0x018a
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r8, r11)
            long r5 = r11.zzhtc
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x00f1
        L_0x00e4:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x018a
            int r0 = com.google.android.gms.internal.ads.zzeam.zzf(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x00f1:
            r2 = r4
            r1 = r7
            goto L_0x0235
        L_0x00f5:
            r2 = r1
            if (r6 != r0) goto L_0x018a
            long r5 = com.google.android.gms.internal.ads.zzeam.zzg(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x013f
        L_0x0105:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
        L_0x0109:
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r8, r11)
            int r1 = r11.zzhtb
        L_0x010f:
            r9.putInt(r14, r2, r1)
            goto L_0x0141
        L_0x0113:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0145
            int r6 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r8, r11)
            long r4 = r11.zzhtc
            r0 = r9
            r1 = r28
        L_0x0120:
            r0.putLong(r1, r2, r4)
            r0 = r6
            goto L_0x0141
        L_0x0125:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0145
            float r0 = com.google.android.gms.internal.ads.zzeam.zzi(r12, r8)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x0141
        L_0x0134:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0145
            double r0 = com.google.android.gms.internal.ads.zzeam.zzh(r12, r8)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x013f:
            int r0 = r8 + 8
        L_0x0141:
            r1 = r7
            r2 = r10
            goto L_0x0235
        L_0x0145:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x0191
        L_0x014d:
            r0 = 27
            if (r3 != r0) goto L_0x0195
            if (r6 != r10) goto L_0x018a
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.ads.zzecl r0 = (com.google.android.gms.internal.ads.zzecl) r0
            boolean r3 = r0.zzbci()
            if (r3 != 0) goto L_0x0171
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0168
            r3 = 10
            goto L_0x016a
        L_0x0168:
            int r3 = r3 << 1
        L_0x016a:
            com.google.android.gms.internal.ads.zzecl r0 = r0.zzfn(r3)
            r9.putObject(r14, r1, r0)
        L_0x0171:
            r5 = r0
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0235
        L_0x018a:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x0191:
            r26 = -1
            goto L_0x01f8
        L_0x0195:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01cb
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.ads.zzeap) r14)
            if (r0 != r15) goto L_0x0225
            goto L_0x0214
        L_0x01cb:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            r7 = r30
            if (r9 != r0) goto L_0x01fa
            if (r7 != r10) goto L_0x01f8
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.ads.zzeap) r8)
            if (r0 != r15) goto L_0x0225
            goto L_0x0214
        L_0x01f8:
            r2 = r15
            goto L_0x0215
        L_0x01fa:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.ads.zzeap) r13)
            if (r0 != r15) goto L_0x0225
        L_0x0214:
            r2 = r0
        L_0x0215:
            com.google.android.gms.internal.ads.zzefb r4 = zzav(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefb) r4, (com.google.android.gms.internal.ads.zzeap) r5)
        L_0x0225:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0235:
            r10 = -1
            goto L_0x0017
        L_0x0238:
            r4 = r13
            if (r0 != r4) goto L_0x023c
            return
        L_0x023c:
            com.google.android.gms.internal.ads.zzeco r0 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            throw r0
        L_0x0241:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeap) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeap):void");
    }

    public final void zzak(T t) {
        int i;
        int i2 = this.zzian;
        while (true) {
            i = this.zziao;
            if (i2 >= i) {
                break;
            }
            long zzhc = (long) (zzhc(this.zziam[i2]) & 1048575);
            Object zzp = zzefi.zzp(t, zzhc);
            if (zzp != null) {
                zzefi.zza((Object) t, zzhc, this.zziat.zzaq(zzp));
            }
            i2++;
        }
        int length = this.zziam.length;
        while (i < length) {
            this.zziaq.zzb(t, (long) this.zziam[i]);
            i++;
        }
        this.zziar.zzak(t);
        if (this.zziai) {
            this.zzias.zzak(t);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d7, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e8, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f9, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020a, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020c, code lost:
        r2.putInt(r1, (long) r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0210, code lost:
        r11 = ((com.google.android.gms.internal.ads.zzebk.zzgm(r3) + com.google.android.gms.internal.ads.zzebk.zzgk(r13)) + r3) + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02aa, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzc(r13, (com.google.android.gms.internal.ads.zzedo) com.google.android.gms.internal.ads.zzefi.zzp(r1, r14), zzgz(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02c4, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzm(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02d3, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzah(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02de, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzo(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02e9, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzaj(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02f8, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzak(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0307, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzag(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0312, code lost:
        r3 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x031d, code lost:
        r3 = com.google.android.gms.internal.ads.zzeem.zzc(r13, com.google.android.gms.internal.ads.zzefi.zzp(r1, r14), zzgz(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0329, code lost:
        r11 = r11 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0338, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzeaq) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x033a, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzc(r13, (com.google.android.gms.internal.ads.zzeaq) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0341, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzl(r13, (java.lang.String) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x034e, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzi(r13, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0359, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzai(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0364, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzn(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0373, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzaf(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0382, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzl(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0391, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzk(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x039c, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzb(r13, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03a7, code lost:
        r3 = com.google.android.gms.internal.ads.zzebk.zzc(r13, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03af, code lost:
        r10 = r10 + 3;
        r3 = 267386880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0476, code lost:
        if ((r6 instanceof com.google.android.gms.internal.ads.zzeaq) != false) goto L_0x072c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x050b, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x051d, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x052f, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0541, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0553, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0565, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0577, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0589, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x059a, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x05ab, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x05bc, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x05cd, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x05de, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x05ef, code lost:
        if (r0.zzial != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05f1, code lost:
        r2.putInt(r1, (long) r10, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05f5, code lost:
        r7 = ((com.google.android.gms.internal.ads.zzebk.zzgm(r6) + com.google.android.gms.internal.ads.zzebk.zzgk(r11)) + r6) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x06b0, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzc(r11, (com.google.android.gms.internal.ads.zzedo) r2.getObject(r1, r13), zzgz(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06c7, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzm(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x06d4, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzah(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x06dd, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzo(r11, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06e8, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzaj(r11, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06f6, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzak(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0703, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzag(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x070c, code lost:
        r6 = r2.getObject(r1, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0714, code lost:
        r6 = com.google.android.gms.internal.ads.zzeem.zzc(r11, r2.getObject(r1, r13), zzgz(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x072a, code lost:
        if ((r6 instanceof com.google.android.gms.internal.ads.zzeaq) != false) goto L_0x072c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x072c, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzc(r11, (com.google.android.gms.internal.ads.zzeaq) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0733, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzl(r11, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzeaq) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0751, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzn(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x075d, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzaf(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0769, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzl(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0775, code lost:
        r6 = com.google.android.gms.internal.ads.zzebk.zzk(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0779, code lost:
        r7 = r7 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0783, code lost:
        r7 = r7 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0790, code lost:
        r4 = r4 + 3;
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0126, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0138, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014a, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015c, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016e, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0180, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0192, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a4, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b5, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c6, code lost:
        if (r0.zzial != false) goto L_0x020c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzau(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.zziak
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 1
            r7 = 0
            r9 = 0
            if (r2 == 0) goto L_0x03bd
            sun.misc.Unsafe r2 = zzhgt
            r10 = 0
            r11 = 0
        L_0x0016:
            int[] r12 = r0.zziad
            int r12 = r12.length
            if (r10 >= r12) goto L_0x03b5
            int r12 = r0.zzhc(r10)
            r3 = r3 & r12
            int r3 = r3 >>> 20
            int[] r13 = r0.zziad
            r13 = r13[r10]
            r12 = r12 & r5
            long r14 = (long) r12
            com.google.android.gms.internal.ads.zzeby r12 = com.google.android.gms.internal.ads.zzeby.DOUBLE_LIST_PACKED
            int r12 = r12.mo16557id()
            if (r3 < r12) goto L_0x0040
            com.google.android.gms.internal.ads.zzeby r12 = com.google.android.gms.internal.ads.zzeby.SINT64_LIST_PACKED
            int r12 = r12.mo16557id()
            if (r3 > r12) goto L_0x0040
            int[] r12 = r0.zziad
            int r16 = r10 + 2
            r12 = r12[r16]
            r12 = r12 & r5
            goto L_0x0041
        L_0x0040:
            r12 = 0
        L_0x0041:
            switch(r3) {
                case 0: goto L_0x03a1;
                case 1: goto L_0x0396;
                case 2: goto L_0x0387;
                case 3: goto L_0x0378;
                case 4: goto L_0x0369;
                case 5: goto L_0x035e;
                case 6: goto L_0x0353;
                case 7: goto L_0x0348;
                case 8: goto L_0x032c;
                case 9: goto L_0x0317;
                case 10: goto L_0x030c;
                case 11: goto L_0x02fd;
                case 12: goto L_0x02ee;
                case 13: goto L_0x02e3;
                case 14: goto L_0x02d8;
                case 15: goto L_0x02c9;
                case 16: goto L_0x02ba;
                case 17: goto L_0x02a4;
                case 18: goto L_0x029a;
                case 19: goto L_0x0290;
                case 20: goto L_0x0286;
                case 21: goto L_0x027c;
                case 22: goto L_0x0272;
                case 23: goto L_0x029a;
                case 24: goto L_0x0290;
                case 25: goto L_0x0268;
                case 26: goto L_0x025e;
                case 27: goto L_0x0250;
                case 28: goto L_0x0246;
                case 29: goto L_0x023c;
                case 30: goto L_0x0232;
                case 31: goto L_0x0290;
                case 32: goto L_0x029a;
                case 33: goto L_0x0228;
                case 34: goto L_0x021e;
                case 35: goto L_0x01fc;
                case 36: goto L_0x01eb;
                case 37: goto L_0x01da;
                case 38: goto L_0x01c9;
                case 39: goto L_0x01b8;
                case 40: goto L_0x01a7;
                case 41: goto L_0x0196;
                case 42: goto L_0x0184;
                case 43: goto L_0x0172;
                case 44: goto L_0x0160;
                case 45: goto L_0x014e;
                case 46: goto L_0x013c;
                case 47: goto L_0x012a;
                case 48: goto L_0x0118;
                case 49: goto L_0x010a;
                case 50: goto L_0x00fa;
                case 51: goto L_0x00f2;
                case 52: goto L_0x00ea;
                case 53: goto L_0x00de;
                case 54: goto L_0x00d2;
                case 55: goto L_0x00c6;
                case 56: goto L_0x00be;
                case 57: goto L_0x00b6;
                case 58: goto L_0x00ae;
                case 59: goto L_0x009e;
                case 60: goto L_0x0096;
                case 61: goto L_0x008e;
                case 62: goto L_0x0082;
                case 63: goto L_0x0076;
                case 64: goto L_0x006e;
                case 65: goto L_0x0066;
                case 66: goto L_0x005a;
                case 67: goto L_0x004e;
                case 68: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x03af
        L_0x0046:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x02aa
        L_0x004e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zzi(r1, r14)
            goto L_0x02c4
        L_0x005a:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzh(r1, r14)
            goto L_0x02d3
        L_0x0066:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x02de
        L_0x006e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x02e9
        L_0x0076:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzh(r1, r14)
            goto L_0x02f8
        L_0x0082:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzh(r1, r14)
            goto L_0x0307
        L_0x008e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x0312
        L_0x0096:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x031d
        L_0x009e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r12 == 0) goto L_0x0341
            goto L_0x033a
        L_0x00ae:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x034e
        L_0x00b6:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x0359
        L_0x00be:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x0364
        L_0x00c6:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzh(r1, r14)
            goto L_0x0373
        L_0x00d2:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zzi(r1, r14)
            goto L_0x0382
        L_0x00de:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zzi(r1, r14)
            goto L_0x0391
        L_0x00ea:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x039c
        L_0x00f2:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x03a7
        L_0x00fa:
            com.google.android.gms.internal.ads.zzedh r3 = r0.zziat
            java.lang.Object r12 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14)
            java.lang.Object r14 = r0.zzha(r10)
            int r3 = r3.zzb(r13, r12, r14)
            goto L_0x0329
        L_0x010a:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.ads.zzeek r12 = r0.zzgz(r10)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzd(r13, r3, r12)
            goto L_0x0329
        L_0x0118:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzab(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x012a:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzaf(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x013c:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzah(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x014e:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzag(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0160:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzac(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0172:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzae(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0184:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzai(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0196:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzag(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01a7:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzah(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01b8:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzad(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01c9:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzaa(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01da:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzz(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01eb:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzag(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01fc:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzeem.zzah(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzial
            if (r14 == 0) goto L_0x0210
        L_0x020c:
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x0210:
            int r12 = com.google.android.gms.internal.ads.zzebk.zzgk(r13)
            int r13 = com.google.android.gms.internal.ads.zzebk.zzgm(r3)
            int r13 = r13 + r12
            int r13 = r13 + r3
            int r13 = r13 + r11
            r11 = r13
            goto L_0x03af
        L_0x021e:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzq(r13, r3, r9)
            goto L_0x0329
        L_0x0228:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzu(r13, r3, r9)
            goto L_0x0329
        L_0x0232:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzr(r13, r3, r9)
            goto L_0x0329
        L_0x023c:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzt(r13, r3, r9)
            goto L_0x0329
        L_0x0246:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzd(r13, r3)
            goto L_0x0329
        L_0x0250:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.ads.zzeek r12 = r0.zzgz(r10)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc((int) r13, (java.util.List<?>) r3, (com.google.android.gms.internal.ads.zzeek) r12)
            goto L_0x0329
        L_0x025e:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc(r13, r3)
            goto L_0x0329
        L_0x0268:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzx(r13, r3, r9)
            goto L_0x0329
        L_0x0272:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzs(r13, r3, r9)
            goto L_0x0329
        L_0x027c:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzp(r13, r3, r9)
            goto L_0x0329
        L_0x0286:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzo(r13, r3, r9)
            goto L_0x0329
        L_0x0290:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzv(r13, r3, r9)
            goto L_0x0329
        L_0x029a:
            java.util.List r3 = zze((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzw(r13, r3, r9)
            goto L_0x0329
        L_0x02a4:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02aa:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14)
            com.google.android.gms.internal.ads.zzedo r3 = (com.google.android.gms.internal.ads.zzedo) r3
            com.google.android.gms.internal.ads.zzeek r12 = r0.zzgz(r10)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc(r13, r3, r12)
            goto L_0x0329
        L_0x02ba:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.ads.zzefi.zzl(r1, r14)
        L_0x02c4:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzm(r13, r14)
            goto L_0x0329
        L_0x02c9:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r14)
        L_0x02d3:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzah(r13, r3)
            goto L_0x0329
        L_0x02d8:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02de:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzo(r13, r7)
            goto L_0x0329
        L_0x02e3:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02e9:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzaj(r13, r9)
            goto L_0x0329
        L_0x02ee:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r14)
        L_0x02f8:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzak(r13, r3)
            goto L_0x0329
        L_0x02fd:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r14)
        L_0x0307:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzag(r13, r3)
            goto L_0x0329
        L_0x030c:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0312:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14)
            goto L_0x033a
        L_0x0317:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x031d:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14)
            com.google.android.gms.internal.ads.zzeek r12 = r0.zzgz(r10)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.ads.zzeek) r12)
        L_0x0329:
            int r11 = r11 + r3
            goto L_0x03af
        L_0x032c:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r12 == 0) goto L_0x0341
        L_0x033a:
            com.google.android.gms.internal.ads.zzeaq r3 = (com.google.android.gms.internal.ads.zzeaq) r3
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r13, (com.google.android.gms.internal.ads.zzeaq) r3)
            goto L_0x0329
        L_0x0341:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.ads.zzebk.zzl((int) r13, (java.lang.String) r3)
            goto L_0x0329
        L_0x0348:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x034e:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzi((int) r13, (boolean) r6)
            goto L_0x0329
        L_0x0353:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0359:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzai(r13, r9)
            goto L_0x0329
        L_0x035e:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0364:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzn(r13, r7)
            goto L_0x0329
        L_0x0369:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r14)
        L_0x0373:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzaf(r13, r3)
            goto L_0x0329
        L_0x0378:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.ads.zzefi.zzl(r1, r14)
        L_0x0382:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzl((int) r13, (long) r14)
            goto L_0x0329
        L_0x0387:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.ads.zzefi.zzl(r1, r14)
        L_0x0391:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzk((int) r13, (long) r14)
            goto L_0x0329
        L_0x0396:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x039c:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzb((int) r13, (float) r4)
            goto L_0x0329
        L_0x03a1:
            boolean r3 = r0.zze(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x03a7:
            r14 = 0
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r13, (double) r14)
            goto L_0x0329
        L_0x03af:
            int r10 = r10 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x03b5:
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r0.zziar
            int r1 = zza(r2, r1)
            int r11 = r11 + r1
            return r11
        L_0x03bd:
            sun.misc.Unsafe r2 = zzhgt
            r3 = -1
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x03c3:
            int[] r9 = r0.zziad
            int r9 = r9.length
            if (r4 >= r9) goto L_0x0795
            int r9 = r0.zzhc(r4)
            int[] r10 = r0.zziad
            r11 = r10[r4]
            r12 = 267386880(0xff00000, float:2.3665827E-29)
            r12 = r12 & r9
            int r12 = r12 >>> 20
            r13 = 17
            if (r12 > r13) goto L_0x03eb
            int r13 = r4 + 2
            r10 = r10[r13]
            r13 = r10 & r5
            int r14 = r10 >>> 20
            int r6 = r6 << r14
            if (r13 == r3) goto L_0x040b
            long r14 = (long) r13
            int r8 = r2.getInt(r1, r14)
            r3 = r13
            goto L_0x040b
        L_0x03eb:
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x0408
            com.google.android.gms.internal.ads.zzeby r6 = com.google.android.gms.internal.ads.zzeby.DOUBLE_LIST_PACKED
            int r6 = r6.mo16557id()
            if (r12 < r6) goto L_0x0408
            com.google.android.gms.internal.ads.zzeby r6 = com.google.android.gms.internal.ads.zzeby.SINT64_LIST_PACKED
            int r6 = r6.mo16557id()
            if (r12 > r6) goto L_0x0408
            int[] r6 = r0.zziad
            int r10 = r4 + 2
            r6 = r6[r10]
            r6 = r6 & r5
            r10 = r6
            goto L_0x040a
        L_0x0408:
            r6 = 0
            r10 = 0
        L_0x040a:
            r6 = 0
        L_0x040b:
            r9 = r9 & r5
            long r13 = (long) r9
            switch(r12) {
                case 0: goto L_0x0785;
                case 1: goto L_0x077b;
                case 2: goto L_0x076e;
                case 3: goto L_0x0762;
                case 4: goto L_0x0756;
                case 5: goto L_0x074c;
                case 6: goto L_0x0743;
                case 7: goto L_0x073a;
                case 8: goto L_0x0721;
                case 9: goto L_0x0711;
                case 10: goto L_0x0709;
                case 11: goto L_0x06fc;
                case 12: goto L_0x06ef;
                case 13: goto L_0x06e5;
                case 14: goto L_0x06da;
                case 15: goto L_0x06cd;
                case 16: goto L_0x06c0;
                case 17: goto L_0x06ad;
                case 18: goto L_0x066c;
                case 19: goto L_0x06a0;
                case 20: goto L_0x0693;
                case 21: goto L_0x0686;
                case 22: goto L_0x0679;
                case 23: goto L_0x066c;
                case 24: goto L_0x06a0;
                case 25: goto L_0x065f;
                case 26: goto L_0x0653;
                case 27: goto L_0x0643;
                case 28: goto L_0x0637;
                case 29: goto L_0x062a;
                case 30: goto L_0x061d;
                case 31: goto L_0x06a0;
                case 32: goto L_0x066c;
                case 33: goto L_0x0610;
                case 34: goto L_0x0603;
                case 35: goto L_0x05e1;
                case 36: goto L_0x05d0;
                case 37: goto L_0x05bf;
                case 38: goto L_0x05ae;
                case 39: goto L_0x059d;
                case 40: goto L_0x058c;
                case 41: goto L_0x057b;
                case 42: goto L_0x0569;
                case 43: goto L_0x0557;
                case 44: goto L_0x0545;
                case 45: goto L_0x0533;
                case 46: goto L_0x0521;
                case 47: goto L_0x050f;
                case 48: goto L_0x04fd;
                case 49: goto L_0x04ed;
                case 50: goto L_0x04dd;
                case 51: goto L_0x04cf;
                case 52: goto L_0x04c2;
                case 53: goto L_0x04b6;
                case 54: goto L_0x04aa;
                case 55: goto L_0x049e;
                case 56: goto L_0x0494;
                case 57: goto L_0x0487;
                case 58: goto L_0x047a;
                case 59: goto L_0x046a;
                case 60: goto L_0x0462;
                case 61: goto L_0x045a;
                case 62: goto L_0x044e;
                case 63: goto L_0x0442;
                case 64: goto L_0x043a;
                case 65: goto L_0x0432;
                case 66: goto L_0x0426;
                case 67: goto L_0x041a;
                case 68: goto L_0x0412;
                default: goto L_0x0410;
            }
        L_0x0410:
            goto L_0x0790
        L_0x0412:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x06b0
        L_0x041a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            long r9 = zzi(r1, r13)
            goto L_0x06c7
        L_0x0426:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzh(r1, r13)
            goto L_0x06d4
        L_0x0432:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x06dd
        L_0x043a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x06e8
        L_0x0442:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzh(r1, r13)
            goto L_0x06f6
        L_0x044e:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzh(r1, r13)
            goto L_0x0703
        L_0x045a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x070c
        L_0x0462:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x0714
        L_0x046a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            java.lang.Object r6 = r2.getObject(r1, r13)
            boolean r9 = r6 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r9 == 0) goto L_0x0733
            goto L_0x072c
        L_0x047a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r6 = 1
            int r6 = com.google.android.gms.internal.ads.zzebk.zzi((int) r11, (boolean) r6)
            goto L_0x0779
        L_0x0487:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzai(r11, r6)
            goto L_0x0779
        L_0x0494:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r9 = 0
            goto L_0x0751
        L_0x049e:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzh(r1, r13)
            goto L_0x075d
        L_0x04aa:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            long r9 = zzi(r1, r13)
            goto L_0x0769
        L_0x04b6:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            long r9 = zzi(r1, r13)
            goto L_0x0775
        L_0x04c2:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzb((int) r11, (float) r6)
            goto L_0x0779
        L_0x04cf:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r9 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzc((int) r11, (double) r9)
            goto L_0x0779
        L_0x04dd:
            com.google.android.gms.internal.ads.zzedh r6 = r0.zziat
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.lang.Object r10 = r0.zzha(r4)
            int r6 = r6.zzb(r11, r9, r10)
            goto L_0x0779
        L_0x04ed:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r4)
            int r6 = com.google.android.gms.internal.ads.zzeem.zzd(r11, r6, r9)
            goto L_0x0779
        L_0x04fd:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzab(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x050f:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzaf(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0521:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzah(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0533:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzag(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0545:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzac(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0557:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzae(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0569:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzai(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x057b:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzag(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x058c:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzah(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x059d:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzad(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05ae:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzaa(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05bf:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzz(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05d0:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzag(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05e1:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzah(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x05f5
        L_0x05f1:
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x05f5:
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgk(r11)
            int r10 = com.google.android.gms.internal.ads.zzebk.zzgm(r6)
            int r10 = r10 + r9
            int r10 = r10 + r6
            int r10 = r10 + r7
            r7 = r10
            goto L_0x0790
        L_0x0603:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.ads.zzeem.zzq(r11, r6, r9)
            goto L_0x0779
        L_0x0610:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzu(r11, r9, r6)
            goto L_0x0779
        L_0x061d:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzr(r11, r9, r6)
            goto L_0x0779
        L_0x062a:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzt(r11, r9, r6)
            goto L_0x0779
        L_0x0637:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzd(r11, r6)
            goto L_0x0779
        L_0x0643:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r4)
            int r6 = com.google.android.gms.internal.ads.zzeem.zzc((int) r11, (java.util.List<?>) r6, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0779
        L_0x0653:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.ads.zzeem.zzc(r11, r6)
            goto L_0x0779
        L_0x065f:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.ads.zzeem.zzx(r11, r6, r9)
            goto L_0x0779
        L_0x066c:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzw(r11, r9, r6)
            goto L_0x0779
        L_0x0679:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzs(r11, r9, r6)
            goto L_0x0779
        L_0x0686:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzp(r11, r9, r6)
            goto L_0x0779
        L_0x0693:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzo(r11, r9, r6)
            goto L_0x0779
        L_0x06a0:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.ads.zzeem.zzv(r11, r9, r6)
            goto L_0x0779
        L_0x06ad:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x06b0:
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzedo r6 = (com.google.android.gms.internal.ads.zzedo) r6
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r4)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzc(r11, r6, r9)
            goto L_0x0779
        L_0x06c0:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            long r9 = r2.getLong(r1, r13)
        L_0x06c7:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzm(r11, r9)
            goto L_0x0779
        L_0x06cd:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x06d4:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzah(r11, r6)
            goto L_0x0779
        L_0x06da:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x06dd:
            r9 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzo(r11, r9)
            goto L_0x0779
        L_0x06e5:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x06e8:
            r6 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzaj(r11, r6)
            goto L_0x0779
        L_0x06ef:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x06f6:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzak(r11, r6)
            goto L_0x0779
        L_0x06fc:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x0703:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzag(r11, r6)
            goto L_0x0779
        L_0x0709:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x070c:
            java.lang.Object r6 = r2.getObject(r1, r13)
            goto L_0x072c
        L_0x0711:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x0714:
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r4)
            int r6 = com.google.android.gms.internal.ads.zzeem.zzc((int) r11, (java.lang.Object) r6, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0779
        L_0x0721:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            java.lang.Object r6 = r2.getObject(r1, r13)
            boolean r9 = r6 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r9 == 0) goto L_0x0733
        L_0x072c:
            com.google.android.gms.internal.ads.zzeaq r6 = (com.google.android.gms.internal.ads.zzeaq) r6
            int r6 = com.google.android.gms.internal.ads.zzebk.zzc((int) r11, (com.google.android.gms.internal.ads.zzeaq) r6)
            goto L_0x0779
        L_0x0733:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.ads.zzebk.zzl((int) r11, (java.lang.String) r6)
            goto L_0x0779
        L_0x073a:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r6 = 1
            int r6 = com.google.android.gms.internal.ads.zzebk.zzi((int) r11, (boolean) r6)
            goto L_0x0783
        L_0x0743:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzai(r11, r6)
            goto L_0x0783
        L_0x074c:
            r6 = r6 & r8
            r9 = 0
            if (r6 == 0) goto L_0x0790
        L_0x0751:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzn(r11, r9)
            goto L_0x0779
        L_0x0756:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x075d:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzaf(r11, r6)
            goto L_0x0779
        L_0x0762:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            long r9 = r2.getLong(r1, r13)
        L_0x0769:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzl((int) r11, (long) r9)
            goto L_0x0779
        L_0x076e:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            long r9 = r2.getLong(r1, r13)
        L_0x0775:
            int r6 = com.google.android.gms.internal.ads.zzebk.zzk((int) r11, (long) r9)
        L_0x0779:
            int r7 = r7 + r6
            goto L_0x0790
        L_0x077b:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzb((int) r11, (float) r6)
        L_0x0783:
            int r7 = r7 + r6
            goto L_0x0790
        L_0x0785:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r9 = 0
            int r6 = com.google.android.gms.internal.ads.zzebk.zzc((int) r11, (double) r9)
            int r6 = r6 + r7
            r7 = r6
        L_0x0790:
            int r4 = r4 + 3
            r6 = 1
            goto L_0x03c3
        L_0x0795:
            r2 = 0
            com.google.android.gms.internal.ads.zzefc<?, ?> r3 = r0.zziar
            int r3 = zza(r3, r1)
            int r7 = r7 + r3
            boolean r3 = r0.zziai
            if (r3 == 0) goto L_0x07ef
            com.google.android.gms.internal.ads.zzebs<?> r3 = r0.zzias
            com.google.android.gms.internal.ads.zzebt r1 = r3.zzai(r1)
            r3 = 0
        L_0x07a8:
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r4 = r1.zzhut
            int r4 = r4.zzbgq()
            if (r3 >= r4) goto L_0x07c8
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r4 = r1.zzhut
            java.util.Map$Entry r4 = r4.zzhj(r3)
            java.lang.Object r5 = r4.getKey()
            com.google.android.gms.internal.ads.zzebv r5 = (com.google.android.gms.internal.ads.zzebv) r5
            java.lang.Object r4 = r4.getValue()
            int r4 = com.google.android.gms.internal.ads.zzebt.zzb((com.google.android.gms.internal.ads.zzebv<?>) r5, (java.lang.Object) r4)
            int r2 = r2 + r4
            int r3 = r3 + 1
            goto L_0x07a8
        L_0x07c8:
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r1 = r1.zzhut
            java.lang.Iterable r1 = r1.zzbgr()
            java.util.Iterator r1 = r1.iterator()
        L_0x07d2:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x07ee
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.ads.zzebv r4 = (com.google.android.gms.internal.ads.zzebv) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.ads.zzebt.zzb((com.google.android.gms.internal.ads.zzebv<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x07d2
        L_0x07ee:
            int r7 = r7 + r2
        L_0x07ef:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzau(java.lang.Object):int");
    }

    public final boolean zzaw(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzian) {
                return !this.zziai || this.zzias.zzai(t).isInitialized();
            }
            int i5 = this.zziam[i3];
            int i6 = this.zziad[i5];
            int zzhc = zzhc(i5);
            if (!this.zziak) {
                int i7 = this.zziad[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzhgt.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzhc) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzhc) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzhc, zzgz(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzao = this.zziat.zzao(zzefi.zzp(t, (long) (zzhc & 1048575)));
                            if (!zzao.isEmpty()) {
                                if (this.zziat.zzas(zzha(i5)).zzhzy.zzbhn() == zzefw.MESSAGE) {
                                    zzeek<?> zzeek = null;
                                    Iterator<?> it = zzao.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzeek == null) {
                                            zzeek = zzedz.zzbgk().zzh(next.getClass());
                                        }
                                        if (!zzeek.zzaw(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzefi.zzp(t, (long) (zzhc & 1048575));
                if (!list.isEmpty()) {
                    zzeek zzgz = zzgz(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzgz.zzaw(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzhc, zzgz(i5))) {
                return false;
            }
            i3++;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.ads.zzefi.zzp(r8, r2));
        zzb(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.ads.zzefi.zzp(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r7, r2, com.google.android.gms.internal.ads.zzefi.zzk(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.ads.zzefi.zzl(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        zzf(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0101
            r0 = 0
        L_0x0003:
            int[] r1 = r6.zziad
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.zzhc(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zziad
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009f;
                case 7: goto L_0x0091;
                case 8: goto L_0x0083;
                case 9: goto L_0x007e;
                case 10: goto L_0x0077;
                case 11: goto L_0x0070;
                case 12: goto L_0x0069;
                case 13: goto L_0x0062;
                case 14: goto L_0x005a;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x007e;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00ee
        L_0x001f:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0031
        L_0x0026:
            r6.zzb(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x002b:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0031:
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzefi.zzp(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.zzb(r7, (int) r4, (int) r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.ads.zzedh r1 = r6.zziat
            com.google.android.gms.internal.ads.zzeem.zza((com.google.android.gms.internal.ads.zzedh) r1, r7, r8, (long) r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.ads.zzecy r1 = r6.zziaq
            r1.zza(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.zza(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzefi.zzp(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.ads.zzefi.zzm(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.ads.zzefi.zzk(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, (long) r2, (long) r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.ads.zzefi.zzn(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.zze(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.ads.zzefi.zzo(r8, r2)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r7, (long) r2, (double) r4)
        L_0x00eb:
            r6.zzf(r7, (int) r0)
        L_0x00ee:
            int r0 = r0 + 3
            goto L_0x0003
        L_0x00f2:
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r6.zziar
            com.google.android.gms.internal.ads.zzeem.zza(r0, r7, r8)
            boolean r0 = r6.zziai
            if (r0 == 0) goto L_0x0100
            com.google.android.gms.internal.ads.zzebs<?> r0 = r6.zzias
            com.google.android.gms.internal.ads.zzeem.zza(r0, r7, r8)
        L_0x0100:
            return
        L_0x0101:
            r7 = 0
            goto L_0x0104
        L_0x0103:
            throw r7
        L_0x0104:
            goto L_0x0103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzf(java.lang.Object, java.lang.Object):void");
    }
}
