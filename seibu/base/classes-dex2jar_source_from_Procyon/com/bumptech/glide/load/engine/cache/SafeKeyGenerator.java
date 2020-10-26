// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;

class SafeKeyGenerator
{
    private final LruCache<Key, String> loadIdToSafeHash;
    
    SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache<Key, String>(1000);
    }
    
    public String getSafeKey(final Key p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash:Lcom/bumptech/glide/util/LruCache;
        //     4: astore_3       
        //     5: aload_3        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash:Lcom/bumptech/glide/util/LruCache;
        //    11: aload_1        
        //    12: invokevirtual   com/bumptech/glide/util/LruCache.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    15: checkcast       Ljava/lang/String;
        //    18: astore_2       
        //    19: aload_3        
        //    20: monitorexit    
        //    21: aload_2        
        //    22: astore_3       
        //    23: aload_2        
        //    24: ifnonnull       71
        //    27: ldc             "SHA-256"
        //    29: invokestatic    java/security/MessageDigest.getInstance:(Ljava/lang/String;)Ljava/security/MessageDigest;
        //    32: astore_3       
        //    33: aload_1        
        //    34: aload_3        
        //    35: invokeinterface com/bumptech/glide/load/Key.updateDiskCacheKey:(Ljava/security/MessageDigest;)V
        //    40: aload_3        
        //    41: invokevirtual   java/security/MessageDigest.digest:()[B
        //    44: invokestatic    com/bumptech/glide/util/Util.sha256BytesToHex:([B)Ljava/lang/String;
        //    47: astore_3       
        //    48: aload_3        
        //    49: astore_2       
        //    50: aload_0        
        //    51: getfield        com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash:Lcom/bumptech/glide/util/LruCache;
        //    54: astore_3       
        //    55: aload_3        
        //    56: monitorenter   
        //    57: aload_0        
        //    58: getfield        com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash:Lcom/bumptech/glide/util/LruCache;
        //    61: aload_1        
        //    62: aload_2        
        //    63: invokevirtual   com/bumptech/glide/util/LruCache.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    66: pop            
        //    67: aload_3        
        //    68: monitorexit    
        //    69: aload_2        
        //    70: astore_3       
        //    71: aload_3        
        //    72: areturn        
        //    73: astore_1       
        //    74: aload_3        
        //    75: monitorexit    
        //    76: aload_1        
        //    77: athrow         
        //    78: astore_3       
        //    79: aload_3        
        //    80: invokevirtual   java/io/UnsupportedEncodingException.printStackTrace:()V
        //    83: goto            50
        //    86: astore_3       
        //    87: aload_3        
        //    88: invokevirtual   java/security/NoSuchAlgorithmException.printStackTrace:()V
        //    91: goto            50
        //    94: astore_1       
        //    95: aload_3        
        //    96: monitorexit    
        //    97: aload_1        
        //    98: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                    
        //  -----  -----  -----  -----  ----------------------------------------
        //  7      21     73     78     Any
        //  27     48     78     86     Ljava/io/UnsupportedEncodingException;
        //  27     48     86     94     Ljava/security/NoSuchAlgorithmException;
        //  57     69     94     99     Any
        //  74     76     73     78     Any
        //  95     97     94     99     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 64 out of bounds for length 64
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
