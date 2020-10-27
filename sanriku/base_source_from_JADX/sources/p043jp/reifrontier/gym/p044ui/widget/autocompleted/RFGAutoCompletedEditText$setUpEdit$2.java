package p043jp.reifrontier.gym.p044ui.widget.autocompleted;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedEditText$setUpEdit$2 */
final class RFGAutoCompletedEditText$setUpEdit$2 implements View.OnTouchListener {
    final /* synthetic */ RFGAutoCompletedEditText this$0;

    RFGAutoCompletedEditText$setUpEdit$2(RFGAutoCompletedEditText rFGAutoCompletedEditText) {
        this.this$0 = rFGAutoCompletedEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkExpressionValueIsNotNull(motionEvent, "motionEvent");
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.this$0.showDropDown();
        return false;
    }
}
