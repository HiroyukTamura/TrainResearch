package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4) || !Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX WARNING: type inference failed for: r4v9, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x04cf  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0368 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0188  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            r0 = r37
            r9 = r38
            r1 = r41
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x001d
            r4 = 1
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            r5 = 2
            if (r39 != 0) goto L_0x0034
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x0027
            r8 = 1
            goto L_0x0028
        L_0x0027:
            r8 = 0
        L_0x0028:
            int r14 = r2.mHorizontalChainStyle
            if (r14 != r7) goto L_0x002e
            r14 = 1
            goto L_0x002f
        L_0x002e:
            r14 = 0
        L_0x002f:
            int r15 = r2.mHorizontalChainStyle
            if (r15 != r5) goto L_0x0048
            goto L_0x0046
        L_0x0034:
            int r8 = r2.mVerticalChainStyle
            if (r8 != 0) goto L_0x003a
            r8 = 1
            goto L_0x003b
        L_0x003a:
            r8 = 0
        L_0x003b:
            int r14 = r2.mVerticalChainStyle
            if (r14 != r7) goto L_0x0041
            r14 = 1
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            int r15 = r2.mVerticalChainStyle
            if (r15 != r5) goto L_0x0048
        L_0x0046:
            r5 = 1
            goto L_0x0049
        L_0x0048:
            r5 = 0
        L_0x0049:
            r7 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x004d:
            r21 = 0
            if (r8 != 0) goto L_0x0122
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r40]
            if (r4 != 0) goto L_0x005d
            if (r5 == 0) goto L_0x005a
            goto L_0x005d
        L_0x005a:
            r23 = 4
            goto L_0x005f
        L_0x005d:
            r23 = 1
        L_0x005f:
            int r24 = r6.getMargin()
            r25 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r6.mTarget
            if (r3 == 0) goto L_0x0071
            if (r7 == r10) goto L_0x0071
            int r3 = r3.getMargin()
            int r24 = r3 + r24
        L_0x0071:
            r3 = r24
            if (r5 == 0) goto L_0x007f
            if (r7 == r10) goto L_0x007f
            if (r7 == r12) goto L_0x007f
            r24 = r8
            r23 = r15
            r8 = 6
            goto L_0x008f
        L_0x007f:
            if (r14 == 0) goto L_0x0089
            if (r4 == 0) goto L_0x0089
            r24 = r8
            r23 = r15
            r8 = 4
            goto L_0x008f
        L_0x0089:
            r24 = r8
            r8 = r23
            r23 = r15
        L_0x008f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r6.mTarget
            if (r15 == 0) goto L_0x00b8
            if (r7 != r12) goto L_0x00a2
            r26 = r14
            androidx.constraintlayout.solver.SolverVariable r14 = r6.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r27 = r2
            r2 = 5
            r9.addGreaterThan(r14, r15, r3, r2)
            goto L_0x00ae
        L_0x00a2:
            r27 = r2
            r26 = r14
            androidx.constraintlayout.solver.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r14 = r15.mSolverVariable
            r15 = 6
            r9.addGreaterThan(r2, r14, r3, r15)
        L_0x00ae:
            androidx.constraintlayout.solver.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r9.addEquality(r2, r6, r3, r8)
            goto L_0x00bc
        L_0x00b8:
            r27 = r2
            r26 = r14
        L_0x00bc:
            if (r4 == 0) goto L_0x00f1
            int r2 = r7.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00e0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r7.mListDimensionBehaviors
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00e0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r40 + 1
            r3 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r2 = r2[r40]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r6 = 5
            r8 = 0
            r9.addGreaterThan(r3, r2, r8, r6)
            goto L_0x00e1
        L_0x00e0:
            r8 = 0
        L_0x00e1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 6
            r9.addGreaterThan(r2, r3, r8, r6)
        L_0x00f1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0110
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r6 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x0110
            r3 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r7) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            r21 = r2
        L_0x0110:
            if (r21 == 0) goto L_0x0117
            r7 = r21
            r8 = r24
            goto L_0x0118
        L_0x0117:
            r8 = 1
        L_0x0118:
            r15 = r23
            r3 = r25
            r14 = r26
            r2 = r27
            goto L_0x004d
        L_0x0122:
            r27 = r2
            r25 = r3
            r26 = r14
            r23 = r15
            if (r13 == 0) goto L_0x014c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r40 + 1
            r6 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x014c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r3]
            androidx.constraintlayout.solver.SolverVariable r7 = r6.mSolverVariable
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r3 = r6.getMargin()
            int r3 = -r3
            r6 = 5
            r9.addLowerThan(r7, r2, r3, r6)
            goto L_0x014d
        L_0x014c:
            r6 = 5
        L_0x014d:
            if (r4 == 0) goto L_0x0167
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r40 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r4 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r2 = r3[r2]
            int r2 = r2.getMargin()
            r3 = 6
            r9.addGreaterThan(r0, r4, r2, r3)
        L_0x0167:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x0216
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0216
            boolean r4 = r1.mHasUndefinedWeights
            if (r4 == 0) goto L_0x017e
            boolean r4 = r1.mHasComplexMatchWeights
            if (r4 != 0) goto L_0x017e
            int r4 = r1.mWidgetsMatchCount
            float r4 = (float) r4
            goto L_0x0180
        L_0x017e:
            r4 = r25
        L_0x0180:
            r7 = 0
            r14 = r21
            r8 = 0
            r29 = 0
        L_0x0186:
            if (r8 >= r2) goto L_0x0216
            java.lang.Object r15 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            float[] r3 = r15.mWeight
            r3 = r3[r39]
            int r19 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r19 >= 0) goto L_0x01b2
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 == 0) goto L_0x01ad
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r15 = r40 + 1
            r15 = r3[r15]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 4
            r7 = 0
            r9.addEquality(r15, r3, r7, r6)
            r6 = 6
            goto L_0x01c8
        L_0x01ad:
            r6 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            goto L_0x01b3
        L_0x01b2:
            r6 = 4
        L_0x01b3:
            int r20 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r20 != 0) goto L_0x01cd
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r15 = r40 + 1
            r15 = r3[r15]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 6
            r7 = 0
            r9.addEquality(r15, r3, r7, r6)
        L_0x01c8:
            r25 = r0
            r17 = r2
            goto L_0x020b
        L_0x01cd:
            r6 = 6
            r7 = 0
            if (r14 == 0) goto L_0x0204
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r14.mListAnchors
            r6 = r14[r40]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            int r17 = r40 + 1
            r14 = r14[r17]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r15.mListAnchors
            r25 = r0
            r0 = r7[r40]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r7 = r7[r17]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r17 = r2
            androidx.constraintlayout.solver.ArrayRow r2 = r38.createRow()
            r28 = r2
            r30 = r4
            r31 = r3
            r32 = r6
            r33 = r14
            r34 = r0
            r35 = r7
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r9.addConstraint(r2)
            goto L_0x0208
        L_0x0204:
            r25 = r0
            r17 = r2
        L_0x0208:
            r29 = r3
            r14 = r15
        L_0x020b:
            int r8 = r8 + 1
            r2 = r17
            r0 = r25
            r3 = 1
            r6 = 5
            r7 = 0
            goto L_0x0186
        L_0x0216:
            if (r12 == 0) goto L_0x0276
            if (r12 == r13) goto L_0x021c
            if (r5 == 0) goto L_0x0276
        L_0x021c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r1 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            r4 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0234
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r4 = r0
            goto L_0x0236
        L_0x0234:
            r4 = r21
        L_0x0236:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r11.mListAnchors
            r5 = r0[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0246
            r0 = r0[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r5 = r0
            goto L_0x0248
        L_0x0246:
            r5 = r21
        L_0x0248:
            if (r12 != r13) goto L_0x0250
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r1 = r0[r40]
            r2 = r0[r3]
        L_0x0250:
            if (r4 == 0) goto L_0x0499
            if (r5 == 0) goto L_0x0499
            r0 = r27
            if (r39 != 0) goto L_0x025b
            float r0 = r0.mHorizontalBiasPercent
            goto L_0x025d
        L_0x025b:
            float r0 = r0.mVerticalBiasPercent
        L_0x025d:
            r6 = r0
            int r3 = r1.getMargin()
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r2.mSolverVariable
            r10 = 5
            r0 = r38
            r2 = r4
            r4 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0499
        L_0x0276:
            if (r26 == 0) goto L_0x036c
            if (r12 == 0) goto L_0x036c
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x0285
            int r1 = r1.mWidgetsCount
            if (r1 != r0) goto L_0x0285
            r16 = 1
            goto L_0x0287
        L_0x0285:
            r16 = 0
        L_0x0287:
            r14 = r12
            r15 = r14
        L_0x0289:
            if (r14 == 0) goto L_0x0499
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
            r8 = r0
        L_0x0290:
            if (r8 == 0) goto L_0x029f
            int r0 = r8.getVisibility()
            r6 = 8
            if (r0 != r6) goto L_0x02a1
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r8 = r0[r39]
            goto L_0x0290
        L_0x029f:
            r6 = 8
        L_0x02a1:
            if (r8 != 0) goto L_0x02ae
            if (r14 != r13) goto L_0x02a6
            goto L_0x02ae
        L_0x02a6:
            r17 = r8
            r18 = 4
            r20 = 6
            goto L_0x035f
        L_0x02ae:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x02bb
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02bd
        L_0x02bb:
            r2 = r21
        L_0x02bd:
            if (r15 == r14) goto L_0x02c8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
        L_0x02c5:
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02db
        L_0x02c8:
            if (r14 != r12) goto L_0x02db
            if (r15 != r14) goto L_0x02db
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r3 = r2[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x02d9
            r2 = r2[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            goto L_0x02c5
        L_0x02d9:
            r2 = r21
        L_0x02db:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r8 == 0) goto L_0x02fd
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.solver.SolverVariable r7 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r4]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r36 = r7
            r7 = r6
            r6 = r36
            goto L_0x0310
        L_0x02fd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0308
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x030a
        L_0x0308:
            r6 = r21
        L_0x030a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
        L_0x0310:
            if (r5 == 0) goto L_0x0317
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x0317:
            if (r15 == 0) goto L_0x0322
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x0322:
            if (r1 == 0) goto L_0x02a6
            if (r2 == 0) goto L_0x02a6
            if (r6 == 0) goto L_0x02a6
            if (r7 == 0) goto L_0x02a6
            if (r14 != r12) goto L_0x0334
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            int r0 = r0.getMargin()
        L_0x0334:
            r5 = r0
            if (r14 != r13) goto L_0x0342
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r17 = r0
            goto L_0x0344
        L_0x0342:
            r17 = r3
        L_0x0344:
            if (r16 == 0) goto L_0x0349
            r19 = 6
            goto L_0x034b
        L_0x0349:
            r19 = 4
        L_0x034b:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r3 = r5
            r5 = r6
            r18 = 4
            r20 = 6
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x035f:
            int r0 = r14.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x0368
            r15 = r14
        L_0x0368:
            r14 = r17
            goto L_0x0289
        L_0x036c:
            r8 = 8
            r18 = 4
            r20 = 6
            if (r23 == 0) goto L_0x0499
            if (r12 == 0) goto L_0x0499
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x0381
            int r1 = r1.mWidgetsCount
            if (r1 != r0) goto L_0x0381
            r16 = 1
            goto L_0x0383
        L_0x0381:
            r16 = 0
        L_0x0383:
            r14 = r12
            r15 = r14
        L_0x0385:
            if (r14 == 0) goto L_0x043b
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
        L_0x038b:
            if (r0 == 0) goto L_0x0398
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x0398
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r39]
            goto L_0x038b
        L_0x0398:
            if (r14 == r12) goto L_0x0428
            if (r14 == r13) goto L_0x0428
            if (r0 == 0) goto L_0x0428
            if (r0 != r13) goto L_0x03a3
            r7 = r21
            goto L_0x03a4
        L_0x03a3:
            r7 = r0
        L_0x03a4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x03b0
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x03b0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x03d4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            if (r8 == 0) goto L_0x03d1
            goto L_0x03e5
        L_0x03d1:
            r8 = r21
            goto L_0x03e7
        L_0x03d4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r14.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x03df
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x03e1
        L_0x03df:
            r6 = r21
        L_0x03e1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r3]
        L_0x03e5:
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
        L_0x03e7:
            if (r5 == 0) goto L_0x03f1
            int r5 = r5.getMargin()
            int r5 = r5 + r4
            r17 = r5
            goto L_0x03f3
        L_0x03f1:
            r17 = r4
        L_0x03f3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r3 = r3 + r0
            if (r16 == 0) goto L_0x0401
            r22 = 6
            goto L_0x0403
        L_0x0401:
            r22 = 4
        L_0x0403:
            if (r1 == 0) goto L_0x041f
            if (r2 == 0) goto L_0x041f
            if (r6 == 0) goto L_0x041f
            if (r8 == 0) goto L_0x041f
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r5 = r6
            r6 = r8
            r19 = r7
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r22
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0425
        L_0x041f:
            r19 = r7
            r17 = r15
            r15 = 8
        L_0x0425:
            r0 = r19
            goto L_0x042c
        L_0x0428:
            r17 = r15
            r15 = 8
        L_0x042c:
            int r1 = r14.getVisibility()
            if (r1 == r15) goto L_0x0433
            goto L_0x0435
        L_0x0433:
            r14 = r17
        L_0x0435:
            r15 = r14
            r8 = 8
            r14 = r0
            goto L_0x0385
        L_0x043b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r40 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.mTarget
            if (r1 == 0) goto L_0x0488
            if (r12 == r13) goto L_0x0462
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r15 = 5
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x0489
        L_0x0462:
            r15 = 5
            if (r14 == 0) goto L_0x0489
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r14.mSolverVariable
            int r8 = r10.getMargin()
            r16 = 5
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0489
        L_0x0488:
            r15 = 5
        L_0x0489:
            if (r14 == 0) goto L_0x0499
            if (r12 == r13) goto L_0x0499
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r14.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x0499:
            if (r26 != 0) goto L_0x049d
            if (r23 == 0) goto L_0x04fb
        L_0x049d:
            if (r12 == 0) goto L_0x04fb
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x04b0
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x04b2
        L_0x04b0:
            r3 = r21
        L_0x04b2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04b9
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x04bb
        L_0x04b9:
            r4 = r21
        L_0x04bb:
            if (r11 == r13) goto L_0x04cc
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x04c9
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r21 = r4
        L_0x04c9:
            r5 = r21
            goto L_0x04cd
        L_0x04cc:
            r5 = r4
        L_0x04cd:
            if (r12 != r13) goto L_0x04da
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r1 = r0[r40]
            r0 = r0[r2]
            r36 = r1
            r1 = r0
            r0 = r36
        L_0x04da:
            if (r3 == 0) goto L_0x04fb
            if (r5 == 0) goto L_0x04fb
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r13.mListAnchors
            r2 = r7[r2]
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
