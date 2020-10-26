// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

class DetectionResultColumn
{
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;
    
    DetectionResultColumn(final BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[boundingBox.getMaxY() - boundingBox.getMinY() + 1];
    }
    
    final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    final Codeword getCodeword(final int n) {
        return this.codewords[this.imageRowToCodewordIndex(n)];
    }
    
    final Codeword getCodewordNearby(final int n) {
        final Codeword codeword = this.getCodeword(n);
        if (codeword != null) {
            return codeword;
        }
        for (int i = 1; i < 5; ++i) {
            final int n2 = this.imageRowToCodewordIndex(n) - i;
            if (n2 >= 0) {
                final Codeword codeword2 = this.codewords[n2];
                if (codeword2 != null) {
                    return codeword2;
                }
            }
            final int n3 = this.imageRowToCodewordIndex(n) + i;
            if (n3 < this.codewords.length) {
                final Codeword codeword3 = this.codewords[n3];
                if (codeword3 != null) {
                    return codeword3;
                }
            }
        }
        return null;
    }
    
    final Codeword[] getCodewords() {
        return this.codewords;
    }
    
    final int imageRowToCodewordIndex(final int n) {
        return n - this.boundingBox.getMinY();
    }
    
    final void setCodeword(final int n, final Codeword codeword) {
        this.codewords[this.imageRowToCodewordIndex(n)] = codeword;
    }
    
    @Override
    public String toString() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2       
        //     2: new             Ljava/util/Formatter;
        //     5: dup            
        //     6: invokespecial   java/util/Formatter.<init>:()V
        //     9: astore          8
        //    11: aconst_null    
        //    12: astore          6
        //    14: aload_0        
        //    15: getfield        com/google/zxing/pdf417/decoder/DetectionResultColumn.codewords:[Lcom/google/zxing/pdf417/decoder/Codeword;
        //    18: astore          5
        //    20: aload           5
        //    22: arraylength    
        //    23: istore          4
        //    25: iconst_0       
        //    26: istore_1       
        //    27: iload_2        
        //    28: iload           4
        //    30: if_icmpge       154
        //    33: aload           5
        //    35: iload_2        
        //    36: aaload         
        //    37: astore          7
        //    39: aload           7
        //    41: ifnonnull       76
        //    44: iload_1        
        //    45: iconst_1       
        //    46: iadd           
        //    47: istore_3       
        //    48: aload           8
        //    50: ldc             "%3d:    |   %n"
        //    52: iconst_1       
        //    53: anewarray       Ljava/lang/Object;
        //    56: dup            
        //    57: iconst_0       
        //    58: iload_1        
        //    59: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    62: aastore        
        //    63: invokevirtual   java/util/Formatter.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
        //    66: pop            
        //    67: iload_3        
        //    68: istore_1       
        //    69: iload_2        
        //    70: iconst_1       
        //    71: iadd           
        //    72: istore_2       
        //    73: goto            27
        //    76: iload_1        
        //    77: iconst_1       
        //    78: iadd           
        //    79: istore_3       
        //    80: aload           8
        //    82: ldc             "%3d: %3d|%3d%n"
        //    84: iconst_3       
        //    85: anewarray       Ljava/lang/Object;
        //    88: dup            
        //    89: iconst_0       
        //    90: iload_1        
        //    91: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    94: aastore        
        //    95: dup            
        //    96: iconst_1       
        //    97: aload           7
        //    99: invokevirtual   com/google/zxing/pdf417/decoder/Codeword.getRowNumber:()I
        //   102: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   105: aastore        
        //   106: dup            
        //   107: iconst_2       
        //   108: aload           7
        //   110: invokevirtual   com/google/zxing/pdf417/decoder/Codeword.getValue:()I
        //   113: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   116: aastore        
        //   117: invokevirtual   java/util/Formatter.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
        //   120: pop            
        //   121: iload_3        
        //   122: istore_1       
        //   123: goto            69
        //   126: astore          5
        //   128: aload           5
        //   130: athrow         
        //   131: astore          7
        //   133: aload           5
        //   135: astore          6
        //   137: aload           7
        //   139: astore          5
        //   141: aload           6
        //   143: ifnull          181
        //   146: aload           8
        //   148: invokevirtual   java/util/Formatter.close:()V
        //   151: aload           5
        //   153: athrow         
        //   154: aload           8
        //   156: invokevirtual   java/util/Formatter.toString:()Ljava/lang/String;
        //   159: astore          5
        //   161: aload           8
        //   163: invokevirtual   java/util/Formatter.close:()V
        //   166: aload           5
        //   168: areturn        
        //   169: astore          7
        //   171: aload           6
        //   173: aload           7
        //   175: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   178: goto            151
        //   181: aload           8
        //   183: invokevirtual   java/util/Formatter.close:()V
        //   186: goto            151
        //   189: astore          5
        //   191: goto            141
        //   194: astore          5
        //   196: goto            128
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     25     126    128    Ljava/lang/Throwable;
        //  14     25     189    194    Any
        //  48     67     126    128    Ljava/lang/Throwable;
        //  48     67     189    194    Any
        //  80     121    126    128    Ljava/lang/Throwable;
        //  80     121    189    194    Any
        //  128    131    131    141    Any
        //  146    151    169    181    Ljava/lang/Throwable;
        //  154    161    194    199    Ljava/lang/Throwable;
        //  154    161    189    194    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0154:
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
}
