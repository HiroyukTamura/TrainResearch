package p041io.realm;

import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.RealmObjectSchema;
import p041io.realm.internal.OsObjectStore;
import p041io.realm.internal.Table;
import p041io.realm.internal.fields.FieldDescriptor;

/* renamed from: io.realm.MutableRealmObjectSchema */
class MutableRealmObjectSchema extends RealmObjectSchema {
    MutableRealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table) {
        super(baseRealm, realmSchema, table, new RealmObjectSchema.DynamicColumnIndices(table));
    }

    private void addModifiers(String str, FieldAttribute[] fieldAttributeArr) {
        if (fieldAttributeArr != null) {
            try {
                if (fieldAttributeArr.length > 0) {
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.INDEXED)) {
                        addIndex(str);
                    }
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.PRIMARY_KEY)) {
                        addPrimaryKey(str);
                    }
                }
            } catch (Exception e) {
                long columnIndex = getColumnIndex(str);
                if (0 != 0) {
                    this.table.removeSearchIndex(columnIndex);
                }
                throw ((RuntimeException) e);
            }
        }
    }

    private void checkAddPrimaryKeyForSync() {
        if (this.realm.configuration.isSyncConfiguration()) {
            throw new UnsupportedOperationException("'addPrimaryKey' is not supported by synced Realms.");
        }
    }

    private void checkEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Null or empty class names are not allowed");
        }
    }

    private void checkFieldNameIsAvailable(String str) {
        if (this.table.getColumnIndex(str) != -1) {
            StringBuilder a = C0681a.m330a("Field already exists in '");
            a.append(getClassName());
            a.append("': ");
            a.append(str);
            throw new IllegalArgumentException(a.toString());
        }
    }

    private void checkNewFieldName(String str) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldNameIsAvailable(str);
    }

    static boolean containsAttribute(FieldAttribute[] fieldAttributeArr, FieldAttribute fieldAttribute) {
        if (!(fieldAttributeArr == null || fieldAttributeArr.length == 0)) {
            for (FieldAttribute fieldAttribute2 : fieldAttributeArr) {
                if (fieldAttribute2 == fieldAttribute) {
                    return true;
                }
            }
        }
        return false;
    }

    public RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr) {
        RealmObjectSchema.FieldMetaData fieldMetaData = RealmObjectSchema.SUPPORTED_SIMPLE_FIELDS.get(cls);
        boolean z = false;
        if (fieldMetaData != null) {
            if (containsAttribute(fieldAttributeArr, FieldAttribute.PRIMARY_KEY)) {
                checkAddPrimaryKeyForSync();
            }
            checkNewFieldName(str);
            boolean z2 = fieldMetaData.defaultNullable;
            if (!containsAttribute(fieldAttributeArr, FieldAttribute.REQUIRED)) {
                z = z2;
            }
            long addColumn = this.table.addColumn(fieldMetaData.fieldType, str, z);
            try {
                addModifiers(str, fieldAttributeArr);
                return this;
            } catch (Exception e) {
                this.table.removeColumn(addColumn);
                throw e;
            }
        } else if (RealmObjectSchema.SUPPORTED_LINKED_FIELDS.containsKey(cls)) {
            throw new IllegalArgumentException(C0681a.m320a("Use addRealmObjectField() instead to add fields that link to other RealmObjects: ", str));
        } else if (RealmModel.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Use 'addRealmObjectField()' instead to add fields that link to other RealmObjects: %s(%s)", new Object[]{str, cls}));
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "Realm doesn't support this field type: %s(%s)", new Object[]{str, cls}));
        }
    }

    public RealmObjectSchema addIndex(String str) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldExists(str);
        long columnIndex = getColumnIndex(str);
        if (!this.table.hasSearchIndex(columnIndex)) {
            this.table.addSearchIndex(columnIndex);
            return this;
        }
        throw new IllegalStateException(C0681a.m320a(str, " already has an index."));
    }

    public RealmObjectSchema addPrimaryKey(String str) {
        checkAddPrimaryKeyForSync();
        RealmObjectSchema.checkLegalName(str);
        checkFieldExists(str);
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName());
        if (primaryKeyForObject == null) {
            long columnIndex = getColumnIndex(str);
            if (!this.table.hasSearchIndex(columnIndex)) {
                this.table.addSearchIndex(columnIndex);
            }
            OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, getClassName(), str);
            return this;
        }
        throw new IllegalStateException(String.format(Locale.ENGLISH, "Field '%s' has been already defined as primary key.", new Object[]{primaryKeyForObject}));
    }

    public RealmObjectSchema addRealmListField(String str, RealmObjectSchema realmObjectSchema) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldNameIsAvailable(str);
        this.table.addColumnLink(RealmFieldType.LIST, str, this.realm.sharedRealm.getTable(Table.getTableNameForClass(realmObjectSchema.getClassName())));
        return this;
    }

    public RealmObjectSchema addRealmListField(String str, Class<?> cls) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldNameIsAvailable(str);
        RealmObjectSchema.FieldMetaData fieldMetaData = RealmObjectSchema.SUPPORTED_SIMPLE_FIELDS.get(cls);
        if (fieldMetaData != null) {
            this.table.addColumn(fieldMetaData.listType, str, fieldMetaData.defaultNullable);
            return this;
        } else if (cls.equals(RealmObjectSchema.class) || RealmModel.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(C0681a.m320a("Use 'addRealmListField(String name, RealmObjectSchema schema)' instead to add lists that link to other RealmObjects: ", str));
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "RealmList does not support lists with this type: %s(%s)", new Object[]{str, cls}));
        }
    }

    public RealmObjectSchema addRealmObjectField(String str, RealmObjectSchema realmObjectSchema) {
        RealmObjectSchema.checkLegalName(str);
        checkFieldNameIsAvailable(str);
        this.table.addColumnLink(RealmFieldType.OBJECT, str, this.realm.sharedRealm.getTable(Table.getTableNameForClass(realmObjectSchema.getClassName())));
        return this;
    }

    /* access modifiers changed from: package-private */
    public FieldDescriptor getColumnIndices(String str, RealmFieldType... realmFieldTypeArr) {
        return FieldDescriptor.createStandardFieldDescriptor(getSchemaConnector(), getTable(), str, realmFieldTypeArr);
    }

    public RealmObjectSchema removeField(String str) {
        this.realm.checkNotInSync();
        RealmObjectSchema.checkLegalName(str);
        if (hasField(str)) {
            long columnIndex = getColumnIndex(str);
            String className = getClassName();
            if (str.equals(OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, className))) {
                OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, className, str);
            }
            this.table.removeColumn(columnIndex);
            return this;
        }
        throw new IllegalStateException(C0681a.m320a(str, " does not exist."));
    }

    public RealmObjectSchema removeIndex(String str) {
        this.realm.checkNotInSync();
        RealmObjectSchema.checkLegalName(str);
        checkFieldExists(str);
        long columnIndex = getColumnIndex(str);
        if (this.table.hasSearchIndex(columnIndex)) {
            this.table.removeSearchIndex(columnIndex);
            return this;
        }
        throw new IllegalStateException(C0681a.m320a("Field is not indexed: ", str));
    }

    public RealmObjectSchema removePrimaryKey() {
        this.realm.checkNotInSync();
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, getClassName());
        if (primaryKeyForObject != null) {
            long columnIndex = this.table.getColumnIndex(primaryKeyForObject);
            if (this.table.hasSearchIndex(columnIndex)) {
                this.table.removeSearchIndex(columnIndex);
            }
            OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, getClassName(), (String) null);
            return this;
        }
        throw new IllegalStateException(getClassName() + " doesn't have a primary key.");
    }

    public RealmObjectSchema renameField(String str, String str2) {
        this.realm.checkNotInSync();
        RealmObjectSchema.checkLegalName(str);
        checkFieldExists(str);
        RealmObjectSchema.checkLegalName(str2);
        checkFieldNameIsAvailable(str2);
        this.table.renameColumn(getColumnIndex(str), str2);
        return this;
    }

    public RealmObjectSchema setClassName(String str) {
        this.realm.checkNotInSync();
        checkEmpty(str);
        String tableNameForClass = Table.getTableNameForClass(str);
        if (str.length() > Table.CLASS_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(Locale.US, "Class name is too long. Limit is %1$d characters: '%2$s' (%3$d)", new Object[]{Integer.valueOf(Table.CLASS_NAME_MAX_LENGTH), str, Integer.valueOf(str.length())}));
        } else if (!this.realm.sharedRealm.hasTable(tableNameForClass)) {
            String name = this.table.getName();
            String className = this.table.getClassName();
            String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(this.realm.sharedRealm, className);
            if (primaryKeyForObject != null) {
                OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, className, (String) null);
            }
            this.realm.sharedRealm.renameTable(name, tableNameForClass);
            if (primaryKeyForObject != null) {
                try {
                    OsObjectStore.setPrimaryKeyForObject(this.realm.sharedRealm, str, primaryKeyForObject);
                } catch (Exception e) {
                    this.realm.sharedRealm.renameTable(this.table.getName(), name);
                    throw e;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException(C0681a.m320a("Class already exists: ", str));
        }
    }

    public RealmObjectSchema setNullable(String str, boolean z) {
        setRequired(str, !z);
        return this;
    }

    public RealmObjectSchema setRequired(String str, boolean z) {
        long columnIndex = this.table.getColumnIndex(str);
        boolean isRequired = isRequired(str);
        RealmFieldType columnType = this.table.getColumnType(columnIndex);
        if (columnType == RealmFieldType.OBJECT) {
            throw new IllegalArgumentException(C0681a.m320a("Cannot modify the required state for RealmObject references: ", str));
        } else if (columnType == RealmFieldType.LIST) {
            throw new IllegalArgumentException(C0681a.m320a("Cannot modify the required state for RealmList references: ", str));
        } else if (z && isRequired) {
            throw new IllegalStateException(C0681a.m320a("Field is already required: ", str));
        } else if (z || isRequired) {
            Table table = this.table;
            if (z) {
                table.convertColumnToNotNullable(columnIndex);
            } else {
                table.convertColumnToNullable(columnIndex);
            }
            return this;
        } else {
            throw new IllegalStateException(C0681a.m320a("Field is already nullable: ", str));
        }
    }

    public RealmObjectSchema transform(RealmObjectSchema.Function function) {
        if (function != null) {
            long size = this.table.size();
            for (long j = 0; j < size; j++) {
                function.apply(new DynamicRealmObject(this.realm, this.table.getCheckedRow(j)));
            }
        }
        return this;
    }
}
