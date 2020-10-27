package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import sun.misc.Unsafe;

final class zzjn<T> implements zzkc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzla.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjr zzo;
    private final zzit zzp;
    private final zzku<?, ?> zzq;
    private final zzhq<?> zzr;
    private final zzjg zzs;

    private zzjn(int[] iArr, Object[] objArr, int i, int i2, zzjj zzjj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjr zzjr, zzit zzit, zzku<?, ?> zzku, zzhq<?> zzhq, zzjg zzjg) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjj instanceof zzib;
        this.zzj = z;
        this.zzh = zzhq != null && zzhq.zza(zzjj);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjr;
        this.zzp = zzit;
        this.zzq = zzku;
        this.zzr = zzhq;
        this.zzg = zzjj;
        this.zzs = zzjg;
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private static <UT, UB> int zza(zzku<UT, UB> zzku, T t) {
        return zzku.zzf(zzku.zzb(t));
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
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzgo r29) throws java.io.IOException {
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
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
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
            com.google.android.gms.internal.measurement.zzkc r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.measurement.zzgo) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.zzc
            if (r15 != 0) goto L_0x0052
            goto L_0x0144
        L_0x0052:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0144
        L_0x0058:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.measurement.zzhf.zza((long) r3)
            goto L_0x0140
        L_0x0066:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze(r3)
            goto L_0x0133
        L_0x0074:
            if (r5 != 0) goto L_0x016c
            int r3 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.measurement.zzif r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x0098
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x0089
            goto L_0x0098
        L_0x0089:
            com.google.android.gms.internal.measurement.zzkt r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x016d
        L_0x0098:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x0168
        L_0x00a2:
            if (r5 != r15) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            goto L_0x0144
        L_0x00ac:
            if (r5 != r15) goto L_0x016c
            com.google.android.gms.internal.measurement.zzkc r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgo) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00c3
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00c4
        L_0x00c3:
            r15 = 0
        L_0x00c4:
            java.lang.Object r3 = r11.zzc
            if (r15 != 0) goto L_0x00ca
            goto L_0x0144
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0144
        L_0x00d0:
            if (r5 != r15) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x00dd
            java.lang.String r3 = ""
            goto L_0x0144
        L_0x00dd:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00f1
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzlc.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x00ec
            goto L_0x00f1
        L_0x00ec:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzh()
            throw r1
        L_0x00f1:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzie.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
            goto L_0x0168
        L_0x00fe:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4, r11)
            long r3 = r11.zzb
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
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0152
        L_0x011f:
            r2 = 1
            if (r5 != r2) goto L_0x016c
            long r2 = com.google.android.gms.internal.measurement.zzgp.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0163
        L_0x012b:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r11)
            int r3 = r11.zza
        L_0x0133:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0144
        L_0x0138:
            if (r5 != 0) goto L_0x016c
            int r2 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4, r11)
            long r3 = r11.zzb
        L_0x0140:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0144:
            r12.putObject(r1, r9, r3)
            goto L_0x0168
        L_0x0148:
            if (r5 != r7) goto L_0x016c
            float r2 = com.google.android.gms.internal.measurement.zzgp.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0152:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0168
        L_0x0158:
            r2 = 1
            if (r5 != r2) goto L_0x016c
            double r2 = com.google.android.gms.internal.measurement.zzgp.zzc(r18, r19)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x026e, code lost:
        if (r7.zzb != 0) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0270, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0272, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0273, code lost:
        r11.zza(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0276, code lost:
        if (r4 >= r5) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0278, code lost:
        r6 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x027e, code lost:
        if (r2 != r7.zza) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0280, code lost:
        r4 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0288, code lost:
        if (r7.zzb == 0) goto L_0x0272;
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
        r11.add(com.google.android.gms.internal.measurement.zzgt.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0148, code lost:
        r11.add(com.google.android.gms.internal.measurement.zzgt.zza(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0150, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0152, code lost:
        r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0158, code lost:
        if (r2 != r7.zza) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015a, code lost:
        r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7);
        r4 = r7.zza;
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
        throw com.google.android.gms.internal.measurement.zzij.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0172, code lost:
        throw com.google.android.gms.internal.measurement.zzij.zzb();
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzgo r30) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzik r11 = (com.google.android.gms.internal.measurement.zzik) r11
            boolean r12 = r11.zza()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzik r11 = r11.zza(r12)
            sun.misc.Unsafe r12 = zzb
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
            com.google.android.gms.internal.measurement.zzkc r1 = r0.zza((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgo) r27)
        L_0x005a:
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            if (r4 >= r5) goto L_0x03d7
            int r8 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x03d7
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgo) r27)
            goto L_0x005a
        L_0x007a:
            if (r6 != r10) goto L_0x009e
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzhf.zza((long) r4)
            r11.zza((long) r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x03d8
        L_0x0099:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
        L_0x00a2:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzhf.zza((long) r8)
            r11.zza((long) r8)
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            goto L_0x00a2
        L_0x00ba:
            if (r6 != r10) goto L_0x00de
            com.google.android.gms.internal.measurement.zzic r11 = (com.google.android.gms.internal.measurement.zzic) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00c5:
            if (r1 >= r2) goto L_0x00d5
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzhf.zze(r4)
            r11.zzd(r4)
            goto L_0x00c5
        L_0x00d5:
            if (r1 != r2) goto L_0x00d9
            goto L_0x03d8
        L_0x00d9:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x00de:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzic r11 = (com.google.android.gms.internal.measurement.zzic) r11
        L_0x00e2:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzhf.zze(r4)
            r11.zzd(r4)
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            goto L_0x00e2
        L_0x00fa:
            if (r6 != r10) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzik<?>) r11, (com.google.android.gms.internal.measurement.zzgo) r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x03d7
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzik<?>) r6, (com.google.android.gms.internal.measurement.zzgo) r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1
            com.google.android.gms.internal.measurement.zzkt r3 = r1.zzb
            com.google.android.gms.internal.measurement.zzkt r4 = com.google.android.gms.internal.measurement.zzkt.zza()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.measurement.zzif r4 = r0.zzc((int) r8)
            com.google.android.gms.internal.measurement.zzku<?, ?> r5 = r0.zzq
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzke.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzkt r3 = (com.google.android.gms.internal.measurement.zzkt) r3
            if (r3 == 0) goto L_0x012f
            r1.zzb = r3
        L_0x012f:
            r1 = r2
            goto L_0x03d8
        L_0x0132:
            if (r6 != r10) goto L_0x03d7
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0178
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0173
            if (r4 != 0) goto L_0x0148
        L_0x0142:
            com.google.android.gms.internal.measurement.zzgt r4 = com.google.android.gms.internal.measurement.zzgt.zza
            r11.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.measurement.zzgt r6 = com.google.android.gms.internal.measurement.zzgt.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x016e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0169
            if (r4 != 0) goto L_0x0148
            goto L_0x0142
        L_0x0169:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x016e:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x0173:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x0178:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x017d:
            if (r6 != r10) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzkc r1 = r0.zza((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x03d8
        L_0x0197:
            if (r6 != r10) goto L_0x03d7
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            if (r6 != 0) goto L_0x01e4
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01df
            if (r6 != 0) goto L_0x01b2
        L_0x01ae:
            r11.add(r1)
            goto L_0x01bd
        L_0x01b2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzie.zza
            r8.<init>(r3, r4, r6, r9)
        L_0x01b9:
            r11.add(r8)
            int r4 = r4 + r6
        L_0x01bd:
            if (r4 >= r5) goto L_0x03d7
            int r6 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x03d7
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01da
            if (r6 != 0) goto L_0x01d2
            goto L_0x01ae
        L_0x01d2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzie.zza
            r8.<init>(r3, r4, r6, r9)
            goto L_0x01b9
        L_0x01da:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x01df:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x01e4:
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0235
            if (r6 != 0) goto L_0x01ee
        L_0x01ea:
            r11.add(r1)
            goto L_0x0201
        L_0x01ee:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzlc.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0230
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzie.zza
            r9.<init>(r3, r4, r6, r10)
        L_0x01fd:
            r11.add(r9)
            r4 = r8
        L_0x0201:
            if (r4 >= r5) goto L_0x03d7
            int r6 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x03d7
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x022b
            if (r6 != 0) goto L_0x0216
            goto L_0x01ea
        L_0x0216:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzlc.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0226
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzie.zza
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01fd
        L_0x0226:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzh()
            throw r1
        L_0x022b:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x0230:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzh()
            throw r1
        L_0x0235:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x023a:
            r1 = 0
            if (r6 != r10) goto L_0x0262
            com.google.android.gms.internal.measurement.zzgr r11 = (com.google.android.gms.internal.measurement.zzgr) r11
            int r2 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0246:
            if (r2 >= r4) goto L_0x0259
            int r2 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0254
            r5 = 1
            goto L_0x0255
        L_0x0254:
            r5 = 0
        L_0x0255:
            r11.zza((boolean) r5)
            goto L_0x0246
        L_0x0259:
            if (r2 != r4) goto L_0x025d
            goto L_0x012f
        L_0x025d:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x0262:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzgr r11 = (com.google.android.gms.internal.measurement.zzgr) r11
            int r4 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0272
        L_0x0270:
            r6 = 1
            goto L_0x0273
        L_0x0272:
            r6 = 0
        L_0x0273:
            r11.zza((boolean) r6)
            if (r4 >= r5) goto L_0x03d7
            int r6 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x03d7
            int r4 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0272
            goto L_0x0270
        L_0x028b:
            if (r6 != r10) goto L_0x02ab
            com.google.android.gms.internal.measurement.zzic r11 = (com.google.android.gms.internal.measurement.zzic) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0296:
            if (r1 >= r2) goto L_0x02a2
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x0296
        L_0x02a2:
            if (r1 != r2) goto L_0x02a6
            goto L_0x03d8
        L_0x02a6:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x02ab:
            if (r6 != r9) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzic r11 = (com.google.android.gms.internal.measurement.zzic) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r18, r19)
            r11.zzd(r1)
        L_0x02b6:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4)
            r11.zzd(r1)
            goto L_0x02b6
        L_0x02ca:
            if (r6 != r10) goto L_0x02ea
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d5:
            if (r1 >= r2) goto L_0x02e1
            long r4 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r1)
            r11.zza((long) r4)
            int r1 = r1 + 8
            goto L_0x02d5
        L_0x02e1:
            if (r1 != r2) goto L_0x02e5
            goto L_0x03d8
        L_0x02e5:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x02ea:
            if (r6 != r13) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            long r8 = com.google.android.gms.internal.measurement.zzgp.zzb(r18, r19)
            r11.zza((long) r8)
        L_0x02f5:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            long r8 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4)
            r11.zza((long) r8)
            goto L_0x02f5
        L_0x0309:
            if (r6 != r10) goto L_0x0311
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzik<?>) r11, (com.google.android.gms.internal.measurement.zzgo) r7)
            goto L_0x03d8
        L_0x0311:
            if (r6 != 0) goto L_0x03d7
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.measurement.zzik<?>) r25, (com.google.android.gms.internal.measurement.zzgo) r26)
            goto L_0x03d8
        L_0x0323:
            if (r6 != r10) goto L_0x0343
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x032e:
            if (r1 >= r2) goto L_0x033a
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r11.zza((long) r4)
            goto L_0x032e
        L_0x033a:
            if (r1 != r2) goto L_0x033e
            goto L_0x03d8
        L_0x033e:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x0343:
            if (r6 != 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
        L_0x0347:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            goto L_0x0347
        L_0x035b:
            if (r6 != r10) goto L_0x037a
            com.google.android.gms.internal.measurement.zzhx r11 = (com.google.android.gms.internal.measurement.zzhx) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0366:
            if (r1 >= r2) goto L_0x0372
            float r4 = com.google.android.gms.internal.measurement.zzgp.zzd(r3, r1)
            r11.zza((float) r4)
            int r1 = r1 + 4
            goto L_0x0366
        L_0x0372:
            if (r1 != r2) goto L_0x0375
            goto L_0x03d8
        L_0x0375:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x037a:
            if (r6 != r9) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzhx r11 = (com.google.android.gms.internal.measurement.zzhx) r11
            float r1 = com.google.android.gms.internal.measurement.zzgp.zzd(r18, r19)
            r11.zza((float) r1)
        L_0x0385:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            float r1 = com.google.android.gms.internal.measurement.zzgp.zzd(r3, r4)
            r11.zza((float) r1)
            goto L_0x0385
        L_0x0399:
            if (r6 != r10) goto L_0x03b8
            com.google.android.gms.internal.measurement.zzhn r11 = (com.google.android.gms.internal.measurement.zzhn) r11
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a4:
            if (r1 >= r2) goto L_0x03b0
            double r4 = com.google.android.gms.internal.measurement.zzgp.zzc(r3, r1)
            r11.zza((double) r4)
            int r1 = r1 + 8
            goto L_0x03a4
        L_0x03b0:
            if (r1 != r2) goto L_0x03b3
            goto L_0x03d8
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x03b8:
            if (r6 != r13) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzhn r11 = (com.google.android.gms.internal.measurement.zzhn) r11
            double r8 = com.google.android.gms.internal.measurement.zzgp.zzc(r18, r19)
            r11.zza((double) r8)
        L_0x03c3:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d8
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d8
            double r8 = com.google.android.gms.internal.measurement.zzgp.zzc(r3, r4)
            r11.zza((double) r8)
            goto L_0x03c3
        L_0x03d7:
            r1 = r4
        L_0x03d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzgo r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zzjg r2 = r7.zzs
            boolean r2 = r2.zzd(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zzjg r2 = r7.zzs
            java.lang.Object r2 = r2.zzf(r12)
            com.google.android.gms.internal.measurement.zzjg r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzjg r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzje r8 = r8.zzb(r12)
            com.google.android.gms.internal.measurement.zzjg r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzgp.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.measurement.zzgo) r15)
            int r10 = r15.zza
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
            com.google.android.gms.internal.measurement.zzlh r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzlh r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzlh) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgo) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.measurement.zzlh r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzlh r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzlh) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgo) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.measurement.zzgp.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.measurement.zzgo) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.measurement.zzij r8 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.measurement.zzij r8 = com.google.android.gms.internal.measurement.zzij.zza()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        r2 = java.lang.Integer.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r6.zzc = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6.zzc = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.zzc = r1;
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
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.measurement.zzlh r4, java.lang.Class<?> r5, com.google.android.gms.internal.measurement.zzgo r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.measurement.zzjq.zza
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
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzd(r1, r2, r6)
            goto L_0x0099
        L_0x0019:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.measurement.zzhf.zza((long) r2)
            goto L_0x0042
        L_0x0024:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.measurement.zzhf.zze(r2)
            goto L_0x004d
        L_0x002f:
            com.google.android.gms.internal.measurement.zzjy r4 = com.google.android.gms.internal.measurement.zzjy.zza()
            com.google.android.gms.internal.measurement.zzkc r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzgo) r6)
            goto L_0x0099
        L_0x003c:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r1, r2, r6)
            long r2 = r6.zzb
        L_0x0042:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0051
        L_0x0047:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r1, r2, r6)
            int r2 = r6.zza
        L_0x004d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0051:
            r6.zzc = r2
            goto L_0x0099
        L_0x0054:
            float r1 = com.google.android.gms.internal.measurement.zzgp.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x006e
        L_0x005d:
            long r3 = com.google.android.gms.internal.measurement.zzgp.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L_0x007b
        L_0x0066:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x006e:
            r6.zzc = r1
            int r1 = r2 + 4
            goto L_0x0099
        L_0x0073:
            double r3 = com.google.android.gms.internal.measurement.zzgp.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
        L_0x007b:
            r6.zzc = r1
            int r1 = r2 + 8
            goto L_0x0099
        L_0x0080:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zze(r1, r2, r6)
            goto L_0x0099
        L_0x0085:
            int r1 = com.google.android.gms.internal.measurement.zzgp.zzb(r1, r2, r6)
            long r2 = r6.zzb
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(byte[], int, int, com.google.android.gms.internal.measurement.zzlh, java.lang.Class, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x038c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzjn<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzjh r34, com.google.android.gms.internal.measurement.zzjr r35, com.google.android.gms.internal.measurement.zzit r36, com.google.android.gms.internal.measurement.zzku<?, ?> r37, com.google.android.gms.internal.measurement.zzhq<?> r38, com.google.android.gms.internal.measurement.zzjg r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzka
            if (r1 == 0) goto L_0x040f
            com.google.android.gms.internal.measurement.zzka r0 = (com.google.android.gms.internal.measurement.zzka) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.measurement.zzib.zzf.zzi
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0031
            r5 = 1
        L_0x0027:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0032
            r5 = r7
            goto L_0x0027
        L_0x0031:
            r7 = 1
        L_0x0032:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0051
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003e:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003e
        L_0x004e:
            int r5 = r5 << r9
            r7 = r7 | r5
            r5 = r10
        L_0x0051:
            if (r7 != 0) goto L_0x005e
            int[] r7 = zza
            r14 = r7
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            goto L_0x016f
        L_0x005e:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006a:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x007a
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r5 = r5 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x006a
        L_0x007a:
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = r10
        L_0x007d:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009c
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0089:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x0099
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x0089
        L_0x0099:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r12
        L_0x009c:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x00bb
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a8:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00b8
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x00a8
        L_0x00b8:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00bb:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00da
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c7:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00d7
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c7
        L_0x00d7:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00da:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00f9
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e6:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x00f6
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e6
        L_0x00f6:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f9:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x011a
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0105:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x0116
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0105
        L_0x0116:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011a:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x013d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0126:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0138
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0126
        L_0x0138:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x013d:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0162
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r3 = r16
            r16 = 13
        L_0x014b:
            int r17 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r6) goto L_0x015d
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r16
            r15 = r15 | r3
            int r16 = r16 + 13
            r3 = r17
            goto L_0x014b
        L_0x015d:
            int r3 = r3 << r16
            r15 = r15 | r3
            r16 = r17
        L_0x0162:
            int r3 = r15 + r13
            int r3 = r3 + r14
            int[] r3 = new int[r3]
            int r14 = r5 << 1
            int r14 = r14 + r7
            r7 = r14
            r14 = r3
            r3 = r5
            r5 = r16
        L_0x016f:
            sun.misc.Unsafe r8 = zzb
            java.lang.Object[] r16 = r0.zze()
            com.google.android.gms.internal.measurement.zzjj r17 = r0.zzc()
            java.lang.Class r6 = r17.getClass()
            r17 = r5
            int r5 = r12 * 3
            int[] r5 = new int[r5]
            int r12 = r12 << r4
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r19 = r15 + r13
            r13 = r7
            r21 = r15
            r7 = r17
            r22 = r19
            r17 = 0
            r20 = 0
        L_0x0193:
            if (r7 >= r2) goto L_0x03e3
            int r23 = r7 + 1
            char r7 = r1.charAt(r7)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r4) goto L_0x01c5
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
        L_0x01a6:
            int r25 = r4 + 1
            char r4 = r1.charAt(r4)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x01bf
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r23
            r7 = r7 | r2
            int r23 = r23 + 13
            r4 = r25
            r2 = r26
            goto L_0x01a6
        L_0x01bf:
            int r2 = r4 << r23
            r7 = r7 | r2
            r2 = r25
            goto L_0x01c9
        L_0x01c5:
            r26 = r2
            r2 = r23
        L_0x01c9:
            int r4 = r2 + 1
            char r2 = r1.charAt(r2)
            r23 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r4) goto L_0x01fb
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
        L_0x01dc:
            int r25 = r4 + 1
            char r4 = r1.charAt(r4)
            r27 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r15) goto L_0x01f5
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r23
            r2 = r2 | r4
            int r23 = r23 + 13
            r4 = r25
            r15 = r27
            goto L_0x01dc
        L_0x01f5:
            int r4 = r4 << r23
            r2 = r2 | r4
            r4 = r25
            goto L_0x01ff
        L_0x01fb:
            r27 = r15
            r4 = r23
        L_0x01ff:
            r15 = r2 & 255(0xff, float:3.57E-43)
            r23 = r10
            r10 = r2 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x020d
            int r10 = r17 + 1
            r14[r17] = r20
            r17 = r10
        L_0x020d:
            r10 = 51
            r29 = r9
            if (r15 < r10) goto L_0x02aa
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r9) goto L_0x023c
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x0222:
            int r32 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r9) goto L_0x0237
            r9 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r31
            r4 = r4 | r9
            int r31 = r31 + 13
            r10 = r32
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0222
        L_0x0237:
            int r9 = r10 << r31
            r4 = r4 | r9
            r10 = r32
        L_0x023c:
            int r9 = r15 + -51
            r31 = r10
            r10 = 9
            if (r9 == r10) goto L_0x025d
            r10 = 17
            if (r9 != r10) goto L_0x0249
            goto L_0x025d
        L_0x0249:
            r10 = 12
            if (r9 != r10) goto L_0x025b
            if (r11 != 0) goto L_0x025b
            int r9 = r20 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r10 = r13 + 1
            r13 = r16[r13]
            r12[r9] = r13
            r13 = r10
        L_0x025b:
            r10 = 1
            goto L_0x026a
        L_0x025d:
            int r9 = r20 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r24 = r13 + 1
            r13 = r16[r13]
            r12[r9] = r13
            r13 = r24
        L_0x026a:
            int r4 = r4 << r10
            r9 = r16[r4]
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x0274
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x027c
        L_0x0274:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r6, (java.lang.String) r9)
            r16[r4] = r9
        L_0x027c:
            long r9 = r8.objectFieldOffset(r9)
            int r10 = (int) r9
            int r4 = r4 + 1
            r9 = r16[r4]
            r25 = r10
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x028e
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0296
        L_0x028e:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r6, (java.lang.String) r9)
            r16[r4] = r9
        L_0x0296:
            long r9 = r8.objectFieldOffset(r9)
            int r4 = (int) r9
            r30 = r1
            r9 = r4
            r1 = r11
            r28 = r12
            r10 = r25
            r11 = r31
            r4 = 0
            r18 = 1
            goto L_0x03a8
        L_0x02aa:
            int r9 = r13 + 1
            r10 = r16[r13]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zza((java.lang.Class<?>) r6, (java.lang.String) r10)
            r13 = 9
            if (r15 == r13) goto L_0x031e
            r13 = 17
            if (r15 != r13) goto L_0x02bd
            goto L_0x031e
        L_0x02bd:
            r13 = 27
            if (r15 == r13) goto L_0x030d
            r13 = 49
            if (r15 != r13) goto L_0x02c6
            goto L_0x030d
        L_0x02c6:
            r13 = 12
            if (r15 == r13) goto L_0x02f9
            r13 = 30
            if (r15 == r13) goto L_0x02f9
            r13 = 44
            if (r15 != r13) goto L_0x02d3
            goto L_0x02f9
        L_0x02d3:
            r13 = 50
            if (r15 != r13) goto L_0x032c
            int r13 = r21 + 1
            r14[r21] = r20
            int r21 = r20 / 3
            r24 = 1
            int r21 = r21 << 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r21] = r9
            r9 = r2 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x02f6
            int r21 = r21 + 1
            int r9 = r25 + 1
            r25 = r16[r25]
            r12[r21] = r25
            r21 = r13
            goto L_0x032c
        L_0x02f6:
            r21 = r13
            goto L_0x031b
        L_0x02f9:
            if (r11 != 0) goto L_0x030a
            int r13 = r20 / 3
            r24 = 1
            int r13 = r13 << 1
            int r13 = r13 + 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r13] = r9
            goto L_0x031b
        L_0x030a:
            r24 = 1
            goto L_0x032c
        L_0x030d:
            r24 = 1
            int r13 = r20 / 3
            int r13 = r13 << 1
            int r13 = r13 + 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r13] = r9
        L_0x031b:
            r13 = r25
            goto L_0x032d
        L_0x031e:
            r24 = 1
            int r13 = r20 / 3
            int r13 = r13 << 1
            int r13 = r13 + 1
            java.lang.Class r25 = r10.getType()
            r12[r13] = r25
        L_0x032c:
            r13 = r9
        L_0x032d:
            long r9 = r8.objectFieldOffset(r10)
            int r10 = (int) r9
            r9 = r2 & 4096(0x1000, float:5.74E-42)
            r25 = r13
            r13 = 4096(0x1000, float:5.74E-42)
            if (r9 != r13) goto L_0x038c
            r9 = 17
            if (r15 > r9) goto L_0x038c
            int r9 = r4 + 1
            char r4 = r1.charAt(r4)
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r13) goto L_0x0364
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x034d:
            int r28 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r13) goto L_0x035f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r18
            r4 = r4 | r9
            int r18 = r18 + 13
            r9 = r28
            goto L_0x034d
        L_0x035f:
            int r9 = r9 << r18
            r4 = r4 | r9
            r9 = r28
        L_0x0364:
            r18 = 1
            int r24 = r3 << 1
            int r28 = r4 / 32
            int r28 = r28 + r24
            r13 = r16[r28]
            r30 = r1
            boolean r1 = r13 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0377
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x037f
        L_0x0377:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza((java.lang.Class<?>) r6, (java.lang.String) r13)
            r16[r28] = r13
        L_0x037f:
            r1 = r11
            r28 = r12
            long r11 = r8.objectFieldOffset(r13)
            int r12 = (int) r11
            int r4 = r4 % 32
            r11 = r9
            r9 = r12
            goto L_0x0398
        L_0x038c:
            r30 = r1
            r1 = r11
            r28 = r12
            r18 = 1
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r4
            r4 = 0
        L_0x0398:
            r12 = 18
            if (r15 < r12) goto L_0x03a6
            r12 = 49
            if (r15 > r12) goto L_0x03a6
            int r12 = r22 + 1
            r14[r22] = r10
            r22 = r12
        L_0x03a6:
            r13 = r25
        L_0x03a8:
            int r12 = r20 + 1
            r5[r20] = r7
            int r7 = r12 + 1
            r20 = r3
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x03b7
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03b8
        L_0x03b7:
            r3 = 0
        L_0x03b8:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03bf
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c0
        L_0x03bf:
            r2 = 0
        L_0x03c0:
            r2 = r2 | r3
            int r3 = r15 << 20
            r2 = r2 | r3
            r2 = r2 | r10
            r5[r12] = r2
            int r2 = r7 + 1
            int r3 = r4 << 20
            r3 = r3 | r9
            r5[r7] = r3
            r7 = r11
            r3 = r20
            r10 = r23
            r15 = r27
            r12 = r28
            r9 = r29
            r4 = 1
            r11 = r1
            r20 = r2
            r2 = r26
            r1 = r30
            goto L_0x0193
        L_0x03e3:
            r29 = r9
            r23 = r10
            r1 = r11
            r28 = r12
            r27 = r15
            com.google.android.gms.internal.measurement.zzjn r2 = new com.google.android.gms.internal.measurement.zzjn
            com.google.android.gms.internal.measurement.zzjj r10 = r0.zzc()
            r12 = 0
            r0 = r5
            r5 = r2
            r6 = r0
            r7 = r28
            r8 = r29
            r9 = r23
            r13 = r14
            r14 = r27
            r15 = r19
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r2
        L_0x040f:
            com.google.android.gms.internal.measurement.zzkn r0 = (com.google.android.gms.internal.measurement.zzkn) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.measurement.zzib.zzf.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x041e
        L_0x041d:
            throw r0
        L_0x041e:
            goto L_0x041d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzjh, com.google.android.gms.internal.measurement.zzjr, com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzku, com.google.android.gms.internal.measurement.zzhq, com.google.android.gms.internal.measurement.zzjg):com.google.android.gms.internal.measurement.zzjn");
    }

    private final zzkc zza(int i) {
        int i2 = (i / 3) << 1;
        zzkc zzkc = (zzkc) this.zzd[i2];
        if (zzkc != null) {
            return zzkc;
        }
        zzkc zza2 = zzjy.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzif zzif, UB ub, zzku<UT, UB> zzku) {
        zzje<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzif.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzku.zza();
                }
                zzhb zzc2 = zzgt.zzc(zzjb.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zzjb.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzku.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzku<UT, UB> zzku) {
        zzif zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzla.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzku);
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

    private static List<?> zza(Object obj, long j) {
        return (List) zzla.zzf(obj, j);
    }

    private static void zza(int i, Object obj, zzln zzln) throws IOException {
        if (obj instanceof String) {
            zzln.zza(i, (String) obj);
        } else {
            zzln.zza(i, (zzgt) obj);
        }
    }

    private static <UT, UB> void zza(zzku<UT, UB> zzku, T t, zzln zzln) throws IOException {
        zzku.zza(zzku.zzb(t), zzln);
    }

    private final <K, V> void zza(zzln zzln, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzln.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private final void zza(Object obj, int i, zzjz zzjz) throws IOException {
        long j;
        Object zzn2;
        if (zzf(i)) {
            j = (long) (i & 1048575);
            zzn2 = zzjz.zzm();
        } else {
            int i2 = i & 1048575;
            if (this.zzi) {
                j = (long) i2;
                zzn2 = zzjz.zzl();
            } else {
                j = (long) i2;
                zzn2 = zzjz.zzn();
            }
        }
        zzla.zza(obj, j, zzn2);
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzla.zzf(t, zzd2);
            Object zzf3 = zzla.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzla.zza((Object) t, zzd2, zzie.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzla.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzla.zze(t, j2) != 0.0d;
                case 1:
                    return zzla.zzd(t, j2) != 0.0f;
                case 2:
                    return zzla.zzb(t, j2) != 0;
                case 3:
                    return zzla.zzb(t, j2) != 0;
                case 4:
                    return zzla.zza((Object) t, j2) != 0;
                case 5:
                    return zzla.zzb(t, j2) != 0;
                case 6:
                    return zzla.zza((Object) t, j2) != 0;
                case 7:
                    return zzla.zzc(t, j2);
                case 8:
                    Object zzf2 = zzla.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgt) {
                        return !zzgt.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzla.zzf(t, j2) != null;
                case 10:
                    return !zzgt.zza.equals(zzla.zzf(t, j2));
                case 11:
                    return zzla.zza((Object) t, j2) != 0;
                case 12:
                    return zzla.zza((Object) t, j2) != 0;
                case 13:
                    return zzla.zza((Object) t, j2) != 0;
                case 14:
                    return zzla.zzb(t, j2) != 0;
                case 15:
                    return zzla.zza((Object) t, j2) != 0;
                case 16:
                    return zzla.zzb(t, j2) != 0;
                case 17:
                    return zzla.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzla.zza((Object) t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzla.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zza(t, i) : (i3 & i4) != 0;
    }

    private static boolean zza(Object obj, int i, zzkc zzkc) {
        return zzkc.zzd(zzla.zzf(obj, (long) (i & 1048575)));
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzla.zzf(t, j)).doubleValue();
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
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

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzla.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzla.zza((Object) t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzla.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0235, code lost:
        com.google.android.gms.internal.measurement.zzke.zzj(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0245, code lost:
        com.google.android.gms.internal.measurement.zzke.zzg(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0255, code lost:
        com.google.android.gms.internal.measurement.zzke.zzl(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0265, code lost:
        com.google.android.gms.internal.measurement.zzke.zzm(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0275, code lost:
        com.google.android.gms.internal.measurement.zzke.zzi(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02bc, code lost:
        com.google.android.gms.internal.measurement.zzke.zzn(r4, r8, r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02c6, code lost:
        com.google.android.gms.internal.measurement.zzke.zzk(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02d6, code lost:
        com.google.android.gms.internal.measurement.zzke.zzf(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02e6, code lost:
        com.google.android.gms.internal.measurement.zzke.zzh(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02f6, code lost:
        com.google.android.gms.internal.measurement.zzke.zzd(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0306, code lost:
        com.google.android.gms.internal.measurement.zzke.zzc(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0316, code lost:
        com.google.android.gms.internal.measurement.zzke.zzb(r4, (java.util.List<java.lang.Float>) (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0326, code lost:
        com.google.android.gms.internal.measurement.zzke.zza(r4, (java.util.List<java.lang.Double>) (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x041b, code lost:
        r10 = r10 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x022b, code lost:
        com.google.android.gms.internal.measurement.zzke.zze(r4, r8, r2, r15);
     */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzln r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzhq<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzhr r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.measurement.zzkd<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x002f:
            if (r10 >= r6) goto L_0x041f
            int r13 = r0.zzd((int) r10)
            int[] r14 = r0.zzc
            r15 = r14[r10]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zzj
            if (r9 != 0) goto L_0x005e
            r9 = 17
            if (r4 > r9) goto L_0x005e
            int r9 = r10 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r11) goto L_0x0058
            long r11 = (long) r8
            int r12 = r7.getInt(r1, r11)
            r11 = r8
        L_0x0058:
            int r8 = r9 >>> 20
            r9 = 1
            int r8 = r9 << r8
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            if (r5 == 0) goto L_0x007d
            com.google.android.gms.internal.measurement.zzhq<?> r9 = r0.zzr
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r15) goto L_0x007d
            com.google.android.gms.internal.measurement.zzhq<?> r9 = r0.zzr
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007b
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005f
        L_0x007b:
            r5 = 0
            goto L_0x005f
        L_0x007d:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r9
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x0410;
                case 1: goto L_0x0404;
                case 2: goto L_0x03f8;
                case 3: goto L_0x03ec;
                case 4: goto L_0x03e0;
                case 5: goto L_0x03d4;
                case 6: goto L_0x03c8;
                case 7: goto L_0x03bc;
                case 8: goto L_0x03b0;
                case 9: goto L_0x039f;
                case 10: goto L_0x0390;
                case 11: goto L_0x0383;
                case 12: goto L_0x0376;
                case 13: goto L_0x0369;
                case 14: goto L_0x035c;
                case 15: goto L_0x034f;
                case 16: goto L_0x0342;
                case 17: goto L_0x0331;
                case 18: goto L_0x0321;
                case 19: goto L_0x0311;
                case 20: goto L_0x0301;
                case 21: goto L_0x02f1;
                case 22: goto L_0x02e1;
                case 23: goto L_0x02d1;
                case 24: goto L_0x02c1;
                case 25: goto L_0x02b1;
                case 26: goto L_0x02a2;
                case 27: goto L_0x028f;
                case 28: goto L_0x0280;
                case 29: goto L_0x0270;
                case 30: goto L_0x0260;
                case 31: goto L_0x0250;
                case 32: goto L_0x0240;
                case 33: goto L_0x0230;
                case 34: goto L_0x0220;
                case 35: goto L_0x0219;
                case 36: goto L_0x0212;
                case 37: goto L_0x020b;
                case 38: goto L_0x0204;
                case 39: goto L_0x01fd;
                case 40: goto L_0x01f6;
                case 41: goto L_0x01ef;
                case 42: goto L_0x01e2;
                case 43: goto L_0x01db;
                case 44: goto L_0x01d4;
                case 45: goto L_0x01cd;
                case 46: goto L_0x01c6;
                case 47: goto L_0x01c0;
                case 48: goto L_0x01b4;
                case 49: goto L_0x01a1;
                case 50: goto L_0x0198;
                case 51: goto L_0x0189;
                case 52: goto L_0x017a;
                case 53: goto L_0x016b;
                case 54: goto L_0x015c;
                case 55: goto L_0x014d;
                case 56: goto L_0x013e;
                case 57: goto L_0x012f;
                case 58: goto L_0x0120;
                case 59: goto L_0x0111;
                case 60: goto L_0x00fe;
                case 61: goto L_0x00ee;
                case 62: goto L_0x00e0;
                case 63: goto L_0x00d2;
                case 64: goto L_0x00c4;
                case 65: goto L_0x00b6;
                case 66: goto L_0x00a8;
                case 67: goto L_0x009a;
                case 68: goto L_0x0088;
                default: goto L_0x0085;
            }
        L_0x0085:
            r4 = 0
            goto L_0x041b
        L_0x0088:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkc r8 = r0.zza((int) r10)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzkc) r8)
            goto L_0x0085
        L_0x009a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zze(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x0085
        L_0x00a8:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzd(r1, r13)
            r2.zzf(r15, r4)
            goto L_0x0085
        L_0x00b6:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zze(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x0085
        L_0x00c4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzd(r1, r13)
            r2.zza((int) r15, (int) r4)
            goto L_0x0085
        L_0x00d2:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzd(r1, r13)
            r2.zzb((int) r15, (int) r4)
            goto L_0x0085
        L_0x00e0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzd(r1, r13)
            r2.zze((int) r15, (int) r4)
            goto L_0x0085
        L_0x00ee:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgt r4 = (com.google.android.gms.internal.measurement.zzgt) r4
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgt) r4)
            goto L_0x0085
        L_0x00fe:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkc r8 = r0.zza((int) r10)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzkc) r8)
            goto L_0x0085
        L_0x0111:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzln) r2)
            goto L_0x0085
        L_0x0120:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            boolean r4 = zzf(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            goto L_0x0085
        L_0x012f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzd(r1, r13)
            r2.zzd((int) r15, (int) r4)
            goto L_0x0085
        L_0x013e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zze(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x0085
        L_0x014d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzd(r1, r13)
            r2.zzc((int) r15, (int) r4)
            goto L_0x0085
        L_0x015c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zze(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x0085
        L_0x016b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zze(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x0085
        L_0x017a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            float r4 = zzc(r1, r13)
            r2.zza((int) r15, (float) r4)
            goto L_0x0085
        L_0x0189:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0085
            double r13 = zzb(r1, (long) r13)
            r2.zza((int) r15, (double) r13)
            goto L_0x0085
        L_0x0198:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza((com.google.android.gms.internal.measurement.zzln) r2, (int) r15, (java.lang.Object) r4, (int) r10)
            goto L_0x0085
        L_0x01a1:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkc r13 = r0.zza((int) r10)
            com.google.android.gms.internal.measurement.zzke.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzln) r2, (com.google.android.gms.internal.measurement.zzkc) r13)
            goto L_0x0085
        L_0x01b4:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 1
            goto L_0x022b
        L_0x01c0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0235
        L_0x01c6:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0245
        L_0x01cd:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0255
        L_0x01d4:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0265
        L_0x01db:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0275
        L_0x01e2:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            goto L_0x02bc
        L_0x01ef:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x02c6
        L_0x01f6:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x02d6
        L_0x01fd:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x02e6
        L_0x0204:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x02f6
        L_0x020b:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0306
        L_0x0212:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0316
        L_0x0219:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0326
        L_0x0220:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
        L_0x022b:
            com.google.android.gms.internal.measurement.zzke.zze(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0230:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0235:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzj(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0240:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0245:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzg(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0250:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0255:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzl(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0260:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0265:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzm(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0270:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0275:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzi(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0280:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzb((int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzgt>) r8, (com.google.android.gms.internal.measurement.zzln) r2)
            goto L_0x0085
        L_0x028f:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkc r13 = r0.zza((int) r10)
            com.google.android.gms.internal.measurement.zzke.zza((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzln) r2, (com.google.android.gms.internal.measurement.zzkc) r13)
            goto L_0x0085
        L_0x02a2:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zza((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzln) r2)
            goto L_0x0085
        L_0x02b1:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
        L_0x02bc:
            com.google.android.gms.internal.measurement.zzke.zzn(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02c1:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x02c6:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzk(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02d1:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x02d6:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzf(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02e1:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x02e6:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzh(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02f1:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x02f6:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzd(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0301:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0306:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzc(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0311:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0316:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzln) r2, (boolean) r15)
            goto L_0x0085
        L_0x0321:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0326:
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzln) r2, (boolean) r15)
            goto L_0x0085
        L_0x0331:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkc r13 = r0.zza((int) r10)
            r2.zzb((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkc) r13)
            goto L_0x041b
        L_0x0342:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            long r13 = r7.getLong(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x041b
        L_0x034f:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            int r8 = r7.getInt(r1, r13)
            r2.zzf(r15, r8)
            goto L_0x041b
        L_0x035c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x041b
        L_0x0369:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            int r8 = r7.getInt(r1, r13)
            r2.zza((int) r15, (int) r8)
            goto L_0x041b
        L_0x0376:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            int r8 = r7.getInt(r1, r13)
            r2.zzb((int) r15, (int) r8)
            goto L_0x041b
        L_0x0383:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            int r8 = r7.getInt(r1, r13)
            r2.zze((int) r15, (int) r8)
            goto L_0x041b
        L_0x0390:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgt r8 = (com.google.android.gms.internal.measurement.zzgt) r8
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgt) r8)
            goto L_0x041b
        L_0x039f:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkc r13 = r0.zza((int) r10)
            r2.zza((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkc) r13)
            goto L_0x041b
        L_0x03b0:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            java.lang.Object r8 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzln) r2)
            goto L_0x041b
        L_0x03bc:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            boolean r8 = com.google.android.gms.internal.measurement.zzla.zzc(r1, r13)
            r2.zza((int) r15, (boolean) r8)
            goto L_0x041b
        L_0x03c8:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            int r8 = r7.getInt(r1, r13)
            r2.zzd((int) r15, (int) r8)
            goto L_0x041b
        L_0x03d4:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            long r13 = r7.getLong(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x041b
        L_0x03e0:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            int r8 = r7.getInt(r1, r13)
            r2.zzc((int) r15, (int) r8)
            goto L_0x041b
        L_0x03ec:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            long r13 = r7.getLong(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x041b
        L_0x03f8:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x041b
        L_0x0404:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            float r8 = com.google.android.gms.internal.measurement.zzla.zzd(r1, r13)
            r2.zza((int) r15, (float) r8)
            goto L_0x041b
        L_0x0410:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x041b
            double r13 = com.google.android.gms.internal.measurement.zzla.zze(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x041b:
            int r10 = r10 + 3
            goto L_0x002f
        L_0x041f:
            if (r5 == 0) goto L_0x0436
            com.google.android.gms.internal.measurement.zzhq<?> r4 = r0.zzr
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0434
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x041f
        L_0x0434:
            r5 = 0
            goto L_0x041f
        L_0x0436:
            com.google.android.gms.internal.measurement.zzku<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.measurement.zzln) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzln):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzla.zzf(t, j);
            Object zzf3 = zzla.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzla.zza((Object) t, j, zzie.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzla.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzla.zzf(t, j)).floatValue();
    }

    private final zzif zzc(int i) {
        return (zzif) this.zzd[((i / 3) << 1) + 1];
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzla.zzf(t, j)).intValue();
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzla.zzf(t, j)).longValue();
    }

    private static zzkt zze(Object obj) {
        zzib zzib = (zzib) obj;
        zzkt zzkt = zzib.zzb;
        if (zzkt != zzkt.zza()) {
            return zzkt;
        }
        zzkt zzb2 = zzkt.zzb();
        zzib.zzb = zzb2;
        return zzb2;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzla.zzf(t, j)).booleanValue();
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = zzd(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = zze(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5);
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
        r3 = ((java.lang.String) com.google.android.gms.internal.measurement.zzla.zzf(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = com.google.android.gms.internal.measurement.zzie.zza(r3);
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
        r3 = com.google.android.gms.internal.measurement.zzie.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012a, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012c, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0130
            int r3 = r8.zzd((int) r1)
            int[] r4 = r8.zzc
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
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5)
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
            boolean r3 = zzf(r9, r5)
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
            int r3 = zzd(r9, r5)
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
            long r3 = zze(r9, r5)
            goto L_0x0126
        L_0x00b0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            float r3 = zzc(r9, r5)
            goto L_0x0117
        L_0x00bd:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            double r3 = zzb(r9, (long) r5)
            goto L_0x0122
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x012a
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012c
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x012a
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzla.zzc(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.measurement.zzie.zza((boolean) r3)
            goto L_0x012a
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r9, (long) r5)
        L_0x0108:
            int r2 = r2 + r3
            goto L_0x012c
        L_0x010a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzla.zzb(r9, r5)
            goto L_0x0126
        L_0x0111:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzla.zzd(r9, r5)
        L_0x0117:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x012a
        L_0x011c:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzla.zze(r9, r5)
        L_0x0122:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0126:
            int r3 = com.google.android.gms.internal.measurement.zzie.zza((long) r3)
        L_0x012a:
            int r3 = r3 + r2
            r2 = r3
        L_0x012c:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0130:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzku<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.zzh
            if (r1 == 0) goto L_0x014e
            int r0 = r0 * 53
            com.google.android.gms.internal.measurement.zzhq<?> r1 = r8.zzr
            com.google.android.gms.internal.measurement.zzhr r9 = r1.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r0 = r0 + r9
        L_0x014e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03a4, code lost:
        if (r0 == r15) goto L_0x040d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03e7, code lost:
        if (r0 == r15) goto L_0x040d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01f5, code lost:
        r10.putObject(r14, r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0243, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0247, code lost:
        r3 = r8;
        r1 = r9;
        r9 = r13;
        r13 = r2;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x028d, code lost:
        r10.putInt(r14, r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b2, code lost:
        r0.putLong(r1, r2, r4);
        r5 = r6 | r22;
        r6 = r30;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02f3, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02f7, code lost:
        r3 = r8;
        r1 = r9;
        r2 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02fb, code lost:
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ff, code lost:
        r7 = r32;
        r2 = r3;
        r22 = r6;
        r26 = r10;
        r17 = r11;
        r6 = r30;
        r30 = r9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.zzgo r33) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x04b7
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgo) r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.zza((int) r0, (int) r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.zzg(r0)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004f
            r30 = r0
            r2 = r3
            r8 = r4
            r22 = r5
            r26 = r10
            r7 = r11
            r17 = 0
            r18 = -1
            goto L_0x0411
        L_0x004f:
            int[] r1 = r15.zzc
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r4
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r8 & r17
            long r12 = (long) r4
            r4 = 17
            r20 = r8
            if (r11 > r4) goto L_0x030e
            int r4 = r2 + 2
            r1 = r1[r4]
            int r4 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r4
            if (r1 == r6) goto L_0x0085
            if (r6 == r4) goto L_0x007e
            long r8 = (long) r6
            r10.putInt(r14, r8, r5)
        L_0x007e:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r8 = r1
            goto L_0x0086
        L_0x0085:
            r8 = r6
        L_0x0086:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02d7;
                case 1: goto L_0x02bb;
                case 2: goto L_0x0292;
                case 3: goto L_0x0292;
                case 4: goto L_0x0275;
                case 5: goto L_0x024e;
                case 6: goto L_0x0226;
                case 7: goto L_0x01f9;
                case 8: goto L_0x01cf;
                case 9: goto L_0x019c;
                case 10: goto L_0x017e;
                case 11: goto L_0x0275;
                case 12: goto L_0x0143;
                case 13: goto L_0x0226;
                case 14: goto L_0x024e;
                case 15: goto L_0x0125;
                case 16: goto L_0x00f4;
                case 17: goto L_0x009c;
                default: goto L_0x008b;
            }
        L_0x008b:
            r12 = r29
            r13 = r33
            r9 = r0
            r11 = r2
            r30 = r8
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02ff
        L_0x009c:
            r5 = 3
            if (r7 != r5) goto L_0x00e2
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.android.gms.internal.measurement.zzkc r1 = r15.zza((int) r2)
            r9 = r0
            r0 = r1
            r18 = -1
            r1 = r29
            r11 = r2
            r2 = r3
            r3 = r31
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r1 = r6 & r22
            r4 = r33
            if (r1 != 0) goto L_0x00c6
            java.lang.Object r1 = r4.zzc
            goto L_0x00d0
        L_0x00c6:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r4.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x00d0:
            r10.putObject(r14, r12, r1)
            r5 = r6 | r22
            r12 = r29
            r13 = r31
            r3 = r7
            r6 = r8
            r1 = r9
            r2 = r11
            r11 = r32
            r9 = r4
            goto L_0x0019
        L_0x00e2:
            r9 = r0
            r11 = r2
            r7 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            r30 = r8
            r8 = r7
            goto L_0x02ff
        L_0x00f4:
            r4 = r33
            r9 = r0
            r11 = r2
            r5 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x011d
            r1 = r12
            r12 = r29
            int r7 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r3, r4)
            r20 = r1
            long r0 = r4.zzb
            long r23 = com.google.android.gms.internal.measurement.zzhf.zza((long) r0)
            r0 = r10
            r2 = r20
            r1 = r28
            r13 = r4
            r30 = r8
            r8 = r5
            r4 = r23
            goto L_0x02b2
        L_0x011d:
            r12 = r29
            r13 = r4
            r30 = r8
            r8 = r5
            goto L_0x02ff
        L_0x0125:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x02ff
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r3, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzhf.zze(r1)
            goto L_0x028d
        L_0x0143:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x02ff
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r3, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzif r2 = r15.zzc((int) r11)
            if (r2 == 0) goto L_0x028d
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0169
            goto L_0x028d
        L_0x0169:
            com.google.android.gms.internal.measurement.zzkt r2 = zze((java.lang.Object) r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r8, (java.lang.Object) r1)
            r5 = r6
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            r6 = r30
            goto L_0x02fb
        L_0x017e:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x02ff
            int r0 = com.google.android.gms.internal.measurement.zzgp.zze(r12, r3, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x02f3
        L_0x019c:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x01cb
            com.google.android.gms.internal.measurement.zzkc r0 = r15.zza((int) r11)
            r2 = r31
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r0, (byte[]) r12, (int) r3, (int) r2, (com.google.android.gms.internal.measurement.zzgo) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01c0
            java.lang.Object r1 = r13.zzc
            goto L_0x01f5
        L_0x01c0:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r3 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r1, (java.lang.Object) r3)
            goto L_0x01f5
        L_0x01cb:
            r2 = r31
            goto L_0x02ff
        L_0x01cf:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x02ff
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.measurement.zzgp.zzc(r12, r3, r13)
            goto L_0x01f3
        L_0x01ef:
            int r0 = com.google.android.gms.internal.measurement.zzgp.zzd(r12, r3, r13)
        L_0x01f3:
            java.lang.Object r1 = r13.zzc
        L_0x01f5:
            r10.putObject(r14, r4, r1)
            goto L_0x0243
        L_0x01f9:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != 0) goto L_0x02ff
            int r0 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r3, r13)
            r3 = r0
            long r0 = r13.zzb
            r20 = 0
            int r7 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r7 == 0) goto L_0x021c
            r0 = 1
            goto L_0x021d
        L_0x021c:
            r0 = 0
        L_0x021d:
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r4, (boolean) r0)
            r5 = r6 | r22
            r6 = r30
            r0 = r3
            goto L_0x0247
        L_0x0226:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r1) goto L_0x02ff
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x0243:
            r5 = r6 | r22
            r6 = r30
        L_0x0247:
            r3 = r8
            r1 = r9
            r9 = r13
            r13 = r2
            r2 = r11
            goto L_0x04b3
        L_0x024e:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x02ff
            long r20 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r3)
            r0 = r10
            r1 = r28
            r7 = r3
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x02f3
        L_0x0275:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x02ff
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r3, r13)
            int r1 = r13.zza
        L_0x028d:
            r10.putInt(r14, r4, r1)
            goto L_0x02f3
        L_0x0292:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x02ff
            int r7 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r3, r13)
            long r2 = r13.zzb
            r0 = r10
            r1 = r28
            r20 = r2
            r2 = r4
            r4 = r20
        L_0x02b2:
            r0.putLong(r1, r2, r4)
            r5 = r6 | r22
            r6 = r30
            r0 = r7
            goto L_0x02f7
        L_0x02bb:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r1) goto L_0x02ff
            float r0 = com.google.android.gms.internal.measurement.zzgp.zzd(r12, r3)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r4, (float) r0)
            int r0 = r3 + 4
            goto L_0x02f3
        L_0x02d7:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x02ff
            double r0 = com.google.android.gms.internal.measurement.zzgp.zzc(r12, r3)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r4, (double) r0)
            int r0 = r3 + 8
        L_0x02f3:
            r5 = r6 | r22
            r6 = r30
        L_0x02f7:
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
        L_0x02fb:
            r13 = r31
            goto L_0x04b3
        L_0x02ff:
            r7 = r32
            r2 = r3
            r22 = r6
            r26 = r10
            r17 = r11
            r6 = r30
            r30 = r9
            goto L_0x0411
        L_0x030e:
            r4 = r2
            r1 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r9
            r9 = r0
            r0 = 27
            if (r11 != r0) goto L_0x0375
            r0 = 2
            if (r7 != r0) goto L_0x0366
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzik r0 = (com.google.android.gms.internal.measurement.zzik) r0
            boolean r7 = r0.zza()
            if (r7 != 0) goto L_0x0340
            int r7 = r0.size()
            if (r7 != 0) goto L_0x0337
            r7 = 10
            goto L_0x0339
        L_0x0337:
            int r7 = r7 << 1
        L_0x0339:
            com.google.android.gms.internal.measurement.zzik r0 = r0.zza(r7)
            r10.putObject(r14, r1, r0)
        L_0x0340:
            r7 = r0
            com.google.android.gms.internal.measurement.zzkc r0 = r15.zza((int) r4)
            r1 = r8
            r2 = r29
            r17 = r4
            r4 = r31
            r22 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r32
            r3 = r8
            r1 = r9
            r9 = r13
            r2 = r17
            r5 = r22
            r6 = r23
            r13 = r31
            goto L_0x0019
        L_0x0366:
            r17 = r4
            r22 = r5
            r23 = r6
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            goto L_0x03ea
        L_0x0375:
            r17 = r4
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x03c2
            r6 = r20
            long r5 = (long) r6
            r0 = r27
            r24 = r1
            r1 = r28
            r2 = r29
            r4 = r3
            r15 = r4
            r4 = r31
            r20 = r5
            r5 = r8
            r6 = r9
            r19 = r8
            r8 = r17
            r30 = r9
            r26 = r10
            r9 = r20
            r12 = r24
            r14 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgo) r14)
            if (r0 != r15) goto L_0x03a8
            goto L_0x040d
        L_0x03a8:
            r15 = r27
            r14 = r28
            r12 = r29
            r1 = r30
            r13 = r31
            r11 = r32
            r9 = r33
            r2 = r17
            r3 = r19
            r5 = r22
            r6 = r23
            r10 = r26
            goto L_0x0019
        L_0x03c2:
            r24 = r1
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            r6 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03f2
            r0 = 2
            if (r7 != r0) goto L_0x03ea
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r17
            r6 = r24
            r8 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgo) r8)
            if (r0 != r15) goto L_0x03a8
            goto L_0x040d
        L_0x03ea:
            r7 = r32
            r2 = r15
        L_0x03ed:
            r8 = r19
            r6 = r23
            goto L_0x0411
        L_0x03f2:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r8 = r6
            r6 = r30
            r9 = r11
            r10 = r24
            r12 = r17
            r13 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgo) r13)
            if (r0 != r15) goto L_0x049b
        L_0x040d:
            r7 = r32
            r2 = r0
            goto L_0x03ed
        L_0x0411:
            if (r8 != r7) goto L_0x0423
            if (r7 != 0) goto L_0x0416
            goto L_0x0423
        L_0x0416:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r27
            r12 = r28
            r0 = r2
            r3 = r8
            r5 = r22
            goto L_0x04c3
        L_0x0423:
            r9 = r27
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x0474
            r10 = r33
            com.google.android.gms.internal.measurement.zzho r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzho r1 = com.google.android.gms.internal.measurement.zzho.zza()
            if (r0 == r1) goto L_0x046f
            com.google.android.gms.internal.measurement.zzjj r0 = r9.zzg
            com.google.android.gms.internal.measurement.zzho r1 = r10.zzd
            r11 = r30
            com.google.android.gms.internal.measurement.zzib$zzd r0 = r1.zza(r0, r11)
            if (r0 != 0) goto L_0x045f
            com.google.android.gms.internal.measurement.zzkt r4 = zze((java.lang.Object) r28)
            r0 = r8
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkt) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r14 = r28
            r12 = r29
            r13 = r31
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r2 = r17
            r5 = r22
            r10 = r26
            goto L_0x0498
        L_0x045f:
            r12 = r28
            r0 = r12
            com.google.android.gms.internal.measurement.zzib$zzb r0 = (com.google.android.gms.internal.measurement.zzib.zzb) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzhr<com.google.android.gms.internal.measurement.zzib$zze> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x046f:
            r12 = r28
            r11 = r30
            goto L_0x047a
        L_0x0474:
            r12 = r28
            r11 = r30
            r10 = r33
        L_0x047a:
            com.google.android.gms.internal.measurement.zzkt r4 = zze((java.lang.Object) r28)
            r0 = r8
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkt) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r13 = r31
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r14 = r12
            r2 = r17
            r5 = r22
            r10 = r26
            r12 = r29
        L_0x0498:
            r11 = r7
            goto L_0x0019
        L_0x049b:
            r11 = r30
            r8 = r19
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r9 = r33
            r3 = r8
            r1 = r11
            r2 = r17
            r5 = r22
            r6 = r23
            r10 = r26
        L_0x04b3:
            r11 = r32
            goto L_0x0019
        L_0x04b7:
            r22 = r5
            r23 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x04c3:
            if (r6 == r1) goto L_0x04cb
            long r1 = (long) r6
            r4 = r26
            r4.putInt(r12, r1, r5)
        L_0x04cb:
            r1 = 0
            int r2 = r9.zzm
        L_0x04ce:
            int r4 = r9.zzn
            if (r2 >= r4) goto L_0x04e1
            int[] r4 = r9.zzl
            r4 = r4[r2]
            com.google.android.gms.internal.measurement.zzku<?, ?> r5 = r9.zzq
            java.lang.Object r1 = r9.zza((java.lang.Object) r12, (int) r4, r1, r5)
            com.google.android.gms.internal.measurement.zzkt r1 = (com.google.android.gms.internal.measurement.zzkt) r1
            int r2 = r2 + 1
            goto L_0x04ce
        L_0x04e1:
            if (r1 == 0) goto L_0x04e8
            com.google.android.gms.internal.measurement.zzku<?, ?> r2 = r9.zzq
            r2.zzb((java.lang.Object) r12, r1)
        L_0x04e8:
            r1 = r31
            if (r7 != 0) goto L_0x04f4
            if (r0 != r1) goto L_0x04ef
            goto L_0x04f8
        L_0x04ef:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r0
        L_0x04f4:
            if (r0 > r1) goto L_0x04f9
            if (r3 != r7) goto L_0x04f9
        L_0x04f8:
            return r0
        L_0x04f9:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zzg()
            goto L_0x04ff
        L_0x04fe:
            throw r0
        L_0x04ff:
            goto L_0x04fe
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzgo):int");
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjz r14, com.google.android.gms.internal.measurement.zzho r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x0535
            com.google.android.gms.internal.measurement.zzku<?, ?> r8 = r12.zzq
            com.google.android.gms.internal.measurement.zzhq<?> r9 = r12.zzr
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zza()     // Catch:{ all -> 0x051d }
            int r3 = r12.zzg(r2)     // Catch:{ all -> 0x051d }
            if (r3 >= 0) goto L_0x0078
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzm
        L_0x001a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzb((java.lang.Object) r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x051d }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.measurement.zzjj r3 = r12.zzg     // Catch:{ all -> 0x051d }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x051d }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzhr r1 = r9.zzb(r13)     // Catch:{ all -> 0x051d }
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
            r8.zza((com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ all -> 0x051d }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x051d }
            r10 = r2
        L_0x005b:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ all -> 0x051d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0063:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0072
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0072:
            if (r10 == 0) goto L_0x0077
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0077:
            return
        L_0x0078:
            int r4 = r12.zzd((int) r3)     // Catch:{ all -> 0x051d }
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
            java.lang.Object r2 = r8.zza()     // Catch:{ zzim -> 0x04f6 }
            goto L_0x04d8
        L_0x008f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r6 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
        L_0x009c:
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x00a1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzt()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x00af:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            int r6 = r14.zzs()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x00bd:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzr()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x00cb:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            int r6 = r14.zzq()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x00d9:
            int r5 = r14.zzp()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzif r7 = r12.zzc((int) r3)     // Catch:{ zzim -> 0x04f6 }
            if (r7 == 0) goto L_0x00f0
            boolean r7 = r7.zza(r5)     // Catch:{ zzim -> 0x04f6 }
            if (r7 == 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzke.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x00f0:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x00fa:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            int r6 = r14.zzo()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0108:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzgt r6 = r14.zzn()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0112:
            boolean r5 = r12.zza(r13, (int) r2, (int) r3)     // Catch:{ zzim -> 0x04f6 }
            r4 = r4 & r6
            if (r5 == 0) goto L_0x012f
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzla.zzf(r13, r4)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r7 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x012f:
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r6 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0140:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0145:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            boolean r6 = r14.zzk()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0154:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            int r6 = r14.zzj()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0163:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzi()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0172:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            int r6 = r14.zzh()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0181:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzf()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x0190:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzg()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x019f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            float r6 = r14.zze()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            double r6 = r14.zzd()     // Catch:{ zzim -> 0x04f6 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x009c
        L_0x01bd:
            java.lang.Object r2 = r12.zzb((int) r3)     // Catch:{ zzim -> 0x04f6 }
            int r3 = r12.zzd((int) r3)     // Catch:{ zzim -> 0x04f6 }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzla.zzf(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            if (r5 != 0) goto L_0x01d7
            com.google.android.gms.internal.measurement.zzjg r5 = r12.zzs     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r5 = r5.zzf(r2)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x01ee
        L_0x01d7:
            com.google.android.gms.internal.measurement.zzjg r6 = r12.zzs     // Catch:{ zzim -> 0x04f6 }
            boolean r6 = r6.zzd(r5)     // Catch:{ zzim -> 0x04f6 }
            if (r6 == 0) goto L_0x01ee
            com.google.android.gms.internal.measurement.zzjg r6 = r12.zzs     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r6 = r6.zzf(r2)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzjg r7 = r12.zzs     // Catch:{ zzim -> 0x04f6 }
            r7.zza(r6, r5)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ zzim -> 0x04f6 }
            r5 = r6
        L_0x01ee:
            com.google.android.gms.internal.measurement.zzjg r3 = r12.zzs     // Catch:{ zzim -> 0x04f6 }
            java.util.Map r3 = r3.zza(r5)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzjg r4 = r12.zzs     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzje r2 = r4.zzb(r2)     // Catch:{ zzim -> 0x04f6 }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzho) r15)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x01ff:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r2 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzit r3 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzim -> 0x04f6 }
            r14.zzb(r3, r2, r15)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0211:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x021a:
            r14.zzq(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x021f:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0228:
            r14.zzp(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x022d:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0236:
            r14.zzo(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x023b:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0244:
            r14.zzn(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0249:
            com.google.android.gms.internal.measurement.zzit r5 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzim -> 0x04f6 }
            r14.zzm(r4)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzif r3 = r12.zzc((int) r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0258:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzke.zza(r2, r4, r3, r10, r8)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x025e:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0267:
            r14.zzl(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x026c:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0275:
            r14.zzh(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x027a:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0283:
            r14.zzg(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0288:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x0291:
            r14.zzf(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0296:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x029f:
            r14.zze(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x02a4:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x02ad:
            r14.zzc(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x02b2:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x02bb:
            r14.zzd(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x02c0:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x02c9:
            r14.zzb(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x02ce:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x02d7:
            r14.zza(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x02dc:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x021a
        L_0x02e7:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0228
        L_0x02f2:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0236
        L_0x02fd:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0244
        L_0x0308:
            com.google.android.gms.internal.measurement.zzit r5 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzim -> 0x04f6 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzim -> 0x04f6 }
            r14.zzm(r4)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzif r3 = r12.zzc((int) r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0258
        L_0x0319:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0267
        L_0x0324:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            r14.zzk(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0332:
            com.google.android.gms.internal.measurement.zzkc r2 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzit r5 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzho) r15)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0344:
            boolean r2 = zzf(r4)     // Catch:{ zzim -> 0x04f6 }
            if (r2 == 0) goto L_0x0358
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            r14.zzj(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0358:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            r14.zzi(r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x0366:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0275
        L_0x0371:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0283
        L_0x037c:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0291
        L_0x0387:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x029f
        L_0x0392:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x02ad
        L_0x039d:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x02bb
        L_0x03a8:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x02c9
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzim -> 0x04f6 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzim -> 0x04f6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x02d7
        L_0x03be:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzim -> 0x04f6 }
            if (r2 == 0) goto L_0x03dc
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzla.zzf(r13, r4)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r3 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzim -> 0x04f6 }
        L_0x03d7:
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x03dc:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r2 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzim -> 0x04f6 }
        L_0x03ea:
            r12.zzb(r13, (int) r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x0009
        L_0x03ef:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzt()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x03fa:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            int r2 = r14.zzs()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0405:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzr()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0410:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            int r2 = r14.zzq()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x041b:
            int r5 = r14.zzp()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzif r7 = r12.zzc((int) r3)     // Catch:{ zzim -> 0x04f6 }
            if (r7 == 0) goto L_0x042b
            boolean r7 = r7.zza(r5)     // Catch:{ zzim -> 0x04f6 }
            if (r7 == 0) goto L_0x00ea
        L_0x042b:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0432:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            int r2 = r14.zzo()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x043d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzgt r2 = r14.zzn()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0448:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzim -> 0x04f6 }
            if (r2 == 0) goto L_0x0463
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzla.zzf(r13, r4)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r3 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03d7
        L_0x0463:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzkc r2 = r12.zza((int) r3)     // Catch:{ zzim -> 0x04f6 }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0473:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0478:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            boolean r2 = r14.zzk()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0484:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            int r2 = r14.zzj()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x0490:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzi()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x049c:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            int r2 = r14.zzh()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x04a8:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzf()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x04b4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            long r6 = r14.zzg()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            float r2 = r14.zze()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x04cc:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzim -> 0x04f6 }
            double r6 = r14.zzd()     // Catch:{ zzim -> 0x04f6 }
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ zzim -> 0x04f6 }
            goto L_0x03ea
        L_0x04d8:
            r10 = r2
        L_0x04d9:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ zzim -> 0x04f6 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x04e1:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x04f0
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x04e1
        L_0x04f0:
            if (r10 == 0) goto L_0x04f5
            r8.zzb((java.lang.Object) r13, r10)
        L_0x04f5:
            return
        L_0x04f6:
            r8.zza((com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ all -> 0x051d }
            if (r10 != 0) goto L_0x0500
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x051d }
            r10 = r2
        L_0x0500:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzjz) r14)     // Catch:{ all -> 0x051d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0508:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0517
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0508
        L_0x0517:
            if (r10 == 0) goto L_0x051c
            r8.zzb((java.lang.Object) r13, r10)
        L_0x051c:
            return
        L_0x051d:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x0520:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x052f
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x0520
        L_0x052f:
            if (r10 == 0) goto L_0x0534
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0534:
            throw r14
        L_0x0535:
            goto L_0x0537
        L_0x0536:
            throw r0
        L_0x0537:
            goto L_0x0536
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjz, com.google.android.gms.internal.measurement.zzho):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0387, code lost:
        r15.zzb(r9, com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r8 & 1048575)), zza(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a2, code lost:
        r15.zze(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b3, code lost:
        r15.zzf(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03c4, code lost:
        r15.zzb(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d5, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03e6, code lost:
        r15.zzb(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03f7, code lost:
        r15.zze(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0402, code lost:
        r15.zza(r9, (com.google.android.gms.internal.measurement.zzgt) com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0415, code lost:
        r15.zza(r9, com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r8 & 1048575)), zza(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x042a, code lost:
        zza(r9, com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0441, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0452, code lost:
        r15.zzd(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0462, code lost:
        r15.zzd(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0472, code lost:
        r15.zzc(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0482, code lost:
        r15.zzc(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0492, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04a2, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04b2, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0846, code lost:
        r15.zzb(r10, com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r9 & 1048575)), zza(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0861, code lost:
        r15.zze(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0872, code lost:
        r15.zzf(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0883, code lost:
        r15.zzb(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0894, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x08a5, code lost:
        r15.zzb(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x08b6, code lost:
        r15.zze(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x08c1, code lost:
        r15.zza(r10, (com.google.android.gms.internal.measurement.zzgt) com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x08d4, code lost:
        r15.zza(r10, com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r9 & 1048575)), zza(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x08e9, code lost:
        zza(r10, com.google.android.gms.internal.measurement.zzla.zzf(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0900, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0911, code lost:
        r15.zzd(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0921, code lost:
        r15.zzd(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0931, code lost:
        r15.zzc(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0941, code lost:
        r15.zzc(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0951, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0961, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0971, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x097a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzln r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzib.zzf.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04d1
            com.google.android.gms.internal.measurement.zzku<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzln) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzhq<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzhr r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzkd<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x04b9
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhq<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhq<?> r10 = r13.zzr
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
            long r10 = zze(r14, r10)
            goto L_0x03a2
        L_0x0080:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03b3
        L_0x008e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x03c4
        L_0x009c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03d5
        L_0x00aa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03e6
        L_0x00b8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
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
            boolean r8 = zzf(r14, r10)
            goto L_0x0441
        L_0x00ec:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x0452
        L_0x00fa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x0462
        L_0x0108:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x0472
        L_0x0116:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x0482
        L_0x0124:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x0492
        L_0x0132:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            goto L_0x04a2
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            goto L_0x04b2
        L_0x014e:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.measurement.zzln) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x04b5
        L_0x0159:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkc r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzke.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzln) r15, (com.google.android.gms.internal.measurement.zzkc) r10)
            goto L_0x04b5
        L_0x016e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zze(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x017f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzj(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0190:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzg(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01a1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzl(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01b2:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzm(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01c3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzi(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01d4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzn(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01e5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzk(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01f6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzf(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0207:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzh(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0218:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzd(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0229:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzc(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x023a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r4)
            goto L_0x04b5
        L_0x024b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r4)
            goto L_0x04b5
        L_0x025c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zze(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x026d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzj(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x027e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzg(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x028f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzl(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02a0:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzm(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzi(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02c2:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzb((int) r9, (java.util.List<com.google.android.gms.internal.measurement.zzgt>) r8, (com.google.android.gms.internal.measurement.zzln) r15)
            goto L_0x04b5
        L_0x02d3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkc r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzke.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzln) r15, (com.google.android.gms.internal.measurement.zzkc) r10)
            goto L_0x04b5
        L_0x02e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzln) r15)
            goto L_0x04b5
        L_0x02f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzn(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x030a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzk(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x031b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzf(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x032c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzh(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x033d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzd(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x034e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzc(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x035f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0370:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzke.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0381:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0387:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzkc r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkc) r10)
            goto L_0x04b5
        L_0x0396:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r10)
        L_0x03a2:
            r15.zze((int) r9, (long) r10)
            goto L_0x04b5
        L_0x03a7:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r10)
        L_0x03b3:
            r15.zzf(r9, r8)
            goto L_0x04b5
        L_0x03b8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r10)
        L_0x03c4:
            r15.zzb((int) r9, (long) r10)
            goto L_0x04b5
        L_0x03c9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r10)
        L_0x03d5:
            r15.zza((int) r9, (int) r8)
            goto L_0x04b5
        L_0x03da:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r10)
        L_0x03e6:
            r15.zzb((int) r9, (int) r8)
            goto L_0x04b5
        L_0x03eb:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r10)
        L_0x03f7:
            r15.zze((int) r9, (int) r8)
            goto L_0x04b5
        L_0x03fc:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0402:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzgt r8 = (com.google.android.gms.internal.measurement.zzgt) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzgt) r8)
            goto L_0x04b5
        L_0x040f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0415:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzkc r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkc) r10)
            goto L_0x04b5
        L_0x0424:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x042a:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzln) r15)
            goto L_0x04b5
        L_0x0435:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzla.zzc(r14, r10)
        L_0x0441:
            r15.zza((int) r9, (boolean) r8)
            goto L_0x04b5
        L_0x0446:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r10)
        L_0x0452:
            r15.zzd((int) r9, (int) r8)
            goto L_0x04b5
        L_0x0456:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r10)
        L_0x0462:
            r15.zzd((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0466:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r10)
        L_0x0472:
            r15.zzc((int) r9, (int) r8)
            goto L_0x04b5
        L_0x0476:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r10)
        L_0x0482:
            r15.zzc((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0486:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r10)
        L_0x0492:
            r15.zza((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0496:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzla.zzd(r14, r10)
        L_0x04a2:
            r15.zza((int) r9, (float) r8)
            goto L_0x04b5
        L_0x04a6:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzla.zze(r14, r10)
        L_0x04b2:
            r15.zza((int) r9, (double) r10)
        L_0x04b5:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x04b9:
            if (r1 == 0) goto L_0x04d0
            com.google.android.gms.internal.measurement.zzhq<?> r14 = r13.zzr
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
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0994
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x04f2
            com.google.android.gms.internal.measurement.zzhq<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzhr r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzkd<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04f2
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f4
        L_0x04f2:
            r0 = r3
            r1 = r0
        L_0x04f4:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = 0
        L_0x04f8:
            if (r8 >= r7) goto L_0x0978
            int r9 = r13.zzd((int) r8)
            int[] r10 = r13.zzc
            r10 = r10[r8]
        L_0x0502:
            if (r1 == 0) goto L_0x0520
            com.google.android.gms.internal.measurement.zzhq<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0520
            com.google.android.gms.internal.measurement.zzhq<?> r11 = r13.zzr
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
            long r11 = zze(r14, r11)
            goto L_0x0861
        L_0x053f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0872
        L_0x054d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0883
        L_0x055b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0894
        L_0x0569:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x08a5
        L_0x0577:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
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
            boolean r9 = zzf(r14, r11)
            goto L_0x0900
        L_0x05ab:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0911
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0921
        L_0x05c7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0931
        L_0x05d5:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0941
        L_0x05e3:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0951
        L_0x05f1:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            goto L_0x0961
        L_0x05ff:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            goto L_0x0971
        L_0x060d:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.measurement.zzln) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0974
        L_0x0618:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkc r11 = r13.zza((int) r8)
            com.google.android.gms.internal.measurement.zzke.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzln) r15, (com.google.android.gms.internal.measurement.zzkc) r11)
            goto L_0x0974
        L_0x062d:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zze(r10, r9, r15, r4)
            goto L_0x0974
        L_0x063e:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzj(r10, r9, r15, r4)
            goto L_0x0974
        L_0x064f:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzg(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0660:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzl(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0671:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzm(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0682:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzi(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0693:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzn(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06a4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzk(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06b5:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzf(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06c6:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzh(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06d7:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzd(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06e8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzc(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06f9:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r4)
            goto L_0x0974
        L_0x070a:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r4)
            goto L_0x0974
        L_0x071b:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zze(r10, r9, r15, r5)
            goto L_0x0974
        L_0x072c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzj(r10, r9, r15, r5)
            goto L_0x0974
        L_0x073d:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzg(r10, r9, r15, r5)
            goto L_0x0974
        L_0x074e:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzl(r10, r9, r15, r5)
            goto L_0x0974
        L_0x075f:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzm(r10, r9, r15, r5)
            goto L_0x0974
        L_0x0770:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzi(r10, r9, r15, r5)
            goto L_0x0974
        L_0x0781:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzb((int) r10, (java.util.List<com.google.android.gms.internal.measurement.zzgt>) r9, (com.google.android.gms.internal.measurement.zzln) r15)
            goto L_0x0974
        L_0x0792:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkc r11 = r13.zza((int) r8)
            com.google.android.gms.internal.measurement.zzke.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzln) r15, (com.google.android.gms.internal.measurement.zzkc) r11)
            goto L_0x0974
        L_0x07a7:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzln) r15)
            goto L_0x0974
        L_0x07b8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzn(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07c9:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzk(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07da:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzf(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07eb:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzh(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07fc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzd(r10, r9, r15, r5)
            goto L_0x0974
        L_0x080d:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzc(r10, r9, r15, r5)
            goto L_0x0974
        L_0x081e:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r5)
            goto L_0x0974
        L_0x082f:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzke.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzln) r15, (boolean) r5)
            goto L_0x0974
        L_0x0840:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x0846:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzkc r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzkc) r11)
            goto L_0x0974
        L_0x0855:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r11)
        L_0x0861:
            r15.zze((int) r10, (long) r11)
            goto L_0x0974
        L_0x0866:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r11)
        L_0x0872:
            r15.zzf(r10, r9)
            goto L_0x0974
        L_0x0877:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r11)
        L_0x0883:
            r15.zzb((int) r10, (long) r11)
            goto L_0x0974
        L_0x0888:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r11)
        L_0x0894:
            r15.zza((int) r10, (int) r9)
            goto L_0x0974
        L_0x0899:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r11)
        L_0x08a5:
            r15.zzb((int) r10, (int) r9)
            goto L_0x0974
        L_0x08aa:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r11)
        L_0x08b6:
            r15.zze((int) r10, (int) r9)
            goto L_0x0974
        L_0x08bb:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08c1:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzgt r9 = (com.google.android.gms.internal.measurement.zzgt) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzgt) r9)
            goto L_0x0974
        L_0x08ce:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08d4:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzkc r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzkc) r11)
            goto L_0x0974
        L_0x08e3:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08e9:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzla.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzln) r15)
            goto L_0x0974
        L_0x08f4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzla.zzc(r14, r11)
        L_0x0900:
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0974
        L_0x0905:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r11)
        L_0x0911:
            r15.zzd((int) r10, (int) r9)
            goto L_0x0974
        L_0x0915:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r11)
        L_0x0921:
            r15.zzd((int) r10, (long) r11)
            goto L_0x0974
        L_0x0925:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r11)
        L_0x0931:
            r15.zzc((int) r10, (int) r9)
            goto L_0x0974
        L_0x0935:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r11)
        L_0x0941:
            r15.zzc((int) r10, (long) r11)
            goto L_0x0974
        L_0x0945:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzla.zzb(r14, r11)
        L_0x0951:
            r15.zza((int) r10, (long) r11)
            goto L_0x0974
        L_0x0955:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzla.zzd(r14, r11)
        L_0x0961:
            r15.zza((int) r10, (float) r9)
            goto L_0x0974
        L_0x0965:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzla.zze(r14, r11)
        L_0x0971:
            r15.zza((int) r10, (double) r11)
        L_0x0974:
            int r8 = r8 + 3
            goto L_0x04f8
        L_0x0978:
            if (r1 == 0) goto L_0x098e
            com.google.android.gms.internal.measurement.zzhq<?> r2 = r13.zzr
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
            com.google.android.gms.internal.measurement.zzku<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzln) r15)
            return
        L_0x0994:
            r13.zzb(r14, (com.google.android.gms.internal.measurement.zzln) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzln):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02c6, code lost:
        if (r0 == r15) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x030d, code lost:
        if (r0 == r15) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x032e, code lost:
        if (r0 == r15) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0330, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0115, code lost:
        r1 = r11.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0117, code lost:
        r7.putObject(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b4, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c8, code lost:
        r1 = r11.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ca, code lost:
        r7.putInt(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x021e, code lost:
        r6 = r6 | r23;
        r9 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0223, code lost:
        r2 = r5;
        r29 = r7;
        r18 = r10;
        r7 = r20;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzgo r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x0375
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0358
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgo) r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zza((int) r5, (int) r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzg(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r18 = 0
        L_0x004e:
            r20 = -1
            goto L_0x0332
        L_0x0052:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r33 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x022c
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r5) goto L_0x0085
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r18
        L_0x0087:
            if (r0 == r5) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r18
        L_0x0094:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x0207;
                case 1: goto L_0x01f0;
                case 2: goto L_0x01ce;
                case 3: goto L_0x01ce;
                case 4: goto L_0x01b7;
                case 5: goto L_0x0195;
                case 6: goto L_0x017e;
                case 7: goto L_0x015e;
                case 8: goto L_0x0141;
                case 9: goto L_0x011c;
                case 10: goto L_0x0104;
                case 11: goto L_0x01b7;
                case 12: goto L_0x00f2;
                case 13: goto L_0x017e;
                case 14: goto L_0x0195;
                case 15: goto L_0x00da;
                case 16: goto L_0x00a5;
                default: goto L_0x0098;
            }
        L_0x0098:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            goto L_0x0223
        L_0x00a5:
            if (r3 != 0) goto L_0x00cc
            int r10 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r4, r11)
            long r0 = r11.zzb
            long r17 = com.google.android.gms.internal.measurement.zzhf.zza((long) r0)
            r0 = r2
            r1 = r31
            r4 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r25 = r33
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r8
            r0 = r10
            goto L_0x0276
        L_0x00cc:
            r25 = r33
            r8 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            r5 = r4
            r10 = r8
            goto L_0x0223
        L_0x00da:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01b4
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzhf.zze(r1)
            goto L_0x01ca
        L_0x00f2:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01b4
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r4, r11)
            goto L_0x01c8
        L_0x0104:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01b4
            int r0 = com.google.android.gms.internal.measurement.zzgp.zze(r12, r4, r11)
        L_0x0115:
            java.lang.Object r1 = r11.zzc
        L_0x0117:
            r7.putObject(r14, r8, r1)
            goto L_0x021e
        L_0x011c:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01b4
            com.google.android.gms.internal.measurement.zzkc r0 = r15.zza((int) r10)
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((com.google.android.gms.internal.measurement.zzkc) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgo) r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x013a
            java.lang.Object r1 = r11.zzc
            goto L_0x0117
        L_0x013a:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzie.zza((java.lang.Object) r1, (java.lang.Object) r2)
            goto L_0x0117
        L_0x0141:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01b4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0159
            int r0 = com.google.android.gms.internal.measurement.zzgp.zzc(r12, r4, r11)
            goto L_0x0115
        L_0x0159:
            int r0 = com.google.android.gms.internal.measurement.zzgp.zzd(r12, r4, r11)
            goto L_0x0115
        L_0x015e:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01b4
            int r0 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0178
            r1 = 1
            goto L_0x0179
        L_0x0178:
            r1 = 0
        L_0x0179:
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r8, (boolean) r1)
            goto L_0x021e
        L_0x017e:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01b4
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r4)
            r7.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x021e
        L_0x0195:
            r25 = r33
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01b4
            long r17 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x021e
        L_0x01b4:
            r5 = r4
            goto L_0x0223
        L_0x01b7:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0223
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r12, r5, r11)
        L_0x01c8:
            int r1 = r11.zza
        L_0x01ca:
            r7.putInt(r14, r8, r1)
            goto L_0x021e
        L_0x01ce:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0223
            int r17 = com.google.android.gms.internal.measurement.zzgp.zzb(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            r0 = r17
            goto L_0x0276
        L_0x01f0:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0223
            float r0 = com.google.android.gms.internal.measurement.zzgp.zzd(r12, r5)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r8, (float) r0)
            int r0 = r5 + 4
            goto L_0x021e
        L_0x0207:
            r25 = r33
            r5 = r4
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0223
            double r0 = com.google.android.gms.internal.measurement.zzgp.zzc(r12, r5)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r14, (long) r8, (double) r0)
            int r0 = r5 + 8
        L_0x021e:
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            goto L_0x0276
        L_0x0223:
            r2 = r5
            r29 = r7
            r18 = r10
            r7 = r20
            goto L_0x004e
        L_0x022c:
            r25 = r33
            r5 = r4
            r20 = r7
            r7 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r0 = 27
            if (r10 != r0) goto L_0x0289
            r0 = 2
            if (r3 != r0) goto L_0x027c
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzik r0 = (com.google.android.gms.internal.measurement.zzik) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x025c
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0253
            r1 = 10
            goto L_0x0255
        L_0x0253:
            int r1 = r1 << 1
        L_0x0255:
            com.google.android.gms.internal.measurement.zzik r0 = r0.zza(r1)
            r7.putObject(r14, r8, r0)
        L_0x025c:
            r8 = r0
            com.google.android.gms.internal.measurement.zzkc r0 = r15.zza((int) r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r18 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza(r0, r1, r2, r3, r4, r5, r6)
            r9 = r7
            r6 = r8
            r2 = r18
        L_0x0276:
            r7 = r20
            r1 = r25
            goto L_0x0352
        L_0x027c:
            r18 = r4
            r15 = r5
            r27 = r6
            r29 = r7
            r28 = r20
            r20 = -1
            goto L_0x0310
        L_0x0289:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02de
            r1 = r21
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r4 = r3
            r3 = r5
            r33 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r33
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r18
            r19 = r10
            r29 = r20
            r20 = -1
            r9 = r21
            r11 = r19
            r12 = r23
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgo) r14)
            if (r0 != r15) goto L_0x02ca
            goto L_0x0330
        L_0x02ca:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x0350
        L_0x02de:
            r33 = r3
            r15 = r5
            r27 = r6
            r29 = r7
            r23 = r8
            r19 = r10
            r28 = r20
            r1 = r21
            r20 = -1
            r0 = 50
            r9 = r19
            r7 = r33
            if (r9 != r0) goto L_0x0316
            r0 = 2
            if (r7 != r0) goto L_0x0310
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r18
            r6 = r23
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgo) r8)
            if (r0 != r15) goto L_0x02ca
            goto L_0x0330
        L_0x0310:
            r2 = r15
        L_0x0311:
            r6 = r27
            r7 = r28
            goto L_0x0332
        L_0x0316:
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgo) r13)
            if (r0 != r15) goto L_0x02ca
        L_0x0330:
            r2 = r0
            goto L_0x0311
        L_0x0332:
            com.google.android.gms.internal.measurement.zzkt r4 = zze((java.lang.Object) r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzgp.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkt) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
        L_0x0350:
            r9 = r29
        L_0x0352:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x0358:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x036b
            long r1 = (long) r7
            r3 = r31
            r6 = r27
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x036b:
            r4 = r34
            if (r0 != r4) goto L_0x0370
            return
        L_0x0370:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r0
        L_0x0375:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgo) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzc(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzla.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzla.zzd(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzla.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzla.zze(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01ba
            int r4 = r9.zzd((int) r2)
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
            int r4 = r9.zze((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzla.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzke.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzke.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01b3
        L_0x004a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzla.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzke.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzla.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x0074:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0086:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzla.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x009a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00ac:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x00be:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00d0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzla.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzke.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzla.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzke.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzla.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzke.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            boolean r4 = com.google.android.gms.internal.measurement.zzla.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzla.zzc(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0124:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0135:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzla.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0148:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0159:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzla.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x016c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzla.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            float r4 = com.google.android.gms.internal.measurement.zzla.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzla.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01b3
        L_0x0197:
            goto L_0x01b2
        L_0x0198:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            double r4 = com.google.android.gms.internal.measurement.zzla.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzla.zze(r11, r6)
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
            com.google.android.gms.internal.measurement.zzku<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.measurement.zzku<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01cd
            return r1
        L_0x01cd:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01e2
            com.google.android.gms.internal.measurement.zzhq<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzhr r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.measurement.zzhq<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzhr r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01e2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d7, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e8, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f9, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020a, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020c, code lost:
        r2.putInt(r1, (long) r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0210, code lost:
        r11 = ((com.google.android.gms.internal.measurement.zzhi.zzg(r3) + com.google.android.gms.internal.measurement.zzhi.zze(r13)) + r3) + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02aa, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzc(r13, (com.google.android.gms.internal.measurement.zzjj) com.google.android.gms.internal.measurement.zzla.zzf(r1, r14), zza(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02c4, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzf(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02d3, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzh(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02de, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzh(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02e9, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzj(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02f8, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzk(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0307, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzg(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0312, code lost:
        r3 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x031d, code lost:
        r3 = com.google.android.gms.internal.measurement.zzke.zza(r13, com.google.android.gms.internal.measurement.zzla.zzf(r1, r14), zza(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0329, code lost:
        r11 = r11 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0338, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzgt) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x033a, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzc(r13, (com.google.android.gms.internal.measurement.zzgt) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0341, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzb(r13, (java.lang.String) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x034e, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzb(r13, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0359, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzi(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0364, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzg(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0373, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzf(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0382, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zze(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0391, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzd(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x039c, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzb(r13, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03a7, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhi.zzb(r13, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03af, code lost:
        r10 = r10 + 3;
        r3 = 267386880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0418, code lost:
        if (zza(r1, r11, r3) != false) goto L_0x06bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0438, code lost:
        if (zza(r1, r11, r3) != false) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0440, code lost:
        if (zza(r1, r11, r3) != false) goto L_0x06f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0460, code lost:
        if (zza(r1, r11, r3) != false) goto L_0x0719;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0468, code lost:
        if (zza(r1, r11, r3) != false) goto L_0x0722;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0478, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzgt) != false) goto L_0x073d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0480, code lost:
        if (zza(r1, r11, r3) != false) goto L_0x074f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0518, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x052a, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x053c, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x054e, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0560, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0572, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0584, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0596, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x05a7, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x05b8, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x05c9, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x05da, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x05eb, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x05fc, code lost:
        if (r0.zzk != false) goto L_0x05fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x05fe, code lost:
        r2.putInt(r1, (long) r10, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0602, code lost:
        r4 = r4 + ((com.google.android.gms.internal.measurement.zzhi.zzg(r6) + com.google.android.gms.internal.measurement.zzhi.zze(r11)) + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x06bb, code lost:
        if ((r8 & r14) != 0) goto L_0x06bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x06bd, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, (com.google.android.gms.internal.measurement.zzjj) r2.getObject(r1, r6), zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06d4, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzf(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x06e1, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzh(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x06e8, code lost:
        if ((r8 & r14) != 0) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x06ea, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzh(r11, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x06f3, code lost:
        if ((r8 & r14) != 0) goto L_0x06f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x06f5, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzj(r11, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0703, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzk(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0710, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzg(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0717, code lost:
        if ((r8 & r14) != 0) goto L_0x0719;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0719, code lost:
        r6 = r2.getObject(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x0720, code lost:
        if ((r8 & r14) != 0) goto L_0x0722;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0722, code lost:
        r6 = com.google.android.gms.internal.measurement.zzke.zza(r11, r2.getObject(r1, r6), zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x072e, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x073b, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzgt) != false) goto L_0x073d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x073d, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, (com.google.android.gms.internal.measurement.zzgt) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0744, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzb(r11, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x074d, code lost:
        if ((r8 & r14) != 0) goto L_0x074f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x074f, code lost:
        r6 = com.google.android.gms.internal.measurement.zzhi.zzb(r11, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzgt) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x078f, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x07a6, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x07a7, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x07a9, code lost:
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x07ab, code lost:
        r3 = r3 + 3;
        r7 = r15;
        r6 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0126, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0138, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014a, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015c, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016e, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0180, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0192, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a4, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b5, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c6, code lost:
        if (r0.zzk != false) goto L_0x020c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.zzj
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r5 = 1
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r7 = 0
            r9 = 0
            if (r2 == 0) goto L_0x03bd
            sun.misc.Unsafe r2 = zzb
            r10 = 0
            r11 = 0
        L_0x0016:
            int[] r12 = r0.zzc
            int r12 = r12.length
            if (r10 >= r12) goto L_0x03b5
            int r12 = r0.zzd((int) r10)
            r3 = r3 & r12
            int r3 = r3 >>> 20
            int[] r13 = r0.zzc
            r13 = r13[r10]
            r12 = r12 & r6
            long r14 = (long) r12
            com.google.android.gms.internal.measurement.zzhw r12 = com.google.android.gms.internal.measurement.zzhw.DOUBLE_LIST_PACKED
            int r12 = r12.zza()
            if (r3 < r12) goto L_0x0040
            com.google.android.gms.internal.measurement.zzhw r12 = com.google.android.gms.internal.measurement.zzhw.SINT64_LIST_PACKED
            int r12 = r12.zza()
            if (r3 > r12) goto L_0x0040
            int[] r12 = r0.zzc
            int r16 = r10 + 2
            r12 = r12[r16]
            r12 = r12 & r6
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
            long r14 = zze(r1, r14)
            goto L_0x02c4
        L_0x005a:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzd(r1, r14)
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
            int r3 = zzd(r1, r14)
            goto L_0x02f8
        L_0x0082:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzd(r1, r14)
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
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.measurement.zzgt
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
            int r3 = zzd(r1, r14)
            goto L_0x0373
        L_0x00d2:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zze(r1, r14)
            goto L_0x0382
        L_0x00de:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zze(r1, r14)
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
            com.google.android.gms.internal.measurement.zzjg r3 = r0.zzs
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14)
            java.lang.Object r14 = r0.zzb((int) r10)
            int r3 = r3.zza(r13, r12, r14)
            goto L_0x0329
        L_0x010a:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.measurement.zzkc r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzb((int) r13, (java.util.List<com.google.android.gms.internal.measurement.zzjj>) r3, (com.google.android.gms.internal.measurement.zzkc) r12)
            goto L_0x0329
        L_0x0118:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzc(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x012a:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzg(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x013c:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzi(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x014e:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzh(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0160:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzd(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0172:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzf(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0184:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzj(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0196:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzh(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01a7:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzi(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01b8:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zze(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01c9:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzb(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01da:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zza((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01eb:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzh(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01fc:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzke.zzi(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzk
            if (r14 == 0) goto L_0x0210
        L_0x020c:
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x0210:
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            int r13 = r13 + r12
            int r13 = r13 + r3
            int r13 = r13 + r11
            r11 = r13
            goto L_0x03af
        L_0x021e:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzc(r13, r3, r9)
            goto L_0x0329
        L_0x0228:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzg(r13, r3, r9)
            goto L_0x0329
        L_0x0232:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzd(r13, r3, r9)
            goto L_0x0329
        L_0x023c:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzf(r13, r3, r9)
            goto L_0x0329
        L_0x0246:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzb(r13, r3)
            goto L_0x0329
        L_0x0250:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.measurement.zzkc r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzke.zza((int) r13, (java.util.List<?>) r3, (com.google.android.gms.internal.measurement.zzkc) r12)
            goto L_0x0329
        L_0x025e:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zza((int) r13, (java.util.List<?>) r3)
            goto L_0x0329
        L_0x0268:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzj(r13, r3, r9)
            goto L_0x0329
        L_0x0272:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zze(r13, r3, r9)
            goto L_0x0329
        L_0x027c:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzb((int) r13, (java.util.List<java.lang.Long>) r3, (boolean) r9)
            goto L_0x0329
        L_0x0286:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zza((int) r13, (java.util.List<java.lang.Long>) r3, (boolean) r9)
            goto L_0x0329
        L_0x0290:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzh(r13, r3, r9)
            goto L_0x0329
        L_0x029a:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzke.zzi(r13, r3, r9)
            goto L_0x0329
        L_0x02a4:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02aa:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzjj r3 = (com.google.android.gms.internal.measurement.zzjj) r3
            com.google.android.gms.internal.measurement.zzkc r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc(r13, r3, r12)
            goto L_0x0329
        L_0x02ba:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.measurement.zzla.zzb(r1, r14)
        L_0x02c4:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r13, (long) r14)
            goto L_0x0329
        L_0x02c9:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r1, (long) r14)
        L_0x02d3:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r13, (int) r3)
            goto L_0x0329
        L_0x02d8:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02de:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r13, (long) r7)
            goto L_0x0329
        L_0x02e3:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02e9:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzj(r13, r9)
            goto L_0x0329
        L_0x02ee:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r1, (long) r14)
        L_0x02f8:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzk(r13, r3)
            goto L_0x0329
        L_0x02fd:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r1, (long) r14)
        L_0x0307:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r13, (int) r3)
            goto L_0x0329
        L_0x030c:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0312:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14)
            goto L_0x033a
        L_0x0317:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x031d:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzkc r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzke.zza((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.measurement.zzkc) r12)
        L_0x0329:
            int r11 = r11 + r3
            goto L_0x03af
        L_0x032c:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzla.zzf(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.measurement.zzgt
            if (r12 == 0) goto L_0x0341
        L_0x033a:
            com.google.android.gms.internal.measurement.zzgt r3 = (com.google.android.gms.internal.measurement.zzgt) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r13, (com.google.android.gms.internal.measurement.zzgt) r3)
            goto L_0x0329
        L_0x0341:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (java.lang.String) r3)
            goto L_0x0329
        L_0x0348:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x034e:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (boolean) r5)
            goto L_0x0329
        L_0x0353:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0359:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzi(r13, r9)
            goto L_0x0329
        L_0x035e:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0364:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r13, (long) r7)
            goto L_0x0329
        L_0x0369:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r1, (long) r14)
        L_0x0373:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r13, (int) r3)
            goto L_0x0329
        L_0x0378:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.measurement.zzla.zzb(r1, r14)
        L_0x0382:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13, (long) r14)
            goto L_0x0329
        L_0x0387:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.measurement.zzla.zzb(r1, r14)
        L_0x0391:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r13, (long) r14)
            goto L_0x0329
        L_0x0396:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x039c:
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (float) r4)
            goto L_0x0329
        L_0x03a1:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x03a7:
            r14 = 0
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (double) r14)
            goto L_0x0329
        L_0x03af:
            int r10 = r10 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x03b5:
            com.google.android.gms.internal.measurement.zzku<?, ?> r2 = r0.zzq
            int r1 = zza(r2, r1)
            int r11 = r11 + r1
            return r11
        L_0x03bd:
            sun.misc.Unsafe r2 = zzb
            r3 = 0
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 0
        L_0x03c5:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r3 >= r9) goto L_0x07b3
            int r9 = r0.zzd((int) r3)
            int[] r10 = r0.zzc
            r11 = r10[r3]
            r12 = 267386880(0xff00000, float:2.3665827E-29)
            r12 = r12 & r9
            int r12 = r12 >>> 20
            r13 = 17
            if (r12 > r13) goto L_0x03ee
            int r13 = r3 + 2
            r10 = r10[r13]
            r13 = r10 & r6
            int r14 = r10 >>> 20
            int r14 = r5 << r14
            if (r13 == r7) goto L_0x040c
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
            goto L_0x040c
        L_0x03ee:
            boolean r10 = r0.zzk
            if (r10 == 0) goto L_0x040a
            com.google.android.gms.internal.measurement.zzhw r10 = com.google.android.gms.internal.measurement.zzhw.DOUBLE_LIST_PACKED
            int r10 = r10.zza()
            if (r12 < r10) goto L_0x040a
            com.google.android.gms.internal.measurement.zzhw r10 = com.google.android.gms.internal.measurement.zzhw.SINT64_LIST_PACKED
            int r10 = r10.zza()
            if (r12 > r10) goto L_0x040a
            int[] r10 = r0.zzc
            int r13 = r3 + 2
            r10 = r10[r13]
            r10 = r10 & r6
            goto L_0x040b
        L_0x040a:
            r10 = 0
        L_0x040b:
            r14 = 0
        L_0x040c:
            r9 = r9 & r6
            r15 = r7
            long r6 = (long) r9
            switch(r12) {
                case 0: goto L_0x079c;
                case 1: goto L_0x0791;
                case 2: goto L_0x0783;
                case 3: goto L_0x0776;
                case 4: goto L_0x0769;
                case 5: goto L_0x075e;
                case 6: goto L_0x0754;
                case 7: goto L_0x074b;
                case 8: goto L_0x0731;
                case 9: goto L_0x071e;
                case 10: goto L_0x0715;
                case 11: goto L_0x0708;
                case 12: goto L_0x06fb;
                case 13: goto L_0x06f1;
                case 14: goto L_0x06e6;
                case 15: goto L_0x06d9;
                case 16: goto L_0x06cc;
                case 17: goto L_0x06b9;
                case 18: goto L_0x06ac;
                case 19: goto L_0x069f;
                case 20: goto L_0x0692;
                case 21: goto L_0x0685;
                case 22: goto L_0x0678;
                case 23: goto L_0x06ac;
                case 24: goto L_0x069f;
                case 25: goto L_0x066b;
                case 26: goto L_0x065f;
                case 27: goto L_0x064f;
                case 28: goto L_0x0643;
                case 29: goto L_0x0636;
                case 30: goto L_0x0629;
                case 31: goto L_0x069f;
                case 32: goto L_0x06ac;
                case 33: goto L_0x061c;
                case 34: goto L_0x060f;
                case 35: goto L_0x05ee;
                case 36: goto L_0x05dd;
                case 37: goto L_0x05cc;
                case 38: goto L_0x05bb;
                case 39: goto L_0x05aa;
                case 40: goto L_0x0599;
                case 41: goto L_0x0588;
                case 42: goto L_0x0576;
                case 43: goto L_0x0564;
                case 44: goto L_0x0552;
                case 45: goto L_0x0540;
                case 46: goto L_0x052e;
                case 47: goto L_0x051c;
                case 48: goto L_0x050a;
                case 49: goto L_0x04fa;
                case 50: goto L_0x04ea;
                case 51: goto L_0x04dc;
                case 52: goto L_0x04cf;
                case 53: goto L_0x04bf;
                case 54: goto L_0x04af;
                case 55: goto L_0x049f;
                case 56: goto L_0x0491;
                case 57: goto L_0x0484;
                case 58: goto L_0x047c;
                case 59: goto L_0x046c;
                case 60: goto L_0x0464;
                case 61: goto L_0x045c;
                case 62: goto L_0x0450;
                case 63: goto L_0x0444;
                case 64: goto L_0x043c;
                case 65: goto L_0x0434;
                case 66: goto L_0x0428;
                case 67: goto L_0x041c;
                case 68: goto L_0x0414;
                default: goto L_0x0412;
            }
        L_0x0412:
            goto L_0x07a9
        L_0x0414:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            goto L_0x06bd
        L_0x041c:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            long r6 = zze(r1, r6)
            goto L_0x06d4
        L_0x0428:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            int r6 = zzd(r1, r6)
            goto L_0x06e1
        L_0x0434:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            goto L_0x06ea
        L_0x043c:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            goto L_0x06f5
        L_0x0444:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            int r6 = zzd(r1, r6)
            goto L_0x0703
        L_0x0450:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            int r6 = zzd(r1, r6)
            goto L_0x0710
        L_0x045c:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            goto L_0x0719
        L_0x0464:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            goto L_0x0722
        L_0x046c:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            java.lang.Object r6 = r2.getObject(r1, r6)
            boolean r7 = r6 instanceof com.google.android.gms.internal.measurement.zzgt
            if (r7 == 0) goto L_0x0744
            goto L_0x073d
        L_0x047c:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            goto L_0x074f
        L_0x0484:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzi(r11, r6)
            goto L_0x072e
        L_0x0491:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (long) r6)
            goto L_0x072e
        L_0x049f:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            int r6 = zzd(r1, r6)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (int) r6)
            goto L_0x072e
        L_0x04af:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            long r6 = zze(r1, r6)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11, (long) r6)
            goto L_0x072e
        L_0x04bf:
            boolean r9 = r0.zza(r1, (int) r11, (int) r3)
            if (r9 == 0) goto L_0x07a9
            long r6 = zze(r1, r6)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r11, (long) r6)
            goto L_0x072e
        L_0x04cf:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (float) r6)
            goto L_0x072e
        L_0x04dc:
            boolean r6 = r0.zza(r1, (int) r11, (int) r3)
            if (r6 == 0) goto L_0x07a9
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (double) r6)
            goto L_0x072e
        L_0x04ea:
            com.google.android.gms.internal.measurement.zzjg r9 = r0.zzs
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.lang.Object r7 = r0.zzb((int) r3)
            int r6 = r9.zza(r11, r6, r7)
            goto L_0x072e
        L_0x04fa:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzkc r7 = r0.zza((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzke.zzb((int) r11, (java.util.List<com.google.android.gms.internal.measurement.zzjj>) r6, (com.google.android.gms.internal.measurement.zzkc) r7)
            goto L_0x072e
        L_0x050a:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzc(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x051c:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzg(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x052e:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzi(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x0540:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzh(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x0552:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzd(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x0564:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzf(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x0576:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzj(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x0588:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzh(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x0599:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzi(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x05aa:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zze(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x05bb:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzb(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x05cc:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zza((java.util.List<java.lang.Long>) r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x05dd:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzh(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
            goto L_0x05fe
        L_0x05ee:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzi(r6)
            if (r6 <= 0) goto L_0x07a9
            boolean r7 = r0.zzk
            if (r7 == 0) goto L_0x0602
        L_0x05fe:
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0602:
            int r7 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r6)
            int r9 = r9 + r7
            int r9 = r9 + r6
            int r4 = r4 + r9
            goto L_0x07a9
        L_0x060f:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            r7 = 0
            int r6 = com.google.android.gms.internal.measurement.zzke.zzc(r11, r6, r7)
            goto L_0x072e
        L_0x061c:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzg(r11, r6, r9)
            goto L_0x072e
        L_0x0629:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzd(r11, r6, r9)
            goto L_0x072e
        L_0x0636:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzf(r11, r6, r9)
            goto L_0x072e
        L_0x0643:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzb(r11, r6)
            goto L_0x072e
        L_0x064f:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzkc r7 = r0.zza((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzke.zza((int) r11, (java.util.List<?>) r6, (com.google.android.gms.internal.measurement.zzkc) r7)
            goto L_0x072e
        L_0x065f:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zza((int) r11, (java.util.List<?>) r6)
            goto L_0x072e
        L_0x066b:
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            r7 = 0
            int r6 = com.google.android.gms.internal.measurement.zzke.zzj(r11, r6, r7)
            goto L_0x072e
        L_0x0678:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zze(r11, r6, r9)
            goto L_0x072e
        L_0x0685:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzb((int) r11, (java.util.List<java.lang.Long>) r6, (boolean) r9)
            goto L_0x072e
        L_0x0692:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zza((int) r11, (java.util.List<java.lang.Long>) r6, (boolean) r9)
            goto L_0x072e
        L_0x069f:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzh(r11, r6, r9)
            goto L_0x072e
        L_0x06ac:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.measurement.zzke.zzi(r11, r6, r9)
            goto L_0x072e
        L_0x06b9:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
        L_0x06bd:
            java.lang.Object r6 = r2.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzjj r6 = (com.google.android.gms.internal.measurement.zzjj) r6
            com.google.android.gms.internal.measurement.zzkc r7 = r0.zza((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, r6, r7)
            goto L_0x072e
        L_0x06cc:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
            long r6 = r2.getLong(r1, r6)
        L_0x06d4:
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (long) r6)
            goto L_0x072e
        L_0x06d9:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
            int r6 = r2.getInt(r1, r6)
        L_0x06e1:
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r11, (int) r6)
            goto L_0x072e
        L_0x06e6:
            r6 = r8 & r14
            if (r6 == 0) goto L_0x07a9
        L_0x06ea:
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r11, (long) r6)
            goto L_0x072e
        L_0x06f1:
            r6 = r8 & r14
            if (r6 == 0) goto L_0x07a9
        L_0x06f5:
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzj(r11, r6)
            goto L_0x072e
        L_0x06fb:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
            int r6 = r2.getInt(r1, r6)
        L_0x0703:
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzk(r11, r6)
            goto L_0x072e
        L_0x0708:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
            int r6 = r2.getInt(r1, r6)
        L_0x0710:
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (int) r6)
            goto L_0x072e
        L_0x0715:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
        L_0x0719:
            java.lang.Object r6 = r2.getObject(r1, r6)
            goto L_0x073d
        L_0x071e:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
        L_0x0722:
            java.lang.Object r6 = r2.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzkc r7 = r0.zza((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzke.zza((int) r11, (java.lang.Object) r6, (com.google.android.gms.internal.measurement.zzkc) r7)
        L_0x072e:
            int r4 = r4 + r6
            goto L_0x07a9
        L_0x0731:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07a9
            java.lang.Object r6 = r2.getObject(r1, r6)
            boolean r7 = r6 instanceof com.google.android.gms.internal.measurement.zzgt
            if (r7 == 0) goto L_0x0744
        L_0x073d:
            com.google.android.gms.internal.measurement.zzgt r6 = (com.google.android.gms.internal.measurement.zzgt) r6
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r11, (com.google.android.gms.internal.measurement.zzgt) r6)
            goto L_0x072e
        L_0x0744:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (java.lang.String) r6)
            goto L_0x072e
        L_0x074b:
            r6 = r8 & r14
            if (r6 == 0) goto L_0x07a9
        L_0x074f:
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (boolean) r5)
            goto L_0x072e
        L_0x0754:
            r6 = r8 & r14
            if (r6 == 0) goto L_0x07a9
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzi(r11, r6)
            goto L_0x07a6
        L_0x075e:
            r6 = r8 & r14
            r9 = 0
            if (r6 == 0) goto L_0x07ab
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (long) r9)
            goto L_0x078f
        L_0x0769:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07ab
            int r6 = r2.getInt(r1, r6)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (int) r6)
            goto L_0x078f
        L_0x0776:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07ab
            long r6 = r2.getLong(r1, r6)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11, (long) r6)
            goto L_0x078f
        L_0x0783:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x07ab
            long r6 = r2.getLong(r1, r6)
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r11, (long) r6)
        L_0x078f:
            int r4 = r4 + r6
            goto L_0x07ab
        L_0x0791:
            r6 = r8 & r14
            if (r6 == 0) goto L_0x07ab
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (float) r6)
            int r4 = r4 + r6
            goto L_0x07ab
        L_0x079c:
            r6 = r8 & r14
            if (r6 == 0) goto L_0x07ab
            r6 = 0
            int r6 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (double) r6)
        L_0x07a6:
            int r6 = r6 + r4
        L_0x07a7:
            r4 = r6
            goto L_0x07ab
        L_0x07a9:
            r6 = r4
            goto L_0x07a7
        L_0x07ab:
            int r3 = r3 + 3
            r7 = r15
            r6 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x03c5
        L_0x07b3:
            r2 = 0
            com.google.android.gms.internal.measurement.zzku<?, ?> r3 = r0.zzq
            int r3 = zza(r3, r1)
            int r4 = r4 + r3
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x080d
            com.google.android.gms.internal.measurement.zzhq<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzhr r1 = r3.zza((java.lang.Object) r1)
            r3 = 0
        L_0x07c6:
            com.google.android.gms.internal.measurement.zzkd<T, java.lang.Object> r5 = r1.zza
            int r5 = r5.zzc()
            if (r3 >= r5) goto L_0x07e6
            com.google.android.gms.internal.measurement.zzkd<T, java.lang.Object> r5 = r1.zza
            java.util.Map$Entry r5 = r5.zzb((int) r3)
            java.lang.Object r6 = r5.getKey()
            com.google.android.gms.internal.measurement.zzht r6 = (com.google.android.gms.internal.measurement.zzht) r6
            java.lang.Object r5 = r5.getValue()
            int r5 = com.google.android.gms.internal.measurement.zzhr.zza((com.google.android.gms.internal.measurement.zzht<?>) r6, (java.lang.Object) r5)
            int r2 = r2 + r5
            int r3 = r3 + 1
            goto L_0x07c6
        L_0x07e6:
            com.google.android.gms.internal.measurement.zzkd<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x07f0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x080c
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getKey()
            com.google.android.gms.internal.measurement.zzht r5 = (com.google.android.gms.internal.measurement.zzht) r5
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzhr.zza((com.google.android.gms.internal.measurement.zzht<?>) r5, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x07f0
        L_0x080c:
            int r4 = r4 + r2
        L_0x080d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzla.zzf(r8, r2));
        zzb(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzla.zzf(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzla.zzb(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        zzb(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0101
            r0 = 0
        L_0x0003:
            int[] r1 = r6.zzc
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.zzd((int) r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zzc
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
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzla.zzf(r8, r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.zzb(r7, (int) r4, (int) r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.measurement.zzjg r1 = r6.zzs
            com.google.android.gms.internal.measurement.zzke.zza((com.google.android.gms.internal.measurement.zzjg) r1, r7, r8, (long) r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.measurement.zzit r1 = r6.zzp
            r1.zza(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.zza(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzla.zzf(r8, r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.measurement.zzla.zzc(r8, r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r8, (long) r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.measurement.zzla.zzb(r8, r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (long) r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.measurement.zzla.zzd(r8, r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.measurement.zzla.zze(r8, r2)
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r7, (long) r2, (double) r4)
        L_0x00eb:
            r6.zzb(r7, (int) r0)
        L_0x00ee:
            int r0 = r0 + 3
            goto L_0x0003
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzku<?, ?> r0 = r6.zzq
            com.google.android.gms.internal.measurement.zzke.zza(r0, r7, r8)
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x0100
            com.google.android.gms.internal.measurement.zzhq<?> r0 = r6.zzr
            com.google.android.gms.internal.measurement.zzke.zza(r0, r7, r8)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object, java.lang.Object):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzla.zzf(t, zzd2);
            if (zzf2 != null) {
                zzla.zza((Object) t, zzd2, this.zzs.zze(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    public final boolean zzd(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t2).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd2 = zzd(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t2, i7, i6) && !zza((Object) t2, zzd2, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzc2 = this.zzs.zzc(zzla.zzf(t2, (long) (zzd2 & 1048575)));
                            if (!zzc2.isEmpty()) {
                                if (this.zzs.zzb(zzb(i6)).zzc.zza() == zzlo.MESSAGE) {
                                    zzkc<?> zzkc = null;
                                    Iterator<?> it = zzc2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzkc == null) {
                                            zzkc = zzjy.zza().zza(next.getClass());
                                        }
                                        if (!zzkc.zzd(next)) {
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
                List list = (List) zzla.zzf(t2, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzkc zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzd2, zza(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }
}
