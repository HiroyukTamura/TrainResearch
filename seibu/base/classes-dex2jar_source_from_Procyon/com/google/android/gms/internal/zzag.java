// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.FilterOutputStream;
import java.util.Iterator;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Collections;
import java.io.OutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.io.File;
import java.util.Map;

public final class zzag implements zzb
{
    private final Map<String, zzai> zzav;
    private long zzaw;
    private final File zzax;
    private final int zzay;
    
    public zzag(final File file) {
        this(file, 5242880);
    }
    
    private zzag(final File zzax, final int n) {
        this.zzav = new LinkedHashMap<String, zzai>(16, 0.75f, true);
        this.zzaw = 0L;
        this.zzax = zzax;
        this.zzay = 5242880;
    }
    
    private final void remove(final String s) {
        synchronized (this) {
            final boolean delete = this.zze(s).delete();
            final zzai zzai = this.zzav.get(s);
            if (zzai != null) {
                this.zzaw -= zzai.size;
                this.zzav.remove(s);
            }
            if (!delete) {
                zzab.zzb("Could not delete cache entry for key=%s, filename=%s", s, zzd(s));
            }
        }
    }
    
    private static int zza(final InputStream inputStream) throws IOException {
        final int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }
    
    static void zza(final OutputStream outputStream, final int n) throws IOException {
        outputStream.write(n & 0xFF);
        outputStream.write(n >> 8 & 0xFF);
        outputStream.write(n >> 16 & 0xFF);
        outputStream.write(n >>> 24);
    }
    
    static void zza(final OutputStream outputStream, final long n) throws IOException {
        outputStream.write((byte)n);
        outputStream.write((byte)(n >>> 8));
        outputStream.write((byte)(n >>> 16));
        outputStream.write((byte)(n >>> 24));
        outputStream.write((byte)(n >>> 32));
        outputStream.write((byte)(n >>> 40));
        outputStream.write((byte)(n >>> 48));
        outputStream.write((byte)(n >>> 56));
    }
    
    static void zza(final OutputStream outputStream, final String s) throws IOException {
        final byte[] bytes = s.getBytes("UTF-8");
        zza(outputStream, (long)bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }
    
    private final void zza(final String s, final zzai zzai) {
        if (!this.zzav.containsKey(s)) {
            this.zzaw += zzai.size;
        }
        else {
            this.zzaw += zzai.size - this.zzav.get(s).size;
        }
        this.zzav.put(s, zzai);
    }
    
    private static byte[] zza(final InputStream inputStream, final int i) throws IOException {
        final byte[] b = new byte[i];
        int j;
        int read;
        for (j = 0; j < i; j += read) {
            read = inputStream.read(b, j, i - j);
            if (read == -1) {
                break;
            }
        }
        if (j != i) {
            throw new IOException(new StringBuilder(50).append("Expected ").append(i).append(" bytes, read ").append(j).append(" bytes").toString());
        }
        return b;
    }
    
    static int zzb(final InputStream inputStream) throws IOException {
        return zza(inputStream) | 0x0 | zza(inputStream) << 8 | zza(inputStream) << 16 | zza(inputStream) << 24;
    }
    
    static long zzc(final InputStream inputStream) throws IOException {
        return 0x0L | ((long)zza(inputStream) & 0xFFL) | ((long)zza(inputStream) & 0xFFL) << 8 | ((long)zza(inputStream) & 0xFFL) << 16 | ((long)zza(inputStream) & 0xFFL) << 24 | ((long)zza(inputStream) & 0xFFL) << 32 | ((long)zza(inputStream) & 0xFFL) << 40 | ((long)zza(inputStream) & 0xFFL) << 48 | ((long)zza(inputStream) & 0xFFL) << 56;
    }
    
    static String zzd(final InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int)zzc(inputStream)), "UTF-8");
    }
    
    private static String zzd(String value) {
        final int n = value.length() / 2;
        final String value2 = String.valueOf(String.valueOf(value.substring(0, n).hashCode()));
        value = String.valueOf(String.valueOf(value.substring(n).hashCode()));
        if (value.length() != 0) {
            return value2.concat(value);
        }
        return new String(value2);
    }
    
    private final File zze(final String s) {
        return new File(this.zzax, zzd(s));
    }
    
    static Map<String, String> zze(final InputStream inputStream) throws IOException {
        final int zzb = zzb(inputStream);
        Map<String, String> emptyMap;
        if (zzb == 0) {
            emptyMap = Collections.emptyMap();
        }
        else {
            emptyMap = new HashMap<String, String>(zzb);
        }
        for (int i = 0; i < zzb; ++i) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }
    
    @Override
    public final void initialize() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/android/gms/internal/zzag.zzax:Ljava/io/File;
        //     6: invokevirtual   java/io/File.exists:()Z
        //     9: ifne            44
        //    12: aload_0        
        //    13: getfield        com/google/android/gms/internal/zzag.zzax:Ljava/io/File;
        //    16: invokevirtual   java/io/File.mkdirs:()Z
        //    19: ifne            41
        //    22: ldc             "Unable to create cache dir %s"
        //    24: iconst_1       
        //    25: anewarray       Ljava/lang/Object;
        //    28: dup            
        //    29: iconst_0       
        //    30: aload_0        
        //    31: getfield        com/google/android/gms/internal/zzag.zzax:Ljava/io/File;
        //    34: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    37: aastore        
        //    38: invokestatic    com/google/android/gms/internal/zzab.zzc:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    41: aload_0        
        //    42: monitorexit    
        //    43: return         
        //    44: aload_0        
        //    45: getfield        com/google/android/gms/internal/zzag.zzax:Ljava/io/File;
        //    48: invokevirtual   java/io/File.listFiles:()[Ljava/io/File;
        //    51: astore          5
        //    53: aload           5
        //    55: ifnull          41
        //    58: aload           5
        //    60: arraylength    
        //    61: istore_2       
        //    62: iconst_0       
        //    63: istore_1       
        //    64: iload_1        
        //    65: iload_2        
        //    66: if_icmpge       41
        //    69: aload           5
        //    71: iload_1        
        //    72: aaload         
        //    73: astore          6
        //    75: aconst_null    
        //    76: astore_3       
        //    77: new             Ljava/io/BufferedInputStream;
        //    80: dup            
        //    81: new             Ljava/io/FileInputStream;
        //    84: dup            
        //    85: aload           6
        //    87: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    90: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    93: astore          4
        //    95: aload           4
        //    97: astore_3       
        //    98: aload           4
        //   100: invokestatic    com/google/android/gms/internal/zzai.zzf:(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzai;
        //   103: astore          7
        //   105: aload           4
        //   107: astore_3       
        //   108: aload           7
        //   110: aload           6
        //   112: invokevirtual   java/io/File.length:()J
        //   115: putfield        com/google/android/gms/internal/zzai.size:J
        //   118: aload           4
        //   120: astore_3       
        //   121: aload_0        
        //   122: aload           7
        //   124: getfield        com/google/android/gms/internal/zzai.key:Ljava/lang/String;
        //   127: aload           7
        //   129: invokespecial   com/google/android/gms/internal/zzag.zza:(Ljava/lang/String;Lcom/google/android/gms/internal/zzai;)V
        //   132: aload           4
        //   134: invokevirtual   java/io/BufferedInputStream.close:()V
        //   137: iload_1        
        //   138: iconst_1       
        //   139: iadd           
        //   140: istore_1       
        //   141: goto            64
        //   144: astore_3       
        //   145: aconst_null    
        //   146: astore          4
        //   148: aload           6
        //   150: ifnull          162
        //   153: aload           4
        //   155: astore_3       
        //   156: aload           6
        //   158: invokevirtual   java/io/File.delete:()Z
        //   161: pop            
        //   162: aload           4
        //   164: ifnull          137
        //   167: aload           4
        //   169: invokevirtual   java/io/BufferedInputStream.close:()V
        //   172: goto            137
        //   175: astore_3       
        //   176: goto            137
        //   179: astore          5
        //   181: aload_3        
        //   182: astore          4
        //   184: aload           5
        //   186: astore_3       
        //   187: aload           4
        //   189: ifnull          197
        //   192: aload           4
        //   194: invokevirtual   java/io/BufferedInputStream.close:()V
        //   197: aload_3        
        //   198: athrow         
        //   199: astore_3       
        //   200: aload_0        
        //   201: monitorexit    
        //   202: aload_3        
        //   203: athrow         
        //   204: astore_3       
        //   205: goto            137
        //   208: astore          4
        //   210: goto            197
        //   213: astore          5
        //   215: aload_3        
        //   216: astore          4
        //   218: aload           5
        //   220: astore_3       
        //   221: goto            187
        //   224: astore_3       
        //   225: goto            148
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      41     199    204    Any
        //  44     53     199    204    Any
        //  58     62     199    204    Any
        //  77     95     144    148    Ljava/io/IOException;
        //  77     95     179    187    Any
        //  98     105    224    228    Ljava/io/IOException;
        //  98     105    213    224    Any
        //  108    118    224    228    Ljava/io/IOException;
        //  108    118    213    224    Any
        //  121    132    224    228    Ljava/io/IOException;
        //  121    132    213    224    Any
        //  132    137    204    208    Ljava/io/IOException;
        //  132    137    199    204    Any
        //  156    162    213    224    Any
        //  167    172    175    179    Ljava/io/IOException;
        //  167    172    199    204    Any
        //  192    197    208    213    Ljava/io/IOException;
        //  192    197    199    204    Any
        //  197    199    199    204    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    public final zzc zza(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/android/gms/internal/zzag.zzav:Ljava/util/Map;
        //     6: aload_1        
        //     7: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    12: checkcast       Lcom/google/android/gms/internal/zzai;
        //    15: astore          6
        //    17: aload           6
        //    19: ifnonnull       28
        //    22: aconst_null    
        //    23: astore_1       
        //    24: aload_0        
        //    25: monitorexit    
        //    26: aload_1        
        //    27: areturn        
        //    28: aload_0        
        //    29: aload_1        
        //    30: invokespecial   com/google/android/gms/internal/zzag.zze:(Ljava/lang/String;)Ljava/io/File;
        //    33: astore          5
        //    35: new             Lcom/google/android/gms/internal/zzaj;
        //    38: dup            
        //    39: new             Ljava/io/BufferedInputStream;
        //    42: dup            
        //    43: new             Ljava/io/FileInputStream;
        //    46: dup            
        //    47: aload           5
        //    49: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    52: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    55: aconst_null    
        //    56: invokespecial   com/google/android/gms/internal/zzaj.<init>:(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzah;)V
        //    59: astore_3       
        //    60: aload_3        
        //    61: astore_2       
        //    62: aload_3        
        //    63: invokestatic    com/google/android/gms/internal/zzai.zzf:(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzai;
        //    66: pop            
        //    67: aload_3        
        //    68: astore_2       
        //    69: aload_3        
        //    70: aload           5
        //    72: invokevirtual   java/io/File.length:()J
        //    75: aload_3        
        //    76: invokestatic    com/google/android/gms/internal/zzaj.zza:(Lcom/google/android/gms/internal/zzaj;)I
        //    79: i2l            
        //    80: lsub           
        //    81: l2i            
        //    82: invokestatic    com/google/android/gms/internal/zzag.zza:(Ljava/io/InputStream;I)[B
        //    85: astore          7
        //    87: aload_3        
        //    88: astore_2       
        //    89: new             Lcom/google/android/gms/internal/zzc;
        //    92: dup            
        //    93: invokespecial   com/google/android/gms/internal/zzc.<init>:()V
        //    96: astore          4
        //    98: aload_3        
        //    99: astore_2       
        //   100: aload           4
        //   102: aload           7
        //   104: putfield        com/google/android/gms/internal/zzc.data:[B
        //   107: aload_3        
        //   108: astore_2       
        //   109: aload           4
        //   111: aload           6
        //   113: getfield        com/google/android/gms/internal/zzai.zza:Ljava/lang/String;
        //   116: putfield        com/google/android/gms/internal/zzc.zza:Ljava/lang/String;
        //   119: aload_3        
        //   120: astore_2       
        //   121: aload           4
        //   123: aload           6
        //   125: getfield        com/google/android/gms/internal/zzai.zzb:J
        //   128: putfield        com/google/android/gms/internal/zzc.zzb:J
        //   131: aload_3        
        //   132: astore_2       
        //   133: aload           4
        //   135: aload           6
        //   137: getfield        com/google/android/gms/internal/zzai.zzc:J
        //   140: putfield        com/google/android/gms/internal/zzc.zzc:J
        //   143: aload_3        
        //   144: astore_2       
        //   145: aload           4
        //   147: aload           6
        //   149: getfield        com/google/android/gms/internal/zzai.zzd:J
        //   152: putfield        com/google/android/gms/internal/zzc.zzd:J
        //   155: aload_3        
        //   156: astore_2       
        //   157: aload           4
        //   159: aload           6
        //   161: getfield        com/google/android/gms/internal/zzai.zze:J
        //   164: putfield        com/google/android/gms/internal/zzc.zze:J
        //   167: aload_3        
        //   168: astore_2       
        //   169: aload           4
        //   171: aload           6
        //   173: getfield        com/google/android/gms/internal/zzai.zzf:Ljava/util/Map;
        //   176: putfield        com/google/android/gms/internal/zzc.zzf:Ljava/util/Map;
        //   179: aload_3        
        //   180: invokevirtual   com/google/android/gms/internal/zzaj.close:()V
        //   183: aload           4
        //   185: astore_1       
        //   186: goto            24
        //   189: astore_1       
        //   190: aconst_null    
        //   191: astore_1       
        //   192: goto            24
        //   195: astore_3       
        //   196: aconst_null    
        //   197: astore_2       
        //   198: ldc_w           "%s: %s"
        //   201: iconst_2       
        //   202: anewarray       Ljava/lang/Object;
        //   205: dup            
        //   206: iconst_0       
        //   207: aload           5
        //   209: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   212: aastore        
        //   213: dup            
        //   214: iconst_1       
        //   215: aload_3        
        //   216: invokevirtual   java/io/IOException.toString:()Ljava/lang/String;
        //   219: aastore        
        //   220: invokestatic    com/google/android/gms/internal/zzab.zzb:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   223: aload_0        
        //   224: aload_1        
        //   225: invokespecial   com/google/android/gms/internal/zzag.remove:(Ljava/lang/String;)V
        //   228: aload_2        
        //   229: ifnull          236
        //   232: aload_2        
        //   233: invokevirtual   com/google/android/gms/internal/zzaj.close:()V
        //   236: aconst_null    
        //   237: astore_1       
        //   238: goto            24
        //   241: astore_1       
        //   242: aconst_null    
        //   243: astore_1       
        //   244: goto            24
        //   247: astore          4
        //   249: aconst_null    
        //   250: astore_3       
        //   251: aload_3        
        //   252: astore_2       
        //   253: ldc_w           "%s: %s"
        //   256: iconst_2       
        //   257: anewarray       Ljava/lang/Object;
        //   260: dup            
        //   261: iconst_0       
        //   262: aload           5
        //   264: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   267: aastore        
        //   268: dup            
        //   269: iconst_1       
        //   270: aload           4
        //   272: invokevirtual   java/lang/NegativeArraySizeException.toString:()Ljava/lang/String;
        //   275: aastore        
        //   276: invokestatic    com/google/android/gms/internal/zzab.zzb:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   279: aload_3        
        //   280: astore_2       
        //   281: aload_0        
        //   282: aload_1        
        //   283: invokespecial   com/google/android/gms/internal/zzag.remove:(Ljava/lang/String;)V
        //   286: aload_3        
        //   287: ifnull          294
        //   290: aload_3        
        //   291: invokevirtual   com/google/android/gms/internal/zzaj.close:()V
        //   294: aconst_null    
        //   295: astore_1       
        //   296: goto            24
        //   299: astore_1       
        //   300: aconst_null    
        //   301: astore_1       
        //   302: goto            24
        //   305: astore_1       
        //   306: aconst_null    
        //   307: astore_2       
        //   308: aload_2        
        //   309: ifnull          316
        //   312: aload_2        
        //   313: invokevirtual   com/google/android/gms/internal/zzaj.close:()V
        //   316: aload_1        
        //   317: athrow         
        //   318: astore_1       
        //   319: aload_0        
        //   320: monitorexit    
        //   321: aload_1        
        //   322: athrow         
        //   323: astore_1       
        //   324: aconst_null    
        //   325: astore_1       
        //   326: goto            24
        //   329: astore_1       
        //   330: goto            308
        //   333: astore_1       
        //   334: goto            308
        //   337: astore          4
        //   339: goto            251
        //   342: astore          4
        //   344: aload_3        
        //   345: astore_2       
        //   346: aload           4
        //   348: astore_3       
        //   349: goto            198
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  2      17     318    323    Any
        //  28     35     318    323    Any
        //  35     60     195    198    Ljava/io/IOException;
        //  35     60     247    251    Ljava/lang/NegativeArraySizeException;
        //  35     60     305    308    Any
        //  62     67     342    352    Ljava/io/IOException;
        //  62     67     337    342    Ljava/lang/NegativeArraySizeException;
        //  62     67     329    333    Any
        //  69     87     342    352    Ljava/io/IOException;
        //  69     87     337    342    Ljava/lang/NegativeArraySizeException;
        //  69     87     329    333    Any
        //  89     98     342    352    Ljava/io/IOException;
        //  89     98     337    342    Ljava/lang/NegativeArraySizeException;
        //  89     98     329    333    Any
        //  100    107    342    352    Ljava/io/IOException;
        //  100    107    337    342    Ljava/lang/NegativeArraySizeException;
        //  100    107    329    333    Any
        //  109    119    342    352    Ljava/io/IOException;
        //  109    119    337    342    Ljava/lang/NegativeArraySizeException;
        //  109    119    329    333    Any
        //  121    131    342    352    Ljava/io/IOException;
        //  121    131    337    342    Ljava/lang/NegativeArraySizeException;
        //  121    131    329    333    Any
        //  133    143    342    352    Ljava/io/IOException;
        //  133    143    337    342    Ljava/lang/NegativeArraySizeException;
        //  133    143    329    333    Any
        //  145    155    342    352    Ljava/io/IOException;
        //  145    155    337    342    Ljava/lang/NegativeArraySizeException;
        //  145    155    329    333    Any
        //  157    167    342    352    Ljava/io/IOException;
        //  157    167    337    342    Ljava/lang/NegativeArraySizeException;
        //  157    167    329    333    Any
        //  169    179    342    352    Ljava/io/IOException;
        //  169    179    337    342    Ljava/lang/NegativeArraySizeException;
        //  169    179    329    333    Any
        //  179    183    189    195    Ljava/io/IOException;
        //  179    183    318    323    Any
        //  198    228    333    337    Any
        //  232    236    241    247    Ljava/io/IOException;
        //  232    236    318    323    Any
        //  253    279    329    333    Any
        //  281    286    329    333    Any
        //  290    294    299    305    Ljava/io/IOException;
        //  290    294    318    323    Any
        //  312    316    323    329    Ljava/io/IOException;
        //  312    316    318    323    Any
        //  316    318    318    323    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0198:
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
    public final void zza(final String s, final zzc zzc) {
    Label_0163_Outer:
        while (true) {
            int i = 0;
            while (true) {
            Label_0381:
                while (true) {
                    Label_0378: {
                        Object o = null;
                        zzai zzai = null;
                        Label_0354: {
                            synchronized (this) {
                                final int length = zzc.data.length;
                                if (this.zzaw + length >= this.zzay) {
                                    if (zzab.DEBUG) {
                                        zzab.zza("Pruning old cache entries.", new Object[0]);
                                    }
                                    final long zzaw = this.zzaw;
                                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                                    final Object file = this.zzav.entrySet().iterator();
                                    if (!((Iterator)file).hasNext()) {
                                        break Label_0381;
                                    }
                                    o = ((Iterator<Map.Entry<K, zzai>>)file).next().getValue();
                                    if (this.zze(((zzai)o).key).delete()) {
                                        this.zzaw -= ((zzai)o).size;
                                    }
                                    else {
                                        zzab.zzb("Could not delete cache entry for key=%s, filename=%s", ((zzai)o).key, zzd(((zzai)o).key));
                                    }
                                    ((Iterator)file).remove();
                                    ++i;
                                    if (this.zzaw + length >= this.zzay * 0.9f) {
                                        break Label_0378;
                                    }
                                    if (zzab.DEBUG) {
                                        zzab.zza("pruned %d files, %d bytes, %d ms", i, this.zzaw - zzaw, SystemClock.elapsedRealtime() - elapsedRealtime);
                                    }
                                }
                                final Object file = this.zze(s);
                                try {
                                    o = new BufferedOutputStream(new FileOutputStream((File)file));
                                    zzai = new zzai(s, zzc);
                                    if (!zzai.zza((OutputStream)o)) {
                                        ((BufferedOutputStream)o).close();
                                        zzab.zzb("Failed to write header for %s", ((File)file).getAbsolutePath());
                                        throw new IOException();
                                    }
                                    break Label_0354;
                                }
                                catch (IOException ex) {
                                    if (!((File)file).delete()) {
                                        zzab.zzb("Could not clean up file %s", ((File)file).getAbsolutePath());
                                    }
                                }
                                return;
                            }
                        }
                        ((FilterOutputStream)o).write(zzc.data);
                        ((BufferedOutputStream)o).close();
                        this.zza(s, zzai);
                        return;
                    }
                    continue Label_0163_Outer;
                }
                continue;
            }
        }
    }
}
