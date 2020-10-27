package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzv();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.Field(mo11969id = 2)
    Bundle zza;
    private Map<String, String> zzb;
    private Notification zzc;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Builder {
        private final Bundle zza = new Bundle();
        private final Map<String, String> zzb = new ArrayMap();

        public Builder(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid to: ".concat(valueOf) : new String("Invalid to: "));
            } else {
                this.zza.putString("google.to", str);
            }
        }

        @NonNull
        public Builder addData(@NonNull String str, @Nullable String str2) {
            this.zzb.put(str, str2);
            return this;
        }

        @NonNull
        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry next : this.zzb.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            bundle.putAll(this.zza);
            this.zza.remove("from");
            return new RemoteMessage(bundle);
        }

        @NonNull
        public Builder clearData() {
            this.zzb.clear();
            return this;
        }

        @NonNull
        public Builder setCollapseKey(@Nullable String str) {
            this.zza.putString("collapse_key", str);
            return this;
        }

        @NonNull
        public Builder setData(@NonNull Map<String, String> map) {
            this.zzb.clear();
            this.zzb.putAll(map);
            return this;
        }

        @NonNull
        public Builder setMessageId(@NonNull String str) {
            this.zza.putString("google.message_id", str);
            return this;
        }

        @NonNull
        public Builder setMessageType(@Nullable String str) {
            this.zza.putString("message_type", str);
            return this;
        }

        @NonNull
        public Builder setTtl(@IntRange(from = 0, mo685to = 86400) int i) {
            this.zza.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    public static class Notification {
        private final String zza;
        private final String zzb;
        private final String[] zzc;
        private final String zzd;
        private final String zze;
        private final String[] zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final Uri zzn;
        private final String zzo;
        private final Integer zzp;
        private final Integer zzq;
        private final Integer zzr;
        private final int[] zzs;
        private final Long zzt;
        private final boolean zzu;
        private final boolean zzv;
        private final boolean zzw;
        private final boolean zzx;
        private final boolean zzy;
        private final long[] zzz;

        private Notification(zzt zzt2) {
            this.zza = zzt2.zza("gcm.n.title");
            this.zzb = zzt2.zze("gcm.n.title");
            this.zzc = zza(zzt2, "gcm.n.title");
            this.zzd = zzt2.zza("gcm.n.body");
            this.zze = zzt2.zze("gcm.n.body");
            this.zzf = zza(zzt2, "gcm.n.body");
            this.zzg = zzt2.zza("gcm.n.icon");
            this.zzi = zzt2.zzb();
            this.zzj = zzt2.zza("gcm.n.tag");
            this.zzk = zzt2.zza("gcm.n.color");
            this.zzl = zzt2.zza("gcm.n.click_action");
            this.zzm = zzt2.zza("gcm.n.android_channel_id");
            this.zzn = zzt2.zza();
            this.zzh = zzt2.zza("gcm.n.image");
            this.zzo = zzt2.zza("gcm.n.ticker");
            this.zzp = zzt2.zzc("gcm.n.notification_priority");
            this.zzq = zzt2.zzc("gcm.n.visibility");
            this.zzr = zzt2.zzc("gcm.n.notification_count");
            this.zzu = zzt2.zzb("gcm.n.sticky");
            this.zzv = zzt2.zzb("gcm.n.local_only");
            this.zzw = zzt2.zzb("gcm.n.default_sound");
            this.zzx = zzt2.zzb("gcm.n.default_vibrate_timings");
            this.zzy = zzt2.zzb("gcm.n.default_light_settings");
            this.zzt = zzt2.zzd("gcm.n.event_time");
            this.zzs = zzt2.zzd();
            this.zzz = zzt2.zzc();
        }

        private static String[] zza(zzt zzt2, String str) {
            Object[] zzf2 = zzt2.zzf(str);
            if (zzf2 == null) {
                return null;
            }
            String[] strArr = new String[zzf2.length];
            for (int i = 0; i < zzf2.length; i++) {
                strArr[i] = String.valueOf(zzf2[i]);
            }
            return strArr;
        }

        @Nullable
        public String getBody() {
            return this.zzd;
        }

        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.zzf;
        }

        @Nullable
        public String getBodyLocalizationKey() {
            return this.zze;
        }

        @Nullable
        public String getChannelId() {
            return this.zzm;
        }

        @Nullable
        public String getClickAction() {
            return this.zzl;
        }

        @Nullable
        public String getColor() {
            return this.zzk;
        }

        public boolean getDefaultLightSettings() {
            return this.zzy;
        }

        public boolean getDefaultSound() {
            return this.zzw;
        }

        public boolean getDefaultVibrateSettings() {
            return this.zzx;
        }

        @Nullable
        public Long getEventTime() {
            return this.zzt;
        }

        @Nullable
        public String getIcon() {
            return this.zzg;
        }

        @Nullable
        public Uri getImageUrl() {
            String str = this.zzh;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        @Nullable
        public int[] getLightSettings() {
            return this.zzs;
        }

        @Nullable
        public Uri getLink() {
            return this.zzn;
        }

        public boolean getLocalOnly() {
            return this.zzv;
        }

        @Nullable
        public Integer getNotificationCount() {
            return this.zzr;
        }

        @Nullable
        public Integer getNotificationPriority() {
            return this.zzp;
        }

        @Nullable
        public String getSound() {
            return this.zzi;
        }

        public boolean getSticky() {
            return this.zzu;
        }

        @Nullable
        public String getTag() {
            return this.zzj;
        }

        @Nullable
        public String getTicker() {
            return this.zzo;
        }

        @Nullable
        public String getTitle() {
            return this.zza;
        }

        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.zzc;
        }

        @Nullable
        public String getTitleLocalizationKey() {
            return this.zzb;
        }

        @Nullable
        public long[] getVibrateTimings() {
            return this.zzz;
        }

        @Nullable
        public Integer getVisibility() {
            return this.zzq;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(mo11972id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    private static int zza(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public final String getCollapseKey() {
        return this.zza.getString("collapse_key");
    }

    @NonNull
    public final Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle bundle = this.zza;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    @Nullable
    public final String getFrom() {
        return this.zza.getString("from");
    }

    @Nullable
    public final String getMessageId() {
        String string = this.zza.getString("google.message_id");
        return string == null ? this.zza.getString("message_id") : string;
    }

    @Nullable
    public final String getMessageType() {
        return this.zza.getString("message_type");
    }

    @Nullable
    public final Notification getNotification() {
        if (this.zzc == null && zzt.zza(this.zza)) {
            this.zzc = new Notification(new zzt(this.zza));
        }
        return this.zzc;
    }

    public final int getOriginalPriority() {
        String string = this.zza.getString("google.original_priority");
        if (string == null) {
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final int getPriority() {
        String string = this.zza.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.zza.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final long getSentTime() {
        Object obj = this.zza.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(valueOf.length() + 19);
            sb.append("Invalid sent time: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    @Nullable
    public final String getTo() {
        return this.zza.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.zza.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(valueOf.length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    @KeepForSdk
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.zza);
        return intent;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
