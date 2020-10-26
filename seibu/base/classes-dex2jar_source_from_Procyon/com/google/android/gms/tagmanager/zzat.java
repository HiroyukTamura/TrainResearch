// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zze;
import java.util.concurrent.Executor;
import android.content.Context;

final class zzat implements zzc
{
    private static final String zzbEn;
    private final Context mContext;
    private final Executor zzbEo;
    private zzax zzbEp;
    private int zzbEq;
    private zze zzvw;
    
    static {
        zzbEn = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    }
    
    public zzat(final Context context) {
        this(context, zzi.zzrY(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }
    
    private zzat(final Context mContext, final zze zzvw, final String s, final int n, final Executor zzbEo) {
        this.mContext = mContext;
        this.zzvw = zzvw;
        this.zzbEq = 2000;
        this.zzbEo = zzbEo;
        this.zzbEp = new zzax(this, this.mContext, s);
    }
    
    private final List<zza> zzBa() {
        try {
            this.zzah(this.zzvw.currentTimeMillis());
            final List<zzay> zzBb = this.zzBb();
            final ArrayList<zza> list = new ArrayList<zza>();
            for (final zzay zzay : zzBb) {
                list.add(new DataLayer.zza(zzay.zzBN, zzt(zzay.zzbEw)));
            }
        }
        finally {
            this.zzBd();
        }
        this.zzBd();
        return;
    }
    
    private final List<zzay> zzBb() {
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for loadSerialized.");
        final ArrayList<zzay> list = new ArrayList<zzay>();
        if (zzfg == null) {
            return list;
        }
        final Cursor query = zzfg.query("datalayer", new String[] { "key", "value" }, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);
        try {
            while (query.moveToNext()) {
                list.add(new zzay(query.getString(0), query.getBlob(1)));
            }
        }
        finally {
            query.close();
        }
        query.close();
        return;
    }
    
    private final int zzBc() {
        Cursor cursor = null;
        Cursor rawQuery = null;
        int n = 0;
        int n2 = 0;
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for getNumStoredEntries.");
        if (zzfg == null) {
            return n2;
        }
        try {
            final Cursor cursor2 = cursor = (rawQuery = zzfg.rawQuery("SELECT COUNT(*) from datalayer", (String[])null));
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
            zzdj.zzaT("Error getting numStoredEntries");
            return 0;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    
    private final void zzBd() {
        try {
            this.zzbEp.close();
        }
        catch (SQLiteException ex) {}
    }
    
    private static byte[] zzF(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //     7: astore_2       
        //     8: new             Ljava/io/ObjectOutputStream;
        //    11: dup            
        //    12: aload_2        
        //    13: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    16: astore_1       
        //    17: aload_1        
        //    18: aload_0        
        //    19: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    22: aload_2        
        //    23: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    26: astore_0       
        //    27: aload_1        
        //    28: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    31: aload_2        
        //    32: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    35: aload_0        
        //    36: areturn        
        //    37: astore_0       
        //    38: aconst_null    
        //    39: astore_1       
        //    40: aload_1        
        //    41: ifnull          48
        //    44: aload_1        
        //    45: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    48: aload_2        
        //    49: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    52: aconst_null    
        //    53: areturn        
        //    54: astore_0       
        //    55: aconst_null    
        //    56: areturn        
        //    57: astore_0       
        //    58: aconst_null    
        //    59: astore_1       
        //    60: aload_1        
        //    61: ifnull          68
        //    64: aload_1        
        //    65: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    68: aload_2        
        //    69: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    72: aload_0        
        //    73: athrow         
        //    74: astore_1       
        //    75: goto            72
        //    78: astore_0       
        //    79: goto            60
        //    82: astore_0       
        //    83: goto            40
        //    86: astore_1       
        //    87: aload_0        
        //    88: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  8      17     37     40     Ljava/io/IOException;
        //  8      17     57     60     Any
        //  17     27     82     86     Ljava/io/IOException;
        //  17     27     78     82     Any
        //  27     35     86     89     Ljava/io/IOException;
        //  44     48     54     57     Ljava/io/IOException;
        //  48     52     54     57     Ljava/io/IOException;
        //  64     68     74     78     Ljava/io/IOException;
        //  68     72     74     78     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 55 out of bounds for length 55
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
    
    private final void zzah(final long i) {
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for deleteOlderThan.");
        if (zzfg == null) {
            return;
        }
        try {
            zzdj.v(new StringBuilder(33).append("Deleted ").append(zzfg.delete("datalayer", "expires <= ?", new String[] { Long.toString(i) })).append(" expired items").toString());
        }
        catch (SQLiteException ex) {
            zzdj.zzaT("Error deleting old entries.");
        }
    }
    
    private final void zzb(final List<zzay> p0, final long p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/android/gms/tagmanager/zzat.zzvw:Lcom/google/android/gms/common/util/zze;
        //     6: invokeinterface com/google/android/gms/common/util/zze.currentTimeMillis:()J
        //    11: lstore          5
        //    13: aload_0        
        //    14: lload           5
        //    16: invokespecial   com/google/android/gms/tagmanager/zzat.zzah:(J)V
        //    19: aload_1        
        //    20: invokeinterface java/util/List.size:()I
        //    25: aload_0        
        //    26: invokespecial   com/google/android/gms/tagmanager/zzat.zzBc:()I
        //    29: aload_0        
        //    30: getfield        com/google/android/gms/tagmanager/zzat.zzbEq:I
        //    33: isub           
        //    34: iadd           
        //    35: istore          4
        //    37: iload           4
        //    39: ifle            118
        //    42: aload_0        
        //    43: iload           4
        //    45: invokespecial   com/google/android/gms/tagmanager/zzat.zzby:(I)Ljava/util/List;
        //    48: astore          7
        //    50: aload           7
        //    52: invokeinterface java/util/List.size:()I
        //    57: istore          4
        //    59: new             Ljava/lang/StringBuilder;
        //    62: dup            
        //    63: bipush          64
        //    65: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    68: ldc_w           "DataLayer store full, deleting "
        //    71: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    74: iload           4
        //    76: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    79: ldc_w           " entries to make room."
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    88: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaS:(Ljava/lang/String;)V
        //    91: aload           7
        //    93: iconst_0       
        //    94: anewarray       Ljava/lang/String;
        //    97: invokeinterface java/util/List.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   102: checkcast       [Ljava/lang/String;
        //   105: astore          7
        //   107: aload           7
        //   109: ifnull          118
        //   112: aload           7
        //   114: arraylength    
        //   115: ifne            134
        //   118: aload_0        
        //   119: aload_1        
        //   120: lload           5
        //   122: lload_2        
        //   123: ladd           
        //   124: invokespecial   com/google/android/gms/tagmanager/zzat.zzc:(Ljava/util/List;J)V
        //   127: aload_0        
        //   128: invokespecial   com/google/android/gms/tagmanager/zzat.zzBd:()V
        //   131: aload_0        
        //   132: monitorexit    
        //   133: return         
        //   134: aload_0        
        //   135: ldc_w           "Error opening database for deleteEntries."
        //   138: invokespecial   com/google/android/gms/tagmanager/zzat.zzfg:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //   141: astore          8
        //   143: aload           8
        //   145: ifnull          118
        //   148: ldc_w           "%s in (%s)"
        //   151: iconst_2       
        //   152: anewarray       Ljava/lang/Object;
        //   155: dup            
        //   156: iconst_0       
        //   157: ldc             "ID"
        //   159: aastore        
        //   160: dup            
        //   161: iconst_1       
        //   162: ldc_w           ","
        //   165: aload           7
        //   167: arraylength    
        //   168: ldc_w           "?"
        //   171: invokestatic    java/util/Collections.nCopies:(ILjava/lang/Object;)Ljava/util/List;
        //   174: invokestatic    android/text/TextUtils.join:(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
        //   177: aastore        
        //   178: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   181: astore          9
        //   183: aload           8
        //   185: ldc             "datalayer"
        //   187: aload           9
        //   189: aload           7
        //   191: invokevirtual   android/database/sqlite/SQLiteDatabase.delete:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //   194: pop            
        //   195: goto            118
        //   198: astore          8
        //   200: aload           7
        //   202: invokestatic    java/util/Arrays.toString:([Ljava/lang/Object;)Ljava/lang/String;
        //   205: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   208: astore          7
        //   210: aload           7
        //   212: invokevirtual   java/lang/String.length:()I
        //   215: ifeq            248
        //   218: ldc_w           "Error deleting entries "
        //   221: aload           7
        //   223: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   226: astore          7
        //   228: aload           7
        //   230: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   233: goto            118
        //   236: astore_1       
        //   237: aload_0        
        //   238: invokespecial   com/google/android/gms/tagmanager/zzat.zzBd:()V
        //   241: aload_1        
        //   242: athrow         
        //   243: astore_1       
        //   244: aload_0        
        //   245: monitorexit    
        //   246: aload_1        
        //   247: athrow         
        //   248: new             Ljava/lang/String;
        //   251: dup            
        //   252: ldc_w           "Error deleting entries "
        //   255: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   258: astore          7
        //   260: goto            228
        //    Signature:
        //  (Ljava/util/List<Lcom/google/android/gms/tagmanager/zzay;>;J)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  2      37     236    243    Any
        //  42     107    236    243    Any
        //  112    118    236    243    Any
        //  118    127    236    243    Any
        //  127    131    243    248    Any
        //  134    143    236    243    Any
        //  148    183    236    243    Any
        //  183    195    198    263    Landroid/database/sqlite/SQLiteException;
        //  183    195    236    243    Any
        //  200    228    236    243    Any
        //  228    233    236    243    Any
        //  237    243    243    248    Any
        //  248    260    236    243    Any
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
    
    private final List<String> zzby(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore          6
        //     9: iload_1        
        //    10: ifgt            22
        //    13: ldc_w           "Invalid maxEntries specified. Skipping."
        //    16: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    19: aload           6
        //    21: areturn        
        //    22: aload_0        
        //    23: ldc_w           "Error opening database for peekEntryIds."
        //    26: invokespecial   com/google/android/gms/tagmanager/zzat.zzfg:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    29: astore_3       
        //    30: aload_3        
        //    31: ifnonnull       37
        //    34: aload           6
        //    36: areturn        
        //    37: ldc_w           "%s ASC"
        //    40: iconst_1       
        //    41: anewarray       Ljava/lang/Object;
        //    44: dup            
        //    45: iconst_0       
        //    46: ldc             "ID"
        //    48: aastore        
        //    49: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    52: astore          4
        //    54: iload_1        
        //    55: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    58: astore          5
        //    60: aload_3        
        //    61: ldc             "datalayer"
        //    63: iconst_1       
        //    64: anewarray       Ljava/lang/String;
        //    67: dup            
        //    68: iconst_0       
        //    69: ldc             "ID"
        //    71: aastore        
        //    72: aconst_null    
        //    73: aconst_null    
        //    74: aconst_null    
        //    75: aconst_null    
        //    76: aload           4
        //    78: aload           5
        //    80: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    83: astore          4
        //    85: aload           4
        //    87: astore_3       
        //    88: aload           4
        //    90: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    95: ifeq            135
        //    98: aload           4
        //   100: astore_3       
        //   101: aload           6
        //   103: aload           4
        //   105: iconst_0       
        //   106: invokeinterface android/database/Cursor.getLong:(I)J
        //   111: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   114: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   119: pop            
        //   120: aload           4
        //   122: astore_3       
        //   123: aload           4
        //   125: invokeinterface android/database/Cursor.moveToNext:()Z
        //   130: istore_2       
        //   131: iload_2        
        //   132: ifne            98
        //   135: aload           4
        //   137: ifnull          147
        //   140: aload           4
        //   142: invokeinterface android/database/Cursor.close:()V
        //   147: aload           6
        //   149: areturn        
        //   150: astore          5
        //   152: aconst_null    
        //   153: astore          4
        //   155: aload           4
        //   157: astore_3       
        //   158: aload           5
        //   160: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   163: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   166: astore          5
        //   168: aload           4
        //   170: astore_3       
        //   171: aload           5
        //   173: invokevirtual   java/lang/String.length:()I
        //   176: ifeq            215
        //   179: aload           4
        //   181: astore_3       
        //   182: ldc_w           "Error in peekEntries fetching entryIds: "
        //   185: aload           5
        //   187: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   190: astore          5
        //   192: aload           4
        //   194: astore_3       
        //   195: aload           5
        //   197: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   200: aload           4
        //   202: ifnull          147
        //   205: aload           4
        //   207: invokeinterface android/database/Cursor.close:()V
        //   212: goto            147
        //   215: aload           4
        //   217: astore_3       
        //   218: new             Ljava/lang/String;
        //   221: dup            
        //   222: ldc_w           "Error in peekEntries fetching entryIds: "
        //   225: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   228: astore          5
        //   230: goto            192
        //   233: astore          5
        //   235: aload_3        
        //   236: astore          4
        //   238: aload           5
        //   240: astore_3       
        //   241: aload           4
        //   243: ifnull          253
        //   246: aload           4
        //   248: invokeinterface android/database/Cursor.close:()V
        //   253: aload_3        
        //   254: athrow         
        //   255: astore_3       
        //   256: aconst_null    
        //   257: astore          4
        //   259: goto            241
        //   262: astore          5
        //   264: goto            155
        //    Signature:
        //  (I)Ljava/util/List<Ljava/lang/String;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  37     85     150    155    Landroid/database/sqlite/SQLiteException;
        //  37     85     255    262    Any
        //  88     98     262    267    Landroid/database/sqlite/SQLiteException;
        //  88     98     233    241    Any
        //  101    120    262    267    Landroid/database/sqlite/SQLiteException;
        //  101    120    233    241    Any
        //  123    131    262    267    Landroid/database/sqlite/SQLiteException;
        //  123    131    233    241    Any
        //  158    168    233    241    Any
        //  171    179    233    241    Any
        //  182    192    233    241    Any
        //  195    200    233    241    Any
        //  218    230    233    241    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0098:
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
    
    private final void zzc(final List<zzay> list, final long l) {
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for writeEntryToDatabase.");
        if (zzfg != null) {
            for (final zzay zzay : list) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(l));
                contentValues.put("key", zzay.zzBN);
                contentValues.put("value", zzay.zzbEw);
                zzfg.insert("datalayer", (String)null, contentValues);
            }
        }
    }
    
    private final void zzff(final String obj) {
        final SQLiteDatabase zzfg = this.zzfg("Error opening database for clearKeysWithPrefix.");
        if (zzfg == null) {
            return;
        }
        try {
            zzdj.v(new StringBuilder(25).append("Cleared ").append(zzfg.delete("datalayer", "key = ? OR key LIKE ?", new String[] { obj, String.valueOf(obj).concat(".%") })).append(" items").toString());
        }
        catch (SQLiteException obj2) {
            final String value = String.valueOf(obj2);
            zzdj.zzaT(new StringBuilder(String.valueOf(obj).length() + 44 + String.valueOf(value).length()).append("Error deleting entries with key prefix: ").append(obj).append(" (").append(value).append(").").toString());
        }
        finally {
            this.zzBd();
        }
    }
    
    private final SQLiteDatabase zzfg(final String s) {
        try {
            return this.zzbEp.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            zzdj.zzaT(s);
            return null;
        }
    }
    
    private static Object zzt(final byte[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0        
        //     5: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //     8: astore_2       
        //     9: new             Ljava/io/ObjectInputStream;
        //    12: dup            
        //    13: aload_2        
        //    14: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //    17: astore_0       
        //    18: aload_0        
        //    19: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //    22: astore_1       
        //    23: aload_0        
        //    24: invokevirtual   java/io/ObjectInputStream.close:()V
        //    27: aload_2        
        //    28: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    31: aload_1        
        //    32: areturn        
        //    33: astore_0       
        //    34: aconst_null    
        //    35: astore_0       
        //    36: aload_0        
        //    37: ifnull          44
        //    40: aload_0        
        //    41: invokevirtual   java/io/ObjectInputStream.close:()V
        //    44: aload_2        
        //    45: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    48: aconst_null    
        //    49: areturn        
        //    50: astore_0       
        //    51: aconst_null    
        //    52: areturn        
        //    53: astore_0       
        //    54: aconst_null    
        //    55: astore_0       
        //    56: aload_0        
        //    57: ifnull          64
        //    60: aload_0        
        //    61: invokevirtual   java/io/ObjectInputStream.close:()V
        //    64: aload_2        
        //    65: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    68: aconst_null    
        //    69: areturn        
        //    70: astore_0       
        //    71: aconst_null    
        //    72: areturn        
        //    73: astore_1       
        //    74: aconst_null    
        //    75: astore_0       
        //    76: aload_0        
        //    77: ifnull          84
        //    80: aload_0        
        //    81: invokevirtual   java/io/ObjectInputStream.close:()V
        //    84: aload_2        
        //    85: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    88: aload_1        
        //    89: athrow         
        //    90: astore_0       
        //    91: goto            88
        //    94: astore_1       
        //    95: goto            76
        //    98: astore_1       
        //    99: goto            56
        //   102: astore_1       
        //   103: goto            36
        //   106: astore_0       
        //   107: aload_1        
        //   108: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  9      18     33     36     Ljava/io/IOException;
        //  9      18     53     56     Ljava/lang/ClassNotFoundException;
        //  9      18     73     76     Any
        //  18     23     102    106    Ljava/io/IOException;
        //  18     23     98     102    Ljava/lang/ClassNotFoundException;
        //  18     23     94     98     Any
        //  23     31     106    109    Ljava/io/IOException;
        //  40     44     50     53     Ljava/io/IOException;
        //  44     48     50     53     Ljava/io/IOException;
        //  60     64     70     73     Ljava/io/IOException;
        //  64     68     70     73     Ljava/io/IOException;
        //  80     84     90     94     Ljava/io/IOException;
        //  84     88     90     94     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 69 out of bounds for length 69
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
    
    @Override
    public final void zza(final zzaq zzaq) {
        this.zzbEo.execute(new zzav(this, zzaq));
    }
    
    @Override
    public final void zza(final List<zza> list, final long n) {
        final ArrayList<zzay> list2 = new ArrayList<zzay>();
        for (final zza zza : list) {
            list2.add(new zzay(zza.zzBN, zzF(zza.mValue)));
        }
        this.zzbEo.execute(new zzau(this, list2, n));
    }
    
    @Override
    public final void zzfe(final String s) {
        this.zzbEo.execute(new zzaw(this, s));
    }
}
