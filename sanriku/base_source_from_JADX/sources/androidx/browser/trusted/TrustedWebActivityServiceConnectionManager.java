package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.TransactionTooLargeException;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import p009e.p010a.p011a.p012a.C0681a;

public class TrustedWebActivityServiceConnectionManager {
    private static final String PREFS_FILE = "TrustedWebActivityVerifiedPackages";
    private static final String TAG = "TWAConnectionManager";
    private static AtomicReference<SharedPreferences> sSharedPreferences = new AtomicReference<>();
    Map<Uri, Connection> mConnections = new HashMap();
    final Context mContext;

    private class Connection implements ServiceConnection {
        private List<WrappedCallback> mCallbacks = new LinkedList();
        private final Uri mScope;
        private TrustedWebActivityServiceWrapper mService;

        Connection(Uri uri) {
            this.mScope = uri;
        }

        public void addCallback(WrappedCallback wrappedCallback) {
            TrustedWebActivityServiceWrapper trustedWebActivityServiceWrapper = this.mService;
            if (trustedWebActivityServiceWrapper == null) {
                this.mCallbacks.add(wrappedCallback);
            } else {
                wrappedCallback.onConnected(trustedWebActivityServiceWrapper);
            }
        }

        public TrustedWebActivityServiceWrapper getService() {
            return this.mService;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.mService = new TrustedWebActivityServiceWrapper(ITrustedWebActivityService.Stub.asInterface(iBinder), componentName);
            for (WrappedCallback onConnected : this.mCallbacks) {
                onConnected.onConnected(this.mService);
            }
            this.mCallbacks.clear();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.mService = null;
            TrustedWebActivityServiceConnectionManager.this.mConnections.remove(this.mScope);
        }
    }

    public interface ExecutionCallback {
        @SuppressLint({"RethrowRemoteException"})
        void onConnected(@Nullable TrustedWebActivityServiceWrapper trustedWebActivityServiceWrapper) throws RemoteException;
    }

    private interface WrappedCallback {
        void onConnected(@Nullable TrustedWebActivityServiceWrapper trustedWebActivityServiceWrapper);
    }

    public TrustedWebActivityServiceConnectionManager(@NonNull final Context context) {
        this.mContext = context.getApplicationContext();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                TrustedWebActivityServiceConnectionManager.ensurePreferencesOpened(context);
            }
        });
    }

    @Nullable
    private Intent createServiceIntent(Context context, Uri uri, String str, boolean z) {
        String str2;
        Set<String> verifiedPackages = getVerifiedPackages(context, str);
        if (verifiedPackages == null || verifiedPackages.size() == 0) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            str2 = it.next().activityInfo.packageName;
            if (verifiedPackages.contains(str2)) {
                break;
            }
        }
        if (str2 == null) {
            if (z) {
                Log.w(TAG, "No TWA candidates for " + str + " have been registered.");
            }
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(str2);
        intent2.setAction(TrustedWebActivityService.ACTION_TRUSTED_WEB_ACTIVITY_SERVICE);
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 131072);
        if (resolveService == null) {
            if (z) {
                Log.w(TAG, "Could not find TWAService for " + str2);
            }
            return null;
        }
        if (z) {
            StringBuilder a = C0681a.m330a("Found ");
            a.append(resolveService.serviceInfo.name);
            a.append(" to handle request for ");
            a.append(str);
            Log.i(TAG, a.toString());
        }
        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName(str2, resolveService.serviceInfo.name));
        return intent3;
    }

    static void ensurePreferencesOpened(@NonNull Context context) {
        if (sSharedPreferences.get() == null) {
            sSharedPreferences.compareAndSet((Object) null, context.getSharedPreferences(PREFS_FILE, 0));
        }
    }

    @NonNull
    public static Set<String> getVerifiedPackages(@NonNull Context context, @NonNull String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            ensurePreferencesOpened(context);
            return new HashSet(sSharedPreferences.get().getStringSet(str, Collections.emptySet()));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static void registerClient(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Set<String> verifiedPackages = getVerifiedPackages(context, str);
        verifiedPackages.add(str2);
        SharedPreferences.Editor edit = sSharedPreferences.get().edit();
        edit.putStringSet(str, verifiedPackages);
        edit.apply();
    }

    private static WrappedCallback wrapCallback(final ExecutionCallback executionCallback) {
        return new WrappedCallback() {
            public void onConnected(@Nullable final TrustedWebActivityServiceWrapper trustedWebActivityServiceWrapper) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        String str;
                        try {
                            executionCallback.onConnected(trustedWebActivityServiceWrapper);
                            return;
                        } catch (TransactionTooLargeException e) {
                            e = e;
                            str = "TransactionTooLargeException from TrustedWebActivityService, possibly due to large size of small icon.";
                        } catch (RemoteException | RuntimeException e2) {
                            e = e2;
                            str = "Exception while trying to use TrustedWebActivityService.";
                        }
                        Log.w(TrustedWebActivityServiceConnectionManager.TAG, str, e);
                    }
                });
            }
        };
    }

    @SuppressLint({"StaticFieldLeak"})
    @MainThread
    public boolean execute(@NonNull Uri uri, @NonNull String str, @NonNull ExecutionCallback executionCallback) {
        final WrappedCallback wrapCallback = wrapCallback(executionCallback);
        Connection connection = this.mConnections.get(uri);
        if (connection != null) {
            connection.addCallback(wrapCallback);
            return true;
        }
        final Intent createServiceIntent = createServiceIntent(this.mContext, uri, str, true);
        if (createServiceIntent == null) {
            return false;
        }
        final Connection connection2 = new Connection(uri);
        connection2.addCallback(wrapCallback);
        final Uri uri2 = uri;
        new AsyncTask<Void, Void, Connection>() {
            /* access modifiers changed from: protected */
            public Connection doInBackground(Void... voidArr) {
                try {
                    if (TrustedWebActivityServiceConnectionManager.this.mContext.bindService(createServiceIntent, connection2, 1)) {
                        return connection2;
                    }
                    TrustedWebActivityServiceConnectionManager.this.mContext.unbindService(connection2);
                    return null;
                } catch (SecurityException e) {
                    Log.w(TrustedWebActivityServiceConnectionManager.TAG, "SecurityException while binding.", e);
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Connection connection) {
                if (connection == null) {
                    wrapCallback.onConnected((TrustedWebActivityServiceWrapper) null);
                } else {
                    TrustedWebActivityServiceConnectionManager.this.mConnections.put(uri2, connection);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @MainThread
    public boolean serviceExistsForScope(@NonNull Uri uri, @NonNull String str) {
        return (this.mConnections.get(uri) == null && createServiceIntent(this.mContext, uri, str, false) == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void unbindAllConnections() {
        for (Connection unbindService : this.mConnections.values()) {
            this.mContext.unbindService(unbindService);
        }
        this.mConnections.clear();
    }
}
