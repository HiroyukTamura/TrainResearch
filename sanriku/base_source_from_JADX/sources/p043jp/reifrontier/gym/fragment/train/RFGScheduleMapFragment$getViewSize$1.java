package p043jp.reifrontier.gym.fragment.train;

import android.content.Context;
import android.graphics.Point;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo21739d2 = {"jp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$getViewSize$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$getViewSize$1 */
public final class RFGScheduleMapFragment$getViewSize$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ RFGScheduleMapFragment this$0;

    RFGScheduleMapFragment$getViewSize$1(RFGScheduleMapFragment rFGScheduleMapFragment) {
        this.this$0 = rFGScheduleMapFragment;
    }

    public void onGlobalLayout() {
        Pair pair;
        RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewBase);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "viewBase");
        relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        RFGScheduleMapFragment rFGScheduleMapFragment = this.this$0;
        RelativeLayout relativeLayout2 = (RelativeLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewBase);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "viewBase");
        int width = relativeLayout2.getWidth();
        RelativeLayout relativeLayout3 = (RelativeLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewBase);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "viewBase");
        rFGScheduleMapFragment.viewSize = new Point(width, relativeLayout3.getHeight());
        RFGScheduleMapFragment rFGScheduleMapFragment2 = this.this$0;
        Context context = rFGScheduleMapFragment2.getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.draggable_handle_area_height);
            int dimensionPixelSize2 = (context.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin) * 2) + context.getResources().getDimensionPixelSize(R.dimen.schedule_search_height);
            RelativeLayout relativeLayout4 = (RelativeLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewBase);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "viewBase");
            pair = new Pair(Integer.valueOf(dimensionPixelSize), Integer.valueOf(relativeLayout4.getHeight() - dimensionPixelSize2));
        } else {
            RelativeLayout relativeLayout5 = (RelativeLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewBase);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "viewBase");
            Integer valueOf = Integer.valueOf(relativeLayout5.getHeight());
            RelativeLayout relativeLayout6 = (RelativeLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.viewBase);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "viewBase");
            pair = new Pair(valueOf, Integer.valueOf(relativeLayout6.getHeight()));
        }
        rFGScheduleMapFragment2.scheduleViewDraggableMinMaxHeight = pair;
    }
}
