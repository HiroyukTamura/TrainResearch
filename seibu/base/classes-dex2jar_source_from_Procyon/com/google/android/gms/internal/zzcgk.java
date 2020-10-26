// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.FutureTask;
import java.util.concurrent.BlockingQueue;

final class zzcgk extends Thread
{
    private /* synthetic */ zzcgg zzbsh;
    private final Object zzbsk;
    private final BlockingQueue<FutureTask<?>> zzbsl;
    
    public zzcgk(final zzcgg zzbsh, final String name, final BlockingQueue<FutureTask<?>> zzbsl) {
        this.zzbsh = zzbsh;
        zzbo.zzu(name);
        zzbo.zzu(zzbsl);
        this.zzbsk = new Object();
        this.zzbsl = zzbsl;
        this.setName(name);
    }
    
    private final void zza(final InterruptedException ex) {
        this.zzbsh.zzwF().zzyz().zzj(String.valueOf(this.getName()).concat(" was interrupted"), ex);
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: iload_1        
        //     3: ifne            30
        //     6: aload_0        
        //     7: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //    10: invokestatic    com/google/android/gms/internal/zzcgg.zza:(Lcom/google/android/gms/internal/zzcgg;)Ljava/util/concurrent/Semaphore;
        //    13: invokevirtual   java/util/concurrent/Semaphore.acquire:()V
        //    16: iconst_1       
        //    17: istore_1       
        //    18: goto            2
        //    21: astore_3       
        //    22: aload_0        
        //    23: aload_3        
        //    24: invokespecial   com/google/android/gms/internal/zzcgk.zza:(Ljava/lang/InterruptedException;)V
        //    27: goto            2
        //    30: aload_0        
        //    31: getfield        com/google/android/gms/internal/zzcgk.zzbsl:Ljava/util/concurrent/BlockingQueue;
        //    34: invokeinterface java/util/concurrent/BlockingQueue.poll:()Ljava/lang/Object;
        //    39: checkcast       Ljava/util/concurrent/FutureTask;
        //    42: astore_3       
        //    43: aload_3        
        //    44: ifnull          111
        //    47: aload_3        
        //    48: invokevirtual   java/util/concurrent/FutureTask.run:()V
        //    51: goto            30
        //    54: astore          4
        //    56: aload_0        
        //    57: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //    60: invokestatic    com/google/android/gms/internal/zzcgg.zzc:(Lcom/google/android/gms/internal/zzcgg;)Ljava/lang/Object;
        //    63: astore_3       
        //    64: aload_3        
        //    65: monitorenter   
        //    66: aload_0        
        //    67: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //    70: invokestatic    com/google/android/gms/internal/zzcgg.zza:(Lcom/google/android/gms/internal/zzcgg;)Ljava/util/concurrent/Semaphore;
        //    73: invokevirtual   java/util/concurrent/Semaphore.release:()V
        //    76: aload_0        
        //    77: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //    80: invokestatic    com/google/android/gms/internal/zzcgg.zzc:(Lcom/google/android/gms/internal/zzcgg;)Ljava/lang/Object;
        //    83: invokevirtual   java/lang/Object.notifyAll:()V
        //    86: aload_0        
        //    87: aload_0        
        //    88: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //    91: invokestatic    com/google/android/gms/internal/zzcgg.zzd:(Lcom/google/android/gms/internal/zzcgg;)Lcom/google/android/gms/internal/zzcgk;
        //    94: if_acmpne       309
        //    97: aload_0        
        //    98: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   101: aconst_null    
        //   102: invokestatic    com/google/android/gms/internal/zzcgg.zza:(Lcom/google/android/gms/internal/zzcgg;Lcom/google/android/gms/internal/zzcgk;)Lcom/google/android/gms/internal/zzcgk;
        //   105: pop            
        //   106: aload_3        
        //   107: monitorexit    
        //   108: aload           4
        //   110: athrow         
        //   111: aload_0        
        //   112: getfield        com/google/android/gms/internal/zzcgk.zzbsk:Ljava/lang/Object;
        //   115: astore_3       
        //   116: aload_3        
        //   117: monitorenter   
        //   118: aload_0        
        //   119: getfield        com/google/android/gms/internal/zzcgk.zzbsl:Ljava/util/concurrent/BlockingQueue;
        //   122: invokeinterface java/util/concurrent/BlockingQueue.peek:()Ljava/lang/Object;
        //   127: ifnonnull       152
        //   130: aload_0        
        //   131: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   134: invokestatic    com/google/android/gms/internal/zzcgg.zzb:(Lcom/google/android/gms/internal/zzcgg;)Z
        //   137: istore_2       
        //   138: iload_2        
        //   139: ifne            152
        //   142: aload_0        
        //   143: getfield        com/google/android/gms/internal/zzcgk.zzbsk:Ljava/lang/Object;
        //   146: ldc2_w          30000
        //   149: invokevirtual   java/lang/Object.wait:(J)V
        //   152: aload_3        
        //   153: monitorexit    
        //   154: aload_0        
        //   155: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   158: invokestatic    com/google/android/gms/internal/zzcgg.zzc:(Lcom/google/android/gms/internal/zzcgg;)Ljava/lang/Object;
        //   161: astore_3       
        //   162: aload_3        
        //   163: monitorenter   
        //   164: aload_0        
        //   165: getfield        com/google/android/gms/internal/zzcgk.zzbsl:Ljava/util/concurrent/BlockingQueue;
        //   168: invokeinterface java/util/concurrent/BlockingQueue.peek:()Ljava/lang/Object;
        //   173: ifnonnull       297
        //   176: aload_3        
        //   177: monitorexit    
        //   178: aload_0        
        //   179: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   182: invokestatic    com/google/android/gms/internal/zzcgg.zzc:(Lcom/google/android/gms/internal/zzcgg;)Ljava/lang/Object;
        //   185: astore_3       
        //   186: aload_3        
        //   187: monitorenter   
        //   188: aload_0        
        //   189: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   192: invokestatic    com/google/android/gms/internal/zzcgg.zza:(Lcom/google/android/gms/internal/zzcgg;)Ljava/util/concurrent/Semaphore;
        //   195: invokevirtual   java/util/concurrent/Semaphore.release:()V
        //   198: aload_0        
        //   199: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   202: invokestatic    com/google/android/gms/internal/zzcgg.zzc:(Lcom/google/android/gms/internal/zzcgg;)Ljava/lang/Object;
        //   205: invokevirtual   java/lang/Object.notifyAll:()V
        //   208: aload_0        
        //   209: aload_0        
        //   210: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   213: invokestatic    com/google/android/gms/internal/zzcgg.zzd:(Lcom/google/android/gms/internal/zzcgg;)Lcom/google/android/gms/internal/zzcgk;
        //   216: if_acmpne       249
        //   219: aload_0        
        //   220: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   223: aconst_null    
        //   224: invokestatic    com/google/android/gms/internal/zzcgg.zza:(Lcom/google/android/gms/internal/zzcgg;Lcom/google/android/gms/internal/zzcgk;)Lcom/google/android/gms/internal/zzcgk;
        //   227: pop            
        //   228: aload_3        
        //   229: monitorexit    
        //   230: return         
        //   231: astore          4
        //   233: aload_0        
        //   234: aload           4
        //   236: invokespecial   com/google/android/gms/internal/zzcgk.zza:(Ljava/lang/InterruptedException;)V
        //   239: goto            152
        //   242: astore          4
        //   244: aload_3        
        //   245: monitorexit    
        //   246: aload           4
        //   248: athrow         
        //   249: aload_0        
        //   250: aload_0        
        //   251: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   254: invokestatic    com/google/android/gms/internal/zzcgg.zze:(Lcom/google/android/gms/internal/zzcgg;)Lcom/google/android/gms/internal/zzcgk;
        //   257: if_acmpne       279
        //   260: aload_0        
        //   261: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   264: aconst_null    
        //   265: invokestatic    com/google/android/gms/internal/zzcgg.zzb:(Lcom/google/android/gms/internal/zzcgg;Lcom/google/android/gms/internal/zzcgk;)Lcom/google/android/gms/internal/zzcgk;
        //   268: pop            
        //   269: goto            228
        //   272: astore          4
        //   274: aload_3        
        //   275: monitorexit    
        //   276: aload           4
        //   278: athrow         
        //   279: aload_0        
        //   280: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   283: invokevirtual   com/google/android/gms/internal/zzcgg.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   286: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   289: ldc             "Current scheduler thread is neither worker nor network"
        //   291: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   294: goto            228
        //   297: aload_3        
        //   298: monitorexit    
        //   299: goto            30
        //   302: astore          4
        //   304: aload_3        
        //   305: monitorexit    
        //   306: aload           4
        //   308: athrow         
        //   309: aload_0        
        //   310: aload_0        
        //   311: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   314: invokestatic    com/google/android/gms/internal/zzcgg.zze:(Lcom/google/android/gms/internal/zzcgg;)Lcom/google/android/gms/internal/zzcgk;
        //   317: if_acmpne       339
        //   320: aload_0        
        //   321: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   324: aconst_null    
        //   325: invokestatic    com/google/android/gms/internal/zzcgg.zzb:(Lcom/google/android/gms/internal/zzcgg;Lcom/google/android/gms/internal/zzcgk;)Lcom/google/android/gms/internal/zzcgk;
        //   328: pop            
        //   329: goto            106
        //   332: astore          4
        //   334: aload_3        
        //   335: monitorexit    
        //   336: aload           4
        //   338: athrow         
        //   339: aload_0        
        //   340: getfield        com/google/android/gms/internal/zzcgk.zzbsh:Lcom/google/android/gms/internal/zzcgg;
        //   343: invokevirtual   com/google/android/gms/internal/zzcgg.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   346: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   349: ldc             "Current scheduler thread is neither worker nor network"
        //   351: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   354: goto            106
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  6      16     21     30     Ljava/lang/InterruptedException;
        //  30     43     54     357    Any
        //  47     51     54     357    Any
        //  66     106    332    339    Any
        //  106    108    332    339    Any
        //  111    118    54     357    Any
        //  118    138    242    249    Any
        //  142    152    231    242    Ljava/lang/InterruptedException;
        //  142    152    242    249    Any
        //  152    154    242    249    Any
        //  154    164    54     357    Any
        //  164    178    302    309    Any
        //  188    228    272    279    Any
        //  228    230    272    279    Any
        //  233    239    242    249    Any
        //  244    246    242    249    Any
        //  246    249    54     357    Any
        //  249    269    272    279    Any
        //  274    276    272    279    Any
        //  279    294    272    279    Any
        //  297    299    302    309    Any
        //  304    306    302    309    Any
        //  306    309    54     357    Any
        //  309    329    332    339    Any
        //  334    336    332    339    Any
        //  339    354    332    339    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0228:
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
    
    public final void zzfF() {
        synchronized (this.zzbsk) {
            this.zzbsk.notifyAll();
        }
    }
}
