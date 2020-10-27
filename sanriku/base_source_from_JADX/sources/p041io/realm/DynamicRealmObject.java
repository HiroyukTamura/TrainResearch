package p041io.realm;

import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.CheckedRow;
import p041io.realm.internal.OsList;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.UncheckedRow;
import p041io.realm.internal.android.JsonUtils;

/* renamed from: io.realm.DynamicRealmObject */
public class DynamicRealmObject extends RealmObject implements RealmObjectProxy {
    static final String MSG_LINK_QUERY_NOT_SUPPORTED = "Queries across relationships are not supported";
    private final ProxyState<DynamicRealmObject> proxyState;

    /* renamed from: io.realm.DynamicRealmObject$1 */
    static /* synthetic */ class C19601 {
        static final /* synthetic */ int[] $SwitchMap$io$realm$RealmFieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|(3:59|60|62)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0081 */
        static {
            /*
                io.realm.RealmFieldType[] r0 = p041io.realm.RealmFieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$realm$RealmFieldType = r0
                io.realm.RealmFieldType r1 = p041io.realm.RealmFieldType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.INTEGER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                r2 = 5
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x001e }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001e }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r3 = 4
                r4 = 6
                int[] r5 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0026 }
                io.realm.RealmFieldType r6 = p041io.realm.RealmFieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0026 }
                r5[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r5 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x002c }
                io.realm.RealmFieldType r6 = p041io.realm.RealmFieldType.STRING     // Catch:{ NoSuchFieldError -> 0x002c }
                r5[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0032 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.BINARY     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r0 = 7
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0039 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.DATE     // Catch:{ NoSuchFieldError -> 0x0039 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r1 = 8
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0041 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.OBJECT     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                r0 = 9
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.LIST     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r1 = 10
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0051 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.LINKING_OBJECTS     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r0 = 11
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0059 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.INTEGER_LIST     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                r1 = 12
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0061 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BOOLEAN_LIST     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                r0 = 13
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0069 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.STRING_LIST     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                r1 = 14
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0071 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.BINARY_LIST     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                r0 = 15
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0079 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.DATE_LIST     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                r1 = 16
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0081 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.FLOAT_LIST     // Catch:{ NoSuchFieldError -> 0x0081 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0089 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.DOUBLE_LIST     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p041io.realm.DynamicRealmObject.C19601.<clinit>():void");
        }
    }

    DynamicRealmObject(BaseRealm baseRealm, Row row) {
        ProxyState<DynamicRealmObject> proxyState2 = new ProxyState<>(this);
        this.proxyState = proxyState2;
        proxyState2.setRealm$realm(baseRealm);
        this.proxyState.setRow$realm(row);
        this.proxyState.setConstructionFinished();
    }

    public DynamicRealmObject(RealmModel realmModel) {
        this.proxyState = new ProxyState<>(this);
        if (realmModel == null) {
            throw new IllegalArgumentException("A non-null object must be provided.");
        } else if (realmModel instanceof DynamicRealmObject) {
            throw new IllegalArgumentException("The object is already a DynamicRealmObject: " + realmModel);
        } else if (!RealmObject.isManaged(realmModel)) {
            throw new IllegalArgumentException("An object managed by Realm must be provided. This is an unmanaged object.");
        } else if (RealmObject.isValid(realmModel)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) realmModel;
            Row row$realm = realmObjectProxy.realmGet$proxyState().getRow$realm();
            this.proxyState.setRealm$realm(realmObjectProxy.realmGet$proxyState().getRealm$realm());
            this.proxyState.setRow$realm(((UncheckedRow) row$realm).convertToChecked());
            this.proxyState.setConstructionFinished();
        } else {
            throw new IllegalArgumentException("A valid object managed by Realm must be provided. This object was deleted.");
        }
    }

    private void checkFieldType(String str, long j, RealmFieldType realmFieldType) {
        RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(j);
        if (columnType != realmFieldType) {
            String str2 = "n";
            String str3 = (realmFieldType == RealmFieldType.INTEGER || realmFieldType == RealmFieldType.OBJECT) ? str2 : "";
            if (!(columnType == RealmFieldType.INTEGER || columnType == RealmFieldType.OBJECT)) {
                str2 = "";
            }
            throw new IllegalArgumentException(String.format(Locale.US, "'%s' is not a%s '%s', but a%s '%s'.", new Object[]{str, str3, realmFieldType, str2, columnType}));
        }
    }

    private void checkIsPrimaryKey(String str) {
        RealmObjectSchema schemaForClass = this.proxyState.getRealm$realm().getSchema().getSchemaForClass(getType());
        if (schemaForClass.hasPrimaryKey() && schemaForClass.getPrimaryKey().equals(str)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Primary key field '%s' cannot be changed after object was created.", new Object[]{str}));
        }
    }

    private <E> RealmFieldType classToRealmType(Class<E> cls) {
        if (cls.equals(Integer.class) || cls.equals(Long.class) || cls.equals(Short.class) || cls.equals(Byte.class)) {
            return RealmFieldType.INTEGER_LIST;
        }
        if (cls.equals(Boolean.class)) {
            return RealmFieldType.BOOLEAN_LIST;
        }
        if (cls.equals(String.class)) {
            return RealmFieldType.STRING_LIST;
        }
        if (cls.equals(byte[].class)) {
            return RealmFieldType.BINARY_LIST;
        }
        if (cls.equals(Date.class)) {
            return RealmFieldType.DATE_LIST;
        }
        if (cls.equals(Float.class)) {
            return RealmFieldType.FLOAT_LIST;
        }
        if (cls.equals(Double.class)) {
            return RealmFieldType.DOUBLE_LIST;
        }
        throw new IllegalArgumentException("Unsupported element type. Only primitive types supported. Yours was: " + cls);
    }

    private <E> ManagedListOperator<E> getOperator(BaseRealm baseRealm, OsList osList, RealmFieldType realmFieldType, Class<E> cls) {
        if (realmFieldType == RealmFieldType.STRING_LIST) {
            return new StringListOperator(baseRealm, osList, cls);
        }
        if (realmFieldType == RealmFieldType.INTEGER_LIST) {
            return new LongListOperator(baseRealm, osList, cls);
        }
        if (realmFieldType == RealmFieldType.BOOLEAN_LIST) {
            return new BooleanListOperator(baseRealm, osList, cls);
        }
        if (realmFieldType == RealmFieldType.BINARY_LIST) {
            return new BinaryListOperator(baseRealm, osList, cls);
        }
        if (realmFieldType == RealmFieldType.DOUBLE_LIST) {
            return new DoubleListOperator(baseRealm, osList, cls);
        }
        if (realmFieldType == RealmFieldType.FLOAT_LIST) {
            return new FloatListOperator(baseRealm, osList, cls);
        }
        if (realmFieldType == RealmFieldType.DATE_LIST) {
            return new DateListOperator(baseRealm, osList, cls);
        }
        StringBuilder a = C0681a.m330a("Unexpected list type: ");
        a.append(realmFieldType.name());
        throw new IllegalArgumentException(a.toString());
    }

    private void setModelList(String str, RealmList<DynamicRealmObject> realmList) {
        boolean z;
        OsList modelList = this.proxyState.getRow$realm().getModelList(this.proxyState.getRow$realm().getColumnIndex(str));
        Table targetTable = modelList.getTargetTable();
        String className = targetTable.getClassName();
        if (realmList.className == null && realmList.clazz == null) {
            z = false;
        } else {
            String str2 = realmList.className;
            if (str2 == null) {
                str2 = this.proxyState.getRealm$realm().getSchema().getTable((Class<? extends RealmModel>) realmList.clazz).getClassName();
            }
            if (className.equals(str2)) {
                z = true;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "The elements in the list are not the proper type. Was %s expected %s.", new Object[]{str2, className}));
            }
        }
        int size = realmList.size();
        long[] jArr = new long[size];
        int i = 0;
        while (i < size) {
            RealmObjectProxy realmObjectProxy = realmList.get(i);
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != this.proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element in 'list' must belong to the same Realm instance.");
            } else if (z || targetTable.hasSameSchema(realmObjectProxy.realmGet$proxyState().getRow$realm().getTable())) {
                jArr[i] = C0681a.m304a(realmObjectProxy);
                i++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Element at index %d is not the proper type. Was '%s' expected '%s'.", new Object[]{Integer.valueOf(i), realmObjectProxy.realmGet$proxyState().getRow$realm().getTable().getClassName(), className}));
            }
        }
        modelList.removeAll();
        for (int i2 = 0; i2 < size; i2++) {
            modelList.addRow(jArr[i2]);
        }
    }

    private void setValue(String str, Object obj) {
        Class<?> cls = obj.getClass();
        if (cls == Boolean.class) {
            setBoolean(str, ((Boolean) obj).booleanValue());
        } else if (cls == Short.class) {
            setShort(str, ((Short) obj).shortValue());
        } else if (cls == Integer.class) {
            setInt(str, ((Integer) obj).intValue());
        } else if (cls == Long.class) {
            setLong(str, ((Long) obj).longValue());
        } else if (cls == Byte.class) {
            setByte(str, ((Byte) obj).byteValue());
        } else if (cls == Float.class) {
            setFloat(str, ((Float) obj).floatValue());
        } else if (cls == Double.class) {
            setDouble(str, ((Double) obj).doubleValue());
        } else if (cls == String.class) {
            setString(str, (String) obj);
        } else if (obj instanceof Date) {
            setDate(str, (Date) obj);
        } else if (obj instanceof byte[]) {
            setBlob(str, (byte[]) obj);
        } else if (cls == DynamicRealmObject.class) {
            setObject(str, (DynamicRealmObject) obj);
        } else if (cls == RealmList.class) {
            setList(str, (RealmList) obj);
        } else {
            StringBuilder a = C0681a.m330a("Value is of an type not supported: ");
            a.append(obj.getClass());
            throw new IllegalArgumentException(a.toString());
        }
    }

    private <E> void setValueList(String str, RealmList<E> realmList, RealmFieldType realmFieldType) {
        Class cls;
        OsList valueList = this.proxyState.getRow$realm().getValueList(this.proxyState.getRow$realm().getColumnIndex(str), realmFieldType);
        switch (realmFieldType.ordinal()) {
            case 10:
                cls = Long.class;
                break;
            case 11:
                cls = Boolean.class;
                break;
            case 12:
                cls = String.class;
                break;
            case 13:
                cls = byte[].class;
                break;
            case 14:
                cls = Date.class;
                break;
            case 15:
                cls = Float.class;
                break;
            case 16:
                cls = Double.class;
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + realmFieldType);
        }
        ManagedListOperator operator = getOperator(this.proxyState.getRealm$realm(), valueList, realmFieldType, cls);
        if (!realmList.isManaged() || valueList.size() != ((long) realmList.size())) {
            valueList.removeAll();
            Iterator<E> it = realmList.iterator();
            while (it.hasNext()) {
                operator.append(it.next());
            }
            return;
        }
        int size = realmList.size();
        Iterator<E> it2 = realmList.iterator();
        for (int i = 0; i < size; i++) {
            operator.set(i, it2.next());
        }
    }

    public boolean equals(Object obj) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this == obj) {
            return true;
        }
        if (obj == null || DynamicRealmObject.class != obj.getClass()) {
            return false;
        }
        DynamicRealmObject dynamicRealmObject = (DynamicRealmObject) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = dynamicRealmObject.proxyState.getRealm$realm().getPath();
        if (path == null ? path2 != null : !path.equals(path2)) {
            return false;
        }
        String a = C0681a.m315a((ProxyState) this.proxyState);
        String a2 = C0681a.m315a((ProxyState) dynamicRealmObject.proxyState);
        if (a == null ? a2 == null : a.equals(a2)) {
            return this.proxyState.getRow$realm().getIndex() == dynamicRealmObject.proxyState.getRow$realm().getIndex();
        }
        return false;
    }

    public <E> E get(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(columnIndex);
        switch (columnType.ordinal()) {
            case 0:
                return Long.valueOf(this.proxyState.getRow$realm().getLong(columnIndex));
            case 1:
                return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(columnIndex));
            case 2:
                return this.proxyState.getRow$realm().getString(columnIndex);
            case 3:
                return this.proxyState.getRow$realm().getBinaryByteArray(columnIndex);
            case 4:
                return this.proxyState.getRow$realm().getDate(columnIndex);
            case 5:
                return Float.valueOf(this.proxyState.getRow$realm().getFloat(columnIndex));
            case 6:
                return Double.valueOf(this.proxyState.getRow$realm().getDouble(columnIndex));
            case 7:
                return getObject(str);
            case 8:
                return getList(str);
            default:
                throw new IllegalStateException("Field type not supported: " + columnType);
        }
    }

    public byte[] getBlob(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getBinaryByteArray(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.BINARY);
            throw e;
        }
    }

    public boolean getBoolean(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getBoolean(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.BOOLEAN);
            throw e;
        }
    }

    public byte getByte(String str) {
        return (byte) ((int) getLong(str));
    }

    public Date getDate(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        checkFieldType(str, columnIndex, RealmFieldType.DATE);
        if (this.proxyState.getRow$realm().isNull(columnIndex)) {
            return null;
        }
        return this.proxyState.getRow$realm().getDate(columnIndex);
    }

    public double getDouble(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getDouble(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.DOUBLE);
            throw e;
        }
    }

    public DynamicRealm getDynamicRealm() {
        BaseRealm realm$realm = realmGet$proxyState().getRealm$realm();
        realm$realm.checkIfValid();
        if (isValid()) {
            return (DynamicRealm) realm$realm;
        }
        throw new IllegalStateException("the object is already deleted.");
    }

    public String[] getFieldNames() {
        this.proxyState.getRealm$realm().checkIfValid();
        int columnCount = (int) this.proxyState.getRow$realm().getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            strArr[i] = this.proxyState.getRow$realm().getColumnName((long) i);
        }
        return strArr;
    }

    public RealmFieldType getFieldType(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(str));
    }

    public float getFloat(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getFloat(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.FLOAT);
            throw e;
        }
    }

    public int getInt(String str) {
        return (int) getLong(str);
    }

    public RealmList<DynamicRealmObject> getList(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            OsList modelList = this.proxyState.getRow$realm().getModelList(columnIndex);
            return new RealmList<>(modelList.getTargetTable().getClassName(), modelList, this.proxyState.getRealm$realm());
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.LIST);
            throw e;
        }
    }

    public <E> RealmList<E> getList(String str, Class<E> cls) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (cls != null) {
            long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
            RealmFieldType classToRealmType = classToRealmType(cls);
            try {
                return new RealmList<>(cls, this.proxyState.getRow$realm().getValueList(columnIndex, classToRealmType), this.proxyState.getRealm$realm());
            } catch (IllegalArgumentException e) {
                checkFieldType(str, columnIndex, classToRealmType);
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Non-null 'primitiveType' required.");
        }
    }

    public long getLong(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getLong(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.INTEGER);
            throw e;
        }
    }

    public DynamicRealmObject getObject(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        checkFieldType(str, columnIndex, RealmFieldType.OBJECT);
        if (this.proxyState.getRow$realm().isNullLink(columnIndex)) {
            return null;
        }
        return new DynamicRealmObject(this.proxyState.getRealm$realm(), this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getCheckedRow(this.proxyState.getRow$realm().getLink(columnIndex)));
    }

    public short getShort(String str) {
        return (short) ((int) getLong(str));
    }

    public String getString(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getString(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.STRING);
            throw e;
        }
    }

    public String getType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getTable().getClassName();
    }

    public boolean hasField(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (str == null || str.isEmpty()) {
            return false;
        }
        return this.proxyState.getRow$realm().hasColumn(str);
    }

    public int hashCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        String path = this.proxyState.getRealm$realm().getPath();
        String a = C0681a.m315a((ProxyState) this.proxyState);
        long index = this.proxyState.getRow$realm().getIndex();
        int i = 0;
        int hashCode = ((path != null ? path.hashCode() : 0) + 527) * 31;
        if (a != null) {
            i = a.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (index ^ (index >>> 32)));
    }

    public boolean isNull(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        switch (this.proxyState.getRow$realm().getColumnType(columnIndex).ordinal()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return this.proxyState.getRow$realm().isNull(columnIndex);
            case 7:
                return this.proxyState.getRow$realm().isNullLink(columnIndex);
            default:
                return false;
        }
    }

    public RealmResults<DynamicRealmObject> linkingObjects(String str, String str2) {
        DynamicRealm dynamicRealm = (DynamicRealm) this.proxyState.getRealm$realm();
        dynamicRealm.checkIfValid();
        this.proxyState.getRow$realm().checkIfAttached();
        RealmObjectSchema realmObjectSchema = dynamicRealm.getSchema().get(str);
        if (realmObjectSchema == null) {
            throw new IllegalArgumentException(C0681a.m320a("Class not found: ", str));
        } else if (str2 == null) {
            throw new IllegalArgumentException("Non-null 'srcFieldName' required.");
        } else if (!str2.contains(".")) {
            RealmFieldType fieldType = realmObjectSchema.getFieldType(str2);
            if (fieldType == RealmFieldType.OBJECT || fieldType == RealmFieldType.LIST) {
                return RealmResults.createDynamicBacklinkResults(dynamicRealm, (CheckedRow) this.proxyState.getRow$realm(), realmObjectSchema.getTable(), str2);
            }
            Locale locale = Locale.US;
            RealmFieldType realmFieldType = RealmFieldType.OBJECT;
            RealmFieldType realmFieldType2 = RealmFieldType.LIST;
            throw new IllegalArgumentException(String.format(locale, "Unexpected field type: %1$s. Field type should be either %2$s.%3$s or %2$s.%4$s.", new Object[]{fieldType.name(), RealmFieldType.class.getSimpleName(), "OBJECT", "LIST"}));
        } else {
            throw new IllegalArgumentException(MSG_LINK_QUERY_NOT_SUPPORTED);
        }
    }

    public void realm$injectObjectContext() {
    }

    public ProxyState realmGet$proxyState() {
        return this.proxyState;
    }

    public void set(String str, Object obj) {
        this.proxyState.getRealm$realm().checkIfValid();
        boolean z = obj instanceof String;
        String str2 = z ? (String) obj : null;
        RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(str));
        if (z && columnType != RealmFieldType.STRING) {
            int ordinal = columnType.ordinal();
            if (ordinal == 0) {
                obj = Long.valueOf(Long.parseLong(str2));
            } else if (ordinal == 1) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str2));
            } else if (ordinal == 4) {
                obj = JsonUtils.stringToDate(str2);
            } else if (ordinal == 5) {
                obj = Float.valueOf(Float.parseFloat(str2));
            } else if (ordinal == 6) {
                obj = Double.valueOf(Double.parseDouble(str2));
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Field %s is not a String field, and the provide value could not be automatically converted: %s. Use a typedsetter instead", new Object[]{str, obj}));
            }
        }
        if (obj == null) {
            setNull(str);
        } else {
            setValue(str, obj);
        }
    }

    public void setBlob(String str, byte[] bArr) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setBinaryByteArray(this.proxyState.getRow$realm().getColumnIndex(str), bArr);
    }

    public void setBoolean(String str, boolean z) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setBoolean(this.proxyState.getRow$realm().getColumnIndex(str), z);
    }

    public void setByte(String str, byte b) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), (long) b);
    }

    public void setDate(String str, Date date) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        Row row$realm = this.proxyState.getRow$realm();
        if (date == null) {
            row$realm.setNull(columnIndex);
        } else {
            row$realm.setDate(columnIndex, date);
        }
    }

    public void setDouble(String str, double d) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setDouble(this.proxyState.getRow$realm().getColumnIndex(str), d);
    }

    public void setFloat(String str, float f) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setFloat(this.proxyState.getRow$realm().getColumnIndex(str), f);
    }

    public void setInt(String str, int i) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), (long) i);
    }

    public <E> void setList(String str, RealmList<E> realmList) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (realmList != null) {
            RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(str));
            switch (columnType.ordinal()) {
                case 8:
                    if (!realmList.isEmpty()) {
                        E first = realmList.first();
                        if (!(first instanceof DynamicRealmObject) && RealmModel.class.isAssignableFrom(first.getClass())) {
                            throw new IllegalArgumentException("RealmList must contain `DynamicRealmObject's, not Java model classes.");
                        }
                    }
                    setModelList(str, realmList);
                    return;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    setValueList(str, realmList, columnType);
                    return;
                default:
                    throw new IllegalArgumentException(String.format("Field '%s' is not a list but a %s", new Object[]{str, columnType}));
            }
        } else {
            throw new IllegalArgumentException("Non-null 'list' required");
        }
    }

    public void setLong(String str, long j) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), j);
    }

    public void setNull(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        if (this.proxyState.getRow$realm().getColumnType(columnIndex) == RealmFieldType.OBJECT) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
            return;
        }
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setNull(columnIndex);
    }

    public void setObject(String str, DynamicRealmObject dynamicRealmObject) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        if (dynamicRealmObject == null) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
        } else if (dynamicRealmObject.proxyState.getRealm$realm() == null || dynamicRealmObject.proxyState.getRow$realm() == null) {
            throw new IllegalArgumentException("Cannot link to objects that are not part of the Realm.");
        } else if (this.proxyState.getRealm$realm() == dynamicRealmObject.proxyState.getRealm$realm()) {
            Table linkTarget = this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex);
            Table table = dynamicRealmObject.proxyState.getRow$realm().getTable();
            if (linkTarget.hasSameSchema(table)) {
                this.proxyState.getRow$realm().setLink(columnIndex, dynamicRealmObject.proxyState.getRow$realm().getIndex());
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Type of object is wrong. Was %s, expected %s", new Object[]{table.getName(), linkTarget.getName()}));
        } else {
            throw new IllegalArgumentException("Cannot add an object from another Realm instance.");
        }
    }

    public void setShort(String str, short s) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), (long) s);
    }

    public void setString(String str, String str2) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setString(this.proxyState.getRow$realm().getColumnIndex(str), str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0248, code lost:
        r1.append(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x024c, code lost:
        r1.append(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x024f, code lost:
        r1.append("},");
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r11 = this;
            io.realm.ProxyState<io.realm.DynamicRealmObject> r0 = r11.proxyState
            io.realm.BaseRealm r0 = r0.getRealm$realm()
            r0.checkIfValid()
            io.realm.ProxyState<io.realm.DynamicRealmObject> r0 = r11.proxyState
            io.realm.internal.Row r0 = r0.getRow$realm()
            boolean r0 = r0.isAttached()
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "Invalid object"
            return r0
        L_0x0018:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r0 = r11.proxyState
            io.realm.internal.Row r0 = r0.getRow$realm()
            io.realm.internal.Table r0 = r0.getTable()
            java.lang.String r0 = r0.getClassName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " = dynamic["
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m320a((java.lang.String) r0, (java.lang.String) r2)
            r1.<init>(r0)
            java.lang.String[] r0 = r11.getFieldNames()
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x0038:
            r5 = 1
            if (r4 >= r2) goto L_0x0258
            r6 = r0[r4]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r7 = r11.proxyState
            io.realm.internal.Row r7 = r7.getRow$realm()
            long r7 = r7.getColumnIndex(r6)
            io.realm.ProxyState<io.realm.DynamicRealmObject> r9 = r11.proxyState
            io.realm.internal.Row r9 = r9.getRow$realm()
            io.realm.RealmFieldType r9 = r9.getColumnType(r7)
            java.lang.String r10 = "{"
            r1.append(r10)
            r1.append(r6)
            java.lang.String r6 = ":"
            r1.append(r6)
            int r6 = r9.ordinal()
            java.lang.String r10 = "null"
            switch(r6) {
                case 0: goto L_0x022d;
                case 1: goto L_0x0211;
                case 2: goto L_0x0206;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01df;
                case 5: goto L_0x01c2;
                case 6: goto L_0x01a4;
                case 7: goto L_0x0180;
                case 8: goto L_0x014b;
                case 9: goto L_0x0067;
                case 10: goto L_0x012b;
                case 11: goto L_0x010b;
                case 12: goto L_0x00eb;
                case 13: goto L_0x00cb;
                case 14: goto L_0x00ab;
                case 15: goto L_0x008b;
                case 16: goto L_0x006b;
                default: goto L_0x0067;
            }
        L_0x0067:
            java.lang.String r5 = "?"
            goto L_0x024c
        L_0x006b:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<Double>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x008b:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<Float>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x00ab:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<Date>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x00cb:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<byte[]>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x00eb:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<String>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x010b:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<Boolean>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x012b:
            java.util.Locale r6 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r5]
            io.realm.ProxyState<io.realm.DynamicRealmObject> r10 = r11.proxyState
            io.realm.internal.Row r10 = r10.getRow$realm()
            io.realm.internal.OsList r7 = r10.getValueList(r7, r9)
            long r7 = r7.size()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5[r3] = r7
            java.lang.String r7 = "RealmList<Long>[%s]"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            goto L_0x024c
        L_0x014b:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r6 = r11.proxyState
            io.realm.internal.Row r6 = r6.getRow$realm()
            io.realm.internal.Table r6 = r6.getTable()
            io.realm.internal.Table r6 = r6.getLinkTarget(r7)
            java.lang.String r6 = r6.getClassName()
            java.util.Locale r9 = java.util.Locale.US
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r3] = r6
            io.realm.ProxyState<io.realm.DynamicRealmObject> r6 = r11.proxyState
            io.realm.internal.Row r6 = r6.getRow$realm()
            io.realm.internal.OsList r6 = r6.getModelList(r7)
            long r6 = r6.size()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r10[r5] = r6
            java.lang.String r5 = "RealmList<%s>[%s]"
            java.lang.String r5 = java.lang.String.format(r9, r5, r10)
            goto L_0x024c
        L_0x0180:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.isNullLink(r7)
            if (r5 == 0) goto L_0x018d
            goto L_0x019f
        L_0x018d:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            io.realm.internal.Table r5 = r5.getTable()
            io.realm.internal.Table r5 = r5.getLinkTarget(r7)
            java.lang.String r10 = r5.getClassName()
        L_0x019f:
            r1.append(r10)
            goto L_0x024f
        L_0x01a4:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.isNull(r7)
            if (r5 == 0) goto L_0x01b2
            goto L_0x0248
        L_0x01b2:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            double r5 = r5.getDouble(r7)
            java.lang.Double r10 = java.lang.Double.valueOf(r5)
            goto L_0x0248
        L_0x01c2:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.isNull(r7)
            if (r5 == 0) goto L_0x01d0
            goto L_0x0248
        L_0x01d0:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            float r5 = r5.getFloat(r7)
            java.lang.Float r10 = java.lang.Float.valueOf(r5)
            goto L_0x0248
        L_0x01df:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.isNull(r7)
            if (r5 == 0) goto L_0x01ec
            goto L_0x0248
        L_0x01ec:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            java.util.Date r10 = r5.getDate(r7)
            goto L_0x0248
        L_0x01f7:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            byte[] r5 = r5.getBinaryByteArray(r7)
            java.lang.String r5 = java.util.Arrays.toString(r5)
            goto L_0x024c
        L_0x0206:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            java.lang.String r5 = r5.getString(r7)
            goto L_0x024c
        L_0x0211:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.isNull(r7)
            if (r5 == 0) goto L_0x021e
            goto L_0x0248
        L_0x021e:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.getBoolean(r7)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r5)
            goto L_0x0248
        L_0x022d:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            boolean r5 = r5.isNull(r7)
            if (r5 == 0) goto L_0x023a
            goto L_0x0248
        L_0x023a:
            io.realm.ProxyState<io.realm.DynamicRealmObject> r5 = r11.proxyState
            io.realm.internal.Row r5 = r5.getRow$realm()
            long r5 = r5.getLong(r7)
            java.lang.Long r10 = java.lang.Long.valueOf(r5)
        L_0x0248:
            r1.append(r10)
            goto L_0x024f
        L_0x024c:
            r1.append(r5)
        L_0x024f:
            java.lang.String r5 = "},"
            r1.append(r5)
            int r4 = r4 + 1
            goto L_0x0038
        L_0x0258:
            int r0 = r1.length()
            int r0 = r0 - r5
            int r2 = r1.length()
            java.lang.String r3 = ""
            r1.replace(r0, r2, r3)
            java.lang.String r0 = "]"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.DynamicRealmObject.toString():java.lang.String");
    }
}
