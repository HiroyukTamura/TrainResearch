package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001:\u0002!\"B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0012HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus;", "", "validRequest", "Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGValidRequest;", "didRequest", "Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGDidRequest;", "lotteryCountString", "", "(Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGValidRequest;Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGDidRequest;Ljava/lang/String;)V", "getDidRequest", "()Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGDidRequest;", "isValidCoupon", "", "()Z", "isValidLottery", "isValidPrize", "isValidTerm", "lotteryCount", "", "getLotteryCount", "()I", "getLotteryCountString", "()Ljava/lang/String;", "getValidRequest", "()Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGValidRequest;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "RFGDidRequest", "RFGValidRequest", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGRewardUserStatus */
public final class RFGRewardUserStatus {
    @SerializedName("did_request")
    private final RFGDidRequest didRequest;
    @SerializedName("lottery_count")
    private final String lotteryCountString;
    @SerializedName("valid_request")
    private final RFGValidRequest validRequest;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGDidRequest;", "", "exchange", "", "lottery", "(ZZ)V", "getExchange", "()Z", "getLottery", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.api.RFGRewardUserStatus$RFGDidRequest */
    public static final class RFGDidRequest {
        @SerializedName("exchange")
        private final boolean exchange;
        @SerializedName("lottery")
        private final boolean lottery;

        public RFGDidRequest(boolean z, boolean z2) {
            this.exchange = z;
            this.lottery = z2;
        }

        public static /* synthetic */ RFGDidRequest copy$default(RFGDidRequest rFGDidRequest, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = rFGDidRequest.exchange;
            }
            if ((i & 2) != 0) {
                z2 = rFGDidRequest.lottery;
            }
            return rFGDidRequest.copy(z, z2);
        }

        public final boolean component1() {
            return this.exchange;
        }

        public final boolean component2() {
            return this.lottery;
        }

        public final RFGDidRequest copy(boolean z, boolean z2) {
            return new RFGDidRequest(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RFGDidRequest)) {
                return false;
            }
            RFGDidRequest rFGDidRequest = (RFGDidRequest) obj;
            return this.exchange == rFGDidRequest.exchange && this.lottery == rFGDidRequest.lottery;
        }

        public final boolean getExchange() {
            return this.exchange;
        }

        public final boolean getLottery() {
            return this.lottery;
        }

        public int hashCode() {
            boolean z = this.exchange;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            boolean z3 = this.lottery;
            if (!z3) {
                z2 = z3;
            }
            return i + (z2 ? 1 : 0);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("RFGDidRequest(exchange=");
            a.append(this.exchange);
            a.append(", lottery=");
            a.append(this.lottery);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus$RFGValidRequest;", "", "exchange", "", "lottery", "bonus_card", "(ZZZ)V", "getBonus_card", "()Z", "getExchange", "getLottery", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.api.RFGRewardUserStatus$RFGValidRequest */
    public static final class RFGValidRequest {
        @SerializedName("bonus_card")
        private final boolean bonus_card;
        @SerializedName("exchange")
        private final boolean exchange;
        @SerializedName("lottery")
        private final boolean lottery;

        public RFGValidRequest(boolean z, boolean z2, boolean z3) {
            this.exchange = z;
            this.lottery = z2;
            this.bonus_card = z3;
        }

        public static /* synthetic */ RFGValidRequest copy$default(RFGValidRequest rFGValidRequest, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = rFGValidRequest.exchange;
            }
            if ((i & 2) != 0) {
                z2 = rFGValidRequest.lottery;
            }
            if ((i & 4) != 0) {
                z3 = rFGValidRequest.bonus_card;
            }
            return rFGValidRequest.copy(z, z2, z3);
        }

        public final boolean component1() {
            return this.exchange;
        }

        public final boolean component2() {
            return this.lottery;
        }

        public final boolean component3() {
            return this.bonus_card;
        }

        public final RFGValidRequest copy(boolean z, boolean z2, boolean z3) {
            return new RFGValidRequest(z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RFGValidRequest)) {
                return false;
            }
            RFGValidRequest rFGValidRequest = (RFGValidRequest) obj;
            return this.exchange == rFGValidRequest.exchange && this.lottery == rFGValidRequest.lottery && this.bonus_card == rFGValidRequest.bonus_card;
        }

        public final boolean getBonus_card() {
            return this.bonus_card;
        }

        public final boolean getExchange() {
            return this.exchange;
        }

        public final boolean getLottery() {
            return this.lottery;
        }

        public int hashCode() {
            boolean z = this.exchange;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            boolean z3 = this.lottery;
            if (z3) {
                z3 = true;
            }
            int i2 = (i + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.bonus_card;
            if (!z4) {
                z2 = z4;
            }
            return i2 + (z2 ? 1 : 0);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("RFGValidRequest(exchange=");
            a.append(this.exchange);
            a.append(", lottery=");
            a.append(this.lottery);
            a.append(", bonus_card=");
            a.append(this.bonus_card);
            a.append(")");
            return a.toString();
        }
    }

    public RFGRewardUserStatus(RFGValidRequest rFGValidRequest, RFGDidRequest rFGDidRequest, String str) {
        Intrinsics.checkParameterIsNotNull(rFGValidRequest, "validRequest");
        Intrinsics.checkParameterIsNotNull(rFGDidRequest, "didRequest");
        Intrinsics.checkParameterIsNotNull(str, "lotteryCountString");
        this.validRequest = rFGValidRequest;
        this.didRequest = rFGDidRequest;
        this.lotteryCountString = str;
    }

    public static /* synthetic */ RFGRewardUserStatus copy$default(RFGRewardUserStatus rFGRewardUserStatus, RFGValidRequest rFGValidRequest, RFGDidRequest rFGDidRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            rFGValidRequest = rFGRewardUserStatus.validRequest;
        }
        if ((i & 2) != 0) {
            rFGDidRequest = rFGRewardUserStatus.didRequest;
        }
        if ((i & 4) != 0) {
            str = rFGRewardUserStatus.lotteryCountString;
        }
        return rFGRewardUserStatus.copy(rFGValidRequest, rFGDidRequest, str);
    }

    public final RFGValidRequest component1() {
        return this.validRequest;
    }

    public final RFGDidRequest component2() {
        return this.didRequest;
    }

    public final String component3() {
        return this.lotteryCountString;
    }

    public final RFGRewardUserStatus copy(RFGValidRequest rFGValidRequest, RFGDidRequest rFGDidRequest, String str) {
        Intrinsics.checkParameterIsNotNull(rFGValidRequest, "validRequest");
        Intrinsics.checkParameterIsNotNull(rFGDidRequest, "didRequest");
        Intrinsics.checkParameterIsNotNull(str, "lotteryCountString");
        return new RFGRewardUserStatus(rFGValidRequest, rFGDidRequest, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGRewardUserStatus)) {
            return false;
        }
        RFGRewardUserStatus rFGRewardUserStatus = (RFGRewardUserStatus) obj;
        return Intrinsics.areEqual((Object) this.validRequest, (Object) rFGRewardUserStatus.validRequest) && Intrinsics.areEqual((Object) this.didRequest, (Object) rFGRewardUserStatus.didRequest) && Intrinsics.areEqual((Object) this.lotteryCountString, (Object) rFGRewardUserStatus.lotteryCountString);
    }

    public final RFGDidRequest getDidRequest() {
        return this.didRequest;
    }

    public final int getLotteryCount() {
        try {
            return Integer.parseInt(this.lotteryCountString);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final String getLotteryCountString() {
        return this.lotteryCountString;
    }

    public final RFGValidRequest getValidRequest() {
        return this.validRequest;
    }

    public int hashCode() {
        RFGValidRequest rFGValidRequest = this.validRequest;
        int i = 0;
        int hashCode = (rFGValidRequest != null ? rFGValidRequest.hashCode() : 0) * 31;
        RFGDidRequest rFGDidRequest = this.didRequest;
        int hashCode2 = (hashCode + (rFGDidRequest != null ? rFGDidRequest.hashCode() : 0)) * 31;
        String str = this.lotteryCountString;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isValidCoupon() {
        return this.validRequest.getBonus_card();
    }

    public final boolean isValidLottery() {
        return this.validRequest.getLottery() || this.didRequest.getLottery();
    }

    public final boolean isValidPrize() {
        return this.validRequest.getExchange() || this.didRequest.getExchange();
    }

    public final boolean isValidTerm() {
        return this.validRequest.getExchange() || this.validRequest.getLottery() || this.validRequest.getBonus_card();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGRewardUserStatus(validRequest=");
        a.append(this.validRequest);
        a.append(", didRequest=");
        a.append(this.didRequest);
        a.append(", lotteryCountString=");
        return C0681a.m324a(a, this.lotteryCountString, ")");
    }
}
