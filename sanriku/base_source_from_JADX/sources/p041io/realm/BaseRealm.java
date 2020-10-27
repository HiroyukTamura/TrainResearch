package p041io.realm;

import android.content.Context;
import android.os.Looper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.Realm;
import p041io.realm.RealmCache;
import p041io.realm.exceptions.RealmException;
import p041io.realm.exceptions.RealmMigrationNeededException;
import p041io.realm.internal.CheckedRow;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.InvalidRow;
import p041io.realm.internal.ObjectServerFacade;
import p041io.realm.internal.OsObjectStore;
import p041io.realm.internal.OsRealmConfig;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;
import p041io.realm.internal.UncheckedRow;
import p041io.realm.internal.Util;
import p041io.realm.internal.async.RealmThreadPoolExecutor;
import p041io.realm.log.RealmLog;
import p078g.p079a.C1701g;

/* renamed from: io.realm.BaseRealm */
abstract class BaseRealm implements Closeable {
    static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    static final String DELETE_NOT_SUPPORTED_UNDER_PARTIAL_SYNC = "This API is not supported by partially synchronized Realms. Either unsubscribe using 'Realm.unsubscribeAsync()' or delete the objects using a query and 'RealmResults.deleteAllFromRealm()'";
    private static final String INCORRECT_THREAD_CLOSE_MESSAGE = "Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.";
    static final String INCORRECT_THREAD_MESSAGE = "Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.";
    static final String LISTENER_NOT_ALLOWED_MESSAGE = "Listeners cannot be used on current thread.";
    private static final String NOT_IN_TRANSACTION_MESSAGE = "Changing Realm data can only be done from inside a transaction.";
    static volatile Context applicationContext;
    static final RealmThreadPoolExecutor asyncTaskExecutor = RealmThreadPoolExecutor.newDefaultExecutor();
    public static final ThreadLocalRealmObjectContext objectContext = new ThreadLocalRealmObjectContext();
    protected final RealmConfiguration configuration;
    private RealmCache realmCache;
    private OsSharedRealm.SchemaChangedCallback schemaChangedCallback;
    public OsSharedRealm sharedRealm;
    private boolean shouldCloseSharedRealm;
    final long threadId;

    /* renamed from: io.realm.BaseRealm$InstanceCallback */
    public static abstract class InstanceCallback<T extends BaseRealm> {
        public void onError(Throwable th) {
            throw new RealmException("Exception happens when initializing Realm in the background thread.", th);
        }

        public abstract void onSuccess(T t);
    }

    /* renamed from: io.realm.BaseRealm$RealmObjectContext */
    public static final class RealmObjectContext {
        private boolean acceptDefaultValue;
        private ColumnInfo columnInfo;
        private List<String> excludeFields;
        private BaseRealm realm;
        private Row row;

        public void clear() {
            this.realm = null;
            this.row = null;
            this.columnInfo = null;
            this.acceptDefaultValue = false;
            this.excludeFields = null;
        }

        public boolean getAcceptDefaultValue() {
            return this.acceptDefaultValue;
        }

        public ColumnInfo getColumnInfo() {
            return this.columnInfo;
        }

        public List<String> getExcludeFields() {
            return this.excludeFields;
        }

        /* access modifiers changed from: package-private */
        public BaseRealm getRealm() {
            return this.realm;
        }

        public Row getRow() {
            return this.row;
        }

        public void set(BaseRealm baseRealm, Row row2, ColumnInfo columnInfo2, boolean z, List<String> list) {
            this.realm = baseRealm;
            this.row = row2;
            this.columnInfo = columnInfo2;
            this.acceptDefaultValue = z;
            this.excludeFields = list;
        }
    }

    /* renamed from: io.realm.BaseRealm$ThreadLocalRealmObjectContext */
    static final class ThreadLocalRealmObjectContext extends ThreadLocal<RealmObjectContext> {
        ThreadLocalRealmObjectContext() {
        }

        /* access modifiers changed from: protected */
        public RealmObjectContext initialValue() {
            return new RealmObjectContext();
        }
    }

    BaseRealm(RealmCache realmCache2, OsSchemaInfo osSchemaInfo) {
        this(realmCache2.getConfiguration(), osSchemaInfo);
        this.realmCache = realmCache2;
    }

    BaseRealm(RealmConfiguration realmConfiguration, OsSchemaInfo osSchemaInfo) {
        this.schemaChangedCallback = new OsSharedRealm.SchemaChangedCallback() {
            public void onSchemaChanged() {
                RealmSchema schema = BaseRealm.this.getSchema();
                if (schema != null) {
                    schema.refresh();
                }
            }
        };
        this.threadId = Thread.currentThread().getId();
        this.configuration = realmConfiguration;
        C09862 r0 = null;
        this.realmCache = null;
        OsSharedRealm.MigrationCallback createMigrationCallback = (osSchemaInfo == null || realmConfiguration.getMigration() == null) ? null : createMigrationCallback(realmConfiguration.getMigration());
        final Realm.Transaction initialDataTransaction = realmConfiguration.getInitialDataTransaction();
        OsSharedRealm instance = OsSharedRealm.getInstance(new OsRealmConfig.Builder(realmConfiguration).fifoFallbackDir(new File(applicationContext.getFilesDir(), ".realm.temp")).autoUpdateNotification(true).migrationCallback(createMigrationCallback).schemaInfo(osSchemaInfo).initializationCallback(initialDataTransaction != null ? new OsSharedRealm.InitializationCallback() {
            public void onInit(OsSharedRealm osSharedRealm) {
                initialDataTransaction.execute(Realm.createInstance(osSharedRealm));
            }
        } : r0));
        this.sharedRealm = instance;
        this.shouldCloseSharedRealm = true;
        instance.registerSchemaChangedCallback(this.schemaChangedCallback);
    }

    BaseRealm(OsSharedRealm osSharedRealm) {
        this.schemaChangedCallback = new OsSharedRealm.SchemaChangedCallback() {
            public void onSchemaChanged() {
                RealmSchema schema = BaseRealm.this.getSchema();
                if (schema != null) {
                    schema.refresh();
                }
            }
        };
        this.threadId = Thread.currentThread().getId();
        this.configuration = osSharedRealm.getConfiguration();
        this.realmCache = null;
        this.sharedRealm = osSharedRealm;
        this.shouldCloseSharedRealm = false;
    }

    static boolean compactRealm(RealmConfiguration realmConfiguration) {
        OsSharedRealm instance = OsSharedRealm.getInstance(realmConfiguration);
        Boolean valueOf = Boolean.valueOf(instance.compact());
        instance.close();
        return valueOf.booleanValue();
    }

    /* access modifiers changed from: private */
    public static OsSharedRealm.MigrationCallback createMigrationCallback(final RealmMigration realmMigration) {
        return new OsSharedRealm.MigrationCallback() {
            public void onMigrationNeeded(OsSharedRealm osSharedRealm, long j, long j2) {
                RealmMigration.this.migrate(DynamicRealm.createInstance(osSharedRealm), j, j2);
            }
        };
    }

    static boolean deleteRealm(final RealmConfiguration realmConfiguration) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        if (OsObjectStore.callWithLock(realmConfiguration, new Runnable() {
            public void run() {
                atomicBoolean.set(Util.deleteRealm(RealmConfiguration.this.getPath(), RealmConfiguration.this.getRealmDirectory(), RealmConfiguration.this.getRealmFileName()));
            }
        })) {
            return atomicBoolean.get();
        }
        StringBuilder a = C0681a.m330a("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: ");
        a.append(realmConfiguration.getPath());
        throw new IllegalStateException(a.toString());
    }

    protected static void migrateRealm(final RealmConfiguration realmConfiguration, final RealmMigration realmMigration) throws FileNotFoundException {
        if (realmConfiguration == null) {
            throw new IllegalArgumentException("RealmConfiguration must be provided");
        } else if (realmConfiguration.isSyncConfiguration()) {
            throw new IllegalArgumentException("Manual migrations are not supported for synced Realms");
        } else if (realmMigration == null && realmConfiguration.getMigration() == null) {
            throw new RealmMigrationNeededException(realmConfiguration.getPath(), "RealmMigration must be provided.");
        } else {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            RealmCache.invokeWithGlobalRefCount(realmConfiguration, new RealmCache.Callback() {
                public void onResult(int i) {
                    if (i != 0) {
                        StringBuilder a = C0681a.m330a("Cannot migrate a Realm file that is already open: ");
                        a.append(RealmConfiguration.this.getPath());
                        throw new IllegalStateException(a.toString());
                    } else if (!new File(RealmConfiguration.this.getPath()).exists()) {
                        atomicBoolean.set(true);
                    } else {
                        OsSchemaInfo osSchemaInfo = new OsSchemaInfo(RealmConfiguration.this.getSchemaMediator().getExpectedObjectSchemaInfoMap().values());
                        OsSharedRealm.MigrationCallback migrationCallback = null;
                        RealmMigration realmMigration = realmMigration;
                        if (realmMigration == null) {
                            realmMigration = RealmConfiguration.this.getMigration();
                        }
                        if (realmMigration != null) {
                            migrationCallback = BaseRealm.createMigrationCallback(realmMigration);
                        }
                        OsSharedRealm instance = OsSharedRealm.getInstance(new OsRealmConfig.Builder(RealmConfiguration.this).autoUpdateNotification(false).schemaInfo(osSchemaInfo).migrationCallback(migrationCallback));
                        if (instance != null) {
                            instance.close();
                        }
                    }
                }
            });
            if (atomicBoolean.get()) {
                StringBuilder a = C0681a.m330a("Cannot migrate a Realm file which doesn't exist: ");
                a.append(realmConfiguration.getPath());
                throw new FileNotFoundException(a.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public <T extends BaseRealm> void addListener(RealmChangeListener<T> realmChangeListener) {
        if (realmChangeListener != null) {
            checkIfValid();
            this.sharedRealm.capabilities.checkCanDeliverNotification(LISTENER_NOT_ALLOWED_MESSAGE);
            this.sharedRealm.realmNotifier.addChangeListener(this, realmChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    public abstract C1701g asFlowable();

    public void beginTransaction() {
        checkIfValid();
        this.sharedRealm.beginTransaction();
    }

    public void cancelTransaction() {
        checkIfValid();
        this.sharedRealm.cancelTransaction();
    }

    /* access modifiers changed from: protected */
    public void checkIfInTransaction() {
        if (!this.sharedRealm.isInTransaction()) {
            throw new IllegalStateException(NOT_IN_TRANSACTION_MESSAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void checkIfPartialRealm() {
        if (!(this.configuration.isSyncConfiguration() ? ObjectServerFacade.getSyncFacadeIfPossible().isPartialRealm(this.configuration) : false)) {
            throw new IllegalStateException("This method is only available on partially synchronized Realms.");
        }
    }

    /* access modifiers changed from: protected */
    public void checkIfValid() {
        OsSharedRealm osSharedRealm = this.sharedRealm;
        if (osSharedRealm == null || osSharedRealm.isClosed()) {
            throw new IllegalStateException(CLOSED_REALM_MESSAGE);
        } else if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException(INCORRECT_THREAD_MESSAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void checkIfValidAndInTransaction() {
        if (!isInTransaction()) {
            throw new IllegalStateException(NOT_IN_TRANSACTION_MESSAGE);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkNotInSync() {
        if (this.configuration.isSyncConfiguration()) {
            throw new IllegalArgumentException("You cannot perform changes to a schema. Please update app and restart.");
        }
    }

    public void close() {
        if (this.threadId == Thread.currentThread().getId()) {
            RealmCache realmCache2 = this.realmCache;
            if (realmCache2 != null) {
                realmCache2.release(this);
            } else {
                doClose();
            }
        } else {
            throw new IllegalStateException(INCORRECT_THREAD_CLOSE_MESSAGE);
        }
    }

    public void commitTransaction() {
        checkIfValid();
        this.sharedRealm.commitTransaction();
    }

    public void deleteAll() {
        checkIfValid();
        if (!this.sharedRealm.isPartial()) {
            boolean isPartial = this.sharedRealm.isPartial();
            for (RealmObjectSchema className : getSchema().getAll()) {
                getSchema().getTable(className.getClassName()).clear(isPartial);
            }
            return;
        }
        throw new IllegalStateException(DELETE_NOT_SUPPORTED_UNDER_PARTIAL_SYNC);
    }

    /* access modifiers changed from: package-private */
    public void doClose() {
        this.realmCache = null;
        OsSharedRealm osSharedRealm = this.sharedRealm;
        if (osSharedRealm != null && this.shouldCloseSharedRealm) {
            osSharedRealm.close();
            this.sharedRealm = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        OsSharedRealm osSharedRealm;
        if (this.shouldCloseSharedRealm && (osSharedRealm = this.sharedRealm) != null && !osSharedRealm.isClosed()) {
            RealmLog.warn("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.configuration.getPath());
            RealmCache realmCache2 = this.realmCache;
            if (realmCache2 != null) {
                realmCache2.leak();
            }
        }
        super.finalize();
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> cls, long j, boolean z, List<String> list) {
        return this.configuration.getSchemaMediator().newInstance(cls, this, getSchema().getTable((Class<? extends RealmModel>) cls).getUncheckedRow(j), getSchema().getColumnInfo((Class<? extends RealmModel>) cls), z, list);
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> cls, String str, long j) {
        boolean z = str != null;
        Table table = z ? getSchema().getTable(str) : getSchema().getTable((Class<? extends RealmModel>) cls);
        if (z) {
            return new DynamicRealmObject(this, j != -1 ? table.getCheckedRow(j) : InvalidRow.INSTANCE);
        }
        return this.configuration.getSchemaMediator().newInstance(cls, this, j != -1 ? table.getUncheckedRow(j) : InvalidRow.INSTANCE, getSchema().getColumnInfo((Class<? extends RealmModel>) cls), false, Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> cls, String str, UncheckedRow uncheckedRow) {
        if (str != null) {
            return new DynamicRealmObject(this, CheckedRow.getFromRow(uncheckedRow));
        }
        return this.configuration.getSchemaMediator().newInstance(cls, this, uncheckedRow, getSchema().getColumnInfo((Class<? extends RealmModel>) cls), false, Collections.emptyList());
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    public String getPath() {
        return this.configuration.getPath();
    }

    public abstract RealmSchema getSchema();

    /* access modifiers changed from: package-private */
    public OsSharedRealm getSharedRealm() {
        return this.sharedRealm;
    }

    public long getVersion() {
        return OsObjectStore.getSchemaVersion(this.sharedRealm);
    }

    public boolean isAutoRefresh() {
        return this.sharedRealm.isAutoRefresh();
    }

    public boolean isClosed() {
        if (this.threadId == Thread.currentThread().getId()) {
            OsSharedRealm osSharedRealm = this.sharedRealm;
            return osSharedRealm == null || osSharedRealm.isClosed();
        }
        throw new IllegalStateException(INCORRECT_THREAD_MESSAGE);
    }

    public abstract boolean isEmpty();

    public boolean isInTransaction() {
        checkIfValid();
        return this.sharedRealm.isInTransaction();
    }

    public void refresh() {
        checkIfValid();
        if (!isInTransaction()) {
            this.sharedRealm.refresh();
            return;
        }
        throw new IllegalStateException("Cannot refresh a Realm instance inside a transaction.");
    }

    /* access modifiers changed from: protected */
    public void removeAllListeners() {
        if (isClosed()) {
            RealmLog.warn("Calling removeChangeListener on a closed Realm %s, make sure to close all listeners before closing the Realm.", this.configuration.getPath());
        }
        this.sharedRealm.realmNotifier.removeChangeListeners(this);
    }

    /* access modifiers changed from: protected */
    public <T extends BaseRealm> void removeListener(RealmChangeListener<T> realmChangeListener) {
        if (realmChangeListener != null) {
            if (isClosed()) {
                RealmLog.warn("Calling removeChangeListener on a closed Realm %s, make sure to close all listeners before closing the Realm.", this.configuration.getPath());
            }
            this.sharedRealm.realmNotifier.removeChangeListener(this, realmChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    public void setAutoRefresh(boolean z) {
        checkIfValid();
        this.sharedRealm.setAutoRefresh(z);
    }

    public void stopWaitForChange() {
        RealmCache realmCache2 = this.realmCache;
        if (realmCache2 != null) {
            realmCache2.invokeWithLock(new RealmCache.Callback0() {
                public void onCall() {
                    OsSharedRealm osSharedRealm = BaseRealm.this.sharedRealm;
                    if (osSharedRealm == null || osSharedRealm.isClosed()) {
                        throw new IllegalStateException(BaseRealm.CLOSED_REALM_MESSAGE);
                    }
                    BaseRealm.this.sharedRealm.stopWaitForChange();
                }
            });
            return;
        }
        throw new IllegalStateException(CLOSED_REALM_MESSAGE);
    }

    public boolean waitForChange() {
        checkIfValid();
        if (isInTransaction()) {
            throw new IllegalStateException("Cannot wait for changes inside of a transaction.");
        } else if (Looper.myLooper() == null) {
            boolean waitForChange = this.sharedRealm.waitForChange();
            if (waitForChange) {
                this.sharedRealm.refresh();
            }
            return waitForChange;
        } else {
            throw new IllegalStateException("Cannot wait for changes inside a Looper thread. Use RealmChangeListeners instead.");
        }
    }

    public void writeCopyTo(File file) {
        if (file != null) {
            checkIfValid();
            this.sharedRealm.writeCopy(file, (byte[]) null);
            return;
        }
        throw new IllegalArgumentException("The destination argument cannot be null");
    }

    public void writeEncryptedCopyTo(File file, byte[] bArr) {
        if (file != null) {
            checkIfValid();
            this.sharedRealm.writeCopy(file, bArr);
            return;
        }
        throw new IllegalArgumentException("The destination argument cannot be null");
    }
}
