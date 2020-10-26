// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.multi.qrcode;

import java.io.Serializable;
import com.google.zxing.NotFoundException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.BinaryBitmap;
import java.util.Iterator;
import com.google.zxing.BarcodeFormat;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import com.google.zxing.ResultMetadataType;
import java.util.List;
import com.google.zxing.ResultPoint;
import com.google.zxing.Result;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.qrcode.QRCodeReader;

public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader
{
    private static final Result[] EMPTY_RESULT_ARRAY;
    private static final ResultPoint[] NO_POINTS;
    
    static {
        EMPTY_RESULT_ARRAY = new Result[0];
        NO_POINTS = new ResultPoint[0];
    }
    
    private static List<Result> processStructuredAppend(final List<Result> list) {
        final int n = 0;
        final Iterator<Result> iterator = list.iterator();
        while (true) {
            do {
                final int n2 = n;
                if (iterator.hasNext()) {
                    continue;
                }
                if (n2 == 0) {
                    return list;
                }
                final ArrayList<Result> list2 = new ArrayList<Result>();
                final ArrayList<Object> list3 = new ArrayList<Object>();
                for (final Result result : list) {
                    list2.add(result);
                    if (result.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                        list3.add(result);
                    }
                }
                Collections.sort(list3, (Comparator<? super Object>)new SAComparator());
                final StringBuilder sb = new StringBuilder();
                int n3 = 0;
                int n4 = 0;
                for (final Result result2 : list3) {
                    sb.append(result2.getText());
                    final int n5 = n3 += result2.getRawBytes().length;
                    if (result2.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                        final Iterator iterator4 = result2.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS).iterator();
                        int n6 = n4;
                        while (true) {
                            n4 = n6;
                            n3 = n5;
                            if (!iterator4.hasNext()) {
                                break;
                            }
                            n6 += ((byte[])iterator4.next()).length;
                        }
                    }
                }
                final byte[] array = new byte[n3];
                final byte[] array2 = new byte[n4];
                int n7 = 0;
                int n8 = 0;
                for (final Result result3 : list3) {
                    System.arraycopy(result3.getRawBytes(), 0, array, n7, result3.getRawBytes().length);
                    final int n9 = n7 += result3.getRawBytes().length;
                    if (result3.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                        final Iterator<byte[]> iterator6 = result3.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS).iterator();
                        int n10 = n8;
                        while (true) {
                            n8 = n10;
                            n7 = n9;
                            if (!iterator6.hasNext()) {
                                break;
                            }
                            final byte[] array3 = iterator6.next();
                            System.arraycopy(array3, 0, array2, n10, array3.length);
                            n10 += array3.length;
                        }
                    }
                }
                final Result result4 = new Result(sb.toString(), array, QRCodeMultiReader.NO_POINTS, BarcodeFormat.QR_CODE);
                if (n4 > 0) {
                    final ArrayList<byte[]> list4 = new ArrayList<byte[]>();
                    list4.add(array2);
                    result4.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list4);
                }
                list2.add(result4);
                return list2;
            } while (!iterator.next().getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE));
            final int n2 = 1;
            continue;
        }
    }
    
    @Override
    public Result[] decodeMultiple(final BinaryBitmap binaryBitmap) throws NotFoundException {
        return this.decodeMultiple(binaryBitmap, null);
    }
    
    @Override
    public Result[] decodeMultiple(final BinaryBitmap p0, final Map<DecodeHintType, ?> p1) throws NotFoundException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore          5
        //     9: new             Lcom/google/zxing/multi/qrcode/detector/MultiDetector;
        //    12: dup            
        //    13: aload_1        
        //    14: invokevirtual   com/google/zxing/BinaryBitmap.getBlackMatrix:()Lcom/google/zxing/common/BitMatrix;
        //    17: invokespecial   com/google/zxing/multi/qrcode/detector/MultiDetector.<init>:(Lcom/google/zxing/common/BitMatrix;)V
        //    20: aload_2        
        //    21: invokevirtual   com/google/zxing/multi/qrcode/detector/MultiDetector.detectMulti:(Ljava/util/Map;)[Lcom/google/zxing/common/DetectorResult;
        //    24: astore_1       
        //    25: aload_1        
        //    26: arraylength    
        //    27: istore          4
        //    29: iconst_0       
        //    30: istore_3       
        //    31: iload_3        
        //    32: iload           4
        //    34: if_icmpge       213
        //    37: aload_1        
        //    38: iload_3        
        //    39: aaload         
        //    40: astore          7
        //    42: aload_0        
        //    43: invokevirtual   com/google/zxing/multi/qrcode/QRCodeMultiReader.getDecoder:()Lcom/google/zxing/qrcode/decoder/Decoder;
        //    46: aload           7
        //    48: invokevirtual   com/google/zxing/common/DetectorResult.getBits:()Lcom/google/zxing/common/BitMatrix;
        //    51: aload_2        
        //    52: invokevirtual   com/google/zxing/qrcode/decoder/Decoder.decode:(Lcom/google/zxing/common/BitMatrix;Ljava/util/Map;)Lcom/google/zxing/common/DecoderResult;
        //    55: astore          6
        //    57: aload           7
        //    59: invokevirtual   com/google/zxing/common/DetectorResult.getPoints:()[Lcom/google/zxing/ResultPoint;
        //    62: astore          7
        //    64: aload           6
        //    66: invokevirtual   com/google/zxing/common/DecoderResult.getOther:()Ljava/lang/Object;
        //    69: instanceof      Lcom/google/zxing/qrcode/decoder/QRCodeDecoderMetaData;
        //    72: ifeq            88
        //    75: aload           6
        //    77: invokevirtual   com/google/zxing/common/DecoderResult.getOther:()Ljava/lang/Object;
        //    80: checkcast       Lcom/google/zxing/qrcode/decoder/QRCodeDecoderMetaData;
        //    83: aload           7
        //    85: invokevirtual   com/google/zxing/qrcode/decoder/QRCodeDecoderMetaData.applyMirroredCorrection:([Lcom/google/zxing/ResultPoint;)V
        //    88: new             Lcom/google/zxing/Result;
        //    91: dup            
        //    92: aload           6
        //    94: invokevirtual   com/google/zxing/common/DecoderResult.getText:()Ljava/lang/String;
        //    97: aload           6
        //    99: invokevirtual   com/google/zxing/common/DecoderResult.getRawBytes:()[B
        //   102: aload           7
        //   104: getstatic       com/google/zxing/BarcodeFormat.QR_CODE:Lcom/google/zxing/BarcodeFormat;
        //   107: invokespecial   com/google/zxing/Result.<init>:(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V
        //   110: astore          7
        //   112: aload           6
        //   114: invokevirtual   com/google/zxing/common/DecoderResult.getByteSegments:()Ljava/util/List;
        //   117: astore          8
        //   119: aload           8
        //   121: ifnull          134
        //   124: aload           7
        //   126: getstatic       com/google/zxing/ResultMetadataType.BYTE_SEGMENTS:Lcom/google/zxing/ResultMetadataType;
        //   129: aload           8
        //   131: invokevirtual   com/google/zxing/Result.putMetadata:(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
        //   134: aload           6
        //   136: invokevirtual   com/google/zxing/common/DecoderResult.getECLevel:()Ljava/lang/String;
        //   139: astore          8
        //   141: aload           8
        //   143: ifnull          156
        //   146: aload           7
        //   148: getstatic       com/google/zxing/ResultMetadataType.ERROR_CORRECTION_LEVEL:Lcom/google/zxing/ResultMetadataType;
        //   151: aload           8
        //   153: invokevirtual   com/google/zxing/Result.putMetadata:(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
        //   156: aload           6
        //   158: invokevirtual   com/google/zxing/common/DecoderResult.hasStructuredAppend:()Z
        //   161: ifeq            196
        //   164: aload           7
        //   166: getstatic       com/google/zxing/ResultMetadataType.STRUCTURED_APPEND_SEQUENCE:Lcom/google/zxing/ResultMetadataType;
        //   169: aload           6
        //   171: invokevirtual   com/google/zxing/common/DecoderResult.getStructuredAppendSequenceNumber:()I
        //   174: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   177: invokevirtual   com/google/zxing/Result.putMetadata:(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
        //   180: aload           7
        //   182: getstatic       com/google/zxing/ResultMetadataType.STRUCTURED_APPEND_PARITY:Lcom/google/zxing/ResultMetadataType;
        //   185: aload           6
        //   187: invokevirtual   com/google/zxing/common/DecoderResult.getStructuredAppendParity:()I
        //   190: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   193: invokevirtual   com/google/zxing/Result.putMetadata:(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
        //   196: aload           5
        //   198: aload           7
        //   200: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   205: pop            
        //   206: iload_3        
        //   207: iconst_1       
        //   208: iadd           
        //   209: istore_3       
        //   210: goto            31
        //   213: aload           5
        //   215: invokeinterface java/util/List.isEmpty:()Z
        //   220: ifeq            227
        //   223: getstatic       com/google/zxing/multi/qrcode/QRCodeMultiReader.EMPTY_RESULT_ARRAY:[Lcom/google/zxing/Result;
        //   226: areturn        
        //   227: aload           5
        //   229: invokestatic    com/google/zxing/multi/qrcode/QRCodeMultiReader.processStructuredAppend:(Ljava/util/List;)Ljava/util/List;
        //   232: astore_1       
        //   233: aload_1        
        //   234: aload_1        
        //   235: invokeinterface java/util/List.size:()I
        //   240: anewarray       Lcom/google/zxing/Result;
        //   243: invokeinterface java/util/List.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   248: checkcast       [Lcom/google/zxing/Result;
        //   251: areturn        
        //   252: astore          6
        //   254: goto            206
        //    Exceptions:
        //  throws com.google.zxing.NotFoundException
        //    Signature:
        //  (Lcom/google/zxing/BinaryBitmap;Ljava/util/Map<Lcom/google/zxing/DecodeHintType;*>;)[Lcom/google/zxing/Result;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  42     88     252    257    Lcom/google/zxing/ReaderException;
        //  88     119    252    257    Lcom/google/zxing/ReaderException;
        //  124    134    252    257    Lcom/google/zxing/ReaderException;
        //  134    141    252    257    Lcom/google/zxing/ReaderException;
        //  146    156    252    257    Lcom/google/zxing/ReaderException;
        //  156    196    252    257    Lcom/google/zxing/ReaderException;
        //  196    206    252    257    Lcom/google/zxing/ReaderException;
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
    
    private static final class SAComparator implements Serializable, Comparator<Result>
    {
        @Override
        public int compare(final Result result, final Result result2) {
            return Integer.compare(result.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE), result2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE));
        }
    }
}
