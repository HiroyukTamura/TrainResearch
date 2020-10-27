package p043jp.reifrontier.gym.p044ui.dialog;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.p044ui.dialog.RFGBodyDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGBodyDialog$setupDialog$3 */
final class RFGBodyDialog$setupDialog$3 implements View.OnClickListener {
    final /* synthetic */ String $unit;
    final /* synthetic */ RFGBodyDialog this$0;

    RFGBodyDialog$setupDialog$3(RFGBodyDialog rFGBodyDialog, String str) {
        this.this$0 = rFGBodyDialog;
        this.$unit = str;
    }

    public final void onClick(View view) {
        this.this$0.dismiss();
        String a = C0681a.m328a(new Object[]{Integer.valueOf(this.this$0.currentBody), Integer.valueOf(this.this$0.currentDeci), this.$unit}, 3, "%s.%s%s", "java.lang.String.format(this, *args)");
        RFGBodyDialog.PickerDialogListener access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p == null) {
            Intrinsics.throwNpe();
        }
        access$getMListener$p.onSelect(this.this$0.pickerType, a);
    }
}
