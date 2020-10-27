package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
final class zzaz extends SQLiteOpenHelper {
    private final /* synthetic */ zzay zzxo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzay zzay, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzxo = zzay;
    }

    private final boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
            boolean moveToFirst = query.moveToFirst();
            query.close();
            return moveToFirst;
        } catch (SQLiteException e) {
            this.zzxo.zzc("Error querying for table", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(C0681a.m313a(C0681a.m336b(str, 22), "SELECT * FROM ", str, " LIMIT 0"), (String[]) null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.zzxo.zzxn.zzj(3600000)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zzxo.zzxn.start();
                this.zzxo.zzu("Opening the database failed, dropping the table and recreating it");
                this.zzxo.getContext().getDatabasePath(zzay.zzdt()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.zzxo.zzxn.clear();
                    return writableDatabase;
                } catch (SQLiteException e) {
                    this.zzxo.zze("Failed to open freshly created database", e);
                    throw e;
                }
            }
        } else {
            throw new SQLiteException("Database open failed");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (zzbx.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r10) {
        /*
            r9 = this;
            java.lang.String r0 = "hits2"
            boolean r1 = r9.zza(r10, r0)
            r2 = 0
            if (r1 != 0) goto L_0x0011
            java.lang.String r0 = com.google.android.gms.internal.gtm.zzay.zzxj
        L_0x000d:
            r10.execSQL(r0)
            goto L_0x0060
        L_0x0011:
            java.util.Set r0 = zzb(r10, r0)
            java.lang.String r1 = "hit_id"
            java.lang.String r3 = "hit_string"
            java.lang.String r4 = "hit_time"
            java.lang.String r5 = "hit_url"
            java.lang.String[] r1 = new java.lang.String[]{r1, r3, r4, r5}
            r3 = 0
        L_0x0022:
            r4 = 4
            if (r3 >= r4) goto L_0x004d
            r4 = r1[r3]
            boolean r5 = r0.remove(r4)
            if (r5 != 0) goto L_0x004a
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database hits2 is missing required column: "
            java.lang.String r1 = java.lang.String.valueOf(r4)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x0040
            java.lang.String r0 = r0.concat(r1)
            goto L_0x0046
        L_0x0040:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x0046:
            r10.<init>(r0)
            throw r10
        L_0x004a:
            int r3 = r3 + 1
            goto L_0x0022
        L_0x004d:
            java.lang.String r1 = "hit_app_id"
            boolean r1 = r0.remove(r1)
            r1 = r1 ^ 1
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00bc
            if (r1 == 0) goto L_0x0060
            java.lang.String r0 = "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER"
            goto L_0x000d
        L_0x0060:
            java.lang.String r0 = "properties"
            boolean r1 = r9.zza(r10, r0)
            if (r1 != 0) goto L_0x006e
            java.lang.String r0 = "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;"
            r10.execSQL(r0)
            return
        L_0x006e:
            java.util.Set r10 = zzb(r10, r0)
            java.lang.String r3 = "app_uid"
            java.lang.String r4 = "cid"
            java.lang.String r5 = "tid"
            java.lang.String r6 = "params"
            java.lang.String r7 = "adid"
            java.lang.String r8 = "hits_count"
            java.lang.String[] r0 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
        L_0x0082:
            r1 = 6
            if (r2 >= r1) goto L_0x00ad
            r1 = r0[r2]
            boolean r3 = r10.remove(r1)
            if (r3 != 0) goto L_0x00aa
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database properties is missing required column: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00a0
            java.lang.String r0 = r0.concat(r1)
            goto L_0x00a6
        L_0x00a0:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x00a6:
            r10.<init>(r0)
            throw r10
        L_0x00aa:
            int r2 = r2 + 1
            goto L_0x0082
        L_0x00ad:
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00b4
            return
        L_0x00b4:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database properties table has extra columns"
            r10.<init>(r0)
            throw r10
        L_0x00bc:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database hits2 has extra columns"
            r10.<init>(r0)
            goto L_0x00c5
        L_0x00c4:
            throw r10
        L_0x00c5:
            goto L_0x00c4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzaz.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
