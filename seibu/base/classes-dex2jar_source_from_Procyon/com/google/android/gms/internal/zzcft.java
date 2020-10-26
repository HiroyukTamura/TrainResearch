// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.util.Map;
import java.net.URL;
import android.support.annotation.WorkerThread;

@WorkerThread
final class zzcft implements Runnable
{
    private final String mPackageName;
    private final URL zzJu;
    private final byte[] zzaKA;
    private final zzcfr zzbrd;
    private final Map<String, String> zzbre;
    private /* synthetic */ zzcfp zzbrf;
    
    public zzcft(final zzcfp zzbrf, final String mPackageName, final URL zzJu, final byte[] zzaKA, final Map<String, String> zzbre, final zzcfr zzbrd) {
        this.zzbrf = zzbrf;
        zzbo.zzcF(mPackageName);
        zzbo.zzu(zzJu);
        zzbo.zzu(zzbrd);
        this.zzJu = zzJu;
        this.zzaKA = zzaKA;
        this.zzbrd = zzbrd;
        this.mPackageName = mPackageName;
        this.zzbre = zzbre;
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          4
        //     3: iconst_0       
        //     4: istore          5
        //     6: iconst_0       
        //     7: istore_1       
        //     8: aload_0        
        //     9: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //    12: invokevirtual   com/google/android/gms/internal/zzcfp.zzwq:()V
        //    15: aload_0        
        //    16: getfield        com/google/android/gms/internal/zzcft.zzJu:Ljava/net/URL;
        //    19: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    22: astore          6
        //    24: aload           6
        //    26: instanceof      Ljava/net/HttpURLConnection;
        //    29: ifne            108
        //    32: new             Ljava/io/IOException;
        //    35: dup            
        //    36: ldc             "Failed to obtain HTTP connection"
        //    38: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    41: athrow         
        //    42: astore          8
        //    44: aconst_null    
        //    45: astore          9
        //    47: iconst_0       
        //    48: istore_1       
        //    49: aconst_null    
        //    50: astore          6
        //    52: aconst_null    
        //    53: astore          7
        //    55: aload           6
        //    57: ifnull          65
        //    60: aload           6
        //    62: invokevirtual   java/io/OutputStream.close:()V
        //    65: aload           7
        //    67: ifnull          75
        //    70: aload           7
        //    72: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //    75: aload_0        
        //    76: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //    79: invokevirtual   com/google/android/gms/internal/zzcfp.zzwE:()Lcom/google/android/gms/internal/zzcgg;
        //    82: new             Lcom/google/android/gms/internal/zzcfs;
        //    85: dup            
        //    86: aload_0        
        //    87: getfield        com/google/android/gms/internal/zzcft.mPackageName:Ljava/lang/String;
        //    90: aload_0        
        //    91: getfield        com/google/android/gms/internal/zzcft.zzbrd:Lcom/google/android/gms/internal/zzcfr;
        //    94: iload_1        
        //    95: aload           8
        //    97: aconst_null    
        //    98: aload           9
        //   100: aconst_null    
        //   101: invokespecial   com/google/android/gms/internal/zzcfs.<init>:(Ljava/lang/String;Lcom/google/android/gms/internal/zzcfr;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/internal/zzcfq;)V
        //   104: invokevirtual   com/google/android/gms/internal/zzcgg.zzj:(Ljava/lang/Runnable;)V
        //   107: return         
        //   108: aload           6
        //   110: checkcast       Ljava/net/HttpURLConnection;
        //   113: astore          6
        //   115: aload           6
        //   117: iconst_0       
        //   118: invokevirtual   java/net/HttpURLConnection.setDefaultUseCaches:(Z)V
        //   121: invokestatic    com/google/android/gms/internal/zzcem.zzxz:()J
        //   124: pop2           
        //   125: aload           6
        //   127: ldc             60000
        //   129: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //   132: invokestatic    com/google/android/gms/internal/zzcem.zzxA:()J
        //   135: pop2           
        //   136: aload           6
        //   138: ldc             61000
        //   140: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //   143: aload           6
        //   145: iconst_0       
        //   146: invokevirtual   java/net/HttpURLConnection.setInstanceFollowRedirects:(Z)V
        //   149: aload           6
        //   151: iconst_1       
        //   152: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //   155: iload           4
        //   157: istore_2       
        //   158: iload           5
        //   160: istore_3       
        //   161: aload_0        
        //   162: getfield        com/google/android/gms/internal/zzcft.zzbre:Ljava/util/Map;
        //   165: ifnull          258
        //   168: iload           4
        //   170: istore_2       
        //   171: iload           5
        //   173: istore_3       
        //   174: aload_0        
        //   175: getfield        com/google/android/gms/internal/zzcft.zzbre:Ljava/util/Map;
        //   178: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   183: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   188: astore          7
        //   190: iload           4
        //   192: istore_2       
        //   193: iload           5
        //   195: istore_3       
        //   196: aload           7
        //   198: invokeinterface java/util/Iterator.hasNext:()Z
        //   203: ifeq            258
        //   206: iload           4
        //   208: istore_2       
        //   209: iload           5
        //   211: istore_3       
        //   212: aload           7
        //   214: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   219: checkcast       Ljava/util/Map$Entry;
        //   222: astore          8
        //   224: iload           4
        //   226: istore_2       
        //   227: iload           5
        //   229: istore_3       
        //   230: aload           6
        //   232: aload           8
        //   234: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   239: checkcast       Ljava/lang/String;
        //   242: aload           8
        //   244: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   249: checkcast       Ljava/lang/String;
        //   252: invokevirtual   java/net/HttpURLConnection.addRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   255: goto            190
        //   258: iload           4
        //   260: istore_2       
        //   261: iload           5
        //   263: istore_3       
        //   264: aload_0        
        //   265: getfield        com/google/android/gms/internal/zzcft.zzaKA:[B
        //   268: ifnull          397
        //   271: iload           4
        //   273: istore_2       
        //   274: iload           5
        //   276: istore_3       
        //   277: aload_0        
        //   278: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   281: invokevirtual   com/google/android/gms/internal/zzcfp.zzwB:()Lcom/google/android/gms/internal/zzcjl;
        //   284: aload_0        
        //   285: getfield        com/google/android/gms/internal/zzcft.zzaKA:[B
        //   288: invokevirtual   com/google/android/gms/internal/zzcjl.zzl:([B)[B
        //   291: astore          8
        //   293: iload           4
        //   295: istore_2       
        //   296: iload           5
        //   298: istore_3       
        //   299: aload_0        
        //   300: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   303: invokevirtual   com/google/android/gms/internal/zzcfp.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   306: invokevirtual   com/google/android/gms/internal/zzcfl.zzyD:()Lcom/google/android/gms/internal/zzcfn;
        //   309: ldc             "Uploading data. size"
        //   311: aload           8
        //   313: arraylength    
        //   314: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   317: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   320: iload           4
        //   322: istore_2       
        //   323: iload           5
        //   325: istore_3       
        //   326: aload           6
        //   328: iconst_1       
        //   329: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   332: iload           4
        //   334: istore_2       
        //   335: iload           5
        //   337: istore_3       
        //   338: aload           6
        //   340: ldc             "Content-Encoding"
        //   342: ldc             "gzip"
        //   344: invokevirtual   java/net/HttpURLConnection.addRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   347: iload           4
        //   349: istore_2       
        //   350: iload           5
        //   352: istore_3       
        //   353: aload           6
        //   355: aload           8
        //   357: arraylength    
        //   358: invokevirtual   java/net/HttpURLConnection.setFixedLengthStreamingMode:(I)V
        //   361: iload           4
        //   363: istore_2       
        //   364: iload           5
        //   366: istore_3       
        //   367: aload           6
        //   369: invokevirtual   java/net/HttpURLConnection.connect:()V
        //   372: iload           4
        //   374: istore_2       
        //   375: iload           5
        //   377: istore_3       
        //   378: aload           6
        //   380: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   383: astore          7
        //   385: aload           7
        //   387: aload           8
        //   389: invokevirtual   java/io/OutputStream.write:([B)V
        //   392: aload           7
        //   394: invokevirtual   java/io/OutputStream.close:()V
        //   397: iload           4
        //   399: istore_2       
        //   400: iload           5
        //   402: istore_3       
        //   403: aload           6
        //   405: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   408: istore_1       
        //   409: iload_1        
        //   410: istore_2       
        //   411: iload_1        
        //   412: istore_3       
        //   413: aload           6
        //   415: invokevirtual   java/net/HttpURLConnection.getHeaderFields:()Ljava/util/Map;
        //   418: astore          7
        //   420: aload_0        
        //   421: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   424: aload           6
        //   426: invokestatic    com/google/android/gms/internal/zzcfp.zza:(Lcom/google/android/gms/internal/zzcfp;Ljava/net/HttpURLConnection;)[B
        //   429: astore          8
        //   431: aload           6
        //   433: ifnull          441
        //   436: aload           6
        //   438: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   441: aload_0        
        //   442: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   445: invokevirtual   com/google/android/gms/internal/zzcfp.zzwE:()Lcom/google/android/gms/internal/zzcgg;
        //   448: new             Lcom/google/android/gms/internal/zzcfs;
        //   451: dup            
        //   452: aload_0        
        //   453: getfield        com/google/android/gms/internal/zzcft.mPackageName:Ljava/lang/String;
        //   456: aload_0        
        //   457: getfield        com/google/android/gms/internal/zzcft.zzbrd:Lcom/google/android/gms/internal/zzcfr;
        //   460: iload_1        
        //   461: aconst_null    
        //   462: aload           8
        //   464: aload           7
        //   466: aconst_null    
        //   467: invokespecial   com/google/android/gms/internal/zzcfs.<init>:(Ljava/lang/String;Lcom/google/android/gms/internal/zzcfr;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/internal/zzcfq;)V
        //   470: invokevirtual   com/google/android/gms/internal/zzcgg.zzj:(Ljava/lang/Runnable;)V
        //   473: return         
        //   474: astore          6
        //   476: aload_0        
        //   477: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   480: invokevirtual   com/google/android/gms/internal/zzcfp.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   483: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   486: ldc             "Error closing HTTP compressed POST connection output stream. appId"
        //   488: aload_0        
        //   489: getfield        com/google/android/gms/internal/zzcft.mPackageName:Ljava/lang/String;
        //   492: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   495: aload           6
        //   497: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   500: goto            65
        //   503: astore          8
        //   505: aconst_null    
        //   506: astore          7
        //   508: aconst_null    
        //   509: astore          6
        //   511: aconst_null    
        //   512: astore          9
        //   514: aload           6
        //   516: ifnull          524
        //   519: aload           6
        //   521: invokevirtual   java/io/OutputStream.close:()V
        //   524: aload           9
        //   526: ifnull          534
        //   529: aload           9
        //   531: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   534: aload_0        
        //   535: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   538: invokevirtual   com/google/android/gms/internal/zzcfp.zzwE:()Lcom/google/android/gms/internal/zzcgg;
        //   541: new             Lcom/google/android/gms/internal/zzcfs;
        //   544: dup            
        //   545: aload_0        
        //   546: getfield        com/google/android/gms/internal/zzcft.mPackageName:Ljava/lang/String;
        //   549: aload_0        
        //   550: getfield        com/google/android/gms/internal/zzcft.zzbrd:Lcom/google/android/gms/internal/zzcfr;
        //   553: iload_1        
        //   554: aconst_null    
        //   555: aconst_null    
        //   556: aload           7
        //   558: aconst_null    
        //   559: invokespecial   com/google/android/gms/internal/zzcfs.<init>:(Ljava/lang/String;Lcom/google/android/gms/internal/zzcfr;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/internal/zzcfq;)V
        //   562: invokevirtual   com/google/android/gms/internal/zzcgg.zzj:(Ljava/lang/Runnable;)V
        //   565: aload           8
        //   567: athrow         
        //   568: astore          6
        //   570: aload_0        
        //   571: getfield        com/google/android/gms/internal/zzcft.zzbrf:Lcom/google/android/gms/internal/zzcfp;
        //   574: invokevirtual   com/google/android/gms/internal/zzcfp.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   577: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   580: ldc             "Error closing HTTP compressed POST connection output stream. appId"
        //   582: aload_0        
        //   583: getfield        com/google/android/gms/internal/zzcft.mPackageName:Ljava/lang/String;
        //   586: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   589: aload           6
        //   591: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   594: goto            524
        //   597: astore          8
        //   599: aconst_null    
        //   600: astore          7
        //   602: aconst_null    
        //   603: astore          10
        //   605: aload           6
        //   607: astore          9
        //   609: aload           10
        //   611: astore          6
        //   613: iload_2        
        //   614: istore_1       
        //   615: goto            514
        //   618: astore          8
        //   620: aconst_null    
        //   621: astore          10
        //   623: aload           6
        //   625: astore          9
        //   627: aload           7
        //   629: astore          6
        //   631: aload           10
        //   633: astore          7
        //   635: goto            514
        //   638: astore          8
        //   640: aconst_null    
        //   641: astore          10
        //   643: aload           6
        //   645: astore          9
        //   647: aload           10
        //   649: astore          6
        //   651: goto            514
        //   654: astore          10
        //   656: aconst_null    
        //   657: astore          9
        //   659: iconst_0       
        //   660: istore_1       
        //   661: aload           6
        //   663: astore          8
        //   665: aload           7
        //   667: astore          6
        //   669: aload           8
        //   671: astore          7
        //   673: aload           10
        //   675: astore          8
        //   677: goto            55
        //   680: astore          8
        //   682: aload           7
        //   684: astore          9
        //   686: aload           6
        //   688: astore          7
        //   690: aconst_null    
        //   691: astore          6
        //   693: goto            55
        //   696: astore          8
        //   698: aconst_null    
        //   699: astore          9
        //   701: iload_3        
        //   702: istore_1       
        //   703: aload           6
        //   705: astore          7
        //   707: aconst_null    
        //   708: astore          6
        //   710: goto            55
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  15     42     42     55     Ljava/io/IOException;
        //  15     42     503    514    Any
        //  60     65     474    503    Ljava/io/IOException;
        //  108    155    42     55     Ljava/io/IOException;
        //  108    155    503    514    Any
        //  161    168    696    713    Ljava/io/IOException;
        //  161    168    597    618    Any
        //  174    190    696    713    Ljava/io/IOException;
        //  174    190    597    618    Any
        //  196    206    696    713    Ljava/io/IOException;
        //  196    206    597    618    Any
        //  212    224    696    713    Ljava/io/IOException;
        //  212    224    597    618    Any
        //  230    255    696    713    Ljava/io/IOException;
        //  230    255    597    618    Any
        //  264    271    696    713    Ljava/io/IOException;
        //  264    271    597    618    Any
        //  277    293    696    713    Ljava/io/IOException;
        //  277    293    597    618    Any
        //  299    320    696    713    Ljava/io/IOException;
        //  299    320    597    618    Any
        //  326    332    696    713    Ljava/io/IOException;
        //  326    332    597    618    Any
        //  338    347    696    713    Ljava/io/IOException;
        //  338    347    597    618    Any
        //  353    361    696    713    Ljava/io/IOException;
        //  353    361    597    618    Any
        //  367    372    696    713    Ljava/io/IOException;
        //  367    372    597    618    Any
        //  378    385    696    713    Ljava/io/IOException;
        //  378    385    597    618    Any
        //  385    397    654    680    Ljava/io/IOException;
        //  385    397    618    638    Any
        //  403    409    696    713    Ljava/io/IOException;
        //  403    409    597    618    Any
        //  413    420    696    713    Ljava/io/IOException;
        //  413    420    597    618    Any
        //  420    431    680    696    Ljava/io/IOException;
        //  420    431    638    654    Any
        //  519    524    568    597    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 352 out of bounds for length 352
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
}
