// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.detector.Detector;

public final class MultiDetector extends Detector
{
    private static final DetectorResult[] EMPTY_DETECTOR_RESULTS;
    
    static {
        EMPTY_DETECTOR_RESULTS = new DetectorResult[0];
    }
    
    public MultiDetector(final BitMatrix bitMatrix) {
        super(bitMatrix);
    }
    
    public DetectorResult[] detectMulti(final Map<DecodeHintType, ?> p0) throws NotFoundException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/zxing/multi/qrcode/detector/MultiDetector.getImage:()Lcom/google/zxing/common/BitMatrix;
        //     4: astore          5
        //     6: aload_1        
        //     7: ifnonnull       38
        //    10: aconst_null    
        //    11: astore          4
        //    13: new             Lcom/google/zxing/multi/qrcode/detector/MultiFinderPatternFinder;
        //    16: dup            
        //    17: aload           5
        //    19: aload           4
        //    21: invokespecial   com/google/zxing/multi/qrcode/detector/MultiFinderPatternFinder.<init>:(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPointCallback;)V
        //    24: aload_1        
        //    25: invokevirtual   com/google/zxing/multi/qrcode/detector/MultiFinderPatternFinder.findMulti:(Ljava/util/Map;)[Lcom/google/zxing/qrcode/detector/FinderPatternInfo;
        //    28: astore_1       
        //    29: aload_1        
        //    30: arraylength    
        //    31: ifne            55
        //    34: invokestatic    com/google/zxing/NotFoundException.getNotFoundInstance:()Lcom/google/zxing/NotFoundException;
        //    37: athrow         
        //    38: aload_1        
        //    39: getstatic       com/google/zxing/DecodeHintType.NEED_RESULT_POINT_CALLBACK:Lcom/google/zxing/DecodeHintType;
        //    42: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    47: checkcast       Lcom/google/zxing/ResultPointCallback;
        //    50: astore          4
        //    52: goto            13
        //    55: new             Ljava/util/ArrayList;
        //    58: dup            
        //    59: invokespecial   java/util/ArrayList.<init>:()V
        //    62: astore          4
        //    64: aload_1        
        //    65: arraylength    
        //    66: istore_3       
        //    67: iconst_0       
        //    68: istore_2       
        //    69: iload_2        
        //    70: iload_3        
        //    71: if_icmpge       100
        //    74: aload_1        
        //    75: iload_2        
        //    76: aaload         
        //    77: astore          5
        //    79: aload           4
        //    81: aload_0        
        //    82: aload           5
        //    84: invokevirtual   com/google/zxing/multi/qrcode/detector/MultiDetector.processFinderPatternInfo:(Lcom/google/zxing/qrcode/detector/FinderPatternInfo;)Lcom/google/zxing/common/DetectorResult;
        //    87: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    92: pop            
        //    93: iload_2        
        //    94: iconst_1       
        //    95: iadd           
        //    96: istore_2       
        //    97: goto            69
        //   100: aload           4
        //   102: invokeinterface java/util/List.isEmpty:()Z
        //   107: ifeq            114
        //   110: getstatic       com/google/zxing/multi/qrcode/detector/MultiDetector.EMPTY_DETECTOR_RESULTS:[Lcom/google/zxing/common/DetectorResult;
        //   113: areturn        
        //   114: aload           4
        //   116: aload           4
        //   118: invokeinterface java/util/List.size:()I
        //   123: anewarray       Lcom/google/zxing/common/DetectorResult;
        //   126: invokeinterface java/util/List.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   131: checkcast       [Lcom/google/zxing/common/DetectorResult;
        //   134: areturn        
        //   135: astore          5
        //   137: goto            93
        //    Exceptions:
        //  throws com.google.zxing.NotFoundException
        //    Signature:
        //  (Ljava/util/Map<Lcom/google/zxing/DecodeHintType;*>;)[Lcom/google/zxing/common/DetectorResult;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  79     93     135    140    Lcom/google/zxing/ReaderException;
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
}
