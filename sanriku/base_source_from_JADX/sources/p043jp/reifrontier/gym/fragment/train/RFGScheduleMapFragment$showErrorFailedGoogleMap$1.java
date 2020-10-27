package p043jp.reifrontier.gym.fragment.train;

import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo21739d2 = {"jp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$showErrorFailedGoogleMap$1", "Ljp/reifrontier/gym/ui/dialog/RFGErrorDialog$ErrorDialogListener;", "onDismiss", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$showErrorFailedGoogleMap$1 */
public final class RFGScheduleMapFragment$showErrorFailedGoogleMap$1 implements RFGErrorDialog.ErrorDialogListener {
    final /* synthetic */ RFGScheduleMapFragment this$0;

    RFGScheduleMapFragment$showErrorFailedGoogleMap$1(RFGScheduleMapFragment rFGScheduleMapFragment) {
        this.this$0 = rFGScheduleMapFragment;
    }

    public void onDismiss() {
        this.this$0.terminate();
    }
}
