package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.internal.gtm.zzdi;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

final class zzat implements DataLayer.zzc {
    /* access modifiers changed from: private */
    public static final String zzafx = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor zzafy;
    private zzax zzafz;
    private int zzaga;
    /* access modifiers changed from: private */
    public final Context zzrm;
    private Clock zzsd;

    public zzat(Context context) {
        this(context, DefaultClock.getInstance(), "google_tagmanager.db", CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzdf.zzgp().zzr(zzdi.zzadg));
    }

    @VisibleForTesting
    private zzat(Context context, Clock clock, String str, int i, Executor executor) {
        this.zzrm = context;
        this.zzsd = clock;
        this.zzaga = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
        this.zzafy = executor;
        this.zzafz = new zzax(this, this.zzrm, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[SYNTHETIC, Splitter:B:13:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0028 A[SYNTHETIC, Splitter:B:22:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0032 A[SYNTHETIC, Splitter:B:31:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object zza(byte[] r3) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r3)
            r3 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x0018 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x0018 }
            java.lang.Object r3 = r1.readObject()     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0026, all -> 0x0016 }
            r1.close()     // Catch:{ IOException -> 0x0015 }
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r3
        L_0x0016:
            r3 = move-exception
            goto L_0x001c
        L_0x0018:
            r1 = move-exception
            r2 = r1
            r1 = r3
            r3 = r2
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0021:
            r0.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            throw r3
        L_0x0025:
            r1 = r3
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002b:
            r0.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return r3
        L_0x002f:
            r1 = r3
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0035:
            r0.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zza(byte[]):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void zzat(String str) {
        SQLiteDatabase zzau = zzau("Error opening database for clearKeysWithPrefix.");
        if (zzau != null) {
            try {
                int delete = zzau.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
                StringBuilder sb = new StringBuilder(25);
                sb.append("Cleared ");
                sb.append(delete);
                sb.append(" items");
                zzdi.zzab(sb.toString());
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 44 + valueOf.length());
                sb2.append("Error deleting entries with key prefix: ");
                sb2.append(str);
                sb2.append(" (");
                sb2.append(valueOf);
                sb2.append(").");
                zzdi.zzac(sb2.toString());
            } finally {
                zzhw();
            }
        }
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzafz.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzb(List<zzay> list, long j) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.zzsd.currentTimeMillis();
            zzl(currentTimeMillis);
            int zzhv = (zzhv() - this.zzaga) + list.size();
            if (zzhv > 0) {
                List<String> zzu = zzu(zzhv);
                int size = zzu.size();
                StringBuilder sb = new StringBuilder(64);
                sb.append("DataLayer store full, deleting ");
                sb.append(size);
                sb.append(" entries to make room.");
                zzdi.zzaw(sb.toString());
                strArr = (String[]) zzu.toArray(new String[0]);
                if (strArr != null) {
                    if (strArr.length != 0) {
                        SQLiteDatabase zzau = zzau("Error opening database for deleteEntries.");
                        if (zzau != null) {
                            zzau.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                        }
                    }
                }
            }
        } catch (SQLiteException unused) {
            String valueOf = String.valueOf(Arrays.toString(strArr));
            zzdi.zzac(valueOf.length() != 0 ? "Error deleting entries ".concat(valueOf) : new String("Error deleting entries "));
        } catch (Throwable th) {
            zzhw();
            throw th;
        }
        long j2 = currentTimeMillis + j;
        SQLiteDatabase zzau2 = zzau("Error opening database for writeEntryToDatabase.");
        if (zzau2 != null) {
            for (zzay next : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j2));
                contentValues.put("key", next.zzagg);
                contentValues.put("value", next.zzagh);
                zzau2.insert("datalayer", (String) null, contentValues);
            }
        }
        zzhw();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[SYNTHETIC, Splitter:B:13:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0029 A[SYNTHETIC, Splitter:B:22:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] zzf(java.lang.Object r3) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0026, all -> 0x001c }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0026, all -> 0x001c }
            r2.writeObject(r3)     // Catch:{ IOException -> 0x0027, all -> 0x0019 }
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x0027, all -> 0x0019 }
            r2.close()     // Catch:{ IOException -> 0x0018 }
            r0.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return r3
        L_0x0019:
            r3 = move-exception
            r1 = r2
            goto L_0x001d
        L_0x001c:
            r3 = move-exception
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0022:
            r0.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            throw r3
        L_0x0026:
            r2 = r1
        L_0x0027:
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x002f }
        L_0x002c:
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzf(java.lang.Object):byte[]");
    }

    /* access modifiers changed from: private */
    public final List<DataLayer.zza> zzht() {
        try {
            zzl(this.zzsd.currentTimeMillis());
            List<zzay> zzhu = zzhu();
            ArrayList arrayList = new ArrayList();
            for (zzay next : zzhu) {
                arrayList.add(new DataLayer.zza(next.zzagg, zza(next.zzagh)));
            }
            return arrayList;
        } finally {
            zzhw();
        }
    }

    private final List<zzay> zzhu() {
        SQLiteDatabase zzau = zzau("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (zzau == null) {
            return arrayList;
        }
        Cursor query = zzau.query("datalayer", new String[]{"key", "value"}, (String) null, (String[]) null, (String) null, (String) null, "ID", (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzay(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
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
    private final int zzhv() {
        /*
            r4 = this;
            java.lang.String r0 = "Error opening database for getNumStoredEntries."
            android.database.sqlite.SQLiteDatabase r0 = r4.zzau(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = 0
            java.lang.String r3 = "SELECT COUNT(*) from datalayer"
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
            java.lang.String r0 = "Error getting numStoredEntries"
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzhv():int");
    }

    private final void zzhw() {
        try {
            this.zzafz.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzl(long j) {
        SQLiteDatabase zzau = zzau("Error opening database for deleteOlderThan.");
        if (zzau != null) {
            try {
                int delete = zzau.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
                StringBuilder sb = new StringBuilder(33);
                sb.append("Deleted ");
                sb.append(delete);
                sb.append(" expired items");
                zzdi.zzab(sb.toString());
            } catch (SQLiteException unused) {
                zzdi.zzac("Error deleting old entries.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        if (r2 == null) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> zzu(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "ID"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r14 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzdi.zzac(r14)
            return r1
        L_0x000f:
            java.lang.String r2 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r3 = r13.zzau(r2)
            if (r3 != 0) goto L_0x0018
            return r1
        L_0x0018:
            r2 = 0
            java.lang.String r4 = "datalayer"
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
            java.lang.String r0 = "Error in peekEntries fetching entryIds: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzu(int):java.util.List");
    }

    public final void zza(zzaq zzaq) {
        this.zzafy.execute(new zzav(this, zzaq));
    }

    public final void zza(List<DataLayer.zza> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza next : list) {
            arrayList.add(new zzay(next.mKey, zzf(next.mValue)));
        }
        this.zzafy.execute(new zzau(this, arrayList, j));
    }

    public final void zzas(String str) {
        this.zzafy.execute(new zzaw(this, str));
    }
}
