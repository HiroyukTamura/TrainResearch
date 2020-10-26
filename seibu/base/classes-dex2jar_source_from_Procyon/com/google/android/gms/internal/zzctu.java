// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.accounts.Account;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.auth.api.signin.internal.zzy;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.internal.zzal;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzm;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.Looper;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzz;

public final class zzctu extends zzz<zzcts> implements zzctk
{
    private final zzq zzaCA;
    private Integer zzaHn;
    private final Bundle zzbCL;
    private final boolean zzbCT;
    
    public zzctu(final Context context, final Looper looper, final boolean zzbCT, final zzq zzaCA, final Bundle zzbCL, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzaCA, connectionCallbacks, onConnectionFailedListener);
        this.zzbCT = zzbCT;
        this.zzaCA = zzaCA;
        this.zzbCL = zzbCL;
        this.zzaHn = zzaCA.zzru();
    }
    
    public zzctu(final Context context, final Looper looper, final boolean b, final zzq zzq, final zzctl zzctl, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, zzq, zza(zzq), connectionCallbacks, onConnectionFailedListener);
    }
    
    public static Bundle zza(final zzq zzq) {
        final zzctl zzrt = zzq.zzrt();
        final Integer zzru = zzq.zzru();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)zzq.getAccount());
        if (zzru != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", (int)zzru);
        }
        if (zzrt != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzrt.zzAr());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzrt.isIdTokenRequested());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzrt.getServerClientId());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzrt.zzAs());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzrt.zzAt());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzrt.zzAu());
            if (zzrt.zzAv() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", (long)zzrt.zzAv());
            }
            if (zzrt.zzAw() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", (long)zzrt.zzAw());
            }
        }
        return bundle;
    }
    
    @Override
    public final void connect() {
        this.zza(new zzm(this));
    }
    
    @Override
    public final void zzAq() {
        try {
            this.zzrf().zzbv(this.zzaHn);
        }
        catch (RemoteException ex) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }
    
    @Override
    public final void zza(final zzal zzal, final boolean b) {
        try {
            this.zzrf().zza(zzal, this.zzaHn, b);
        }
        catch (RemoteException ex) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }
    
    @Override
    public final void zza(final zzctq zzctq) {
        zzbo.zzb(zzctq, "Expecting a valid ISignInCallbacks");
        try {
            final Account zzrl = this.zzaCA.zzrl();
            GoogleSignInAccount zzmN = null;
            if ("<<default account>>".equals(zzrl.name)) {
                zzmN = zzy.zzaj(this.getContext()).zzmN();
            }
            this.zzrf().zza(new zzctv(new zzbp(zzrl, this.zzaHn, zzmN)), zzctq);
        }
        catch (RemoteException ex) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzctq.zzb(new zzctx(8));
            }
            catch (RemoteException ex2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)ex);
            }
        }
    }
    
    @Override
    protected final String zzdb() {
        return "com.google.android.gms.signin.service.START";
    }
    
    @Override
    protected final String zzdc() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }
    
    @Override
    protected final Bundle zzmo() {
        if (!this.getContext().getPackageName().equals(this.zzaCA.zzrq())) {
            this.zzbCL.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzaCA.zzrq());
        }
        return this.zzbCL;
    }
    
    @Override
    public final boolean zzmv() {
        return this.zzbCT;
    }
}
