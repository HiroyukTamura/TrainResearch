// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.ConnectionResult;
import android.os.Parcel;
import android.os.IInterface;

public abstract class zzctr extends zzee implements zzctq
{
    public zzctr() {
        this.attachInterface((IInterface)this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (this.zza(n, parcel, parcel2, n2)) {
            return true;
        }
        switch (n) {
            default: {
                return false;
            }
            case 3: {
                zzef.zza(parcel, ConnectionResult.CREATOR);
                zzef.zza(parcel, zzctn.CREATOR);
                break;
            }
            case 4: {
                zzef.zza(parcel, Status.CREATOR);
                break;
            }
            case 6: {
                zzef.zza(parcel, Status.CREATOR);
                break;
            }
            case 7: {
                zzef.zza(parcel, Status.CREATOR);
                zzef.zza(parcel, GoogleSignInAccount.CREATOR);
                break;
            }
            case 8: {
                this.zzb(zzef.zza(parcel, zzctx.CREATOR));
                break;
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
