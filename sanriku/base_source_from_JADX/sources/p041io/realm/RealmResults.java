package p041io.realm;

import android.annotation.SuppressLint;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.CheckedRow;
import p041io.realm.internal.OsResults;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.UncheckedRow;
import p041io.realm.internal.Util;
import p041io.realm.internal.android.JsonUtils;
import p041io.realm.log.RealmLog;
import p041io.realm.p117rx.CollectionChange;
import p078g.p079a.C1701g;
import p078g.p079a.C1706l;

/* renamed from: io.realm.RealmResults */
public class RealmResults<E> extends OrderedRealmCollectionImpl<E> {

    /* renamed from: io.realm.RealmResults$1 */
    static /* synthetic */ class C19661 {
        static final /* synthetic */ int[] $SwitchMap$io$realm$RealmFieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|(2:3|4)|5|(2:7|8)|9|11|12|13|14|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|4|5|7|8|9|11|12|13|14|15|17|18|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|4|5|7|8|9|11|12|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0057 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
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
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.realm.RealmFieldType r1 = p041io.realm.RealmFieldType.INTEGER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 5
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x001e }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r1 = 4
                r2 = 6
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0026 }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0026 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x002c }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.DATE     // Catch:{ NoSuchFieldError -> 0x002c }
                r3[r1] = r0     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                r0 = 8
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0034 }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.LIST     // Catch:{ NoSuchFieldError -> 0x0034 }
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r1 = 10
                int[] r2 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x003d }
                io.realm.RealmFieldType r3 = p041io.realm.RealmFieldType.INTEGER_LIST     // Catch:{ NoSuchFieldError -> 0x003d }
                r3 = 7
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                r2 = 11
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0045 }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.BOOLEAN_LIST     // Catch:{ NoSuchFieldError -> 0x0045 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                r0 = 12
                int[] r3 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x004f }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.STRING_LIST     // Catch:{ NoSuchFieldError -> 0x004f }
                r4 = 9
                r3[r0] = r4     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                r3 = 13
                int[] r4 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0057 }
                io.realm.RealmFieldType r5 = p041io.realm.RealmFieldType.BINARY_LIST     // Catch:{ NoSuchFieldError -> 0x0057 }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x005f }
                io.realm.RealmFieldType r4 = p041io.realm.RealmFieldType.DATE_LIST     // Catch:{ NoSuchFieldError -> 0x005f }
                r4 = 14
                r1[r4] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r1 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0067 }
                io.realm.RealmFieldType r2 = p041io.realm.RealmFieldType.FLOAT_LIST     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 15
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x006f }
                io.realm.RealmFieldType r1 = p041io.realm.RealmFieldType.DOUBLE_LIST     // Catch:{ NoSuchFieldError -> 0x006f }
                r1 = 16
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p041io.realm.RealmResults.C19661.<clinit>():void");
        }
    }

    RealmResults(BaseRealm baseRealm, OsResults osResults, Class<E> cls) {
        super(baseRealm, osResults, cls);
    }

    RealmResults(BaseRealm baseRealm, OsResults osResults, String str) {
        super(baseRealm, osResults, str);
    }

    private void checkForAddListener(Object obj) {
        if (obj != null) {
            this.realm.checkIfValid();
            this.realm.sharedRealm.capabilities.checkCanDeliverNotification("Listeners cannot be used on current thread.");
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    private void checkForRemoveListener(Object obj, boolean z) {
        if (z && obj == null) {
            throw new IllegalArgumentException("Listener should not be null");
        } else if (this.realm.isClosed()) {
            RealmLog.warn("Calling removeChangeListener on a closed Realm %s, make sure to close all listeners before closing the Realm.", this.realm.configuration.getPath());
        }
    }

    private void checkNonEmptyFieldName(String str) {
        if (Util.isEmptyString(str)) {
            throw new IllegalArgumentException("Non-empty 'fieldname' required.");
        }
    }

    private void checkNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Non-null 'value' required. Use 'setNull(fieldName)' instead.");
        }
    }

    private Row checkRealmObjectConstraints(String str, RealmModel realmModel) {
        if (realmModel == null) {
            return null;
        }
        if (!RealmObject.isManaged(realmModel) || !RealmObject.isValid(realmModel)) {
            throw new IllegalArgumentException("'value' is not a valid, managed Realm object.");
        }
        ProxyState realmGet$proxyState = ((RealmObjectProxy) realmModel).realmGet$proxyState();
        if (realmGet$proxyState.getRealm$realm().getPath().equals(this.realm.getPath())) {
            Table table = this.osResults.getTable();
            Table linkTarget = table.getLinkTarget(table.getColumnIndex(str));
            Table table2 = realmGet$proxyState.getRow$realm().getTable();
            if (linkTarget.hasSameSchema(table2)) {
                return realmGet$proxyState.getRow$realm();
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Type of object is wrong. Was '%s', expected '%s'", new Object[]{table2.getClassName(), linkTarget.getClassName()}));
        }
        throw new IllegalArgumentException("'value' does not belong to the same Realm as the RealmResults.");
    }

    private void checkType(String str, RealmFieldType realmFieldType) {
        String className = this.osResults.getTable().getClassName();
        RealmFieldType fieldType = this.realm.getSchema().get(className).getFieldType(str);
        if (fieldType != realmFieldType) {
            throw new IllegalArgumentException(String.format("The field '%s.%s' is not of the expected type. Actual: %s, Expected: %s", new Object[]{className, str, fieldType, realmFieldType}));
        }
    }

    private <T> void checkTypeOfListElements(RealmList<T> realmList, Class<?> cls) {
        if (!realmList.isEmpty()) {
            Class<?> cls2 = realmList.first().getClass();
            if (!cls.isAssignableFrom(cls2)) {
                throw new IllegalArgumentException(String.format("List contained the wrong type of elements. Elements of type '%s' was expected, but the actual type is '%s'", new Object[]{cls, cls2}));
            }
        }
    }

    @SuppressLint({"unused"})
    static <T extends RealmModel> RealmResults<T> createBacklinkResults(BaseRealm baseRealm, Row row, Class<T> cls, String str) {
        Table table = baseRealm.getSchema().getTable((Class<? extends RealmModel>) cls);
        return new RealmResults<>(baseRealm, OsResults.createForBacklinks(baseRealm.sharedRealm, (UncheckedRow) row, table, str), cls);
    }

    static RealmResults<DynamicRealmObject> createDynamicBacklinkResults(DynamicRealm dynamicRealm, CheckedRow checkedRow, Table table, String str) {
        return new RealmResults<>((BaseRealm) dynamicRealm, OsResults.createForBacklinks(dynamicRealm.sharedRealm, checkedRow, table, str), Table.getClassNameForTable(table.getName()));
    }

    private Class<?> getListType(RealmList realmList) {
        return !realmList.isEmpty() ? realmList.first().getClass() : Long.class;
    }

    private String mapFieldNameToInternalName(String str) {
        if (!(this.realm instanceof Realm)) {
            return str;
        }
        String internalFieldName = this.realm.getSchema().getColumnInfo(this.osResults.getTable().getClassName()).getInternalFieldName(str);
        if (internalFieldName != null) {
            return internalFieldName;
        }
        throw new IllegalArgumentException(String.format("Field '%s' does not exists.", new Object[]{str}));
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        super.add(i, obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return super.addAll(i, collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public void addChangeListener(OrderedRealmCollectionChangeListener<RealmResults<E>> orderedRealmCollectionChangeListener) {
        checkForAddListener(orderedRealmCollectionChangeListener);
        this.osResults.addListener(this, orderedRealmCollectionChangeListener);
    }

    public void addChangeListener(RealmChangeListener<RealmResults<E>> realmChangeListener) {
        checkForAddListener(realmChangeListener);
        this.osResults.addListener(this, realmChangeListener);
    }

    public C1706l<CollectionChange<RealmResults<E>>> asChangesetObservable() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm instanceof Realm) {
            return baseRealm.configuration.getRxFactory().changesetsFrom((Realm) this.realm, this);
        }
        if (baseRealm instanceof DynamicRealm) {
            return baseRealm.configuration.getRxFactory().changesetsFrom((DynamicRealm) baseRealm, this);
        }
        throw new UnsupportedOperationException(this.realm.getClass() + " does not support RxJava2.");
    }

    public C1701g<RealmResults<E>> asFlowable() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm instanceof Realm) {
            return baseRealm.configuration.getRxFactory().from((Realm) this.realm, this);
        }
        if (baseRealm instanceof DynamicRealm) {
            return baseRealm.configuration.getRxFactory().from((DynamicRealm) baseRealm, this);
        }
        throw new UnsupportedOperationException(this.realm.getClass() + " does not support RxJava2.");
    }

    public String asJSON() {
        return this.osResults.toJSON(-1);
    }

    public /* bridge */ /* synthetic */ double average(String str) {
        return super.average(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ OrderedRealmCollectionSnapshot createSnapshot() {
        return super.createSnapshot();
    }

    public /* bridge */ /* synthetic */ boolean deleteAllFromRealm() {
        return super.deleteAllFromRealm();
    }

    public /* bridge */ /* synthetic */ boolean deleteFirstFromRealm() {
        return super.deleteFirstFromRealm();
    }

    public /* bridge */ /* synthetic */ void deleteFromRealm(int i) {
        super.deleteFromRealm(i);
    }

    public /* bridge */ /* synthetic */ boolean deleteLastFromRealm() {
        return super.deleteLastFromRealm();
    }

    public /* bridge */ /* synthetic */ Object first() {
        return super.first();
    }

    public /* bridge */ /* synthetic */ Object first(Object obj) {
        return super.first(obj);
    }

    public /* bridge */ /* synthetic */ Object get(int i) {
        return super.get(i);
    }

    public /* bridge */ /* synthetic */ Realm getRealm() {
        return super.getRealm();
    }

    public boolean isLoaded() {
        this.realm.checkIfValid();
        return this.osResults.isLoaded();
    }

    public /* bridge */ /* synthetic */ boolean isManaged() {
        return super.isManaged();
    }

    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ Object last() {
        return super.last();
    }

    public /* bridge */ /* synthetic */ Object last(Object obj) {
        return super.last(obj);
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    public boolean load() {
        this.realm.checkIfValid();
        this.osResults.load();
        return true;
    }

    public /* bridge */ /* synthetic */ Number max(String str) {
        return super.max(str);
    }

    public /* bridge */ /* synthetic */ Date maxDate(String str) {
        return super.maxDate(str);
    }

    public /* bridge */ /* synthetic */ Number min(String str) {
        return super.min(str);
    }

    public /* bridge */ /* synthetic */ Date minDate(String str) {
        return super.minDate(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ Object remove(int i) {
        return super.remove(i);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public void removeAllChangeListeners() {
        checkForRemoveListener((Object) null, false);
        this.osResults.removeAllListeners();
    }

    public void removeChangeListener(OrderedRealmCollectionChangeListener<RealmResults<E>> orderedRealmCollectionChangeListener) {
        checkForRemoveListener(orderedRealmCollectionChangeListener, true);
        this.osResults.removeListener(this, orderedRealmCollectionChangeListener);
    }

    public void removeChangeListener(RealmChangeListener<RealmResults<E>> realmChangeListener) {
        checkForRemoveListener(realmChangeListener, true);
        this.osResults.removeListener(this, realmChangeListener);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return super.set(i, obj);
    }

    public void setBlob(String str, byte[] bArr) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.BINARY);
        this.osResults.setBlob(mapFieldNameToInternalName, bArr);
    }

    public void setBoolean(String str, boolean z) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.BOOLEAN);
        this.osResults.setBoolean(mapFieldNameToInternalName, z);
    }

    public void setByte(String str, byte b) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.INTEGER);
        this.osResults.setInt(mapFieldNameToInternalName, (long) b);
    }

    public void setDate(String str, Date date) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.DATE);
        this.osResults.setDate(mapFieldNameToInternalName, date);
    }

    public void setDouble(String str, double d) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.DOUBLE);
        this.osResults.setDouble(mapFieldNameToInternalName, d);
    }

    public void setFloat(String str, float f) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.FLOAT);
        this.osResults.setFloat(mapFieldNameToInternalName, f);
    }

    public void setInt(String str, int i) {
        checkNonEmptyFieldName(str);
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.INTEGER);
        this.realm.checkIfValidAndInTransaction();
        this.osResults.setInt(mapFieldNameToInternalName, (long) i);
    }

    public <T> void setList(String str, RealmList<T> realmList) {
        checkNonEmptyFieldName(str);
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        this.realm.checkIfValidAndInTransaction();
        if (realmList != null) {
            RealmFieldType fieldType = this.realm.getSchema().getSchemaForClass(this.osResults.getTable().getClassName()).getFieldType(mapFieldNameToInternalName);
            switch (fieldType.ordinal()) {
                case 8:
                    checkTypeOfListElements(realmList, RealmModel.class);
                    checkRealmObjectConstraints(mapFieldNameToInternalName, (RealmModel) realmList.first(null));
                    this.osResults.setModelList(mapFieldNameToInternalName, realmList);
                    return;
                case 10:
                    Class<?> listType = getListType(realmList);
                    if (listType.equals(Integer.class)) {
                        this.osResults.setIntegerList(mapFieldNameToInternalName, realmList);
                        return;
                    } else if (listType.equals(Long.class)) {
                        this.osResults.setLongList(mapFieldNameToInternalName, realmList);
                        return;
                    } else if (listType.equals(Short.class)) {
                        this.osResults.setShortList(mapFieldNameToInternalName, realmList);
                        return;
                    } else if (listType.equals(Byte.class)) {
                        this.osResults.setByteList(mapFieldNameToInternalName, realmList);
                        return;
                    } else {
                        throw new IllegalArgumentException(String.format("List contained the wrong type of elements. Elements that can be mapped to Integers was expected, but the actual type is '%s'", new Object[]{listType}));
                    }
                case 11:
                    checkTypeOfListElements(realmList, Boolean.class);
                    this.osResults.setBooleanList(mapFieldNameToInternalName, realmList);
                    return;
                case 12:
                    checkTypeOfListElements(realmList, String.class);
                    this.osResults.setStringList(mapFieldNameToInternalName, realmList);
                    return;
                case 13:
                    checkTypeOfListElements(realmList, byte[].class);
                    this.osResults.setByteArrayList(mapFieldNameToInternalName, realmList);
                    return;
                case 14:
                    checkTypeOfListElements(realmList, Date.class);
                    this.osResults.setDateList(mapFieldNameToInternalName, realmList);
                    return;
                case 15:
                    checkTypeOfListElements(realmList, Float.class);
                    this.osResults.setFloatList(mapFieldNameToInternalName, realmList);
                    return;
                case 16:
                    checkTypeOfListElements(realmList, Double.class);
                    this.osResults.setDoubleList(mapFieldNameToInternalName, realmList);
                    return;
                default:
                    throw new IllegalArgumentException(String.format("Field '%s' is not a list but a %s", new Object[]{mapFieldNameToInternalName, fieldType}));
            }
        } else {
            throw new IllegalArgumentException("Non-null 'list' required");
        }
    }

    public void setLong(String str, long j) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.INTEGER);
        this.osResults.setInt(mapFieldNameToInternalName, j);
    }

    public void setNull(String str) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        this.osResults.setNull(str);
    }

    public void setObject(String str, RealmModel realmModel) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.OBJECT);
        this.osResults.setObject(mapFieldNameToInternalName, checkRealmObjectConstraints(mapFieldNameToInternalName, realmModel));
    }

    public void setShort(String str, short s) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.INTEGER);
        this.osResults.setInt(mapFieldNameToInternalName, (long) s);
    }

    public void setString(String str, String str2) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        checkType(mapFieldNameToInternalName, RealmFieldType.STRING);
        this.osResults.setString(mapFieldNameToInternalName, str2);
    }

    public void setValue(String str, Object obj) {
        checkNonEmptyFieldName(str);
        this.realm.checkIfValidAndInTransaction();
        String mapFieldNameToInternalName = mapFieldNameToInternalName(str);
        boolean z = obj instanceof String;
        String str2 = z ? (String) obj : null;
        String className = this.osResults.getTable().getClassName();
        RealmObjectSchema realmObjectSchema = getRealm().getSchema().get(className);
        if (!realmObjectSchema.hasField(mapFieldNameToInternalName)) {
            throw new IllegalArgumentException(String.format("Field '%s' could not be found in class '%s'", new Object[]{mapFieldNameToInternalName, className}));
        } else if (obj == null) {
            this.osResults.setNull(mapFieldNameToInternalName);
        } else {
            RealmFieldType fieldType = realmObjectSchema.getFieldType(mapFieldNameToInternalName);
            if (z && fieldType != RealmFieldType.STRING) {
                int ordinal = fieldType.ordinal();
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
                    throw new IllegalArgumentException(String.format(Locale.US, "Field %s is not a String field, and the provide value could not be automatically converted: %s. Use a typedsetter instead", new Object[]{mapFieldNameToInternalName, obj}));
                }
            }
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class) {
                setBoolean(mapFieldNameToInternalName, ((Boolean) obj).booleanValue());
            } else if (cls == Short.class) {
                setShort(mapFieldNameToInternalName, ((Short) obj).shortValue());
            } else if (cls == Integer.class) {
                setInt(mapFieldNameToInternalName, ((Integer) obj).intValue());
            } else if (cls == Long.class) {
                setLong(mapFieldNameToInternalName, ((Long) obj).longValue());
            } else if (cls == Byte.class) {
                setByte(mapFieldNameToInternalName, ((Byte) obj).byteValue());
            } else if (cls == Float.class) {
                setFloat(mapFieldNameToInternalName, ((Float) obj).floatValue());
            } else if (cls == Double.class) {
                setDouble(mapFieldNameToInternalName, ((Double) obj).doubleValue());
            } else if (cls == String.class) {
                setString(mapFieldNameToInternalName, (String) obj);
            } else if (obj instanceof Date) {
                setDate(mapFieldNameToInternalName, (Date) obj);
            } else if (obj instanceof byte[]) {
                setBlob(mapFieldNameToInternalName, (byte[]) obj);
            } else if (obj instanceof RealmModel) {
                setObject(mapFieldNameToInternalName, (RealmModel) obj);
            } else if (cls == RealmList.class) {
                setList(mapFieldNameToInternalName, (RealmList) obj);
            } else {
                StringBuilder a = C0681a.m330a("Value is of a type not supported: ");
                a.append(obj.getClass());
                throw new IllegalArgumentException(a.toString());
            }
        }
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ RealmResults sort(String str) {
        return super.sort(str);
    }

    public /* bridge */ /* synthetic */ RealmResults sort(String str, Sort sort) {
        return super.sort(str, sort);
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public /* bridge */ /* synthetic */ RealmResults sort(String[] strArr, Sort[] sortArr) {
        return super.sort(strArr, sortArr);
    }

    public /* bridge */ /* synthetic */ Number sum(String str) {
        return super.sum(str);
    }

    public RealmQuery<E> where() {
        this.realm.checkIfValid();
        return RealmQuery.createQueryFromResult(this);
    }
}
