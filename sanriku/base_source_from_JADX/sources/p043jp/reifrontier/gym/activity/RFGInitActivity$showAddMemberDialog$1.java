package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.p044ui.dialog.RFGAddMemberDialog;
import p043jp.reifrontier.gym.util.GymUtils;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGInitActivity$showAddMemberDialog$1", "Ljp/reifrontier/gym/ui/dialog/RFGAddMemberDialog$AddMemberDialogListener;", "onDismiss", "", "cancel", "", "inputText", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$showAddMemberDialog$1 */
public final class RFGInitActivity$showAddMemberDialog$1 implements RFGAddMemberDialog.AddMemberDialogListener {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$showAddMemberDialog$1(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public void onDismiss(boolean z, String str) {
        Intrinsics.checkParameterIsNotNull(str, "inputText");
        if (!z) {
            if (!GymUtils.INSTANCE.validateEmail(str)) {
                this.this$0.alertWith("正しい形式のメールアドレスを入力してください");
                return;
            }
            this.this$0.closeKeyboard();
            this.this$0.requestResetPassword(str);
        }
    }
}
