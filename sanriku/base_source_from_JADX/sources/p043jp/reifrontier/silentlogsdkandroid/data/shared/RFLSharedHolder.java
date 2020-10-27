package p043jp.reifrontier.silentlogsdkandroid.data.shared;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLExtra;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLUserProfile;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherCategory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010E\u001a\u00020\u0004J\u0006\u0010F\u001a\u000200J\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u0006\u0010J\u001a\u00020\u0004J\u0006\u0010K\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020HJ\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040PJ\u0006\u0010Q\u001a\u00020RJ\u0006\u0010S\u001a\u00020\u0004J\u0006\u0010T\u001a\u00020\u0004J\u0006\u0010U\u001a\u00020RJ\u000e\u0010V\u001a\u00020M2\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020HJ\u0006\u0010Z\u001a\u00020RJ\u0006\u0010[\u001a\u00020RJ\u0006\u0010\\\u001a\u00020RJ\u0006\u0010]\u001a\u00020RJ\u0006\u0010^\u001a\u00020HJ\u0006\u0010_\u001a\u00020\u0004J\u0006\u0010`\u001a\u00020\u0004J\b\u0010a\u001a\u0004\u0018\u00010\u0004J\u0006\u0010b\u001a\u00020RJ\u0006\u0010c\u001a\u000200J\b\u0010d\u001a\u0004\u0018\u00010eJ\b\u0010f\u001a\u0004\u0018\u00010gJ\u0006\u0010h\u001a\u00020RJ\u0006\u0010i\u001a\u00020\u0004J\u0018\u0010j\u001a\u00020M2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004H\u0002J\u000e\u0010l\u001a\u00020M2\u0006\u0010E\u001a\u00020\u0004J\u000e\u0010m\u001a\u00020M2\u0006\u0010n\u001a\u000200J\u000e\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020HJ\u000e\u0010q\u001a\u00020M2\u0006\u0010r\u001a\u00020RJ\u0018\u0010s\u001a\u00020M2\u0006\u0010/\u001a\u00020R2\u0006\u0010k\u001a\u00020\u0004H\u0002J\u000e\u0010t\u001a\u00020M2\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010u\u001a\u00020M2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010v\u001a\u00020M2\u0006\u0010K\u001a\u00020\u0004J\u000e\u0010w\u001a\u00020M2\u0006\u0010r\u001a\u00020RJ\u000e\u0010x\u001a\u00020M2\u0006\u0010^\u001a\u00020HJ\u001a\u0010y\u001a\u00020M2\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040PJ\u000e\u0010{\u001a\u00020M2\u0006\u0010S\u001a\u00020\u0004J\u000e\u0010|\u001a\u00020M2\u0006\u0010T\u001a\u00020\u0004J\u000e\u0010}\u001a\u00020M2\u0006\u0010U\u001a\u00020RJ\u000e\u0010~\u001a\u00020M2\u0006\u0010Y\u001a\u00020HJ\u0018\u0010\u001a\u00020M2\u0006\u0010/\u001a\u0002002\u0006\u0010k\u001a\u00020\u0004H\u0002J\u0019\u0010\u0001\u001a\u00020M2\u0006\u0010/\u001a\u00020H2\u0006\u0010k\u001a\u00020\u0004H\u0002J\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020RJ\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010^\u001a\u00020HJ\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020RJ\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010_\u001a\u00020\u0004J\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010`\u001a\u00020\u0004J\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010a\u001a\u00020\u0004J\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010r\u001a\u00020RJ\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u000200J\u0012\u0010\u0001\u001a\u00020M2\t\u0010\u0001\u001a\u0004\u0018\u00010eJ\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020gJ\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010h\u001a\u00020RJ\u000f\u0010\u0001\u001a\u00020M2\u0006\u0010i\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020RJ\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020RJ\"\u0010\u0001\u001a\u00020M2\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010 \u0001\u001a\u00020\u00042\u0007\u0010¡\u0001\u001a\u00020\u0004J\u0010\u0010¢\u0001\u001a\u00020M2\u0007\u0010£\u0001\u001a\u00020\u0004J\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0007\u0010\u0001\u001a\u00020\u0004J\u0007\u0010¥\u0001\u001a\u00020\u0004J\u0007\u0010\u0001\u001a\u00020RJ\u0007\u0010\u0001\u001a\u00020RJ\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001J\u0007\u0010£\u0001\u001a\u00020\u0004J\u0007\u0010\u0001\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u0002002\u0006\u0010/\u001a\u0002008F@FX\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0002062\u0006\u0010/\u001a\u0002068F@FX\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\\\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010<j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`=2\"\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010<j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`=8F@FX\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006¨\u0001"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/shared/RFLSharedHolder;", "", "()V", "KEY_ACCESS_TOKEN", "", "KEY_AD_ENTRY_TYPE", "KEY_AD_TRIGGER_REQUEST_TIME", "KEY_ALTITUDE_PREDICTION", "KEY_BASE_URL", "KEY_CLIENT_ID", "KEY_CLIENT_SECRET", "KEY_EXTRA_PARAMETER", "KEY_FIRST_LAUNCH", "KEY_FORECAST_LAST_UPDATE_TIME", "KEY_FORECAST_WEATHER_CATEGORY", "KEY_FOREGROUND", "KEY_FOR_EVENT", "KEY_FOR_GRANT", "KEY_FOR_LOAD_DAILY_TIME", "KEY_FOR_PREDICT", "KEY_GEO_FENCE", "KEY_INSTALL_DATE", "KEY_LOCATION_JAPAN_ONLY", "KEY_LOCATION_TEMPERATURE", "KEY_PASSWORD", "KEY_POINT_URL", "KEY_PRIORITY_TYPE", "KEY_PROFILE_EXTRA_KEY", "KEY_PROFILE_PRIVATE_KEY", "KEY_SEND_PUSH_TOKEN", "KEY_SERVICE", "KEY_SILENT_LOG_USER_ID", "KEY_TEMP_PUSH_TOKEN", "KEY_TRACKING", "KEY_TWO_WEEK_SETTING", "KEY_USERNAME", "KEY_USER_BIRTH_DAY", "KEY_USER_DATA_POINT_SYSTEM_KEY", "KEY_USER_DATA_SL2ID", "KEY_USER_FIRST_DATE", "KEY_USER_GENDER", "KEY_USE_ADVERTISING_ID", "KEY_UUID_STRING", "SDK_SCHEME", "SHARED", "Landroid/content/SharedPreferences;", "accessTokenValue", "value", "", "forecastLastUpdateTime", "getForecastLastUpdateTime", "()I", "setForecastLastUpdateTime", "(I)V", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherCategory;", "forecastWeatherCategory", "getForecastWeatherCategory", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherCategory;", "setForecastWeatherCategory", "(Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherCategory;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "locationTemperature", "getLocationTemperature", "()Ljava/util/HashMap;", "setLocationTemperature", "(Ljava/util/HashMap;)V", "passwordValue", "usernameValue", "accessToken", "adEntryType", "adTriggerRequestTime", "", "baseUrl", "clientId", "clientSecret", "deleteAll", "", "eventTime", "extraParameter", "", "firstLaunch", "", "foregroundName", "geofenceName", "grant", "initialize", "context", "Landroid/content/Context;", "installDate", "isEnableAltitudePrediction", "isEnableTwoWeekSetting", "isLocationJapanOnly", "isMilePointAuth", "loadTime", "password", "pointSystemKey", "pointUrl", "predict", "priorityType", "profileExtraKey", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLExtra;", "profilePrivateKey", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "sendPushToken", "serviceName", "set", "key", "setAccessToken", "setAdEntryType", "entryType", "setAdTriggerRequestTime", "timeInMillis", "setAltitudePrediction", "enable", "setB", "setBaseUrl", "setClientId", "setClientSecret", "setEnableTwoWeekSetting", "setEventTime", "setExtraParameter", "params", "setForegroundName", "setGeoFenceName", "setGrant", "setInstallDate", "setInt", "setL", "setLaunch", "launch", "setLoadTime", "setLocationJapanOnly", "japanOnly", "setPassword", "setPointSystemKey", "setPointUrl", "setPrediction", "setPriorityType", "type", "setProfileExtraKey", "extraKey", "setProfilePrivateKey", "privateKey", "setSendPushToken", "setServiceName", "setSilentLogUserId", "userId", "setSl2Id", "sl2Id", "setTempPushToken", "tokenString", "setTracking", "tracking", "setUUID", "uuid", "setUseAdvertisingId", "useAdvertisingId", "setUserProfile", "gender", "birthDay", "firstDate", "setUsername", "username", "silentLogUserId", "tempPushToken", "userProfile", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLUserProfile;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder */
public final class RFLSharedHolder {
    public static final RFLSharedHolder INSTANCE = new RFLSharedHolder();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static SharedPreferences f3342a;

    /* renamed from: b */
    private static String f3343b = RFLAccountManager.DEFAULT_ACCESS_TOKEN;

    /* renamed from: c */
    private static String f3344c = "";

    /* renamed from: d */
    private static String f3345d = "";

    private RFLSharedHolder() {
    }

    /* renamed from: a */
    private final void m3814a(int i, String str) {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    /* renamed from: a */
    private final void m3815a(long j, String str) {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    /* renamed from: a */
    private final void m3816a(String str, String str2) {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str2, str);
        edit.apply();
    }

    /* renamed from: a */
    private final void m3817a(boolean z, String str) {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static final /* synthetic */ SharedPreferences access$getSHARED$p(RFLSharedHolder rFLSharedHolder) {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences;
    }

    public final String accessToken() {
        return f3343b;
    }

    public final int adEntryType() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getInt("kKey_AD_ENTRY_TYPE", 0);
    }

    public final long adTriggerRequestTime() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getLong("kKey_AD_TRIGGER_REQUEST_TIME", 0);
    }

    public final String baseUrl() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getString("kRFL_KEY_BASE_URL", (String) null);
    }

    public final String clientId() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_CLIENT_ID", (String) null);
        return string != null ? string : "clientId";
    }

    public final String clientSecret() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_CLIENT_SECRET", (String) null);
        return string != null ? string : "clientSecret";
    }

    public final void deleteAll() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().clear().apply();
    }

    public final long eventTime() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getLong("kRFL_KEY_FOR_EVENT", 0);
    }

    public final Map<String, String> extraParameter() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        Map<String, String> map = null;
        String string = sharedPreferences.getString("kRFL_KEY_EXTRA_PARAMETER", (String) null);
        if (string != null) {
            Object fromJson = new Gson().fromJson(string, Map.class);
            if (fromJson instanceof Map) {
                map = fromJson;
            }
            Map<String, String> map2 = map;
            if (map2 != null) {
                return map2;
            }
        }
        return MapsKt__MapsKt.emptyMap();
    }

    public final boolean firstLaunch() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFL_KEY_FIRST_LAUNCH", false);
    }

    public final String foregroundName() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_FOREGROUND", (String) null);
        return string != null ? string : "geofence";
    }

    public final String geofenceName() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_GEO_FENCE", (String) null);
        return string != null ? string : "geofence";
    }

    public final int getForecastLastUpdateTime() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getInt("kRFLForecastLastUpdateTime", 0);
    }

    public final RFLWeatherCategory getForecastWeatherCategory() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        int i = sharedPreferences.getInt("kRFLForecastWeatherCategory", 0);
        return i < RFLWeatherCategory.values().length ? RFLWeatherCategory.values()[i] : RFLWeatherCategory.NONE;
    }

    public final HashMap<String, Object> getLocationTemperature() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFLLocationTemperature", (String) null);
        if (string == null) {
            return new HashMap<>();
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "SHARED.getString(KEY_LOC…null) ?: return HashMap()");
        Object fromJson = new Gson().fromJson(string, new RFLSharedHolder$locationTemperature$mapType$1().getType());
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(json, mapType)");
        return (HashMap) fromJson;
    }

    public final boolean grant() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFL_KEY_FOR_GRANT", false);
    }

    public final void initialize(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String a = C0681a.m328a(new Object[]{"SilentLogSDK-2", context.getPackageName()}, 2, "%s%s", "java.lang.String.format(this, *args)");
        if (f3342a == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            f3342a = sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = f3342a;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences2.getString("kRFL_KEY_ACCESS_TOKEN", (String) null);
        if (string == null) {
            string = RFLAccountManager.DEFAULT_ACCESS_TOKEN;
        }
        f3343b = string;
        SharedPreferences sharedPreferences3 = f3342a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string2 = sharedPreferences3.getString("kRFL_KEY_USERNAME", (String) null);
        String str = "";
        if (string2 == null) {
            string2 = str;
        }
        f3344c = string2;
        SharedPreferences sharedPreferences4 = f3342a;
        if (sharedPreferences4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string3 = sharedPreferences4.getString("kRFL_KEY_PASSWORD", (String) null);
        if (string3 != null) {
            str = string3;
        }
        f3345d = str;
    }

    public final long installDate() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getLong("kRFL_KEY_INSTALL_DATE", System.currentTimeMillis());
    }

    public final boolean isEnableAltitudePrediction() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFLAltitudePrediction", false);
    }

    public final boolean isEnableTwoWeekSetting() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFLTwoWeekSetting", false);
    }

    public final boolean isLocationJapanOnly() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFLLocationJapanOnly", false);
    }

    public final boolean isMilePointAuth() {
        Boolean mpAuth;
        RFLPrivate profilePrivateKey = profilePrivateKey();
        if (profilePrivateKey == null || (mpAuth = profilePrivateKey.getMpAuth()) == null) {
            return false;
        }
        return mpAuth.booleanValue();
    }

    public final long loadTime() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getLong("kRFL_KEY_FOR_LOAD_DAILY_TIME", 0);
    }

    public final String password() {
        return f3345d;
    }

    public final String pointSystemKey() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFLUserDataPointSystemKey", (String) null);
        return string != null ? string : "systemkey";
    }

    public final String pointUrl() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getString("kRFL_KEY_POINT_URL", (String) null);
    }

    public final boolean predict() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFL_KEY_FOR_PREDICT", false);
    }

    public final int priorityType() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return (int) sharedPreferences.getLong("kRFL_KEY_PRIORITY_TYPE", 1);
    }

    public final RFLExtra profileExtraKey() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_PROFILE_EXTRA_KEY", (String) null);
        if (string == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "SHARED.getString(KEY_PRO…KEY, null) ?: return null");
        return (RFLExtra) new Gson().fromJson(string, RFLExtra.class);
    }

    public final RFLPrivate profilePrivateKey() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_PROFILE_PRIVATE_KEY", (String) null);
        if (string == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "SHARED.getString(KEY_PRO…KEY, null) ?: return null");
        return (RFLPrivate) new Gson().fromJson(string, RFLPrivate.class);
    }

    public final boolean sendPushToken() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFL_KEY_SEND_PUSH_TOKEN", false);
    }

    public final String serviceName() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_SERVICE", (String) null);
        return string != null ? string : NotificationCompat.CATEGORY_SERVICE;
    }

    public final void setAccessToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "accessToken");
        f3343b = str;
        m3816a(str, "kRFL_KEY_ACCESS_TOKEN");
    }

    public final void setAdEntryType(int i) {
        m3814a(i, "kKey_AD_ENTRY_TYPE");
    }

    public final void setAdTriggerRequestTime(long j) {
        m3815a(j, "kKey_AD_TRIGGER_REQUEST_TIME");
    }

    public final void setAltitudePrediction(boolean z) {
        m3817a(z, "kRFLAltitudePrediction");
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        m3816a(str, "kRFL_KEY_BASE_URL");
    }

    public final void setClientId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "clientId");
        m3816a(str, "kRFL_KEY_CLIENT_ID");
    }

    public final void setClientSecret(String str) {
        Intrinsics.checkParameterIsNotNull(str, "clientSecret");
        m3816a(str, "kRFL_KEY_CLIENT_SECRET");
    }

    public final void setEnableTwoWeekSetting(boolean z) {
        m3817a(z, "kRFLTwoWeekSetting");
    }

    public final void setEventTime(long j) {
        m3815a(j, "kRFL_KEY_FOR_EVENT");
    }

    public final void setExtraParameter(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "params");
        String json = new Gson().toJson((Object) map);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(params)");
        m3816a(json, "kRFL_KEY_EXTRA_PARAMETER");
    }

    public final void setForecastLastUpdateTime(int i) {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().putInt("kRFLForecastLastUpdateTime", i).apply();
    }

    public final void setForecastWeatherCategory(RFLWeatherCategory rFLWeatherCategory) {
        Intrinsics.checkParameterIsNotNull(rFLWeatherCategory, "value");
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().putInt("kRFLForecastWeatherCategory", rFLWeatherCategory.ordinal()).apply();
    }

    public final void setForegroundName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "foregroundName");
        m3816a(str, "kRFL_KEY_FOREGROUND");
    }

    public final void setGeoFenceName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "geofenceName");
        m3816a(str, "kRFL_KEY_GEO_FENCE");
    }

    public final void setGrant(boolean z) {
        m3817a(z, "kRFL_KEY_FOR_GRANT");
    }

    public final void setInstallDate(long j) {
        m3815a(j, "kRFL_KEY_INSTALL_DATE");
    }

    public final void setLaunch(boolean z) {
        m3817a(z, "kRFL_KEY_FIRST_LAUNCH");
    }

    public final void setLoadTime(long j) {
        m3815a(j, "kRFL_KEY_FOR_LOAD_DAILY_TIME");
    }

    public final void setLocationJapanOnly(boolean z) {
        m3817a(z, "kRFLLocationJapanOnly");
    }

    public final void setLocationTemperature(HashMap<String, Object> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "value");
        String json = new Gson().toJson((Object) hashMap);
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().putString("kRFLLocationTemperature", json).apply();
    }

    public final void setPassword(String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        f3345d = str;
        m3816a(str, "kRFL_KEY_PASSWORD");
    }

    public final void setPointSystemKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pointSystemKey");
        m3816a(str, "kRFLUserDataPointSystemKey");
    }

    public final void setPointUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pointUrl");
        m3816a(str, "kRFL_KEY_POINT_URL");
    }

    public final void setPrediction(boolean z) {
        m3817a(z, "kRFL_KEY_FOR_PREDICT");
    }

    public final void setPriorityType(int i) {
        m3815a((long) i, "kRFL_KEY_PRIORITY_TYPE");
    }

    public final void setProfileExtraKey(RFLExtra rFLExtra) {
        if (rFLExtra != null) {
            String json = new Gson().toJson((Object) rFLExtra);
            Intrinsics.checkExpressionValueIsNotNull(json, "json");
            m3816a(json, "kRFL_KEY_PROFILE_EXTRA_KEY");
        }
    }

    public final void setProfilePrivateKey(RFLPrivate rFLPrivate) {
        Intrinsics.checkParameterIsNotNull(rFLPrivate, "privateKey");
        String json = new Gson().toJson((Object) rFLPrivate);
        Intrinsics.checkExpressionValueIsNotNull(json, "json");
        m3816a(json, "kRFL_KEY_PROFILE_PRIVATE_KEY");
    }

    public final void setSendPushToken(boolean z) {
        m3817a(z, "kRFL_KEY_SEND_PUSH_TOKEN");
    }

    public final void setServiceName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "serviceName");
        m3816a(str, "kRFL_KEY_SERVICE");
    }

    public final void setSilentLogUserId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        m3816a(str, "kRFLSilentLogUserId");
    }

    public final void setSl2Id(String str) {
        Intrinsics.checkParameterIsNotNull(str, "sl2Id");
        m3816a(str, "kRFLUserDataSL2Id");
    }

    public final void setTempPushToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tokenString");
        m3816a(str, "kRFL_KEY_TEMP_PUSH_TOKEN");
    }

    public final void setTracking(boolean z) {
        m3817a(z, "kKEY_TRACKING");
    }

    public final void setUUID(String str) {
        Intrinsics.checkParameterIsNotNull(str, "uuid");
        m3816a(str, "kRFL_KEY_UUID_STRING");
    }

    public final void setUseAdvertisingId(boolean z) {
        m3817a(z, "kRFL_KEY_USE_ADVERTISING_ID");
    }

    public final void setUserProfile(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "gender");
        Intrinsics.checkParameterIsNotNull(str2, "birthDay");
        Intrinsics.checkParameterIsNotNull(str3, "firstDate");
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().putString("kRFLUserGender", str).putString("kRFLUserBirthDay", str2).putString("kRFLUserFirstDate", str3).apply();
    }

    public final void setUsername(String str) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        f3344c = str;
        m3816a(str, "kRFL_KEY_USERNAME");
    }

    public final String silentLogUserId() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFLSilentLogUserId", (String) null);
        return string != null ? string : "";
    }

    public final String sl2Id() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFLUserDataSL2Id", (String) null);
        return string != null ? string : "";
    }

    public final String tempPushToken() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_TEMP_PUSH_TOKEN", (String) null);
        return string != null ? string : "";
    }

    public final boolean tracking() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kKEY_TRACKING", true);
    }

    public final boolean useAdvertisingId() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean("kRFL_KEY_USE_ADVERTISING_ID", false);
    }

    public final RFLUserProfile userProfile() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFLUserGender", (String) null);
        String str = "";
        if (string == null) {
            string = str;
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "SHARED.getString(KEY_USER_GENDER, null) ?: \"\"");
        boolean z = true;
        if (string.length() == 0) {
            return null;
        }
        SharedPreferences sharedPreferences2 = f3342a;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string2 = sharedPreferences2.getString("kRFLUserBirthDay", (String) null);
        if (string2 == null) {
            string2 = str;
        }
        Intrinsics.checkExpressionValueIsNotNull(string2, "SHARED.getString(KEY_USER_BIRTH_DAY, null) ?: \"\"");
        if (string2.length() == 0) {
            return null;
        }
        SharedPreferences sharedPreferences3 = f3342a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string3 = sharedPreferences3.getString("kRFLUserFirstDate", (String) null);
        if (string3 != null) {
            str = string3;
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "SHARED.getString(KEY_USER_FIRST_DATE, null) ?: \"\"");
        if (str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        return new RFLUserProfile(string, string2, str);
    }

    public final String username() {
        return f3344c;
    }

    public final String uuid() {
        SharedPreferences sharedPreferences = f3342a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString("kRFL_KEY_UUID_STRING", (String) null);
        return string != null ? string : "uuid";
    }
}
