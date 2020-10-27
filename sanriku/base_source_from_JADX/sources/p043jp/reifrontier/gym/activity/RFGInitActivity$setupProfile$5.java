package p043jp.reifrontier.gym.activity;

import android.view.View;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.p044ui.dialog.RFGDateDialog;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$setupProfile$5 */
final class RFGInitActivity$setupProfile$5 implements View.OnClickListener {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$setupProfile$5(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final void onClick(View view) {
        this.this$0.closeKeyboard();
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(this.this$0.updateBirthday);
        RFGDateDialog.Companion.newInstance(instance.get(1), instance.get(2), instance.get(5)).show(this.this$0.getSupportFragmentManager(), RFGDateDialog.Companion.getTAG());
    }
}
