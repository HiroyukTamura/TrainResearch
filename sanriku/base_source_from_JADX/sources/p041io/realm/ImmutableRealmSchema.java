package p041io.realm;

import java.util.LinkedHashSet;
import java.util.Set;
import p041io.realm.internal.ColumnIndices;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Table;

/* renamed from: io.realm.ImmutableRealmSchema */
class ImmutableRealmSchema extends RealmSchema {
    private static final String SCHEMA_IMMUTABLE_EXCEPTION_MSG = "This 'RealmSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.";

    ImmutableRealmSchema(BaseRealm baseRealm, ColumnIndices columnIndices) {
        super(baseRealm, columnIndices);
    }

    public RealmObjectSchema create(String str) {
        throw new UnsupportedOperationException(SCHEMA_IMMUTABLE_EXCEPTION_MSG);
    }

    public RealmObjectSchema createWithPrimaryKeyField(String str, String str2, Class<?> cls, FieldAttribute... fieldAttributeArr) {
        throw new UnsupportedOperationException(SCHEMA_IMMUTABLE_EXCEPTION_MSG);
    }

    public RealmObjectSchema get(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (!this.realm.getSharedRealm().hasTable(tableNameForClass)) {
            return null;
        }
        return new ImmutableRealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(tableNameForClass), getColumnInfo(str));
    }

    public Set<RealmObjectSchema> getAll() {
        RealmProxyMediator schemaMediator = this.realm.getConfiguration().getSchemaMediator();
        Set<Class<? extends RealmModel>> modelClasses = schemaMediator.getModelClasses();
        LinkedHashSet linkedHashSet = new LinkedHashSet(modelClasses.size());
        for (Class<? extends RealmModel> simpleClassName : modelClasses) {
            linkedHashSet.add(get(schemaMediator.getSimpleClassName(simpleClassName)));
        }
        return linkedHashSet;
    }

    public void remove(String str) {
        throw new UnsupportedOperationException(SCHEMA_IMMUTABLE_EXCEPTION_MSG);
    }

    public RealmObjectSchema rename(String str, String str2) {
        throw new UnsupportedOperationException(SCHEMA_IMMUTABLE_EXCEPTION_MSG);
    }
}
