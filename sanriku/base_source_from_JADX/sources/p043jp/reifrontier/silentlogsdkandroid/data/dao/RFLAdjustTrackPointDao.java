package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import com.google.gson.Gson;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityAdjustTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityAdjustTrackPoint_Deleter;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J$\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLAdjustTrackPointDao;", "", "()V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "delete", "", "from", "", "to", "deleteBefore", "targetDay", "Ljava/util/Calendar;", "find", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityAdjustTrackPoint;", "getData", "", "adjustTrackPoints", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "insert", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao */
public final class RFLAdjustTrackPointDao {
    public RFLOrmaHolder rflOrmaHolder;

    public RFLAdjustTrackPointDao() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final byte[] m3806a(List<RFLTrackPoint> list) {
        String json = new Gson().toJson((Object) list);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(adjustTrackPoints)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public final void delete(int i, int i2) {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().deleteFromRFLEntityAdjustTrackPoint().fromDateEq(i).toDateEq(i2).execute();
    }

    public final void deleteBefore(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "targetDay");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        RFLEntityAdjustTrackPoint_Deleter deleteFromRFLEntityAdjustTrackPoint = rFLOrmaHolder.getORMA().deleteFromRFLEntityAdjustTrackPoint();
        Date time = calendar.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "targetDay.time");
        deleteFromRFLEntityAdjustTrackPoint.fromDateLt(RFLDailyUtilsKt.second(time)).execute();
    }

    public final RFLEntityAdjustTrackPoint find(int i, int i2) {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return (RFLEntityAdjustTrackPoint) rFLOrmaHolder.getORMA().selectFromRFLEntityAdjustTrackPoint().fromDateEq(i).toDateEq(i2).valueOrNull();
    }

    public final RFLOrmaHolder getRflOrmaHolder() {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return rFLOrmaHolder;
    }

    public final void insert(int i, int i2, List<RFLTrackPoint> list) {
        Intrinsics.checkParameterIsNotNull(list, "adjustTrackPoints");
        RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint = new RFLEntityAdjustTrackPoint(i, i2, m3806a(list));
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().insertIntoRFLEntityAdjustTrackPoint(rFLEntityAdjustTrackPoint);
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }
}
