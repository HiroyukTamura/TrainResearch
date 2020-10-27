package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzao;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p009e.p028d.p030b.p031a.C0880g;

public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    @VisibleForTesting
    @SuppressLint({"FirebaseUnknownNullness"})
    @Nullable
    static C0880g zza;
    private final Context zzb;
    private final FirebaseInstanceId zzc;
    private final Task<zzab> zzd;

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable C0880g gVar) {
        zza = gVar;
        this.zzc = firebaseInstanceId;
        Context applicationContext = firebaseApp.getApplicationContext();
        this.zzb = applicationContext;
        Task<zzab> zza2 = zzab.zza(firebaseApp, firebaseInstanceId, new zzao(applicationContext), userAgentPublisher, heartBeatInfo, firebaseInstallationsApi, this.zzb, zzi.zza(), new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
        this.zzd = zza2;
        zza2.addOnSuccessListener(zzi.zzb(), (OnSuccessListener<? super zzab>) new zzk(this));
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(cls);
        }
        return firebaseMessaging;
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return zzr.zza();
    }

    public boolean isAutoInitEnabled() {
        return this.zzc.zzh();
    }

    public void send(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra("app", PendingIntent.getBroadcast(this.zzb, 0, intent2, 0));
            intent.setPackage("com.google.android.gms");
            intent.putExtras(remoteMessage.zza);
            this.zzb.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z) {
        this.zzc.zzb(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        zzr.zza(z);
    }

    @NonNull
    public Task<Void> subscribeToTopic(@NonNull String str) {
        return this.zzd.onSuccessTask(new zzm(str));
    }

    @NonNull
    public Task<Void> unsubscribeFromTopic(@NonNull String str) {
        return this.zzd.onSuccessTask(new zzl(str));
    }
}
