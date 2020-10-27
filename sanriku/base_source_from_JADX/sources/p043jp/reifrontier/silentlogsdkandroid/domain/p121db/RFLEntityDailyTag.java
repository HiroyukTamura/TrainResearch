package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag;", "", "dateValue", "Ljava/util/Date;", "dailyTag", "", "updateTime", "", "(Ljava/util/Date;Ljava/lang/String;I)V", "date", "(ILjava/lang/String;I)V", "getDailyTag", "()Ljava/lang/String;", "getDate", "()I", "getDateValue", "()Ljava/util/Date;", "getUpdateTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag */
public final class RFLEntityDailyTag {

    /* renamed from: a */
    private final int f3655a;

    /* renamed from: b */
    private final String f3656b;

    /* renamed from: c */
    private final int f3657c;

    public RFLEntityDailyTag(int i, String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "dailyTag");
        this.f3655a = i;
        this.f3656b = str;
        this.f3657c = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RFLEntityDailyTag(Date date, String str, int i) {
        this(RFLDailyUtilsKt.second(date), str, i);
        Intrinsics.checkParameterIsNotNull(date, "dateValue");
        Intrinsics.checkParameterIsNotNull(str, "dailyTag");
    }

    public static /* synthetic */ RFLEntityDailyTag copy$default(RFLEntityDailyTag rFLEntityDailyTag, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rFLEntityDailyTag.f3655a;
        }
        if ((i3 & 2) != 0) {
            str = rFLEntityDailyTag.f3656b;
        }
        if ((i3 & 4) != 0) {
            i2 = rFLEntityDailyTag.f3657c;
        }
        return rFLEntityDailyTag.copy(i, str, i2);
    }

    public final int component1() {
        return this.f3655a;
    }

    public final String component2() {
        return this.f3656b;
    }

    public final int component3() {
        return this.f3657c;
    }

    public final RFLEntityDailyTag copy(int i, String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "dailyTag");
        return new RFLEntityDailyTag(i, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLEntityDailyTag)) {
            return false;
        }
        RFLEntityDailyTag rFLEntityDailyTag = (RFLEntityDailyTag) obj;
        return this.f3655a == rFLEntityDailyTag.f3655a && !(Intrinsics.areEqual((Object) this.f3656b, (Object) rFLEntityDailyTag.f3656b) ^ true) && this.f3657c == rFLEntityDailyTag.f3657c;
    }

    public final String getDailyTag() {
        return this.f3656b;
    }

    public final int getDate() {
        return this.f3655a;
    }

    public final Date getDateValue() {
        return RFLDailyUtilsKt.date(this.f3655a);
    }

    public final int getUpdateTime() {
        return this.f3657c;
    }

    public int hashCode() {
        return ((this.f3656b.hashCode() + (this.f3655a * 31)) * 31) + this.f3657c;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityDailyTag(date=");
        a.append(this.f3655a);
        a.append(", dailyTag=");
        a.append(this.f3656b);
        a.append(", updateTime=");
        return C0681a.m322a(a, this.f3657c, ")");
    }
}
