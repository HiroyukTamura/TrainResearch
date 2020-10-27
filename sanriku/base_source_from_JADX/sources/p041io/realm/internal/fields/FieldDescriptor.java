package p041io.realm.internal.fields;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import p041io.realm.RealmFieldType;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.Table;

/* renamed from: io.realm.internal.fields.FieldDescriptor */
public abstract class FieldDescriptor {
    public static final Set<RealmFieldType> ALL_LINK_FIELD_TYPES;
    private static final Pattern FIELD_SEPARATOR = Pattern.compile("\\.");
    public static final Set<RealmFieldType> LIST_LINK_FIELD_TYPE;
    public static final Set<RealmFieldType> NO_LINK_FIELD_TYPE = Collections.emptySet();
    public static final Set<RealmFieldType> OBJECT_LINK_FIELD_TYPE;
    public static final Set<RealmFieldType> SIMPLE_LINK_FIELD_TYPES;
    private long[] columnIndices;
    private final List<String> fields;
    private String finalColumnName;
    private RealmFieldType finalColumnType;
    private long[] nativeTablePointers;
    private final Set<RealmFieldType> validFinalColumnTypes;
    private final Set<RealmFieldType> validInternalColumnTypes;

    /* renamed from: io.realm.internal.fields.FieldDescriptor$SchemaProxy */
    public interface SchemaProxy {
        ColumnInfo getColumnInfo(String str);

        long getNativeTablePtr(String str);

        boolean hasCache();
    }

    static {
        HashSet hashSet = new HashSet(3);
        hashSet.add(RealmFieldType.OBJECT);
        hashSet.add(RealmFieldType.LIST);
        hashSet.add(RealmFieldType.LINKING_OBJECTS);
        ALL_LINK_FIELD_TYPES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(RealmFieldType.OBJECT);
        hashSet2.add(RealmFieldType.LIST);
        SIMPLE_LINK_FIELD_TYPES = Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet(1);
        hashSet3.add(RealmFieldType.LIST);
        LIST_LINK_FIELD_TYPE = Collections.unmodifiableSet(hashSet3);
        HashSet hashSet4 = new HashSet(1);
        hashSet4.add(RealmFieldType.OBJECT);
        OBJECT_LINK_FIELD_TYPE = Collections.unmodifiableSet(hashSet4);
    }

    protected FieldDescriptor(String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        List<String> parseFieldDescription = parseFieldDescription(str);
        this.fields = parseFieldDescription;
        if (parseFieldDescription.size() > 0) {
            this.validInternalColumnTypes = set;
            this.validFinalColumnTypes = set2;
            return;
        }
        throw new IllegalArgumentException("Invalid query: Empty field descriptor");
    }

    private void compileIfNecessary() {
        if (this.finalColumnType == null) {
            compileFieldDescription(this.fields);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: io.realm.internal.fields.CachedFieldDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: io.realm.internal.fields.DynamicFieldDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: io.realm.internal.fields.CachedFieldDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.realm.internal.fields.CachedFieldDescriptor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p041io.realm.internal.fields.FieldDescriptor createFieldDescriptor(p041io.realm.internal.fields.FieldDescriptor.SchemaProxy r7, p041io.realm.internal.Table r8, java.lang.String r9, java.util.Set<p041io.realm.RealmFieldType> r10, java.util.Set<p041io.realm.RealmFieldType> r11) {
        /*
            if (r7 == 0) goto L_0x001d
            boolean r0 = r7.hasCache()
            if (r0 != 0) goto L_0x0009
            goto L_0x001d
        L_0x0009:
            io.realm.internal.fields.CachedFieldDescriptor r0 = new io.realm.internal.fields.CachedFieldDescriptor
            java.lang.String r3 = r8.getClassName()
            if (r10 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            java.util.Set<io.realm.RealmFieldType> r10 = ALL_LINK_FIELD_TYPES
        L_0x0014:
            r5 = r10
            r1 = r0
            r2 = r7
            r4 = r9
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0027
        L_0x001d:
            io.realm.internal.fields.DynamicFieldDescriptor r0 = new io.realm.internal.fields.DynamicFieldDescriptor
            if (r10 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            java.util.Set<io.realm.RealmFieldType> r10 = SIMPLE_LINK_FIELD_TYPES
        L_0x0024:
            r0.<init>(r8, r9, r10, r11)
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.internal.fields.FieldDescriptor.createFieldDescriptor(io.realm.internal.fields.FieldDescriptor$SchemaProxy, io.realm.internal.Table, java.lang.String, java.util.Set, java.util.Set):io.realm.internal.fields.FieldDescriptor");
    }

    public static FieldDescriptor createStandardFieldDescriptor(SchemaProxy schemaProxy, Table table, String str, RealmFieldType... realmFieldTypeArr) {
        return createFieldDescriptor(schemaProxy, table, str, (Set<RealmFieldType>) null, new HashSet(Arrays.asList(realmFieldTypeArr)));
    }

    private List<String> parseFieldDescription(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Invalid query: field name is empty");
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != str.length() - 1) {
            return lastIndexOf > -1 ? Arrays.asList(FIELD_SEPARATOR.split(str)) : Collections.singletonList(str);
        }
        throw new IllegalArgumentException("Invalid query: field name must not end with a period ('.')");
    }

    private void verifyColumnType(String str, String str2, RealmFieldType realmFieldType, Set<RealmFieldType> set) {
        if (!set.contains(realmFieldType)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' in class '%s' is of invalid type '%s'.", new Object[]{str2, str, realmFieldType.toString()}));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void compileFieldDescription(List<String> list);

    public final long[] getColumnIndices() {
        compileIfNecessary();
        long[] jArr = this.columnIndices;
        return Arrays.copyOf(jArr, jArr.length);
    }

    public final String getFinalColumnName() {
        compileIfNecessary();
        return this.finalColumnName;
    }

    public final RealmFieldType getFinalColumnType() {
        compileIfNecessary();
        return this.finalColumnType;
    }

    public final long[] getNativeTablePointers() {
        compileIfNecessary();
        long[] jArr = this.nativeTablePointers;
        return Arrays.copyOf(jArr, jArr.length);
    }

    public final int length() {
        return this.fields.size();
    }

    /* access modifiers changed from: protected */
    public final void setCompilationResults(String str, String str2, RealmFieldType realmFieldType, long[] jArr, long[] jArr2) {
        Set<RealmFieldType> set = this.validFinalColumnTypes;
        if (set != null && set.size() > 0) {
            verifyColumnType(str, str2, realmFieldType, this.validFinalColumnTypes);
        }
        this.finalColumnName = str2;
        this.finalColumnType = realmFieldType;
        this.columnIndices = jArr;
        this.nativeTablePointers = jArr2;
    }

    /* access modifiers changed from: protected */
    public final void verifyInternalColumnType(String str, String str2, RealmFieldType realmFieldType) {
        verifyColumnType(str, str2, realmFieldType, this.validInternalColumnTypes);
    }
}
