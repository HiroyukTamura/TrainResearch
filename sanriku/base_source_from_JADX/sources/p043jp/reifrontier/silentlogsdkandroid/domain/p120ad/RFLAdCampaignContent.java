package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaignContent;", "", "title", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "bannerImage", "imageSize", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLImageSize;", "message", "(Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLImageSize;Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;)V", "getBannerImage", "()Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "getImageSize", "()Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLImageSize;", "getMessage", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdCampaignContent */
public final class RFLAdCampaignContent {
    @SerializedName("title")

    /* renamed from: a */
    private final RFLLocalizeData f3433a;
    @SerializedName("banner_image")

    /* renamed from: b */
    private final RFLLocalizeData f3434b;
    @SerializedName("image_size")

    /* renamed from: c */
    private final RFLImageSize f3435c;
    @SerializedName("message")

    /* renamed from: d */
    private final RFLLocalizeData f3436d;

    public RFLAdCampaignContent(RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, RFLImageSize rFLImageSize, RFLLocalizeData rFLLocalizeData3) {
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData, "title");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData2, "bannerImage");
        Intrinsics.checkParameterIsNotNull(rFLImageSize, "imageSize");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData3, "message");
        this.f3433a = rFLLocalizeData;
        this.f3434b = rFLLocalizeData2;
        this.f3435c = rFLImageSize;
        this.f3436d = rFLLocalizeData3;
    }

    public static /* synthetic */ RFLAdCampaignContent copy$default(RFLAdCampaignContent rFLAdCampaignContent, RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, RFLImageSize rFLImageSize, RFLLocalizeData rFLLocalizeData3, int i, Object obj) {
        if ((i & 1) != 0) {
            rFLLocalizeData = rFLAdCampaignContent.f3433a;
        }
        if ((i & 2) != 0) {
            rFLLocalizeData2 = rFLAdCampaignContent.f3434b;
        }
        if ((i & 4) != 0) {
            rFLImageSize = rFLAdCampaignContent.f3435c;
        }
        if ((i & 8) != 0) {
            rFLLocalizeData3 = rFLAdCampaignContent.f3436d;
        }
        return rFLAdCampaignContent.copy(rFLLocalizeData, rFLLocalizeData2, rFLImageSize, rFLLocalizeData3);
    }

    public final RFLLocalizeData component1() {
        return this.f3433a;
    }

    public final RFLLocalizeData component2() {
        return this.f3434b;
    }

    public final RFLImageSize component3() {
        return this.f3435c;
    }

    public final RFLLocalizeData component4() {
        return this.f3436d;
    }

    public final RFLAdCampaignContent copy(RFLLocalizeData rFLLocalizeData, RFLLocalizeData rFLLocalizeData2, RFLImageSize rFLImageSize, RFLLocalizeData rFLLocalizeData3) {
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData, "title");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData2, "bannerImage");
        Intrinsics.checkParameterIsNotNull(rFLImageSize, "imageSize");
        Intrinsics.checkParameterIsNotNull(rFLLocalizeData3, "message");
        return new RFLAdCampaignContent(rFLLocalizeData, rFLLocalizeData2, rFLImageSize, rFLLocalizeData3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLAdCampaignContent)) {
            return false;
        }
        RFLAdCampaignContent rFLAdCampaignContent = (RFLAdCampaignContent) obj;
        return Intrinsics.areEqual((Object) this.f3433a, (Object) rFLAdCampaignContent.f3433a) && Intrinsics.areEqual((Object) this.f3434b, (Object) rFLAdCampaignContent.f3434b) && Intrinsics.areEqual((Object) this.f3435c, (Object) rFLAdCampaignContent.f3435c) && Intrinsics.areEqual((Object) this.f3436d, (Object) rFLAdCampaignContent.f3436d);
    }

    public final RFLLocalizeData getBannerImage() {
        return this.f3434b;
    }

    public final RFLImageSize getImageSize() {
        return this.f3435c;
    }

    public final RFLLocalizeData getMessage() {
        return this.f3436d;
    }

    public final RFLLocalizeData getTitle() {
        return this.f3433a;
    }

    public int hashCode() {
        RFLLocalizeData rFLLocalizeData = this.f3433a;
        int i = 0;
        int hashCode = (rFLLocalizeData != null ? rFLLocalizeData.hashCode() : 0) * 31;
        RFLLocalizeData rFLLocalizeData2 = this.f3434b;
        int hashCode2 = (hashCode + (rFLLocalizeData2 != null ? rFLLocalizeData2.hashCode() : 0)) * 31;
        RFLImageSize rFLImageSize = this.f3435c;
        int hashCode3 = (hashCode2 + (rFLImageSize != null ? rFLImageSize.hashCode() : 0)) * 31;
        RFLLocalizeData rFLLocalizeData3 = this.f3436d;
        if (rFLLocalizeData3 != null) {
            i = rFLLocalizeData3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLAdCampaignContent(title=");
        a.append(this.f3433a);
        a.append(", bannerImage=");
        a.append(this.f3434b);
        a.append(", imageSize=");
        a.append(this.f3435c);
        a.append(", message=");
        a.append(this.f3436d);
        a.append(")");
        return a.toString();
    }
}
