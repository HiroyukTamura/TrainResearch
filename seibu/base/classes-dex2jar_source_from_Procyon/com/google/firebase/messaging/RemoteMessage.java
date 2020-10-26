// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.messaging;

import android.support.annotation.Nullable;
import android.net.Uri;
import com.google.firebase.iid.FirebaseInstanceId;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.util.Log;
import java.util.Iterator;
import android.support.v4.util.ArrayMap;
import java.util.Map;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class RemoteMessage extends zza
{
    public static final Parcelable$Creator<RemoteMessage> CREATOR;
    Bundle mBundle;
    private Map<String, String> zzadY;
    private Notification zzckY;
    
    static {
        CREATOR = (Parcelable$Creator)new zzf();
    }
    
    RemoteMessage(final Bundle mBundle) {
        this.mBundle = mBundle;
    }
    
    public final String getCollapseKey() {
        return this.mBundle.getString("collapse_key");
    }
    
    public final Map<String, String> getData() {
        if (this.zzadY == null) {
            this.zzadY = new ArrayMap<String, String>();
            for (final String s : this.mBundle.keySet()) {
                final Object value = this.mBundle.get(s);
                if (value instanceof String) {
                    final String s2 = (String)value;
                    if (s.startsWith("google.") || s.startsWith("gcm.") || s.equals("from") || s.equals("message_type") || s.equals("collapse_key")) {
                        continue;
                    }
                    this.zzadY.put(s, s2);
                }
            }
        }
        return this.zzadY;
    }
    
    public final String getFrom() {
        return this.mBundle.getString("from");
    }
    
    public final String getMessageId() {
        String s;
        if ((s = this.mBundle.getString("google.message_id")) == null) {
            s = this.mBundle.getString("message_id");
        }
        return s;
    }
    
    public final String getMessageType() {
        return this.mBundle.getString("message_type");
    }
    
    public final Notification getNotification() {
        if (this.zzckY == null && com.google.firebase.messaging.zza.zzG(this.mBundle)) {
            this.zzckY = new Notification(this.mBundle, null);
        }
        return this.zzckY;
    }
    
    public final long getSentTime() {
        final Object value = this.mBundle.get("google.sent_time");
        if (value instanceof Long) {
            return (long)value;
        }
        if (value instanceof String) {
            try {
                return Long.parseLong((String)value);
            }
            catch (NumberFormatException ex) {
                final String value2 = String.valueOf(value);
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(value2).length() + 19).append("Invalid sent time: ").append(value2).toString());
            }
        }
        return 0L;
    }
    
    public final String getTo() {
        return this.mBundle.getString("google.to");
    }
    
    public final int getTtl() {
        final Object value = this.mBundle.get("google.ttl");
        if (value instanceof Integer) {
            return (int)value;
        }
        if (value instanceof String) {
            try {
                return Integer.parseInt((String)value);
            }
            catch (NumberFormatException ex) {
                final String value2 = String.valueOf(value);
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(value2).length() + 13).append("Invalid TTL: ").append(value2).toString());
            }
        }
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.mBundle, false);
        zzd.zzI(parcel, zze);
    }
    
    public static class Builder
    {
        private final Bundle mBundle;
        private final Map<String, String> zzadY;
        
        public Builder(String s) {
            this.mBundle = new Bundle();
            this.zzadY = new ArrayMap<String, String>();
            if (TextUtils.isEmpty((CharSequence)s)) {
                s = String.valueOf(s);
                if (s.length() != 0) {
                    s = "Invalid to: ".concat(s);
                }
                else {
                    s = new String("Invalid to: ");
                }
                throw new IllegalArgumentException(s);
            }
            this.mBundle.putString("google.to", s);
        }
        
        public Builder addData(final String s, final String s2) {
            this.zzadY.put(s, s2);
            return this;
        }
        
        public RemoteMessage build() {
            final Bundle bundle = new Bundle();
            for (final Map.Entry<String, String> entry : this.zzadY.entrySet()) {
                bundle.putString((String)entry.getKey(), (String)entry.getValue());
            }
            bundle.putAll(this.mBundle);
            final String token = FirebaseInstanceId.getInstance().getToken();
            if (token != null) {
                this.mBundle.putString("from", token);
            }
            else {
                this.mBundle.remove("from");
            }
            return new RemoteMessage(bundle);
        }
        
        public Builder clearData() {
            this.zzadY.clear();
            return this;
        }
        
        public Builder setCollapseKey(final String s) {
            this.mBundle.putString("collapse_key", s);
            return this;
        }
        
        public Builder setData(final Map<String, String> map) {
            this.zzadY.clear();
            this.zzadY.putAll(map);
            return this;
        }
        
        public Builder setMessageId(final String s) {
            this.mBundle.putString("google.message_id", s);
            return this;
        }
        
        public Builder setMessageType(final String s) {
            this.mBundle.putString("message_type", s);
            return this;
        }
        
        public Builder setTtl(final int i) {
            this.mBundle.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }
    
    public static class Notification
    {
        private final String mTag;
        private final String zzHD;
        private final String zzaoy;
        private final String zzckZ;
        private final String[] zzcla;
        private final String zzclb;
        private final String[] zzclc;
        private final String zzcld;
        private final String zzcle;
        private final String zzclf;
        private final String zzclg;
        private final Uri zzclh;
        
        private Notification(final Bundle bundle) {
            this.zzaoy = com.google.firebase.messaging.zza.zze(bundle, "gcm.n.title");
            this.zzckZ = com.google.firebase.messaging.zza.zzh(bundle, "gcm.n.title");
            this.zzcla = zzk(bundle, "gcm.n.title");
            this.zzHD = com.google.firebase.messaging.zza.zze(bundle, "gcm.n.body");
            this.zzclb = com.google.firebase.messaging.zza.zzh(bundle, "gcm.n.body");
            this.zzclc = zzk(bundle, "gcm.n.body");
            this.zzcld = com.google.firebase.messaging.zza.zze(bundle, "gcm.n.icon");
            this.zzcle = com.google.firebase.messaging.zza.zzI(bundle);
            this.mTag = com.google.firebase.messaging.zza.zze(bundle, "gcm.n.tag");
            this.zzclf = com.google.firebase.messaging.zza.zze(bundle, "gcm.n.color");
            this.zzclg = com.google.firebase.messaging.zza.zze(bundle, "gcm.n.click_action");
            this.zzclh = com.google.firebase.messaging.zza.zzH(bundle);
        }
        
        private static String[] zzk(final Bundle bundle, final String s) {
            final Object[] zzi = com.google.firebase.messaging.zza.zzi(bundle, s);
            if (zzi == null) {
                return null;
            }
            final String[] array = new String[zzi.length];
            for (int i = 0; i < zzi.length; ++i) {
                array[i] = String.valueOf(zzi[i]);
            }
            return array;
        }
        
        @Nullable
        public String getBody() {
            return this.zzHD;
        }
        
        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.zzclc;
        }
        
        @Nullable
        public String getBodyLocalizationKey() {
            return this.zzclb;
        }
        
        @Nullable
        public String getClickAction() {
            return this.zzclg;
        }
        
        @Nullable
        public String getColor() {
            return this.zzclf;
        }
        
        @Nullable
        public String getIcon() {
            return this.zzcld;
        }
        
        @Nullable
        public Uri getLink() {
            return this.zzclh;
        }
        
        @Nullable
        public String getSound() {
            return this.zzcle;
        }
        
        @Nullable
        public String getTag() {
            return this.mTag;
        }
        
        @Nullable
        public String getTitle() {
            return this.zzaoy;
        }
        
        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.zzcla;
        }
        
        @Nullable
        public String getTitleLocalizationKey() {
            return this.zzckZ;
        }
    }
}
