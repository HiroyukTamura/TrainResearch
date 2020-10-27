package p043jp.reifrontier.gym.domain.app;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGDate;", "", "isToday", "", "isLater", "time", "Ljava/util/Date;", "(ZZLjava/util/Date;)V", "()Z", "getTime", "()Ljava/util/Date;", "date", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.app.RFGDate */
public final class RFGDate {
    private final boolean isLater;
    private final boolean isToday;
    private final Date time;

    public RFGDate(boolean z, boolean z2, Date date) {
        Intrinsics.checkParameterIsNotNull(date, "time");
        this.isToday = z;
        this.isLater = z2;
        this.time = date;
    }

    public final String date() {
        return RFLDailyUtilsKt.format$default(this.time, "d", (String) null, 2, (Object) null);
    }

    public final Date getTime() {
        return this.time;
    }

    public final boolean isLater() {
        return this.isLater;
    }

    public final boolean isToday() {
        return this.isToday;
    }
}
