package p041io.realm.internal.fields;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import p041io.realm.RealmFieldType;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.fields.FieldDescriptor;

/* renamed from: io.realm.internal.fields.CachedFieldDescriptor */
class CachedFieldDescriptor extends FieldDescriptor {
    private final String className;
    private final FieldDescriptor.SchemaProxy schema;

    CachedFieldDescriptor(FieldDescriptor.SchemaProxy schemaProxy, String str, String str2, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str2, set, set2);
        this.className = str;
        this.schema = schemaProxy;
    }

    /* access modifiers changed from: protected */
    public void compileFieldDescription(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        String str = null;
        RealmFieldType realmFieldType = null;
        String str2 = this.className;
        int i = 0;
        while (i < size) {
            str = list.get(i);
            if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            ColumnInfo columnInfo = this.schema.getColumnInfo(str2);
            if (columnInfo != null) {
                ColumnInfo.ColumnDetails columnDetails = columnInfo.getColumnDetails(str);
                if (columnDetails != null) {
                    RealmFieldType realmFieldType2 = columnDetails.columnType;
                    if (i < size - 1) {
                        verifyInternalColumnType(str2, str, realmFieldType2);
                        str2 = columnDetails.linkedClassName;
                    }
                    jArr[i] = columnDetails.columnIndex;
                    jArr2[i] = realmFieldType2 != RealmFieldType.LINKING_OBJECTS ? 0 : this.schema.getNativeTablePtr(columnDetails.linkedClassName);
                    i++;
                    realmFieldType = realmFieldType2;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in class '%s'.", new Object[]{str, str2}));
                }
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: class '%s' not found in this schema.", new Object[]{str2}));
            }
        }
        setCompilationResults(str2, str, realmFieldType, jArr, jArr2);
    }
}
