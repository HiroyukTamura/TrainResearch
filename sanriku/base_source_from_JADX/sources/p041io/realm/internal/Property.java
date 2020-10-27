package p041io.realm.internal;

import java.util.Locale;
import p041io.realm.RealmFieldType;
import p043jp.reifrontier.silentlogsdkandroid.BuildConfig;

/* renamed from: io.realm.internal.Property */
public class Property implements NativeObject {
    public static final boolean INDEXED = true;
    public static final boolean PRIMARY_KEY = true;
    public static final boolean REQUIRED = true;
    public static final int TYPE_ARRAY = 128;
    public static final int TYPE_BOOL = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_DATE = 4;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 0;
    public static final int TYPE_LINKING_OBJECTS = 8;
    public static final int TYPE_NULLABLE = 64;
    public static final int TYPE_OBJECT = 7;
    public static final int TYPE_REQUIRED = 0;
    public static final int TYPE_STRING = 2;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private long nativePtr;

    /* renamed from: io.realm.internal.Property$1 */
    static /* synthetic */ class C19831 {
        static final /* synthetic */ int[] $SwitchMap$io$realm$RealmFieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|(2:31|32)|33|(2:35|36)|37|(2:39|40)|41|(2:43|44)|45|(2:47|48)|49|(2:51|52)|53|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|(2:31|32)|33|(2:35|36)|37|39|40|41|(2:43|44)|45|(2:47|48)|49|(2:51|52)|53|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|31|32|33|35|36|37|39|40|41|43|44|45|47|48|49|51|52|53|55|56|(3:57|58|60)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0037 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0081 */
        static {
            /*
                io.realm.RealmFieldType[] r0 = p041io.realm.RealmFieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$realm$RealmFieldType = r0
                r1 = 1
                r2 = 7
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.OBJECT     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 8
                int[] r4 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0018 }
                io.realm.RealmFieldType r5 = p041io.realm.RealmFieldType.LIST     // Catch:{ NoSuchFieldError -> 0x0018 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                r4 = 3
                r5 = 9
                int[] r6 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0021 }
                io.realm.RealmFieldType r7 = p041io.realm.RealmFieldType.LINKING_OBJECTS     // Catch:{ NoSuchFieldError -> 0x0021 }
                r6[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                r6 = 4
                int[] r7 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0029 }
                io.realm.RealmFieldType r8 = p041io.realm.RealmFieldType.INTEGER     // Catch:{ NoSuchFieldError -> 0x0029 }
                r8 = 0
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                r7 = 5
                int[] r8 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0030 }
                io.realm.RealmFieldType r9 = p041io.realm.RealmFieldType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0030 }
                r8[r1] = r7     // Catch:{ NoSuchFieldError -> 0x0030 }
            L_0x0030:
                r1 = 6
                int[] r8 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0037 }
                io.realm.RealmFieldType r9 = p041io.realm.RealmFieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0037 }
                r8[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x003d }
                io.realm.RealmFieldType r8 = p041io.realm.RealmFieldType.BINARY     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0043 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.DATE     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0049 }
                r0[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 10
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0051 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r1 = 11
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0059 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.INTEGER_LIST     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                r0 = 12
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0061 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BOOLEAN_LIST     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                r1 = 13
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0069 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.STRING_LIST     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                r0 = 14
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0071 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BINARY_LIST     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                r1 = 15
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0079 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.DATE_LIST     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                r0 = 16
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0081 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.FLOAT_LIST     // Catch:{ NoSuchFieldError -> 0x0081 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0089 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.DOUBLE_LIST     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2 = 17
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p041io.realm.internal.Property.C19831.<clinit>():void");
        }
    }

    Property(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }

    static int convertFromRealmFieldType(RealmFieldType realmFieldType, boolean z) {
        int i = 1;
        int i2 = 0;
        switch (realmFieldType.ordinal()) {
            case 0:
                i = 0;
                break;
            case 1:
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            case 7:
                return 71;
            case 8:
                return 135;
            case 9:
                return BuildConfig.VERSION_CODE;
            case 10:
                i = 128;
                break;
            case 11:
                i = 129;
                break;
            case 12:
                i = 130;
                break;
            case 13:
                i = 131;
                break;
            case 14:
                i = 132;
                break;
            case 15:
                i = 133;
                break;
            case 16:
                i = 134;
                break;
            default:
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported filed type: '%s'.", new Object[]{realmFieldType.name()}));
        }
        if (!z) {
            i2 = 64;
        }
        return i | i2;
    }

    private static RealmFieldType convertToRealmFieldType(int i) {
        int i2 = i & -65;
        switch (i2) {
            case 0:
                return RealmFieldType.INTEGER;
            case 1:
                return RealmFieldType.BOOLEAN;
            case 2:
                return RealmFieldType.STRING;
            case 3:
                return RealmFieldType.BINARY;
            case 4:
                return RealmFieldType.DATE;
            case 5:
                return RealmFieldType.FLOAT;
            case 6:
                return RealmFieldType.DOUBLE;
            case 7:
                return RealmFieldType.OBJECT;
            default:
                switch (i2) {
                    case 128:
                        return RealmFieldType.INTEGER_LIST;
                    case 129:
                        return RealmFieldType.BOOLEAN_LIST;
                    case 130:
                        return RealmFieldType.STRING_LIST;
                    case 131:
                        return RealmFieldType.BINARY_LIST;
                    case 132:
                        return RealmFieldType.DATE_LIST;
                    case 133:
                        return RealmFieldType.FLOAT_LIST;
                    case 134:
                        return RealmFieldType.DOUBLE_LIST;
                    case 135:
                        return RealmFieldType.LIST;
                    case BuildConfig.VERSION_CODE /*136*/:
                        return RealmFieldType.LINKING_OBJECTS;
                    default:
                        throw new IllegalArgumentException(String.format(Locale.US, "Unsupported property type: '%d'", new Object[]{Integer.valueOf(i)}));
                }
        }
    }

    static native long nativeCreateComputedLinkProperty(String str, String str2, String str3);

    static native long nativeCreatePersistedLinkProperty(String str, int i, String str2);

    static native long nativeCreatePersistedProperty(String str, int i, boolean z, boolean z2);

    private static native long nativeGetColumnIndex(long j);

    private static native long nativeGetFinalizerPtr();

    private static native String nativeGetLinkedObjectName(long j);

    private static native int nativeGetType(long j);

    public long getColumnIndex() {
        return nativeGetColumnIndex(this.nativePtr);
    }

    public String getLinkedObjectName() {
        return nativeGetLinkedObjectName(this.nativePtr);
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public RealmFieldType getType() {
        return convertToRealmFieldType(nativeGetType(this.nativePtr));
    }
}
