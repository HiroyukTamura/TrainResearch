// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;

public abstract class zzi<TListener>
{
    private TListener mListener;
    private /* synthetic */ zzd zzaHe;
    private boolean zzaHf;
    
    public zzi(final zzd zzaHe, final TListener mListener) {
        this.zzaHe = zzaHe;
        this.mListener = mListener;
        this.zzaHf = false;
    }
    
    public final void removeListener() {
        synchronized (this) {
            this.mListener = null;
        }
    }
    
    public final void unregister() {
        this.removeListener();
        synchronized (this.zzaHe.zzaGS) {
            this.zzaHe.zzaGS.remove(this);
        }
    }
    
    public final void zzrk() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/android/gms/common/internal/zzi.mListener:Ljava/lang/Object;
        //     6: astore_1       
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/common/internal/zzi.zzaHf:Z
        //    11: ifeq            59
        //    14: aload_0        
        //    15: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    18: astore_2       
        //    19: ldc             "GmsClient"
        //    21: new             Ljava/lang/StringBuilder;
        //    24: dup            
        //    25: aload_2        
        //    26: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    29: invokevirtual   java/lang/String.length:()I
        //    32: bipush          47
        //    34: iadd           
        //    35: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    38: ldc             "Callback proxy "
        //    40: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    43: aload_2        
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    47: ldc             " being reused. This is not safe."
        //    49: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    52: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    55: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    58: pop            
        //    59: aload_0        
        //    60: monitorexit    
        //    61: aload_1        
        //    62: ifnull          70
        //    65: aload_0        
        //    66: aload_1        
        //    67: invokevirtual   com/google/android/gms/common/internal/zzi.zzs:(Ljava/lang/Object;)V
        //    70: aload_0        
        //    71: monitorenter   
        //    72: aload_0        
        //    73: iconst_1       
        //    74: putfield        com/google/android/gms/common/internal/zzi.zzaHf:Z
        //    77: aload_0        
        //    78: monitorexit    
        //    79: aload_0        
        //    80: invokevirtual   com/google/android/gms/common/internal/zzi.unregister:()V
        //    83: return         
        //    84: astore_1       
        //    85: aload_0        
        //    86: monitorexit    
        //    87: aload_1        
        //    88: athrow         
        //    89: astore_1       
        //    90: aload_1        
        //    91: athrow         
        //    92: astore_1       
        //    93: aload_0        
        //    94: monitorexit    
        //    95: aload_1        
        //    96: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  2      59     84     89     Any
        //  59     61     84     89     Any
        //  65     70     89     92     Ljava/lang/RuntimeException;
        //  72     79     92     97     Any
        //  85     87     84     89     Any
        //  93     95     92     97     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 59 out of bounds for length 59
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
    
    protected abstract void zzs(final TListener p0);
}
