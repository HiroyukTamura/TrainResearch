// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import com.google.android.gms.measurement.AppMeasurement;
import android.support.v4.util.ArrayMap;
import java.util.Map;

public final class zzcgf extends zzchj
{
    private final Map<String, Map<String, String>> zzbrQ;
    private final Map<String, Map<String, Boolean>> zzbrR;
    private final Map<String, Map<String, Boolean>> zzbrS;
    private final Map<String, zzcjt> zzbrT;
    private final Map<String, String> zzbrU;
    
    zzcgf(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbrQ = new ArrayMap<String, Map<String, String>>();
        this.zzbrR = new ArrayMap<String, Map<String, Boolean>>();
        this.zzbrS = new ArrayMap<String, Map<String, Boolean>>();
        this.zzbrT = new ArrayMap<String, zzcjt>();
        this.zzbrU = new ArrayMap<String, String>();
    }
    
    private static Map<String, String> zza(final zzcjt zzcjt) {
        final ArrayMap<String, String> arrayMap = new ArrayMap<String, String>();
        if (zzcjt != null && zzcjt.zzbvn != null) {
            final zzcju[] zzbvn = zzcjt.zzbvn;
            for (int length = zzbvn.length, i = 0; i < length; ++i) {
                final zzcju zzcju = zzbvn[i];
                if (zzcju != null) {
                    arrayMap.put(zzcju.key, zzcju.value);
                }
            }
        }
        return arrayMap;
    }
    
    private final void zza(final String s, final zzcjt zzcjt) {
        final ArrayMap<String, Boolean> arrayMap = new ArrayMap<String, Boolean>();
        final ArrayMap<String, Boolean> arrayMap2 = new ArrayMap<String, Boolean>();
        if (zzcjt != null && zzcjt.zzbvo != null) {
            final zzcjs[] zzbvo = zzcjt.zzbvo;
            for (int length = zzbvo.length, i = 0; i < length; ++i) {
                final zzcjs zzcjs = zzbvo[i];
                if (zzcjs != null) {
                    final String zzdF = AppMeasurement.Event.zzdF(zzcjs.name);
                    if (zzdF != null) {
                        zzcjs.name = zzdF;
                    }
                    arrayMap.put(zzcjs.name, zzcjs.zzbvj);
                    arrayMap2.put(zzcjs.name, zzcjs.zzbvk);
                }
            }
        }
        this.zzbrR.put(s, arrayMap);
        this.zzbrS.put(s, arrayMap2);
    }
    
    @WorkerThread
    private final zzcjt zzc(final String s, final byte[] array) {
        if (array == null) {
            return new zzcjt();
        }
        final adg zzb = adg.zzb(array, 0, array.length);
        final zzcjt zzcjt = new zzcjt();
        try {
            zzcjt.zza(zzb);
            super.zzwF().zzyD().zze("Parsed config. version, gmp_app_id", zzcjt.zzbvl, zzcjt.zzboQ);
            return zzcjt;
        }
        catch (IOException ex) {
            super.zzwF().zzyz().zze("Unable to merge remote config. appId", zzcfl.zzdZ(s), ex);
            return new zzcjt();
        }
    }
    
    @WorkerThread
    private final void zzeg(final String s) {
        this.zzkD();
        super.zzjC();
        zzbo.zzcF(s);
        if (this.zzbrT.get(s) == null) {
            final byte[] zzdS = super.zzwz().zzdS(s);
            if (zzdS != null) {
                final zzcjt zzc = this.zzc(s, zzdS);
                this.zzbrQ.put(s, zza(zzc));
                this.zza(s, zzc);
                this.zzbrT.put(s, zzc);
                this.zzbrU.put(s, null);
                return;
            }
            this.zzbrQ.put(s, null);
            this.zzbrR.put(s, null);
            this.zzbrS.put(s, null);
            this.zzbrT.put(s, null);
            this.zzbrU.put(s, null);
        }
    }
    
    @WorkerThread
    final String zzM(final String s, final String s2) {
        super.zzjC();
        this.zzeg(s);
        final Map<String, String> map = this.zzbrQ.get(s);
        if (map != null) {
            return map.get(s2);
        }
        return null;
    }
    
    @WorkerThread
    final boolean zzN(final String s, final String s2) {
        super.zzjC();
        this.zzeg(s);
        if ((super.zzwB().zzeA(s) && zzcjl.zzex(s2)) || (super.zzwB().zzeB(s) && zzcjl.zzeo(s2))) {
            return true;
        }
        final Map<String, Boolean> map = this.zzbrR.get(s);
        if (map != null) {
            final Boolean b = map.get(s2);
            return b != null && b;
        }
        return false;
    }
    
    @WorkerThread
    final boolean zzO(final String s, final String anObject) {
        super.zzjC();
        this.zzeg(s);
        if ("ecommerce_purchase".equals(anObject)) {
            return true;
        }
        final Map<String, Boolean> map = this.zzbrS.get(s);
        if (map != null) {
            final Boolean b = map.get(anObject);
            return b != null && b;
        }
        return false;
    }
    
    @WorkerThread
    protected final boolean zzb(final String p0, final byte[] p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/android/gms/internal/zzcgf.zzkD:()V
        //     4: aload_0        
        //     5: invokespecial   com/google/android/gms/internal/zzchj.zzjC:()V
        //     8: aload_1        
        //     9: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    12: pop            
        //    13: aload_0        
        //    14: aload_1        
        //    15: aload_2        
        //    16: invokespecial   com/google/android/gms/internal/zzcgf.zzc:(Ljava/lang/String;[B)Lcom/google/android/gms/internal/zzcjt;
        //    19: astore          10
        //    21: aload           10
        //    23: ifnonnull       28
        //    26: iconst_0       
        //    27: ireturn        
        //    28: aload_0        
        //    29: aload_1        
        //    30: aload           10
        //    32: invokespecial   com/google/android/gms/internal/zzcgf.zza:(Ljava/lang/String;Lcom/google/android/gms/internal/zzcjt;)V
        //    35: aload_0        
        //    36: getfield        com/google/android/gms/internal/zzcgf.zzbrT:Ljava/util/Map;
        //    39: aload_1        
        //    40: aload           10
        //    42: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    47: pop            
        //    48: aload_0        
        //    49: getfield        com/google/android/gms/internal/zzcgf.zzbrU:Ljava/util/Map;
        //    52: aload_1        
        //    53: aload_3        
        //    54: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    59: pop            
        //    60: aload_0        
        //    61: getfield        com/google/android/gms/internal/zzcgf.zzbrQ:Ljava/util/Map;
        //    64: aload_1        
        //    65: aload           10
        //    67: invokestatic    com/google/android/gms/internal/zzcgf.zza:(Lcom/google/android/gms/internal/zzcjt;)Ljava/util/Map;
        //    70: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    75: pop            
        //    76: aload_0        
        //    77: invokespecial   com/google/android/gms/internal/zzchj.zzws:()Lcom/google/android/gms/internal/zzcej;
        //    80: astore_3       
        //    81: aload           10
        //    83: getfield        com/google/android/gms/internal/zzcjt.zzbvp:[Lcom/google/android/gms/internal/zzcjm;
        //    86: astore          11
        //    88: aload           11
        //    90: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    93: pop            
        //    94: aload           11
        //    96: arraylength    
        //    97: istore          7
        //    99: iconst_0       
        //   100: istore          4
        //   102: iload           4
        //   104: iload           7
        //   106: if_icmpge       305
        //   109: aload           11
        //   111: iload           4
        //   113: aaload         
        //   114: astore          12
        //   116: aload           12
        //   118: getfield        com/google/android/gms/internal/zzcjm.zzbuK:[Lcom/google/android/gms/internal/zzcjn;
        //   121: astore          13
        //   123: aload           13
        //   125: arraylength    
        //   126: istore          8
        //   128: iconst_0       
        //   129: istore          5
        //   131: iload           5
        //   133: iload           8
        //   135: if_icmpge       236
        //   138: aload           13
        //   140: iload           5
        //   142: aaload         
        //   143: astore          14
        //   145: aload           14
        //   147: getfield        com/google/android/gms/internal/zzcjn.zzbuN:Ljava/lang/String;
        //   150: invokestatic    com/google/android/gms/measurement/AppMeasurement$Event.zzdF:(Ljava/lang/String;)Ljava/lang/String;
        //   153: astore          15
        //   155: aload           15
        //   157: ifnull          167
        //   160: aload           14
        //   162: aload           15
        //   164: putfield        com/google/android/gms/internal/zzcjn.zzbuN:Ljava/lang/String;
        //   167: aload           14
        //   169: getfield        com/google/android/gms/internal/zzcjn.zzbuO:[Lcom/google/android/gms/internal/zzcjo;
        //   172: astore          14
        //   174: aload           14
        //   176: arraylength    
        //   177: istore          9
        //   179: iconst_0       
        //   180: istore          6
        //   182: iload           6
        //   184: iload           9
        //   186: if_icmpge       227
        //   189: aload           14
        //   191: iload           6
        //   193: aaload         
        //   194: astore          15
        //   196: aload           15
        //   198: getfield        com/google/android/gms/internal/zzcjo.zzbuV:Ljava/lang/String;
        //   201: invokestatic    com/google/android/gms/measurement/AppMeasurement$Param.zzdF:(Ljava/lang/String;)Ljava/lang/String;
        //   204: astore          16
        //   206: aload           16
        //   208: ifnull          218
        //   211: aload           15
        //   213: aload           16
        //   215: putfield        com/google/android/gms/internal/zzcjo.zzbuV:Ljava/lang/String;
        //   218: iload           6
        //   220: iconst_1       
        //   221: iadd           
        //   222: istore          6
        //   224: goto            182
        //   227: iload           5
        //   229: iconst_1       
        //   230: iadd           
        //   231: istore          5
        //   233: goto            131
        //   236: aload           12
        //   238: getfield        com/google/android/gms/internal/zzcjm.zzbuJ:[Lcom/google/android/gms/internal/zzcjq;
        //   241: astore          12
        //   243: aload           12
        //   245: arraylength    
        //   246: istore          6
        //   248: iconst_0       
        //   249: istore          5
        //   251: iload           5
        //   253: iload           6
        //   255: if_icmpge       296
        //   258: aload           12
        //   260: iload           5
        //   262: aaload         
        //   263: astore          13
        //   265: aload           13
        //   267: getfield        com/google/android/gms/internal/zzcjq.zzbvc:Ljava/lang/String;
        //   270: invokestatic    com/google/android/gms/measurement/AppMeasurement$UserProperty.zzdF:(Ljava/lang/String;)Ljava/lang/String;
        //   273: astore          14
        //   275: aload           14
        //   277: ifnull          287
        //   280: aload           13
        //   282: aload           14
        //   284: putfield        com/google/android/gms/internal/zzcjq.zzbvc:Ljava/lang/String;
        //   287: iload           5
        //   289: iconst_1       
        //   290: iadd           
        //   291: istore          5
        //   293: goto            251
        //   296: iload           4
        //   298: iconst_1       
        //   299: iadd           
        //   300: istore          4
        //   302: goto            102
        //   305: aload_3        
        //   306: invokevirtual   com/google/android/gms/internal/zzcej.zzwz:()Lcom/google/android/gms/internal/zzcen;
        //   309: aload_1        
        //   310: aload           11
        //   312: invokevirtual   com/google/android/gms/internal/zzcen.zza:(Ljava/lang/String;[Lcom/google/android/gms/internal/zzcjm;)V
        //   315: aload           10
        //   317: aconst_null    
        //   318: putfield        com/google/android/gms/internal/zzcjt.zzbvp:[Lcom/google/android/gms/internal/zzcjm;
        //   321: aload           10
        //   323: invokevirtual   com/google/android/gms/internal/zzcjt.zzLV:()I
        //   326: newarray        B
        //   328: astore_3       
        //   329: aload           10
        //   331: aload_3        
        //   332: iconst_0       
        //   333: aload_3        
        //   334: arraylength    
        //   335: invokestatic    com/google/android/gms/internal/adh.zzc:([BII)Lcom/google/android/gms/internal/adh;
        //   338: invokevirtual   com/google/android/gms/internal/zzcjt.zza:(Lcom/google/android/gms/internal/adh;)V
        //   341: aload_3        
        //   342: astore_2       
        //   343: aload_0        
        //   344: invokespecial   com/google/android/gms/internal/zzchj.zzwz:()Lcom/google/android/gms/internal/zzcen;
        //   347: astore_3       
        //   348: aload_1        
        //   349: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //   352: pop            
        //   353: aload_3        
        //   354: invokevirtual   com/google/android/gms/internal/zzcen.zzjC:()V
        //   357: aload_3        
        //   358: invokevirtual   com/google/android/gms/internal/zzcen.zzkD:()V
        //   361: new             Landroid/content/ContentValues;
        //   364: dup            
        //   365: invokespecial   android/content/ContentValues.<init>:()V
        //   368: astore          10
        //   370: aload           10
        //   372: ldc_w           "remote_config"
        //   375: aload_2        
        //   376: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;[B)V
        //   379: aload_3        
        //   380: invokevirtual   com/google/android/gms/internal/zzcen.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //   383: ldc_w           "apps"
        //   386: aload           10
        //   388: ldc_w           "app_id = ?"
        //   391: iconst_1       
        //   392: anewarray       Ljava/lang/String;
        //   395: dup            
        //   396: iconst_0       
        //   397: aload_1        
        //   398: aastore        
        //   399: invokevirtual   android/database/sqlite/SQLiteDatabase.update:(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   402: i2l            
        //   403: lconst_0       
        //   404: lcmp           
        //   405: ifne            425
        //   408: aload_3        
        //   409: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   412: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   415: ldc_w           "Failed to update remote config (got 0). appId"
        //   418: aload_1        
        //   419: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   422: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   425: iconst_1       
        //   426: ireturn        
        //   427: astore_3       
        //   428: aload_0        
        //   429: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   432: invokevirtual   com/google/android/gms/internal/zzcfl.zzyz:()Lcom/google/android/gms/internal/zzcfn;
        //   435: ldc_w           "Unable to serialize reduced-size config. Storing full config instead. appId"
        //   438: aload_1        
        //   439: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   442: aload_3        
        //   443: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   446: goto            343
        //   449: astore_2       
        //   450: aload_3        
        //   451: invokevirtual   com/google/android/gms/internal/zzcen.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   454: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   457: ldc_w           "Error storing remote config. appId"
        //   460: aload_1        
        //   461: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   464: aload_2        
        //   465: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   468: goto            425
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  315    341    427    449    Ljava/io/IOException;
        //  379    425    449    471    Landroid/database/sqlite/SQLiteException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0425:
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
    
    @WorkerThread
    protected final zzcjt zzeh(final String s) {
        this.zzkD();
        super.zzjC();
        zzbo.zzcF(s);
        this.zzeg(s);
        return this.zzbrT.get(s);
    }
    
    @WorkerThread
    protected final String zzei(final String s) {
        super.zzjC();
        return this.zzbrU.get(s);
    }
    
    @WorkerThread
    protected final void zzej(final String s) {
        super.zzjC();
        this.zzbrU.put(s, null);
    }
    
    @WorkerThread
    final void zzek(final String s) {
        super.zzjC();
        this.zzbrT.remove(s);
    }
    
    @Override
    protected final void zzjD() {
    }
}
