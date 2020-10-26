// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.detector;

import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class Detector
{
    private static final int[] EXPECTED_CORNER_BITS;
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;
    
    static {
        EXPECTED_CORNER_BITS = new int[] { 3808, 476, 2107, 1799 };
    }
    
    public Detector(final BitMatrix image) {
        this.image = image;
    }
    
    private static float distance(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }
    
    private static float distance(final Point point, final Point point2) {
        return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }
    
    private static ResultPoint[] expandSquare(final ResultPoint[] array, float n, float n2) {
        n = n2 / (2.0f * n);
        n2 = array[0].getX() - array[2].getX();
        final float n3 = array[0].getY() - array[2].getY();
        final float n4 = (array[0].getX() + array[2].getX()) / 2.0f;
        final float n5 = (array[0].getY() + array[2].getY()) / 2.0f;
        final ResultPoint resultPoint = new ResultPoint(n * n2 + n4, n * n3 + n5);
        final ResultPoint resultPoint2 = new ResultPoint(n4 - n * n2, n5 - n * n3);
        n2 = array[1].getX() - array[3].getX();
        final float n6 = array[1].getY() - array[3].getY();
        final float n7 = (array[1].getX() + array[3].getX()) / 2.0f;
        final float n8 = (array[1].getY() + array[3].getY()) / 2.0f;
        return new ResultPoint[] { resultPoint, new ResultPoint(n * n2 + n7, n * n6 + n8), resultPoint2, new ResultPoint(n7 - n * n2, n8 - n * n6) };
    }
    
    private void extractParameters(final ResultPoint[] array) throws NotFoundException {
        if (!this.isValid(array[0]) || !this.isValid(array[1]) || !this.isValid(array[2]) || !this.isValid(array[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int n = this.nbCenterLayers * 2;
        final int[] array2 = { this.sampleLine(array[0], array[1], n), this.sampleLine(array[1], array[2], n), this.sampleLine(array[2], array[3], n), this.sampleLine(array[3], array[0], n) };
        this.shift = getRotation(array2, n);
        long n2 = 0L;
        for (int i = 0; i < 4; ++i) {
            final int n3 = array2[(this.shift + i) % 4];
            if (this.compact) {
                n2 = (n2 << 7) + (n3 >> 1 & 0x7F);
            }
            else {
                n2 = (n2 << 10) + ((n3 >> 2 & 0x3E0) + (n3 >> 1 & 0x1F));
            }
        }
        final int correctedParameterData = getCorrectedParameterData(n2, this.compact);
        if (this.compact) {
            this.nbLayers = (correctedParameterData >> 6) + 1;
            this.nbDataBlocks = (correctedParameterData & 0x3F) + 1;
            return;
        }
        this.nbLayers = (correctedParameterData >> 11) + 1;
        this.nbDataBlocks = (correctedParameterData & 0x7FF) + 1;
    }
    
    private ResultPoint[] getBullsEyeCorners(Point point) throws NotFoundException {
        Point point2 = point;
        Point point3 = point;
        Point point4 = point;
        boolean b = true;
        this.nbCenterLayers = 1;
        while (this.nbCenterLayers < 9) {
            final Point firstDifferent = this.getFirstDifferent(point2, b, 1, -1);
            final Point firstDifferent2 = this.getFirstDifferent(point3, b, 1, 1);
            final Point firstDifferent3 = this.getFirstDifferent(point4, b, -1, 1);
            final Point firstDifferent4 = this.getFirstDifferent(point, b, -1, -1);
            if (this.nbCenterLayers > 2) {
                final float n = distance(firstDifferent4, firstDifferent) * this.nbCenterLayers / (distance(point, point2) * (this.nbCenterLayers + 2));
                if (n < 0.75 || n > 1.25 || !this.isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            point2 = firstDifferent;
            point3 = firstDifferent2;
            point4 = firstDifferent3;
            point = firstDifferent4;
            b = !b;
            ++this.nbCenterLayers;
        }
        if (this.nbCenterLayers != 5 && this.nbCenterLayers != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.compact = (this.nbCenterLayers == 5);
        return expandSquare(new ResultPoint[] { new ResultPoint(point2.getX() + 0.5f, point2.getY() - 0.5f), new ResultPoint(point3.getX() + 0.5f, point3.getY() + 0.5f), new ResultPoint(point4.getX() - 0.5f, point4.getY() + 0.5f), new ResultPoint(point.getX() - 0.5f, point.getY() - 0.5f) }, (float)(this.nbCenterLayers * 2 - 3), (float)(this.nbCenterLayers * 2));
    }
    
    private int getColor(final Point point, final Point point2) {
        final float distance = distance(point, point2);
        final float n = (point2.getX() - point.getX()) / distance;
        final float n2 = (point2.getY() - point.getY()) / distance;
        int n3 = 0;
        float n4 = (float)point.getX();
        float n5 = (float)point.getY();
        final boolean value = this.image.get(point.getX(), point.getY());
        int n7;
        for (int n6 = (int)Math.ceil(distance), i = 0; i < n6; ++i, n3 = n7) {
            n4 += n;
            n5 += n2;
            n7 = n3;
            if (this.image.get(MathUtils.round(n4), MathUtils.round(n5)) != value) {
                n7 = n3 + 1;
            }
        }
        final float n8 = n3 / distance;
        if (n8 > 0.1f && n8 < 0.9f) {
            return 0;
        }
        int n9;
        if (n8 <= 0.1f) {
            n9 = 1;
        }
        else {
            n9 = 0;
        }
        if (n9 == (value ? 1 : 0)) {
            return 1;
        }
        return -1;
    }
    
    private static int getCorrectedParameterData(long n, final boolean b) throws NotFoundException {
        int n2;
        int n3;
        if (b) {
            n2 = 7;
            n3 = 2;
        }
        else {
            n2 = 10;
            n3 = 4;
        }
        final int[] array = new int[n2];
        for (int i = n2 - 1; i >= 0; --i) {
            array[i] = ((int)n & 0xF);
            n >>= 4;
        }
        int n4;
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(array, n2 - n3);
            n4 = 0;
            for (int j = 0; j < n3; ++j) {
                n4 = (n4 << 4) + array[j];
            }
        }
        catch (ReedSolomonException ex) {
            throw NotFoundException.getNotFoundInstance();
        }
        return n4;
    }
    
    private int getDimension() {
        if (this.compact) {
            return this.nbLayers * 4 + 11;
        }
        if (this.nbLayers <= 4) {
            return this.nbLayers * 4 + 15;
        }
        return this.nbLayers * 4 + ((this.nbLayers - 4) / 8 + 1) * 2 + 15;
    }
    
    private Point getFirstDifferent(final Point point, final boolean b, int n, final int n2) {
        int n3;
        int n4;
        for (n3 = point.getX() + n, n4 = point.getY() + n2; this.isValid(n3, n4) && this.image.get(n3, n4) == b; n3 += n, n4 += n2) {}
        final int n5 = n3 - n;
        int n6;
        int n7;
        for (n6 = n4 - n2, n7 = n5; this.isValid(n7, n6) && this.image.get(n7, n6) == b; n7 += n) {}
        int n8;
        for (n8 = n7 - n, n = n6; this.isValid(n8, n) && this.image.get(n8, n) == b; n += n2) {}
        return new Point(n8, n - n2);
    }
    
    private Point getMatrixCenter() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0        
        //     5: getfield        com/google/zxing/aztec/detector/Detector.image:Lcom/google/zxing/common/BitMatrix;
        //     8: invokespecial   com/google/zxing/common/detector/WhiteRectangleDetector.<init>:(Lcom/google/zxing/common/BitMatrix;)V
        //    11: invokevirtual   com/google/zxing/common/detector/WhiteRectangleDetector.detect:()[Lcom/google/zxing/ResultPoint;
        //    14: astore          6
        //    16: aload           6
        //    18: iconst_0       
        //    19: aaload         
        //    20: astore_3       
        //    21: aload           6
        //    23: iconst_1       
        //    24: aaload         
        //    25: astore          4
        //    27: aload           6
        //    29: iconst_2       
        //    30: aaload         
        //    31: astore          5
        //    33: aload           6
        //    35: iconst_3       
        //    36: aaload         
        //    37: astore          6
        //    39: aload_3        
        //    40: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //    43: aload           6
        //    45: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //    48: fadd           
        //    49: aload           4
        //    51: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //    54: fadd           
        //    55: aload           5
        //    57: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //    60: fadd           
        //    61: ldc             4.0
        //    63: fdiv           
        //    64: invokestatic    com/google/zxing/common/detector/MathUtils.round:(F)I
        //    67: istore_1       
        //    68: aload_3        
        //    69: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //    72: aload           6
        //    74: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //    77: fadd           
        //    78: aload           4
        //    80: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //    83: fadd           
        //    84: aload           5
        //    86: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //    89: fadd           
        //    90: ldc             4.0
        //    92: fdiv           
        //    93: invokestatic    com/google/zxing/common/detector/MathUtils.round:(F)I
        //    96: istore_2       
        //    97: new             Lcom/google/zxing/common/detector/WhiteRectangleDetector;
        //   100: dup            
        //   101: aload_0        
        //   102: getfield        com/google/zxing/aztec/detector/Detector.image:Lcom/google/zxing/common/BitMatrix;
        //   105: bipush          15
        //   107: iload_1        
        //   108: iload_2        
        //   109: invokespecial   com/google/zxing/common/detector/WhiteRectangleDetector.<init>:(Lcom/google/zxing/common/BitMatrix;III)V
        //   112: invokevirtual   com/google/zxing/common/detector/WhiteRectangleDetector.detect:()[Lcom/google/zxing/ResultPoint;
        //   115: astore          6
        //   117: aload           6
        //   119: iconst_0       
        //   120: aaload         
        //   121: astore_3       
        //   122: aload           6
        //   124: iconst_1       
        //   125: aaload         
        //   126: astore          4
        //   128: aload           6
        //   130: iconst_2       
        //   131: aaload         
        //   132: astore          5
        //   134: aload           6
        //   136: iconst_3       
        //   137: aaload         
        //   138: astore          6
        //   140: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   143: dup            
        //   144: aload_3        
        //   145: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //   148: aload           6
        //   150: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //   153: fadd           
        //   154: aload           4
        //   156: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //   159: fadd           
        //   160: aload           5
        //   162: invokevirtual   com/google/zxing/ResultPoint.getX:()F
        //   165: fadd           
        //   166: ldc             4.0
        //   168: fdiv           
        //   169: invokestatic    com/google/zxing/common/detector/MathUtils.round:(F)I
        //   172: aload_3        
        //   173: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //   176: aload           6
        //   178: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //   181: fadd           
        //   182: aload           4
        //   184: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //   187: fadd           
        //   188: aload           5
        //   190: invokevirtual   com/google/zxing/ResultPoint.getY:()F
        //   193: fadd           
        //   194: ldc             4.0
        //   196: fdiv           
        //   197: invokestatic    com/google/zxing/common/detector/MathUtils.round:(F)I
        //   200: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   203: areturn        
        //   204: astore_3       
        //   205: aload_0        
        //   206: getfield        com/google/zxing/aztec/detector/Detector.image:Lcom/google/zxing/common/BitMatrix;
        //   209: invokevirtual   com/google/zxing/common/BitMatrix.getWidth:()I
        //   212: iconst_2       
        //   213: idiv           
        //   214: istore_1       
        //   215: aload_0        
        //   216: getfield        com/google/zxing/aztec/detector/Detector.image:Lcom/google/zxing/common/BitMatrix;
        //   219: invokevirtual   com/google/zxing/common/BitMatrix.getHeight:()I
        //   222: iconst_2       
        //   223: idiv           
        //   224: istore_2       
        //   225: aload_0        
        //   226: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   229: dup            
        //   230: iload_1        
        //   231: bipush          7
        //   233: iadd           
        //   234: iload_2        
        //   235: bipush          7
        //   237: isub           
        //   238: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   241: iconst_0       
        //   242: iconst_1       
        //   243: iconst_m1      
        //   244: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   247: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   250: astore_3       
        //   251: aload_0        
        //   252: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   255: dup            
        //   256: iload_1        
        //   257: bipush          7
        //   259: iadd           
        //   260: iload_2        
        //   261: bipush          7
        //   263: iadd           
        //   264: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   267: iconst_0       
        //   268: iconst_1       
        //   269: iconst_1       
        //   270: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   273: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   276: astore          4
        //   278: aload_0        
        //   279: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   282: dup            
        //   283: iload_1        
        //   284: bipush          7
        //   286: isub           
        //   287: iload_2        
        //   288: bipush          7
        //   290: iadd           
        //   291: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   294: iconst_0       
        //   295: iconst_m1      
        //   296: iconst_1       
        //   297: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   300: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   303: astore          5
        //   305: aload_0        
        //   306: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   309: dup            
        //   310: iload_1        
        //   311: bipush          7
        //   313: isub           
        //   314: iload_2        
        //   315: bipush          7
        //   317: isub           
        //   318: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   321: iconst_0       
        //   322: iconst_m1      
        //   323: iconst_m1      
        //   324: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   327: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   330: astore          6
        //   332: goto            39
        //   335: astore_3       
        //   336: aload_0        
        //   337: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   340: dup            
        //   341: iload_1        
        //   342: bipush          7
        //   344: iadd           
        //   345: iload_2        
        //   346: bipush          7
        //   348: isub           
        //   349: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   352: iconst_0       
        //   353: iconst_1       
        //   354: iconst_m1      
        //   355: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   358: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   361: astore_3       
        //   362: aload_0        
        //   363: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   366: dup            
        //   367: iload_1        
        //   368: bipush          7
        //   370: iadd           
        //   371: iload_2        
        //   372: bipush          7
        //   374: iadd           
        //   375: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   378: iconst_0       
        //   379: iconst_1       
        //   380: iconst_1       
        //   381: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   384: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   387: astore          4
        //   389: aload_0        
        //   390: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   393: dup            
        //   394: iload_1        
        //   395: bipush          7
        //   397: isub           
        //   398: iload_2        
        //   399: bipush          7
        //   401: iadd           
        //   402: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   405: iconst_0       
        //   406: iconst_m1      
        //   407: iconst_1       
        //   408: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   411: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   414: astore          5
        //   416: aload_0        
        //   417: new             Lcom/google/zxing/aztec/detector/Detector$Point;
        //   420: dup            
        //   421: iload_1        
        //   422: bipush          7
        //   424: isub           
        //   425: iload_2        
        //   426: bipush          7
        //   428: isub           
        //   429: invokespecial   com/google/zxing/aztec/detector/Detector$Point.<init>:(II)V
        //   432: iconst_0       
        //   433: iconst_m1      
        //   434: iconst_m1      
        //   435: invokespecial   com/google/zxing/aztec/detector/Detector.getFirstDifferent:(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
        //   438: invokevirtual   com/google/zxing/aztec/detector/Detector$Point.toResultPoint:()Lcom/google/zxing/ResultPoint;
        //   441: astore          6
        //   443: goto            140
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  0      16     204    335    Lcom/google/zxing/NotFoundException;
        //  97     117    335    446    Lcom/google/zxing/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0140:
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
    
    private ResultPoint[] getMatrixCornerPoints(final ResultPoint[] array) {
        return expandSquare(array, (float)(this.nbCenterLayers * 2), (float)this.getDimension());
    }
    
    private static int getRotation(final int[] array, int i) throws NotFoundException {
        int n = 0;
        for (int length = array.length, j = 0; j < length; ++j) {
            final int n2 = array[j];
            n = (n << 3) + ((n2 >> i - 2 << 1) + (n2 & 0x1));
        }
        for (i = 0; i < 4; ++i) {
            if (Integer.bitCount(Detector.EXPECTED_CORNER_BITS[i] ^ ((n & 0x1) << 11) + (n >> 1)) <= 2) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private boolean isValid(final int n, final int n2) {
        return n >= 0 && n < this.image.getWidth() && n2 > 0 && n2 < this.image.getHeight();
    }
    
    private boolean isValid(final ResultPoint resultPoint) {
        return this.isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }
    
    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        point = new Point(point.getX() - 3, point.getY() + 3);
        point2 = new Point(point2.getX() - 3, point2.getY() - 3);
        point3 = new Point(point3.getX() + 3, point3.getY() - 3);
        point4 = new Point(point4.getX() + 3, point4.getY() + 3);
        final int color = this.getColor(point4, point);
        return color != 0 && this.getColor(point, point2) == color && this.getColor(point2, point3) == color && this.getColor(point3, point4) == color;
    }
    
    private BitMatrix sampleGrid(final BitMatrix bitMatrix, final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4) throws NotFoundException {
        final GridSampler instance = GridSampler.getInstance();
        final int dimension = this.getDimension();
        final float n = dimension / 2.0f - this.nbCenterLayers;
        final float n2 = dimension / 2.0f + this.nbCenterLayers;
        return instance.sampleGrid(bitMatrix, dimension, dimension, n, n, n2, n, n2, n2, n, n2, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }
    
    private int sampleLine(final ResultPoint resultPoint, final ResultPoint resultPoint2, final int n) {
        int n2 = 0;
        final float distance = distance(resultPoint, resultPoint2);
        final float n3 = distance / n;
        final float x = resultPoint.getX();
        final float y = resultPoint.getY();
        final float n4 = (resultPoint2.getX() - resultPoint.getX()) * n3 / distance;
        final float n5 = (resultPoint2.getY() - resultPoint.getY()) * n3 / distance;
        int n6;
        for (int i = 0; i < n; ++i, n2 = n6) {
            n6 = n2;
            if (this.image.get(MathUtils.round(i * n4 + x), MathUtils.round(i * n5 + y))) {
                n6 = (n2 | 1 << n - i - 1);
            }
        }
        return n2;
    }
    
    public AztecDetectorResult detect() throws NotFoundException {
        return this.detect(false);
    }
    
    public AztecDetectorResult detect(final boolean b) throws NotFoundException {
        final ResultPoint[] bullsEyeCorners = this.getBullsEyeCorners(this.getMatrixCenter());
        if (b) {
            final ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        this.extractParameters(bullsEyeCorners);
        return new AztecDetectorResult(this.sampleGrid(this.image, bullsEyeCorners[this.shift % 4], bullsEyeCorners[(this.shift + 1) % 4], bullsEyeCorners[(this.shift + 2) % 4], bullsEyeCorners[(this.shift + 3) % 4]), this.getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }
    
    static final class Point
    {
        private final int x;
        private final int y;
        
        Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        int getX() {
            return this.x;
        }
        
        int getY() {
            return this.y;
        }
        
        ResultPoint toResultPoint() {
            return new ResultPoint((float)this.getX(), (float)this.getY());
        }
        
        @Override
        public String toString() {
            return "<" + this.x + ' ' + this.y + '>';
        }
    }
}
