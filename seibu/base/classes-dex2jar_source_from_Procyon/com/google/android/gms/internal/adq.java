// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class adq
{
    private static void zza(final String p0, final Object p1, final StringBuffer p2, final StringBuffer p3) throws IllegalAccessException, InvocationTargetException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnull          474
        //     4: aload_1        
        //     5: instanceof      Lcom/google/android/gms/internal/adp;
        //     8: ifeq            475
        //    11: aload_2        
        //    12: invokevirtual   java/lang/StringBuffer.length:()I
        //    15: istore          7
        //    17: aload_0        
        //    18: ifnull          46
        //    21: aload_3        
        //    22: aload_2        
        //    23: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
        //    26: aload_0        
        //    27: invokestatic    com/google/android/gms/internal/adq.zzhR:(Ljava/lang/String;)Ljava/lang/String;
        //    30: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    33: ldc             " <\n"
        //    35: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    38: pop            
        //    39: aload_2        
        //    40: ldc             "  "
        //    42: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    45: pop            
        //    46: aload_1        
        //    47: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    50: astore          10
        //    52: aload           10
        //    54: invokevirtual   java/lang/Class.getFields:()[Ljava/lang/reflect/Field;
        //    57: astore          9
        //    59: aload           9
        //    61: arraylength    
        //    62: istore          8
        //    64: iconst_0       
        //    65: istore          4
        //    67: iload           4
        //    69: iload           8
        //    71: if_icmpge       246
        //    74: aload           9
        //    76: iload           4
        //    78: aaload         
        //    79: astore          13
        //    81: aload           13
        //    83: invokevirtual   java/lang/reflect/Field.getModifiers:()I
        //    86: istore          5
        //    88: aload           13
        //    90: invokevirtual   java/lang/reflect/Field.getName:()Ljava/lang/String;
        //    93: astore          11
        //    95: ldc             "cachedSize"
        //    97: aload           11
        //    99: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   102: ifne            237
        //   105: iload           5
        //   107: iconst_1       
        //   108: iand           
        //   109: iconst_1       
        //   110: if_icmpne       237
        //   113: iload           5
        //   115: bipush          8
        //   117: iand           
        //   118: bipush          8
        //   120: if_icmpeq       237
        //   123: aload           11
        //   125: ldc             "_"
        //   127: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   130: ifne            237
        //   133: aload           11
        //   135: ldc             "_"
        //   137: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //   140: ifne            237
        //   143: aload           13
        //   145: invokevirtual   java/lang/reflect/Field.getType:()Ljava/lang/Class;
        //   148: astore          12
        //   150: aload           13
        //   152: aload_1        
        //   153: invokevirtual   java/lang/reflect/Field.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   156: astore          13
        //   158: aload           12
        //   160: invokevirtual   java/lang/Class.isArray:()Z
        //   163: ifeq            228
        //   166: aload           12
        //   168: invokevirtual   java/lang/Class.getComponentType:()Ljava/lang/Class;
        //   171: getstatic       java/lang/Byte.TYPE:Ljava/lang/Class;
        //   174: if_acmpeq       228
        //   177: aload           13
        //   179: ifnonnull       218
        //   182: iconst_0       
        //   183: istore          5
        //   185: iconst_0       
        //   186: istore          6
        //   188: iload           6
        //   190: iload           5
        //   192: if_icmpge       237
        //   195: aload           11
        //   197: aload           13
        //   199: iload           6
        //   201: invokestatic    java/lang/reflect/Array.get:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   204: aload_2        
        //   205: aload_3        
        //   206: invokestatic    com/google/android/gms/internal/adq.zza:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
        //   209: iload           6
        //   211: iconst_1       
        //   212: iadd           
        //   213: istore          6
        //   215: goto            188
        //   218: aload           13
        //   220: invokestatic    java/lang/reflect/Array.getLength:(Ljava/lang/Object;)I
        //   223: istore          5
        //   225: goto            185
        //   228: aload           11
        //   230: aload           13
        //   232: aload_2        
        //   233: aload_3        
        //   234: invokestatic    com/google/android/gms/internal/adq.zza:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
        //   237: iload           4
        //   239: iconst_1       
        //   240: iadd           
        //   241: istore          4
        //   243: goto            67
        //   246: aload           10
        //   248: invokevirtual   java/lang/Class.getMethods:()[Ljava/lang/reflect/Method;
        //   251: astore          11
        //   253: aload           11
        //   255: arraylength    
        //   256: istore          5
        //   258: iconst_0       
        //   259: istore          4
        //   261: iload           4
        //   263: iload           5
        //   265: if_icmpge       453
        //   268: aload           11
        //   270: iload           4
        //   272: aaload         
        //   273: invokevirtual   java/lang/reflect/Method.getName:()Ljava/lang/String;
        //   276: astore          9
        //   278: aload           9
        //   280: ldc             "set"
        //   282: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   285: ifeq            406
        //   288: aload           9
        //   290: iconst_3       
        //   291: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   294: astore          12
        //   296: aload           12
        //   298: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   301: astore          9
        //   303: aload           9
        //   305: invokevirtual   java/lang/String.length:()I
        //   308: ifeq            415
        //   311: ldc             "has"
        //   313: aload           9
        //   315: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   318: astore          9
        //   320: aload           10
        //   322: aload           9
        //   324: iconst_0       
        //   325: anewarray       Ljava/lang/Class;
        //   328: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   331: astore          9
        //   333: aload           9
        //   335: aload_1        
        //   336: iconst_0       
        //   337: anewarray       Ljava/lang/Object;
        //   340: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   343: checkcast       Ljava/lang/Boolean;
        //   346: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   349: ifeq            406
        //   352: aload           12
        //   354: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   357: astore          9
        //   359: aload           9
        //   361: invokevirtual   java/lang/String.length:()I
        //   364: ifeq            434
        //   367: ldc             "get"
        //   369: aload           9
        //   371: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   374: astore          9
        //   376: aload           10
        //   378: aload           9
        //   380: iconst_0       
        //   381: anewarray       Ljava/lang/Class;
        //   384: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   387: astore          9
        //   389: aload           12
        //   391: aload           9
        //   393: aload_1        
        //   394: iconst_0       
        //   395: anewarray       Ljava/lang/Object;
        //   398: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   401: aload_2        
        //   402: aload_3        
        //   403: invokestatic    com/google/android/gms/internal/adq.zza:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
        //   406: iload           4
        //   408: iconst_1       
        //   409: iadd           
        //   410: istore          4
        //   412: goto            261
        //   415: new             Ljava/lang/String;
        //   418: dup            
        //   419: ldc             "has"
        //   421: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   424: astore          9
        //   426: goto            320
        //   429: astore          9
        //   431: goto            406
        //   434: new             Ljava/lang/String;
        //   437: dup            
        //   438: ldc             "get"
        //   440: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   443: astore          9
        //   445: goto            376
        //   448: astore          9
        //   450: goto            406
        //   453: aload_0        
        //   454: ifnull          474
        //   457: aload_2        
        //   458: iload           7
        //   460: invokevirtual   java/lang/StringBuffer.setLength:(I)V
        //   463: aload_3        
        //   464: aload_2        
        //   465: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
        //   468: ldc             ">\n"
        //   470: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   473: pop            
        //   474: return         
        //   475: aload_0        
        //   476: invokestatic    com/google/android/gms/internal/adq.zzhR:(Ljava/lang/String;)Ljava/lang/String;
        //   479: astore_0       
        //   480: aload_3        
        //   481: aload_2        
        //   482: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
        //   485: aload_0        
        //   486: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   489: ldc             ": "
        //   491: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   494: pop            
        //   495: aload_1        
        //   496: instanceof      Ljava/lang/String;
        //   499: ifeq            576
        //   502: aload_1        
        //   503: checkcast       Ljava/lang/String;
        //   506: astore_1       
        //   507: aload_1        
        //   508: astore_0       
        //   509: aload_1        
        //   510: ldc             "http"
        //   512: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   515: ifne            547
        //   518: aload_1        
        //   519: astore_0       
        //   520: aload_1        
        //   521: invokevirtual   java/lang/String.length:()I
        //   524: sipush          200
        //   527: if_icmple       547
        //   530: aload_1        
        //   531: iconst_0       
        //   532: sipush          200
        //   535: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   538: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   541: ldc             "[...]"
        //   543: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   546: astore_0       
        //   547: aload_0        
        //   548: invokestatic    com/google/android/gms/internal/adq.zzcK:(Ljava/lang/String;)Ljava/lang/String;
        //   551: astore_0       
        //   552: aload_3        
        //   553: ldc             "\""
        //   555: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   558: aload_0        
        //   559: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   562: ldc             "\""
        //   564: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   567: pop            
        //   568: aload_3        
        //   569: ldc             "\n"
        //   571: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   574: pop            
        //   575: return         
        //   576: aload_1        
        //   577: instanceof      [B
        //   580: ifeq            594
        //   583: aload_1        
        //   584: checkcast       [B
        //   587: aload_3        
        //   588: invokestatic    com/google/android/gms/internal/adq.zza:([BLjava/lang/StringBuffer;)V
        //   591: goto            568
        //   594: aload_3        
        //   595: aload_1        
        //   596: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/Object;)Ljava/lang/StringBuffer;
        //   599: pop            
        //   600: goto            568
        //    Exceptions:
        //  throws java.lang.IllegalAccessException
        //  throws java.lang.reflect.InvocationTargetException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  296    320    429    434    Ljava/lang/NoSuchMethodException;
        //  320    333    429    434    Ljava/lang/NoSuchMethodException;
        //  352    376    448    453    Ljava/lang/NoSuchMethodException;
        //  376    389    448    453    Ljava/lang/NoSuchMethodException;
        //  415    426    429    434    Ljava/lang/NoSuchMethodException;
        //  434    445    448    453    Ljava/lang/NoSuchMethodException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0376:
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
    
    private static void zza(final byte[] array, final StringBuffer sb) {
        if (array == null) {
            sb.append("\"\"");
            return;
        }
        sb.append('\"');
        for (int i = 0; i < array.length; ++i) {
            final int j = array[i] & 0xFF;
            if (j == 92 || j == 34) {
                sb.append('\\').append((char)j);
            }
            else if (j >= 32 && j < 127) {
                sb.append((char)j);
            }
            else {
                sb.append(String.format("\\%03o", j));
            }
        }
        sb.append('\"');
    }
    
    private static String zzcK(final String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 >= ' ' && char1 <= '~' && char1 != '\"' && char1 != '\'') {
                sb.append(char1);
            }
            else {
                sb.append(String.format("\\u%04x", (int)char1));
            }
        }
        return sb.toString();
    }
    
    public static <T extends adp> String zzd(final T t) {
        if (t == null) {
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), sb);
            return sb.toString();
        }
        catch (IllegalAccessException ex) {
            final String value = String.valueOf(ex.getMessage());
            if (value.length() != 0) {
                return "Error printing proto: ".concat(value);
            }
            return new String("Error printing proto: ");
        }
        catch (InvocationTargetException ex2) {
            final String value2 = String.valueOf(ex2.getMessage());
            if (value2.length() != 0) {
                return "Error printing proto: ".concat(value2);
            }
            return new String("Error printing proto: ");
        }
    }
    
    private static String zzhR(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (i == 0) {
                sb.append(Character.toLowerCase(char1));
            }
            else if (Character.isUpperCase(char1)) {
                sb.append('_').append(Character.toLowerCase(char1));
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
}
