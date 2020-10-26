// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.ConnectionResult;

public interface zzbdp
{
    ConnectionResult blockingConnect();
    
    ConnectionResult blockingConnect(final long p0, final TimeUnit p1);
    
    void connect();
    
    void disconnect();
    
    void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    @Nullable
    ConnectionResult getConnectionResult(@NonNull final Api<?> p0);
    
    boolean isConnected();
    
    boolean isConnecting();
    
    boolean zza(final zzbei p0);
    
     <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(@NonNull final T p0);
    
     <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T p0);
    
    void zzpE();
    
    void zzpl();
}
