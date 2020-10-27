package p041io.realm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.ColumnIndices;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.Table;
import p041io.realm.internal.Util;

/* renamed from: io.realm.RealmSchema */
public abstract class RealmSchema {
    static final String EMPTY_STRING_MSG = "Null or empty class names are not allowed";
    private final Map<Class<? extends RealmModel>, RealmObjectSchema> classToSchema = new HashMap();
    private final Map<Class<? extends RealmModel>, Table> classToTable = new HashMap();
    private final ColumnIndices columnIndices;
    private final Map<String, RealmObjectSchema> dynamicClassToSchema = new HashMap();
    private final Map<String, Table> dynamicClassToTable = new HashMap();
    final BaseRealm realm;

    RealmSchema(BaseRealm baseRealm, ColumnIndices columnIndices2) {
        this.realm = baseRealm;
        this.columnIndices = columnIndices2;
    }

    private void checkIndices() {
        if (!haveColumnInfo()) {
            throw new IllegalStateException("Attempt to use column index before set.");
        }
    }

    private boolean isProxyClass(Class<? extends RealmModel> cls, Class<? extends RealmModel> cls2) {
        return cls.equals(cls2);
    }

    /* access modifiers changed from: package-private */
    public void checkHasTable(String str, String str2) {
        if (!this.realm.getSharedRealm().hasTable(Table.getTableNameForClass(str))) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkNotEmpty(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    public boolean contains(String str) {
        return this.realm.getSharedRealm().hasTable(Table.getTableNameForClass(str));
    }

    public abstract RealmObjectSchema create(String str);

    public abstract RealmObjectSchema createWithPrimaryKeyField(String str, String str2, Class<?> cls, FieldAttribute... fieldAttributeArr);

    public abstract RealmObjectSchema get(String str);

    public abstract Set<RealmObjectSchema> getAll();

    /* access modifiers changed from: package-private */
    public final ColumnInfo getColumnInfo(Class<? extends RealmModel> cls) {
        checkIndices();
        return this.columnIndices.getColumnInfo(cls);
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo getColumnInfo(String str) {
        checkIndices();
        return this.columnIndices.getColumnInfo(str);
    }

    /* access modifiers changed from: package-private */
    public RealmObjectSchema getSchemaForClass(Class<? extends RealmModel> cls) {
        ImmutableRealmObjectSchema immutableRealmObjectSchema = this.classToSchema.get(cls);
        if (immutableRealmObjectSchema != null) {
            return immutableRealmObjectSchema;
        }
        Class<? extends RealmModel> originalModelClass = Util.getOriginalModelClass(cls);
        if (isProxyClass(originalModelClass, cls)) {
            immutableRealmObjectSchema = this.classToSchema.get(originalModelClass);
        }
        if (immutableRealmObjectSchema == null) {
            ImmutableRealmObjectSchema immutableRealmObjectSchema2 = new ImmutableRealmObjectSchema(this.realm, this, getTable(cls), getColumnInfo(originalModelClass));
            this.classToSchema.put(originalModelClass, immutableRealmObjectSchema2);
            immutableRealmObjectSchema = immutableRealmObjectSchema2;
        }
        if (isProxyClass(originalModelClass, cls)) {
            this.classToSchema.put(cls, immutableRealmObjectSchema);
        }
        return immutableRealmObjectSchema;
    }

    /* access modifiers changed from: package-private */
    public RealmObjectSchema getSchemaForClass(String str) {
        String tableNameForClass = Table.getTableNameForClass(str);
        RealmObjectSchema realmObjectSchema = this.dynamicClassToSchema.get(tableNameForClass);
        if (realmObjectSchema != null && realmObjectSchema.getTable().isValid() && realmObjectSchema.getClassName().equals(str)) {
            return realmObjectSchema;
        }
        if (this.realm.getSharedRealm().hasTable(tableNameForClass)) {
            BaseRealm baseRealm = this.realm;
            ImmutableRealmObjectSchema immutableRealmObjectSchema = new ImmutableRealmObjectSchema(baseRealm, this, baseRealm.getSharedRealm().getTable(tableNameForClass));
            this.dynamicClassToSchema.put(tableNameForClass, immutableRealmObjectSchema);
            return immutableRealmObjectSchema;
        }
        throw new IllegalArgumentException(C0681a.m321a("The class ", str, " doesn't exist in this Realm."));
    }

    /* access modifiers changed from: package-private */
    public Table getTable(Class<? extends RealmModel> cls) {
        Table table = this.classToTable.get(cls);
        if (table != null) {
            return table;
        }
        Class<? extends RealmModel> originalModelClass = Util.getOriginalModelClass(cls);
        if (isProxyClass(originalModelClass, cls)) {
            table = this.classToTable.get(originalModelClass);
        }
        if (table == null) {
            table = this.realm.getSharedRealm().getTable(Table.getTableNameForClass(this.realm.getConfiguration().getSchemaMediator().getSimpleClassName(originalModelClass)));
            this.classToTable.put(originalModelClass, table);
        }
        if (isProxyClass(originalModelClass, cls)) {
            this.classToTable.put(cls, table);
        }
        return table;
    }

    /* access modifiers changed from: package-private */
    public Table getTable(String str) {
        String tableNameForClass = Table.getTableNameForClass(str);
        Table table = this.dynamicClassToTable.get(tableNameForClass);
        if (table != null) {
            return table;
        }
        Table table2 = this.realm.getSharedRealm().getTable(tableNameForClass);
        this.dynamicClassToTable.put(tableNameForClass, table2);
        return table2;
    }

    /* access modifiers changed from: package-private */
    public final boolean haveColumnInfo() {
        return this.columnIndices != null;
    }

    /* access modifiers changed from: package-private */
    public final void putToClassNameToSchemaMap(String str, RealmObjectSchema realmObjectSchema) {
        this.dynamicClassToSchema.put(str, realmObjectSchema);
    }

    /* access modifiers changed from: package-private */
    public void refresh() {
        ColumnIndices columnIndices2 = this.columnIndices;
        if (columnIndices2 != null) {
            columnIndices2.refresh();
        }
        this.dynamicClassToTable.clear();
        this.classToTable.clear();
        this.classToSchema.clear();
        this.dynamicClassToSchema.clear();
    }

    public abstract void remove(String str);

    /* access modifiers changed from: package-private */
    public final RealmObjectSchema removeFromClassNameToSchemaMap(String str) {
        return this.dynamicClassToSchema.remove(str);
    }

    public abstract RealmObjectSchema rename(String str, String str2);
}
