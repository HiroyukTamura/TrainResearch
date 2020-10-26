// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzbau;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.internal.zzbcp;
import java.util.concurrent.locks.ReentrantLock;
import com.google.android.gms.internal.zzbbi;
import java.util.List;
import java.util.Collection;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzctg;
import android.support.v4.util.ArrayMap;
import java.util.HashSet;
import android.accounts.Account;
import java.util.ArrayList;
import com.google.android.gms.internal.zzctl;
import com.google.android.gms.internal.zzctk;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.zzbdr;
import com.google.android.gms.common.internal.zzr;
import android.view.View;
import com.google.android.gms.internal.zzbdw;
import com.google.android.gms.internal.zzbay;
import com.google.android.gms.internal.zzbei;
import com.google.android.gms.internal.zzbes;
import android.support.v4.app.FragmentActivity;
import android.os.Looper;
import android.content.Context;
import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;

public abstract class GoogleApiClient
{
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zzaAS;
    
    static {
        zzaAS = Collections.newSetFromMap(new WeakHashMap<GoogleApiClient, Boolean>());
    }
    
    public static void dumpAll(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        synchronized (GoogleApiClient.zzaAS) {
            final String concat = String.valueOf(s).concat("  ");
            final Iterator<GoogleApiClient> iterator = GoogleApiClient.zzaAS.iterator();
            int x = 0;
            while (iterator.hasNext()) {
                final GoogleApiClient googleApiClient = iterator.next();
                printWriter.append(s).append("GoogleApiClient#").println(x);
                googleApiClient.dump(concat, fileDescriptor, printWriter, array);
                ++x;
            }
        }
    }
    
    public static Set<GoogleApiClient> zzpk() {
        synchronized (GoogleApiClient.zzaAS) {
            return GoogleApiClient.zzaAS;
        }
    }
    
    public abstract ConnectionResult blockingConnect();
    
    public abstract ConnectionResult blockingConnect(final long p0, @NonNull final TimeUnit p1);
    
    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
    
    public abstract void connect();
    
    public void connect(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public abstract void disconnect();
    
    public abstract void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull final Api<?> p0);
    
    public Context getContext() {
        throw new UnsupportedOperationException();
    }
    
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }
    
    public abstract boolean hasConnectedApi(@NonNull final Api<?> p0);
    
    public abstract boolean isConnected();
    
    public abstract boolean isConnecting();
    
    public abstract boolean isConnectionCallbacksRegistered(@NonNull final ConnectionCallbacks p0);
    
    public abstract boolean isConnectionFailedListenerRegistered(@NonNull final OnConnectionFailedListener p0);
    
    public abstract void reconnect();
    
    public abstract void registerConnectionCallbacks(@NonNull final ConnectionCallbacks p0);
    
    public abstract void registerConnectionFailedListener(@NonNull final OnConnectionFailedListener p0);
    
    public abstract void stopAutoManage(@NonNull final FragmentActivity p0);
    
    public abstract void unregisterConnectionCallbacks(@NonNull final ConnectionCallbacks p0);
    
    public abstract void unregisterConnectionFailedListener(@NonNull final OnConnectionFailedListener p0);
    
    @NonNull
    public <C extends Api.zze> C zza(@NonNull final Api.zzc<C> zzc) {
        throw new UnsupportedOperationException();
    }
    
    public void zza(final zzbes zzbes) {
        throw new UnsupportedOperationException();
    }
    
    public boolean zza(@NonNull final Api<?> api) {
        throw new UnsupportedOperationException();
    }
    
    public boolean zza(final zzbei zzbei) {
        throw new UnsupportedOperationException();
    }
    
    public void zzb(final zzbes zzbes) {
        throw new UnsupportedOperationException();
    }
    
    public <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(@NonNull final T t) {
        throw new UnsupportedOperationException();
    }
    
    public <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T t) {
        throw new UnsupportedOperationException();
    }
    
    public <L> zzbdw<L> zzp(@NonNull final L l) {
        throw new UnsupportedOperationException();
    }
    
    public void zzpl() {
        throw new UnsupportedOperationException();
    }
    
    public static final class Builder
    {
        private final Context mContext;
        private final Set<Scope> zzaAT;
        private final Set<Scope> zzaAU;
        private int zzaAV;
        private View zzaAW;
        private String zzaAX;
        private final Map<Api<?>, zzr> zzaAY;
        private final Map<Api<?>, Api.ApiOptions> zzaAZ;
        private zzbdr zzaBa;
        private int zzaBb;
        private OnConnectionFailedListener zzaBc;
        private GoogleApiAvailability zzaBd;
        private Api.zza<? extends zzctk, zzctl> zzaBe;
        private final ArrayList<ConnectionCallbacks> zzaBf;
        private final ArrayList<OnConnectionFailedListener> zzaBg;
        private boolean zzaBh;
        private Account zzajb;
        private String zzake;
        private Looper zzrM;
        
        public Builder(@NonNull final Context mContext) {
            this.zzaAT = new HashSet<Scope>();
            this.zzaAU = new HashSet<Scope>();
            this.zzaAY = new ArrayMap<Api<?>, zzr>();
            this.zzaAZ = new ArrayMap<Api<?>, Api.ApiOptions>();
            this.zzaBb = -1;
            this.zzaBd = GoogleApiAvailability.getInstance();
            this.zzaBe = zzctg.zzajS;
            this.zzaBf = new ArrayList<ConnectionCallbacks>();
            this.zzaBg = new ArrayList<OnConnectionFailedListener>();
            this.zzaBh = false;
            this.mContext = mContext;
            this.zzrM = mContext.getMainLooper();
            this.zzake = mContext.getPackageName();
            this.zzaAX = mContext.getClass().getName();
        }
        
        public Builder(@NonNull final Context context, @NonNull final ConnectionCallbacks e, @NonNull final OnConnectionFailedListener e2) {
            this(context);
            zzbo.zzb(e, "Must provide a connected listener");
            this.zzaBf.add(e);
            zzbo.zzb(e2, "Must provide a connection failed listener");
            this.zzaBg.add(e2);
        }
        
        private final <O extends Api.ApiOptions> void zza(final Api<O> api, final O o, final Scope... array) {
            final HashSet<Scope> set = new HashSet<Scope>(api.zzpb().zzn(o));
            for (int length = array.length, i = 0; i < length; ++i) {
                set.add(array[i]);
            }
            this.zzaAY.put(api, new zzr(set));
        }
        
        public final Builder addApi(@NonNull final Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzbo.zzb(api, "Api must not be null");
            this.zzaAZ.put(api, null);
            final List<Scope> zzn = api.zzpb().zzn((Api.ApiOptions.NotRequiredOptions)null);
            this.zzaAU.addAll(zzn);
            this.zzaAT.addAll(zzn);
            return this;
        }
        
        public final <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull final Api<O> api, @NonNull final O o) {
            zzbo.zzb(api, "Api must not be null");
            zzbo.zzb(o, "Null options are not permitted for this Api");
            this.zzaAZ.put(api, (Api.ApiOptions)o);
            final List<Scope> zzn = api.zzpb().zzn(o);
            this.zzaAU.addAll(zzn);
            this.zzaAT.addAll(zzn);
            return this;
        }
        
        public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull final Api<O> api, @NonNull final O o, final Scope... array) {
            zzbo.zzb(api, "Api must not be null");
            zzbo.zzb(o, "Null options are not permitted for this Api");
            this.zzaAZ.put(api, (Api.ApiOptions)o);
            this.zza(api, o, array);
            return this;
        }
        
        public final Builder addApiIfAvailable(@NonNull final Api<? extends Api.ApiOptions.NotRequiredOptions> api, final Scope... array) {
            zzbo.zzb(api, "Api must not be null");
            this.zzaAZ.put(api, null);
            this.zza((Api<Api.ApiOptions>)api, null, array);
            return this;
        }
        
        public final Builder addConnectionCallbacks(@NonNull final ConnectionCallbacks e) {
            zzbo.zzb(e, "Listener must not be null");
            this.zzaBf.add(e);
            return this;
        }
        
        public final Builder addOnConnectionFailedListener(@NonNull final OnConnectionFailedListener e) {
            zzbo.zzb(e, "Listener must not be null");
            this.zzaBg.add(e);
            return this;
        }
        
        public final Builder addScope(@NonNull final Scope scope) {
            zzbo.zzb(scope, "Scope must not be null");
            this.zzaAT.add(scope);
            return this;
        }
        
        public final GoogleApiClient build() {
            boolean b = !this.zzaAZ.isEmpty();
            zzbo.zzb(b, (Object)"must call addApi() to add at least one API");
            final zzq zzpn = this.zzpn();
            Api api = null;
            final Map<Api<?>, zzr> zzrp = zzpn.zzrp();
            final ArrayMap<Api<?>, Boolean> arrayMap = new ArrayMap<Api<?>, Boolean>();
            final ArrayMap<Api.zzc<?>, Api.zze> arrayMap2 = new ArrayMap<Api.zzc<?>, Api.zze>();
            final ArrayList<zzbbi> list = new ArrayList<zzbbi>();
            final Iterator<Api<Object>> iterator = this.zzaAZ.keySet().iterator();
            boolean b2 = false;
        Label_0224_Outer:
            while (true) {
                Api<Object> api2 = null;
                Object zza = null;
                if (iterator.hasNext()) {
                    api2 = iterator.next();
                    final Api.ApiOptions value = this.zzaAZ.get(api2);
                    b = (zzrp.get(api2) != null);
                    arrayMap.put(api2, b);
                    final zzbbi e = new zzbbi(api2, b);
                    list.add(e);
                    final Api.zza<?, Api.ApiOptions> zzpc = api2.zzpc();
                    zza = zzpc.zza(this.mContext, this.zzrM, zzpn, value, e, e);
                    arrayMap2.put(api2.zzpd(), (Api.zze)zza);
                    if (zzpc.getPriority() == 1) {
                        b2 = (value != null);
                    }
                }
                else {
                    Label_0568: {
                        while (true) {
                            Label_0453: {
                                if (api == null) {
                                    break Label_0453;
                                }
                                if (b2) {
                                    final String value2 = String.valueOf(api.getName());
                                    throw new IllegalStateException(new StringBuilder(String.valueOf(value2).length() + 82).append("With using ").append(value2).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                                }
                                if (this.zzajb != null) {
                                    break Label_0568;
                                }
                                b = true;
                                zzbo.zza(b, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                                zzbo.zza(this.zzaAT.equals(this.zzaAU), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
                            }
                            final zzbcp zzbcp = new zzbcp(this.mContext, new ReentrantLock(), this.zzrM, zzpn, this.zzaBd, this.zzaBe, arrayMap, this.zzaBf, this.zzaBg, arrayMap2, this.zzaBb, com.google.android.gms.internal.zzbcp.zza((Iterable<Api.zze>)arrayMap2.values(), true), list, false);
                            synchronized (GoogleApiClient.zzaAS) {
                                GoogleApiClient.zzaAS.add(zzbcp);
                                // monitorexit(GoogleApiClient.zzpm())
                                if (this.zzaBb >= 0) {
                                    zzbau.zza(this.zzaBa).zza(this.zzaBb, zzbcp, this.zzaBc);
                                }
                                return zzbcp;
                                b = false;
                                continue Label_0224_Outer;
                            }
                            break;
                        }
                    }
                }
                while (true) {
                    Api<Object> api3;
                    if (((Api.zze)zza).zzmG()) {
                        api3 = api2;
                        if (api != null) {
                            final String value3 = String.valueOf(api2.getName());
                            final String value4 = String.valueOf(api.getName());
                            throw new IllegalStateException(new StringBuilder(String.valueOf(value3).length() + 21 + String.valueOf(value4).length()).append(value3).append(" cannot be used with ").append(value4).toString());
                        }
                    }
                    else {
                        api3 = (Api<Object>)api;
                    }
                    api = api3;
                    continue Label_0224_Outer;
                    continue;
                }
            }
        }
        
        public final Builder enableAutoManage(@NonNull final FragmentActivity fragmentActivity, final int zzaBb, @Nullable final OnConnectionFailedListener zzaBc) {
            final zzbdr zzaBa = new zzbdr(fragmentActivity);
            zzbo.zzb(zzaBb >= 0, (Object)"clientId must be non-negative");
            this.zzaBb = zzaBb;
            this.zzaBc = zzaBc;
            this.zzaBa = zzaBa;
            return this;
        }
        
        public final Builder enableAutoManage(@NonNull final FragmentActivity fragmentActivity, @Nullable final OnConnectionFailedListener onConnectionFailedListener) {
            return this.enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }
        
        public final Builder setAccountName(final String s) {
            Account zzajb;
            if (s == null) {
                zzajb = null;
            }
            else {
                zzajb = new Account(s, "com.google");
            }
            this.zzajb = zzajb;
            return this;
        }
        
        public final Builder setGravityForPopups(final int zzaAV) {
            this.zzaAV = zzaAV;
            return this;
        }
        
        public final Builder setHandler(@NonNull final Handler handler) {
            zzbo.zzb(handler, "Handler must not be null");
            this.zzrM = handler.getLooper();
            return this;
        }
        
        public final Builder setViewForPopups(@NonNull final View zzaAW) {
            zzbo.zzb(zzaAW, "View must not be null");
            this.zzaAW = zzaAW;
            return this;
        }
        
        public final Builder useDefaultAccount() {
            return this.setAccountName("<<default account>>");
        }
        
        public final Builder zze(final Account zzajb) {
            this.zzajb = zzajb;
            return this;
        }
        
        public final zzq zzpn() {
            zzctl zzbCM = zzctl.zzbCM;
            if (this.zzaAZ.containsKey(zzctg.API)) {
                zzbCM = (zzctl)this.zzaAZ.get(zzctg.API);
            }
            return new zzq(this.zzajb, this.zzaAT, this.zzaAY, this.zzaAV, this.zzaAW, this.zzake, this.zzaAX, zzbCM);
        }
    }
    
    public interface ConnectionCallbacks
    {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;
        
        void onConnected(@Nullable final Bundle p0);
        
        void onConnectionSuspended(final int p0);
    }
    
    public interface OnConnectionFailedListener
    {
        void onConnectionFailed(@NonNull final ConnectionResult p0);
    }
}
