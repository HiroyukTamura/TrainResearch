// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

public class HttpUtils
{
    public static boolean download(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: monitorenter   
        //     3: iconst_1       
        //     4: istore_3       
        //     5: aconst_null    
        //     6: astore          10
        //     8: aconst_null    
        //     9: astore          6
        //    11: aconst_null    
        //    12: astore          11
        //    14: aconst_null    
        //    15: astore          15
        //    17: aconst_null    
        //    18: astore          13
        //    20: aconst_null    
        //    21: astore          14
        //    23: aconst_null    
        //    24: astore          16
        //    26: aconst_null    
        //    27: astore          17
        //    29: aconst_null    
        //    30: astore          5
        //    32: aload           5
        //    34: astore          9
        //    36: aload           16
        //    38: astore          12
        //    40: aload           17
        //    42: astore          7
        //    44: aload           13
        //    46: astore          8
        //    48: new             Ljava/net/URL;
        //    51: dup            
        //    52: aload_0        
        //    53: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    56: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    59: checkcast       Ljava/net/HttpURLConnection;
        //    62: astore_0       
        //    63: aload_0        
        //    64: astore          11
        //    66: aload           5
        //    68: astore          9
        //    70: aload_0        
        //    71: astore          10
        //    73: aload           16
        //    75: astore          12
        //    77: aload_0        
        //    78: astore          6
        //    80: aload           17
        //    82: astore          7
        //    84: aload           13
        //    86: astore          8
        //    88: new             Ljava/io/File;
        //    91: dup            
        //    92: new             Ljava/lang/StringBuilder;
        //    95: dup            
        //    96: invokespecial   java/lang/StringBuilder.<init>:()V
        //    99: aload_1        
        //   100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: ldc             "temp"
        //   105: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   108: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   111: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   114: astore          18
        //   116: aload_0        
        //   117: astore          11
        //   119: aload           5
        //   121: astore          9
        //   123: aload_0        
        //   124: astore          10
        //   126: aload           16
        //   128: astore          12
        //   130: aload_0        
        //   131: astore          6
        //   133: aload           17
        //   135: astore          7
        //   137: aload           13
        //   139: astore          8
        //   141: aload_0        
        //   142: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   145: astore          5
        //   147: aload_0        
        //   148: astore          11
        //   150: aload           5
        //   152: astore          9
        //   154: aload_0        
        //   155: astore          10
        //   157: aload           5
        //   159: astore          12
        //   161: aload_0        
        //   162: astore          6
        //   164: aload           5
        //   166: astore          7
        //   168: aload           13
        //   170: astore          8
        //   172: aload           18
        //   174: invokevirtual   java/io/File.exists:()Z
        //   177: ifeq            456
        //   180: aload_0        
        //   181: astore          11
        //   183: aload           5
        //   185: astore          9
        //   187: aload_0        
        //   188: astore          10
        //   190: aload           5
        //   192: astore          12
        //   194: aload_0        
        //   195: astore          6
        //   197: aload           5
        //   199: astore          7
        //   201: aload           13
        //   203: astore          8
        //   205: new             Ljava/io/File;
        //   208: dup            
        //   209: new             Ljava/lang/StringBuilder;
        //   212: dup            
        //   213: invokespecial   java/lang/StringBuilder.<init>:()V
        //   216: aload_1        
        //   217: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   220: ldc             ".bk"
        //   222: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   225: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   228: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   231: astore          16
        //   233: aload_0        
        //   234: astore          11
        //   236: aload           5
        //   238: astore          9
        //   240: aload_0        
        //   241: astore          10
        //   243: aload           5
        //   245: astore          12
        //   247: aload_0        
        //   248: astore          6
        //   250: aload           5
        //   252: astore          7
        //   254: aload           13
        //   256: astore          8
        //   258: aload           16
        //   260: invokevirtual   java/io/File.delete:()Z
        //   263: pop            
        //   264: aload_0        
        //   265: astore          11
        //   267: aload           5
        //   269: astore          9
        //   271: aload_0        
        //   272: astore          10
        //   274: aload           5
        //   276: astore          12
        //   278: aload_0        
        //   279: astore          6
        //   281: aload           5
        //   283: astore          7
        //   285: aload           13
        //   287: astore          8
        //   289: aload           18
        //   291: aload           16
        //   293: invokevirtual   java/io/File.renameTo:(Ljava/io/File;)Z
        //   296: pop            
        //   297: aload_0        
        //   298: astore          11
        //   300: aload           5
        //   302: astore          9
        //   304: aload_0        
        //   305: astore          10
        //   307: aload           5
        //   309: astore          12
        //   311: aload_0        
        //   312: astore          6
        //   314: aload           5
        //   316: astore          7
        //   318: aload           13
        //   320: astore          8
        //   322: aload           18
        //   324: invokevirtual   java/io/File.createNewFile:()Z
        //   327: pop            
        //   328: aload_0        
        //   329: astore          11
        //   331: aload           5
        //   333: astore          9
        //   335: aload_0        
        //   336: astore          10
        //   338: aload           5
        //   340: astore          12
        //   342: aload_0        
        //   343: astore          6
        //   345: aload           5
        //   347: astore          7
        //   349: aload           13
        //   351: astore          8
        //   353: new             Ljava/io/FileOutputStream;
        //   356: dup            
        //   357: aload           18
        //   359: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   362: astore          13
        //   364: sipush          4096
        //   367: newarray        B
        //   369: astore          6
        //   371: aload           5
        //   373: aload           6
        //   375: invokevirtual   java/io/InputStream.read:([B)I
        //   378: istore_2       
        //   379: iload_2        
        //   380: iconst_m1      
        //   381: if_icmpeq       515
        //   384: aload           13
        //   386: aload           6
        //   388: iconst_0       
        //   389: iload_2        
        //   390: invokevirtual   java/io/OutputStream.write:([BII)V
        //   393: goto            371
        //   396: astore          10
        //   398: aload           13
        //   400: astore_1       
        //   401: aload_0        
        //   402: astore          6
        //   404: aload           5
        //   406: astore          7
        //   408: aload_1        
        //   409: astore          8
        //   411: aload           10
        //   413: invokevirtual   java/net/MalformedURLException.printStackTrace:()V
        //   416: iconst_0       
        //   417: istore          4
        //   419: aload_1        
        //   420: ifnull          427
        //   423: aload_1        
        //   424: invokevirtual   java/io/OutputStream.close:()V
        //   427: aload           5
        //   429: ifnull          437
        //   432: aload           5
        //   434: invokevirtual   java/io/InputStream.close:()V
        //   437: iload           4
        //   439: istore_3       
        //   440: aload_0        
        //   441: ifnull          451
        //   444: aload_0        
        //   445: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   448: iload           4
        //   450: istore_3       
        //   451: ldc             Lcom/feilang/mvpproject/util/HttpUtils;.class
        //   453: monitorexit    
        //   454: iload_3        
        //   455: ireturn        
        //   456: aload_0        
        //   457: astore          11
        //   459: aload           5
        //   461: astore          9
        //   463: aload_0        
        //   464: astore          10
        //   466: aload           5
        //   468: astore          12
        //   470: aload_0        
        //   471: astore          6
        //   473: aload           5
        //   475: astore          7
        //   477: aload           13
        //   479: astore          8
        //   481: new             Ljava/io/File;
        //   484: dup            
        //   485: aload           18
        //   487: invokevirtual   java/io/File.getParent:()Ljava/lang/String;
        //   490: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   493: invokevirtual   java/io/File.mkdirs:()Z
        //   496: pop            
        //   497: goto            297
        //   500: astore          10
        //   502: aload           11
        //   504: astore_0       
        //   505: aload           9
        //   507: astore          5
        //   509: aload           14
        //   511: astore_1       
        //   512: goto            401
        //   515: aload           13
        //   517: invokevirtual   java/io/OutputStream.flush:()V
        //   520: aload           18
        //   522: new             Ljava/io/File;
        //   525: dup            
        //   526: aload_1        
        //   527: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   530: invokevirtual   java/io/File.renameTo:(Ljava/io/File;)Z
        //   533: pop            
        //   534: aload           18
        //   536: invokevirtual   java/io/File.delete:()Z
        //   539: pop            
        //   540: aload           13
        //   542: ifnull          550
        //   545: aload           13
        //   547: invokevirtual   java/io/OutputStream.close:()V
        //   550: aload           5
        //   552: ifnull          560
        //   555: aload           5
        //   557: invokevirtual   java/io/InputStream.close:()V
        //   560: aload_0        
        //   561: ifnull          568
        //   564: aload_0        
        //   565: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   568: goto            451
        //   571: astore_0       
        //   572: aload_0        
        //   573: invokevirtual   java/io/IOException.printStackTrace:()V
        //   576: goto            451
        //   579: astore_0       
        //   580: aload_0        
        //   581: invokevirtual   java/io/IOException.printStackTrace:()V
        //   584: iload           4
        //   586: istore_3       
        //   587: goto            451
        //   590: astore_0       
        //   591: ldc             Lcom/feilang/mvpproject/util/HttpUtils;.class
        //   593: monitorexit    
        //   594: aload_0        
        //   595: athrow         
        //   596: astore          9
        //   598: aload           15
        //   600: astore_1       
        //   601: aload           12
        //   603: astore          5
        //   605: aload           10
        //   607: astore_0       
        //   608: aload_0        
        //   609: astore          6
        //   611: aload           5
        //   613: astore          7
        //   615: aload_1        
        //   616: astore          8
        //   618: aload           9
        //   620: invokevirtual   java/io/IOException.printStackTrace:()V
        //   623: iconst_0       
        //   624: istore          4
        //   626: aload_1        
        //   627: ifnull          634
        //   630: aload_1        
        //   631: invokevirtual   java/io/OutputStream.close:()V
        //   634: aload           5
        //   636: ifnull          644
        //   639: aload           5
        //   641: invokevirtual   java/io/InputStream.close:()V
        //   644: iload           4
        //   646: istore_3       
        //   647: aload_0        
        //   648: ifnull          451
        //   651: aload_0        
        //   652: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   655: iload           4
        //   657: istore_3       
        //   658: goto            451
        //   661: astore_0       
        //   662: aload_0        
        //   663: invokevirtual   java/io/IOException.printStackTrace:()V
        //   666: iload           4
        //   668: istore_3       
        //   669: goto            451
        //   672: astore_0       
        //   673: aload           7
        //   675: astore          5
        //   677: aload           8
        //   679: ifnull          687
        //   682: aload           8
        //   684: invokevirtual   java/io/OutputStream.close:()V
        //   687: aload           5
        //   689: ifnull          697
        //   692: aload           5
        //   694: invokevirtual   java/io/InputStream.close:()V
        //   697: aload           6
        //   699: ifnull          707
        //   702: aload           6
        //   704: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   707: aload_0        
        //   708: athrow         
        //   709: astore_1       
        //   710: aload_1        
        //   711: invokevirtual   java/io/IOException.printStackTrace:()V
        //   714: goto            707
        //   717: astore_1       
        //   718: aload           13
        //   720: astore          8
        //   722: aload_0        
        //   723: astore          6
        //   725: aload_1        
        //   726: astore_0       
        //   727: goto            677
        //   730: astore          9
        //   732: aload           13
        //   734: astore_1       
        //   735: goto            608
        //   738: astore_0       
        //   739: goto            591
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  48     63     500    515    Ljava/net/MalformedURLException;
        //  48     63     596    608    Ljava/io/IOException;
        //  48     63     672    677    Any
        //  88     116    500    515    Ljava/net/MalformedURLException;
        //  88     116    596    608    Ljava/io/IOException;
        //  88     116    672    677    Any
        //  141    147    500    515    Ljava/net/MalformedURLException;
        //  141    147    596    608    Ljava/io/IOException;
        //  141    147    672    677    Any
        //  172    180    500    515    Ljava/net/MalformedURLException;
        //  172    180    596    608    Ljava/io/IOException;
        //  172    180    672    677    Any
        //  205    233    500    515    Ljava/net/MalformedURLException;
        //  205    233    596    608    Ljava/io/IOException;
        //  205    233    672    677    Any
        //  258    264    500    515    Ljava/net/MalformedURLException;
        //  258    264    596    608    Ljava/io/IOException;
        //  258    264    672    677    Any
        //  289    297    500    515    Ljava/net/MalformedURLException;
        //  289    297    596    608    Ljava/io/IOException;
        //  289    297    672    677    Any
        //  322    328    500    515    Ljava/net/MalformedURLException;
        //  322    328    596    608    Ljava/io/IOException;
        //  322    328    672    677    Any
        //  353    364    500    515    Ljava/net/MalformedURLException;
        //  353    364    596    608    Ljava/io/IOException;
        //  353    364    672    677    Any
        //  364    371    396    401    Ljava/net/MalformedURLException;
        //  364    371    730    738    Ljava/io/IOException;
        //  364    371    717    730    Any
        //  371    379    396    401    Ljava/net/MalformedURLException;
        //  371    379    730    738    Ljava/io/IOException;
        //  371    379    717    730    Any
        //  384    393    396    401    Ljava/net/MalformedURLException;
        //  384    393    730    738    Ljava/io/IOException;
        //  384    393    717    730    Any
        //  411    416    672    677    Any
        //  423    427    579    590    Ljava/io/IOException;
        //  423    427    590    591    Any
        //  432    437    579    590    Ljava/io/IOException;
        //  432    437    590    591    Any
        //  444    448    579    590    Ljava/io/IOException;
        //  444    448    590    591    Any
        //  481    497    500    515    Ljava/net/MalformedURLException;
        //  481    497    596    608    Ljava/io/IOException;
        //  481    497    672    677    Any
        //  515    540    396    401    Ljava/net/MalformedURLException;
        //  515    540    730    738    Ljava/io/IOException;
        //  515    540    717    730    Any
        //  545    550    571    579    Ljava/io/IOException;
        //  545    550    738    742    Any
        //  555    560    571    579    Ljava/io/IOException;
        //  555    560    738    742    Any
        //  564    568    571    579    Ljava/io/IOException;
        //  564    568    738    742    Any
        //  572    576    738    742    Any
        //  580    584    590    591    Any
        //  618    623    672    677    Any
        //  630    634    661    672    Ljava/io/IOException;
        //  630    634    590    591    Any
        //  639    644    661    672    Ljava/io/IOException;
        //  639    644    590    591    Any
        //  651    655    661    672    Ljava/io/IOException;
        //  651    655    590    591    Any
        //  662    666    590    591    Any
        //  682    687    709    717    Ljava/io/IOException;
        //  682    687    590    591    Any
        //  692    697    709    717    Ljava/io/IOException;
        //  692    697    590    591    Any
        //  702    707    709    717    Ljava/io/IOException;
        //  702    707    590    591    Any
        //  707    709    590    591    Any
        //  710    714    590    591    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 388 out of bounds for length 388
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3569)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3435)
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
