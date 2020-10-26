// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.detector;

import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.FormatException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;

public class Detector
{
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;
    
    public Detector(final BitMatrix image) {
        this.image = image;
    }
    
    private float calculateModuleSizeOneWay(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        final float sizeOfBlackWhiteBlackRunBothWays = this.sizeOfBlackWhiteBlackRunBothWays((int)resultPoint.getX(), (int)resultPoint.getY(), (int)resultPoint2.getX(), (int)resultPoint2.getY());
        final float sizeOfBlackWhiteBlackRunBothWays2 = this.sizeOfBlackWhiteBlackRunBothWays((int)resultPoint2.getX(), (int)resultPoint2.getY(), (int)resultPoint.getX(), (int)resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2)) {
            return sizeOfBlackWhiteBlackRunBothWays / 7.0f;
        }
        return (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }
    
    private static int computeDimension(final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final float n) throws NotFoundException {
        final int n2 = (MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / n) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / n)) / 2 + 7;
        switch (n2 & 0x3) {
            default: {
                return n2;
            }
            case 0: {
                return n2 + 1;
            }
            case 2: {
                return n2 - 1;
            }
            case 3: {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
    
    private static PerspectiveTransform createTransform(final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4, final int n) {
        final float n2 = n - 3.5f;
        float x;
        float y;
        float n4;
        float n3;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            n3 = (n4 = n2 - 3.0f);
        }
        else {
            x = resultPoint2.getX() - resultPoint.getX() + resultPoint3.getX();
            y = resultPoint2.getY() - resultPoint.getY() + resultPoint3.getY();
            n3 = n2;
            n4 = n2;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, n2, 3.5f, n3, n4, 3.5f, n2, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }
    
    private static BitMatrix sampleGrid(final BitMatrix bitMatrix, final PerspectiveTransform perspectiveTransform, final int n) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, n, n, perspectiveTransform);
    }
    
    private float sizeOfBlackWhiteBlackRun(int n, int n2, int n3, int n4) {
        boolean b;
        if (Math.abs(n4 - n2) > Math.abs(n3 - n)) {
            b = true;
        }
        else {
            b = false;
        }
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        int n8 = n4;
        if (b) {
            n8 = n3;
            n7 = n4;
            n6 = n;
            n5 = n2;
        }
        final int abs = Math.abs(n7 - n5);
        final int abs2 = Math.abs(n8 - n6);
        int n9 = -abs / 2;
        int n10;
        if (n5 < n7) {
            n10 = 1;
        }
        else {
            n10 = -1;
        }
        int n11;
        if (n6 < n8) {
            n11 = 1;
        }
        else {
            n11 = -1;
        }
        n3 = 0;
        n = n5;
        n2 = n6;
        int n12;
        while (true) {
            n12 = n3;
            if (n == n7 + n10) {
                break;
            }
            int n13;
            if (b) {
                n13 = n2;
            }
            else {
                n13 = n;
            }
            int n14;
            if (b) {
                n14 = n;
            }
            else {
                n14 = n2;
            }
            final boolean b2 = n3 == 1;
            n4 = n3;
            if (b2 == this.image.get(n13, n14)) {
                if (n3 == 2) {
                    return MathUtils.distance(n, n2, n5, n6);
                }
                n4 = n3 + 1;
            }
            final int n15 = n3 = n9 + abs2;
            int n16 = n2;
            if (n15 > 0) {
                n12 = n4;
                if (n2 == n8) {
                    break;
                }
                n16 = n2 + n11;
                n3 = n15 - abs;
            }
            n += n10;
            n9 = n3;
            n3 = n4;
            n2 = n16;
        }
        if (n12 == 2) {
            return MathUtils.distance(n7 + n10, n8, n5, n6);
        }
        return Float.NaN;
    }
    
    private float sizeOfBlackWhiteBlackRunBothWays(final int n, final int n2, int n3, int n4) {
        final float sizeOfBlackWhiteBlackRun = this.sizeOfBlackWhiteBlackRun(n, n2, n3, n4);
        float n5 = 1.0f;
        final int n6 = n - (n3 - n);
        if (n6 < 0) {
            n5 = n / (float)(n - n6);
            n3 = 0;
        }
        else if ((n3 = n6) >= this.image.getWidth()) {
            n5 = (this.image.getWidth() - 1 - n) / (float)(n6 - n);
            n3 = this.image.getWidth() - 1;
        }
        final int n7 = (int)(n2 - (n4 - n2) * n5);
        float n8 = 1.0f;
        if (n7 < 0) {
            n8 = n2 / (float)(n2 - n7);
            n4 = 0;
        }
        else if ((n4 = n7) >= this.image.getHeight()) {
            n8 = (this.image.getHeight() - 1 - n2) / (float)(n7 - n2);
            n4 = this.image.getHeight() - 1;
        }
        return this.sizeOfBlackWhiteBlackRun(n, n2, (int)(n + (n3 - n) * n8), n4) + sizeOfBlackWhiteBlackRun - 1.0f;
    }
    
    protected final float calculateModuleSize(final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3) {
        return (this.calculateModuleSizeOneWay(resultPoint, resultPoint2) + this.calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }
    
    public DetectorResult detect() throws NotFoundException, FormatException {
        return this.detect(null);
    }
    
    public final DetectorResult detect(final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback;
        if (map == null) {
            resultPointCallback = null;
        }
        else {
            resultPointCallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback;
        return this.processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }
    
    protected final AlignmentPattern findAlignmentInRegion(final float n, int min, int min2, final float n2) throws NotFoundException {
        final int n3 = (int)(n2 * n);
        final int max = Math.max(0, min - n3);
        min = Math.min(this.image.getWidth() - 1, min + n3);
        if (min - max < n * 3.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int max2 = Math.max(0, min2 - n3);
        min2 = Math.min(this.image.getHeight() - 1, min2 + n3);
        if (min2 - max2 < n * 3.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new AlignmentPatternFinder(this.image, max, max2, min - max, min2 - max2, n, this.resultPointCallback).find();
    }
    
    protected final BitMatrix getImage() {
        return this.image;
    }
    
    protected final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }
    
    protected final DetectorResult processFinderPatternInfo(final FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        final FinderPattern topLeft = finderPatternInfo.getTopLeft();
        final FinderPattern topRight = finderPatternInfo.getTopRight();
        final FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        final float calculateModuleSize = this.calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
        final Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion();
        ResultPoint alignmentInRegion;
        Object transform = alignmentInRegion = null;
    Block_3_Outer:
        while (true) {
            while (true) {
                Label_0188: {
                    if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                        final float x = topRight.getX();
                        final float x2 = topLeft.getX();
                        final float x3 = bottomLeft.getX();
                        final float y = topRight.getY();
                        final float y2 = topLeft.getY();
                        final float y3 = bottomLeft.getY();
                        final float n = 1.0f - 3.0f / (dimensionForVersion - 7);
                        final int n2 = (int)(topLeft.getX() + (x - x2 + x3 - topLeft.getX()) * n);
                        final int n3 = (int)(topLeft.getY() + (y - y2 + y3 - topLeft.getY()) * n);
                        dimensionForVersion = 4;
                        break Label_0188;
                    }
                    break Label_0213;
                    while (true) {
                        final float n4 = (float)dimensionForVersion;
                        while (true) {
                            try {
                                final int n2;
                                final int n3;
                                alignmentInRegion = this.findAlignmentInRegion(calculateModuleSize, n2, n3, n4);
                                transform = createTransform(topLeft, topRight, bottomLeft, alignmentInRegion, computeDimension);
                                final BitMatrix sampleGrid = sampleGrid(this.image, (PerspectiveTransform)transform, computeDimension);
                                if (alignmentInRegion == null) {
                                    final ResultPoint[] array = { bottomLeft, topLeft, topRight };
                                    return new DetectorResult(sampleGrid, array);
                                }
                            }
                            catch (NotFoundException ex) {
                                dimensionForVersion <<= 1;
                                break;
                            }
                            ResultPoint[] array;
                            transform = (array = new ResultPoint[] { bottomLeft, topLeft, topRight, alignmentInRegion });
                            continue;
                        }
                    }
                }
                alignmentInRegion = (ResultPoint)transform;
                if (dimensionForVersion <= 16) {
                    continue;
                }
                break;
            }
            continue Block_3_Outer;
        }
    }
}
