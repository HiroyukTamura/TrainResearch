// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.os.RemoteException;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.internal.zzef;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.zzee;

public abstract class zzl extends zzee implements zzk
{
    public zzl() {
        this.attachInterface((IInterface)this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public boolean onTransact(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        final IObjectWrapper objectWrapper = null;
        final IObjectWrapper objectWrapper2 = null;
        if (this.zza(n, parcel, parcel2, n2)) {
            return true;
        }
        switch (n) {
            default: {
                return false;
            }
            case 2: {
                final IObjectWrapper zzty = this.zzty();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zzty);
                break;
            }
            case 3: {
                final Bundle arguments = this.getArguments();
                parcel2.writeNoException();
                zzef.zzb(parcel2, (Parcelable)arguments);
                break;
            }
            case 4: {
                n = this.getId();
                parcel2.writeNoException();
                parcel2.writeInt(n);
                break;
            }
            case 5: {
                final zzk zztz = this.zztz();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zztz);
                break;
            }
            case 6: {
                final IObjectWrapper zztA = this.zztA();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zztA);
                break;
            }
            case 7: {
                final boolean retainInstance = this.getRetainInstance();
                parcel2.writeNoException();
                zzef.zza(parcel2, retainInstance);
                break;
            }
            case 8: {
                final String tag = this.getTag();
                parcel2.writeNoException();
                parcel2.writeString(tag);
                break;
            }
            case 9: {
                final zzk zztB = this.zztB();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zztB);
                break;
            }
            case 10: {
                n = this.getTargetRequestCode();
                parcel2.writeNoException();
                parcel2.writeInt(n);
                break;
            }
            case 11: {
                final boolean userVisibleHint = this.getUserVisibleHint();
                parcel2.writeNoException();
                zzef.zza(parcel2, userVisibleHint);
                break;
            }
            case 12: {
                final IObjectWrapper view = this.getView();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)view);
                break;
            }
            case 13: {
                final boolean added = this.isAdded();
                parcel2.writeNoException();
                zzef.zza(parcel2, added);
                break;
            }
            case 14: {
                final boolean detached = this.isDetached();
                parcel2.writeNoException();
                zzef.zza(parcel2, detached);
                break;
            }
            case 15: {
                final boolean hidden = this.isHidden();
                parcel2.writeNoException();
                zzef.zza(parcel2, hidden);
                break;
            }
            case 16: {
                final boolean inLayout = this.isInLayout();
                parcel2.writeNoException();
                zzef.zza(parcel2, inLayout);
                break;
            }
            case 17: {
                final boolean removing = this.isRemoving();
                parcel2.writeNoException();
                zzef.zza(parcel2, removing);
                break;
            }
            case 18: {
                final boolean resumed = this.isResumed();
                parcel2.writeNoException();
                zzef.zza(parcel2, resumed);
                break;
            }
            case 19: {
                final boolean visible = this.isVisible();
                parcel2.writeNoException();
                zzef.zza(parcel2, visible);
                break;
            }
            case 20: {
                final IBinder strongBinder = parcel.readStrongBinder();
                IObjectWrapper objectWrapper3;
                if (strongBinder == null) {
                    objectWrapper3 = objectWrapper2;
                }
                else {
                    final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
                    if (queryLocalInterface instanceof IObjectWrapper) {
                        objectWrapper3 = (IObjectWrapper)queryLocalInterface;
                    }
                    else {
                        objectWrapper3 = new zzm(strongBinder);
                    }
                }
                this.zzC(objectWrapper3);
                parcel2.writeNoException();
                break;
            }
            case 21: {
                this.setHasOptionsMenu(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            }
            case 22: {
                this.setMenuVisibility(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            }
            case 23: {
                this.setRetainInstance(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            }
            case 24: {
                this.setUserVisibleHint(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            }
            case 25: {
                this.startActivity(zzef.zza(parcel, (android.os.Parcelable$Creator<Intent>)Intent.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 26: {
                this.startActivityForResult(zzef.zza(parcel, (android.os.Parcelable$Creator<Intent>)Intent.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                break;
            }
            case 27: {
                final IBinder strongBinder2 = parcel.readStrongBinder();
                IObjectWrapper objectWrapper4;
                if (strongBinder2 == null) {
                    objectWrapper4 = objectWrapper;
                }
                else {
                    final IInterface queryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
                    if (queryLocalInterface2 instanceof IObjectWrapper) {
                        objectWrapper4 = (IObjectWrapper)queryLocalInterface2;
                    }
                    else {
                        objectWrapper4 = new zzm(strongBinder2);
                    }
                }
                this.zzD(objectWrapper4);
                parcel2.writeNoException();
                break;
            }
        }
        return true;
    }
}
