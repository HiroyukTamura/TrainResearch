package p041io.realm;

import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.OsList;
import p041io.realm.internal.OsResults;
import p041io.realm.internal.PendingRow;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Row;
import p041io.realm.internal.SubscriptionAwareOsResults;
import p041io.realm.internal.Table;
import p041io.realm.internal.TableQuery;
import p041io.realm.internal.core.DescriptorOrdering;
import p041io.realm.internal.core.QueryDescriptor;
import p041io.realm.internal.fields.FieldDescriptor;
import p041io.realm.internal.sync.SubscriptionAction;

/* renamed from: io.realm.RealmQuery */
public class RealmQuery<E> {
    private static final String ASYNC_QUERY_WRONG_THREAD_MESSAGE = "Async query cannot be created on current thread.";
    private static final String EMPTY_VALUES = "Non-empty 'values' must be provided.";
    private static final String TYPE_MISMATCH = "Field '%s': type mismatch - %s expected.";
    private String className;
    private Class<E> clazz;
    private final boolean forValues;
    private final OsList osList;
    private final TableQuery query;
    private DescriptorOrdering queryDescriptors = new DescriptorOrdering();
    private final BaseRealm realm;
    private final RealmObjectSchema schema;
    private final Table table;

    /* renamed from: io.realm.RealmQuery$1 */
    static /* synthetic */ class C19651 {
        static final /* synthetic */ int[] $SwitchMap$io$realm$RealmFieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        static {
            /*
                io.realm.RealmFieldType[] r0 = p041io.realm.RealmFieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$realm$RealmFieldType = r0
                io.realm.RealmFieldType r1 = p041io.realm.RealmFieldType.INTEGER     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x0017 }
                io.realm.RealmFieldType r1 = p041io.realm.RealmFieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0017 }
                r1 = 5
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = $SwitchMap$io$realm$RealmFieldType     // Catch:{ NoSuchFieldError -> 0x001f }
                io.realm.RealmFieldType r1 = p041io.realm.RealmFieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001f }
                r1 = 6
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p041io.realm.RealmQuery.C19651.<clinit>():void");
        }
    }

    private RealmQuery(BaseRealm baseRealm, OsList osList2, Class<E> cls) {
        TableQuery tableQuery;
        this.realm = baseRealm;
        this.clazz = cls;
        boolean z = !isClassForRealmModel(cls);
        this.forValues = z;
        if (z) {
            tableQuery = null;
            this.schema = null;
            this.table = null;
            this.osList = null;
        } else {
            RealmObjectSchema schemaForClass = baseRealm.getSchema().getSchemaForClass((Class<? extends RealmModel>) cls);
            this.schema = schemaForClass;
            this.table = schemaForClass.getTable();
            this.osList = osList2;
            tableQuery = osList2.getQuery();
        }
        this.query = tableQuery;
    }

    private RealmQuery(BaseRealm baseRealm, OsList osList2, String str) {
        this.realm = baseRealm;
        this.className = str;
        this.forValues = false;
        RealmObjectSchema schemaForClass = baseRealm.getSchema().getSchemaForClass(str);
        this.schema = schemaForClass;
        this.table = schemaForClass.getTable();
        this.query = osList2.getQuery();
        this.osList = osList2;
    }

    private RealmQuery(BaseRealm baseRealm, String str) {
        this.realm = baseRealm;
        this.className = str;
        this.forValues = false;
        RealmObjectSchema schemaForClass = baseRealm.getSchema().getSchemaForClass(str);
        this.schema = schemaForClass;
        Table table2 = schemaForClass.getTable();
        this.table = table2;
        this.query = table2.where();
        this.osList = null;
    }

    private RealmQuery(Realm realm2, Class<E> cls) {
        this.realm = realm2;
        this.clazz = cls;
        boolean z = !isClassForRealmModel(cls);
        this.forValues = z;
        if (z) {
            this.schema = null;
            this.table = null;
            this.osList = null;
            this.query = null;
            return;
        }
        RealmObjectSchema schemaForClass = realm2.getSchema().getSchemaForClass((Class<? extends RealmModel>) cls);
        this.schema = schemaForClass;
        Table table2 = schemaForClass.getTable();
        this.table = table2;
        this.osList = null;
        this.query = table2.where();
    }

    private RealmQuery(RealmResults<E> realmResults, Class<E> cls) {
        this.realm = realmResults.realm;
        this.clazz = cls;
        boolean z = !isClassForRealmModel(cls);
        this.forValues = z;
        if (z) {
            this.schema = null;
            this.table = null;
            this.osList = null;
            this.query = null;
            return;
        }
        this.schema = this.realm.getSchema().getSchemaForClass((Class<? extends RealmModel>) cls);
        this.table = realmResults.getTable();
        this.osList = null;
        this.query = realmResults.getOsResults().where();
    }

    private RealmQuery(RealmResults<DynamicRealmObject> realmResults, String str) {
        BaseRealm baseRealm = realmResults.realm;
        this.realm = baseRealm;
        this.className = str;
        this.forValues = false;
        RealmObjectSchema schemaForClass = baseRealm.getSchema().getSchemaForClass(str);
        this.schema = schemaForClass;
        this.table = schemaForClass.getTable();
        this.query = realmResults.getOsResults().where();
        this.osList = null;
    }

    private RealmQuery<E> beginGroupWithoutThreadValidation() {
        this.query.group();
        return this;
    }

    static <E extends RealmModel> RealmQuery<E> createDynamicQuery(DynamicRealm dynamicRealm, String str) {
        return new RealmQuery<>((BaseRealm) dynamicRealm, str);
    }

    static <E extends RealmModel> RealmQuery<E> createQuery(Realm realm2, Class<E> cls) {
        return new RealmQuery<>(realm2, cls);
    }

    static <E> RealmQuery<E> createQueryFromList(RealmList<E> realmList) {
        return realmList.clazz == null ? new RealmQuery<>(realmList.realm, realmList.getOsList(), realmList.className) : new RealmQuery<>(realmList.realm, realmList.getOsList(), realmList.clazz);
    }

    static <E> RealmQuery<E> createQueryFromResult(RealmResults<E> realmResults) {
        Class<E> cls = realmResults.classSpec;
        return cls == null ? new RealmQuery<>((RealmResults<DynamicRealmObject>) realmResults, realmResults.className) : new RealmQuery<>(realmResults, cls);
    }

    private RealmResults<E> createRealmResults(TableQuery tableQuery, DescriptorOrdering descriptorOrdering, boolean z, SubscriptionAction subscriptionAction) {
        OsResults createFromQuery = subscriptionAction.shouldCreateSubscriptions() ? SubscriptionAwareOsResults.createFromQuery(this.realm.sharedRealm, tableQuery, descriptorOrdering, subscriptionAction) : OsResults.createFromQuery(this.realm.sharedRealm, tableQuery, descriptorOrdering);
        RealmResults<E> realmResults = isDynamicQuery() ? new RealmResults<>(this.realm, createFromQuery, this.className) : new RealmResults<>(this.realm, createFromQuery, this.clazz);
        if (z) {
            realmResults.load();
        }
        return realmResults;
    }

    private RealmQuery<E> endGroupWithoutThreadValidation() {
        this.query.endGroup();
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Boolean bool) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.BOOLEAN);
        if (bool == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), bool.booleanValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Byte b) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (b == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) b.byteValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Double d) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        if (d == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), d.doubleValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Float f) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        if (f == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), f.floatValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Integer num) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (num == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) num.intValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Long l) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (l == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), l.longValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Short sh) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (sh == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) sh.shortValue());
        }
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, String str2, Case caseR) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, caseR);
        return this;
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Date date) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.realm.getSchema());
    }

    private long getSourceRowIndexForFirstObject() {
        if (this.queryDescriptors.isEmpty()) {
            return this.query.find();
        }
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) findAll().first((Object) null);
        if (realmObjectProxy != null) {
            return C0681a.m304a(realmObjectProxy);
        }
        return -1;
    }

    private static boolean isClassForRealmModel(Class<?> cls) {
        return RealmModel.class.isAssignableFrom(cls);
    }

    private boolean isDynamicQuery() {
        return this.className != null;
    }

    private OsResults lazyFindAll() {
        this.realm.checkIfValid();
        return createRealmResults(this.query, this.queryDescriptors, false, SubscriptionAction.NO_SUBSCRIPTION).osResults;
    }

    private static native String nativeSerializeQuery(long j, long j2);

    private static native long nativeSubscribe(long j, String str, long j2, long j3, long j4, boolean z);

    private RealmQuery<E> orWithoutThreadValidation() {
        this.query.mo28873or();
        return this;
    }

    public RealmQuery<E> alwaysFalse() {
        this.realm.checkIfValid();
        this.query.alwaysFalse();
        return this;
    }

    public RealmQuery<E> alwaysTrue() {
        this.realm.checkIfValid();
        this.query.alwaysTrue();
        return this;
    }

    public RealmQuery<E> and() {
        this.realm.checkIfValid();
        return this;
    }

    public double average(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        int ordinal = this.table.getColumnType(andCheckFieldIndex).ordinal();
        if (ordinal == 0) {
            return this.query.averageInt(andCheckFieldIndex);
        }
        if (ordinal == 5) {
            return this.query.averageFloat(andCheckFieldIndex);
        }
        if (ordinal == 6) {
            return this.query.averageDouble(andCheckFieldIndex);
        }
        throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
    }

    public RealmQuery<E> beginGroup() {
        this.realm.checkIfValid();
        return beginGroupWithoutThreadValidation();
    }

    public RealmQuery<E> beginsWith(String str, String str2) {
        return beginsWith(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> beginsWith(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.beginsWith(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> between(String str, double d, double d2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.DOUBLE).getColumnIndices(), d, d2);
        return this;
    }

    public RealmQuery<E> between(String str, float f, float f2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.FLOAT).getColumnIndices(), f, f2);
        return this;
    }

    public RealmQuery<E> between(String str, int i, int i2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.INTEGER).getColumnIndices(), (long) i, (long) i2);
        return this;
    }

    public RealmQuery<E> between(String str, long j, long j2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.INTEGER).getColumnIndices(), j, j2);
        return this;
    }

    public RealmQuery<E> between(String str, Date date, Date date2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.DATE).getColumnIndices(), date, date2);
        return this;
    }

    public RealmQuery<E> contains(String str, String str2) {
        return contains(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> contains(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.contains(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public long count() {
        this.realm.checkIfValid();
        return lazyFindAll().size();
    }

    public RealmQuery<E> distinct(String str) {
        return distinct(str, new String[0]);
    }

    public RealmQuery<E> distinct(String str, String... strArr) {
        QueryDescriptor queryDescriptor;
        this.realm.checkIfValid();
        if (strArr.length == 0) {
            queryDescriptor = QueryDescriptor.getInstanceForDistinct((FieldDescriptor.SchemaProxy) getSchemaConnector(), this.table, str);
        } else {
            String[] strArr2 = new String[(strArr.length + 1)];
            strArr2[0] = str;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            queryDescriptor = QueryDescriptor.getInstanceForDistinct((FieldDescriptor.SchemaProxy) getSchemaConnector(), this.table, strArr2);
        }
        this.queryDescriptors.appendDistinct(queryDescriptor);
        return this;
    }

    public RealmQuery<E> endGroup() {
        this.realm.checkIfValid();
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> endsWith(String str, String str2) {
        return endsWith(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> endsWith(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.endsWith(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> equalTo(String str, Boolean bool) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, bool);
    }

    public RealmQuery<E> equalTo(String str, Byte b) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, b);
    }

    public RealmQuery<E> equalTo(String str, Double d) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, d);
    }

    public RealmQuery<E> equalTo(String str, Float f) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, f);
    }

    public RealmQuery<E> equalTo(String str, Integer num) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, num);
    }

    public RealmQuery<E> equalTo(String str, Long l) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, l);
    }

    public RealmQuery<E> equalTo(String str, Short sh) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, sh);
    }

    public RealmQuery<E> equalTo(String str, String str2) {
        return equalTo(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> equalTo(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, str2, caseR);
    }

    public RealmQuery<E> equalTo(String str, Date date) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, date);
    }

    public RealmQuery<E> equalTo(String str, byte[] bArr) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.BINARY);
        if (bArr == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), bArr);
        }
        return this;
    }

    public RealmResults<E> findAll() {
        this.realm.checkIfValid();
        return createRealmResults(this.query, this.queryDescriptors, true, SubscriptionAction.NO_SUBSCRIPTION);
    }

    public RealmResults<E> findAllAsync() {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, this.queryDescriptors, false, (!this.realm.sharedRealm.isPartial() || this.osList != null) ? SubscriptionAction.NO_SUBSCRIPTION : SubscriptionAction.ANONYMOUS_SUBSCRIPTION);
    }

    public E findFirst() {
        this.realm.checkIfValid();
        if (this.forValues) {
            return null;
        }
        long sourceRowIndexForFirstObject = getSourceRowIndexForFirstObject();
        if (sourceRowIndexForFirstObject < 0) {
            return null;
        }
        return this.realm.get(this.clazz, this.className, sourceRowIndexForFirstObject);
    }

    public E findFirstAsync() {
        E e;
        this.realm.checkIfValid();
        if (!this.forValues) {
            this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
            Row firstUncheckedRow = this.realm.isInTransaction() ? OsResults.createFromQuery(this.realm.sharedRealm, this.query).firstUncheckedRow() : new PendingRow(this.realm.sharedRealm, this.query, this.queryDescriptors, isDynamicQuery());
            if (isDynamicQuery()) {
                e = new DynamicRealmObject(this.realm, firstUncheckedRow);
            } else {
                Class<E> cls = this.clazz;
                RealmProxyMediator schemaMediator = this.realm.getConfiguration().getSchemaMediator();
                BaseRealm baseRealm = this.realm;
                e = schemaMediator.newInstance(cls, baseRealm, firstUncheckedRow, baseRealm.getSchema().getColumnInfo((Class<? extends RealmModel>) cls), false, Collections.emptyList());
            }
            if (firstUncheckedRow instanceof PendingRow) {
                ((PendingRow) firstUncheckedRow).setFrontEnd(((RealmObjectProxy) e).realmGet$proxyState());
            }
            return e;
        }
        throw new UnsupportedOperationException("findFirstAsync() available only when type parameter 'E' is implementing RealmModel.");
    }

    public String getDescription() {
        return nativeSerializeQuery(this.query.getNativePtr(), this.queryDescriptors.getNativePtr());
    }

    public Realm getRealm() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm == null) {
            return null;
        }
        baseRealm.checkIfValid();
        BaseRealm baseRealm2 = this.realm;
        if (baseRealm2 instanceof Realm) {
            return (Realm) baseRealm2;
        }
        throw new IllegalStateException("This method is only available for typed Realms");
    }

    public String getTypeQueried() {
        return this.table.getClassName();
    }

    public RealmQuery<E> greaterThan(String str, double d) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.greaterThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, float f) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.greaterThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, int i) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, long j) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.greaterThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, double d) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.greaterThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, float f) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.greaterThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, int i) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, long j) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.greaterThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    /* renamed from: in */
    public RealmQuery<E> mo28438in(String str, Boolean[] boolArr) {
        this.realm.checkIfValid();
        if (boolArr == null || boolArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, boolArr[0]);
        for (int i = 1; i < boolArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, boolArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28439in(String str, Byte[] bArr) {
        this.realm.checkIfValid();
        if (bArr == null || bArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, bArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28440in(String str, Double[] dArr) {
        this.realm.checkIfValid();
        if (dArr == null || dArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, dArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28441in(String str, Float[] fArr) {
        this.realm.checkIfValid();
        if (fArr == null || fArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, fArr[0]);
        for (int i = 1; i < fArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, fArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28442in(String str, Integer[] numArr) {
        this.realm.checkIfValid();
        if (numArr == null || numArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, numArr[0]);
        for (int i = 1; i < numArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, numArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28443in(String str, Long[] lArr) {
        this.realm.checkIfValid();
        if (lArr == null || lArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, lArr[0]);
        for (int i = 1; i < lArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, lArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28444in(String str, Short[] shArr) {
        this.realm.checkIfValid();
        if (shArr == null || shArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, shArr[0]);
        for (int i = 1; i < shArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, shArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28445in(String str, String[] strArr) {
        return mo28446in(str, strArr, Case.SENSITIVE);
    }

    /* renamed from: in */
    public RealmQuery<E> mo28446in(String str, String[] strArr, Case caseR) {
        this.realm.checkIfValid();
        if (strArr == null || strArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, strArr[0], caseR);
        for (int i = 1; i < strArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, strArr[i], caseR);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo28447in(String str, Date[] dateArr) {
        this.realm.checkIfValid();
        if (dateArr == null || dateArr.length == 0) {
            alwaysFalse();
            return this;
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, dateArr[0]);
        for (int i = 1; i < dateArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, dateArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> isEmpty(String str) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING, RealmFieldType.BINARY, RealmFieldType.LIST, RealmFieldType.LINKING_OBJECTS);
        this.query.isEmpty(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        return this;
    }

    public RealmQuery<E> isNotEmpty(String str) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING, RealmFieldType.BINARY, RealmFieldType.LIST, RealmFieldType.LINKING_OBJECTS);
        this.query.isNotEmpty(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        return this;
    }

    public RealmQuery<E> isNotNull(String str) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, new RealmFieldType[0]);
        this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        return this;
    }

    public RealmQuery<E> isNull(String str) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, new RealmFieldType[0]);
        this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        return this;
    }

    public boolean isValid() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm == null || baseRealm.isClosed()) {
            return false;
        }
        OsList osList2 = this.osList;
        if (osList2 != null) {
            return osList2.isValid();
        }
        Table table2 = this.table;
        return table2 != null && table2.isValid();
    }

    public RealmQuery<E> lessThan(String str, double d) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.lessThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> lessThan(String str, float f) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.lessThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> lessThan(String str, int i) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> lessThan(String str, long j) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> lessThan(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.lessThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, double d) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.lessThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, float f) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.lessThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, int i) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, long j) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.lessThanOrEqual(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> like(String str, String str2) {
        return like(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> like(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.like(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> limit(long j) {
        this.realm.checkIfValid();
        if (j >= 1) {
            this.queryDescriptors.setLimit(j);
            return this;
        }
        throw new IllegalArgumentException(C0681a.m318a("Only positive numbers above 0 is allowed. Yours was: ", j));
    }

    public Number max(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        int ordinal = this.table.getColumnType(andCheckFieldIndex).ordinal();
        if (ordinal == 0) {
            return this.query.maximumInt(andCheckFieldIndex);
        }
        if (ordinal == 5) {
            return this.query.maximumFloat(andCheckFieldIndex);
        }
        if (ordinal == 6) {
            return this.query.maximumDouble(andCheckFieldIndex);
        }
        throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
    }

    public Date maximumDate(String str) {
        this.realm.checkIfValid();
        return this.query.maximumDate(this.schema.getAndCheckFieldIndex(str));
    }

    public Number min(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        int ordinal = this.table.getColumnType(andCheckFieldIndex).ordinal();
        if (ordinal == 0) {
            return this.query.minimumInt(andCheckFieldIndex);
        }
        if (ordinal == 5) {
            return this.query.minimumFloat(andCheckFieldIndex);
        }
        if (ordinal == 6) {
            return this.query.minimumDouble(andCheckFieldIndex);
        }
        throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
    }

    public Date minimumDate(String str) {
        this.realm.checkIfValid();
        return this.query.minimumDate(this.schema.getAndCheckFieldIndex(str));
    }

    public RealmQuery<E> not() {
        this.realm.checkIfValid();
        this.query.not();
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Boolean bool) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.BOOLEAN);
        if (bool == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), !bool.booleanValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Byte b) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (b == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) b.byteValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Double d) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        if (d == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), d.doubleValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Float f) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        if (f == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), f.floatValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Integer num) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (num == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) num.intValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Long l) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (l == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), l.longValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Short sh) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (sh == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) sh.shortValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, String str2) {
        return notEqualTo(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> notEqualTo(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        if (columnIndices.length() <= 1 || caseR.getValue()) {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, caseR);
            return this;
        }
        throw new IllegalArgumentException("Link queries cannot be case insensitive - coming soon.");
    }

    public RealmQuery<E> notEqualTo(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        if (date == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, byte[] bArr) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.BINARY);
        if (bArr == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), bArr);
        }
        return this;
    }

    /* renamed from: or */
    public RealmQuery<E> mo28482or() {
        this.realm.checkIfValid();
        return orWithoutThreadValidation();
    }

    public RealmQuery<E> sort(String str) {
        this.realm.checkIfValid();
        return sort(str, Sort.ASCENDING);
    }

    public RealmQuery<E> sort(String str, Sort sort) {
        this.realm.checkIfValid();
        return sort(new String[]{str}, new Sort[]{sort});
    }

    public RealmQuery<E> sort(String str, Sort sort, String str2, Sort sort2) {
        this.realm.checkIfValid();
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public RealmQuery<E> sort(String[] strArr, Sort[] sortArr) {
        this.realm.checkIfValid();
        this.queryDescriptors.appendSort(QueryDescriptor.getInstanceForSort((FieldDescriptor.SchemaProxy) getSchemaConnector(), this.query.getTable(), strArr, sortArr));
        return this;
    }

    public Number sum(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        int ordinal = this.table.getColumnType(andCheckFieldIndex).ordinal();
        if (ordinal == 0) {
            return Long.valueOf(this.query.sumInt(andCheckFieldIndex));
        }
        if (ordinal == 5) {
            return Double.valueOf(this.query.sumFloat(andCheckFieldIndex));
        }
        if (ordinal == 6) {
            return Double.valueOf(this.query.sumDouble(andCheckFieldIndex));
        }
        throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
    }
}
