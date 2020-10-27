package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

final class zzad extends zzkl {
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzae zzj = new zzae(this, zzn(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzkh zzk = new zzkh(zzm());

    zzad(zzkk zzkk) {
        super(zzkk);
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo24209c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            rawQuery.close();
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbu.zzb zzb2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzfb zzi2 = zzr().zzi();
            Object zza = zzez.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzi2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zzb2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        contentValues.put("data", zzbi);
        try {
            if (mo24209c_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzez.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzez.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbu.zze zze2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzfb zzi2 = zzr().zzi();
            Object zza = zzez.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzi2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zze2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put("data", zzbi);
        try {
            if (mo24209c_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzez.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzez.zza(str), e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = mo24209c_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                cursor.close();
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase c_ = mo24209c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzt().zzb(str, zzaq.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String a = C0681a.m313a(C0681a.m336b(join, 2), "(", join, ")");
            return c_.delete("audience_filter_values", C0681a.m313a(C0681a.m336b(a, 140), "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", a, " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzez.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    /* renamed from: b_ */
    public final void mo24208b_() {
        zzak();
        mo24209c_().setTransactionSuccessful();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: c_ */
    public final SQLiteDatabase mo24209c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    @androidx.annotation.WorkerThread
    /* renamed from: d_ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo24210d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.mo24209c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0027
        L_0x0020:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003b
        L_0x0025:
            r2 = move-exception
            r0 = r1
        L_0x0027:
            com.google.android.gms.measurement.internal.zzez r3 = r6.zzr()     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()
        L_0x0040:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.mo24210d_():java.lang.String");
    }

    public final long zza(zzcc.zzg zzg2) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbi = zzg2.zzbi();
        long zza = zzg().zza(zzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbi);
        try {
            mo24209c_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzez.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzcc.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo24209c_()     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0071 }
            if (r2 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzez r8 = r7.zzr()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzx()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r0
        L_0x0035:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0071 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzjm r2 = com.google.android.gms.measurement.internal.zzks.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzv()     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ IOException -> 0x005b }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r8
        L_0x005b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzez r3 = r7.zzr()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0071 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r0
        L_0x0071:
            r8 = move-exception
            goto L_0x0077
        L_0x0073:
            r8 = move-exception
            goto L_0x008c
        L_0x0075:
            r8 = move-exception
            r1 = r0
        L_0x0077:
            com.google.android.gms.measurement.internal.zzez r9 = r7.zzr()     // Catch:{ all -> 0x008a }
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzf()     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            return r0
        L_0x008a:
            r8 = move-exception
            r0 = r1
        L_0x008c:
            if (r0 == 0) goto L_0x0091
            r0.close()
        L_0x0091:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    @WorkerThread
    public final zzac zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzac zzac = new zzac();
        Cursor cursor = null;
        try {
            SQLiteDatabase c_ = mo24209c_();
            cursor = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzez.zza(str));
                cursor.close();
                return zzac;
            }
            if (cursor.getLong(0) == j) {
                zzac.zzb = cursor.getLong(1);
                zzac.zza = cursor.getLong(2);
                zzac.zzc = cursor.getLong(3);
                zzac.zzd = cursor.getLong(4);
                zzac.zze = cursor.getLong(5);
            }
            if (z) {
                zzac.zzb += j2;
            }
            if (z2) {
                zzac.zza += j2;
            }
            if (z3) {
                zzac.zzc += j2;
            }
            if (z4) {
                zzac.zzd += j2;
            }
            if (z5) {
                zzac.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzac.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzac.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzac.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzac.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzac.zze));
            c_.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return zzac;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error updating daily counts. appId", zzez.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzac;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final zzac zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzak zza(java.lang.String r26, java.lang.String r27) {
        /*
            r25 = this;
            r15 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            r25.zzd()
            r25.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r1 = r25.mo24209c_()     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.String r2 = "events"
            r9 = 0
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.String r4 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r5[r9] = r26     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r10 = 1
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r1 != 0) goto L_0x005a
            r14.close()
            return r18
        L_0x005a:
            long r4 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            long r6 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            long r11 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r0 = 3
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r2 = 0
            if (r1 == 0) goto L_0x0072
            r16 = r2
            goto L_0x0078
        L_0x0072:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r16 = r0
        L_0x0078:
            r0 = 4
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r1 == 0) goto L_0x0082
            r0 = r18
            goto L_0x008a
        L_0x0082:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
        L_0x008a:
            r1 = 5
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x0094
            r19 = r18
            goto L_0x009e
        L_0x0094:
            long r19 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r1 = java.lang.Long.valueOf(r19)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r19 = r1
        L_0x009e:
            r1 = 6
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x00a8
            r20 = r18
            goto L_0x00b2
        L_0x00a8:
            long r20 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r1 = java.lang.Long.valueOf(r20)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r20 = r1
        L_0x00b2:
            r1 = 7
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 != 0) goto L_0x00cd
            long r21 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x00cb }
            r23 = 1
            int r1 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x00c4
            r9 = 1
        L_0x00c4:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x00cb }
            r21 = r1
            goto L_0x00cf
        L_0x00cb:
            r0 = move-exception
            goto L_0x0125
        L_0x00cd:
            r21 = r18
        L_0x00cf:
            r1 = 8
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x00d9
            r8 = r2
            goto L_0x00de
        L_0x00d9:
            long r1 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r8 = r1
        L_0x00de:
            com.google.android.gms.measurement.internal.zzak r22 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r1 = r22
            r2 = r26
            r3 = r27
            r10 = r11
            r12 = r16
            r23 = r14
            r14 = r0
            r15 = r19
            r16 = r20
            r17 = r21
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            if (r0 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.zzez r0 = r25.zzr()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r26)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
        L_0x010c:
            r23.close()
            return r22
        L_0x0110:
            r0 = move-exception
            goto L_0x0119
        L_0x0112:
            r0 = move-exception
            r14 = r23
            goto L_0x0125
        L_0x0116:
            r0 = move-exception
            r23 = r14
        L_0x0119:
            r18 = r23
            goto L_0x0149
        L_0x011c:
            r0 = move-exception
            r23 = r14
            goto L_0x0125
        L_0x0120:
            r0 = move-exception
            goto L_0x0149
        L_0x0122:
            r0 = move-exception
            r14 = r18
        L_0x0125:
            com.google.android.gms.measurement.internal.zzez r1 = r25.zzr()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r26)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.measurement.internal.zzex r4 = r25.zzo()     // Catch:{ all -> 0x0146 }
            r5 = r27
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0146 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x0145
            r14.close()
        L_0x0145:
            return r18
        L_0x0146:
            r0 = move-exception
            r18 = r14
        L_0x0149:
            if (r18 == 0) goto L_0x014e
            r18.close()
        L_0x014e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzak");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzd()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.mo24209c_()     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003a }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzez r6 = r4.zzr()     // Catch:{ SQLiteException -> 0x003a }
            com.google.android.gms.measurement.internal.zzfb r6 = r6.zzx()     // Catch:{ SQLiteException -> 0x003a }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003a }
            r5.close()
            return r0
        L_0x0032:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003a }
            r5.close()
            return r6
        L_0x003a:
            r6 = move-exception
            goto L_0x0040
        L_0x003c:
            r6 = move-exception
            goto L_0x0055
        L_0x003e:
            r6 = move-exception
            r5 = r0
        L_0x0040:
            com.google.android.gms.measurement.internal.zzez r1 = r4.zzr()     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0052
            r5.close()
        L_0x0052:
            return r0
        L_0x0053:
            r6 = move-exception
            r0 = r5
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            r0.close()
        L_0x005a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A[Catch:{ all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkt> zza(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzd()
            r13.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.mo24209c_()     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r12 = 0
            r6[r12] = r14     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007c }
            if (r3 != 0) goto L_0x003d
            r2.close()
            return r0
        L_0x003d:
            java.lang.String r7 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x007c }
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x007c }
            if (r3 != 0) goto L_0x0049
            java.lang.String r3 = ""
        L_0x0049:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x007c }
            r3 = 3
            java.lang.Object r10 = r13.zza((android.database.Cursor) r2, (int) r3)     // Catch:{ SQLiteException -> 0x007c }
            if (r10 != 0) goto L_0x0068
            com.google.android.gms.measurement.internal.zzez r3 = r13.zzr()     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x007c }
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r14)     // Catch:{ SQLiteException -> 0x007c }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x007c }
            goto L_0x0072
        L_0x0068:
            com.google.android.gms.measurement.internal.zzkt r3 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ SQLiteException -> 0x007c }
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x007c }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x007c }
        L_0x0072:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x007c }
            if (r3 != 0) goto L_0x003d
            r2.close()
            return r0
        L_0x007c:
            r0 = move-exception
            goto L_0x0082
        L_0x007e:
            r14 = move-exception
            goto L_0x00b7
        L_0x0080:
            r0 = move-exception
            r2 = r1
        L_0x0082:
            com.google.android.gms.measurement.internal.zzez r3 = r13.zzr()     // Catch:{ all -> 0x00b5 }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r14)     // Catch:{ all -> 0x00b5 }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x00b5 }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzy r0 = r13.zzt()     // Catch:{ all -> 0x00b5 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00b5 }
            boolean r14 = r0.zze(r14, r3)     // Catch:{ all -> 0x00b5 }
            if (r14 == 0) goto L_0x00af
            java.util.List r14 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00ae
            r2.close()
        L_0x00ae:
            return r14
        L_0x00af:
            if (r2 == 0) goto L_0x00b4
            r2.close()
        L_0x00b4:
            return r1
        L_0x00b5:
            r14 = move-exception
            r1 = r2
        L_0x00b7:
            if (r1 == 0) goto L_0x00bc
            r1.close()
        L_0x00bc:
            goto L_0x00be
        L_0x00bd:
            throw r14
        L_0x00be:
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[LOOP:0: B:17:0x0052->B:41:0x00c3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c5 A[EDGE_INSN: B:54:0x00c5->B:42:0x00c5 ?: BREAK  , SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzcc.zzg, java.lang.Long>> zza(java.lang.String r13, int r14, int r15) {
        /*
            r12 = this;
            r12.zzd()
            r12.zzak()
            r0 = 1
            r1 = 0
            if (r14 <= 0) goto L_0x000c
            r2 = 1
            goto L_0x000d
        L_0x000c:
            r2 = 0
        L_0x000d:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            if (r15 <= 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.mo24209c_()     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.String r4 = "queue"
            java.lang.String r5 = "rowid"
            java.lang.String r6 = "data"
            java.lang.String r7 = "retry_count"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7}     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00cb }
            r7[r1] = r13     // Catch:{ SQLiteException -> 0x00cb }
            r8 = 0
            r9 = 0
            java.lang.String r10 = "rowid"
            java.lang.String r11 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x00cb }
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00cb }
            boolean r14 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00cb }
            if (r14 != 0) goto L_0x004c
            java.util.List r13 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x00cb }
            r2.close()
            return r13
        L_0x004c:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00cb }
            r14.<init>()     // Catch:{ SQLiteException -> 0x00cb }
            r3 = 0
        L_0x0052:
            long r4 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00cb }
            byte[] r6 = r2.getBlob(r0)     // Catch:{ IOException -> 0x00ad }
            com.google.android.gms.measurement.internal.zzks r7 = r12.zzg()     // Catch:{ IOException -> 0x00ad }
            byte[] r6 = r7.zzb(r6)     // Catch:{ IOException -> 0x00ad }
            boolean r7 = r14.isEmpty()     // Catch:{ SQLiteException -> 0x00cb }
            if (r7 != 0) goto L_0x006c
            int r7 = r6.length     // Catch:{ SQLiteException -> 0x00cb }
            int r7 = r7 + r3
            if (r7 > r15) goto L_0x00c5
        L_0x006c:
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = com.google.android.gms.internal.measurement.zzcc.zzg.zzbf()     // Catch:{ IOException -> 0x009a }
            com.google.android.gms.internal.measurement.zzjm r7 = com.google.android.gms.measurement.internal.zzks.zza(r7, (byte[]) r6)     // Catch:{ IOException -> 0x009a }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = (com.google.android.gms.internal.measurement.zzcc.zzg.zza) r7     // Catch:{ IOException -> 0x009a }
            r8 = 2
            boolean r9 = r2.isNull(r8)     // Catch:{ SQLiteException -> 0x00cb }
            if (r9 != 0) goto L_0x0084
            int r8 = r2.getInt(r8)     // Catch:{ SQLiteException -> 0x00cb }
            r7.zzi((int) r8)     // Catch:{ SQLiteException -> 0x00cb }
        L_0x0084:
            int r6 = r6.length     // Catch:{ SQLiteException -> 0x00cb }
            int r3 = r3 + r6
            com.google.android.gms.internal.measurement.zzjj r6 = r7.zzv()     // Catch:{ SQLiteException -> 0x00cb }
            com.google.android.gms.internal.measurement.zzib r6 = (com.google.android.gms.internal.measurement.zzib) r6     // Catch:{ SQLiteException -> 0x00cb }
            com.google.android.gms.internal.measurement.zzcc$zzg r6 = (com.google.android.gms.internal.measurement.zzcc.zzg) r6     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00cb }
            android.util.Pair r4 = android.util.Pair.create(r6, r4)     // Catch:{ SQLiteException -> 0x00cb }
            r14.add(r4)     // Catch:{ SQLiteException -> 0x00cb }
            goto L_0x00bd
        L_0x009a:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzez r5 = r12.zzr()     // Catch:{ SQLiteException -> 0x00cb }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.String r6 = "Failed to merge queued bundle. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x00cb }
        L_0x00a9:
            r5.zza(r6, r7, r4)     // Catch:{ SQLiteException -> 0x00cb }
            goto L_0x00bd
        L_0x00ad:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzez r5 = r12.zzr()     // Catch:{ SQLiteException -> 0x00cb }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.String r6 = "Failed to unzip queued bundle. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x00cb }
            goto L_0x00a9
        L_0x00bd:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00cb }
            if (r4 == 0) goto L_0x00c5
            if (r3 <= r15) goto L_0x0052
        L_0x00c5:
            r2.close()
            return r14
        L_0x00c9:
            r13 = move-exception
            goto L_0x00e7
        L_0x00cb:
            r14 = move-exception
            com.google.android.gms.measurement.internal.zzez r15 = r12.zzr()     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.measurement.internal.zzfb r15 = r15.zzf()     // Catch:{ all -> 0x00c9 }
            java.lang.String r0 = "Error querying bundles. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ all -> 0x00c9 }
            r15.zza(r0, r13, r14)     // Catch:{ all -> 0x00c9 }
            java.util.List r13 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00c9 }
            if (r2 == 0) goto L_0x00e6
            r2.close()
        L_0x00e6:
            return r13
        L_0x00e7:
            if (r2 == 0) goto L_0x00ec
            r2.close()
        L_0x00ec:
            goto L_0x00ee
        L_0x00ed:
            throw r13
        L_0x00ee:
            goto L_0x00ed
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f8, code lost:
        r12 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fc, code lost:
        r12 = r20;
        r3 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0124 A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0138  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkt> zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r20 = this;
            r8 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r20.zzd()
            r20.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            r10 = 3
            r1.<init>(r10)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            r1.add(r8)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            java.lang.String r3 = "app_id=?"
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            boolean r3 = android.text.TextUtils.isEmpty(r22)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            if (r3 != 0) goto L_0x0032
            r3 = r22
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r4 = " and origin=?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            goto L_0x0034
        L_0x0032:
            r3 = r22
        L_0x0034:
            boolean r4 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            if (r4 != 0) goto L_0x004c
            java.lang.String r4 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r5 = "*"
            java.lang.String r4 = r4.concat(r5)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            r1.add(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r4 = " and name glob ?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
        L_0x004c:
            int r4 = r1.size()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            r15 = r1
            java.lang.String[] r15 = (java.lang.String[]) r15     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            android.database.sqlite.SQLiteDatabase r11 = r20.mo24209c_()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r12 = "user_attributes"
            java.lang.String r1 = "name"
            java.lang.String r4 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r1, r4, r5, r6}     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            java.lang.String r14 = r2.toString()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "1001"
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00f7 }
            boolean r1 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            if (r1 != 0) goto L_0x0085
            r11.close()
            return r0
        L_0x0085:
            int r1 = r0.size()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 < r2) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzez r1 = r20.zzr()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r1.zza(r4, r2)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r12 = r20
            goto L_0x00e0
        L_0x00a1:
            r1 = 0
            java.lang.String r4 = r11.getString(r1)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r1 = 1
            long r5 = r11.getLong(r1)     // Catch:{ SQLiteException -> 0x00ef, all -> 0x00eb }
            r1 = 2
            r12 = r20
            java.lang.Object r7 = r12.zza((android.database.Cursor) r11, (int) r1)     // Catch:{ SQLiteException -> 0x00e9 }
            java.lang.String r13 = r11.getString(r10)     // Catch:{ SQLiteException -> 0x00e9 }
            if (r7 != 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzez r1 = r20.zzr()     // Catch:{ SQLiteException -> 0x00e6 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x00e6 }
            java.lang.String r2 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r21)     // Catch:{ SQLiteException -> 0x00e6 }
            r14 = r23
            r1.zza(r2, r3, r13, r14)     // Catch:{ SQLiteException -> 0x00e6 }
            goto L_0x00da
        L_0x00cc:
            r14 = r23
            com.google.android.gms.measurement.internal.zzkt r15 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ SQLiteException -> 0x00e6 }
            r1 = r15
            r2 = r21
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x00e6 }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x00e6 }
        L_0x00da:
            boolean r1 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00e6 }
            if (r1 != 0) goto L_0x00e4
        L_0x00e0:
            r11.close()
            return r0
        L_0x00e4:
            r3 = r13
            goto L_0x0085
        L_0x00e6:
            r0 = move-exception
            r3 = r13
            goto L_0x0101
        L_0x00e9:
            r0 = move-exception
            goto L_0x0101
        L_0x00eb:
            r0 = move-exception
            r12 = r20
            goto L_0x0135
        L_0x00ef:
            r0 = move-exception
            r12 = r20
            goto L_0x0101
        L_0x00f3:
            r0 = move-exception
            r12 = r20
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            r12 = r20
            goto L_0x0136
        L_0x00fb:
            r0 = move-exception
            r12 = r20
            r3 = r22
        L_0x0100:
            r11 = r9
        L_0x0101:
            com.google.android.gms.measurement.internal.zzez r1 = r20.zzr()     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r21)     // Catch:{ all -> 0x0134 }
            r1.zza(r2, r4, r3, r0)     // Catch:{ all -> 0x0134 }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x012e
            com.google.android.gms.measurement.internal.zzy r0 = r20.zzt()     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x0134 }
            boolean r0 = r0.zze(r8, r1)     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x012e
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0134 }
            if (r11 == 0) goto L_0x012d
            r11.close()
        L_0x012d:
            return r0
        L_0x012e:
            if (r11 == 0) goto L_0x0133
            r11.close()
        L_0x0133:
            return r9
        L_0x0134:
            r0 = move-exception
        L_0x0135:
            r9 = r11
        L_0x0136:
            if (r9 == 0) goto L_0x013b
            r9.close()
        L_0x013b:
            goto L_0x013d
        L_0x013c:
            throw r0
        L_0x013d:
            goto L_0x013c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final List<zzw> zza(String str, String[] strArr) {
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = mo24209c_().query("conditional_properties", new String[]{"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, (String) null, (String) null, "rowid", NativeContentAd.ASSET_HEADLINE);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    long j2 = cursor.getLong(8);
                    long j3 = cursor.getLong(10);
                    boolean z2 = z;
                    zzw zzw = r3;
                    zzw zzw2 = new zzw(string, string2, new zzkr(string3, j3, zza, string2), j2, z2, string4, (zzao) zzg().zza(cursor.getBlob(7), zzao.CREATOR), j, (zzao) zzg().zza(cursor.getBlob(9), zzao.CREATOR), cursor.getLong(11), (zzao) zzg().zza(cursor.getBlob(12), zzao.CREATOR));
                    arrayList.add(zzw);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying conditional user property value", e);
            List<zzw> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zza(zzak zzak) {
        Preconditions.checkNotNull(zzak);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzak.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzak.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzak.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzak.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzak.zzg));
        contentValues.put("last_bundled_day", zzak.zzh);
        contentValues.put("last_sampled_complex_event_id", zzak.zzi);
        contentValues.put("last_sampling_rate", zzak.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzak.zze));
        Boolean bool = zzak.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (mo24209c_().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzez.zza(zzak.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzez.zza(zzak.zza), e);
        }
    }

    @WorkerThread
    public final void zza(zzf zzf2) {
        Preconditions.checkNotNull(zzf2);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf2.zzc());
        contentValues.put("app_instance_id", zzf2.zzd());
        contentValues.put("gmp_app_id", zzf2.zze());
        contentValues.put("resettable_device_id_hash", zzf2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzf2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf2.zzk()));
        contentValues.put("app_version", zzf2.zzl());
        contentValues.put("app_store", zzf2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzf2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf2.zzr()));
        contentValues.put("day", Long.valueOf(zzf2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzf2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzf2.zzm()));
        contentValues.put("firebase_instance_id", zzf2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf2.zzaa()));
        contentValues.put("health_monitor_sample", zzf2.zzac());
        contentValues.put("android_id", Long.valueOf(zzf2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf2.zzag()));
        contentValues.put("admob_app_id", zzf2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzf2.zzq()));
        if (zzf2.zzai() != null) {
            if (zzf2.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzf2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf2.zzai()));
            }
        }
        if (zzoe.zzb() && zzt().zze(zzf2.zzc(), zzaq.zzbn)) {
            contentValues.put("ga_app_id", zzf2.zzg());
        }
        try {
            SQLiteDatabase c_ = mo24209c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzf2.zzc()})) == 0 && c_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzez.zza(zzf2.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzez.zza(zzf2.zzc()), e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0164, code lost:
        r8.zza(r10, r11, r9);
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r18, java.util.List<com.google.android.gms.internal.measurement.zzbu.zza> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            java.lang.String r3 = "app_id=? and audience_id=?"
            java.lang.String r4 = "event_filters"
            java.lang.String r5 = "app_id=?"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r19)
            r8 = 0
        L_0x0012:
            int r9 = r19.size()
            if (r8 >= r9) goto L_0x00d0
            java.lang.Object r9 = r2.get(r8)
            com.google.android.gms.internal.measurement.zzbu$zza r9 = (com.google.android.gms.internal.measurement.zzbu.zza) r9
            com.google.android.gms.internal.measurement.zzib$zza r9 = r9.zzbl()
            com.google.android.gms.internal.measurement.zzbu$zza$zza r9 = (com.google.android.gms.internal.measurement.zzbu.zza.C2675zza) r9
            int r11 = r9.zzb()
            if (r11 == 0) goto L_0x0095
            r11 = 0
        L_0x002b:
            int r12 = r9.zzb()
            if (r11 >= r12) goto L_0x0095
            com.google.android.gms.internal.measurement.zzbu$zzb r12 = r9.zzb(r11)
            com.google.android.gms.internal.measurement.zzib$zza r12 = r12.zzbl()
            com.google.android.gms.internal.measurement.zzbu$zzb$zza r12 = (com.google.android.gms.internal.measurement.zzbu.zzb.zza) r12
            java.lang.Object r13 = r12.clone()
            com.google.android.gms.internal.measurement.zzib$zza r13 = (com.google.android.gms.internal.measurement.zzib.zza) r13
            com.google.android.gms.internal.measurement.zzbu$zzb$zza r13 = (com.google.android.gms.internal.measurement.zzbu.zzb.zza) r13
            java.lang.String r14 = r12.zza()
            java.lang.String r14 = com.google.android.gms.measurement.internal.zzhb.zzb(r14)
            if (r14 == 0) goto L_0x0052
            r13.zza((java.lang.String) r14)
            r14 = 1
            goto L_0x0053
        L_0x0052:
            r14 = 0
        L_0x0053:
            r15 = 0
        L_0x0054:
            int r7 = r12.zzb()
            if (r15 >= r7) goto L_0x0081
            com.google.android.gms.internal.measurement.zzbu$zzc r7 = r12.zza((int) r15)
            java.lang.String r16 = r7.zzh()
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzha.zza(r16)
            if (r10 == 0) goto L_0x007e
            com.google.android.gms.internal.measurement.zzib$zza r7 = r7.zzbl()
            com.google.android.gms.internal.measurement.zzbu$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbu.zzc.zza) r7
            com.google.android.gms.internal.measurement.zzbu$zzc$zza r7 = r7.zza(r10)
            com.google.android.gms.internal.measurement.zzjj r7 = r7.zzv()
            com.google.android.gms.internal.measurement.zzib r7 = (com.google.android.gms.internal.measurement.zzib) r7
            com.google.android.gms.internal.measurement.zzbu$zzc r7 = (com.google.android.gms.internal.measurement.zzbu.zzc) r7
            r13.zza(r15, r7)
            r14 = 1
        L_0x007e:
            int r15 = r15 + 1
            goto L_0x0054
        L_0x0081:
            if (r14 == 0) goto L_0x0092
            com.google.android.gms.internal.measurement.zzbu$zza$zza r9 = r9.zza((int) r11, (com.google.android.gms.internal.measurement.zzbu.zzb.zza) r13)
            com.google.android.gms.internal.measurement.zzjj r7 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r7 = (com.google.android.gms.internal.measurement.zzib) r7
            com.google.android.gms.internal.measurement.zzbu$zza r7 = (com.google.android.gms.internal.measurement.zzbu.zza) r7
            r2.set(r8, r7)
        L_0x0092:
            int r11 = r11 + 1
            goto L_0x002b
        L_0x0095:
            int r7 = r9.zza()
            if (r7 == 0) goto L_0x00cc
            r7 = 0
        L_0x009c:
            int r10 = r9.zza()
            if (r7 >= r10) goto L_0x00cc
            com.google.android.gms.internal.measurement.zzbu$zze r10 = r9.zza(r7)
            java.lang.String r11 = r10.zzc()
            java.lang.String r11 = com.google.android.gms.measurement.internal.zzhd.zza(r11)
            if (r11 == 0) goto L_0x00c9
            com.google.android.gms.internal.measurement.zzib$zza r10 = r10.zzbl()
            com.google.android.gms.internal.measurement.zzbu$zze$zza r10 = (com.google.android.gms.internal.measurement.zzbu.zze.zza) r10
            com.google.android.gms.internal.measurement.zzbu$zze$zza r10 = r10.zza(r11)
            com.google.android.gms.internal.measurement.zzbu$zza$zza r9 = r9.zza((int) r7, (com.google.android.gms.internal.measurement.zzbu.zze.zza) r10)
            com.google.android.gms.internal.measurement.zzjj r10 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r10 = (com.google.android.gms.internal.measurement.zzib) r10
            com.google.android.gms.internal.measurement.zzbu$zza r10 = (com.google.android.gms.internal.measurement.zzbu.zza) r10
            r2.set(r8, r10)
        L_0x00c9:
            int r7 = r7 + 1
            goto L_0x009c
        L_0x00cc:
            int r8 = r8 + 1
            goto L_0x0012
        L_0x00d0:
            r17.zzak()
            r17.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r19)
            android.database.sqlite.SQLiteDatabase r7 = r17.mo24209c_()
            r7.beginTransaction()
            r17.zzak()     // Catch:{ all -> 0x0236 }
            r17.zzd()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)     // Catch:{ all -> 0x0236 }
            android.database.sqlite.SQLiteDatabase r8 = r17.mo24209c_()     // Catch:{ all -> 0x0236 }
            r9 = 1
            java.lang.String[] r10 = new java.lang.String[r9]     // Catch:{ all -> 0x0236 }
            r11 = 0
            r10[r11] = r0     // Catch:{ all -> 0x0236 }
            r8.delete(r6, r5, r10)     // Catch:{ all -> 0x0236 }
            java.lang.String[] r10 = new java.lang.String[r9]     // Catch:{ all -> 0x0236 }
            r10[r11] = r0     // Catch:{ all -> 0x0236 }
            r8.delete(r4, r5, r10)     // Catch:{ all -> 0x0236 }
            java.util.Iterator r5 = r19.iterator()     // Catch:{ all -> 0x0236 }
        L_0x0104:
            boolean r8 = r5.hasNext()     // Catch:{ all -> 0x0236 }
            if (r8 == 0) goto L_0x0203
            java.lang.Object r8 = r5.next()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.internal.measurement.zzbu$zza r8 = (com.google.android.gms.internal.measurement.zzbu.zza) r8     // Catch:{ all -> 0x0236 }
            r17.zzak()     // Catch:{ all -> 0x0236 }
            r17.zzd()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)     // Catch:{ all -> 0x0236 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0236 }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x0236 }
            if (r9 != 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzez r8 = r17.zzr()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()     // Catch:{ all -> 0x0236 }
            java.lang.String r9 = "Audience with no ID. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r18)     // Catch:{ all -> 0x0236 }
            r8.zza(r9, r10)     // Catch:{ all -> 0x0236 }
            goto L_0x0104
        L_0x0134:
            int r9 = r8.zzb()     // Catch:{ all -> 0x0236 }
            java.util.List r10 = r8.zze()     // Catch:{ all -> 0x0236 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0236 }
        L_0x0140:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0236 }
            if (r11 == 0) goto L_0x0168
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.internal.measurement.zzbu$zzb r11 = (com.google.android.gms.internal.measurement.zzbu.zzb) r11     // Catch:{ all -> 0x0236 }
            boolean r11 = r11.zza()     // Catch:{ all -> 0x0236 }
            if (r11 != 0) goto L_0x0140
            com.google.android.gms.measurement.internal.zzez r8 = r17.zzr()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()     // Catch:{ all -> 0x0236 }
            java.lang.String r10 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r18)     // Catch:{ all -> 0x0236 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0236 }
        L_0x0164:
            r8.zza(r10, r11, r9)     // Catch:{ all -> 0x0236 }
            goto L_0x0104
        L_0x0168:
            java.util.List r10 = r8.zzc()     // Catch:{ all -> 0x0236 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0236 }
        L_0x0170:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0236 }
            if (r11 == 0) goto L_0x0195
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.internal.measurement.zzbu$zze r11 = (com.google.android.gms.internal.measurement.zzbu.zze) r11     // Catch:{ all -> 0x0236 }
            boolean r11 = r11.zza()     // Catch:{ all -> 0x0236 }
            if (r11 != 0) goto L_0x0170
            com.google.android.gms.measurement.internal.zzez r8 = r17.zzr()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()     // Catch:{ all -> 0x0236 }
            java.lang.String r10 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r18)     // Catch:{ all -> 0x0236 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0236 }
            goto L_0x0164
        L_0x0195:
            java.util.List r10 = r8.zze()     // Catch:{ all -> 0x0236 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0236 }
        L_0x019d:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0236 }
            if (r11 == 0) goto L_0x01b1
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.internal.measurement.zzbu$zzb r11 = (com.google.android.gms.internal.measurement.zzbu.zzb) r11     // Catch:{ all -> 0x0236 }
            boolean r11 = r1.zza((java.lang.String) r0, (int) r9, (com.google.android.gms.internal.measurement.zzbu.zzb) r11)     // Catch:{ all -> 0x0236 }
            if (r11 != 0) goto L_0x019d
            r10 = 0
            goto L_0x01b2
        L_0x01b1:
            r10 = 1
        L_0x01b2:
            if (r10 == 0) goto L_0x01cf
            java.util.List r8 = r8.zzc()     // Catch:{ all -> 0x0236 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0236 }
        L_0x01bc:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x0236 }
            if (r11 == 0) goto L_0x01cf
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.internal.measurement.zzbu$zze r11 = (com.google.android.gms.internal.measurement.zzbu.zze) r11     // Catch:{ all -> 0x0236 }
            boolean r11 = r1.zza((java.lang.String) r0, (int) r9, (com.google.android.gms.internal.measurement.zzbu.zze) r11)     // Catch:{ all -> 0x0236 }
            if (r11 != 0) goto L_0x01bc
            r10 = 0
        L_0x01cf:
            if (r10 != 0) goto L_0x01ff
            r17.zzak()     // Catch:{ all -> 0x0236 }
            r17.zzd()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)     // Catch:{ all -> 0x0236 }
            android.database.sqlite.SQLiteDatabase r8 = r17.mo24209c_()     // Catch:{ all -> 0x0236 }
            r10 = 2
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ all -> 0x0236 }
            r12 = 0
            r11[r12] = r0     // Catch:{ all -> 0x0236 }
            java.lang.String r12 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0236 }
            r13 = 1
            r11[r13] = r12     // Catch:{ all -> 0x0236 }
            r8.delete(r6, r3, r11)     // Catch:{ all -> 0x0236 }
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ all -> 0x0236 }
            r11 = 0
            r10[r11] = r0     // Catch:{ all -> 0x0236 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0236 }
            r12 = 1
            r10[r12] = r9     // Catch:{ all -> 0x0236 }
            r8.delete(r4, r3, r10)     // Catch:{ all -> 0x0236 }
            goto L_0x0104
        L_0x01ff:
            r11 = 0
            r12 = 1
            goto L_0x0104
        L_0x0203:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0236 }
            r3.<init>()     // Catch:{ all -> 0x0236 }
            java.util.Iterator r2 = r19.iterator()     // Catch:{ all -> 0x0236 }
        L_0x020c:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0236 }
            if (r4 == 0) goto L_0x022c
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0236 }
            com.google.android.gms.internal.measurement.zzbu$zza r4 = (com.google.android.gms.internal.measurement.zzbu.zza) r4     // Catch:{ all -> 0x0236 }
            boolean r5 = r4.zza()     // Catch:{ all -> 0x0236 }
            if (r5 == 0) goto L_0x0227
            int r4 = r4.zzb()     // Catch:{ all -> 0x0236 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0236 }
            goto L_0x0228
        L_0x0227:
            r4 = 0
        L_0x0228:
            r3.add(r4)     // Catch:{ all -> 0x0236 }
            goto L_0x020c
        L_0x022c:
            r1.zzb((java.lang.String) r0, (java.util.List<java.lang.Integer>) r3)     // Catch:{ all -> 0x0236 }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x0236 }
            r7.endTransaction()
            return
        L_0x0236:
            r0 = move-exception
            r7.endTransaction()
            goto L_0x023c
        L_0x023b:
            throw r0
        L_0x023c:
            goto L_0x023b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            String a = C0681a.m313a(C0681a.m336b(join, 2), "(", join, ")");
            if (zzb(C0681a.m313a(C0681a.m336b(a, 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", a, " AND retry_count =  2147483647 LIMIT 1"), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = mo24209c_();
                StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(a);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    public final boolean zza(zzcc.zzg zzg2, boolean z) {
        zzfb zzf2;
        Object zza;
        String str;
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzy.zzk() || zzg2.zzl() > zzy.zzk() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzez.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = zzg().zzc(zzg2.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (mo24209c_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzez.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                e = e;
                zzf2 = zzr().zzf();
                zza = zzez.zza(zzg2.zzx());
                str = "Error storing bundle. appId";
                zzf2.zza(str, zza, e);
                return false;
            }
        } catch (IOException e2) {
            e = e2;
            zzf2 = zzr().zzf();
            zza = zzez.zza(zzg2.zzx());
            str = "Data loss. Failed to serialize bundle. appId";
            zzf2.zza(str, zza, e);
            return false;
        }
    }

    public final boolean zza(zzal zzal, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzal);
        Preconditions.checkNotEmpty(zzal.zza);
        byte[] zzbi = zzg().zza(zzal).zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzal.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzal.zzb);
        contentValues.put("timestamp", Long.valueOf(zzal.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (mo24209c_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzez.zza(zzal.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzez.zza(zzal.zza), e);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzkt zzkt) {
        Preconditions.checkNotNull(zzkt);
        zzd();
        zzak();
        if (zzc(zzkt.zza, zzkt.zzc) == null) {
            if (zzkw.zza(zzkt.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkt.zza}) >= ((long) zzt().zzd(zzkt.zza))) {
                    return false;
                }
            } else if (!"_npa".equals(zzkt.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkt.zza, zzkt.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkt.zza);
        contentValues.put("origin", zzkt.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzkt.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkt.zzd));
        zza(contentValues, "value", zzkt.zze);
        try {
            if (mo24209c_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzez.zza(zzkt.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzez.zza(zzkt.zza), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        zzd();
        zzak();
        if (zzc(zzw.zza, zzw.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzw.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzw.zza);
        contentValues.put("origin", zzw.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzw.zzc.zza);
        zza(contentValues, "value", zzw.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzw.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzw.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzw.zzh));
        zzp();
        contentValues.put("timed_out_event", zzkw.zza((Parcelable) zzw.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzw.zzd));
        zzp();
        contentValues.put("triggered_event", zzkw.zza((Parcelable) zzw.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzw.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzw.zzj));
        zzp();
        contentValues.put("expired_event", zzkw.zza((Parcelable) zzw.zzk));
        try {
            if (mo24209c_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzez.zza(zzw.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzez.zza(zzw.zza), e);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzd();
        zzak();
        byte[] zzbi = zzg().zza(new zzal(this.zzy, "", str, "dep", 0, 0, bundle)).zzbi();
        zzr().zzx().zza("Saving default event parameters, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbi);
        try {
            if (mo24209c_().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert default event parameters (got -1). appId", zzez.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing default event parameters. appId", zzez.zza(str), e);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzcc.zzc zzc2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbi = zzc2.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbi);
        try {
            if (mo24209c_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzez.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzez.zza(str), e);
            return false;
        }
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            cursor = mo24209c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1;
            }
            long j = cursor.getLong(0);
            cursor.close();
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0119 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x011d A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0157 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0170 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0185 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a1 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a2 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b1 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01e7 A[Catch:{ SQLiteException -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0229  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r35
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r35)
            r34.zzd()
            r34.zzak()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r34.mo24209c_()     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "ssaid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x020a, all -> 0x0206 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0202, all -> 0x01fe }
            if (r4 != 0) goto L_0x0069
            r3.close()
            return r2
        L_0x0069:
            com.google.android.gms.measurement.internal.zzf r4 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ SQLiteException -> 0x0202, all -> 0x01fe }
            r5 = r34
            com.google.android.gms.measurement.internal.zzkk r6 = r5.zza     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzs()     // Catch:{ SQLiteException -> 0x01fc }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zze((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzg((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zza((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzb((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzg((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzh((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzd((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zze((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r7 != 0) goto L_0x00d7
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r6 = 0
            goto L_0x00d8
        L_0x00d7:
            r6 = 1
        L_0x00d8:
            r4.zza((boolean) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzh((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzi((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r7 == 0) goto L_0x011d
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0122
        L_0x011d:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x01fc }
        L_0x0122:
            r4.zzc((long) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzf((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzi((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzy r6 = r34.zzt()     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzaq.zzcl     // Catch:{ SQLiteException -> 0x01fc }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x01fc }
            r7 = 0
            if (r6 != 0) goto L_0x0168
            r6 = 22
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r9 == 0) goto L_0x0161
            r9 = r7
            goto L_0x0165
        L_0x0161:
            long r9 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x0165:
            r4.zzp(r9)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x0168:
            r6 = 23
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r9 != 0) goto L_0x0179
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            r6 = 0
            goto L_0x017a
        L_0x0179:
            r6 = 1
        L_0x017a:
            r4.zzb((boolean) r6)     // Catch:{ SQLiteException -> 0x01fc }
            r6 = 24
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r9 != 0) goto L_0x018d
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x018c
            goto L_0x018d
        L_0x018c:
            r0 = 0
        L_0x018d:
            r4.zzc((boolean) r0)     // Catch:{ SQLiteException -> 0x01fc }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzc((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x01fc }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 == 0) goto L_0x01a2
            goto L_0x01a6
        L_0x01a2:
            long r7 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01a6:
            r4.zzf((long) r7)     // Catch:{ SQLiteException -> 0x01fc }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x01fc }
            if (r6 != 0) goto L_0x01c3
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x01fc }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zza((java.util.List<java.lang.String>) r0)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01c3:
            boolean r0 = com.google.android.gms.internal.measurement.zzoe.zzb()     // Catch:{ SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01de
            com.google.android.gms.measurement.internal.zzy r0 = r34.zzt()     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzbn     // Catch:{ SQLiteException -> 0x01fc }
            boolean r0 = r0.zze(r1, r6)     // Catch:{ SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01de
            r0 = 28
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01fc }
            r4.zzd((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01de:
            r4.zzb()     // Catch:{ SQLiteException -> 0x01fc }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01f8
            com.google.android.gms.measurement.internal.zzez r0 = r34.zzr()     // Catch:{ SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x01fc }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r35)     // Catch:{ SQLiteException -> 0x01fc }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x01fc }
        L_0x01f8:
            r3.close()
            return r4
        L_0x01fc:
            r0 = move-exception
            goto L_0x020e
        L_0x01fe:
            r0 = move-exception
            r5 = r34
            goto L_0x0226
        L_0x0202:
            r0 = move-exception
            r5 = r34
            goto L_0x020e
        L_0x0206:
            r0 = move-exception
            r5 = r34
            goto L_0x0227
        L_0x020a:
            r0 = move-exception
            r5 = r34
            r3 = r2
        L_0x020e:
            com.google.android.gms.measurement.internal.zzez r4 = r34.zzr()     // Catch:{ all -> 0x0225 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()     // Catch:{ all -> 0x0225 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r35)     // Catch:{ all -> 0x0225 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x0225 }
            if (r3 == 0) goto L_0x0224
            r3.close()
        L_0x0224:
            return r2
        L_0x0225:
            r0 = move-exception
        L_0x0226:
            r2 = r3
        L_0x0227:
            if (r2 == 0) goto L_0x022c
            r2.close()
        L_0x022c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    @WorkerThread
    public final List<zzw> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            mo24209c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user property. appId", zzez.zza(str), zzo().zzc(str2), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return (long) mo24209c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzaq.zzo))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzez.zza(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzkt zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzd()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.mo24209c_()     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x007e, all -> 0x007a }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0072 }
            if (r3 != 0) goto L_0x003d
            r10.close()
            return r9
        L_0x003d:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0072 }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzkt r0 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ SQLiteException -> 0x0070 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0070 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0070 }
            if (r1 == 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzez r1 = r18.zzr()     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0070 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0070 }
        L_0x006c:
            r10.close()
            return r0
        L_0x0070:
            r0 = move-exception
            goto L_0x0082
        L_0x0072:
            r0 = move-exception
            r11 = r18
            goto L_0x00a2
        L_0x0076:
            r0 = move-exception
            r11 = r18
            goto L_0x0082
        L_0x007a:
            r0 = move-exception
            r11 = r18
            goto L_0x00a3
        L_0x007e:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0082:
            com.google.android.gms.measurement.internal.zzez r1 = r18.zzr()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r19)     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzex r4 = r18.zzo()     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00a1 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x00a0
            r10.close()
        L_0x00a0:
            return r9
        L_0x00a1:
            r0 = move-exception
        L_0x00a2:
            r9 = r10
        L_0x00a3:
            if (r9 == 0) goto L_0x00a8
            r9.close()
        L_0x00a8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkt");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0121  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzw zzd(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzd()
            r29.zzak()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.mo24209c_()     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00f6 }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            if (r3 != 0) goto L_0x004c
            r9.close()
            return r8
        L_0x004c:
            java.lang.String r16 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r10 = r29
            java.lang.Object r5 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x00ec }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00ec }
            if (r0 == 0) goto L_0x005f
            r20 = 1
            goto L_0x0061
        L_0x005f:
            r20 = 0
        L_0x0061:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzks r0 = r29.zzg()     // Catch:{ SQLiteException -> 0x00ec }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r2 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ec }
            r22 = r0
            com.google.android.gms.measurement.internal.zzao r22 = (com.google.android.gms.measurement.internal.zzao) r22     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzks r0 = r29.zzg()     // Catch:{ SQLiteException -> 0x00ec }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r2 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ec }
            r25 = r0
            com.google.android.gms.measurement.internal.zzao r25 = (com.google.android.gms.measurement.internal.zzao) r25     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzks r0 = r29.zzg()     // Catch:{ SQLiteException -> 0x00ec }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r2 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ SQLiteException -> 0x00ec }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ec }
            r28 = r0
            com.google.android.gms.measurement.internal.zzao r28 = (com.google.android.gms.measurement.internal.zzao) r28     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzkr r17 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ SQLiteException -> 0x00ec }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzw r0 = new com.google.android.gms.measurement.internal.zzw     // Catch:{ SQLiteException -> 0x00ec }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00ec }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00ec }
            if (r1 == 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzez r1 = r29.zzr()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r30)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzex r4 = r29.zzo()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x00ec }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00ec }
        L_0x00e8:
            r9.close()
            return r0
        L_0x00ec:
            r0 = move-exception
            goto L_0x00fe
        L_0x00ee:
            r0 = move-exception
            r10 = r29
            goto L_0x011e
        L_0x00f2:
            r0 = move-exception
            r10 = r29
            goto L_0x00fe
        L_0x00f6:
            r0 = move-exception
            r10 = r29
            goto L_0x011f
        L_0x00fa:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzez r1 = r29.zzr()     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x011d }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r30)     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzex r4 = r29.zzo()     // Catch:{ all -> 0x011d }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x011d }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x011d }
            if (r9 == 0) goto L_0x011c
            r9.close()
        L_0x011c:
            return r8
        L_0x011d:
            r0 = move-exception
        L_0x011e:
            r8 = r9
        L_0x011f:
            if (r8 == 0) goto L_0x0124
            r8.close()
        L_0x0124:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzw");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzd()
            r10.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.mo24209c_()     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            r9 = 0
            r5[r9] = r11     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0052, all -> 0x0050 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x004e }
            if (r2 != 0) goto L_0x002f
            r1.close()
            return r0
        L_0x002f:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x004e }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x004e }
            if (r3 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzez r3 = r10.zzr()     // Catch:{ SQLiteException -> 0x004e }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x004e }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x004e }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x004e }
        L_0x004a:
            r1.close()
            return r2
        L_0x004e:
            r2 = move-exception
            goto L_0x0054
        L_0x0050:
            r11 = move-exception
            goto L_0x006d
        L_0x0052:
            r2 = move-exception
            r1 = r0
        L_0x0054:
            com.google.android.gms.measurement.internal.zzez r3 = r10.zzr()     // Catch:{ all -> 0x006b }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r11)     // Catch:{ all -> 0x006b }
            r3.zza(r4, r11, r2)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x006a
            r1.close()
        L_0x006a:
            return r0
        L_0x006b:
            r11 = move-exception
            r0 = r1
        L_0x006d:
            if (r0 == 0) goto L_0x0072
            r0.close()
        L_0x0072:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzd(java.lang.String):byte[]");
    }

    @WorkerThread
    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return mo24209c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzez.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzbu.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = mo24209c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzbu.zzb>> emptyMap = Collections.emptyMap();
                cursor.close();
                return emptyMap;
            }
            do {
                try {
                    zzbu.zzb zzb2 = (zzbu.zzb) ((zzib) ((zzbu.zzb.zza) zzks.zza(zzbu.zzb.zzl(), cursor.getBlob(1))).zzv());
                    if (zzb2.zzf()) {
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzr().zzf().zza("Failed to merge filter. appId", zzez.zza(str), e);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzez.zza(str), e2);
            Map<Integer, List<zzbu.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a A[Catch:{ all -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzak()
            r7.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.mo24209c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0065, all -> 0x0063 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0061 }
            if (r3 != 0) goto L_0x0030
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0061 }
            r1.close()
            return r8
        L_0x0030:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0061 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0061 }
            if (r4 != 0) goto L_0x004c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0061 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0061 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0061 }
        L_0x004c:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0061 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0061 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0061 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0061 }
            if (r3 != 0) goto L_0x0030
            r1.close()
            return r0
        L_0x0061:
            r0 = move-exception
            goto L_0x0067
        L_0x0063:
            r8 = move-exception
            goto L_0x009c
        L_0x0065:
            r0 = move-exception
            r1 = r2
        L_0x0067:
            com.google.android.gms.measurement.internal.zzez r3 = r7.zzr()     // Catch:{ all -> 0x009a }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x009a }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r8)     // Catch:{ all -> 0x009a }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x009a }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x0094
            com.google.android.gms.measurement.internal.zzy r0 = r7.zzt()     // Catch:{ all -> 0x009a }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x009a }
            boolean r8 = r0.zze(r8, r3)     // Catch:{ all -> 0x009a }
            if (r8 == 0) goto L_0x0094
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            return r8
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            return r2
        L_0x009a:
            r8 = move-exception
            r2 = r1
        L_0x009c:
            if (r2 == 0) goto L_0x00a1
            r2.close()
        L_0x00a1:
            goto L_0x00a3
        L_0x00a2:
            throw r8
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzf(java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbu.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo24209c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            r14.close()
            return r13
        L_0x0040:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzbu$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbu.zzb.zzl()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjm r1 = com.google.android.gms.measurement.internal.zzks.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbu$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbu.zzb.zza) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzv()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbu$zzb r1 = (com.google.android.gms.internal.measurement.zzbu.zzb) r1     // Catch:{ IOException -> 0x0076 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0092 }
            if (r3 != 0) goto L_0x0072
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0072:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0088
        L_0x0076:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r12.zzr()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            r14.close()
            return r0
        L_0x0092:
            r0 = move-exception
            goto L_0x0098
        L_0x0094:
            r13 = move-exception
            goto L_0x00cd
        L_0x0096:
            r0 = move-exception
            r14 = r9
        L_0x0098:
            com.google.android.gms.measurement.internal.zzez r1 = r12.zzr()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ all -> 0x00cb }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00cb }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzy r0 = r12.zzt()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00cb }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00cb }
            if (r13 == 0) goto L_0x00c5
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cb }
            if (r14 == 0) goto L_0x00c4
            r14.close()
        L_0x00c4:
            return r13
        L_0x00c5:
            if (r14 == 0) goto L_0x00ca
            r14.close()
        L_0x00ca:
            return r9
        L_0x00cb:
            r13 = move-exception
            r9 = r14
        L_0x00cd:
            if (r9 == 0) goto L_0x00d2
            r9.close()
        L_0x00d2:
            goto L_0x00d4
        L_0x00d3:
            throw r13
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    @WorkerThread
    public final void zzf() {
        zzak();
        mo24209c_().beginTransaction();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzcc.zzi> zzg(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzak()
            r11.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.mo24209c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r10 = 0
            r4[r10] = r12     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x004b
            boolean r1 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 == 0) goto L_0x0047
            com.google.android.gms.measurement.internal.zzy r1 = r11.zzt()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ SQLiteException -> 0x0092 }
            boolean r1 = r1.zze(r12, r2)     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 == 0) goto L_0x0047
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            r0.close()
            return r12
        L_0x0047:
            r0.close()
            return r8
        L_0x004b:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0092 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0050:
            int r2 = r0.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            byte[] r3 = r0.getBlob(r9)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r4 = com.google.android.gms.internal.measurement.zzcc.zzi.zzi()     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzjm r3 = com.google.android.gms.measurement.internal.zzks.zza(r4, (byte[]) r3)     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzcc.zzi.zza) r3     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzv()     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzcc$zzi r3 = (com.google.android.gms.internal.measurement.zzcc.zzi) r3     // Catch:{ IOException -> 0x0072 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0088
        L_0x0072:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzez r4 = r11.zzr()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r4.zza(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0088:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r2 != 0) goto L_0x0050
            r0.close()
            return r1
        L_0x0092:
            r1 = move-exception
            goto L_0x0098
        L_0x0094:
            r12 = move-exception
            goto L_0x00cd
        L_0x0096:
            r1 = move-exception
            r0 = r8
        L_0x0098:
            com.google.android.gms.measurement.internal.zzez r2 = r11.zzr()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r12)     // Catch:{ all -> 0x00cb }
            r2.zza(r3, r4, r1)     // Catch:{ all -> 0x00cb }
            boolean r1 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzy r1 = r11.zzt()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00cb }
            boolean r12 = r1.zze(r12, r2)     // Catch:{ all -> 0x00cb }
            if (r12 == 0) goto L_0x00c5
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c4
            r0.close()
        L_0x00c4:
            return r12
        L_0x00c5:
            if (r0 == 0) goto L_0x00ca
            r0.close()
        L_0x00ca:
            return r8
        L_0x00cb:
            r12 = move-exception
            r8 = r0
        L_0x00cd:
            if (r8 == 0) goto L_0x00d2
            r8.close()
        L_0x00d2:
            goto L_0x00d4
        L_0x00d3:
            throw r12
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzg(java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbu.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo24209c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0094 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            r14.close()
            return r13
        L_0x0040:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzbu$zze$zza r2 = com.google.android.gms.internal.measurement.zzbu.zze.zzi()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjm r1 = com.google.android.gms.measurement.internal.zzks.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbu$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbu.zze.zza) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzv()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzbu$zze r1 = (com.google.android.gms.internal.measurement.zzbu.zze) r1     // Catch:{ IOException -> 0x0076 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0092 }
            if (r3 != 0) goto L_0x0072
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0072:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0088
        L_0x0076:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r12.zzr()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            r14.close()
            return r0
        L_0x0092:
            r0 = move-exception
            goto L_0x0098
        L_0x0094:
            r13 = move-exception
            goto L_0x00cd
        L_0x0096:
            r0 = move-exception
            r14 = r9
        L_0x0098:
            com.google.android.gms.measurement.internal.zzez r1 = r12.zzr()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)     // Catch:{ all -> 0x00cb }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00cb }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzy r0 = r12.zzt()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00cb }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00cb }
            if (r13 == 0) goto L_0x00c5
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cb }
            if (r14 == 0) goto L_0x00c4
            r14.close()
        L_0x00c4:
            return r13
        L_0x00c5:
            if (r14 == 0) goto L_0x00ca
            r14.close()
        L_0x00ca:
            return r9
        L_0x00cb:
            r13 = move-exception
            r9 = r14
        L_0x00cd:
            if (r9 == 0) goto L_0x00d2
            r9.close()
        L_0x00d2:
            goto L_0x00d4
        L_0x00d3:
            throw r13
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final long zzh(String str, String str2) {
        long zza;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase c_ = mo24209c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                zza = zza(sb.toString(), new String[]{str3}, -1);
                if (zza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (c_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzez.zza(str), str4);
                        c_.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzr().zzf().zza("Error inserting column. appId", zzez.zza(str), str4, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put(str4, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    zzr().zzf().zza("Failed to update column (got 0). appId", zzez.zza(str), str4);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza;
                zzr().zzf().zza("Error inserting column. appId", zzez.zza(str), str4, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzr().zzf().zza("Error inserting column. appId", zzez.zza(str), str4, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            c_.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public final void zzh() {
        zzak();
        mo24209c_().endTransaction();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo24209c_()     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r2 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzez r8 = r7.zzr()     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzx()     // Catch:{ SQLiteException -> 0x00b6 }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00b6 }
            r1.close()
            return r0
        L_0x002e:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r3 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzjm r2 = com.google.android.gms.measurement.internal.zzks.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzv()     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ IOException -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ IOException -> 0x00a0 }
            r7.zzg()     // Catch:{ SQLiteException -> 0x00b6 }
            java.util.List r8 = r2.zza()     // Catch:{ SQLiteException -> 0x00b6 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00b6 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00b6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00b6 }
        L_0x0054:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r3 == 0) goto L_0x009c
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3     // Catch:{ SQLiteException -> 0x00b6 }
            java.lang.String r4 = r3.zzb()     // Catch:{ SQLiteException -> 0x00b6 }
            boolean r5 = r3.zzi()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x0072
            double r5 = r3.zzj()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x0072:
            boolean r5 = r3.zzg()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x0080
            float r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x0080:
            boolean r5 = r3.zzc()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x008e
            java.lang.String r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x008e:
            boolean r5 = r3.zze()     // Catch:{ SQLiteException -> 0x00b6 }
            if (r5 == 0) goto L_0x0054
            long r5 = r3.zzf()     // Catch:{ SQLiteException -> 0x00b6 }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00b6 }
            goto L_0x0054
        L_0x009c:
            r1.close()
            return r2
        L_0x00a0:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzez r3 = r7.zzr()     // Catch:{ SQLiteException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x00b6 }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x00b6 }
            r3.zza(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00b6 }
            r1.close()
            return r0
        L_0x00b6:
            r8 = move-exception
            goto L_0x00bc
        L_0x00b8:
            r8 = move-exception
            goto L_0x00d1
        L_0x00ba:
            r8 = move-exception
            r1 = r0
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzez r2 = r7.zzr()     // Catch:{ all -> 0x00cf }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r8)     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x00ce
            r1.close()
        L_0x00ce:
            return r0
        L_0x00cf:
            r8 = move-exception
            r0 = r1
        L_0x00d1:
            if (r0 == 0) goto L_0x00d6
            r0.close()
        L_0x00d6:
            goto L_0x00d8
        L_0x00d7:
            throw r8
        L_0x00d8:
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzi(java.lang.String):android.os.Bundle");
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzv() {
        int delete;
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzaq.zzx.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (zzam() && (delete = mo24209c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzy.zzk())})) > 0) {
                    zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    @WorkerThread
    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @WorkerThread
    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }
}
