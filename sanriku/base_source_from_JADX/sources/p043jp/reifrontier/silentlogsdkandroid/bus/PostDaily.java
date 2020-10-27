package p043jp.reifrontier.silentlogsdkandroid.bus;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/bus/PostDaily;", "", "date", "Ljava/util/Date;", "previousUpdate", "", "(Ljava/util/Date;Ljava/lang/Integer;)V", "getDate", "()Ljava/util/Date;", "getPreviousUpdate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.bus.PostDaily */
public final class PostDaily {

    /* renamed from: a */
    private final Date f3043a;

    /* renamed from: b */
    private final Integer f3044b;

    public PostDaily(Date date, Integer num) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        this.f3043a = date;
        this.f3044b = num;
    }

    public final Date getDate() {
        return this.f3043a;
    }

    public final Integer getPreviousUpdate() {
        return this.f3044b;
    }
}
