// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.IInterface;

public interface zzfd extends IInterface
{
    String getId() throws RemoteException;
    
    boolean zzb(final boolean p0) throws RemoteException;
    
    void zzc(final String p0, final boolean p1) throws RemoteException;
    
    String zzq(final String p0) throws RemoteException;
}
