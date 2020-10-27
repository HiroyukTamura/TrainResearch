package p043jp.reifrontier.silentlogsdkandroid;

import java.util.List;
import kotlin.Metadata;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdCampaign;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResType;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener;", "", "OnCompletedGetCampaign", "OnCompletedResponseAd", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogAdListener */
public interface SilentLogAdListener {

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener$OnCompletedGetCampaign;", "", "onResult", "", "success", "", "campaignList", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaign;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogAdListener$OnCompletedGetCampaign */
    public interface OnCompletedGetCampaign {
        void onResult(boolean z, List<RFLAdCampaign> list);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener$OnCompletedResponseAd;", "", "onResult", "", "success", "", "adResType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "campId", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogAdListener$OnCompletedResponseAd */
    public interface OnCompletedResponseAd {
        void onResult(boolean z, RFLAdResType rFLAdResType, int i);
    }
}
