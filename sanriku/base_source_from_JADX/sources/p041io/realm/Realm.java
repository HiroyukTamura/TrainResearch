package p041io.realm;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.SystemClock;
import android.util.JsonReader;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.BaseRealm;
import p041io.realm.RealmCache;
import p041io.realm.RealmConfiguration;
import p041io.realm.exceptions.RealmException;
import p041io.realm.exceptions.RealmMigrationNeededException;
import p041io.realm.exceptions.RealmPrimaryKeyConstraintException;
import p041io.realm.internal.ColumnIndices;
import p041io.realm.internal.ObjectServerFacade;
import p041io.realm.internal.OsObject;
import p041io.realm.internal.OsObjectStore;
import p041io.realm.internal.OsResults;
import p041io.realm.internal.OsSchemaInfo;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.internal.RealmCore;
import p041io.realm.internal.RealmNotifier;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.RealmProxyMediator;
import p041io.realm.internal.Table;
import p041io.realm.internal.Util;
import p041io.realm.internal.async.RealmAsyncTaskImpl;
import p041io.realm.log.RealmLog;
import p078g.p079a.C1701g;

/* renamed from: io.realm.Realm */
public class Realm extends BaseRealm {
    public static final String DEFAULT_REALM_NAME = "default.realm";
    private static final String NULL_CONFIG_MSG = "A non-null RealmConfiguration must be provided";
    private static RealmConfiguration defaultConfiguration;
    private static final Object defaultConfigurationLock = new Object();
    private final RealmSchema schema;

    /* renamed from: io.realm.Realm$Transaction */
    public interface Transaction {

        /* renamed from: io.realm.Realm$Transaction$Callback */
        public static class Callback {
            public void onError(Exception exc) {
            }

            public void onSuccess() {
            }
        }

        /* renamed from: io.realm.Realm$Transaction$OnError */
        public interface OnError {
            void onError(Throwable th);
        }

        /* renamed from: io.realm.Realm$Transaction$OnSuccess */
        public interface OnSuccess {
            void onSuccess();
        }

        void execute(Realm realm);
    }

    /* renamed from: io.realm.Realm$Callback */
    public static abstract class Callback extends BaseRealm.InstanceCallback<Realm> {
        public void onError(Throwable th) {
            super.onError(th);
        }

        public abstract void onSuccess(Realm realm);
    }

    /* renamed from: io.realm.Realm$UnsubscribeCallback */
    public interface UnsubscribeCallback {
        void onError(String str, Throwable th);

        void onSuccess(String str);
    }

    private Realm(RealmCache realmCache) {
        super(realmCache, createExpectedSchemaInfo(realmCache.getConfiguration().getSchemaMediator()));
        this.schema = new ImmutableRealmSchema(this, new ColumnIndices(this.configuration.getSchemaMediator(), this.sharedRealm.getSchemaInfo()));
        if (this.configuration.isReadOnly()) {
            RealmProxyMediator schemaMediator = this.configuration.getSchemaMediator();
            for (Class<? extends RealmModel> simpleClassName : schemaMediator.getModelClasses()) {
                String tableNameForClass = Table.getTableNameForClass(schemaMediator.getSimpleClassName(simpleClassName));
                if (!this.sharedRealm.hasTable(tableNameForClass)) {
                    this.sharedRealm.close();
                    throw new RealmMigrationNeededException(this.configuration.getPath(), String.format(Locale.US, "Cannot open the read only Realm. '%s' is missing.", new Object[]{Table.getClassNameForTable(tableNameForClass)}));
                }
            }
        }
    }

    private Realm(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
        this.schema = new ImmutableRealmSchema(this, new ColumnIndices(this.configuration.getSchemaMediator(), osSharedRealm.getSchemaInfo()));
    }

    private static void checkFilesDirAvailable(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            if (!filesDir.exists()) {
                try {
                    filesDir.mkdirs();
                } catch (SecurityException unused) {
                }
            } else {
                return;
            }
        }
        if (filesDir == null || !filesDir.exists()) {
            long[] jArr = {1, 2, 5, 10, 16};
            long j = 0;
            int i = -1;
            do {
                if (context.getFilesDir() != null && context.getFilesDir().exists()) {
                    break;
                }
                i++;
                long j2 = jArr[Math.min(i, 4)];
                SystemClock.sleep(j2);
                j += j2;
            } while (j <= 200);
        }
        if (context.getFilesDir() == null || !context.getFilesDir().exists()) {
            StringBuilder a = C0681a.m330a("Context.getFilesDir() returns ");
            a.append(context.getFilesDir());
            a.append(" which is not an existing directory. See https://issuetracker.google.com/issues/36918154");
            throw new IllegalStateException(a.toString());
        }
    }

    private void checkHasPrimaryKey(Class<? extends RealmModel> cls) {
        if (this.sharedRealm.getSchemaInfo().getObjectSchemaInfo(this.configuration.getSchemaMediator().getSimpleClassName(cls)).getPrimaryKeyProperty() == null) {
            StringBuilder a = C0681a.m330a("A RealmObject with no @PrimaryKey cannot be updated: ");
            a.append(cls.toString());
            throw new IllegalArgumentException(a.toString());
        }
    }

    private void checkMaxDepth(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(C0681a.m316a("maxDepth must be > 0. It was: ", i));
        }
    }

    private <E extends RealmModel> void checkNotNullObject(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        }
    }

    private <E extends RealmModel> void checkValidObjectForDetach(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null objects cannot be copied from Realm.");
        } else if (!RealmObject.isManaged(e) || !RealmObject.isValid(e)) {
            throw new IllegalArgumentException("Only valid managed objects can be copied from Realm.");
        } else if (e instanceof DynamicRealmObject) {
            throw new IllegalArgumentException("DynamicRealmObject cannot be copied from Realm.");
        }
    }

    public static boolean compactRealm(RealmConfiguration realmConfiguration) {
        return BaseRealm.compactRealm(realmConfiguration);
    }

    private <E extends RealmModel> E copyOrUpdate(E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        checkIfValid();
        if (isInTransaction()) {
            try {
                return this.configuration.getSchemaMediator().copyOrUpdate(this, e, z, map, set);
            } catch (IllegalStateException e2) {
                if (e2.getMessage().startsWith("Attempting to create an object of type")) {
                    throw new RealmPrimaryKeyConstraintException(e2.getMessage());
                }
                throw e2;
            }
        } else {
            throw new IllegalStateException("`copyOrUpdate` can only be called inside a write transaction.");
        }
    }

    private <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        checkIfValid();
        return this.configuration.getSchemaMediator().createDetachedCopy(e, i, map);
    }

    private static OsSchemaInfo createExpectedSchemaInfo(RealmProxyMediator realmProxyMediator) {
        return new OsSchemaInfo(realmProxyMediator.getExpectedObjectSchemaInfoMap().values());
    }

    static Realm createInstance(RealmCache realmCache) {
        return new Realm(realmCache);
    }

    static Realm createInstance(OsSharedRealm osSharedRealm) {
        return new Realm(osSharedRealm);
    }

    public static boolean deleteRealm(RealmConfiguration realmConfiguration) {
        return BaseRealm.deleteRealm(realmConfiguration);
    }

    public static RealmConfiguration getDefaultConfiguration() {
        RealmConfiguration realmConfiguration;
        synchronized (defaultConfigurationLock) {
            realmConfiguration = defaultConfiguration;
        }
        return realmConfiguration;
    }

    public static Realm getDefaultInstance() {
        RealmConfiguration defaultConfiguration2 = getDefaultConfiguration();
        if (defaultConfiguration2 != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(defaultConfiguration2, Realm.class);
        }
        if (BaseRealm.applicationContext == null) {
            throw new IllegalStateException("Call `Realm.init(Context)` before calling this method.");
        }
        throw new IllegalStateException("Set default configuration by using `Realm.setDefaultConfiguration(RealmConfiguration)`.");
    }

    public static Object getDefaultModule() {
        try {
            Constructor constructor = Class.forName("io.realm.DefaultRealmModule").getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RealmException(C0681a.m320a("Could not create an instance of ", "io.realm.DefaultRealmModule"), e);
        } catch (InstantiationException e2) {
            throw new RealmException(C0681a.m320a("Could not create an instance of ", "io.realm.DefaultRealmModule"), e2);
        } catch (IllegalAccessException e3) {
            throw new RealmException(C0681a.m320a("Could not create an instance of ", "io.realm.DefaultRealmModule"), e3);
        }
    }

    private Scanner getFullStringScanner(InputStream inputStream) {
        return new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
    }

    public static int getGlobalInstanceCount(RealmConfiguration realmConfiguration) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        RealmCache.invokeWithGlobalRefCount(realmConfiguration, new RealmCache.Callback() {
            public void onResult(int i) {
                atomicInteger.set(i);
            }
        });
        return atomicInteger.get();
    }

    public static Realm getInstance(RealmConfiguration realmConfiguration) {
        if (realmConfiguration != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(realmConfiguration, Realm.class);
        }
        throw new IllegalArgumentException(NULL_CONFIG_MSG);
    }

    public static RealmAsyncTask getInstanceAsync(RealmConfiguration realmConfiguration, Callback callback) {
        if (realmConfiguration != null) {
            return RealmCache.createRealmOrGetFromCacheAsync(realmConfiguration, callback, Realm.class);
        }
        throw new IllegalArgumentException(NULL_CONFIG_MSG);
    }

    public static int getLocalInstanceCount(RealmConfiguration realmConfiguration) {
        return RealmCache.getLocalThreadCount(realmConfiguration);
    }

    public static synchronized void init(Context context) {
        synchronized (Realm.class) {
            initializeRealm(context, "");
        }
    }

    private static void initializeRealm(Context context, String str) {
        if (BaseRealm.applicationContext != null) {
            return;
        }
        if (context != null) {
            checkFilesDirAvailable(context);
            RealmCore.loadLibrary(context);
            setDefaultConfiguration(new RealmConfiguration.Builder(context).build());
            ObjectServerFacade.getSyncFacadeIfPossible().initialize(context, str);
            if (context.getApplicationContext() != null) {
                BaseRealm.applicationContext = context.getApplicationContext();
            } else {
                BaseRealm.applicationContext = context;
            }
            OsSharedRealm.initialize(new File(context.getFilesDir(), ".realm.temp"));
            return;
        }
        throw new IllegalArgumentException("Non-null context required.");
    }

    public static void migrateRealm(RealmConfiguration realmConfiguration) throws FileNotFoundException {
        migrateRealm(realmConfiguration, (RealmMigration) null);
    }

    public static void migrateRealm(RealmConfiguration realmConfiguration, RealmMigration realmMigration) throws FileNotFoundException {
        BaseRealm.migrateRealm(realmConfiguration, realmMigration);
    }

    public static void removeDefaultConfiguration() {
        synchronized (defaultConfigurationLock) {
            defaultConfiguration = null;
        }
    }

    public static void setDefaultConfiguration(RealmConfiguration realmConfiguration) {
        if (realmConfiguration != null) {
            synchronized (defaultConfigurationLock) {
                defaultConfiguration = realmConfiguration;
            }
            return;
        }
        throw new IllegalArgumentException(NULL_CONFIG_MSG);
    }

    public void addChangeListener(RealmChangeListener<Realm> realmChangeListener) {
        addListener(realmChangeListener);
    }

    public C1701g<Realm> asFlowable() {
        return this.configuration.getRxFactory().from(this);
    }

    public /* bridge */ /* synthetic */ void beginTransaction() {
        super.beginTransaction();
    }

    public /* bridge */ /* synthetic */ void cancelTransaction() {
        super.cancelTransaction();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public /* bridge */ /* synthetic */ void commitTransaction() {
        super.commitTransaction();
    }

    public <E extends RealmModel> E copyFromRealm(E e) {
        return copyFromRealm(e, Integer.MAX_VALUE);
    }

    public <E extends RealmModel> E copyFromRealm(E e, int i) {
        checkMaxDepth(i);
        checkValidObjectForDetach(e);
        return createDetachedCopy(e, i, new HashMap());
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> iterable) {
        return copyFromRealm(iterable, Integer.MAX_VALUE);
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> iterable, int i) {
        checkMaxDepth(i);
        if (iterable == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList();
        HashMap hashMap = new HashMap();
        for (E e : iterable) {
            checkValidObjectForDetach(e);
            arrayList.add(createDetachedCopy(e, i, hashMap));
        }
        return arrayList;
    }

    public <E extends RealmModel> E copyToRealm(E e, ImportFlag... importFlagArr) {
        checkNotNullObject(e);
        return copyOrUpdate(e, false, new HashMap(), Util.toSet(importFlagArr));
    }

    public <E extends RealmModel> List<E> copyToRealm(Iterable<E> iterable, ImportFlag... importFlagArr) {
        if (iterable == null) {
            return new ArrayList();
        }
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList();
        HashMap hashMap = new HashMap();
        for (E e : iterable) {
            checkNotNullObject(e);
            arrayList.add(copyOrUpdate(e, false, hashMap, Util.toSet(importFlagArr)));
        }
        return arrayList;
    }

    public <E extends RealmModel> E copyToRealmOrUpdate(E e, ImportFlag... importFlagArr) {
        checkNotNullObject(e);
        checkHasPrimaryKey(e.getClass());
        return copyOrUpdate(e, true, new HashMap(), Util.toSet(importFlagArr));
    }

    public <E extends RealmModel> List<E> copyToRealmOrUpdate(Iterable<E> iterable, ImportFlag... importFlagArr) {
        if (iterable == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList();
        HashMap hashMap = new HashMap();
        Set set = Util.toSet(importFlagArr);
        for (E e : iterable) {
            checkNotNullObject(e);
            arrayList.add(copyOrUpdate(e, true, hashMap, set));
        }
        return arrayList;
    }

    @TargetApi(11)
    public <E extends RealmModel> void createAllFromJson(Class<E> cls, InputStream inputStream) throws IOException {
        if (cls != null && inputStream != null) {
            checkIfValid();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    this.configuration.getSchemaMediator().createUsingJsonStream(cls, this, jsonReader);
                }
                jsonReader.endArray();
            } finally {
                jsonReader.close();
            }
        }
    }

    public <E extends RealmModel> void createAllFromJson(Class<E> cls, String str) {
        if (cls != null && str != null && str.length() != 0) {
            try {
                createAllFromJson(cls, new JSONArray(str));
            } catch (JSONException e) {
                throw new RealmException("Could not create JSON array from string", e);
            }
        }
    }

    public <E extends RealmModel> void createAllFromJson(Class<E> cls, JSONArray jSONArray) {
        if (cls != null && jSONArray != null) {
            checkIfValid();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONArray.getJSONObject(i), false);
                    i++;
                } catch (JSONException e) {
                    throw new RealmException("Could not map JSON", e);
                }
            }
        }
    }

    public <E extends RealmModel> E createObject(Class<E> cls) {
        checkIfValid();
        return createObjectInternal(cls, true, Collections.emptyList());
    }

    public <E extends RealmModel> E createObject(Class<E> cls, Object obj) {
        checkIfValid();
        return createObjectInternal(cls, obj, true, Collections.emptyList());
    }

    @TargetApi(11)
    public <E extends RealmModel> E createObjectFromJson(Class<E> cls, InputStream inputStream) throws IOException {
        E e;
        E e2 = null;
        if (cls == null || inputStream == null) {
            return e2;
        }
        checkIfValid();
        if (OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, this.configuration.getSchemaMediator().getSimpleClassName(cls)) != null) {
            try {
                Scanner fullStringScanner = getFullStringScanner(inputStream);
                e = this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, new JSONObject(fullStringScanner.next()), false);
                fullStringScanner.close();
            } catch (JSONException e3) {
                throw new RealmException("Failed to read JSON", e3);
            } catch (Throwable th) {
                if (e2 != null) {
                    e2.close();
                }
                throw th;
            }
        } else {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                e = this.configuration.getSchemaMediator().createUsingJsonStream(cls, this, jsonReader);
            } finally {
                jsonReader.close();
            }
        }
        return e;
    }

    public <E extends RealmModel> E createObjectFromJson(Class<E> cls, String str) {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        try {
            return createObjectFromJson(cls, new JSONObject(str));
        } catch (JSONException e) {
            throw new RealmException("Could not create Json object from string", e);
        }
    }

    public <E extends RealmModel> E createObjectFromJson(Class<E> cls, JSONObject jSONObject) {
        if (cls == null || jSONObject == null) {
            return null;
        }
        checkIfValid();
        try {
            return this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONObject, false);
        } catch (JSONException e) {
            throw new RealmException("Could not map JSON", e);
        }
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E createObjectInternal(Class<E> cls, Object obj, boolean z, List<String> list) {
        return this.configuration.getSchemaMediator().newInstance(cls, this, OsObject.createWithPrimaryKey(this.schema.getTable((Class<? extends RealmModel>) cls), obj), this.schema.getColumnInfo((Class<? extends RealmModel>) cls), z, list);
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E createObjectInternal(Class<E> cls, boolean z, List<String> list) {
        Table table = this.schema.getTable((Class<? extends RealmModel>) cls);
        if (OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, this.configuration.getSchemaMediator().getSimpleClassName(cls)) == null) {
            return this.configuration.getSchemaMediator().newInstance(cls, this, OsObject.create(table), this.schema.getColumnInfo((Class<? extends RealmModel>) cls), z, list);
        }
        throw new RealmException(String.format(Locale.US, "'%s' has a primary key, use 'createObject(Class<E>, Object)' instead.", new Object[]{table.getClassName()}));
    }

    @TargetApi(11)
    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> cls, InputStream inputStream) {
        if (cls != null && inputStream != null) {
            checkIfValid();
            checkHasPrimaryKey(cls);
            Scanner scanner = null;
            try {
                Scanner fullStringScanner = getFullStringScanner(inputStream);
                JSONArray jSONArray = new JSONArray(fullStringScanner.next());
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONArray.getJSONObject(i), true);
                }
                fullStringScanner.close();
            } catch (JSONException e) {
                throw new RealmException("Failed to read JSON", e);
            } catch (Throwable th) {
                if (scanner != null) {
                    scanner.close();
                }
                throw th;
            }
        }
    }

    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> cls, String str) {
        if (cls != null && str != null && str.length() != 0) {
            checkIfValid();
            checkHasPrimaryKey(cls);
            try {
                createOrUpdateAllFromJson(cls, new JSONArray(str));
            } catch (JSONException e) {
                throw new RealmException("Could not create JSON array from string", e);
            }
        }
    }

    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> cls, JSONArray jSONArray) {
        if (cls != null && jSONArray != null) {
            checkIfValid();
            checkHasPrimaryKey(cls);
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONArray.getJSONObject(i), true);
                    i++;
                } catch (JSONException e) {
                    throw new RealmException("Could not map JSON", e);
                }
            }
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> cls, InputStream inputStream) {
        E e = null;
        if (cls == null || inputStream == null) {
            return e;
        }
        checkIfValid();
        checkHasPrimaryKey(cls);
        try {
            Scanner fullStringScanner = getFullStringScanner(inputStream);
            E createOrUpdateObjectFromJson = createOrUpdateObjectFromJson(cls, new JSONObject(fullStringScanner.next()));
            fullStringScanner.close();
            return createOrUpdateObjectFromJson;
        } catch (JSONException e2) {
            throw new RealmException("Failed to read JSON", e2);
        } catch (Throwable th) {
            if (e != null) {
                e.close();
            }
            throw th;
        }
    }

    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> cls, String str) {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        checkIfValid();
        checkHasPrimaryKey(cls);
        try {
            return createOrUpdateObjectFromJson(cls, new JSONObject(str));
        } catch (JSONException e) {
            throw new RealmException("Could not create Json object from string", e);
        }
    }

    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> cls, JSONObject jSONObject) {
        if (cls == null || jSONObject == null) {
            return null;
        }
        checkIfValid();
        checkHasPrimaryKey(cls);
        try {
            return this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONObject, true);
        } catch (JSONException e) {
            throw new RealmException("Could not map JSON", e);
        }
    }

    public void delete(Class<? extends RealmModel> cls) {
        checkIfValid();
        if (!this.sharedRealm.isPartial()) {
            this.schema.getTable(cls).clear(this.sharedRealm.isPartial());
            return;
        }
        throw new IllegalStateException("This API is not supported by partially synchronized Realms. Either unsubscribe using 'Realm.unsubscribeAsync()' or delete the objects using a query and 'RealmResults.deleteAllFromRealm()'");
    }

    public /* bridge */ /* synthetic */ void deleteAll() {
        super.deleteAll();
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction != null) {
            beginTransaction();
            try {
                transaction.execute(this);
                commitTransaction();
            } catch (Throwable th) {
                if (isInTransaction()) {
                    cancelTransaction();
                } else {
                    RealmLog.warn("Could not cancel transaction, not currently in a transaction.", new Object[0]);
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Transaction should not be null");
        }
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction) {
        return executeTransactionAsync(transaction, (Transaction.OnSuccess) null, (Transaction.OnError) null);
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, Transaction.OnError onError) {
        if (onError != null) {
            return executeTransactionAsync(transaction, (Transaction.OnSuccess) null, onError);
        }
        throw new IllegalArgumentException("onError callback can't be null");
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, Transaction.OnSuccess onSuccess) {
        if (onSuccess != null) {
            return executeTransactionAsync(transaction, onSuccess, (Transaction.OnError) null);
        }
        throw new IllegalArgumentException("onSuccess callback can't be null");
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, Transaction.OnSuccess onSuccess, Transaction.OnError onError) {
        checkIfValid();
        if (transaction != null) {
            final boolean canDeliverNotification = this.sharedRealm.capabilities.canDeliverNotification();
            if (!(onSuccess == null && onError == null)) {
                this.sharedRealm.capabilities.checkCanDeliverNotification("Callback cannot be delivered on current thread.");
            }
            final RealmConfiguration configuration = getConfiguration();
            final RealmNotifier realmNotifier = this.sharedRealm.realmNotifier;
            final Transaction transaction2 = transaction;
            final Transaction.OnSuccess onSuccess2 = onSuccess;
            final Transaction.OnError onError2 = onError;
            return new RealmAsyncTaskImpl(BaseRealm.asyncTaskExecutor.submitTransaction(new Runnable() {
                /* JADX INFO: finally extract failed */
                public void run() {
                    final OsSharedRealm.VersionID versionID;
                    if (!Thread.currentThread().isInterrupted()) {
                        Realm instance = Realm.getInstance(configuration);
                        instance.beginTransaction();
                        final Throwable th = null;
                        try {
                            transaction2.execute(instance);
                            if (Thread.currentThread().isInterrupted()) {
                                try {
                                    if (instance.isInTransaction()) {
                                        instance.cancelTransaction();
                                    }
                                } finally {
                                    instance.close();
                                }
                            } else {
                                instance.commitTransaction();
                                versionID = instance.sharedRealm.getVersionID();
                                try {
                                    if (instance.isInTransaction()) {
                                        instance.cancelTransaction();
                                    }
                                    if (canDeliverNotification) {
                                        if (versionID != null && onSuccess2 != null) {
                                            realmNotifier.post(new Runnable() {
                                                public void run() {
                                                    if (Realm.this.isClosed()) {
                                                        onSuccess2.onSuccess();
                                                    } else if (Realm.this.sharedRealm.getVersionID().compareTo(versionID) < 0) {
                                                        Realm.this.sharedRealm.realmNotifier.addTransactionCallback(new Runnable() {
                                                            public void run() {
                                                                onSuccess2.onSuccess();
                                                            }
                                                        });
                                                    } else {
                                                        onSuccess2.onSuccess();
                                                    }
                                                }
                                            });
                                        } else if (th != null) {
                                            realmNotifier.post(new Runnable() {
                                                public void run() {
                                                    Transaction.OnError onError = onError2;
                                                    if (onError != null) {
                                                        onError.onError(th);
                                                        return;
                                                    }
                                                    throw new RealmException("Async transaction failed", th);
                                                }
                                            });
                                        }
                                    } else if (th != null) {
                                        throw new RealmException("Async transaction failed", th);
                                    }
                                } finally {
                                    instance.close();
                                }
                            }
                        } catch (Throwable th2) {
                            instance.close();
                            throw th2;
                        }
                    }
                }
            }), BaseRealm.asyncTaskExecutor);
        }
        throw new IllegalArgumentException("Transaction should not be null");
    }

    public /* bridge */ /* synthetic */ RealmConfiguration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ String getPath() {
        return super.getPath();
    }

    public RealmSchema getSchema() {
        return this.schema;
    }

    /* access modifiers changed from: package-private */
    public Table getTable(Class<? extends RealmModel> cls) {
        return this.schema.getTable(cls);
    }

    public /* bridge */ /* synthetic */ long getVersion() {
        return super.getVersion();
    }

    public void insert(RealmModel realmModel) {
        checkIfValidAndInTransaction();
        if (realmModel != null) {
            this.configuration.getSchemaMediator().insert(this, realmModel, new HashMap());
            return;
        }
        throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
    }

    public void insert(Collection<? extends RealmModel> collection) {
        checkIfValidAndInTransaction();
        if (collection == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!collection.isEmpty()) {
            this.configuration.getSchemaMediator().insert(this, collection);
        }
    }

    public void insertOrUpdate(RealmModel realmModel) {
        checkIfValidAndInTransaction();
        if (realmModel != null) {
            this.configuration.getSchemaMediator().insertOrUpdate(this, realmModel, new HashMap());
            return;
        }
        throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
    }

    public void insertOrUpdate(Collection<? extends RealmModel> collection) {
        checkIfValidAndInTransaction();
        if (collection == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!collection.isEmpty()) {
            this.configuration.getSchemaMediator().insertOrUpdate(this, collection);
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoRefresh() {
        return super.isAutoRefresh();
    }

    public /* bridge */ /* synthetic */ boolean isClosed() {
        return super.isClosed();
    }

    public boolean isEmpty() {
        checkIfValid();
        for (RealmObjectSchema next : this.schema.getAll()) {
            if (!next.getClassName().startsWith("__") && next.getTable().size() > 0) {
                return false;
            }
        }
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isInTransaction() {
        return super.isInTransaction();
    }

    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public void removeAllChangeListeners() {
        removeAllListeners();
    }

    public void removeChangeListener(RealmChangeListener<Realm> realmChangeListener) {
        removeListener(realmChangeListener);
    }

    public /* bridge */ /* synthetic */ void setAutoRefresh(boolean z) {
        super.setAutoRefresh(z);
    }

    public /* bridge */ /* synthetic */ void stopWaitForChange() {
        super.stopWaitForChange();
    }

    public RealmAsyncTask unsubscribeAsync(final String str, final UnsubscribeCallback unsubscribeCallback) {
        if (Util.isEmptyString(str)) {
            throw new IllegalArgumentException("Non-empty 'subscriptionName' required.");
        } else if (unsubscribeCallback != null) {
            this.sharedRealm.capabilities.checkCanDeliverNotification("This method is only available from a Looper thread.");
            if (ObjectServerFacade.getSyncFacadeIfPossible().isPartialRealm(this.configuration)) {
                return executeTransactionAsync(new Transaction() {
                    public void execute(Realm realm) {
                        Table table = realm.sharedRealm.getTable("class___ResultSets");
                        OsResults createFromQuery = OsResults.createFromQuery(realm.sharedRealm, table.where().equalTo(new long[]{table.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME)}, new long[]{0}, str));
                        long size = createFromQuery.size();
                        if (size != 0) {
                            if (size > 1) {
                                RealmLog.warn(C0681a.m324a(C0681a.m330a("Multiple subscriptions named '"), str, "' exists. This should not be possible. They will all be deleted"), new Object[0]);
                            }
                            createFromQuery.clear();
                            return;
                        }
                        throw new IllegalArgumentException(C0681a.m324a(C0681a.m330a("No active subscription named '"), str, "' exists."));
                    }
                }, new Transaction.OnSuccess() {
                    public void onSuccess() {
                        unsubscribeCallback.onSuccess(str);
                    }
                }, new Transaction.OnError() {
                    public void onError(Throwable th) {
                        unsubscribeCallback.onError(str, th);
                    }
                });
            }
            StringBuilder a = C0681a.m330a("Realm is fully synchronized Realm. This method is only available when using query-based synchronization: ");
            a.append(this.configuration.getPath());
            throw new UnsupportedOperationException(a.toString());
        } else {
            throw new IllegalArgumentException("'callback' required.");
        }
    }

    public /* bridge */ /* synthetic */ boolean waitForChange() {
        return super.waitForChange();
    }

    public <E extends RealmModel> RealmQuery<E> where(Class<E> cls) {
        checkIfValid();
        return RealmQuery.createQuery(this, cls);
    }

    public /* bridge */ /* synthetic */ void writeCopyTo(File file) {
        super.writeCopyTo(file);
    }

    public /* bridge */ /* synthetic */ void writeEncryptedCopyTo(File file, byte[] bArr) {
        super.writeEncryptedCopyTo(file, bArr);
    }
}
