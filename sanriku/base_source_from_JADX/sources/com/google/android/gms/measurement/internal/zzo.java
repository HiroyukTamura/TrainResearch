package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class zzo extends zzkl {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzq> zzd;
    private Long zze;
    private Long zzf;

    zzo(zzkk zzkk) {
        super(zzkk);
    }

    private final zzq zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzq zzq = new zzq(this, this.zzb, (zzr) null);
        this.zzd.put(Integer.valueOf(i), zzq);
        return zzq;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0643, code lost:
        if (r8.zza() == false) goto L_0x064e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0645, code lost:
        r8 = java.lang.Integer.valueOf(r8.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x064e, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x064f, code lost:
        r7.zza("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
        r8 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x02cf A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzcc.zza> zza(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.zzcc.zzc> r48, java.util.List<com.google.android.gms.internal.measurement.zzcc.zzk> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            r46 = this;
            r10 = r46
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r47)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r48)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r49)
            r0 = r47
            r10.zzb = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzc = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzd = r0
            r0 = r50
            r10.zze = r0
            r0 = r51
            r10.zzf = r0
            java.util.Iterator r0 = r48.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            r11 = 0
            r12 = 1
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1
            java.lang.String r1 = r1.zzc()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0029
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            boolean r0 = com.google.android.gms.internal.measurement.zzna.zzb()
            if (r0 == 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzy r0 = r46.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzbf
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x005c
            r13 = 1
            goto L_0x005d
        L_0x005c:
            r13 = 0
        L_0x005d:
            boolean r0 = com.google.android.gms.internal.measurement.zzna.zzb()
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzy r0 = r46.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzbe
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x0073
            r14 = 1
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.zzad r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            r2.zzak()
            r2.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.mo24209c_()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x00a3 }
            r7[r11] = r3     // Catch:{ SQLiteException -> 0x00a3 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x00b5
        L_0x00a3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zza(r4, r3, r0)
        L_0x00b5:
            java.util.Map r0 = java.util.Collections.emptyMap()
            if (r14 == 0) goto L_0x00c7
            if (r13 == 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzad r0 = r46.zzi()
            java.lang.String r2 = r10.zzb
            java.util.Map r0 = r0.zze(r2)
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzad r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            java.util.Map r15 = r2.zzg(r3)
            boolean r2 = com.google.android.gms.internal.measurement.zznm.zzb()
            if (r2 == 0) goto L_0x00e5
            com.google.android.gms.measurement.internal.zzy r2 = r46.zzt()
            java.lang.String r3 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzcs
            boolean r2 = r2.zzd(r3, r4)
            if (r2 != 0) goto L_0x00e7
        L_0x00e5:
            if (r15 == 0) goto L_0x036a
        L_0x00e7:
            boolean r2 = r15.isEmpty()
            if (r2 == 0) goto L_0x00ef
            goto L_0x036a
        L_0x00ef:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r15.keySet()
            r2.<init>(r3)
            if (r1 == 0) goto L_0x01d5
            java.lang.String r1 = r10.zzb
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r4 = r15.isEmpty()
            if (r4 != 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzad r4 = r46.zzi()
            java.util.Map r1 = r4.zzf(r1)
            java.util.Set r4 = r15.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x011d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d3
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r15.get(r6)
            com.google.android.gms.internal.measurement.zzcc$zzi r6 = (com.google.android.gms.internal.measurement.zzcc.zzi) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r1.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01c9
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x014b
            goto L_0x01c9
        L_0x014b:
            com.google.android.gms.measurement.internal.zzks r8 = r46.zzg()
            java.util.List r9 = r6.zzc()
            java.util.List r8 = r8.zza((java.util.List<java.lang.Long>) r9, (java.util.List<java.lang.Integer>) r7)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x011d
            com.google.android.gms.internal.measurement.zzib$zza r9 = r6.zzbl()
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r9 = (com.google.android.gms.internal.measurement.zzcc.zzi.zza) r9
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r9 = r9.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r8 = r9.zzb((java.lang.Iterable<? extends java.lang.Long>) r8)
            com.google.android.gms.measurement.internal.zzks r9 = r46.zzg()
            java.util.List r11 = r6.zza()
            java.util.List r9 = r9.zza((java.util.List<java.lang.Long>) r11, (java.util.List<java.lang.Integer>) r7)
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r11 = r8.zza()
            r11.zza((java.lang.Iterable<? extends java.lang.Long>) r9)
            r9 = 0
        L_0x017f:
            int r11 = r6.zzf()
            if (r9 >= r11) goto L_0x019d
            com.google.android.gms.internal.measurement.zzcc$zzb r11 = r6.zza((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x019a
            r8.zza((int) r9)
        L_0x019a:
            int r9 = r9 + 1
            goto L_0x017f
        L_0x019d:
            r9 = 0
        L_0x019e:
            int r11 = r6.zzh()
            if (r9 >= r11) goto L_0x01bc
            com.google.android.gms.internal.measurement.zzcc$zzj r11 = r6.zzb((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x01b9
            r8.zzb((int) r9)
        L_0x01b9:
            int r9 = r9 + 1
            goto L_0x019e
        L_0x01bc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzjj r6 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r6 = (com.google.android.gms.internal.measurement.zzib) r6
            com.google.android.gms.internal.measurement.zzcc$zzi r6 = (com.google.android.gms.internal.measurement.zzcc.zzi) r6
            goto L_0x01cd
        L_0x01c9:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        L_0x01cd:
            r3.put(r5, r6)
            r11 = 0
            goto L_0x011d
        L_0x01d3:
            r11 = r3
            goto L_0x01d6
        L_0x01d5:
            r11 = r15
        L_0x01d6:
            java.util.Iterator r16 = r2.iterator()
        L_0x01da:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x036a
            java.lang.Object r1 = r16.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r17 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzcc$zzi r1 = (com.google.android.gms.internal.measurement.zzcc.zzi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x0242
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x020c
            goto L_0x0242
        L_0x020c:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x0214:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0242
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcc$zzb r3 = (com.google.android.gms.internal.measurement.zzcc.zzb) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0214
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzc()
            if (r8 == 0) goto L_0x023d
            long r8 = r3.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x023e
        L_0x023d:
            r3 = 0
        L_0x023e:
            r7.put(r4, r3)
            goto L_0x0214
        L_0x0242:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x0289
            int r2 = r1.zzh()
            if (r2 != 0) goto L_0x0250
            goto L_0x0289
        L_0x0250:
            java.util.List r2 = r1.zzg()
            java.util.Iterator r2 = r2.iterator()
        L_0x0258:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0289
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcc$zzj r3 = (com.google.android.gms.internal.measurement.zzcc.zzj) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0258
            int r4 = r3.zzd()
            if (r4 <= 0) goto L_0x0258
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r9 = r3.zzd()
            int r9 = r9 - r12
            long r18 = r3.zza((int) r9)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r4, r3)
            goto L_0x0258
        L_0x0289:
            if (r1 == 0) goto L_0x02d3
            r2 = 0
        L_0x028c:
            int r3 = r1.zzb()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x02d3
            java.util.List r3 = r1.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzks.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02c5
            com.google.android.gms.measurement.internal.zzez r3 = r46.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzx()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            java.lang.String r12 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r12, r4, r9)
            r6.set(r2)
            java.util.List r3 = r1.zzc()
            boolean r3 = com.google.android.gms.measurement.internal.zzks.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02c5
            r5.set(r2)
            r3 = 1
            goto L_0x02c6
        L_0x02c5:
            r3 = 0
        L_0x02c6:
            if (r3 != 0) goto L_0x02cf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x02cf:
            int r2 = r2 + 1
            r12 = 1
            goto L_0x028c
        L_0x02d3:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r15.get(r1)
            r4 = r1
            com.google.android.gms.internal.measurement.zzcc$zzi r4 = (com.google.android.gms.internal.measurement.zzcc.zzi) r4
            if (r14 == 0) goto L_0x034e
            if (r13 == 0) goto L_0x034e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x034e
            java.lang.Long r2 = r10.zzf
            if (r2 == 0) goto L_0x034e
            java.lang.Long r2 = r10.zze
            if (r2 != 0) goto L_0x02f7
            goto L_0x034e
        L_0x02f7:
            java.util.Iterator r1 = r1.iterator()
        L_0x02fb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x034e
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbu$zzb r2 = (com.google.android.gms.internal.measurement.zzbu.zzb) r2
            int r3 = r2.zzb()
            java.lang.Long r9 = r10.zzf
            long r18 = r9.longValue()
            r20 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 / r20
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x0323
            java.lang.Long r2 = r10.zze
            long r18 = r2.longValue()
            long r18 = r18 / r20
        L_0x0323:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x0338
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r9 = java.lang.Long.valueOf(r18)
            r7.put(r2, r9)
        L_0x0338:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r8.containsKey(r2)
            if (r2 == 0) goto L_0x02fb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r2, r3)
            goto L_0x02fb
        L_0x034e:
            com.google.android.gms.measurement.internal.zzq r12 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r3 = r10.zzb
            r9 = 0
            r1 = r12
            r2 = r46
            r18 = r11
            r11 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzq> r1 = r10.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r1.put(r2, r12)
            r11 = r18
            r12 = 1
            goto L_0x01da
        L_0x036a:
            r11 = 0
            boolean r0 = r48.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 != 0) goto L_0x04fd
            com.google.android.gms.measurement.internal.zzt r0 = new com.google.android.gms.measurement.internal.zzt
            r0.<init>(r10, r11)
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r48.iterator()
        L_0x0381:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04fd
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.zzcc$zzc r4 = (com.google.android.gms.internal.measurement.zzcc.zzc) r4
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzcc$zzc r5 = r0.zza(r5, r4)
            if (r5 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzad r6 = r46.zzi()
            java.lang.String r13 = r10.zzb
            java.lang.String r7 = r5.zzc()
            java.lang.String r8 = r4.zzc()
            com.google.android.gms.measurement.internal.zzak r8 = r6.zza((java.lang.String) r13, (java.lang.String) r8)
            if (r8 != 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.zzez r8 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzo()
            java.lang.String r6 = r6.zza((java.lang.String) r7)
            java.lang.String r7 = "Event aggregate wasn't created during raw event logging. appId, event"
            r8.zza(r7, r9, r6)
            com.google.android.gms.measurement.internal.zzak r6 = new com.google.android.gms.measurement.internal.zzak
            r12 = r6
            java.lang.String r14 = r4.zzc()
            r15 = 1
            r17 = 1
            r19 = 1
            long r21 = r4.zze()
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)
            goto L_0x0416
        L_0x03e1:
            com.google.android.gms.measurement.internal.zzak r6 = new com.google.android.gms.measurement.internal.zzak
            r29 = r6
            java.lang.String r4 = r8.zza
            r30 = r4
            java.lang.String r4 = r8.zzb
            r31 = r4
            long r12 = r8.zzc
            r14 = 1
            long r32 = r12 + r14
            long r12 = r8.zzd
            long r34 = r12 + r14
            long r12 = r8.zze
            long r36 = r12 + r14
            long r12 = r8.zzf
            r38 = r12
            long r12 = r8.zzg
            r40 = r12
            java.lang.Long r4 = r8.zzh
            r42 = r4
            java.lang.Long r4 = r8.zzi
            r43 = r4
            java.lang.Long r4 = r8.zzj
            r44 = r4
            java.lang.Boolean r4 = r8.zzk
            r45 = r4
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)
        L_0x0416:
            com.google.android.gms.measurement.internal.zzad r4 = r46.zzi()
            r4.zza((com.google.android.gms.measurement.internal.zzak) r6)
            long r7 = r6.zzc
            java.lang.String r4 = r5.zzc()
            java.lang.Object r9 = r2.get(r4)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 != 0) goto L_0x0453
            com.google.android.gms.measurement.internal.zzad r9 = r46.zzi()
            java.lang.String r12 = r10.zzb
            java.util.Map r9 = r9.zzf(r12, r4)
            boolean r12 = com.google.android.gms.internal.measurement.zznm.zzb()
            if (r12 == 0) goto L_0x0449
            com.google.android.gms.measurement.internal.zzy r12 = r46.zzt()
            java.lang.String r13 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzaq.zzcs
            boolean r12 = r12.zzd(r13, r14)
            if (r12 != 0) goto L_0x0450
        L_0x0449:
            if (r9 != 0) goto L_0x0450
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
        L_0x0450:
            r2.put(r4, r9)
        L_0x0453:
            java.util.Set r4 = r9.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x045b:
            boolean r12 = r4.hasNext()
            if (r12 == 0) goto L_0x0381
            java.lang.Object r12 = r4.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r15 = r12.intValue()
            java.util.Set<java.lang.Integer> r12 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x0487
            com.google.android.gms.measurement.internal.zzez r12 = r46.zzr()
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzx()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            r12.zza(r1, r13)
            goto L_0x045b
        L_0x0487:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r15)
            java.lang.Object r12 = r9.get(r12)
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r20 = r12.iterator()
            r12 = 1
        L_0x0496:
            boolean r13 = r20.hasNext()
            if (r13 == 0) goto L_0x04ea
            java.lang.Object r12 = r20.next()
            com.google.android.gms.internal.measurement.zzbu$zzb r12 = (com.google.android.gms.internal.measurement.zzbu.zzb) r12
            com.google.android.gms.measurement.internal.zzs r14 = new com.google.android.gms.measurement.internal.zzs
            java.lang.String r13 = r10.zzb
            r14.<init>(r10, r13, r15, r12)
            java.lang.Long r13 = r10.zze
            java.lang.Long r11 = r10.zzf
            int r12 = r12.zzb()
            boolean r19 = r10.zza(r15, r12)
            r12 = r14
            r21 = r0
            r0 = r14
            r14 = r11
            r11 = r15
            r15 = r5
            r16 = r7
            r18 = r6
            boolean r12 = r12.zza(r13, r14, r15, r16, r18, r19)
            com.google.android.gms.measurement.internal.zzy r13 = r46.zzt()
            java.lang.String r14 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzaq.zzbc
            boolean r13 = r13.zzd(r14, r15)
            if (r13 == 0) goto L_0x04de
            if (r12 != 0) goto L_0x04de
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            r0.add(r13)
            goto L_0x04ed
        L_0x04de:
            com.google.android.gms.measurement.internal.zzq r13 = r10.zza(r11)
            r13.zza((com.google.android.gms.measurement.internal.zzv) r0)
            r15 = r11
            r0 = r21
            r11 = 0
            goto L_0x0496
        L_0x04ea:
            r21 = r0
            r11 = r15
        L_0x04ed:
            if (r12 != 0) goto L_0x04f8
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r0.add(r11)
        L_0x04f8:
            r0 = r21
            r11 = 0
            goto L_0x045b
        L_0x04fd:
            boolean r0 = r49.isEmpty()
            if (r0 != 0) goto L_0x0666
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r2 = r49.iterator()
        L_0x050c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0666
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcc$zzk r3 = (com.google.android.gms.internal.measurement.zzcc.zzk) r3
            java.lang.String r4 = r3.zzc()
            java.lang.Object r5 = r0.get(r4)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x054c
            com.google.android.gms.measurement.internal.zzad r5 = r46.zzi()
            java.lang.String r6 = r10.zzb
            java.util.Map r5 = r5.zzg(r6, r4)
            boolean r6 = com.google.android.gms.internal.measurement.zznm.zzb()
            if (r6 == 0) goto L_0x0542
            com.google.android.gms.measurement.internal.zzy r6 = r46.zzt()
            java.lang.String r7 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzcs
            boolean r6 = r6.zzd(r7, r8)
            if (r6 != 0) goto L_0x0549
        L_0x0542:
            if (r5 != 0) goto L_0x0549
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
        L_0x0549:
            r0.put(r4, r5)
        L_0x054c:
            java.util.Set r4 = r5.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0554:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x050c
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0580
            com.google.android.gms.measurement.internal.zzez r3 = r46.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzx()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.zza(r1, r4)
            goto L_0x050c
        L_0x0580:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r5.get(r7)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x058f:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0659
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzbu$zze r8 = (com.google.android.gms.internal.measurement.zzbu.zze) r8
            com.google.android.gms.measurement.internal.zzez r9 = r46.zzr()
            r11 = 2
            boolean r9 = r9.zza((int) r11)
            if (r9 == 0) goto L_0x05e8
            com.google.android.gms.measurement.internal.zzez r9 = r46.zzr()
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzx()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            boolean r12 = r8.zza()
            if (r12 == 0) goto L_0x05c1
            int r12 = r8.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x05c2
        L_0x05c1:
            r12 = 0
        L_0x05c2:
            com.google.android.gms.measurement.internal.zzex r13 = r46.zzo()
            java.lang.String r14 = r8.zzc()
            java.lang.String r13 = r13.zzc(r14)
            java.lang.String r14 = "Evaluating filter. audience, filter, property"
            r9.zza(r14, r11, r12, r13)
            com.google.android.gms.measurement.internal.zzez r9 = r46.zzr()
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzx()
            com.google.android.gms.measurement.internal.zzks r11 = r46.zzg()
            java.lang.String r11 = r11.zza((com.google.android.gms.internal.measurement.zzbu.zze) r8)
            java.lang.String r12 = "Filter definition"
            r9.zza(r12, r11)
        L_0x05e8:
            boolean r9 = r8.zza()
            if (r9 == 0) goto L_0x0631
            int r9 = r8.zzb()
            r11 = 256(0x100, float:3.59E-43)
            if (r9 <= r11) goto L_0x05f7
            goto L_0x0631
        L_0x05f7:
            com.google.android.gms.measurement.internal.zzu r9 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r11 = r10.zzb
            r9.<init>(r10, r11, r6, r8)
            java.lang.Long r11 = r10.zze
            java.lang.Long r12 = r10.zzf
            int r8 = r8.zzb()
            boolean r8 = r10.zza(r6, r8)
            boolean r8 = r9.zza(r11, r12, r3, r8)
            com.google.android.gms.measurement.internal.zzy r11 = r46.zzt()
            java.lang.String r12 = r10.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzbc
            boolean r11 = r11.zzd(r12, r13)
            if (r11 == 0) goto L_0x0628
            if (r8 != 0) goto L_0x0628
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            goto L_0x0659
        L_0x0628:
            com.google.android.gms.measurement.internal.zzq r11 = r10.zza(r6)
            r11.zza((com.google.android.gms.measurement.internal.zzv) r9)
            goto L_0x058f
        L_0x0631:
            com.google.android.gms.measurement.internal.zzez r7 = r46.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()
            java.lang.String r9 = r10.zzb
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)
            boolean r11 = r8.zza()
            if (r11 == 0) goto L_0x064e
            int r8 = r8.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x064f
        L_0x064e:
            r8 = 0
        L_0x064f:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r11 = "Invalid property filter ID. appId, id"
            r7.zza(r11, r9, r8)
            r8 = 0
        L_0x0659:
            if (r8 != 0) goto L_0x0554
            java.util.Set<java.lang.Integer> r7 = r10.zzc
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
            goto L_0x0554
        L_0x0666:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzq> r0 = r10.zzd
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.zzc
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x067a:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x070a
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzq> r3 = r10.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzq r3 = (com.google.android.gms.measurement.internal.zzq) r3
            com.google.android.gms.internal.measurement.zzcc$zza r3 = r3.zza((int) r0)
            r1.add(r3)
            com.google.android.gms.measurement.internal.zzad r4 = r46.zzi()
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzcc$zzi r3 = r3.zzc()
            r4.zzak()
            r4.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbi()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r7 = "audience_id"
            r6.put(r7, r0)
            java.lang.String r0 = "current_results"
            r6.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.mo24209c_()     // Catch:{ SQLiteException -> 0x06f5 }
            java.lang.String r3 = "audience_filter_values"
            r7 = 5
            r8 = 0
            long r6 = r0.insertWithOnConflict(r3, r8, r6, r7)     // Catch:{ SQLiteException -> 0x06f3 }
            r11 = -1
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x067a
            com.google.android.gms.measurement.internal.zzez r0 = r4.zzr()     // Catch:{ SQLiteException -> 0x06f3 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x06f3 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ SQLiteException -> 0x06f3 }
            r0.zza(r3, r6)     // Catch:{ SQLiteException -> 0x06f3 }
            goto L_0x067a
        L_0x06f3:
            r0 = move-exception
            goto L_0x06f7
        L_0x06f5:
            r0 = move-exception
            r8 = 0
        L_0x06f7:
            com.google.android.gms.measurement.internal.zzez r3 = r4.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)
            java.lang.String r5 = "Error storing filter results. appId"
            r3.zza(r5, r4, r0)
            goto L_0x067a
        L_0x070a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzo.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }
}
