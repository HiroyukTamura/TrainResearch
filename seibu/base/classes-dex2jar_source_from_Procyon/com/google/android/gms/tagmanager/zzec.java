// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zze;
import android.content.Context;

final class zzec implements zzcc
{
    private static final String zzagp;
    private final Context mContext;
    private final zzee zzbFu;
    private volatile zzbe zzbFv;
    private final zzcd zzbFw;
    private final String zzbFx;
    private long zzbFy;
    private final int zzbFz;
    private zze zzvw;
    
    static {
        zzagp = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    }
    
    zzec(final zzcd zzcd, final Context context) {
        this(zzcd, context, "gtm_urls.db", 2000);
    }
    
    private zzec(final zzcd zzbFw, final Context context, final String zzbFx, final int n) {
        this.mContext = context.getApplicationContext();
        this.zzbFx = zzbFx;
        this.zzbFw = zzbFw;
        this.zzvw = zzi.zzrY();
        this.zzbFu = new zzee(this, this.mContext, this.zzbFx);
        this.zzbFv = new zzfv(this.mContext, new zzed(this));
        this.zzbFy = 0L;
        this.zzbFz = 2000;
    }
    
    private final int zzBA() {
        Cursor cursor = null;
        Cursor rawQuery = null;
        int n = 0;
        int n2 = 0;
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for getNumStoredHits.");
        if (zzfg == null) {
            return n2;
        }
        try {
            final Cursor cursor2 = cursor = (rawQuery = zzfg.rawQuery("SELECT COUNT(*) from gtm_hits", (String[])null));
            if (cursor2.moveToFirst()) {
                rawQuery = cursor2;
                cursor = cursor2;
                n = (int)cursor2.getLong(0);
            }
            n2 = n;
            return n;
        }
        catch (SQLiteException cursor) {
            cursor = rawQuery;
            zzdj.zzaT("Error getting numStoredHits");
            return 0;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
    private final int zzBB() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: ldc             "Error opening database for getNumStoredHits."
        //     6: invokespecial   com/google/android/gms/tagmanager/zzec.zzfg:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //     9: astore_3       
        //    10: aload_3        
        //    11: ifnonnull       16
        //    14: iconst_0       
        //    15: ireturn        
        //    16: aload_3        
        //    17: ldc             "gtm_hits"
        //    19: iconst_2       
        //    20: anewarray       Ljava/lang/String;
        //    23: dup            
        //    24: iconst_0       
        //    25: ldc             "hit_id"
        //    27: aastore        
        //    28: dup            
        //    29: iconst_1       
        //    30: ldc             "hit_first_send_time"
        //    32: aastore        
        //    33: ldc             "hit_first_send_time=0"
        //    35: aconst_null    
        //    36: aconst_null    
        //    37: aconst_null    
        //    38: aconst_null    
        //    39: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    42: astore_3       
        //    43: aload_3        
        //    44: invokeinterface android/database/Cursor.getCount:()I
        //    49: istore_2       
        //    50: iload_2        
        //    51: istore_1       
        //    52: aload_3        
        //    53: ifnull          64
        //    56: aload_3        
        //    57: invokeinterface android/database/Cursor.close:()V
        //    62: iload_2        
        //    63: istore_1       
        //    64: iload_1        
        //    65: ireturn        
        //    66: astore_3       
        //    67: aconst_null    
        //    68: astore_3       
        //    69: ldc             "Error getting num untried hits"
        //    71: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    74: aload_3        
        //    75: ifnull          131
        //    78: aload_3        
        //    79: invokeinterface android/database/Cursor.close:()V
        //    84: iconst_0       
        //    85: istore_1       
        //    86: goto            64
        //    89: astore_3       
        //    90: aload           4
        //    92: ifnull          102
        //    95: aload           4
        //    97: invokeinterface android/database/Cursor.close:()V
        //   102: aload_3        
        //   103: athrow         
        //   104: astore          5
        //   106: aload_3        
        //   107: astore          4
        //   109: aload           5
        //   111: astore_3       
        //   112: goto            90
        //   115: astore          5
        //   117: aload_3        
        //   118: astore          4
        //   120: aload           5
        //   122: astore_3       
        //   123: goto            90
        //   126: astore          4
        //   128: goto            69
        //   131: iconst_0       
        //   132: istore_1       
        //   133: goto            64
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  16     43     66     69     Landroid/database/sqlite/SQLiteException;
        //  16     43     89     90     Any
        //  43     50     126    131    Landroid/database/sqlite/SQLiteException;
        //  43     50     104    115    Any
        //  69     74     115    126    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 78 out of bounds for length 78
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
    
    private final List<String> zzbD(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore          6
        //     9: iload_1        
        //    10: ifgt            21
        //    13: ldc             "Invalid maxHits specified. Skipping"
        //    15: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    18: aload           6
        //    20: areturn        
        //    21: aload_0        
        //    22: ldc             "Error opening database for peekHitIds."
        //    24: invokespecial   com/google/android/gms/tagmanager/zzec.zzfg:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    27: astore_3       
        //    28: aload_3        
        //    29: ifnonnull       35
        //    32: aload           6
        //    34: areturn        
        //    35: ldc             "%s ASC"
        //    37: iconst_1       
        //    38: anewarray       Ljava/lang/Object;
        //    41: dup            
        //    42: iconst_0       
        //    43: ldc             "hit_id"
        //    45: aastore        
        //    46: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    49: astore          4
        //    51: iload_1        
        //    52: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    55: astore          5
        //    57: aload_3        
        //    58: ldc             "gtm_hits"
        //    60: iconst_1       
        //    61: anewarray       Ljava/lang/String;
        //    64: dup            
        //    65: iconst_0       
        //    66: ldc             "hit_id"
        //    68: aastore        
        //    69: aconst_null    
        //    70: aconst_null    
        //    71: aconst_null    
        //    72: aconst_null    
        //    73: aload           4
        //    75: aload           5
        //    77: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    80: astore          4
        //    82: aload           4
        //    84: astore_3       
        //    85: aload           4
        //    87: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    92: ifeq            132
        //    95: aload           4
        //    97: astore_3       
        //    98: aload           6
        //   100: aload           4
        //   102: iconst_0       
        //   103: invokeinterface android/database/Cursor.getLong:(I)J
        //   108: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   111: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   116: pop            
        //   117: aload           4
        //   119: astore_3       
        //   120: aload           4
        //   122: invokeinterface android/database/Cursor.moveToNext:()Z
        //   127: istore_2       
        //   128: iload_2        
        //   129: ifne            95
        //   132: aload           4
        //   134: ifnull          144
        //   137: aload           4
        //   139: invokeinterface android/database/Cursor.close:()V
        //   144: aload           6
        //   146: areturn        
        //   147: astore          5
        //   149: aconst_null    
        //   150: astore          4
        //   152: aload           4
        //   154: astore_3       
        //   155: aload           5
        //   157: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   160: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   163: astore          5
        //   165: aload           4
        //   167: astore_3       
        //   168: aload           5
        //   170: invokevirtual   java/lang/String.length:()I
        //   173: ifeq            211
        //   176: aload           4
        //   178: astore_3       
        //   179: ldc             "Error in peekHits fetching hitIds: "
        //   181: aload           5
        //   183: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   186: astore          5
        //   188: aload           4
        //   190: astore_3       
        //   191: aload           5
        //   193: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   196: aload           4
        //   198: ifnull          144
        //   201: aload           4
        //   203: invokeinterface android/database/Cursor.close:()V
        //   208: goto            144
        //   211: aload           4
        //   213: astore_3       
        //   214: new             Ljava/lang/String;
        //   217: dup            
        //   218: ldc             "Error in peekHits fetching hitIds: "
        //   220: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   223: astore          5
        //   225: goto            188
        //   228: astore          5
        //   230: aload_3        
        //   231: astore          4
        //   233: aload           5
        //   235: astore_3       
        //   236: aload           4
        //   238: ifnull          248
        //   241: aload           4
        //   243: invokeinterface android/database/Cursor.close:()V
        //   248: aload_3        
        //   249: athrow         
        //   250: astore_3       
        //   251: aconst_null    
        //   252: astore          4
        //   254: goto            236
        //   257: astore          5
        //   259: goto            152
        //    Signature:
        //  (I)Ljava/util/List<Ljava/lang/String;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  35     82     147    152    Landroid/database/sqlite/SQLiteException;
        //  35     82     250    257    Any
        //  85     95     257    262    Landroid/database/sqlite/SQLiteException;
        //  85     95     228    236    Any
        //  98     117    257    262    Landroid/database/sqlite/SQLiteException;
        //  98     117    228    236    Any
        //  120    128    257    262    Landroid/database/sqlite/SQLiteException;
        //  120    128    228    236    Any
        //  155    165    228    236    Any
        //  168    176    228    236    Any
        //  179    188    228    236    Any
        //  191    196    228    236    Any
        //  214    225    228    236    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0095:
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
    
    private final List<zzbx> zzbE(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore          7
        //     9: aload_0        
        //    10: ldc             "Error opening database for peekHits"
        //    12: invokespecial   com/google/android/gms/tagmanager/zzec.zzfg:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    15: astore          10
        //    17: aload           10
        //    19: ifnonnull       29
        //    22: aload           7
        //    24: astore          8
        //    26: aload           8
        //    28: areturn        
        //    29: aconst_null    
        //    30: astore          8
        //    32: ldc             "%s ASC"
        //    34: iconst_1       
        //    35: anewarray       Ljava/lang/Object;
        //    38: dup            
        //    39: iconst_0       
        //    40: ldc             "hit_id"
        //    42: aastore        
        //    43: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    46: astore          6
        //    48: bipush          40
        //    50: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    53: astore          9
        //    55: aload           10
        //    57: ldc             "gtm_hits"
        //    59: iconst_3       
        //    60: anewarray       Ljava/lang/String;
        //    63: dup            
        //    64: iconst_0       
        //    65: ldc             "hit_id"
        //    67: aastore        
        //    68: dup            
        //    69: iconst_1       
        //    70: ldc             "hit_time"
        //    72: aastore        
        //    73: dup            
        //    74: iconst_2       
        //    75: ldc             "hit_first_send_time"
        //    77: aastore        
        //    78: aconst_null    
        //    79: aconst_null    
        //    80: aconst_null    
        //    81: aconst_null    
        //    82: aload           6
        //    84: aload           9
        //    86: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    89: astore          6
        //    91: new             Ljava/util/ArrayList;
        //    94: dup            
        //    95: invokespecial   java/util/ArrayList.<init>:()V
        //    98: astore          9
        //   100: aload           6
        //   102: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   107: ifeq            163
        //   110: aload           9
        //   112: new             Lcom/google/android/gms/tagmanager/zzbx;
        //   115: dup            
        //   116: aload           6
        //   118: iconst_0       
        //   119: invokeinterface android/database/Cursor.getLong:(I)J
        //   124: aload           6
        //   126: iconst_1       
        //   127: invokeinterface android/database/Cursor.getLong:(I)J
        //   132: aload           6
        //   134: iconst_2       
        //   135: invokeinterface android/database/Cursor.getLong:(I)J
        //   140: invokespecial   com/google/android/gms/tagmanager/zzbx.<init>:(JJJ)V
        //   143: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   148: pop            
        //   149: aload           6
        //   151: invokeinterface android/database/Cursor.moveToNext:()Z
        //   156: istore          5
        //   158: iload           5
        //   160: ifne            110
        //   163: aload           6
        //   165: ifnull          175
        //   168: aload           6
        //   170: invokeinterface android/database/Cursor.close:()V
        //   175: aload           6
        //   177: astore          7
        //   179: ldc             "%s ASC"
        //   181: iconst_1       
        //   182: anewarray       Ljava/lang/Object;
        //   185: dup            
        //   186: iconst_0       
        //   187: ldc             "hit_id"
        //   189: aastore        
        //   190: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   193: astore          8
        //   195: aload           6
        //   197: astore          7
        //   199: bipush          40
        //   201: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   204: astore          11
        //   206: aload           6
        //   208: astore          7
        //   210: aload           10
        //   212: ldc             "gtm_hits"
        //   214: iconst_2       
        //   215: anewarray       Ljava/lang/String;
        //   218: dup            
        //   219: iconst_0       
        //   220: ldc             "hit_id"
        //   222: aastore        
        //   223: dup            
        //   224: iconst_1       
        //   225: ldc             "hit_url"
        //   227: aastore        
        //   228: aconst_null    
        //   229: aconst_null    
        //   230: aconst_null    
        //   231: aconst_null    
        //   232: aload           8
        //   234: aload           11
        //   236: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   239: astore          10
        //   241: aload           10
        //   243: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   248: ifeq            303
        //   251: iconst_0       
        //   252: istore_1       
        //   253: aload           10
        //   255: checkcast       Landroid/database/sqlite/SQLiteCursor;
        //   258: invokevirtual   android/database/sqlite/SQLiteCursor.getWindow:()Landroid/database/CursorWindow;
        //   261: invokevirtual   android/database/CursorWindow.getNumRows:()I
        //   264: ifle            417
        //   267: aload           9
        //   269: iload_1        
        //   270: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   275: checkcast       Lcom/google/android/gms/tagmanager/zzbx;
        //   278: aload           10
        //   280: iconst_1       
        //   281: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   286: invokevirtual   com/google/android/gms/tagmanager/zzbx.zzfl:(Ljava/lang/String;)V
        //   289: aload           10
        //   291: invokeinterface android/database/Cursor.moveToNext:()Z
        //   296: istore          5
        //   298: iload           5
        //   300: ifne            724
        //   303: aload           9
        //   305: astore          8
        //   307: aload           10
        //   309: ifnull          26
        //   312: aload           10
        //   314: invokeinterface android/database/Cursor.close:()V
        //   319: aload           9
        //   321: areturn        
        //   322: astore          8
        //   324: aconst_null    
        //   325: astore          6
        //   327: aload           8
        //   329: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   332: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   335: astore          8
        //   337: aload           8
        //   339: invokevirtual   java/lang/String.length:()I
        //   342: ifeq            378
        //   345: ldc             "Error in peekHits fetching hitIds: "
        //   347: aload           8
        //   349: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   352: astore          8
        //   354: aload           8
        //   356: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   359: aload           7
        //   361: astore          8
        //   363: aload           6
        //   365: ifnull          26
        //   368: aload           6
        //   370: invokeinterface android/database/Cursor.close:()V
        //   375: aload           7
        //   377: areturn        
        //   378: new             Ljava/lang/String;
        //   381: dup            
        //   382: ldc             "Error in peekHits fetching hitIds: "
        //   384: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   387: astore          8
        //   389: goto            354
        //   392: astore          8
        //   394: aload           6
        //   396: astore          7
        //   398: aload           8
        //   400: astore          6
        //   402: aload           7
        //   404: ifnull          414
        //   407: aload           7
        //   409: invokeinterface android/database/Cursor.close:()V
        //   414: aload           6
        //   416: athrow         
        //   417: ldc             "HitString for hitId %d too large.  Hit will be deleted."
        //   419: iconst_1       
        //   420: anewarray       Ljava/lang/Object;
        //   423: dup            
        //   424: iconst_0       
        //   425: aload           9
        //   427: iload_1        
        //   428: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   433: checkcast       Lcom/google/android/gms/tagmanager/zzbx;
        //   436: invokevirtual   com/google/android/gms/tagmanager/zzbx.zzBm:()J
        //   439: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   442: aastore        
        //   443: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   446: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   449: goto            289
        //   452: astore          8
        //   454: aload           10
        //   456: astore          6
        //   458: aload           6
        //   460: astore          7
        //   462: aload           8
        //   464: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   467: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   470: astore          8
        //   472: aload           6
        //   474: astore          7
        //   476: aload           8
        //   478: invokevirtual   java/lang/String.length:()I
        //   481: ifeq            640
        //   484: aload           6
        //   486: astore          7
        //   488: ldc_w           "Error in peekHits fetching hit url: "
        //   491: aload           8
        //   493: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   496: astore          8
        //   498: aload           6
        //   500: astore          7
        //   502: aload           8
        //   504: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   507: aload           6
        //   509: astore          7
        //   511: new             Ljava/util/ArrayList;
        //   514: dup            
        //   515: invokespecial   java/util/ArrayList.<init>:()V
        //   518: astore          8
        //   520: iconst_0       
        //   521: istore_1       
        //   522: aload           6
        //   524: astore          7
        //   526: aload           9
        //   528: checkcast       Ljava/util/ArrayList;
        //   531: astore          9
        //   533: aload           6
        //   535: astore          7
        //   537: aload           9
        //   539: invokevirtual   java/util/ArrayList.size:()I
        //   542: istore          4
        //   544: iconst_0       
        //   545: istore_2       
        //   546: iload_2        
        //   547: iload           4
        //   549: if_icmpge       659
        //   552: aload           6
        //   554: astore          7
        //   556: aload           9
        //   558: iload_2        
        //   559: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   562: astore          10
        //   564: iload_2        
        //   565: iconst_1       
        //   566: iadd           
        //   567: istore_3       
        //   568: aload           6
        //   570: astore          7
        //   572: aload           10
        //   574: checkcast       Lcom/google/android/gms/tagmanager/zzbx;
        //   577: astore          10
        //   579: iload_1        
        //   580: istore_2       
        //   581: aload           6
        //   583: astore          7
        //   585: aload           10
        //   587: invokevirtual   com/google/android/gms/tagmanager/zzbx.zzBo:()Ljava/lang/String;
        //   590: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   593: ifeq            602
        //   596: iload_1        
        //   597: ifne            659
        //   600: iconst_1       
        //   601: istore_2       
        //   602: aload           6
        //   604: astore          7
        //   606: aload           8
        //   608: aload           10
        //   610: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   615: pop            
        //   616: iload_2        
        //   617: istore_1       
        //   618: iload_3        
        //   619: istore_2       
        //   620: goto            546
        //   623: astore          6
        //   625: aload           7
        //   627: ifnull          637
        //   630: aload           7
        //   632: invokeinterface android/database/Cursor.close:()V
        //   637: aload           6
        //   639: athrow         
        //   640: aload           6
        //   642: astore          7
        //   644: new             Ljava/lang/String;
        //   647: dup            
        //   648: ldc_w           "Error in peekHits fetching hit url: "
        //   651: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   654: astore          8
        //   656: goto            498
        //   659: aload           6
        //   661: ifnull          671
        //   664: aload           6
        //   666: invokeinterface android/database/Cursor.close:()V
        //   671: aload           8
        //   673: areturn        
        //   674: astore          6
        //   676: aload           10
        //   678: astore          7
        //   680: goto            625
        //   683: astore          8
        //   685: goto            458
        //   688: astore          6
        //   690: aload           8
        //   692: astore          7
        //   694: goto            402
        //   697: astore          8
        //   699: aload           6
        //   701: astore          7
        //   703: aload           8
        //   705: astore          6
        //   707: goto            402
        //   710: astore          8
        //   712: goto            327
        //   715: astore          8
        //   717: aload           9
        //   719: astore          7
        //   721: goto            327
        //   724: iload_1        
        //   725: iconst_1       
        //   726: iadd           
        //   727: istore_1       
        //   728: goto            253
        //    Signature:
        //  (I)Ljava/util/List<Lcom/google/android/gms/tagmanager/zzbx;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  32     91     322    327    Landroid/database/sqlite/SQLiteException;
        //  32     91     688    697    Any
        //  91     100    710    715    Landroid/database/sqlite/SQLiteException;
        //  91     100    697    710    Any
        //  100    110    715    724    Landroid/database/sqlite/SQLiteException;
        //  100    110    697    710    Any
        //  110    158    715    724    Landroid/database/sqlite/SQLiteException;
        //  110    158    697    710    Any
        //  179    195    683    688    Landroid/database/sqlite/SQLiteException;
        //  179    195    623    625    Any
        //  199    206    683    688    Landroid/database/sqlite/SQLiteException;
        //  199    206    623    625    Any
        //  210    241    683    688    Landroid/database/sqlite/SQLiteException;
        //  210    241    623    625    Any
        //  241    251    452    458    Landroid/database/sqlite/SQLiteException;
        //  241    251    674    683    Any
        //  253    289    452    458    Landroid/database/sqlite/SQLiteException;
        //  253    289    674    683    Any
        //  289    298    452    458    Landroid/database/sqlite/SQLiteException;
        //  289    298    674    683    Any
        //  327    354    392    402    Any
        //  354    359    392    402    Any
        //  378    389    392    402    Any
        //  417    449    452    458    Landroid/database/sqlite/SQLiteException;
        //  417    449    674    683    Any
        //  462    472    623    625    Any
        //  476    484    623    625    Any
        //  488    498    623    625    Any
        //  502    507    623    625    Any
        //  511    520    623    625    Any
        //  526    533    623    625    Any
        //  537    544    623    625    Any
        //  556    564    623    625    Any
        //  572    579    623    625    Any
        //  585    596    623    625    Any
        //  606    616    623    625    Any
        //  644    656    623    625    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 341 out of bounds for length 341
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
    
    private final void zzd(final String[] array) {
        boolean b = true;
        if (array != null && array.length != 0) {
            final SQLiteDatabase zzfg = this.zzfg("Error opening database for deleteHits.");
            if (zzfg != null) {
                while (true) {
                    final String format = String.format("HIT_ID in (%s)", TextUtils.join((CharSequence)",", (Iterable)Collections.nCopies(array.length, "?")));
                    while (true) {
                        try {
                            zzfg.delete("gtm_hits", format, array);
                            final zzcd zzbFw = this.zzbFw;
                            if (this.zzBA() == 0) {
                                zzbFw.zzar(b);
                                return;
                            }
                        }
                        catch (SQLiteException ex) {
                            zzdj.zzaT("Error deleting hits");
                            return;
                        }
                        b = false;
                        continue;
                    }
                }
            }
        }
    }
    
    private final SQLiteDatabase zzfg(final String s) {
        try {
            return this.zzbFu.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            zzdj.zzaT(s);
            return null;
        }
    }
    
    private final void zzh(final long n, final long l) {
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for getNumStoredHits.");
        if (zzfg == null) {
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(l));
        try {
            zzfg.update("gtm_hits", contentValues, "hit_id=?", new String[] { String.valueOf(n) });
        }
        catch (SQLiteException ex) {
            zzdj.zzaT(new StringBuilder(69).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ").append(n).toString());
            this.zzp(n);
        }
    }
    
    private final void zzp(final long l) {
        this.zzd(new String[] { String.valueOf(l) });
    }
    
    @Override
    public final void dispatch() {
        zzdj.v("GTM Dispatch running...");
        if (this.zzbFv.zzBf()) {
            final List<zzbx> zzbE = this.zzbE(40);
            if (zzbE.isEmpty()) {
                zzdj.v("...nothing to dispatch");
                this.zzbFw.zzar(true);
                return;
            }
            this.zzbFv.zzK(zzbE);
            if (this.zzBB() > 0) {
                zzfo.zzBV().dispatch();
            }
        }
    }
    
    @Override
    public final void zzb(final long l, final String s) {
        boolean b = true;
        final long currentTimeMillis = this.zzvw.currentTimeMillis();
        Label_0264: {
            while (true) {
                Label_0104: {
                    if (currentTimeMillis <= this.zzbFy + 86400000L) {
                        break Label_0104;
                    }
                    this.zzbFy = currentTimeMillis;
                    final SQLiteDatabase zzfg = this.zzfg("Error opening database for deleteStaleHits.");
                    if (zzfg == null) {
                        break Label_0104;
                    }
                    zzfg.delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(this.zzvw.currentTimeMillis() - 2592000000L) });
                    final zzcd zzbFw = this.zzbFw;
                    if (this.zzBA() != 0) {
                        break Label_0264;
                    }
                    zzbFw.zzar(b);
                }
                final int n = this.zzBA() - this.zzbFz + 1;
                if (n > 0) {
                    final List<String> zzbD = this.zzbD(n);
                    zzdj.v(new StringBuilder(51).append("Store full, deleting ").append(zzbD.size()).append(" hits to make room.").toString());
                    this.zzd(zzbD.toArray(new String[0]));
                }
                final SQLiteDatabase zzfg2 = this.zzfg("Error opening database for putHit");
                if (zzfg2 == null) {
                    return;
                }
                final ContentValues contentValues = new ContentValues();
                contentValues.put("hit_time", Long.valueOf(l));
                contentValues.put("hit_url", s);
                contentValues.put("hit_first_send_time", Integer.valueOf(0));
                try {
                    zzfg2.insert("gtm_hits", (String)null, contentValues);
                    this.zzbFw.zzar(false);
                    return;
                    b = false;
                    continue;
                }
                catch (SQLiteException ex) {
                    zzdj.zzaT("Error storing hit");
                }
                break;
            }
        }
    }
}
