package com.google.firebase.messaging;

import com.google.android.datatransport.cct.C0569a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.platforminfo.UserAgentPublisher;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.C0880g;

final /* synthetic */ class zzn implements ComponentFactory {
    static final ComponentFactory zza = new zzn();

    private zzn() {
    }

    public final Object create(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class);
        UserAgentPublisher userAgentPublisher = (UserAgentPublisher) componentContainer.get(UserAgentPublisher.class);
        HeartBeatInfo heartBeatInfo = (HeartBeatInfo) componentContainer.get(HeartBeatInfo.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class);
        C0880g gVar = (C0880g) componentContainer.get(C0880g.class);
        if (gVar == null || !C0569a.f126g.mo9430a().contains(C0875b.m1149a("json"))) {
            gVar = new FirebaseMessagingRegistrar.zzb();
        }
        return new FirebaseMessaging(firebaseApp, firebaseInstanceId, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi, gVar);
    }
}
