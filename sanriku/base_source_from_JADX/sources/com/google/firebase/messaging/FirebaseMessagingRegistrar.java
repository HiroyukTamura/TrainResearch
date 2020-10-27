package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.C0876c;
import p009e.p028d.p030b.p031a.C0878e;
import p009e.p028d.p030b.p031a.C0879f;
import p009e.p028d.p030b.p031a.C0880g;
import p009e.p028d.p030b.p031a.C0881h;

@KeepForSdk
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    private static class zza<T> implements C0879f<T> {
        private zza() {
        }

        public final void schedule(C0876c<T> cVar, C0881h hVar) {
            hVar.onSchedule((Exception) null);
        }

        public final void send(C0876c<T> cVar) {
        }
    }

    @VisibleForTesting
    public static class zzb implements C0880g {
        public final <T> C0879f<T> getTransport(String str, Class<T> cls, C0875b bVar, C0878e<T, byte[]> eVar) {
            return new zza();
        }

        public final <T> C0879f<T> getTransport(String str, Class<T> cls, C0878e<T, byte[]> eVar) {
            return new zza();
        }
    }

    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseMessaging.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstanceId.class)).add(Dependency.required(UserAgentPublisher.class)).add(Dependency.required(HeartBeatInfo.class)).add(Dependency.optional(C0880g.class)).add(Dependency.required(FirebaseInstallationsApi.class)).factory(zzn.zza).alwaysEager().build(), LibraryVersionComponent.create("fire-fcm", "20.1.7")});
    }
}
