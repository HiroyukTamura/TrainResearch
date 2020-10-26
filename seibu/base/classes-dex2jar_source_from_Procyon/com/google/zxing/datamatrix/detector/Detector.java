// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.detector;

import java.io.Serializable;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import java.util.Map;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.ResultPoint;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.BitMatrix;

public final class Detector
{
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;
    
    public Detector(final BitMatrix image) throws NotFoundException {
        this.image = image;
        this.rectangleDetector = new WhiteRectangleDetector(image);
    }
    
    private ResultPoint correctTopRight(ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4, int distance) {
        final float n = distance(resultPoint, resultPoint2) / (float)distance;
        final int distance2 = distance(resultPoint3, resultPoint4);
        final ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + n * ((resultPoint4.getX() - resultPoint3.getX()) / distance2), resultPoint4.getY() + n * ((resultPoint4.getY() - resultPoint3.getY()) / distance2));
        final float n2 = distance(resultPoint, resultPoint3) / (float)distance;
        distance = distance(resultPoint2, resultPoint4);
        resultPoint = new ResultPoint(resultPoint4.getX() + n2 * ((resultPoint4.getX() - resultPoint2.getX()) / distance), resultPoint4.getY() + n2 * ((resultPoint4.getY() - resultPoint2.getY()) / distance));
        if (!this.isValid(resultPoint5)) {
            if (!this.isValid(resultPoint)) {
                return null;
            }
        }
        else {
            if (!this.isValid(resultPoint)) {
                return resultPoint5;
            }
            if (Math.abs(this.transitionsBetween(resultPoint3, resultPoint5).getTransitions() - this.transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(this.transitionsBetween(resultPoint3, resultPoint).getTransitions() - this.transitionsBetween(resultPoint2, resultPoint).getTransitions())) {
                return resultPoint5;
            }
        }
        return resultPoint;
    }
    
    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4, final int n, final int n2) {
        final float n3 = distance(resultPoint, resultPoint2) / (float)n;
        final int distance = distance(resultPoint3, resultPoint4);
        final ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + n3 * ((resultPoint4.getX() - resultPoint3.getX()) / distance), resultPoint4.getY() + n3 * ((resultPoint4.getY() - resultPoint3.getY()) / distance));
        final float n4 = distance(resultPoint, resultPoint3) / (float)n2;
        final int distance2 = distance(resultPoint2, resultPoint4);
        resultPoint = new ResultPoint(resultPoint4.getX() + n4 * ((resultPoint4.getX() - resultPoint2.getX()) / distance2), resultPoint4.getY() + n4 * ((resultPoint4.getY() - resultPoint2.getY()) / distance2));
        if (!this.isValid(resultPoint5)) {
            if (!this.isValid(resultPoint)) {
                return null;
            }
        }
        else {
            if (!this.isValid(resultPoint)) {
                return resultPoint5;
            }
            if (Math.abs(n - this.transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(n2 - this.transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(n - this.transitionsBetween(resultPoint3, resultPoint).getTransitions()) + Math.abs(n2 - this.transitionsBetween(resultPoint2, resultPoint).getTransitions())) {
                return resultPoint5;
            }
        }
        return resultPoint;
    }
    
    private static int distance(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }
    
    private static void increment(final Map<ResultPoint, Integer> map, final ResultPoint resultPoint) {
        final Integer n = map.get(resultPoint);
        int i;
        if (n == null) {
            i = 1;
        }
        else {
            i = n + 1;
        }
        map.put(resultPoint, i);
    }
    
    private boolean isValid(final ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < this.image.getWidth() && resultPoint.getY() > 0.0f && resultPoint.getY() < this.image.getHeight();
    }
    
    private static BitMatrix sampleGrid(final BitMatrix bitMatrix, final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4, final int n, final int n2) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, n, n2, 0.5f, 0.5f, n - 0.5f, 0.5f, n - 0.5f, n2 - 0.5f, 0.5f, n2 - 0.5f, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }
    
    private ResultPointsAndTransitions transitionsBetween(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        final int n = (int)resultPoint.getX();
        final int n2 = (int)resultPoint.getY();
        final int n3 = (int)resultPoint2.getX();
        final int n4 = (int)resultPoint2.getY();
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
            n5 = n2;
            n6 = n;
            n8 = n3;
            n7 = n4;
        }
        final int abs = Math.abs(n7 - n5);
        final int abs2 = Math.abs(n8 - n6);
        int n9 = -abs / 2;
        int n10;
        if (n6 < n8) {
            n10 = 1;
        }
        else {
            n10 = -1;
        }
        int n11;
        if (n5 < n7) {
            n11 = 1;
        }
        else {
            n11 = -1;
        }
        final int n12 = 0;
        final BitMatrix image = this.image;
        int n13;
        if (b) {
            n13 = n6;
        }
        else {
            n13 = n5;
        }
        int n14;
        if (b) {
            n14 = n5;
        }
        else {
            n14 = n6;
        }
        boolean value = image.get(n13, n14);
        final int n15 = n5;
        int n16 = n6;
        int n17 = n15;
        int n18 = n12;
        int n19;
        while (true) {
            n19 = n18;
            if (n17 == n7) {
                break;
            }
            final BitMatrix image2 = this.image;
            int n20;
            if (b) {
                n20 = n16;
            }
            else {
                n20 = n17;
            }
            int n21;
            if (b) {
                n21 = n17;
            }
            else {
                n21 = n16;
            }
            final boolean value2 = image2.get(n20, n21);
            boolean b2 = value;
            int n22 = n18;
            if (value2 != value) {
                n22 = n18 + 1;
                b2 = value2;
            }
            int n24;
            final int n23 = n24 = n9 + abs2;
            int n25 = n16;
            if (n23 > 0) {
                n19 = n22;
                if (n16 == n8) {
                    break;
                }
                n25 = n16 + n10;
                n24 = n23 - abs;
            }
            n17 += n11;
            n9 = n24;
            value = b2;
            n18 = n22;
            n16 = n25;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, n19);
    }
    
    public DetectorResult detect() throws NotFoundException {
        final ResultPoint[] detect = this.rectangleDetector.detect();
        final ResultPoint resultPoint = detect[0];
        final ResultPoint resultPoint2 = detect[1];
        final ResultPoint resultPoint3 = detect[2];
        final ResultPoint resultPoint4 = detect[3];
        final ArrayList<ResultPointsAndTransitions> list = new ArrayList<ResultPointsAndTransitions>(4);
        list.add(this.transitionsBetween(resultPoint, resultPoint2));
        list.add((T)this.transitionsBetween(resultPoint, resultPoint3));
        list.add(this.transitionsBetween(resultPoint2, resultPoint4));
        list.add(this.transitionsBetween(resultPoint3, resultPoint4));
        Collections.sort((List<Object>)list, (Comparator<? super Object>)new ResultPointsAndTransitionsComparator());
        final ResultPointsAndTransitions resultPointsAndTransitions = list.get(0);
        final ResultPointsAndTransitions resultPointsAndTransitions2 = list.get(1);
        final HashMap<ResultPoint, Integer> hashMap = new HashMap<ResultPoint, Integer>();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint5 = null;
        ResultPoint resultPoint6 = null;
        ResultPoint resultPoint7 = null;
        for (final Map.Entry<ResultPoint, V> entry : hashMap.entrySet()) {
            final ResultPoint resultPoint8 = entry.getKey();
            if ((int)entry.getValue() == 2) {
                resultPoint6 = resultPoint8;
            }
            else if (resultPoint5 == null) {
                resultPoint5 = resultPoint8;
            }
            else {
                resultPoint7 = resultPoint8;
            }
        }
        if (resultPoint5 == null || resultPoint6 == null || resultPoint7 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        final ResultPoint[] array = { resultPoint5, resultPoint6, resultPoint7 };
        ResultPoint.orderBestPatterns(array);
        final ResultPoint resultPoint9 = array[0];
        final ResultPoint resultPoint10 = array[1];
        final ResultPoint resultPoint11 = array[2];
        ResultPoint resultPoint12;
        if (!hashMap.containsKey(resultPoint)) {
            resultPoint12 = resultPoint;
        }
        else if (!hashMap.containsKey(resultPoint2)) {
            resultPoint12 = resultPoint2;
        }
        else if (!hashMap.containsKey(resultPoint3)) {
            resultPoint12 = resultPoint3;
        }
        else {
            resultPoint12 = resultPoint4;
        }
        final int transitions = this.transitionsBetween(resultPoint11, resultPoint12).getTransitions();
        final int transitions2 = this.transitionsBetween(resultPoint9, resultPoint12).getTransitions();
        int n = transitions;
        if ((transitions & 0x1) == 0x1) {
            n = transitions + 1;
        }
        final int b = n + 2;
        int n2 = transitions2;
        if ((transitions2 & 0x1) == 0x1) {
            n2 = transitions2 + 1;
        }
        final int a = n2 + 2;
        ResultPoint resultPoint13;
        BitMatrix bitMatrix;
        if (b * 4 >= a * 7 || a * 4 >= b * 7) {
            if ((resultPoint13 = this.correctTopRightRectangular(resultPoint10, resultPoint9, resultPoint11, resultPoint12, b, a)) == null) {
                resultPoint13 = resultPoint12;
            }
            final int transitions3 = this.transitionsBetween(resultPoint11, resultPoint13).getTransitions();
            final int transitions4 = this.transitionsBetween(resultPoint9, resultPoint13).getTransitions();
            int n3 = transitions3;
            if ((transitions3 & 0x1) == 0x1) {
                n3 = transitions3 + 1;
            }
            int n4 = transitions4;
            if ((transitions4 & 0x1) == 0x1) {
                n4 = transitions4 + 1;
            }
            bitMatrix = sampleGrid(this.image, resultPoint11, resultPoint10, resultPoint9, resultPoint13, n3, n4);
        }
        else {
            if ((resultPoint13 = this.correctTopRight(resultPoint10, resultPoint9, resultPoint11, resultPoint12, Math.min(a, b))) == null) {
                resultPoint13 = resultPoint12;
            }
            int n6;
            final int n5 = n6 = Math.max(this.transitionsBetween(resultPoint11, resultPoint13).getTransitions(), this.transitionsBetween(resultPoint9, resultPoint13).getTransitions()) + 1;
            if ((n5 & 0x1) == 0x1) {
                n6 = n5 + 1;
            }
            bitMatrix = sampleGrid(this.image, resultPoint11, resultPoint10, resultPoint9, resultPoint13, n6, n6);
        }
        return new DetectorResult(bitMatrix, new ResultPoint[] { resultPoint11, resultPoint10, resultPoint9, resultPoint13 });
    }
    
    private static final class ResultPointsAndTransitions
    {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;
        
        private ResultPointsAndTransitions(final ResultPoint from, final ResultPoint to, final int transitions) {
            this.from = from;
            this.to = to;
            this.transitions = transitions;
        }
        
        ResultPoint getFrom() {
            return this.from;
        }
        
        ResultPoint getTo() {
            return this.to;
        }
        
        int getTransitions() {
            return this.transitions;
        }
        
        @Override
        public String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }
    }
    
    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions>
    {
        @Override
        public int compare(final ResultPointsAndTransitions resultPointsAndTransitions, final ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }
}
