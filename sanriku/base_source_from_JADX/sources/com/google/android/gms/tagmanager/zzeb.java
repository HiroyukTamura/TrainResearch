package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
final class zzeb implements zzcb {
    /* access modifiers changed from: private */
    public static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private final zzed zzaie;
    private volatile zzbe zzaif;
    private final zzcc zzaig;
    /* access modifiers changed from: private */
    public final String zzaih;
    private long zzaii;
    private final int zzaij;
    /* access modifiers changed from: private */
    public final Context zzrm;
    /* access modifiers changed from: private */
    public Clock zzsd;

    zzeb(zzcc zzcc, Context context) {
        this(zzcc, context, "gtm_urls.db", CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    @VisibleForTesting
    private zzeb(zzcc zzcc, Context context, String str, int i) {
        this.zzrm = context.getApplicationContext();
        this.zzaih = str;
        this.zzaig = zzcc;
        this.zzsd = DefaultClock.getInstance();
        this.zzaie = new zzed(this, this.zzrm, this.zzaih);
        this.zzaif = new zzfu(this.zzrm, new zzec(this));
        this.zzaii = 0;
        this.zzaij = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
    }

    private final void zza(String[] strArr) {
        SQLiteDatabase zzau;
        if (strArr != null && strArr.length != 0 && (zzau = zzau("Error opening database for deleteHits.")) != null) {
            boolean z = true;
            try {
                zzau.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                zzcc zzcc = this.zzaig;
                if (zziv() != 0) {
                    z = false;
                }
                zzcc.zze(z);
            } catch (SQLiteException unused) {
                zzdi.zzac("Error deleting hits");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0138, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0139, code lost:
        r14 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fb A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010f A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0138 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0155 A[Catch:{ all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015a A[Catch:{ all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.google.android.gms.tagmanager.zzbw> zzaa(int r19) {
        /*
            r18 = this;
            java.lang.String r0 = "%s ASC"
            java.lang.String r1 = "hit_id"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "Error opening database for peekHits"
            r4 = r18
            android.database.sqlite.SQLiteDatabase r3 = r4.zzau(r3)
            if (r3 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r6 = "gtm_hits"
            java.lang.String r5 = "hit_time"
            java.lang.String r7 = "hit_first_send_time"
            java.lang.String[] r7 = new java.lang.String[]{r1, r5, r7}     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r15 = 1
            java.lang.Object[] r5 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r13 = 0
            r5[r13] = r1     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            java.lang.String r12 = java.lang.String.format(r0, r5)     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r16 = 40
            java.lang.String r17 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r5 = r3
            r14 = 0
            r13 = r17
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x013c, all -> 0x0138 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x013c, all -> 0x0138 }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0135, all -> 0x0138 }
            if (r2 == 0) goto L_0x006b
        L_0x0045:
            com.google.android.gms.tagmanager.zzbw r2 = new com.google.android.gms.tagmanager.zzbw     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            long r6 = r13.getLong(r14)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            long r8 = r13.getLong(r15)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r5 = 2
            long r10 = r13.getLong(r5)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r5 = r2
            r5.<init>(r6, r8, r10)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r12.add(r2)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            boolean r2 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            if (r2 != 0) goto L_0x0045
            goto L_0x006b
        L_0x0062:
            r0 = move-exception
            r14 = r13
            goto L_0x0169
        L_0x0066:
            r0 = move-exception
            r2 = r12
            r14 = r13
            goto L_0x0145
        L_0x006b:
            r13.close()
            java.lang.String r6 = "gtm_hits"
            java.lang.String r2 = "hit_url"
            java.lang.String[] r7 = new java.lang.String[]{r1, r2}     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.Object[] r2 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            r2[r14] = r1     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r1 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            r5 = r3
            r2 = r12
            r12 = r0
            r3 = r13
            r13 = r1
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x00dd, all -> 0x00da }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x00d8 }
            if (r0 == 0) goto L_0x00d4
            r0 = 0
        L_0x0096:
            r1 = r13
            android.database.sqlite.SQLiteCursor r1 = (android.database.sqlite.SQLiteCursor) r1     // Catch:{ SQLiteException -> 0x00d8 }
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x00d8 }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x00d8 }
            if (r1 <= 0) goto L_0x00b1
            java.lang.Object r1 = r2.get(r0)     // Catch:{ SQLiteException -> 0x00d8 }
            com.google.android.gms.tagmanager.zzbw r1 = (com.google.android.gms.tagmanager.zzbw) r1     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.String r3 = r13.getString(r15)     // Catch:{ SQLiteException -> 0x00d8 }
            r1.zzbc(r3)     // Catch:{ SQLiteException -> 0x00d8 }
            goto L_0x00cc
        L_0x00b1:
            java.lang.String r1 = "HitString for hitId %d too large.  Hit will be deleted."
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.Object r5 = r2.get(r0)     // Catch:{ SQLiteException -> 0x00d8 }
            com.google.android.gms.tagmanager.zzbw r5 = (com.google.android.gms.tagmanager.zzbw) r5     // Catch:{ SQLiteException -> 0x00d8 }
            long r5 = r5.zzih()     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00d8 }
            r3[r14] = r5     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ SQLiteException -> 0x00d8 }
            com.google.android.gms.tagmanager.zzdi.zzac(r1)     // Catch:{ SQLiteException -> 0x00d8 }
        L_0x00cc:
            int r0 = r0 + 1
            boolean r1 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x00d8 }
            if (r1 != 0) goto L_0x0096
        L_0x00d4:
            r13.close()
            return r2
        L_0x00d8:
            r0 = move-exception
            goto L_0x00e6
        L_0x00da:
            r0 = move-exception
            r13 = r3
            goto L_0x012f
        L_0x00dd:
            r0 = move-exception
            r13 = r3
            goto L_0x00e6
        L_0x00e0:
            r0 = move-exception
            r3 = r13
            goto L_0x012f
        L_0x00e3:
            r0 = move-exception
            r2 = r12
            r3 = r13
        L_0x00e6:
            java.lang.String r1 = "Error in peekHits fetching hit url: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x012e }
            int r3 = r0.length()     // Catch:{ all -> 0x012e }
            if (r3 == 0) goto L_0x00fb
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x012e }
            goto L_0x0100
        L_0x00fb:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x012e }
            r0.<init>(r1)     // Catch:{ all -> 0x012e }
        L_0x0100:
            com.google.android.gms.tagmanager.zzdi.zzac(r0)     // Catch:{ all -> 0x012e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x012e }
            r0.<init>()     // Catch:{ all -> 0x012e }
            int r1 = r2.size()     // Catch:{ all -> 0x012e }
            r3 = 0
        L_0x010d:
            if (r14 >= r1) goto L_0x0128
            java.lang.Object r5 = r2.get(r14)     // Catch:{ all -> 0x012e }
            int r14 = r14 + 1
            com.google.android.gms.tagmanager.zzbw r5 = (com.google.android.gms.tagmanager.zzbw) r5     // Catch:{ all -> 0x012e }
            java.lang.String r6 = r5.zzij()     // Catch:{ all -> 0x012e }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x012e }
            if (r6 == 0) goto L_0x0124
            if (r3 != 0) goto L_0x0128
            r3 = 1
        L_0x0124:
            r0.add(r5)     // Catch:{ all -> 0x012e }
            goto L_0x010d
        L_0x0128:
            if (r13 == 0) goto L_0x012d
            r13.close()
        L_0x012d:
            return r0
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            if (r13 == 0) goto L_0x0134
            r13.close()
        L_0x0134:
            throw r0
        L_0x0135:
            r0 = move-exception
            r2 = r12
            goto L_0x013d
        L_0x0138:
            r0 = move-exception
            r3 = r13
            r14 = r3
            goto L_0x0169
        L_0x013c:
            r0 = move-exception
        L_0x013d:
            r3 = r13
            r14 = r3
            goto L_0x0145
        L_0x0140:
            r0 = move-exception
            r14 = 0
            goto L_0x0169
        L_0x0143:
            r0 = move-exception
            r14 = 0
        L_0x0145:
            java.lang.String r1 = "Error in peekHits fetching hitIds: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0168 }
            int r3 = r0.length()     // Catch:{ all -> 0x0168 }
            if (r3 == 0) goto L_0x015a
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0168 }
            goto L_0x015f
        L_0x015a:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0168 }
            r0.<init>(r1)     // Catch:{ all -> 0x0168 }
        L_0x015f:
            com.google.android.gms.tagmanager.zzdi.zzac(r0)     // Catch:{ all -> 0x0168 }
            if (r14 == 0) goto L_0x0167
            r14.close()
        L_0x0167:
            return r2
        L_0x0168:
            r0 = move-exception
        L_0x0169:
            if (r14 == 0) goto L_0x016e
            r14.close()
        L_0x016e:
            goto L_0x0170
        L_0x016f:
            throw r0
        L_0x0170:
            goto L_0x016f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzaa(int):java.util.List");
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzaie.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzb(long j, long j2) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        if (zzau != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzau.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException unused) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
                sb.append(j);
                zzdi.zzac(sb.toString());
                zze(j);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zze(long j) {
        zza(new String[]{String.valueOf(j)});
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r2 == 0) goto L_0x002a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zziv() {
        /*
            r4 = this;
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r4.zzau(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = 0
            java.lang.String r3 = "SELECT COUNT(*) from gtm_hits"
            android.database.Cursor r2 = r0.rawQuery(r3, r2)     // Catch:{ SQLiteException -> 0x0022 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001c
            long r0 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x0022 }
            int r1 = (int) r0
        L_0x001c:
            r2.close()
            goto L_0x002a
        L_0x0020:
            r0 = move-exception
            goto L_0x002b
        L_0x0022:
            java.lang.String r0 = "Error getting numStoredHits"
            com.google.android.gms.tagmanager.zzdi.zzac(r0)     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x002a
            goto L_0x001c
        L_0x002a:
            return r1
        L_0x002b:
            if (r2 == 0) goto L_0x0030
            r2.close()
        L_0x0030:
            goto L_0x0032
        L_0x0031:
            throw r0
        L_0x0032:
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zziv():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r9 == null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zziw() {
        /*
            r10 = this;
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r1 = r10.zzau(r0)
            r0 = 0
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            r9 = 0
            java.lang.String r2 = "gtm_hits"
            java.lang.String r3 = "hit_id"
            java.lang.String r4 = "hit_first_send_time"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0029 }
            java.lang.String r4 = "hit_first_send_time=0"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0029 }
            int r0 = r9.getCount()     // Catch:{ SQLiteException -> 0x0029 }
        L_0x0023:
            r9.close()
            goto L_0x0031
        L_0x0027:
            r0 = move-exception
            goto L_0x0032
        L_0x0029:
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.zzdi.zzac(r1)     // Catch:{ all -> 0x0027 }
            if (r9 == 0) goto L_0x0031
            goto L_0x0023
        L_0x0031:
            return r0
        L_0x0032:
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            goto L_0x0039
        L_0x0038:
            throw r0
        L_0x0039:
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zziw():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        if (r2 == null) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> zzz(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "hit_id"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r14 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.zzdi.zzac(r14)
            return r1
        L_0x000f:
            java.lang.String r2 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r3 = r13.zzau(r2)
            if (r3 != 0) goto L_0x0018
            return r1
        L_0x0018:
            r2 = 0
            java.lang.String r4 = "gtm_hits"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0051 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "%s ASC"
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ SQLiteException -> 0x0051 }
            r12 = 0
            r11[r12] = r0     // Catch:{ SQLiteException -> 0x0051 }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ SQLiteException -> 0x0051 }
            java.lang.String r11 = java.lang.Integer.toString(r14)     // Catch:{ SQLiteException -> 0x0051 }
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0051 }
            boolean r14 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0051 }
            if (r14 == 0) goto L_0x0071
        L_0x003d:
            long r3 = r2.getLong(r12)     // Catch:{ SQLiteException -> 0x0051 }
            java.lang.String r14 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0051 }
            r1.add(r14)     // Catch:{ SQLiteException -> 0x0051 }
            boolean r14 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0051 }
            if (r14 != 0) goto L_0x003d
            goto L_0x0071
        L_0x004f:
            r14 = move-exception
            goto L_0x0075
        L_0x0051:
            r14 = move-exception
            java.lang.String r0 = "Error in peekHits fetching hitIds: "
            java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x004f }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x004f }
            int r3 = r14.length()     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x0067
            java.lang.String r14 = r0.concat(r14)     // Catch:{ all -> 0x004f }
            goto L_0x006c
        L_0x0067:
            java.lang.String r14 = new java.lang.String     // Catch:{ all -> 0x004f }
            r14.<init>(r0)     // Catch:{ all -> 0x004f }
        L_0x006c:
            com.google.android.gms.tagmanager.zzdi.zzac(r14)     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0074
        L_0x0071:
            r2.close()
        L_0x0074:
            return r1
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.close()
        L_0x007a:
            goto L_0x007c
        L_0x007b:
            throw r14
        L_0x007c:
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzz(int):java.util.List");
    }

    public final void dispatch() {
        zzdi.zzab("GTM Dispatch running...");
        if (this.zzaif.zzhy()) {
            List<zzbw> zzaa = zzaa(40);
            if (zzaa.isEmpty()) {
                zzdi.zzab("...nothing to dispatch");
                this.zzaig.zze(true);
                return;
            }
            this.zzaif.zzd(zzaa);
            if (zziw() > 0) {
                zzfn.zzjq().dispatch();
            }
        }
    }

    public final void zzb(long j, String str) {
        long currentTimeMillis = this.zzsd.currentTimeMillis();
        if (currentTimeMillis > this.zzaii + 86400000) {
            this.zzaii = currentTimeMillis;
            SQLiteDatabase zzau = zzau("Error opening database for deleteStaleHits.");
            if (zzau != null) {
                zzau.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzsd.currentTimeMillis() - 2592000000L)});
                this.zzaig.zze(zziv() == 0);
            }
        }
        int zziv = (zziv() - this.zzaij) + 1;
        if (zziv > 0) {
            List<String> zzz = zzz(zziv);
            int size = zzz.size();
            StringBuilder sb = new StringBuilder(51);
            sb.append("Store full, deleting ");
            sb.append(size);
            sb.append(" hits to make room.");
            zzdi.zzab(sb.toString());
            zza((String[]) zzz.toArray(new String[0]));
        }
        SQLiteDatabase zzau2 = zzau("Error opening database for putHit");
        if (zzau2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", 0);
            try {
                zzau2.insert("gtm_hits", (String) null, contentValues);
                this.zzaig.zze(false);
            } catch (SQLiteException unused) {
                zzdi.zzac("Error storing hit");
            }
        }
    }
}
