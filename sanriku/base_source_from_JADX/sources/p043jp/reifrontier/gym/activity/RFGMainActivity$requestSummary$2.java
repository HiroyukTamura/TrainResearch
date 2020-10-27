package p043jp.reifrontier.gym.activity;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.domain.api.RFGUserCurrentYearPoint;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "it", "", "", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestSummary$2 */
final class RFGMainActivity$requestSummary$2<T> implements C1741d<Map<String, ? extends RFGH2Client.H2APIResponse>> {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$requestSummary$2(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void accept(Map<String, RFGH2Client.H2APIResponse> map) {
        RFGH2Client.H2APIResponse h2APIResponse = map.get("summary");
        if (h2APIResponse != null) {
            RFGH2Client.H2APIResponse h2APIResponse2 = h2APIResponse;
            RFGH2Client.H2APIResponse h2APIResponse3 = map.get("point");
            if (h2APIResponse3 != null) {
                RFGH2Client.H2APIResponse h2APIResponse4 = h2APIResponse3;
                if (h2APIResponse2.getCode() == 200 && h2APIResponse4.getCode() == 200) {
                    Object data = h2APIResponse2.getData();
                    if (data != null) {
                        List list = (List) data;
                        Object data2 = h2APIResponse4.getData();
                        if (data2 != null) {
                            this.this$0.bindSummary(list, (RFGUserCurrentYearPoint) data2);
                            this.this$0.requestFeedAndChallenge();
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.api.RFGUserCurrentYearPoint");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<jp.reifrontier.gym.domain.api.RFGSummaryHistory>");
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.data.api.RFGH2Client.H2APIResponse");
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.data.api.RFGH2Client.H2APIResponse");
    }
}
