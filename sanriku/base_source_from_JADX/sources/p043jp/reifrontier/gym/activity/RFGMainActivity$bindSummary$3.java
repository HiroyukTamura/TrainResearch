package p043jp.reifrontier.gym.activity;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.gym.fragment.RFGFeedFragment;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$bindSummary$3 */
final class RFGMainActivity$bindSummary$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RFGFeedFragment $feedF;
    final /* synthetic */ List $summaries;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGMainActivity$bindSummary$3(RFGFeedFragment rFGFeedFragment, List list) {
        super(0);
        this.$feedF = rFGFeedFragment;
        this.$summaries = list;
    }

    public final void invoke() {
        this.$feedF.clear();
        this.$feedF.addSummaries(this.$summaries);
    }
}
