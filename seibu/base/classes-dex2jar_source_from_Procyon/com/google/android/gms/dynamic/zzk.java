// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IInterface;

public interface zzk extends IInterface
{
    Bundle getArguments() throws RemoteException;
    
    int getId() throws RemoteException;
    
    boolean getRetainInstance() throws RemoteException;
    
    String getTag() throws RemoteException;
    
    int getTargetRequestCode() throws RemoteException;
    
    boolean getUserVisibleHint() throws RemoteException;
    
    IObjectWrapper getView() throws RemoteException;
    
    boolean isAdded() throws RemoteException;
    
    boolean isDetached() throws RemoteException;
    
    boolean isHidden() throws RemoteException;
    
    boolean isInLayout() throws RemoteException;
    
    boolean isRemoving() throws RemoteException;
    
    boolean isResumed() throws RemoteException;
    
    boolean isVisible() throws RemoteException;
    
    void setHasOptionsMenu(final boolean p0) throws RemoteException;
    
    void setMenuVisibility(final boolean p0) throws RemoteException;
    
    void setRetainInstance(final boolean p0) throws RemoteException;
    
    void setUserVisibleHint(final boolean p0) throws RemoteException;
    
    void startActivity(final Intent p0) throws RemoteException;
    
    void startActivityForResult(final Intent p0, final int p1) throws RemoteException;
    
    void zzC(final IObjectWrapper p0) throws RemoteException;
    
    void zzD(final IObjectWrapper p0) throws RemoteException;
    
    IObjectWrapper zztA() throws RemoteException;
    
    zzk zztB() throws RemoteException;
    
    IObjectWrapper zzty() throws RemoteException;
    
    zzk zztz() throws RemoteException;
}
