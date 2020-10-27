package p043jp.reifrontier.gym.p044ui.dialog;

import android.widget.NumberPicker;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/NumberPicker;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "new", "onValueChange"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.dialog.RFGDateDialog$setupDialog$3 */
final class RFGDateDialog$setupDialog$3 implements NumberPicker.OnValueChangeListener {
    final /* synthetic */ NumberPicker $dayPicker;
    final /* synthetic */ RFGDateDialog this$0;

    RFGDateDialog$setupDialog$3(RFGDateDialog rFGDateDialog, NumberPicker numberPicker) {
        this.this$0 = rFGDateDialog;
        this.$dayPicker = numberPicker;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        this.this$0.currentYear = i2;
        Calendar instance = Calendar.getInstance();
        instance.set(1, this.this$0.currentYear);
        instance.set(2, this.this$0.currentMonth);
        instance.set(5, 1);
        instance.add(5, -1);
        int i3 = instance.get(5);
        NumberPicker numberPicker2 = this.$dayPicker;
        Intrinsics.checkExpressionValueIsNotNull(numberPicker2, "dayPicker");
        numberPicker2.setMaxValue(i3);
        if (this.this$0.currentDay > i3) {
            this.this$0.currentDay = i3;
        }
    }
}
