package p041io.realm.internal.fields;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import p041io.realm.RealmFieldType;
import p041io.realm.internal.Table;

/* renamed from: io.realm.internal.fields.DynamicFieldDescriptor */
class DynamicFieldDescriptor extends FieldDescriptor {
    private final Table table;

    DynamicFieldDescriptor(Table table2, String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str, set, set2);
        this.table = table2;
    }

    /* access modifiers changed from: protected */
    public void compileFieldDescription(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        Table table2 = this.table;
        String str = null;
        String str2 = null;
        RealmFieldType realmFieldType = null;
        int i = 0;
        while (i < size) {
            str2 = list.get(i);
            if (str2 == null || str2.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            str = table2.getClassName();
            long columnIndex = table2.getColumnIndex(str2);
            if (columnIndex >= 0) {
                realmFieldType = table2.getColumnType(columnIndex);
                if (i < size - 1) {
                    verifyInternalColumnType(str, str2, realmFieldType);
                    table2 = table2.getLinkTarget(columnIndex);
                }
                jArr[i] = columnIndex;
                i++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", new Object[]{str2, str}));
            }
        }
        setCompilationResults(str, str2, realmFieldType, jArr, new long[size]);
    }
}
