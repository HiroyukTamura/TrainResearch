package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaignCoupon;", "", "couponTitle", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "couponImage", "imageSize", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLImageSize;", "couponMessage", "actionTitle", "(Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLImageSize;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;)V", "getActionTitle", "()Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "getCouponImage", "getCouponMessage", "getCouponTitle", "getImageSize", "()Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLImageSize;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdCampaignCoupon */
public final class RFLAdCampaignCoupon {
    @SerializedName("coupon_title")

    /* renamed from: a */
    private final RFLLocalizeData f3437a;
    @SerializedName("coupon_image")

    /* renamed from: b */
    private final RFLLocalizeData f3438b;
    @SerializedName("image_size")

    /* renamed from: c */
    private final RFLImageSize f3439c;
    @SerializedName("coupon_message")

    /* renamed from: d */
    private final RFLLocalizeData f3440d;
    @SerializedName("action_title")

    /* renamed from: e */
    private final RFLLocalizeData f3441e;

    public RFLAdCampaignCoupon(RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, RFLImageSize rFLImageSize, RFLLocalizeData rFLLocalizeData3, RFLLocalizeData rFLLocalizeData4) {
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData, "couponTitle");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData2, "couponImage");
        Intrinsics.checkParameterIsNotNull(rFLImageSize, "imageSize");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData3, "couponMessage");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData4, "actionTitle");
        this.f3437a = rFLLocalizeData;
        this.f3438b = rFLLocalizeData2;
        this.f3439c = rFLImageSize;
        this.f3440d = rFLLocalizeData3;
        this.f3441e = rFLLocalizeData4;
    }

    public static /* synthetic */ RFLAdCampaignCoupon copy$default(RFLAdCampaignCoupon rFLAdCampaignCoupon, RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, RFLImageSize rFLImageSize, RFLLocalizeData rFLLocalizeData3, RFLLocalizeData rFLLocalizeData4, int i, Object obj) {
        if ((i & 1) != 0) {
            rFLLocalizeData = rFLAdCampaignCoupon.f3437a;
        }
        if ((i & 2) != 0) {
            rFLLocalizeData2 = rFLAdCampaignCoupon.f3438b;
        }
        RFLLocalizeData rFLLocalizeData5 = rFLLocalizeData2;
        if ((i & 4) != 0) {
            rFLImageSize = rFLAdCampaignCoupon.f3439c;
        }
        RFLImageSize rFLImageSize2 = rFLImageSize;
        if ((i & 8) != 0) {
            rFLLocalizeData3 = rFLAdCampaignCoupon.f3440d;
        }
        RFLLocalizeData rFLLocalizeData6 = rFLLocalizeData3;
        if ((i & 16) != 0) {
            rFLLocalizeData4 = rFLAdCampaignCoupon.f3441e;
        }
        return rFLAdCampaignCoupon.copy(rFLLocalizeData, rFLLocalizeData5, rFLImageSize2, rFLLocalizeData6, rFLLocalizeData4);
    }

    public final RFLLocalizeData component1() {
        return this.f3437a;
    }

    public final RFLLocalizeData component2() {
        return this.f3438b;
    }

    public final RFLImageSize component3() {
        return this.f3439c;
    }

    public final RFLLocalizeData component4() {
        return this.f3440d;
    }

    public final RFLLocalizeData component5() {
        return this.f3441e;
    }

    public final RFLAdCampaignCoupon copy(RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, RFLImageSize rFLImageSize, RFLLocalizeData rFLLocalizeData3, RFLLocalizeData rFLLocalizeData4) {
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData, "couponTitle");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData2, "couponImage");
        Intrinsics.checkParameterIsNotNull(rFLImageSize, "imageSize");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData3, "couponMessage");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData4, "actionTitle");
        return new RFLAdCampaignCoupon(rFLLocalizeData, rFLLocalizeData2, rFLImageSize, rFLLocalizeData3, rFLLocalizeData4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLAdCampaignCoupon)) {
            return false;
        }
        RFLAdCampaignCoupon rFLAdCampaignCoupon = (RFLAdCampaignCoupon) obj;
        return Intrinsics.areEqual((Object) this.f3437a, (Object) rFLAdCampaignCoupon.f3437a) && Intrinsics.areEqual((Object) this.f3438b, (Object) rFLAdCampaignCoupon.f3438b) && Intrinsics.areEqual((Object) this.f3439c, (Object) rFLAdCampaignCoupon.f3439c) && Intrinsics.areEqual((Object) this.f3440d, (Object) rFLAdCampaignCoupon.f3440d) && Intrinsics.areEqual((Object) this.f3441e, (Object) rFLAdCampaignCoupon.f3441e);
    }

    public final RFLLocalizeData getActionTitle() {
        return this.f3441e;
    }

    public final RFLLocalizeData getCouponImage() {
        return this.f3438b;
    }

    public final RFLLocalizeData getCouponMessage() {
        return this.f3440d;
    }

    public final RFLLocalizeData getCouponTitle() {
        return this.f3437a;
    }

    public final RFLImageSize getImageSize() {
        return this.f3439c;
    }

    public int hashCode() {
        RFLLocalizeData rFLLocalizeData = this.f3437a;
        int i = 0;
        int hashCode = (rFLLocalizeData != null ? rFLLocalizeData.hashCode() : 0) * 31;
        RFLLocalizeData rFLLocalizeData2 = this.f3438b;
        int hashCode2 = (hashCode + (rFLLocalizeData2 != null ? rFLLocalizeData2.hashCode() : 0)) * 31;
        RFLImageSize rFLImageSize = this.f3439c;
        int hashCode3 = (hashCode2 + (rFLImageSize != null ? rFLImageSize.hashCode() : 0)) * 31;
        RFLLocalizeData rFLLocalizeData3 = this.f3440d;
        int hashCode4 = (hashCode3 + (rFLLocalizeData3 != null ? rFLLocalizeData3.hashCode() : 0)) * 31;
        RFLLocalizeData rFLLocalizeData4 = this.f3441e;
        if (rFLLocalizeData4 != null) {
            i = rFLLocalizeData4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLAdCampaignCoupon(couponTitle=");
        a.append(this.f3437a);
        a.append(", couponImage=");
        a.append(this.f3438b);
        a.append(", imageSize=");
        a.append(this.f3439c);
        a.append(", couponMessage=");
        a.append(this.f3440d);
        a.append(", actionTitle=");
        a.append(this.f3441e);
        a.append(")");
        return a.toString();
    }
}
