package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId = -1;

    /* renamed from: id */
    public int f14id = -1;
    ArrayRow[] mClientEquations = new ArrayRow[8];
    int mClientEquationsCount = 0;
    private String mName;
    Type mType;
    public int strength = 0;
    float[] strengthVector = new float[7];
    public int usageInRowCount = 0;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1 */
    static /* synthetic */ class C01801 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
        static {
            /*
                androidx.constraintlayout.solver.SolverVariable$Type[] r0 = androidx.constraintlayout.solver.SolverVariable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = r0
                r1 = 1
                androidx.constraintlayout.solver.SolverVariable$Type r2 = androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x0016 }
                androidx.constraintlayout.solver.SolverVariable$Type r3 = androidx.constraintlayout.solver.SolverVariable.Type.CONSTANT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.SolverVariable$Type r3 = androidx.constraintlayout.solver.SolverVariable.Type.SLACK     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.constraintlayout.solver.SolverVariable$Type r3 = androidx.constraintlayout.solver.SolverVariable.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x002b }
                androidx.constraintlayout.solver.SolverVariable$Type r2 = androidx.constraintlayout.solver.SolverVariable.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.SolverVariable.C01801.<clinit>():void");
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.mType = type;
    }

    public SolverVariable(String str, Type type) {
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        int i;
        StringBuilder sb;
        if (str != null) {
            sb = C0681a.m330a(str);
            i = uniqueErrorId;
        } else {
            int ordinal = type.ordinal();
            if (ordinal == 0) {
                sb = C0681a.m330a("U");
                i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
            } else if (ordinal == 1) {
                sb = C0681a.m330a("C");
                i = uniqueConstantId + 1;
                uniqueConstantId = i;
            } else if (ordinal == 2) {
                sb = C0681a.m330a(ExifInterface.LATITUDE_SOUTH);
                i = uniqueSlackId + 1;
                uniqueSlackId = i;
            } else if (ordinal == 3) {
                sb = C0681a.m330a("e");
                i = uniqueErrorId + 1;
                uniqueErrorId = i;
            } else if (ordinal == 4) {
                sb = C0681a.m330a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                i = uniqueId + 1;
                uniqueId = i;
            } else {
                throw new AssertionError(type.name());
            }
        }
        sb.append(i);
        return sb.toString();
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i >= i2) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            } else if (this.mClientEquations[i] != arrayRow) {
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mClientEquations[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i4 = i2 + i3;
                    arrayRowArr[i4] = arrayRowArr[i4 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f14id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    /* access modifiers changed from: package-private */
    public String strengthsToString() {
        String str = this + "[";
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        while (i < this.strengthVector.length) {
            StringBuilder a = C0681a.m330a(str);
            a.append(this.strengthVector[i]);
            String sb = a.toString();
            float[] fArr = this.strengthVector;
            if (fArr[i] > 0.0f) {
                z = false;
            } else if (fArr[i] < 0.0f) {
                z = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z2 = false;
            }
            int length = this.strengthVector.length - 1;
            StringBuilder a2 = C0681a.m330a(sb);
            a2.append(i < length ? ", " : "] ");
            str = a2.toString();
            i++;
        }
        if (z) {
            str = C0681a.m320a(str, " (-)");
        }
        return z2 ? C0681a.m320a(str, " (*)") : str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("");
        a.append(this.mName);
        return a.toString();
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayRow[] arrayRowArr = this.mClientEquations;
            arrayRowArr[i2].variables.updateFromRow(arrayRowArr[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
