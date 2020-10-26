// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

public final class zzamp implements ServiceConnection
{
    final /* synthetic */ zzamn zzagk;
    private volatile zzany zzagl;
    private volatile boolean zzagm;
    
    protected zzamp(final zzamn zzagk) {
        this.zzagk = zzagk;
    }
    
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
        //     8: ifnonnull       27
        //    11: aload_0        
        //    12: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    15: ldc             "Service connected with null binder"
        //    17: invokevirtual   com/google/android/gms/internal/zzamn.zzbs:(Ljava/lang/String;)V
        //    20: aload_0        
        //    21: invokevirtual   java/lang/Object.notifyAll:()V
        //    24: aload_0        
        //    25: monitorexit    
        //    26: return         
        //    27: aload_2        
        //    28: invokeinterface android/os/IBinder.getInterfaceDescriptor:()Ljava/lang/String;
        //    33: astore_1       
        //    34: ldc             "com.google.android.gms.analytics.internal.IAnalyticsService"
        //    36: aload_1        
        //    37: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    40: istore_3       
        //    41: iload_3        
        //    42: ifeq            155
        //    45: aload_2        
        //    46: ifnonnull       97
        //    49: aconst_null    
        //    50: astore_1       
        //    51: aload_0        
        //    52: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    55: ldc             "Bound to IAnalyticsService interface"
        //    57: invokevirtual   com/google/android/gms/internal/zzamn.zzbo:(Ljava/lang/String;)V
        //    60: aload_1        
        //    61: ifnonnull       170
        //    64: invokestatic    com/google/android/gms/common/stats/zza.zzrU:()Lcom/google/android/gms/common/stats/zza;
        //    67: pop            
        //    68: aload_0        
        //    69: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    72: invokevirtual   com/google/android/gms/internal/zzamn.getContext:()Landroid/content/Context;
        //    75: aload_0        
        //    76: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    79: invokestatic    com/google/android/gms/internal/zzamn.zza:(Lcom/google/android/gms/internal/zzamn;)Lcom/google/android/gms/internal/zzamp;
        //    82: invokevirtual   android/content/Context.unbindService:(Landroid/content/ServiceConnection;)V
        //    85: aload_0        
        //    86: invokevirtual   java/lang/Object.notifyAll:()V
        //    89: aload_0        
        //    90: monitorexit    
        //    91: return         
        //    92: astore_1       
        //    93: aload_0        
        //    94: monitorexit    
        //    95: aload_1        
        //    96: athrow         
        //    97: aload_2        
        //    98: ldc             "com.google.android.gms.analytics.internal.IAnalyticsService"
        //   100: invokeinterface android/os/IBinder.queryLocalInterface:(Ljava/lang/String;)Landroid/os/IInterface;
        //   105: astore_1       
        //   106: aload_1        
        //   107: instanceof      Lcom/google/android/gms/internal/zzany;
        //   110: ifeq            121
        //   113: aload_1        
        //   114: checkcast       Lcom/google/android/gms/internal/zzany;
        //   117: astore_1       
        //   118: goto            51
        //   121: new             Lcom/google/android/gms/internal/zzanz;
        //   124: dup            
        //   125: aload_2        
        //   126: invokespecial   com/google/android/gms/internal/zzanz.<init>:(Landroid/os/IBinder;)V
        //   129: astore_1       
        //   130: goto            51
        //   133: astore_1       
        //   134: aconst_null    
        //   135: astore_1       
        //   136: aload_0        
        //   137: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //   140: ldc             "Service connect failed to get IAnalyticsService"
        //   142: invokevirtual   com/google/android/gms/internal/zzamn.zzbs:(Ljava/lang/String;)V
        //   145: goto            60
        //   148: astore_1       
        //   149: aload_0        
        //   150: invokevirtual   java/lang/Object.notifyAll:()V
        //   153: aload_1        
        //   154: athrow         
        //   155: aload_0        
        //   156: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //   159: ldc             "Got binder with a wrong descriptor"
        //   161: aload_1        
        //   162: invokevirtual   com/google/android/gms/internal/zzamn.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   165: aconst_null    
        //   166: astore_1       
        //   167: goto            60
        //   170: aload_0        
        //   171: getfield        com/google/android/gms/internal/zzamp.zzagm:Z
        //   174: ifne            208
        //   177: aload_0        
        //   178: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //   181: ldc             "onServiceConnected received after the timeout limit"
        //   183: invokevirtual   com/google/android/gms/internal/zzamn.zzbr:(Ljava/lang/String;)V
        //   186: aload_0        
        //   187: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //   190: invokevirtual   com/google/android/gms/internal/zzamn.zzkt:()Lcom/google/android/gms/analytics/zzl;
        //   193: new             Lcom/google/android/gms/internal/zzamq;
        //   196: dup            
        //   197: aload_0        
        //   198: aload_1        
        //   199: invokespecial   com/google/android/gms/internal/zzamq.<init>:(Lcom/google/android/gms/internal/zzamp;Lcom/google/android/gms/internal/zzany;)V
        //   202: invokevirtual   com/google/android/gms/analytics/zzl.zzf:(Ljava/lang/Runnable;)V
        //   205: goto            85
        //   208: aload_0        
        //   209: aload_1        
        //   210: putfield        com/google/android/gms/internal/zzamp.zzagl:Lcom/google/android/gms/internal/zzany;
        //   213: goto            85
        //   216: astore_1       
        //   217: goto            85
        //   220: astore_2       
        //   221: goto            136
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  11     20     148    155    Any
        //  20     26     92     97     Any
        //  27     41     133    136    Landroid/os/RemoteException;
        //  27     41     148    155    Any
        //  51     60     220    224    Landroid/os/RemoteException;
        //  51     60     148    155    Any
        //  64     85     216    220    Ljava/lang/IllegalArgumentException;
        //  64     85     148    155    Any
        //  85     91     92     97     Any
        //  93     95     92     97     Any
        //  97     118    133    136    Landroid/os/RemoteException;
        //  97     118    148    155    Any
        //  121    130    133    136    Landroid/os/RemoteException;
        //  121    130    148    155    Any
        //  136    145    148    155    Any
        //  149    155    92     97     Any
        //  155    165    133    136    Landroid/os/RemoteException;
        //  155    165    148    155    Any
        //  170    205    148    155    Any
        //  208    213    148    155    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0027:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        zzbo.zzcz("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzagk.zzkt().zzf(new zzamr(this, componentName));
    }
    
    public final zzany zzkR() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: new             Landroid/content/Intent;
        //     6: dup            
        //     7: ldc             "com.google.android.gms.analytics.service.START"
        //     9: invokespecial   android/content/Intent.<init>:(Ljava/lang/String;)V
        //    12: astore_2       
        //    13: aload_2        
        //    14: new             Landroid/content/ComponentName;
        //    17: dup            
        //    18: ldc             "com.google.android.gms"
        //    20: ldc             "com.google.android.gms.analytics.service.AnalyticsService"
        //    22: invokespecial   android/content/ComponentName.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    25: invokevirtual   android/content/Intent.setComponent:(Landroid/content/ComponentName;)Landroid/content/Intent;
        //    28: pop            
        //    29: aload_0        
        //    30: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    33: invokevirtual   com/google/android/gms/internal/zzamn.getContext:()Landroid/content/Context;
        //    36: astore_3       
        //    37: aload_2        
        //    38: ldc             "app_package_name"
        //    40: aload_3        
        //    41: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    44: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //    47: pop            
        //    48: invokestatic    com/google/android/gms/common/stats/zza.zzrU:()Lcom/google/android/gms/common/stats/zza;
        //    51: astore          4
        //    53: aload_0        
        //    54: monitorenter   
        //    55: aload_0        
        //    56: aconst_null    
        //    57: putfield        com/google/android/gms/internal/zzamp.zzagl:Lcom/google/android/gms/internal/zzany;
        //    60: aload_0        
        //    61: iconst_1       
        //    62: putfield        com/google/android/gms/internal/zzamp.zzagm:Z
        //    65: aload           4
        //    67: aload_3        
        //    68: aload_2        
        //    69: aload_0        
        //    70: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    73: invokestatic    com/google/android/gms/internal/zzamn.zza:(Lcom/google/android/gms/internal/zzamn;)Lcom/google/android/gms/internal/zzamp;
        //    76: sipush          129
        //    79: invokevirtual   com/google/android/gms/common/stats/zza.zza:(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //    82: istore_1       
        //    83: aload_0        
        //    84: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //    87: ldc             "Bind to service requested"
        //    89: iload_1        
        //    90: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    93: invokevirtual   com/google/android/gms/internal/zzamn.zza:(Ljava/lang/String;Ljava/lang/Object;)V
        //    96: iload_1        
        //    97: ifne            109
        //   100: aload_0        
        //   101: iconst_0       
        //   102: putfield        com/google/android/gms/internal/zzamp.zzagm:Z
        //   105: aload_0        
        //   106: monitorexit    
        //   107: aconst_null    
        //   108: areturn        
        //   109: aload_0        
        //   110: getstatic       com/google/android/gms/internal/zzans.zzahP:Lcom/google/android/gms/internal/zzant;
        //   113: invokevirtual   com/google/android/gms/internal/zzant.get:()Ljava/lang/Object;
        //   116: checkcast       Ljava/lang/Long;
        //   119: invokevirtual   java/lang/Long.longValue:()J
        //   122: invokevirtual   java/lang/Object.wait:(J)V
        //   125: aload_0        
        //   126: iconst_0       
        //   127: putfield        com/google/android/gms/internal/zzamp.zzagm:Z
        //   130: aload_0        
        //   131: getfield        com/google/android/gms/internal/zzamp.zzagl:Lcom/google/android/gms/internal/zzany;
        //   134: astore_2       
        //   135: aload_0        
        //   136: aconst_null    
        //   137: putfield        com/google/android/gms/internal/zzamp.zzagl:Lcom/google/android/gms/internal/zzany;
        //   140: aload_2        
        //   141: ifnonnull       153
        //   144: aload_0        
        //   145: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //   148: ldc             "Successfully bound to service but never got onServiceConnected callback"
        //   150: invokevirtual   com/google/android/gms/internal/zzamn.zzbs:(Ljava/lang/String;)V
        //   153: aload_0        
        //   154: monitorexit    
        //   155: aload_2        
        //   156: areturn        
        //   157: astore_2       
        //   158: aload_0        
        //   159: monitorexit    
        //   160: aload_2        
        //   161: athrow         
        //   162: astore_2       
        //   163: aload_0        
        //   164: getfield        com/google/android/gms/internal/zzamp.zzagk:Lcom/google/android/gms/internal/zzamn;
        //   167: ldc             "Wait for service connect was interrupted"
        //   169: invokevirtual   com/google/android/gms/internal/zzamn.zzbr:(Ljava/lang/String;)V
        //   172: goto            125
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  55     96     157    162    Any
        //  100    107    157    162    Any
        //  109    125    162    175    Ljava/lang/InterruptedException;
        //  109    125    157    162    Any
        //  125    140    157    162    Any
        //  144    153    157    162    Any
        //  153    155    157    162    Any
        //  158    160    157    162    Any
        //  163    172    157    162    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0109:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
}
