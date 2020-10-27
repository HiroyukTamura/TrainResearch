package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup {
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions = {-1, -1};
    int mGroupHeight = -1;
    int mGroupWidth = -1;
    public boolean mSkipSolver = false;
    List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
    List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
    List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
    HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet<>();
    HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet<>();
    List<ConstraintWidget> mWidgetsToSolve = new ArrayList();

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.mConstrainedGroup = list;
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2;
        if (!constraintWidget.mGroupsToSolver) {
            arrayList.add(constraintWidget);
            constraintWidget.mGroupsToSolver = true;
            if (!constraintWidget.isFullyResolved()) {
                if (constraintWidget instanceof Helper) {
                    Helper helper = (Helper) constraintWidget;
                    int i = helper.mWidgetsCount;
                    for (int i2 = 0; i2 < i; i2++) {
                        getWidgetsToSolveTraversal(arrayList, helper.mWidgets[i2]);
                    }
                }
                for (ConstraintAnchor constraintAnchor : constraintWidget.mListAnchors) {
                    ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                    if (!(constraintAnchor2 == null || (constraintWidget2 = constraintAnchor2.mOwner) == constraintWidget.getParent())) {
                        getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateResolvedDimension(androidx.constraintlayout.solver.widgets.ConstraintWidget r7) {
        /*
            r6 = this;
            boolean r0 = r7.mOptimizerMeasurable
            if (r0 == 0) goto L_0x00d9
            boolean r0 = r7.isFullyResolved()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mRight
            goto L_0x001d
        L_0x001b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mLeft
        L_0x001d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0043
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r3.mOwner
            boolean r5 = r4.mOptimizerMeasured
            if (r5 != 0) goto L_0x002a
            r6.updateResolvedDimension(r4)
        L_0x002a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r3.mType
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r4 != r5) goto L_0x003a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            int r4 = r3.f16mX
            int r3 = r3.getWidth()
            int r3 = r3 + r4
            goto L_0x0044
        L_0x003a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r4 != r5) goto L_0x0043
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            int r3 = r3.f16mX
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r0 == 0) goto L_0x004e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mRight
            int r0 = r0.getMargin()
            int r3 = r3 - r0
            goto L_0x005a
        L_0x004e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mLeft
            int r0 = r0.getMargin()
            int r4 = r7.getWidth()
            int r4 = r4 + r0
            int r3 = r3 + r4
        L_0x005a:
            int r0 = r7.getWidth()
            int r0 = r3 - r0
            r7.setHorizontalDimension(r0, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x0085
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mOwner
            boolean r3 = r1.mOptimizerMeasured
            if (r3 != 0) goto L_0x0072
            r6.updateResolvedDimension(r1)
        L_0x0072:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.mOwner
            int r1 = r0.f17mY
            int r0 = r0.mBaselineDistance
            int r1 = r1 + r0
            int r0 = r7.mBaselineDistance
            int r1 = r1 - r0
            int r0 = r7.mHeight
            int r0 = r0 + r1
            r7.setVerticalDimension(r1, r0)
            r7.mOptimizerMeasured = r2
            return
        L_0x0085:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x008c
            r1 = 1
        L_0x008c:
            if (r1 == 0) goto L_0x0091
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mBottom
            goto L_0x0093
        L_0x0091:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mTop
        L_0x0093:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x00b8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mOwner
            boolean r5 = r4.mOptimizerMeasured
            if (r5 != 0) goto L_0x00a0
            r6.updateResolvedDimension(r4)
        L_0x00a0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r0.mType
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r4 != r5) goto L_0x00b0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.mOwner
            int r3 = r0.f17mY
            int r0 = r0.getHeight()
            int r3 = r3 + r0
            goto L_0x00b8
        L_0x00b0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r4 != r5) goto L_0x00b8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.mOwner
            int r3 = r0.f17mY
        L_0x00b8:
            if (r1 == 0) goto L_0x00c2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mBottom
            int r0 = r0.getMargin()
            int r3 = r3 - r0
            goto L_0x00ce
        L_0x00c2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mTop
            int r0 = r0.getMargin()
            int r1 = r7.getHeight()
            int r1 = r1 + r0
            int r3 = r3 + r1
        L_0x00ce:
            int r0 = r7.getHeight()
            int r0 = r3 - r0
            r7.setVerticalDimension(r0, r3)
            r7.mOptimizerMeasured = r2
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup.updateResolvedDimension(androidx.constraintlayout.solver.widgets.ConstraintWidget):void");
    }

    /* access modifiers changed from: package-private */
    public void addWidgetsToSet(ConstraintWidget constraintWidget, int i) {
        HashSet<ConstraintWidget> hashSet;
        if (i == 0) {
            hashSet = this.mWidgetsToSetHorizontal;
        } else if (i == 1) {
            hashSet = this.mWidgetsToSetVertical;
        } else {
            return;
        }
        hashSet.add(constraintWidget);
    }

    public List<ConstraintWidget> getStartWidgets(int i) {
        if (i == 0) {
            return this.mStartHorizontalWidgets;
        }
        if (i == 1) {
            return this.mStartVerticalWidgets;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Set<ConstraintWidget> getWidgetsToSet(int i) {
        if (i == 0) {
            return this.mWidgetsToSetHorizontal;
        }
        if (i == 1) {
            return this.mWidgetsToSetVertical;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<ConstraintWidget> getWidgetsToSolve() {
        if (!this.mWidgetsToSolve.isEmpty()) {
            return this.mWidgetsToSolve;
        }
        int size = this.mConstrainedGroup.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i);
            if (!constraintWidget.mOptimizerMeasurable) {
                getWidgetsToSolveTraversal((ArrayList) this.mWidgetsToSolve, constraintWidget);
            }
        }
        this.mUnresolvedWidgets.clear();
        this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
        this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
        return this.mWidgetsToSolve;
    }

    /* access modifiers changed from: package-private */
    public void updateUnresolvedWidgets() {
        int size = this.mUnresolvedWidgets.size();
        for (int i = 0; i < size; i++) {
            updateResolvedDimension(this.mUnresolvedWidgets.get(i));
        }
    }
}
