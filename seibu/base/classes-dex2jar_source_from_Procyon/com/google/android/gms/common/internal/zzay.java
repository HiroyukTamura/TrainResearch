// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.common.zzm;
import android.os.IInterface;

public interface zzay extends IInterface
{
    boolean zza(final zzm p0, final IObjectWrapper p1) throws RemoteException;
    
    boolean zze(final String p0, final IObjectWrapper p1) throws RemoteException;
    
    boolean zzf(final String p0, final IObjectWrapper p1) throws RemoteException;
    
    IObjectWrapper zzrF() throws RemoteException;
    
    IObjectWrapper zzrG() throws RemoteException;
}
