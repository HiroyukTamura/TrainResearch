package p043jp.reifrontier.gym.p044ui.dialog;

import android.widget.NumberPicker;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/NumberPicker;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "new", "onValueChange"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGBodyDialog$setupDialog$4 */
final class RFGBodyDialog$setupDialog$4 implements NumberPicker.OnValueChangeListener {
    final /* synthetic */ RFGBodyDialog this$0;

    RFGBodyDialog$setupDialog$4(RFGBodyDialog rFGBodyDialog) {
        this.this$0 = rFGBodyDialog;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        this.this$0.currentBody = i2;
    }
}
