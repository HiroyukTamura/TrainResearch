package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.iid.zzao;
import com.google.firebase.iid.zzt;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p009e.p010a.p011a.p012a.C0681a;

final class zzab {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private final FirebaseInstanceId zzb;
    private final Context zzc;
    private final zzao zzd;
    private final zzt zze;
    @GuardedBy("pendingOperations")
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> zzf = new ArrayMap();
    private final ScheduledExecutorService zzg;
    @GuardedBy("this")
    private boolean zzh = false;
    private final zzy zzi;

    private zzab(FirebaseInstanceId firebaseInstanceId, zzao zzao, zzy zzy, zzt zzt, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.zzb = firebaseInstanceId;
        this.zzd = zzao;
        this.zzi = zzy;
        this.zze = zzt;
        this.zzc = context;
        this.zzg = scheduledExecutorService;
    }

    static Task<zzab> zza(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, zzao zzao, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, Context context, Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new zzaa(context, scheduledExecutorService, firebaseInstanceId, zzao, new zzt(firebaseApp, zzao, executor, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi)));
    }

    static final /* synthetic */ zzab zza(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, zzao zzao, zzt zzt) throws Exception {
        return new zzab(firebaseInstanceId, zzao, zzy.zza(context, scheduledExecutorService), zzt, context, scheduledExecutorService);
    }

    @WorkerThread
    private static <T> T zza(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e2);
        }
    }

    @WorkerThread
    private final boolean zzb(zzz zzz) throws IOException {
        String str;
        String str2;
        StringBuilder sb;
        try {
            String zzb2 = zzz.zzb();
            char c = 65535;
            int hashCode = zzb2.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85) {
                    if (zzb2.equals("U")) {
                        c = 1;
                    }
                }
            } else if (zzb2.equals(ExifInterface.LATITUDE_SOUTH)) {
                c = 0;
            }
            if (c != 0) {
                if (c == 1) {
                    String zza2 = zzz.zza();
                    InstanceIdResult instanceIdResult = (InstanceIdResult) zza(this.zzb.getInstanceId());
                    zza(this.zze.zzd(instanceIdResult.getId(), instanceIdResult.getToken(), zza2));
                    if (zzd()) {
                        String zza3 = zzz.zza();
                        sb = new StringBuilder(String.valueOf(zza3).length() + 35);
                        sb.append("Unsubscribe from topic: ");
                        sb.append(zza3);
                        sb.append(" succeeded.");
                    }
                } else if (zzd()) {
                    String valueOf = String.valueOf(zzz);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
                    sb2.append("Unknown topic operation");
                    sb2.append(valueOf);
                    sb2.append(".");
                    str2 = sb2.toString();
                    Log.d("FirebaseMessaging", str2);
                }
                return true;
            }
            String zza4 = zzz.zza();
            InstanceIdResult instanceIdResult2 = (InstanceIdResult) zza(this.zzb.getInstanceId());
            zza(this.zze.zzc(instanceIdResult2.getId(), instanceIdResult2.getToken(), zza4));
            if (zzd()) {
                String zza5 = zzz.zza();
                sb = new StringBuilder(String.valueOf(zza5).length() + 31);
                sb.append("Subscribe to topic: ");
                sb.append(zza5);
                sb.append(" succeeded.");
            }
            return true;
            str2 = sb.toString();
            Log.d("FirebaseMessaging", str2);
            return true;
        } catch (IOException e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                String message = e.getMessage();
                str = C0681a.m313a(C0681a.m336b(message, 53), "Topic operation failed: ", message, ". Will retry Topic operation.");
            } else if (e.getMessage() == null) {
                str = "Topic operation failed without exception message. Will retry Topic operation.";
            } else {
                throw e;
            }
            Log.e("FirebaseMessaging", str);
            return false;
        }
    }

    private final synchronized boolean zzc() {
        return this.zzh;
    }

    private static boolean zzd() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Task<Void> zza(zzz zzz) {
        ArrayDeque arrayDeque;
        this.zzi.zza(zzz);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.zzf) {
            String zzc2 = zzz.zzc();
            if (this.zzf.containsKey(zzc2)) {
                arrayDeque = this.zzf.get(zzc2);
            } else {
                ArrayDeque arrayDeque2 = new ArrayDeque();
                this.zzf.put(zzc2, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if ((this.zzi.zza() != null) && !zzc()) {
            zza(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        zza(new zzad(this, this.zzc, this.zzd, Math.min(Math.max(30, j << 1), zza)), j);
        zza(true);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable, long j) {
        this.zzg.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.zzh = z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (zzb(r0) != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r5.zzi.zzb(r0);
        r1 = r5.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = r0.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r5.zzf.containsKey(r0) != false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        r2 = r5.zzf.get(r0);
        r3 = (com.google.android.gms.tasks.TaskCompletionSource) r2.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        if (r3 == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        r3.setResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        if (r2.isEmpty() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
        r5.zzf.remove(r0);
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb() throws java.io.IOException {
        /*
            r5 = this;
        L_0x0000:
            monitor-enter(r5)
            com.google.firebase.messaging.zzy r0 = r5.zzi     // Catch:{ all -> 0x005b }
            com.google.firebase.messaging.zzz r0 = r0.zza()     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0019
            boolean r0 = zzd()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x005b }
        L_0x0016:
            r0 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x005b }
            return r0
        L_0x0019:
            monitor-exit(r5)     // Catch:{ all -> 0x005b }
            boolean r1 = r5.zzb(r0)
            if (r1 != 0) goto L_0x0022
            r0 = 0
            return r0
        L_0x0022:
            com.google.firebase.messaging.zzy r1 = r5.zzi
            r1.zzb(r0)
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r5.zzf
            monitor-enter(r1)
            java.lang.String r0 = r0.zzc()     // Catch:{ all -> 0x0058 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.zzf     // Catch:{ all -> 0x0058 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0038
        L_0x0036:
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            goto L_0x0000
        L_0x0038:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.zzf     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0058 }
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2     // Catch:{ all -> 0x0058 }
            java.lang.Object r3 = r2.poll()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.tasks.TaskCompletionSource r3 = (com.google.android.gms.tasks.TaskCompletionSource) r3     // Catch:{ all -> 0x0058 }
            if (r3 == 0) goto L_0x004c
            r4 = 0
            r3.setResult(r4)     // Catch:{ all -> 0x0058 }
        L_0x004c:
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0036
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.zzf     // Catch:{ all -> 0x0058 }
            r2.remove(r0)     // Catch:{ all -> 0x0058 }
            goto L_0x0036
        L_0x0058:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            throw r0
        L_0x005b:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005e:
            throw r0
        L_0x005f:
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzab.zzb():boolean");
    }
}
