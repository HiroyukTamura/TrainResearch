package p043jp.reifrontier.silentlogsdkandroid.info;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/info/RFLPointCalcRequest;", "", "appId", "", "(I)V", "getAppId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.info.RFLPointCalcRequest */
public final class RFLPointCalcRequest {
    @SerializedName("app_id")

    /* renamed from: a */
    private final int f3806a;

    public RFLPointCalcRequest(int i) {
        this.f3806a = i;
    }

    public static /* synthetic */ RFLPointCalcRequest copy$default(RFLPointCalcRequest rFLPointCalcRequest, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFLPointCalcRequest.f3806a;
        }
        return rFLPointCalcRequest.copy(i);
    }

    public final int component1() {
        return this.f3806a;
    }

    public final RFLPointCalcRequest copy(int i) {
        return new RFLPointCalcRequest(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFLPointCalcRequest) && this.f3806a == ((RFLPointCalcRequest) obj).f3806a;
        }
        return true;
    }

    public final int getAppId() {
        return this.f3806a;
    }

    public int hashCode() {
        return this.f3806a;
    }

    public String toString() {
        return C0681a.m322a(C0681a.m330a("RFLPointCalcRequest(appId="), this.f3806a, ")");
    }
}
