package p043jp.reifrontier.gym.activity;

import android.content.Intent;
import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.dialog.RFGConfirmDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGSettingActivity$confirmRemoveData$1$1", "Ljp/reifrontier/gym/ui/dialog/RFGConfirmDialog$ConfirmDialogListener;", "onDismiss", "", "cancel", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$confirmRemoveData$$inlined$apply$lambda$1 */
public final class RFGSettingActivity$confirmRemoveData$$inlined$apply$lambda$1 implements RFGConfirmDialog.ConfirmDialogListener {
    final /* synthetic */ RFGSettingActivity this$0;

    RFGSettingActivity$confirmRemoveData$$inlined$apply$lambda$1(RFGSettingActivity rFGSettingActivity) {
        this.this$0 = rFGSettingActivity;
    }

    public void onDismiss(boolean z) {
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra(RFGSettingActivity.RESULT_KEY_REQUEST_DELETE_DATA, true);
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
        }
    }
}
