package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityActivity;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nJ$\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLActivityDao;", "", "()V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "find", "", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityActivity;", "dateString", "", "timezone", "getDataFromList", "", "activities", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "insert", "", "updateByDateTimezone", "updateActivities", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao */
public final class RFLActivityDao {
    public RFLOrmaHolder rflOrmaHolder;

    public RFLActivityDao() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final byte[] m3805a(List<RFLActivity> list) {
        String json = new Gson().toJson((Object) list);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(activities)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public final List<RFLEntityActivity> find(String str) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        List<RFLEntityActivity> list = rFLOrmaHolder.getORMA().selectFromRFLEntityActivity().dateEq(str).toList();
        Intrinsics.checkExpressionValueIsNotNull(list, "rflOrmaHolder.ORMA\n     …                .toList()");
        return list;
    }

    public final List<RFLEntityActivity> find(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        List<RFLEntityActivity> list = rFLOrmaHolder.getORMA().selectFromRFLEntityActivity().dateEq(str).timezoneEq(str2).toList();
        Intrinsics.checkExpressionValueIsNotNull(list, "rflOrmaHolder.ORMA\n     …                .toList()");
        return list;
    }

    public final RFLOrmaHolder getRflOrmaHolder() {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return rFLOrmaHolder;
    }

    public final void insert(String str, String str2, List<RFLActivity> list) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        Intrinsics.checkParameterIsNotNull(list, "activities");
        RFLEntityActivity rFLEntityActivity = new RFLEntityActivity(str, str2, m3805a(list));
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().prepareInsertIntoRFLEntityActivity(5).mo19796a(rFLEntityActivity);
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }

    public final void updateByDateTimezone(List<RFLActivity> list, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(list, "updateActivities");
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().updateRFLEntityActivity().dateEq(str).timezoneEq(str2).data(m3805a(list)).execute();
    }
}
