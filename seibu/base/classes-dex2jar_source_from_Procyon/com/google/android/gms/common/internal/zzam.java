// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.accounts.Account;
import android.os.Parcelable;
import com.google.android.gms.internal.zzef;
import android.os.Parcel;
import com.google.android.gms.internal.zzee;

public abstract class zzam extends zzee implements zzal
{
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (this.zza(n, parcel, parcel2, n2)) {
            return true;
        }
        if (n == 2) {
            final Account account = this.getAccount();
            parcel2.writeNoException();
            zzef.zzb(parcel2, (Parcelable)account);
            return true;
        }
        return false;
    }
}
