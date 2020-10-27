package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserReward;", "", "userId", "", "username", "invalidRewards", "", "Ljp/reifrontier/gym/domain/api/RFGValidReward;", "validRewards", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getInvalidRewards", "()Ljava/util/List;", "getUserId", "()Ljava/lang/String;", "getUsername", "getValidRewards", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserReward */
public final class RFGUserReward {
    @SerializedName("invalid_reward")
    private final List<RFGValidReward> invalidRewards;
    @SerializedName("userId")
    private final String userId;
    @SerializedName("username")
    private final String username;
    @SerializedName("valid_reward")
    private final List<RFGValidReward> validRewards;

    public RFGUserReward(String str, String str2, List<RFGValidReward> list, List<RFGValidReward> list2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "username");
        Intrinsics.checkParameterIsNotNull(list, "invalidRewards");
        Intrinsics.checkParameterIsNotNull(list2, "validRewards");
        this.userId = str;
        this.username = str2;
        this.invalidRewards = list;
        this.validRewards = list2;
    }

    public static /* synthetic */ RFGUserReward copy$default(RFGUserReward rFGUserReward, String str, String str2, List<RFGValidReward> list, List<RFGValidReward> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGUserReward.userId;
        }
        if ((i & 2) != 0) {
            str2 = rFGUserReward.username;
        }
        if ((i & 4) != 0) {
            list = rFGUserReward.invalidRewards;
        }
        if ((i & 8) != 0) {
            list2 = rFGUserReward.validRewards;
        }
        return rFGUserReward.copy(str, str2, list, list2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.username;
    }

    public final List<RFGValidReward> component3() {
        return this.invalidRewards;
    }

    public final List<RFGValidReward> component4() {
        return this.validRewards;
    }

    public final RFGUserReward copy(String str, String str2, List<RFGValidReward> list, List<RFGValidReward> list2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "username");
        Intrinsics.checkParameterIsNotNull(list, "invalidRewards");
        Intrinsics.checkParameterIsNotNull(list2, "validRewards");
        return new RFGUserReward(str, str2, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserReward)) {
            return false;
        }
        RFGUserReward rFGUserReward = (RFGUserReward) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) rFGUserReward.userId) && Intrinsics.areEqual((Object) this.username, (Object) rFGUserReward.username) && Intrinsics.areEqual((Object) this.invalidRewards, (Object) rFGUserReward.invalidRewards) && Intrinsics.areEqual((Object) this.validRewards, (Object) rFGUserReward.validRewards);
    }

    public final List<RFGValidReward> getInvalidRewards() {
        return this.invalidRewards;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public final List<RFGValidReward> getValidRewards() {
        return this.validRewards;
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.username;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<RFGValidReward> list = this.invalidRewards;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<RFGValidReward> list2 = this.validRewards;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserReward(userId=");
        a.append(this.userId);
        a.append(", username=");
        a.append(this.username);
        a.append(", invalidRewards=");
        a.append(this.invalidRewards);
        a.append(", validRewards=");
        return C0681a.m325a(a, (List) this.validRewards, ")");
    }
}
