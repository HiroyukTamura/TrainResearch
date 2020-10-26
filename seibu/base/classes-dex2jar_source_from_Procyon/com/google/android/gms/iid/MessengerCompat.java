// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.iid;

import android.os.Parcel;
import android.os.RemoteException;
import android.os.Message;
import android.os.IInterface;
import android.os.Build$VERSION;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable
{
    public static final Parcelable$Creator<MessengerCompat> CREATOR;
    private Messenger zzbgX;
    private zzb zzbgY;
    
    static {
        CREATOR = (Parcelable$Creator)new zzd();
    }
    
    public MessengerCompat(final IBinder binder) {
        if (Build$VERSION.SDK_INT >= 21) {
            this.zzbgX = new Messenger(binder);
            return;
        }
        zzb zzbgY;
        if (binder == null) {
            zzbgY = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            if (queryLocalInterface instanceof zzb) {
                zzbgY = (zzb)queryLocalInterface;
            }
            else {
                zzbgY = new zzc(binder);
            }
        }
        this.zzbgY = zzbgY;
    }
    
    private final IBinder getBinder() {
        if (this.zzbgX != null) {
            return this.zzbgX.getBinder();
        }
        return this.zzbgY.asBinder();
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        try {
            return this.getBinder().equals(((MessengerCompat)o).getBinder());
        }
        catch (ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.getBinder().hashCode();
    }
    
    public final void send(final Message message) throws RemoteException {
        if (this.zzbgX != null) {
            this.zzbgX.send(message);
            return;
        }
        this.zzbgY.send(message);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (this.zzbgX != null) {
            parcel.writeStrongBinder(this.zzbgX.getBinder());
            return;
        }
        parcel.writeStrongBinder(this.zzbgY.asBinder());
    }
}
