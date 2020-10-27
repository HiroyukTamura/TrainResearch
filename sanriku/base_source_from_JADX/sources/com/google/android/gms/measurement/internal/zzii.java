package com.google.android.gms.measurement.internal;

final class zzii extends zzkl {
    public zzii(zzkk zzkk) {
        super(zzkk);
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02b7 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0320 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }, LOOP:2: B:114:0x031a->B:116:0x0320, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x037d A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03a4 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03d5 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03f9 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x042d A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x047d A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }, LOOP:3: B:133:0x0477->B:135:0x047d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x04ea A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0501 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x050c A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0510 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x026e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0195 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01cb A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0240 A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x025d A[Catch:{ SecurityException -> 0x01d7, all -> 0x05b2 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(@androidx.annotation.NonNull com.google.android.gms.measurement.internal.zzao r29, @androidx.annotation.Size(min = 1) java.lang.String r30) {
        /*
            r28 = this;
            r1 = r28
            r0 = r29
            r15 = r30
            java.lang.String r2 = "_r"
            r28.zzd()
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzy
            r3.zzae()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.measurement.internal.zzy r3 = r28.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzax
            boolean r3 = r3.zze(r15, r4)
            r4 = 0
            if (r3 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzez r0 = r28.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            java.lang.String r2 = "Generating ScionPayload disabled. packageName"
            r0.zza(r2, r15)
            byte[] r0 = new byte[r4]
            return r0
        L_0x0033:
            java.lang.String r3 = r0.zza
            java.lang.String r5 = "_iap"
            boolean r3 = r5.equals(r3)
            r14 = 0
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = r0.zza
            java.lang.String r5 = "_iapx"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x0058
            com.google.android.gms.measurement.internal.zzez r2 = r28.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzw()
            java.lang.String r0 = r0.zza
            java.lang.String r3 = "Generating a payload for this event is not available. package_name, event_name"
            r2.zza(r3, r15, r0)
            return r14
        L_0x0058:
            com.google.android.gms.internal.measurement.zzcc$zzf$zza r13 = com.google.android.gms.internal.measurement.zzcc.zzf.zzb()
            com.google.android.gms.measurement.internal.zzad r3 = r28.zzi()
            r3.zzf()
            com.google.android.gms.measurement.internal.zzad r3 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzf r11 = r3.zzb(r15)     // Catch:{ all -> 0x05b2 }
            if (r11 != 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzez r0 = r28.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()     // Catch:{ all -> 0x05b2 }
            java.lang.String r2 = "Log and bundle not available. package_name"
            r0.zza(r2, r15)     // Catch:{ all -> 0x05b2 }
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()
            r2.zzh()
            return r0
        L_0x0084:
            boolean r3 = r11.zzr()     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzez r0 = r28.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()     // Catch:{ all -> 0x05b2 }
            java.lang.String r2 = "Log and bundle disabled. package_name"
            r0.zza(r2, r15)     // Catch:{ all -> 0x05b2 }
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()
            r2.zzh()
            return r0
        L_0x00a1:
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r3 = com.google.android.gms.internal.measurement.zzcc.zzg.zzbf()     // Catch:{ all -> 0x05b2 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r3 = r3.zza((int) r5)     // Catch:{ all -> 0x05b2 }
            java.lang.String r5 = "android"
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r12 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = r11.zzc()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x00c1
            java.lang.String r3 = r11.zzc()     // Catch:{ all -> 0x05b2 }
            r12.zzf((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
        L_0x00c1:
            java.lang.String r3 = r11.zzn()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x00d2
            java.lang.String r3 = r11.zzn()     // Catch:{ all -> 0x05b2 }
            r12.zze((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
        L_0x00d2:
            java.lang.String r3 = r11.zzl()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x00e3
            java.lang.String r3 = r11.zzl()     // Catch:{ all -> 0x05b2 }
            r12.zzg((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
        L_0x00e3:
            long r5 = r11.zzm()     // Catch:{ all -> 0x05b2 }
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x00f6
            long r5 = r11.zzm()     // Catch:{ all -> 0x05b2 }
            int r3 = (int) r5     // Catch:{ all -> 0x05b2 }
            r12.zzh((int) r3)     // Catch:{ all -> 0x05b2 }
        L_0x00f6:
            long r5 = r11.zzo()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r3 = r12.zzf((long) r5)     // Catch:{ all -> 0x05b2 }
            long r5 = r11.zzq()     // Catch:{ all -> 0x05b2 }
            r3.zzk((long) r5)     // Catch:{ all -> 0x05b2 }
            boolean r3 = com.google.android.gms.internal.measurement.zzoe.zzb()     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x0151
            com.google.android.gms.measurement.internal.zzy r3 = r28.zzt()     // Catch:{ all -> 0x05b2 }
            java.lang.String r5 = r11.zzc()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzbn     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.zze(r5, r6)     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x0151
            java.lang.String r3 = r11.zze()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x012d
            java.lang.String r3 = r11.zze()     // Catch:{ all -> 0x05b2 }
        L_0x0129:
            r12.zzk((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
            goto L_0x016f
        L_0x012d:
            java.lang.String r3 = r11.zzg()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x013f
            java.lang.String r3 = r11.zzg()     // Catch:{ all -> 0x05b2 }
            r12.zzp(r3)     // Catch:{ all -> 0x05b2 }
            goto L_0x016f
        L_0x013f:
            java.lang.String r3 = r11.zzf()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x016f
            java.lang.String r3 = r11.zzf()     // Catch:{ all -> 0x05b2 }
        L_0x014d:
            r12.zzo(r3)     // Catch:{ all -> 0x05b2 }
            goto L_0x016f
        L_0x0151:
            java.lang.String r3 = r11.zze()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x0160
            java.lang.String r3 = r11.zze()     // Catch:{ all -> 0x05b2 }
            goto L_0x0129
        L_0x0160:
            java.lang.String r3 = r11.zzf()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x016f
            java.lang.String r3 = r11.zzf()     // Catch:{ all -> 0x05b2 }
            goto L_0x014d
        L_0x016f:
            long r5 = r11.zzp()     // Catch:{ all -> 0x05b2 }
            r12.zzh((long) r5)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzy     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.zzab()     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x0198
            com.google.android.gms.measurement.internal.zzy r3 = r28.zzt()     // Catch:{ all -> 0x05b2 }
            java.lang.String r5 = r12.zzj()     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.zzg(r5)     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x0198
            r12.zzj()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x0198
            r12.zzn(r14)     // Catch:{ all -> 0x05b2 }
        L_0x0198:
            com.google.android.gms.measurement.internal.zzfl r3 = r28.zzs()     // Catch:{ all -> 0x05b2 }
            java.lang.String r5 = r11.zzc()     // Catch:{ all -> 0x05b2 }
            android.util.Pair r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x05b2 }
            boolean r5 = r11.zzaf()     // Catch:{ all -> 0x05b2 }
            if (r5 == 0) goto L_0x01f3
            if (r3 == 0) goto L_0x01f3
            java.lang.Object r5 = r3.first     // Catch:{ all -> 0x05b2 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x05b2 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x05b2 }
            if (r5 != 0) goto L_0x01f3
            java.lang.Object r5 = r3.first     // Catch:{ SecurityException -> 0x01d7 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SecurityException -> 0x01d7 }
            long r6 = r0.zzd     // Catch:{ SecurityException -> 0x01d7 }
            java.lang.String r6 = java.lang.Long.toString(r6)     // Catch:{ SecurityException -> 0x01d7 }
            java.lang.String r5 = zza((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ SecurityException -> 0x01d7 }
            r12.zzh((java.lang.String) r5)     // Catch:{ SecurityException -> 0x01d7 }
            java.lang.Object r5 = r3.second     // Catch:{ all -> 0x05b2 }
            if (r5 == 0) goto L_0x01f3
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x05b2 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x05b2 }
            r12.zza((boolean) r3)     // Catch:{ all -> 0x05b2 }
            goto L_0x01f3
        L_0x01d7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r28.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzw()     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = "Resettable device id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x05b2 }
            r2.zza(r3, r0)     // Catch:{ all -> 0x05b2 }
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()
            r2.zzh()
            return r0
        L_0x01f3:
            com.google.android.gms.measurement.internal.zzai r3 = r28.zzl()     // Catch:{ all -> 0x05b2 }
            r3.zzaa()     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r3 = r12.zzc((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzai r5 = r28.zzl()     // Catch:{ all -> 0x05b2 }
            r5.zzaa()     // Catch:{ all -> 0x05b2 }
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r3 = r3.zzb((java.lang.String) r5)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzai r5 = r28.zzl()     // Catch:{ all -> 0x05b2 }
            long r5 = r5.zzf()     // Catch:{ all -> 0x05b2 }
            int r6 = (int) r5     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r3 = r3.zzf((int) r6)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzai r5 = r28.zzl()     // Catch:{ all -> 0x05b2 }
            java.lang.String r5 = r5.zzg()     // Catch:{ all -> 0x05b2 }
            r3.zzd((java.lang.String) r5)     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = r11.zzd()     // Catch:{ SecurityException -> 0x0596 }
            long r5 = r0.zzd     // Catch:{ SecurityException -> 0x0596 }
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ SecurityException -> 0x0596 }
            java.lang.String r3 = zza((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ SecurityException -> 0x0596 }
            r12.zzi((java.lang.String) r3)     // Catch:{ SecurityException -> 0x0596 }
            java.lang.String r3 = r11.zzi()     // Catch:{ all -> 0x05b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05b2 }
            if (r3 != 0) goto L_0x0247
            java.lang.String r3 = r11.zzi()     // Catch:{ all -> 0x05b2 }
            r12.zzl((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
        L_0x0247:
            java.lang.String r3 = r11.zzc()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r5 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            java.util.List r5 = r5.zza((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
            java.util.Iterator r6 = r5.iterator()     // Catch:{ all -> 0x05b2 }
        L_0x0257:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x05b2 }
            if (r7 == 0) goto L_0x026e
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkt r7 = (com.google.android.gms.measurement.internal.zzkt) r7     // Catch:{ all -> 0x05b2 }
            java.lang.String r8 = "_lte"
            java.lang.String r9 = r7.zzc     // Catch:{ all -> 0x05b2 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x05b2 }
            if (r8 == 0) goto L_0x0257
            goto L_0x026f
        L_0x026e:
            r7 = r14
        L_0x026f:
            r23 = 0
            if (r7 == 0) goto L_0x0277
            java.lang.Object r6 = r7.zze     // Catch:{ all -> 0x05b2 }
            if (r6 != 0) goto L_0x029a
        L_0x0277:
            com.google.android.gms.measurement.internal.zzkt r6 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ all -> 0x05b2 }
            java.lang.String r18 = "auto"
            java.lang.String r19 = "_lte"
            com.google.android.gms.common.util.Clock r7 = r28.zzm()     // Catch:{ all -> 0x05b2 }
            long r20 = r7.currentTimeMillis()     // Catch:{ all -> 0x05b2 }
            java.lang.Long r22 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x05b2 }
            r16 = r6
            r17 = r3
            r16.<init>(r17, r18, r19, r20, r22)     // Catch:{ all -> 0x05b2 }
            r5.add(r6)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r3 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            r3.zza((com.google.android.gms.measurement.internal.zzkt) r6)     // Catch:{ all -> 0x05b2 }
        L_0x029a:
            com.google.android.gms.measurement.internal.zzks r3 = r28.zzg()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzez r6 = r3.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r6 = r6.zzx()     // Catch:{ all -> 0x05b2 }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r6.zza(r7)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzai r6 = r3.zzl()     // Catch:{ all -> 0x05b2 }
            boolean r6 = r6.zzj()     // Catch:{ all -> 0x05b2 }
            r7 = 1
            if (r6 == 0) goto L_0x0314
            java.lang.String r6 = r11.zzc()     // Catch:{ all -> 0x05b2 }
            boolean r9 = r11.zzaf()     // Catch:{ all -> 0x05b2 }
            if (r9 == 0) goto L_0x0314
            com.google.android.gms.measurement.internal.zzfx r9 = r3.zzj()     // Catch:{ all -> 0x05b2 }
            boolean r9 = r9.zze(r6)     // Catch:{ all -> 0x05b2 }
            if (r9 == 0) goto L_0x0314
            com.google.android.gms.measurement.internal.zzez r9 = r3.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzw()     // Catch:{ all -> 0x05b2 }
            java.lang.String r10 = "Turning off ad personalization due to account type"
            r9.zza(r10)     // Catch:{ all -> 0x05b2 }
            java.util.Iterator r9 = r5.iterator()     // Catch:{ all -> 0x05b2 }
        L_0x02dc:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x05b2 }
            if (r10 == 0) goto L_0x02f8
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkt r10 = (com.google.android.gms.measurement.internal.zzkt) r10     // Catch:{ all -> 0x05b2 }
            java.lang.String r14 = "_npa"
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x05b2 }
            boolean r10 = r14.equals(r10)     // Catch:{ all -> 0x05b2 }
            if (r10 == 0) goto L_0x02f6
            r9.remove()     // Catch:{ all -> 0x05b2 }
            goto L_0x02f8
        L_0x02f6:
            r14 = 0
            goto L_0x02dc
        L_0x02f8:
            com.google.android.gms.measurement.internal.zzkt r9 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ all -> 0x05b2 }
            java.lang.String r18 = "auto"
            java.lang.String r19 = "_npa"
            com.google.android.gms.common.util.Clock r3 = r3.zzm()     // Catch:{ all -> 0x05b2 }
            long r20 = r3.currentTimeMillis()     // Catch:{ all -> 0x05b2 }
            java.lang.Long r22 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x05b2 }
            r16 = r9
            r17 = r6
            r16.<init>(r17, r18, r19, r20, r22)     // Catch:{ all -> 0x05b2 }
            r5.add(r9)     // Catch:{ all -> 0x05b2 }
        L_0x0314:
            int r3 = r5.size()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzk[] r3 = new com.google.android.gms.internal.measurement.zzcc.zzk[r3]     // Catch:{ all -> 0x05b2 }
        L_0x031a:
            int r6 = r5.size()     // Catch:{ all -> 0x05b2 }
            if (r4 >= r6) goto L_0x0358
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r6 = com.google.android.gms.internal.measurement.zzcc.zzk.zzj()     // Catch:{ all -> 0x05b2 }
            java.lang.Object r9 = r5.get(r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkt r9 = (com.google.android.gms.measurement.internal.zzkt) r9     // Catch:{ all -> 0x05b2 }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r6 = r6.zza((java.lang.String) r9)     // Catch:{ all -> 0x05b2 }
            java.lang.Object r9 = r5.get(r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkt r9 = (com.google.android.gms.measurement.internal.zzkt) r9     // Catch:{ all -> 0x05b2 }
            long r9 = r9.zzd     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r6 = r6.zza((long) r9)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzks r9 = r28.zzg()     // Catch:{ all -> 0x05b2 }
            java.lang.Object r10 = r5.get(r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkt r10 = (com.google.android.gms.measurement.internal.zzkt) r10     // Catch:{ all -> 0x05b2 }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x05b2 }
            r9.zza((com.google.android.gms.internal.measurement.zzcc.zzk.zza) r6, (java.lang.Object) r10)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzjj r6 = r6.zzv()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzib r6 = (com.google.android.gms.internal.measurement.zzib) r6     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzk r6 = (com.google.android.gms.internal.measurement.zzcc.zzk) r6     // Catch:{ all -> 0x05b2 }
            r3[r4] = r6     // Catch:{ all -> 0x05b2 }
            int r4 = r4 + 1
            goto L_0x031a
        L_0x0358:
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ all -> 0x05b2 }
            r12.zzb((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcc.zzk>) r3)     // Catch:{ all -> 0x05b2 }
            boolean r3 = com.google.android.gms.internal.measurement.zzof.zzb()     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x03a4
            com.google.android.gms.measurement.internal.zzy r3 = r28.zzt()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzcn     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r4)     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x03a4
            com.google.android.gms.measurement.internal.zzy r3 = r28.zzt()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzco     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r4)     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x03a4
            com.google.android.gms.measurement.internal.zzfd r3 = com.google.android.gms.measurement.internal.zzfd.zza(r29)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkw r4 = r28.zzp()     // Catch:{ all -> 0x05b2 }
            android.os.Bundle r5 = r3.zzb     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r6 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            android.os.Bundle r6 = r6.zzi(r15)     // Catch:{ all -> 0x05b2 }
            r4.zza((android.os.Bundle) r5, (android.os.Bundle) r6)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkw r4 = r28.zzp()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzy r5 = r28.zzt()     // Catch:{ all -> 0x05b2 }
            int r5 = r5.zza((java.lang.String) r15)     // Catch:{ all -> 0x05b2 }
            r4.zza((com.google.android.gms.measurement.internal.zzfd) r3, (int) r5)     // Catch:{ all -> 0x05b2 }
            android.os.Bundle r3 = r3.zzb     // Catch:{ all -> 0x05b2 }
            goto L_0x03aa
        L_0x03a4:
            com.google.android.gms.measurement.internal.zzan r3 = r0.zzb     // Catch:{ all -> 0x05b2 }
            android.os.Bundle r3 = r3.zzb()     // Catch:{ all -> 0x05b2 }
        L_0x03aa:
            r14 = r3
            java.lang.String r3 = "_c"
            r14.putLong(r3, r7)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzez r3 = r28.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzw()     // Catch:{ all -> 0x05b2 }
            java.lang.String r4 = "Marking in-app purchase as real-time"
            r3.zza(r4)     // Catch:{ all -> 0x05b2 }
            r14.putLong(r2, r7)     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = "_o"
            java.lang.String r4 = r0.zzc     // Catch:{ all -> 0x05b2 }
            r14.putString(r3, r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkw r3 = r28.zzp()     // Catch:{ all -> 0x05b2 }
            java.lang.String r4 = r12.zzj()     // Catch:{ all -> 0x05b2 }
            boolean r3 = r3.zzf(r4)     // Catch:{ all -> 0x05b2 }
            if (r3 == 0) goto L_0x03ed
            com.google.android.gms.measurement.internal.zzkw r3 = r28.zzp()     // Catch:{ all -> 0x05b2 }
            java.lang.String r4 = "_dbg"
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x05b2 }
            r3.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzkw r3 = r28.zzp()     // Catch:{ all -> 0x05b2 }
            java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x05b2 }
            r3.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x05b2 }
        L_0x03ed:
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = r0.zza     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzak r2 = r2.zza((java.lang.String) r15, (java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
            if (r2 != 0) goto L_0x042d
            com.google.android.gms.measurement.internal.zzak r17 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x05b2 }
            java.lang.String r4 = r0.zza     // Catch:{ all -> 0x05b2 }
            r5 = 0
            r7 = 0
            long r9 = r0.zzd     // Catch:{ all -> 0x05b2 }
            r18 = 0
            r16 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r2 = r17
            r3 = r30
            r25 = r11
            r26 = r12
            r11 = r18
            r27 = r13
            r13 = r16
            r18 = r14
            r19 = 0
            r14 = r20
            r15 = r21
            r16 = r22
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r14, r15, r16)     // Catch:{ all -> 0x05b2 }
            r12 = r17
            r9 = r23
            goto L_0x0442
        L_0x042d:
            r25 = r11
            r26 = r12
            r27 = r13
            r18 = r14
            r19 = 0
            long r3 = r2.zzf     // Catch:{ all -> 0x05b2 }
            long r5 = r0.zzd     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzak r17 = r2.zza(r5)     // Catch:{ all -> 0x05b2 }
            r9 = r3
            r12 = r17
        L_0x0442:
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            r2.zza((com.google.android.gms.measurement.internal.zzak) r12)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzal r13 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzy     // Catch:{ all -> 0x05b2 }
            java.lang.String r4 = r0.zzc     // Catch:{ all -> 0x05b2 }
            java.lang.String r6 = r0.zza     // Catch:{ all -> 0x05b2 }
            long r7 = r0.zzd     // Catch:{ all -> 0x05b2 }
            r2 = r13
            r5 = r30
            r11 = r18
            r2.<init>((com.google.android.gms.measurement.internal.zzgd) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (long) r9, (android.os.Bundle) r11)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ all -> 0x05b2 }
            long r3 = r13.zzc     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = r2.zza((long) r3)     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = r13.zzb     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = r2.zza((java.lang.String) r3)     // Catch:{ all -> 0x05b2 }
            long r3 = r13.zzd     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = r2.zzb((long) r3)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzan r3 = r13.zze     // Catch:{ all -> 0x05b2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x05b2 }
        L_0x0477:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x05b2 }
            if (r4 == 0) goto L_0x049c
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x05b2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = com.google.android.gms.internal.measurement.zzcc.zze.zzm()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = r5.zza((java.lang.String) r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzan r6 = r13.zze     // Catch:{ all -> 0x05b2 }
            java.lang.Object r4 = r6.zza((java.lang.String) r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzks r6 = r28.zzg()     // Catch:{ all -> 0x05b2 }
            r6.zza((com.google.android.gms.internal.measurement.zzcc.zze.zza) r5, (java.lang.Object) r4)     // Catch:{ all -> 0x05b2 }
            r2.zza((com.google.android.gms.internal.measurement.zzcc.zze.zza) r5)     // Catch:{ all -> 0x05b2 }
            goto L_0x0477
        L_0x049c:
            r3 = r26
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r4 = r3.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzh$zza r5 = com.google.android.gms.internal.measurement.zzcc.zzh.zza()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzd$zza r6 = com.google.android.gms.internal.measurement.zzcc.zzd.zza()     // Catch:{ all -> 0x05b2 }
            long r7 = r12.zzc     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzd$zza r6 = r6.zza((long) r7)     // Catch:{ all -> 0x05b2 }
            java.lang.String r0 = r0.zza     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzd$zza r0 = r6.zza((java.lang.String) r0)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzh$zza r0 = r5.zza(r0)     // Catch:{ all -> 0x05b2 }
            r4.zza((com.google.android.gms.internal.measurement.zzcc.zzh.zza) r0)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzo r5 = r28.mo24432e_()     // Catch:{ all -> 0x05b2 }
            java.lang.String r6 = r25.zzc()     // Catch:{ all -> 0x05b2 }
            java.util.List r7 = java.util.Collections.emptyList()     // Catch:{ all -> 0x05b2 }
            java.util.List r8 = r3.zzd()     // Catch:{ all -> 0x05b2 }
            long r9 = r2.zzf()     // Catch:{ all -> 0x05b2 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x05b2 }
            long r10 = r2.zzf()     // Catch:{ all -> 0x05b2 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x05b2 }
            java.util.List r0 = r5.zza(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x05b2 }
            r3.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcc.zza>) r0)     // Catch:{ all -> 0x05b2 }
            boolean r0 = r2.zze()     // Catch:{ all -> 0x05b2 }
            if (r0 == 0) goto L_0x04f9
            long r4 = r2.zzf()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r0 = r3.zzb((long) r4)     // Catch:{ all -> 0x05b2 }
            long r4 = r2.zzf()     // Catch:{ all -> 0x05b2 }
            r0.zzc((long) r4)     // Catch:{ all -> 0x05b2 }
        L_0x04f9:
            long r4 = r25.zzk()     // Catch:{ all -> 0x05b2 }
            int r0 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x0504
            r3.zze((long) r4)     // Catch:{ all -> 0x05b2 }
        L_0x0504:
            long r6 = r25.zzj()     // Catch:{ all -> 0x05b2 }
            int r0 = (r6 > r23 ? 1 : (r6 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x0510
            r3.zzd((long) r6)     // Catch:{ all -> 0x05b2 }
            goto L_0x0517
        L_0x0510:
            int r0 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x0517
            r3.zzd((long) r4)     // Catch:{ all -> 0x05b2 }
        L_0x0517:
            r25.zzv()     // Catch:{ all -> 0x05b2 }
            long r4 = r25.zzs()     // Catch:{ all -> 0x05b2 }
            int r0 = (int) r4     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r0 = r3.zzg((int) r0)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzy r2 = r28.zzt()     // Catch:{ all -> 0x05b2 }
            long r4 = r2.zzf()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r0 = r0.zzg((long) r4)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.common.util.Clock r2 = r28.zzm()     // Catch:{ all -> 0x05b2 }
            long r4 = r2.currentTimeMillis()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r0 = r0.zza((long) r4)     // Catch:{ all -> 0x05b2 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x05b2 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x05b2 }
            r0.zzb((boolean) r2)     // Catch:{ all -> 0x05b2 }
            r0 = r27
            r0.zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r3)     // Catch:{ all -> 0x05b2 }
            long r4 = r3.zzf()     // Catch:{ all -> 0x05b2 }
            r2 = r25
            r2.zza((long) r4)     // Catch:{ all -> 0x05b2 }
            long r3 = r3.zzg()     // Catch:{ all -> 0x05b2 }
            r2.zzb((long) r3)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r3 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            r3.zza((com.google.android.gms.measurement.internal.zzf) r2)     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()     // Catch:{ all -> 0x05b2 }
            r2.mo24208b_()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()
            r2.zzh()
            com.google.android.gms.measurement.internal.zzks r2 = r28.zzg()     // Catch:{ IOException -> 0x0583 }
            com.google.android.gms.internal.measurement.zzjj r0 = r0.zzv()     // Catch:{ IOException -> 0x0583 }
            com.google.android.gms.internal.measurement.zzib r0 = (com.google.android.gms.internal.measurement.zzib) r0     // Catch:{ IOException -> 0x0583 }
            com.google.android.gms.internal.measurement.zzcc$zzf r0 = (com.google.android.gms.internal.measurement.zzcc.zzf) r0     // Catch:{ IOException -> 0x0583 }
            byte[] r0 = r0.zzbi()     // Catch:{ IOException -> 0x0583 }
            byte[] r0 = r2.zzc(r0)     // Catch:{ IOException -> 0x0583 }
            return r0
        L_0x0583:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r28.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r30)
            java.lang.String r4 = "Data loss. Failed to bundle and serialize. appId"
            r2.zza(r4, r3, r0)
            return r19
        L_0x0596:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r28.zzr()     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzw()     // Catch:{ all -> 0x05b2 }
            java.lang.String r3 = "app instance id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x05b2 }
            r2.zza(r3, r0)     // Catch:{ all -> 0x05b2 }
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x05b2 }
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()
            r2.zzh()
            return r0
        L_0x05b2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzad r2 = r28.zzi()
            r2.zzh()
            goto L_0x05bc
        L_0x05bb:
            throw r0
        L_0x05bc:
            goto L_0x05bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzii.zza(com.google.android.gms.measurement.internal.zzao, java.lang.String):byte[]");
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }
}
