// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.zzef;
import android.accounts.Account;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzan extends zzed implements zzal
{
    zzan(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    @Override
    public final Account getAccount() throws RemoteException {
        final Parcel zza = this.zza(2, this.zzZ());
        final Account account = zzef.zza(zza, (android.os.Parcelable$Creator<Account>)Account.CREATOR);
        zza.recycle();
        return account;
    }
}
