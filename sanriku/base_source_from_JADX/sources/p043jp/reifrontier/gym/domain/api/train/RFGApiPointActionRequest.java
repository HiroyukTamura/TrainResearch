package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.BuildConfig;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionRequest;", "", "app_id", "", "type", "(II)V", "getApp_id", "()I", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiPointActionRequest */
public final class RFGApiPointActionRequest {
    @SerializedName("app_id")
    private final int app_id;
    @SerializedName("type")
    private final int type;

    public RFGApiPointActionRequest() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public RFGApiPointActionRequest(int i, int i2) {
        this.app_id = i;
        this.type = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGApiPointActionRequest(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Integer.parseInt(BuildConfig.APP_ID) : i, (i3 & 2) != 0 ? 1 : i2);
    }

    public static /* synthetic */ RFGApiPointActionRequest copy$default(RFGApiPointActionRequest rFGApiPointActionRequest, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rFGApiPointActionRequest.app_id;
        }
        if ((i3 & 2) != 0) {
            i2 = rFGApiPointActionRequest.type;
        }
        return rFGApiPointActionRequest.copy(i, i2);
    }

    public final int component1() {
        return this.app_id;
    }

    public final int component2() {
        return this.type;
    }

    public final RFGApiPointActionRequest copy(int i, int i2) {
        return new RFGApiPointActionRequest(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGApiPointActionRequest)) {
            return false;
        }
        RFGApiPointActionRequest rFGApiPointActionRequest = (RFGApiPointActionRequest) obj;
        return this.app_id == rFGApiPointActionRequest.app_id && this.type == rFGApiPointActionRequest.type;
    }

    public final int getApp_id() {
        return this.app_id;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.app_id * 31) + this.type;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGApiPointActionRequest(app_id=");
        a.append(this.app_id);
        a.append(", type=");
        return C0681a.m322a(a, this.type, ")");
    }
}
