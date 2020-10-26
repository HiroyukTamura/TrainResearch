// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase;

import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzby;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zzt;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;

public final class FirebaseOptions
{
    private final String zzaoM;
    private final String zzbVj;
    private final String zzbVk;
    private final String zzbVl;
    private final String zzbVm;
    private final String zzbVn;
    private final String zzbVo;
    
    private FirebaseOptions(@NonNull final String zzaoM, @NonNull final String zzbVj, @Nullable final String zzbVk, @Nullable final String zzbVl, @Nullable final String zzbVm, @Nullable final String zzbVn, @Nullable final String zzbVo) {
        zzbo.zza(!zzt.zzcL(zzaoM), (Object)"ApplicationId must be set.");
        this.zzaoM = zzaoM;
        this.zzbVj = zzbVj;
        this.zzbVk = zzbVk;
        this.zzbVl = zzbVl;
        this.zzbVm = zzbVm;
        this.zzbVn = zzbVn;
        this.zzbVo = zzbVo;
    }
    
    public static FirebaseOptions fromResource(final Context context) {
        final zzby zzby = new zzby(context);
        final String string = zzby.getString("google_app_id");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        return new FirebaseOptions(string, zzby.getString("google_api_key"), zzby.getString("firebase_database_url"), zzby.getString("ga_trackingId"), zzby.getString("gcm_defaultSenderId"), zzby.getString("google_storage_bucket"), zzby.getString("project_id"));
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o instanceof FirebaseOptions) {
            final FirebaseOptions firebaseOptions = (FirebaseOptions)o;
            if (zzbe.equal(this.zzaoM, firebaseOptions.zzaoM) && zzbe.equal(this.zzbVj, firebaseOptions.zzbVj) && zzbe.equal(this.zzbVk, firebaseOptions.zzbVk) && zzbe.equal(this.zzbVl, firebaseOptions.zzbVl) && zzbe.equal(this.zzbVm, firebaseOptions.zzbVm) && zzbe.equal(this.zzbVn, firebaseOptions.zzbVn) && zzbe.equal(this.zzbVo, firebaseOptions.zzbVo)) {
                return true;
            }
        }
        return false;
    }
    
    public final String getApiKey() {
        return this.zzbVj;
    }
    
    public final String getApplicationId() {
        return this.zzaoM;
    }
    
    public final String getDatabaseUrl() {
        return this.zzbVk;
    }
    
    public final String getGcmSenderId() {
        return this.zzbVm;
    }
    
    public final String getProjectId() {
        return this.zzbVo;
    }
    
    public final String getStorageBucket() {
        return this.zzbVn;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzaoM, this.zzbVj, this.zzbVk, this.zzbVl, this.zzbVm, this.zzbVn, this.zzbVo });
    }
    
    @Override
    public final String toString() {
        return zzbe.zzt(this).zzg("applicationId", this.zzaoM).zzg("apiKey", this.zzbVj).zzg("databaseUrl", this.zzbVk).zzg("gcmSenderId", this.zzbVm).zzg("storageBucket", this.zzbVn).zzg("projectId", this.zzbVo).toString();
    }
    
    public static final class Builder
    {
        private String zzaoM;
        private String zzbVj;
        private String zzbVk;
        private String zzbVl;
        private String zzbVm;
        private String zzbVn;
        private String zzbVo;
        
        public Builder() {
        }
        
        public Builder(final FirebaseOptions firebaseOptions) {
            this.zzaoM = firebaseOptions.zzaoM;
            this.zzbVj = firebaseOptions.zzbVj;
            this.zzbVk = firebaseOptions.zzbVk;
            this.zzbVl = firebaseOptions.zzbVl;
            this.zzbVm = firebaseOptions.zzbVm;
            this.zzbVn = firebaseOptions.zzbVn;
            this.zzbVo = firebaseOptions.zzbVo;
        }
        
        public final FirebaseOptions build() {
            return new FirebaseOptions(this.zzaoM, this.zzbVj, this.zzbVk, this.zzbVl, this.zzbVm, this.zzbVn, this.zzbVo, null);
        }
        
        public final Builder setApiKey(@NonNull final String s) {
            this.zzbVj = zzbo.zzh(s, "ApiKey must be set.");
            return this;
        }
        
        public final Builder setApplicationId(@NonNull final String s) {
            this.zzaoM = zzbo.zzh(s, "ApplicationId must be set.");
            return this;
        }
        
        public final Builder setDatabaseUrl(@Nullable final String zzbVk) {
            this.zzbVk = zzbVk;
            return this;
        }
        
        public final Builder setGcmSenderId(@Nullable final String zzbVm) {
            this.zzbVm = zzbVm;
            return this;
        }
        
        public final Builder setProjectId(@Nullable final String zzbVo) {
            this.zzbVo = zzbVo;
            return this;
        }
        
        public final Builder setStorageBucket(@Nullable final String zzbVn) {
            this.zzbVn = zzbVn;
            return this;
        }
    }
}
