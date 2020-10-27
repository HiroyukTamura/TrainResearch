package p043jp.reifrontier.gym.fragment.train;

import android.view.View;
import kotlin.Metadata;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.train.spot.RFGContentButton;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$addNormalButton$1 */
final class RFGSpotDetailFragment$addNormalButton$1 implements View.OnClickListener {
    final /* synthetic */ RFGContentButton $button;
    final /* synthetic */ int $spotId;
    final /* synthetic */ RFGSpotDetailFragment this$0;

    RFGSpotDetailFragment$addNormalButton$1(RFGSpotDetailFragment rFGSpotDetailFragment, RFGContentButton rFGContentButton, int i) {
        this.this$0 = rFGSpotDetailFragment;
        this.$button = rFGContentButton;
        this.$spotId = i;
    }

    public final void onClick(View view) {
        String value = this.$button.getValue();
        if (value != null) {
            RFGAnalyticsManager rFGAnalyticsManager = RFGAnalyticsManager.INSTANCE;
            rFGAnalyticsManager.sendEvent("310", "310c", this.$spotId + '_' + this.$button.getAnalytics());
            this.this$0.openLink(value);
        }
    }
}
