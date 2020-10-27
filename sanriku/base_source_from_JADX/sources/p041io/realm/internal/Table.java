package p041io.realm.internal;

import java.util.Date;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.RealmFieldType;
import p041io.realm.exceptions.RealmPrimaryKeyConstraintException;

/* renamed from: io.realm.internal.Table */
public class Table implements NativeObject {
    public static final int CLASS_NAME_MAX_LENGTH;
    public static final long INFINITE = -1;
    public static final int MAX_BINARY_SIZE = 16777200;
    public static final int MAX_STRING_SIZE = 16777199;
    public static final boolean NOT_NULLABLE = false;
    public static final int NO_MATCH = -1;
    public static final boolean NULLABLE = true;
    private static final int TABLE_NAME_MAX_LENGTH = 63;
    private static final String TABLE_PREFIX;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    private final long nativePtr;
    private final OsSharedRealm sharedRealm;

    /* renamed from: io.realm.internal.Table$1 */
    static /* synthetic */ class C10011 {
        static final /* synthetic */ int[] $SwitchMap$io$realm$RealmFieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|27|28|29|(2:31|32)|33|35|36|37|39|40|41|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|27|28|29|31|32|33|35|36|37|39|40|41|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x006d */
        static {
            /*
                io.realm.RealmFieldType[] r0 = p041io.realm.RealmFieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$realm$RealmFieldType = r0
                r1 = 1
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.INTEGER     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BINARY     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x002b }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.DATE     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0032 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0039 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 7
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r0 = 10
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0043 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.INTEGER_LIST     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 8
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r1 = 11
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x004d }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BOOLEAN_LIST     // Catch:{ NoSuchFieldError -> 0x004d }
                r3 = 9
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                r2 = 12
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0055 }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.STRING_LIST     // Catch:{ NoSuchFieldError -> 0x0055 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                r0 = 13
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x005d }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.BINARY_LIST     // Catch:{ NoSuchFieldError -> 0x005d }
                r3[r0] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                r1 = 14
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0065 }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.DATE_LIST     // Catch:{ NoSuchFieldError -> 0x0065 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x006d }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.FLOAT_LIST     // Catch:{ NoSuchFieldError -> 0x006d }
                r3 = 15
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0075 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.DOUBLE_LIST     // Catch:{ NoSuchFieldError -> 0x0075 }
                r2 = 16
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p041io.realm.internal.Table.C10011.<clinit>():void");
        }
    }

    static {
        String tablePrefix = Util.getTablePrefix();
        TABLE_PREFIX = tablePrefix;
        CLASS_NAME_MAX_LENGTH = 63 - tablePrefix.length();
    }

    Table(OsSharedRealm osSharedRealm, long j) {
        NativeContext nativeContext = osSharedRealm.context;
        this.context = nativeContext;
        this.sharedRealm = osSharedRealm;
        this.nativePtr = j;
        nativeContext.addReference(this);
    }

    Table(Table table, long j) {
        this(table.sharedRealm, j);
    }

    public static String getClassNameForTable(String str) {
        if (str == null) {
            return null;
        }
        return !str.startsWith(TABLE_PREFIX) ? str : str.substring(TABLE_PREFIX.length());
    }

    public static String getTableNameForClass(String str) {
        if (str == null) {
            return null;
        }
        return C0681a.m324a(new StringBuilder(), TABLE_PREFIX, str);
    }

    private boolean isPrimaryKey(long j) {
        return getColumnName(j).equals(OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, getClassName()));
    }

    public static void migratePrimaryKeyTableIfNeeded(OsSharedRealm osSharedRealm) {
        nativeMigratePrimaryKeyTableIfNeeded(osSharedRealm.getNativePtr());
    }

    private native long nativeAddColumn(long j, int i, String str, boolean z);

    private native long nativeAddColumnLink(long j, int i, String str, long j2);

    private native long nativeAddPrimitiveListColumn(long j, int i, String str, boolean z);

    private native void nativeAddSearchIndex(long j, long j2);

    private native void nativeClear(long j, boolean z);

    private native void nativeConvertColumnToNotNullable(long j, long j2, boolean z);

    private native void nativeConvertColumnToNullable(long j, long j2, boolean z);

    private native long nativeCountDouble(long j, long j2, double d);

    private native long nativeCountFloat(long j, long j2, float f);

    private native long nativeCountLong(long j, long j2, long j3);

    private native long nativeCountString(long j, long j2, String str);

    private native long nativeFindFirstBool(long j, long j2, boolean z);

    private native long nativeFindFirstDouble(long j, long j2, double d);

    private native long nativeFindFirstFloat(long j, long j2, float f);

    public static native long nativeFindFirstInt(long j, long j2, long j3);

    public static native long nativeFindFirstNull(long j, long j2);

    public static native long nativeFindFirstString(long j, long j2, String str);

    private native long nativeFindFirstTimestamp(long j, long j2, long j3);

    private native boolean nativeGetBoolean(long j, long j2, long j3);

    private native byte[] nativeGetByteArray(long j, long j2, long j3);

    private native long nativeGetColumnCount(long j);

    private native long nativeGetColumnIndex(long j, String str);

    private native String nativeGetColumnName(long j, long j2);

    private native int nativeGetColumnType(long j, long j2);

    private native double nativeGetDouble(long j, long j2, long j3);

    private static native long nativeGetFinalizerPtr();

    private native float nativeGetFloat(long j, long j2, long j3);

    private native long nativeGetLink(long j, long j2, long j3);

    private native long nativeGetLinkTarget(long j, long j2);

    private native long nativeGetLong(long j, long j2, long j3);

    private native String nativeGetName(long j);

    private native String nativeGetString(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2, long j3);

    private native boolean nativeHasSameSchema(long j, long j2);

    private native boolean nativeHasSearchIndex(long j, long j2);

    public static native void nativeIncrementLong(long j, long j2, long j3, long j4);

    private static native void nativeInsertColumn(long j, long j2, int i, String str);

    private native boolean nativeIsColumnNullable(long j, long j2);

    private native boolean nativeIsNull(long j, long j2, long j3);

    private native boolean nativeIsNullLink(long j, long j2, long j3);

    private native boolean nativeIsValid(long j);

    private static native void nativeMigratePrimaryKeyTableIfNeeded(long j);

    private native void nativeMoveLastOver(long j, long j2);

    public static native void nativeNullifyLink(long j, long j2, long j3);

    private native void nativeRemoveColumn(long j, long j2);

    private native void nativeRemoveSearchIndex(long j, long j2);

    private native void nativeRenameColumn(long j, long j2, String str);

    public static native void nativeSetBoolean(long j, long j2, long j3, boolean z, boolean z2);

    public static native void nativeSetByteArray(long j, long j2, long j3, byte[] bArr, boolean z);

    public static native void nativeSetDouble(long j, long j2, long j3, double d, boolean z);

    public static native void nativeSetFloat(long j, long j2, long j3, float f, boolean z);

    public static native void nativeSetLink(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetLong(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetNull(long j, long j2, long j3, boolean z);

    public static native void nativeSetString(long j, long j2, long j3, String str, boolean z);

    public static native void nativeSetTimestamp(long j, long j2, long j3, long j4, boolean z);

    private native long nativeSize(long j);

    private native long nativeWhere(long j);

    public static void throwDuplicatePrimaryKeyException(Object obj) {
        throw new RealmPrimaryKeyConstraintException("Value already exists: " + obj);
    }

    private static void throwImmutable() {
        throw new IllegalStateException("Cannot modify managed objects outside of a write transaction.");
    }

    private void verifyColumnName(String str) {
        if (str.length() > 63) {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        }
    }

    public long addColumn(RealmFieldType realmFieldType, String str) {
        return addColumn(realmFieldType, str, false);
    }

    public long addColumn(RealmFieldType realmFieldType, String str, boolean z) {
        verifyColumnName(str);
        switch (realmFieldType.ordinal()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return nativeAddColumn(this.nativePtr, realmFieldType.getNativeValue(), str, z);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return nativeAddPrimitiveListColumn(this.nativePtr, realmFieldType.getNativeValue() - 128, str, z);
            default:
                throw new IllegalArgumentException("Unsupported type: " + realmFieldType);
        }
    }

    public long addColumnLink(RealmFieldType realmFieldType, String str, Table table) {
        verifyColumnName(str);
        return nativeAddColumnLink(this.nativePtr, realmFieldType.getNativeValue(), str, table.nativePtr);
    }

    public void addSearchIndex(long j) {
        checkImmutable();
        nativeAddSearchIndex(this.nativePtr, j);
    }

    /* access modifiers changed from: package-private */
    public void checkImmutable() {
        if (isImmutable()) {
            throwImmutable();
        }
    }

    public void clear(boolean z) {
        checkImmutable();
        nativeClear(this.nativePtr, z);
    }

    public void convertColumnToNotNullable(long j) {
        if (!this.sharedRealm.isSyncRealm()) {
            nativeConvertColumnToNotNullable(this.nativePtr, j, isPrimaryKey(j));
            return;
        }
        throw new IllegalStateException("This method is only available for non-synchronized Realms");
    }

    public void convertColumnToNullable(long j) {
        if (!this.sharedRealm.isSyncRealm()) {
            nativeConvertColumnToNullable(this.nativePtr, j, isPrimaryKey(j));
            return;
        }
        throw new IllegalStateException("This method is only available for non-synchronized Realms");
    }

    public long count(long j, double d) {
        return nativeCountDouble(this.nativePtr, j, d);
    }

    public long count(long j, float f) {
        return nativeCountFloat(this.nativePtr, j, f);
    }

    public long count(long j, long j2) {
        return nativeCountLong(this.nativePtr, j, j2);
    }

    public long count(long j, String str) {
        return nativeCountString(this.nativePtr, j, str);
    }

    public long findFirstBoolean(long j, boolean z) {
        return nativeFindFirstBool(this.nativePtr, j, z);
    }

    public long findFirstDate(long j, Date date) {
        if (date != null) {
            return nativeFindFirstTimestamp(this.nativePtr, j, date.getTime());
        }
        throw new IllegalArgumentException("null is not supported");
    }

    public long findFirstDouble(long j, double d) {
        return nativeFindFirstDouble(this.nativePtr, j, d);
    }

    public long findFirstFloat(long j, float f) {
        return nativeFindFirstFloat(this.nativePtr, j, f);
    }

    public long findFirstLong(long j, long j2) {
        return nativeFindFirstInt(this.nativePtr, j, j2);
    }

    public long findFirstNull(long j) {
        return nativeFindFirstNull(this.nativePtr, j);
    }

    public long findFirstString(long j, String str) {
        if (str != null) {
            return nativeFindFirstString(this.nativePtr, j, str);
        }
        throw new IllegalArgumentException("null is not supported");
    }

    public byte[] getBinaryByteArray(long j, long j2) {
        return nativeGetByteArray(this.nativePtr, j, j2);
    }

    public boolean getBoolean(long j, long j2) {
        return nativeGetBoolean(this.nativePtr, j, j2);
    }

    public CheckedRow getCheckedRow(long j) {
        return CheckedRow.get(this.context, this, j);
    }

    public String getClassName() {
        return getClassNameForTable(getName());
    }

    public long getColumnCount() {
        return nativeGetColumnCount(this.nativePtr);
    }

    public long getColumnIndex(String str) {
        if (str != null) {
            return nativeGetColumnIndex(this.nativePtr, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public String getColumnName(long j) {
        return nativeGetColumnName(this.nativePtr, j);
    }

    public RealmFieldType getColumnType(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.nativePtr, j));
    }

    public Date getDate(long j, long j2) {
        return new Date(nativeGetTimestamp(this.nativePtr, j, j2));
    }

    public double getDouble(long j, long j2) {
        return nativeGetDouble(this.nativePtr, j, j2);
    }

    public float getFloat(long j, long j2) {
        return nativeGetFloat(this.nativePtr, j, j2);
    }

    public long getLink(long j, long j2) {
        return nativeGetLink(this.nativePtr, j, j2);
    }

    public Table getLinkTarget(long j) {
        return new Table(this.sharedRealm, nativeGetLinkTarget(this.nativePtr, j));
    }

    public long getLong(long j, long j2) {
        return nativeGetLong(this.nativePtr, j, j2);
    }

    public String getName() {
        return nativeGetName(this.nativePtr);
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public OsSharedRealm getSharedRealm() {
        return this.sharedRealm;
    }

    public String getString(long j, long j2) {
        return nativeGetString(this.nativePtr, j, j2);
    }

    public Table getTable() {
        return this;
    }

    public UncheckedRow getUncheckedRow(long j) {
        return UncheckedRow.getByRowIndex(this.context, this, j);
    }

    public UncheckedRow getUncheckedRowByPointer(long j) {
        return UncheckedRow.getByRowPointer(this.context, this, j);
    }

    public boolean hasSameSchema(Table table) {
        if (table != null) {
            return nativeHasSameSchema(this.nativePtr, table.nativePtr);
        }
        throw new IllegalArgumentException("The argument cannot be null");
    }

    public boolean hasSearchIndex(long j) {
        return nativeHasSearchIndex(this.nativePtr, j);
    }

    public void incrementLong(long j, long j2, long j3) {
        checkImmutable();
        nativeIncrementLong(this.nativePtr, j, j2, j3);
    }

    public void insertColumn(long j, RealmFieldType realmFieldType, String str) {
        verifyColumnName(str);
        nativeInsertColumn(this.nativePtr, j, realmFieldType.getNativeValue(), str);
    }

    public boolean isColumnNullable(long j) {
        return nativeIsColumnNullable(this.nativePtr, j);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isImmutable() {
        OsSharedRealm osSharedRealm = this.sharedRealm;
        return osSharedRealm != null && !osSharedRealm.isInTransaction();
    }

    public boolean isNull(long j, long j2) {
        return nativeIsNull(this.nativePtr, j, j2);
    }

    public boolean isNullLink(long j, long j2) {
        return nativeIsNullLink(this.nativePtr, j, j2);
    }

    public boolean isValid() {
        long j = this.nativePtr;
        return j != 0 && nativeIsValid(j);
    }

    public void moveLastOver(long j) {
        checkImmutable();
        nativeMoveLastOver(this.nativePtr, j);
    }

    /* access modifiers changed from: package-private */
    public native long nativeGetRowPtr(long j, long j2);

    public void nullifyLink(long j, long j2) {
        nativeNullifyLink(this.nativePtr, j, j2);
    }

    public void removeColumn(long j) {
        String className = getClassName();
        String columnName = getColumnName(j);
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, getClassName());
        nativeRemoveColumn(this.nativePtr, j);
        if (columnName.equals(primaryKeyForObject)) {
            OsObjectStore.setPrimaryKeyForObject(this.sharedRealm, className, (String) null);
        }
    }

    public void removeSearchIndex(long j) {
        checkImmutable();
        nativeRemoveSearchIndex(this.nativePtr, j);
    }

    public void renameColumn(long j, String str) {
        verifyColumnName(str);
        String nativeGetColumnName = nativeGetColumnName(this.nativePtr, j);
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, getClassName());
        nativeRenameColumn(this.nativePtr, j, str);
        if (nativeGetColumnName.equals(primaryKeyForObject)) {
            try {
                OsObjectStore.setPrimaryKeyForObject(this.sharedRealm, getClassName(), str);
            } catch (Exception e) {
                nativeRenameColumn(this.nativePtr, j, nativeGetColumnName);
                throw new RuntimeException(e);
            }
        }
    }

    public void setBinaryByteArray(long j, long j2, byte[] bArr, boolean z) {
        checkImmutable();
        nativeSetByteArray(this.nativePtr, j, j2, bArr, z);
    }

    public void setBoolean(long j, long j2, boolean z, boolean z2) {
        checkImmutable();
        nativeSetBoolean(this.nativePtr, j, j2, z, z2);
    }

    public void setDate(long j, long j2, Date date, boolean z) {
        if (date != null) {
            checkImmutable();
            nativeSetTimestamp(this.nativePtr, j, j2, date.getTime(), z);
            return;
        }
        throw new IllegalArgumentException("Null Date is not allowed.");
    }

    public void setDouble(long j, long j2, double d, boolean z) {
        checkImmutable();
        nativeSetDouble(this.nativePtr, j, j2, d, z);
    }

    public void setFloat(long j, long j2, float f, boolean z) {
        checkImmutable();
        nativeSetFloat(this.nativePtr, j, j2, f, z);
    }

    public void setLink(long j, long j2, long j3, boolean z) {
        checkImmutable();
        nativeSetLink(this.nativePtr, j, j2, j3, z);
    }

    public void setLong(long j, long j2, long j3, boolean z) {
        checkImmutable();
        nativeSetLong(this.nativePtr, j, j2, j3, z);
    }

    public void setNull(long j, long j2, boolean z) {
        checkImmutable();
        nativeSetNull(this.nativePtr, j, j2, z);
    }

    public void setString(long j, long j2, String str, boolean z) {
        checkImmutable();
        long j3 = this.nativePtr;
        long j4 = j;
        long j5 = j2;
        if (str == null) {
            nativeSetNull(j3, j4, j5, z);
        } else {
            nativeSetString(j3, j4, j5, str, z);
        }
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public String toString() {
        long columnCount = getColumnCount();
        String name = getName();
        StringBuilder sb = new StringBuilder("The Table ");
        if (name != null && !name.isEmpty()) {
            sb.append(getName());
            sb.append(" ");
        }
        sb.append("contains ");
        sb.append(columnCount);
        sb.append(" columns: ");
        int i = 0;
        while (true) {
            long j = (long) i;
            if (j < columnCount) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(getColumnName(j));
                i++;
            } else {
                sb.append(".");
                sb.append(" And ");
                sb.append(size());
                sb.append(" rows.");
                return sb.toString();
            }
        }
    }

    public TableQuery where() {
        return new TableQuery(this.context, this, nativeWhere(this.nativePtr));
    }
}
