package p041io.realm;

import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.fields.FieldDescriptor;

/* renamed from: io.realm.SchemaConnector */
class SchemaConnector implements FieldDescriptor.SchemaProxy {
    private final RealmSchema schema;

    public SchemaConnector(RealmSchema realmSchema) {
        this.schema = realmSchema;
    }

    public ColumnInfo getColumnInfo(String str) {
        return this.schema.getColumnInfo(str);
    }

    public long getNativeTablePtr(String str) {
        return this.schema.getTable(str).getNativePtr();
    }

    public boolean hasCache() {
        return this.schema.haveColumnInfo();
    }
}
