package p043jp.reifrontier.gym.data.shared;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.util.CaledarExKt;
import p043jp.reifrontier.gym.util.CalendarEx;
import p043jp.reifrontier.gym.util.RFGUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018J\u0014\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0006\u0010+\u001a\u00020'J\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u001bJ\u0006\u00103\u001a\u00020\u001bJ\u0006\u00104\u001a\u00020\u001bJ\u0006\u00105\u001a\u00020\u0004J\u0006\u00106\u001a\u00020\u001bJ\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004H\u0002J\u0018\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0004H\u0002J\u000e\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u0004J\u0016\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0019J\u0018\u0010B\u001a\u00020'2\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\u0004H\u0002J\u000e\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0004J\u000e\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020'2\u0006\u00100\u001a\u000201J\u000e\u0010H\u001a\u00020'2\u0006\u00102\u001a\u00020\u001bJ\u000e\u0010I\u001a\u00020'2\u0006\u00103\u001a\u00020\u001bJ\u000e\u0010J\u001a\u00020'2\u0006\u00104\u001a\u00020\u001bJ\u0018\u0010K\u001a\u00020'2\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020\u0004H\u0002J\u000e\u0010L\u001a\u00020'2\u0006\u0010>\u001a\u00020\u0004J\u0016\u0010M\u001a\u00020'2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004J\u000e\u0010N\u001a\u00020'2\u0006\u0010D\u001a\u00020\u001bJ\u000e\u0010O\u001a\u00020'2\u0006\u00107\u001a\u000208J\u000e\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u000201J\u000e\u0010R\u001a\u00020'2\u0006\u0010Q\u001a\u000201J\u000e\u0010S\u001a\u00020'2\u0006\u0010Q\u001a\u000201J\u000e\u0010T\u001a\u00020'2\u0006\u0010Q\u001a\u000201J\u000e\u0010U\u001a\u00020'2\u0006\u0010:\u001a\u00020VJ\u000e\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\u0004J\u0006\u0010Y\u001a\u00020\u001bJ\u0006\u0010Z\u001a\u00020\u001bJ\u0006\u0010[\u001a\u00020\u001bJ\u0006\u0010\\\u001a\u00020\u001bJ\u0006\u0010]\u001a\u00020\u0004J\u0006\u0010F\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018X.¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR6\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004` X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006^"}, mo21739d2 = {"Ljp/reifrontier/gym/data/shared/RFGShared;", "", "()V", "KEY_CHALLENGE", "", "KEY_CLUB_ICON_UPDATE_TIME", "KEY_FIRSTDAY", "KEY_INSTALL", "KEY_IS_ENTER_PERSONAL", "KEY_IS_ERROR_RESTART", "KEY_IS_USE_GOOGLE_FIT", "KEY_LOCATION", "KEY_MODIFY", "KEY_PREVIOUS_VERSION", "KEY_REQUEST_A", "KEY_REQUEST_CLUB_LIST", "KEY_REQUEST_F", "KEY_REQUEST_P", "KEY_SAN_LOGIN_DATE", "KEY_SILENTLOGID", "KEY_TOKEN", "SHARED", "Landroid/content/SharedPreferences;", "clubIconUpdateTimeMap", "", "", "shouldRequestLoginBonus", "", "getShouldRequestLoginBonus", "()Z", "yesterdayMetsList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getYesterdayMetsList", "()Ljava/util/HashMap;", "setYesterdayMetsList", "(Ljava/util/HashMap;)V", "challengeDate", "clearChallengeData", "", "clearLocationData", "clubIconUpdateTime", "clubIconUpdateTimeForce", "deleteAll", "firstDate", "initialize", "context", "Landroid/content/Context;", "installDate", "", "isEnterPersonal", "isErrorRestart", "isUseGoogleFit", "locationData", "modify", "previousVersion", "", "set", "value", "key", "setB", "setChallengeData", "data", "setClubIconUpdateTime", "clubId", "clubUpdateTime", "setF", "setFirstDate", "date", "setGCMToken", "token", "setInstallDate", "setIsEnterPersonal", "setIsErrorRestart", "setIsUseGoogleFit", "setL", "setLocationData", "setMets", "setModify", "setPreviousVersion", "setRequestActs", "time", "setRequestClubList", "setRequestFeed", "setRequestPoint", "setSanLoginDate", "Ljava/util/Calendar;", "setSilentLogId", "silentlogId", "shouldRequestClubList", "shouldRequestFeed", "shouldRequestLatestActs", "shouldRequestPoint", "silentLogId", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.shared.RFGShared */
public final class RFGShared {
    public static final RFGShared INSTANCE = new RFGShared();
    private static final String KEY_CHALLENGE = "kRFD_CHALLENGE";
    private static final String KEY_CLUB_ICON_UPDATE_TIME = "kRFG_CLUB_ICON_UPDATE_TIME";
    private static final String KEY_FIRSTDAY = "kRFD_FIRSTDAY";
    private static final String KEY_INSTALL = "kRFD_INSTALL";
    private static final String KEY_IS_ENTER_PERSONAL = "kRFG_IS_ENTER_PERSONAL";
    private static final String KEY_IS_ERROR_RESTART = "kRFD_IS_ERROR_RESTART";
    private static final String KEY_IS_USE_GOOGLE_FIT = "kRFG_IS_USE_GOOGLE_FIT";
    private static final String KEY_LOCATION = "kRFD_LOCATION";
    private static final String KEY_MODIFY = "kRFD_MODIFY";
    private static final String KEY_PREVIOUS_VERSION = "kRFG_PREVIOUS_VERSION";
    private static final String KEY_REQUEST_A = "kRFD_ACTIVITY";
    private static final String KEY_REQUEST_CLUB_LIST = "kRFD_CLUB_LIST";
    private static final String KEY_REQUEST_F = "kRFD_FEED";
    private static final String KEY_REQUEST_P = "kRFD_POINT";
    private static final String KEY_SAN_LOGIN_DATE = "kSAN_LOGIN_DATE";
    private static final String KEY_SILENTLOGID = "kRFD_SILENTLOGID";
    private static final String KEY_TOKEN = "kRFD_TOKEN";
    /* access modifiers changed from: private */
    public static SharedPreferences SHARED;
    /* access modifiers changed from: private */
    public static Map<String, Integer> clubIconUpdateTimeMap;
    public static HashMap<String, String> yesterdayMetsList;

    private RFGShared() {
    }

    public static final /* synthetic */ Map access$getClubIconUpdateTimeMap$p(RFGShared rFGShared) {
        Map<String, Integer> map = clubIconUpdateTimeMap;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubIconUpdateTimeMap");
        }
        return map;
    }

    public static final /* synthetic */ SharedPreferences access$getSHARED$p(RFGShared rFGShared) {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences;
    }

    private final Map<String, Integer> clubIconUpdateTimeForce() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString(KEY_CLUB_ICON_UPDATE_TIME, (String) null);
        if (string == null) {
            return new LinkedHashMap();
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "SHARED.getString(KEY_CLU… ?: return mutableMapOf()");
        Object fromJson = new Gson().fromJson(string, new RFGShared$clubIconUpdateTimeForce$type$1().getType());
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<MutableM…, Int>>(jsonString, type)");
        return (Map) fromJson;
    }

    private final void set(String str, String str2) {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str2, str);
        edit.apply();
    }

    private final void setB(boolean z, String str) {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private final void setF(float f, String str) {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    private final void setL(long j, String str) {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public final String challengeDate() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString(KEY_CHALLENGE, (String) null);
        return string != null ? string : "challenge";
    }

    public final void clearChallengeData() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().remove(KEY_CHALLENGE).apply();
    }

    public final void clearLocationData() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().remove(KEY_LOCATION).apply();
    }

    public final Map<String, Integer> clubIconUpdateTime() {
        Map<String, Integer> map = clubIconUpdateTimeMap;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubIconUpdateTimeMap");
        }
        return map;
    }

    public final void deleteAll() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        sharedPreferences.edit().clear().apply();
        HashMap<String, String> hashMap = yesterdayMetsList;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yesterdayMetsList");
        }
        hashMap.clear();
        Map<String, Integer> map = clubIconUpdateTimeMap;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubIconUpdateTimeMap");
        }
        map.clear();
    }

    public final String firstDate() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString(KEY_FIRSTDAY, (String) null);
        return string != null ? string : "21000207T000000Z";
    }

    public final boolean getShouldRequestLoginBonus() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getLong(KEY_SAN_LOGIN_DATE, 0) < CalendarEx.INSTANCE.today().getTimeInMillis();
    }

    public final HashMap<String, String> getYesterdayMetsList() {
        HashMap<String, String> hashMap = yesterdayMetsList;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yesterdayMetsList");
        }
        return hashMap;
    }

    public final void initialize(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String a = C0681a.m328a(new Object[]{"app_", context.getPackageName()}, 2, "%s%s", "java.lang.String.format(this, *args)");
        if (SHARED == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            SHARED = sharedPreferences;
        }
        HashMap<String, String> hashMap = yesterdayMetsList;
        if (hashMap != null) {
            if (hashMap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yesterdayMetsList");
            }
            hashMap.clear();
        } else {
            yesterdayMetsList = new HashMap<>();
        }
        Map<String, Integer> map = clubIconUpdateTimeMap;
        if (map != null) {
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clubIconUpdateTimeMap");
            }
            map.clear();
            return;
        }
        clubIconUpdateTimeMap = clubIconUpdateTimeForce();
    }

    public final long installDate() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getLong(KEY_INSTALL, 0);
    }

    public final boolean isEnterPersonal() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean(KEY_IS_ENTER_PERSONAL, false);
    }

    public final boolean isErrorRestart() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean(KEY_IS_ERROR_RESTART, false);
    }

    public final boolean isUseGoogleFit() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean(KEY_IS_USE_GOOGLE_FIT, false);
    }

    public final String locationData() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString(KEY_LOCATION, (String) null);
        return string != null ? string : FirebaseAnalytics.Param.LOCATION;
    }

    public final boolean modify() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getBoolean(KEY_MODIFY, false);
    }

    public final float previousVersion() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        return sharedPreferences.getFloat(KEY_PREVIOUS_VERSION, 0.0f);
    }

    public final void setChallengeData(String str) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        set(str, KEY_CHALLENGE);
    }

    public final void setClubIconUpdateTime(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Map<String, Integer> map = clubIconUpdateTimeMap;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubIconUpdateTimeMap");
        }
        map.put(str, Integer.valueOf(i));
        Gson gson = new Gson();
        Map<String, Integer> map2 = clubIconUpdateTimeMap;
        if (map2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubIconUpdateTimeMap");
        }
        String json = gson.toJson((Object) map2);
        Intrinsics.checkExpressionValueIsNotNull(json, "mapString");
        set(json, KEY_CLUB_ICON_UPDATE_TIME);
    }

    public final void setFirstDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        set(str, KEY_FIRSTDAY);
    }

    public final void setGCMToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        set(str, KEY_TOKEN);
    }

    public final void setInstallDate(long j) {
        setL(j, KEY_INSTALL);
    }

    public final void setIsEnterPersonal(boolean z) {
        setB(z, KEY_IS_ENTER_PERSONAL);
    }

    public final void setIsErrorRestart(boolean z) {
        setB(z, KEY_IS_ERROR_RESTART);
    }

    public final void setIsUseGoogleFit(boolean z) {
        setB(z, KEY_IS_USE_GOOGLE_FIT);
    }

    public final void setLocationData(String str) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        set(str, KEY_LOCATION);
    }

    public final void setMets(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        HashMap<String, String> hashMap = yesterdayMetsList;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yesterdayMetsList");
        }
        hashMap.put(str, str2);
    }

    public final void setModify(boolean z) {
        setB(z, KEY_MODIFY);
    }

    public final void setPreviousVersion(float f) {
        setF(f, KEY_PREVIOUS_VERSION);
    }

    public final void setRequestActs(long j) {
        setL(j, KEY_REQUEST_A);
    }

    public final void setRequestClubList(long j) {
        setL(j, KEY_REQUEST_CLUB_LIST);
    }

    public final void setRequestFeed(long j) {
        setL(j, KEY_REQUEST_F);
    }

    public final void setRequestPoint(long j) {
        setL(j, KEY_REQUEST_P);
    }

    public final void setSanLoginDate(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "value");
        setL(CaledarExKt.dayStart(calendar).getTimeInMillis(), KEY_SAN_LOGIN_DATE);
    }

    public final void setSilentLogId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "silentlogId");
        set(str, KEY_SILENTLOGID);
    }

    public final void setYesterdayMetsList(HashMap<String, String> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        yesterdayMetsList = hashMap;
    }

    public final boolean shouldRequestClubList() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        long j = sharedPreferences.getLong(KEY_REQUEST_CLUB_LIST, 0);
        return !RFGUtilsKt.isToday(new Date(j)) || System.currentTimeMillis() - j > 300000;
    }

    public final boolean shouldRequestFeed() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        long j = sharedPreferences.getLong(KEY_REQUEST_F, 0);
        return !RFGUtilsKt.isToday(new Date(j)) || System.currentTimeMillis() - j > 300000;
    }

    public final boolean shouldRequestLatestActs() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        long j = sharedPreferences.getLong(KEY_REQUEST_A, 0);
        return !RFGUtilsKt.isToday(new Date(j)) || System.currentTimeMillis() - j > 3600000;
    }

    public final boolean shouldRequestPoint() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        long j = sharedPreferences.getLong(KEY_REQUEST_P, 0);
        return !RFGUtilsKt.isToday(new Date(j)) || System.currentTimeMillis() - j > 300000;
    }

    public final String silentLogId() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString(KEY_SILENTLOGID, (String) null);
        return string != null ? string : "";
    }

    public final String token() {
        SharedPreferences sharedPreferences = SHARED;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("SHARED");
        }
        String string = sharedPreferences.getString(KEY_TOKEN, (String) null);
        return string != null ? string : "token";
    }
}
