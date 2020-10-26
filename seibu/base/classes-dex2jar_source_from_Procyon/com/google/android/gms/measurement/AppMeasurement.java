// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.measurement;

import android.support.annotation.MainThread;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.android.gms.internal.zzcjl;
import com.google.android.gms.internal.zzcem;
import java.util.Iterator;
import com.google.android.gms.internal.zzcji;
import android.support.v4.util.ArrayMap;
import java.util.Map;
import com.google.android.gms.internal.zzchl;
import com.google.android.gms.internal.zzbdm;
import android.support.annotation.WorkerThread;
import java.util.List;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzcgl;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.support.annotation.Keep;

@Deprecated
@Keep
public class AppMeasurement
{
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    private final zzcgl zzboe;
    
    public AppMeasurement(final zzcgl zzboe) {
        zzbo.zzu(zzboe);
        this.zzboe = zzboe;
    }
    
    @Deprecated
    @Keep
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK" })
    public static AppMeasurement getInstance(final Context context) {
        return zzcgl.zzbj(context).zzyS();
    }
    
    @Keep
    public void beginAdUnitExposure(@NonNull @Size(min = 1L) final String s) {
        this.zzboe.zzwr().beginAdUnitExposure(s);
    }
    
    @Keep
    protected void clearConditionalUserProperty(@NonNull @Size(max = 24L, min = 1L) final String s, @Nullable final String s2, @Nullable final Bundle bundle) {
        this.zzboe.zzwt().clearConditionalUserProperty(s, s2, bundle);
    }
    
    @Keep
    protected void clearConditionalUserPropertyAs(@NonNull @Size(min = 1L) final String s, @NonNull @Size(max = 24L, min = 1L) final String s2, @Nullable final String s3, @Nullable final Bundle bundle) {
        this.zzboe.zzwt().clearConditionalUserPropertyAs(s, s2, s3, bundle);
    }
    
    @Keep
    public void endAdUnitExposure(@NonNull @Size(min = 1L) final String s) {
        this.zzboe.zzwr().endAdUnitExposure(s);
    }
    
    @Keep
    public long generateEventId() {
        return this.zzboe.zzwB().zzzs();
    }
    
    @Keep
    @Nullable
    public String getAppInstanceId() {
        return this.zzboe.zzwt().zzyH();
    }
    
    @Keep
    @WorkerThread
    protected List<ConditionalUserProperty> getConditionalUserProperties(@Nullable final String s, @Nullable @Size(max = 23L, min = 1L) final String s2) {
        return this.zzboe.zzwt().getConditionalUserProperties(s, s2);
    }
    
    @Keep
    @WorkerThread
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(@NonNull @Size(min = 1L) final String s, @Nullable final String s2, @Nullable @Size(max = 23L, min = 1L) final String s3) {
        return this.zzboe.zzwt().getConditionalUserPropertiesAs(s, s2, s3);
    }
    
    @Keep
    @Nullable
    public String getCurrentScreenClass() {
        final zzb zzzi = this.zzboe.zzwx().zzzi();
        if (zzzi != null) {
            return zzzi.zzbok;
        }
        return null;
    }
    
    @Keep
    @Nullable
    public String getCurrentScreenName() {
        final zzb zzzi = this.zzboe.zzwx().zzzi();
        if (zzzi != null) {
            return zzzi.zzboj;
        }
        return null;
    }
    
    @Keep
    @Nullable
    public String getGmpAppId() {
        try {
            return zzbdm.zzqA();
        }
        catch (IllegalStateException ex) {
            this.zzboe.zzwF().zzyx().zzj("getGoogleAppId failed with exception", ex);
            return null;
        }
    }
    
    @Keep
    @WorkerThread
    protected int getMaxUserProperties(@NonNull @Size(min = 1L) final String s) {
        this.zzboe.zzwt();
        return zzchl.getMaxUserProperties(s);
    }
    
    @Keep
    @WorkerThread
    protected Map<String, Object> getUserProperties(@Nullable final String s, @Nullable @Size(max = 24L, min = 1L) final String s2, final boolean b) {
        return this.zzboe.zzwt().getUserProperties(s, s2, b);
    }
    
    @WorkerThread
    @KeepForSdk
    public Map<String, Object> getUserProperties(final boolean b) {
        final List<zzcji> zzao = this.zzboe.zzwt().zzao(b);
        final ArrayMap arrayMap = new ArrayMap<String, Object>(zzao.size());
        for (final zzcji zzcji : zzao) {
            arrayMap.put(zzcji.name, zzcji.getValue());
        }
        return (Map<String, Object>)arrayMap;
    }
    
    @Keep
    @WorkerThread
    protected Map<String, Object> getUserPropertiesAs(@NonNull @Size(min = 1L) final String s, @Nullable final String s2, @Nullable @Size(max = 23L, min = 1L) final String s3, final boolean b) {
        return this.zzboe.zzwt().getUserPropertiesAs(s, s2, s3, b);
    }
    
    public final void logEvent(@NonNull @Size(max = 40L, min = 1L) final String anObject, final Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        zzcem.zzxE();
        if (!"_iap".equals(anObject)) {
            final int zzep = this.zzboe.zzwB().zzep(anObject);
            if (zzep != 0) {
                this.zzboe.zzwB();
                final String zza = zzcjl.zza(anObject, zzcem.zzxh(), true);
                int length;
                if (anObject != null) {
                    length = anObject.length();
                }
                else {
                    length = 0;
                }
                this.zzboe.zzwB().zza(zzep, "_ev", zza, length);
                return;
            }
        }
        this.zzboe.zzwt().zza("app", anObject, bundle2, true);
    }
    
    @Keep
    public void logEventInternal(final String s, final String s2, final Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        this.zzboe.zzwt().zzd(s, s2, bundle2);
    }
    
    @KeepForSdk
    public void logEventInternalNoInterceptor(final String s, final String s2, Bundle bundle, final long n) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzboe.zzwt().zza(s, s2, bundle, n);
    }
    
    @KeepForSdk
    public void registerOnMeasurementEventListener(final OnEventListener onEventListener) {
        this.zzboe.zzwt().registerOnMeasurementEventListener(onEventListener);
    }
    
    @Keep
    public void registerOnScreenChangeCallback(@NonNull final zza zza) {
        this.zzboe.zzwx().registerOnScreenChangeCallback(zza);
    }
    
    @Keep
    protected void setConditionalUserProperty(@NonNull final ConditionalUserProperty conditionalUserProperty) {
        this.zzboe.zzwt().setConditionalUserProperty(conditionalUserProperty);
    }
    
    @Keep
    protected void setConditionalUserPropertyAs(@NonNull final ConditionalUserProperty conditionalUserPropertyAs) {
        this.zzboe.zzwt().setConditionalUserPropertyAs(conditionalUserPropertyAs);
    }
    
    @WorkerThread
    @KeepForSdk
    public void setEventInterceptor(final EventInterceptor eventInterceptor) {
        this.zzboe.zzwt().setEventInterceptor(eventInterceptor);
    }
    
    @Deprecated
    public void setMeasurementEnabled(final boolean measurementEnabled) {
        this.zzboe.zzwt().setMeasurementEnabled(measurementEnabled);
    }
    
    public final void setMinimumSessionDuration(final long minimumSessionDuration) {
        this.zzboe.zzwt().setMinimumSessionDuration(minimumSessionDuration);
    }
    
    public final void setSessionTimeoutDuration(final long sessionTimeoutDuration) {
        this.zzboe.zzwt().setSessionTimeoutDuration(sessionTimeoutDuration);
    }
    
    public final void setUserProperty(@NonNull @Size(max = 24L, min = 1L) final String s, @Nullable @Size(max = 36L) String zza) {
        final int zzer = this.zzboe.zzwB().zzer(s);
        if (zzer != 0) {
            this.zzboe.zzwB();
            zza = zzcjl.zza(s, zzcem.zzxi(), true);
            int length;
            if (s != null) {
                length = s.length();
            }
            else {
                length = 0;
            }
            this.zzboe.zzwB().zza(zzer, "_ev", zza, length);
            return;
        }
        this.setUserPropertyInternal("app", s, zza);
    }
    
    @KeepForSdk
    public void setUserPropertyInternal(final String s, final String s2, final Object o) {
        this.zzboe.zzwt().zzb(s, s2, o);
    }
    
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(final OnEventListener onEventListener) {
        this.zzboe.zzwt().unregisterOnMeasurementEventListener(onEventListener);
    }
    
    @Keep
    public void unregisterOnScreenChangeCallback(@NonNull final zza zza) {
        this.zzboe.zzwx().unregisterOnScreenChangeCallback(zza);
    }
    
    public static class ConditionalUserProperty
    {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;
        
        public ConditionalUserProperty() {
        }
        
        public ConditionalUserProperty(final ConditionalUserProperty conditionalUserProperty) {
            zzbo.zzu(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzcjl.zzD(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mValue = conditionalUserProperty.mValue;
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }
    
    @KeepForSdk
    public static final class Event extends FirebaseAnalytics.Event
    {
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";
        public static final String[] zzbof;
        public static final String[] zzbog;
        
        static {
            zzbof = new String[] { "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter" };
            zzbog = new String[] { "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_vs", "_ep" };
        }
        
        private Event() {
        }
        
        public static String zzdF(final String s) {
            return zzcjl.zza(s, Event.zzbof, Event.zzbog);
        }
    }
    
    @KeepForSdk
    public interface EventInterceptor
    {
        @WorkerThread
        @KeepForSdk
        void interceptEvent(final String p0, final String p1, final Bundle p2, final long p3);
    }
    
    @KeepForSdk
    public interface OnEventListener
    {
        @WorkerThread
        @KeepForSdk
        void onEvent(final String p0, final String p1, final Bundle p2, final long p3);
    }
    
    @KeepForSdk
    public static final class Param extends FirebaseAnalytics.Param
    {
        @KeepForSdk
        public static final String FATAL = "fatal";
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";
        public static final String[] zzboh;
        public static final String[] zzboi;
        
        static {
            zzboh = new String[] { "firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "firebase_event_id", "firebase_extra_params_ct", "firebase_group_name", "firebase_list_length", "firebase_index", "firebase_event_name" };
            zzboi = new String[] { "_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en" };
        }
        
        private Param() {
        }
        
        public static String zzdF(final String s) {
            return zzcjl.zza(s, Param.zzboh, Param.zzboi);
        }
    }
    
    @KeepForSdk
    public static final class UserProperty extends FirebaseAnalytics.UserProperty
    {
        @KeepForSdk
        public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
        public static final String[] zzbom;
        public static final String[] zzbon;
        
        static {
            zzbom = new String[] { "firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install" };
            zzbon = new String[] { "_ln", "_fot", "_fvt", "_ldl", "_id", "_fi" };
        }
        
        private UserProperty() {
        }
        
        public static String zzdF(final String s) {
            return zzcjl.zza(s, UserProperty.zzbom, UserProperty.zzbon);
        }
    }
    
    public interface zza
    {
        @MainThread
        boolean zza(final zzb p0, final zzb p1);
    }
    
    public static class zzb
    {
        public String zzboj;
        public String zzbok;
        public long zzbol;
        
        public zzb() {
        }
        
        public zzb(final zzb zzb) {
            this.zzboj = zzb.zzboj;
            this.zzbok = zzb.zzbok;
            this.zzbol = zzb.zzbol;
        }
    }
}
