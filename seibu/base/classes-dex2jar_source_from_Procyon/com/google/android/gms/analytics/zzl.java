// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.os.Process;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.zzaos;
import java.util.Locale;
import com.google.android.gms.internal.zzalp;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.text.TextUtils;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.Iterator;
import android.net.Uri;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzalk;
import java.util.List;
import android.content.Context;

public final class zzl
{
    private static volatile zzl zzaed;
    private final Context mContext;
    private final List<Object> zzaee;
    private final zzg zzaef;
    private final zza zzaeg;
    private volatile zzalk zzaeh;
    private Thread.UncaughtExceptionHandler zzaei;
    
    private zzl(Context applicationContext) {
        applicationContext = applicationContext.getApplicationContext();
        zzbo.zzu(applicationContext);
        this.mContext = applicationContext;
        this.zzaeg = new zza();
        this.zzaee = new CopyOnWriteArrayList<Object>();
        this.zzaef = new zzg();
    }
    
    public static zzl zzae(final Context context) {
        zzbo.zzu(context);
        Label_0034: {
            if (zzl.zzaed != null) {
                break Label_0034;
            }
            synchronized (zzl.class) {
                if (zzl.zzaed == null) {
                    zzl.zzaed = new zzl(context);
                }
                return zzl.zzaed;
            }
        }
    }
    
    private static void zzb(final zzi zzi) {
        zzbo.zzcG("deliver should be called from worker thread");
        zzbo.zzb(zzi.zzju(), (Object)"Measurement must be submitted");
        final List<zzo> zzjr = zzi.zzjr();
        if (!zzjr.isEmpty()) {
            final HashSet<Uri> set = new HashSet<Uri>();
            for (final zzo zzo : zzjr) {
                final Uri zzjl = zzo.zzjl();
                if (!set.contains(zzjl)) {
                    set.add(zzjl);
                    zzo.zzb(zzi);
                }
            }
        }
    }
    
    public static void zzjC() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }
    
    public final Context getContext() {
        return this.mContext;
    }
    
    public final void zza(final Thread.UncaughtExceptionHandler zzaei) {
        this.zzaei = zzaei;
    }
    
    public final <V> Future<V> zzd(final Callable<V> callable) {
        zzbo.zzu(callable);
        if (Thread.currentThread() instanceof zzc) {
            final FutureTask<V> futureTask = new FutureTask<V>(callable);
            futureTask.run();
            return futureTask;
        }
        return this.zzaeg.submit(callable);
    }
    
    final void zze(zzi zzjp) {
        if (zzjp.zzjx()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzjp.zzju()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        zzjp = zzjp.zzjp();
        zzjp.zzjv();
        this.zzaeg.execute(new zzm(this, zzjp));
    }
    
    public final void zzf(final Runnable task) {
        zzbo.zzu(task);
        this.zzaeg.submit(task);
    }
    
    public final zzalk zzjA() {
        Label_0156: {
            if (this.zzaeh != null) {
                break Label_0156;
            }
        Label_0182_Outer:
            while (true) {
                while (true) {
                    synchronized (this) {
                        Label_0154: {
                            if (this.zzaeh != null) {
                                break Label_0154;
                            }
                            final zzalk zzaeh = new zzalk();
                            final PackageManager packageManager = this.mContext.getPackageManager();
                            final String packageName = this.mContext.getPackageName();
                            zzaeh.setAppId(packageName);
                            zzaeh.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                            final String s = null;
                            String obj = packageName;
                            while (true) {
                                try {
                                    final PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                                    String versionName = s;
                                    String string = packageName;
                                    if (packageInfo != null) {
                                        obj = packageName;
                                        final CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                                        string = packageName;
                                        obj = packageName;
                                        if (!TextUtils.isEmpty(applicationLabel)) {
                                            obj = packageName;
                                            string = applicationLabel.toString();
                                        }
                                        obj = string;
                                        versionName = packageInfo.versionName;
                                    }
                                    zzaeh.setAppName(string);
                                    zzaeh.setAppVersion(versionName);
                                    this.zzaeh = zzaeh;
                                    // monitorexit(this)
                                    return this.zzaeh;
                                }
                                catch (PackageManager$NameNotFoundException ex) {
                                    final String value = String.valueOf(obj);
                                    if (value.length() != 0) {
                                        final String concat = "Error retrieving package info: appName set to ".concat(value);
                                        Log.e("GAv4", concat);
                                        final String versionName = s;
                                        final String string = obj;
                                        continue Label_0182_Outer;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    final String concat = new String("Error retrieving package info: appName set to ");
                    continue;
                }
            }
        }
    }
    
    public final zzalp zzjB() {
        final DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        final zzalp zzalp = new zzalp();
        zzalp.setLanguage(zzaos.zza(Locale.getDefault()));
        zzalp.zzNY = displayMetrics.widthPixels;
        zzalp.zzNZ = displayMetrics.heightPixels;
        return zzalp;
    }
    
    final class zza extends ThreadPoolExecutor
    {
        public zza() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
            this.setThreadFactory(new zzb(null));
            this.allowCoreThreadTimeOut(true);
        }
        
        @Override
        protected final <T> RunnableFuture<T> newTaskFor(final Runnable runnable, final T t) {
            return (RunnableFuture<T>)new zzn(this, runnable, t);
        }
    }
    
    static final class zzb implements ThreadFactory
    {
        private static final AtomicInteger zzaem;
        
        static {
            zzaem = new AtomicInteger();
        }
        
        private zzb() {
        }
        
        @Override
        public final Thread newThread(final Runnable runnable) {
            return new zzc(runnable, new StringBuilder(23).append("measurement-").append(zzb.zzaem.incrementAndGet()).toString());
        }
    }
    
    static final class zzc extends Thread
    {
        zzc(final Runnable target, final String name) {
            super(target, name);
        }
        
        @Override
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }
}
