package com.google.firebase.messaging;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

@KeepForSdk
final class FirelogAnalyticsEvent {
    private final String zza;
    private final Intent zzb;

    static final class zza {
        private final FirelogAnalyticsEvent zza;

        zza(@NonNull FirelogAnalyticsEvent firelogAnalyticsEvent) {
            this.zza = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final FirelogAnalyticsEvent zza() {
            return this.zza;
        }
    }

    static class zzb implements ObjectEncoder<FirelogAnalyticsEvent> {
        zzb() {
        }

        public final /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
            FirelogAnalyticsEvent firelogAnalyticsEvent = (FirelogAnalyticsEvent) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            Intent zza = firelogAnalyticsEvent.zza();
            objectEncoderContext.add("ttl", zzr.zzf(zza));
            objectEncoderContext.add("event", (Object) firelogAnalyticsEvent.zzb());
            objectEncoderContext.add("instanceId", (Object) zzr.zzc());
            objectEncoderContext.add("priority", zzr.zzm(zza));
            objectEncoderContext.add("packageName", (Object) zzr.zzb());
            objectEncoderContext.add("sdkPlatform", (Object) "ANDROID");
            objectEncoderContext.add("messageType", (Object) zzr.zzk(zza));
            String zzj = zzr.zzj(zza);
            if (zzj != null) {
                objectEncoderContext.add("messageId", (Object) zzj);
            }
            String zzl = zzr.zzl(zza);
            if (zzl != null) {
                objectEncoderContext.add("topic", (Object) zzl);
            }
            String zzg = zzr.zzg(zza);
            if (zzg != null) {
                objectEncoderContext.add("collapseKey", (Object) zzg);
            }
            if (zzr.zzi(zza) != null) {
                objectEncoderContext.add("analyticsLabel", (Object) zzr.zzi(zza));
            }
            if (zzr.zzh(zza) != null) {
                objectEncoderContext.add("composerLabel", (Object) zzr.zzh(zza));
            }
            String zzd = zzr.zzd();
            if (zzd != null) {
                objectEncoderContext.add("projectNumber", (Object) zzd);
            }
        }
    }

    static final class zzc implements ObjectEncoder<zza> {
        zzc() {
        }

        public final /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("messaging_client_event", (Object) ((zza) obj).zza());
        }
    }

    FirelogAnalyticsEvent(@NonNull String str, @NonNull Intent intent) {
        this.zza = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.zzb = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final Intent zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final String zzb() {
        return this.zza;
    }
}
