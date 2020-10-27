package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGModActivity;", "", "type", "", "date", "", "(Ljava/lang/String;I)V", "getDate", "()I", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGModActivity */
public final class RFGModActivity {
    @SerializedName("mod_update_time")
    private final int date;
    @SerializedName("mod_activity")
    private final String type;

    public RFGModActivity(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        this.type = str;
        this.date = i;
    }

    public static /* synthetic */ RFGModActivity copy$default(RFGModActivity rFGModActivity, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rFGModActivity.type;
        }
        if ((i2 & 2) != 0) {
            i = rFGModActivity.date;
        }
        return rFGModActivity.copy(str, i);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.date;
    }

    public final RFGModActivity copy(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return new RFGModActivity(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGModActivity)) {
            return false;
        }
        RFGModActivity rFGModActivity = (RFGModActivity) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) rFGModActivity.type) && this.date == rFGModActivity.date;
    }

    public final int getDate() {
        return this.date;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        return ((str != null ? str.hashCode() : 0) * 31) + this.date;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGModActivity(type=");
        a.append(this.type);
        a.append(", date=");
        return C0681a.m322a(a, this.date, ")");
    }
}
