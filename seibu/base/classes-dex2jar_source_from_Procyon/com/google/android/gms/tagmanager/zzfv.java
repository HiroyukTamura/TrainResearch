// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.List;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import android.content.Context;

final class zzfv implements zzbe
{
    private final Context mContext;
    private final String zzJP;
    private final zzfy zzbGR;
    private final zzfx zzbGS;
    
    zzfv(final Context context, final zzfx zzfx) {
        this(new zzfw(), context, zzfx);
    }
    
    private zzfv(final zzfy zzbGR, final Context context, final zzfx zzbGS) {
        final Object o = null;
        this.zzbGR = zzbGR;
        this.mContext = context.getApplicationContext();
        this.zzbGS = zzbGS;
        final String release = Build$VERSION.RELEASE;
        final Locale default1 = Locale.getDefault();
        Object string;
        if (default1 == null) {
            string = o;
        }
        else {
            string = o;
            if (default1.getLanguage() != null) {
                string = o;
                if (default1.getLanguage().length() != 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(default1.getLanguage().toLowerCase());
                    if (default1.getCountry() != null && default1.getCountry().length() != 0) {
                        sb.append("-").append(default1.getCountry().toLowerCase());
                    }
                    string = sb.toString();
                }
            }
        }
        this.zzJP = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "4.00", release, string, Build.MODEL, Build.ID);
    }
    
    private static URL zzd(final zzbx zzbx) {
        final String zzBo = zzbx.zzBo();
        try {
            return new URL(zzBo);
        }
        catch (MalformedURLException ex) {
            zzdj.e("Error trying to parse the GTM url.");
            return null;
        }
    }
    
    @Override
    public final boolean zzBf() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            zzdj.v("...no network connectivity");
            return false;
        }
        return true;
    }
    
    @Override
    public final void zzK(final List<zzbx> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface java/util/List.size:()I
        //     6: bipush          40
        //     8: invokestatic    java/lang/Math.min:(II)I
        //    11: istore          6
        //    13: iconst_1       
        //    14: istore_3       
        //    15: iconst_0       
        //    16: istore          5
        //    18: iload           5
        //    20: iload           6
        //    22: if_icmpge       316
        //    25: aload_1        
        //    26: iload           5
        //    28: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    33: checkcast       Lcom/google/android/gms/tagmanager/zzbx;
        //    36: astore          9
        //    38: aload           9
        //    40: invokestatic    com/google/android/gms/tagmanager/zzfv.zzd:(Lcom/google/android/gms/tagmanager/zzbx;)Ljava/net/URL;
        //    43: astore          7
        //    45: aload           7
        //    47: ifnonnull       79
        //    50: ldc             "No destination: discarding hit."
        //    52: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //    55: aload_0        
        //    56: getfield        com/google/android/gms/tagmanager/zzfv.zzbGS:Lcom/google/android/gms/tagmanager/zzfx;
        //    59: aload           9
        //    61: invokeinterface com/google/android/gms/tagmanager/zzfx.zzb:(Lcom/google/android/gms/tagmanager/zzbx;)V
        //    66: iload_3        
        //    67: istore_2       
        //    68: iload           5
        //    70: iconst_1       
        //    71: iadd           
        //    72: istore          5
        //    74: iload_2        
        //    75: istore_3       
        //    76: goto            18
        //    79: iload_3        
        //    80: istore          4
        //    82: aload_0        
        //    83: getfield        com/google/android/gms/tagmanager/zzfv.zzbGR:Lcom/google/android/gms/tagmanager/zzfy;
        //    86: aload           7
        //    88: invokeinterface com/google/android/gms/tagmanager/zzfy.zzc:(Ljava/net/URL;)Ljava/net/HttpURLConnection;
        //    93: astore          10
        //    95: iload_3        
        //    96: istore_2       
        //    97: iload_3        
        //    98: ifeq            110
        //   101: aload_0        
        //   102: getfield        com/google/android/gms/tagmanager/zzfv.mContext:Landroid/content/Context;
        //   105: invokestatic    com/google/android/gms/tagmanager/zzdo.zzbt:(Landroid/content/Context;)V
        //   108: iconst_0       
        //   109: istore_2       
        //   110: iload_2        
        //   111: istore_3       
        //   112: aload           10
        //   114: ldc             "User-Agent"
        //   116: aload_0        
        //   117: getfield        com/google/android/gms/tagmanager/zzfv.zzJP:Ljava/lang/String;
        //   120: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   123: iload_2        
        //   124: istore_3       
        //   125: aload           10
        //   127: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   130: istore          4
        //   132: iload_2        
        //   133: istore_3       
        //   134: aload           10
        //   136: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   139: astore          7
        //   141: iload           4
        //   143: sipush          200
        //   146: if_icmpeq       209
        //   149: new             Ljava/lang/StringBuilder;
        //   152: dup            
        //   153: bipush          25
        //   155: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   158: ldc             "Bad response: "
        //   160: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   163: iload           4
        //   165: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   168: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   171: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   174: aload_0        
        //   175: getfield        com/google/android/gms/tagmanager/zzfv.zzbGS:Lcom/google/android/gms/tagmanager/zzfx;
        //   178: aload           9
        //   180: invokeinterface com/google/android/gms/tagmanager/zzfx.zzc:(Lcom/google/android/gms/tagmanager/zzbx;)V
        //   185: aload           7
        //   187: ifnull          198
        //   190: iload_2        
        //   191: istore          4
        //   193: aload           7
        //   195: invokevirtual   java/io/InputStream.close:()V
        //   198: iload_2        
        //   199: istore          4
        //   201: aload           10
        //   203: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   206: goto            68
        //   209: aload_0        
        //   210: getfield        com/google/android/gms/tagmanager/zzfv.zzbGS:Lcom/google/android/gms/tagmanager/zzfx;
        //   213: aload           9
        //   215: invokeinterface com/google/android/gms/tagmanager/zzfx.zza:(Lcom/google/android/gms/tagmanager/zzbx;)V
        //   220: goto            185
        //   223: astore          8
        //   225: aload           7
        //   227: ifnull          235
        //   230: aload           7
        //   232: invokevirtual   java/io/InputStream.close:()V
        //   235: aload           10
        //   237: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   240: aload           8
        //   242: athrow         
        //   243: astore          7
        //   245: aload           7
        //   247: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   250: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //   253: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   256: astore          8
        //   258: aload           8
        //   260: invokevirtual   java/lang/String.length:()I
        //   263: ifeq            302
        //   266: ldc             "Exception sending hit: "
        //   268: aload           8
        //   270: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   273: astore          8
        //   275: aload           8
        //   277: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   280: aload           7
        //   282: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   285: invokestatic    com/google/android/gms/tagmanager/zzdj.zzaT:(Ljava/lang/String;)V
        //   288: aload_0        
        //   289: getfield        com/google/android/gms/tagmanager/zzfv.zzbGS:Lcom/google/android/gms/tagmanager/zzfx;
        //   292: aload           9
        //   294: invokeinterface com/google/android/gms/tagmanager/zzfx.zzc:(Lcom/google/android/gms/tagmanager/zzbx;)V
        //   299: goto            68
        //   302: new             Ljava/lang/String;
        //   305: dup            
        //   306: ldc             "Exception sending hit: "
        //   308: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   311: astore          8
        //   313: goto            275
        //   316: return         
        //   317: astore          7
        //   319: iload           4
        //   321: istore_2       
        //   322: goto            245
        //   325: astore          8
        //   327: aconst_null    
        //   328: astore          7
        //   330: iload_3        
        //   331: istore_2       
        //   332: goto            225
        //    Signature:
        //  (Ljava/util/List<Lcom/google/android/gms/tagmanager/zzbx;>;)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  82     95     317    325    Ljava/io/IOException;
        //  101    108    325    335    Any
        //  112    123    325    335    Any
        //  125    132    325    335    Any
        //  134    141    325    335    Any
        //  149    185    223    225    Any
        //  193    198    317    325    Ljava/io/IOException;
        //  201    206    317    325    Ljava/io/IOException;
        //  209    220    223    225    Any
        //  230    235    243    245    Ljava/io/IOException;
        //  235    243    243    245    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0110:
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
