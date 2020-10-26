// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Set;
import android.database.Cursor;
import java.util.HashSet;
import android.os.Build$VERSION;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

final class zzee extends SQLiteOpenHelper
{
    private /* synthetic */ zzec zzbFA;
    private boolean zzbFB;
    private long zzbFC;
    
    zzee(final zzec zzbFA, final Context context, final String s) {
        this.zzbFA = zzbFA;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
        this.zzbFC = 0L;
    }
    
    private static boolean zza(final String p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: aload_1        
        //     3: ldc             "SQLITE_MASTER"
        //     5: iconst_1       
        //     6: anewarray       Ljava/lang/String;
        //     9: dup            
        //    10: iconst_0       
        //    11: ldc             "name"
        //    13: aastore        
        //    14: ldc             "name=?"
        //    16: iconst_1       
        //    17: anewarray       Ljava/lang/String;
        //    20: dup            
        //    21: iconst_0       
        //    22: aload_0        
        //    23: aastore        
        //    24: aconst_null    
        //    25: aconst_null    
        //    26: aconst_null    
        //    27: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    30: astore_1       
        //    31: aload_1        
        //    32: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    37: istore_2       
        //    38: aload_1        
        //    39: ifnull          48
        //    42: aload_1        
        //    43: invokeinterface android/database/Cursor.close:()V
        //    48: iload_2        
        //    49: ireturn        
        //    50: astore_1       
        //    51: aconst_null    
        //    52: astore_1       
        //    53: aload_0        
        //    54: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    57: astore_0       
        //    58: aload_0        
        //    59: invokevirtual   java/lang/String.length:()I
        //    62: ifeq            88
        //    65: ldc             "Error querying for table "
        //    67: aload_0        
        //    68: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //    71: astore_0       
        //    72: aload_0        
        //    73: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    76: aload_1        
        //    77: ifnull          86
        //    80: aload_1        
        //    81: invokeinterface android/database/Cursor.close:()V
        //    86: iconst_0       
        //    87: ireturn        
        //    88: new             Ljava/lang/String;
        //    91: dup            
        //    92: ldc             "Error querying for table "
        //    94: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //    97: astore_0       
        //    98: goto            72
        //   101: astore_0       
        //   102: aload_1        
        //   103: ifnull          112
        //   106: aload_1        
        //   107: invokeinterface android/database/Cursor.close:()V
        //   112: aload_0        
        //   113: athrow         
        //   114: astore_0       
        //   115: aload_3        
        //   116: astore_1       
        //   117: goto            102
        //   120: astore_0       
        //   121: goto            102
        //   124: astore_3       
        //   125: goto            53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  2      31     50     53     Landroid/database/sqlite/SQLiteException;
        //  2      31     114    120    Any
        //  31     38     124    128    Landroid/database/sqlite/SQLiteException;
        //  31     38     120    124    Any
        //  53     72     101    102    Any
        //  72     76     101    102    Any
        //  88     98     101    102    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0048:
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
    
    public final SQLiteDatabase getWritableDatabase() {
        if (this.zzbFB && this.zzbFC + 3600000L > this.zzbFA.zzvw.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
        }
        SQLiteDatabase writableDatabase = null;
        this.zzbFB = true;
        this.zzbFC = this.zzbFA.zzvw.currentTimeMillis();
        while (true) {
            try {
                writableDatabase = super.getWritableDatabase();
                SQLiteDatabase writableDatabase2 = writableDatabase;
                if (writableDatabase == null) {
                    writableDatabase2 = super.getWritableDatabase();
                }
                this.zzbFB = false;
                return writableDatabase2;
            }
            catch (SQLiteException ex) {
                this.zzbFA.mContext.getDatabasePath(this.zzbFA.zzbFx).delete();
                continue;
            }
            break;
        }
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        zzbs.zzfk(sqLiteDatabase.getPath());
    }
    
    public final void onDowngrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
    
    public final void onOpen(SQLiteDatabase rawQuery) {
        while (true) {
            if (Build$VERSION.SDK_INT < 15) {
                while (true) {
                    final Cursor rawQuery2 = rawQuery.rawQuery("PRAGMA journal_mode=memory", (String[])null);
                    try {
                        rawQuery2.moveToFirst();
                        rawQuery2.close();
                        if (!zza("gtm_hits", rawQuery)) {
                            rawQuery.execSQL(zzec.zzagp);
                            return;
                        }
                    }
                    finally {
                        rawQuery2.close();
                    }
                    final SQLiteDatabase sqLiteDatabase;
                    rawQuery = (SQLiteDatabase)sqLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", (String[])null);
                    final HashSet<String> set = new HashSet<String>();
                    try {
                        final String[] columnNames = ((Cursor)rawQuery).getColumnNames();
                        for (int i = 0; i < columnNames.length; ++i) {
                            set.add(columnNames[i]);
                        }
                        ((Cursor)rawQuery).close();
                        if (!set.remove("hit_id") || !set.remove("hit_url") || !set.remove("hit_time") || !set.remove("hit_first_send_time")) {
                            throw new SQLiteException("Database column missing");
                        }
                    }
                    finally {
                        ((Cursor)rawQuery).close();
                    }
                    if (!((Set)rawQuery2).isEmpty()) {
                        break;
                    }
                    return;
                }
                throw new SQLiteException("Database has extra columns");
            }
            continue;
        }
    }
    
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
}
