package p043jp.reifrontier.silentlogsdkandroid;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogWeatherListener;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivityPoi;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p078g.p079a.C1696b;
import p078g.p079a.C1714r;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001EB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bJ0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ3\u0010\u001b\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001fJ/\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001fJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\f\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u000bJ\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170'2\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010)\u001a\u00020\u0017J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bJ(\u0010+\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ4\u0010,\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0-0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ$\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\n2\u0006\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dJ,\u00104\u001a\u00020/2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\n2\u0006\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0017J\u0016\u00108\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u000bJ\u000e\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0017J\u0016\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020?J\u0015\u0010@\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020AH\u0000¢\u0006\u0002\bBJ\u0016\u0010C\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010D\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation;", "", "internalSilentLogOperation", "Ljp/reifrontier/silentlogsdkandroid/RFLSilentLogOperation;", "(Ljp/reifrontier/silentlogsdkandroid/RFLSilentLogOperation;)V", "addDailyTag", "", "targetDate", "Ljava/util/Date;", "dailyTags", "", "", "listener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogDailyTagListener;", "addJrFormAsync", "jrForms", "build", "context", "Landroid/content/Context;", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogOperationListener;", "clientId", "clientSecret", "staging", "", "connectApiViaLogin", "username", "password", "connectApiWithPass", "gender", "", "birthday", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;)V", "createUser", "findWeather", "date", "Ljp/reifrontier/silentlogsdkandroid/SilentLogWeatherListener$OnCompletedFind;", "forgetPassword", "email", "getDataWithAdjustTrackPoint", "Lio/reactivex/Single;", "getJrForms", "isEnableTwoWeekSetting", "isValidPassword", "removeDailyTag", "replaceDailyTag", "Lkotlin/Pair;", "saveActivityAdjustTrackPoint", "Lio/reactivex/Completable;", "adjustTrackPoints", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "fromDate", "toDate", "saveActivityPoi", "poiList", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "removePredict", "saveDailyNote", "dailyNote", "saveSl2Id", "sl2Id", "setAltitudePrediction", "enable", "setEnableTwoWeekSetting", "Ljp/reifrontier/silentlogsdkandroid/SilentLogTwoWeekSettingListener;", "setListener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;", "setListener$silentlogsdkandroid_release", "updatePassword", "uploadForceTest", "SilentLogInternalOperationListener", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation */
public final class SilentLogInternalOperation {

    /* renamed from: a */
    private final RFLSilentLogOperation f2997a;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;", "", "resultForForgetPassword", "", "success", "", "message", "", "resultForUpdatePassword", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation$SilentLogInternalOperationListener */
    public interface SilentLogInternalOperationListener {
        void resultForForgetPassword(boolean z, String str);

        void resultForUpdatePassword(boolean z);
    }

    public SilentLogInternalOperation(RFLSilentLogOperation rFLSilentLogOperation) {
        Intrinsics.checkParameterIsNotNull(rFLSilentLogOperation, "internalSilentLogOperation");
        this.f2997a = rFLSilentLogOperation;
    }

    public static /* synthetic */ void addDailyTag$default(SilentLogInternalOperation silentLogInternalOperation, Date date, List list, SilentLogDailyTagListener silentLogDailyTagListener, int i, Object obj) {
        if ((i & 4) != 0) {
            silentLogDailyTagListener = null;
        }
        silentLogInternalOperation.addDailyTag(date, list, silentLogDailyTagListener);
    }

    public static /* synthetic */ void build$default(SilentLogInternalOperation silentLogInternalOperation, Context context, SilentLogOperation.SilentLogOperationListener silentLogOperationListener, String str, String str2, boolean z, int i, Object obj) {
        silentLogInternalOperation.build(context, silentLogOperationListener, str, str2, (i & 16) != 0 ? false : z);
    }

    public static /* synthetic */ void removeDailyTag$default(SilentLogInternalOperation silentLogInternalOperation, Date date, List list, SilentLogDailyTagListener silentLogDailyTagListener, int i, Object obj) {
        if ((i & 4) != 0) {
            silentLogDailyTagListener = null;
        }
        silentLogInternalOperation.removeDailyTag(date, list, silentLogDailyTagListener);
    }

    public static /* synthetic */ void replaceDailyTag$default(SilentLogInternalOperation silentLogInternalOperation, Date date, List list, SilentLogDailyTagListener silentLogDailyTagListener, int i, Object obj) {
        if ((i & 4) != 0) {
            silentLogDailyTagListener = null;
        }
        silentLogInternalOperation.replaceDailyTag(date, list, silentLogDailyTagListener);
    }

    public final void addDailyTag(Date date, List<String> list, SilentLogDailyTagListener silentLogDailyTagListener) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        this.f2997a.addDailyTag(date, list, silentLogDailyTagListener);
    }

    public final void addJrFormAsync(String str) {
        Intrinsics.checkParameterIsNotNull(str, "jrForms");
        this.f2997a.addJrFormAsync$silentlogsdkandroid_release(str);
    }

    public final void build(Context context, SilentLogOperation.SilentLogOperationListener silentLogOperationListener, String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(silentLogOperationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(str, "clientId");
        Intrinsics.checkParameterIsNotNull(str2, "clientSecret");
        this.f2997a.build$silentlogsdkandroid_release(context, silentLogOperationListener, str, str2, z);
    }

    public final void connectApiViaLogin(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        this.f2997a.connectApiViaLogin$silentlogsdkandroid_release(str, str2);
    }

    public final void connectApiWithPass(String str, String str2, Integer num, Date date) {
        this.f2997a.connectApiWithPass$silentlogsdkandroid_release(str, str2, num, date);
    }

    public final void createUser(String str, String str2, Integer num, Date date) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        this.f2997a.createUser(str, str2, num, date);
    }

    public final void findWeather(Date date, SilentLogWeatherListener.OnCompletedFind onCompletedFind) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(onCompletedFind, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f2997a.findWeather$silentlogsdkandroid_release(date, onCompletedFind);
    }

    public final void forgetPassword(String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        this.f2997a.forgetPassword$silentlogsdkandroid_release(str);
    }

    public final C1714r<Boolean> getDataWithAdjustTrackPoint(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        return this.f2997a.getDataWithAdjustTrackPoint$silentlogsdkandroid_release(date);
    }

    public final List<String> getJrForms() {
        return this.f2997a.getJrForms$silentlogsdkandroid_release();
    }

    public final boolean isEnableTwoWeekSetting() {
        return this.f2997a.isEnableTwoWeekSetting();
    }

    public final boolean isValidPassword(String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        return this.f2997a.isValidPassword$silentlogsdkandroid_release(str);
    }

    public final void removeDailyTag(Date date, List<String> list, SilentLogDailyTagListener silentLogDailyTagListener) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        this.f2997a.removeDailyTag(date, list, silentLogDailyTagListener);
    }

    public final void replaceDailyTag(Date date, List<Pair<String, String>> list, SilentLogDailyTagListener silentLogDailyTagListener) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        this.f2997a.replaceDailyTag(date, list, silentLogDailyTagListener);
    }

    public final C1696b saveActivityAdjustTrackPoint(List<RFLTrackPoint> list, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "adjustTrackPoints");
        return this.f2997a.saveActivityAdjustTrackPoint$silentlogsdkandroid_release(list, i, i2);
    }

    public final C1696b saveActivityPoi(List<RFLActivityPoi> list, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "poiList");
        return this.f2997a.saveActivityPoi$silentlogsdkandroid_release(list, i, i2, z);
    }

    public final void saveDailyNote(Date date, String str) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(str, "dailyNote");
        this.f2997a.saveDailyNote(date, str);
    }

    public final void saveSl2Id(String str) {
        Intrinsics.checkParameterIsNotNull(str, "sl2Id");
        this.f2997a.saveSl2Id$silentlogsdkandroid_release(str);
    }

    public final void setAltitudePrediction(boolean z) {
        this.f2997a.setAltitudePrediction(z);
    }

    public final void setEnableTwoWeekSetting(boolean z, SilentLogTwoWeekSettingListener silentLogTwoWeekSettingListener) {
        Intrinsics.checkParameterIsNotNull(silentLogTwoWeekSettingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f2997a.setEnableTwoWeekSetting(z, silentLogTwoWeekSettingListener);
    }

    public final void setListener$silentlogsdkandroid_release(SilentLogInternalOperationListener silentLogInternalOperationListener) {
        Intrinsics.checkParameterIsNotNull(silentLogInternalOperationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f2997a.setInternalOperationListener(silentLogInternalOperationListener);
    }

    public final void updatePassword(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        Intrinsics.checkParameterIsNotNull(str2, "email");
        this.f2997a.updatePassword$silentlogsdkandroid_release(str, str2);
    }

    public final void uploadForceTest() {
        this.f2997a.uploadForceTest$silentlogsdkandroid_release();
    }
}
