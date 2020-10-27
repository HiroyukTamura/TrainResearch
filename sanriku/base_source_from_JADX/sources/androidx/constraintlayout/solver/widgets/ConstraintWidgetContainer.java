package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount = 0;
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    private int mOptimizationLevel = 7;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mChildren.get(i2).analyze(i);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARNING: type inference failed for: r8v17, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.f16mX
            int r3 = r1.f17mY
            int r0 = r21.getWidth()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.getHeight()
            int r6 = java.lang.Math.max(r4, r0)
            r1.mWidthMeasuredTooSmall = r4
            r1.mHeightMeasuredTooSmall = r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.mParent
            if (r0 == 0) goto L_0x0046
            androidx.constraintlayout.solver.widgets.Snapshot r0 = r1.mSnapshot
            if (r0 != 0) goto L_0x002a
            androidx.constraintlayout.solver.widgets.Snapshot r0 = new androidx.constraintlayout.solver.widgets.Snapshot
            r0.<init>(r1)
            r1.mSnapshot = r0
        L_0x002a:
            androidx.constraintlayout.solver.widgets.Snapshot r0 = r1.mSnapshot
            r0.updateFrom(r1)
            int r0 = r1.mPaddingLeft
            r1.setX(r0)
            int r0 = r1.mPaddingTop
            r1.setY(r0)
            r21.resetAnchors()
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            androidx.constraintlayout.solver.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            goto L_0x004a
        L_0x0046:
            r1.f16mX = r4
            r1.f17mY = r4
        L_0x004a:
            int r0 = r1.mOptimizationLevel
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.optimizeFor(r8)
            if (r0 != 0) goto L_0x005c
            r21.optimizeReset()
        L_0x005c:
            boolean r0 = r1.optimizeFor(r7)
            if (r0 != 0) goto L_0x0065
            r21.optimize()
        L_0x0065:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r9
            goto L_0x006e
        L_0x006a:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r4
        L_0x006e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r10 = r0[r9]
            r11 = r0[r4]
            r21.resetChains()
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0090
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            r0.clear()
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r12 = new androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r13 = r1.mChildren
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0090:
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            int r12 = r0.size()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r13 = r1.mChildren
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r21.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r14) goto L_0x00ab
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r21.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r14) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r14 = 0
            goto L_0x00ac
        L_0x00ab:
            r14 = 1
        L_0x00ac:
            r0 = 0
            r15 = 0
        L_0x00ae:
            if (r15 >= r12) goto L_0x02ee
            boolean r8 = r1.mSkipSolver
            if (r8 != 0) goto L_0x02ee
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r8 = r1.mWidgetGroups
            java.lang.Object r8 = r8.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r8
            boolean r8 = r8.mSkipSolver
            if (r8 == 0) goto L_0x00c4
            r19 = r12
            goto L_0x02e2
        L_0x00c4:
            boolean r8 = r1.optimizeFor(r7)
            if (r8 == 0) goto L_0x00f5
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r21.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 != r7) goto L_0x00e7
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r21.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 != r8) goto L_0x00e7
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r7 = r1.mWidgetGroups
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List r7 = r7.getWidgetsToSolve()
            goto L_0x00f1
        L_0x00e7:
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r7 = r1.mWidgetGroups
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r7.mConstrainedGroup
        L_0x00f1:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.mChildren = r7
        L_0x00f5:
            r21.resetChains()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r1.mChildren
            int r7 = r7.size()
            r8 = 0
        L_0x00ff:
            if (r8 >= r7) goto L_0x0117
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r4 = r1.mChildren
            java.lang.Object r4 = r4.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r4
            boolean r9 = r4 instanceof androidx.constraintlayout.solver.widgets.WidgetContainer
            if (r9 == 0) goto L_0x0112
            androidx.constraintlayout.solver.widgets.WidgetContainer r4 = (androidx.constraintlayout.solver.widgets.WidgetContainer) r4
            r4.layout()
        L_0x0112:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x00ff
        L_0x0117:
            r4 = r0
            r0 = 0
            r8 = 1
        L_0x011a:
            r17 = r4
            if (r8 == 0) goto L_0x02d3
            r9 = 1
            int r4 = r0 + 1
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x015e }
            r0.reset()     // Catch:{ Exception -> 0x015e }
            r21.resetChains()     // Catch:{ Exception -> 0x015e }
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x015e }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x015e }
            r0 = 0
        L_0x012f:
            if (r0 >= r7) goto L_0x0145
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r9 = r1.mChildren     // Catch:{ Exception -> 0x015e }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ Exception -> 0x015e }
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9     // Catch:{ Exception -> 0x015e }
            r18 = r8
            androidx.constraintlayout.solver.LinearSystem r8 = r1.mSystem     // Catch:{ Exception -> 0x015a }
            r9.createObjectVariables(r8)     // Catch:{ Exception -> 0x015a }
            int r0 = r0 + 1
            r8 = r18
            goto L_0x012f
        L_0x0145:
            r18 = r8
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x015a }
            boolean r8 = r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x015a }
            if (r8 == 0) goto L_0x0157
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0155 }
            r0.minimize()     // Catch:{ Exception -> 0x0155 }
            goto L_0x0157
        L_0x0155:
            r0 = move-exception
            goto L_0x0161
        L_0x0157:
            r19 = r12
            goto L_0x0180
        L_0x015a:
            r0 = move-exception
            r8 = r18
            goto L_0x0161
        L_0x015e:
            r0 = move-exception
            r18 = r8
        L_0x0161:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r18 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
            r8 = r18
        L_0x0180:
            if (r8 == 0) goto L_0x018b
            androidx.constraintlayout.solver.LinearSystem r8 = r1.mSystem
            boolean[] r9 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r1.updateChildrenFromSolver(r8, r9)
        L_0x0189:
            r9 = 2
            goto L_0x01d4
        L_0x018b:
            androidx.constraintlayout.solver.LinearSystem r8 = r1.mSystem
            r1.updateFromSolver(r8)
            r8 = 0
        L_0x0191:
            if (r8 >= r7) goto L_0x0189
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r9 = r1.mChildren
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r9.mListDimensionBehaviors
            r16 = 0
            r12 = r12[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x01b6
            int r0 = r9.getWidth()
            int r12 = r9.getWrapWidth()
            if (r0 >= r12) goto L_0x01b6
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r8 = 2
            r12 = 1
            r0[r8] = r12
            goto L_0x0189
        L_0x01b6:
            r12 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r9.mListDimensionBehaviors
            r0 = r0[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r12) goto L_0x01d0
            int r0 = r9.getHeight()
            int r9 = r9.getWrapHeight()
            if (r0 >= r9) goto L_0x01d0
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r8 = 1
            r9 = 2
            r0[r9] = r8
            goto L_0x01d4
        L_0x01d0:
            r9 = 2
            int r8 = r8 + 1
            goto L_0x0191
        L_0x01d4:
            if (r14 == 0) goto L_0x024c
            r8 = 8
            if (r4 >= r8) goto L_0x024c
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            boolean r0 = r0[r9]
            if (r0 == 0) goto L_0x024c
            r0 = 0
            r9 = 0
            r12 = 0
        L_0x01e3:
            if (r0 >= r7) goto L_0x020d
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r8 = r1.mChildren
            java.lang.Object r8 = r8.get(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r8
            r18 = r4
            int r4 = r8.f16mX
            int r20 = r8.getWidth()
            int r4 = r20 + r4
            int r9 = java.lang.Math.max(r9, r4)
            int r4 = r8.f17mY
            int r8 = r8.getHeight()
            int r8 = r8 + r4
            int r12 = java.lang.Math.max(r12, r8)
            int r0 = r0 + 1
            r4 = r18
            r8 = 8
            goto L_0x01e3
        L_0x020d:
            r18 = r4
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r9)
            int r4 = r1.mMinHeight
            int r4 = java.lang.Math.max(r4, r12)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r8) goto L_0x0233
            int r8 = r21.getWidth()
            if (r8 >= r0) goto L_0x0233
            r1.setWidth(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r17 = 1
            goto L_0x0234
        L_0x0233:
            r0 = 0
        L_0x0234:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r10 != r8) goto L_0x024f
            int r8 = r21.getHeight()
            if (r8 >= r4) goto L_0x024f
            r1.setHeight(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r17 = 1
            goto L_0x024f
        L_0x024c:
            r18 = r4
            r0 = 0
        L_0x024f:
            int r4 = r1.mMinWidth
            int r8 = r21.getWidth()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.getWidth()
            if (r4 <= r8) goto L_0x026c
            r1.setWidth(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 0
            r0[r8] = r4
            r0 = 1
            r17 = 1
        L_0x026c:
            int r4 = r1.mMinHeight
            int r8 = r21.getHeight()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.getHeight()
            if (r4 <= r8) goto L_0x0289
            r1.setHeight(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x028c
        L_0x0289:
            r8 = 1
            r9 = r17
        L_0x028c:
            if (r9 != 0) goto L_0x02cb
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            r12 = 0
            r4 = r4[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r12) goto L_0x02ad
            if (r5 <= 0) goto L_0x02ad
            int r4 = r21.getWidth()
            if (r4 <= r5) goto L_0x02ad
            r1.mWidthMeasuredTooSmall = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = 0
            r0[r9] = r4
            r1.setWidth(r5)
            r0 = 1
            r9 = 1
        L_0x02ad:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            r4 = r4[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r12) goto L_0x02cb
            if (r6 <= 0) goto L_0x02cb
            int r4 = r21.getHeight()
            if (r4 <= r6) goto L_0x02cb
            r1.mHeightMeasuredTooSmall = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r4
            r1.setHeight(r6)
            r4 = 1
            r8 = 1
            goto L_0x02cd
        L_0x02cb:
            r8 = r0
            r4 = r9
        L_0x02cd:
            r0 = r18
            r12 = r19
            goto L_0x011a
        L_0x02d3:
            r19 = r12
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            java.lang.Object r0 = r0.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r0 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r0
            r0.updateUnresolvedWidgets()
            r0 = r17
        L_0x02e2:
            int r15 = r15 + 1
            r12 = r19
            r4 = 0
            r7 = 32
            r8 = 8
            r9 = 1
            goto L_0x00ae
        L_0x02ee:
            r1.mChildren = r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mParent
            if (r4 == 0) goto L_0x0320
            int r2 = r1.mMinWidth
            int r3 = r21.getWidth()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.mMinHeight
            int r4 = r21.getHeight()
            int r3 = java.lang.Math.max(r3, r4)
            androidx.constraintlayout.solver.widgets.Snapshot r4 = r1.mSnapshot
            r4.applyTo(r1)
            int r4 = r1.mPaddingLeft
            int r2 = r2 + r4
            int r4 = r1.mPaddingRight
            int r2 = r2 + r4
            r1.setWidth(r2)
            int r2 = r1.mPaddingTop
            int r3 = r3 + r2
            int r2 = r1.mPaddingBottom
            int r3 = r3 + r2
            r1.setHeight(r3)
            goto L_0x0324
        L_0x0320:
            r1.f16mX = r2
            r1.f17mY = r3
        L_0x0324:
            if (r0 == 0) goto L_0x032e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r2 = 0
            r0[r2] = r11
            r2 = 1
            r0[r2] = r10
        L_0x032e:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            androidx.constraintlayout.solver.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r0 = r21.getRootConstraintContainer()
            if (r1 != r0) goto L_0x0340
            r21.updateDrawPosition()
        L_0x0340:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    public void optimizeForDimensions(int i, int i2) {
        ResolutionDimension resolutionDimension;
        ResolutionDimension resolutionDimension2;
        if (!(this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (resolutionDimension2 = this.mResolutionWidth) == null)) {
            resolutionDimension2.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (resolutionDimension = this.mResolutionHeight) != null) {
            resolutionDimension.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetResolutionNodes();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }
}
