// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.accounts.Account;
import android.os.IInterface;

public interface zzal extends IInterface
{
    Account getAccount() throws RemoteException;
}
