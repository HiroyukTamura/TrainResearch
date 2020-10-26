// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.database.Cursor;
import android.os.Build$VERSION;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

final class zzamt extends SQLiteOpenHelper
{
    private /* synthetic */ zzams zzagu;
    
    zzamt(final zzams zzagu, final Context context, final String s) {
        this.zzagu = zzagu;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
    }
    
    private static void zza(final SQLiteDatabase sqLiteDatabase) {
        int i = 0;
        final Set<String> zzb = zzb(sqLiteDatabase, "properties");
        while (i < 6) {
            final String obj = (new String[] { "app_uid", "cid", "tid", "params", "adid", "hits_count" })[i];
            if (!zzb.remove(obj)) {
                final String value = String.valueOf(obj);
                String concat;
                if (value.length() != 0) {
                    concat = "Database properties is missing required column: ".concat(value);
                }
                else {
                    concat = new String("Database properties is missing required column: ");
                }
                throw new SQLiteException(concat);
            }
            ++i;
        }
        if (!zzb.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }
    
    private final boolean zza(final SQLiteDatabase p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_1        
        //     4: ldc             "SQLITE_MASTER"
        //     6: iconst_1       
        //     7: anewarray       Ljava/lang/String;
        //    10: dup            
        //    11: iconst_0       
        //    12: ldc             "name"
        //    14: aastore        
        //    15: ldc             "name=?"
        //    17: iconst_1       
        //    18: anewarray       Ljava/lang/String;
        //    21: dup            
        //    22: iconst_0       
        //    23: aload_2        
        //    24: aastore        
        //    25: aconst_null    
        //    26: aconst_null    
        //    27: aconst_null    
        //    28: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    31: astore_1       
        //    32: aload_1        
        //    33: astore          4
        //    35: aload           4
        //    37: astore_1       
        //    38: aload           4
        //    40: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    45: istore_3       
        //    46: aload           4
        //    48: ifnull          58
        //    51: aload           4
        //    53: invokeinterface android/database/Cursor.close:()V
        //    58: iload_3        
        //    59: ireturn        
        //    60: astore          5
        //    62: aconst_null    
        //    63: astore          4
        //    65: aload           4
        //    67: astore_1       
        //    68: aload_0        
        //    69: getfield        com/google/android/gms/internal/zzamt.zzagu:Lcom/google/android/gms/internal/zzams;
        //    72: ldc             "Error querying for table"
        //    74: aload_2        
        //    75: aload           5
        //    77: invokevirtual   com/google/android/gms/internal/zzams.zzc:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    80: aload           4
        //    82: ifnull          92
        //    85: aload           4
        //    87: invokeinterface android/database/Cursor.close:()V
        //    92: iconst_0       
        //    93: ireturn        
        //    94: astore_1       
        //    95: aload           4
        //    97: astore_2       
        //    98: aload_2        
        //    99: ifnull          108
        //   102: aload_2        
        //   103: invokeinterface android/database/Cursor.close:()V
        //   108: aload_1        
        //   109: athrow         
        //   110: astore          4
        //   112: aload_1        
        //   113: astore_2       
        //   114: aload           4
        //   116: astore_1       
        //   117: goto            98
        //   120: astore          5
        //   122: goto            65
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  3      32     60     65     Landroid/database/sqlite/SQLiteException;
        //  3      32     94     98     Any
        //  38     46     120    125    Landroid/database/sqlite/SQLiteException;
        //  38     46     110    120    Any
        //  68     80     110    120    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0058:
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
    
    private static Set<String> zzb(SQLiteDatabase rawQuery, final String s) {
        final HashSet<String> set = new HashSet<String>();
        rawQuery = (SQLiteDatabase)rawQuery.rawQuery(new StringBuilder(String.valueOf(s).length() + 22).append("SELECT * FROM ").append(s).append(" LIMIT 0").toString(), (String[])null);
        try {
            final String[] columnNames = ((Cursor)rawQuery).getColumnNames();
            for (int i = 0; i < columnNames.length; ++i) {
                set.add(columnNames[i]);
            }
            return set;
        }
        finally {
            ((Cursor)rawQuery).close();
        }
    }
    
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzagu.zzagt.zzu(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        }
        catch (SQLiteException ex2) {
            this.zzagu.zzagt.start();
            this.zzagu.zzbs("Opening the database failed, dropping the table and recreating it");
            this.zzagu.getContext().getDatabasePath(zzams.zzb(this.zzagu)).delete();
            try {
                final SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.zzagu.zzagt.clear();
                return writableDatabase;
            }
            catch (SQLiteException ex) {
                this.zzagu.zze("Failed to open freshly created database", ex);
                throw ex;
            }
        }
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        final String path = sqLiteDatabase.getPath();
        if (zzanr.version() >= 9) {
            final File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }
    
    public final void onOpen(final SQLiteDatabase sqLiteDatabase) {
        final int n = 1;
        Label_0034: {
            if (Build$VERSION.SDK_INT >= 15) {
                break Label_0034;
            }
            while (true) {
                Object o = sqLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[])null);
            Label_0234:
                while (true) {
                    try {
                        ((Cursor)o).moveToFirst();
                        ((Cursor)o).close();
                        if (!this.zza(sqLiteDatabase, "hits2")) {
                            sqLiteDatabase.execSQL(zzams.zzagp);
                            if (!this.zza(sqLiteDatabase, "properties")) {
                                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
                                return;
                            }
                            break Label_0234;
                        }
                    }
                    finally {
                        ((Cursor)o).close();
                    }
                    o = zzb(sqLiteDatabase, "hits2");
                    for (int i = 0; i < 4; ++i) {
                        final String obj = (new String[] { "hit_id", "hit_string", "hit_time", "hit_url" })[i];
                        if (!((Set)o).remove(obj)) {
                            final String value = String.valueOf(obj);
                            String concat;
                            if (value.length() != 0) {
                                concat = "Database hits2 is missing required column: ".concat(value);
                            }
                            else {
                                concat = new String("Database hits2 is missing required column: ");
                            }
                            throw new SQLiteException(concat);
                        }
                    }
                    int n2;
                    if (!((Set)o).remove("hit_app_id")) {
                        n2 = n;
                    }
                    else {
                        n2 = 0;
                    }
                    if (!((Set)o).isEmpty()) {
                        throw new SQLiteException("Database hits2 has extra columns");
                    }
                    if (n2 != 0) {
                        sqLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
                        continue;
                    }
                    continue;
                }
                zza(sqLiteDatabase);
            }
        }
    }
    
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
}
