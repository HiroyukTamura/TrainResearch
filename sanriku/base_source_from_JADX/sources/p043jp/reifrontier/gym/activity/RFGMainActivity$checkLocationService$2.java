package p043jp.reifrontier.gym.activity;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.dialog.RFGErrorDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGMainActivity$checkLocationService$2", "Ljp/reifrontier/gym/ui/dialog/RFGErrorDialog$ErrorDialogListener;", "onDismiss", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$checkLocationService$2 */
public final class RFGMainActivity$checkLocationService$2 implements RFGErrorDialog.ErrorDialogListener {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$checkLocationService$2(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public void onDismiss() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.this$0.getPackageName(), (String) null));
        this.this$0.startActivity(intent);
    }
}
