// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.database.Cursor;
import java.util.Map;
import android.support.annotation.WorkerThread;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Build$VERSION;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.annotation.TargetApi;
import android.database.sqlite.SQLiteOpenHelper;

@TargetApi(11)
final class zzcfi extends SQLiteOpenHelper
{
    private /* synthetic */ zzcfh zzbqH;
    
    zzcfi(final zzcfh zzbqH, final Context context, final String s) {
        this.zzbqH = zzbqH;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
    }
    
    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            if (Build$VERSION.SDK_INT >= 11 && ex instanceof SQLiteDatabaseLockedException) {
                throw ex;
            }
            this.zzbqH.zzwF().zzyx().log("Opening the local database failed, dropping and recreating it");
            final String zzxD = zzcem.zzxD();
            if (!this.zzbqH.getContext().getDatabasePath(zzxD).delete()) {
                this.zzbqH.zzwF().zzyx().zzj("Failed to delete corrupted local db file", zzxD);
            }
            try {
                return super.getWritableDatabase();
            }
            catch (SQLiteException ex2) {
                this.zzbqH.zzwF().zzyx().zzj("Failed to open local database. Events will bypass local storage", ex2);
                return null;
            }
        }
    }
    
    @WorkerThread
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        zzcen.zza(this.zzbqH.zzwF(), sqLiteDatabase);
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
                zzcen.zza(this.zzbqH.zzwF(), sqLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
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
