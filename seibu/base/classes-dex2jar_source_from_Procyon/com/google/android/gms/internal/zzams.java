// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import android.content.ContentValues;
import android.net.Uri$Builder;
import com.google.android.gms.common.internal.zzbo;
import java.util.List;
import com.google.android.gms.analytics.zzl;
import java.net.URISyntaxException;
import com.google.android.gms.common.util.zzm;
import java.net.URI;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.Map;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.Closeable;

final class zzams extends zzamh implements Closeable
{
    private static final String zzagp;
    private static final String zzagq;
    private final zzamt zzagr;
    private final zzaoo zzags;
    private final zzaoo zzagt;
    
    static {
        zzagp = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
        zzagq = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    }
    
    zzams(final zzamj zzamj) {
        super(zzamj);
        this.zzags = new zzaoo(this.zzkq());
        this.zzagt = new zzaoo(this.zzkq());
        this.zzagr = new zzamt(this, zzamj.getContext(), "google_analytics_v4.db");
    }
    
    private final long zza(final String p0, final String[] p1, final long p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzams.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //     4: astore          7
        //     6: aconst_null    
        //     7: astore          5
        //     9: aconst_null    
        //    10: astore          6
        //    12: aload           7
        //    14: aload_1        
        //    15: aload_2        
        //    16: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    19: astore_2       
        //    20: aload_2        
        //    21: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    26: ifeq            49
        //    29: aload_2        
        //    30: iconst_0       
        //    31: invokeinterface android/database/Cursor.getLong:(I)J
        //    36: lstore_3       
        //    37: aload_2        
        //    38: ifnull          47
        //    41: aload_2        
        //    42: invokeinterface android/database/Cursor.close:()V
        //    47: lload_3        
        //    48: lreturn        
        //    49: aload_2        
        //    50: ifnull          59
        //    53: aload_2        
        //    54: invokeinterface android/database/Cursor.close:()V
        //    59: lconst_0       
        //    60: lreturn        
        //    61: astore          5
        //    63: aload           6
        //    65: astore_2       
        //    66: aload           5
        //    68: astore          6
        //    70: aload_2        
        //    71: astore          5
        //    73: aload_0        
        //    74: ldc             "Database error"
        //    76: aload_1        
        //    77: aload           6
        //    79: invokevirtual   com/google/android/gms/internal/zzams.zzd:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    82: aload_2        
        //    83: astore          5
        //    85: aload           6
        //    87: athrow         
        //    88: astore_1       
        //    89: aload           5
        //    91: ifnull          101
        //    94: aload           5
        //    96: invokeinterface android/database/Cursor.close:()V
        //   101: aload_1        
        //   102: athrow         
        //   103: astore_1       
        //   104: aload_2        
        //   105: astore          5
        //   107: goto            89
        //   110: astore          6
        //   112: goto            70
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  12     20     61     70     Landroid/database/sqlite/SQLiteException;
        //  12     20     88     89     Any
        //  20     37     110    115    Landroid/database/sqlite/SQLiteException;
        //  20     37     103    110    Any
        //  73     82     88     89     Any
        //  85     88     88     89     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0047:
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
    
    private final long zzb(final String s, String[] rawQuery) {
        Object o = null;
        rawQuery = null;
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        try {
            final String[] array = (String[])(o = (rawQuery = (String[])(Object)writableDatabase.rawQuery(s, (String[])null)));
            if (((Cursor)(Object)array).moveToFirst()) {
                rawQuery = array;
                o = array;
                return ((Cursor)(Object)array).getLong(0);
            }
            rawQuery = array;
            o = array;
            throw new SQLiteException("Database returned empty set");
        }
        catch (SQLiteException ex) {
            o = rawQuery;
            this.zzd("Database error", s, ex);
            o = rawQuery;
            throw ex;
        }
        finally {
            if (o != null) {
                ((Cursor)o).close();
            }
        }
    }
    
    private final Map<String, String> zzbt(String str) {
        if (TextUtils.isEmpty((CharSequence)str)) {
            return new HashMap<String, String>(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = String.valueOf(str);
                if (str.length() != 0) {
                    str = "?".concat(str);
                }
                else {
                    str = new String("?");
                }
            }
            return zzm.zza(new URI(str), "UTF-8");
        }
        catch (URISyntaxException ex) {
            this.zze("Error parsing hit parameters", ex);
            return new HashMap<String, String>(0);
        }
    }
    
    private final Map<String, String> zzbu(String str) {
        if (TextUtils.isEmpty((CharSequence)str)) {
            return new HashMap<String, String>(0);
        }
        try {
            str = String.valueOf(str);
            if (str.length() != 0) {
                str = "?".concat(str);
            }
            else {
                str = new String("?");
            }
            return zzm.zza(new URI(str), "UTF-8");
        }
        catch (URISyntaxException ex) {
            this.zze("Error parsing property parameters", ex);
            return new HashMap<String, String>(0);
        }
    }
    
    private final long zzkN() {
        zzl.zzjC();
        this.zzkD();
        return this.zzb("SELECT COUNT(*) FROM hits2", null);
    }
    
    private static String zzkU() {
        return "google_analytics_v4.db";
    }
    
    private final List<Long> zzn(final long p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          5
        //     3: invokestatic    com/google/android/gms/analytics/zzl.zzjC:()V
        //     6: aload_0        
        //     7: invokevirtual   com/google/android/gms/internal/zzams.zzkD:()V
        //    10: lload_1        
        //    11: lconst_0       
        //    12: lcmp           
        //    13: ifgt            20
        //    16: invokestatic    java/util/Collections.emptyList:()Ljava/util/List;
        //    19: areturn        
        //    20: aload_0        
        //    21: invokevirtual   com/google/android/gms/internal/zzams.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    24: astore          4
        //    26: new             Ljava/util/ArrayList;
        //    29: dup            
        //    30: invokespecial   java/util/ArrayList.<init>:()V
        //    33: astore          7
        //    35: ldc             "%s ASC"
        //    37: iconst_1       
        //    38: anewarray       Ljava/lang/Object;
        //    41: dup            
        //    42: iconst_0       
        //    43: ldc             "hit_id"
        //    45: aastore        
        //    46: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    49: astore          6
        //    51: lload_1        
        //    52: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //    55: astore          8
        //    57: aload           4
        //    59: ldc             "hits2"
        //    61: iconst_1       
        //    62: anewarray       Ljava/lang/String;
        //    65: dup            
        //    66: iconst_0       
        //    67: ldc             "hit_id"
        //    69: aastore        
        //    70: aconst_null    
        //    71: aconst_null    
        //    72: aconst_null    
        //    73: aconst_null    
        //    74: aload           6
        //    76: aload           8
        //    78: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    81: astore          4
        //    83: aload           4
        //    85: astore          5
        //    87: aload           5
        //    89: astore          4
        //    91: aload           5
        //    93: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    98: ifeq            140
        //   101: aload           5
        //   103: astore          4
        //   105: aload           7
        //   107: aload           5
        //   109: iconst_0       
        //   110: invokeinterface android/database/Cursor.getLong:(I)J
        //   115: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   118: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   123: pop            
        //   124: aload           5
        //   126: astore          4
        //   128: aload           5
        //   130: invokeinterface android/database/Cursor.moveToNext:()Z
        //   135: istore_3       
        //   136: iload_3        
        //   137: ifne            101
        //   140: aload           5
        //   142: ifnull          152
        //   145: aload           5
        //   147: invokeinterface android/database/Cursor.close:()V
        //   152: aload           7
        //   154: areturn        
        //   155: astore          6
        //   157: aconst_null    
        //   158: astore          5
        //   160: aload           5
        //   162: astore          4
        //   164: aload_0        
        //   165: ldc             "Error selecting hit ids"
        //   167: aload           6
        //   169: invokevirtual   com/google/android/gms/internal/zzams.zzd:(Ljava/lang/String;Ljava/lang/Object;)V
        //   172: aload           5
        //   174: ifnull          152
        //   177: aload           5
        //   179: invokeinterface android/database/Cursor.close:()V
        //   184: goto            152
        //   187: astore          4
        //   189: aload           5
        //   191: ifnull          201
        //   194: aload           5
        //   196: invokeinterface android/database/Cursor.close:()V
        //   201: aload           4
        //   203: athrow         
        //   204: astore          6
        //   206: aload           4
        //   208: astore          5
        //   210: aload           6
        //   212: astore          4
        //   214: goto            189
        //   217: astore          6
        //   219: goto            160
        //    Signature:
        //  (J)Ljava/util/List<Ljava/lang/Long;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  35     83     155    160    Landroid/database/sqlite/SQLiteException;
        //  35     83     187    189    Any
        //  91     101    217    222    Landroid/database/sqlite/SQLiteException;
        //  91     101    204    217    Any
        //  105    124    217    222    Landroid/database/sqlite/SQLiteException;
        //  105    124    204    217    Any
        //  128    136    217    222    Landroid/database/sqlite/SQLiteException;
        //  128    136    204    217    Any
        //  164    172    204    217    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0101:
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
    
    public final void beginTransaction() {
        this.zzkD();
        this.getWritableDatabase().beginTransaction();
    }
    
    @Override
    public final void close() {
        try {
            this.zzagr.close();
        }
        catch (SQLiteException ex) {
            this.zze("Sql error closing database", ex);
        }
        catch (IllegalStateException ex2) {
            this.zze("Error closing database", ex2);
        }
    }
    
    public final void endTransaction() {
        this.zzkD();
        this.getWritableDatabase().endTransaction();
    }
    
    final SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzagr.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            this.zzd("Error opening database", ex);
            throw ex;
        }
    }
    
    final boolean isEmpty() {
        return this.zzkN() == 0L;
    }
    
    public final void setTransactionSuccessful() {
        this.zzkD();
        this.getWritableDatabase().setTransactionSuccessful();
    }
    
    public final long zza(final long l, final String s, final String s2) {
        zzbo.zzcF(s);
        zzbo.zzcF(s2);
        this.zzkD();
        zzl.zzjC();
        return this.zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[] { String.valueOf(l), s, s2 }, 0L);
    }
    
    public final void zzc(final zzanx zzanx) {
        zzbo.zzu(zzanx);
        zzl.zzjC();
        this.zzkD();
        zzbo.zzu(zzanx);
        final Uri$Builder uri$Builder = new Uri$Builder();
        for (final Map.Entry<String, String> entry : zzanx.zzdV().entrySet()) {
            final String anObject = entry.getKey();
            if (!"ht".equals(anObject) && !"qt".equals(anObject) && !"AppUID".equals(anObject)) {
                uri$Builder.appendQueryParameter(anObject, (String)entry.getValue());
            }
        }
        String encodedQuery = uri$Builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            this.zzkr().zza(zzanx, "Hit length exceeds the maximum allowed size");
            return;
        }
        final int intValue = zzans.zzahj.get();
        final long zzkN = this.zzkN();
        if (zzkN > intValue - 1) {
            final List<Long> zzn = this.zzn(zzkN - intValue + 1L);
            this.zzd("Store full, deleting hits to make room, count", zzn.size());
            this.zzs(zzn);
        }
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzanx.zzlG()));
        contentValues.put("hit_app_id", Integer.valueOf(zzanx.zzlE()));
        while (true) {
            Label_0348: {
                if (!zzanx.zzlI()) {
                    break Label_0348;
                }
                final String s = zzank.zzlu();
                contentValues.put("hit_url", s);
                long insert = 0L;
                Label_0356: {
                    try {
                        insert = writableDatabase.insert("hits2", (String)null, contentValues);
                        if (insert == -1L) {
                            this.zzbs("Failed to insert a hit (got -1)");
                            return;
                        }
                        break Label_0356;
                    }
                    catch (SQLiteException ex) {
                        this.zze("Error storing a hit", ex);
                        return;
                    }
                    break Label_0348;
                }
                this.zzb("Hit saved to database. db-id, hit", insert, zzanx);
                return;
            }
            final String s = zzank.zzlv();
            continue;
        }
    }
    
    @Override
    protected final void zzjD() {
    }
    
    public final int zzkS() {
        zzl.zzjC();
        this.zzkD();
        if (!this.zzags.zzu(86400000L)) {
            return 0;
        }
        this.zzags.start();
        this.zzbo("Deleting stale hits (if any)");
        final int delete = this.getWritableDatabase().delete("hits2", "hit_time < ?", new String[] { Long.toString(this.zzkq().currentTimeMillis() - 2592000000L) });
        this.zza("Deleted stale hits, count", delete);
        return delete;
    }
    
    public final long zzkT() {
        zzl.zzjC();
        this.zzkD();
        return this.zza(zzams.zzagq, null, 0L);
    }
    
    public final List<zzanx> zzo(final long p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          6
        //     3: aconst_null    
        //     4: astore          8
        //     6: lload_1        
        //     7: lconst_0       
        //     8: lcmp           
        //     9: iflt            273
        //    12: iload           6
        //    14: invokestatic    com/google/android/gms/common/internal/zzbo.zzaf:(Z)V
        //    17: invokestatic    com/google/android/gms/analytics/zzl.zzjC:()V
        //    20: aload_0        
        //    21: invokevirtual   com/google/android/gms/internal/zzams.zzkD:()V
        //    24: aload_0        
        //    25: invokevirtual   com/google/android/gms/internal/zzams.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    28: astore          9
        //    30: aload           8
        //    32: astore          7
        //    34: ldc             "%s ASC"
        //    36: iconst_1       
        //    37: anewarray       Ljava/lang/Object;
        //    40: dup            
        //    41: iconst_0       
        //    42: ldc             "hit_id"
        //    44: aastore        
        //    45: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    48: astore          10
        //    50: aload           8
        //    52: astore          7
        //    54: lload_1        
        //    55: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //    58: astore          11
        //    60: aload           8
        //    62: astore          7
        //    64: aload           9
        //    66: ldc             "hits2"
        //    68: iconst_5       
        //    69: anewarray       Ljava/lang/String;
        //    72: dup            
        //    73: iconst_0       
        //    74: ldc             "hit_id"
        //    76: aastore        
        //    77: dup            
        //    78: iconst_1       
        //    79: ldc             "hit_time"
        //    81: aastore        
        //    82: dup            
        //    83: iconst_2       
        //    84: ldc             "hit_string"
        //    86: aastore        
        //    87: dup            
        //    88: iconst_3       
        //    89: ldc             "hit_url"
        //    91: aastore        
        //    92: dup            
        //    93: iconst_4       
        //    94: ldc             "hit_app_id"
        //    96: aastore        
        //    97: aconst_null    
        //    98: aconst_null    
        //    99: aconst_null    
        //   100: aconst_null    
        //   101: aload           10
        //   103: aload           11
        //   105: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   108: astore          8
        //   110: aload           8
        //   112: astore          7
        //   114: new             Ljava/util/ArrayList;
        //   117: dup            
        //   118: invokespecial   java/util/ArrayList.<init>:()V
        //   121: astore          9
        //   123: aload           8
        //   125: astore          7
        //   127: aload           8
        //   129: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   134: ifeq            258
        //   137: aload           8
        //   139: astore          7
        //   141: aload           8
        //   143: iconst_0       
        //   144: invokeinterface android/database/Cursor.getLong:(I)J
        //   149: lstore_1       
        //   150: aload           8
        //   152: astore          7
        //   154: aload           8
        //   156: iconst_1       
        //   157: invokeinterface android/database/Cursor.getLong:(I)J
        //   162: lstore          4
        //   164: aload           8
        //   166: astore          7
        //   168: aload           8
        //   170: iconst_2       
        //   171: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   176: astore          10
        //   178: aload           8
        //   180: astore          7
        //   182: aload           8
        //   184: iconst_3       
        //   185: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   190: astore          11
        //   192: aload           8
        //   194: astore          7
        //   196: aload           8
        //   198: iconst_4       
        //   199: invokeinterface android/database/Cursor.getInt:(I)I
        //   204: istore_3       
        //   205: aload           8
        //   207: astore          7
        //   209: aload           9
        //   211: new             Lcom/google/android/gms/internal/zzanx;
        //   214: dup            
        //   215: aload_0        
        //   216: aload_0        
        //   217: aload           10
        //   219: invokespecial   com/google/android/gms/internal/zzams.zzbt:(Ljava/lang/String;)Ljava/util/Map;
        //   222: lload           4
        //   224: aload           11
        //   226: invokestatic    com/google/android/gms/internal/zzaos.zzbF:(Ljava/lang/String;)Z
        //   229: lload_1        
        //   230: iload_3        
        //   231: invokespecial   com/google/android/gms/internal/zzanx.<init>:(Lcom/google/android/gms/internal/zzamg;Ljava/util/Map;JZJI)V
        //   234: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   239: pop            
        //   240: aload           8
        //   242: astore          7
        //   244: aload           8
        //   246: invokeinterface android/database/Cursor.moveToNext:()Z
        //   251: istore          6
        //   253: iload           6
        //   255: ifne            137
        //   258: aload           8
        //   260: ifnull          270
        //   263: aload           8
        //   265: invokeinterface android/database/Cursor.close:()V
        //   270: aload           9
        //   272: areturn        
        //   273: iconst_0       
        //   274: istore          6
        //   276: goto            12
        //   279: astore          8
        //   281: aconst_null    
        //   282: astore          7
        //   284: aload_0        
        //   285: ldc_w           "Error loading hits from the database"
        //   288: aload           8
        //   290: invokevirtual   com/google/android/gms/internal/zzams.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   293: aload           8
        //   295: athrow         
        //   296: astore          8
        //   298: aload           7
        //   300: ifnull          310
        //   303: aload           7
        //   305: invokeinterface android/database/Cursor.close:()V
        //   310: aload           8
        //   312: athrow         
        //   313: astore          8
        //   315: goto            298
        //   318: astore          9
        //   320: aload           8
        //   322: astore          7
        //   324: aload           9
        //   326: astore          8
        //   328: goto            284
        //    Signature:
        //  (J)Ljava/util/List<Lcom/google/android/gms/internal/zzanx;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  34     50     279    284    Landroid/database/sqlite/SQLiteException;
        //  34     50     313    318    Any
        //  54     60     279    284    Landroid/database/sqlite/SQLiteException;
        //  54     60     313    318    Any
        //  64     110    279    284    Landroid/database/sqlite/SQLiteException;
        //  64     110    313    318    Any
        //  114    123    318    331    Landroid/database/sqlite/SQLiteException;
        //  114    123    313    318    Any
        //  127    137    318    331    Landroid/database/sqlite/SQLiteException;
        //  127    137    313    318    Any
        //  141    150    318    331    Landroid/database/sqlite/SQLiteException;
        //  141    150    313    318    Any
        //  154    164    318    331    Landroid/database/sqlite/SQLiteException;
        //  154    164    313    318    Any
        //  168    178    318    331    Landroid/database/sqlite/SQLiteException;
        //  168    178    313    318    Any
        //  182    192    318    331    Landroid/database/sqlite/SQLiteException;
        //  182    192    313    318    Any
        //  196    205    318    331    Landroid/database/sqlite/SQLiteException;
        //  196    205    313    318    Any
        //  209    240    318    331    Landroid/database/sqlite/SQLiteException;
        //  209    240    313    318    Any
        //  244    253    318    331    Landroid/database/sqlite/SQLiteException;
        //  244    253    313    318    Any
        //  284    296    296    298    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0137:
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
    
    public final void zzp(final long n) {
        zzl.zzjC();
        this.zzkD();
        final ArrayList<Long> list = new ArrayList<Long>(1);
        list.add(n);
        this.zza("Deleting hit, id", n);
        this.zzs(list);
    }
    
    public final List<zzamm> zzq(long n) {
        this.zzkD();
        zzl.zzjC();
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        Cursor query;
        final Cursor cursor = query = null;
        while (true) {
            try {
                try {
                    final int intValue = zzans.zzahl.get();
                    query = cursor;
                    final Cursor cursor2 = query = writableDatabase.query("properties", new String[] { "cid", "tid", "adid", "hits_count", "params" }, "app_uid=?", new String[] { "0" }, (String)null, (String)null, (String)null, String.valueOf(intValue));
                    SQLiteException ex;
                    try {
                        final ArrayList<zzamm> list = new ArrayList<zzamm>();
                        query = cursor2;
                        if (cursor2.moveToFirst()) {
                            do {
                                query = cursor2;
                                final String string = cursor2.getString(0);
                                query = cursor2;
                                final String string2 = cursor2.getString(1);
                                query = cursor2;
                                final boolean b = cursor2.getInt(2) != 0;
                                query = cursor2;
                                n = cursor2.getInt(3);
                                query = cursor2;
                                final Map<String, String> zzbu = this.zzbu(cursor2.getString(4));
                                query = cursor2;
                                Label_0245: {
                                    if (!TextUtils.isEmpty((CharSequence)string)) {
                                        query = cursor2;
                                        if (!TextUtils.isEmpty((CharSequence)string2)) {
                                            query = cursor2;
                                            list.add(new zzamm(0L, string, string2, b, n, zzbu));
                                            break Label_0245;
                                        }
                                    }
                                    query = cursor2;
                                    this.zzc("Read property with empty client id or tracker id", string, string2);
                                }
                                query = cursor2;
                            } while (cursor2.moveToNext());
                        }
                        query = cursor2;
                        if (list.size() >= intValue) {
                            query = cursor2;
                            this.zzbr("Sending hits to too many properties. Campaign report might be incorrect");
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return list;
                    }
                    catch (SQLiteException ex2) {
                        query = cursor2;
                        ex = ex2;
                    }
                    try {
                        this.zze("Error loading hits from the database", ex);
                        throw ex;
                    }
                    finally {}
                    if (query != null) {
                        query.close();
                    }
                    throw;
                }
                finally {}
            }
            catch (SQLiteException ex) {
                query = null;
                continue;
            }
            break;
        }
    }
    
    public final void zzs(final List<Long> list) {
        zzbo.zzu(list);
        zzl.zzjC();
        this.zzkD();
        if (!list.isEmpty()) {
            final StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i = 0; i < list.size(); ++i) {
                final Long obj = list.get(i);
                if (obj == null || obj == 0L) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(obj);
            }
            sb.append(")");
            final String string = sb.toString();
            try {
                final SQLiteDatabase writableDatabase = this.getWritableDatabase();
                this.zza("Deleting dispatched hits. count", list.size());
                final int delete = writableDatabase.delete("hits2", string, (String[])null);
                if (delete != list.size()) {
                    this.zzb("Deleted fewer hits then expected", list.size(), delete, string);
                }
            }
            catch (SQLiteException ex) {
                this.zze("Error deleting hits", ex);
                throw ex;
            }
        }
    }
}
