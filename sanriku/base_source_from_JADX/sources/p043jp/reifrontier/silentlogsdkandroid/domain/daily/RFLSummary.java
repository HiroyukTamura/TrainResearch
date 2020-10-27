package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSummary;", "", "dailyNote", "", "(Ljava/lang/String;)V", "getDailyNote", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSummary */
public final class RFLSummary {
    @SerializedName("daily_note")

    /* renamed from: a */
    private final String f3571a;

    public RFLSummary(String str) {
        Intrinsics.checkParameterIsNotNull(str, "dailyNote");
        this.f3571a = str;
    }

    public static /* synthetic */ RFLSummary copy$default(RFLSummary rFLSummary, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLSummary.f3571a;
        }
        return rFLSummary.copy(str);
    }

    public final String component1() {
        return this.f3571a;
    }

    public final RFLSummary copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "dailyNote");
        return new RFLSummary(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFLSummary) && Intrinsics.areEqual((Object) this.f3571a, (Object) ((RFLSummary) obj).f3571a);
        }
        return true;
    }

    public final String getDailyNote() {
        return this.f3571a;
    }

    public int hashCode() {
        String str = this.f3571a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C0681a.m324a(C0681a.m330a("RFLSummary(dailyNote="), this.f3571a, ")");
    }
}
