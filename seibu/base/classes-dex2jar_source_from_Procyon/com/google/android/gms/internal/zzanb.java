// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.android.gms.common.internal.zzbo;
import java.util.UUID;
import android.content.Context;
import java.util.concurrent.Future;

public final class zzanb extends zzamh
{
    private volatile String zzafd;
    private Future<String> zzagN;
    
    protected zzanb(final zzamj zzamj) {
        super(zzamj);
    }
    
    private final String zzag(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    com/google/android/gms/common/internal/zzbo.zzcG:(Ljava/lang/String;)V
        //     5: aload_1        
        //     6: ldc             "gaClientId"
        //     8: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
        //    11: astore_3       
        //    12: aload_3        
        //    13: astore          4
        //    15: bipush          36
        //    17: newarray        B
        //    19: astore          5
        //    21: aload_3        
        //    22: astore          4
        //    24: aload_3        
        //    25: aload           5
        //    27: iconst_0       
        //    28: bipush          36
        //    30: invokevirtual   java/io/FileInputStream.read:([BII)I
        //    33: istore_2       
        //    34: aload_3        
        //    35: astore          4
        //    37: aload_3        
        //    38: invokevirtual   java/io/FileInputStream.available:()I
        //    41: ifle            90
        //    44: aload_3        
        //    45: astore          4
        //    47: aload_0        
        //    48: ldc             "clientId file seems corrupted, deleting it."
        //    50: invokevirtual   com/google/android/gms/internal/zzanb.zzbr:(Ljava/lang/String;)V
        //    53: aload_3        
        //    54: astore          4
        //    56: aload_3        
        //    57: invokevirtual   java/io/FileInputStream.close:()V
        //    60: aload_3        
        //    61: astore          4
        //    63: aload_1        
        //    64: ldc             "gaClientId"
        //    66: invokevirtual   android/content/Context.deleteFile:(Ljava/lang/String;)Z
        //    69: pop            
        //    70: aload_3        
        //    71: ifnull          78
        //    74: aload_3        
        //    75: invokevirtual   java/io/FileInputStream.close:()V
        //    78: aconst_null    
        //    79: areturn        
        //    80: astore_1       
        //    81: aload_0        
        //    82: ldc             "Failed to close client id reading stream"
        //    84: aload_1        
        //    85: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //    88: aconst_null    
        //    89: areturn        
        //    90: iload_2        
        //    91: bipush          14
        //    93: if_icmpge       142
        //    96: aload_3        
        //    97: astore          4
        //    99: aload_0        
        //   100: ldc             "clientId file is empty, deleting it."
        //   102: invokevirtual   com/google/android/gms/internal/zzanb.zzbr:(Ljava/lang/String;)V
        //   105: aload_3        
        //   106: astore          4
        //   108: aload_3        
        //   109: invokevirtual   java/io/FileInputStream.close:()V
        //   112: aload_3        
        //   113: astore          4
        //   115: aload_1        
        //   116: ldc             "gaClientId"
        //   118: invokevirtual   android/content/Context.deleteFile:(Ljava/lang/String;)Z
        //   121: pop            
        //   122: aload_3        
        //   123: ifnull          78
        //   126: aload_3        
        //   127: invokevirtual   java/io/FileInputStream.close:()V
        //   130: aconst_null    
        //   131: areturn        
        //   132: astore_1       
        //   133: aload_0        
        //   134: ldc             "Failed to close client id reading stream"
        //   136: aload_1        
        //   137: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   140: aconst_null    
        //   141: areturn        
        //   142: aload_3        
        //   143: astore          4
        //   145: aload_3        
        //   146: invokevirtual   java/io/FileInputStream.close:()V
        //   149: aload_3        
        //   150: astore          4
        //   152: new             Ljava/lang/String;
        //   155: dup            
        //   156: aload           5
        //   158: iconst_0       
        //   159: iload_2        
        //   160: invokespecial   java/lang/String.<init>:([BII)V
        //   163: astore          5
        //   165: aload_3        
        //   166: astore          4
        //   168: aload_0        
        //   169: ldc             "Read client id from disk"
        //   171: aload           5
        //   173: invokevirtual   com/google/android/gms/internal/zzanb.zza:(Ljava/lang/String;Ljava/lang/Object;)V
        //   176: aload_3        
        //   177: ifnull          184
        //   180: aload_3        
        //   181: invokevirtual   java/io/FileInputStream.close:()V
        //   184: aload           5
        //   186: areturn        
        //   187: astore_1       
        //   188: aload_0        
        //   189: ldc             "Failed to close client id reading stream"
        //   191: aload_1        
        //   192: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   195: goto            184
        //   198: astore_1       
        //   199: aconst_null    
        //   200: astore_1       
        //   201: aload_1        
        //   202: ifnull          78
        //   205: aload_1        
        //   206: invokevirtual   java/io/FileInputStream.close:()V
        //   209: aconst_null    
        //   210: areturn        
        //   211: astore_1       
        //   212: aload_0        
        //   213: ldc             "Failed to close client id reading stream"
        //   215: aload_1        
        //   216: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   219: aconst_null    
        //   220: areturn        
        //   221: astore          5
        //   223: aconst_null    
        //   224: astore_3       
        //   225: aload_3        
        //   226: astore          4
        //   228: aload_0        
        //   229: ldc             "Error reading client id file, deleting it"
        //   231: aload           5
        //   233: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   236: aload_3        
        //   237: astore          4
        //   239: aload_1        
        //   240: ldc             "gaClientId"
        //   242: invokevirtual   android/content/Context.deleteFile:(Ljava/lang/String;)Z
        //   245: pop            
        //   246: aload_3        
        //   247: ifnull          78
        //   250: aload_3        
        //   251: invokevirtual   java/io/FileInputStream.close:()V
        //   254: aconst_null    
        //   255: areturn        
        //   256: astore_1       
        //   257: aload_0        
        //   258: ldc             "Failed to close client id reading stream"
        //   260: aload_1        
        //   261: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   264: aconst_null    
        //   265: areturn        
        //   266: astore_1       
        //   267: aconst_null    
        //   268: astore          4
        //   270: aload           4
        //   272: ifnull          280
        //   275: aload           4
        //   277: invokevirtual   java/io/FileInputStream.close:()V
        //   280: aload_1        
        //   281: athrow         
        //   282: astore_3       
        //   283: aload_0        
        //   284: ldc             "Failed to close client id reading stream"
        //   286: aload_3        
        //   287: invokevirtual   com/google/android/gms/internal/zzanb.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   290: goto            280
        //   293: astore_1       
        //   294: goto            270
        //   297: astore          5
        //   299: goto            225
        //   302: astore_1       
        //   303: aload_3        
        //   304: astore_1       
        //   305: goto            201
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  5      12     198    201    Ljava/io/FileNotFoundException;
        //  5      12     221    225    Ljava/io/IOException;
        //  5      12     266    270    Any
        //  15     21     302    308    Ljava/io/FileNotFoundException;
        //  15     21     297    302    Ljava/io/IOException;
        //  15     21     293    297    Any
        //  24     34     302    308    Ljava/io/FileNotFoundException;
        //  24     34     297    302    Ljava/io/IOException;
        //  24     34     293    297    Any
        //  37     44     302    308    Ljava/io/FileNotFoundException;
        //  37     44     297    302    Ljava/io/IOException;
        //  37     44     293    297    Any
        //  47     53     302    308    Ljava/io/FileNotFoundException;
        //  47     53     297    302    Ljava/io/IOException;
        //  47     53     293    297    Any
        //  56     60     302    308    Ljava/io/FileNotFoundException;
        //  56     60     297    302    Ljava/io/IOException;
        //  56     60     293    297    Any
        //  63     70     302    308    Ljava/io/FileNotFoundException;
        //  63     70     297    302    Ljava/io/IOException;
        //  63     70     293    297    Any
        //  74     78     80     90     Ljava/io/IOException;
        //  99     105    302    308    Ljava/io/FileNotFoundException;
        //  99     105    297    302    Ljava/io/IOException;
        //  99     105    293    297    Any
        //  108    112    302    308    Ljava/io/FileNotFoundException;
        //  108    112    297    302    Ljava/io/IOException;
        //  108    112    293    297    Any
        //  115    122    302    308    Ljava/io/FileNotFoundException;
        //  115    122    297    302    Ljava/io/IOException;
        //  115    122    293    297    Any
        //  126    130    132    142    Ljava/io/IOException;
        //  145    149    302    308    Ljava/io/FileNotFoundException;
        //  145    149    297    302    Ljava/io/IOException;
        //  145    149    293    297    Any
        //  152    165    302    308    Ljava/io/FileNotFoundException;
        //  152    165    297    302    Ljava/io/IOException;
        //  152    165    293    297    Any
        //  168    176    302    308    Ljava/io/FileNotFoundException;
        //  168    176    297    302    Ljava/io/IOException;
        //  168    176    293    297    Any
        //  180    184    187    198    Ljava/io/IOException;
        //  205    209    211    221    Ljava/io/IOException;
        //  228    236    293    297    Any
        //  239    246    293    297    Any
        //  250    254    256    266    Ljava/io/IOException;
        //  275    280    282    293    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0078:
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
    
    private final String zzll() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            if (!this.zzv(this.zzkt().getContext(), lowerCase)) {
                lowerCase = "0";
            }
            return lowerCase;
        }
        catch (Exception ex) {
            this.zze("Error saving clientId file", ex);
            return "0";
        }
    }
    
    private final boolean zzv(final Context context, final String s) {
        boolean b = false;
        zzbo.zzcF(s);
        zzbo.zzcG("ClientId should be saved from worker thread");
        final FileOutputStream fileOutputStream = null;
        final FileOutputStream fileOutputStream2 = null;
        FileOutputStream openFileOutput;
        final FileOutputStream fileOutputStream3 = openFileOutput = null;
        FileOutputStream fileOutputStream4 = fileOutputStream;
        FileOutputStream fileOutputStream5 = fileOutputStream2;
        try {
            this.zza("Storing clientId", s);
            openFileOutput = fileOutputStream3;
            fileOutputStream4 = fileOutputStream;
            fileOutputStream5 = fileOutputStream2;
            final FileOutputStream fileOutputStream6 = fileOutputStream5 = (fileOutputStream4 = (openFileOutput = context.openFileOutput("gaClientId", 0)));
            fileOutputStream6.write(s.getBytes());
            Label_0085: {
                if (fileOutputStream6 == null) {
                    break Label_0085;
                }
                try {
                    fileOutputStream6.close();
                    b = true;
                    return b;
                }
                catch (IOException ex) {
                    this.zze("Failed to close clientId writing stream", ex);
                }
            }
        }
        catch (FileNotFoundException ex2) {
            fileOutputStream5 = openFileOutput;
            this.zze("Error creating clientId file", ex2);
            if (openFileOutput == null) {
                return b;
            }
            try {
                openFileOutput.close();
                return false;
            }
            catch (IOException ex3) {
                this.zze("Failed to close clientId writing stream", ex3);
                return false;
            }
        }
        catch (IOException ex4) {
            fileOutputStream5 = fileOutputStream4;
            this.zze("Error writing to clientId file", ex4);
            if (fileOutputStream4 == null) {
                return b;
            }
            try {
                fileOutputStream4.close();
                return false;
            }
            catch (IOException ex5) {
                this.zze("Failed to close clientId writing stream", ex5);
                return false;
            }
        }
        finally {
            Label_0179: {
                if (fileOutputStream5 == null) {
                    break Label_0179;
                }
                try {
                    fileOutputStream5.close();
                }
                catch (IOException ex6) {
                    this.zze("Failed to close clientId writing stream", ex6);
                }
            }
        }
    }
    
    @Override
    protected final void zzjD() {
    }
    
    public final String zzli() {
        this.zzkD();
        // monitorenter(this)
        try {
            if (this.zzafd == null) {
                this.zzagN = this.zzkt().zzd((Callable<String>)new zzanc(this));
            }
            Label_0085: {
                if (this.zzagN == null) {
                    break Label_0085;
                }
                try {
                    this.zzafd = this.zzagN.get();
                    if (this.zzafd == null) {
                        this.zzafd = "0";
                    }
                    this.zza("Loaded clientId", this.zzafd);
                    this.zzagN = null;
                    return this.zzafd;
                }
                catch (InterruptedException ex) {
                    this.zzd("ClientId loading or generation was interrupted", ex);
                    this.zzafd = "0";
                }
                catch (ExecutionException ex2) {
                    this.zze("Failed to load or generate client id", ex2);
                    this.zzafd = "0";
                }
            }
        }
        finally {}
    }
    
    final String zzlj() {
        synchronized (this) {
            this.zzafd = null;
            this.zzagN = this.zzkt().zzd((Callable<String>)new zzand(this));
            return this.zzli();
        }
    }
    
    final String zzlk() {
        String s;
        if ((s = this.zzag(this.zzkt().getContext())) == null) {
            s = this.zzll();
        }
        return s;
    }
}
