package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations implements FirebaseInstallationsApi {
    private static final String CHIME_FIREBASE_APP_NAME = "CHIME_ANDROID_SDK";
    private static final int CORE_POOL_SIZE = 0;
    private static final long KEEP_ALIVE_TIME_IN_SECONDS = 30;
    private static final String LOCKFILE_NAME_GENERATE_FID = "generatefid.lock";
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.mCount.getAndIncrement())}));
        }
    };
    private static final Object lockGenerateFid = new Object();
    private final ExecutorService backgroundExecutor;
    private String cachedFid;
    private final RandomFidGenerator fidGenerator;
    private final FirebaseApp firebaseApp;
    private final IidStore iidStore;
    @GuardedBy("lock")
    private final List<StateListener> listeners;
    private final Object lock;
    private final ExecutorService networkExecutor;
    private final PersistedInstallation persistedInstallation;
    private final FirebaseInstallationServiceClient serviceClient;
    private final Utils utils;

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$2 */
    static /* synthetic */ class C13412 {

        /* renamed from: $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode */
        static final /* synthetic */ int[] f1360xc38d2559;

        /* renamed from: $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode */
        static final /* synthetic */ int[] f1361xe5baa01a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|5|6|7|8|9|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.google.firebase.installations.remote.TokenResult$ResponseCode[] r0 = com.google.firebase.installations.remote.TokenResult.ResponseCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1361xe5baa01a = r0
                r1 = 0
                r2 = 1
                com.google.firebase.installations.remote.TokenResult$ResponseCode r3 = com.google.firebase.installations.remote.TokenResult.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r3 = f1361xe5baa01a     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r4 = com.google.firebase.installations.remote.TokenResult.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r3 = f1361xe5baa01a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r4 = com.google.firebase.installations.remote.TokenResult.ResponseCode.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                r4 = 3
                r3[r0] = r4     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode[] r3 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f1360xc38d2559 = r3
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r4 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = f1360xc38d2559     // Catch:{ NoSuchFieldError -> 0x0030 }
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r3 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0030 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0030 }
            L_0x0030:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.C13412.<clinit>():void");
        }
    }

    FirebaseInstallations(FirebaseApp firebaseApp2, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        this(new ThreadPoolExecutor(0, 1, KEEP_ALIVE_TIME_IN_SECONDS, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY), firebaseApp2, new FirebaseInstallationServiceClient(firebaseApp2.getApplicationContext(), userAgentPublisher, heartBeatInfo), new PersistedInstallation(firebaseApp2), new Utils(), new IidStore(firebaseApp2), new RandomFidGenerator());
    }

    FirebaseInstallations(ExecutorService executorService, FirebaseApp firebaseApp2, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation2, Utils utils2, IidStore iidStore2, RandomFidGenerator randomFidGenerator) {
        this.lock = new Object();
        this.cachedFid = null;
        this.listeners = new ArrayList();
        this.firebaseApp = firebaseApp2;
        this.serviceClient = firebaseInstallationServiceClient;
        this.persistedInstallation = persistedInstallation2;
        this.utils = utils2;
        this.iidStore = iidStore2;
        this.fidGenerator = randomFidGenerator;
        this.backgroundExecutor = executorService;
        this.networkExecutor = new ThreadPoolExecutor(0, 1, KEEP_ALIVE_TIME_IN_SECONDS, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
    }

    private Task<InstallationTokenResult> addGetAuthTokenListener() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.utils, taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getAuthTokenListener);
        }
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public Void deleteFirebaseInstallationId() throws FirebaseInstallationsException, IOException {
        this.cachedFid = null;
        PersistedInstallationEntry multiProcessSafePrefs = getMultiProcessSafePrefs();
        if (multiProcessSafePrefs.isRegistered()) {
            try {
                this.serviceClient.deleteFirebaseInstallation(getApiKey(), multiProcessSafePrefs.getFirebaseInstallationId(), getProjectIdentifier(), multiProcessSafePrefs.getRefreshToken());
            } catch (FirebaseException unused) {
                throw new FirebaseInstallationsException("Failed to delete a Firebase Installation.", FirebaseInstallationsException.Status.BAD_CONFIG);
            }
        }
        insertOrUpdatePrefs(multiProcessSafePrefs.withNoGeneratedFid());
        return null;
    }

    /* access modifiers changed from: private */
    public void doGetAuthToken(boolean z) {
        PersistedInstallationEntry prefsWithGeneratedIdMultiProcessSafe = getPrefsWithGeneratedIdMultiProcessSafe();
        if (z) {
            prefsWithGeneratedIdMultiProcessSafe = prefsWithGeneratedIdMultiProcessSafe.withClearedAuthToken();
        }
        triggerOnStateReached(prefsWithGeneratedIdMultiProcessSafe);
        this.networkExecutor.execute(FirebaseInstallations$$Lambda$4.lambdaFactory$(this, z));
    }

    private String doGetId() {
        String str = this.cachedFid;
        if (str != null) {
            return str;
        }
        PersistedInstallationEntry prefsWithGeneratedIdMultiProcessSafe = getPrefsWithGeneratedIdMultiProcessSafe();
        this.networkExecutor.execute(FirebaseInstallations$$Lambda$3.lambdaFactory$(this));
        return prefsWithGeneratedIdMultiProcessSafe.getFirebaseInstallationId();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doNetworkCallIfNecessary(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.getMultiProcessSafePrefs()
            boolean r1 = r0.isErrored()     // Catch:{ IOException -> 0x0058 }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r0.isUnregistered()     // Catch:{ IOException -> 0x0058 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            if (r3 != 0) goto L_0x001d
            com.google.firebase.installations.Utils r3 = r2.utils     // Catch:{ IOException -> 0x0058 }
            boolean r3 = r3.isAuthTokenExpired(r0)     // Catch:{ IOException -> 0x0058 }
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.fetchAuthTokenFromServer(r0)     // Catch:{ IOException -> 0x0058 }
            goto L_0x0026
        L_0x0022:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.registerFidWithServer(r0)     // Catch:{ IOException -> 0x0058 }
        L_0x0026:
            r2.insertOrUpdatePrefs(r3)
            boolean r0 = r3.isRegistered()
            if (r0 == 0) goto L_0x0035
            java.lang.String r0 = r3.getFirebaseInstallationId()
            r2.cachedFid = r0
        L_0x0035:
            boolean r0 = r3.isErrored()
            if (r0 == 0) goto L_0x0046
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r1 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r0.<init>(r1)
        L_0x0042:
            r2.triggerOnException(r3, r0)
            goto L_0x0057
        L_0x0046:
            boolean r0 = r3.isNotGenerated()
            if (r0 == 0) goto L_0x0054
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "cleared fid due to auth error"
            r0.<init>(r1)
            goto L_0x0042
        L_0x0054:
            r2.triggerOnStateReached(r3)
        L_0x0057:
            return
        L_0x0058:
            r3 = move-exception
            r2.triggerOnException(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.doNetworkCallIfNecessary(boolean):void");
    }

    private PersistedInstallationEntry fetchAuthTokenFromServer(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws IOException {
        TokenResult generateAuthToken = this.serviceClient.generateAuthToken(getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), persistedInstallationEntry.getRefreshToken());
        int ordinal = generateAuthToken.getResponseCode().ordinal();
        if (ordinal == 0) {
            return persistedInstallationEntry.withAuthToken(generateAuthToken.getToken(), generateAuthToken.getTokenExpirationTimestamp(), this.utils.currentTimeInSecs());
        } else if (ordinal == 1) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        } else {
            if (ordinal == 2) {
                this.cachedFid = null;
                return persistedInstallationEntry.withNoGeneratedFid();
            }
            throw new IOException();
        }
    }

    @NonNull
    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @NonNull
    public static FirebaseInstallations getInstance(@NonNull FirebaseApp firebaseApp2) {
        Preconditions.checkArgument(firebaseApp2 != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp2.get(FirebaseInstallationsApi.class);
    }

    private PersistedInstallationEntry getMultiProcessSafePrefs() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), LOCKFILE_NAME_GENERATE_FID);
            try {
                readPersistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            } catch (Throwable th) {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
                throw th;
            }
        }
        return readPersistedInstallationEntryValue;
    }

    private PersistedInstallationEntry getPrefsWithGeneratedIdMultiProcessSafe() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), LOCKFILE_NAME_GENERATE_FID);
            try {
                readPersistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
                if (readPersistedInstallationEntryValue.isNotGenerated()) {
                    readPersistedInstallationEntryValue = this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue.withUnregisteredFid(readExistingIidOrCreateFid(readPersistedInstallationEntryValue)));
                }
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            } catch (Throwable th) {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
                throw th;
            }
        }
        return readPersistedInstallationEntryValue;
    }

    private void insertOrUpdatePrefs(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (lockGenerateFid) {
            CrossProcessLock acquire = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), LOCKFILE_NAME_GENERATE_FID);
            try {
                this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            } catch (Throwable th) {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
                throw th;
            }
        }
    }

    private void preConditionChecks() {
        Preconditions.checkNotEmpty(getApplicationId());
        Preconditions.checkNotEmpty(getProjectIdentifier());
        Preconditions.checkNotEmpty(getApiKey());
        Preconditions.checkArgument(Utils.isValidAppIdFormat(getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.isValidApiKeyFormat(getApiKey()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String readExistingIidOrCreateFid(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.firebaseApp.getName().equals(CHIME_FIREBASE_APP_NAME) && !this.firebaseApp.isDefaultApp()) || !persistedInstallationEntry.shouldAttemptMigration()) {
            return this.fidGenerator.createRandomFid();
        }
        String readIid = this.iidStore.readIid();
        return TextUtils.isEmpty(readIid) ? this.fidGenerator.createRandomFid() : readIid;
    }

    private PersistedInstallationEntry registerFidWithServer(PersistedInstallationEntry persistedInstallationEntry) throws IOException {
        InstallationResponse createFirebaseInstallation = this.serviceClient.createFirebaseInstallation(getApiKey(), persistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), getApplicationId(), persistedInstallationEntry.getFirebaseInstallationId().length() == 11 ? this.iidStore.readToken() : null);
        int ordinal = createFirebaseInstallation.getResponseCode().ordinal();
        if (ordinal == 0) {
            return persistedInstallationEntry.withRegisteredFid(createFirebaseInstallation.getFid(), createFirebaseInstallation.getRefreshToken(), this.utils.currentTimeInSecs(), createFirebaseInstallation.getAuthToken().getToken(), createFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
        } else if (ordinal == 1) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        } else {
            throw new IOException();
        }
    }

    private void triggerOnException(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onException(persistedInstallationEntry, exc)) {
                    it.remove();
                }
            }
        }
    }

    private void triggerOnStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onStateReached(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    @NonNull
    public Task<Void> delete() {
        return Tasks.call(this.backgroundExecutor, FirebaseInstallations$$Lambda$2.lambdaFactory$(this));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getApiKey() {
        return this.firebaseApp.getOptions().getApiKey();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String getApplicationId() {
        return this.firebaseApp.getOptions().getApplicationId();
    }

    @NonNull
    public Task<String> getId() {
        preConditionChecks();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.trySetResult(doGetId());
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String getName() {
        return this.firebaseApp.getName();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getProjectIdentifier() {
        return this.firebaseApp.getOptions().getProjectId();
    }

    @NonNull
    public Task<InstallationTokenResult> getToken(boolean z) {
        preConditionChecks();
        Task<InstallationTokenResult> addGetAuthTokenListener = addGetAuthTokenListener();
        this.backgroundExecutor.execute(FirebaseInstallations$$Lambda$1.lambdaFactory$(this, z));
        return addGetAuthTokenListener;
    }
}
