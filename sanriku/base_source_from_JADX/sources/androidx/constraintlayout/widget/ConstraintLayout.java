package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean CACHE_MEASURED_DIMENSION = false;
    private static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    private boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOptimizationLevel = 7;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>(100);

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        int dimensionRatioSide = 1;
        float dimensionRatioValue = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        boolean isGuideline = false;
        boolean isHelper = false;
        boolean isInPlaceholder = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        boolean needsBaseline = false;
        public int orientation = -1;
        int resolveGoneLeftMargin = -1;
        int resolveGoneRightMargin = -1;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias = 0.5f;
        int resolvedLeftToLeft = -1;
        int resolvedLeftToRight = -1;
        int resolvedRightToLeft = -1;
        int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        ConstraintWidget widget = new ConstraintWidget();

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(C0185R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(C0185R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }

            private Table() {
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0211, code lost:
            android.util.Log.e(androidx.constraintlayout.widget.ConstraintLayout.TAG, r4);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams(android.content.Context r10, android.util.AttributeSet r11) {
            /*
                r9 = this;
                r9.<init>(r10, r11)
                r0 = -1
                r9.guideBegin = r0
                r9.guideEnd = r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r9.guidePercent = r1
                r9.leftToLeft = r0
                r9.leftToRight = r0
                r9.rightToLeft = r0
                r9.rightToRight = r0
                r9.topToTop = r0
                r9.topToBottom = r0
                r9.bottomToTop = r0
                r9.bottomToBottom = r0
                r9.baselineToBaseline = r0
                r9.circleConstraint = r0
                r2 = 0
                r9.circleRadius = r2
                r3 = 0
                r9.circleAngle = r3
                r9.startToEnd = r0
                r9.startToStart = r0
                r9.endToStart = r0
                r9.endToEnd = r0
                r9.goneLeftMargin = r0
                r9.goneTopMargin = r0
                r9.goneRightMargin = r0
                r9.goneBottomMargin = r0
                r9.goneStartMargin = r0
                r9.goneEndMargin = r0
                r4 = 1056964608(0x3f000000, float:0.5)
                r9.horizontalBias = r4
                r9.verticalBias = r4
                r5 = 0
                r9.dimensionRatio = r5
                r9.dimensionRatioValue = r3
                r5 = 1
                r9.dimensionRatioSide = r5
                r9.horizontalWeight = r1
                r9.verticalWeight = r1
                r9.horizontalChainStyle = r2
                r9.verticalChainStyle = r2
                r9.matchConstraintDefaultWidth = r2
                r9.matchConstraintDefaultHeight = r2
                r9.matchConstraintMinWidth = r2
                r9.matchConstraintMinHeight = r2
                r9.matchConstraintMaxWidth = r2
                r9.matchConstraintMaxHeight = r2
                r1 = 1065353216(0x3f800000, float:1.0)
                r9.matchConstraintPercentWidth = r1
                r9.matchConstraintPercentHeight = r1
                r9.editorAbsoluteX = r0
                r9.editorAbsoluteY = r0
                r9.orientation = r0
                r9.constrainedWidth = r2
                r9.constrainedHeight = r2
                r9.horizontalDimensionFixed = r5
                r9.verticalDimensionFixed = r5
                r9.needsBaseline = r2
                r9.isGuideline = r2
                r9.isHelper = r2
                r9.isInPlaceholder = r2
                r9.resolvedLeftToLeft = r0
                r9.resolvedLeftToRight = r0
                r9.resolvedRightToLeft = r0
                r9.resolvedRightToRight = r0
                r9.resolveGoneLeftMargin = r0
                r9.resolveGoneRightMargin = r0
                r9.resolvedHorizontalBias = r4
                androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = new androidx.constraintlayout.solver.widgets.ConstraintWidget
                r1.<init>()
                r9.widget = r1
                r9.helped = r2
                int[] r1 = androidx.constraintlayout.widget.C0185R.styleable.ConstraintLayout_Layout
                android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r1)
                int r11 = r10.getIndexCount()
                r1 = 0
            L_0x009a:
                if (r1 >= r11) goto L_0x03b8
                int r4 = r10.getIndex(r1)
                android.util.SparseIntArray r6 = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.Table.map
                int r6 = r6.get(r4)
                java.lang.String r7 = "ConstraintLayout"
                r8 = -2
                switch(r6) {
                    case 1: goto L_0x03ac;
                    case 2: goto L_0x039b;
                    case 3: goto L_0x0392;
                    case 4: goto L_0x037d;
                    case 5: goto L_0x0374;
                    case 6: goto L_0x036b;
                    case 7: goto L_0x0362;
                    case 8: goto L_0x0351;
                    case 9: goto L_0x0340;
                    case 10: goto L_0x032e;
                    case 11: goto L_0x031c;
                    case 12: goto L_0x030a;
                    case 13: goto L_0x02f8;
                    case 14: goto L_0x02e6;
                    case 15: goto L_0x02d4;
                    case 16: goto L_0x02c2;
                    case 17: goto L_0x02b0;
                    case 18: goto L_0x029e;
                    case 19: goto L_0x028c;
                    case 20: goto L_0x027a;
                    case 21: goto L_0x0270;
                    case 22: goto L_0x0266;
                    case 23: goto L_0x025c;
                    case 24: goto L_0x0252;
                    case 25: goto L_0x0248;
                    case 26: goto L_0x023e;
                    case 27: goto L_0x0234;
                    case 28: goto L_0x022a;
                    case 29: goto L_0x0220;
                    case 30: goto L_0x0216;
                    case 31: goto L_0x0207;
                    case 32: goto L_0x01fc;
                    case 33: goto L_0x01e5;
                    case 34: goto L_0x01ce;
                    case 35: goto L_0x01c0;
                    case 36: goto L_0x01a9;
                    case 37: goto L_0x0192;
                    case 38: goto L_0x0184;
                    default: goto L_0x00ac;
                }
            L_0x00ac:
                switch(r6) {
                    case 44: goto L_0x00e9;
                    case 45: goto L_0x00df;
                    case 46: goto L_0x00d5;
                    case 47: goto L_0x00cd;
                    case 48: goto L_0x00c5;
                    case 49: goto L_0x00bb;
                    case 50: goto L_0x00b1;
                    default: goto L_0x00af;
                }
            L_0x00af:
                goto L_0x03b4
            L_0x00b1:
                int r6 = r9.editorAbsoluteY
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.editorAbsoluteY = r4
                goto L_0x03b4
            L_0x00bb:
                int r6 = r9.editorAbsoluteX
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.editorAbsoluteX = r4
                goto L_0x03b4
            L_0x00c5:
                int r4 = r10.getInt(r4, r2)
                r9.verticalChainStyle = r4
                goto L_0x03b4
            L_0x00cd:
                int r4 = r10.getInt(r4, r2)
                r9.horizontalChainStyle = r4
                goto L_0x03b4
            L_0x00d5:
                float r6 = r9.verticalWeight
                float r4 = r10.getFloat(r4, r6)
                r9.verticalWeight = r4
                goto L_0x03b4
            L_0x00df:
                float r6 = r9.horizontalWeight
                float r4 = r10.getFloat(r4, r6)
                r9.horizontalWeight = r4
                goto L_0x03b4
            L_0x00e9:
                java.lang.String r4 = r10.getString(r4)
                r9.dimensionRatio = r4
                r6 = 2143289344(0x7fc00000, float:NaN)
                r9.dimensionRatioValue = r6
                r9.dimensionRatioSide = r0
                if (r4 == 0) goto L_0x03b4
                int r4 = r4.length()
                java.lang.String r6 = r9.dimensionRatio
                r7 = 44
                int r6 = r6.indexOf(r7)
                if (r6 <= 0) goto L_0x0127
                int r7 = r4 + -1
                if (r6 >= r7) goto L_0x0127
                java.lang.String r7 = r9.dimensionRatio
                java.lang.String r7 = r7.substring(r2, r6)
                java.lang.String r8 = "W"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x011a
                r9.dimensionRatioSide = r2
                goto L_0x0124
            L_0x011a:
                java.lang.String r8 = "H"
                boolean r7 = r7.equalsIgnoreCase(r8)
                if (r7 == 0) goto L_0x0124
                r9.dimensionRatioSide = r5
            L_0x0124:
                int r6 = r6 + 1
                goto L_0x0128
            L_0x0127:
                r6 = 0
            L_0x0128:
                java.lang.String r7 = r9.dimensionRatio
                r8 = 58
                int r7 = r7.indexOf(r8)
                if (r7 < 0) goto L_0x0173
                int r4 = r4 + -1
                if (r7 >= r4) goto L_0x0173
                java.lang.String r4 = r9.dimensionRatio
                java.lang.String r4 = r4.substring(r6, r7)
                java.lang.String r6 = r9.dimensionRatio
                int r7 = r7 + 1
                java.lang.String r6 = r6.substring(r7)
                int r7 = r4.length()
                if (r7 <= 0) goto L_0x03b4
                int r7 = r6.length()
                if (r7 <= 0) goto L_0x03b4
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03b4 }
                float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x03b4 }
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03b4
                int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03b4
                int r7 = r9.dimensionRatioSide     // Catch:{ NumberFormatException -> 0x03b4 }
                if (r7 != r5) goto L_0x016d
                float r6 = r6 / r4
                float r4 = java.lang.Math.abs(r6)     // Catch:{ NumberFormatException -> 0x03b4 }
            L_0x0169:
                r9.dimensionRatioValue = r4     // Catch:{ NumberFormatException -> 0x03b4 }
                goto L_0x03b4
            L_0x016d:
                float r4 = r4 / r6
                float r4 = java.lang.Math.abs(r4)     // Catch:{ NumberFormatException -> 0x03b4 }
                goto L_0x0169
            L_0x0173:
                java.lang.String r4 = r9.dimensionRatio
                java.lang.String r4 = r4.substring(r6)
                int r6 = r4.length()
                if (r6 <= 0) goto L_0x03b4
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03b4 }
                goto L_0x0169
            L_0x0184:
                float r6 = r9.matchConstraintPercentHeight
                float r4 = r10.getFloat(r4, r6)
                float r4 = java.lang.Math.max(r3, r4)
                r9.matchConstraintPercentHeight = r4
                goto L_0x03b4
            L_0x0192:
                int r6 = r9.matchConstraintMaxHeight     // Catch:{ Exception -> 0x019c }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x019c }
                r9.matchConstraintMaxHeight = r6     // Catch:{ Exception -> 0x019c }
                goto L_0x03b4
            L_0x019c:
                int r6 = r9.matchConstraintMaxHeight
                int r4 = r10.getInt(r4, r6)
                if (r4 != r8) goto L_0x03b4
                r9.matchConstraintMaxHeight = r8
                goto L_0x03b4
            L_0x01a9:
                int r6 = r9.matchConstraintMinHeight     // Catch:{ Exception -> 0x01b3 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01b3 }
                r9.matchConstraintMinHeight = r6     // Catch:{ Exception -> 0x01b3 }
                goto L_0x03b4
            L_0x01b3:
                int r6 = r9.matchConstraintMinHeight
                int r4 = r10.getInt(r4, r6)
                if (r4 != r8) goto L_0x03b4
                r9.matchConstraintMinHeight = r8
                goto L_0x03b4
            L_0x01c0:
                float r6 = r9.matchConstraintPercentWidth
                float r4 = r10.getFloat(r4, r6)
                float r4 = java.lang.Math.max(r3, r4)
                r9.matchConstraintPercentWidth = r4
                goto L_0x03b4
            L_0x01ce:
                int r6 = r9.matchConstraintMaxWidth     // Catch:{ Exception -> 0x01d8 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01d8 }
                r9.matchConstraintMaxWidth = r6     // Catch:{ Exception -> 0x01d8 }
                goto L_0x03b4
            L_0x01d8:
                int r6 = r9.matchConstraintMaxWidth
                int r4 = r10.getInt(r4, r6)
                if (r4 != r8) goto L_0x03b4
                r9.matchConstraintMaxWidth = r8
                goto L_0x03b4
            L_0x01e5:
                int r6 = r9.matchConstraintMinWidth     // Catch:{ Exception -> 0x01ef }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01ef }
                r9.matchConstraintMinWidth = r6     // Catch:{ Exception -> 0x01ef }
                goto L_0x03b4
            L_0x01ef:
                int r6 = r9.matchConstraintMinWidth
                int r4 = r10.getInt(r4, r6)
                if (r4 != r8) goto L_0x03b4
                r9.matchConstraintMinWidth = r8
                goto L_0x03b4
            L_0x01fc:
                int r4 = r10.getInt(r4, r2)
                r9.matchConstraintDefaultHeight = r4
                if (r4 != r5) goto L_0x03b4
                java.lang.String r4 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
                goto L_0x0211
            L_0x0207:
                int r4 = r10.getInt(r4, r2)
                r9.matchConstraintDefaultWidth = r4
                if (r4 != r5) goto L_0x03b4
                java.lang.String r4 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
            L_0x0211:
                android.util.Log.e(r7, r4)
                goto L_0x03b4
            L_0x0216:
                float r6 = r9.verticalBias
                float r4 = r10.getFloat(r4, r6)
                r9.verticalBias = r4
                goto L_0x03b4
            L_0x0220:
                float r6 = r9.horizontalBias
                float r4 = r10.getFloat(r4, r6)
                r9.horizontalBias = r4
                goto L_0x03b4
            L_0x022a:
                boolean r6 = r9.constrainedHeight
                boolean r4 = r10.getBoolean(r4, r6)
                r9.constrainedHeight = r4
                goto L_0x03b4
            L_0x0234:
                boolean r6 = r9.constrainedWidth
                boolean r4 = r10.getBoolean(r4, r6)
                r9.constrainedWidth = r4
                goto L_0x03b4
            L_0x023e:
                int r6 = r9.goneEndMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneEndMargin = r4
                goto L_0x03b4
            L_0x0248:
                int r6 = r9.goneStartMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneStartMargin = r4
                goto L_0x03b4
            L_0x0252:
                int r6 = r9.goneBottomMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneBottomMargin = r4
                goto L_0x03b4
            L_0x025c:
                int r6 = r9.goneRightMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneRightMargin = r4
                goto L_0x03b4
            L_0x0266:
                int r6 = r9.goneTopMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneTopMargin = r4
                goto L_0x03b4
            L_0x0270:
                int r6 = r9.goneLeftMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneLeftMargin = r4
                goto L_0x03b4
            L_0x027a:
                int r6 = r9.endToEnd
                int r6 = r10.getResourceId(r4, r6)
                r9.endToEnd = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.endToEnd = r4
                goto L_0x03b4
            L_0x028c:
                int r6 = r9.endToStart
                int r6 = r10.getResourceId(r4, r6)
                r9.endToStart = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.endToStart = r4
                goto L_0x03b4
            L_0x029e:
                int r6 = r9.startToStart
                int r6 = r10.getResourceId(r4, r6)
                r9.startToStart = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.startToStart = r4
                goto L_0x03b4
            L_0x02b0:
                int r6 = r9.startToEnd
                int r6 = r10.getResourceId(r4, r6)
                r9.startToEnd = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.startToEnd = r4
                goto L_0x03b4
            L_0x02c2:
                int r6 = r9.baselineToBaseline
                int r6 = r10.getResourceId(r4, r6)
                r9.baselineToBaseline = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.baselineToBaseline = r4
                goto L_0x03b4
            L_0x02d4:
                int r6 = r9.bottomToBottom
                int r6 = r10.getResourceId(r4, r6)
                r9.bottomToBottom = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.bottomToBottom = r4
                goto L_0x03b4
            L_0x02e6:
                int r6 = r9.bottomToTop
                int r6 = r10.getResourceId(r4, r6)
                r9.bottomToTop = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.bottomToTop = r4
                goto L_0x03b4
            L_0x02f8:
                int r6 = r9.topToBottom
                int r6 = r10.getResourceId(r4, r6)
                r9.topToBottom = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.topToBottom = r4
                goto L_0x03b4
            L_0x030a:
                int r6 = r9.topToTop
                int r6 = r10.getResourceId(r4, r6)
                r9.topToTop = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.topToTop = r4
                goto L_0x03b4
            L_0x031c:
                int r6 = r9.rightToRight
                int r6 = r10.getResourceId(r4, r6)
                r9.rightToRight = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.rightToRight = r4
                goto L_0x03b4
            L_0x032e:
                int r6 = r9.rightToLeft
                int r6 = r10.getResourceId(r4, r6)
                r9.rightToLeft = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.rightToLeft = r4
                goto L_0x03b4
            L_0x0340:
                int r6 = r9.leftToRight
                int r6 = r10.getResourceId(r4, r6)
                r9.leftToRight = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.leftToRight = r4
                goto L_0x03b4
            L_0x0351:
                int r6 = r9.leftToLeft
                int r6 = r10.getResourceId(r4, r6)
                r9.leftToLeft = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.leftToLeft = r4
                goto L_0x03b4
            L_0x0362:
                float r6 = r9.guidePercent
                float r4 = r10.getFloat(r4, r6)
                r9.guidePercent = r4
                goto L_0x03b4
            L_0x036b:
                int r6 = r9.guideEnd
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.guideEnd = r4
                goto L_0x03b4
            L_0x0374:
                int r6 = r9.guideBegin
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.guideBegin = r4
                goto L_0x03b4
            L_0x037d:
                float r6 = r9.circleAngle
                float r4 = r10.getFloat(r4, r6)
                r6 = 1135869952(0x43b40000, float:360.0)
                float r4 = r4 % r6
                r9.circleAngle = r4
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 >= 0) goto L_0x03b4
                float r4 = r6 - r4
                float r4 = r4 % r6
                r9.circleAngle = r4
                goto L_0x03b4
            L_0x0392:
                int r6 = r9.circleRadius
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.circleRadius = r4
                goto L_0x03b4
            L_0x039b:
                int r6 = r9.circleConstraint
                int r6 = r10.getResourceId(r4, r6)
                r9.circleConstraint = r6
                if (r6 != r0) goto L_0x03b4
                int r4 = r10.getInt(r4, r0)
                r9.circleConstraint = r4
                goto L_0x03b4
            L_0x03ac:
                int r6 = r9.orientation
                int r4 = r10.getInt(r4, r6)
                r9.orientation = r4
            L_0x03b4:
                int r1 = r1 + 1
                goto L_0x009a
            L_0x03b8:
                r10.recycle()
                r9.validate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.widget = layoutParams.widget;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d6, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00e5, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.resolvedRightToLeft = r7
                r6.resolvedRightToRight = r7
                r6.resolvedLeftToLeft = r7
                r6.resolvedLeftToRight = r7
                r6.resolveGoneLeftMargin = r7
                r6.resolveGoneRightMargin = r7
                int r2 = r6.goneLeftMargin
                r6.resolveGoneLeftMargin = r2
                int r2 = r6.goneRightMargin
                r6.resolveGoneRightMargin = r2
                float r2 = r6.horizontalBias
                r6.resolvedHorizontalBias = r2
                int r2 = r6.guideBegin
                r6.resolvedGuideBegin = r2
                int r2 = r6.guideEnd
                r6.resolvedGuideEnd = r2
                float r2 = r6.guidePercent
                r6.resolvedGuidePercent = r2
                int r2 = r6.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0036
                r2 = 1
                goto L_0x0037
            L_0x0036:
                r2 = 0
            L_0x0037:
                if (r2 == 0) goto L_0x0098
                int r2 = r6.startToEnd
                if (r2 == r7) goto L_0x0041
                r6.resolvedRightToLeft = r2
            L_0x003f:
                r3 = 1
                goto L_0x0048
            L_0x0041:
                int r2 = r6.startToStart
                if (r2 == r7) goto L_0x0048
                r6.resolvedRightToRight = r2
                goto L_0x003f
            L_0x0048:
                int r2 = r6.endToStart
                if (r2 == r7) goto L_0x004f
                r6.resolvedLeftToRight = r2
                r3 = 1
            L_0x004f:
                int r2 = r6.endToEnd
                if (r2 == r7) goto L_0x0056
                r6.resolvedLeftToLeft = r2
                r3 = 1
            L_0x0056:
                int r2 = r6.goneStartMargin
                if (r2 == r7) goto L_0x005c
                r6.resolveGoneRightMargin = r2
            L_0x005c:
                int r2 = r6.goneEndMargin
                if (r2 == r7) goto L_0x0062
                r6.resolveGoneLeftMargin = r2
            L_0x0062:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x006c
                float r3 = r6.horizontalBias
                float r3 = r2 - r3
                r6.resolvedHorizontalBias = r3
            L_0x006c:
                boolean r3 = r6.isGuideline
                if (r3 == 0) goto L_0x00bc
                int r3 = r6.orientation
                if (r3 != r4) goto L_0x00bc
                float r3 = r6.guidePercent
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x0084
                float r2 = r2 - r3
                r6.resolvedGuidePercent = r2
                r6.resolvedGuideBegin = r7
                r6.resolvedGuideEnd = r7
                goto L_0x00bc
            L_0x0084:
                int r2 = r6.guideBegin
                if (r2 == r7) goto L_0x008f
                r6.resolvedGuideEnd = r2
                r6.resolvedGuideBegin = r7
            L_0x008c:
                r6.resolvedGuidePercent = r4
                goto L_0x00bc
            L_0x008f:
                int r2 = r6.guideEnd
                if (r2 == r7) goto L_0x00bc
                r6.resolvedGuideBegin = r2
                r6.resolvedGuideEnd = r7
                goto L_0x008c
            L_0x0098:
                int r2 = r6.startToEnd
                if (r2 == r7) goto L_0x009e
                r6.resolvedLeftToRight = r2
            L_0x009e:
                int r2 = r6.startToStart
                if (r2 == r7) goto L_0x00a4
                r6.resolvedLeftToLeft = r2
            L_0x00a4:
                int r2 = r6.endToStart
                if (r2 == r7) goto L_0x00aa
                r6.resolvedRightToLeft = r2
            L_0x00aa:
                int r2 = r6.endToEnd
                if (r2 == r7) goto L_0x00b0
                r6.resolvedRightToRight = r2
            L_0x00b0:
                int r2 = r6.goneStartMargin
                if (r2 == r7) goto L_0x00b6
                r6.resolveGoneLeftMargin = r2
            L_0x00b6:
                int r2 = r6.goneEndMargin
                if (r2 == r7) goto L_0x00bc
                r6.resolveGoneRightMargin = r2
            L_0x00bc:
                int r2 = r6.endToStart
                if (r2 != r7) goto L_0x0104
                int r2 = r6.endToEnd
                if (r2 != r7) goto L_0x0104
                int r2 = r6.startToStart
                if (r2 != r7) goto L_0x0104
                int r2 = r6.startToEnd
                if (r2 != r7) goto L_0x0104
                int r2 = r6.rightToLeft
                if (r2 == r7) goto L_0x00db
                r6.resolvedRightToLeft = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e8
                if (r1 <= 0) goto L_0x00e8
            L_0x00d8:
                r6.rightMargin = r1
                goto L_0x00e8
            L_0x00db:
                int r2 = r6.rightToRight
                if (r2 == r7) goto L_0x00e8
                r6.resolvedRightToRight = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e8
                if (r1 <= 0) goto L_0x00e8
                goto L_0x00d8
            L_0x00e8:
                int r1 = r6.leftToLeft
                if (r1 == r7) goto L_0x00f7
                r6.resolvedLeftToLeft = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
            L_0x00f4:
                r6.leftMargin = r0
                goto L_0x0104
            L_0x00f7:
                int r1 = r6.leftToRight
                if (r1 == r7) goto L_0x0104
                r6.resolvedLeftToRight = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
                goto L_0x00f4
            L_0x0104:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                this.matchConstraintDefaultWidth = 1;
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                this.matchConstraintDefaultHeight = 1;
            }
            int i = this.width;
            if (i == 0 || i == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            int i2 = this.height;
            if (i2 == 0 || i2 == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0185R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0185R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == C0185R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == C0185R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == C0185R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == C0185R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == C0185R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void internalMeasureChildren(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (!layoutParams.isGuideline && !layoutParams.isHelper) {
                    constraintWidget.setVisibility(childAt.getVisibility());
                    int i8 = layoutParams.width;
                    int i9 = layoutParams.height;
                    boolean z3 = layoutParams.horizontalDimensionFixed;
                    if (z3 || layoutParams.verticalDimensionFixed || (!z3 && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
                        if (i8 == 0) {
                            i3 = ViewGroup.getChildMeasureSpec(i5, paddingRight, -2);
                            z2 = true;
                        } else if (i8 == -1) {
                            i3 = ViewGroup.getChildMeasureSpec(i5, paddingRight, -1);
                            z2 = false;
                        } else {
                            z2 = i8 == -2;
                            i3 = ViewGroup.getChildMeasureSpec(i5, paddingRight, i8);
                        }
                        if (i9 == 0) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingBottom, -2);
                            z = true;
                        } else if (i9 == -1) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingBottom, -1);
                            z = false;
                        } else {
                            z = i9 == -2;
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingBottom, i9);
                        }
                        childAt.measure(i3, i4);
                        Metrics metrics = this.mMetrics;
                        if (metrics != null) {
                            metrics.measures++;
                        }
                        constraintWidget.setWidthWrapContent(i8 == -2);
                        constraintWidget.setHeightWrapContent(i9 == -2);
                        i8 = childAt.getMeasuredWidth();
                        i9 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    constraintWidget.setWidth(i8);
                    constraintWidget.setHeight(i9);
                    if (z2) {
                        constraintWidget.setWrapWidth(i8);
                    }
                    if (z) {
                        constraintWidget.setWrapHeight(i9);
                    }
                    if (layoutParams.needsBaseline && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.setBaselineDistance(baseline);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void internalMeasureDimensions(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            int r4 = r4 + r3
            int r3 = r23.getPaddingLeft()
            int r5 = r23.getPaddingRight()
            int r5 = r5 + r3
            int r3 = r23.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r3) goto L_0x00d9
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0030
            goto L_0x00d1
        L_0x0030:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = r10.widget
            boolean r6 = r10.isGuideline
            if (r6 != 0) goto L_0x00d1
            boolean r6 = r10.isHelper
            if (r6 == 0) goto L_0x0042
            goto L_0x00d1
        L_0x0042:
            int r6 = r14.getVisibility()
            r15.setVisibility(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00c3
            if (r13 != 0) goto L_0x0053
            goto L_0x00c3
        L_0x0053:
            if (r6 != r12) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r5, r6)
            if (r13 != r12) goto L_0x0063
            r17 = 1
            goto L_0x0065
        L_0x0063:
            r17 = 0
        L_0x0065:
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r2, r4, r13)
            r14.measure(r11, r12)
            androidx.constraintlayout.solver.Metrics r11 = r0.mMetrics
            if (r11 == 0) goto L_0x0075
            long r1 = r11.measures
            long r1 = r1 + r8
            r11.measures = r1
        L_0x0075:
            r1 = -2
            if (r6 != r1) goto L_0x007a
            r2 = 1
            goto L_0x007b
        L_0x007a:
            r2 = 0
        L_0x007b:
            r15.setWidthWrapContent(r2)
            if (r13 != r1) goto L_0x0082
            r13 = 1
            goto L_0x0083
        L_0x0082:
            r13 = 0
        L_0x0083:
            r15.setHeightWrapContent(r13)
            int r1 = r14.getMeasuredWidth()
            int r2 = r14.getMeasuredHeight()
            r15.setWidth(r1)
            r15.setHeight(r2)
            if (r16 == 0) goto L_0x0099
            r15.setWrapWidth(r1)
        L_0x0099:
            if (r17 == 0) goto L_0x009e
            r15.setWrapHeight(r2)
        L_0x009e:
            boolean r6 = r10.needsBaseline
            if (r6 == 0) goto L_0x00ac
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00ac
            r15.setBaselineDistance(r6)
        L_0x00ac:
            boolean r6 = r10.horizontalDimensionFixed
            if (r6 == 0) goto L_0x00d1
            boolean r6 = r10.verticalDimensionFixed
            if (r6 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r15.getResolutionWidth()
            r6.resolve(r1)
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r15.getResolutionHeight()
            r1.resolve(r2)
            goto L_0x00d1
        L_0x00c3:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r15.getResolutionWidth()
            r1.invalidate()
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r15.getResolutionHeight()
            r1.invalidate()
        L_0x00d1:
            int r7 = r7 + 1
            r1 = r24
            r2 = r25
            goto L_0x001d
        L_0x00d9:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.solveGraph()
            r1 = 0
        L_0x00df:
            if (r1 >= r3) goto L_0x02ec
            android.view.View r2 = r0.getChildAt(r1)
            int r6 = r2.getVisibility()
            if (r6 != r10) goto L_0x00ed
            goto L_0x02d2
        L_0x00ed:
            android.view.ViewGroup$LayoutParams r6 = r2.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.widget
            boolean r11 = r6.isGuideline
            if (r11 != 0) goto L_0x02d2
            boolean r11 = r6.isHelper
            if (r11 == 0) goto L_0x00ff
            goto L_0x02d2
        L_0x00ff:
            int r11 = r2.getVisibility()
            r7.setVisibility(r11)
            int r11 = r6.width
            int r12 = r6.height
            if (r11 == 0) goto L_0x0110
            if (r12 == 0) goto L_0x0110
            goto L_0x02d2
        L_0x0110:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r7.getAnchor(r13)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r13 = r13.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.getAnchor(r14)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r14 = r14.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r7.getAnchor(r15)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r15.getTarget()
            if (r15 == 0) goto L_0x013e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r7.getAnchor(r15)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r15.getTarget()
            if (r15 == 0) goto L_0x013e
            r15 = 1
            goto L_0x013f
        L_0x013e:
            r15 = 0
        L_0x013f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r7.getAnchor(r10)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r10.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.getAnchor(r8)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r7.getAnchor(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.getTarget()
            if (r9 == 0) goto L_0x016d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r7.getAnchor(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.getTarget()
            if (r9 == 0) goto L_0x016d
            r9 = 1
            goto L_0x016e
        L_0x016d:
            r9 = 0
        L_0x016e:
            if (r11 != 0) goto L_0x0186
            if (r12 != 0) goto L_0x0186
            if (r15 == 0) goto L_0x0186
            if (r9 == 0) goto L_0x0186
            r6 = r24
            r8 = r25
            r20 = r1
            r17 = r3
            r13 = r4
            r15 = r5
            r2 = -1
            r4 = -2
            r18 = 1
            goto L_0x02e0
        L_0x0186:
            r17 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.getHorizontalDimensionBehaviour()
            r20 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 == r1) goto L_0x0196
            r1 = 1
            goto L_0x0197
        L_0x0196:
            r1 = 0
        L_0x0197:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.getVerticalDimensionBehaviour()
            r21 = r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 == r6) goto L_0x01a5
            r3 = 1
            goto L_0x01a6
        L_0x01a5:
            r3 = 0
        L_0x01a6:
            if (r1 != 0) goto L_0x01af
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r7.getResolutionWidth()
            r6.invalidate()
        L_0x01af:
            if (r3 != 0) goto L_0x01b8
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r7.getResolutionHeight()
            r6.invalidate()
        L_0x01b8:
            if (r11 != 0) goto L_0x01f3
            if (r1 == 0) goto L_0x01e8
            boolean r6 = r7.isSpreadWidth()
            if (r6 == 0) goto L_0x01e8
            if (r15 == 0) goto L_0x01e8
            boolean r6 = r13.isResolved()
            if (r6 == 0) goto L_0x01e8
            boolean r6 = r14.isResolved()
            if (r6 == 0) goto L_0x01e8
            float r6 = r14.getResolvedValue()
            float r11 = r13.getResolvedValue()
            float r6 = r6 - r11
            int r11 = (int) r6
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r7.getResolutionWidth()
            r6.resolve(r11)
            r6 = r24
            int r13 = android.view.ViewGroup.getChildMeasureSpec(r6, r5, r11)
            goto L_0x01fe
        L_0x01e8:
            r6 = r24
            r13 = -2
            int r1 = android.view.ViewGroup.getChildMeasureSpec(r6, r5, r13)
            r13 = r1
            r1 = 0
            r14 = 1
            goto L_0x020e
        L_0x01f3:
            r6 = r24
            r13 = -2
            r14 = -1
            if (r11 != r14) goto L_0x0200
            int r15 = android.view.ViewGroup.getChildMeasureSpec(r6, r5, r14)
            r13 = r15
        L_0x01fe:
            r14 = 0
            goto L_0x020e
        L_0x0200:
            if (r11 != r13) goto L_0x0204
            r13 = 1
            goto L_0x0205
        L_0x0204:
            r13 = 0
        L_0x0205:
            int r14 = android.view.ViewGroup.getChildMeasureSpec(r6, r5, r11)
            r22 = r14
            r14 = r13
            r13 = r22
        L_0x020e:
            if (r12 != 0) goto L_0x0249
            if (r3 == 0) goto L_0x023e
            boolean r15 = r7.isSpreadHeight()
            if (r15 == 0) goto L_0x023e
            if (r9 == 0) goto L_0x023e
            boolean r9 = r10.isResolved()
            if (r9 == 0) goto L_0x023e
            boolean r9 = r8.isResolved()
            if (r9 == 0) goto L_0x023e
            float r8 = r8.getResolvedValue()
            float r9 = r10.getResolvedValue()
            float r8 = r8 - r9
            int r12 = (int) r8
            androidx.constraintlayout.solver.widgets.ResolutionDimension r8 = r7.getResolutionHeight()
            r8.resolve(r12)
            r8 = r25
            int r9 = android.view.ViewGroup.getChildMeasureSpec(r8, r4, r12)
            goto L_0x0254
        L_0x023e:
            r8 = r25
            r9 = -2
            int r3 = android.view.ViewGroup.getChildMeasureSpec(r8, r4, r9)
            r9 = r3
            r3 = 0
            r10 = 1
            goto L_0x0264
        L_0x0249:
            r8 = r25
            r9 = -2
            r10 = -1
            if (r12 != r10) goto L_0x0256
            int r15 = android.view.ViewGroup.getChildMeasureSpec(r8, r4, r10)
            r9 = r15
        L_0x0254:
            r10 = 0
            goto L_0x0264
        L_0x0256:
            if (r12 != r9) goto L_0x025a
            r9 = 1
            goto L_0x025b
        L_0x025a:
            r9 = 0
        L_0x025b:
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r8, r4, r12)
            r22 = r10
            r10 = r9
            r9 = r22
        L_0x0264:
            r2.measure(r13, r9)
            androidx.constraintlayout.solver.Metrics r9 = r0.mMetrics
            r13 = r4
            r15 = r5
            if (r9 == 0) goto L_0x0276
            long r4 = r9.measures
            r18 = 1
            long r4 = r4 + r18
            r9.measures = r4
            goto L_0x0278
        L_0x0276:
            r18 = 1
        L_0x0278:
            r4 = -2
            if (r11 != r4) goto L_0x027d
            r5 = 1
            goto L_0x027e
        L_0x027d:
            r5 = 0
        L_0x027e:
            r7.setWidthWrapContent(r5)
            if (r12 != r4) goto L_0x0285
            r5 = 1
            goto L_0x0286
        L_0x0285:
            r5 = 0
        L_0x0286:
            r7.setHeightWrapContent(r5)
            int r5 = r2.getMeasuredWidth()
            int r9 = r2.getMeasuredHeight()
            r7.setWidth(r5)
            r7.setHeight(r9)
            if (r14 == 0) goto L_0x029c
            r7.setWrapWidth(r5)
        L_0x029c:
            if (r10 == 0) goto L_0x02a1
            r7.setWrapHeight(r9)
        L_0x02a1:
            if (r1 == 0) goto L_0x02ab
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r7.getResolutionWidth()
            r1.resolve(r5)
            goto L_0x02b2
        L_0x02ab:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r7.getResolutionWidth()
            r1.remove()
        L_0x02b2:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r7.getResolutionHeight()
            if (r3 == 0) goto L_0x02bc
            r1.resolve(r9)
            goto L_0x02bf
        L_0x02bc:
            r1.remove()
        L_0x02bf:
            r1 = r21
            boolean r1 = r1.needsBaseline
            if (r1 == 0) goto L_0x02d0
            int r1 = r2.getBaseline()
            r2 = -1
            if (r1 == r2) goto L_0x02e0
            r7.setBaselineDistance(r1)
            goto L_0x02e0
        L_0x02d0:
            r2 = -1
            goto L_0x02e0
        L_0x02d2:
            r6 = r24
            r20 = r1
            r17 = r3
            r13 = r4
            r15 = r5
            r18 = r8
            r2 = -1
            r4 = -2
            r8 = r25
        L_0x02e0:
            int r1 = r20 + 1
            r4 = r13
            r5 = r15
            r3 = r17
            r8 = r18
            r10 = 8
            goto L_0x00df
        L_0x02ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.internalMeasureDimensions(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x035c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setChildrenConstraints() {
        /*
            r25 = this;
            r0 = r25
            boolean r1 = r25.isInEditMode()
            int r2 = r25.getChildCount()
            r3 = 0
            r4 = -1
            if (r1 == 0) goto L_0x0048
            r5 = 0
        L_0x000f:
            if (r5 >= r2) goto L_0x0048
            android.view.View r6 = r0.getChildAt(r5)
            android.content.res.Resources r7 = r25.getResources()     // Catch:{ NotFoundException -> 0x0045 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0045 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0045 }
            r0.setDesignInformation(r3, r7, r8)     // Catch:{ NotFoundException -> 0x0045 }
            r8 = 47
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0045 }
            if (r8 == r4) goto L_0x003a
            int r8 = r8 + 1
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0045 }
        L_0x003a:
            int r6 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.getTargetWidget(r6)     // Catch:{ NotFoundException -> 0x0045 }
            r6.setDebugName(r7)     // Catch:{ NotFoundException -> 0x0045 }
        L_0x0045:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x0048:
            r5 = 0
        L_0x0049:
            if (r5 >= r2) goto L_0x005c
            android.view.View r6 = r0.getChildAt(r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.getViewWidget(r6)
            if (r6 != 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            r6.reset()
        L_0x0059:
            int r5 = r5 + 1
            goto L_0x0049
        L_0x005c:
            int r5 = r0.mConstraintSetId
            if (r5 == r4) goto L_0x007e
            r5 = 0
        L_0x0061:
            if (r5 >= r2) goto L_0x007e
            android.view.View r6 = r0.getChildAt(r5)
            int r7 = r6.getId()
            int r8 = r0.mConstraintSetId
            if (r7 != r8) goto L_0x007b
            boolean r7 = r6 instanceof androidx.constraintlayout.widget.Constraints
            if (r7 == 0) goto L_0x007b
            androidx.constraintlayout.widget.Constraints r6 = (androidx.constraintlayout.widget.Constraints) r6
            androidx.constraintlayout.widget.ConstraintSet r6 = r6.getConstraintSet()
            r0.mConstraintSet = r6
        L_0x007b:
            int r5 = r5 + 1
            goto L_0x0061
        L_0x007e:
            androidx.constraintlayout.widget.ConstraintSet r5 = r0.mConstraintSet
            if (r5 == 0) goto L_0x0085
            r5.applyToInternal(r0)
        L_0x0085:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r5 = r0.mLayoutWidget
            r5.removeAllChildren()
            java.util.ArrayList<androidx.constraintlayout.widget.ConstraintHelper> r5 = r0.mConstraintHelpers
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00a3
            r6 = 0
        L_0x0093:
            if (r6 >= r5) goto L_0x00a3
            java.util.ArrayList<androidx.constraintlayout.widget.ConstraintHelper> r7 = r0.mConstraintHelpers
            java.lang.Object r7 = r7.get(r6)
            androidx.constraintlayout.widget.ConstraintHelper r7 = (androidx.constraintlayout.widget.ConstraintHelper) r7
            r7.updatePreLayout(r0)
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00a3:
            r5 = 0
        L_0x00a4:
            if (r5 >= r2) goto L_0x00b6
            android.view.View r6 = r0.getChildAt(r5)
            boolean r7 = r6 instanceof androidx.constraintlayout.widget.Placeholder
            if (r7 == 0) goto L_0x00b3
            androidx.constraintlayout.widget.Placeholder r6 = (androidx.constraintlayout.widget.Placeholder) r6
            r6.updatePreLayout(r0)
        L_0x00b3:
            int r5 = r5 + 1
            goto L_0x00a4
        L_0x00b6:
            r5 = 0
        L_0x00b7:
            if (r5 >= r2) goto L_0x038d
            android.view.View r6 = r0.getChildAt(r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r0.getViewWidget(r6)
            if (r13 != 0) goto L_0x00c5
            goto L_0x0389
        L_0x00c5:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            r14 = r7
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r14 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r14
            r14.validate()
            boolean r7 = r14.helped
            if (r7 == 0) goto L_0x00d6
            r14.helped = r3
            goto L_0x0108
        L_0x00d6:
            if (r1 == 0) goto L_0x0108
            android.content.res.Resources r7 = r25.getResources()     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0107 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0107 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0107 }
            r0.setDesignInformation(r3, r7, r8)     // Catch:{ NotFoundException -> 0x0107 }
            java.lang.String r8 = "id/"
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r8 + 3
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0107 }
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r0.getTargetWidget(r8)     // Catch:{ NotFoundException -> 0x0107 }
            r8.setDebugName(r7)     // Catch:{ NotFoundException -> 0x0107 }
            goto L_0x0108
        L_0x0107:
        L_0x0108:
            int r7 = r6.getVisibility()
            r13.setVisibility(r7)
            boolean r7 = r14.isInPlaceholder
            if (r7 == 0) goto L_0x0118
            r7 = 8
            r13.setVisibility(r7)
        L_0x0118:
            r13.setCompanionWidget(r6)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r6 = r0.mLayoutWidget
            r6.add((androidx.constraintlayout.solver.widgets.ConstraintWidget) r13)
            boolean r6 = r14.verticalDimensionFixed
            if (r6 == 0) goto L_0x0128
            boolean r6 = r14.horizontalDimensionFixed
            if (r6 != 0) goto L_0x012d
        L_0x0128:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r6 = r0.mVariableDimensionsWidgets
            r6.add(r13)
        L_0x012d:
            boolean r6 = r14.isGuideline
            if (r6 == 0) goto L_0x0152
            androidx.constraintlayout.solver.widgets.Guideline r13 = (androidx.constraintlayout.solver.widgets.Guideline) r13
            int r6 = r14.resolvedGuideBegin
            int r7 = r14.resolvedGuideEnd
            float r8 = r14.resolvedGuidePercent
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x0144
            r13.setGuidePercent((float) r8)
            goto L_0x0389
        L_0x0144:
            if (r6 == r4) goto L_0x014b
            r13.setGuideBegin(r6)
            goto L_0x0389
        L_0x014b:
            if (r7 == r4) goto L_0x0389
            r13.setGuideEnd(r7)
            goto L_0x0389
        L_0x0152:
            int r6 = r14.leftToLeft
            if (r6 != r4) goto L_0x019a
            int r6 = r14.leftToRight
            if (r6 != r4) goto L_0x019a
            int r6 = r14.rightToLeft
            if (r6 != r4) goto L_0x019a
            int r6 = r14.rightToRight
            if (r6 != r4) goto L_0x019a
            int r6 = r14.startToStart
            if (r6 != r4) goto L_0x019a
            int r6 = r14.startToEnd
            if (r6 != r4) goto L_0x019a
            int r6 = r14.endToStart
            if (r6 != r4) goto L_0x019a
            int r6 = r14.endToEnd
            if (r6 != r4) goto L_0x019a
            int r6 = r14.topToTop
            if (r6 != r4) goto L_0x019a
            int r6 = r14.topToBottom
            if (r6 != r4) goto L_0x019a
            int r6 = r14.bottomToTop
            if (r6 != r4) goto L_0x019a
            int r6 = r14.bottomToBottom
            if (r6 != r4) goto L_0x019a
            int r6 = r14.baselineToBaseline
            if (r6 != r4) goto L_0x019a
            int r6 = r14.editorAbsoluteX
            if (r6 != r4) goto L_0x019a
            int r6 = r14.editorAbsoluteY
            if (r6 != r4) goto L_0x019a
            int r6 = r14.circleConstraint
            if (r6 != r4) goto L_0x019a
            int r6 = r14.width
            if (r6 == r4) goto L_0x019a
            int r6 = r14.height
            if (r6 != r4) goto L_0x0389
        L_0x019a:
            int r6 = r14.resolvedLeftToLeft
            int r7 = r14.resolvedLeftToRight
            int r15 = r14.resolvedRightToLeft
            int r12 = r14.resolvedRightToRight
            int r11 = r14.resolveGoneLeftMargin
            int r10 = r14.resolveGoneRightMargin
            float r9 = r14.resolvedHorizontalBias
            int r8 = r14.circleConstraint
            if (r8 == r4) goto L_0x01bb
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.getTargetWidget(r8)
            if (r6 == 0) goto L_0x02dc
            float r7 = r14.circleAngle
            int r8 = r14.circleRadius
            r13.connectCircularConstraint(r6, r7, r8)
            goto L_0x02dc
        L_0x01bb:
            if (r6 == r4) goto L_0x01dd
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.getTargetWidget(r6)
            if (r6 == 0) goto L_0x01d8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r16 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            int r8 = r14.leftMargin
            r7 = r13
            r17 = r8
            r8 = r16
            r3 = r9
            r9 = r6
            r6 = r10
            r10 = r16
            r16 = r11
            r11 = r17
            r18 = r12
            goto L_0x01f2
        L_0x01d8:
            r3 = r9
            r6 = r10
            r18 = r12
            goto L_0x01f7
        L_0x01dd:
            r3 = r9
            r6 = r10
            r16 = r11
            r18 = r12
            if (r7 == r4) goto L_0x01f7
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r7)
            if (r9 == 0) goto L_0x01f7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r11 = r14.leftMargin
            r7 = r13
        L_0x01f2:
            r12 = r16
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x01f7:
            if (r15 == r4) goto L_0x0207
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r15)
            if (r9 == 0) goto L_0x021b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            int r11 = r14.rightMargin
            r7 = r13
            goto L_0x0217
        L_0x0207:
            r7 = r18
            if (r7 == r4) goto L_0x021b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r7)
            if (r9 == 0) goto L_0x021b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r11 = r14.rightMargin
            r7 = r13
            r8 = r10
        L_0x0217:
            r12 = r6
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x021b:
            int r6 = r14.topToTop
            if (r6 == r4) goto L_0x022e
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r6)
            if (r9 == 0) goto L_0x0244
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            int r11 = r14.topMargin
            int r12 = r14.goneTopMargin
            r7 = r13
            r8 = r10
            goto L_0x0241
        L_0x022e:
            int r6 = r14.topToBottom
            if (r6 == r4) goto L_0x0244
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r6)
            if (r9 == 0) goto L_0x0244
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            int r11 = r14.topMargin
            int r12 = r14.goneTopMargin
            r7 = r13
        L_0x0241:
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x0244:
            int r6 = r14.bottomToTop
            if (r6 == r4) goto L_0x0258
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r6)
            if (r9 == 0) goto L_0x026d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            int r11 = r14.bottomMargin
            int r12 = r14.goneBottomMargin
            r7 = r13
            goto L_0x026a
        L_0x0258:
            int r6 = r14.bottomToBottom
            if (r6 == r4) goto L_0x026d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r6)
            if (r9 == 0) goto L_0x026d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            int r11 = r14.bottomMargin
            int r12 = r14.goneBottomMargin
            r7 = r13
            r8 = r10
        L_0x026a:
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x026d:
            int r6 = r14.baselineToBaseline
            if (r6 == r4) goto L_0x02c1
            android.util.SparseArray<android.view.View> r7 = r0.mChildrenByIds
            java.lang.Object r6 = r7.get(r6)
            android.view.View r6 = (android.view.View) r6
            int r7 = r14.baselineToBaseline
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r0.getTargetWidget(r7)
            if (r7 == 0) goto L_0x02c1
            if (r6 == 0) goto L_0x02c1
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            boolean r8 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r8 == 0) goto L_0x02c1
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
            r8 = 1
            r14.needsBaseline = r8
            r6.needsBaseline = r8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r18 = r13.getAnchor(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r19 = r7.getAnchor(r6)
            r20 = 0
            r21 = -1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r22 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            r23 = 0
            r24 = 1
            r18.connect(r19, r20, r21, r22, r23, r24)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r13.getAnchor(r6)
            r6.reset()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r13.getAnchor(r6)
            r6.reset()
        L_0x02c1:
            r6 = 1056964608(0x3f000000, float:0.5)
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x02cf
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x02cf
            r13.setHorizontalBiasPercent(r3)
        L_0x02cf:
            float r3 = r14.verticalBias
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x02dc
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x02dc
            r13.setVerticalBiasPercent(r3)
        L_0x02dc:
            if (r1 == 0) goto L_0x02ed
            int r3 = r14.editorAbsoluteX
            if (r3 != r4) goto L_0x02e6
            int r3 = r14.editorAbsoluteY
            if (r3 == r4) goto L_0x02ed
        L_0x02e6:
            int r3 = r14.editorAbsoluteX
            int r6 = r14.editorAbsoluteY
            r13.setOrigin(r3, r6)
        L_0x02ed:
            boolean r3 = r14.horizontalDimensionFixed
            if (r3 != 0) goto L_0x0316
            int r3 = r14.width
            if (r3 != r4) goto L_0x030f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r13.setHorizontalDimensionBehaviour(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.leftMargin
            r3.mMargin = r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.rightMargin
            r3.mMargin = r6
            goto L_0x0320
        L_0x030f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r13.setHorizontalDimensionBehaviour(r3)
            r3 = 0
            goto L_0x031d
        L_0x0316:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13.setHorizontalDimensionBehaviour(r3)
            int r3 = r14.width
        L_0x031d:
            r13.setWidth(r3)
        L_0x0320:
            boolean r3 = r14.verticalDimensionFixed
            if (r3 != 0) goto L_0x034d
            int r3 = r14.height
            if (r3 != r4) goto L_0x0343
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r13.setVerticalDimensionBehaviour(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.topMargin
            r3.mMargin = r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.bottomMargin
            r3.mMargin = r6
            r3 = 0
            goto L_0x0358
        L_0x0343:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r13.setVerticalDimensionBehaviour(r3)
            r3 = 0
            r13.setHeight(r3)
            goto L_0x0358
        L_0x034d:
            r3 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13.setVerticalDimensionBehaviour(r6)
            int r6 = r14.height
            r13.setHeight(r6)
        L_0x0358:
            java.lang.String r6 = r14.dimensionRatio
            if (r6 == 0) goto L_0x035f
            r13.setDimensionRatio(r6)
        L_0x035f:
            float r6 = r14.horizontalWeight
            r13.setHorizontalWeight(r6)
            float r6 = r14.verticalWeight
            r13.setVerticalWeight(r6)
            int r6 = r14.horizontalChainStyle
            r13.setHorizontalChainStyle(r6)
            int r6 = r14.verticalChainStyle
            r13.setVerticalChainStyle(r6)
            int r6 = r14.matchConstraintDefaultWidth
            int r7 = r14.matchConstraintMinWidth
            int r8 = r14.matchConstraintMaxWidth
            float r9 = r14.matchConstraintPercentWidth
            r13.setHorizontalMatchStyle(r6, r7, r8, r9)
            int r6 = r14.matchConstraintDefaultHeight
            int r7 = r14.matchConstraintMinHeight
            int r8 = r14.matchConstraintMaxHeight
            float r9 = r14.matchConstraintPercentHeight
            r13.setVerticalMatchStyle(r6, r7, r8, r9)
        L_0x0389:
            int r5 = r5 + 1
            goto L_0x00b7
        L_0x038d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setChildrenConstraints():void");
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i3 = Math.min(this.mMaxWidth, size) - paddingRight;
                dimensionBehaviour = dimensionBehaviour2;
            }
            i3 = 0;
        } else {
            i3 = size;
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.mMaxHeight, size2) - paddingBottom;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.mLayoutWidget.setMinWidth(0);
        this.mLayoutWidget.setMinHeight(0);
        this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mLayoutWidget.setWidth(i3);
        this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
        this.mLayoutWidget.setHeight(size2);
        this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.mVariableDimensionsWidgets.clear();
            setChildrenConstraints();
        }
    }

    private void updatePostMeasures() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).updatePostMeasure(this);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f = (float) i2;
                        float f2 = (float) (i2 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f3 = (float) i3;
                        float f4 = f;
                        float f5 = f;
                        float f6 = f3;
                        Paint paint2 = paint;
                        float f7 = f2;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f4, f6, f7, f3, paint3);
                        float parseInt4 = (float) (i3 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f8 = f2;
                        float f9 = parseInt4;
                        canvas2.drawLine(f8, f6, f7, f9, paint3);
                        float f10 = parseInt4;
                        float f11 = f5;
                        canvas2.drawLine(f8, f10, f11, f9, paint3);
                        float f12 = f5;
                        canvas2.drawLine(f12, f10, f11, f3, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f13 = f2;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f12, f3, f13, parseInt4, paint6);
                        canvas2.drawLine(f12, parseInt4, f13, f3, paint6);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || isInEditMode) && !layoutParams.isInPlaceholder) {
                int drawX = constraintWidget.getDrawX();
                int drawY = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX;
                int height = constraintWidget.getHeight() + drawY;
                childAt.layout(drawX, drawY, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(drawX, drawY, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r24)
            int r4 = android.view.View.MeasureSpec.getSize(r24)
            int r5 = android.view.View.MeasureSpec.getMode(r25)
            int r6 = android.view.View.MeasureSpec.getSize(r25)
            int r7 = r23.getPaddingLeft()
            int r8 = r23.getPaddingTop()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            r9.setX(r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            r9.setY(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r0.mMaxWidth
            r9.setMaxWidth(r10)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r0.mMaxHeight
            r9.setMaxHeight(r10)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r23.getLayoutDirection()
            r11 = 0
            r12 = 1
            if (r10 != r12) goto L_0x0045
            r10 = 1
            goto L_0x0046
        L_0x0045:
            r10 = 0
        L_0x0046:
            r9.setRtl(r10)
            r23.setSelfDimensionBehaviour(r24, r25)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r9 = r9.getWidth()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r10 = r0.mLayoutWidget
            int r10 = r10.getHeight()
            boolean r13 = r0.mDirtyHierarchy
            if (r13 == 0) goto L_0x0063
            r0.mDirtyHierarchy = r11
            r23.updateHierarchy()
            r13 = 1
            goto L_0x0064
        L_0x0063:
            r13 = 0
        L_0x0064:
            int r14 = r0.mOptimizationLevel
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x006d
            r14 = 1
            goto L_0x006e
        L_0x006d:
            r14 = 0
        L_0x006e:
            if (r14 == 0) goto L_0x007e
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r15 = r0.mLayoutWidget
            r15.preOptimize()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r15 = r0.mLayoutWidget
            r15.optimizeForDimensions(r9, r10)
            r23.internalMeasureDimensions(r24, r25)
            goto L_0x0081
        L_0x007e:
            r23.internalMeasureChildren(r24, r25)
        L_0x0081:
            r23.updatePostMeasures()
            int r15 = r23.getChildCount()
            if (r15 <= 0) goto L_0x0091
            if (r13 == 0) goto L_0x0091
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.Analyzer.determineGroups(r13)
        L_0x0091:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            boolean r15 = r13.mGroupsWrapOptimized
            if (r15 == 0) goto L_0x00c3
            boolean r15 = r13.mHorizontalWrapOptimized
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r15 == 0) goto L_0x00ad
            if (r3 != r12) goto L_0x00ad
            int r15 = r13.mWrapFixedWidth
            if (r15 >= r4) goto L_0x00a6
            r13.setWidth(r15)
        L_0x00a6:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13.setHorizontalDimensionBehaviour(r15)
        L_0x00ad:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            boolean r15 = r13.mVerticalWrapOptimized
            if (r15 == 0) goto L_0x00c3
            if (r5 != r12) goto L_0x00c3
            int r12 = r13.mWrapFixedHeight
            if (r12 >= r6) goto L_0x00bc
            r13.setHeight(r12)
        L_0x00bc:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12.setVerticalDimensionBehaviour(r13)
        L_0x00c3:
            int r12 = r0.mOptimizationLevel
            r13 = 32
            r12 = r12 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 != r13) goto L_0x0117
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r12 = r12.getWidth()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getHeight()
            int r11 = r0.mLastMeasureWidth
            if (r11 == r12) goto L_0x00e6
            if (r3 != r15) goto L_0x00e6
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r11 = 0
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r11, r12)
        L_0x00e6:
            int r3 = r0.mLastMeasureHeight
            if (r3 == r13) goto L_0x00f4
            if (r5 != r15) goto L_0x00f4
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r5 = 1
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r5, r13)
        L_0x00f4:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r5 = r3.mHorizontalWrapOptimized
            if (r5 == 0) goto L_0x0105
            int r5 = r3.mWrapFixedWidth
            if (r5 <= r4) goto L_0x0105
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r11 = 0
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r11, r4)
            goto L_0x0106
        L_0x0105:
            r11 = 0
        L_0x0106:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r4 = r3.mVerticalWrapOptimized
            if (r4 == 0) goto L_0x0117
            int r4 = r3.mWrapFixedHeight
            if (r4 <= r6) goto L_0x0117
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r4 = 1
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r4, r6)
            goto L_0x0118
        L_0x0117:
            r4 = 1
        L_0x0118:
            int r3 = r23.getChildCount()
            if (r3 <= 0) goto L_0x0123
            java.lang.String r3 = "First pass"
            r0.solveLinearSystem(r3)
        L_0x0123:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r0.mVariableDimensionsWidgets
            int r3 = r3.size()
            int r5 = r23.getPaddingBottom()
            int r5 = r5 + r8
            int r6 = r23.getPaddingRight()
            int r6 = r6 + r7
            if (r3 <= 0) goto L_0x0361
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r7 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r7.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r8) goto L_0x0141
            r7 = 1
            goto L_0x0142
        L_0x0141:
            r7 = 0
        L_0x0142:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r8.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r12) goto L_0x014e
            r8 = 1
            goto L_0x014f
        L_0x014e:
            r8 = 0
        L_0x014f:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r12 = r12.getWidth()
            int r13 = r0.mMinWidth
            int r12 = java.lang.Math.max(r12, r13)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getHeight()
            int r4 = r0.mMinHeight
            int r4 = java.lang.Math.max(r13, r4)
            r16 = r12
            r12 = 0
            r13 = 0
        L_0x016b:
            r17 = 1
            if (r12 >= r3) goto L_0x02ba
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r15 = r0.mVariableDimensionsWidgets
            java.lang.Object r15 = r15.get(r12)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            java.lang.Object r19 = r15.getCompanionWidget()
            r20 = r3
            r3 = r19
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x018c
            r19 = r9
            r21 = r10
            r22 = r13
        L_0x0189:
            r9 = r5
            goto L_0x029d
        L_0x018c:
            android.view.ViewGroup$LayoutParams r19 = r3.getLayoutParams()
            r21 = r10
            r10 = r19
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r10
            r19 = r9
            boolean r9 = r10.isHelper
            if (r9 != 0) goto L_0x029a
            boolean r9 = r10.isGuideline
            if (r9 == 0) goto L_0x01a2
            goto L_0x029a
        L_0x01a2:
            int r9 = r3.getVisibility()
            r22 = r13
            r13 = 8
            if (r9 != r13) goto L_0x01ad
        L_0x01ac:
            goto L_0x0189
        L_0x01ad:
            if (r14 == 0) goto L_0x01c4
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.getResolutionWidth()
            boolean r9 = r9.isResolved()
            if (r9 == 0) goto L_0x01c4
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.getResolutionHeight()
            boolean r9 = r9.isResolved()
            if (r9 == 0) goto L_0x01c4
            goto L_0x01ac
        L_0x01c4:
            int r9 = r10.width
            r13 = -2
            if (r9 != r13) goto L_0x01d2
            boolean r13 = r10.horizontalDimensionFixed
            if (r13 == 0) goto L_0x01d2
            int r9 = android.view.ViewGroup.getChildMeasureSpec(r1, r6, r9)
            goto L_0x01dc
        L_0x01d2:
            int r9 = r15.getWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
        L_0x01dc:
            int r13 = r10.height
            r1 = -2
            if (r13 != r1) goto L_0x01ea
            boolean r1 = r10.verticalDimensionFixed
            if (r1 == 0) goto L_0x01ea
            int r1 = android.view.ViewGroup.getChildMeasureSpec(r2, r5, r13)
            goto L_0x01f4
        L_0x01ea:
            int r1 = r15.getHeight()
            r13 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r13)
        L_0x01f4:
            r3.measure(r9, r1)
            androidx.constraintlayout.solver.Metrics r1 = r0.mMetrics
            r9 = r5
            r13 = r6
            if (r1 == 0) goto L_0x0203
            long r5 = r1.additionalMeasures
            long r5 = r5 + r17
            r1.additionalMeasures = r5
        L_0x0203:
            int r1 = r3.getMeasuredWidth()
            int r5 = r3.getMeasuredHeight()
            int r6 = r15.getWidth()
            if (r1 == r6) goto L_0x0245
            r15.setWidth(r1)
            if (r14 == 0) goto L_0x021d
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r15.getResolutionWidth()
            r6.resolve(r1)
        L_0x021d:
            if (r7 == 0) goto L_0x023d
            int r1 = r15.getRight()
            r6 = r16
            if (r1 <= r6) goto L_0x023f
            int r1 = r15.getRight()
            r16 = r7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r15.getAnchor(r7)
            int r7 = r7.getMargin()
            int r7 = r7 + r1
            int r1 = java.lang.Math.max(r6, r7)
            goto L_0x0242
        L_0x023d:
            r6 = r16
        L_0x023f:
            r16 = r7
            r1 = r6
        L_0x0242:
            r22 = 1
            goto L_0x024a
        L_0x0245:
            r6 = r16
            r16 = r7
            r1 = r6
        L_0x024a:
            int r6 = r15.getHeight()
            if (r5 == r6) goto L_0x0279
            r15.setHeight(r5)
            if (r14 == 0) goto L_0x025c
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r15.getResolutionHeight()
            r6.resolve(r5)
        L_0x025c:
            if (r8 == 0) goto L_0x0277
            int r5 = r15.getBottom()
            if (r5 <= r4) goto L_0x0277
            int r5 = r15.getBottom()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r15.getAnchor(r6)
            int r6 = r6.getMargin()
            int r6 = r6 + r5
            int r4 = java.lang.Math.max(r4, r6)
        L_0x0277:
            r5 = 1
            goto L_0x027b
        L_0x0279:
            r5 = r22
        L_0x027b:
            boolean r6 = r10.needsBaseline
            if (r6 == 0) goto L_0x0290
            int r6 = r3.getBaseline()
            r7 = -1
            if (r6 == r7) goto L_0x0290
            int r7 = r15.getBaselineDistance()
            if (r6 == r7) goto L_0x0290
            r15.setBaselineDistance(r6)
            r5 = 1
        L_0x0290:
            int r3 = r3.getMeasuredState()
            int r3 = android.view.ViewGroup.combineMeasuredStates(r11, r3)
            r11 = r3
            goto L_0x02a5
        L_0x029a:
            r9 = r5
            r22 = r13
        L_0x029d:
            r13 = r6
            r6 = r16
            r16 = r7
            r1 = r6
            r5 = r22
        L_0x02a5:
            int r12 = r12 + 1
            r6 = r13
            r7 = r16
            r3 = r20
            r10 = r21
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = r1
            r13 = r5
            r5 = r9
            r9 = r19
            r1 = r24
            goto L_0x016b
        L_0x02ba:
            r20 = r3
            r19 = r9
            r21 = r10
            r22 = r13
            r9 = r5
            r13 = r6
            r6 = r16
            if (r22 == 0) goto L_0x0309
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r3 = r19
            r1.setWidth(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r3 = r21
            r1.setHeight(r3)
            if (r14 == 0) goto L_0x02dd
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.solveGraph()
        L_0x02dd:
            java.lang.String r1 = "2nd pass"
            r0.solveLinearSystem(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getWidth()
            if (r1 >= r6) goto L_0x02f1
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.setWidth(r6)
            r1 = 1
            goto L_0x02f2
        L_0x02f1:
            r1 = 0
        L_0x02f2:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.getHeight()
            if (r3 >= r4) goto L_0x0301
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.setHeight(r4)
            r12 = 1
            goto L_0x0302
        L_0x0301:
            r12 = r1
        L_0x0302:
            if (r12 == 0) goto L_0x0309
            java.lang.String r1 = "3rd pass"
            r0.solveLinearSystem(r1)
        L_0x0309:
            r3 = r20
            r1 = 0
        L_0x030c:
            if (r1 >= r3) goto L_0x0364
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r4 = r0.mVariableDimensionsWidgets
            java.lang.Object r4 = r4.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r4
            java.lang.Object r5 = r4.getCompanionWidget()
            android.view.View r5 = (android.view.View) r5
            if (r5 != 0) goto L_0x0323
        L_0x031e:
            r7 = 8
        L_0x0320:
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x035e
        L_0x0323:
            int r6 = r5.getMeasuredWidth()
            int r7 = r4.getWidth()
            if (r6 != r7) goto L_0x0337
            int r6 = r5.getMeasuredHeight()
            int r7 = r4.getHeight()
            if (r6 == r7) goto L_0x031e
        L_0x0337:
            int r6 = r4.getVisibility()
            r7 = 8
            if (r6 == r7) goto L_0x0320
            int r6 = r4.getWidth()
            r8 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r8)
            int r4 = r4.getHeight()
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r8)
            r5.measure(r6, r4)
            androidx.constraintlayout.solver.Metrics r4 = r0.mMetrics
            if (r4 == 0) goto L_0x035e
            long r5 = r4.additionalMeasures
            long r5 = r5 + r17
            r4.additionalMeasures = r5
        L_0x035e:
            int r1 = r1 + 1
            goto L_0x030c
        L_0x0361:
            r9 = r5
            r13 = r6
            r11 = 0
        L_0x0364:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getWidth()
            int r1 = r1 + r13
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.getHeight()
            int r3 = r3 + r9
            r4 = r24
            int r1 = android.view.ViewGroup.resolveSizeAndState(r1, r4, r11)
            int r4 = r11 << 16
            int r2 = android.view.ViewGroup.resolveSizeAndState(r3, r2, r4)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.mMaxWidth
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.mMaxHeight
            int r2 = java.lang.Math.min(r3, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isWidthMeasuredTooSmall()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x039a
            r1 = r1 | r4
        L_0x039a:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isHeightMeasuredTooSmall()
            if (r3 == 0) goto L_0x03a3
            r2 = r2 | r4
        L_0x03a3:
            r0.setMeasuredDimension(r1, r2)
            r0.mLastMeasureWidth = r1
            r0.mLastMeasureHeight = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.remove(viewWidget);
        this.mConstraintHelpers.remove(view);
        this.mVariableDimensionsWidgets.remove(viewWidget);
        this.mDirtyHierarchy = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void solveLinearSystem(String str) {
        this.mLayoutWidget.layout();
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.resolutions++;
        }
    }
}
