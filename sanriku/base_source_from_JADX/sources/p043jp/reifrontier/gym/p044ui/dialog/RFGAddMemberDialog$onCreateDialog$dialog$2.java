package p043jp.reifrontier.gym.p044ui.dialog;

import android.content.DialogInterface;
import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.dialog.RFGAddMemberDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGAddMemberDialog$onCreateDialog$dialog$2 */
final class RFGAddMemberDialog$onCreateDialog$dialog$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ RFGAddMemberDialog this$0;

    RFGAddMemberDialog$onCreateDialog$dialog$2(RFGAddMemberDialog rFGAddMemberDialog) {
        this.this$0 = rFGAddMemberDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RFGAddMemberDialog.AddMemberDialogListener access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p != null) {
            access$getMListener$p.onDismiss(true, "");
        }
    }
}
