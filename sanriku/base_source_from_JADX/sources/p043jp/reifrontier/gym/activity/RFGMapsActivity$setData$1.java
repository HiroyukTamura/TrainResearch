package p043jp.reifrontier.gym.activity;

import android.view.View;
import kotlin.Metadata;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.p044ui.dialog.RFGEditActDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMapsActivity$setData$1 */
final class RFGMapsActivity$setData$1 implements View.OnClickListener {
    final /* synthetic */ RFGMapsActivity this$0;

    RFGMapsActivity$setData$1(RFGMapsActivity rFGMapsActivity) {
        this.this$0 = rFGMapsActivity;
    }

    public final void onClick(View view) {
        RFGAnalyticsManager.INSTANCE.sendEvent("111", "111a", RFGMapsActivity.access$getMAdapterActivity$p(this.this$0).analyticsTime());
        RFGEditActDialog newInstance = RFGEditActDialog.Companion.newInstance(RFGMapsActivity.access$getCurrentType$p(this.this$0));
        newInstance.setListener(this.this$0);
        newInstance.show(this.this$0.getSupportFragmentManager(), RFGEditActDialog.Companion.getTAG());
    }
}
