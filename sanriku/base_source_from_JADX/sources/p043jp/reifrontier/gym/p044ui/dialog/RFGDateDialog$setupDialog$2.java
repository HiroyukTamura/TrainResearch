package p043jp.reifrontier.gym.p044ui.dialog;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.p044ui.dialog.RFGDateDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGDateDialog$setupDialog$2 */
final class RFGDateDialog$setupDialog$2 implements View.OnClickListener {
    final /* synthetic */ RFGDateDialog this$0;

    RFGDateDialog$setupDialog$2(RFGDateDialog rFGDateDialog) {
        this.this$0 = rFGDateDialog;
    }

    public final void onClick(View view) {
        this.this$0.dismiss();
        RFGDateDialog.DateDialogListener access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p == null) {
            Intrinsics.throwNpe();
        }
        access$getMListener$p.onDateSelect(this.this$0.currentYear, this.this$0.currentMonth - 1, this.this$0.currentDay);
    }
}
