// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import java.util.Collections;
import com.google.android.gms.common.zzc;
import android.content.Intent;
import android.app.PendingIntent;
import android.support.annotation.WorkerThread;
import android.os.RemoteException;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import android.support.annotation.NonNull;
import android.os.IBinder;
import android.support.annotation.CallSuper;
import android.accounts.Account;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.text.TextUtils;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.content.ServiceConnection;
import android.util.Log;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import com.google.android.gms.common.zze;
import android.os.Handler;
import android.content.Context;
import android.os.IInterface;

public abstract class zzd<T extends IInterface>
{
    private static String[] zzaHc;
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final zze zzaCF;
    private int zzaGH;
    private long zzaGI;
    private long zzaGJ;
    private int zzaGK;
    private long zzaGL;
    private zzak zzaGM;
    private final zzae zzaGN;
    private final Object zzaGO;
    private zzaw zzaGP;
    protected zzj zzaGQ;
    private T zzaGR;
    private final ArrayList<zzi<?>> zzaGS;
    private zzl zzaGT;
    private int zzaGU;
    private final zzf zzaGV;
    private final zzg zzaGW;
    private final int zzaGX;
    private final String zzaGY;
    private ConnectionResult zzaGZ;
    private boolean zzaHa;
    protected AtomicInteger zzaHb;
    private final Looper zzrM;
    
    static {
        zzd.zzaHc = new String[] { "service_esmobile", "service_googleme" };
    }
    
    protected zzd(final Context context, final Looper looper, final int n, final zzf zzf, final zzg zzg, final String s) {
        this(context, looper, zzae.zzaC(context), zze.zzoW(), n, zzbo.zzu(zzf), zzbo.zzu(zzg), null);
    }
    
    protected zzd(final Context context, final Looper looper, final zzae zzae, final zze zze, final int zzaGX, final zzf zzaGV, final zzg zzaGW, final String zzaGY) {
        this.mLock = new Object();
        this.zzaGO = new Object();
        this.zzaGS = new ArrayList<zzi<?>>();
        this.zzaGU = 1;
        this.zzaGZ = null;
        this.zzaHa = false;
        this.zzaHb = new AtomicInteger(0);
        this.mContext = zzbo.zzb(context, "Context must not be null");
        this.zzrM = zzbo.zzb(looper, "Looper must not be null");
        this.zzaGN = zzbo.zzb(zzae, "Supervisor must not be null");
        this.zzaCF = zzbo.zzb(zze, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzaGX = zzaGX;
        this.zzaGV = zzaGV;
        this.zzaGW = zzaGW;
        this.zzaGY = zzaGY;
    }
    
    private final void zza(final int zzaGU, final T zzaGR) {
        boolean b = true;
        int n;
        if (zzaGU == 4) {
            n = 1;
        }
        else {
            n = 0;
        }
        int n2;
        if (zzaGR != null) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n != n2) {
            b = false;
        }
        while (true) {
            zzbo.zzaf(b);
            Label_0416: {
                synchronized (this.mLock) {
                    this.zzaGU = zzaGU;
                    this.zzaGR = zzaGR;
                    switch (zzaGU) {
                        case 2:
                        case 3: {
                            if (this.zzaGT != null && this.zzaGM != null) {
                                final String value = String.valueOf(this.zzaGM.zzrE());
                                final String value2 = String.valueOf(this.zzaGM.getPackageName());
                                Log.e("GmsClient", new StringBuilder(String.valueOf(value).length() + 70 + String.valueOf(value2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(value).append(" on ").append(value2).toString());
                                this.zzaGN.zza(this.zzaGM.zzrE(), this.zzaGM.getPackageName(), (ServiceConnection)this.zzaGT, this.zzra());
                                this.zzaHb.incrementAndGet();
                            }
                            this.zzaGT = new zzl(this, this.zzaHb.get());
                            this.zzaGM = new zzak(this.zzqZ(), this.zzdb(), false);
                            if (!this.zzaGN.zza(new zzaf(this.zzaGM.zzrE(), this.zzaGM.getPackageName()), (ServiceConnection)this.zzaGT, this.zzra())) {
                                final String value3 = String.valueOf(this.zzaGM.zzrE());
                                final String value4 = String.valueOf(this.zzaGM.getPackageName());
                                Log.e("GmsClient", new StringBuilder(String.valueOf(value3).length() + 34 + String.valueOf(value4).length()).append("unable to connect to service: ").append(value3).append(" on ").append(value4).toString());
                                this.zza(16, null, this.zzaHb.get());
                            }
                            return;
                        }
                        case 4: {
                            break;
                        }
                        case 1: {
                            break Label_0416;
                        }
                        default: {
                            return;
                        }
                    }
                }
                this.zza(zzaGR);
                return;
            }
            if (this.zzaGT != null) {
                this.zzaGN.zza(this.zzdb(), this.zzqZ(), (ServiceConnection)this.zzaGT, this.zzra());
                this.zzaGT = null;
            }
        }
    }
    
    private final boolean zza(final int n, final int n2, final T t) {
        synchronized (this.mLock) {
            if (this.zzaGU != n) {
                return false;
            }
            this.zza(n2, t);
            return true;
        }
    }
    
    private final void zzaz(int n) {
        if (this.zzrc()) {
            n = 5;
            this.zzaHa = true;
        }
        else {
            n = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(n, this.zzaHb.get(), 16));
    }
    
    @Nullable
    private final String zzra() {
        if (this.zzaGY == null) {
            return this.mContext.getClass().getName();
        }
        return this.zzaGY;
    }
    
    private final boolean zzrc() {
        while (true) {
            synchronized (this.mLock) {
                if (this.zzaGU == 3) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private final boolean zzri() {
        if (this.zzaHa || TextUtils.isEmpty((CharSequence)this.zzdc()) || TextUtils.isEmpty((CharSequence)null)) {
            return false;
        }
        try {
            Class.forName(this.zzdc());
            return true;
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
    public void disconnect() {
        this.zzaHb.incrementAndGet();
        Object o = this.zzaGS;
        synchronized (o) {
            for (int size = this.zzaGS.size(), i = 0; i < size; ++i) {
                this.zzaGS.get(i).removeListener();
            }
            this.zzaGS.clear();
            // monitorexit(o)
            o = this.zzaGO;
            // monitorenter(o)
            final zzd zzd = this;
            final zzaw zzaw = null;
            zzd.zzaGP = zzaw;
            final Object o2 = o;
            // monitorexit(o2)
            final zzd zzd2 = this;
            final int n = 1;
            final IInterface interface1 = null;
            zzd2.zza(n, (T)interface1);
            return;
        }
        try {
            final zzd zzd = this;
            final zzaw zzaw = null;
            zzd.zzaGP = zzaw;
            final Object o2 = o;
            // monitorexit(o2)
            final zzd zzd2 = this;
            final int n = 1;
            final IInterface interface1 = null;
            zzd2.zza(n, (T)interface1);
        }
        finally {
        }
        // monitorexit(o)
    }
    
    public final void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/common/internal/zzd.mLock:Ljava/lang/Object;
        //     4: astore          4
        //     6: aload           4
        //     8: monitorenter   
        //     9: aload_0        
        //    10: getfield        com/google/android/gms/common/internal/zzd.zzaGU:I
        //    13: istore          5
        //    15: aload_0        
        //    16: getfield        com/google/android/gms/common/internal/zzd.zzaGR:Landroid/os/IInterface;
        //    19: astore_2       
        //    20: aload           4
        //    22: monitorexit    
        //    23: aload_0        
        //    24: getfield        com/google/android/gms/common/internal/zzd.zzaGO:Ljava/lang/Object;
        //    27: astore          4
        //    29: aload           4
        //    31: monitorenter   
        //    32: aload_0        
        //    33: getfield        com/google/android/gms/common/internal/zzd.zzaGP:Lcom/google/android/gms/common/internal/zzaw;
        //    36: astore          8
        //    38: aload           4
        //    40: monitorexit    
        //    41: aload_3        
        //    42: aload_1        
        //    43: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //    46: ldc_w           "mConnectState="
        //    49: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //    52: pop            
        //    53: iload           5
        //    55: tableswitch {
        //                2: 533
        //                3: 493
        //                4: 503
        //                5: 513
        //                6: 523
        //          default: 88
        //        }
        //    88: aload_3        
        //    89: ldc_w           "UNKNOWN"
        //    92: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //    95: aload_3        
        //    96: ldc_w           " mService="
        //    99: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   102: pop            
        //   103: aload_2        
        //   104: ifnonnull       543
        //   107: aload_3        
        //   108: ldc_w           "null"
        //   111: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   114: pop            
        //   115: aload_3        
        //   116: ldc_w           " mServiceBroker="
        //   119: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   122: pop            
        //   123: aload           8
        //   125: ifnonnull       576
        //   128: aload_3        
        //   129: ldc_w           "null"
        //   132: invokevirtual   java/io/PrintWriter.println:(Ljava/lang/String;)V
        //   135: new             Ljava/text/SimpleDateFormat;
        //   138: dup            
        //   139: ldc_w           "yyyy-MM-dd HH:mm:ss.SSS"
        //   142: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //   145: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;Ljava/util/Locale;)V
        //   148: astore_2       
        //   149: aload_0        
        //   150: getfield        com/google/android/gms/common/internal/zzd.zzaGJ:J
        //   153: lconst_0       
        //   154: lcmp           
        //   155: ifle            239
        //   158: aload_3        
        //   159: aload_1        
        //   160: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   163: ldc_w           "lastConnectedTime="
        //   166: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   169: astore          4
        //   171: aload_0        
        //   172: getfield        com/google/android/gms/common/internal/zzd.zzaGJ:J
        //   175: lstore          6
        //   177: aload_2        
        //   178: new             Ljava/util/Date;
        //   181: dup            
        //   182: aload_0        
        //   183: getfield        com/google/android/gms/common/internal/zzd.zzaGJ:J
        //   186: invokespecial   java/util/Date.<init>:(J)V
        //   189: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //   192: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   195: astore          8
        //   197: aload           4
        //   199: new             Ljava/lang/StringBuilder;
        //   202: dup            
        //   203: aload           8
        //   205: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   208: invokevirtual   java/lang/String.length:()I
        //   211: bipush          21
        //   213: iadd           
        //   214: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   217: lload           6
        //   219: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   222: ldc_w           " "
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: aload           8
        //   230: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   233: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   236: invokevirtual   java/io/PrintWriter.println:(Ljava/lang/String;)V
        //   239: aload_0        
        //   240: getfield        com/google/android/gms/common/internal/zzd.zzaGI:J
        //   243: lconst_0       
        //   244: lcmp           
        //   245: ifle            377
        //   248: aload_3        
        //   249: aload_1        
        //   250: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   253: ldc_w           "lastSuspendedCause="
        //   256: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   259: pop            
        //   260: aload_0        
        //   261: getfield        com/google/android/gms/common/internal/zzd.zzaGH:I
        //   264: tableswitch {
        //                2: 602
        //                3: 613
        //          default: 288
        //        }
        //   288: aload_3        
        //   289: aload_0        
        //   290: getfield        com/google/android/gms/common/internal/zzd.zzaGH:I
        //   293: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //   296: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   299: pop            
        //   300: aload_3        
        //   301: ldc_w           " lastSuspendedTime="
        //   304: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   307: astore          4
        //   309: aload_0        
        //   310: getfield        com/google/android/gms/common/internal/zzd.zzaGI:J
        //   313: lstore          6
        //   315: aload_2        
        //   316: new             Ljava/util/Date;
        //   319: dup            
        //   320: aload_0        
        //   321: getfield        com/google/android/gms/common/internal/zzd.zzaGI:J
        //   324: invokespecial   java/util/Date.<init>:(J)V
        //   327: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //   330: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   333: astore          8
        //   335: aload           4
        //   337: new             Ljava/lang/StringBuilder;
        //   340: dup            
        //   341: aload           8
        //   343: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   346: invokevirtual   java/lang/String.length:()I
        //   349: bipush          21
        //   351: iadd           
        //   352: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   355: lload           6
        //   357: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   360: ldc_w           " "
        //   363: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   366: aload           8
        //   368: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   371: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   374: invokevirtual   java/io/PrintWriter.println:(Ljava/lang/String;)V
        //   377: aload_0        
        //   378: getfield        com/google/android/gms/common/internal/zzd.zzaGL:J
        //   381: lconst_0       
        //   382: lcmp           
        //   383: ifle            480
        //   386: aload_3        
        //   387: aload_1        
        //   388: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   391: ldc_w           "lastFailedStatus="
        //   394: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   397: aload_0        
        //   398: getfield        com/google/android/gms/common/internal/zzd.zzaGK:I
        //   401: invokestatic    com/google/android/gms/common/api/CommonStatusCodes.getStatusCodeString:(I)Ljava/lang/String;
        //   404: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   407: pop            
        //   408: aload_3        
        //   409: ldc_w           " lastFailedTime="
        //   412: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   415: astore_1       
        //   416: aload_0        
        //   417: getfield        com/google/android/gms/common/internal/zzd.zzaGL:J
        //   420: lstore          6
        //   422: aload_2        
        //   423: new             Ljava/util/Date;
        //   426: dup            
        //   427: aload_0        
        //   428: getfield        com/google/android/gms/common/internal/zzd.zzaGL:J
        //   431: invokespecial   java/util/Date.<init>:(J)V
        //   434: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //   437: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   440: astore_2       
        //   441: aload_1        
        //   442: new             Ljava/lang/StringBuilder;
        //   445: dup            
        //   446: aload_2        
        //   447: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   450: invokevirtual   java/lang/String.length:()I
        //   453: bipush          21
        //   455: iadd           
        //   456: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   459: lload           6
        //   461: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   464: ldc_w           " "
        //   467: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   470: aload_2        
        //   471: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   474: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   477: invokevirtual   java/io/PrintWriter.println:(Ljava/lang/String;)V
        //   480: return         
        //   481: astore_1       
        //   482: aload           4
        //   484: monitorexit    
        //   485: aload_1        
        //   486: athrow         
        //   487: astore_1       
        //   488: aload           4
        //   490: monitorexit    
        //   491: aload_1        
        //   492: athrow         
        //   493: aload_3        
        //   494: ldc_w           "REMOTE_CONNECTING"
        //   497: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   500: goto            95
        //   503: aload_3        
        //   504: ldc_w           "LOCAL_CONNECTING"
        //   507: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   510: goto            95
        //   513: aload_3        
        //   514: ldc_w           "CONNECTED"
        //   517: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   520: goto            95
        //   523: aload_3        
        //   524: ldc_w           "DISCONNECTING"
        //   527: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   530: goto            95
        //   533: aload_3        
        //   534: ldc_w           "DISCONNECTED"
        //   537: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   540: goto            95
        //   543: aload_3        
        //   544: aload_0        
        //   545: invokevirtual   com/google/android/gms/common/internal/zzd.zzdc:()Ljava/lang/String;
        //   548: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   551: ldc_w           "@"
        //   554: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   557: aload_2        
        //   558: invokeinterface android/os/IInterface.asBinder:()Landroid/os/IBinder;
        //   563: invokestatic    java/lang/System.identityHashCode:(Ljava/lang/Object;)I
        //   566: invokestatic    java/lang/Integer.toHexString:(I)Ljava/lang/String;
        //   569: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   572: pop            
        //   573: goto            115
        //   576: aload_3        
        //   577: ldc_w           "IGmsServiceBroker@"
        //   580: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   583: aload           8
        //   585: invokeinterface com/google/android/gms/common/internal/zzaw.asBinder:()Landroid/os/IBinder;
        //   590: invokestatic    java/lang/System.identityHashCode:(Ljava/lang/Object;)I
        //   593: invokestatic    java/lang/Integer.toHexString:(I)Ljava/lang/String;
        //   596: invokevirtual   java/io/PrintWriter.println:(Ljava/lang/String;)V
        //   599: goto            135
        //   602: aload_3        
        //   603: ldc_w           "CAUSE_SERVICE_DISCONNECTED"
        //   606: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   609: pop            
        //   610: goto            300
        //   613: aload_3        
        //   614: ldc_w           "CAUSE_NETWORK_LOST"
        //   617: invokevirtual   java/io/PrintWriter.append:(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
        //   620: pop            
        //   621: goto            300
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  9      23     481    487    Any
        //  32     41     487    493    Any
        //  482    485    481    487    Any
        //  488    491    487    493    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0088:
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
    
    public Account getAccount() {
        return null;
    }
    
    public final Context getContext() {
        return this.mContext;
    }
    
    public final Looper getLooper() {
        return this.zzrM;
    }
    
    public final boolean isConnected() {
        while (true) {
            synchronized (this.mLock) {
                if (this.zzaGU == 4) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public final boolean isConnecting() {
        while (true) {
            synchronized (this.mLock) {
                if (this.zzaGU == 2) {
                    return true;
                }
                if (this.zzaGU == 3) {
                    return true;
                }
                return false;
            }
            return true;
            b = false;
            return b;
        }
    }
    
    @CallSuper
    protected void onConnectionFailed(final ConnectionResult connectionResult) {
        this.zzaGK = connectionResult.getErrorCode();
        this.zzaGL = System.currentTimeMillis();
    }
    
    @CallSuper
    protected final void onConnectionSuspended(final int zzaGH) {
        this.zzaGH = zzaGH;
        this.zzaGI = System.currentTimeMillis();
    }
    
    protected final void zza(final int n, @Nullable final Bundle bundle, final int n2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, n2, -1, (Object)new zzo(this, n, null)));
    }
    
    protected void zza(final int n, final IBinder binder, final Bundle bundle, final int n2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, n2, -1, (Object)new zzn(this, n, binder, bundle)));
    }
    
    @CallSuper
    protected void zza(@NonNull final T t) {
        this.zzaGJ = System.currentTimeMillis();
    }
    
    @WorkerThread
    public final void zza(final zzal ex, final Set<Scope> set) {
        final Bundle zzmo = this.zzmo();
        final zzx zzx = new zzx(this.zzaGX);
        zzx.zzaHw = this.mContext.getPackageName();
        zzx.zzaHz = zzmo;
        if (set != null) {
            zzx.zzaHy = (Scope[])set.toArray((Object[])new Scope[set.size()]);
        }
        while (true) {
            Account account = null;
            Label_0166: {
                if (!this.zzmv()) {
                    break Label_0166;
                }
                if (this.getAccount() != null) {
                    account = this.getAccount();
                    break Label_0166;
                }
                Label_0149: {
                    break Label_0149;
                    while (true) {
                        zzx.zzaHB = this.zzrd();
                        try {
                            synchronized (this.zzaGO) {
                                if (this.zzaGP != null) {
                                    this.zzaGP.zza(new zzk(this, this.zzaHb.get()), zzx);
                                }
                                else {
                                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                                }
                                return;
                                final Account account2 = new Account("<<default account>>", "com.google");
                                break;
                                zzx.zzaHA = this.getAccount();
                                continue;
                            }
                            // iftrue(Label_0099:, !this.zzrg())
                        }
                        catch (DeadObjectException ex2) {
                            Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)ex2);
                            this.zzay(1);
                            return;
                        }
                        catch (SecurityException ex3) {
                            throw ex3;
                        }
                        catch (RemoteException ex4) {}
                        catch (RuntimeException ex) {
                            goto Label_0222;
                        }
                    }
                }
            }
            zzx.zzaHA = account;
            if (ex != null) {
                zzx.zzaHx = ((zzal)ex).asBinder();
            }
            continue;
        }
    }
    
    public void zza(@NonNull final zzj zzj) {
        this.zzaGQ = zzbo.zzb(zzj, "Connection progress callbacks cannot be null.");
        this.zza(2, null);
    }
    
    protected final void zza(@NonNull final zzj zzj, final int n, @Nullable final PendingIntent pendingIntent) {
        this.zzaGQ = zzbo.zzb(zzj, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzaHb.get(), n, (Object)pendingIntent));
    }
    
    public final void zzay(final int n) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzaHb.get(), n));
    }
    
    @Nullable
    protected abstract T zzd(final IBinder p0);
    
    @NonNull
    protected abstract String zzdb();
    
    @NonNull
    protected abstract String zzdc();
    
    public boolean zzmG() {
        return false;
    }
    
    public Intent zzmH() {
        throw new UnsupportedOperationException("Not a sign in API");
    }
    
    protected Bundle zzmo() {
        return new Bundle();
    }
    
    public boolean zzmv() {
        return false;
    }
    
    public Bundle zzoC() {
        return null;
    }
    
    public boolean zzpe() {
        return true;
    }
    
    protected String zzqZ() {
        return "com.google.android.gms";
    }
    
    public final void zzrb() {
        final int googlePlayServicesAvailable = this.zzaCF.isGooglePlayServicesAvailable(this.mContext);
        if (googlePlayServicesAvailable != 0) {
            this.zza(1, null);
            this.zza(new zzm(this), googlePlayServicesAvailable, null);
            return;
        }
        this.zza(new zzm(this));
    }
    
    public zzc[] zzrd() {
        return new zzc[0];
    }
    
    protected final void zzre() {
        if (!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
    
    public final T zzrf() throws DeadObjectException {
        synchronized (this.mLock) {
            if (this.zzaGU == 5) {
                throw new DeadObjectException();
            }
        }
        this.zzre();
        zzbo.zza(this.zzaGR != null, (Object)"Client is connected but service is null");
        final IInterface zzaGR = this.zzaGR;
        // monitorexit(o)
        return (T)zzaGR;
    }
    
    public boolean zzrg() {
        return false;
    }
    
    protected Set<Scope> zzrh() {
        return (Set<Scope>)Collections.EMPTY_SET;
    }
}
