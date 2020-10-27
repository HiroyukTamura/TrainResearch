package p043jp.reifrontier.gym.fragment.train;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$setUpScheduleView$1 */
final class RFGScheduleMapFragment$setUpScheduleView$1 implements View.OnTouchListener {
    final /* synthetic */ RFGScheduleMapFragment this$0;

    RFGScheduleMapFragment$setUpScheduleView$1(RFGScheduleMapFragment rFGScheduleMapFragment) {
        this.this$0 = rFGScheduleMapFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        RFGScheduleMapFragment rFGScheduleMapFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(motionEvent, "motionEvent");
        return rFGScheduleMapFragment.onDraggableHandleTouchListener(motionEvent);
    }
}
