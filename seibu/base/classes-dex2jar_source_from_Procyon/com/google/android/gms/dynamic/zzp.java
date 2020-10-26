// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;

public abstract class zzp<T>
{
    private final String zzaSC;
    private T zzaSD;
    
    protected zzp(final String zzaSC) {
        this.zzaSC = zzaSC;
    }
    
    protected final T zzaS(Context remoteContext) throws zzq {
        Label_0058: {
            if (this.zzaSD != null) {
                break Label_0058;
            }
            zzbo.zzu(remoteContext);
            remoteContext = zzo.getRemoteContext(remoteContext);
            if (remoteContext == null) {
                throw new zzq("Could not get remote context.");
            }
            final ClassLoader classLoader = remoteContext.getClassLoader();
            try {
                this.zzaSD = this.zzb((IBinder)classLoader.loadClass(this.zzaSC).newInstance());
                return this.zzaSD;
            }
            catch (ClassNotFoundException ex) {
                throw new zzq("Could not load creator class.", ex);
            }
            catch (InstantiationException ex2) {
                throw new zzq("Could not instantiate creator.", ex2);
            }
            catch (IllegalAccessException ex3) {
                throw new zzq("Could not access creator.", ex3);
            }
        }
    }
    
    protected abstract T zzb(final IBinder p0);
}
