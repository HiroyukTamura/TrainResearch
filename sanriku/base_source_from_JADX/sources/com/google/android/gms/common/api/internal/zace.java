package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zab;
import com.google.android.gms.signin.zac;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

public final class zace extends zad implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static Api.AbstractClientBuilder<? extends zac, SignInOptions> zakm = zab.zapv;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> mScopes;
    private final Api.AbstractClientBuilder<? extends zac, SignInOptions> zaaw;
    private ClientSettings zafa;
    private zac zagf;
    /* access modifiers changed from: private */
    public zacf zakn;

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        this(context, handler, clientSettings, zakm);
    }

    @WorkerThread
    public zace(Context context, Handler handler, @NonNull ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder) {
        this.mContext = context;
        this.mHandler = handler;
        this.zafa = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zaaw = abstractClientBuilder;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zac(zak zak) {
        ConnectionResult connectionResult = zak.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacv = zak.zacv();
            connectionResult = zacv.getConnectionResult();
            if (!connectionResult.isSuccess()) {
                String valueOf = String.valueOf(connectionResult);
                Log.wtf("SignInCoordinator", C0681a.m312a(valueOf.length() + 48, "Sign-in succeeded with resolve account failure: ", valueOf), new Exception());
            } else {
                this.zakn.zaa(zacv.getAccountAccessor(), this.mScopes);
                this.zagf.disconnect();
            }
        }
        this.zakn.zag(connectionResult);
        this.zagf.disconnect();
    }

    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zagf.zaa(this);
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zakn.zag(connectionResult);
    }

    @WorkerThread
    public final void onConnectionSuspended(int i) {
        this.zagf.disconnect();
    }

    @WorkerThread
    public final void zaa(zacf zacf) {
        zac zac = this.zagf;
        if (zac != null) {
            zac.disconnect();
        }
        this.zafa.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder = this.zaaw;
        Context context = this.mContext;
        Looper looper = this.mHandler.getLooper();
        ClientSettings clientSettings = this.zafa;
        this.zagf = (zac) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.zakn = zacf;
        Set<Scope> set = this.mScopes;
        if (set == null || set.isEmpty()) {
            this.mHandler.post(new zacd(this));
        } else {
            this.zagf.connect();
        }
    }

    @BinderThread
    public final void zab(zak zak) {
        this.mHandler.post(new zacg(this, zak));
    }

    public final zac zabo() {
        return this.zagf;
    }

    public final void zabq() {
        zac zac = this.zagf;
        if (zac != null) {
            zac.disconnect();
        }
    }
}
