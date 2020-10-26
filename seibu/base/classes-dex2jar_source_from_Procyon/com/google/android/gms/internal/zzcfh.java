// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;
import android.os.Parcel;
import android.content.Context;
import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Build$VERSION;
import android.database.sqlite.SQLiteFullException;
import android.content.ContentValues;
import android.support.annotation.WorkerThread;
import android.database.sqlite.SQLiteDatabase;

public final class zzcfh extends zzchj
{
    private final zzcfi zzbqF;
    private boolean zzbqG;
    
    zzcfh(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbqF = new zzcfi(this, super.getContext(), zzcem.zzxD());
    }
    
    @WorkerThread
    private final SQLiteDatabase getWritableDatabase() {
        if (this.zzbqG) {
            return null;
        }
        final SQLiteDatabase writableDatabase = this.zzbqF.getWritableDatabase();
        if (writableDatabase == null) {
            this.zzbqG = true;
            return null;
        }
        return writableDatabase;
    }
    
    @TargetApi(11)
    @WorkerThread
    private final boolean zza(int i, byte[] array) {
        super.zzwp();
        super.zzjC();
        if (this.zzbqG) {
            return false;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", array);
        zzcem.zzxN();
        final int n = 0;
        i = 5;
        if (n < 5) {
            SQLiteDatabase sqLiteDatabase = null;
            SQLiteDatabase sqLiteDatabase2 = null;
            SQLiteDatabase sqLiteDatabase3 = null;
            final Cursor cursor = null;
            final byte[] array2 = null;
            Object o2;
            final Object o = o2 = null;
            Object o3 = cursor;
            array = array2;
            try {
                final SQLiteDatabase writableDatabase = this.getWritableDatabase();
                if (writableDatabase == null) {
                    o2 = o;
                    sqLiteDatabase3 = writableDatabase;
                    o3 = cursor;
                    sqLiteDatabase = writableDatabase;
                    array = array2;
                    sqLiteDatabase2 = writableDatabase;
                    this.zzbqG = true;
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return false;
                }
                o2 = o;
                sqLiteDatabase3 = writableDatabase;
                o3 = cursor;
                sqLiteDatabase = writableDatabase;
                array = array2;
                sqLiteDatabase2 = writableDatabase;
                writableDatabase.beginTransaction();
                final long n2 = 0L;
                o2 = o;
                sqLiteDatabase3 = writableDatabase;
                o3 = cursor;
                sqLiteDatabase = writableDatabase;
                array = array2;
                sqLiteDatabase2 = writableDatabase;
                final Object rawQuery = writableDatabase.rawQuery("select count(1) from messages", (String[])null);
                long long1 = n2;
                if (rawQuery != null) {
                    long1 = n2;
                    o2 = rawQuery;
                    sqLiteDatabase3 = writableDatabase;
                    o3 = rawQuery;
                    sqLiteDatabase = writableDatabase;
                    array = (byte[])rawQuery;
                    sqLiteDatabase2 = writableDatabase;
                    if (((Cursor)rawQuery).moveToFirst()) {
                        o2 = rawQuery;
                        sqLiteDatabase3 = writableDatabase;
                        o3 = rawQuery;
                        sqLiteDatabase = writableDatabase;
                        array = (byte[])rawQuery;
                        sqLiteDatabase2 = writableDatabase;
                        long1 = ((Cursor)rawQuery).getLong(0);
                    }
                }
                if (long1 >= 100000L) {
                    o2 = rawQuery;
                    sqLiteDatabase3 = writableDatabase;
                    o3 = rawQuery;
                    sqLiteDatabase = writableDatabase;
                    array = (byte[])rawQuery;
                    sqLiteDatabase2 = writableDatabase;
                    super.zzwF().zzyx().log("Data loss, local db full");
                    final long n3 = 100000L - long1 + 1L;
                    o2 = rawQuery;
                    sqLiteDatabase3 = writableDatabase;
                    o3 = rawQuery;
                    sqLiteDatabase = writableDatabase;
                    array = (byte[])rawQuery;
                    sqLiteDatabase2 = writableDatabase;
                    final long l = writableDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[] { Long.toString(n3) });
                    if (l != n3) {
                        o2 = rawQuery;
                        sqLiteDatabase3 = writableDatabase;
                        o3 = rawQuery;
                        sqLiteDatabase = writableDatabase;
                        array = (byte[])rawQuery;
                        sqLiteDatabase2 = writableDatabase;
                        super.zzwF().zzyx().zzd("Different delete count than expected in local db. expected, received, difference", n3, l, n3 - l);
                    }
                }
                o2 = rawQuery;
                sqLiteDatabase3 = writableDatabase;
                o3 = rawQuery;
                sqLiteDatabase = writableDatabase;
                array = (byte[])rawQuery;
                sqLiteDatabase2 = writableDatabase;
                writableDatabase.insertOrThrow("messages", (String)null, contentValues);
                o2 = rawQuery;
                sqLiteDatabase3 = writableDatabase;
                o3 = rawQuery;
                sqLiteDatabase = writableDatabase;
                array = (byte[])rawQuery;
                sqLiteDatabase2 = writableDatabase;
                writableDatabase.setTransactionSuccessful();
                o2 = rawQuery;
                sqLiteDatabase3 = writableDatabase;
                o3 = rawQuery;
                sqLiteDatabase = writableDatabase;
                array = (byte[])rawQuery;
                sqLiteDatabase2 = writableDatabase;
                writableDatabase.endTransaction();
                return true;
            }
            catch (SQLiteFullException ex) {
                array = (byte[])o2;
                sqLiteDatabase2 = sqLiteDatabase3;
                super.zzwF().zzyx().zzj("Error writing entry to local database", ex);
                array = (byte[])o2;
                sqLiteDatabase2 = sqLiteDatabase3;
                this.zzbqG = true;
                if (o2 != null) {
                    ((Cursor)o2).close();
                }
                if (sqLiteDatabase3 == null) {
                    goto Label_0620;
                }
                sqLiteDatabase3.close();
            }
            catch (SQLiteException ex2) {
                array = (byte[])o3;
                sqLiteDatabase2 = sqLiteDatabase;
                Label_0710: {
                    if (Build$VERSION.SDK_INT < 11) {
                        break Label_0710;
                    }
                    array = (byte[])o3;
                    sqLiteDatabase2 = sqLiteDatabase;
                    if (!(ex2 instanceof SQLiteDatabaseLockedException)) {
                        break Label_0710;
                    }
                    array = (byte[])o3;
                    sqLiteDatabase2 = sqLiteDatabase;
                    SystemClock.sleep((long)i);
                    i += 20;
                    if (o3 != null) {
                        ((Cursor)o3).close();
                    }
                    if (sqLiteDatabase != null) {
                        sqLiteDatabase.close();
                        goto Label_0620;
                    }
                    goto Label_0620;
                }
                if (sqLiteDatabase != null) {
                    array = (byte[])o3;
                    sqLiteDatabase2 = sqLiteDatabase;
                    if (sqLiteDatabase.inTransaction()) {
                        array = (byte[])o3;
                        sqLiteDatabase2 = sqLiteDatabase;
                        sqLiteDatabase.endTransaction();
                    }
                }
                array = (byte[])o3;
                sqLiteDatabase2 = sqLiteDatabase;
                super.zzwF().zzyx().zzj("Error writing entry to local database", ex2);
                array = (byte[])o3;
                sqLiteDatabase2 = sqLiteDatabase;
                this.zzbqG = true;
            }
            finally {
                if (array != null) {
                    ((Cursor)(Object)array).close();
                }
                if (sqLiteDatabase2 != null) {
                    sqLiteDatabase2.close();
                }
            }
        }
        super.zzwF().zzyz().log("Failed to write entry to local database");
        return false;
    }
    
    public final boolean zza(final zzcez zzcez) {
        final Parcel obtain = Parcel.obtain();
        zzcez.writeToParcel(obtain, 0);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            super.zzwF().zzyz().log("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return this.zza(0, marshall);
    }
    
    public final boolean zza(final zzcji zzcji) {
        final Parcel obtain = Parcel.obtain();
        zzcji.writeToParcel(obtain, 0);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            super.zzwF().zzyz().log("User property too long for local database. Sending directly to service");
            return false;
        }
        return this.zza(1, marshall);
    }
    
    @TargetApi(11)
    public final List<zza> zzbp(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/google/android/gms/internal/zzchj.zzjC:()V
        //     4: aload_0        
        //     5: invokespecial   com/google/android/gms/internal/zzchj.zzwp:()V
        //     8: aload_0        
        //     9: getfield        com/google/android/gms/internal/zzcfh.zzbqG:Z
        //    12: ifeq            17
        //    15: aconst_null    
        //    16: areturn        
        //    17: new             Ljava/util/ArrayList;
        //    20: dup            
        //    21: invokespecial   java/util/ArrayList.<init>:()V
        //    24: astore          12
        //    26: aload_0        
        //    27: invokespecial   com/google/android/gms/internal/zzchj.getContext:()Landroid/content/Context;
        //    30: invokestatic    com/google/android/gms/internal/zzcem.zzxD:()Ljava/lang/String;
        //    33: invokevirtual   android/content/Context.getDatabasePath:(Ljava/lang/String;)Ljava/io/File;
        //    36: invokevirtual   java/io/File.exists:()Z
        //    39: ifne            45
        //    42: aload           12
        //    44: areturn        
        //    45: iconst_5       
        //    46: istore_1       
        //    47: iconst_0       
        //    48: istore_3       
        //    49: iload_3        
        //    50: iconst_5       
        //    51: if_icmpge       813
        //    54: aconst_null    
        //    55: astore          10
        //    57: aconst_null    
        //    58: astore          9
        //    60: aload_0        
        //    61: invokespecial   com/google/android/gms/internal/zzcfh.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    64: astore          8
        //    66: aload           8
        //    68: ifnonnull       88
        //    71: aload_0        
        //    72: iconst_1       
        //    73: putfield        com/google/android/gms/internal/zzcfh.zzbqG:Z
        //    76: aload           8
        //    78: ifnull          86
        //    81: aload           8
        //    83: invokevirtual   android/database/sqlite/SQLiteDatabase.close:()V
        //    86: aconst_null    
        //    87: areturn        
        //    88: aload           8
        //    90: invokevirtual   android/database/sqlite/SQLiteDatabase.beginTransaction:()V
        //    93: bipush          100
        //    95: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    98: astore          9
        //   100: aload           8
        //   102: ldc             "messages"
        //   104: iconst_3       
        //   105: anewarray       Ljava/lang/String;
        //   108: dup            
        //   109: iconst_0       
        //   110: ldc             "rowid"
        //   112: aastore        
        //   113: dup            
        //   114: iconst_1       
        //   115: ldc             "type"
        //   117: aastore        
        //   118: dup            
        //   119: iconst_2       
        //   120: ldc             "entry"
        //   122: aastore        
        //   123: aconst_null    
        //   124: aconst_null    
        //   125: aconst_null    
        //   126: aconst_null    
        //   127: ldc             "rowid asc"
        //   129: aload           9
        //   131: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   134: astore          10
        //   136: ldc2_w          -1
        //   139: lstore          4
        //   141: aload           10
        //   143: invokeinterface android/database/Cursor.moveToNext:()Z
        //   148: ifeq            690
        //   151: aload           10
        //   153: iconst_0       
        //   154: invokeinterface android/database/Cursor.getLong:(I)J
        //   159: lstore          6
        //   161: aload           10
        //   163: iconst_1       
        //   164: invokeinterface android/database/Cursor.getInt:(I)I
        //   169: istore_2       
        //   170: aload           10
        //   172: iconst_2       
        //   173: invokeinterface android/database/Cursor.getBlob:(I)[B
        //   178: astore          13
        //   180: iload_2        
        //   181: ifne            452
        //   184: invokestatic    android/os/Parcel.obtain:()Landroid/os/Parcel;
        //   187: astore          9
        //   189: aload           9
        //   191: aload           13
        //   193: iconst_0       
        //   194: aload           13
        //   196: arraylength    
        //   197: invokevirtual   android/os/Parcel.unmarshall:([BII)V
        //   200: aload           9
        //   202: iconst_0       
        //   203: invokevirtual   android/os/Parcel.setDataPosition:(I)V
        //   206: getstatic       com/google/android/gms/internal/zzcez.CREATOR:Landroid/os/Parcelable$Creator;
        //   209: aload           9
        //   211: invokeinterface android/os/Parcelable$Creator.createFromParcel:(Landroid/os/Parcel;)Ljava/lang/Object;
        //   216: checkcast       Lcom/google/android/gms/internal/zzcez;
        //   219: astore          11
        //   221: aload           9
        //   223: invokevirtual   android/os/Parcel.recycle:()V
        //   226: lload           6
        //   228: lstore          4
        //   230: aload           11
        //   232: ifnull          141
        //   235: aload           12
        //   237: aload           11
        //   239: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   244: pop            
        //   245: lload           6
        //   247: lstore          4
        //   249: goto            141
        //   252: astore          11
        //   254: aload           8
        //   256: astore          9
        //   258: aload           10
        //   260: astore          8
        //   262: aload           11
        //   264: astore          10
        //   266: aload_0        
        //   267: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   270: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   273: ldc_w           "Error reading entries from local database"
        //   276: aload           10
        //   278: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   281: aload_0        
        //   282: iconst_1       
        //   283: putfield        com/google/android/gms/internal/zzcfh.zzbqG:Z
        //   286: aload           8
        //   288: ifnull          298
        //   291: aload           8
        //   293: invokeinterface android/database/Cursor.close:()V
        //   298: aload           9
        //   300: ifnull          925
        //   303: aload           9
        //   305: invokevirtual   android/database/sqlite/SQLiteDatabase.close:()V
        //   308: iload_3        
        //   309: iconst_1       
        //   310: iadd           
        //   311: istore_3       
        //   312: goto            49
        //   315: astore          11
        //   317: aload_0        
        //   318: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   321: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   324: ldc_w           "Failed to load event from local database"
        //   327: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   330: aload           9
        //   332: invokevirtual   android/os/Parcel.recycle:()V
        //   335: lload           6
        //   337: lstore          4
        //   339: goto            141
        //   342: astore          11
        //   344: aload           8
        //   346: astore          9
        //   348: aload           11
        //   350: astore          8
        //   352: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   355: bipush          11
        //   357: if_icmplt       770
        //   360: aload           8
        //   362: instanceof      Landroid/database/sqlite/SQLiteDatabaseLockedException;
        //   365: ifeq            770
        //   368: iload_1        
        //   369: i2l            
        //   370: invokestatic    android/os/SystemClock.sleep:(J)V
        //   373: iload_1        
        //   374: bipush          20
        //   376: iadd           
        //   377: istore_2       
        //   378: aload           10
        //   380: ifnull          390
        //   383: aload           10
        //   385: invokeinterface android/database/Cursor.close:()V
        //   390: iload_2        
        //   391: istore_1       
        //   392: aload           9
        //   394: ifnull          308
        //   397: aload           9
        //   399: invokevirtual   android/database/sqlite/SQLiteDatabase.close:()V
        //   402: iload_2        
        //   403: istore_1       
        //   404: goto            308
        //   407: astore          11
        //   409: aload           9
        //   411: invokevirtual   android/os/Parcel.recycle:()V
        //   414: aload           11
        //   416: athrow         
        //   417: astore          11
        //   419: aload           8
        //   421: astore          9
        //   423: aload           11
        //   425: astore          8
        //   427: aload           10
        //   429: ifnull          439
        //   432: aload           10
        //   434: invokeinterface android/database/Cursor.close:()V
        //   439: aload           9
        //   441: ifnull          449
        //   444: aload           9
        //   446: invokevirtual   android/database/sqlite/SQLiteDatabase.close:()V
        //   449: aload           8
        //   451: athrow         
        //   452: iload_2        
        //   453: iconst_1       
        //   454: if_icmpne       561
        //   457: invokestatic    android/os/Parcel.obtain:()Landroid/os/Parcel;
        //   460: astore          11
        //   462: aload           11
        //   464: aload           13
        //   466: iconst_0       
        //   467: aload           13
        //   469: arraylength    
        //   470: invokevirtual   android/os/Parcel.unmarshall:([BII)V
        //   473: aload           11
        //   475: iconst_0       
        //   476: invokevirtual   android/os/Parcel.setDataPosition:(I)V
        //   479: getstatic       com/google/android/gms/internal/zzcji.CREATOR:Landroid/os/Parcelable$Creator;
        //   482: aload           11
        //   484: invokeinterface android/os/Parcelable$Creator.createFromParcel:(Landroid/os/Parcel;)Ljava/lang/Object;
        //   489: checkcast       Lcom/google/android/gms/internal/zzcji;
        //   492: astore          9
        //   494: aload           11
        //   496: invokevirtual   android/os/Parcel.recycle:()V
        //   499: lload           6
        //   501: lstore          4
        //   503: aload           9
        //   505: ifnull          141
        //   508: aload           12
        //   510: aload           9
        //   512: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   517: pop            
        //   518: lload           6
        //   520: lstore          4
        //   522: goto            141
        //   525: astore          9
        //   527: aload_0        
        //   528: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   531: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   534: ldc_w           "Failed to load user property from local database"
        //   537: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   540: aload           11
        //   542: invokevirtual   android/os/Parcel.recycle:()V
        //   545: aconst_null    
        //   546: astore          9
        //   548: goto            499
        //   551: astore          9
        //   553: aload           11
        //   555: invokevirtual   android/os/Parcel.recycle:()V
        //   558: aload           9
        //   560: athrow         
        //   561: iload_2        
        //   562: iconst_2       
        //   563: if_icmpne       670
        //   566: invokestatic    android/os/Parcel.obtain:()Landroid/os/Parcel;
        //   569: astore          11
        //   571: aload           11
        //   573: aload           13
        //   575: iconst_0       
        //   576: aload           13
        //   578: arraylength    
        //   579: invokevirtual   android/os/Parcel.unmarshall:([BII)V
        //   582: aload           11
        //   584: iconst_0       
        //   585: invokevirtual   android/os/Parcel.setDataPosition:(I)V
        //   588: getstatic       com/google/android/gms/internal/zzcek.CREATOR:Landroid/os/Parcelable$Creator;
        //   591: aload           11
        //   593: invokeinterface android/os/Parcelable$Creator.createFromParcel:(Landroid/os/Parcel;)Ljava/lang/Object;
        //   598: checkcast       Lcom/google/android/gms/internal/zzcek;
        //   601: astore          9
        //   603: aload           11
        //   605: invokevirtual   android/os/Parcel.recycle:()V
        //   608: lload           6
        //   610: lstore          4
        //   612: aload           9
        //   614: ifnull          141
        //   617: aload           12
        //   619: aload           9
        //   621: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   626: pop            
        //   627: lload           6
        //   629: lstore          4
        //   631: goto            141
        //   634: astore          9
        //   636: aload_0        
        //   637: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   640: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   643: ldc_w           "Failed to load user property from local database"
        //   646: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   649: aload           11
        //   651: invokevirtual   android/os/Parcel.recycle:()V
        //   654: aconst_null    
        //   655: astore          9
        //   657: goto            608
        //   660: astore          9
        //   662: aload           11
        //   664: invokevirtual   android/os/Parcel.recycle:()V
        //   667: aload           9
        //   669: athrow         
        //   670: aload_0        
        //   671: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   674: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   677: ldc_w           "Unknown record type in local database"
        //   680: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   683: lload           6
        //   685: lstore          4
        //   687: goto            141
        //   690: aload           8
        //   692: ldc             "messages"
        //   694: ldc_w           "rowid <= ?"
        //   697: iconst_1       
        //   698: anewarray       Ljava/lang/String;
        //   701: dup            
        //   702: iconst_0       
        //   703: lload           4
        //   705: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //   708: aastore        
        //   709: invokevirtual   android/database/sqlite/SQLiteDatabase.delete:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //   712: aload           12
        //   714: invokeinterface java/util/List.size:()I
        //   719: if_icmpge       735
        //   722: aload_0        
        //   723: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   726: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   729: ldc_w           "Fewer entries removed from local database than expected"
        //   732: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   735: aload           8
        //   737: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //   740: aload           8
        //   742: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   745: aload           10
        //   747: ifnull          757
        //   750: aload           10
        //   752: invokeinterface android/database/Cursor.close:()V
        //   757: aload           8
        //   759: ifnull          767
        //   762: aload           8
        //   764: invokevirtual   android/database/sqlite/SQLiteDatabase.close:()V
        //   767: aload           12
        //   769: areturn        
        //   770: aload           9
        //   772: ifnull          788
        //   775: aload           9
        //   777: invokevirtual   android/database/sqlite/SQLiteDatabase.inTransaction:()Z
        //   780: ifeq            788
        //   783: aload           9
        //   785: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   788: aload_0        
        //   789: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   792: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   795: ldc_w           "Error reading entries from local database"
        //   798: aload           8
        //   800: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   803: aload_0        
        //   804: iconst_1       
        //   805: putfield        com/google/android/gms/internal/zzcfh.zzbqG:Z
        //   808: iload_1        
        //   809: istore_2       
        //   810: goto            378
        //   813: aload_0        
        //   814: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   817: invokevirtual   com/google/android/gms/internal/zzcfl.zzyz:()Lcom/google/android/gms/internal/zzcfn;
        //   820: ldc_w           "Failed to read events from database in reasonable time"
        //   823: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   826: aconst_null    
        //   827: areturn        
        //   828: astore          8
        //   830: aconst_null    
        //   831: astore          11
        //   833: aload           10
        //   835: astore          9
        //   837: aload           11
        //   839: astore          10
        //   841: goto            427
        //   844: astore          11
        //   846: aconst_null    
        //   847: astore          10
        //   849: aload           8
        //   851: astore          9
        //   853: aload           11
        //   855: astore          8
        //   857: goto            427
        //   860: astore          11
        //   862: aload           8
        //   864: astore          10
        //   866: aload           11
        //   868: astore          8
        //   870: goto            427
        //   873: astore          8
        //   875: goto            427
        //   878: astore          8
        //   880: aconst_null    
        //   881: astore          10
        //   883: goto            352
        //   886: astore          11
        //   888: aconst_null    
        //   889: astore          10
        //   891: aload           8
        //   893: astore          9
        //   895: aload           11
        //   897: astore          8
        //   899: goto            352
        //   902: astore          10
        //   904: aconst_null    
        //   905: astore          9
        //   907: aconst_null    
        //   908: astore          8
        //   910: goto            266
        //   913: astore          10
        //   915: aload           8
        //   917: astore          9
        //   919: aconst_null    
        //   920: astore          8
        //   922: goto            266
        //   925: goto            308
        //    Signature:
        //  (I)Ljava/util/List<Lcom/google/android/gms/common/internal/safeparcel/zza;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                   
        //  -----  -----  -----  -----  -------------------------------------------------------
        //  60     66     902    913    Landroid/database/sqlite/SQLiteFullException;
        //  60     66     878    886    Landroid/database/sqlite/SQLiteException;
        //  60     66     828    844    Any
        //  71     76     913    925    Landroid/database/sqlite/SQLiteFullException;
        //  71     76     886    902    Landroid/database/sqlite/SQLiteException;
        //  71     76     844    860    Any
        //  88     136    913    925    Landroid/database/sqlite/SQLiteFullException;
        //  88     136    886    902    Landroid/database/sqlite/SQLiteException;
        //  88     136    844    860    Any
        //  141    180    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  141    180    342    352    Landroid/database/sqlite/SQLiteException;
        //  141    180    417    427    Any
        //  184    189    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  184    189    342    352    Landroid/database/sqlite/SQLiteException;
        //  184    189    417    427    Any
        //  189    221    315    342    Lcom/google/android/gms/common/internal/safeparcel/zzc;
        //  189    221    407    417    Any
        //  221    226    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  221    226    342    352    Landroid/database/sqlite/SQLiteException;
        //  221    226    417    427    Any
        //  235    245    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  235    245    342    352    Landroid/database/sqlite/SQLiteException;
        //  235    245    417    427    Any
        //  266    286    860    873    Any
        //  317    330    407    417    Any
        //  330    335    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  330    335    342    352    Landroid/database/sqlite/SQLiteException;
        //  330    335    417    427    Any
        //  352    373    873    878    Any
        //  409    417    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  409    417    342    352    Landroid/database/sqlite/SQLiteException;
        //  409    417    417    427    Any
        //  457    462    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  457    462    342    352    Landroid/database/sqlite/SQLiteException;
        //  457    462    417    427    Any
        //  462    494    525    551    Lcom/google/android/gms/common/internal/safeparcel/zzc;
        //  462    494    551    561    Any
        //  494    499    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  494    499    342    352    Landroid/database/sqlite/SQLiteException;
        //  494    499    417    427    Any
        //  508    518    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  508    518    342    352    Landroid/database/sqlite/SQLiteException;
        //  508    518    417    427    Any
        //  527    540    551    561    Any
        //  540    545    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  540    545    342    352    Landroid/database/sqlite/SQLiteException;
        //  540    545    417    427    Any
        //  553    561    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  553    561    342    352    Landroid/database/sqlite/SQLiteException;
        //  553    561    417    427    Any
        //  566    571    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  566    571    342    352    Landroid/database/sqlite/SQLiteException;
        //  566    571    417    427    Any
        //  571    603    634    660    Lcom/google/android/gms/common/internal/safeparcel/zzc;
        //  571    603    660    670    Any
        //  603    608    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  603    608    342    352    Landroid/database/sqlite/SQLiteException;
        //  603    608    417    427    Any
        //  617    627    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  617    627    342    352    Landroid/database/sqlite/SQLiteException;
        //  617    627    417    427    Any
        //  636    649    660    670    Any
        //  649    654    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  649    654    342    352    Landroid/database/sqlite/SQLiteException;
        //  649    654    417    427    Any
        //  662    670    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  662    670    342    352    Landroid/database/sqlite/SQLiteException;
        //  662    670    417    427    Any
        //  670    683    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  670    683    342    352    Landroid/database/sqlite/SQLiteException;
        //  670    683    417    427    Any
        //  690    735    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  690    735    342    352    Landroid/database/sqlite/SQLiteException;
        //  690    735    417    427    Any
        //  735    745    252    266    Landroid/database/sqlite/SQLiteFullException;
        //  735    745    342    352    Landroid/database/sqlite/SQLiteException;
        //  735    745    417    427    Any
        //  775    788    873    878    Any
        //  788    808    873    878    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 426 out of bounds for length 426
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
    
    public final boolean zzc(final zzcek zzcek) {
        super.zzwB();
        final byte[] zza = zzcjl.zza((Parcelable)zzcek);
        if (zza.length > 131072) {
            super.zzwF().zzyz().log("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return this.zza(2, zza);
    }
    
    @Override
    protected final void zzjD() {
    }
}
