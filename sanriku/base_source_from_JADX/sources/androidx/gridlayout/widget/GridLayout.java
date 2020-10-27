package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.gridlayout.C0310R;
import androidx.legacy.widget.Space;
import com.google.android.gms.fitness.data.WorkoutExercises;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public class GridLayout extends ViewGroup {
    private static final int ALIGNMENT_MODE = C0310R.styleable.GridLayout_alignmentMode;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            if (baseline == -1) {
                return Integer.MIN_VALUE;
            }
            return baseline;
        }

        public Bounds getBounds() {
            return new Bounds() {
                private int size;

                /* access modifiers changed from: protected */
                public int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
                    return Math.max(0, super.getOffset(gridLayout, view, alignment, i, z));
                }

                /* access modifiers changed from: protected */
                public void include(int i, int i2) {
                    super.include(i, i2);
                    this.size = Math.max(this.size, i + i2);
                }

                /* access modifiers changed from: protected */
                public void reset() {
                    super.reset();
                    this.size = Integer.MIN_VALUE;
                }

                /* access modifiers changed from: protected */
                public int size(boolean z) {
                    return Math.max(super.size(z), this.size);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "BASELINE";
        }

        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int i) {
            return 0;
        }
    };
    public static final Alignment BOTTOM;
    static final int CAN_STRETCH = 2;
    public static final Alignment CENTER = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return i >> 1;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "CENTER";
        }

        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int i) {
            return i >> 1;
        }
    };
    private static final int COLUMN_COUNT = C0310R.styleable.GridLayout_columnCount;
    private static final int COLUMN_ORDER_PRESERVED = C0310R.styleable.GridLayout_columnOrderPreserved;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END;
    public static final Alignment FILL = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "FILL";
        }

        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int i) {
            return 0;
        }

        public int getSizeInCell(View view, int i, int i2) {
            return i2;
        }
    };
    public static final int HORIZONTAL = 0;
    static final int INFLEXIBLE = 0;
    private static final Alignment LEADING = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "LEADING";
        }

        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int i) {
            return 0;
        }
    };
    public static final Alignment LEFT;
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final int MAX_SIZE = 100000;
    static final Printer NO_PRINTER = new Printer() {
        public void println(String str) {
        }
    };
    private static final int ORIENTATION = C0310R.styleable.GridLayout_orientation;
    public static final Alignment RIGHT = createSwitchingAlignment(END, START);
    private static final int ROW_COUNT = C0310R.styleable.GridLayout_rowCount;
    private static final int ROW_ORDER_PRESERVED = C0310R.styleable.GridLayout_rowOrderPreserved;
    public static final Alignment START;
    public static final Alignment TOP;
    private static final Alignment TRAILING;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() {
        public int getAlignmentValue(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "UNDEFINED";
        }

        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int i) {
            return Integer.MIN_VALUE;
        }
    };
    static final int UNINITIALIZED_HASH = 0;
    private static final int USE_DEFAULT_MARGINS = C0310R.styleable.GridLayout_useDefaultMargins;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;

    public static abstract class Alignment {
        Alignment() {
        }

        /* access modifiers changed from: package-private */
        public abstract int getAlignmentValue(View view, int i, int i2);

        /* access modifiers changed from: package-private */
        public Bounds getBounds() {
            return new Bounds();
        }

        /* access modifiers changed from: package-private */
        public abstract String getDebugString();

        /* access modifiers changed from: package-private */
        public abstract int getGravityOffset(View view, int i);

        /* access modifiers changed from: package-private */
        public int getSizeInCell(View view, int i, int i2) {
            return i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("Alignment:");
            a.append(getDebugString());
            return a.toString();
        }
    }

    static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.span);
            sb.append(" ");
            sb.append(!this.valid ? "+>" : "->");
            sb.append(" ");
            sb.append(this.value);
            return sb.toString();
        }
    }

    static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        /* renamed from: of */
        public static <K, V> Assoc<K, V> m17of(Class<K> cls, Class<V> cls2) {
            return new Assoc<>(cls, cls2);
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.valueType, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = ((Pair) get(i)).first;
                objArr2[i] = ((Pair) get(i)).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }

        public void put(K k, V v) {
            add(Pair.create(k, v));
        }
    }

    final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int COMPLETE = 2;
        static final int NEW = 0;
        static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid = false;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid = false;
        public int definedCount = Integer.MIN_VALUE;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid = false;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid = false;
        public boolean hasWeights;
        public boolean hasWeightsValid = false;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid = false;
        public int[] locations;
        public boolean locationsValid = false;
        private int maxIndex = Integer.MIN_VALUE;
        boolean orderPreserved = true;
        private MutableInt parentMax = new MutableInt(-100000);
        private MutableInt parentMin = new MutableInt(0);
        public int[] trailingMargins;
        public boolean trailingMarginsValid = false;

        static {
            Class<GridLayout> cls = GridLayout.class;
        }

        Axis(boolean z) {
            this.horizontal = z;
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            int i = 0;
            while (true) {
                K[] kArr = packedMap.keys;
                if (i < ((Interval[]) kArr).length) {
                    include(list, ((Interval[]) kArr)[i], ((MutableInt[]) packedMap.values)[i], false);
                    i++;
                } else {
                    return;
                }
            }
        }

        private String arcsToString(List<Arc> list) {
            StringBuilder sb;
            String str = this.horizontal ? "x" : "y";
            StringBuilder sb2 = new StringBuilder();
            boolean z = true;
            for (Arc next : list) {
                if (z) {
                    z = false;
                } else {
                    sb2.append(", ");
                }
                Interval interval = next.span;
                int i = interval.min;
                int i2 = interval.max;
                int i3 = next.value.value;
                if (i < i2) {
                    sb.append(str);
                    sb.append(i2);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i);
                    sb.append(">=");
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i2);
                    sb.append("<=");
                    i3 = -i3;
                }
                sb.append(i3);
                sb2.append(sb.toString());
            }
            return sb2.toString();
        }

        private int calculateMaxIndex() {
            int childCount = GridLayout.this.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                i = Math.max(Math.max(Math.max(i, interval.min), interval.max), interval.size());
            }
            if (i == -1) {
                return Integer.MIN_VALUE;
            }
            return i;
        }

        private float calculateTotalWeight() {
            int childCount = GridLayout.this.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                }
            }
            return f;
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        private void computeGroupBounds() {
            Bounds[] boundsArr = (Bounds[]) this.groupBounds.values;
            for (Bounds reset : boundsArr) {
                reset.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                this.groupBounds.getValue(i).include(GridLayout.this, childAt, spec, this, GridLayout.this.getMeasurementIncludingMargin(childAt, this.horizontal) + (spec.weight == 0.0f ? 0 : getDeltas()[i]));
            }
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            MutableInt[] mutableIntArr = (MutableInt[]) packedMap.values;
            for (MutableInt reset : mutableIntArr) {
                reset.reset();
            }
            Bounds[] boundsArr = (Bounds[]) getGroupBounds().values;
            for (int i = 0; i < boundsArr.length; i++) {
                int size = boundsArr[i].size(z);
                MutableInt value = packedMap.getValue(i);
                int i2 = value.value;
                if (!z) {
                    size = -size;
                }
                value.value = Math.max(i2, size);
            }
        }

        private void computeLocations(int[] iArr) {
            if (!hasWeights()) {
                solve(iArr);
            } else {
                solveAndDistributeSpace(iArr);
            }
            if (!this.orderPreserved) {
                int i = iArr[0];
                int length = iArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = iArr[i2] - i;
                }
            }
        }

        private void computeMargins(boolean z) {
            int[] iArr = z ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i2 = z ? interval.min : interval.max;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.getMargin1(childAt, this.horizontal, z));
                }
            }
        }

        private Arc[] createArcs() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                int i = 0;
                while (i < getCount()) {
                    int i2 = i + 1;
                    include(arrayList, new Interval(i, i2), new MutableInt(0));
                    i = i2;
                }
            }
            int count = getCount();
            include(arrayList, new Interval(0, count), this.parentMin, false);
            include(arrayList2, new Interval(count, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort((List<Arc>) arrayList), topologicalSort((List<Arc>) arrayList2));
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc<K, V> of = Assoc.m17of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                of.put(spec, spec.getAbsoluteAlignment(this.horizontal).getBounds());
            }
            return of.pack();
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z) {
            Assoc<K, V> of = Assoc.m17of(Interval.class, MutableInt.class);
            Spec[] specArr = (Spec[]) getGroupBounds().keys;
            int length = specArr.length;
            for (int i = 0; i < length; i++) {
                of.put(z ? specArr[i].span : specArr[i].span.inverse(), new MutableInt());
            }
            return of.pack();
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        private int getMeasure(int i, int i2) {
            setParentConstraints(i, i2);
            return size(getLocations());
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, true);
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.size() != 0) {
                if (z) {
                    for (Arc arc : list) {
                        if (arc.span.equals(interval)) {
                            return;
                        }
                    }
                }
                list.add(new Arc(interval, mutableInt));
            }
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arcArr.length; i++) {
                Arc arc = arcArr[i];
                if (zArr[i]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
            }
            Printer printer = GridLayout.this.mPrinter;
            StringBuilder c = C0681a.m340c(str, " constraints: ");
            c.append(arcsToString(arrayList));
            c.append(" are inconsistent; permanently removing: ");
            c.append(arcsToString(arrayList2));
            c.append(". ");
            printer.println(c.toString());
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (!arc.valid) {
                return false;
            }
            Interval interval = arc.span;
            int i = interval.min;
            int i2 = interval.max;
            int i3 = iArr[i] + arc.value.value;
            if (i3 <= iArr[i2]) {
                return false;
            }
            iArr[i2] = i3;
            return true;
        }

        private void setParentConstraints(int i, int i2) {
            this.parentMin.value = i;
            this.parentMax.value = -i2;
            this.locationsValid = false;
        }

        private void shareOutDelta(int i, float f) {
            Arrays.fill(this.deltas, 0);
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    float f2 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                    if (f2 != 0.0f) {
                        int round = Math.round((((float) i) * f2) / f);
                        this.deltas[i2] = round;
                        i -= round;
                        f -= f2;
                    }
                }
            }
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, true);
        }

        private boolean solve(Arc[] arcArr, int[] iArr, boolean z) {
            String str = this.horizontal ? "horizontal" : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i = 0; i < arcArr.length; i++) {
                init(iArr);
                for (int i2 = 0; i2 < count; i2++) {
                    boolean z2 = false;
                    for (Arc relax : arcArr) {
                        z2 |= relax(iArr, relax);
                    }
                    if (!z2) {
                        if (zArr != null) {
                            logError(str, arcArr, zArr);
                        }
                        return true;
                    }
                }
                if (!z) {
                    return false;
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (int i3 = 0; i3 < count; i3++) {
                    int length = arcArr.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        zArr2[i4] = zArr2[i4] | relax(iArr, arcArr[i4]);
                    }
                }
                if (i == 0) {
                    zArr = zArr2;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= arcArr.length) {
                        break;
                    }
                    if (zArr2[i5]) {
                        Arc arc = arcArr[i5];
                        Interval interval = arc.span;
                        if (interval.min >= interval.max) {
                            arc.valid = false;
                            break;
                        }
                    }
                    i5++;
                }
            }
            return true;
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), 0);
            solve(iArr);
            int childCount = GridLayout.this.getChildCount() * this.parentMin.value;
            boolean z = true;
            int i = childCount + 1;
            if (i >= 2) {
                float calculateTotalWeight = calculateTotalWeight();
                int i2 = -1;
                int i3 = 0;
                while (i3 < i) {
                    int i4 = (int) ((((long) i3) + ((long) i)) / 2);
                    invalidateValues();
                    shareOutDelta(i4, calculateTotalWeight);
                    boolean solve = solve(getArcs(), iArr, false);
                    if (solve) {
                        i3 = i4 + 1;
                        i2 = i4;
                    } else {
                        i = i4;
                    }
                    z = solve;
                }
                if (i2 > 0 && !z) {
                    invalidateValues();
                    shareOutDelta(i2, calculateTotalWeight);
                    solve(iArr);
                }
            }
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        private Arc[] topologicalSort(final Arc[] arcArr) {
            return new Object() {
                static final /* synthetic */ boolean $assertionsDisabled = false;
                Arc[][] arcsByVertex;
                int cursor;
                Arc[] result;
                int[] visited = new int[(Axis.this.getCount() + 1)];

                static {
                    Class<GridLayout> cls = GridLayout.class;
                }

                {
                    Arc[] arcArr = arcArr;
                    Arc[] arcArr2 = new Arc[arcArr.length];
                    this.result = arcArr2;
                    this.cursor = arcArr2.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcArr);
                }

                /* access modifiers changed from: package-private */
                public Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i = 0; i < length; i++) {
                        walk(i);
                    }
                    return this.result;
                }

                /* access modifiers changed from: package-private */
                public void walk(int i) {
                    int[] iArr = this.visited;
                    if (iArr[i] == 0) {
                        iArr[i] = 1;
                        for (Arc arc : this.arcsByVertex[i]) {
                            walk(arc.span.max);
                            Arc[] arcArr = this.result;
                            int i2 = this.cursor;
                            this.cursor = i2 - 1;
                            arcArr[i2] = arc;
                        }
                        this.visited[i] = 2;
                    }
                }
            }.sort();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[(getCount() + 1)];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[(getCount() + 1)];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        public int getMeasure(int i) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                return getMeasure(0, size);
            }
            if (mode == 0) {
                return getMeasure(0, GridLayout.MAX_SIZE);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return getMeasure(size, size);
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[(getCount() + 1)];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        /* access modifiers changed from: package-private */
        public Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int count = getCount() + 1;
            Arc[][] arcArr2 = new Arc[count][];
            int[] iArr = new int[count];
            for (Arc arc : arcArr) {
                int i = arc.span.min;
                iArr[i] = iArr[i] + 1;
            }
            for (int i2 = 0; i2 < count; i2++) {
                arcArr2[i2] = new Arc[iArr[i2]];
            }
            Arrays.fill(iArr, 0);
            for (Arc arc2 : arcArr) {
                int i3 = arc2.span.min;
                Arc[] arcArr3 = arcArr2[i3];
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                arcArr3[i4] = arc2;
            }
            return arcArr2;
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void layout(int i) {
            setParentConstraints(i, i);
            getLocations();
        }

        public void setCount(int i) {
            if (i != Integer.MIN_VALUE && i < getMaxIndex()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.horizontal ? "column" : WorkoutExercises.ROW);
                sb.append("Count must be greater than or equal to the maximum of all grid indices ");
                sb.append("(and spans) defined in the LayoutParams of each child");
                GridLayout.handleInvalidParams(sb.toString());
            }
            this.definedCount = i;
        }

        public void setOrderPreserved(boolean z) {
            this.orderPreserved = z;
            invalidateStructure();
        }
    }

    static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        Bounds() {
            reset();
        }

        /* access modifiers changed from: protected */
        public int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
            return this.before - alignment.getAlignmentValue(view, i, ViewGroupCompat.getLayoutMode(gridLayout));
        }

        /* access modifiers changed from: protected */
        public void include(int i, int i2) {
            this.before = Math.max(this.before, i);
            this.after = Math.max(this.after, i2);
        }

        /* access modifiers changed from: protected */
        public final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(view, i, ViewGroupCompat.getLayoutMode(gridLayout));
            include(alignmentValue, i - alignmentValue);
        }

        /* access modifiers changed from: protected */
        public void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        /* access modifiers changed from: protected */
        public int size(boolean z) {
            return (z || !GridLayout.canStretch(this.flexibility)) ? this.before + this.after : GridLayout.MAX_SIZE;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("Bounds{before=");
            a.append(this.before);
            a.append(", after=");
            a.append(this.after);
            a.append('}');
            return a.toString();
        }
    }

    static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Interval.class != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.max == interval.max && this.min == interval.min;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        /* access modifiers changed from: package-private */
        public Interval inverse() {
            return new Interval(this.max, this.min);
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.max - this.min;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("[");
            a.append(this.min);
            a.append(", ");
            return C0681a.m322a(a, this.max, "]");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN = C0310R.styleable.GridLayout_Layout_android_layout_marginBottom;
        private static final int COLUMN = C0310R.styleable.GridLayout_Layout_layout_column;
        private static final int COLUMN_SPAN = C0310R.styleable.GridLayout_Layout_layout_columnSpan;
        private static final int COLUMN_WEIGHT = C0310R.styleable.GridLayout_Layout_layout_columnWeight;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN;
        private static final int DEFAULT_SPAN_SIZE;
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY = C0310R.styleable.GridLayout_Layout_layout_gravity;
        private static final int LEFT_MARGIN = C0310R.styleable.GridLayout_Layout_android_layout_marginLeft;
        private static final int MARGIN = C0310R.styleable.GridLayout_Layout_android_layout_margin;
        private static final int RIGHT_MARGIN = C0310R.styleable.GridLayout_Layout_android_layout_marginRight;
        private static final int ROW = C0310R.styleable.GridLayout_Layout_layout_row;
        private static final int ROW_SPAN = C0310R.styleable.GridLayout_Layout_layout_rowSpan;
        private static final int ROW_WEIGHT = C0310R.styleable.GridLayout_Layout_layout_rowWeight;
        private static final int TOP_MARGIN = C0310R.styleable.GridLayout_Layout_android_layout_marginTop;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            DEFAULT_SPAN = interval;
            DEFAULT_SPAN_SIZE = interval.size();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams() {
            /*
                r1 = this;
                androidx.gridlayout.widget.GridLayout$Spec r0 = androidx.gridlayout.widget.GridLayout.Spec.UNDEFINED
                r1.<init>((androidx.gridlayout.widget.GridLayout.Spec) r0, (androidx.gridlayout.widget.GridLayout.Spec) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.gridlayout.widget.GridLayout.LayoutParams.<init>():void");
        }

        private LayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Spec spec, Spec spec2) {
            super(i, i2);
            Spec spec3 = Spec.UNDEFINED;
            this.rowSpec = spec3;
            this.columnSpec = spec3;
            setMargins(i3, i4, i5, i6);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0310R.styleable.GridLayout_Layout);
            try {
                int i = obtainStyledAttributes.getInt(GRAVITY, 0);
                this.columnSpec = GridLayout.spec(obtainStyledAttributes.getInt(COLUMN, Integer.MIN_VALUE), obtainStyledAttributes.getInt(COLUMN_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, true), obtainStyledAttributes.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(obtainStyledAttributes.getInt(ROW, Integer.MIN_VALUE), obtainStyledAttributes.getInt(ROW_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, false), obtainStyledAttributes.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0310R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(MARGIN, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || LayoutParams.class != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec);
        }

        public int hashCode() {
            return this.columnSpec.hashCode() + (this.rowSpec.hashCode() * 31);
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, -2);
            this.height = typedArray.getLayoutDimension(i2, -2);
        }

        /* access modifiers changed from: package-private */
        public final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public void setGravity(int i) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i, true));
        }

        /* access modifiers changed from: package-private */
        public final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }
    }

    static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int i) {
            this.value = i;
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        PackedMap(K[] kArr, V[] vArr) {
            int[] createIndex = createIndex(kArr);
            this.index = createIndex;
            this.keys = compact(kArr, createIndex);
            this.values = compact(vArr, this.index);
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1);
            for (int i = 0; i < length; i++) {
                kArr2[iArr[i]] = kArr[i];
            }
            return kArr2;
        }

        private static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap hashMap = new HashMap();
            for (int i = 0; i < length; i++) {
                K k = kArr[i];
                Integer num = (Integer) hashMap.get(k);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(k, num);
                }
                iArr[i] = num.intValue();
            }
            return iArr;
        }

        public V getValue(int i) {
            return this.values[this.index[i]];
        }
    }

    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        Spec(boolean z, int i, int i2, Alignment alignment2, float f) {
            this(z, new Interval(i, i2 + i), alignment2, f);
        }

        private Spec(boolean z, Interval interval, Alignment alignment2, float f) {
            this.startDefined = z;
            this.span = interval;
            this.alignment = alignment2;
            this.weight = f;
        }

        /* access modifiers changed from: package-private */
        public final Spec copyWriteAlignment(Alignment alignment2) {
            return new Spec(this.startDefined, this.span, alignment2, this.weight);
        }

        /* access modifiers changed from: package-private */
        public final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Spec.class != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            return this.alignment.equals(spec.alignment) && this.span.equals(spec.span);
        }

        public Alignment getAbsoluteAlignment(boolean z) {
            Alignment alignment2 = this.alignment;
            return alignment2 != GridLayout.UNDEFINED_ALIGNMENT ? alignment2 : this.weight == 0.0f ? z ? GridLayout.START : GridLayout.BASELINE : GridLayout.FILL;
        }

        /* access modifiers changed from: package-private */
        public final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public int hashCode() {
            return this.alignment.hashCode() + (this.span.hashCode() * 31);
        }
    }

    static {
        C03164 r0 = new Alignment() {
            public int getAlignmentValue(View view, int i, int i2) {
                return i;
            }

            /* access modifiers changed from: package-private */
            public String getDebugString() {
                return "TRAILING";
            }

            /* access modifiers changed from: package-private */
            public int getGravityOffset(View view, int i) {
                return i;
            }
        };
        TRAILING = r0;
        Alignment alignment = LEADING;
        TOP = alignment;
        BOTTOM = r0;
        START = alignment;
        END = r0;
        LEFT = createSwitchingAlignment(alignment, r0);
    }

    public GridLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(C0310R.dimen.default_gap);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0310R.styleable.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(ROW_COUNT, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(COLUMN_COUNT, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(ORIENTATION, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(USE_DEFAULT_MARGINS, false));
            setAlignmentMode(obtainStyledAttributes.getInt(ALIGNMENT_MODE, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(ROW_ORDER_PRESERVED, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(COLUMN_ORDER_PRESERVED, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int adjust(int i, int i2) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2 + i), View.MeasureSpec.getMode(i));
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static boolean canStretch(int i) {
        return (i & 2) != 0;
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : WorkoutExercises.ROW;
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        int i = interval.min;
        if (i != Integer.MIN_VALUE && i < 0) {
            handleInvalidParams(C0681a.m320a(str, " indices must be positive"));
        }
        int i2 = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i2 != Integer.MIN_VALUE) {
            if (interval.max > i2) {
                handleInvalidParams(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.size() > i2) {
                handleInvalidParams(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    private static int clip(Interval interval, boolean z, int i) {
        int size = interval.size();
        if (i == 0) {
            return size;
        }
        return Math.min(size, i - (z ? Math.min(interval.min, i) : 0));
    }

    private int computeLayoutParamsHashCode() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                i = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (i * 31);
            }
        }
        return i;
    }

    private void consistencyCheck() {
        int i = this.mLastLayoutParamsHashCode;
        if (i == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (i != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private static Alignment createSwitchingAlignment(final Alignment alignment, final Alignment alignment2) {
        return new Alignment() {
            public int getAlignmentValue(View view, int i, int i2) {
                boolean z = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    z = false;
                }
                return (!z ? alignment : alignment2).getAlignmentValue(view, i, i2);
            }

            /* access modifiers changed from: package-private */
            public String getDebugString() {
                StringBuilder a = C0681a.m330a("SWITCHING[L:");
                a.append(alignment.getDebugString());
                a.append(", R:");
                return C0681a.m324a(a, alignment2.getDebugString(), "]");
            }

            /* access modifiers changed from: package-private */
            public int getGravityOffset(View view, int i) {
                boolean z = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    z = false;
                }
                return (!z ? alignment : alignment2).getGravityOffset(view, i);
            }
        };
    }

    private void drawLine(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (isLayoutRtlCompat()) {
            int width = getWidth();
            canvas.drawLine((float) (width - i5), (float) i6, (float) (width - i7), (float) i8, paint);
            return;
        }
        canvas.drawLine((float) i5, (float) i6, (float) i7, (float) i8, paint);
    }

    private static boolean fits(int[] iArr, int i, int i2, int i3) {
        if (i3 > iArr.length) {
            return false;
        }
        while (i2 < i3) {
            if (iArr[i2] > i) {
                return false;
            }
            i2++;
        }
        return true;
    }

    static Alignment getAlignment(int i, boolean z) {
        int i2 = (i & (z ? 7 : 112)) >> (z ? 0 : 4);
        return i2 != 1 ? i2 != 3 ? i2 != 5 ? i2 != 7 ? i2 != 8388611 ? i2 != 8388613 ? UNDEFINED_ALIGNMENT : END : START : FILL : z ? RIGHT : BOTTOM : z ? LEFT : TOP : CENTER;
    }

    private int getDefaultMargin(View view, LayoutParams layoutParams, boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval interval = spec.span;
        if (!((!z || !isLayoutRtlCompat()) ? z2 : !z2) ? interval.max == axis.getCount() : interval.min == 0) {
            z3 = true;
        }
        return getDefaultMargin(view, z3, z, z2);
    }

    private int getDefaultMargin(View view, boolean z, boolean z2) {
        if (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) {
            return 0;
        }
        return this.mDefaultGap / 2;
    }

    private int getDefaultMargin(View view, boolean z, boolean z2, boolean z3) {
        return getDefaultMargin(view, z2, z3);
    }

    private int getMargin(View view, boolean z, boolean z2) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z, z2);
        }
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z2 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        return leadingMargins[z2 ? interval.min : interval.max];
    }

    private int getMeasurement(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int getTotalMargin(View view, boolean z) {
        return getMargin(view, z, true) + getMargin(view, z, false);
    }

    static void handleInvalidParams(String str) {
        throw new IllegalArgumentException(C0681a.m320a(str, ". "));
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        Axis axis = this.mHorizontalAxis;
        if (axis != null) {
            axis.invalidateStructure();
        }
        Axis axis2 = this.mVerticalAxis;
        if (axis2 != null) {
            axis2.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        Axis axis = this.mHorizontalAxis;
        if (axis != null && this.mVerticalAxis != null) {
            axis.invalidateValues();
            this.mVerticalAxis.invalidateValues();
        }
    }

    private boolean isLayoutRtlCompat() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    static int max2(int[] iArr, int i) {
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private void measureChildWithMargins2(View view, int i, int i2, int i3, int i4) {
        view.measure(ViewGroup.getChildMeasureSpec(i, getTotalMargin(view, true), i3), ViewGroup.getChildMeasureSpec(i2, getTotalMargin(view, false), i4));
    }

    private void measureChildrenWithMargins(int i, int i2, boolean z) {
        int totalMargin;
        int i3;
        GridLayout gridLayout;
        int i4;
        int i5;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z) {
                    i3 = layoutParams.width;
                    totalMargin = layoutParams.height;
                } else {
                    boolean z2 = this.mOrientation == 0;
                    Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.getAbsoluteAlignment(z2) == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z2);
                        if (z2) {
                            int i7 = layoutParams.height;
                            gridLayout = this;
                            i4 = i;
                            i5 = i2;
                            i3 = totalMargin;
                            totalMargin = i7;
                            gridLayout.measureChildWithMargins2(childAt, i4, i5, i3, totalMargin);
                        } else {
                            i3 = layoutParams.width;
                        }
                    }
                }
                gridLayout = this;
                i4 = i;
                i5 = i2;
                gridLayout.measureChildWithMargins2(childAt, i4, i5, i3, totalMargin);
            }
        }
    }

    private static void procrusteanFill(int[] iArr, int i, int i2, int i3) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i, length), Math.min(i2, length), i3);
    }

    private static void setCellGroup(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.setRowSpecSpan(new Interval(i, i2 + i));
        layoutParams.setColumnSpecSpan(new Interval(i3, i4 + i3));
    }

    public static Spec spec(int i) {
        return spec(i, 1);
    }

    public static Spec spec(int i, float f) {
        return spec(i, 1, f);
    }

    public static Spec spec(int i, int i2) {
        return spec(i, i2, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i, int i2, float f) {
        return spec(i, i2, UNDEFINED_ALIGNMENT, f);
    }

    public static Spec spec(int i, int i2, Alignment alignment) {
        return spec(i, i2, alignment, 0.0f);
    }

    public static Spec spec(int i, int i2, Alignment alignment, float f) {
        return new Spec(i != Integer.MIN_VALUE, i, i2, alignment, f);
    }

    public static Spec spec(int i, Alignment alignment) {
        return spec(i, 1, alignment);
    }

    public static Spec spec(int i, Alignment alignment, float f) {
        return spec(i, 1, alignment, f);
    }

    private void validateLayoutParams() {
        boolean z = this.mOrientation == 0;
        int i = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int[] iArr = new int[i];
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            Spec spec = z ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z2 = spec.startDefined;
            int size = interval.size();
            if (z2) {
                i2 = interval.min;
            }
            Spec spec2 = z ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z3 = spec2.startDefined;
            int clip = clip(interval2, z3, i);
            if (z3) {
                i3 = interval2.min;
            }
            if (i != 0) {
                if (!z2 || !z3) {
                    while (true) {
                        int i5 = i3 + clip;
                        if (fits(iArr, i2, i3, i5)) {
                            break;
                        } else if (z3) {
                            i2++;
                        } else if (i5 <= i) {
                            i3++;
                        } else {
                            i2++;
                            i3 = 0;
                        }
                    }
                }
                procrusteanFill(iArr, i3, i3 + clip, i2 + size);
            }
            if (z) {
                setCellGroup(layoutParams, i2, size, i3, clip);
            } else {
                setCellGroup(layoutParams, i3, clip, i2, size);
            }
            i3 += clip;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        checkLayoutParams(layoutParams2, true);
        checkLayoutParams(layoutParams2, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    /* access modifiers changed from: package-private */
    public final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getMargin1(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = getLayoutParams(view);
        int i = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        return i == Integer.MIN_VALUE ? getDefaultMargin(view, layoutParams, z, z2) : i;
    }

    /* access modifiers changed from: package-private */
    public final int getMeasurementIncludingMargin(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(view, z) + getTotalMargin(view, z);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int[] iArr;
        int[] iArr2;
        GridLayout gridLayout = this;
        consistencyCheck();
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        gridLayout.mHorizontalAxis.layout((i5 - paddingLeft) - paddingRight);
        gridLayout.mVerticalAxis.layout(((i4 - i2) - paddingTop) - paddingBottom);
        int[] locations = gridLayout.mHorizontalAxis.getLocations();
        int[] locations2 = gridLayout.mVerticalAxis.getLocations();
        int childCount = getChildCount();
        boolean z2 = false;
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = gridLayout.getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                iArr2 = locations;
                iArr = locations2;
            } else {
                LayoutParams layoutParams = gridLayout.getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i7 = locations[interval.min];
                int i8 = locations2[interval2.min];
                int i9 = locations[interval.max] - i7;
                int i10 = locations2[interval2.max] - i8;
                int measurement = gridLayout.getMeasurement(childAt, true);
                int measurement2 = gridLayout.getMeasurement(childAt, z2);
                Alignment absoluteAlignment = spec.getAbsoluteAlignment(true);
                Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(z2);
                Bounds value = gridLayout.mHorizontalAxis.getGroupBounds().getValue(i6);
                Bounds value2 = gridLayout.mVerticalAxis.getGroupBounds().getValue(i6);
                int i11 = measurement2;
                iArr2 = locations;
                int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i9 - value.size(true));
                int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i10 - value2.size(true));
                int margin = gridLayout.getMargin(childAt, true, true);
                int margin2 = gridLayout.getMargin(childAt, false, true);
                int margin3 = gridLayout.getMargin(childAt, true, false);
                int i12 = margin + margin3;
                int margin4 = margin2 + gridLayout.getMargin(childAt, false, false);
                Alignment alignment = absoluteAlignment2;
                Bounds bounds = value;
                Alignment alignment2 = absoluteAlignment;
                int i13 = i11;
                Alignment alignment3 = alignment;
                View view = childAt;
                int offset = bounds.getOffset(this, childAt, alignment2, measurement + i12, true);
                int i14 = i13;
                View view2 = view;
                iArr = locations2;
                int offset2 = value2.getOffset(this, view2, alignment3, i14 + margin4, false);
                int sizeInCell = alignment2.getSizeInCell(view2, measurement, i9 - i12);
                int sizeInCell2 = alignment3.getSizeInCell(view2, i14, i10 - margin4);
                int i15 = i7 + gravityOffset + offset;
                int i16 = !isLayoutRtlCompat() ? paddingLeft + margin + i15 : (((i5 - sizeInCell) - paddingRight) - margin3) - i15;
                int i17 = paddingTop + i8 + gravityOffset2 + offset2 + margin2;
                if (!(sizeInCell == view2.getMeasuredWidth() && sizeInCell2 == view2.getMeasuredHeight())) {
                    view2.measure(View.MeasureSpec.makeMeasureSpec(sizeInCell, 1073741824), View.MeasureSpec.makeMeasureSpec(sizeInCell2, 1073741824));
                }
                view2.layout(i16, i17, sizeInCell + i16, sizeInCell2 + i17);
            }
            i6++;
            gridLayout = this;
            locations = iArr2;
            locations2 = iArr;
            z2 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        consistencyCheck();
        invalidateValues();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int adjust = adjust(i, -paddingRight);
        int adjust2 = adjust(i2, -paddingBottom);
        measureChildrenWithMargins(adjust, adjust2, true);
        if (this.mOrientation == 0) {
            i3 = this.mHorizontalAxis.getMeasure(adjust);
            measureChildrenWithMargins(adjust, adjust2, false);
            i4 = this.mVerticalAxis.getMeasure(adjust2);
        } else {
            int measure = this.mVerticalAxis.getMeasure(adjust2);
            measureChildrenWithMargins(adjust, adjust2, false);
            int i5 = measure;
            i3 = this.mHorizontalAxis.getMeasure(adjust);
            i4 = i5;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3 + paddingRight, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(Math.max(i4 + paddingBottom, getSuggestedMinimumHeight()), i2, 0));
    }

    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    public void setAlignmentMode(int i) {
        this.mAlignmentMode = i;
        requestLayout();
    }

    public void setColumnCount(int i) {
        this.mHorizontalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.mHorizontalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            invalidateStructure();
            requestLayout();
        }
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    public void setRowCount(int i) {
        this.mVerticalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z) {
        this.mVerticalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public void setUseDefaultMargins(boolean z) {
        this.mUseDefaultMargins = z;
        requestLayout();
    }
}