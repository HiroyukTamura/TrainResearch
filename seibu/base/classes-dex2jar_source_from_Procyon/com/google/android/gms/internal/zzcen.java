// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Pair;
import android.os.Parcelable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import android.text.TextUtils;
import java.io.File;
import com.google.android.gms.common.internal.zzbo;
import android.content.ContentValues;
import android.support.annotation.WorkerThread;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import java.util.Map;

final class zzcen extends zzchj
{
    private static final Map<String, String> zzbpn;
    private static final Map<String, String> zzbpo;
    private static final Map<String, String> zzbpp;
    private static final Map<String, String> zzbpq;
    private static final Map<String, String> zzbpr;
    private final zzceq zzbps;
    private final zzcjf zzbpt;
    
    static {
        (zzbpn = new ArrayMap<String, String>(1)).put("origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;");
        (zzbpo = new ArrayMap<String, String>(18)).put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        zzcen.zzbpo.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        zzcen.zzbpo.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        zzcen.zzbpo.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        zzcen.zzbpo.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        zzcen.zzbpo.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        zzcen.zzbpo.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        zzcen.zzbpo.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        zzcen.zzbpo.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        zzcen.zzbpo.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        zzcen.zzbpo.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        zzcen.zzbpo.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        zzcen.zzbpo.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        zzcen.zzbpo.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        zzcen.zzbpo.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        zzcen.zzbpo.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
        zzcen.zzbpo.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
        zzcen.zzbpo.put("health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;");
        zzcen.zzbpo.put("android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;");
        (zzbpp = new ArrayMap<String, String>(1)).put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
        (zzbpq = new ArrayMap<String, String>(1)).put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
        (zzbpr = new ArrayMap<String, String>(1)).put("previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;");
    }
    
    zzcen(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbpt = new zzcjf(this.zzkq());
        this.zzbps = new zzceq(this, this.getContext(), zzcem.zzxC());
    }
    
    @WorkerThread
    private final long zza(final String s, final String[] array, long n) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        Cursor cursor = null;
        Cursor rawQuery = null;
        try {
            final Cursor cursor2 = cursor = (rawQuery = writableDatabase.rawQuery(s, array));
            if (cursor2.moveToFirst()) {
                rawQuery = cursor2;
                cursor = cursor2;
                long long1;
                n = (long1 = cursor2.getLong(0));
                if (cursor2 != null) {
                    cursor2.close();
                    long1 = n;
                }
                return long1;
            }
            long long1 = n;
            return n;
        }
        catch (SQLiteException ex) {
            cursor = rawQuery;
            this.zzwF().zzyx().zze("Database error", s, ex);
            cursor = rawQuery;
            throw ex;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
    @WorkerThread
    private final Object zza(final Cursor cursor, final int n) {
        final int type = cursor.getType(n);
        switch (type) {
            default: {
                this.zzwF().zzyx().zzj("Loaded invalid unknown value type, ignoring it", type);
                return null;
            }
            case 0: {
                this.zzwF().zzyx().log("Loaded invalid null value from database");
                return null;
            }
            case 1: {
                return cursor.getLong(n);
            }
            case 2: {
                return cursor.getDouble(n);
            }
            case 3: {
                return cursor.getString(n);
            }
            case 4: {
                this.zzwF().zzyx().log("Loaded invalid blob type value, ignoring it");
                return null;
            }
        }
    }
    
    @WorkerThread
    private static void zza(final ContentValues contentValues, final String s, final Object o) {
        zzbo.zzcF(s);
        zzbo.zzu(o);
        if (o instanceof String) {
            contentValues.put(s, (String)o);
            return;
        }
        if (o instanceof Long) {
            contentValues.put(s, (Long)o);
            return;
        }
        if (o instanceof Double) {
            contentValues.put(s, (Double)o);
            return;
        }
        throw new IllegalArgumentException("Invalid value type");
    }
    
    static void zza(final zzcfl zzcfl, final SQLiteDatabase sqLiteDatabase) {
        if (zzcfl == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        final File file = new File(sqLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzcfl.zzyz().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzcfl.zzyz().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzcfl.zzyz().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzcfl.zzyz().log("Failed to turn on database write permission for owner");
        }
    }
    
    @WorkerThread
    static void zza(final zzcfl zzcfl, final SQLiteDatabase sqLiteDatabase, final String s, final String s2, final String s3, final Map<String, String> map) throws SQLiteException {
        if (zzcfl == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzcfl, sqLiteDatabase, s)) {
            sqLiteDatabase.execSQL(s2);
        }
        try {
            zza(zzcfl, sqLiteDatabase, s, s3, map);
        }
        catch (SQLiteException ex) {
            zzcfl.zzyx().zzj("Failed to verify columns on table that was just created", s);
            throw ex;
        }
    }
    
    @WorkerThread
    private static void zza(final zzcfl zzcfl, final SQLiteDatabase sqLiteDatabase, final String s, final String s2, final Map<String, String> map) throws SQLiteException {
        if (zzcfl == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        final Set<String> zzb = zzb(sqLiteDatabase, s);
        final String[] split = s2.split(",");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String s3 = split[i];
            if (!zzb.remove(s3)) {
                throw new SQLiteException(new StringBuilder(String.valueOf(s).length() + 35 + String.valueOf(s3).length()).append("Table ").append(s).append(" is missing required column: ").append(s3).toString());
            }
        }
        if (map != null) {
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                if (!zzb.remove(entry.getKey())) {
                    sqLiteDatabase.execSQL((String)entry.getValue());
                }
            }
        }
        if (!zzb.isEmpty()) {
            zzcfl.zzyz().zze("Table has extra columns. table, columns", s, TextUtils.join((CharSequence)", ", (Iterable)zzb));
        }
    }
    
    @WorkerThread
    private static boolean zza(final zzcfl p0, final SQLiteDatabase p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: ifnonnull       18
        //     7: new             Ljava/lang/IllegalArgumentException;
        //    10: dup            
        //    11: ldc_w           "Monitor must not be null"
        //    14: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    17: athrow         
        //    18: aload_1        
        //    19: ldc_w           "SQLITE_MASTER"
        //    22: iconst_1       
        //    23: anewarray       Ljava/lang/String;
        //    26: dup            
        //    27: iconst_0       
        //    28: ldc_w           "name"
        //    31: aastore        
        //    32: ldc_w           "name=?"
        //    35: iconst_1       
        //    36: anewarray       Ljava/lang/String;
        //    39: dup            
        //    40: iconst_0       
        //    41: aload_2        
        //    42: aastore        
        //    43: aconst_null    
        //    44: aconst_null    
        //    45: aconst_null    
        //    46: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    49: astore_1       
        //    50: aload_1        
        //    51: astore          4
        //    53: aload           4
        //    55: astore_1       
        //    56: aload           4
        //    58: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    63: istore_3       
        //    64: aload           4
        //    66: ifnull          76
        //    69: aload           4
        //    71: invokeinterface android/database/Cursor.close:()V
        //    76: iload_3        
        //    77: ireturn        
        //    78: astore          5
        //    80: aconst_null    
        //    81: astore          4
        //    83: aload           4
        //    85: astore_1       
        //    86: aload_0        
        //    87: invokevirtual   com/google/android/gms/internal/zzcfl.zzyz:()Lcom/google/android/gms/internal/zzcfn;
        //    90: ldc_w           "Error querying for table"
        //    93: aload_2        
        //    94: aload           5
        //    96: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    99: aload           4
        //   101: ifnull          111
        //   104: aload           4
        //   106: invokeinterface android/database/Cursor.close:()V
        //   111: iconst_0       
        //   112: ireturn        
        //   113: astore_0       
        //   114: aload           4
        //   116: astore_1       
        //   117: aload_1        
        //   118: ifnull          127
        //   121: aload_1        
        //   122: invokeinterface android/database/Cursor.close:()V
        //   127: aload_0        
        //   128: athrow         
        //   129: astore_0       
        //   130: goto            117
        //   133: astore          5
        //   135: goto            83
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  18     50     78     83     Landroid/database/sqlite/SQLiteException;
        //  18     50     113    117    Any
        //  56     64     133    138    Landroid/database/sqlite/SQLiteException;
        //  56     64     129    133    Any
        //  86     99     129    133    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0076:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    private final boolean zza(final String p0, final int p1, final zzcjn p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //     4: aload_0        
        //     5: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     8: aload_1        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_3        
        //    14: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    17: pop            
        //    18: aload_3        
        //    19: getfield        com/google/android/gms/internal/zzcjn.zzbuN:Ljava/lang/String;
        //    22: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    25: ifeq            58
        //    28: aload_0        
        //    29: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //    32: invokevirtual   com/google/android/gms/internal/zzcfl.zzyz:()Lcom/google/android/gms/internal/zzcfn;
        //    35: ldc_w           "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
        //    38: aload_1        
        //    39: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //    42: iload_2        
        //    43: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    46: aload_3        
        //    47: getfield        com/google/android/gms/internal/zzcjn.zzbuM:Ljava/lang/Integer;
        //    50: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    53: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    56: iconst_0       
        //    57: ireturn        
        //    58: aload_3        
        //    59: invokevirtual   com/google/android/gms/internal/zzcjn.zzLV:()I
        //    62: newarray        B
        //    64: astore          4
        //    66: aload           4
        //    68: iconst_0       
        //    69: aload           4
        //    71: arraylength    
        //    72: invokestatic    com/google/android/gms/internal/adh.zzc:([BII)Lcom/google/android/gms/internal/adh;
        //    75: astore          5
        //    77: aload_3        
        //    78: aload           5
        //    80: invokevirtual   com/google/android/gms/internal/zzcjn.zza:(Lcom/google/android/gms/internal/adh;)V
        //    83: aload           5
        //    85: invokevirtual   com/google/android/gms/internal/adh.zzLM:()V
        //    88: new             Landroid/content/ContentValues;
        //    91: dup            
        //    92: invokespecial   android/content/ContentValues.<init>:()V
        //    95: astore          5
        //    97: aload           5
        //    99: ldc_w           "app_id"
        //   102: aload_1        
        //   103: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   106: aload           5
        //   108: ldc_w           "audience_id"
        //   111: iload_2        
        //   112: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   115: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   118: aload           5
        //   120: ldc_w           "filter_id"
        //   123: aload_3        
        //   124: getfield        com/google/android/gms/internal/zzcjn.zzbuM:Ljava/lang/Integer;
        //   127: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   130: aload           5
        //   132: ldc_w           "event_name"
        //   135: aload_3        
        //   136: getfield        com/google/android/gms/internal/zzcjn.zzbuN:Ljava/lang/String;
        //   139: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   142: aload           5
        //   144: ldc_w           "data"
        //   147: aload           4
        //   149: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;[B)V
        //   152: aload_0        
        //   153: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //   156: ldc_w           "event_filters"
        //   159: aconst_null    
        //   160: aload           5
        //   162: iconst_5       
        //   163: invokevirtual   android/database/sqlite/SQLiteDatabase.insertWithOnConflict:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
        //   166: ldc2_w          -1
        //   169: lcmp           
        //   170: ifne            190
        //   173: aload_0        
        //   174: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   177: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   180: ldc_w           "Failed to insert event filter (got -1). appId"
        //   183: aload_1        
        //   184: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   187: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   190: iconst_1       
        //   191: ireturn        
        //   192: astore_3       
        //   193: aload_0        
        //   194: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   197: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   200: ldc_w           "Configuration loss. Failed to serialize event filter. appId"
        //   203: aload_1        
        //   204: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   207: aload_3        
        //   208: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   211: iconst_0       
        //   212: ireturn        
        //   213: astore_3       
        //   214: aload_0        
        //   215: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   218: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   221: ldc_w           "Error storing event filter. appId"
        //   224: aload_1        
        //   225: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   228: aload_3        
        //   229: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   232: iconst_0       
        //   233: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  58     88     192    213    Ljava/io/IOException;
        //  152    190    213    234    Landroid/database/sqlite/SQLiteException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0190:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    private final boolean zza(final String s, final int n, final zzcjq zzcjq) {
        this.zzkD();
        this.zzjC();
        zzbo.zzcF(s);
        zzbo.zzu(zzcjq);
        if (TextUtils.isEmpty((CharSequence)zzcjq.zzbvc)) {
            this.zzwF().zzyz().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzcfl.zzdZ(s), n, String.valueOf(zzcjq.zzbuM));
            return false;
        }
        try {
            final byte[] array = new byte[zzcjq.zzLV()];
            final adh zzc = adh.zzc(array, 0, array.length);
            zzcjq.zza(zzc);
            zzc.zzLM();
            final ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", s);
            contentValues.put("audience_id", Integer.valueOf(n));
            contentValues.put("filter_id", zzcjq.zzbuM);
            contentValues.put("property_name", zzcjq.zzbvc);
            contentValues.put("data", array);
            try {
                if (this.getWritableDatabase().insertWithOnConflict("property_filters", (String)null, contentValues, 5) == -1L) {
                    this.zzwF().zzyx().zzj("Failed to insert property filter (got -1). appId", zzcfl.zzdZ(s));
                    return false;
                }
                return true;
            }
            catch (SQLiteException ex) {
                this.zzwF().zzyx().zze("Error storing property filter. appId", zzcfl.zzdZ(s), ex);
                return false;
            }
        }
        catch (IOException ex2) {
            this.zzwF().zzyx().zze("Configuration loss. Failed to serialize property filter. appId", zzcfl.zzdZ(s), ex2);
            return false;
        }
        return true;
    }
    
    @WorkerThread
    private final long zzb(final String s, final String[] array) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        Cursor cursor = null;
        Cursor rawQuery = null;
        try {
            final Cursor cursor2 = cursor = (rawQuery = writableDatabase.rawQuery(s, array));
            if (cursor2.moveToFirst()) {
                rawQuery = cursor2;
                cursor = cursor2;
                return cursor2.getLong(0);
            }
            rawQuery = cursor2;
            cursor = cursor2;
            throw new SQLiteException("Database returned empty set");
        }
        catch (SQLiteException ex) {
            cursor = rawQuery;
            this.zzwF().zzyx().zze("Database error", s, ex);
            cursor = rawQuery;
            throw ex;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
    @WorkerThread
    private static Set<String> zzb(SQLiteDatabase rawQuery, final String s) {
        final HashSet<Object> c = new HashSet<Object>();
        rawQuery = (SQLiteDatabase)rawQuery.rawQuery(new StringBuilder(String.valueOf(s).length() + 22).append("SELECT * FROM ").append(s).append(" LIMIT 0").toString(), (String[])null);
        try {
            Collections.addAll(c, ((Cursor)rawQuery).getColumnNames());
            return (Set<String>)c;
        }
        finally {
            ((Cursor)rawQuery).close();
        }
    }
    
    private final boolean zzc(final String s, final List<Integer> list) {
        while (true) {
            zzbo.zzcF(s);
            this.zzkD();
            this.zzjC();
            final SQLiteDatabase writableDatabase = this.getWritableDatabase();
            int max;
            try {
                final long zzb = this.zzb("select count(1) from audience_filter_values where app_id=?", new String[] { s });
                max = Math.max(0, Math.min(2000, this.zzwH().zzb(s, zzcfb.zzbqA)));
                if (zzb <= max) {
                    return false;
                }
            }
            catch (SQLiteException ex) {
                this.zzwF().zzyx().zze("Database error querying filters. appId", zzcfl.zzdZ(s), ex);
                return false;
            }
            final ArrayList<String> list2 = new ArrayList<String>();
            for (int i = 0; i < list.size(); ++i) {
                final Integer n = list.get(i);
                if (n == null || !(n instanceof Integer)) {
                    return false;
                }
                list2.add(Integer.toString(n));
            }
            final String value = String.valueOf(TextUtils.join((CharSequence)",", (Iterable)list2));
            final String string = new StringBuilder(String.valueOf(value).length() + 2).append("(").append(value).append(")").toString();
            if (writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(string).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(string).append(" order by rowid desc limit -1 offset ?)").toString(), new String[] { s, Integer.toString(max) }) > 0) {
                break;
            }
            return false;
        }
        return true;
    }
    
    private final boolean zzyk() {
        return this.getContext().getDatabasePath(zzcem.zzxC()).exists();
    }
    
    @WorkerThread
    public final void beginTransaction() {
        this.zzkD();
        this.getWritableDatabase().beginTransaction();
    }
    
    @WorkerThread
    public final void endTransaction() {
        this.zzkD();
        this.getWritableDatabase().endTransaction();
    }
    
    @WorkerThread
    final SQLiteDatabase getWritableDatabase() {
        this.zzjC();
        try {
            return this.zzbps.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyz().zzj("Error opening database", ex);
            throw ex;
        }
    }
    
    @WorkerThread
    public final void setTransactionSuccessful() {
        this.zzkD();
        this.getWritableDatabase().setTransactionSuccessful();
    }
    
    @WorkerThread
    public final zzcev zzE(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          5
        //     3: aload_1        
        //     4: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     7: pop            
        //     8: aload_2        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_0        
        //    14: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //    17: aload_0        
        //    18: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    21: aload_0        
        //    22: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    25: ldc_w           "events"
        //    28: iconst_3       
        //    29: anewarray       Ljava/lang/String;
        //    32: dup            
        //    33: iconst_0       
        //    34: ldc_w           "lifetime_count"
        //    37: aastore        
        //    38: dup            
        //    39: iconst_1       
        //    40: ldc_w           "current_bundle_count"
        //    43: aastore        
        //    44: dup            
        //    45: iconst_2       
        //    46: ldc_w           "last_fire_timestamp"
        //    49: aastore        
        //    50: ldc_w           "app_id=? and name=?"
        //    53: iconst_2       
        //    54: anewarray       Ljava/lang/String;
        //    57: dup            
        //    58: iconst_0       
        //    59: aload_1        
        //    60: aastore        
        //    61: dup            
        //    62: iconst_1       
        //    63: aload_2        
        //    64: aastore        
        //    65: aconst_null    
        //    66: aconst_null    
        //    67: aconst_null    
        //    68: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    71: astore          4
        //    73: aload           4
        //    75: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    80: istore_3       
        //    81: iload_3        
        //    82: ifne            101
        //    85: aload           4
        //    87: ifnull          97
        //    90: aload           4
        //    92: invokeinterface android/database/Cursor.close:()V
        //    97: aconst_null    
        //    98: astore_1       
        //    99: aload_1        
        //   100: areturn        
        //   101: new             Lcom/google/android/gms/internal/zzcev;
        //   104: dup            
        //   105: aload_1        
        //   106: aload_2        
        //   107: aload           4
        //   109: iconst_0       
        //   110: invokeinterface android/database/Cursor.getLong:(I)J
        //   115: aload           4
        //   117: iconst_1       
        //   118: invokeinterface android/database/Cursor.getLong:(I)J
        //   123: aload           4
        //   125: iconst_2       
        //   126: invokeinterface android/database/Cursor.getLong:(I)J
        //   131: invokespecial   com/google/android/gms/internal/zzcev.<init>:(Ljava/lang/String;Ljava/lang/String;JJJ)V
        //   134: astore          5
        //   136: aload           4
        //   138: invokeinterface android/database/Cursor.moveToNext:()Z
        //   143: ifeq            163
        //   146: aload_0        
        //   147: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   150: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   153: ldc_w           "Got multiple records for event aggregates, expected one. appId"
        //   156: aload_1        
        //   157: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   160: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   163: aload           5
        //   165: astore_1       
        //   166: aload           4
        //   168: ifnull          99
        //   171: aload           4
        //   173: invokeinterface android/database/Cursor.close:()V
        //   178: aload           5
        //   180: areturn        
        //   181: astore          5
        //   183: aconst_null    
        //   184: astore          4
        //   186: aload_0        
        //   187: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   190: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   193: ldc_w           "Error querying events. appId"
        //   196: aload_1        
        //   197: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   200: aload_0        
        //   201: invokevirtual   com/google/android/gms/internal/zzcen.zzwA:()Lcom/google/android/gms/internal/zzcfj;
        //   204: aload_2        
        //   205: invokevirtual   com/google/android/gms/internal/zzcfj.zzdW:(Ljava/lang/String;)Ljava/lang/String;
        //   208: aload           5
        //   210: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   213: aload           4
        //   215: ifnull          225
        //   218: aload           4
        //   220: invokeinterface android/database/Cursor.close:()V
        //   225: aconst_null    
        //   226: areturn        
        //   227: astore_1       
        //   228: aload           5
        //   230: astore_2       
        //   231: aload_2        
        //   232: ifnull          241
        //   235: aload_2        
        //   236: invokeinterface android/database/Cursor.close:()V
        //   241: aload_1        
        //   242: athrow         
        //   243: astore_1       
        //   244: aload           4
        //   246: astore_2       
        //   247: goto            231
        //   250: astore_1       
        //   251: aload           4
        //   253: astore_2       
        //   254: goto            231
        //   257: astore          5
        //   259: goto            186
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  21     73     181    186    Landroid/database/sqlite/SQLiteException;
        //  21     73     227    231    Any
        //  73     81     257    262    Landroid/database/sqlite/SQLiteException;
        //  73     81     243    250    Any
        //  101    163    257    262    Landroid/database/sqlite/SQLiteException;
        //  101    163    243    250    Any
        //  186    213    250    257    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 131 out of bounds for length 131
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final void zzF(final String s, final String s2) {
        zzbo.zzcF(s);
        zzbo.zzcF(s2);
        this.zzjC();
        this.zzkD();
        try {
            this.zzwF().zzyD().zzj("Deleted user attribute rows", this.getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { s, s2 }));
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zzd("Error deleting user attribute. appId", zzcfl.zzdZ(s), this.zzwA().zzdY(s2), ex);
        }
    }
    
    @WorkerThread
    public final zzcjk zzG(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          7
        //     3: aload_1        
        //     4: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     7: pop            
        //     8: aload_2        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_0        
        //    14: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //    17: aload_0        
        //    18: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    21: aload_0        
        //    22: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    25: ldc_w           "user_attributes"
        //    28: iconst_3       
        //    29: anewarray       Ljava/lang/String;
        //    32: dup            
        //    33: iconst_0       
        //    34: ldc_w           "set_timestamp"
        //    37: aastore        
        //    38: dup            
        //    39: iconst_1       
        //    40: ldc_w           "value"
        //    43: aastore        
        //    44: dup            
        //    45: iconst_2       
        //    46: ldc             "origin"
        //    48: aastore        
        //    49: ldc_w           "app_id=? and name=?"
        //    52: iconst_2       
        //    53: anewarray       Ljava/lang/String;
        //    56: dup            
        //    57: iconst_0       
        //    58: aload_1        
        //    59: aastore        
        //    60: dup            
        //    61: iconst_1       
        //    62: aload_2        
        //    63: aastore        
        //    64: aconst_null    
        //    65: aconst_null    
        //    66: aconst_null    
        //    67: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    70: astore          6
        //    72: aload           6
        //    74: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    79: istore_3       
        //    80: iload_3        
        //    81: ifne            100
        //    84: aload           6
        //    86: ifnull          96
        //    89: aload           6
        //    91: invokeinterface android/database/Cursor.close:()V
        //    96: aconst_null    
        //    97: astore_1       
        //    98: aload_1        
        //    99: areturn        
        //   100: aload           6
        //   102: iconst_0       
        //   103: invokeinterface android/database/Cursor.getLong:(I)J
        //   108: lstore          4
        //   110: aload_0        
        //   111: aload           6
        //   113: iconst_1       
        //   114: invokespecial   com/google/android/gms/internal/zzcen.zza:(Landroid/database/Cursor;I)Ljava/lang/Object;
        //   117: astore          7
        //   119: new             Lcom/google/android/gms/internal/zzcjk;
        //   122: dup            
        //   123: aload_1        
        //   124: aload           6
        //   126: iconst_2       
        //   127: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   132: aload_2        
        //   133: lload           4
        //   135: aload           7
        //   137: invokespecial   com/google/android/gms/internal/zzcjk.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
        //   140: astore          7
        //   142: aload           6
        //   144: invokeinterface android/database/Cursor.moveToNext:()Z
        //   149: ifeq            169
        //   152: aload_0        
        //   153: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   156: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   159: ldc_w           "Got multiple records for user property, expected one. appId"
        //   162: aload_1        
        //   163: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   166: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   169: aload           7
        //   171: astore_1       
        //   172: aload           6
        //   174: ifnull          98
        //   177: aload           6
        //   179: invokeinterface android/database/Cursor.close:()V
        //   184: aload           7
        //   186: areturn        
        //   187: astore          7
        //   189: aconst_null    
        //   190: astore          6
        //   192: aload_0        
        //   193: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   196: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   199: ldc_w           "Error querying user property. appId"
        //   202: aload_1        
        //   203: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   206: aload_0        
        //   207: invokevirtual   com/google/android/gms/internal/zzcen.zzwA:()Lcom/google/android/gms/internal/zzcfj;
        //   210: aload_2        
        //   211: invokevirtual   com/google/android/gms/internal/zzcfj.zzdY:(Ljava/lang/String;)Ljava/lang/String;
        //   214: aload           7
        //   216: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   219: aload           6
        //   221: ifnull          231
        //   224: aload           6
        //   226: invokeinterface android/database/Cursor.close:()V
        //   231: aconst_null    
        //   232: areturn        
        //   233: astore_1       
        //   234: aload           7
        //   236: astore_2       
        //   237: aload_2        
        //   238: ifnull          247
        //   241: aload_2        
        //   242: invokeinterface android/database/Cursor.close:()V
        //   247: aload_1        
        //   248: athrow         
        //   249: astore_1       
        //   250: aload           6
        //   252: astore_2       
        //   253: goto            237
        //   256: astore_1       
        //   257: aload           6
        //   259: astore_2       
        //   260: goto            237
        //   263: astore          7
        //   265: goto            192
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  21     72     187    192    Landroid/database/sqlite/SQLiteException;
        //  21     72     233    237    Any
        //  72     80     263    268    Landroid/database/sqlite/SQLiteException;
        //  72     80     249    256    Any
        //  100    169    263    268    Landroid/database/sqlite/SQLiteException;
        //  100    169    249    256    Any
        //  192    219    256    263    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 136 out of bounds for length 136
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final void zzG(final List<Long> list) {
        zzbo.zzu(list);
        this.zzjC();
        this.zzkD();
        final StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append((long)list.get(i));
        }
        sb.append(")");
        final int delete = this.getWritableDatabase().delete("raw_events", sb.toString(), (String[])null);
        if (delete != list.size()) {
            this.zzwF().zzyx().zze("Deleted fewer rows from raw events table than expected", delete, list.size());
        }
    }
    
    @WorkerThread
    public final zzcek zzH(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     4: pop            
        //     5: aload_2        
        //     6: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     9: pop            
        //    10: aload_0        
        //    11: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //    14: aload_0        
        //    15: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    18: aload_0        
        //    19: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    22: ldc_w           "conditional_properties"
        //    25: bipush          11
        //    27: anewarray       Ljava/lang/String;
        //    30: dup            
        //    31: iconst_0       
        //    32: ldc             "origin"
        //    34: aastore        
        //    35: dup            
        //    36: iconst_1       
        //    37: ldc_w           "value"
        //    40: aastore        
        //    41: dup            
        //    42: iconst_2       
        //    43: ldc_w           "active"
        //    46: aastore        
        //    47: dup            
        //    48: iconst_3       
        //    49: ldc_w           "trigger_event_name"
        //    52: aastore        
        //    53: dup            
        //    54: iconst_4       
        //    55: ldc_w           "trigger_timeout"
        //    58: aastore        
        //    59: dup            
        //    60: iconst_5       
        //    61: ldc_w           "timed_out_event"
        //    64: aastore        
        //    65: dup            
        //    66: bipush          6
        //    68: ldc_w           "creation_timestamp"
        //    71: aastore        
        //    72: dup            
        //    73: bipush          7
        //    75: ldc_w           "triggered_event"
        //    78: aastore        
        //    79: dup            
        //    80: bipush          8
        //    82: ldc_w           "triggered_timestamp"
        //    85: aastore        
        //    86: dup            
        //    87: bipush          9
        //    89: ldc_w           "time_to_live"
        //    92: aastore        
        //    93: dup            
        //    94: bipush          10
        //    96: ldc_w           "expired_event"
        //    99: aastore        
        //   100: ldc_w           "app_id=? and name=?"
        //   103: iconst_2       
        //   104: anewarray       Ljava/lang/String;
        //   107: dup            
        //   108: iconst_0       
        //   109: aload_1        
        //   110: aastore        
        //   111: dup            
        //   112: iconst_1       
        //   113: aload_2        
        //   114: aastore        
        //   115: aconst_null    
        //   116: aconst_null    
        //   117: aconst_null    
        //   118: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   121: astore          12
        //   123: aload           12
        //   125: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   130: istore_3       
        //   131: iload_3        
        //   132: ifne            151
        //   135: aload           12
        //   137: ifnull          147
        //   140: aload           12
        //   142: invokeinterface android/database/Cursor.close:()V
        //   147: aconst_null    
        //   148: astore_1       
        //   149: aload_1        
        //   150: areturn        
        //   151: aload           12
        //   153: iconst_0       
        //   154: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   159: astore          13
        //   161: aload_0        
        //   162: aload           12
        //   164: iconst_1       
        //   165: invokespecial   com/google/android/gms/internal/zzcen.zza:(Landroid/database/Cursor;I)Ljava/lang/Object;
        //   168: astore          14
        //   170: aload           12
        //   172: iconst_2       
        //   173: invokeinterface android/database/Cursor.getInt:(I)I
        //   178: ifeq            401
        //   181: iconst_1       
        //   182: istore_3       
        //   183: aload           12
        //   185: iconst_3       
        //   186: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   191: astore          15
        //   193: aload           12
        //   195: iconst_4       
        //   196: invokeinterface android/database/Cursor.getLong:(I)J
        //   201: lstore          4
        //   203: aload_0        
        //   204: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   207: aload           12
        //   209: iconst_5       
        //   210: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   215: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   218: invokevirtual   com/google/android/gms/internal/zzcjl.zzb:([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
        //   221: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   224: astore          16
        //   226: aload           12
        //   228: bipush          6
        //   230: invokeinterface android/database/Cursor.getLong:(I)J
        //   235: lstore          6
        //   237: aload_0        
        //   238: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   241: aload           12
        //   243: bipush          7
        //   245: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   250: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   253: invokevirtual   com/google/android/gms/internal/zzcjl.zzb:([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
        //   256: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   259: astore          17
        //   261: aload           12
        //   263: bipush          8
        //   265: invokeinterface android/database/Cursor.getLong:(I)J
        //   270: lstore          8
        //   272: aload           12
        //   274: bipush          9
        //   276: invokeinterface android/database/Cursor.getLong:(I)J
        //   281: lstore          10
        //   283: aload_0        
        //   284: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   287: aload           12
        //   289: bipush          10
        //   291: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   296: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   299: invokevirtual   com/google/android/gms/internal/zzcjl.zzb:([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
        //   302: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   305: astore          18
        //   307: new             Lcom/google/android/gms/internal/zzcek;
        //   310: dup            
        //   311: aload_1        
        //   312: aload           13
        //   314: new             Lcom/google/android/gms/internal/zzcji;
        //   317: dup            
        //   318: aload_2        
        //   319: lload           8
        //   321: aload           14
        //   323: aload           13
        //   325: invokespecial   com/google/android/gms/internal/zzcji.<init>:(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
        //   328: lload           6
        //   330: iload_3        
        //   331: aload           15
        //   333: aload           16
        //   335: lload           4
        //   337: aload           17
        //   339: lload           10
        //   341: aload           18
        //   343: invokespecial   com/google/android/gms/internal/zzcek.<init>:(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzcji;JZLjava/lang/String;Lcom/google/android/gms/internal/zzcez;JLcom/google/android/gms/internal/zzcez;JLcom/google/android/gms/internal/zzcez;)V
        //   346: astore          13
        //   348: aload           12
        //   350: invokeinterface android/database/Cursor.moveToNext:()Z
        //   355: ifeq            383
        //   358: aload_0        
        //   359: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   362: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   365: ldc_w           "Got multiple records for conditional property, expected one"
        //   368: aload_1        
        //   369: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   372: aload_0        
        //   373: invokevirtual   com/google/android/gms/internal/zzcen.zzwA:()Lcom/google/android/gms/internal/zzcfj;
        //   376: aload_2        
        //   377: invokevirtual   com/google/android/gms/internal/zzcfj.zzdY:(Ljava/lang/String;)Ljava/lang/String;
        //   380: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   383: aload           13
        //   385: astore_1       
        //   386: aload           12
        //   388: ifnull          149
        //   391: aload           12
        //   393: invokeinterface android/database/Cursor.close:()V
        //   398: aload           13
        //   400: areturn        
        //   401: iconst_0       
        //   402: istore_3       
        //   403: goto            183
        //   406: astore          13
        //   408: aconst_null    
        //   409: astore          12
        //   411: aload_0        
        //   412: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   415: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   418: ldc_w           "Error querying conditional property"
        //   421: aload_1        
        //   422: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   425: aload_0        
        //   426: invokevirtual   com/google/android/gms/internal/zzcen.zzwA:()Lcom/google/android/gms/internal/zzcfj;
        //   429: aload_2        
        //   430: invokevirtual   com/google/android/gms/internal/zzcfj.zzdY:(Ljava/lang/String;)Ljava/lang/String;
        //   433: aload           13
        //   435: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   438: aload           12
        //   440: ifnull          450
        //   443: aload           12
        //   445: invokeinterface android/database/Cursor.close:()V
        //   450: aconst_null    
        //   451: areturn        
        //   452: astore_1       
        //   453: aconst_null    
        //   454: astore          12
        //   456: aload           12
        //   458: ifnull          468
        //   461: aload           12
        //   463: invokeinterface android/database/Cursor.close:()V
        //   468: aload_1        
        //   469: athrow         
        //   470: astore_1       
        //   471: goto            456
        //   474: astore_1       
        //   475: goto            456
        //   478: astore          13
        //   480: goto            411
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  18     123    406    411    Landroid/database/sqlite/SQLiteException;
        //  18     123    452    456    Any
        //  123    131    478    483    Landroid/database/sqlite/SQLiteException;
        //  123    131    470    474    Any
        //  151    181    478    483    Landroid/database/sqlite/SQLiteException;
        //  151    181    470    474    Any
        //  183    383    478    483    Landroid/database/sqlite/SQLiteException;
        //  183    383    470    474    Any
        //  411    438    474    478    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 232 out of bounds for length 232
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final int zzI(final String s, final String s2) {
        zzbo.zzcF(s);
        zzbo.zzcF(s2);
        this.zzjC();
        this.zzkD();
        try {
            return this.getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[] { s, s2 });
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zzd("Error deleting conditional property", zzcfl.zzdZ(s), this.zzwA().zzdY(s2), ex);
            return 0;
        }
    }
    
    final Map<Integer, List<zzcjn>> zzJ(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //     4: aload_0        
        //     5: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     8: aload_1        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_2        
        //    14: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    17: pop            
        //    18: new             Landroid/support/v4/util/ArrayMap;
        //    21: dup            
        //    22: invokespecial   android/support/v4/util/ArrayMap.<init>:()V
        //    25: astore          8
        //    27: aload_0        
        //    28: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    31: astore          5
        //    33: aload           5
        //    35: ldc_w           "event_filters"
        //    38: iconst_2       
        //    39: anewarray       Ljava/lang/String;
        //    42: dup            
        //    43: iconst_0       
        //    44: ldc_w           "audience_id"
        //    47: aastore        
        //    48: dup            
        //    49: iconst_1       
        //    50: ldc_w           "data"
        //    53: aastore        
        //    54: ldc_w           "app_id=? AND event_name=?"
        //    57: iconst_2       
        //    58: anewarray       Ljava/lang/String;
        //    61: dup            
        //    62: iconst_0       
        //    63: aload_1        
        //    64: aastore        
        //    65: dup            
        //    66: iconst_1       
        //    67: aload_2        
        //    68: aastore        
        //    69: aconst_null    
        //    70: aconst_null    
        //    71: aconst_null    
        //    72: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    75: astore          5
        //    77: aload           5
        //    79: astore_2       
        //    80: aload           5
        //    82: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    87: ifne            113
        //    90: aload           5
        //    92: astore_2       
        //    93: invokestatic    java/util/Collections.emptyMap:()Ljava/util/Map;
        //    96: astore          6
        //    98: aload           5
        //   100: ifnull          110
        //   103: aload           5
        //   105: invokeinterface android/database/Cursor.close:()V
        //   110: aload           6
        //   112: areturn        
        //   113: aload           5
        //   115: astore_2       
        //   116: aload           5
        //   118: iconst_1       
        //   119: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   124: astore          6
        //   126: aload           5
        //   128: astore_2       
        //   129: aload           6
        //   131: iconst_0       
        //   132: aload           6
        //   134: arraylength    
        //   135: invokestatic    com/google/android/gms/internal/adg.zzb:([BII)Lcom/google/android/gms/internal/adg;
        //   138: astore          6
        //   140: aload           5
        //   142: astore_2       
        //   143: new             Lcom/google/android/gms/internal/zzcjn;
        //   146: dup            
        //   147: invokespecial   com/google/android/gms/internal/zzcjn.<init>:()V
        //   150: astore          9
        //   152: aload           5
        //   154: astore_2       
        //   155: aload           9
        //   157: aload           6
        //   159: invokevirtual   com/google/android/gms/internal/zzcjn.zza:(Lcom/google/android/gms/internal/adg;)Lcom/google/android/gms/internal/adp;
        //   162: pop            
        //   163: aload           5
        //   165: astore_2       
        //   166: aload           5
        //   168: iconst_0       
        //   169: invokeinterface android/database/Cursor.getInt:(I)I
        //   174: istore_3       
        //   175: aload           5
        //   177: astore_2       
        //   178: aload           8
        //   180: iload_3        
        //   181: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   184: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   189: checkcast       Ljava/util/List;
        //   192: astore          7
        //   194: aload           7
        //   196: astore          6
        //   198: aload           7
        //   200: ifnonnull       232
        //   203: aload           5
        //   205: astore_2       
        //   206: new             Ljava/util/ArrayList;
        //   209: dup            
        //   210: invokespecial   java/util/ArrayList.<init>:()V
        //   213: astore          6
        //   215: aload           5
        //   217: astore_2       
        //   218: aload           8
        //   220: iload_3        
        //   221: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   224: aload           6
        //   226: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   231: pop            
        //   232: aload           5
        //   234: astore_2       
        //   235: aload           6
        //   237: aload           9
        //   239: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   244: pop            
        //   245: aload           5
        //   247: astore_2       
        //   248: aload           5
        //   250: invokeinterface android/database/Cursor.moveToNext:()Z
        //   255: istore          4
        //   257: iload           4
        //   259: ifne            113
        //   262: aload           5
        //   264: ifnull          274
        //   267: aload           5
        //   269: invokeinterface android/database/Cursor.close:()V
        //   274: aload           8
        //   276: areturn        
        //   277: astore          6
        //   279: aload           5
        //   281: astore_2       
        //   282: aload_0        
        //   283: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   286: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   289: ldc_w           "Failed to merge filter. appId"
        //   292: aload_1        
        //   293: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   296: aload           6
        //   298: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   301: goto            245
        //   304: astore          6
        //   306: aload           5
        //   308: astore_2       
        //   309: aload_0        
        //   310: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   313: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   316: ldc_w           "Database error querying filters. appId"
        //   319: aload_1        
        //   320: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   323: aload           6
        //   325: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   328: aload           5
        //   330: ifnull          340
        //   333: aload           5
        //   335: invokeinterface android/database/Cursor.close:()V
        //   340: aconst_null    
        //   341: areturn        
        //   342: astore_1       
        //   343: aconst_null    
        //   344: astore_2       
        //   345: aload_2        
        //   346: ifnull          355
        //   349: aload_2        
        //   350: invokeinterface android/database/Cursor.close:()V
        //   355: aload_1        
        //   356: athrow         
        //   357: astore_1       
        //   358: goto            345
        //   361: astore          6
        //   363: aconst_null    
        //   364: astore          5
        //   366: goto            306
        //    Signature:
        //  (Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map<Ljava/lang/Integer;Ljava/util/List<Lcom/google/android/gms/internal/zzcjn;>;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  33     77     361    369    Landroid/database/sqlite/SQLiteException;
        //  33     77     342    345    Any
        //  80     90     304    306    Landroid/database/sqlite/SQLiteException;
        //  80     90     357    361    Any
        //  93     98     304    306    Landroid/database/sqlite/SQLiteException;
        //  93     98     357    361    Any
        //  116    126    304    306    Landroid/database/sqlite/SQLiteException;
        //  116    126    357    361    Any
        //  129    140    304    306    Landroid/database/sqlite/SQLiteException;
        //  129    140    357    361    Any
        //  143    152    304    306    Landroid/database/sqlite/SQLiteException;
        //  143    152    357    361    Any
        //  155    163    277    304    Ljava/io/IOException;
        //  155    163    304    306    Landroid/database/sqlite/SQLiteException;
        //  155    163    357    361    Any
        //  166    175    304    306    Landroid/database/sqlite/SQLiteException;
        //  166    175    357    361    Any
        //  178    194    304    306    Landroid/database/sqlite/SQLiteException;
        //  178    194    357    361    Any
        //  206    215    304    306    Landroid/database/sqlite/SQLiteException;
        //  206    215    357    361    Any
        //  218    232    304    306    Landroid/database/sqlite/SQLiteException;
        //  218    232    357    361    Any
        //  235    245    304    306    Landroid/database/sqlite/SQLiteException;
        //  235    245    357    361    Any
        //  248    257    304    306    Landroid/database/sqlite/SQLiteException;
        //  248    257    357    361    Any
        //  282    301    304    306    Landroid/database/sqlite/SQLiteException;
        //  282    301    357    361    Any
        //  309    328    357    361    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0110:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    final Map<Integer, List<zzcjq>> zzK(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //     4: aload_0        
        //     5: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     8: aload_1        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_2        
        //    14: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    17: pop            
        //    18: new             Landroid/support/v4/util/ArrayMap;
        //    21: dup            
        //    22: invokespecial   android/support/v4/util/ArrayMap.<init>:()V
        //    25: astore          8
        //    27: aload_0        
        //    28: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    31: astore          5
        //    33: aload           5
        //    35: ldc_w           "property_filters"
        //    38: iconst_2       
        //    39: anewarray       Ljava/lang/String;
        //    42: dup            
        //    43: iconst_0       
        //    44: ldc_w           "audience_id"
        //    47: aastore        
        //    48: dup            
        //    49: iconst_1       
        //    50: ldc_w           "data"
        //    53: aastore        
        //    54: ldc_w           "app_id=? AND property_name=?"
        //    57: iconst_2       
        //    58: anewarray       Ljava/lang/String;
        //    61: dup            
        //    62: iconst_0       
        //    63: aload_1        
        //    64: aastore        
        //    65: dup            
        //    66: iconst_1       
        //    67: aload_2        
        //    68: aastore        
        //    69: aconst_null    
        //    70: aconst_null    
        //    71: aconst_null    
        //    72: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    75: astore          5
        //    77: aload           5
        //    79: astore_2       
        //    80: aload           5
        //    82: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    87: ifne            113
        //    90: aload           5
        //    92: astore_2       
        //    93: invokestatic    java/util/Collections.emptyMap:()Ljava/util/Map;
        //    96: astore          6
        //    98: aload           5
        //   100: ifnull          110
        //   103: aload           5
        //   105: invokeinterface android/database/Cursor.close:()V
        //   110: aload           6
        //   112: areturn        
        //   113: aload           5
        //   115: astore_2       
        //   116: aload           5
        //   118: iconst_1       
        //   119: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   124: astore          6
        //   126: aload           5
        //   128: astore_2       
        //   129: aload           6
        //   131: iconst_0       
        //   132: aload           6
        //   134: arraylength    
        //   135: invokestatic    com/google/android/gms/internal/adg.zzb:([BII)Lcom/google/android/gms/internal/adg;
        //   138: astore          6
        //   140: aload           5
        //   142: astore_2       
        //   143: new             Lcom/google/android/gms/internal/zzcjq;
        //   146: dup            
        //   147: invokespecial   com/google/android/gms/internal/zzcjq.<init>:()V
        //   150: astore          9
        //   152: aload           5
        //   154: astore_2       
        //   155: aload           9
        //   157: aload           6
        //   159: invokevirtual   com/google/android/gms/internal/zzcjq.zza:(Lcom/google/android/gms/internal/adg;)Lcom/google/android/gms/internal/adp;
        //   162: pop            
        //   163: aload           5
        //   165: astore_2       
        //   166: aload           5
        //   168: iconst_0       
        //   169: invokeinterface android/database/Cursor.getInt:(I)I
        //   174: istore_3       
        //   175: aload           5
        //   177: astore_2       
        //   178: aload           8
        //   180: iload_3        
        //   181: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   184: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   189: checkcast       Ljava/util/List;
        //   192: astore          7
        //   194: aload           7
        //   196: astore          6
        //   198: aload           7
        //   200: ifnonnull       232
        //   203: aload           5
        //   205: astore_2       
        //   206: new             Ljava/util/ArrayList;
        //   209: dup            
        //   210: invokespecial   java/util/ArrayList.<init>:()V
        //   213: astore          6
        //   215: aload           5
        //   217: astore_2       
        //   218: aload           8
        //   220: iload_3        
        //   221: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   224: aload           6
        //   226: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   231: pop            
        //   232: aload           5
        //   234: astore_2       
        //   235: aload           6
        //   237: aload           9
        //   239: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   244: pop            
        //   245: aload           5
        //   247: astore_2       
        //   248: aload           5
        //   250: invokeinterface android/database/Cursor.moveToNext:()Z
        //   255: istore          4
        //   257: iload           4
        //   259: ifne            113
        //   262: aload           5
        //   264: ifnull          274
        //   267: aload           5
        //   269: invokeinterface android/database/Cursor.close:()V
        //   274: aload           8
        //   276: areturn        
        //   277: astore          6
        //   279: aload           5
        //   281: astore_2       
        //   282: aload_0        
        //   283: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   286: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   289: ldc_w           "Failed to merge filter"
        //   292: aload_1        
        //   293: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   296: aload           6
        //   298: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   301: goto            245
        //   304: astore          6
        //   306: aload           5
        //   308: astore_2       
        //   309: aload_0        
        //   310: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   313: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   316: ldc_w           "Database error querying filters. appId"
        //   319: aload_1        
        //   320: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   323: aload           6
        //   325: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   328: aload           5
        //   330: ifnull          340
        //   333: aload           5
        //   335: invokeinterface android/database/Cursor.close:()V
        //   340: aconst_null    
        //   341: areturn        
        //   342: astore_1       
        //   343: aconst_null    
        //   344: astore_2       
        //   345: aload_2        
        //   346: ifnull          355
        //   349: aload_2        
        //   350: invokeinterface android/database/Cursor.close:()V
        //   355: aload_1        
        //   356: athrow         
        //   357: astore_1       
        //   358: goto            345
        //   361: astore          6
        //   363: aconst_null    
        //   364: astore          5
        //   366: goto            306
        //    Signature:
        //  (Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map<Ljava/lang/Integer;Ljava/util/List<Lcom/google/android/gms/internal/zzcjq;>;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  33     77     361    369    Landroid/database/sqlite/SQLiteException;
        //  33     77     342    345    Any
        //  80     90     304    306    Landroid/database/sqlite/SQLiteException;
        //  80     90     357    361    Any
        //  93     98     304    306    Landroid/database/sqlite/SQLiteException;
        //  93     98     357    361    Any
        //  116    126    304    306    Landroid/database/sqlite/SQLiteException;
        //  116    126    357    361    Any
        //  129    140    304    306    Landroid/database/sqlite/SQLiteException;
        //  129    140    357    361    Any
        //  143    152    304    306    Landroid/database/sqlite/SQLiteException;
        //  143    152    357    361    Any
        //  155    163    277    304    Ljava/io/IOException;
        //  155    163    304    306    Landroid/database/sqlite/SQLiteException;
        //  155    163    357    361    Any
        //  166    175    304    306    Landroid/database/sqlite/SQLiteException;
        //  166    175    357    361    Any
        //  178    194    304    306    Landroid/database/sqlite/SQLiteException;
        //  178    194    357    361    Any
        //  206    215    304    306    Landroid/database/sqlite/SQLiteException;
        //  206    215    357    361    Any
        //  218    232    304    306    Landroid/database/sqlite/SQLiteException;
        //  218    232    357    361    Any
        //  235    245    304    306    Landroid/database/sqlite/SQLiteException;
        //  235    245    357    361    Any
        //  248    257    304    306    Landroid/database/sqlite/SQLiteException;
        //  248    257    357    361    Any
        //  282    301    304    306    Landroid/database/sqlite/SQLiteException;
        //  282    301    357    361    Any
        //  309    328    357    361    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0110:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    protected final long zzL(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     4: pop            
        //     5: aload_2        
        //     6: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     9: pop            
        //    10: aload_0        
        //    11: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //    14: aload_0        
        //    15: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    18: aload_0        
        //    19: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    22: astore          8
        //    24: aload           8
        //    26: invokevirtual   android/database/sqlite/SQLiteDatabase.beginTransaction:()V
        //    29: aload_0        
        //    30: new             Ljava/lang/StringBuilder;
        //    33: dup            
        //    34: aload_2        
        //    35: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    38: invokevirtual   java/lang/String.length:()I
        //    41: bipush          32
        //    43: iadd           
        //    44: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    47: ldc_w           "select "
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: aload_2        
        //    54: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    57: ldc_w           " from app2 where app_id=?"
        //    60: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    63: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    66: iconst_1       
        //    67: anewarray       Ljava/lang/String;
        //    70: dup            
        //    71: iconst_0       
        //    72: aload_1        
        //    73: aastore        
        //    74: ldc2_w          -1
        //    77: invokespecial   com/google/android/gms/internal/zzcen.zza:(Ljava/lang/String;[Ljava/lang/String;J)J
        //    80: lstore          5
        //    82: lload           5
        //    84: lstore_3       
        //    85: lload           5
        //    87: ldc2_w          -1
        //    90: lcmp           
        //    91: ifne            183
        //    94: new             Landroid/content/ContentValues;
        //    97: dup            
        //    98: invokespecial   android/content/ContentValues.<init>:()V
        //   101: astore          7
        //   103: aload           7
        //   105: ldc_w           "app_id"
        //   108: aload_1        
        //   109: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   112: aload           7
        //   114: ldc_w           "first_open_count"
        //   117: iconst_0       
        //   118: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   121: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   124: aload           7
        //   126: ldc             "previous_install_count"
        //   128: iconst_0       
        //   129: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   132: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   135: aload           8
        //   137: ldc_w           "app2"
        //   140: aconst_null    
        //   141: aload           7
        //   143: iconst_5       
        //   144: invokevirtual   android/database/sqlite/SQLiteDatabase.insertWithOnConflict:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
        //   147: ldc2_w          -1
        //   150: lcmp           
        //   151: ifne            181
        //   154: aload_0        
        //   155: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   158: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   161: ldc_w           "Failed to insert column (got -1). appId"
        //   164: aload_1        
        //   165: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   168: aload_2        
        //   169: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   172: aload           8
        //   174: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   177: ldc2_w          -1
        //   180: lreturn        
        //   181: lconst_0       
        //   182: lstore_3       
        //   183: new             Landroid/content/ContentValues;
        //   186: dup            
        //   187: invokespecial   android/content/ContentValues.<init>:()V
        //   190: astore          7
        //   192: aload           7
        //   194: ldc_w           "app_id"
        //   197: aload_1        
        //   198: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   201: aload           7
        //   203: aload_2        
        //   204: lconst_1       
        //   205: lload_3        
        //   206: ladd           
        //   207: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   210: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   213: aload           8
        //   215: ldc_w           "app2"
        //   218: aload           7
        //   220: ldc_w           "app_id = ?"
        //   223: iconst_1       
        //   224: anewarray       Ljava/lang/String;
        //   227: dup            
        //   228: iconst_0       
        //   229: aload_1        
        //   230: aastore        
        //   231: invokevirtual   android/database/sqlite/SQLiteDatabase.update:(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   234: i2l            
        //   235: lconst_0       
        //   236: lcmp           
        //   237: ifne            267
        //   240: aload_0        
        //   241: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   244: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   247: ldc_w           "Failed to update column (got 0). appId"
        //   250: aload_1        
        //   251: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   254: aload_2        
        //   255: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   258: aload           8
        //   260: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   263: ldc2_w          -1
        //   266: lreturn        
        //   267: aload           8
        //   269: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //   272: aload           8
        //   274: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   277: lload_3        
        //   278: lreturn        
        //   279: astore          7
        //   281: lconst_0       
        //   282: lstore_3       
        //   283: aload_0        
        //   284: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   287: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   290: ldc_w           "Error inserting column. appId"
        //   293: aload_1        
        //   294: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   297: aload_2        
        //   298: aload           7
        //   300: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   303: aload           8
        //   305: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   308: lload_3        
        //   309: lreturn        
        //   310: astore_1       
        //   311: aload           8
        //   313: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   316: aload_1        
        //   317: athrow         
        //   318: astore          7
        //   320: goto            283
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  29     82     279    283    Landroid/database/sqlite/SQLiteException;
        //  29     82     310    318    Any
        //  94     172    279    283    Landroid/database/sqlite/SQLiteException;
        //  94     172    310    318    Any
        //  183    258    318    323    Landroid/database/sqlite/SQLiteException;
        //  183    258    310    318    Any
        //  267    272    318    323    Landroid/database/sqlite/SQLiteException;
        //  267    272    310    318    Any
        //  283    303    310    318    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0183:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final long zza(final zzcjz zzcjz) throws IOException {
        this.zzjC();
        this.zzkD();
        zzbo.zzu(zzcjz);
        zzbo.zzcF(zzcjz.zzaH);
        while (true) {
            Label_0184: {
                long zzn;
                ContentValues contentValues;
                try {
                    final byte[] input = new byte[zzcjz.zzLV()];
                    final adh zzc = adh.zzc(input, 0, input.length);
                    zzcjz.zza(zzc);
                    zzc.zzLM();
                    final zzcjl zzwB = this.zzwB();
                    zzbo.zzu(input);
                    zzwB.zzjC();
                    final MessageDigest zzbE = zzcjl.zzbE("MD5");
                    if (zzbE == null) {
                        zzwB.zzwF().zzyx().log("Failed to get MD5");
                        zzn = 0L;
                        contentValues = new ContentValues();
                        contentValues.put("app_id", zzcjz.zzaH);
                        contentValues.put("metadata_fingerprint", Long.valueOf(zzn));
                        contentValues.put("metadata", input);
                        final zzcen zzcen = this;
                        final SQLiteDatabase sqLiteDatabase = zzcen.getWritableDatabase();
                        final String s = "raw_events_metadata";
                        final String s2 = null;
                        final ContentValues contentValues2 = contentValues;
                        final int n = 4;
                        sqLiteDatabase.insertWithOnConflict(s, s2, contentValues2, n);
                        return zzn;
                    }
                    break Label_0184;
                }
                catch (IOException ex) {
                    this.zzwF().zzyx().zze("Data loss. Failed to serialize event metadata. appId", zzcfl.zzdZ(zzcjz.zzaH), ex);
                    throw ex;
                }
                try {
                    final zzcen zzcen = this;
                    final SQLiteDatabase sqLiteDatabase = zzcen.getWritableDatabase();
                    final String s = "raw_events_metadata";
                    final String s2 = null;
                    final ContentValues contentValues2 = contentValues;
                    final int n = 4;
                    sqLiteDatabase.insertWithOnConflict(s, s2, contentValues2, n);
                    return zzn;
                    final byte[] input;
                    final MessageDigest zzbE;
                    zzn = zzcjl.zzn(zzbE.digest(input));
                    continue;
                }
                catch (SQLiteException ex2) {
                    this.zzwF().zzyx().zze("Error storing raw event metadata. appId", zzcfl.zzdZ(zzcjz.zzaH), ex2);
                    throw ex2;
                }
            }
            break;
        }
    }
    
    @WorkerThread
    public final zzceo zza(final long p0, final String p1, final boolean p2, final boolean p3, final boolean p4, final boolean p5, final boolean p6) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     4: pop            
        //     5: aload_0        
        //     6: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     9: aload_0        
        //    10: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    13: new             Lcom/google/android/gms/internal/zzceo;
        //    16: dup            
        //    17: invokespecial   com/google/android/gms/internal/zzceo.<init>:()V
        //    20: astore          12
        //    22: aload_0        
        //    23: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    26: astore          11
        //    28: aload           11
        //    30: ldc_w           "apps"
        //    33: bipush          6
        //    35: anewarray       Ljava/lang/String;
        //    38: dup            
        //    39: iconst_0       
        //    40: ldc             "day"
        //    42: aastore        
        //    43: dup            
        //    44: iconst_1       
        //    45: ldc             "daily_events_count"
        //    47: aastore        
        //    48: dup            
        //    49: iconst_2       
        //    50: ldc             "daily_public_events_count"
        //    52: aastore        
        //    53: dup            
        //    54: iconst_3       
        //    55: ldc             "daily_conversions_count"
        //    57: aastore        
        //    58: dup            
        //    59: iconst_4       
        //    60: ldc             "daily_error_events_count"
        //    62: aastore        
        //    63: dup            
        //    64: iconst_5       
        //    65: ldc             "daily_realtime_events_count"
        //    67: aastore        
        //    68: ldc_w           "app_id=?"
        //    71: iconst_1       
        //    72: anewarray       Ljava/lang/String;
        //    75: dup            
        //    76: iconst_0       
        //    77: aload_3        
        //    78: aastore        
        //    79: aconst_null    
        //    80: aconst_null    
        //    81: aconst_null    
        //    82: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    85: astore          10
        //    87: aload           10
        //    89: astore          9
        //    91: aload           10
        //    93: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    98: ifne            137
        //   101: aload           10
        //   103: astore          9
        //   105: aload_0        
        //   106: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   109: invokevirtual   com/google/android/gms/internal/zzcfl.zzyz:()Lcom/google/android/gms/internal/zzcfn;
        //   112: ldc_w           "Not updating daily counts, app is not known. appId"
        //   115: aload_3        
        //   116: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   119: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   122: aload           10
        //   124: ifnull          134
        //   127: aload           10
        //   129: invokeinterface android/database/Cursor.close:()V
        //   134: aload           12
        //   136: areturn        
        //   137: aload           10
        //   139: astore          9
        //   141: aload           10
        //   143: iconst_0       
        //   144: invokeinterface android/database/Cursor.getLong:(I)J
        //   149: lload_1        
        //   150: lcmp           
        //   151: ifne            239
        //   154: aload           10
        //   156: astore          9
        //   158: aload           12
        //   160: aload           10
        //   162: iconst_1       
        //   163: invokeinterface android/database/Cursor.getLong:(I)J
        //   168: putfield        com/google/android/gms/internal/zzceo.zzbpv:J
        //   171: aload           10
        //   173: astore          9
        //   175: aload           12
        //   177: aload           10
        //   179: iconst_2       
        //   180: invokeinterface android/database/Cursor.getLong:(I)J
        //   185: putfield        com/google/android/gms/internal/zzceo.zzbpu:J
        //   188: aload           10
        //   190: astore          9
        //   192: aload           12
        //   194: aload           10
        //   196: iconst_3       
        //   197: invokeinterface android/database/Cursor.getLong:(I)J
        //   202: putfield        com/google/android/gms/internal/zzceo.zzbpw:J
        //   205: aload           10
        //   207: astore          9
        //   209: aload           12
        //   211: aload           10
        //   213: iconst_4       
        //   214: invokeinterface android/database/Cursor.getLong:(I)J
        //   219: putfield        com/google/android/gms/internal/zzceo.zzbpx:J
        //   222: aload           10
        //   224: astore          9
        //   226: aload           12
        //   228: aload           10
        //   230: iconst_5       
        //   231: invokeinterface android/database/Cursor.getLong:(I)J
        //   236: putfield        com/google/android/gms/internal/zzceo.zzbpy:J
        //   239: iload           4
        //   241: ifeq            260
        //   244: aload           10
        //   246: astore          9
        //   248: aload           12
        //   250: aload           12
        //   252: getfield        com/google/android/gms/internal/zzceo.zzbpv:J
        //   255: lconst_1       
        //   256: ladd           
        //   257: putfield        com/google/android/gms/internal/zzceo.zzbpv:J
        //   260: iload           5
        //   262: ifeq            281
        //   265: aload           10
        //   267: astore          9
        //   269: aload           12
        //   271: aload           12
        //   273: getfield        com/google/android/gms/internal/zzceo.zzbpu:J
        //   276: lconst_1       
        //   277: ladd           
        //   278: putfield        com/google/android/gms/internal/zzceo.zzbpu:J
        //   281: iload           6
        //   283: ifeq            302
        //   286: aload           10
        //   288: astore          9
        //   290: aload           12
        //   292: aload           12
        //   294: getfield        com/google/android/gms/internal/zzceo.zzbpw:J
        //   297: lconst_1       
        //   298: ladd           
        //   299: putfield        com/google/android/gms/internal/zzceo.zzbpw:J
        //   302: iload           7
        //   304: ifeq            323
        //   307: aload           10
        //   309: astore          9
        //   311: aload           12
        //   313: aload           12
        //   315: getfield        com/google/android/gms/internal/zzceo.zzbpx:J
        //   318: lconst_1       
        //   319: ladd           
        //   320: putfield        com/google/android/gms/internal/zzceo.zzbpx:J
        //   323: iload           8
        //   325: ifeq            344
        //   328: aload           10
        //   330: astore          9
        //   332: aload           12
        //   334: aload           12
        //   336: getfield        com/google/android/gms/internal/zzceo.zzbpy:J
        //   339: lconst_1       
        //   340: ladd           
        //   341: putfield        com/google/android/gms/internal/zzceo.zzbpy:J
        //   344: aload           10
        //   346: astore          9
        //   348: new             Landroid/content/ContentValues;
        //   351: dup            
        //   352: invokespecial   android/content/ContentValues.<init>:()V
        //   355: astore          13
        //   357: aload           10
        //   359: astore          9
        //   361: aload           13
        //   363: ldc             "day"
        //   365: lload_1        
        //   366: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   369: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   372: aload           10
        //   374: astore          9
        //   376: aload           13
        //   378: ldc             "daily_public_events_count"
        //   380: aload           12
        //   382: getfield        com/google/android/gms/internal/zzceo.zzbpu:J
        //   385: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   388: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   391: aload           10
        //   393: astore          9
        //   395: aload           13
        //   397: ldc             "daily_events_count"
        //   399: aload           12
        //   401: getfield        com/google/android/gms/internal/zzceo.zzbpv:J
        //   404: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   407: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   410: aload           10
        //   412: astore          9
        //   414: aload           13
        //   416: ldc             "daily_conversions_count"
        //   418: aload           12
        //   420: getfield        com/google/android/gms/internal/zzceo.zzbpw:J
        //   423: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   426: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   429: aload           10
        //   431: astore          9
        //   433: aload           13
        //   435: ldc             "daily_error_events_count"
        //   437: aload           12
        //   439: getfield        com/google/android/gms/internal/zzceo.zzbpx:J
        //   442: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   445: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   448: aload           10
        //   450: astore          9
        //   452: aload           13
        //   454: ldc             "daily_realtime_events_count"
        //   456: aload           12
        //   458: getfield        com/google/android/gms/internal/zzceo.zzbpy:J
        //   461: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   464: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   467: aload           10
        //   469: astore          9
        //   471: aload           11
        //   473: ldc_w           "apps"
        //   476: aload           13
        //   478: ldc_w           "app_id=?"
        //   481: iconst_1       
        //   482: anewarray       Ljava/lang/String;
        //   485: dup            
        //   486: iconst_0       
        //   487: aload_3        
        //   488: aastore        
        //   489: invokevirtual   android/database/sqlite/SQLiteDatabase.update:(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   492: pop            
        //   493: aload           10
        //   495: ifnull          505
        //   498: aload           10
        //   500: invokeinterface android/database/Cursor.close:()V
        //   505: aload           12
        //   507: areturn        
        //   508: astore          11
        //   510: aconst_null    
        //   511: astore          10
        //   513: aload           10
        //   515: astore          9
        //   517: aload_0        
        //   518: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   521: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   524: ldc_w           "Error updating daily counts. appId"
        //   527: aload_3        
        //   528: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   531: aload           11
        //   533: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   536: aload           10
        //   538: ifnull          548
        //   541: aload           10
        //   543: invokeinterface android/database/Cursor.close:()V
        //   548: aload           12
        //   550: areturn        
        //   551: astore_3       
        //   552: aconst_null    
        //   553: astore          9
        //   555: aload           9
        //   557: ifnull          567
        //   560: aload           9
        //   562: invokeinterface android/database/Cursor.close:()V
        //   567: aload_3        
        //   568: athrow         
        //   569: astore_3       
        //   570: goto            555
        //   573: astore          11
        //   575: goto            513
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  22     87     508    513    Landroid/database/sqlite/SQLiteException;
        //  22     87     551    555    Any
        //  91     101    573    578    Landroid/database/sqlite/SQLiteException;
        //  91     101    569    573    Any
        //  105    122    573    578    Landroid/database/sqlite/SQLiteException;
        //  105    122    569    573    Any
        //  141    154    573    578    Landroid/database/sqlite/SQLiteException;
        //  141    154    569    573    Any
        //  158    171    573    578    Landroid/database/sqlite/SQLiteException;
        //  158    171    569    573    Any
        //  175    188    573    578    Landroid/database/sqlite/SQLiteException;
        //  175    188    569    573    Any
        //  192    205    573    578    Landroid/database/sqlite/SQLiteException;
        //  192    205    569    573    Any
        //  209    222    573    578    Landroid/database/sqlite/SQLiteException;
        //  209    222    569    573    Any
        //  226    239    573    578    Landroid/database/sqlite/SQLiteException;
        //  226    239    569    573    Any
        //  248    260    573    578    Landroid/database/sqlite/SQLiteException;
        //  248    260    569    573    Any
        //  269    281    573    578    Landroid/database/sqlite/SQLiteException;
        //  269    281    569    573    Any
        //  290    302    573    578    Landroid/database/sqlite/SQLiteException;
        //  290    302    569    573    Any
        //  311    323    573    578    Landroid/database/sqlite/SQLiteException;
        //  311    323    569    573    Any
        //  332    344    573    578    Landroid/database/sqlite/SQLiteException;
        //  332    344    569    573    Any
        //  348    357    573    578    Landroid/database/sqlite/SQLiteException;
        //  348    357    569    573    Any
        //  361    372    573    578    Landroid/database/sqlite/SQLiteException;
        //  361    372    569    573    Any
        //  376    391    573    578    Landroid/database/sqlite/SQLiteException;
        //  376    391    569    573    Any
        //  395    410    573    578    Landroid/database/sqlite/SQLiteException;
        //  395    410    569    573    Any
        //  414    429    573    578    Landroid/database/sqlite/SQLiteException;
        //  414    429    569    573    Any
        //  433    448    573    578    Landroid/database/sqlite/SQLiteException;
        //  433    448    569    573    Any
        //  452    467    573    578    Landroid/database/sqlite/SQLiteException;
        //  452    467    569    573    Any
        //  471    493    573    578    Landroid/database/sqlite/SQLiteException;
        //  471    493    569    573    Any
        //  517    536    569    573    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0134:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final void zza(final zzceg zzceg) {
        zzbo.zzu(zzceg);
        this.zzjC();
        this.zzkD();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzceg.zzhl());
        contentValues.put("app_instance_id", zzceg.getAppInstanceId());
        contentValues.put("gmp_app_id", zzceg.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzceg.zzwJ());
        contentValues.put("last_bundle_index", Long.valueOf(zzceg.zzwS()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzceg.zzwL()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzceg.zzwM()));
        contentValues.put("app_version", zzceg.zzjH());
        contentValues.put("app_store", zzceg.zzwO());
        contentValues.put("gmp_version", Long.valueOf(zzceg.zzwP()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzceg.zzwQ()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzceg.zzwR()));
        contentValues.put("day", Long.valueOf(zzceg.zzwW()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzceg.zzwX()));
        contentValues.put("daily_events_count", Long.valueOf(zzceg.zzwY()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzceg.zzwZ()));
        contentValues.put("config_fetched_time", Long.valueOf(zzceg.zzwT()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzceg.zzwU()));
        contentValues.put("app_version_int", Long.valueOf(zzceg.zzwN()));
        contentValues.put("firebase_instance_id", zzceg.zzwK());
        contentValues.put("daily_error_events_count", Long.valueOf(zzceg.zzxb()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzceg.zzxa()));
        contentValues.put("health_monitor_sample", zzceg.zzxc());
        contentValues.put("android_id", Long.valueOf(zzceg.zzxe()));
        try {
            final SQLiteDatabase writableDatabase = this.getWritableDatabase();
            if (writableDatabase.update("apps", contentValues, "app_id = ?", new String[] { zzceg.zzhl() }) == 0L && writableDatabase.insertWithOnConflict("apps", (String)null, contentValues, 5) == -1L) {
                this.zzwF().zzyx().zzj("Failed to insert/update app (got -1). appId", zzcfl.zzdZ(zzceg.zzhl()));
            }
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zze("Error storing app. appId", zzcfl.zzdZ(zzceg.zzhl()), ex);
        }
    }
    
    @WorkerThread
    public final void zza(final zzcev zzcev) {
        zzbo.zzu(zzcev);
        this.zzjC();
        this.zzkD();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcev.mAppId);
        contentValues.put("name", zzcev.mName);
        contentValues.put("lifetime_count", Long.valueOf(zzcev.zzbpG));
        contentValues.put("current_bundle_count", Long.valueOf(zzcev.zzbpH));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzcev.zzbpI));
        try {
            if (this.getWritableDatabase().insertWithOnConflict("events", (String)null, contentValues, 5) == -1L) {
                this.zzwF().zzyx().zzj("Failed to insert/update event aggregates (got -1). appId", zzcfl.zzdZ(zzcev.mAppId));
            }
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zze("Error storing event aggregates. appId", zzcfl.zzdZ(zzcev.mAppId), ex);
        }
    }
    
    @WorkerThread
    final void zza(final String s, final zzcjm[] array) {
        int n;
        SQLiteDatabase writableDatabase;
        while (true) {
            n = 0;
            this.zzkD();
            this.zzjC();
            zzbo.zzcF(s);
            zzbo.zzu(array);
            writableDatabase = this.getWritableDatabase();
            writableDatabase.beginTransaction();
        Label_0347_Outer:
            while (true) {
                int n2 = 0;
                Label_0547: {
                    Object o = null;
                    int intValue = 0;
                Label_0256:
                    while (true) {
                        int i;
                        try {
                            this.zzkD();
                            this.zzjC();
                            zzbo.zzcF(s);
                            o = this.getWritableDatabase();
                            ((SQLiteDatabase)o).delete("property_filters", "app_id=?", new String[] { s });
                            ((SQLiteDatabase)o).delete("event_filters", "app_id=?", new String[] { s });
                            final int length = array.length;
                            n2 = 0;
                            if (n2 >= length) {
                                break;
                            }
                            o = array[n2];
                            this.zzkD();
                            this.zzjC();
                            zzbo.zzcF(s);
                            zzbo.zzu(o);
                            zzbo.zzu(((zzcjm)o).zzbuK);
                            zzbo.zzu(((zzcjm)o).zzbuJ);
                            if (((zzcjm)o).zzbuI == null) {
                                this.zzwF().zzyz().zzj("Audience with no ID. appId", zzcfl.zzdZ(s));
                                break Label_0547;
                            }
                            intValue = ((zzcjm)o).zzbuI;
                            final adp[] array2 = ((zzcjm)o).zzbuK;
                            final int n3 = array2.length;
                            i = 0;
                            if (i >= n3) {
                                break Label_0256;
                            }
                            if (((zzcjn)array2[i]).zzbuM == null) {
                                this.zzwF().zzyz().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzcfl.zzdZ(s), ((zzcjm)o).zzbuI);
                                break Label_0547;
                            }
                        }
                        finally {
                            writableDatabase.endTransaction();
                        }
                        ++i;
                        continue Label_0347_Outer;
                    }
                    adp[] array2 = ((zzcjm)o).zzbuJ;
                    int n3;
                    for (n3 = array2.length, int i = 0; i < n3; ++i) {
                        if (((zzcjq)array2[i]).zzbuM == null) {
                            this.zzwF().zzyz().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzcfl.zzdZ(s), ((zzcjm)o).zzbuI);
                            break Label_0547;
                        }
                    }
                    array2 = ((zzcjm)o).zzbuK;
                    n3 = array2.length;
                    int j = 0;
                    while (true) {
                        while (j < n3) {
                            if (!this.zza(s, intValue, (zzcjn)array2[j])) {
                                final int i = 0;
                                int n4 = i;
                                if (i != 0) {
                                    o = ((zzcjm)o).zzbuJ;
                                    final int length2 = ((zzcjm)o).length;
                                    n3 = 0;
                                    while (true) {
                                        n4 = i;
                                        if (n3 >= length2) {
                                            break;
                                        }
                                        if (!this.zza(s, intValue, o[n3])) {
                                            n4 = 0;
                                            break;
                                        }
                                        ++n3;
                                    }
                                }
                                if (n4 == 0) {
                                    this.zzkD();
                                    this.zzjC();
                                    zzbo.zzcF(s);
                                    o = this.getWritableDatabase();
                                    ((SQLiteDatabase)o).delete("property_filters", "app_id=? and audience_id=?", new String[] { s, String.valueOf(intValue) });
                                    ((SQLiteDatabase)o).delete("event_filters", "app_id=? and audience_id=?", new String[] { s, String.valueOf(intValue) });
                                }
                                break Label_0547;
                            }
                            else {
                                ++j;
                            }
                        }
                        final int i = 1;
                        continue;
                    }
                }
                ++n2;
                continue;
            }
        }
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int length3 = array.length, k = n; k < length3; ++k) {
            list.add(array[k].zzbuI);
        }
        this.zzc(s, list);
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }
    
    @WorkerThread
    public final boolean zza(final zzcek zzcek) {
        zzbo.zzu(zzcek);
        this.zzjC();
        this.zzkD();
        if (this.zzG(zzcek.packageName, zzcek.zzbpd.name) == null) {
            final long zzb = this.zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[] { zzcek.packageName });
            zzcem.zzxv();
            if (zzb >= 1000L) {
                return false;
            }
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcek.packageName);
        contentValues.put("origin", zzcek.zzbpc);
        contentValues.put("name", zzcek.zzbpd.name);
        zza(contentValues, "value", zzcek.zzbpd.getValue());
        contentValues.put("active", Boolean.valueOf(zzcek.zzbpf));
        contentValues.put("trigger_event_name", zzcek.zzbpg);
        contentValues.put("trigger_timeout", Long.valueOf(zzcek.zzbpi));
        this.zzwB();
        contentValues.put("timed_out_event", zzcjl.zza((Parcelable)zzcek.zzbph));
        contentValues.put("creation_timestamp", Long.valueOf(zzcek.zzbpe));
        this.zzwB();
        contentValues.put("triggered_event", zzcjl.zza((Parcelable)zzcek.zzbpj));
        contentValues.put("triggered_timestamp", Long.valueOf(zzcek.zzbpd.zzbuy));
        contentValues.put("time_to_live", Long.valueOf(zzcek.zzbpk));
        this.zzwB();
        contentValues.put("expired_event", zzcjl.zza((Parcelable)zzcek.zzbpl));
        try {
            if (this.getWritableDatabase().insertWithOnConflict("conditional_properties", (String)null, contentValues, 5) == -1L) {
                this.zzwF().zzyx().zzj("Failed to insert/update conditional user property (got -1)", zzcfl.zzdZ(zzcek.packageName));
            }
            return true;
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zze("Error storing conditional user property", zzcfl.zzdZ(zzcek.packageName), ex);
            return true;
        }
    }
    
    public final boolean zza(final zzceu zzceu, final long l, final boolean b) {
        this.zzjC();
        this.zzkD();
        zzbo.zzu(zzceu);
        zzbo.zzcF(zzceu.mAppId);
        final zzcjw zzcjw = new zzcjw();
        zzcjw.zzbvy = zzceu.zzbpE;
        zzcjw.zzbvw = new zzcjx[zzceu.zzbpF.size()];
        final Iterator<String> iterator = zzceu.zzbpF.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final String name = iterator.next();
            final zzcjx zzcjx = new zzcjx();
            zzcjw.zzbvw[n] = zzcjx;
            zzcjx.name = name;
            this.zzwB().zza(zzcjx, zzceu.zzbpF.get(name));
            ++n;
        }
        Label_0368: {
            while (true) {
                ContentValues contentValues;
                try {
                    final byte[] array = new byte[zzcjw.zzLV()];
                    final adh zzc = adh.zzc(array, 0, array.length);
                    zzcjw.zza(zzc);
                    zzc.zzLM();
                    this.zzwF().zzyD().zze("Saving event, name, data size", this.zzwA().zzdW(zzceu.mName), array.length);
                    contentValues = new ContentValues();
                    contentValues.put("app_id", zzceu.mAppId);
                    contentValues.put("name", zzceu.mName);
                    contentValues.put("timestamp", Long.valueOf(zzceu.zzayS));
                    contentValues.put("metadata_fingerprint", Long.valueOf(l));
                    contentValues.put("data", array);
                    if (!b) {
                        break Label_0368;
                    }
                    final int i = 1;
                    contentValues.put("realtime", Integer.valueOf(i));
                    final zzcen zzcen = this;
                    final SQLiteDatabase sqLiteDatabase = zzcen.getWritableDatabase();
                    final String s = "raw_events";
                    final String s2 = null;
                    final ContentValues contentValues2 = contentValues;
                    final long n2 = sqLiteDatabase.insert(s, s2, contentValues2);
                    final long n3 = -1L;
                    final long n4 = lcmp(n2, n3);
                    if (n4 == 0) {
                        final zzcen zzcen2 = this;
                        final zzcfl zzcfl = zzcen2.zzwF();
                        final zzcfn zzcfn = zzcfl.zzyx();
                        final String s3 = "Failed to insert raw event (got -1). appId";
                        final zzceu zzceu2 = zzceu;
                        final String s4 = zzceu2.mAppId;
                        final Object o = com.google.android.gms.internal.zzcfl.zzdZ(s4);
                        zzcfn.zzj(s3, o);
                        return false;
                    }
                    return true;
                }
                catch (IOException ex) {
                    this.zzwF().zzyx().zze("Data loss. Failed to serialize event params/data. appId", zzcfl.zzdZ(zzceu.mAppId), ex);
                    return false;
                }
                try {
                    final zzcen zzcen = this;
                    final SQLiteDatabase sqLiteDatabase = zzcen.getWritableDatabase();
                    final String s = "raw_events";
                    final String s2 = null;
                    final ContentValues contentValues2 = contentValues;
                    final long n2 = sqLiteDatabase.insert(s, s2, contentValues2);
                    final long n3 = -1L;
                    final long n4 = lcmp(n2, n3);
                    if (n4 == 0) {
                        final zzcen zzcen2 = this;
                        final zzcfl zzcfl = zzcen2.zzwF();
                        final zzcfn zzcfn = zzcfl.zzyx();
                        final String s3 = "Failed to insert raw event (got -1). appId";
                        final zzceu zzceu2 = zzceu;
                        final String s4 = zzceu2.mAppId;
                        final Object o = com.google.android.gms.internal.zzcfl.zzdZ(s4);
                        zzcfn.zzj(s3, o);
                        return false;
                    }
                    return true;
                    final int i = 0;
                    continue;
                }
                catch (SQLiteException ex2) {
                    this.zzwF().zzyx().zze("Error storing raw event. appId", zzcfl.zzdZ(zzceu.mAppId), ex2);
                    return false;
                }
                break;
            }
        }
        return true;
    }
    
    @WorkerThread
    public final boolean zza(final zzcjk zzcjk) {
        zzbo.zzu(zzcjk);
        this.zzjC();
        this.zzkD();
        Label_0109: {
            if (this.zzG(zzcjk.mAppId, zzcjk.mName) == null) {
                if (zzcjl.zzeo(zzcjk.mName)) {
                    final long zzb = this.zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { zzcjk.mAppId });
                    zzcem.zzxs();
                    if (zzb < 25L) {
                        break Label_0109;
                    }
                }
                else {
                    final long zzb2 = this.zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { zzcjk.mAppId, zzcjk.mOrigin });
                    zzcem.zzxu();
                    if (zzb2 < 25L) {
                        break Label_0109;
                    }
                }
                return false;
            }
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcjk.mAppId);
        contentValues.put("origin", zzcjk.mOrigin);
        contentValues.put("name", zzcjk.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzcjk.zzbuC));
        zza(contentValues, "value", zzcjk.mValue);
        try {
            if (this.getWritableDatabase().insertWithOnConflict("user_attributes", (String)null, contentValues, 5) == -1L) {
                this.zzwF().zzyx().zzj("Failed to insert/update user property (got -1). appId", zzcfl.zzdZ(zzcjk.mAppId));
            }
            return true;
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zze("Error storing user property. appId", zzcfl.zzdZ(zzcjk.mAppId), ex);
            return true;
        }
    }
    
    @WorkerThread
    public final boolean zza(final zzcjz zzcjz, final boolean b) {
        this.zzjC();
        this.zzkD();
        zzbo.zzu(zzcjz);
        zzbo.zzcF(zzcjz.zzaH);
        zzbo.zzu(zzcjz.zzbvI);
        this.zzye();
        final long currentTimeMillis = this.zzkq().currentTimeMillis();
        if (zzcjz.zzbvI < currentTimeMillis - zzcem.zzxG() || zzcjz.zzbvI > zzcem.zzxG() + currentTimeMillis) {
            this.zzwF().zzyz().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzcfl.zzdZ(zzcjz.zzaH), currentTimeMillis, zzcjz.zzbvI);
        }
        Label_0295: {
            while (true) {
                ContentValues contentValues;
                try {
                    final byte[] array = new byte[zzcjz.zzLV()];
                    final adh zzc = adh.zzc(array, 0, array.length);
                    zzcjz.zza(zzc);
                    zzc.zzLM();
                    final byte[] zzl = this.zzwB().zzl(array);
                    this.zzwF().zzyD().zzj("Saving bundle, size", zzl.length);
                    contentValues = new ContentValues();
                    contentValues.put("app_id", zzcjz.zzaH);
                    contentValues.put("bundle_end_timestamp", zzcjz.zzbvI);
                    contentValues.put("data", zzl);
                    if (!b) {
                        break Label_0295;
                    }
                    final int i = 1;
                    contentValues.put("has_realtime", Integer.valueOf(i));
                    final zzcen zzcen = this;
                    final SQLiteDatabase sqLiteDatabase = zzcen.getWritableDatabase();
                    final String s = "queue";
                    final String s2 = null;
                    final ContentValues contentValues2 = contentValues;
                    final long n = sqLiteDatabase.insert(s, s2, contentValues2);
                    final long n2 = -1L;
                    final long n3 = lcmp(n, n2);
                    if (n3 == 0) {
                        final zzcen zzcen2 = this;
                        final zzcfl zzcfl = zzcen2.zzwF();
                        final zzcfn zzcfn = zzcfl.zzyx();
                        final String s3 = "Failed to insert bundle (got -1). appId";
                        final zzcjz zzcjz2 = zzcjz;
                        final String s4 = zzcjz2.zzaH;
                        final Object o = com.google.android.gms.internal.zzcfl.zzdZ(s4);
                        zzcfn.zzj(s3, o);
                        return false;
                    }
                    return true;
                }
                catch (IOException ex) {
                    this.zzwF().zzyx().zze("Data loss. Failed to serialize bundle. appId", zzcfl.zzdZ(zzcjz.zzaH), ex);
                    return false;
                }
                try {
                    final zzcen zzcen = this;
                    final SQLiteDatabase sqLiteDatabase = zzcen.getWritableDatabase();
                    final String s = "queue";
                    final String s2 = null;
                    final ContentValues contentValues2 = contentValues;
                    final long n = sqLiteDatabase.insert(s, s2, contentValues2);
                    final long n2 = -1L;
                    final long n3 = lcmp(n, n2);
                    if (n3 == 0) {
                        final zzcen zzcen2 = this;
                        final zzcfl zzcfl = zzcen2.zzwF();
                        final zzcfn zzcfn = zzcfl.zzyx();
                        final String s3 = "Failed to insert bundle (got -1). appId";
                        final zzcjz zzcjz2 = zzcjz;
                        final String s4 = zzcjz2.zzaH;
                        final Object o = com.google.android.gms.internal.zzcfl.zzdZ(s4);
                        zzcfn.zzj(s3, o);
                        return false;
                    }
                    return true;
                    final int i = 0;
                    continue;
                }
                catch (SQLiteException ex2) {
                    this.zzwF().zzyx().zze("Error storing bundle. appId", zzcfl.zzdZ(zzcjz.zzaH), ex2);
                    return false;
                }
                break;
            }
        }
        return true;
    }
    
    public final String zzaa(final long p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          6
        //     3: aload_0        
        //     4: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     7: aload_0        
        //     8: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    11: aload_0        
        //    12: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    15: ldc_w           "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
        //    18: iconst_1       
        //    19: anewarray       Ljava/lang/String;
        //    22: dup            
        //    23: iconst_0       
        //    24: lload_1        
        //    25: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //    28: aastore        
        //    29: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    32: astore_3       
        //    33: aload_3        
        //    34: astore          4
        //    36: aload_3        
        //    37: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    42: ifne            82
        //    45: aload_3        
        //    46: astore          4
        //    48: aload_0        
        //    49: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //    52: invokevirtual   com/google/android/gms/internal/zzcfl.zzyD:()Lcom/google/android/gms/internal/zzcfn;
        //    55: ldc_w           "No expired configs for apps with pending events"
        //    58: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //    61: aload           6
        //    63: astore          4
        //    65: aload_3        
        //    66: ifnull          79
        //    69: aload_3        
        //    70: invokeinterface android/database/Cursor.close:()V
        //    75: aload           6
        //    77: astore          4
        //    79: aload           4
        //    81: areturn        
        //    82: aload_3        
        //    83: astore          4
        //    85: aload_3        
        //    86: iconst_0       
        //    87: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    92: astore          5
        //    94: aload           5
        //    96: astore          4
        //    98: aload_3        
        //    99: ifnull          79
        //   102: aload_3        
        //   103: invokeinterface android/database/Cursor.close:()V
        //   108: aload           5
        //   110: areturn        
        //   111: astore          5
        //   113: aconst_null    
        //   114: astore_3       
        //   115: aload_3        
        //   116: astore          4
        //   118: aload_0        
        //   119: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   122: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   125: ldc_w           "Error selecting expired configs"
        //   128: aload           5
        //   130: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   133: aload           6
        //   135: astore          4
        //   137: aload_3        
        //   138: ifnull          79
        //   141: aload_3        
        //   142: invokeinterface android/database/Cursor.close:()V
        //   147: aconst_null    
        //   148: areturn        
        //   149: astore_3       
        //   150: aconst_null    
        //   151: astore          4
        //   153: aload           4
        //   155: ifnull          165
        //   158: aload           4
        //   160: invokeinterface android/database/Cursor.close:()V
        //   165: aload_3        
        //   166: athrow         
        //   167: astore_3       
        //   168: goto            153
        //   171: astore          5
        //   173: goto            115
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  11     33     111    115    Landroid/database/sqlite/SQLiteException;
        //  11     33     149    153    Any
        //  36     45     171    176    Landroid/database/sqlite/SQLiteException;
        //  36     45     167    171    Any
        //  48     61     171    176    Landroid/database/sqlite/SQLiteException;
        //  48     61     167    171    Any
        //  85     94     171    176    Landroid/database/sqlite/SQLiteException;
        //  85     94     167    171    Any
        //  118    133    167    171    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final List<zzcek> zzc(final String p0, final String[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     4: aload_0        
        //     5: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //     8: new             Ljava/util/ArrayList;
        //    11: dup            
        //    12: invokespecial   java/util/ArrayList.<init>:()V
        //    15: astore          12
        //    17: aload_0        
        //    18: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    21: astore          13
        //    23: invokestatic    com/google/android/gms/internal/zzcem.zzxv:()I
        //    26: pop            
        //    27: aload           13
        //    29: ldc_w           "conditional_properties"
        //    32: bipush          13
        //    34: anewarray       Ljava/lang/String;
        //    37: dup            
        //    38: iconst_0       
        //    39: ldc_w           "app_id"
        //    42: aastore        
        //    43: dup            
        //    44: iconst_1       
        //    45: ldc             "origin"
        //    47: aastore        
        //    48: dup            
        //    49: iconst_2       
        //    50: ldc_w           "name"
        //    53: aastore        
        //    54: dup            
        //    55: iconst_3       
        //    56: ldc_w           "value"
        //    59: aastore        
        //    60: dup            
        //    61: iconst_4       
        //    62: ldc_w           "active"
        //    65: aastore        
        //    66: dup            
        //    67: iconst_5       
        //    68: ldc_w           "trigger_event_name"
        //    71: aastore        
        //    72: dup            
        //    73: bipush          6
        //    75: ldc_w           "trigger_timeout"
        //    78: aastore        
        //    79: dup            
        //    80: bipush          7
        //    82: ldc_w           "timed_out_event"
        //    85: aastore        
        //    86: dup            
        //    87: bipush          8
        //    89: ldc_w           "creation_timestamp"
        //    92: aastore        
        //    93: dup            
        //    94: bipush          9
        //    96: ldc_w           "triggered_event"
        //    99: aastore        
        //   100: dup            
        //   101: bipush          10
        //   103: ldc_w           "triggered_timestamp"
        //   106: aastore        
        //   107: dup            
        //   108: bipush          11
        //   110: ldc_w           "time_to_live"
        //   113: aastore        
        //   114: dup            
        //   115: bipush          12
        //   117: ldc_w           "expired_event"
        //   120: aastore        
        //   121: aload_1        
        //   122: aload_2        
        //   123: aconst_null    
        //   124: aconst_null    
        //   125: ldc_w           "rowid"
        //   128: ldc_w           "1001"
        //   131: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   134: astore_1       
        //   135: aload_1        
        //   136: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   141: istore_3       
        //   142: iload_3        
        //   143: ifne            161
        //   146: aload_1        
        //   147: ifnull          156
        //   150: aload_1        
        //   151: invokeinterface android/database/Cursor.close:()V
        //   156: aload           12
        //   158: astore_2       
        //   159: aload_2        
        //   160: areturn        
        //   161: aload           12
        //   163: invokeinterface java/util/List.size:()I
        //   168: invokestatic    com/google/android/gms/internal/zzcem.zzxv:()I
        //   171: if_icmplt       206
        //   174: aload_0        
        //   175: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   178: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   181: ldc_w           "Read more than the max allowed conditional properties, ignoring extra"
        //   184: invokestatic    com/google/android/gms/internal/zzcem.zzxv:()I
        //   187: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   190: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   193: aload_1        
        //   194: ifnull          203
        //   197: aload_1        
        //   198: invokeinterface android/database/Cursor.close:()V
        //   203: aload           12
        //   205: areturn        
        //   206: aload_1        
        //   207: iconst_0       
        //   208: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   213: astore_2       
        //   214: aload_1        
        //   215: iconst_1       
        //   216: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   221: astore          13
        //   223: aload_1        
        //   224: iconst_2       
        //   225: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   230: astore          14
        //   232: aload_0        
        //   233: aload_1        
        //   234: iconst_3       
        //   235: invokespecial   com/google/android/gms/internal/zzcen.zza:(Landroid/database/Cursor;I)Ljava/lang/Object;
        //   238: astore          15
        //   240: aload_1        
        //   241: iconst_4       
        //   242: invokeinterface android/database/Cursor.getInt:(I)I
        //   247: ifeq            432
        //   250: iconst_1       
        //   251: istore_3       
        //   252: aload_1        
        //   253: iconst_5       
        //   254: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   259: astore          16
        //   261: aload_1        
        //   262: bipush          6
        //   264: invokeinterface android/database/Cursor.getLong:(I)J
        //   269: lstore          4
        //   271: aload_0        
        //   272: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   275: aload_1        
        //   276: bipush          7
        //   278: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   283: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   286: invokevirtual   com/google/android/gms/internal/zzcjl.zzb:([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
        //   289: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   292: astore          17
        //   294: aload_1        
        //   295: bipush          8
        //   297: invokeinterface android/database/Cursor.getLong:(I)J
        //   302: lstore          6
        //   304: aload_0        
        //   305: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   308: aload_1        
        //   309: bipush          9
        //   311: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   316: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   319: invokevirtual   com/google/android/gms/internal/zzcjl.zzb:([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
        //   322: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   325: astore          18
        //   327: aload_1        
        //   328: bipush          10
        //   330: invokeinterface android/database/Cursor.getLong:(I)J
        //   335: lstore          8
        //   337: aload_1        
        //   338: bipush          11
        //   340: invokeinterface android/database/Cursor.getLong:(I)J
        //   345: lstore          10
        //   347: aload_0        
        //   348: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   351: aload_1        
        //   352: bipush          12
        //   354: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   359: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   362: invokevirtual   com/google/android/gms/internal/zzcjl.zzb:([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
        //   365: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   368: astore          19
        //   370: aload           12
        //   372: new             Lcom/google/android/gms/internal/zzcek;
        //   375: dup            
        //   376: aload_2        
        //   377: aload           13
        //   379: new             Lcom/google/android/gms/internal/zzcji;
        //   382: dup            
        //   383: aload           14
        //   385: lload           8
        //   387: aload           15
        //   389: aload           13
        //   391: invokespecial   com/google/android/gms/internal/zzcji.<init>:(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
        //   394: lload           6
        //   396: iload_3        
        //   397: aload           16
        //   399: aload           17
        //   401: lload           4
        //   403: aload           18
        //   405: lload           10
        //   407: aload           19
        //   409: invokespecial   com/google/android/gms/internal/zzcek.<init>:(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzcji;JZLjava/lang/String;Lcom/google/android/gms/internal/zzcez;JLcom/google/android/gms/internal/zzcez;JLcom/google/android/gms/internal/zzcez;)V
        //   412: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   417: pop            
        //   418: aload_1        
        //   419: invokeinterface android/database/Cursor.moveToNext:()Z
        //   424: istore_3       
        //   425: iload_3        
        //   426: ifne            161
        //   429: goto            193
        //   432: iconst_0       
        //   433: istore_3       
        //   434: goto            252
        //   437: astore_2       
        //   438: aconst_null    
        //   439: astore_1       
        //   440: aload_0        
        //   441: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   444: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   447: ldc_w           "Error querying conditional user property value"
        //   450: aload_2        
        //   451: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   454: invokestatic    java/util/Collections.emptyList:()Ljava/util/List;
        //   457: astore          12
        //   459: aload           12
        //   461: astore_2       
        //   462: aload_1        
        //   463: ifnull          159
        //   466: aload_1        
        //   467: invokeinterface android/database/Cursor.close:()V
        //   472: aload           12
        //   474: areturn        
        //   475: astore_2       
        //   476: aconst_null    
        //   477: astore_1       
        //   478: aload_1        
        //   479: ifnull          488
        //   482: aload_1        
        //   483: invokeinterface android/database/Cursor.close:()V
        //   488: aload_2        
        //   489: athrow         
        //   490: astore_2       
        //   491: goto            478
        //   494: astore_2       
        //   495: goto            478
        //   498: astore_2       
        //   499: goto            440
        //    Signature:
        //  (Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List<Lcom/google/android/gms/internal/zzcek;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  17     135    437    440    Landroid/database/sqlite/SQLiteException;
        //  17     135    475    478    Any
        //  135    142    498    502    Landroid/database/sqlite/SQLiteException;
        //  135    142    490    494    Any
        //  161    193    498    502    Landroid/database/sqlite/SQLiteException;
        //  161    193    490    494    Any
        //  206    250    498    502    Landroid/database/sqlite/SQLiteException;
        //  206    250    490    494    Any
        //  252    425    498    502    Landroid/database/sqlite/SQLiteException;
        //  252    425    490    494    Any
        //  440    459    494    498    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 243 out of bounds for length 243
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final List<zzcjk> zzdP(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          7
        //     3: aload_1        
        //     4: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     7: pop            
        //     8: aload_0        
        //     9: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //    12: aload_0        
        //    13: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: astore          9
        //    25: aload_0        
        //    26: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    29: astore          6
        //    31: invokestatic    com/google/android/gms/internal/zzcem.zzxt:()I
        //    34: istore_2       
        //    35: aload           6
        //    37: ldc_w           "user_attributes"
        //    40: iconst_4       
        //    41: anewarray       Ljava/lang/String;
        //    44: dup            
        //    45: iconst_0       
        //    46: ldc_w           "name"
        //    49: aastore        
        //    50: dup            
        //    51: iconst_1       
        //    52: ldc             "origin"
        //    54: aastore        
        //    55: dup            
        //    56: iconst_2       
        //    57: ldc_w           "set_timestamp"
        //    60: aastore        
        //    61: dup            
        //    62: iconst_3       
        //    63: ldc_w           "value"
        //    66: aastore        
        //    67: ldc_w           "app_id=?"
        //    70: iconst_1       
        //    71: anewarray       Ljava/lang/String;
        //    74: dup            
        //    75: iconst_0       
        //    76: aload_1        
        //    77: aastore        
        //    78: aconst_null    
        //    79: aconst_null    
        //    80: ldc_w           "rowid"
        //    83: iload_2        
        //    84: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //    87: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    90: astore          6
        //    92: aload           6
        //    94: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    99: istore_3       
        //   100: iload_3        
        //   101: ifne            119
        //   104: aload           6
        //   106: ifnull          116
        //   109: aload           6
        //   111: invokeinterface android/database/Cursor.close:()V
        //   116: aload           9
        //   118: areturn        
        //   119: aload           6
        //   121: iconst_0       
        //   122: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   127: astore          10
        //   129: aload           6
        //   131: iconst_1       
        //   132: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   137: astore          8
        //   139: aload           8
        //   141: astore          7
        //   143: aload           8
        //   145: ifnonnull       153
        //   148: ldc_w           ""
        //   151: astore          7
        //   153: aload           6
        //   155: iconst_2       
        //   156: invokeinterface android/database/Cursor.getLong:(I)J
        //   161: lstore          4
        //   163: aload_0        
        //   164: aload           6
        //   166: iconst_3       
        //   167: invokespecial   com/google/android/gms/internal/zzcen.zza:(Landroid/database/Cursor;I)Ljava/lang/Object;
        //   170: astore          8
        //   172: aload           8
        //   174: ifnonnull       221
        //   177: aload_0        
        //   178: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   181: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   184: ldc_w           "Read invalid user property value, ignoring it. appId"
        //   187: aload_1        
        //   188: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   191: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   194: aload           6
        //   196: invokeinterface android/database/Cursor.moveToNext:()Z
        //   201: istore_3       
        //   202: iload_3        
        //   203: ifne            119
        //   206: aload           6
        //   208: ifnull          218
        //   211: aload           6
        //   213: invokeinterface android/database/Cursor.close:()V
        //   218: aload           9
        //   220: areturn        
        //   221: aload           9
        //   223: new             Lcom/google/android/gms/internal/zzcjk;
        //   226: dup            
        //   227: aload_1        
        //   228: aload           7
        //   230: aload           10
        //   232: lload           4
        //   234: aload           8
        //   236: invokespecial   com/google/android/gms/internal/zzcjk.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
        //   239: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   244: pop            
        //   245: goto            194
        //   248: astore          7
        //   250: aload_0        
        //   251: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   254: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   257: ldc_w           "Error querying user properties. appId"
        //   260: aload_1        
        //   261: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   264: aload           7
        //   266: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   269: aload           6
        //   271: ifnull          281
        //   274: aload           6
        //   276: invokeinterface android/database/Cursor.close:()V
        //   281: aconst_null    
        //   282: areturn        
        //   283: astore_1       
        //   284: aload           7
        //   286: astore          6
        //   288: aload           6
        //   290: ifnull          300
        //   293: aload           6
        //   295: invokeinterface android/database/Cursor.close:()V
        //   300: aload_1        
        //   301: athrow         
        //   302: astore_1       
        //   303: goto            288
        //   306: astore_1       
        //   307: goto            288
        //   310: astore          7
        //   312: aconst_null    
        //   313: astore          6
        //   315: goto            250
        //    Signature:
        //  (Ljava/lang/String;)Ljava/util/List<Lcom/google/android/gms/internal/zzcjk;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  25     92     310    318    Landroid/database/sqlite/SQLiteException;
        //  25     92     283    288    Any
        //  92     100    248    250    Landroid/database/sqlite/SQLiteException;
        //  92     100    302    306    Any
        //  119    139    248    250    Landroid/database/sqlite/SQLiteException;
        //  119    139    302    306    Any
        //  153    172    248    250    Landroid/database/sqlite/SQLiteException;
        //  153    172    302    306    Any
        //  177    194    248    250    Landroid/database/sqlite/SQLiteException;
        //  177    194    302    306    Any
        //  194    202    248    250    Landroid/database/sqlite/SQLiteException;
        //  194    202    302    306    Any
        //  221    245    248    250    Landroid/database/sqlite/SQLiteException;
        //  221    245    302    306    Any
        //  250    269    306    310    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0250:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final zzceg zzdQ(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     4: pop            
        //     5: aload_0        
        //     6: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     9: aload_0        
        //    10: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    13: aload_0        
        //    14: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    17: ldc_w           "apps"
        //    20: bipush          23
        //    22: anewarray       Ljava/lang/String;
        //    25: dup            
        //    26: iconst_0       
        //    27: ldc_w           "app_instance_id"
        //    30: aastore        
        //    31: dup            
        //    32: iconst_1       
        //    33: ldc_w           "gmp_app_id"
        //    36: aastore        
        //    37: dup            
        //    38: iconst_2       
        //    39: ldc_w           "resettable_device_id_hash"
        //    42: aastore        
        //    43: dup            
        //    44: iconst_3       
        //    45: ldc_w           "last_bundle_index"
        //    48: aastore        
        //    49: dup            
        //    50: iconst_4       
        //    51: ldc             "last_bundle_start_timestamp"
        //    53: aastore        
        //    54: dup            
        //    55: iconst_5       
        //    56: ldc_w           "last_bundle_end_timestamp"
        //    59: aastore        
        //    60: dup            
        //    61: bipush          6
        //    63: ldc             "app_version"
        //    65: aastore        
        //    66: dup            
        //    67: bipush          7
        //    69: ldc             "app_store"
        //    71: aastore        
        //    72: dup            
        //    73: bipush          8
        //    75: ldc             "gmp_version"
        //    77: aastore        
        //    78: dup            
        //    79: bipush          9
        //    81: ldc             "dev_cert_hash"
        //    83: aastore        
        //    84: dup            
        //    85: bipush          10
        //    87: ldc             "measurement_enabled"
        //    89: aastore        
        //    90: dup            
        //    91: bipush          11
        //    93: ldc             "day"
        //    95: aastore        
        //    96: dup            
        //    97: bipush          12
        //    99: ldc             "daily_public_events_count"
        //   101: aastore        
        //   102: dup            
        //   103: bipush          13
        //   105: ldc             "daily_events_count"
        //   107: aastore        
        //   108: dup            
        //   109: bipush          14
        //   111: ldc             "daily_conversions_count"
        //   113: aastore        
        //   114: dup            
        //   115: bipush          15
        //   117: ldc             "config_fetched_time"
        //   119: aastore        
        //   120: dup            
        //   121: bipush          16
        //   123: ldc             "failed_config_fetch_time"
        //   125: aastore        
        //   126: dup            
        //   127: bipush          17
        //   129: ldc             "app_version_int"
        //   131: aastore        
        //   132: dup            
        //   133: bipush          18
        //   135: ldc             "firebase_instance_id"
        //   137: aastore        
        //   138: dup            
        //   139: bipush          19
        //   141: ldc             "daily_error_events_count"
        //   143: aastore        
        //   144: dup            
        //   145: bipush          20
        //   147: ldc             "daily_realtime_events_count"
        //   149: aastore        
        //   150: dup            
        //   151: bipush          21
        //   153: ldc             "health_monitor_sample"
        //   155: aastore        
        //   156: dup            
        //   157: bipush          22
        //   159: ldc             "android_id"
        //   161: aastore        
        //   162: ldc_w           "app_id=?"
        //   165: iconst_1       
        //   166: anewarray       Ljava/lang/String;
        //   169: dup            
        //   170: iconst_0       
        //   171: aload_1        
        //   172: aastore        
        //   173: aconst_null    
        //   174: aconst_null    
        //   175: aconst_null    
        //   176: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   179: astore          7
        //   181: aload           7
        //   183: astore          6
        //   185: aload           7
        //   187: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   192: istore_3       
        //   193: iload_3        
        //   194: ifne            213
        //   197: aload           7
        //   199: ifnull          209
        //   202: aload           7
        //   204: invokeinterface android/database/Cursor.close:()V
        //   209: aconst_null    
        //   210: astore_1       
        //   211: aload_1        
        //   212: areturn        
        //   213: aload           7
        //   215: astore          6
        //   217: new             Lcom/google/android/gms/internal/zzceg;
        //   220: dup            
        //   221: aload_0        
        //   222: getfield        com/google/android/gms/internal/zzcen.zzboe:Lcom/google/android/gms/internal/zzcgl;
        //   225: aload_1        
        //   226: invokespecial   com/google/android/gms/internal/zzceg.<init>:(Lcom/google/android/gms/internal/zzcgl;Ljava/lang/String;)V
        //   229: astore          8
        //   231: aload           7
        //   233: astore          6
        //   235: aload           8
        //   237: aload           7
        //   239: iconst_0       
        //   240: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   245: invokevirtual   com/google/android/gms/internal/zzceg.zzdG:(Ljava/lang/String;)V
        //   248: aload           7
        //   250: astore          6
        //   252: aload           8
        //   254: aload           7
        //   256: iconst_1       
        //   257: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   262: invokevirtual   com/google/android/gms/internal/zzceg.zzdH:(Ljava/lang/String;)V
        //   265: aload           7
        //   267: astore          6
        //   269: aload           8
        //   271: aload           7
        //   273: iconst_2       
        //   274: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   279: invokevirtual   com/google/android/gms/internal/zzceg.zzdI:(Ljava/lang/String;)V
        //   282: aload           7
        //   284: astore          6
        //   286: aload           8
        //   288: aload           7
        //   290: iconst_3       
        //   291: invokeinterface android/database/Cursor.getLong:(I)J
        //   296: invokevirtual   com/google/android/gms/internal/zzceg.zzQ:(J)V
        //   299: aload           7
        //   301: astore          6
        //   303: aload           8
        //   305: aload           7
        //   307: iconst_4       
        //   308: invokeinterface android/database/Cursor.getLong:(I)J
        //   313: invokevirtual   com/google/android/gms/internal/zzceg.zzL:(J)V
        //   316: aload           7
        //   318: astore          6
        //   320: aload           8
        //   322: aload           7
        //   324: iconst_5       
        //   325: invokeinterface android/database/Cursor.getLong:(I)J
        //   330: invokevirtual   com/google/android/gms/internal/zzceg.zzM:(J)V
        //   333: aload           7
        //   335: astore          6
        //   337: aload           8
        //   339: aload           7
        //   341: bipush          6
        //   343: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   348: invokevirtual   com/google/android/gms/internal/zzceg.setAppVersion:(Ljava/lang/String;)V
        //   351: aload           7
        //   353: astore          6
        //   355: aload           8
        //   357: aload           7
        //   359: bipush          7
        //   361: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   366: invokevirtual   com/google/android/gms/internal/zzceg.zzdK:(Ljava/lang/String;)V
        //   369: aload           7
        //   371: astore          6
        //   373: aload           8
        //   375: aload           7
        //   377: bipush          8
        //   379: invokeinterface android/database/Cursor.getLong:(I)J
        //   384: invokevirtual   com/google/android/gms/internal/zzceg.zzO:(J)V
        //   387: aload           7
        //   389: astore          6
        //   391: aload           8
        //   393: aload           7
        //   395: bipush          9
        //   397: invokeinterface android/database/Cursor.getLong:(I)J
        //   402: invokevirtual   com/google/android/gms/internal/zzceg.zzP:(J)V
        //   405: aload           7
        //   407: astore          6
        //   409: aload           7
        //   411: bipush          10
        //   413: invokeinterface android/database/Cursor.isNull:(I)Z
        //   418: ifeq            740
        //   421: iconst_1       
        //   422: istore_2       
        //   423: goto            863
        //   426: aload           7
        //   428: astore          6
        //   430: aload           8
        //   432: iload_3        
        //   433: invokevirtual   com/google/android/gms/internal/zzceg.setMeasurementEnabled:(Z)V
        //   436: aload           7
        //   438: astore          6
        //   440: aload           8
        //   442: aload           7
        //   444: bipush          11
        //   446: invokeinterface android/database/Cursor.getLong:(I)J
        //   451: invokevirtual   com/google/android/gms/internal/zzceg.zzT:(J)V
        //   454: aload           7
        //   456: astore          6
        //   458: aload           8
        //   460: aload           7
        //   462: bipush          12
        //   464: invokeinterface android/database/Cursor.getLong:(I)J
        //   469: invokevirtual   com/google/android/gms/internal/zzceg.zzU:(J)V
        //   472: aload           7
        //   474: astore          6
        //   476: aload           8
        //   478: aload           7
        //   480: bipush          13
        //   482: invokeinterface android/database/Cursor.getLong:(I)J
        //   487: invokevirtual   com/google/android/gms/internal/zzceg.zzV:(J)V
        //   490: aload           7
        //   492: astore          6
        //   494: aload           8
        //   496: aload           7
        //   498: bipush          14
        //   500: invokeinterface android/database/Cursor.getLong:(I)J
        //   505: invokevirtual   com/google/android/gms/internal/zzceg.zzW:(J)V
        //   508: aload           7
        //   510: astore          6
        //   512: aload           8
        //   514: aload           7
        //   516: bipush          15
        //   518: invokeinterface android/database/Cursor.getLong:(I)J
        //   523: invokevirtual   com/google/android/gms/internal/zzceg.zzR:(J)V
        //   526: aload           7
        //   528: astore          6
        //   530: aload           8
        //   532: aload           7
        //   534: bipush          16
        //   536: invokeinterface android/database/Cursor.getLong:(I)J
        //   541: invokevirtual   com/google/android/gms/internal/zzceg.zzS:(J)V
        //   544: aload           7
        //   546: astore          6
        //   548: aload           7
        //   550: bipush          17
        //   552: invokeinterface android/database/Cursor.isNull:(I)Z
        //   557: ifeq            757
        //   560: ldc2_w          -2147483648
        //   563: lstore          4
        //   565: aload           7
        //   567: astore          6
        //   569: aload           8
        //   571: lload           4
        //   573: invokevirtual   com/google/android/gms/internal/zzceg.zzN:(J)V
        //   576: aload           7
        //   578: astore          6
        //   580: aload           8
        //   582: aload           7
        //   584: bipush          18
        //   586: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   591: invokevirtual   com/google/android/gms/internal/zzceg.zzdJ:(Ljava/lang/String;)V
        //   594: aload           7
        //   596: astore          6
        //   598: aload           8
        //   600: aload           7
        //   602: bipush          19
        //   604: invokeinterface android/database/Cursor.getLong:(I)J
        //   609: invokevirtual   com/google/android/gms/internal/zzceg.zzY:(J)V
        //   612: aload           7
        //   614: astore          6
        //   616: aload           8
        //   618: aload           7
        //   620: bipush          20
        //   622: invokeinterface android/database/Cursor.getLong:(I)J
        //   627: invokevirtual   com/google/android/gms/internal/zzceg.zzX:(J)V
        //   630: aload           7
        //   632: astore          6
        //   634: aload           8
        //   636: aload           7
        //   638: bipush          21
        //   640: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   645: invokevirtual   com/google/android/gms/internal/zzceg.zzdL:(Ljava/lang/String;)V
        //   648: aload           7
        //   650: astore          6
        //   652: aload           7
        //   654: bipush          22
        //   656: invokeinterface android/database/Cursor.isNull:(I)Z
        //   661: ifeq            776
        //   664: lconst_0       
        //   665: lstore          4
        //   667: aload           7
        //   669: astore          6
        //   671: aload           8
        //   673: lload           4
        //   675: invokevirtual   com/google/android/gms/internal/zzceg.zzZ:(J)V
        //   678: aload           7
        //   680: astore          6
        //   682: aload           8
        //   684: invokevirtual   com/google/android/gms/internal/zzceg.zzwI:()V
        //   687: aload           7
        //   689: astore          6
        //   691: aload           7
        //   693: invokeinterface android/database/Cursor.moveToNext:()Z
        //   698: ifeq            722
        //   701: aload           7
        //   703: astore          6
        //   705: aload_0        
        //   706: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   709: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   712: ldc_w           "Got multiple records for app, expected one. appId"
        //   715: aload_1        
        //   716: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   719: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   722: aload           8
        //   724: astore_1       
        //   725: aload           7
        //   727: ifnull          211
        //   730: aload           7
        //   732: invokeinterface android/database/Cursor.close:()V
        //   737: aload           8
        //   739: areturn        
        //   740: aload           7
        //   742: astore          6
        //   744: aload           7
        //   746: bipush          10
        //   748: invokeinterface android/database/Cursor.getInt:(I)I
        //   753: istore_2       
        //   754: goto            863
        //   757: aload           7
        //   759: astore          6
        //   761: aload           7
        //   763: bipush          17
        //   765: invokeinterface android/database/Cursor.getInt:(I)I
        //   770: i2l            
        //   771: lstore          4
        //   773: goto            565
        //   776: aload           7
        //   778: astore          6
        //   780: aload           7
        //   782: bipush          22
        //   784: invokeinterface android/database/Cursor.getLong:(I)J
        //   789: lstore          4
        //   791: goto            667
        //   794: astore          8
        //   796: aconst_null    
        //   797: astore          7
        //   799: aload           7
        //   801: astore          6
        //   803: aload_0        
        //   804: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   807: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   810: ldc_w           "Error querying app. appId"
        //   813: aload_1        
        //   814: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   817: aload           8
        //   819: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   822: aload           7
        //   824: ifnull          834
        //   827: aload           7
        //   829: invokeinterface android/database/Cursor.close:()V
        //   834: aconst_null    
        //   835: areturn        
        //   836: astore_1       
        //   837: aconst_null    
        //   838: astore          6
        //   840: aload           6
        //   842: ifnull          852
        //   845: aload           6
        //   847: invokeinterface android/database/Cursor.close:()V
        //   852: aload_1        
        //   853: athrow         
        //   854: astore_1       
        //   855: goto            840
        //   858: astore          8
        //   860: goto            799
        //   863: iload_2        
        //   864: ifeq            872
        //   867: iconst_1       
        //   868: istore_3       
        //   869: goto            426
        //   872: iconst_0       
        //   873: istore_3       
        //   874: goto            426
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  13     181    794    799    Landroid/database/sqlite/SQLiteException;
        //  13     181    836    840    Any
        //  185    193    858    863    Landroid/database/sqlite/SQLiteException;
        //  185    193    854    858    Any
        //  217    231    858    863    Landroid/database/sqlite/SQLiteException;
        //  217    231    854    858    Any
        //  235    248    858    863    Landroid/database/sqlite/SQLiteException;
        //  235    248    854    858    Any
        //  252    265    858    863    Landroid/database/sqlite/SQLiteException;
        //  252    265    854    858    Any
        //  269    282    858    863    Landroid/database/sqlite/SQLiteException;
        //  269    282    854    858    Any
        //  286    299    858    863    Landroid/database/sqlite/SQLiteException;
        //  286    299    854    858    Any
        //  303    316    858    863    Landroid/database/sqlite/SQLiteException;
        //  303    316    854    858    Any
        //  320    333    858    863    Landroid/database/sqlite/SQLiteException;
        //  320    333    854    858    Any
        //  337    351    858    863    Landroid/database/sqlite/SQLiteException;
        //  337    351    854    858    Any
        //  355    369    858    863    Landroid/database/sqlite/SQLiteException;
        //  355    369    854    858    Any
        //  373    387    858    863    Landroid/database/sqlite/SQLiteException;
        //  373    387    854    858    Any
        //  391    405    858    863    Landroid/database/sqlite/SQLiteException;
        //  391    405    854    858    Any
        //  409    421    858    863    Landroid/database/sqlite/SQLiteException;
        //  409    421    854    858    Any
        //  430    436    858    863    Landroid/database/sqlite/SQLiteException;
        //  430    436    854    858    Any
        //  440    454    858    863    Landroid/database/sqlite/SQLiteException;
        //  440    454    854    858    Any
        //  458    472    858    863    Landroid/database/sqlite/SQLiteException;
        //  458    472    854    858    Any
        //  476    490    858    863    Landroid/database/sqlite/SQLiteException;
        //  476    490    854    858    Any
        //  494    508    858    863    Landroid/database/sqlite/SQLiteException;
        //  494    508    854    858    Any
        //  512    526    858    863    Landroid/database/sqlite/SQLiteException;
        //  512    526    854    858    Any
        //  530    544    858    863    Landroid/database/sqlite/SQLiteException;
        //  530    544    854    858    Any
        //  548    560    858    863    Landroid/database/sqlite/SQLiteException;
        //  548    560    854    858    Any
        //  569    576    858    863    Landroid/database/sqlite/SQLiteException;
        //  569    576    854    858    Any
        //  580    594    858    863    Landroid/database/sqlite/SQLiteException;
        //  580    594    854    858    Any
        //  598    612    858    863    Landroid/database/sqlite/SQLiteException;
        //  598    612    854    858    Any
        //  616    630    858    863    Landroid/database/sqlite/SQLiteException;
        //  616    630    854    858    Any
        //  634    648    858    863    Landroid/database/sqlite/SQLiteException;
        //  634    648    854    858    Any
        //  652    664    858    863    Landroid/database/sqlite/SQLiteException;
        //  652    664    854    858    Any
        //  671    678    858    863    Landroid/database/sqlite/SQLiteException;
        //  671    678    854    858    Any
        //  682    687    858    863    Landroid/database/sqlite/SQLiteException;
        //  682    687    854    858    Any
        //  691    701    858    863    Landroid/database/sqlite/SQLiteException;
        //  691    701    854    858    Any
        //  705    722    858    863    Landroid/database/sqlite/SQLiteException;
        //  705    722    854    858    Any
        //  744    754    858    863    Landroid/database/sqlite/SQLiteException;
        //  744    754    854    858    Any
        //  761    773    858    863    Landroid/database/sqlite/SQLiteException;
        //  761    773    854    858    Any
        //  780    791    858    863    Landroid/database/sqlite/SQLiteException;
        //  780    791    854    858    Any
        //  803    822    854    858    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0209:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final long zzdR(final String s) {
        zzbo.zzcF(s);
        this.zzjC();
        this.zzkD();
        try {
            return this.getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[] { s, String.valueOf(Math.max(0, Math.min(1000000, this.zzwH().zzb(s, zzcfb.zzbqk)))) });
        }
        catch (SQLiteException ex) {
            this.zzwF().zzyx().zze("Error deleting over the limit events. appId", zzcfl.zzdZ(s), ex);
            return 0L;
        }
    }
    
    @WorkerThread
    public final byte[] zzdS(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     4: pop            
        //     5: aload_0        
        //     6: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     9: aload_0        
        //    10: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    13: aload_0        
        //    14: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    17: ldc_w           "apps"
        //    20: iconst_1       
        //    21: anewarray       Ljava/lang/String;
        //    24: dup            
        //    25: iconst_0       
        //    26: ldc             "remote_config"
        //    28: aastore        
        //    29: ldc_w           "app_id=?"
        //    32: iconst_1       
        //    33: anewarray       Ljava/lang/String;
        //    36: dup            
        //    37: iconst_0       
        //    38: aload_1        
        //    39: aastore        
        //    40: aconst_null    
        //    41: aconst_null    
        //    42: aconst_null    
        //    43: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    46: astore          4
        //    48: aload           4
        //    50: astore_3       
        //    51: aload           4
        //    53: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    58: istore_2       
        //    59: iload_2        
        //    60: ifne            79
        //    63: aload           4
        //    65: ifnull          75
        //    68: aload           4
        //    70: invokeinterface android/database/Cursor.close:()V
        //    75: aconst_null    
        //    76: astore_1       
        //    77: aload_1        
        //    78: areturn        
        //    79: aload           4
        //    81: astore_3       
        //    82: aload           4
        //    84: iconst_0       
        //    85: invokeinterface android/database/Cursor.getBlob:(I)[B
        //    90: astore          5
        //    92: aload           4
        //    94: astore_3       
        //    95: aload           4
        //    97: invokeinterface android/database/Cursor.moveToNext:()Z
        //   102: ifeq            125
        //   105: aload           4
        //   107: astore_3       
        //   108: aload_0        
        //   109: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   112: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   115: ldc_w           "Got multiple records for app config, expected one. appId"
        //   118: aload_1        
        //   119: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   122: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   125: aload           5
        //   127: astore_1       
        //   128: aload           4
        //   130: ifnull          77
        //   133: aload           4
        //   135: invokeinterface android/database/Cursor.close:()V
        //   140: aload           5
        //   142: areturn        
        //   143: astore          5
        //   145: aconst_null    
        //   146: astore          4
        //   148: aload           4
        //   150: astore_3       
        //   151: aload_0        
        //   152: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   155: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   158: ldc_w           "Error querying remote config. appId"
        //   161: aload_1        
        //   162: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   165: aload           5
        //   167: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   170: aload           4
        //   172: ifnull          182
        //   175: aload           4
        //   177: invokeinterface android/database/Cursor.close:()V
        //   182: aconst_null    
        //   183: areturn        
        //   184: astore_1       
        //   185: aconst_null    
        //   186: astore_3       
        //   187: aload_3        
        //   188: ifnull          197
        //   191: aload_3        
        //   192: invokeinterface android/database/Cursor.close:()V
        //   197: aload_1        
        //   198: athrow         
        //   199: astore_1       
        //   200: goto            187
        //   203: astore          5
        //   205: goto            148
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  13     48     143    148    Landroid/database/sqlite/SQLiteException;
        //  13     48     184    187    Any
        //  51     59     203    208    Landroid/database/sqlite/SQLiteException;
        //  51     59     199    203    Any
        //  82     92     203    208    Landroid/database/sqlite/SQLiteException;
        //  82     92     199    203    Any
        //  95     105    203    208    Landroid/database/sqlite/SQLiteException;
        //  95     105    199    203    Any
        //  108    125    203    208    Landroid/database/sqlite/SQLiteException;
        //  108    125    199    203    Any
        //  151    170    199    203    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0075:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    final Map<Integer, zzcka> zzdT(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //     4: aload_0        
        //     5: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     8: aload_1        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_0        
        //    14: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    17: astore          4
        //    19: aload           4
        //    21: ldc_w           "audience_filter_values"
        //    24: iconst_2       
        //    25: anewarray       Ljava/lang/String;
        //    28: dup            
        //    29: iconst_0       
        //    30: ldc_w           "audience_id"
        //    33: aastore        
        //    34: dup            
        //    35: iconst_1       
        //    36: ldc_w           "current_results"
        //    39: aastore        
        //    40: ldc_w           "app_id=?"
        //    43: iconst_1       
        //    44: anewarray       Ljava/lang/String;
        //    47: dup            
        //    48: iconst_0       
        //    49: aload_1        
        //    50: aastore        
        //    51: aconst_null    
        //    52: aconst_null    
        //    53: aconst_null    
        //    54: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    57: astore          5
        //    59: aload           5
        //    61: astore          4
        //    63: aload           5
        //    65: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    70: istore_3       
        //    71: iload_3        
        //    72: ifne            91
        //    75: aload           5
        //    77: ifnull          87
        //    80: aload           5
        //    82: invokeinterface android/database/Cursor.close:()V
        //    87: aconst_null    
        //    88: astore_1       
        //    89: aload_1        
        //    90: areturn        
        //    91: aload           5
        //    93: astore          4
        //    95: new             Landroid/support/v4/util/ArrayMap;
        //    98: dup            
        //    99: invokespecial   android/support/v4/util/ArrayMap.<init>:()V
        //   102: astore          6
        //   104: aload           5
        //   106: astore          4
        //   108: aload           5
        //   110: iconst_0       
        //   111: invokeinterface android/database/Cursor.getInt:(I)I
        //   116: istore_2       
        //   117: aload           5
        //   119: astore          4
        //   121: aload           5
        //   123: iconst_1       
        //   124: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   129: astore          7
        //   131: aload           5
        //   133: astore          4
        //   135: aload           7
        //   137: iconst_0       
        //   138: aload           7
        //   140: arraylength    
        //   141: invokestatic    com/google/android/gms/internal/adg.zzb:([BII)Lcom/google/android/gms/internal/adg;
        //   144: astore          7
        //   146: aload           5
        //   148: astore          4
        //   150: new             Lcom/google/android/gms/internal/zzcka;
        //   153: dup            
        //   154: invokespecial   com/google/android/gms/internal/zzcka.<init>:()V
        //   157: astore          8
        //   159: aload           5
        //   161: astore          4
        //   163: aload           8
        //   165: aload           7
        //   167: invokevirtual   com/google/android/gms/internal/zzcka.zza:(Lcom/google/android/gms/internal/adg;)Lcom/google/android/gms/internal/adp;
        //   170: pop            
        //   171: aload           5
        //   173: astore          4
        //   175: aload           6
        //   177: iload_2        
        //   178: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   181: aload           8
        //   183: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   188: pop            
        //   189: aload           5
        //   191: astore          4
        //   193: aload           5
        //   195: invokeinterface android/database/Cursor.moveToNext:()Z
        //   200: istore_3       
        //   201: iload_3        
        //   202: ifne            104
        //   205: aload           6
        //   207: astore_1       
        //   208: aload           5
        //   210: ifnull          89
        //   213: aload           5
        //   215: invokeinterface android/database/Cursor.close:()V
        //   220: aload           6
        //   222: areturn        
        //   223: astore          7
        //   225: aload           5
        //   227: astore          4
        //   229: aload_0        
        //   230: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   233: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   236: ldc_w           "Failed to merge filter results. appId, audienceId, error"
        //   239: aload_1        
        //   240: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   243: iload_2        
        //   244: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   247: aload           7
        //   249: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   252: goto            189
        //   255: astore          6
        //   257: aload           5
        //   259: astore          4
        //   261: aload_0        
        //   262: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   265: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   268: ldc_w           "Database error querying filter results. appId"
        //   271: aload_1        
        //   272: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   275: aload           6
        //   277: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   280: aload           5
        //   282: ifnull          292
        //   285: aload           5
        //   287: invokeinterface android/database/Cursor.close:()V
        //   292: aconst_null    
        //   293: areturn        
        //   294: astore_1       
        //   295: aconst_null    
        //   296: astore          4
        //   298: aload           4
        //   300: ifnull          310
        //   303: aload           4
        //   305: invokeinterface android/database/Cursor.close:()V
        //   310: aload_1        
        //   311: athrow         
        //   312: astore_1       
        //   313: goto            298
        //   316: astore          6
        //   318: aconst_null    
        //   319: astore          5
        //   321: goto            257
        //    Signature:
        //  (Ljava/lang/String;)Ljava/util/Map<Ljava/lang/Integer;Lcom/google/android/gms/internal/zzcka;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  19     59     316    324    Landroid/database/sqlite/SQLiteException;
        //  19     59     294    298    Any
        //  63     71     255    257    Landroid/database/sqlite/SQLiteException;
        //  63     71     312    316    Any
        //  95     104    255    257    Landroid/database/sqlite/SQLiteException;
        //  95     104    312    316    Any
        //  108    117    255    257    Landroid/database/sqlite/SQLiteException;
        //  108    117    312    316    Any
        //  121    131    255    257    Landroid/database/sqlite/SQLiteException;
        //  121    131    312    316    Any
        //  135    146    255    257    Landroid/database/sqlite/SQLiteException;
        //  135    146    312    316    Any
        //  150    159    255    257    Landroid/database/sqlite/SQLiteException;
        //  150    159    312    316    Any
        //  163    171    223    255    Ljava/io/IOException;
        //  163    171    255    257    Landroid/database/sqlite/SQLiteException;
        //  163    171    312    316    Any
        //  175    189    255    257    Landroid/database/sqlite/SQLiteException;
        //  175    189    312    316    Any
        //  193    201    255    257    Landroid/database/sqlite/SQLiteException;
        //  193    201    312    316    Any
        //  229    252    255    257    Landroid/database/sqlite/SQLiteException;
        //  229    252    312    316    Any
        //  261    280    312    316    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0087:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final long zzdU(final String s) {
        zzbo.zzcF(s);
        return this.zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { s }, 0L);
    }
    
    @WorkerThread
    public final List<zzcjk> zzh(final String p0, final String p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          8
        //     3: aload_1        
        //     4: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //     7: pop            
        //     8: aload_0        
        //     9: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //    12: aload_0        
        //    13: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: astore          9
        //    25: new             Ljava/util/ArrayList;
        //    28: dup            
        //    29: iconst_3       
        //    30: invokespecial   java/util/ArrayList.<init>:(I)V
        //    33: astore          10
        //    35: aload           10
        //    37: aload_1        
        //    38: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    43: pop            
        //    44: new             Ljava/lang/StringBuilder;
        //    47: dup            
        //    48: ldc_w           "app_id=?"
        //    51: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    54: astore          7
        //    56: aload_2        
        //    57: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    60: ifne            81
        //    63: aload           10
        //    65: aload_2        
        //    66: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    71: pop            
        //    72: aload           7
        //    74: ldc_w           " and origin=?"
        //    77: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    80: pop            
        //    81: aload_3        
        //    82: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    85: ifne            115
        //    88: aload           10
        //    90: aload_3        
        //    91: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    94: ldc_w           "*"
        //    97: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   100: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   105: pop            
        //   106: aload           7
        //   108: ldc_w           " and name glob ?"
        //   111: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   114: pop            
        //   115: aload           10
        //   117: aload           10
        //   119: invokeinterface java/util/List.size:()I
        //   124: anewarray       Ljava/lang/String;
        //   127: invokeinterface java/util/List.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   132: checkcast       [Ljava/lang/String;
        //   135: astore          10
        //   137: aload_0        
        //   138: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //   141: astore          11
        //   143: aload           7
        //   145: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   148: astore          7
        //   150: invokestatic    com/google/android/gms/internal/zzcem.zzxt:()I
        //   153: pop            
        //   154: aload           11
        //   156: ldc_w           "user_attributes"
        //   159: iconst_4       
        //   160: anewarray       Ljava/lang/String;
        //   163: dup            
        //   164: iconst_0       
        //   165: ldc_w           "name"
        //   168: aastore        
        //   169: dup            
        //   170: iconst_1       
        //   171: ldc_w           "set_timestamp"
        //   174: aastore        
        //   175: dup            
        //   176: iconst_2       
        //   177: ldc_w           "value"
        //   180: aastore        
        //   181: dup            
        //   182: iconst_3       
        //   183: ldc             "origin"
        //   185: aastore        
        //   186: aload           7
        //   188: aload           10
        //   190: aconst_null    
        //   191: aconst_null    
        //   192: ldc_w           "rowid"
        //   195: ldc_w           "1001"
        //   198: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   201: astore          7
        //   203: aload_2        
        //   204: astore          8
        //   206: aload           7
        //   208: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   213: istore          4
        //   215: iload           4
        //   217: ifne            235
        //   220: aload           7
        //   222: ifnull          232
        //   225: aload           7
        //   227: invokeinterface android/database/Cursor.close:()V
        //   232: aload           9
        //   234: areturn        
        //   235: aload_2        
        //   236: astore          8
        //   238: aload           9
        //   240: invokeinterface java/util/List.size:()I
        //   245: invokestatic    com/google/android/gms/internal/zzcem.zzxt:()I
        //   248: if_icmplt       288
        //   251: aload_2        
        //   252: astore          8
        //   254: aload_0        
        //   255: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   258: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   261: ldc_w           "Read more than the max allowed user properties, ignoring excess"
        //   264: invokestatic    com/google/android/gms/internal/zzcem.zzxt:()I
        //   267: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   270: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   273: aload           7
        //   275: ifnull          285
        //   278: aload           7
        //   280: invokeinterface android/database/Cursor.close:()V
        //   285: aload           9
        //   287: areturn        
        //   288: aload_2        
        //   289: astore          8
        //   291: aload           7
        //   293: iconst_0       
        //   294: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   299: astore          10
        //   301: aload_2        
        //   302: astore          8
        //   304: aload           7
        //   306: iconst_1       
        //   307: invokeinterface android/database/Cursor.getLong:(I)J
        //   312: lstore          5
        //   314: aload_2        
        //   315: astore          8
        //   317: aload_0        
        //   318: aload           7
        //   320: iconst_2       
        //   321: invokespecial   com/google/android/gms/internal/zzcen.zza:(Landroid/database/Cursor;I)Ljava/lang/Object;
        //   324: astore          11
        //   326: aload_2        
        //   327: astore          8
        //   329: aload           7
        //   331: iconst_3       
        //   332: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   337: astore_2       
        //   338: aload           11
        //   340: ifnonnull       375
        //   343: aload_0        
        //   344: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   347: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   350: ldc_w           "(2)Read invalid user property value, ignoring it"
        //   353: aload_1        
        //   354: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   357: aload_2        
        //   358: aload_3        
        //   359: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   362: aload           7
        //   364: invokeinterface android/database/Cursor.moveToNext:()Z
        //   369: ifne            235
        //   372: goto            273
        //   375: aload           9
        //   377: new             Lcom/google/android/gms/internal/zzcjk;
        //   380: dup            
        //   381: aload_1        
        //   382: aload_2        
        //   383: aload           10
        //   385: lload           5
        //   387: aload           11
        //   389: invokespecial   com/google/android/gms/internal/zzcjk.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
        //   392: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   397: pop            
        //   398: goto            362
        //   401: astore          8
        //   403: aload           7
        //   405: astore_3       
        //   406: aload           8
        //   408: astore          7
        //   410: aload_0        
        //   411: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   414: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   417: ldc_w           "(2)Error querying user properties"
        //   420: aload_1        
        //   421: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   424: aload_2        
        //   425: aload           7
        //   427: invokevirtual   com/google/android/gms/internal/zzcfn.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   430: aload_3        
        //   431: ifnull          440
        //   434: aload_3        
        //   435: invokeinterface android/database/Cursor.close:()V
        //   440: aconst_null    
        //   441: areturn        
        //   442: astore_1       
        //   443: aload           8
        //   445: astore_2       
        //   446: aload_2        
        //   447: ifnull          456
        //   450: aload_2        
        //   451: invokeinterface android/database/Cursor.close:()V
        //   456: aload_1        
        //   457: athrow         
        //   458: astore_1       
        //   459: aload           7
        //   461: astore_2       
        //   462: goto            446
        //   465: astore_1       
        //   466: aload_3        
        //   467: astore_2       
        //   468: goto            446
        //   471: astore          7
        //   473: aconst_null    
        //   474: astore_3       
        //   475: goto            410
        //   478: astore_2       
        //   479: aload           7
        //   481: astore_3       
        //   482: aload_2        
        //   483: astore          7
        //   485: aload           8
        //   487: astore_2       
        //   488: goto            410
        //    Signature:
        //  (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List<Lcom/google/android/gms/internal/zzcjk;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  25     81     471    478    Landroid/database/sqlite/SQLiteException;
        //  25     81     442    446    Any
        //  81     115    471    478    Landroid/database/sqlite/SQLiteException;
        //  81     115    442    446    Any
        //  115    203    471    478    Landroid/database/sqlite/SQLiteException;
        //  115    203    442    446    Any
        //  206    215    478    491    Landroid/database/sqlite/SQLiteException;
        //  206    215    458    465    Any
        //  238    251    478    491    Landroid/database/sqlite/SQLiteException;
        //  238    251    458    465    Any
        //  254    273    478    491    Landroid/database/sqlite/SQLiteException;
        //  254    273    458    465    Any
        //  291    301    478    491    Landroid/database/sqlite/SQLiteException;
        //  291    301    458    465    Any
        //  304    314    478    491    Landroid/database/sqlite/SQLiteException;
        //  304    314    458    465    Any
        //  317    326    478    491    Landroid/database/sqlite/SQLiteException;
        //  317    326    458    465    Any
        //  329    338    478    491    Landroid/database/sqlite/SQLiteException;
        //  329    338    458    465    Any
        //  343    362    401    410    Landroid/database/sqlite/SQLiteException;
        //  343    362    458    465    Any
        //  362    372    401    410    Landroid/database/sqlite/SQLiteException;
        //  362    372    458    465    Any
        //  375    398    401    410    Landroid/database/sqlite/SQLiteException;
        //  375    398    458    465    Any
        //  410    430    465    471    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0232:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final List<zzcek> zzi(final String s, final String s2, final String obj) {
        zzbo.zzcF(s);
        this.zzjC();
        this.zzkD();
        final ArrayList<String> list = new ArrayList<String>(3);
        list.add(s);
        final StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            list.add(s2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty((CharSequence)obj)) {
            list.add(String.valueOf(obj).concat("*"));
            sb.append(" and name glob ?");
        }
        return this.zzc(sb.toString(), list.toArray(new String[list.size()]));
    }
    
    @Override
    protected final void zzjD() {
    }
    
    @WorkerThread
    public final List<Pair<zzcjz, Long>> zzl(final String p0, final int p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          5
        //     3: aload_0        
        //     4: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //     7: aload_0        
        //     8: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //    11: iload_2        
        //    12: ifle            124
        //    15: iconst_1       
        //    16: istore          4
        //    18: iload           4
        //    20: invokestatic    com/google/android/gms/common/internal/zzbo.zzaf:(Z)V
        //    23: iload_3        
        //    24: ifle            130
        //    27: iload           5
        //    29: istore          4
        //    31: iload           4
        //    33: invokestatic    com/google/android/gms/common/internal/zzbo.zzaf:(Z)V
        //    36: aload_1        
        //    37: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    40: pop            
        //    41: aload_0        
        //    42: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    45: ldc_w           "queue"
        //    48: iconst_2       
        //    49: anewarray       Ljava/lang/String;
        //    52: dup            
        //    53: iconst_0       
        //    54: ldc_w           "rowid"
        //    57: aastore        
        //    58: dup            
        //    59: iconst_1       
        //    60: ldc_w           "data"
        //    63: aastore        
        //    64: ldc_w           "app_id=?"
        //    67: iconst_1       
        //    68: anewarray       Ljava/lang/String;
        //    71: dup            
        //    72: iconst_0       
        //    73: aload_1        
        //    74: aastore        
        //    75: aconst_null    
        //    76: aconst_null    
        //    77: ldc_w           "rowid"
        //    80: iload_2        
        //    81: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //    84: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    87: astore          8
        //    89: aload           8
        //    91: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    96: ifne            136
        //    99: invokestatic    java/util/Collections.emptyList:()Ljava/util/List;
        //   102: astore          9
        //   104: aload           9
        //   106: astore_1       
        //   107: aload           8
        //   109: ifnull          122
        //   112: aload           8
        //   114: invokeinterface android/database/Cursor.close:()V
        //   119: aload           9
        //   121: astore_1       
        //   122: aload_1        
        //   123: areturn        
        //   124: iconst_0       
        //   125: istore          4
        //   127: goto            18
        //   130: iconst_0       
        //   131: istore          4
        //   133: goto            31
        //   136: new             Ljava/util/ArrayList;
        //   139: dup            
        //   140: invokespecial   java/util/ArrayList.<init>:()V
        //   143: astore          9
        //   145: iconst_0       
        //   146: istore_2       
        //   147: aload           8
        //   149: iconst_0       
        //   150: invokeinterface android/database/Cursor.getLong:(I)J
        //   155: lstore          6
        //   157: aload           8
        //   159: iconst_1       
        //   160: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   165: astore          10
        //   167: aload_0        
        //   168: invokevirtual   com/google/android/gms/internal/zzcen.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   171: aload           10
        //   173: invokevirtual   com/google/android/gms/internal/zzcjl.zzm:([B)[B
        //   176: astore          10
        //   178: aload           9
        //   180: invokeinterface java/util/List.isEmpty:()Z
        //   185: ifne            197
        //   188: aload           10
        //   190: arraylength    
        //   191: iload_2        
        //   192: iadd           
        //   193: iload_3        
        //   194: if_icmpgt       268
        //   197: aload           10
        //   199: iconst_0       
        //   200: aload           10
        //   202: arraylength    
        //   203: invokestatic    com/google/android/gms/internal/adg.zzb:([BII)Lcom/google/android/gms/internal/adg;
        //   206: astore          11
        //   208: new             Lcom/google/android/gms/internal/zzcjz;
        //   211: dup            
        //   212: invokespecial   com/google/android/gms/internal/zzcjz.<init>:()V
        //   215: astore          12
        //   217: aload           12
        //   219: aload           11
        //   221: invokevirtual   com/google/android/gms/internal/zzcjz.zza:(Lcom/google/android/gms/internal/adg;)Lcom/google/android/gms/internal/adp;
        //   224: pop            
        //   225: aload           10
        //   227: arraylength    
        //   228: iload_2        
        //   229: iadd           
        //   230: istore_2       
        //   231: aload           9
        //   233: aload           12
        //   235: lload           6
        //   237: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   240: invokestatic    android/util/Pair.create:(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
        //   243: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   248: pop            
        //   249: aload           8
        //   251: invokeinterface android/database/Cursor.moveToNext:()Z
        //   256: istore          4
        //   258: iload           4
        //   260: ifeq            268
        //   263: iload_2        
        //   264: iload_3        
        //   265: if_icmple       412
        //   268: aload           9
        //   270: astore_1       
        //   271: aload           8
        //   273: ifnull          122
        //   276: aload           8
        //   278: invokeinterface android/database/Cursor.close:()V
        //   283: aload           9
        //   285: areturn        
        //   286: astore          10
        //   288: aload_0        
        //   289: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   292: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   295: ldc_w           "Failed to unzip queued bundle. appId"
        //   298: aload_1        
        //   299: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   302: aload           10
        //   304: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   307: goto            249
        //   310: astore          10
        //   312: aload_0        
        //   313: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   316: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   319: ldc_w           "Failed to merge queued bundle. appId"
        //   322: aload_1        
        //   323: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   326: aload           10
        //   328: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   331: goto            249
        //   334: astore          9
        //   336: aconst_null    
        //   337: astore          8
        //   339: aload_0        
        //   340: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   343: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   346: ldc_w           "Error querying bundles. appId"
        //   349: aload_1        
        //   350: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   353: aload           9
        //   355: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   358: invokestatic    java/util/Collections.emptyList:()Ljava/util/List;
        //   361: astore          9
        //   363: aload           9
        //   365: astore_1       
        //   366: aload           8
        //   368: ifnull          122
        //   371: aload           8
        //   373: invokeinterface android/database/Cursor.close:()V
        //   378: aload           9
        //   380: areturn        
        //   381: astore_1       
        //   382: aconst_null    
        //   383: astore          8
        //   385: aload           8
        //   387: ifnull          397
        //   390: aload           8
        //   392: invokeinterface android/database/Cursor.close:()V
        //   397: aload_1        
        //   398: athrow         
        //   399: astore_1       
        //   400: goto            385
        //   403: astore_1       
        //   404: goto            385
        //   407: astore          9
        //   409: goto            339
        //   412: goto            147
        //    Signature:
        //  (Ljava/lang/String;II)Ljava/util/List<Landroid/util/Pair<Lcom/google/android/gms/internal/zzcjz;Ljava/lang/Long;>;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  41     89     334    339    Landroid/database/sqlite/SQLiteException;
        //  41     89     381    385    Any
        //  89     104    407    412    Landroid/database/sqlite/SQLiteException;
        //  89     104    399    403    Any
        //  136    145    407    412    Landroid/database/sqlite/SQLiteException;
        //  136    145    399    403    Any
        //  147    157    407    412    Landroid/database/sqlite/SQLiteException;
        //  147    157    399    403    Any
        //  157    178    286    310    Ljava/io/IOException;
        //  157    178    407    412    Landroid/database/sqlite/SQLiteException;
        //  157    178    399    403    Any
        //  178    197    407    412    Landroid/database/sqlite/SQLiteException;
        //  178    197    399    403    Any
        //  197    217    407    412    Landroid/database/sqlite/SQLiteException;
        //  197    217    399    403    Any
        //  217    225    310    334    Ljava/io/IOException;
        //  217    225    407    412    Landroid/database/sqlite/SQLiteException;
        //  217    225    399    403    Any
        //  225    249    407    412    Landroid/database/sqlite/SQLiteException;
        //  225    249    399    403    Any
        //  249    258    407    412    Landroid/database/sqlite/SQLiteException;
        //  249    258    399    403    Any
        //  288    307    407    412    Landroid/database/sqlite/SQLiteException;
        //  288    307    399    403    Any
        //  312    331    407    412    Landroid/database/sqlite/SQLiteException;
        //  312    331    399    403    Any
        //  339    363    403    407    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 196 out of bounds for length 196
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @WorkerThread
    public final String zzyc() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc_w           "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
        //    12: aconst_null    
        //    13: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    16: astore_1       
        //    17: aload_1        
        //    18: astore_2       
        //    19: aload_1        
        //    20: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    25: ifeq            54
        //    28: aload_1        
        //    29: astore_2       
        //    30: aload_1        
        //    31: iconst_0       
        //    32: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //    37: astore_3       
        //    38: aload_3        
        //    39: astore_2       
        //    40: aload_1        
        //    41: ifnull          52
        //    44: aload_1        
        //    45: invokeinterface android/database/Cursor.close:()V
        //    50: aload_3        
        //    51: astore_2       
        //    52: aload_2        
        //    53: areturn        
        //    54: aload           4
        //    56: astore_2       
        //    57: aload_1        
        //    58: ifnull          52
        //    61: aload_1        
        //    62: invokeinterface android/database/Cursor.close:()V
        //    67: aconst_null    
        //    68: areturn        
        //    69: astore_3       
        //    70: aconst_null    
        //    71: astore_1       
        //    72: aload_1        
        //    73: astore_2       
        //    74: aload_0        
        //    75: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //    78: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //    81: ldc_w           "Database error getting next bundle app id"
        //    84: aload_3        
        //    85: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //    88: aload           4
        //    90: astore_2       
        //    91: aload_1        
        //    92: ifnull          52
        //    95: aload_1        
        //    96: invokeinterface android/database/Cursor.close:()V
        //   101: aconst_null    
        //   102: areturn        
        //   103: astore_1       
        //   104: aconst_null    
        //   105: astore_2       
        //   106: aload_2        
        //   107: ifnull          116
        //   110: aload_2        
        //   111: invokeinterface android/database/Cursor.close:()V
        //   116: aload_1        
        //   117: athrow         
        //   118: astore_1       
        //   119: goto            106
        //   122: astore_3       
        //   123: goto            72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  8      17     69     72     Landroid/database/sqlite/SQLiteException;
        //  8      17     103    106    Any
        //  19     28     122    126    Landroid/database/sqlite/SQLiteException;
        //  19     28     118    122    Any
        //  30     38     122    126    Landroid/database/sqlite/SQLiteException;
        //  30     38     118    122    Any
        //  74     88     118    122    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final boolean zzyd() {
        return this.zzb("select count(1) > 0 from queue where has_realtime = 1", null) != 0L;
    }
    
    @WorkerThread
    final void zzye() {
        this.zzjC();
        this.zzkD();
        if (this.zzyk()) {
            final long value = this.zzwG().zzbrn.get();
            final long elapsedRealtime = this.zzkq().elapsedRealtime();
            if (Math.abs(elapsedRealtime - value) > zzcem.zzxH()) {
                this.zzwG().zzbrn.set(elapsedRealtime);
                this.zzjC();
                this.zzkD();
                if (this.zzyk()) {
                    final int delete = this.getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(this.zzkq().currentTimeMillis()), String.valueOf(zzcem.zzxG()) });
                    if (delete > 0) {
                        this.zzwF().zzyD().zzj("Deleted stale rows. rowsDeleted", delete);
                    }
                }
            }
        }
    }
    
    @WorkerThread
    public final long zzyf() {
        return this.zza("select max(bundle_end_timestamp) from queue", null, 0L);
    }
    
    @WorkerThread
    public final long zzyg() {
        return this.zza("select max(timestamp) from raw_events", null, 0L);
    }
    
    public final boolean zzyh() {
        return this.zzb("select count(1) > 0 from raw_events", null) != 0L;
    }
    
    public final boolean zzyi() {
        return this.zzb("select count(1) > 0 from raw_events where realtime = 1", null) != 0L;
    }
    
    public final long zzyj() {
        long n = -1L;
        Cursor cursor = null;
        Cursor rawQuery = null;
        try {
            final Cursor cursor2 = cursor = (rawQuery = this.getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[])null));
            if (!cursor2.moveToFirst()) {
                long long1 = n;
                if (cursor2 != null) {
                    cursor2.close();
                    long1 = n;
                }
                return long1;
            }
            rawQuery = cursor2;
            cursor = cursor2;
            long long1;
            n = (long1 = cursor2.getLong(0));
            return n;
        }
        catch (SQLiteException ex) {
            cursor = rawQuery;
            this.zzwF().zzyx().zzj("Error querying raw events", ex);
            final long long1 = n;
            return -1L;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
