// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.Context;
import com.google.android.gms.common.zzo;
import android.os.RemoteException;
import android.util.Log;
import android.os.Binder;
import android.accounts.Account;

public final class zza extends zzam
{
    private int zzaGG;
    
    public static Account zza(final zzal zzal) {
        Account account = null;
        if (zzal == null) {
            return account;
        }
        final long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            account = zzal.getAccount();
            return account;
        }
        catch (RemoteException ex) {
            Log.w("AccountAccessor", "Remote account accessor probably died");
            return null;
        }
        finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
    
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zza)) {
            return false;
        }
        throw new NullPointerException();
    }
    
    @Override
    public final Account getAccount() {
        final int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzaGG) {
            return null;
        }
        if (zzo.zzf(null, callingUid)) {
            this.zzaGG = callingUid;
            return null;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
