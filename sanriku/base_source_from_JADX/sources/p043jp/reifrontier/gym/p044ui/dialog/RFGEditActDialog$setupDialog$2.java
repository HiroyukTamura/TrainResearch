package p043jp.reifrontier.gym.p044ui.dialog;

import android.view.View;
import kotlin.Metadata;
import p043jp.reifrontier.gym.p044ui.dialog.RFGEditActDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGEditActDialog$setupDialog$2 */
final class RFGEditActDialog$setupDialog$2 implements View.OnClickListener {
    final /* synthetic */ RFGEditActDialog this$0;

    RFGEditActDialog$setupDialog$2(RFGEditActDialog rFGEditActDialog) {
        this.this$0 = rFGEditActDialog;
    }

    public final void onClick(View view) {
        this.this$0.dismiss();
        RFGEditActDialog.EditActDialogListener access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p != null) {
            access$getMListener$p.finishEdit("wlk");
        }
    }
}
