// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Reader;

public final class AztecReader implements Reader
{
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public Result decode(final BinaryBitmap p0, final Map<DecodeHintType, ?> p1) throws NotFoundException, FormatException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          7
        //     3: aconst_null    
        //     4: astore          8
        //     6: new             Lcom/google/zxing/aztec/detector/Detector;
        //     9: dup            
        //    10: aload_1        
        //    11: invokevirtual   com/google/zxing/BinaryBitmap.getBlackMatrix:()Lcom/google/zxing/common/BitMatrix;
        //    14: invokespecial   com/google/zxing/aztec/detector/Detector.<init>:(Lcom/google/zxing/common/BitMatrix;)V
        //    17: astore          11
        //    19: aconst_null    
        //    20: astore          10
        //    22: aconst_null    
        //    23: astore_1       
        //    24: aconst_null    
        //    25: astore          9
        //    27: aload_1        
        //    28: astore          5
        //    30: aload           10
        //    32: astore          6
        //    34: aload           11
        //    36: iconst_0       
        //    37: invokevirtual   com/google/zxing/aztec/detector/Detector.detect:(Z)Lcom/google/zxing/aztec/AztecDetectorResult;
        //    40: astore          12
        //    42: aload_1        
        //    43: astore          5
        //    45: aload           10
        //    47: astore          6
        //    49: aload           12
        //    51: invokevirtual   com/google/zxing/aztec/AztecDetectorResult.getPoints:()[Lcom/google/zxing/ResultPoint;
        //    54: astore_1       
        //    55: aload_1        
        //    56: astore          5
        //    58: aload_1        
        //    59: astore          6
        //    61: new             Lcom/google/zxing/aztec/decoder/Decoder;
        //    64: dup            
        //    65: invokespecial   com/google/zxing/aztec/decoder/Decoder.<init>:()V
        //    68: aload           12
        //    70: invokevirtual   com/google/zxing/aztec/decoder/Decoder.decode:(Lcom/google/zxing/aztec/AztecDetectorResult;)Lcom/google/zxing/common/DecoderResult;
        //    73: astore          10
        //    75: aload           10
        //    77: astore          5
        //    79: aload           8
        //    81: astore          6
        //    83: aload_1        
        //    84: astore          8
        //    86: aload           5
        //    88: astore_1       
        //    89: aload           5
        //    91: ifnonnull       119
        //    94: aload           11
        //    96: iconst_1       
        //    97: invokevirtual   com/google/zxing/aztec/detector/Detector.detect:(Z)Lcom/google/zxing/aztec/AztecDetectorResult;
        //   100: astore_1       
        //   101: aload_1        
        //   102: invokevirtual   com/google/zxing/aztec/AztecDetectorResult.getPoints:()[Lcom/google/zxing/ResultPoint;
        //   105: astore          8
        //   107: new             Lcom/google/zxing/aztec/decoder/Decoder;
        //   110: dup            
        //   111: invokespecial   com/google/zxing/aztec/decoder/Decoder.<init>:()V
        //   114: aload_1        
        //   115: invokevirtual   com/google/zxing/aztec/decoder/Decoder.decode:(Lcom/google/zxing/aztec/AztecDetectorResult;)Lcom/google/zxing/common/DecoderResult;
        //   118: astore_1       
        //   119: aload_2        
        //   120: ifnull          221
        //   123: aload_2        
        //   124: getstatic       com/google/zxing/DecodeHintType.NEED_RESULT_POINT_CALLBACK:Lcom/google/zxing/DecodeHintType;
        //   127: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   132: checkcast       Lcom/google/zxing/ResultPointCallback;
        //   135: astore_2       
        //   136: aload_2        
        //   137: ifnull          221
        //   140: aload           8
        //   142: arraylength    
        //   143: istore          4
        //   145: iconst_0       
        //   146: istore_3       
        //   147: iload_3        
        //   148: iload           4
        //   150: if_icmpge       221
        //   153: aload_2        
        //   154: aload           8
        //   156: iload_3        
        //   157: aaload         
        //   158: invokeinterface com/google/zxing/ResultPointCallback.foundPossibleResultPoint:(Lcom/google/zxing/ResultPoint;)V
        //   163: iload_3        
        //   164: iconst_1       
        //   165: iadd           
        //   166: istore_3       
        //   167: goto            147
        //   170: astore          7
        //   172: aload           5
        //   174: astore_1       
        //   175: aload           9
        //   177: astore          5
        //   179: aload           8
        //   181: astore          6
        //   183: goto            83
        //   186: astore          8
        //   188: aload           6
        //   190: astore_1       
        //   191: aload           9
        //   193: astore          5
        //   195: aload           8
        //   197: astore          6
        //   199: goto            83
        //   202: astore_1       
        //   203: aload           7
        //   205: ifnull          211
        //   208: aload           7
        //   210: athrow         
        //   211: aload           6
        //   213: ifnull          219
        //   216: aload           6
        //   218: athrow         
        //   219: aload_1        
        //   220: athrow         
        //   221: new             Lcom/google/zxing/Result;
        //   224: dup            
        //   225: aload_1        
        //   226: invokevirtual   com/google/zxing/common/DecoderResult.getText:()Ljava/lang/String;
        //   229: aload_1        
        //   230: invokevirtual   com/google/zxing/common/DecoderResult.getRawBytes:()[B
        //   233: aload_1        
        //   234: invokevirtual   com/google/zxing/common/DecoderResult.getNumBits:()I
        //   237: aload           8
        //   239: getstatic       com/google/zxing/BarcodeFormat.AZTEC:Lcom/google/zxing/BarcodeFormat;
        //   242: invokestatic    java/lang/System.currentTimeMillis:()J
        //   245: invokespecial   com/google/zxing/Result.<init>:(Ljava/lang/String;[BI[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;J)V
        //   248: astore_2       
        //   249: aload_1        
        //   250: invokevirtual   com/google/zxing/common/DecoderResult.getByteSegments:()Ljava/util/List;
        //   253: astore          5
        //   255: aload           5
        //   257: ifnull          269
        //   260: aload_2        
        //   261: getstatic       com/google/zxing/ResultMetadataType.BYTE_SEGMENTS:Lcom/google/zxing/ResultMetadataType;
        //   264: aload           5
        //   266: invokevirtual   com/google/zxing/Result.putMetadata:(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
        //   269: aload_1        
        //   270: invokevirtual   com/google/zxing/common/DecoderResult.getECLevel:()Ljava/lang/String;
        //   273: astore_1       
        //   274: aload_1        
        //   275: ifnull          286
        //   278: aload_2        
        //   279: getstatic       com/google/zxing/ResultMetadataType.ERROR_CORRECTION_LEVEL:Lcom/google/zxing/ResultMetadataType;
        //   282: aload_1        
        //   283: invokevirtual   com/google/zxing/Result.putMetadata:(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
        //   286: aload_2        
        //   287: areturn        
        //   288: astore_1       
        //   289: goto            203
        //    Exceptions:
        //  throws com.google.zxing.NotFoundException
        //  throws com.google.zxing.FormatException
        //    Signature:
        //  (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map<Lcom/google/zxing/DecodeHintType;*>;)Lcom/google/zxing/Result;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  34     42     170    186    Lcom/google/zxing/NotFoundException;
        //  34     42     186    202    Lcom/google/zxing/FormatException;
        //  49     55     170    186    Lcom/google/zxing/NotFoundException;
        //  49     55     186    202    Lcom/google/zxing/FormatException;
        //  61     75     170    186    Lcom/google/zxing/NotFoundException;
        //  61     75     186    202    Lcom/google/zxing/FormatException;
        //  94     119    202    203    Lcom/google/zxing/NotFoundException;
        //  94     119    288    292    Lcom/google/zxing/FormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    public void reset() {
    }
}
