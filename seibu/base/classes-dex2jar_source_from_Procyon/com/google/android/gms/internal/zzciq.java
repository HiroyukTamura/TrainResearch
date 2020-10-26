// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.content.Context;
import com.google.android.gms.common.stats.zza;
import android.content.Intent;
import android.os.IBinder;
import android.content.ComponentName;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import android.support.annotation.MainThread;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzf;
import android.content.ServiceConnection;

public final class zzciq implements ServiceConnection, zzf, zzg
{
    final /* synthetic */ zzcid zzbua;
    private volatile boolean zzbuh;
    private volatile zzcfk zzbui;
    
    protected zzciq(final zzcid zzbua) {
        this.zzbua = zzbua;
    }
    
    @MainThread
    public final void onConnected(@Nullable final Bundle bundle) {
        zzbo.zzcz("MeasurementServiceConnection.onConnected");
        // monitorenter(this)
        while (true) {
            try {
                try {
                    final zzcfd zzcfd = this.zzbui.zzrf();
                    this.zzbui = null;
                    this.zzbua.zzwE().zzj(new zzcit(this, zzcfd));
                    return;
                    this.zzbui = null;
                    this.zzbuh = false;
                }
                finally {
                }
                // monitorexit(this)
            }
            catch (DeadObjectException ex) {
                continue;
            }
            catch (IllegalStateException ex2) {
                continue;
            }
            break;
        }
    }
    
    @MainThread
    public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
        zzbo.zzcz("MeasurementServiceConnection.onConnectionFailed");
        final zzcfl zzyQ = this.zzbua.zzboe.zzyQ();
        if (zzyQ != null) {
            zzyQ.zzyz().zzj("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzbuh = false;
            this.zzbui = null;
            // monitorexit(this)
            this.zzbua.zzwE().zzj(new zzciv(this));
        }
    }
    
    @MainThread
    public final void onConnectionSuspended(final int n) {
        zzbo.zzcz("MeasurementServiceConnection.onConnectionSuspended");
        this.zzbua.zzwF().zzyC().log("Service connection suspended");
        this.zzbua.zzwE().zzj(new zzciu(this));
    }
    
    @MainThread
    public final void onServiceConnected(final ComponentName p0, final IBinder p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    com/google/android/gms/common/internal/zzbo.zzcz:(Ljava/lang/String;)V
        //     5: aload_0        
        //     6: monitorenter   
        //     7: aload_2        
        //     8: ifnonnull       34
        //    11: aload_0        
        //    12: iconst_0       
        //    13: putfield        com/google/android/gms/internal/zzciq.zzbuh:Z
        //    16: aload_0        
        //    17: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //    20: invokevirtual   com/google/android/gms/internal/zzcid.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //    23: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //    26: ldc             "Service connected with null binder"
        //    28: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //    31: aload_0        
        //    32: monitorexit    
        //    33: return         
        //    34: aload_2        
        //    35: invokeinterface android/os/IBinder.getInterfaceDescriptor:()Ljava/lang/String;
        //    40: astore_1       
        //    41: ldc             "com.google.android.gms.measurement.internal.IMeasurementService"
        //    43: aload_1        
        //    44: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    47: istore_3       
        //    48: iload_3        
        //    49: ifeq            168
        //    52: aload_2        
        //    53: ifnonnull       111
        //    56: aconst_null    
        //    57: astore_1       
        //    58: aload_0        
        //    59: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //    62: invokevirtual   com/google/android/gms/internal/zzcid.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //    65: invokevirtual   com/google/android/gms/internal/zzcfl.zzyD:()Lcom/google/android/gms/internal/zzcfn;
        //    68: ldc             "Bound to IMeasurementService interface"
        //    70: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //    73: aload_1        
        //    74: ifnonnull       189
        //    77: aload_0        
        //    78: iconst_0       
        //    79: putfield        com/google/android/gms/internal/zzciq.zzbuh:Z
        //    82: invokestatic    com/google/android/gms/common/stats/zza.zzrU:()Lcom/google/android/gms/common/stats/zza;
        //    85: pop            
        //    86: aload_0        
        //    87: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //    90: invokevirtual   com/google/android/gms/internal/zzcid.getContext:()Landroid/content/Context;
        //    93: aload_0        
        //    94: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //    97: invokestatic    com/google/android/gms/internal/zzcid.zza:(Lcom/google/android/gms/internal/zzcid;)Lcom/google/android/gms/internal/zzciq;
        //   100: invokevirtual   android/content/Context.unbindService:(Landroid/content/ServiceConnection;)V
        //   103: aload_0        
        //   104: monitorexit    
        //   105: return         
        //   106: astore_1       
        //   107: aload_0        
        //   108: monitorexit    
        //   109: aload_1        
        //   110: athrow         
        //   111: aload_2        
        //   112: ldc             "com.google.android.gms.measurement.internal.IMeasurementService"
        //   114: invokeinterface android/os/IBinder.queryLocalInterface:(Ljava/lang/String;)Landroid/os/IInterface;
        //   119: astore_1       
        //   120: aload_1        
        //   121: instanceof      Lcom/google/android/gms/internal/zzcfd;
        //   124: ifeq            135
        //   127: aload_1        
        //   128: checkcast       Lcom/google/android/gms/internal/zzcfd;
        //   131: astore_1       
        //   132: goto            58
        //   135: new             Lcom/google/android/gms/internal/zzcff;
        //   138: dup            
        //   139: aload_2        
        //   140: invokespecial   com/google/android/gms/internal/zzcff.<init>:(Landroid/os/IBinder;)V
        //   143: astore_1       
        //   144: goto            58
        //   147: astore_1       
        //   148: aconst_null    
        //   149: astore_1       
        //   150: aload_0        
        //   151: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //   154: invokevirtual   com/google/android/gms/internal/zzcid.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   157: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   160: ldc             "Service connect failed to get IMeasurementService"
        //   162: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   165: goto            73
        //   168: aload_0        
        //   169: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //   172: invokevirtual   com/google/android/gms/internal/zzcid.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   175: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   178: ldc             "Got binder with a wrong descriptor"
        //   180: aload_1        
        //   181: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   184: aconst_null    
        //   185: astore_1       
        //   186: goto            73
        //   189: aload_0        
        //   190: getfield        com/google/android/gms/internal/zzciq.zzbua:Lcom/google/android/gms/internal/zzcid;
        //   193: invokevirtual   com/google/android/gms/internal/zzcid.zzwE:()Lcom/google/android/gms/internal/zzcgg;
        //   196: new             Lcom/google/android/gms/internal/zzcir;
        //   199: dup            
        //   200: aload_0        
        //   201: aload_1        
        //   202: invokespecial   com/google/android/gms/internal/zzcir.<init>:(Lcom/google/android/gms/internal/zzciq;Lcom/google/android/gms/internal/zzcfd;)V
        //   205: invokevirtual   com/google/android/gms/internal/zzcgg.zzj:(Ljava/lang/Runnable;)V
        //   208: goto            103
        //   211: astore_1       
        //   212: goto            103
        //   215: astore_2       
        //   216: goto            150
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  11     33     106    111    Any
        //  34     48     147    150    Landroid/os/RemoteException;
        //  34     48     106    111    Any
        //  58     73     215    219    Landroid/os/RemoteException;
        //  58     73     106    111    Any
        //  77     82     106    111    Any
        //  82     103    211    215    Ljava/lang/IllegalArgumentException;
        //  82     103    106    111    Any
        //  103    105    106    111    Any
        //  107    109    106    111    Any
        //  111    132    147    150    Landroid/os/RemoteException;
        //  111    132    106    111    Any
        //  135    144    147    150    Landroid/os/RemoteException;
        //  135    144    106    111    Any
        //  150    165    106    111    Any
        //  168    184    147    150    Landroid/os/RemoteException;
        //  168    184    106    111    Any
        //  189    208    106    111    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 110 out of bounds for length 110
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @MainThread
    public final void onServiceDisconnected(final ComponentName componentName) {
        zzbo.zzcz("MeasurementServiceConnection.onServiceDisconnected");
        this.zzbua.zzwF().zzyC().log("Service disconnected");
        this.zzbua.zzwE().zzj(new zzcis(this, componentName));
    }
    
    @WorkerThread
    public final void zzk(final Intent intent) {
        this.zzbua.zzjC();
        final Context context = this.zzbua.getContext();
        final zza zzrU = zza.zzrU();
        synchronized (this) {
            if (this.zzbuh) {
                this.zzbua.zzwF().zzyD().log("Connection attempt already in progress");
                return;
            }
            this.zzbuh = true;
            zzrU.zza(context, intent, (ServiceConnection)this.zzbua.zzbtT, 129);
        }
    }
    
    @WorkerThread
    public final void zzzm() {
        this.zzbua.zzjC();
        this.zzbua.getContext();
        synchronized (this) {
            if (this.zzbuh) {
                this.zzbua.zzwF().zzyD().log("Connection attempt already in progress");
                return;
            }
            if (this.zzbui != null) {
                this.zzbua.zzwF().zzyD().log("Already awaiting connection attempt");
                return;
            }
        }
        final Context context;
        this.zzbui = new zzcfk(context, Looper.getMainLooper(), this, this);
        this.zzbua.zzwF().zzyD().log("Connecting to remote service");
        this.zzbuh = true;
        this.zzbui.zzrb();
    }
    // monitorexit(this)
}
