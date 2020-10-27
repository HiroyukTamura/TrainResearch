package p041io.realm;

import android.os.SystemClock;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.BaseRealm;
import p041io.realm.internal.ObjectServerFacade;
import p041io.realm.internal.OsObjectStore;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.internal.RealmNotifier;
import p041io.realm.internal.Util;
import p041io.realm.internal.android.AndroidCapabilities;
import p041io.realm.internal.android.AndroidRealmNotifier;
import p041io.realm.internal.async.RealmAsyncTaskImpl;
import p041io.realm.log.RealmLog;

/* renamed from: io.realm.RealmCache */
final class RealmCache {
    private static final String ASYNC_CALLBACK_NULL_MSG = "The callback cannot be null.";
    private static final String ASYNC_NOT_ALLOWED_MSG = "Realm instances cannot be loaded asynchronously on a non-looper thread.";
    private static final String DIFFERENT_KEY_MESSAGE = "Wrong key used to decrypt Realm.";
    private static final String WRONG_REALM_CLASS_MESSAGE = "The type of Realm class must be Realm or DynamicRealm.";
    private static final List<WeakReference<RealmCache>> cachesList = new ArrayList();
    private static final Collection<RealmCache> leakedCaches = new ConcurrentLinkedQueue();
    private RealmConfiguration configuration;
    private final AtomicBoolean isLeaked = new AtomicBoolean(false);
    private final String realmPath;
    private final EnumMap<RealmCacheType, RefAndCount> refAndCountMap;

    /* renamed from: io.realm.RealmCache$Callback */
    interface Callback {
        void onResult(int i);
    }

    /* renamed from: io.realm.RealmCache$Callback0 */
    interface Callback0 {
        void onCall();
    }

    /* renamed from: io.realm.RealmCache$CreateRealmRunnable */
    private static class CreateRealmRunnable<T extends BaseRealm> implements Runnable {
        /* access modifiers changed from: private */
        public final BaseRealm.InstanceCallback<T> callback;
        /* access modifiers changed from: private */
        public final CountDownLatch canReleaseBackgroundInstanceLatch = new CountDownLatch(1);
        /* access modifiers changed from: private */
        public final RealmConfiguration configuration;
        /* access modifiers changed from: private */
        public Future future;
        private final RealmNotifier notifier;
        /* access modifiers changed from: private */
        public final Class<T> realmClass;

        CreateRealmRunnable(RealmNotifier realmNotifier, RealmConfiguration realmConfiguration, BaseRealm.InstanceCallback<T> instanceCallback, Class<T> cls) {
            this.configuration = realmConfiguration;
            this.realmClass = cls;
            this.callback = instanceCallback;
            this.notifier = realmNotifier;
        }

        public void run() {
            BaseRealm baseRealm = null;
            try {
                baseRealm = RealmCache.createRealmOrGetFromCache(this.configuration, this.realmClass);
                if (!this.notifier.post(new Runnable() {
                    public void run() {
                        if (CreateRealmRunnable.this.future == null || CreateRealmRunnable.this.future.isCancelled()) {
                            CreateRealmRunnable.this.canReleaseBackgroundInstanceLatch.countDown();
                            return;
                        }
                        BaseRealm baseRealm = null;
                        try {
                            BaseRealm createRealmOrGetFromCache = RealmCache.createRealmOrGetFromCache(CreateRealmRunnable.this.configuration, CreateRealmRunnable.this.realmClass);
                            CreateRealmRunnable.this.canReleaseBackgroundInstanceLatch.countDown();
                            BaseRealm baseRealm2 = createRealmOrGetFromCache;
                            th = null;
                            baseRealm = baseRealm2;
                        } catch (Throwable th) {
                            th = th;
                            CreateRealmRunnable.this.canReleaseBackgroundInstanceLatch.countDown();
                        }
                        if (baseRealm != null) {
                            CreateRealmRunnable.this.callback.onSuccess(baseRealm);
                        } else {
                            CreateRealmRunnable.this.callback.onError(th);
                        }
                    }
                })) {
                    this.canReleaseBackgroundInstanceLatch.countDown();
                }
                if (!this.canReleaseBackgroundInstanceLatch.await(2, TimeUnit.SECONDS)) {
                    RealmLog.warn("Timeout for creating Realm instance in foreground thread in `CreateRealmRunnable` ", new Object[0]);
                }
                if (baseRealm == null) {
                    return;
                }
            } catch (InterruptedException e) {
                RealmLog.warn(e, "`CreateRealmRunnable` has been interrupted.", new Object[0]);
                if (baseRealm == null) {
                    return;
                }
            } catch (Throwable th) {
                if (baseRealm != null) {
                    baseRealm.close();
                }
                throw th;
            }
            baseRealm.close();
        }

        public void setFuture(Future future2) {
            this.future = future2;
        }
    }

    /* renamed from: io.realm.RealmCache$RealmCacheType */
    private enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM;

        static RealmCacheType valueOf(Class<? extends BaseRealm> cls) {
            if (cls == Realm.class) {
                return TYPED_REALM;
            }
            if (cls == DynamicRealm.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException(RealmCache.WRONG_REALM_CLASS_MESSAGE);
        }
    }

    /* renamed from: io.realm.RealmCache$RefAndCount */
    private static class RefAndCount {
        /* access modifiers changed from: private */
        public int globalCount;
        /* access modifiers changed from: private */
        public final ThreadLocal<Integer> localCount;
        /* access modifiers changed from: private */
        public final ThreadLocal<BaseRealm> localRealm;

        private RefAndCount() {
            this.localRealm = new ThreadLocal<>();
            this.localCount = new ThreadLocal<>();
            this.globalCount = 0;
        }

        static /* synthetic */ int access$808(RefAndCount refAndCount) {
            int i = refAndCount.globalCount;
            refAndCount.globalCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$810(RefAndCount refAndCount) {
            int i = refAndCount.globalCount;
            refAndCount.globalCount = i - 1;
            return i;
        }
    }

    private RealmCache(String str) {
        this.realmPath = str;
        this.refAndCountMap = new EnumMap<>(RealmCacheType.class);
        for (RealmCacheType put : RealmCacheType.values()) {
            this.refAndCountMap.put(put, new RefAndCount());
        }
    }

    private static void copyAssetFileIfNeeded(final RealmConfiguration realmConfiguration) {
        final File file = realmConfiguration.hasAssetFile() ? new File(realmConfiguration.getRealmDirectory(), realmConfiguration.getRealmFileName()) : null;
        final String syncServerCertificateAssetName = ObjectServerFacade.getFacade(realmConfiguration.isSyncConfiguration()).getSyncServerCertificateAssetName(realmConfiguration);
        final boolean z = !Util.isEmptyString(syncServerCertificateAssetName);
        if (file != null || z) {
            OsObjectStore.callWithLock(realmConfiguration, new Runnable() {
                public void run() {
                    if (file != null) {
                        RealmCache.copyFileIfNeeded(realmConfiguration.getAssetFilePath(), file);
                    }
                    if (z) {
                        RealmCache.copyFileIfNeeded(syncServerCertificateAssetName, new File(ObjectServerFacade.getFacade(realmConfiguration.isSyncConfiguration()).getSyncServerCertificateFilePath(realmConfiguration)));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085 A[SYNTHETIC, Splitter:B:44:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c A[SYNTHETIC, Splitter:B:48:0x008c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFileIfNeeded(java.lang.String r7, java.io.File r8) {
        /*
            boolean r0 = r8.exists()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            android.content.Context r1 = p041io.realm.BaseRealm.applicationContext     // Catch:{ IOException -> 0x0066, all -> 0x0062 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x0066, all -> 0x0062 }
            java.io.InputStream r1 = r1.open(r7)     // Catch:{ IOException -> 0x0066, all -> 0x0062 }
            if (r1 == 0) goto L_0x0049
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r8 = 4096(0x1000, float:5.74E-42)
            byte[] r8 = new byte[r8]     // Catch:{ IOException -> 0x0041 }
        L_0x001d:
            int r3 = r1.read(r8)     // Catch:{ IOException -> 0x0041 }
            r4 = -1
            if (r3 <= r4) goto L_0x0029
            r4 = 0
            r2.write(r8, r4, r3)     // Catch:{ IOException -> 0x0041 }
            goto L_0x001d
        L_0x0029:
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x002e
        L_0x002d:
            r0 = move-exception
        L_0x002e:
            r2.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r7 = move-exception
            if (r0 != 0) goto L_0x0036
            r0 = r7
        L_0x0036:
            if (r0 != 0) goto L_0x0039
            return
        L_0x0039:
            io.realm.exceptions.RealmFileException r7 = new io.realm.exceptions.RealmFileException
            io.realm.exceptions.RealmFileException$Kind r8 = p041io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR
            r7.<init>((p041io.realm.exceptions.RealmFileException.Kind) r8, (java.lang.Throwable) r0)
            throw r7
        L_0x0041:
            r8 = move-exception
            goto L_0x0069
        L_0x0043:
            r7 = move-exception
            r2 = r0
            goto L_0x0083
        L_0x0046:
            r8 = move-exception
            r2 = r0
            goto L_0x0069
        L_0x0049:
            io.realm.exceptions.RealmFileException r8 = new io.realm.exceptions.RealmFileException     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            io.realm.exceptions.RealmFileException$Kind r2 = p041io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r3.<init>()     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.lang.String r4 = "Invalid input stream to the asset file: "
            r3.append(r4)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r3.append(r7)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r8.<init>((p041io.realm.exceptions.RealmFileException.Kind) r2, (java.lang.String) r3)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            throw r8     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
        L_0x0062:
            r7 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0083
        L_0x0066:
            r8 = move-exception
            r1 = r0
            r2 = r1
        L_0x0069:
            io.realm.exceptions.RealmFileException r3 = new io.realm.exceptions.RealmFileException     // Catch:{ all -> 0x0082 }
            io.realm.exceptions.RealmFileException$Kind r4 = p041io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r5.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = "Could not resolve the path to the asset file: "
            r5.append(r6)     // Catch:{ all -> 0x0082 }
            r5.append(r7)     // Catch:{ all -> 0x0082 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0082 }
            r3.<init>(r4, r7, r8)     // Catch:{ all -> 0x0082 }
            throw r3     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r7 = move-exception
        L_0x0083:
            if (r1 == 0) goto L_0x008a
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008a
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            goto L_0x0091
        L_0x0090:
            throw r7
        L_0x0091:
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.RealmCache.copyFileIfNeeded(java.lang.String, java.io.File):void");
    }

    static <E extends BaseRealm> E createRealmOrGetFromCache(RealmConfiguration realmConfiguration, Class<E> cls) {
        return getCache(realmConfiguration.getPath(), true).doCreateRealmOrGetFromCache(realmConfiguration, cls);
    }

    static <T extends BaseRealm> RealmAsyncTask createRealmOrGetFromCacheAsync(RealmConfiguration realmConfiguration, BaseRealm.InstanceCallback<T> instanceCallback, Class<T> cls) {
        return getCache(realmConfiguration.getPath(), true).doCreateRealmOrGetFromCacheAsync(realmConfiguration, instanceCallback, cls);
    }

    private static void deleteRealmFileOnDisk(RealmConfiguration realmConfiguration) {
        int i = 5;
        boolean z = false;
        while (i > 0 && !z) {
            try {
                z = BaseRealm.deleteRealm(realmConfiguration);
            } catch (IllegalStateException unused) {
                i--;
                RealmLog.warn(C0681a.m317a("Sync server still holds a reference to the Realm. It cannot be deleted. Retrying ", i, " more times"), new Object[0]);
                if (i > 0) {
                    SystemClock.sleep(15);
                }
            }
        }
        if (!z) {
            StringBuilder a = C0681a.m330a("Failed to delete the underlying Realm file: ");
            a.append(realmConfiguration.getPath());
            RealmLog.error(a.toString(), new Object[0]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: io.realm.DynamicRealm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: io.realm.Realm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: io.realm.DynamicRealm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: io.realm.DynamicRealm} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized <E extends p041io.realm.BaseRealm> E doCreateRealmOrGetFromCache(p041io.realm.RealmConfiguration r8, java.lang.Class<E> r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.EnumMap<io.realm.RealmCache$RealmCacheType, io.realm.RealmCache$RefAndCount> r0 = r7.refAndCountMap     // Catch:{ all -> 0x00e2 }
            io.realm.RealmCache$RealmCacheType r1 = p041io.realm.RealmCache.RealmCacheType.valueOf((java.lang.Class<? extends p041io.realm.BaseRealm>) r9)     // Catch:{ all -> 0x00e2 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00e2 }
            io.realm.RealmCache$RefAndCount r0 = (p041io.realm.RealmCache.RefAndCount) r0     // Catch:{ all -> 0x00e2 }
            int r1 = r7.getTotalGlobalRefCount()     // Catch:{ all -> 0x00e2 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0017
            r1 = 1
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            boolean r4 = r8.realmExists()     // Catch:{ all -> 0x00e2 }
            r4 = r4 ^ r3
            if (r1 == 0) goto L_0x007d
            copyAssetFileIfNeeded(r8)     // Catch:{ all -> 0x00e2 }
            r1 = 0
            boolean r5 = r8.isSyncConfiguration()     // Catch:{ all -> 0x0076 }
            if (r5 == 0) goto L_0x0065
            if (r4 == 0) goto L_0x006e
            io.realm.internal.OsRealmConfig$Builder r5 = new io.realm.internal.OsRealmConfig$Builder     // Catch:{ all -> 0x0076 }
            r5.<init>(r8)     // Catch:{ all -> 0x0076 }
            io.realm.internal.OsRealmConfig r5 = r5.build()     // Catch:{ all -> 0x0076 }
            io.realm.internal.ObjectServerFacade r6 = p041io.realm.internal.ObjectServerFacade.getSyncFacadeIfPossible()     // Catch:{ all -> 0x0076 }
            r6.wrapObjectStoreSessionIfRequired(r5)     // Catch:{ all -> 0x0076 }
            io.realm.internal.ObjectServerFacade r5 = p041io.realm.internal.ObjectServerFacade.getSyncFacadeIfPossible()     // Catch:{ all -> 0x0076 }
            boolean r5 = r5.isPartialRealm(r8)     // Catch:{ all -> 0x0076 }
            if (r5 == 0) goto L_0x005d
            io.realm.internal.OsSharedRealm r5 = p041io.realm.internal.OsSharedRealm.getInstance((p041io.realm.RealmConfiguration) r8)     // Catch:{ all -> 0x0076 }
            io.realm.internal.ObjectServerFacade r6 = p041io.realm.internal.ObjectServerFacade.getSyncFacadeIfPossible()     // Catch:{ all -> 0x0052 }
            r6.downloadInitialRemoteChanges(r8)     // Catch:{ all -> 0x0052 }
            r1 = r5
            goto L_0x006e
        L_0x0052:
            r9 = move-exception
            r5.close()     // Catch:{ all -> 0x005a }
            deleteRealmFileOnDisk(r8)     // Catch:{ all -> 0x0076 }
            throw r9     // Catch:{ all -> 0x0076 }
        L_0x005a:
            r8 = move-exception
            r1 = r5
            goto L_0x0077
        L_0x005d:
            io.realm.internal.ObjectServerFacade r5 = p041io.realm.internal.ObjectServerFacade.getSyncFacadeIfPossible()     // Catch:{ all -> 0x0076 }
            r5.downloadInitialRemoteChanges(r8)     // Catch:{ all -> 0x0076 }
            goto L_0x006e
        L_0x0065:
            if (r4 != 0) goto L_0x006e
            io.realm.internal.OsSharedRealm r1 = p041io.realm.internal.OsSharedRealm.getInstance((p041io.realm.RealmConfiguration) r8)     // Catch:{ all -> 0x0076 }
            p041io.realm.internal.Table.migratePrimaryKeyTableIfNeeded(r1)     // Catch:{ all -> 0x0076 }
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ all -> 0x00e2 }
        L_0x0073:
            r7.configuration = r8     // Catch:{ all -> 0x00e2 }
            goto L_0x0080
        L_0x0076:
            r8 = move-exception
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ all -> 0x00e2 }
        L_0x007c:
            throw r8     // Catch:{ all -> 0x00e2 }
        L_0x007d:
            r7.validateConfiguration(r8)     // Catch:{ all -> 0x00e2 }
        L_0x0080:
            java.lang.ThreadLocal r8 = r0.localRealm     // Catch:{ all -> 0x00e2 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00e2 }
            if (r8 != 0) goto L_0x00bc
            java.lang.Class<io.realm.Realm> r8 = p041io.realm.Realm.class
            if (r9 != r8) goto L_0x0096
            io.realm.Realm r8 = p041io.realm.Realm.createInstance((p041io.realm.RealmCache) r7)     // Catch:{ all -> 0x00e2 }
            synchronizeInitialSubscriptionsIfNeeded(r8, r4)     // Catch:{ all -> 0x00e2 }
            goto L_0x009e
        L_0x0096:
            java.lang.Class<io.realm.DynamicRealm> r8 = p041io.realm.DynamicRealm.class
            if (r9 != r8) goto L_0x00b4
            io.realm.DynamicRealm r8 = p041io.realm.DynamicRealm.createInstance((p041io.realm.RealmCache) r7)     // Catch:{ all -> 0x00e2 }
        L_0x009e:
            java.lang.ThreadLocal r9 = r0.localRealm     // Catch:{ all -> 0x00e2 }
            r9.set(r8)     // Catch:{ all -> 0x00e2 }
            java.lang.ThreadLocal r8 = r0.localCount     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00e2 }
            r8.set(r9)     // Catch:{ all -> 0x00e2 }
            p041io.realm.RealmCache.RefAndCount.access$808(r0)     // Catch:{ all -> 0x00e2 }
            goto L_0x00bc
        L_0x00b4:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e2 }
            java.lang.String r9 = "The type of Realm class must be Realm or DynamicRealm."
            r8.<init>(r9)     // Catch:{ all -> 0x00e2 }
            throw r8     // Catch:{ all -> 0x00e2 }
        L_0x00bc:
            java.lang.ThreadLocal r8 = r0.localCount     // Catch:{ all -> 0x00e2 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x00e2 }
            java.lang.ThreadLocal r9 = r0.localCount     // Catch:{ all -> 0x00e2 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x00e2 }
            int r8 = r8 + r3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00e2 }
            r9.set(r8)     // Catch:{ all -> 0x00e2 }
            java.lang.ThreadLocal r8 = r0.localRealm     // Catch:{ all -> 0x00e2 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00e2 }
            io.realm.BaseRealm r8 = (p041io.realm.BaseRealm) r8     // Catch:{ all -> 0x00e2 }
            monitor-exit(r7)
            return r8
        L_0x00e2:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.RealmCache.doCreateRealmOrGetFromCache(io.realm.RealmConfiguration, java.lang.Class):io.realm.BaseRealm");
    }

    private synchronized <T extends BaseRealm> RealmAsyncTask doCreateRealmOrGetFromCacheAsync(RealmConfiguration realmConfiguration, BaseRealm.InstanceCallback<T> instanceCallback, Class<T> cls) {
        Future<?> submitTransaction;
        AndroidCapabilities androidCapabilities = new AndroidCapabilities();
        androidCapabilities.checkCanDeliverNotification(ASYNC_NOT_ALLOWED_MSG);
        if (instanceCallback != null) {
            CreateRealmRunnable createRealmRunnable = new CreateRealmRunnable(new AndroidRealmNotifier((OsSharedRealm) null, androidCapabilities), realmConfiguration, instanceCallback, cls);
            submitTransaction = BaseRealm.asyncTaskExecutor.submitTransaction(createRealmRunnable);
            createRealmRunnable.setFuture(submitTransaction);
        } else {
            throw new IllegalArgumentException(ASYNC_CALLBACK_NULL_MSG);
        }
        return new RealmAsyncTaskImpl(submitTransaction, BaseRealm.asyncTaskExecutor);
    }

    private synchronized void doInvokeWithGlobalRefCount(Callback callback) {
        callback.onResult(getTotalGlobalRefCount());
    }

    private static RealmCache getCache(String str, boolean z) {
        RealmCache realmCache;
        synchronized (cachesList) {
            Iterator<WeakReference<RealmCache>> it = cachesList.iterator();
            realmCache = null;
            while (it.hasNext()) {
                RealmCache realmCache2 = (RealmCache) it.next().get();
                if (realmCache2 == null) {
                    it.remove();
                } else if (realmCache2.realmPath.equals(str)) {
                    realmCache = realmCache2;
                }
            }
            if (realmCache == null && z) {
                realmCache = new RealmCache(str);
                cachesList.add(new WeakReference(realmCache));
            }
        }
        return realmCache;
    }

    static int getLocalThreadCount(RealmConfiguration realmConfiguration) {
        RealmCache cache = getCache(realmConfiguration.getPath(), false);
        if (cache == null) {
            return 0;
        }
        int i = 0;
        for (RefAndCount access$700 : cache.refAndCountMap.values()) {
            Integer num = (Integer) access$700.localCount.get();
            i += num != null ? num.intValue() : 0;
        }
        return i;
    }

    private int getTotalGlobalRefCount() {
        int i = 0;
        for (RefAndCount access$800 : this.refAndCountMap.values()) {
            i += access$800.globalCount;
        }
        return i;
    }

    static void invokeWithGlobalRefCount(RealmConfiguration realmConfiguration, Callback callback) {
        synchronized (cachesList) {
            RealmCache cache = getCache(realmConfiguration.getPath(), false);
            if (cache == null) {
                callback.onResult(0);
            } else {
                cache.doInvokeWithGlobalRefCount(callback);
            }
        }
    }

    private static void synchronizeInitialSubscriptionsIfNeeded(Realm realm, boolean z) {
        if (z) {
            try {
                ObjectServerFacade.getSyncFacadeIfPossible().downloadInitialSubscriptions(realm);
            } catch (Throwable unused) {
                realm.close();
                deleteRealmFileOnDisk(realm.getConfiguration());
            }
        }
    }

    private void validateConfiguration(RealmConfiguration realmConfiguration) {
        if (!this.configuration.equals(realmConfiguration)) {
            if (Arrays.equals(this.configuration.getEncryptionKey(), realmConfiguration.getEncryptionKey())) {
                RealmMigration migration = realmConfiguration.getMigration();
                RealmMigration migration2 = this.configuration.getMigration();
                if (migration2 == null || migration == null || !migration2.getClass().equals(migration.getClass()) || migration.equals(migration2)) {
                    StringBuilder a = C0681a.m330a("Configurations cannot be different if used to open the same file. \nCached configuration: \n");
                    a.append(this.configuration);
                    a.append("\n\nNew configuration: \n");
                    a.append(realmConfiguration);
                    throw new IllegalArgumentException(a.toString());
                }
                StringBuilder a2 = C0681a.m330a("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: ");
                a2.append(realmConfiguration.getMigration().getClass().getCanonicalName());
                throw new IllegalArgumentException(a2.toString());
            }
            throw new IllegalArgumentException(DIFFERENT_KEY_MESSAGE);
        }
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: package-private */
    public synchronized void invokeWithLock(Callback0 callback0) {
        callback0.onCall();
    }

    /* access modifiers changed from: package-private */
    public void leak() {
        if (!this.isLeaked.getAndSet(true)) {
            leakedCaches.add(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void release(p041io.realm.BaseRealm r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r7.getPath()     // Catch:{ all -> 0x00a6 }
            java.util.EnumMap<io.realm.RealmCache$RealmCacheType, io.realm.RealmCache$RefAndCount> r1 = r6.refAndCountMap     // Catch:{ all -> 0x00a6 }
            java.lang.Class r2 = r7.getClass()     // Catch:{ all -> 0x00a6 }
            io.realm.RealmCache$RealmCacheType r2 = p041io.realm.RealmCache.RealmCacheType.valueOf((java.lang.Class<? extends p041io.realm.BaseRealm>) r2)     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00a6 }
            io.realm.RealmCache$RefAndCount r1 = (p041io.realm.RealmCache.RefAndCount) r1     // Catch:{ all -> 0x00a6 }
            java.lang.ThreadLocal r2 = r1.localCount     // Catch:{ all -> 0x00a6 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00a6 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00a6 }
            r3 = 0
            if (r2 != 0) goto L_0x0026
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00a6 }
        L_0x0026:
            int r4 = r2.intValue()     // Catch:{ all -> 0x00a6 }
            r5 = 1
            if (r4 > 0) goto L_0x003b
            java.lang.String r7 = "%s has been closed already. refCount is %s"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a6 }
            r1[r3] = r0     // Catch:{ all -> 0x00a6 }
            r1[r5] = r2     // Catch:{ all -> 0x00a6 }
            p041io.realm.log.RealmLog.warn(r7, r1)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r6)
            return
        L_0x003b:
            int r2 = r2.intValue()     // Catch:{ all -> 0x00a6 }
            int r2 = r2 - r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00a6 }
            int r3 = r2.intValue()     // Catch:{ all -> 0x00a6 }
            if (r3 != 0) goto L_0x009d
            java.lang.ThreadLocal r2 = r1.localCount     // Catch:{ all -> 0x00a6 }
            r3 = 0
            r2.set(r3)     // Catch:{ all -> 0x00a6 }
            java.lang.ThreadLocal r2 = r1.localRealm     // Catch:{ all -> 0x00a6 }
            r2.set(r3)     // Catch:{ all -> 0x00a6 }
            p041io.realm.RealmCache.RefAndCount.access$810(r1)     // Catch:{ all -> 0x00a6 }
            int r1 = r1.globalCount     // Catch:{ all -> 0x00a6 }
            if (r1 < 0) goto L_0x0081
            r7.doClose()     // Catch:{ all -> 0x00a6 }
            int r0 = r6.getTotalGlobalRefCount()     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x00a4
            r6.configuration = r3     // Catch:{ all -> 0x00a6 }
            io.realm.RealmConfiguration r0 = r7.getConfiguration()     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.isSyncConfiguration()     // Catch:{ all -> 0x00a6 }
            io.realm.internal.ObjectServerFacade r0 = p041io.realm.internal.ObjectServerFacade.getFacade(r0)     // Catch:{ all -> 0x00a6 }
            io.realm.RealmConfiguration r7 = r7.getConfiguration()     // Catch:{ all -> 0x00a6 }
            r0.realmClosed(r7)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a4
        L_0x0081:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "Global reference counter of Realm"
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            r1.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = " got corrupted."
            r1.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00a6 }
            r7.<init>(r0)     // Catch:{ all -> 0x00a6 }
            throw r7     // Catch:{ all -> 0x00a6 }
        L_0x009d:
            java.lang.ThreadLocal r7 = r1.localCount     // Catch:{ all -> 0x00a6 }
            r7.set(r2)     // Catch:{ all -> 0x00a6 }
        L_0x00a4:
            monitor-exit(r6)
            return
        L_0x00a6:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.RealmCache.release(io.realm.BaseRealm):void");
    }
}
