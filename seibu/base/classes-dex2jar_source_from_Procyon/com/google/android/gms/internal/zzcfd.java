// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
import android.os.IInterface;

public interface zzcfd extends IInterface
{
    List<zzcji> zza(final zzceh p0, final boolean p1) throws RemoteException;
    
    List<zzcek> zza(final String p0, final String p1, final zzceh p2) throws RemoteException;
    
    List<zzcji> zza(final String p0, final String p1, final String p2, final boolean p3) throws RemoteException;
    
    List<zzcji> zza(final String p0, final String p1, final boolean p2, final zzceh p3) throws RemoteException;
    
    void zza(final long p0, final String p1, final String p2, final String p3) throws RemoteException;
    
    void zza(final zzceh p0) throws RemoteException;
    
    void zza(final zzcek p0, final zzceh p1) throws RemoteException;
    
    void zza(final zzcez p0, final zzceh p1) throws RemoteException;
    
    void zza(final zzcez p0, final String p1, final String p2) throws RemoteException;
    
    void zza(final zzcji p0, final zzceh p1) throws RemoteException;
    
    byte[] zza(final zzcez p0, final String p1) throws RemoteException;
    
    void zzb(final zzceh p0) throws RemoteException;
    
    void zzb(final zzcek p0) throws RemoteException;
    
    String zzc(final zzceh p0) throws RemoteException;
    
    List<zzcek> zzk(final String p0, final String p1, final String p2) throws RemoteException;
}
