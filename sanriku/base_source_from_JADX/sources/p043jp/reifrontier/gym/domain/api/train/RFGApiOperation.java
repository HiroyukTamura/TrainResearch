package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "", "trainId", "", "status", "ontime", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getOntime", "getStatus", "getTrainId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiOperation */
public final class RFGApiOperation {
    @SerializedName("message")
    private final String message;
    @SerializedName("ontime")
    private final String ontime;
    @SerializedName("status")
    private final String status;
    @SerializedName("train_id")
    private final String trainId;

    public RFGApiOperation(String str, String str2, String str3, String str4) {
        this.trainId = str;
        this.status = str2;
        this.ontime = str3;
        this.message = str4;
    }

    public static /* synthetic */ RFGApiOperation copy$default(RFGApiOperation rFGApiOperation, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGApiOperation.trainId;
        }
        if ((i & 2) != 0) {
            str2 = rFGApiOperation.status;
        }
        if ((i & 4) != 0) {
            str3 = rFGApiOperation.ontime;
        }
        if ((i & 8) != 0) {
            str4 = rFGApiOperation.message;
        }
        return rFGApiOperation.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.trainId;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.ontime;
    }

    public final String component4() {
        return this.message;
    }

    public final RFGApiOperation copy(String str, String str2, String str3, String str4) {
        return new RFGApiOperation(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGApiOperation)) {
            return false;
        }
        RFGApiOperation rFGApiOperation = (RFGApiOperation) obj;
        return Intrinsics.areEqual((Object) this.trainId, (Object) rFGApiOperation.trainId) && Intrinsics.areEqual((Object) this.status, (Object) rFGApiOperation.status) && Intrinsics.areEqual((Object) this.ontime, (Object) rFGApiOperation.ontime) && Intrinsics.areEqual((Object) this.message, (Object) rFGApiOperation.message);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOntime() {
        return this.ontime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTrainId() {
        return this.trainId;
    }

    public int hashCode() {
        String str = this.trainId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ontime;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.message;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGApiOperation(trainId=");
        a.append(this.trainId);
        a.append(", status=");
        a.append(this.status);
        a.append(", ontime=");
        a.append(this.ontime);
        a.append(", message=");
        return C0681a.m324a(a, this.message, ")");
    }
}
