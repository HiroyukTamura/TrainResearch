package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzev extends zzg {
    private final zzeu zza = new zzeu(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzev(zzgd zzgd) {
        super(zzgd);
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, (String) null, (String) null, "rowid desc", "1");
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                query.close();
                return j;
            }
            query.close();
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2 A[SYNTHETIC, Splitter:B:47:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0116 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0116 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0116 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzb()
            r16.zzd()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0026:
            if (r5 >= r4) goto L_0x0128
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzae()     // Catch:{ SQLiteFullException -> 0x00fc, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00be, all -> 0x00bb }
            if (r9 != 0) goto L_0x0038
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00eb, SQLiteException -> 0x00b5 }
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r2
        L_0x0038:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00eb, SQLiteException -> 0x00b5 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00eb, SQLiteException -> 0x00b5 }
            if (r12 == 0) goto L_0x0059
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r0 == 0) goto L_0x0059
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            r0 = move-exception
            goto L_0x00e8
        L_0x0053:
            r0 = move-exception
            goto L_0x00b7
        L_0x0055:
            r0 = move-exception
            r7 = r12
            goto L_0x00fe
        L_0x0059:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzez r15 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            com.google.android.gms.measurement.internal.zzfb r15 = r15.zzf()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            r10[r2] = r11     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            int r4 = r9.delete(r0, r4, r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            long r10 = (long) r4     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzez r4 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            r4.zza(r15, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
        L_0x00a0:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r12 == 0) goto L_0x00ae
            r12.close()
        L_0x00ae:
            r9.close()
            r2 = 1
            return r2
        L_0x00b3:
            r7 = r12
            goto L_0x00eb
        L_0x00b5:
            r0 = move-exception
            r12 = r7
        L_0x00b7:
            r7 = r9
            goto L_0x00c0
        L_0x00b9:
            r0 = move-exception
            goto L_0x00fe
        L_0x00bb:
            r0 = move-exception
            r9 = r7
            goto L_0x011d
        L_0x00be:
            r0 = move-exception
            r12 = r7
        L_0x00c0:
            if (r7 == 0) goto L_0x00cb
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00cb
            r7.endTransaction()     // Catch:{ all -> 0x00e6 }
        L_0x00cb:
            com.google.android.gms.measurement.internal.zzez r2 = r16.zzr()     // Catch:{ all -> 0x00e6 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x00e6 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e6 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00e6 }
            if (r12 == 0) goto L_0x00e0
            r12.close()
        L_0x00e0:
            if (r7 == 0) goto L_0x0116
            r7.close()
            goto L_0x0116
        L_0x00e6:
            r0 = move-exception
            r9 = r7
        L_0x00e8:
            r7 = r12
            goto L_0x011d
        L_0x00ea:
            r9 = r7
        L_0x00eb:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x011c }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f6
            r7.close()
        L_0x00f6:
            if (r9 == 0) goto L_0x0116
        L_0x00f8:
            r9.close()
            goto L_0x0116
        L_0x00fc:
            r0 = move-exception
            r9 = r7
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzez r2 = r16.zzr()     // Catch:{ all -> 0x011c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x011c }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x011c }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x011c }
            if (r7 == 0) goto L_0x0113
            r7.close()
        L_0x0113:
            if (r9 == 0) goto L_0x0116
            goto L_0x00f8
        L_0x0116:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0026
        L_0x011c:
            r0 = move-exception
        L_0x011d:
            if (r7 == 0) goto L_0x0122
            r7.close()
        L_0x0122:
            if (r9 == 0) goto L_0x0127
            r9.close()
        L_0x0127:
            throw r0
        L_0x0128:
            com.google.android.gms.measurement.internal.zzez r0 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzev.zza(int, byte[]):boolean");
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    @VisibleForTesting
    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:60|61|62|63) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:75|76|77|78) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:47|48|49|50|169) */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x017f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0186, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x019a, code lost:
        if (r15.inTransaction() != false) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x019c, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01ae, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01be, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01e4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x01e5, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01e6, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x01e9, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x01ee, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        zzr().zzf().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        zzr().zzf().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        zzr().zzf().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x00d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0107 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x017f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0196 A[SYNTHETIC, Splitter:B:123:0x0196] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01df A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01df A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01df A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "Error reading entries from local database"
            r21.zzd()
            r21.zzb()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r21.zzaf()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x0020:
            if (r7 >= r5) goto L_0x01f2
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r21.zzae()     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0191, all -> 0x018e }
            if (r15 != 0) goto L_0x0037
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0031, all -> 0x017f }
            if (r15 == 0) goto L_0x0030
            r15.close()
        L_0x0030:
            return r3
        L_0x0031:
            r0 = move-exception
            goto L_0x0184
        L_0x0034:
            r0 = move-exception
            goto L_0x018c
        L_0x0037:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0182, all -> 0x017f }
            long r10 = zza((android.database.sqlite.SQLiteDatabase) r15)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0182, all -> 0x017f }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0031, all -> 0x017f }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0031, all -> 0x017f }
            r12[r6] = r10     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0031, all -> 0x017f }
            r13 = r0
            r14 = r12
            goto L_0x0053
        L_0x0051:
            r13 = r3
            r14 = r13
        L_0x0053:
            java.lang.String r11 = "messages"
            java.lang.String r0 = "rowid"
            java.lang.String r10 = "type"
            java.lang.String r12 = "entry"
            java.lang.String[] r12 = new java.lang.String[]{r0, r10, r12}     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0182, all -> 0x017f }
            r0 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            r10 = 100
            java.lang.String r18 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0186, SQLiteException -> 0x0182, all -> 0x017f }
            r10 = r15
            r5 = r15
            r15 = r0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x017b, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0177, all -> 0x0174 }
        L_0x0071:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            if (r0 == 0) goto L_0x013c
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            if (r0 != 0) goto L_0x00b9
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00a4 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00a4 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00a4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r0 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ ParseException -> 0x00a4 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00a4 }
            com.google.android.gms.measurement.internal.zzao r0 = (com.google.android.gms.measurement.internal.zzao) r0     // Catch:{ ParseException -> 0x00a4 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            if (r0 == 0) goto L_0x0071
        L_0x009e:
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            goto L_0x0071
        L_0x00a2:
            r0 = move-exception
            goto L_0x00b5
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x00a2 }
            java.lang.String r12 = "Failed to load event from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00a2 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            goto L_0x0071
        L_0x00b5:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            throw r0     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
        L_0x00b9:
            if (r0 != r9) goto L_0x00ec
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00d4 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00d4 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00d4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkr> r0 = com.google.android.gms.measurement.internal.zzkr.CREATOR     // Catch:{ ParseException -> 0x00d4 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00d4 }
            com.google.android.gms.measurement.internal.zzkr r0 = (com.google.android.gms.measurement.internal.zzkr) r0     // Catch:{ ParseException -> 0x00d4 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            goto L_0x00e5
        L_0x00d2:
            r0 = move-exception
            goto L_0x00e8
        L_0x00d4:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ all -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x00d2 }
            java.lang.String r12 = "Failed to load user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00d2 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            r0 = r3
        L_0x00e5:
            if (r0 == 0) goto L_0x0071
            goto L_0x009e
        L_0x00e8:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            throw r0     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
        L_0x00ec:
            if (r0 != r11) goto L_0x011f
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            int r0 = r12.length     // Catch:{ ParseException -> 0x0107 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x0107 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0107 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r0 = com.google.android.gms.measurement.internal.zzw.CREATOR     // Catch:{ ParseException -> 0x0107 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x0107 }
            com.google.android.gms.measurement.internal.zzw r0 = (com.google.android.gms.measurement.internal.zzw) r0     // Catch:{ ParseException -> 0x0107 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            goto L_0x0118
        L_0x0105:
            r0 = move-exception
            goto L_0x011b
        L_0x0107:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = "Failed to load conditional user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x0105 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            r0 = r3
        L_0x0118:
            if (r0 == 0) goto L_0x0071
            goto L_0x009e
        L_0x011b:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            throw r0     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
        L_0x011f:
            r11 = 3
            if (r0 != r11) goto L_0x0131
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            java.lang.String r11 = "Skipping app launch break"
        L_0x012c:
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            goto L_0x0071
        L_0x0131:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            java.lang.String r11 = "Unknown record type in local database"
            goto L_0x012c
        L_0x013c:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            int r0 = r5.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            int r11 = r4.size()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            if (r0 >= r11) goto L_0x015f
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
        L_0x015f:
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0172, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x0170, all -> 0x016c }
            r10.close()
            r5.close()
            return r4
        L_0x016c:
            r0 = move-exception
            r3 = r10
            goto L_0x01e7
        L_0x0170:
            r0 = move-exception
            goto L_0x0179
        L_0x0172:
            r0 = move-exception
            goto L_0x017d
        L_0x0174:
            r0 = move-exception
            goto L_0x01e7
        L_0x0177:
            r0 = move-exception
            r10 = r3
        L_0x0179:
            r15 = r5
            goto L_0x0194
        L_0x017b:
            r0 = move-exception
            r10 = r3
        L_0x017d:
            r15 = r5
            goto L_0x01ca
        L_0x017f:
            r0 = move-exception
            goto L_0x01e6
        L_0x0182:
            r0 = move-exception
            r5 = r15
        L_0x0184:
            r10 = r3
            goto L_0x0194
        L_0x0186:
            r5 = r15
        L_0x0187:
            r10 = r3
        L_0x0188:
            r15 = r5
            goto L_0x01b6
        L_0x018a:
            r0 = move-exception
            r5 = r15
        L_0x018c:
            r10 = r3
            goto L_0x01ca
        L_0x018e:
            r0 = move-exception
            r5 = r3
            goto L_0x01e7
        L_0x0191:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x0194:
            if (r15 == 0) goto L_0x019f
            boolean r5 = r15.inTransaction()     // Catch:{ all -> 0x01e4 }
            if (r5 == 0) goto L_0x019f
            r15.endTransaction()     // Catch:{ all -> 0x01e4 }
        L_0x019f:
            com.google.android.gms.measurement.internal.zzez r5 = r21.zzr()     // Catch:{ all -> 0x01e4 }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x01e4 }
            r5.zza(r2, r0)     // Catch:{ all -> 0x01e4 }
            r1.zzb = r9     // Catch:{ all -> 0x01e4 }
            if (r10 == 0) goto L_0x01b1
            r10.close()
        L_0x01b1:
            if (r15 == 0) goto L_0x01df
            goto L_0x01c3
        L_0x01b4:
            r10 = r3
            r15 = r10
        L_0x01b6:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x01e4 }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x01c1
            r10.close()
        L_0x01c1:
            if (r15 == 0) goto L_0x01df
        L_0x01c3:
            r15.close()
            goto L_0x01df
        L_0x01c7:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzez r5 = r21.zzr()     // Catch:{ all -> 0x01e4 }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x01e4 }
            r5.zza(r2, r0)     // Catch:{ all -> 0x01e4 }
            r1.zzb = r9     // Catch:{ all -> 0x01e4 }
            if (r10 == 0) goto L_0x01dc
            r10.close()
        L_0x01dc:
            if (r15 == 0) goto L_0x01df
            goto L_0x01c3
        L_0x01df:
            int r7 = r7 + 1
            r5 = 5
            goto L_0x0020
        L_0x01e4:
            r0 = move-exception
            r3 = r10
        L_0x01e6:
            r5 = r15
        L_0x01e7:
            if (r3 == 0) goto L_0x01ec
            r3.close()
        L_0x01ec:
            if (r5 == 0) goto L_0x01f1
            r5.close()
        L_0x01f1:
            throw r0
        L_0x01f2:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzev.zza(int):java.util.List");
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final boolean zza(zzao zzao) {
        Parcel obtain = Parcel.obtain();
        zzao.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkr zzkr) {
        Parcel obtain = Parcel.obtain();
        zzkr.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzw zzw) {
        zzp();
        byte[] zza2 = zzkw.zza((Parcelable) zzw);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    @WorkerThread
    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    @WorkerThread
    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    @WorkerThread
    public final boolean zzad() {
        zzd();
        zzb();
        if (this.zzb || !zzaf()) {
            return false;
        }
        int i = 0;
        int i2 = 5;
        while (i < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = zzae();
                if (sQLiteDatabase == null) {
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
                return true;
            } catch (SQLiteFullException e) {
                zzr().zzf().zza("Error deleting app launch break from local database", e);
                this.zzb = true;
                if (sQLiteDatabase == null) {
                    i++;
                }
                sQLiteDatabase.close();
                i++;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i2);
                i2 += 20;
                if (sQLiteDatabase == null) {
                    i++;
                }
                sQLiteDatabase.close();
                i++;
            } catch (SQLiteException e2) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzr().zzf().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i++;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzr().zzi().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
