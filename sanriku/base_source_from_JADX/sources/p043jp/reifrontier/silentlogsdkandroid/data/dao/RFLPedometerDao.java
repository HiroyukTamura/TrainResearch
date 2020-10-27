package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityPedometer;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLPedometerDao;", "", "()V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "deleteBefore", "", "targetDay", "Ljava/util/Calendar;", "findStep", "", "from", "", "to", "insert", "timestamp", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao */
public final class RFLPedometerDao {
    public RFLOrmaHolder rflOrmaHolder;

    public RFLPedometerDao() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    public final void deleteBefore(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "targetDay");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().deleteFromRFLEntityPedometer().timestampLt(calendar.getTimeInMillis()).execute();
    }

    public final int findStep(long j, long j2) {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return rFLOrmaHolder.getORMA().selectFromRFLEntityPedometer().timestampBetween(j, j2).count();
    }

    public final RFLOrmaHolder getRflOrmaHolder() {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return rFLOrmaHolder;
    }

    public final void insert(long j) {
        RFLEntityPedometer rFLEntityPedometer = new RFLEntityPedometer(j);
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().prepareInsertIntoRFLEntityPedometer().mo19796a(rFLEntityPedometer);
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }
}
