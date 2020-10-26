// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.io.InputStream;
import java.io.IOException;
import android.content.res.Resources$NotFoundException;
import java.io.OutputStream;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ado;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.adp;
import com.google.android.gms.internal.zzbn;
import org.json.JSONException;
import java.io.UnsupportedEncodingException;
import com.google.android.gms.internal.ek;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.google.android.gms.internal.ee;
import android.content.Context;

final class zzey implements zzah
{
    private final Context mContext;
    private final String zzbDw;
    private zzdi<ee> zzbFV;
    private final ExecutorService zzbrV;
    
    zzey(final Context mContext, final String zzbDw) {
        this.mContext = mContext;
        this.zzbDw = zzbDw;
        this.zzbrV = Executors.newSingleThreadExecutor();
    }
    
    private final File zzBJ() {
        final String value = String.valueOf("resource_");
        final String value2 = String.valueOf(this.zzbDw);
        String concat;
        if (value2.length() != 0) {
            concat = value.concat(value2);
        }
        else {
            concat = new String(value);
        }
        return new File(this.mContext.getDir("google_tagmanager", 0), concat);
    }
    
    private static ek zza(final ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzdb.zzfo(byteArrayOutputStream.toString("UTF-8"));
        }
        catch (UnsupportedEncodingException ex) {
            zzdj.zzaC("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        }
        catch (JSONException ex2) {
            zzdj.zzaT("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }
    
    private static ek zzu(final byte[] array) {
        try {
            final ek zza = eg.zza(adp.zza(new zzbn(), array));
            if (zza != null) {
                zzdj.v("The container was successfully loaded from the resource (using binary file)");
            }
            return zza;
        }
        catch (ado ado) {
            zzdj.e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
        catch (eo eo) {
            zzdj.zzaT("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }
    
    @Override
    public final void release() {
        synchronized (this) {
            this.zzbrV.shutdown();
        }
    }
    
    @Override
    public final void zzAR() {
        this.zzbrV.execute(new zzez(this));
    }
    
    final void zzBI() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/tagmanager/zzey.zzbFV:Lcom/google/android/gms/tagmanager/zzdi;
        //     4: ifnonnull       17
        //     7: new             Ljava/lang/IllegalStateException;
        //    10: dup            
        //    11: ldc             "Callback must be set before execute"
        //    13: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: ldc             "Attempting to load resource from disk"
        //    19: invokestatic    com/google/android/gms/tagmanager/zzdj.v:(Ljava/lang/String;)V
        //    22: invokestatic    com/google/android/gms/tagmanager/zzei.zzBD:()Lcom/google/android/gms/tagmanager/zzei;
        //    25: invokevirtual   com/google/android/gms/tagmanager/zzei.zzBE:()Lcom/google/android/gms/tagmanager/zzei$zza;
        //    28: getstatic       com/google/android/gms/tagmanager/zzei$zza.zzbFK:Lcom/google/android/gms/tagmanager/zzei$zza;
        //    31: if_acmpeq       46
        //    34: invokestatic    com/google/android/gms/tagmanager/zzei.zzBD:()Lcom/google/android/gms/tagmanager/zzei;
        //    37: invokevirtual   com/google/android/gms/tagmanager/zzei.zzBE:()Lcom/google/android/gms/tagmanager/zzei$zza;
        //    40: getstatic       com/google/android/gms/tagmanager/zzei$zza.zzbFL:Lcom/google/android/gms/tagmanager/zzei$zza;
        //    43: if_acmpne       75
        //    46: aload_0        
        //    47: getfield        com/google/android/gms/tagmanager/zzey.zzbDw:Ljava/lang/String;
        //    50: invokestatic    com/google/android/gms/tagmanager/zzei.zzBD:()Lcom/google/android/gms/tagmanager/zzei;
        //    53: invokevirtual   com/google/android/gms/tagmanager/zzei.getContainerId:()Ljava/lang/String;
        //    56: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    59: ifeq            75
        //    62: aload_0        
        //    63: getfield        com/google/android/gms/tagmanager/zzey.zzbFV:Lcom/google/android/gms/tagmanager/zzdi;
        //    66: getstatic       com/google/android/gms/tagmanager/zzda.zzbFh:I
        //    69: invokeinterface com/google/android/gms/tagmanager/zzdi.zzbw:(I)V
        //    74: return         
        //    75: new             Ljava/io/FileInputStream;
        //    78: dup            
        //    79: aload_0        
        //    80: invokespecial   com/google/android/gms/tagmanager/zzey.zzBJ:()Ljava/io/File;
        //    83: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    86: astore_1       
        //    87: new             Ljava/io/ByteArrayOutputStream;
        //    90: dup            
        //    91: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    94: astore_2       
        //    95: aload_1        
        //    96: aload_2        
        //    97: invokestatic    com/google/android/gms/internal/eg.zzb:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   100: aload_2        
        //   101: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   104: astore_2       
        //   105: new             Lcom/google/android/gms/internal/ee;
        //   108: dup            
        //   109: invokespecial   com/google/android/gms/internal/ee.<init>:()V
        //   112: aload_2        
        //   113: invokestatic    com/google/android/gms/internal/adp.zza:(Lcom/google/android/gms/internal/adp;[B)Lcom/google/android/gms/internal/adp;
        //   116: checkcast       Lcom/google/android/gms/internal/ee;
        //   119: astore_2       
        //   120: aload_2        
        //   121: getfield        com/google/android/gms/internal/ee.zzlB:Lcom/google/android/gms/internal/zzbn;
        //   124: ifnonnull       191
        //   127: aload_2        
        //   128: getfield        com/google/android/gms/internal/ee.zzbLH:Lcom/google/android/gms/internal/zzbq;
        //   131: ifnonnull       191
        //   134: new             Ljava/lang/IllegalArgumentException;
        //   137: dup            
        //   138: ldc             "Resource and SupplementedResource are NULL."
        //   140: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   143: athrow         
        //   144: astore_2       
        //   145: aload_0        
        //   146: getfield        com/google/android/gms/tagmanager/zzey.zzbFV:Lcom/google/android/gms/tagmanager/zzdi;
        //   149: getstatic       com/google/android/gms/tagmanager/zzda.zzbFi:I
        //   152: invokeinterface com/google/android/gms/tagmanager/zzdi.zzbw:(I)V
        //   157: ldc             "Failed to read the resource from disk"
        //   159: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   162: aload_1        
        //   163: invokevirtual   java/io/FileInputStream.close:()V
        //   166: ldc             "The Disk resource was successfully read."
        //   168: invokestatic    com/google/android/gms/tagmanager/zzdj.v:(Ljava/lang/String;)V
        //   171: return         
        //   172: astore_1       
        //   173: ldc             "Failed to find the resource in the disk"
        //   175: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaC:(Ljava/lang/String;)V
        //   178: aload_0        
        //   179: getfield        com/google/android/gms/tagmanager/zzey.zzbFV:Lcom/google/android/gms/tagmanager/zzdi;
        //   182: getstatic       com/google/android/gms/tagmanager/zzda.zzbFh:I
        //   185: invokeinterface com/google/android/gms/tagmanager/zzdi.zzbw:(I)V
        //   190: return         
        //   191: aload_0        
        //   192: getfield        com/google/android/gms/tagmanager/zzey.zzbFV:Lcom/google/android/gms/tagmanager/zzdi;
        //   195: aload_2        
        //   196: invokeinterface com/google/android/gms/tagmanager/zzdi.onSuccess:(Ljava/lang/Object;)V
        //   201: aload_1        
        //   202: invokevirtual   java/io/FileInputStream.close:()V
        //   205: goto            166
        //   208: astore_1       
        //   209: ldc             "Error closing stream for reading resource from disk"
        //   211: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   214: goto            166
        //   217: astore_1       
        //   218: ldc             "Error closing stream for reading resource from disk"
        //   220: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   223: goto            166
        //   226: astore_2       
        //   227: aload_0        
        //   228: getfield        com/google/android/gms/tagmanager/zzey.zzbFV:Lcom/google/android/gms/tagmanager/zzdi;
        //   231: getstatic       com/google/android/gms/tagmanager/zzda.zzbFi:I
        //   234: invokeinterface com/google/android/gms/tagmanager/zzdi.zzbw:(I)V
        //   239: ldc             "Failed to read the resource from disk. The resource is inconsistent"
        //   241: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   244: aload_1        
        //   245: invokevirtual   java/io/FileInputStream.close:()V
        //   248: goto            166
        //   251: astore_1       
        //   252: ldc             "Error closing stream for reading resource from disk"
        //   254: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   257: goto            166
        //   260: astore_2       
        //   261: aload_1        
        //   262: invokevirtual   java/io/FileInputStream.close:()V
        //   265: aload_2        
        //   266: athrow         
        //   267: astore_1       
        //   268: ldc             "Error closing stream for reading resource from disk"
        //   270: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   273: goto            265
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  75     87     172    191    Ljava/io/FileNotFoundException;
        //  87     144    144    166    Ljava/io/IOException;
        //  87     144    226    260    Ljava/lang/IllegalArgumentException;
        //  87     144    260    276    Any
        //  145    162    260    276    Any
        //  162    166    217    226    Ljava/io/IOException;
        //  191    201    144    166    Ljava/io/IOException;
        //  191    201    226    260    Ljava/lang/IllegalArgumentException;
        //  191    201    260    276    Any
        //  201    205    208    217    Ljava/io/IOException;
        //  227    244    260    276    Any
        //  244    248    251    260    Ljava/io/IOException;
        //  261    265    267    276    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 121 out of bounds for length 121
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3569)
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
    
    @Override
    public final void zza(final ee ee) {
        this.zzbrV.execute(new zzfa(this, ee));
    }
    
    @Override
    public final void zza(final zzdi<ee> zzbFV) {
        this.zzbFV = zzbFV;
    }
    
    final boolean zzb(final ee p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/google/android/gms/tagmanager/zzey.zzBJ:()Ljava/io/File;
        //     4: astore_3       
        //     5: new             Ljava/io/FileOutputStream;
        //     8: dup            
        //     9: aload_3        
        //    10: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    13: astore_2       
        //    14: aload_2        
        //    15: aload_1        
        //    16: invokestatic    com/google/android/gms/internal/adp.zzc:(Lcom/google/android/gms/internal/adp;)[B
        //    19: invokevirtual   java/io/FileOutputStream.write:([B)V
        //    22: aload_2        
        //    23: invokevirtual   java/io/FileOutputStream.close:()V
        //    26: iconst_1       
        //    27: ireturn        
        //    28: astore_1       
        //    29: ldc_w           "Error opening resource file for writing"
        //    32: invokestatic    com/google/android/gms/tagmanager/zzdj.e:(Ljava/lang/String;)V
        //    35: iconst_0       
        //    36: ireturn        
        //    37: astore_1       
        //    38: ldc_w           "error closing stream for writing resource to disk"
        //    41: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    44: goto            26
        //    47: astore_1       
        //    48: ldc_w           "Error writing resource to disk. Removing resource from disk."
        //    51: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    54: aload_3        
        //    55: invokevirtual   java/io/File.delete:()Z
        //    58: pop            
        //    59: aload_2        
        //    60: invokevirtual   java/io/FileOutputStream.close:()V
        //    63: iconst_0       
        //    64: ireturn        
        //    65: astore_1       
        //    66: ldc_w           "error closing stream for writing resource to disk"
        //    69: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    72: iconst_0       
        //    73: ireturn        
        //    74: astore_1       
        //    75: aload_2        
        //    76: invokevirtual   java/io/FileOutputStream.close:()V
        //    79: aload_1        
        //    80: athrow         
        //    81: astore_2       
        //    82: ldc_w           "error closing stream for writing resource to disk"
        //    85: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    88: goto            79
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  5      14     28     37     Ljava/io/FileNotFoundException;
        //  14     22     47     74     Ljava/io/IOException;
        //  14     22     74     91     Any
        //  22     26     37     47     Ljava/io/IOException;
        //  48     59     74     91     Any
        //  59     63     65     74     Ljava/io/IOException;
        //  75     79     81     91     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0026:
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
    
    @Override
    public final ek zzbx(final int i) {
        Label_0134: {
            InputStream openRawResource;
            try {
                openRawResource = this.mContext.getResources().openRawResource(i);
                final String value = String.valueOf(this.mContext.getResources().getResourceName(i));
                zzdj.v(new StringBuilder(String.valueOf(value).length() + 66).append("Attempting to load a container from the resource ID ").append(i).append(" (").append(value).append(")").toString());
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                final InputStream inputStream = openRawResource;
                final ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                eg.zzb(inputStream, byteArrayOutputStream2);
                final ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                final ek ek = zza(byteArrayOutputStream3);
                final ek ek3;
                final ek ek2 = ek3 = ek;
                if (ek3 != null) {
                    final String s = "The container was successfully loaded from the resource (using JSON file format)";
                    zzdj.v(s);
                    return ek2;
                }
                break Label_0134;
            }
            catch (Resources$NotFoundException ex) {
                zzdj.zzaT(new StringBuilder(98).append("Failed to load the container. No default container resource found with the resource ID ").append(i).toString());
                return null;
            }
            try {
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                final InputStream inputStream = openRawResource;
                final ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                eg.zzb(inputStream, byteArrayOutputStream2);
                final ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                final ek ek = zza(byteArrayOutputStream3);
                final ek ek3;
                final ek ek2 = ek3 = ek;
                if (ek3 != null) {
                    final String s = "The container was successfully loaded from the resource (using JSON file format)";
                    zzdj.v(s);
                    return ek2;
                }
                return zzu(byteArrayOutputStream.toByteArray());
            }
            catch (IOException ex2) {
                final String value2 = String.valueOf(this.mContext.getResources().getResourceName(i));
                zzdj.zzaT(new StringBuilder(String.valueOf(value2).length() + 67).append("Error reading the default container with resource ID ").append(i).append(" (").append(value2).append(")").toString());
                return null;
            }
        }
    }
}
