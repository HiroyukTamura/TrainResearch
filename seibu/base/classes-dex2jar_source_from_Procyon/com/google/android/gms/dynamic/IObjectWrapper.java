// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.internal.zzee;
import android.os.IInterface;

public interface IObjectWrapper extends IInterface
{
    public static class zza extends zzee implements IObjectWrapper
    {
        public zza() {
            this.attachInterface((IInterface)this, "com.google.android.gms.dynamic.IObjectWrapper");
        }
        
        public static IObjectWrapper zzM(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof IObjectWrapper) {
                return (IObjectWrapper)queryLocalInterface;
            }
            return new zzm(binder);
        }
    }
}
