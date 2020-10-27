package p043jp.reifrontier.gym.fragment;

import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.adapter.RFGFeedAdapter;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "run"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGFeedFragment$notifyDataSet$1 */
final class RFGFeedFragment$notifyDataSet$1 implements Runnable {
    final /* synthetic */ RFGFeedFragment this$0;

    RFGFeedFragment$notifyDataSet$1(RFGFeedFragment rFGFeedFragment) {
        this.this$0 = rFGFeedFragment;
    }

    public final void run() {
        RFGFeedAdapter access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p != null) {
            access$getMAdapter$p.notifyDataSetChanged();
        }
    }
}
