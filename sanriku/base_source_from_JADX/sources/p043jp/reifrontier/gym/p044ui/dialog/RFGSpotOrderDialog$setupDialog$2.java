package p043jp.reifrontier.gym.p044ui.dialog;

import android.view.View;
import kotlin.Metadata;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGSpotOrderType;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGSpotOrderDialog$setupDialog$2 */
final class RFGSpotOrderDialog$setupDialog$2 implements View.OnClickListener {
    final /* synthetic */ RFGSpotOrderDialog this$0;

    RFGSpotOrderDialog$setupDialog$2(RFGSpotOrderDialog rFGSpotOrderDialog) {
        this.this$0 = rFGSpotOrderDialog;
    }

    public final void onClick(View view) {
        C1126c.m1638c().mo21903a((Object) new RFGSpotListFragment.OnSelectedOrder(false, RFGSpotOrderType.NEAREST));
        this.this$0.dismiss();
    }
}
