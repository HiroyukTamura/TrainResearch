// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.tinypinyin.android.asset.lexicons;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import com.github.promeg.pinyinhelper.PinyinMapDict;

public abstract class AndroidAssetDict extends PinyinMapDict
{
    final Context mContext;
    final Map<String, String[]> mDict;
    
    public AndroidAssetDict(final Context context) {
        this.mContext = context.getApplicationContext();
        this.mDict = new HashMap<String, String[]>();
        this.init();
    }
    
    private void init() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: aconst_null    
        //     3: astore          4
        //     5: new             Ljava/io/BufferedReader;
        //     8: dup            
        //     9: new             Ljava/io/InputStreamReader;
        //    12: dup            
        //    13: aload_0        
        //    14: getfield        com/github/promeg/tinypinyin/android/asset/lexicons/AndroidAssetDict.mContext:Landroid/content/Context;
        //    17: invokevirtual   android/content/Context.getAssets:()Landroid/content/res/AssetManager;
        //    20: aload_0        
        //    21: invokevirtual   com/github/promeg/tinypinyin/android/asset/lexicons/AndroidAssetDict.assetFileName:()Ljava/lang/String;
        //    24: invokevirtual   android/content/res/AssetManager.open:(Ljava/lang/String;)Ljava/io/InputStream;
        //    27: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    30: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    33: astore_2       
        //    34: aload_2        
        //    35: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    38: astore_1       
        //    39: aload_1        
        //    40: ifnull          102
        //    43: aload_1        
        //    44: ldc             "\\s+"
        //    46: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    49: astore_1       
        //    50: aload_1        
        //    51: ifnull          34
        //    54: aload_1        
        //    55: arraylength    
        //    56: iconst_2       
        //    57: if_icmpne       34
        //    60: aload_1        
        //    61: iconst_0       
        //    62: aaload         
        //    63: ldc             "'"
        //    65: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    68: astore_3       
        //    69: aload_0        
        //    70: getfield        com/github/promeg/tinypinyin/android/asset/lexicons/AndroidAssetDict.mDict:Ljava/util/Map;
        //    73: aload_1        
        //    74: iconst_1       
        //    75: aaload         
        //    76: aload_3        
        //    77: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    82: pop            
        //    83: goto            34
        //    86: astore_3       
        //    87: aload_2        
        //    88: astore_1       
        //    89: aload_3        
        //    90: invokevirtual   java/io/IOException.printStackTrace:()V
        //    93: aload_2        
        //    94: ifnull          101
        //    97: aload_2        
        //    98: invokevirtual   java/io/BufferedReader.close:()V
        //   101: return         
        //   102: aload_2        
        //   103: ifnull          157
        //   106: aload_2        
        //   107: invokevirtual   java/io/BufferedReader.close:()V
        //   110: return         
        //   111: astore_1       
        //   112: aload_1        
        //   113: invokevirtual   java/io/IOException.printStackTrace:()V
        //   116: return         
        //   117: astore_1       
        //   118: aload_1        
        //   119: invokevirtual   java/io/IOException.printStackTrace:()V
        //   122: return         
        //   123: astore_2       
        //   124: aload_1        
        //   125: ifnull          132
        //   128: aload_1        
        //   129: invokevirtual   java/io/BufferedReader.close:()V
        //   132: aload_2        
        //   133: athrow         
        //   134: astore_1       
        //   135: aload_1        
        //   136: invokevirtual   java/io/IOException.printStackTrace:()V
        //   139: goto            132
        //   142: astore_3       
        //   143: aload_2        
        //   144: astore_1       
        //   145: aload_3        
        //   146: astore_2       
        //   147: goto            124
        //   150: astore_3       
        //   151: aload           4
        //   153: astore_2       
        //   154: goto            87
        //   157: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      34     150    157    Ljava/io/IOException;
        //  5      34     123    124    Any
        //  34     39     86     87     Ljava/io/IOException;
        //  34     39     142    150    Any
        //  43     50     86     87     Ljava/io/IOException;
        //  43     50     142    150    Any
        //  54     83     86     87     Ljava/io/IOException;
        //  54     83     142    150    Any
        //  89     93     123    124    Any
        //  97     101    117    123    Ljava/io/IOException;
        //  106    110    111    117    Ljava/io/IOException;
        //  128    132    134    142    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0132:
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
    
    protected abstract String assetFileName();
    
    @Override
    public Map<String, String[]> mapping() {
        return this.mDict;
    }
}
