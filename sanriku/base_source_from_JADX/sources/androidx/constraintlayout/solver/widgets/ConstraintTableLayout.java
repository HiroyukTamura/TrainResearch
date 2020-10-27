package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import p009e.p010a.p011a.p012a.C0681a;

public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static final int ALIGN_CENTER = 0;
    private static final int ALIGN_FULL = 3;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList<>();
    private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList<>();
    private int mNumCols = 0;
    private int mNumRows = 0;
    private int mPadding = 8;
    private boolean mVerticalGrowth = true;
    private ArrayList<Guideline> mVerticalGuidelines = new ArrayList<>();
    private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList<>();
    private LinearSystem system = null;

    class HorizontalSlice {
        ConstraintWidget bottom;
        int padding;
        ConstraintWidget top;

        HorizontalSlice() {
        }
    }

    class VerticalSlice {
        int alignment = 1;
        ConstraintWidget left;
        int padding;
        ConstraintWidget right;

        VerticalSlice() {
        }
    }

    public ConstraintTableLayout() {
    }

    public ConstraintTableLayout(int i, int i2) {
        super(i, i2);
    }

    public ConstraintTableLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setChildrenConnections() {
        /*
            r11 = this;
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r11.mChildren
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x00d5
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r11.mChildren
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            int r4 = r3.getContainerItemSkip()
            int r4 = r4 + r2
            int r2 = r11.mNumCols
            int r5 = r4 % r2
            int r2 = r4 / r2
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintTableLayout$HorizontalSlice> r6 = r11.mHorizontalSlices
            java.lang.Object r2 = r6.get(r2)
            androidx.constraintlayout.solver.widgets.ConstraintTableLayout$HorizontalSlice r2 = (androidx.constraintlayout.solver.widgets.ConstraintTableLayout.HorizontalSlice) r2
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintTableLayout$VerticalSlice> r6 = r11.mVerticalSlices
            java.lang.Object r5 = r6.get(r5)
            androidx.constraintlayout.solver.widgets.ConstraintTableLayout$VerticalSlice r5 = (androidx.constraintlayout.solver.widgets.ConstraintTableLayout.VerticalSlice) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r5.left
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r5.right
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r2.top
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.bottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r3.getAnchor(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.getAnchor(r10)
            int r10 = r11.mPadding
            r9.connect(r6, r10)
            boolean r6 = r7 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r6 == 0) goto L_0x0053
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.getAnchor(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            goto L_0x005b
        L_0x0053:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.getAnchor(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
        L_0x005b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.getAnchor(r9)
            int r9 = r11.mPadding
            r6.connect(r7, r9)
            int r5 = r5.alignment
            r6 = 1
            if (r5 == r6) goto L_0x008a
            r6 = 2
            if (r5 == r6) goto L_0x0076
            r6 = 3
            if (r5 == r6) goto L_0x0070
            goto L_0x00a0
        L_0x0070:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r3.setHorizontalDimensionBehaviour(r5)
            goto L_0x00a0
        L_0x0076:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
            r5.setStrength(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            goto L_0x009d
        L_0x008a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            r5.setStrength(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
        L_0x009d:
            r5.setStrength(r6)
        L_0x00a0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.getAnchor(r6)
            int r7 = r11.mPadding
            r5.connect(r6, r7)
            boolean r5 = r2 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r5 == 0) goto L_0x00be
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            goto L_0x00c6
        L_0x00be:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x00c6:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.getAnchor(r5)
            int r5 = r11.mPadding
            r3.connect(r2, r5)
            int r2 = r4 + 1
            int r1 = r1 + 1
            goto L_0x0008
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintTableLayout.setChildrenConnections():void");
    }

    private void setHorizontalSlices() {
        this.mHorizontalSlices.clear();
        float f = 100.0f / ((float) this.mNumRows);
        ConstraintWidget constraintWidget = this;
        float f2 = f;
        for (int i = 0; i < this.mNumRows; i++) {
            HorizontalSlice horizontalSlice = new HorizontalSlice();
            horizontalSlice.top = constraintWidget;
            if (i < this.mNumRows - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(0);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f2);
                f2 += f;
                horizontalSlice.bottom = guideline;
                this.mHorizontalGuidelines.add(guideline);
            } else {
                horizontalSlice.bottom = this;
            }
            constraintWidget = horizontalSlice.bottom;
            this.mHorizontalSlices.add(horizontalSlice);
        }
        updateDebugSolverNames();
    }

    private void setVerticalSlices() {
        this.mVerticalSlices.clear();
        float f = 100.0f / ((float) this.mNumCols);
        ConstraintWidget constraintWidget = this;
        float f2 = f;
        for (int i = 0; i < this.mNumCols; i++) {
            VerticalSlice verticalSlice = new VerticalSlice();
            verticalSlice.left = constraintWidget;
            if (i < this.mNumCols - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(1);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f2);
                f2 += f;
                verticalSlice.right = guideline;
                this.mVerticalGuidelines.add(guideline);
            } else {
                verticalSlice.right = this;
            }
            constraintWidget = verticalSlice.right;
            this.mVerticalSlices.add(verticalSlice);
        }
        updateDebugSolverNames();
    }

    private void updateDebugSolverNames() {
        if (this.system != null) {
            int size = this.mVerticalGuidelines.size();
            for (int i = 0; i < size; i++) {
                LinearSystem linearSystem = this.system;
                this.mVerticalGuidelines.get(i).setDebugSolverName(linearSystem, getDebugName() + ".VG" + i);
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i2 = 0; i2 < size2; i2++) {
                LinearSystem linearSystem2 = this.system;
                this.mHorizontalGuidelines.get(i2).setDebugSolverName(linearSystem2, getDebugName() + ".HG" + i2);
            }
        }
    }

    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        int size = this.mChildren.size();
        if (size != 0) {
            setTableDimensions();
            if (linearSystem == this.mSystem) {
                int size2 = this.mVerticalGuidelines.size();
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i >= size2) {
                        break;
                    }
                    Guideline guideline = this.mVerticalGuidelines.get(i);
                    if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        z = false;
                    }
                    guideline.setPositionRelaxed(z);
                    guideline.addToSolver(linearSystem);
                    i++;
                }
                int size3 = this.mHorizontalGuidelines.size();
                for (int i2 = 0; i2 < size3; i2++) {
                    Guideline guideline2 = this.mHorizontalGuidelines.get(i2);
                    guideline2.setPositionRelaxed(getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    guideline2.addToSolver(linearSystem);
                }
                for (int i3 = 0; i3 < size; i3++) {
                    this.mChildren.get(i3).addToSolver(linearSystem);
                }
            }
        }
    }

    public void computeGuidelinesPercentPositions() {
        int size = this.mVerticalGuidelines.size();
        for (int i = 0; i < size; i++) {
            this.mVerticalGuidelines.get(i).inferRelativePercentPosition();
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.mHorizontalGuidelines.get(i2).inferRelativePercentPosition();
        }
    }

    public void cycleColumnAlignment(int i) {
        VerticalSlice verticalSlice = this.mVerticalSlices.get(i);
        int i2 = verticalSlice.alignment;
        if (i2 == 0) {
            verticalSlice.alignment = 2;
        } else if (i2 == 1) {
            verticalSlice.alignment = 0;
        } else if (i2 == 2) {
            verticalSlice.alignment = 1;
        }
        setChildrenConnections();
    }

    public String getColumnAlignmentRepresentation(int i) {
        int i2 = this.mVerticalSlices.get(i).alignment;
        return i2 == 1 ? "L" : i2 == 0 ? "C" : i2 == 3 ? "F" : i2 == 2 ? "R" : "!";
    }

    public String getColumnsAlignmentRepresentation() {
        String str;
        StringBuilder sb;
        int size = this.mVerticalSlices.size();
        String str2 = "";
        for (int i = 0; i < size; i++) {
            int i2 = this.mVerticalSlices.get(i).alignment;
            if (i2 == 1) {
                sb = C0681a.m330a(str2);
                str = "L";
            } else if (i2 == 0) {
                sb = C0681a.m330a(str2);
                str = "C";
            } else if (i2 == 3) {
                sb = C0681a.m330a(str2);
                str = "F";
            } else if (i2 == 2) {
                sb = C0681a.m330a(str2);
                str = "R";
            }
            sb.append(str);
            str2 = sb.toString();
        }
        return str2;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        return this.mHorizontalGuidelines;
    }

    public int getNumCols() {
        return this.mNumCols;
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public int getPadding() {
        return this.mPadding;
    }

    public String getType() {
        return "ConstraintTableLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        return this.mVerticalGuidelines;
    }

    public boolean handlesInternalConstraints() {
        return true;
    }

    public boolean isVerticalGrowth() {
        return this.mVerticalGrowth;
    }

    public void setColumnAlignment(int i, int i2) {
        if (i < this.mVerticalSlices.size()) {
            this.mVerticalSlices.get(i).alignment = i2;
            setChildrenConnections();
        }
    }

    public void setColumnAlignment(String str) {
        int i;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 'L') {
                i = 1;
            } else {
                if (charAt != 'C') {
                    if (charAt == 'F') {
                        i = 3;
                    } else if (charAt == 'R') {
                        i = 2;
                    }
                }
                setColumnAlignment(i2, 0);
            }
            setColumnAlignment(i2, i);
        }
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.system = linearSystem;
        super.setDebugSolverName(linearSystem, str);
        updateDebugSolverNames();
    }

    public void setNumCols(int i) {
        if (this.mVerticalGrowth && this.mNumCols != i) {
            this.mNumCols = i;
            setVerticalSlices();
            setTableDimensions();
        }
    }

    public void setNumRows(int i) {
        if (!this.mVerticalGrowth && this.mNumCols != i) {
            this.mNumRows = i;
            setHorizontalSlices();
            setTableDimensions();
        }
    }

    public void setPadding(int i) {
        if (i > 1) {
            this.mPadding = i;
        }
    }

    public void setTableDimensions() {
        int size = this.mChildren.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mChildren.get(i2).getContainerItemSkip();
        }
        int i3 = size + i;
        if (this.mVerticalGrowth) {
            if (this.mNumCols == 0) {
                setNumCols(1);
            }
            int i4 = this.mNumCols;
            int i5 = i3 / i4;
            if (i4 * i5 < i3) {
                i5++;
            }
            if (this.mNumRows != i5 || this.mVerticalGuidelines.size() != this.mNumCols - 1) {
                this.mNumRows = i5;
                setHorizontalSlices();
            } else {
                return;
            }
        } else {
            if (this.mNumRows == 0) {
                setNumRows(1);
            }
            int i6 = this.mNumRows;
            int i7 = i3 / i6;
            if (i6 * i7 < i3) {
                i7++;
            }
            if (this.mNumCols != i7 || this.mHorizontalGuidelines.size() != this.mNumRows - 1) {
                this.mNumCols = i7;
                setVerticalSlices();
            } else {
                return;
            }
        }
        setChildrenConnections();
    }

    public void setVerticalGrowth(boolean z) {
        this.mVerticalGrowth = z;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        super.updateFromSolver(linearSystem);
        if (linearSystem == this.mSystem) {
            int size = this.mVerticalGuidelines.size();
            for (int i = 0; i < size; i++) {
                this.mVerticalGuidelines.get(i).updateFromSolver(linearSystem);
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mHorizontalGuidelines.get(i2).updateFromSolver(linearSystem);
            }
        }
    }
}
