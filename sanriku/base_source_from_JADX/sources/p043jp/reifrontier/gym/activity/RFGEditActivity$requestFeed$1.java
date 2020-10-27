package p043jp.reifrontier.gym.activity;

import java.util.List;
import kotlin.Metadata;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.domain.api.RFGFeed;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGEditActivity$requestFeed$1 */
final class RFGEditActivity$requestFeed$1<T> implements C1741d<RFGH2Client.H2APIResponse> {
    final /* synthetic */ RFGEditActivity this$0;

    RFGEditActivity$requestFeed$1(RFGEditActivity rFGEditActivity) {
        this.this$0 = rFGEditActivity;
    }

    public final void accept(RFGH2Client.H2APIResponse h2APIResponse) {
        this.this$0.stopLoading();
        if (h2APIResponse.getCode() == 200 || h2APIResponse.getCode() == 204) {
            List<RFGFeed> list = (List) h2APIResponse.getData();
            if (list != null) {
                for (RFGFeed rFGFeed : list) {
                    if (rFGFeed.isWeight()) {
                        this.this$0.weightFeedId = rFGFeed.getFeedId();
                    }
                }
                return;
            }
            return;
        }
        this.this$0.requestError();
    }
}
