package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zar;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
    /* access modifiers changed from: private */
    public static final Object lock = new Object();
    public static final Status zaib = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */
    public static final Status zaic = new Status(4, "The user must be signed in to make this API call.");
    private static GoogleApiManager zaig;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public long zaid = 5000;
    /* access modifiers changed from: private */
    public long zaie = 120000;
    /* access modifiers changed from: private */
    public long zaif = 10000;
    /* access modifiers changed from: private */
    public final Context zaih;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability zaii;
    /* access modifiers changed from: private */
    public final GoogleApiAvailabilityCache zaij;
    private final AtomicInteger zaik = new AtomicInteger(1);
    private final AtomicInteger zail = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<ApiKey<?>, zaa<?>> zaim = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    public zaad zain = null;
    /* access modifiers changed from: private */
    public final Set<ApiKey<?>> zaio = new ArraySet();
    private final Set<ApiKey<?>> zaip = new ArraySet();

    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {
        private final ApiKey<O> zaft;
        private final Queue<zac> zair = new LinkedList();
        /* access modifiers changed from: private */
        public final Api.Client zais;
        private final Api.AnyClient zait;
        private final zaz zaiu;
        private final Set<zaj> zaiv = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zabv> zaiw = new HashMap();
        private final int zaix;
        private final zace zaiy;
        private boolean zaiz;
        private final List<zac> zaja = new ArrayList();
        private ConnectionResult zajb = null;

        @WorkerThread
        public zaa(GoogleApi<O> googleApi) {
            Api.Client zaa = googleApi.zaa(GoogleApiManager.this.handler.getLooper(), (zaa<O>) this);
            this.zais = zaa;
            this.zait = zaa instanceof SimpleClientAdapter ? ((SimpleClientAdapter) zaa).getClient() : zaa;
            this.zaft = googleApi.getApiKey();
            this.zaiu = new zaz();
            this.zaix = googleApi.getInstanceId();
            if (this.zais.requiresSignIn()) {
                this.zaiy = googleApi.zaa(GoogleApiManager.this.zaih, GoogleApiManager.this.handler);
            } else {
                this.zaiy = null;
            }
        }

        @WorkerThread
        @Nullable
        private final Feature zaa(@Nullable Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] availableFeatures = this.zais.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
                }
                for (Feature feature2 : featureArr) {
                    if (!arrayMap.containsKey(feature2.getName()) || ((Long) arrayMap.get(feature2.getName())).longValue() < feature2.getVersion()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zaa(zac zac) {
            if (!this.zaja.contains(zac) || this.zaiz) {
                return;
            }
            if (!this.zais.isConnected()) {
                connect();
            } else {
                zabg();
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zab(zac zac) {
            Feature[] zaa;
            if (this.zaja.remove(zac)) {
                GoogleApiManager.this.handler.removeMessages(15, zac);
                GoogleApiManager.this.handler.removeMessages(16, zac);
                Feature zad = zac.zaji;
                ArrayList arrayList = new ArrayList(this.zair.size());
                for (zac zac2 : this.zair) {
                    if ((zac2 instanceof zab) && (zaa = ((zab) zac2).zaa(this)) != null && ArrayUtils.contains((T[]) zaa, zad)) {
                        arrayList.add(zac2);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zac zac3 = (zac) obj;
                    this.zair.remove(zac3);
                    zac3.zaa((RuntimeException) new UnsupportedApiCallException(zad));
                }
            }
        }

        @WorkerThread
        private final boolean zab(zac zac) {
            if (!(zac instanceof zab)) {
                zac(zac);
                return true;
            }
            zab zab = (zab) zac;
            Feature zaa = zaa(zab.zaa(this));
            if (zaa == null) {
                zac(zac);
                return true;
            } else if (zab.zab(this)) {
                zac zac2 = new zac(this.zaft, zaa, (zabh) null);
                int indexOf = this.zaja.indexOf(zac2);
                if (indexOf >= 0) {
                    zac zac3 = this.zaja.get(indexOf);
                    GoogleApiManager.this.handler.removeMessages(15, zac3);
                    GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zac3), GoogleApiManager.this.zaid);
                    return false;
                }
                this.zaja.add(zac2);
                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zac2), GoogleApiManager.this.zaid);
                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 16, zac2), GoogleApiManager.this.zaie);
                ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
                if (zah(connectionResult)) {
                    return false;
                }
                GoogleApiManager.this.zac(connectionResult, this.zaix);
                return false;
            } else {
                zab.zaa((RuntimeException) new UnsupportedApiCallException(zaa));
                return false;
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zabe() {
            zabj();
            zai(ConnectionResult.RESULT_SUCCESS);
            zabl();
            Iterator<zabv> it = this.zaiw.values().iterator();
            while (it.hasNext()) {
                zabv next = it.next();
                if (zaa(next.zakc.getRequiredFeatures()) == null) {
                    try {
                        next.zakc.registerListener(this.zait, new TaskCompletionSource());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.zais.disconnect();
                    } catch (RemoteException unused2) {
                    }
                }
                it.remove();
            }
            zabg();
            zabm();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zabf() {
            zabj();
            this.zaiz = true;
            this.zaiu.zaag();
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zaft), GoogleApiManager.this.zaid);
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 11, this.zaft), GoogleApiManager.this.zaie);
            GoogleApiManager.this.zaij.flush();
        }

        @WorkerThread
        private final void zabg() {
            ArrayList arrayList = new ArrayList(this.zair);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zac zac = (zac) obj;
                if (!this.zais.isConnected()) {
                    return;
                }
                if (zab(zac)) {
                    this.zair.remove(zac);
                }
            }
        }

        @WorkerThread
        private final void zabl() {
            if (this.zaiz) {
                GoogleApiManager.this.handler.removeMessages(11, this.zaft);
                GoogleApiManager.this.handler.removeMessages(9, this.zaft);
                this.zaiz = false;
            }
        }

        private final void zabm() {
            GoogleApiManager.this.handler.removeMessages(12, this.zaft);
            GoogleApiManager.this.handler.sendMessageDelayed(GoogleApiManager.this.handler.obtainMessage(12, this.zaft), GoogleApiManager.this.zaif);
        }

        @WorkerThread
        private final void zac(zac zac) {
            zac.zaa(this.zaiu, requiresSignIn());
            try {
                zac.zac(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zais.disconnect();
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final boolean zac(boolean z) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zais.isConnected() || this.zaiw.size() != 0) {
                return false;
            }
            if (this.zaiu.zaae()) {
                if (z) {
                    zabm();
                }
                return false;
            }
            this.zais.disconnect();
            return true;
        }

        @WorkerThread
        private final boolean zah(@NonNull ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.lock) {
                if (GoogleApiManager.this.zain == null || !GoogleApiManager.this.zaio.contains(this.zaft)) {
                    return false;
                }
                GoogleApiManager.this.zain.zab(connectionResult, this.zaix);
                return true;
            }
        }

        @WorkerThread
        private final void zai(ConnectionResult connectionResult) {
            for (zaj next : this.zaiv) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.zais.getEndpointPackageName();
                }
                next.zaa(this.zaft, connectionResult, str);
            }
            this.zaiv.clear();
        }

        @WorkerThread
        public final void connect() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zais.isConnected() && !this.zais.isConnecting()) {
                int clientAvailability = GoogleApiManager.this.zaij.getClientAvailability(GoogleApiManager.this.zaih, this.zais);
                if (clientAvailability != 0) {
                    onConnectionFailed(new ConnectionResult(clientAvailability, (PendingIntent) null));
                    return;
                }
                zab zab = new zab(this.zais, this.zaft);
                if (this.zais.requiresSignIn()) {
                    this.zaiy.zaa((zacf) zab);
                }
                this.zais.connect(zab);
            }
        }

        public final int getInstanceId() {
            return this.zaix;
        }

        /* access modifiers changed from: package-private */
        public final boolean isConnected() {
            return this.zais.isConnected();
        }

        public final void onConnected(@Nullable Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zabe();
            } else {
                GoogleApiManager.this.handler.post(new zabi(this));
            }
        }

        @WorkerThread
        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            zace zace = this.zaiy;
            if (zace != null) {
                zace.zabq();
            }
            zabj();
            GoogleApiManager.this.zaij.flush();
            zai(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zac(GoogleApiManager.zaic);
            } else if (this.zair.isEmpty()) {
                this.zajb = connectionResult;
            } else if (!zah(connectionResult) && !GoogleApiManager.this.zac(connectionResult, this.zaix)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zaiz = true;
                }
                if (this.zaiz) {
                    GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zaft), GoogleApiManager.this.zaid);
                    return;
                }
                String apiName = this.zaft.getApiName();
                String valueOf = String.valueOf(connectionResult);
                zac(new Status(17, C0681a.m314a(valueOf.length() + C0681a.m336b(apiName, 63), "API: ", apiName, " is not available on this device. Connection failed with: ", valueOf)));
            }
        }

        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zabf();
            } else {
                GoogleApiManager.this.handler.post(new zabk(this));
            }
        }

        public final boolean requiresSignIn() {
            return this.zais.requiresSignIn();
        }

        @WorkerThread
        public final void resume() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zaiz) {
                connect();
            }
        }

        public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                GoogleApiManager.this.handler.post(new zabj(this, connectionResult));
            }
        }

        @WorkerThread
        public final void zaa(zac zac) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zais.isConnected()) {
                this.zair.add(zac);
                ConnectionResult connectionResult = this.zajb;
                if (connectionResult == null || !connectionResult.hasResolution()) {
                    connect();
                } else {
                    onConnectionFailed(this.zajb);
                }
            } else if (zab(zac)) {
                zabm();
            } else {
                this.zair.add(zac);
            }
        }

        @WorkerThread
        public final void zaa(zaj zaj) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zaiv.add(zaj);
        }

        public final Api.Client zaad() {
            return this.zais;
        }

        @WorkerThread
        public final void zaat() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zaiz) {
                zabl();
                zac(GoogleApiManager.this.zaii.isGooglePlayServicesAvailable(GoogleApiManager.this.zaih) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.zais.disconnect();
            }
        }

        @WorkerThread
        public final void zabh() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            zac(GoogleApiManager.zaib);
            this.zaiu.zaaf();
            for (ListenerHolder.ListenerKey zah : (ListenerHolder.ListenerKey[]) this.zaiw.keySet().toArray(new ListenerHolder.ListenerKey[this.zaiw.size()])) {
                zaa((zac) new zah(zah, new TaskCompletionSource()));
            }
            zai(new ConnectionResult(4));
            if (this.zais.isConnected()) {
                this.zais.onUserSignOut(new zabm(this));
            }
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabv> zabi() {
            return this.zaiw;
        }

        @WorkerThread
        public final void zabj() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zajb = null;
        }

        @WorkerThread
        public final ConnectionResult zabk() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            return this.zajb;
        }

        @WorkerThread
        public final boolean zabn() {
            return zac(true);
        }

        /* access modifiers changed from: package-private */
        public final com.google.android.gms.signin.zac zabo() {
            zace zace = this.zaiy;
            if (zace == null) {
                return null;
            }
            return zace.zabo();
        }

        @WorkerThread
        public final void zac(Status status) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            for (zac zaa : this.zair) {
                zaa.zaa(status);
            }
            this.zair.clear();
        }

        @WorkerThread
        public final void zag(@NonNull ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zais.disconnect();
            onConnectionFailed(connectionResult);
        }
    }

    private class zab implements zacf, BaseGmsClient.ConnectionProgressReportCallbacks {
        /* access modifiers changed from: private */
        public final ApiKey<?> zaft;
        /* access modifiers changed from: private */
        public final Api.Client zais;
        private IAccountAccessor zaje = null;
        private Set<Scope> zajf = null;
        /* access modifiers changed from: private */
        public boolean zajg = false;

        public zab(Api.Client client, ApiKey<?> apiKey) {
            this.zais = client;
            this.zaft = apiKey;
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zabp() {
            IAccountAccessor iAccountAccessor;
            if (this.zajg && (iAccountAccessor = this.zaje) != null) {
                this.zais.getRemoteService(iAccountAccessor, this.zajf);
            }
        }

        public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            GoogleApiManager.this.handler.post(new zabo(this, connectionResult));
        }

        @WorkerThread
        public final void zaa(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zag(new ConnectionResult(4));
                return;
            }
            this.zaje = iAccountAccessor;
            this.zajf = set;
            zabp();
        }

        @WorkerThread
        public final void zag(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.zaim.get(this.zaft)).zag(connectionResult);
        }
    }

    private static class zac {
        /* access modifiers changed from: private */
        public final ApiKey<?> zajh;
        /* access modifiers changed from: private */
        public final Feature zaji;

        private zac(ApiKey<?> apiKey, Feature feature) {
            this.zajh = apiKey;
            this.zaji = feature;
        }

        /* synthetic */ zac(ApiKey apiKey, Feature feature, zabh zabh) {
            this(apiKey, feature);
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof zac)) {
                zac zac = (zac) obj;
                return Objects.equal(this.zajh, zac.zajh) && Objects.equal(this.zaji, zac.zaji);
            }
        }

        public final int hashCode() {
            return Objects.hashCode(this.zajh, this.zaji);
        }

        public final String toString() {
            return Objects.toStringHelper(this).add("key", this.zajh).add("feature", this.zaji).toString();
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zaih = context;
        this.handler = new zar(looper, this);
        this.zaii = googleApiAvailability;
        this.zaij = new GoogleApiAvailabilityCache(googleApiAvailability);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(6));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (lock) {
            if (zaig != null) {
                GoogleApiManager googleApiManager = zaig;
                googleApiManager.zail.incrementAndGet();
                googleApiManager.handler.sendMessageAtFrontOfQueue(googleApiManager.handler.obtainMessage(10));
            }
        }
    }

    public static GoogleApiManager zab(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (lock) {
            if (zaig == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zaig = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zaig;
        }
        return googleApiManager;
    }

    @WorkerThread
    private final void zab(GoogleApi<?> googleApi) {
        ApiKey<?> apiKey = googleApi.getApiKey();
        zaa zaa2 = this.zaim.get(apiKey);
        if (zaa2 == null) {
            zaa2 = new zaa(googleApi);
            this.zaim.put(apiKey, zaa2);
        }
        if (zaa2.requiresSignIn()) {
            this.zaip.add(apiKey);
        }
        zaa2.connect();
    }

    public static GoogleApiManager zaba() {
        GoogleApiManager googleApiManager;
        synchronized (lock) {
            Preconditions.checkNotNull(zaig, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zaig;
        }
        return googleApiManager;
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        TaskCompletionSource<Boolean> taskCompletionSource;
        boolean z;
        int i = message.what;
        long j = 300000;
        zaa zaa2 = null;
        switch (i) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zaif = j;
                this.handler.removeMessages(12);
                for (ApiKey<?> obtainMessage : this.zaim.keySet()) {
                    Handler handler2 = this.handler;
                    handler2.sendMessageDelayed(handler2.obtainMessage(12, obtainMessage), this.zaif);
                }
                break;
            case 2:
                zaj zaj = (zaj) message.obj;
                Iterator<ApiKey<?>> it = zaj.zan().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ApiKey next = it.next();
                        zaa zaa3 = this.zaim.get(next);
                        if (zaa3 == null) {
                            zaj.zaa(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (zaa3.isConnected()) {
                            zaj.zaa(next, ConnectionResult.RESULT_SUCCESS, zaa3.zaad().getEndpointPackageName());
                        } else if (zaa3.zabk() != null) {
                            zaj.zaa(next, zaa3.zabk(), (String) null);
                        } else {
                            zaa3.zaa(zaj);
                            zaa3.connect();
                        }
                    }
                }
            case 3:
                for (zaa next2 : this.zaim.values()) {
                    next2.zabj();
                    next2.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zabu zabu = (zabu) message.obj;
                zaa zaa4 = this.zaim.get(zabu.zajz.getApiKey());
                if (zaa4 == null) {
                    zab(zabu.zajz);
                    zaa4 = this.zaim.get(zabu.zajz.getApiKey());
                }
                if (zaa4.requiresSignIn() && this.zail.get() != zabu.zajy) {
                    zabu.zajx.zaa(zaib);
                    zaa4.zabh();
                    break;
                } else {
                    zaa4.zaa(zabu.zajx);
                    break;
                }
                break;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it2 = this.zaim.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaa next3 = it2.next();
                        if (next3.getInstanceId() == i2) {
                            zaa2 = next3;
                        }
                    }
                }
                if (zaa2 == null) {
                    Log.wtf("GoogleApiManager", C0681a.m310a(76, "Could not find API instance ", i2, " while trying to fail enqueued calls."), new Exception());
                    break;
                } else {
                    String errorString = this.zaii.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    zaa2.zac(new Status(17, C0681a.m314a(C0681a.m336b(errorMessage, C0681a.m336b(errorString, 69)), "Error resolution was canceled by the user, original error message: ", errorString, ": ", errorMessage)));
                    break;
                }
            case 6:
                if (PlatformVersion.isAtLeastIceCreamSandwich() && (this.zaih.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.initialize((Application) this.zaih.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabh(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zaif = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zab((GoogleApi<?>) (GoogleApi) message.obj);
                break;
            case 9:
                if (this.zaim.containsKey(message.obj)) {
                    this.zaim.get(message.obj).resume();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> remove : this.zaip) {
                    this.zaim.remove(remove).zabh();
                }
                this.zaip.clear();
                break;
            case 11:
                if (this.zaim.containsKey(message.obj)) {
                    this.zaim.get(message.obj).zaat();
                    break;
                }
                break;
            case 12:
                if (this.zaim.containsKey(message.obj)) {
                    this.zaim.get(message.obj).zabn();
                    break;
                }
                break;
            case 14:
                zaae zaae = (zaae) message.obj;
                ApiKey<?> apiKey = zaae.getApiKey();
                if (!this.zaim.containsKey(apiKey)) {
                    taskCompletionSource = zaae.zaaj();
                    z = false;
                } else {
                    boolean zaa5 = this.zaim.get(apiKey).zac(false);
                    taskCompletionSource = zaae.zaaj();
                    z = Boolean.valueOf(zaa5);
                }
                taskCompletionSource.setResult(z);
                break;
            case 15:
                zac zac2 = (zac) message.obj;
                if (this.zaim.containsKey(zac2.zajh)) {
                    this.zaim.get(zac2.zajh).zaa(zac2);
                    break;
                }
                break;
            case 16:
                zac zac3 = (zac) message.obj;
                if (this.zaim.containsKey(zac3.zajh)) {
                    this.zaim.get(zac3.zajh).zab(zac3);
                    break;
                }
                break;
            default:
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i);
                Log.w("GoogleApiManager", sb.toString());
                return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void maybeSignOut() {
        this.zail.incrementAndGet();
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(10));
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent zaa(ApiKey<?> apiKey, int i) {
        com.google.android.gms.signin.zac zabo;
        zaa zaa2 = this.zaim.get(apiKey);
        if (zaa2 == null || (zabo = zaa2.zabo()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.zaih, i, zabo.getSignInIntent(), 134217728);
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zaa(@NonNull GoogleApi<O> googleApi, @NonNull ListenerHolder.ListenerKey<?> listenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zah zah = new zah(listenerKey, taskCompletionSource);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(13, new zabu(zah, this.zail.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Void> zaa(@NonNull GoogleApi<O> googleApi, @NonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zag zag = new zag(new zabv(registerListenerMethod, unregisterListenerMethod), taskCompletionSource);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(8, new zabu(zag, this.zail.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task<Map<ApiKey<?>, String>> zaa(Iterable<? extends HasApiKey<?>> iterable) {
        zaj zaj = new zaj(iterable);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(2, zaj));
        return zaj.getTask();
    }

    public final void zaa(ConnectionResult connectionResult, int i) {
        if (!zac(connectionResult, i)) {
            Handler handler2 = this.handler;
            handler2.sendMessage(handler2.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void zaa(GoogleApi<?> googleApi) {
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(7, googleApi));
    }

    public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> googleApi, int i, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zad zad = new zad(i, apiMethodImpl);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(4, new zabu(zad, this.zail.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> googleApi, int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaf zaf = new zaf(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(4, new zabu(zaf, this.zail.get(), googleApi)));
    }

    public final void zaa(@NonNull zaad zaad) {
        synchronized (lock) {
            if (this.zain != zaad) {
                this.zain = zaad;
                this.zaio.clear();
            }
            this.zaio.addAll(zaad.zaah());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zab(@NonNull zaad zaad) {
        synchronized (lock) {
            if (this.zain == zaad) {
                this.zain = null;
                this.zaio.clear();
            }
        }
    }

    public final int zabb() {
        return this.zaik.getAndIncrement();
    }

    public final Task<Boolean> zac(GoogleApi<?> googleApi) {
        zaae zaae = new zaae(googleApi.getApiKey());
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(14, zaae));
        return zaae.zaaj().getTask();
    }

    /* access modifiers changed from: package-private */
    public final boolean zac(ConnectionResult connectionResult, int i) {
        return this.zaii.zaa(this.zaih, connectionResult, i);
    }

    public final void zam() {
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(3));
    }
}
