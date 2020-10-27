package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionResponse;", "", "result", "", "loginBonus", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLoginBonus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionResponse;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiPointActionResponse */
public final class RFGApiPointActionResponse {
    @SerializedName("loginbonus")
    private final Integer loginBonus;
    @SerializedName("result")
    private final String result;

    public RFGApiPointActionResponse(String str, Integer num) {
        this.result = str;
        this.loginBonus = num;
    }

    public static /* synthetic */ RFGApiPointActionResponse copy$default(RFGApiPointActionResponse rFGApiPointActionResponse, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGApiPointActionResponse.result;
        }
        if ((i & 2) != 0) {
            num = rFGApiPointActionResponse.loginBonus;
        }
        return rFGApiPointActionResponse.copy(str, num);
    }

    public final String component1() {
        return this.result;
    }

    public final Integer component2() {
        return this.loginBonus;
    }

    public final RFGApiPointActionResponse copy(String str, Integer num) {
        return new RFGApiPointActionResponse(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGApiPointActionResponse)) {
            return false;
        }
        RFGApiPointActionResponse rFGApiPointActionResponse = (RFGApiPointActionResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) rFGApiPointActionResponse.result) && Intrinsics.areEqual((Object) this.loginBonus, (Object) rFGApiPointActionResponse.loginBonus);
    }

    public final Integer getLoginBonus() {
        return this.loginBonus;
    }

    public final String getResult() {
        return this.result;
    }

    public int hashCode() {
        String str = this.result;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.loginBonus;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGApiPointActionResponse(result=");
        a.append(this.result);
        a.append(", loginBonus=");
        a.append(this.loginBonus);
        a.append(")");
        return a.toString();
    }
}
