package p043jp.reifrontier.gym.activity;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.domain.api.RFGSummaryHistory;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestActivitySummaries$1 */
final class RFGMainActivity$requestActivitySummaries$1<T> implements C1741d<RFGH2Client.H2APIResponse> {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$requestActivitySummaries$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void accept(RFGH2Client.H2APIResponse h2APIResponse) {
        if (h2APIResponse.getCode() == 200) {
            ArrayList arrayList = new ArrayList();
            List<RFGSummaryHistory> list = (List) h2APIResponse.getData();
            if (list != null) {
                for (RFGSummaryHistory rFGSummaryHistory : list) {
                    if (!Intrinsics.areEqual((Object) rFGSummaryHistory.getType(), (Object) "total")) {
                        arrayList.add(rFGSummaryHistory);
                    }
                }
            }
            this.this$0.bindActivitySingle((RFGSummaryHistory) CollectionsKt___CollectionsKt.last(CollectionsKt___CollectionsKt.sortedWith(arrayList, RFGMainActivity$requestActivitySummaries$1$sortSum$1.INSTANCE)));
        }
    }
}
