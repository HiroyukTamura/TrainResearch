// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import android.os.IBinder;
import android.os.IInterface;
import android.content.Intent;
import com.google.android.gms.common.internal.zzj;
import java.util.Set;
import com.google.android.gms.common.internal.zzal;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.Collections;
import java.util.List;
import com.google.android.gms.common.internal.zzq;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;

public final class Api<O extends ApiOptions>
{
    private final String mName;
    private final zzi<?> zzaAA;
    private final zza<?, O> zzaAx;
    private final zzh<?, O> zzaAy;
    private final zzf<?> zzaAz;
    
    public <C extends zze> Api(final String mName, final zza<C, O> zzaAx, final zzf<C> zzaAz) {
        zzbo.zzb(zzaAx, "Cannot construct an Api with a null ClientBuilder");
        zzbo.zzb(zzaAz, "Cannot construct an Api with a null ClientKey");
        this.mName = mName;
        this.zzaAx = zzaAx;
        this.zzaAy = null;
        this.zzaAz = zzaAz;
        this.zzaAA = null;
    }
    
    public final String getName() {
        return this.mName;
    }
    
    public final zzd<?, O> zzpb() {
        return (zzd<?, O>)this.zzaAx;
    }
    
    public final zza<?, O> zzpc() {
        zzbo.zza(this.zzaAx != null, (Object)"This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzaAx;
    }
    
    public final zzc<?> zzpd() {
        if (this.zzaAz != null) {
            return (zzc<?>)this.zzaAz;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
    
    public interface ApiOptions
    {
        public interface HasOptions extends ApiOptions
        {
        }
        
        public static final class NoOptions implements NotRequiredOptions
        {
            private NoOptions() {
            }
        }
        
        public interface NotRequiredOptions extends ApiOptions
        {
        }
        
        public interface Optional extends HasOptions, NotRequiredOptions
        {
        }
    }
    
    public abstract static class zza<T extends zze, O> extends zzd<T, O>
    {
        public abstract T zza(final Context p0, final Looper p1, final zzq p2, final O p3, final GoogleApiClient.ConnectionCallbacks p4, final GoogleApiClient.OnConnectionFailedListener p5);
    }
    
    public interface zzb
    {
    }
    
    public static class zzc<C extends zzb>
    {
    }
    
    public static class zzd<T extends zzb, O>
    {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
        
        public List<Scope> zzn(final O o) {
            return Collections.emptyList();
        }
    }
    
    public interface zze extends zzb
    {
        void disconnect();
        
        void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
        
        boolean isConnected();
        
        boolean isConnecting();
        
        void zza(final zzal p0, final Set<Scope> p1);
        
        void zza(final zzj p0);
        
        boolean zzmG();
        
        Intent zzmH();
        
        boolean zzmv();
        
        boolean zzpe();
    }
    
    public static final class zzf<C extends zze> extends zzc<C>
    {
    }
    
    public interface zzg<T extends IInterface> extends zzb
    {
        T zzd(final IBinder p0);
        
        String zzdb();
        
        String zzdc();
    }
    
    public static class zzh<T extends zzg, O> extends zzd<T, O>
    {
    }
    
    public static final class zzi<C extends zzg> extends zzc<C>
    {
    }
}
