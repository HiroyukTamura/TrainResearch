// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.database.Cursor;
import java.util.Map;
import android.os.Build$VERSION;
import android.support.annotation.WorkerThread;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

final class zzceq extends SQLiteOpenHelper
{
    private /* synthetic */ zzcen zzbpz;
    
    zzceq(final zzcen zzbpz, final Context context, final String s) {
        this.zzbpz = zzbpz;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
    }
    
    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzbpz.zzbpt.zzu(zzcem.zzxy())) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        }
        catch (SQLiteException ex2) {
            this.zzbpz.zzbpt.start();
            this.zzbpz.zzwF().zzyx().log("Opening the database failed, dropping and recreating it");
            final String zzxC = zzcem.zzxC();
            if (!this.zzbpz.getContext().getDatabasePath(zzxC).delete()) {
                this.zzbpz.zzwF().zzyx().zzj("Failed to delete corrupted db file", zzxC);
            }
            try {
                final SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.zzbpz.zzbpt.clear();
                return writableDatabase;
            }
            catch (SQLiteException ex) {
                this.zzbpz.zzwF().zzyx().zzj("Failed to open freshly created database", ex);
                throw ex;
            }
        }
    }
    
    @WorkerThread
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase);
    }
    
    @WorkerThread
    public final void onDowngrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
    
    @WorkerThread
    public final void onOpen(final SQLiteDatabase sqLiteDatabase) {
        Label_0029: {
            if (Build$VERSION.SDK_INT >= 15) {
                break Label_0029;
            }
            final Cursor rawQuery = sqLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[])null);
            try {
                rawQuery.moveToFirst();
                rawQuery.close();
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzcen.zzbpn);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzcen.zzbpo);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzcen.zzbpq);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzcen.zzbpp);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                zzcen.zza(this.zzbpz.zzwF(), sqLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzcen.zzbpr);
            }
            finally {
                rawQuery.close();
            }
        }
    }
    
    @WorkerThread
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
}
