// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.google.android.gms.analytics.zzl;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.io.IOException;
import com.google.android.gms.common.internal.zzbo;
import java.net.URL;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;

final class zzaoe extends zzamh
{
    private static final byte[] zzait;
    private final String zzJP;
    private final zzaoo zzais;
    
    static {
        zzait = "\n".getBytes();
    }
    
    zzaoe(final zzamj zzamj) {
        super(zzamj);
        this.zzJP = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzami.VERSION, Build$VERSION.RELEASE, zzaos.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzais = new zzaoo(zzamj.zzkq());
    }
    
    private final int zza(final URL url) {
        zzbo.zzu(url);
        this.zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection zzb = null;
        try {
            final HttpURLConnection httpURLConnection2 = httpURLConnection = (zzb = this.zzb(url));
            httpURLConnection2.connect();
            zzb = httpURLConnection2;
            httpURLConnection = httpURLConnection2;
            this.zzb(httpURLConnection2);
            zzb = httpURLConnection2;
            httpURLConnection = httpURLConnection2;
            final int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode == 200) {
                zzb = httpURLConnection2;
                httpURLConnection = httpURLConnection2;
                this.zzkv().zzko();
            }
            zzb = httpURLConnection2;
            httpURLConnection = httpURLConnection2;
            this.zzb("GET status", responseCode);
            return responseCode;
        }
        catch (IOException ex) {
            httpURLConnection = zzb;
            this.zzd("Network GET connection error", ex);
            return 0;
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
    
    private final int zza(final URL p0, final byte[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          5
        //     3: aconst_null    
        //     4: astore          7
        //     6: aconst_null    
        //     7: astore          8
        //     9: aconst_null    
        //    10: astore          6
        //    12: aload_1        
        //    13: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    16: pop            
        //    17: aload_2        
        //    18: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: pop            
        //    22: aload_0        
        //    23: ldc             "POST bytes, url"
        //    25: aload_2        
        //    26: arraylength    
        //    27: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    30: aload_1        
        //    31: invokevirtual   com/google/android/gms/internal/zzaoe.zzb:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    34: invokestatic    com/google/android/gms/internal/zzaoe.zzhM:()Z
        //    37: ifeq            54
        //    40: aload_0        
        //    41: ldc             "Post payload\n"
        //    43: new             Ljava/lang/String;
        //    46: dup            
        //    47: aload_2        
        //    48: invokespecial   java/lang/String.<init>:([B)V
        //    51: invokevirtual   com/google/android/gms/internal/zzaoe.zza:(Ljava/lang/String;Ljava/lang/Object;)V
        //    54: aload_0        
        //    55: invokevirtual   com/google/android/gms/internal/zzaoe.getContext:()Landroid/content/Context;
        //    58: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    61: pop            
        //    62: aload_0        
        //    63: aload_1        
        //    64: invokespecial   com/google/android/gms/internal/zzaoe.zzb:(Ljava/net/URL;)Ljava/net/HttpURLConnection;
        //    67: astore_1       
        //    68: aload_1        
        //    69: astore          5
        //    71: aload           7
        //    73: astore_1       
        //    74: aload           5
        //    76: astore          4
        //    78: aload           8
        //    80: astore          6
        //    82: aload           5
        //    84: iconst_1       
        //    85: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //    88: aload           7
        //    90: astore_1       
        //    91: aload           5
        //    93: astore          4
        //    95: aload           8
        //    97: astore          6
        //    99: aload           5
        //   101: aload_2        
        //   102: arraylength    
        //   103: invokevirtual   java/net/HttpURLConnection.setFixedLengthStreamingMode:(I)V
        //   106: aload           7
        //   108: astore_1       
        //   109: aload           5
        //   111: astore          4
        //   113: aload           8
        //   115: astore          6
        //   117: aload           5
        //   119: invokevirtual   java/net/HttpURLConnection.connect:()V
        //   122: aload           7
        //   124: astore_1       
        //   125: aload           5
        //   127: astore          4
        //   129: aload           8
        //   131: astore          6
        //   133: aload           5
        //   135: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   138: astore          7
        //   140: aload           7
        //   142: astore_1       
        //   143: aload           5
        //   145: astore          4
        //   147: aload           7
        //   149: astore          6
        //   151: aload           7
        //   153: aload_2        
        //   154: invokevirtual   java/io/OutputStream.write:([B)V
        //   157: aload           7
        //   159: astore_1       
        //   160: aload           5
        //   162: astore          4
        //   164: aload           7
        //   166: astore          6
        //   168: aload_0        
        //   169: aload           5
        //   171: invokespecial   com/google/android/gms/internal/zzaoe.zzb:(Ljava/net/HttpURLConnection;)V
        //   174: aload           7
        //   176: astore_1       
        //   177: aload           5
        //   179: astore          4
        //   181: aload           7
        //   183: astore          6
        //   185: aload           5
        //   187: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   190: istore_3       
        //   191: iload_3        
        //   192: sipush          200
        //   195: if_icmpne       216
        //   198: aload           7
        //   200: astore_1       
        //   201: aload           5
        //   203: astore          4
        //   205: aload           7
        //   207: astore          6
        //   209: aload_0        
        //   210: invokevirtual   com/google/android/gms/internal/zzaoe.zzkv:()Lcom/google/android/gms/internal/zzaly;
        //   213: invokevirtual   com/google/android/gms/internal/zzaly.zzko:()V
        //   216: aload           7
        //   218: astore_1       
        //   219: aload           5
        //   221: astore          4
        //   223: aload           7
        //   225: astore          6
        //   227: aload_0        
        //   228: ldc             "POST status"
        //   230: iload_3        
        //   231: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   234: invokevirtual   com/google/android/gms/internal/zzaoe.zzb:(Ljava/lang/String;Ljava/lang/Object;)V
        //   237: aload           7
        //   239: ifnull          247
        //   242: aload           7
        //   244: invokevirtual   java/io/OutputStream.close:()V
        //   247: aload           5
        //   249: ifnull          257
        //   252: aload           5
        //   254: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   257: iload_3        
        //   258: ireturn        
        //   259: astore_1       
        //   260: aload_0        
        //   261: ldc             "Error closing http post connection output stream"
        //   263: aload_1        
        //   264: invokevirtual   com/google/android/gms/internal/zzaoe.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   267: goto            247
        //   270: astore_2       
        //   271: aconst_null    
        //   272: astore          5
        //   274: aload           6
        //   276: astore_1       
        //   277: aload           5
        //   279: astore          4
        //   281: aload_0        
        //   282: ldc             "Network POST connection error"
        //   284: aload_2        
        //   285: invokevirtual   com/google/android/gms/internal/zzaoe.zzd:(Ljava/lang/String;Ljava/lang/Object;)V
        //   288: aload           6
        //   290: ifnull          298
        //   293: aload           6
        //   295: invokevirtual   java/io/OutputStream.close:()V
        //   298: aload           5
        //   300: ifnull          308
        //   303: aload           5
        //   305: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   308: iconst_0       
        //   309: ireturn        
        //   310: astore_1       
        //   311: aload_0        
        //   312: ldc             "Error closing http post connection output stream"
        //   314: aload_1        
        //   315: invokevirtual   com/google/android/gms/internal/zzaoe.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   318: goto            298
        //   321: astore_2       
        //   322: aconst_null    
        //   323: astore          4
        //   325: aload           5
        //   327: astore_1       
        //   328: aload_1        
        //   329: ifnull          336
        //   332: aload_1        
        //   333: invokevirtual   java/io/OutputStream.close:()V
        //   336: aload           4
        //   338: ifnull          346
        //   341: aload           4
        //   343: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   346: aload_2        
        //   347: athrow         
        //   348: astore_1       
        //   349: aload_0        
        //   350: ldc             "Error closing http post connection output stream"
        //   352: aload_1        
        //   353: invokevirtual   com/google/android/gms/internal/zzaoe.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   356: goto            336
        //   359: astore_2       
        //   360: goto            328
        //   363: astore_2       
        //   364: goto            274
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  54     68     270    274    Ljava/io/IOException;
        //  54     68     321    328    Any
        //  82     88     363    367    Ljava/io/IOException;
        //  82     88     359    363    Any
        //  99     106    363    367    Ljava/io/IOException;
        //  99     106    359    363    Any
        //  117    122    363    367    Ljava/io/IOException;
        //  117    122    359    363    Any
        //  133    140    363    367    Ljava/io/IOException;
        //  133    140    359    363    Any
        //  151    157    363    367    Ljava/io/IOException;
        //  151    157    359    363    Any
        //  168    174    363    367    Ljava/io/IOException;
        //  168    174    359    363    Any
        //  185    191    363    367    Ljava/io/IOException;
        //  185    191    359    363    Any
        //  209    216    363    367    Ljava/io/IOException;
        //  209    216    359    363    Any
        //  227    237    363    367    Ljava/io/IOException;
        //  227    237    359    363    Any
        //  242    247    259    270    Ljava/io/IOException;
        //  281    288    359    363    Any
        //  293    298    310    321    Ljava/io/IOException;
        //  332    336    348    359    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0216:
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
    
    private static void zza(final StringBuilder sb, final String s, final String s2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(s, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(s2, "UTF-8"));
    }
    
    private final int zzb(final URL p0, final byte[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          5
        //     3: aconst_null    
        //     4: astore          4
        //     6: aload_1        
        //     7: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    10: pop            
        //    11: aload_2        
        //    12: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    15: pop            
        //    16: aload_0        
        //    17: invokevirtual   com/google/android/gms/internal/zzaoe.getContext:()Landroid/content/Context;
        //    20: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    23: pop            
        //    24: new             Ljava/io/ByteArrayOutputStream;
        //    27: dup            
        //    28: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    31: astore          6
        //    33: new             Ljava/util/zip/GZIPOutputStream;
        //    36: dup            
        //    37: aload           6
        //    39: invokespecial   java/util/zip/GZIPOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    42: astore          7
        //    44: aload           7
        //    46: aload_2        
        //    47: invokevirtual   java/util/zip/GZIPOutputStream.write:([B)V
        //    50: aload           7
        //    52: invokevirtual   java/util/zip/GZIPOutputStream.close:()V
        //    55: aload           6
        //    57: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    60: aload           6
        //    62: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    65: astore          6
        //    67: aload_0        
        //    68: ldc             "POST compressed size, ratio %, url"
        //    70: aload           6
        //    72: arraylength    
        //    73: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    76: ldc2_w          100
        //    79: aload           6
        //    81: arraylength    
        //    82: i2l            
        //    83: lmul           
        //    84: aload_2        
        //    85: arraylength    
        //    86: i2l            
        //    87: ldiv           
        //    88: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //    91: aload_1        
        //    92: invokevirtual   com/google/android/gms/internal/zzaoe.zza:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    95: aload           6
        //    97: arraylength    
        //    98: aload_2        
        //    99: arraylength    
        //   100: if_icmple       120
        //   103: aload_0        
        //   104: ldc             "Compressed payload is larger then uncompressed. compressed, uncompressed"
        //   106: aload           6
        //   108: arraylength    
        //   109: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   112: aload_2        
        //   113: arraylength    
        //   114: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   117: invokevirtual   com/google/android/gms/internal/zzaoe.zzc:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   120: invokestatic    com/google/android/gms/internal/zzaoe.zzhM:()Z
        //   123: ifeq            160
        //   126: new             Ljava/lang/String;
        //   129: dup            
        //   130: aload_2        
        //   131: invokespecial   java/lang/String.<init>:([B)V
        //   134: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   137: astore_2       
        //   138: aload_2        
        //   139: invokevirtual   java/lang/String.length:()I
        //   142: ifeq            251
        //   145: ldc             "\n"
        //   147: aload_2        
        //   148: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   151: astore_2       
        //   152: aload_0        
        //   153: ldc_w           "Post payload"
        //   156: aload_2        
        //   157: invokevirtual   com/google/android/gms/internal/zzaoe.zza:(Ljava/lang/String;Ljava/lang/Object;)V
        //   160: aload_0        
        //   161: aload_1        
        //   162: invokespecial   com/google/android/gms/internal/zzaoe.zzb:(Ljava/net/URL;)Ljava/net/HttpURLConnection;
        //   165: astore_1       
        //   166: aload_1        
        //   167: iconst_1       
        //   168: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   171: aload_1        
        //   172: ldc_w           "Content-Encoding"
        //   175: ldc_w           "gzip"
        //   178: invokevirtual   java/net/HttpURLConnection.addRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   181: aload_1        
        //   182: aload           6
        //   184: arraylength    
        //   185: invokevirtual   java/net/HttpURLConnection.setFixedLengthStreamingMode:(I)V
        //   188: aload_1        
        //   189: invokevirtual   java/net/HttpURLConnection.connect:()V
        //   192: aload_1        
        //   193: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   196: astore_2       
        //   197: aload_2        
        //   198: aload           6
        //   200: invokevirtual   java/io/OutputStream.write:([B)V
        //   203: aload_2        
        //   204: invokevirtual   java/io/OutputStream.close:()V
        //   207: aload_0        
        //   208: aload_1        
        //   209: invokespecial   com/google/android/gms/internal/zzaoe.zzb:(Ljava/net/HttpURLConnection;)V
        //   212: aload_1        
        //   213: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   216: istore_3       
        //   217: iload_3        
        //   218: sipush          200
        //   221: if_icmpne       231
        //   224: aload_0        
        //   225: invokevirtual   com/google/android/gms/internal/zzaoe.zzkv:()Lcom/google/android/gms/internal/zzaly;
        //   228: invokevirtual   com/google/android/gms/internal/zzaly.zzko:()V
        //   231: aload_0        
        //   232: ldc             "POST status"
        //   234: iload_3        
        //   235: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   238: invokevirtual   com/google/android/gms/internal/zzaoe.zzb:(Ljava/lang/String;Ljava/lang/Object;)V
        //   241: aload_1        
        //   242: ifnull          249
        //   245: aload_1        
        //   246: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   249: iload_3        
        //   250: ireturn        
        //   251: new             Ljava/lang/String;
        //   254: dup            
        //   255: ldc             "\n"
        //   257: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   260: astore_2       
        //   261: goto            152
        //   264: astore_2       
        //   265: aconst_null    
        //   266: astore_1       
        //   267: aload_0        
        //   268: ldc_w           "Network compressed POST connection error"
        //   271: aload_2        
        //   272: invokevirtual   com/google/android/gms/internal/zzaoe.zzd:(Ljava/lang/String;Ljava/lang/Object;)V
        //   275: aload           4
        //   277: ifnull          285
        //   280: aload           4
        //   282: invokevirtual   java/io/OutputStream.close:()V
        //   285: aload_1        
        //   286: ifnull          293
        //   289: aload_1        
        //   290: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   293: iconst_0       
        //   294: ireturn        
        //   295: astore_2       
        //   296: aload_0        
        //   297: ldc_w           "Error closing http compressed post connection output stream"
        //   300: aload_2        
        //   301: invokevirtual   com/google/android/gms/internal/zzaoe.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   304: goto            285
        //   307: astore_2       
        //   308: aconst_null    
        //   309: astore_1       
        //   310: aload           5
        //   312: astore          4
        //   314: aload           4
        //   316: ifnull          324
        //   319: aload           4
        //   321: invokevirtual   java/io/OutputStream.close:()V
        //   324: aload_1        
        //   325: ifnull          332
        //   328: aload_1        
        //   329: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   332: aload_2        
        //   333: athrow         
        //   334: astore          4
        //   336: aload_0        
        //   337: ldc_w           "Error closing http compressed post connection output stream"
        //   340: aload           4
        //   342: invokevirtual   com/google/android/gms/internal/zzaoe.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   345: goto            324
        //   348: astore_2       
        //   349: aload           5
        //   351: astore          4
        //   353: goto            314
        //   356: astore          5
        //   358: aload_2        
        //   359: astore          4
        //   361: aload           5
        //   363: astore_2       
        //   364: goto            314
        //   367: astore_2       
        //   368: goto            314
        //   371: astore_2       
        //   372: goto            267
        //   375: astore          5
        //   377: aload_2        
        //   378: astore          4
        //   380: aload           5
        //   382: astore_2       
        //   383: goto            267
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  16     120    264    267    Ljava/io/IOException;
        //  16     120    307    314    Any
        //  120    152    264    267    Ljava/io/IOException;
        //  120    152    307    314    Any
        //  152    160    264    267    Ljava/io/IOException;
        //  152    160    307    314    Any
        //  160    166    264    267    Ljava/io/IOException;
        //  160    166    307    314    Any
        //  166    197    371    375    Ljava/io/IOException;
        //  166    197    348    356    Any
        //  197    207    375    386    Ljava/io/IOException;
        //  197    207    356    367    Any
        //  207    217    371    375    Ljava/io/IOException;
        //  207    217    348    356    Any
        //  224    231    371    375    Ljava/io/IOException;
        //  224    231    348    356    Any
        //  231    241    371    375    Ljava/io/IOException;
        //  231    241    348    356    Any
        //  251    261    264    267    Ljava/io/IOException;
        //  251    261    307    314    Any
        //  267    275    367    371    Any
        //  280    285    295    307    Ljava/io/IOException;
        //  319    324    334    348    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 201 out of bounds for length 201
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
    
    private final HttpURLConnection zzb(final URL url) throws IOException {
        final URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        final HttpURLConnection httpURLConnection = (HttpURLConnection)openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzans.zzahI.get());
        httpURLConnection.setReadTimeout(zzans.zzahJ.get());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzJP);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }
    
    private final URL zzb(final zzanx zzanx, final String s) {
        Label_0086: {
            if (!zzanx.zzlI()) {
                break Label_0086;
            }
            final String value = String.valueOf(zzank.zzlu());
            final String value2 = String.valueOf(zzank.zzlw());
            String s2 = new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(value2).length() + String.valueOf(s).length()).append(value).append(value2).append("?").append(s).toString();
            try {
                return new URL(s2);
                final String value3 = String.valueOf(zzank.zzlv());
                final String value4 = String.valueOf(zzank.zzlw());
                s2 = new StringBuilder(String.valueOf(value3).length() + 1 + String.valueOf(value4).length() + String.valueOf(s).length()).append(value3).append(value4).append("?").append(s).toString();
                return new URL(s2);
            }
            catch (MalformedURLException ex) {
                this.zze("Error trying to parse the hardcoded host url", ex);
                return null;
            }
        }
    }
    
    private final void zzb(final HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            final InputStream inputStream2 = inputStream = httpURLConnection.getInputStream();
            do {
                inputStream = inputStream2;
            } while (inputStream2.read(new byte[1024]) > 0);
            if (inputStream2 == null) {
                return;
            }
            try {
                inputStream2.close();
            }
            catch (IOException ex) {
                this.zze("Error closing http connection input stream", ex);
            }
        }
        finally {
            Label_0057: {
                if (inputStream == null) {
                    break Label_0057;
                }
                try {
                    inputStream.close();
                }
                catch (IOException ex2) {
                    this.zze("Error closing http connection input stream", ex2);
                }
            }
        }
    }
    
    private final URL zzd(final zzanx zzanx) {
        Label_0057: {
            if (!zzanx.zzlI()) {
                break Label_0057;
            }
            final String value = String.valueOf(zzank.zzlu());
            final String value2 = String.valueOf(zzank.zzlw());
            Label_0045: {
                if (value2.length() == 0) {
                    break Label_0045;
                }
                String s = value.concat(value2);
                try {
                    return new URL(s);
                    s = new String(value);
                    return new URL(s);
                    final String value3 = String.valueOf(zzank.zzlv());
                    final String value4 = String.valueOf(zzank.zzlw());
                    // iftrue(Label_0087:, value4.length() == 0)
                    s = value3.concat(value4);
                    return new URL(s);
                    Label_0087: {
                        s = new String(value3);
                    }
                    return new URL(s);
                }
                catch (MalformedURLException ex) {
                    this.zze("Error trying to parse the hardcoded host url", ex);
                    return null;
                }
            }
        }
    }
    
    private final URL zzlR() {
        final String value = String.valueOf(zzank.zzlu());
        final String value2 = String.valueOf(zzans.zzahx.get());
        Label_0044: {
            if (value2.length() == 0) {
                break Label_0044;
            }
            String concat = value.concat(value2);
            try {
                return new URL(concat);
                concat = new String(value);
                return new URL(concat);
            }
            catch (MalformedURLException ex) {
                this.zze("Error trying to parse the hardcoded host url", ex);
                return null;
            }
        }
    }
    
    private final List<Long> zzv(final List<zzanx> list) {
        final ArrayList<Long> list2 = new ArrayList<Long>(list.size());
        for (final zzanx zzanx : list) {
            zzbo.zzu(zzanx);
            final String zza = this.zza(zzanx, !zzanx.zzlI());
            int n = 0;
            Label_0086: {
                if (zza == null) {
                    this.zzkr().zza(zzanx, "Error formatting hit for upload");
                    n = 1;
                }
                else {
                    if (zza.length() <= zzans.zzahy.get()) {
                        final URL zzb = this.zzb(zzanx, zza);
                        if (zzb == null) {
                            this.zzbs("Failed to build collect GET endpoint url");
                        }
                        else {
                            if (this.zza(zzb) == 200) {
                                n = 1;
                                break Label_0086;
                            }
                            n = 0;
                            break Label_0086;
                        }
                    }
                    else {
                        final String zza2 = this.zza(zzanx, false);
                        if (zza2 == null) {
                            this.zzkr().zza(zzanx, "Error formatting hit for POST upload");
                            n = 1;
                            break Label_0086;
                        }
                        final byte[] bytes = zza2.getBytes();
                        if (bytes.length > zzans.zzahD.get()) {
                            this.zzkr().zza(zzanx, "Hit payload exceeds size limit");
                            n = 1;
                            break Label_0086;
                        }
                        final URL zzd = this.zzd(zzanx);
                        if (zzd == null) {
                            this.zzbs("Failed to build collect POST endpoint url");
                        }
                        else if (this.zza(zzd, bytes) == 200) {
                            n = 1;
                            break Label_0086;
                        }
                    }
                    n = 0;
                }
            }
            if (n == 0) {
                break;
            }
            list2.add(zzanx.zzlF());
            if (list2.size() >= zzank.zzls()) {
                break;
            }
        }
        return list2;
    }
    
    final String zza(final zzanx zzanx, final boolean b) {
        zzbo.zzu(zzanx);
        final StringBuilder sb = new StringBuilder();
        try {
            for (final Map.Entry<String, String> entry : zzanx.zzdV().entrySet()) {
                final String anObject = entry.getKey();
                if (!"ht".equals(anObject) && !"qt".equals(anObject) && !"AppUID".equals(anObject) && !"z".equals(anObject) && !"_gmsv".equals(anObject)) {
                    zza(sb, anObject, entry.getValue());
                }
            }
        }
        catch (UnsupportedEncodingException ex) {
            this.zze("Failed to encode name or value", ex);
            return null;
        }
        zza(sb, "ht", String.valueOf(zzanx.zzlG()));
        zza(sb, "qt", String.valueOf(this.zzkq().currentTimeMillis() - zzanx.zzlG()));
        if (b) {
            final long zzlJ = zzanx.zzlJ();
            String s;
            if (zzlJ != 0L) {
                s = String.valueOf(zzlJ);
            }
            else {
                s = String.valueOf(zzanx.zzlF());
            }
            zza(sb, "z", s);
        }
        return sb.toString();
    }
    
    @Override
    protected final void zzjD() {
        this.zza("Network initialized. User agent", this.zzJP);
    }
    
    public final boolean zzlQ() {
        zzl.zzjC();
        this.zzkD();
        final ConnectivityManager connectivityManager = (ConnectivityManager)this.getContext().getSystemService("connectivity");
        while (true) {
            try {
                final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    this.zzbo("No network connectivity");
                    return false;
                }
            }
            catch (SecurityException ex) {
                final NetworkInfo activeNetworkInfo = null;
                continue;
            }
            break;
        }
        return true;
    }
    
    public final List<Long> zzu(final List<zzanx> list) {
        boolean b = true;
        zzl.zzjC();
        this.zzkD();
        zzbo.zzu(list);
        int n2 = 0;
        boolean b2 = false;
        Label_0064: {
            int n;
            if (this.zzks().zzlx().isEmpty() || !this.zzais.zzu(zzans.zzahG.get() * 1000L)) {
                n = 0;
            }
            else {
                if (zzana.zzbx(zzans.zzahz.get()) != zzana.zzagG) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                n = n2;
                if (zzang.zzby(zzans.zzahA.get()) == zzang.zzagR) {
                    b2 = true;
                    break Label_0064;
                }
            }
            b2 = false;
            n2 = n;
        }
        if (n2 == 0) {
            return this.zzv(list);
        }
        if (list.isEmpty()) {
            b = false;
        }
        zzbo.zzaf(b);
        this.zza("Uploading batched hits. compression, count", b2, list.size());
        final zzaof zzaof = new zzaof(this);
        final ArrayList<Long> list2 = new ArrayList<Long>();
        for (final zzanx zzanx : list) {
            if (!zzaof.zze(zzanx)) {
                break;
            }
            list2.add(zzanx.zzlF());
        }
        if (zzaof.zzlT() == 0) {
            return list2;
        }
        final URL zzlR = this.zzlR();
        if (zzlR == null) {
            this.zzbs("Failed to build batching endpoint url");
        }
        else {
            int n3;
            if (b2) {
                n3 = this.zzb(zzlR, zzaof.getPayload());
            }
            else {
                n3 = this.zza(zzlR, zzaof.getPayload());
            }
            if (200 == n3) {
                this.zza("Batched upload completed. Hits batched", zzaof.zzlT());
                return list2;
            }
            this.zza("Network error uploading hits. status code", n3);
            if (this.zzks().zzlx().contains(n3)) {
                this.zzbr("Server instructed the client to stop batching");
                this.zzais.start();
            }
        }
        return Collections.emptyList();
    }
}
