package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaignLink;", "", "clkLink", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "cvLink", "(Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;)V", "getClkLink", "()Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "getCvLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdCampaignLink */
public final class RFLAdCampaignLink {
    @SerializedName("clk_link")

    /* renamed from: a */
    private final RFLLocalizeData f3442a;
    @SerializedName("cv_link")

    /* renamed from: b */
    private final RFLLocalizeData f3443b;

    public RFLAdCampaignLink(RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2) {
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData, "clkLink");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData2, "cvLink");
        this.f3442a = rFLLocalizeData;
        this.f3443b = rFLLocalizeData2;
    }

    public static /* synthetic */ RFLAdCampaignLink copy$default(RFLAdCampaignLink rFLAdCampaignLink, RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, int i, Object obj) {
        if ((i & 1) != 0) {
            rFLLocalizeData = rFLAdCampaignLink.f3442a;
        }
        if ((i & 2) != 0) {
            rFLLocalizeData2 = rFLAdCampaignLink.f3443b;
        }
        return rFLAdCampaignLink.copy(rFLLocalizeData, rFLLocalizeData2);
    }

    public final RFLLocalizeData component1() {
        return this.f3442a;
    }

    public final RFLLocalizeData component2() {
        return this.f3443b;
    }

    public final RFLAdCampaignLink copy(RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2) {
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData, "clkLink");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData2, "cvLink");
        return new RFLAdCampaignLink(rFLLocalizeData, rFLLocalizeData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLAdCampaignLink)) {
            return false;
        }
        RFLAdCampaignLink rFLAdCampaignLink = (RFLAdCampaignLink) obj;
        return Intrinsics.areEqual((Object) this.f3442a, (Object) rFLAdCampaignLink.f3442a) && Intrinsics.areEqual((Object) this.f3443b, (Object) rFLAdCampaignLink.f3443b);
    }

    public final RFLLocalizeData getClkLink() {
        return this.f3442a;
    }

    public final RFLLocalizeData getCvLink() {
        return this.f3443b;
    }

    public int hashCode() {
        RFLLocalizeData rFLLocalizeData = this.f3442a;
        int i = 0;
        int hashCode = (rFLLocalizeData != null ? rFLLocalizeData.hashCode() : 0) * 31;
        RFLLocalizeData rFLLocalizeData2 = this.f3443b;
        if (rFLLocalizeData2 != null) {
            i = rFLLocalizeData2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLAdCampaignLink(clkLink=");
        a.append(this.f3442a);
        a.append(", cvLink=");
        a.append(this.f3443b);
        a.append(")");
        return a.toString();
    }
}
