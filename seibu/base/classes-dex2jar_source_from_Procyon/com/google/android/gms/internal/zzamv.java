// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import android.util.Pair;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.analytics.zzl;
import java.util.Iterator;
import com.google.android.gms.analytics.zzi;
import java.util.Map;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzbo;

final class zzamv extends zzamh
{
    private boolean mStarted;
    private final zzanm zzagA;
    private final zzanm zzagB;
    private final zzaoo zzagC;
    private long zzagD;
    private boolean zzagE;
    private final zzams zzagv;
    private final zzaoe zzagw;
    private final zzaod zzagx;
    private final zzamn zzagy;
    private long zzagz;
    
    protected zzamv(final zzamj zzamj, final zzaml zzaml) {
        super(zzamj);
        zzbo.zzu(zzaml);
        this.zzagz = Long.MIN_VALUE;
        this.zzagx = new zzaod(zzamj);
        this.zzagv = new zzams(zzamj);
        this.zzagw = new zzaoe(zzamj);
        this.zzagy = new zzamn(zzamj);
        this.zzagC = new zzaoo(this.zzkq());
        this.zzagA = new zzamw(this, zzamj);
        this.zzagB = new zzamx(this, zzamj);
    }
    
    private final void zza(final zzamm zzamm, final zzall zzall) {
        zzbo.zzu(zzamm);
        zzbo.zzu(zzall);
        final zza zza = new zza(this.zzkp());
        zza.zzaY(zzamm.zzkL());
        zza.enableAdvertisingIdCollection(zzamm.zzkM());
        final zzi zzjj = zza.zzjj();
        final zzalt zzalt = zzjj.zzb(zzalt.class);
        zzalt.zzbj("data");
        zzalt.zzH(true);
        zzjj.zza(zzall);
        final zzalo zzalo = zzjj.zzb(zzalo.class);
        final zzalk zzalk = zzjj.zzb(zzalk.class);
        for (final Map.Entry<String, String> entry : zzamm.zzdV().entrySet()) {
            final String anObject = entry.getKey();
            final String userId = entry.getValue();
            if ("an".equals(anObject)) {
                zzalk.setAppName(userId);
            }
            else if ("av".equals(anObject)) {
                zzalk.setAppVersion(userId);
            }
            else if ("aid".equals(anObject)) {
                zzalk.setAppId(userId);
            }
            else if ("aiid".equals(anObject)) {
                zzalk.setAppInstallerId(userId);
            }
            else if ("uid".equals(anObject)) {
                zzalt.setUserId(userId);
            }
            else {
                zzalo.set(anObject, userId);
            }
        }
        this.zzb("Sending installation campaign to", zzamm.zzkL(), zzall);
        zzjj.zzl(this.zzky().zzlU());
        zzjj.zzjt();
    }
    
    private final boolean zzbv(final String s) {
        return zzbha.zzaP(this.getContext()).checkCallingOrSelfPermission(s) == 0;
    }
    
    private final long zzkT() {
        zzl.zzjC();
        this.zzkD();
        try {
            return this.zzagv.zzkT();
        }
        catch (SQLiteException ex) {
            this.zze("Failed to get min/max hit times from local store", ex);
            return 0L;
        }
    }
    
    private final void zzkY() {
        this.zzb(new zzamz(this));
    }
    
    private final void zzkZ() {
        while (true) {
            try {
                this.zzagv.zzkS();
                this.zzld();
                this.zzagB.zzs(86400000L);
            }
            catch (SQLiteException ex) {
                this.zzd("Failed to delete stale hits", ex);
                continue;
            }
            break;
        }
    }
    
    private final void zzla() {
        if (!this.zzagE && zzank.zzlo() && !this.zzagy.isConnected() && this.zzagC.zzu(zzans.zzahS.get())) {
            this.zzagC.start();
            this.zzbo("Connecting to service");
            if (this.zzagy.connect()) {
                this.zzbo("Connected to service");
                this.zzagC.clear();
                this.onServiceConnected();
            }
        }
    }
    
    private final boolean zzlb() {
        boolean b = true;
        zzl.zzjC();
        this.zzkD();
        this.zzbo("Dispatching a batch of local hits");
        boolean b2;
        if (!this.zzagy.isConnected()) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (this.zzagw.zzlQ()) {
            b = false;
        }
        if (b2 && b) {
            this.zzbo("No network or service available. Will retry later");
            return false;
        }
        final long n = Math.max(zzank.zzls(), zzank.zzlt());
        final ArrayList<Long> list = new ArrayList<Long>();
        long a = 0L;
        try {
            while (true) {
                this.zzagv.beginTransaction();
                list.clear();
                List<zzanx> zzo = null;
                Label_0327: {
                    try {
                        zzo = this.zzagv.zzo(n);
                        if (zzo.isEmpty()) {
                            this.zzbo("Store is empty, nothing to dispatch");
                            this.zzlf();
                            try {
                                this.zzagv.setTransactionSuccessful();
                                this.zzagv.endTransaction();
                                return false;
                            }
                            catch (SQLiteException ex) {
                                this.zze("Failed to commit local dispatch transaction", ex);
                                this.zzlf();
                                return false;
                            }
                        }
                        this.zza("Hits loaded from store. count", zzo.size());
                        final Iterator<zzanx> iterator = zzo.iterator();
                        Block_18: {
                            while (iterator.hasNext()) {
                                if (iterator.next().zzlF() == a) {
                                    break Block_18;
                                }
                            }
                            break Label_0327;
                        }
                        this.zzd("Database contains successfully uploaded hit", a, zzo.size());
                        this.zzlf();
                        try {
                            this.zzagv.setTransactionSuccessful();
                            this.zzagv.endTransaction();
                            return false;
                        }
                        catch (SQLiteException ex2) {
                            this.zze("Failed to commit local dispatch transaction", ex2);
                            this.zzlf();
                            return false;
                        }
                    }
                    catch (SQLiteException ex3) {
                        this.zzd("Failed to read hits from persisted store", ex3);
                        this.zzlf();
                        try {
                            this.zzagv.setTransactionSuccessful();
                            this.zzagv.endTransaction();
                            return false;
                        }
                        catch (SQLiteException ex4) {
                            this.zze("Failed to commit local dispatch transaction", ex4);
                            this.zzlf();
                            return false;
                        }
                    }
                }
                long n2 = a;
                if (this.zzagy.isConnected()) {
                    this.zzbo("Service connected, sending hits to the service");
                    while (true) {
                        n2 = a;
                        if (zzo.isEmpty()) {
                            break;
                        }
                        final zzanx zzanx = zzo.get(0);
                        n2 = a;
                        if (this.zzagy.zzb(zzanx)) {
                            a = Math.max(a, zzanx.zzlF());
                            zzo.remove(zzanx);
                            this.zzb("Hit sent do device AnalyticsService for delivery", zzanx);
                            try {
                                this.zzagv.zzp(zzanx.zzlF());
                                list.add(zzanx.zzlF());
                                continue;
                            }
                            catch (SQLiteException ex5) {
                                this.zze("Failed to remove hit that was send for delivery", ex5);
                                this.zzlf();
                                try {
                                    this.zzagv.setTransactionSuccessful();
                                    this.zzagv.endTransaction();
                                    return false;
                                }
                                catch (SQLiteException ex6) {
                                    this.zze("Failed to commit local dispatch transaction", ex6);
                                    this.zzlf();
                                    return false;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
                a = n2;
                Label_0582: {
                    if (!this.zzagw.zzlQ()) {
                        break Label_0582;
                    }
                    final List<Long> zzu = this.zzagw.zzu(zzo);
                    final Iterator<Long> iterator2 = zzu.iterator();
                    a = n2;
                    while (iterator2.hasNext()) {
                        a = Math.max(a, iterator2.next());
                    }
                    try {
                        this.zzagv.zzs(zzu);
                        list.addAll((Collection<?>)zzu);
                        if (list.isEmpty()) {
                            try {
                                this.zzagv.setTransactionSuccessful();
                                this.zzagv.endTransaction();
                                return false;
                            }
                            catch (SQLiteException ex7) {
                                this.zze("Failed to commit local dispatch transaction", ex7);
                                this.zzlf();
                                return false;
                            }
                        }
                    }
                    catch (SQLiteException ex8) {
                        this.zze("Failed to remove successfully uploaded hits", ex8);
                        this.zzlf();
                        try {
                            this.zzagv.setTransactionSuccessful();
                            this.zzagv.endTransaction();
                            return false;
                        }
                        catch (SQLiteException ex9) {
                            this.zze("Failed to commit local dispatch transaction", ex9);
                            this.zzlf();
                            return false;
                        }
                    }
                }
                try {
                    this.zzagv.setTransactionSuccessful();
                    this.zzagv.endTransaction();
                }
                catch (SQLiteException ex10) {
                    this.zze("Failed to commit local dispatch transaction", ex10);
                    this.zzlf();
                    return false;
                }
            }
        }
        finally {
            try {
                this.zzagv.setTransactionSuccessful();
                this.zzagv.endTransaction();
            }
            catch (SQLiteException ex11) {
                this.zze("Failed to commit local dispatch transaction", ex11);
                this.zzlf();
                return false;
            }
        }
    }
    
    private final void zzle() {
        final zzanp zzkw = this.zzkw();
        if (zzkw.zzlC() && !zzkw.zzbo()) {
            final long zzkT = this.zzkT();
            if (zzkT != 0L && Math.abs(this.zzkq().currentTimeMillis() - zzkT) <= zzans.zzahr.get()) {
                this.zza("Dispatch alarm scheduled (ms)", zzank.zzlr());
                zzkw.schedule();
            }
        }
    }
    
    private final void zzlf() {
        if (this.zzagA.zzbo()) {
            this.zzbo("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzagA.cancel();
        final zzanp zzkw = this.zzkw();
        if (zzkw.zzbo()) {
            zzkw.cancel();
        }
    }
    
    private final long zzlg() {
        long n;
        if (this.zzagz != Long.MIN_VALUE) {
            n = this.zzagz;
        }
        else {
            n = zzans.zzahm.get();
            final zzaot zzkx = this.zzkx();
            zzkx.zzkD();
            if (zzkx.zzaiP) {
                final zzaot zzkx2 = this.zzkx();
                zzkx2.zzkD();
                return zzkx2.zzahZ * 1000L;
            }
        }
        return n;
    }
    
    private final void zzlh() {
        this.zzkD();
        zzl.zzjC();
        this.zzagE = true;
        this.zzagy.disconnect();
        this.zzld();
    }
    
    protected final void onServiceConnected() {
        zzl.zzjC();
        zzl.zzjC();
        this.zzkD();
        if (!zzank.zzlo()) {
            this.zzbr("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zzagy.isConnected()) {
            this.zzbo("Service not connected");
        }
        else if (!this.zzagv.isEmpty()) {
            this.zzbo("Dispatching local hits to device AnalyticsService");
            while (true) {
                Label_0117: {
                    List<zzanx> zzo;
                    try {
                        zzo = this.zzagv.zzo(zzank.zzls());
                        if (zzo.isEmpty()) {
                            this.zzld();
                            return;
                        }
                        break Label_0117;
                    }
                    catch (SQLiteException ex) {
                        this.zze("Failed to read hits from store", ex);
                        this.zzlf();
                        return;
                    }
                    while (true) {
                        zzanx zzanx = null;
                        zzo.remove(zzanx);
                        try {
                            this.zzagv.zzp(zzanx.zzlF());
                            if (zzo.isEmpty()) {
                                break;
                            }
                            zzanx = zzo.get(0);
                            if (!this.zzagy.zzb(zzanx)) {
                                this.zzld();
                                return;
                            }
                            continue;
                        }
                        catch (SQLiteException ex2) {
                            this.zze("Failed to remove hit that was send for delivery", ex2);
                            this.zzlf();
                        }
                    }
                }
            }
        }
    }
    
    final void start() {
        this.zzkD();
        zzbo.zza(!this.mStarted, (Object)"Analytics backend already started");
        this.mStarted = true;
        this.zzkt().zzf(new zzamy(this));
    }
    
    public final long zza(final zzamm p0, final boolean p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: pop            
        //     5: aload_0        
        //     6: invokevirtual   com/google/android/gms/internal/zzamv.zzkD:()V
        //     9: invokestatic    com/google/android/gms/analytics/zzl.zzjC:()V
        //    12: aload_0        
        //    13: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //    16: invokevirtual   com/google/android/gms/internal/zzams.beginTransaction:()V
        //    19: aload_0        
        //    20: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //    23: astore          6
        //    25: aload_1        
        //    26: invokevirtual   com/google/android/gms/internal/zzamm.zzkK:()J
        //    29: lstore          4
        //    31: aload_1        
        //    32: invokevirtual   com/google/android/gms/internal/zzamm.zzjX:()Ljava/lang/String;
        //    35: astore          7
        //    37: aload           7
        //    39: invokestatic    com/google/android/gms/common/internal/zzbo.zzcF:(Ljava/lang/String;)Ljava/lang/String;
        //    42: pop            
        //    43: aload           6
        //    45: invokevirtual   com/google/android/gms/internal/zzams.zzkD:()V
        //    48: invokestatic    com/google/android/gms/analytics/zzl.zzjC:()V
        //    51: aload           6
        //    53: invokevirtual   com/google/android/gms/internal/zzams.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    56: ldc_w           "properties"
        //    59: ldc_w           "app_uid=? AND cid<>?"
        //    62: iconst_2       
        //    63: anewarray       Ljava/lang/String;
        //    66: dup            
        //    67: iconst_0       
        //    68: lload           4
        //    70: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //    73: aastore        
        //    74: dup            
        //    75: iconst_1       
        //    76: aload           7
        //    78: aastore        
        //    79: invokevirtual   android/database/sqlite/SQLiteDatabase.delete:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //    82: istore_3       
        //    83: iload_3        
        //    84: ifle            99
        //    87: aload           6
        //    89: ldc_w           "Deleted property records"
        //    92: iload_3        
        //    93: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    96: invokevirtual   com/google/android/gms/internal/zzams.zza:(Ljava/lang/String;Ljava/lang/Object;)V
        //    99: aload_0        
        //   100: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //   103: aload_1        
        //   104: invokevirtual   com/google/android/gms/internal/zzamm.zzkK:()J
        //   107: aload_1        
        //   108: invokevirtual   com/google/android/gms/internal/zzamm.zzjX:()Ljava/lang/String;
        //   111: aload_1        
        //   112: invokevirtual   com/google/android/gms/internal/zzamm.zzkL:()Ljava/lang/String;
        //   115: invokevirtual   com/google/android/gms/internal/zzams.zza:(JLjava/lang/String;Ljava/lang/String;)J
        //   118: lstore          4
        //   120: aload_1        
        //   121: lconst_1       
        //   122: lload           4
        //   124: ladd           
        //   125: invokevirtual   com/google/android/gms/internal/zzamm.zzm:(J)V
        //   128: aload_0        
        //   129: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //   132: astore          7
        //   134: aload_1        
        //   135: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //   138: pop            
        //   139: aload           7
        //   141: invokevirtual   com/google/android/gms/internal/zzams.zzkD:()V
        //   144: invokestatic    com/google/android/gms/analytics/zzl.zzjC:()V
        //   147: aload           7
        //   149: invokevirtual   com/google/android/gms/internal/zzams.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //   152: astore          8
        //   154: aload_1        
        //   155: invokevirtual   com/google/android/gms/internal/zzamm.zzdV:()Ljava/util/Map;
        //   158: astore          9
        //   160: aload           9
        //   162: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //   165: pop            
        //   166: new             Landroid/net/Uri$Builder;
        //   169: dup            
        //   170: invokespecial   android/net/Uri$Builder.<init>:()V
        //   173: astore          6
        //   175: aload           9
        //   177: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   182: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   187: astore          9
        //   189: aload           9
        //   191: invokeinterface java/util/Iterator.hasNext:()Z
        //   196: ifeq            260
        //   199: aload           9
        //   201: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   206: checkcast       Ljava/util/Map$Entry;
        //   209: astore          10
        //   211: aload           6
        //   213: aload           10
        //   215: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   220: checkcast       Ljava/lang/String;
        //   223: aload           10
        //   225: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   230: checkcast       Ljava/lang/String;
        //   233: invokevirtual   android/net/Uri$Builder.appendQueryParameter:(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
        //   236: pop            
        //   237: goto            189
        //   240: astore_1       
        //   241: aload_0        
        //   242: ldc_w           "Failed to update Analytics property"
        //   245: aload_1        
        //   246: invokevirtual   com/google/android/gms/internal/zzamv.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   249: aload_0        
        //   250: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //   253: invokevirtual   com/google/android/gms/internal/zzams.endTransaction:()V
        //   256: ldc2_w          -1
        //   259: lreturn        
        //   260: aload           6
        //   262: invokevirtual   android/net/Uri$Builder.build:()Landroid/net/Uri;
        //   265: invokevirtual   android/net/Uri.getEncodedQuery:()Ljava/lang/String;
        //   268: astore          6
        //   270: aload           6
        //   272: ifnonnull       418
        //   275: ldc_w           ""
        //   278: astore          6
        //   280: new             Landroid/content/ContentValues;
        //   283: dup            
        //   284: invokespecial   android/content/ContentValues.<init>:()V
        //   287: astore          9
        //   289: aload           9
        //   291: ldc_w           "app_uid"
        //   294: aload_1        
        //   295: invokevirtual   com/google/android/gms/internal/zzamm.zzkK:()J
        //   298: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   301: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   304: aload           9
        //   306: ldc_w           "cid"
        //   309: aload_1        
        //   310: invokevirtual   com/google/android/gms/internal/zzamm.zzjX:()Ljava/lang/String;
        //   313: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   316: aload           9
        //   318: ldc_w           "tid"
        //   321: aload_1        
        //   322: invokevirtual   com/google/android/gms/internal/zzamm.zzkL:()Ljava/lang/String;
        //   325: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   328: aload_1        
        //   329: invokevirtual   com/google/android/gms/internal/zzamm.zzkM:()Z
        //   332: ifeq            421
        //   335: iconst_1       
        //   336: istore_3       
        //   337: aload           9
        //   339: ldc_w           "adid"
        //   342: iload_3        
        //   343: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   346: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //   349: aload           9
        //   351: ldc_w           "hits_count"
        //   354: aload_1        
        //   355: invokevirtual   com/google/android/gms/internal/zzamm.zzkN:()J
        //   358: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   361: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Long;)V
        //   364: aload           9
        //   366: ldc_w           "params"
        //   369: aload           6
        //   371: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   374: aload           8
        //   376: ldc_w           "properties"
        //   379: aconst_null    
        //   380: aload           9
        //   382: iconst_5       
        //   383: invokevirtual   android/database/sqlite/SQLiteDatabase.insertWithOnConflict:(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
        //   386: ldc2_w          -1
        //   389: lcmp           
        //   390: ifne            401
        //   393: aload           7
        //   395: ldc_w           "Failed to insert/update a property (got -1)"
        //   398: invokevirtual   com/google/android/gms/internal/zzams.zzbs:(Ljava/lang/String;)V
        //   401: aload_0        
        //   402: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //   405: invokevirtual   com/google/android/gms/internal/zzams.setTransactionSuccessful:()V
        //   408: aload_0        
        //   409: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //   412: invokevirtual   com/google/android/gms/internal/zzams.endTransaction:()V
        //   415: lload           4
        //   417: lreturn        
        //   418: goto            280
        //   421: iconst_0       
        //   422: istore_3       
        //   423: goto            337
        //   426: astore_1       
        //   427: aload           7
        //   429: ldc_w           "Error storing a property"
        //   432: aload_1        
        //   433: invokevirtual   com/google/android/gms/internal/zzams.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   436: goto            401
        //   439: astore_1       
        //   440: aload_0        
        //   441: getfield        com/google/android/gms/internal/zzamv.zzagv:Lcom/google/android/gms/internal/zzams;
        //   444: invokevirtual   com/google/android/gms/internal/zzams.endTransaction:()V
        //   447: aload_1        
        //   448: athrow         
        //   449: astore_1       
        //   450: aload_0        
        //   451: ldc_w           "Failed to end transaction"
        //   454: aload_1        
        //   455: invokevirtual   com/google/android/gms/internal/zzamv.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   458: goto            415
        //   461: astore_1       
        //   462: aload_0        
        //   463: ldc_w           "Failed to end transaction"
        //   466: aload_1        
        //   467: invokevirtual   com/google/android/gms/internal/zzamv.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   470: goto            256
        //   473: astore          6
        //   475: aload_0        
        //   476: ldc_w           "Failed to end transaction"
        //   479: aload           6
        //   481: invokevirtual   com/google/android/gms/internal/zzamv.zze:(Ljava/lang/String;Ljava/lang/Object;)V
        //   484: goto            447
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  12     83     240    260    Landroid/database/sqlite/SQLiteException;
        //  12     83     439    449    Any
        //  87     99     240    260    Landroid/database/sqlite/SQLiteException;
        //  87     99     439    449    Any
        //  99     189    240    260    Landroid/database/sqlite/SQLiteException;
        //  99     189    439    449    Any
        //  189    237    240    260    Landroid/database/sqlite/SQLiteException;
        //  189    237    439    449    Any
        //  241    249    439    449    Any
        //  249    256    461    473    Landroid/database/sqlite/SQLiteException;
        //  260    270    240    260    Landroid/database/sqlite/SQLiteException;
        //  260    270    439    449    Any
        //  280    335    240    260    Landroid/database/sqlite/SQLiteException;
        //  280    335    439    449    Any
        //  337    374    240    260    Landroid/database/sqlite/SQLiteException;
        //  337    374    439    449    Any
        //  374    401    426    439    Landroid/database/sqlite/SQLiteException;
        //  374    401    439    449    Any
        //  401    408    240    260    Landroid/database/sqlite/SQLiteException;
        //  401    408    439    449    Any
        //  408    415    449    461    Landroid/database/sqlite/SQLiteException;
        //  427    436    240    260    Landroid/database/sqlite/SQLiteException;
        //  427    436    439    449    Any
        //  440    447    473    487    Landroid/database/sqlite/SQLiteException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 218 out of bounds for length 218
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
    
    public final void zza(final zzanx zzanx) {
        zzbo.zzu(zzanx);
        zzl.zzjC();
        this.zzkD();
        if (this.zzagE) {
            this.zzbp("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        }
        else {
            this.zza("Delivering hit", zzanx);
        }
        zzanx zzanx2;
        if (!TextUtils.isEmpty((CharSequence)zzanx.zzlK())) {
            zzanx2 = zzanx;
        }
        else {
            final Pair<String, Long> zzmb = this.zzky().zzlZ().zzmb();
            zzanx2 = zzanx;
            if (zzmb != null) {
                final Long obj = (Long)zzmb.second;
                final String s = (String)zzmb.first;
                final String value = String.valueOf(obj);
                final String string = new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(s).length()).append(value).append(":").append(s).toString();
                final HashMap<String, String> hashMap = new HashMap<String, String>(zzanx.zzdV());
                hashMap.put("_m", string);
                zzanx2 = new zzanx(this, hashMap, zzanx.zzlG(), zzanx.zzlI(), zzanx.zzlF(), zzanx.zzlE(), zzanx.zzlH());
            }
        }
        this.zzla();
        if (this.zzagy.zzb(zzanx2)) {
            this.zzbp("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzagv.zzc(zzanx2);
            this.zzld();
        }
        catch (SQLiteException ex) {
            this.zze("Delivery failed to save hit to a database", ex);
            this.zzkr().zza(zzanx2, "deliver: failed to insert hit to database");
        }
    }
    
    protected final void zzb(final zzamm zzamm) {
        zzl.zzjC();
        this.zzb("Sending first hit to property", zzamm.zzkL());
        if (!this.zzky().zzlV().zzu(zzank.zzly())) {
            final String zzlY = this.zzky().zzlY();
            if (!TextUtils.isEmpty((CharSequence)zzlY)) {
                final zzall zza = zzaos.zza(this.zzkr(), zzlY);
                this.zzb("Found relevant installation campaign", zza);
                this.zza(zzamm, zza);
            }
        }
    }
    
    public final void zzb(final zzanq zzanq) {
        final long zzagD = this.zzagD;
        zzl.zzjC();
        this.zzkD();
        long abs = -1L;
        final long zzlW = this.zzky().zzlW();
        if (zzlW != 0L) {
            abs = Math.abs(this.zzkq().currentTimeMillis() - zzlW);
        }
        this.zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", abs);
        this.zzla();
        try {
            this.zzlb();
            this.zzky().zzlX();
            this.zzld();
            if (zzanq != null) {
                zzanq.zzc(null);
            }
            if (this.zzagD != zzagD) {
                this.zzagx.zzlP();
            }
        }
        catch (Throwable t) {
            this.zze("Local dispatch failed", t);
            this.zzky().zzlX();
            this.zzld();
            if (zzanq != null) {
                zzanq.zzc(t);
            }
        }
    }
    
    public final void zzbw(final String s) {
        zzbo.zzcF(s);
        zzl.zzjC();
        final zzall zza = zzaos.zza(this.zzkr(), s);
        if (zza == null) {
            this.zzd("Parsing failed. Ignoring invalid campaign data", s);
        }
        else {
            final String zzlY = this.zzky().zzlY();
            if (s.equals(zzlY)) {
                this.zzbr("Ignoring duplicate install campaign");
                return;
            }
            if (!TextUtils.isEmpty((CharSequence)zzlY)) {
                this.zzd("Ignoring multiple install campaigns. original, new", zzlY, s);
                return;
            }
            this.zzky().zzbz(s);
            if (this.zzky().zzlV().zzu(zzank.zzly())) {
                this.zzd("Campaign received too late, ignoring", zza);
                return;
            }
            this.zzb("Received installation campaign", zza);
            final Iterator<zzamm> iterator = this.zzagv.zzq(0L).iterator();
            while (iterator.hasNext()) {
                this.zza(iterator.next(), zza);
            }
        }
    }
    
    @Override
    protected final void zzjD() {
        this.zzagv.initialize();
        this.zzagw.initialize();
        this.zzagy.initialize();
    }
    
    protected final void zzkX() {
        this.zzkD();
        zzl.zzjC();
        final Context context = this.zzkp().getContext();
        if (!zzaoj.zzac(context)) {
            this.zzbr("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        }
        else if (!zzaok.zzad(context)) {
            this.zzbs("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzac(context)) {
            this.zzbr("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        else if (!CampaignTrackingService.zzad(context)) {
            this.zzbr("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        this.zzky().zzlU();
        if (!this.zzbv("android.permission.ACCESS_NETWORK_STATE")) {
            this.zzbs("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            this.zzlh();
        }
        if (!this.zzbv("android.permission.INTERNET")) {
            this.zzbs("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            this.zzlh();
        }
        if (zzaok.zzad(this.getContext())) {
            this.zzbo("AnalyticsService registered in the app manifest and enabled");
        }
        else {
            this.zzbr("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzagE && !this.zzagv.isEmpty()) {
            this.zzla();
        }
        this.zzld();
    }
    
    public final void zzkk() {
        zzl.zzjC();
        this.zzkD();
        this.zzbo("Delete all hits from local store");
        while (true) {
            try {
                final zzams zzagv = this.zzagv;
                zzl.zzjC();
                zzagv.zzkD();
                zzagv.getWritableDatabase().delete("hits2", (String)null, (String[])null);
                final zzams zzagv2 = this.zzagv;
                zzl.zzjC();
                zzagv2.zzkD();
                zzagv2.getWritableDatabase().delete("properties", (String)null, (String[])null);
                this.zzld();
                this.zzla();
                if (this.zzagy.zzkO()) {
                    this.zzbo("Device service unavailable. Can't clear hits stored on the device service.");
                }
            }
            catch (SQLiteException ex) {
                this.zzd("Failed to delete hits from store", ex);
                continue;
            }
            break;
        }
    }
    
    final void zzko() {
        zzl.zzjC();
        this.zzagD = this.zzkq().currentTimeMillis();
    }
    
    public final void zzlc() {
        zzl.zzjC();
        this.zzkD();
        this.zzbp("Sync dispatching local hits");
        final long zzagD = this.zzagD;
        this.zzla();
        try {
            this.zzlb();
            this.zzky().zzlX();
            this.zzld();
            if (this.zzagD != zzagD) {
                this.zzagx.zzlP();
            }
        }
        catch (Throwable t) {
            this.zze("Sync local dispatch failed", t);
            this.zzld();
        }
    }
    
    public final void zzld() {
        zzl.zzjC();
        this.zzkD();
        int n;
        if (!this.zzagE && this.zzlg() > 0L) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            this.zzagx.unregister();
            this.zzlf();
            return;
        }
        if (this.zzagv.isEmpty()) {
            this.zzagx.unregister();
            this.zzlf();
            return;
        }
        int connected;
        if (!zzans.zzahN.get()) {
            this.zzagx.zzlN();
            connected = (this.zzagx.isConnected() ? 1 : 0);
        }
        else {
            connected = 1;
        }
        if (connected == 0) {
            this.zzlf();
            this.zzle();
            return;
        }
        this.zzle();
        final long zzlg = this.zzlg();
        final long zzlW = this.zzky().zzlW();
        long l;
        if (zzlW != 0L) {
            l = zzlg - Math.abs(this.zzkq().currentTimeMillis() - zzlW);
            if (l <= 0L) {
                l = Math.min(zzank.zzlq(), zzlg);
            }
        }
        else {
            l = Math.min(zzank.zzlq(), zzlg);
        }
        this.zza("Dispatch scheduled (ms)", l);
        if (this.zzagA.zzbo()) {
            this.zzagA.zzt(Math.max(1L, l + this.zzagA.zzlz()));
            return;
        }
        this.zzagA.zzs(l);
    }
    
    public final void zzr(final long n) {
        zzl.zzjC();
        this.zzkD();
        long zzagz = n;
        if (n < 0L) {
            zzagz = 0L;
        }
        this.zzagz = zzagz;
        this.zzld();
    }
}
