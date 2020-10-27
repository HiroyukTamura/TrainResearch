package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private ArrayList<ResolutionAnchor> mNodes = new ArrayList<>(4);

    public void addToSolver(LinearSystem linearSystem) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i3 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i3 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i3].mSolverVariable = linearSystem.createObjectVariable(constraintAnchorArr[i3]);
            i3++;
        }
        int i4 = this.mBarrierType;
        if (i4 >= 0 && i4 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i4];
            int i5 = 0;
            while (true) {
                if (i5 >= this.mWidgetsCount) {
                    z = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i5];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                    z = true;
                } else {
                    i5++;
                }
            }
            int i6 = this.mBarrierType;
            if (i6 == 0 || i6 == 1 ? getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z = false;
            }
            for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i7];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                    int i8 = this.mBarrierType;
                    constraintAnchorArr3[i8].mSolverVariable = createObjectVariable;
                    if (i8 == 0 || i8 == 2) {
                        linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, z);
                    } else {
                        linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, z);
                    }
                }
            }
            int i9 = this.mBarrierType;
            if (i9 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mLeft.mSolverVariable;
                    constraintAnchor = this.mParent.mRight;
                } else {
                    return;
                }
            } else if (i9 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mLeft.mSolverVariable;
                    constraintAnchor = this.mParent.mLeft;
                } else {
                    return;
                }
            } else if (i9 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mTop.mSolverVariable;
                    constraintAnchor = this.mParent.mBottom;
                } else {
                    return;
                }
            } else if (i9 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mTop.mSolverVariable;
                    constraintAnchor = this.mParent.mTop;
                } else {
                    return;
                }
            } else {
                return;
            }
            linearSystem.addEquality(solverVariable, constraintAnchor.mSolverVariable, 0, 5);
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void analyze(int r8) {
        /*
            r7 = this;
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r7.mParent
            if (r8 != 0) goto L_0x0005
            return
        L_0x0005:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r0 = 2
            boolean r8 = r8.optimizeFor(r0)
            if (r8 != 0) goto L_0x000f
            return
        L_0x000f:
            int r8 = r7.mBarrierType
            r1 = 3
            r2 = 1
            if (r8 == 0) goto L_0x0025
            if (r8 == r2) goto L_0x0022
            if (r8 == r0) goto L_0x001f
            if (r8 == r1) goto L_0x001c
            return
        L_0x001c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.mBottom
            goto L_0x0027
        L_0x001f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.mTop
            goto L_0x0027
        L_0x0022:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.mRight
            goto L_0x0027
        L_0x0025:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.mLeft
        L_0x0027:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r3 = 5
            r8.setType(r3)
            int r3 = r7.mBarrierType
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0044
            if (r3 != r2) goto L_0x0038
            goto L_0x0044
        L_0x0038:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mLeft
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            r3.resolve(r5, r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mRight
            goto L_0x004f
        L_0x0044:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mTop
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            r3.resolve(r5, r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mBottom
        L_0x004f:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            r3.resolve(r5, r4)
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r3 = r7.mNodes
            r3.clear()
            r3 = 0
        L_0x005c:
            int r4 = r7.mWidgetsCount
            if (r3 >= r4) goto L_0x0097
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r4 = r7.mWidgets
            r4 = r4[r3]
            boolean r6 = r7.mAllowsGoneWidget
            if (r6 != 0) goto L_0x006f
            boolean r6 = r4.allowedInBarrier()
            if (r6 != 0) goto L_0x006f
            goto L_0x0094
        L_0x006f:
            int r6 = r7.mBarrierType
            if (r6 == 0) goto L_0x0084
            if (r6 == r2) goto L_0x0081
            if (r6 == r0) goto L_0x007e
            if (r6 == r1) goto L_0x007b
            r4 = r5
            goto L_0x008a
        L_0x007b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mBottom
            goto L_0x0086
        L_0x007e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTop
            goto L_0x0086
        L_0x0081:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mRight
            goto L_0x0086
        L_0x0084:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mLeft
        L_0x0086:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
        L_0x008a:
            if (r4 == 0) goto L_0x0094
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r6 = r7.mNodes
            r6.add(r4)
            r4.addDependent(r8)
        L_0x0094:
            int r3 = r3 + 1
            goto L_0x005c
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Barrier.analyze(int):void");
    }

    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.mNodes.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resolve() {
        /*
            r11 = this;
            int r0 = r11.mBarrierType
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x0020
            if (r0 == r4) goto L_0x0018
            if (r0 == r3) goto L_0x0015
            if (r0 == r2) goto L_0x0012
            return
        L_0x0012:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mBottom
            goto L_0x001a
        L_0x0015:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mTop
            goto L_0x0022
        L_0x0018:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mRight
        L_0x001a:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r1 = 0
            goto L_0x0026
        L_0x0020:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mLeft
        L_0x0022:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
        L_0x0026:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r5 = r11.mNodes
            int r5 = r5.size()
            r6 = 0
            r7 = 0
        L_0x002e:
            if (r7 >= r5) goto L_0x0058
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r8 = r11.mNodes
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = (androidx.constraintlayout.solver.widgets.ResolutionAnchor) r8
            int r9 = r8.state
            if (r9 == r4) goto L_0x003d
            return
        L_0x003d:
            int r9 = r11.mBarrierType
            if (r9 == 0) goto L_0x004b
            if (r9 != r3) goto L_0x0044
            goto L_0x004b
        L_0x0044:
            float r9 = r8.resolvedOffset
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 <= 0) goto L_0x0055
            goto L_0x0051
        L_0x004b:
            float r9 = r8.resolvedOffset
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x0055
        L_0x0051:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r1 = r8.resolvedTarget
            r6 = r1
            r1 = r9
        L_0x0055:
            int r7 = r7 + 1
            goto L_0x002e
        L_0x0058:
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r5 == 0) goto L_0x0069
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r7 = r5.barrierConnectionResolved
            r9 = 1
            long r7 = r7 + r9
            r5.barrierConnectionResolved = r7
        L_0x0069:
            r0.resolvedTarget = r6
            r0.resolvedOffset = r1
            r0.didResolve()
            int r0 = r11.mBarrierType
            if (r0 == 0) goto L_0x0084
            if (r0 == r4) goto L_0x0081
            if (r0 == r3) goto L_0x007e
            if (r0 == r2) goto L_0x007b
            return
        L_0x007b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mTop
            goto L_0x0086
        L_0x007e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mBottom
            goto L_0x0086
        L_0x0081:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mLeft
            goto L_0x0086
        L_0x0084:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mRight
        L_0x0086:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r0.resolve(r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Barrier.resolve():void");
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }
}
