package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u001aHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012¨\u00068"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGReward;", "", "rewardId", "", "appId", "rewardName", "rewardDetail", "rewardImage", "couponImage", "point", "expireDate", "validFlag", "created_at", "updated_at", "category", "nendo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCategory", "getCouponImage", "getCreated_at", "getExpireDate", "getNendo", "getPoint", "pointValue", "", "getPointValue", "()I", "getRewardDetail", "getRewardId", "rewardIdValue", "getRewardIdValue", "getRewardImage", "getRewardName", "getUpdated_at", "getValidFlag", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGReward */
public final class RFGReward {
    @SerializedName("app_id")
    private final String appId;
    @SerializedName("category")
    private final String category;
    @SerializedName("coupon_image")
    private final String couponImage;
    @SerializedName("created_at")
    private final String created_at;
    @SerializedName("expire_date")
    private final String expireDate;
    @SerializedName("nendo")
    private final String nendo;
    @SerializedName("consumption_points")
    private final String point;
    @SerializedName("reward_detail")
    private final String rewardDetail;
    @SerializedName("id")
    private final String rewardId;
    @SerializedName("reward_image")
    private final String rewardImage;
    @SerializedName("reward_name")
    private final String rewardName;
    @SerializedName("updated_at")
    private final String updated_at;
    @SerializedName("valid_flag")
    private final String validFlag;

    public RFGReward(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        Intrinsics.checkParameterIsNotNull(str, "rewardId");
        Intrinsics.checkParameterIsNotNull(str2, "appId");
        Intrinsics.checkParameterIsNotNull(str3, "rewardName");
        Intrinsics.checkParameterIsNotNull(str4, "rewardDetail");
        Intrinsics.checkParameterIsNotNull(str5, "rewardImage");
        Intrinsics.checkParameterIsNotNull(str6, "couponImage");
        Intrinsics.checkParameterIsNotNull(str7, "point");
        Intrinsics.checkParameterIsNotNull(str8, "expireDate");
        Intrinsics.checkParameterIsNotNull(str9, "validFlag");
        Intrinsics.checkParameterIsNotNull(str10, "created_at");
        Intrinsics.checkParameterIsNotNull(str11, "updated_at");
        Intrinsics.checkParameterIsNotNull(str12, "category");
        Intrinsics.checkParameterIsNotNull(str13, "nendo");
        this.rewardId = str;
        this.appId = str2;
        this.rewardName = str3;
        this.rewardDetail = str4;
        this.rewardImage = str5;
        this.couponImage = str6;
        this.point = str7;
        this.expireDate = str8;
        this.validFlag = str9;
        this.created_at = str10;
        this.updated_at = str11;
        this.category = str12;
        this.nendo = str13;
    }

    public static /* synthetic */ RFGReward copy$default(RFGReward rFGReward, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, Object obj) {
        RFGReward rFGReward2 = rFGReward;
        int i2 = i;
        return rFGReward.copy((i2 & 1) != 0 ? rFGReward2.rewardId : str, (i2 & 2) != 0 ? rFGReward2.appId : str2, (i2 & 4) != 0 ? rFGReward2.rewardName : str3, (i2 & 8) != 0 ? rFGReward2.rewardDetail : str4, (i2 & 16) != 0 ? rFGReward2.rewardImage : str5, (i2 & 32) != 0 ? rFGReward2.couponImage : str6, (i2 & 64) != 0 ? rFGReward2.point : str7, (i2 & 128) != 0 ? rFGReward2.expireDate : str8, (i2 & 256) != 0 ? rFGReward2.validFlag : str9, (i2 & 512) != 0 ? rFGReward2.created_at : str10, (i2 & 1024) != 0 ? rFGReward2.updated_at : str11, (i2 & 2048) != 0 ? rFGReward2.category : str12, (i2 & 4096) != 0 ? rFGReward2.nendo : str13);
    }

    public final String component1() {
        return this.rewardId;
    }

    public final String component10() {
        return this.created_at;
    }

    public final String component11() {
        return this.updated_at;
    }

    public final String component12() {
        return this.category;
    }

    public final String component13() {
        return this.nendo;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.rewardName;
    }

    public final String component4() {
        return this.rewardDetail;
    }

    public final String component5() {
        return this.rewardImage;
    }

    public final String component6() {
        return this.couponImage;
    }

    public final String component7() {
        return this.point;
    }

    public final String component8() {
        return this.expireDate;
    }

    public final String component9() {
        return this.validFlag;
    }

    public final RFGReward copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        String str14 = str;
        Intrinsics.checkParameterIsNotNull(str14, "rewardId");
        String str15 = str2;
        Intrinsics.checkParameterIsNotNull(str15, "appId");
        String str16 = str3;
        Intrinsics.checkParameterIsNotNull(str16, "rewardName");
        String str17 = str4;
        Intrinsics.checkParameterIsNotNull(str17, "rewardDetail");
        String str18 = str5;
        Intrinsics.checkParameterIsNotNull(str18, "rewardImage");
        String str19 = str6;
        Intrinsics.checkParameterIsNotNull(str19, "couponImage");
        String str20 = str7;
        Intrinsics.checkParameterIsNotNull(str20, "point");
        String str21 = str8;
        Intrinsics.checkParameterIsNotNull(str21, "expireDate");
        String str22 = str9;
        Intrinsics.checkParameterIsNotNull(str22, "validFlag");
        String str23 = str10;
        Intrinsics.checkParameterIsNotNull(str23, "created_at");
        String str24 = str11;
        Intrinsics.checkParameterIsNotNull(str24, "updated_at");
        String str25 = str12;
        Intrinsics.checkParameterIsNotNull(str25, "category");
        String str26 = str13;
        Intrinsics.checkParameterIsNotNull(str26, "nendo");
        return new RFGReward(str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGReward)) {
            return false;
        }
        RFGReward rFGReward = (RFGReward) obj;
        return Intrinsics.areEqual((Object) this.rewardId, (Object) rFGReward.rewardId) && Intrinsics.areEqual((Object) this.appId, (Object) rFGReward.appId) && Intrinsics.areEqual((Object) this.rewardName, (Object) rFGReward.rewardName) && Intrinsics.areEqual((Object) this.rewardDetail, (Object) rFGReward.rewardDetail) && Intrinsics.areEqual((Object) this.rewardImage, (Object) rFGReward.rewardImage) && Intrinsics.areEqual((Object) this.couponImage, (Object) rFGReward.couponImage) && Intrinsics.areEqual((Object) this.point, (Object) rFGReward.point) && Intrinsics.areEqual((Object) this.expireDate, (Object) rFGReward.expireDate) && Intrinsics.areEqual((Object) this.validFlag, (Object) rFGReward.validFlag) && Intrinsics.areEqual((Object) this.created_at, (Object) rFGReward.created_at) && Intrinsics.areEqual((Object) this.updated_at, (Object) rFGReward.updated_at) && Intrinsics.areEqual((Object) this.category, (Object) rFGReward.category) && Intrinsics.areEqual((Object) this.nendo, (Object) rFGReward.nendo);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getCouponImage() {
        return this.couponImage;
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final String getExpireDate() {
        return this.expireDate;
    }

    public final String getNendo() {
        return this.nendo;
    }

    public final String getPoint() {
        return this.point;
    }

    public final int getPointValue() {
        try {
            int parseInt = Integer.parseInt(this.point);
            if (!Intrinsics.areEqual((Object) this.category, (Object) "exchange") || parseInt != 1) {
                return parseInt;
            }
            return 0;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final String getRewardDetail() {
        return this.rewardDetail;
    }

    public final String getRewardId() {
        return this.rewardId;
    }

    public final int getRewardIdValue() {
        try {
            return Integer.parseInt(this.rewardId);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final String getRewardImage() {
        return this.rewardImage;
    }

    public final String getRewardName() {
        return this.rewardName;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public final String getValidFlag() {
        return this.validFlag;
    }

    public int hashCode() {
        String str = this.rewardId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rewardName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.rewardDetail;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.rewardImage;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.couponImage;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.point;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.expireDate;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.validFlag;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.created_at;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.updated_at;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.category;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.nendo;
        if (str13 != null) {
            i = str13.hashCode();
        }
        return hashCode12 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGReward(rewardId=");
        a.append(this.rewardId);
        a.append(", appId=");
        a.append(this.appId);
        a.append(", rewardName=");
        a.append(this.rewardName);
        a.append(", rewardDetail=");
        a.append(this.rewardDetail);
        a.append(", rewardImage=");
        a.append(this.rewardImage);
        a.append(", couponImage=");
        a.append(this.couponImage);
        a.append(", point=");
        a.append(this.point);
        a.append(", expireDate=");
        a.append(this.expireDate);
        a.append(", validFlag=");
        a.append(this.validFlag);
        a.append(", created_at=");
        a.append(this.created_at);
        a.append(", updated_at=");
        a.append(this.updated_at);
        a.append(", category=");
        a.append(this.category);
        a.append(", nendo=");
        return C0681a.m324a(a, this.nendo, ")");
    }
}
