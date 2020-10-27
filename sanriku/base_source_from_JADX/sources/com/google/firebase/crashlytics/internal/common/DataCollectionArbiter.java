package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;

public class DataCollectionArbiter {
    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    private volatile boolean crashlyticsDataCollectionEnabled;
    private volatile boolean crashlyticsDataCollectionExplicitlySet;
    TaskCompletionSource<Void> dataCollectionEnabledTask = new TaskCompletionSource<>();
    private TaskCompletionSource<Void> dataCollectionExplicitlyApproved;
    private final FirebaseApp firebaseApp;
    private final SharedPreferences sharedPreferences;
    private Object taskLock = new Object();
    boolean taskResolved;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public DataCollectionArbiter(com.google.firebase.FirebaseApp r5) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r4.taskLock = r0
            com.google.android.gms.tasks.TaskCompletionSource r0 = new com.google.android.gms.tasks.TaskCompletionSource
            r0.<init>()
            r4.dataCollectionEnabledTask = r0
            r0 = 0
            r4.taskResolved = r0
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            r4.dataCollectionExplicitlyApproved = r1
            r4.firebaseApp = r5
            android.content.Context r5 = r5.getApplicationContext()
            if (r5 == 0) goto L_0x008a
            android.content.SharedPreferences r1 = com.google.firebase.crashlytics.internal.common.CommonUtils.getSharedPrefs(r5)
            r4.sharedPreferences = r1
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.contains(r2)
            r2 = 1
            if (r1 == 0) goto L_0x003c
            android.content.SharedPreferences r5 = r4.sharedPreferences
            java.lang.String r0 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r5.getBoolean(r0, r2)
        L_0x003a:
            r0 = 1
            goto L_0x0070
        L_0x003c:
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0065 }
            if (r1 == 0) goto L_0x006f
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0065 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r1.getApplicationInfo(r5, r3)     // Catch:{ NameNotFoundException -> 0x0065 }
            if (r5 == 0) goto L_0x006f
            android.os.Bundle r1 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0065 }
            if (r1 == 0) goto L_0x006f
            android.os.Bundle r1 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0065 }
            java.lang.String r3 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.containsKey(r3)     // Catch:{ NameNotFoundException -> 0x0065 }
            if (r1 == 0) goto L_0x006f
            android.os.Bundle r5 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0065 }
            java.lang.String r1 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r5.getBoolean(r1)     // Catch:{ NameNotFoundException -> 0x0065 }
            goto L_0x003a
        L_0x0065:
            r5 = move-exception
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r3 = "Unable to get PackageManager. Falling through"
            r1.mo25713d(r3, r5)
        L_0x006f:
            r5 = 1
        L_0x0070:
            r4.crashlyticsDataCollectionEnabled = r5
            r4.crashlyticsDataCollectionExplicitlySet = r0
            java.lang.Object r5 = r4.taskLock
            monitor-enter(r5)
            boolean r0 = r4.isAutomaticDataCollectionEnabled()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0085
            com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void> r0 = r4.dataCollectionEnabledTask     // Catch:{ all -> 0x0087 }
            r1 = 0
            r0.trySetResult(r1)     // Catch:{ all -> 0x0087 }
            r4.taskResolved = r2     // Catch:{ all -> 0x0087 }
        L_0x0085:
            monitor-exit(r5)     // Catch:{ all -> 0x0087 }
            return
        L_0x0087:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0087 }
            throw r0
        L_0x008a:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r5.<init>(r0)
            goto L_0x0093
        L_0x0092:
            throw r5
        L_0x0093:
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.DataCollectionArbiter.<init>(com.google.firebase.FirebaseApp):void");
    }

    public void grantDataCollectionPermission(boolean z) {
        if (z) {
            this.dataCollectionExplicitlyApproved.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public boolean isAutomaticDataCollectionEnabled() {
        return this.crashlyticsDataCollectionExplicitlySet ? this.crashlyticsDataCollectionEnabled : this.firebaseApp.isDataCollectionDefaultEnabled();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void setCrashlyticsDataCollectionEnabled(boolean z) {
        this.crashlyticsDataCollectionEnabled = z;
        this.crashlyticsDataCollectionExplicitlySet = true;
        this.sharedPreferences.edit().putBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, z).commit();
        synchronized (this.taskLock) {
            if (z) {
                if (!this.taskResolved) {
                    this.dataCollectionEnabledTask.trySetResult(null);
                    this.taskResolved = true;
                }
            } else if (this.taskResolved) {
                this.dataCollectionEnabledTask = new TaskCompletionSource<>();
                this.taskResolved = false;
            }
        }
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.taskLock) {
            task = this.dataCollectionEnabledTask.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission() {
        return Utils.race(this.dataCollectionExplicitlyApproved.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
