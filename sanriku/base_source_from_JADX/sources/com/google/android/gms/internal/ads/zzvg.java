package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

abstract class zzvg<T> {
    @Nullable
    private static final zzwi zzcfx = zzpo();

    zzvg() {
    }

    private static zzwi zzpo() {
        try {
            Object newInstance = zzuu.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzazw.zzfc("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return queryLocalInterface instanceof zzwi ? (zzwi) queryLocalInterface : new zzwk(iBinder);
        } catch (Exception unused) {
            zzazw.zzfc("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    private final T zzpp() {
        zzwi zzwi = zzcfx;
        if (zzwi == null) {
            zzazw.zzfc("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzwi);
        } catch (RemoteException e) {
            zzazw.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private final T zzpq() {
        try {
            return zzpn();
        } catch (RemoteException e) {
            zzazw.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zza(zzwi zzwi) throws RemoteException;

    public final T zzd(Context context, boolean z) {
        T t;
        boolean z2 = false;
        boolean z3 = z;
        if (!z3) {
            zzvj.zzpr();
            if (!zzazm.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzazw.zzed("Google Play Services is not available.");
                z3 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = true;
        }
        zzzz.initialize(context);
        if (zzabj.zzcwj.get().booleanValue()) {
            z3 = false;
        }
        if (z3) {
            t = zzpp();
            if (t == null) {
                t = zzpq();
            }
        } else {
            T zzpq = zzpq();
            int i = zzpq == null ? 1 : 0;
            if (i != 0) {
                if (zzvj.zzpy().nextInt(zzabt.zzcxn.get().intValue()) == 0) {
                    z2 = true;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzvj.zzpr().zza(context, zzvj.zzpx().zzbnd, "gmob-apps", bundle, true);
                }
            }
            t = zzpq == null ? zzpp() : zzpq;
        }
        return t == null ? zzpm() : t;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract T zzpm();

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzpn() throws RemoteException;
}
